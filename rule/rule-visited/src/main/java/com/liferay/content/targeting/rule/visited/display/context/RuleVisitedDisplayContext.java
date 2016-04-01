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

import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.content.targeting.analytics.util.AnalyticsUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class RuleVisitedDisplayContext {

	public RuleVisitedDisplayContext(HttpServletRequest request) {
		_request = request;

		_displayContext = (Map<String, Object>)request.getAttribute(
			"displayContext");
	}

	public long getAssetEntryId() {
		if (_assetEntryId != null) {
			return _assetEntryId;
		}

		_assetEntryId = GetterUtil.getLong(
			_displayContext.get("assetEntryId"), 0L);

		return _assetEntryId;
	}

	public String getAssetImage() {
		if (_assetImage != null) {
			return _assetImage;
		}

		_assetImage = GetterUtil.getString(_displayContext.get("assetImage"));

		return _assetImage;
	}

	public List<AssetRendererFactory> getAssetRendererFactories() {
		if (_assetRendererFactories != null) {
			return _assetRendererFactories;
		}

		_assetRendererFactories =
			(List<AssetRendererFactory>)_displayContext.get(
				"assetRendererFactories");

		return _assetRendererFactories;
	}

	public String getAssetTitle() {
		if (_assetTitle != null) {
			return _assetTitle;
		}

		_assetTitle = GetterUtil.getString(_displayContext.get("assetTitle"));

		return _assetTitle;
	}

	public String getAssetType() {
		if (_assetType != null) {
			return _assetType;
		}

		_assetType = GetterUtil.getString(_displayContext.get("assetType"));

		return _assetType;
	}

	public String getFriendlyURL() {
		if (_friendlyURL != null) {
			return _friendlyURL;
		}

		_friendlyURL = GetterUtil.getString(_displayContext.get("friendlyURL"));

		return _friendlyURL;
	}

	public String getFriendlyURLBase() {
		if (_friendlyURLBase != null) {
			return _friendlyURLBase;
		}

		_friendlyURLBase = GetterUtil.getString(
			_displayContext.get("friendlyURLBase"));

		return _friendlyURLBase;
	}

	public String getFriendlyURLPrivateBase() {
		if (_friendlyURLPrivateBase != null) {
			return _friendlyURLPrivateBase;
		}

		_friendlyURLPrivateBase = GetterUtil.getString(
			_displayContext.get("friendlyURLPrivateBase"));

		return _friendlyURLPrivateBase;
	}

	public String getFriendlyURLPublicBase() {
		if (_friendlyURLPublicBase != null) {
			return _friendlyURLPublicBase;
		}

		_friendlyURLPublicBase = GetterUtil.getString(
			_displayContext.get("friendlyURLPublicBase"));

		return _friendlyURLPublicBase;
	}

	public String getPortalSettingsURL() {
		if (_portalSettingsURL != null) {
			return _portalSettingsURL;
		}

		_portalSettingsURL = GetterUtil.getString(
			_displayContext.get("portalSettingsURL"));

		return _portalSettingsURL;
	}

	public String getSiteSettingsURL() {
		if (_siteSettingsURL != null) {
			return _siteSettingsURL;
		}

		_siteSettingsURL = GetterUtil.getString(
			_displayContext.get("siteSettingsURL"));

		return _siteSettingsURL;
	}

	public boolean isPrivateLayout() {
		if (_privateLayout != null) {
			return _privateLayout;
		}

		_privateLayout = GetterUtil.getBoolean(
			_displayContext.get("privateLayout"), false);

		return _privateLayout;
	}

	public boolean isTrackingContentEnabled() {
		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return AnalyticsUtil.isAnalyticsContentEnabled(
			themeDisplay.getScopeGroupId());
	}

	public boolean isTrackingPageEnabled() {
		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		return AnalyticsUtil.isAnalyticsPageEnabled(
			themeDisplay.getScopeGroupId());
	}

	private Long _assetEntryId;
	private String _assetImage;
	private List<AssetRendererFactory> _assetRendererFactories;
	private String _assetTitle;
	private String _assetType;
	private final Map<String, Object> _displayContext;
	private String _friendlyURL;
	private String _friendlyURLBase;
	private String _friendlyURLPrivateBase;
	private String _friendlyURLPublicBase;
	private String _portalSettingsURL;
	private Boolean _privateLayout;
	private final HttpServletRequest _request;
	private String _siteSettingsURL;

}