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
import com.liferay.content.targeting.service.TacticLocalService;
import com.liferay.content.targeting.service.permission.TacticPermission;
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
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Indexer.class)
public class TacticIndexer extends BaseIndexer<Tactic> {

	public static final String[] CLASS_NAMES = {Tactic.class.getName()};

	public static final String PORTLET_ID = PortletKeys.CT_CORE;

	public TacticIndexer() {
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return Tactic.class.getName();
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

		Tactic tactic = _tacticLocalService.getTactic(entryClassPK);

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
	protected void doDelete(Tactic tactic) throws Exception {
		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, tactic.getTacticId());

		SearchEngineUtil.deleteDocument(
			getSearchEngineId(), tactic.getCompanyId(),
			document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(Tactic tactic) throws Exception {
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
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws Exception {

		return null;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Tactic tactic = _tacticLocalService.getTactic(classPK);

		doReindex(tactic);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexTactics(companyId);
	}

	@Override
	protected void doReindex(Tactic tactic) throws Exception {
		Document document = getDocument(tactic);

		if (document != null) {
			SearchEngineUtil.updateDocument(
				getSearchEngineId(), tactic.getCompanyId(), document);
		}
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexTactics(final long companyId) throws PortalException {
		final IndexableActionableDynamicQuery actionableDynamicQuery =
			_tacticLocalService.getIndexableActionableDynamicQuery();

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Tactic>() {

				@Override
				public void performAction(Tactic tactic) {
					try {
						Document document = getDocument(tactic);

						if (document != null) {
							actionableDynamicQuery.addDocuments(document);
						}
					}
					catch (PortalException pe) {
						if (_log.isWarnEnabled()) {
							_log.warn(
								"Unable to index tactic: " +
									tactic.getTacticId(),
								pe);
						}
					}
				}

			});

		actionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		actionableDynamicQuery.performActions();
	}

	@Reference(unbind = "-")
	protected void setTacticLocalService(
		TacticLocalService tacticLocalService) {

		_tacticLocalService = tacticLocalService;
	}

	private static final Log _log = LogFactoryUtil.getLog(TacticIndexer.class);

	private TacticLocalService _tacticLocalService;

}