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

package com.liferay.content.targeting.rule.visited.display.context;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.content.targeting.analytics.util.AnalyticsUtil;
import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleVisitedDisplayContext extends BaseRuleDisplayContext {

	public RuleVisitedDisplayContext(HttpServletRequest request) {
		super(request);
	}

	public AssetEntry getAssetEntry() {
		if (_assetEntry != null) {
			return _assetEntry;
		}

		_assetEntry = AssetEntryLocalServiceUtil.fetchAssetEntry(
			getAssetEntryId());

		return _assetEntry;
	}

	public long getAssetEntryId() {
		if (_assetEntryId != null) {
			return _assetEntryId;
		}

		_assetEntryId = GetterUtil.getLong(
			displayContext.get("assetEntryId"), 0L);

		return _assetEntryId;
	}

	public List<AssetRendererFactory<?>> getAssetRendererFactories() {
		if (_assetRendererFactories != null) {
			return _assetRendererFactories;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_assetRendererFactories =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactories(
				themeDisplay.getCompanyId(), true);

		return _assetRendererFactories;
	}

	public String getFriendlyURL() {
		if (_friendlyURL != null) {
			return _friendlyURL;
		}

		_friendlyURL = GetterUtil.getString(displayContext.get("friendlyURL"));

		return _friendlyURL;
	}

	public String getFriendlyURLBase() throws PortalException {
		if (isPrivateLayout()) {
			return getFriendlyURLPrivateBase();
		}

		return getFriendlyURLPublicBase();
	}

	public String getFriendlyURLPrivateBase() throws PortalException {
		if (_friendlyURLPrivateBase != null) {
			return _friendlyURLPrivateBase;
		}

		_friendlyURLPrivateBase = getFriendlyURL(true);

		return _friendlyURLPrivateBase;
	}

	public String getFriendlyURLPublicBase() throws PortalException {
		if (_friendlyURLPublicBase != null) {
			return _friendlyURLPublicBase;
		}

		_friendlyURLPublicBase = getFriendlyURL(false);

		return _friendlyURLPublicBase;
	}

	public boolean isPrivateLayout() {
		if (_privateLayout != null) {
			return _privateLayout;
		}

		_privateLayout = GetterUtil.getBoolean(
			displayContext.get("privateLayout"));

		return _privateLayout;
	}

	public boolean isTrackingContentEnabled() {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return AnalyticsUtil.isAnalyticsContentEnabled(
			themeDisplay.getScopeGroupId());
	}

	public boolean isTrackingPageEnabled() {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return AnalyticsUtil.isAnalyticsPageEnabled(
			themeDisplay.getScopeGroupId());
	}

	protected String getFriendlyURL(boolean privateLayout)
		throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		String friendlyURL = StringPool.BLANK;

		LayoutSet layoutSet = themeDisplay.getLayoutSet();

		boolean privateLayoutSet = layoutSet.isPrivateLayout();

		try {
			layoutSet.setPrivateLayout(privateLayout);

			friendlyURL = PortalUtil.getGroupFriendlyURL(
				layoutSet, themeDisplay);
		}
		finally {
			layoutSet.setPrivateLayout(privateLayoutSet);
		}

		return friendlyURL;
	}

	private AssetEntry _assetEntry;
	private Long _assetEntryId;
	private List<AssetRendererFactory<?>> _assetRendererFactories;
	private String _friendlyURL;
	private String _friendlyURLPrivateBase;
	private String _friendlyURLPublicBase;
	private Boolean _privateLayout;

}