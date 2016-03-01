/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.content.targeting.util;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Indexer.class)
public class ReportInstanceIndexer extends BaseIndexer<ReportInstance> {

	public static final String[] CLASS_NAMES = {ReportInstance.class.getName()};

	public static final String PORTLET_ID = PortletKeys.CT_CORE;

	public ReportInstanceIndexer() {
		setFilterSearch(true);
		setPermissionAware(false);
	}

	@Override
	public String getClassName() {
		return ReportInstance.class.getName();
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, String entryClassName,
			long entryClassPK, String actionId)
		throws Exception {

		return true;
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		addSearchLocalizedTerm(
			searchQuery, searchContext, Field.DESCRIPTION, true);
		addSearchLocalizedTerm(searchQuery, searchContext, Field.NAME, true);
	}

	@Override
	protected void doDelete(ReportInstance reportInstance) throws Exception {
		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, reportInstance.getReportInstanceId());

		SearchEngineUtil.deleteDocument(
			getSearchEngineId(), reportInstance.getCompanyId(),
			document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(ReportInstance reportInstance)
		throws Exception {

		if (_log.isDebugEnabled()) {
			_log.debug("Indexing reportInstance " + reportInstance);
		}

		Document document = getBaseModelDocument(PORTLET_ID, reportInstance);

		document.addLocalizedText(
			Field.DESCRIPTION, reportInstance.getDescriptionMap());
		document.addLocalizedText(Field.NAME, reportInstance.getNameMap());

		document.addKeyword("className", reportInstance.getClassName());
		document.addKeyword("classPK", reportInstance.getClassPK());
		document.addKeyword(
			"reportInstanceId", reportInstance.getReportInstanceId());

		if (_log.isDebugEnabled()) {
			_log.debug(
				"ReportInstance " + reportInstance + " indexed successfully");
		}

		return document;
	}

	@Override
	protected Summary doGetSummary(
			Document document, Locale locale, String snippet,
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws Exception {

		return null;
	}

	@Override
	protected void doReindex(ReportInstance reportInstance) throws Exception {
		Document document = getDocument(reportInstance);

		if (document != null) {
			SearchEngineUtil.updateDocument(
				getSearchEngineId(), reportInstance.getCompanyId(), document);
		}
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		ReportInstance reportInstance =
			_reportInstanceLocalService.getReportInstance(classPK);

		doReindex(reportInstance);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexReportInstances(
			companyId, _campaignLocalService, _userSegmentLocalService);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexReportInstances(
			final long companyId,
			final CampaignLocalService campaignLocalService,
			final UserSegmentLocalService userSegmentLocalService)
		throws PortalException {

		final IndexableActionableDynamicQuery actionableDynamicQuery =
			_reportInstanceLocalService.getIndexableActionableDynamicQuery();

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ReportInstance>() {

				@Override
				public void performAction(ReportInstance reportInstance) {
					if (reportInstance.getGroupId() == 0) {
						try {
							String className = reportInstance.getClassName();

							if (className.equals(Campaign.class.getName())) {
								Campaign campaign =
									campaignLocalService.getCampaign(
										reportInstance.getClassPK());

								reportInstance.setGroupId(
									campaign.getGroupId());
							}
							else {
								UserSegment userSegment =
									userSegmentLocalService.getUserSegment(
										reportInstance.getClassPK());

								reportInstance.setGroupId(
									userSegment.getGroupId());
							}

							reportInstance.setCreateDate(new Date());
						}
						catch (Exception e) {
							_log.error(e, e);
						}
					}

					try {
						Document document = getDocument(reportInstance);

						if (document != null) {
							actionableDynamicQuery.addDocuments(document);
						}
					}
					catch (PortalException pe) {
						if (_log.isWarnEnabled()) {
							_log.warn(
								"Unable to index report instance: " +
									reportInstance.getReportInstanceId(),
								pe);
						}
					}
				}

			});

		actionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		actionableDynamicQuery.performActions();
	}

	@Reference(unbind = "-")
	protected void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {

		_campaignLocalService = campaignLocalService;
	}

	@Reference(unbind = "-")
	protected void setReportInstanceLocalService(
		ReportInstanceLocalService reportInstanceLocalService) {

		_reportInstanceLocalService = reportInstanceLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ReportInstanceIndexer.class);

	private CampaignLocalService _campaignLocalService;
	private ReportInstanceLocalService _reportInstanceLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}