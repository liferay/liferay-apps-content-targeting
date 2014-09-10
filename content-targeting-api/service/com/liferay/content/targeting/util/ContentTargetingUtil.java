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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetRendererFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class ContentTargetingUtil {

	public static long[] getAncestorsAndCurrentGroupIds(long groupId)
		throws PortalException, SystemException {

		Group scopeGroup = GroupLocalServiceUtil.fetchGroup(groupId);

		if (scopeGroup == null) {
			return null;
		}

		if (scopeGroup.isStagingGroup()) {
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

	public static Map<String, Object> getAssetSelectorIconData(
			HttpServletRequest request,
			AssetRendererFactory assetRendererFactory, String index)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL assetBrowserURL = getAssetBrowserURL(
			request, assetRendererFactory.getClassName());

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

	protected static PortletURL getAssetBrowserURL(
			HttpServletRequest request, String className)
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
			"selectedGroupIds", String.valueOf(themeDisplay.getScopeGroupId()));
		assetBrowserURL.setParameter("eventName", "selectContent");
		assetBrowserURL.setParameter("typeSelection", className);
		assetBrowserURL.setPortletMode(PortletMode.VIEW);
		assetBrowserURL.setWindowState(LiferayWindowState.POP_UP);

		return assetBrowserURL;
	}

}