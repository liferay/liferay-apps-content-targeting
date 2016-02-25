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

package com.liferay.content.targeting.portlet.util;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Julio Camarero
 */
public abstract class AssetQueryRule implements QueryRule {

	public AssetQueryRule(long assetEntryId, int index, Locale locale)
		throws PortalException {

		_assetEntryId = assetEntryId;
		_index = index;

		initAssetEntry(locale);
	}

	@Override
	public int compareTo(QueryRule queryRule) {
		return _index - queryRule.getIndex();
	}

	@Override
	public boolean evaluate(long[] ids) {
		return true;
	}

	@Override
	public String getAssetClassName() {
		return _assetClassName;
	}

	@Override
	public long getAssetClassPK() {
		return _assetClassPK;
	}

	@Override
	public AssetEntry getAssetEntry() {
		return _assetEntry;
	}

	@Override
	public long getAssetEntryId() {
		return _assetEntryId;
	}

	@Override
	public String getAssetImage(PortletRequest portletRequest)
		throws Exception {

		if (Validator.isNull(_assetClassName) || (_assetClassPK <= 0)) {
			return StringPool.BLANK;
		}

		return _assetRenderer.getThumbnailPath(portletRequest);
	}

	public Map<String, Object> getAssetSelectorIconData(
			HttpServletRequest request,
			AssetRendererFactory assetRendererFactory, String index)
		throws Exception {

		return ContentTargetingUtil.getAssetSelectorIconData(
			request, assetRendererFactory, index);
	}

	@Override
	public String getAssetTitle() {
		return _assetTitle;
	}

	@Override
	public String getAssetType() {
		return _assetType;
	}

	@Override
	public String getCssClass(int position) {
		if (position == 0) {
			return "first active";
		}
		else if (_index == -1) {
			return "last";
		}

		return StringPool.BLANK;
	}

	@Override
	public long getGroupId(long scopeGroupId) {
		return scopeGroupId;
	}

	@Override
	public int getIndex() {
		return _index;
	}

	@Override
	public String getTemplate() {
		return _template;
	}

	@Override
	public boolean hasAssetEntry() {
		if ((_assetEntry != null) && _assetEntry.isVisible()) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isDefaultRule() {
		if (_index == -1) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isValid() {
		return hasAssetEntry();
	}

	@Override
	public void setAssetAttributes(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		portletRequest.setAttribute("view.jsp-results", new ArrayList());
		portletRequest.setAttribute(
			"view.jsp-assetEntryIndex", Integer.valueOf(0));
		portletRequest.setAttribute("view.jsp-assetEntry", _assetEntry);
		portletRequest.setAttribute(
			"view.jsp-assetRendererFactory", _assetRendererFactory);
		portletRequest.setAttribute("view.jsp-assetRenderer", _assetRenderer);
		portletRequest.setAttribute(
			"view.jsp-title", _assetEntry.getTitle(themeDisplay.getLocale()));
		portletRequest.setAttribute("view.jsp-show", Boolean.valueOf(false));
		portletRequest.setAttribute("view.jsp-print", Boolean.valueOf(false));
	}

	@Override
	public void setAssetClassName(String assetClassName) {
		_assetClassName = assetClassName;
	}

	@Override
	public void setAssetClassPK(long assetClassPK) {
		_assetClassPK = assetClassPK;
	}

	@Override
	public void setAssetEntryId(long assetEntryId) {
		_assetEntryId = assetEntryId;
	}

	@Override
	public void setAssetTitle(String assetTitle) {
		_assetTitle = assetTitle;
	}

	@Override
	public void setAssetType(String assetType) {
		_assetType = assetType;
	}

	@Override
	public void setIndex(int index) {
		_index = index;
	}

	@Override
	public void setTemplate(String template) {
		_template = template;
	}

	protected String htmlOperator(
		Boolean andOperator, boolean contains, PortletConfig portletConfig,
		Locale locale) {

		StringBundler sb = new StringBundler(5);

		String cssClass = "query-operator";

		if ((andOperator == null) && !contains) {
			sb.append(
				LanguageUtil.get(
					portletConfig.getResourceBundle(locale), "not"));
			sb.append(StringPool.SPACE);

			cssClass += " first";
		}
		else {
			sb.append(StringPool.SPACE);

			if (andOperator) {
				sb.append(
					LanguageUtil.get(
						portletConfig.getResourceBundle(locale), "and"));
			}
			else {
				sb.append(
					LanguageUtil.get(
						portletConfig.getResourceBundle(locale), "or"));
			}

			sb.append(StringPool.SPACE);

			if (!contains) {
				sb.append(
					LanguageUtil.get(
						portletConfig.getResourceBundle(locale), "not"));
				sb.append(StringPool.SPACE);
			}
		}

		StringBundler html = new StringBundler(5);

		html.append("<span class=\"");
		html.append(cssClass);
		html.append("\">");
		html.append(StringUtil.toLowerCase(sb.toString()));
		html.append("</span>");

		return html.toString();
	}

	protected void initAssetEntry(Locale locale) throws PortalException {
		try {

			// See LPS-55480

			_assetEntry = AssetEntryServiceUtil.getEntry(_assetEntryId);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}

			return;
		}

		if (!_assetEntry.isVisible()) {
			return;
		}

		_assetClassName = _assetEntry.getClassName();
		_assetClassPK = _assetEntry.getClassPK();
		_assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
				_assetEntry.getClassName());
		_assetRenderer = _assetRendererFactory.getAssetRenderer(_assetClassPK);
		_assetTitle = _assetEntry.getTitle(locale);
		_assetType = _assetRendererFactory.getTypeName(locale, true);
	}

	private static final Log _log = LogFactoryUtil.getLog(AssetQueryRule.class);

	private String _assetClassName = StringPool.BLANK;
	private long _assetClassPK;
	private AssetEntry _assetEntry;
	private long _assetEntryId;
	private AssetRenderer _assetRenderer;
	private AssetRendererFactory _assetRendererFactory;
	private String _assetTitle = StringPool.BLANK;
	private String _assetType = StringPool.BLANK;
	private int _index;
	private String _template = null;

}