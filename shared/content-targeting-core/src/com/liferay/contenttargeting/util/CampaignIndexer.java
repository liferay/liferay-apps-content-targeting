/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.util;

import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.service.CampaignLocalServiceUtil;
import com.liferay.contenttargeting.service.permission.CampaignPermission;
import com.liferay.contenttargeting.service.persistence.CampaignActionableDynamicQuery;
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
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

import java.util.Locale;

import javax.portlet.PortletURL;

/**
 * @author Eudaldo Alonso
 */
public class CampaignIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {Campaign.class.getName()};

	public static final String PORTLET_ID = PortletKeys.CT_CORE;

	public CampaignIndexer() {
		setFilterSearch(true);
		setPermissionAware(true);
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

		Campaign campaign = CampaignLocalServiceUtil.getCampaign(entryClassPK);

		return CampaignPermission.contains(
			permissionChecker, campaign, ActionKeys.VIEW);
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
		Campaign campaign = (Campaign)obj;

		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, campaign.getCampaignId());

		SearchEngineUtil.deleteDocument(
			getSearchEngineId(), campaign.getCompanyId(),
			document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		Campaign campaign = (Campaign)obj;

		if (_log.isDebugEnabled()) {
			_log.debug("Indexing campaign " + campaign);
		}

		Document document = getBaseModelDocument(PORTLET_ID, campaign);

		document.addLocalizedText(
			Field.DESCRIPTION, campaign.getDescriptionMap());
		document.addLocalizedText(Field.NAME, campaign.getNameMap());

		document.addKeyword("campaignId", campaign.getCampaignId());

		if (_log.isDebugEnabled()) {
			_log.debug("Campaign " + campaign + " indexed successfully");
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
		Campaign campaign = (Campaign)obj;

		Document document = getDocument(campaign);

		if (document != null) {
			SearchEngineUtil.updateDocument(
				getSearchEngineId(), campaign.getCompanyId(), document);
		}
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Campaign campaign = CampaignLocalServiceUtil.getCampaign(classPK);

		doReindex(campaign);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexCampaigns(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexCampaigns(final long companyId)
		throws PortalException, SystemException {

		ActionableDynamicQuery actionableDynamicQuery =
			new CampaignActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException {
				Campaign campaign = (Campaign)object;

				Document document = getDocument(campaign);

				if (document != null) {
					addDocument(document);
				}
			}

		};

		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		actionableDynamicQuery.performActions();
	}

	private static Log _log = LogFactoryUtil.getLog(CampaignIndexer.class);

}