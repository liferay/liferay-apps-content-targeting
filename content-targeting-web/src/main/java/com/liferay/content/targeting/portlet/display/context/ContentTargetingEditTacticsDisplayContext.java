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

package com.liferay.content.targeting.portlet.display.context;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.util.ChannelTemplate;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingEditTacticsDisplayContext {

	public ContentTargetingEditTacticsDisplayContext(
		LiferayPortletResponse liferayPortletResponse,
		PortletConfig portletConfig, HttpServletRequest request) {

		_liferayPortletResponse = liferayPortletResponse;
		_portletConfig = portletConfig;
		_request = request;
	}

	public List<ChannelTemplate> getAddedChannelTemplates() {
		if (_addedChannelTemplates != null) {
			return _addedChannelTemplates;
		}

		_addedChannelTemplates = (List<ChannelTemplate>)_request.getAttribute(
			"addedChannelTemplates");

		return _addedChannelTemplates;
	}

	public String getBackURL() {
		if (Validator.isNotNull(_backURL)) {
			return _backURL;
		}

		String backURL = ParamUtil.getString(_request, "backURL");

		if (Validator.isNull(backURL)) {
			PortletURL backURLObject =
				_liferayPortletResponse.createRenderURL();

			backURLObject.setParameter(
				"mvcRenderCommandName",
				ContentTargetingMVCCommand.VIEW_TACTICS);
			backURLObject.setParameter(
				"campaignId", String.valueOf(getCampaignId()));
			backURLObject.setParameter("className", Campaign.class.getName());
			backURLObject.setParameter(
				"classPK", String.valueOf(getCampaignId()));

			backURL = backURLObject.toString();
		}

		_backURL = backURL;

		return _backURL;
	}

	public long getCampaignId() {
		if (_campaignId != null) {
			return _campaignId;
		}

		_campaignId = ParamUtil.getLong(_request, "campaignId", 0);

		return _campaignId;
	}

	public String getCampaignUserSegmentsIds() {
		if (Validator.isNotNull(_campaignUserSegmentsIds)) {
			return _campaignUserSegmentsIds;
		}

		_campaignUserSegmentsIds = GetterUtil.getString(
			_request.getAttribute("campaignUserSegmentsIds"));

		return _campaignUserSegmentsIds;
	}

	public List<ChannelTemplate> getChannelTemplates() {
		if (_channelTemplates != null) {
			return _channelTemplates;
		}

		_channelTemplates = (List<ChannelTemplate>)_request.getAttribute(
			"channelTemplates");

		return _channelTemplates;
	}

	public String getCssItemsClass() {
		if (Validator.isNotNull(_cssItemsClass)) {
			return _cssItemsClass;
		}

		String cssItemsClass = "";

		List<ChannelTemplate> addedChannelTemplates =
			getAddedChannelTemplates();

		if (addedChannelTemplates.size() > 0) {
			cssItemsClass = "has-items";
		}

		_cssItemsClass = cssItemsClass;

		return _cssItemsClass;
	}

	public String getRedirect() {
		if (Validator.isNotNull(_redirect)) {
			return _redirect;
		}

		_redirect = ParamUtil.getString(_request, "redirect");

		return _redirect;
	}

	public Tactic getTactic() {
		if (_tactic != null) {
			return _tactic;
		}

		long tacticId = getTacticId();

		if (tacticId > 0) {
			_tactic = TacticLocalServiceUtil.fetchTactic(tacticId);
		}

		return _tactic;
	}

	public long getTacticId() {
		if (_tacticId != null) {
			return _tacticId;
		}

		_tacticId = ParamUtil.getLong(_request, "tacticId", 0);

		return _tacticId;
	}

	public String getTacticName() {
		if (Validator.isNotNull(_tacticName)) {
			return _tacticName;
		}

		Tactic tactic = getTactic();

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (tactic != null) {
			_tacticName = tactic.getName(themeDisplay.getLocale());
		}
		else {
			_tacticName = LanguageUtil.get(
				_portletConfig.getResourceBundle(themeDisplay.getLocale()),
				"new-promotion");
		}

		return _tacticName;
	}

	public String getUserSegmentAssetCategoryIdsAsString() {
		if (Validator.isNotNull(_userSegmentAssetCategoryIdsAsString)) {
			return _userSegmentAssetCategoryIdsAsString;
		}

		_userSegmentAssetCategoryIdsAsString = GetterUtil.getString(
			_request.getAttribute("userSegmentAssetCategoryIdsAsString"));

		return _userSegmentAssetCategoryIdsAsString;
	}

	public String getUserSegmentAssetCategoryNames() {
		if (Validator.isNotNull(_userSegmentAssetCategoryNames)) {
			return _userSegmentAssetCategoryNames;
		}

		_userSegmentAssetCategoryNames = GetterUtil.getString(
			_request.getAttribute("userSegmentAssetCategoryNames"));

		return _userSegmentAssetCategoryNames;
	}

	public String getVocabularyGroupIds() {
		if (Validator.isNotNull(_vocabularyGroupIds)) {
			return _vocabularyGroupIds;
		}

		_vocabularyGroupIds = GetterUtil.getString(
			_request.getAttribute("vocabularyGroupIds"));

		return _vocabularyGroupIds;
	}

	public String getVocabularyIds() {
		if (Validator.isNotNull(_vocabularyIds)) {
			return _vocabularyIds;
		}

		_vocabularyIds = GetterUtil.getString(
			_request.getAttribute("vocabularyIds"));

		return _vocabularyIds;
	}

	private List<ChannelTemplate> _addedChannelTemplates;
	private String _backURL;
	private Long _campaignId;
	private String _campaignUserSegmentsIds;
	private List<ChannelTemplate> _channelTemplates;
	private String _cssItemsClass;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortletConfig _portletConfig;
	private String _redirect;
	private final HttpServletRequest _request;
	private Tactic _tactic;
	private Long _tacticId;
	private String _tacticName;
	private String _userSegmentAssetCategoryIdsAsString;
	private String _userSegmentAssetCategoryNames;
	private String _vocabularyGroupIds;
	private String _vocabularyIds;

}