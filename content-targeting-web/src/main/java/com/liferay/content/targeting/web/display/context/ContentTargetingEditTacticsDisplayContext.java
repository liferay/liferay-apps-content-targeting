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

package com.liferay.content.targeting.web.display.context;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.web.util.ChannelTemplate;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
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
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		UserSegmentLocalService userSegmentLocalService) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_userSegmentLocalService = userSegmentLocalService;

		_request = PortalUtil.getHttpServletRequest(liferayPortletRequest);

		_themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);
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
			PortletConfig portletConfig =
				(PortletConfig) _liferayPortletRequest.getAttribute(
					JavaConstants.JAVAX_PORTLET_CONFIG);

			_tacticName = LanguageUtil.get(
				portletConfig.getResourceBundle(themeDisplay.getLocale()),
				"new-promotion");
		}

		return _tacticName;
	}

	public String getUserSegmentAssetCategoryIdsAsString() {
		if (Validator.isNotNull(_userSegmentAssetCategoryIdsAsString)) {
			return _userSegmentAssetCategoryIdsAsString;
		}

		long[] userSegmentAssetCategoryIds =
			ContentTargetingUtil.getAssetCategoryIds(
				_getCampaignUserSegments());

		_userSegmentAssetCategoryIdsAsString = StringUtil.merge(
			userSegmentAssetCategoryIds);

		return _userSegmentAssetCategoryIdsAsString;
	}

	public String getUserSegmentAssetCategoryNames() {
		if (Validator.isNotNull(_userSegmentAssetCategoryNames)) {
			return _userSegmentAssetCategoryNames;
		}

		long[] userSegmentAssetCategoryIds =
			ContentTargetingUtil.getAssetCategoryIds(
				_getCampaignUserSegments());

		_userSegmentAssetCategoryNames =
			ContentTargetingUtil.getAssetCategoryNames(
				userSegmentAssetCategoryIds, _themeDisplay.getLocale());

		return _userSegmentAssetCategoryNames;
	}

	public String getVocabularyGroupIds() throws PortalException {
		if (Validator.isNotNull(_vocabularyGroupIds)) {
			return _vocabularyGroupIds;
		}

		long[] vocabularyGroupIds = new long[1];

		if (_themeDisplay.getScopeGroupId() ==
				_themeDisplay.getCompanyGroupId()) {

			vocabularyGroupIds[0] = _themeDisplay.getCompanyGroupId();
		}
		else {
			vocabularyGroupIds =
				ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
					_themeDisplay.getSiteGroupId());
		}

		_vocabularyGroupIds = StringUtil.merge(vocabularyGroupIds);

		return _vocabularyGroupIds;
	}

	public String getVocabularyIds() throws PortalException {
		if (Validator.isNotNull(_vocabularyIds)) {
			return _vocabularyIds;
		}

		long[] vocabularyIds = new long[1];

		if (_themeDisplay.getScopeGroupId() ==
				_themeDisplay.getCompanyGroupId()) {

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(_themeDisplay.getScopeGroupId());

			vocabularyIds[0] = UserSegmentUtil.getAssetVocabularyId(
				_themeDisplay.getUserId(), serviceContext);
		}
		else {
			long[] vocabularyGroupsIds = StringUtil.split(
				getVocabularyGroupIds(), 0L);

			vocabularyIds = UserSegmentUtil.getAssetVocabularyIds(
				vocabularyGroupsIds);
		}

		_vocabularyIds = StringUtil.merge(vocabularyIds);

		return _vocabularyIds;
	}

	private List<UserSegment> _getCampaignUserSegments() {
		if (_campaignUserSegments != null) {
			return _campaignUserSegments;
		}

		_campaignUserSegments =
			_userSegmentLocalService.getCampaignUserSegments(getCampaignId());

		return _campaignUserSegments;
	}

	private List<ChannelTemplate> _addedChannelTemplates;
	private String _backURL;
	private Long _campaignId;
	private List<UserSegment> _campaignUserSegments;
	private String _campaignUserSegmentsIds;
	private List<ChannelTemplate> _channelTemplates;
	private String _cssItemsClass;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private String _redirect;
	private final HttpServletRequest _request;
	private Tactic _tactic;
	private Long _tacticId;
	private String _tacticName;
	private final ThemeDisplay _themeDisplay;
	private String _userSegmentAssetCategoryIdsAsString;
	private String _userSegmentAssetCategoryNames;
	private final UserSegmentLocalService _userSegmentLocalService;
	private String _vocabularyGroupIds;
	private String _vocabularyIds;

}