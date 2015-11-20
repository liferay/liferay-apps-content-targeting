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

import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.content.targeting.service.permission.TacticPermission;
import com.liferay.content.targeting.service.persistence.TacticActionableDynamicQuery;
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
public class TacticIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {Tactic.class.getName()};

	public static final String PORTLET_ID = PortletKeys.CT_CORE;

	public TacticIndexer() {
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

		Tactic tactic = TacticLocalServiceUtil.getTactic(entryClassPK);

		return TacticPermission.contains(
			permissionChecker, tactic, ActionKeys.VIEW);
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
		Tactic tactic = (Tactic)obj;

		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, tactic.getTacticId());

		SearchEngineUtil.deleteDocument(
			getSearchEngineId(), tactic.getCompanyId(),
			document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		Tactic tactic = (Tactic)obj;

		if (_log.isDebugEnabled()) {
			_log.debug("Indexing tactic " + tactic);
		}

		Document document = getBaseModelDocument(PORTLET_ID, tactic);

		document.addLocalizedText(
			Field.DESCRIPTION, tactic.getDescriptionMap());
		document.addLocalizedText(Field.NAME, tactic.getNameMap());

		document.addKeyword("campaignId", tactic.getCampaignId());
		document.addKeyword("tacticId", tactic.getTacticId());

		if (_log.isDebugEnabled()) {
			_log.debug("Tactic " + tactic + " indexed successfully");
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
		Tactic tactic = (Tactic)obj;

		Document document = getDocument(tactic);

		if (document != null) {
			SearchEngineUtil.updateDocument(
				getSearchEngineId(), tactic.getCompanyId(), document);
		}
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Tactic tactic = TacticLocalServiceUtil.getTactic(classPK);

		doReindex(tactic);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexTactics(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexTactics(final long companyId)
		throws PortalException, SystemException {

		ActionableDynamicQuery actionableDynamicQuery =
			new TacticActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) {
				Tactic tactic = (Tactic)object;

				try {
					Document document = getDocument(tactic);

					if (document != null) {
						addDocument(document);
					}
				}
				catch (PortalException e) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							"Unable to index tactic: " + tactic.getTacticId(),
							e);
					}
				}
			}

		};

		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		actionableDynamicQuery.performActions();
	}

	private static Log _log = LogFactoryUtil.getLog(TacticIndexer.class);

}