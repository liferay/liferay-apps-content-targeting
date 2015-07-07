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
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.staging.StagingUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.sites.util.Sites;
import com.liferay.portlet.sites.util.SitesUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class ContentTargetingUtil {

	public static final String GUID_REPLACEMENT = "{ct_field_guid}";

	public static long[] getAncestorsAndCurrentGroupIds(long groupId)
		throws PortalException, SystemException {

		Group scopeGroup = GroupLocalServiceUtil.fetchGroup(groupId);

		if (scopeGroup == null) {
			return null;
		}

		if (scopeGroup.isStagingGroup() &&
			!ContentTargetingUtil.isStaged(
				scopeGroup.getLiveGroupId(), PortletKeys.CT_ADMIN)) {

			scopeGroup = scopeGroup.getLiveGroup();
		}

		List<Group> groups = scopeGroup.getAncestors();

		groups.add(scopeGroup);

		Group companyGroup = GroupLocalServiceUtil.getCompanyGroup(
			scopeGroup.getCompanyId());

		groups.add(companyGroup);

		long[] groupIds = new long[groups.size()];

		for (int i = 0; i < groups.size(); i++) {
			Group group = groups.get(i);

			groupIds[i] = group.getGroupId();
		}

		return groupIds;
	}

	public static long[] getAssetCategoryIds(List<UserSegment> userSegments) {
		long[] assetCategoryIds = new long[userSegments.size()];

		for (int i = 0; i < assetCategoryIds.length; i++) {
			UserSegment userSegment = userSegments.get(i);

			assetCategoryIds[i] = userSegment.getAssetCategoryId();
		}

		return assetCategoryIds;
	}

	public static long[] getAssetCategoryIds(
			long groupId, long[] userSegmentIds)
		throws SystemException {

		if (userSegmentIds == null) {
			return new long[0];
		}

		long[] assetCategoryIds = new long[userSegmentIds.length];

		for (int i = 0; i < userSegmentIds.length; i++) {
			UserSegment userSegment =
				UserSegmentLocalServiceUtil.fetchUserSegment(userSegmentIds[i]);

			assetCategoryIds[i] = userSegment.getAssetCategoryId(groupId);
		}

		return assetCategoryIds;
	}

	public static String getAssetCategoryNames(
			long[] assetCategoryIds, Locale locale)
		throws SystemException {

		return getAssetCategoryNames(
			assetCategoryIds, locale, _CATEGORY_SEPARATOR);
	}

	public static String getAssetCategoryNames(
			long[] assetCategoryIds, Locale locale, String separator)
		throws SystemException {

		if (ArrayUtil.isEmpty(assetCategoryIds)) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler((assetCategoryIds.length * 2) - 1);

		for (int i = 0; i < assetCategoryIds.length; i++) {
			AssetCategory assetCategory =
				AssetCategoryLocalServiceUtil.fetchAssetCategory(
						assetCategoryIds[i]);

			if (assetCategory == null) {
				continue;
			}

			sb.append(assetCategory.getTitle(locale));

			if (i != (assetCategoryIds.length - 1)) {
				sb.append(separator);
			}
		}

		return sb.toString();
	}

	public static Map<String, Object> getAssetSelectorIconData(
			HttpServletRequest request,
			AssetRendererFactory assetRendererFactory, String index)
		throws Exception {

		return getAssetSelectorIconData(
			request, assetRendererFactory, index, false);
	}

	public static Map<String, Object> getAssetSelectorIconData(
			HttpServletRequest request,
			AssetRendererFactory assetRendererFactory, String index,
			boolean instantiable)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL assetBrowserURL = getAssetBrowserURL(
			request, assetRendererFactory.getClassName(), instantiable);

		String typeName = assetRendererFactory.getTypeName(
			themeDisplay.getLocale(), false);

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("groupid", String.valueOf(themeDisplay.getScopeGroupId()));
		data.put("href", assetBrowserURL.toString());

		if (Validator.isNotNull(index)) {
			data.put("index", index);
		}

		data.put(
			"title",
			LanguageUtil.format(
				themeDisplay.getLocale(), "select-x", typeName, false));
		data.put("type", typeName);

		return data;
	}

	// This method already exists in 7.0

	public static long[] getSharedContentSiteGroupIds(
			long companyId, long groupId, long userId)
		throws PortalException, SystemException {

		Set<Group> groups = new LinkedHashSet<Group>();

		Group siteGroup = doGetCurrentSiteGroup(groupId);

		if (siteGroup != null) {

			// Current site

			groups.add(siteGroup);

			// Layout scopes

			groups.addAll(
				GroupLocalServiceUtil.getGroups(
					siteGroup.getCompanyId(), Layout.class.getName(),
					siteGroup.getGroupId()));
		}

		// Administered sites

		if (PrefsPropsUtil.getBoolean(
				companyId,
			PropsKeys.
				SITES_CONTENT_SHARING_THROUGH_ADMINISTRATORS_ENABLED)) {

			LinkedHashMap<String, Object> groupParams =
				new LinkedHashMap<String, Object>();

			groupParams.put("site", Boolean.TRUE);
			groupParams.put("usersGroups", userId);

			groups.addAll(
				GroupLocalServiceUtil.search(
					companyId, null, null, groupParams, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null));
		}

		// Descendant sites

		groups.addAll(getDescendants(siteGroup, true));

		// Ancestor sites and global site

		int sitesContentSharingWithChildrenEnabled = PrefsPropsUtil.getInteger(
			companyId, PropsKeys.SITES_CONTENT_SHARING_WITH_CHILDREN_ENABLED);

		if (sitesContentSharingWithChildrenEnabled !=
				Sites.CONTENT_SHARING_WITH_CHILDREN_DISABLED) {

			groups.addAll(doGetAncestorSiteGroups(groupId, true));
		}

		long[] groupIds = new long[groups.size()];

		int i = 0;

		for (Group group : groups) {
			groupIds[i++] = group.getGroupId();
		}

		return groupIds;
	}

	public static boolean isStaged(long liveGroupId, String portletId)
		throws PortalException, SystemException {

		Group liveGroup = GroupLocalServiceUtil.getGroup(liveGroupId);

		UnicodeProperties liveGroupTypeSettings =
			liveGroup.getTypeSettingsProperties();

		return GetterUtil.getBoolean(
			liveGroupTypeSettings.getProperty(
				StagingUtil.getStagedPortletId(portletId)), false);
	}

	// This method already exists in 7.0

	protected static Set<Group> doGetAncestorSiteGroups(
			long groupId, boolean checkContentSharingWithChildrenEnabled)
		throws PortalException, SystemException {

		Set<Group> groups = new LinkedHashSet<Group>();

		long siteGroupId = getSiteGroupId(groupId);

		Group siteGroup = GroupLocalServiceUtil.getGroup(siteGroupId);

		for (Group group : siteGroup.getAncestors()) {
			if (checkContentSharingWithChildrenEnabled &&
				!SitesUtil.isContentSharingWithChildrenEnabled(group)) {

				continue;
			}

			groups.add(group);
		}

		if (!siteGroup.isCompany()) {
			groups.add(
				GroupLocalServiceUtil.getCompanyGroup(
					siteGroup.getCompanyId()));
		}

		return groups;
	}

	// This method already exists in 7.0

	protected static Group doGetCurrentSiteGroup(long groupId)
		throws PortalException, SystemException {

		long siteGroupId = getSiteGroupId(groupId);

		Group siteGroup = GroupLocalServiceUtil.getGroup(siteGroupId);

		if (!siteGroup.isLayoutPrototype()) {
			return siteGroup;
		}

		return null;
	}

	protected static PortletURL getAssetBrowserURL(
			HttpServletRequest request, String className, boolean instantiable)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL assetBrowserURL = PortletURLFactoryUtil.create(
			request, PortletKeys.ASSET_BROWSER,
			PortalUtil.getControlPanelPlid(themeDisplay.getCompanyId()),
			PortletRequest.RENDER_PHASE);

		assetBrowserURL.setParameter("struts_action", "/asset_browser/view");
		assetBrowserURL.setParameter(
			"groupId", String.valueOf(themeDisplay.getScopeGroupId()));
		assetBrowserURL.setParameter(
			"selectedGroupIds",
			StringUtil.merge(
				getSharedContentSiteGroupIds(
					themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
					themeDisplay.getUserId())));

		String eventName = "selectContent";

		if (instantiable) {
			eventName = GUID_REPLACEMENT + eventName;
		}

		assetBrowserURL.setParameter("eventName", eventName);
		assetBrowserURL.setParameter("typeSelection", className);
		assetBrowserURL.setPortletMode(PortletMode.VIEW);
		assetBrowserURL.setWindowState(LiferayWindowState.POP_UP);

		return assetBrowserURL;
	}

	// This method already exists in 7.0

	protected static List<Group> getDescendants(Group group, boolean site)
		throws SystemException {

		Set<Group> descendants = new LinkedHashSet<Group>();

		for (Group curGroup : group.getChildren(site)) {
			descendants.add(curGroup);
			descendants.addAll(getDescendants(curGroup, site));
		}

		return new ArrayList<Group>(descendants);
	}

	// This method already exists in 7.0

	protected static long getSiteGroupId(long groupId)
		throws PortalException, SystemException {

		if (groupId <= 0) {
			return 0;
		}

		Group group = GroupLocalServiceUtil.getGroup(groupId);

		long siteGroupId = groupId;

		if (group.isLayout()) {
			siteGroupId = group.getParentGroupId();
		}

		return siteGroupId;
	}

	private static final String _CATEGORY_SEPARATOR = "_CATEGORY_";

}