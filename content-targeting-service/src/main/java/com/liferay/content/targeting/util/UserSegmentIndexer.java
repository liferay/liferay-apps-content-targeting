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

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.permission.UserSegmentPermission;
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
public class UserSegmentIndexer extends BaseIndexer<UserSegment> {

	public static final String[] CLASS_NAMES = {UserSegment.class.getName()};

	public static final String PORTLET_ID = PortletKeys.CT_CORE;

	public UserSegmentIndexer() {
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return UserSegment.class.getName();
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

		UserSegment userSegment = _userSegmentLocalService.getUserSegment(
			entryClassPK);

		return UserSegmentPermission.contains(
			permissionChecker, userSegment, ActionKeys.VIEW);
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
	protected void doDelete(UserSegment userSegment) throws Exception {
		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, userSegment.getUserSegmentId());

		SearchEngineUtil.deleteDocument(
			getSearchEngineId(), userSegment.getCompanyId(),
			document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(UserSegment userSegment) throws Exception {
		if (_log.isDebugEnabled()) {
			_log.debug("Indexing user segment " + userSegment);
		}

		Document document = getBaseModelDocument(PORTLET_ID, userSegment);

		document.addLocalizedText(
			Field.DESCRIPTION, userSegment.getDescriptionMap());
		document.addLocalizedText(Field.NAME, userSegment.getNameMap());

		document.addKeyword("userSegmentId", userSegment.getUserSegmentId());

		if (_log.isDebugEnabled()) {
			_log.debug("User segment " + userSegment + " indexed successfully");
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
		UserSegment userSegment = _userSegmentLocalService.getUserSegment(
			classPK);

		doReindex(userSegment);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexUserSegments(companyId);
	}

	@Override
	protected void doReindex(UserSegment userSegment) throws Exception {
		Document document = getDocument(userSegment);

		if (document != null) {
			SearchEngineUtil.updateDocument(
				getSearchEngineId(), userSegment.getCompanyId(), document);
		}
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexUserSegments(final long companyId)
		throws PortalException {

		final IndexableActionableDynamicQuery actionableDynamicQuery =
			_userSegmentLocalService.getIndexableActionableDynamicQuery();

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<UserSegment>() {

				@Override
				public void performAction(UserSegment userSegment) {
					try {
						Document document = getDocument(userSegment);

						if (document != null) {
							actionableDynamicQuery.addDocuments(document);
						}
					}
					catch (PortalException pe) {
						if (_log.isWarnEnabled()) {
							_log.warn(
								"Unable to index user segment: " +
									userSegment.getUserSegmentId(),
								pe);
						}
					}
				}

			});

		actionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		actionableDynamicQuery.performActions();
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserSegmentIndexer.class);

	private UserSegmentLocalService _userSegmentLocalService;

}