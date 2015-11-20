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

package com.liferay.consumer.manager.util;

import com.liferay.consumer.manager.model.ConsumerReportInstance;
import com.liferay.consumer.manager.service.ConsumerReportInstanceLocalServiceUtil;
import com.liferay.consumer.manager.service.persistence.ConsumerReportInstanceActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.permission.PermissionChecker;

import java.util.Locale;

import javax.portlet.PortletURL;

/**
 * @author Eudaldo Alonso
 */
public class ConsumerReportInstanceIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {
		ConsumerReportInstance.class.getName()};

	public static final String PORTLET_ID = PortletKeys.CM_ADMIN;

	public ConsumerReportInstanceIndexer() {
		setFilterSearch(true);
		setPermissionAware(false);
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
	protected void doDelete(Object obj) throws Exception {
		ConsumerReportInstance reportInstance = (ConsumerReportInstance)obj;

		Document document = new DocumentImpl();

		document.addUID(
			PORTLET_ID, reportInstance.getConsumerReportInstanceId());

		SearchEngineUtil.deleteDocument(
			getSearchEngineId(), reportInstance.getCompanyId(),
			document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		ConsumerReportInstance reportInstance = (ConsumerReportInstance)obj;

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Indexing consumerExtensionReportInstance " + reportInstance);
		}

		Document document = getBaseModelDocument(PORTLET_ID, reportInstance);

		document.addLocalizedText(
			Field.DESCRIPTION, reportInstance.getDescriptionMap());
		document.addLocalizedText(Field.NAME, reportInstance.getNameMap());

		document.addKeyword("consumerId", reportInstance.getConsumerId());
		document.addKeyword(
			"consumerExtensionReportInstanceId",
			reportInstance.getConsumerReportInstanceId());
		document.addKeyword(
			"reportCategoryKey", reportInstance.getReportCategoryKey());

		if (_log.isDebugEnabled()) {
			_log.debug(
				"consumerExtensionReportInstance " + reportInstance +
					" indexed successfully");
		}

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet,
		PortletURL portletURL) {

		return null;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		ConsumerReportInstance reportInstance = (ConsumerReportInstance)obj;

		Document document = getDocument(reportInstance);

		if (document != null) {
			SearchEngineUtil.updateDocument(
				getSearchEngineId(), reportInstance.getCompanyId(), document);
		}
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		ConsumerReportInstance reportInstance =
			ConsumerReportInstanceLocalServiceUtil.getReportInstance(classPK);

		doReindex(reportInstance);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexReportInstances(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexReportInstances(final long companyId)
		throws PortalException, SystemException {

		ActionableDynamicQuery actionableDynamicQuery =
			new ConsumerReportInstanceActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) {
				ConsumerReportInstance reportInstance =
					(ConsumerReportInstance)object;

				try {
					Document document = getDocument(reportInstance);

					if (document != null) {
						addDocument(document);
					}
				}
				catch (PortalException e) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							"Unable to index consumer report instance: " +
								reportInstance.getConsumerReportInstanceId(),
							e);
					}
				}
			}

		};

		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		actionableDynamicQuery.performActions();
	}

	private static Log _log = LogFactoryUtil.getLog(
		ConsumerReportInstanceIndexer.class);

}