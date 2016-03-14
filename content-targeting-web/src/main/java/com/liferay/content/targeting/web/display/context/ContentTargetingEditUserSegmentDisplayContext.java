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

import com.liferay.content.targeting.api.model.RuleCategoriesRegistry;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.content.targeting.web.util.RuleTemplate;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingEditUserSegmentDisplayContext {

	public ContentTargetingEditUserSegmentDisplayContext(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		_renderResponse = renderResponse;

		_request = PortalUtil.getHttpServletRequest(renderRequest);
	}

	public List<RuleTemplate> getAddedRuleTemplates() {
		if (_addedRuleTemplates != null) {
			return _addedRuleTemplates;
		}

		_addedRuleTemplates = (List<RuleTemplate>)_request.getAttribute(
			"addedRuleTemplates");

		return _addedRuleTemplates;
	}

	public String getBackURL() {
		String backURL = ParamUtil.getString(_request, "backURL");

		if (Validator.isNotNull(backURL)) {
			return backURL;
		}

		PortletURL backURLObject = _renderResponse.createRenderURL();

		backURLObject.setParameter("mvcPath", "/view.jsp");
		backURLObject.setParameter("tabs1", "user-segments");

		return backURLObject.toString();
	}

	public String getCssItemsClass() {
		List<RuleTemplate> addedRuleTemplates = getAddedRuleTemplates();

		String cssItemsClass = StringPool.BLANK;

		if (!addedRuleTemplates.isEmpty()) {
			cssItemsClass = "has-items";
		}

		_cssItemsClass = cssItemsClass;

		return _cssItemsClass;
	}

	public String getRedirect() {
		if (Validator.isNotNull(_redirect)) {
			return _redirect;
		}

		String redirect = ParamUtil.getString(_request, "redirect");

		if (Validator.isNull(redirect)) {
			PortletURL redirectURLObject = _renderResponse.createRenderURL();

			redirectURLObject.setParameter("mvcPath", "/view.jsp");
			redirectURLObject.setParameter("tabs1", "user-segments");

			redirect = redirectURLObject.toString();
		}

		_redirect = redirect;

		return _redirect;
	}

	public RuleCategoriesRegistry getRuleCategoriesRegistry() {
		if (_ruleCategoriesRegistry != null) {
			return _ruleCategoriesRegistry;
		}

		_ruleCategoriesRegistry = (RuleCategoriesRegistry)_request.getAttribute(
			"ruleCategoriesRegistry");

		return _ruleCategoriesRegistry;
	}

	public List<RuleTemplate> getRuleTemplates() {
		if (_ruleTemplates != null) {
			return _ruleTemplates;
		}

		_ruleTemplates = (List<RuleTemplate>)_request.getAttribute(
			"ruleTemplates");

		return _ruleTemplates;
	}

	public UserSegment getUserSegment() {
		if (_userSegment != null) {
			return _userSegment;
		}

		long userSegmentId = getUserSegmentId();

		if (userSegmentId > 0) {
			_userSegment = UserSegmentLocalServiceUtil.fetchUserSegment(
				userSegmentId);
		}

		return _userSegment;
	}

	public long getUserSegmentId() {
		if (_userSegmentId != null) {
			return _userSegmentId;
		}

		_userSegmentId = ParamUtil.getLong(_request, "userSegmentId", 0);

		return _userSegmentId;
	}

	public String getUserSegmentTitle() {
		if (Validator.isNotNull(_userSegmentTitle)) {
			return _userSegmentTitle;
		}

		UserSegment userSegment = getUserSegment();

		if (userSegment == null) {
			_userSegmentTitle = StringPool.BLANK;

			return _userSegmentTitle;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Locale locale = themeDisplay.getLocale();

		_userSegmentTitle = userSegment.getName(locale);

		return _userSegmentTitle;
	}

	private List<RuleTemplate> _addedRuleTemplates;
	private String _cssItemsClass;
	private String _redirect;
	private final RenderResponse _renderResponse;
	private final HttpServletRequest _request;
	private RuleCategoriesRegistry _ruleCategoriesRegistry;
	private List<RuleTemplate> _ruleTemplates;
	private UserSegment _userSegment;
	private Long _userSegmentId;
	private String _userSegmentTitle;

}