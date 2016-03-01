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

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.exportimport.kernel.staging.StagingUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.portlet.PortletMode;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class ContentTargetingUtil {

	public static final String GUID_REPLACEMENT = "{ct_field_guid}";

	public static long[] getAncestorsAndCurrentGroupIds(long groupId)
		throws PortalException {

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
		long groupId, long[] userSegmentIds) {

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
		long[] assetCategoryIds, Locale locale) {

		return getAssetCategoryNames(
			assetCategoryIds, locale, _CATEGORY_SEPARATOR);
	}

	public static String getAssetCategoryNames(
		long[] assetCategoryIds, Locale locale, String separator) {

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

		Map<String, Object> data = new HashMap<>();

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

	public static String getModelResource(
		Locale locale, Class clazz, String name) {

		String key = ResourceActionsUtil.getModelResourceNamePrefix() + name;

		try {
			ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", locale, clazz);

			String modelResource = ResourceBundleUtil.getString(
				resourceBundle, key);

			if (modelResource == null) {
				modelResource = key;
			}

			return modelResource;
		}
		catch (MissingResourceException mre) {
			return ResourceActionsUtil.getModelResource(locale, name);
		}
	}

	public static boolean isStaged(long liveGroupId, String portletId)
		throws PortalException {

		Group liveGroup = GroupLocalServiceUtil.getGroup(liveGroupId);

		UnicodeProperties liveGroupTypeSettings =
			liveGroup.getTypeSettingsProperties();

		return GetterUtil.getBoolean(
			liveGroupTypeSettings.getProperty(
				StagingUtil.getStagedPortletId(portletId)),
			false);
	}

	protected static PortletURL getAssetBrowserURL(
			HttpServletRequest request, String className, boolean instantiable)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL assetBrowserURL = PortletProviderUtil.getPortletURL(
			request, className, PortletProvider.Action.BROWSE);

		assetBrowserURL.setParameter(
			"groupId", String.valueOf(themeDisplay.getScopeGroupId()));
		assetBrowserURL.setParameter(
			"selectedGroupIds",
			StringUtil.merge(
				PortalUtil.getSharedContentSiteGroupIds(
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

	private static final String _CATEGORY_SEPARATOR = "_CATEGORY_";

}