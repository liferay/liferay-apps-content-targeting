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
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class BaseContentTargetingUserSegmentDisplayContext {

	public BaseContentTargetingUserSegmentDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		this.liferayPortletRequest = liferayPortletRequest;
		this.liferayPortletResponse = liferayPortletResponse;

		this.request = PortalUtil.getHttpServletRequest(liferayPortletRequest);
	}

	public String getBackURL() {
		String backURL = ParamUtil.getString(request, "backURL");

		if (Validator.isNotNull(backURL)) {
			return backURL;
		}

		PortletURL backURLObject = liferayPortletResponse.createRenderURL();

		backURLObject.setParameter("mvcPath", "/view.jsp");
		backURLObject.setParameter("tabs1", "user-segments");

		return backURLObject.toString();
	}

	public RuleCategoriesRegistry getRuleCategoriesRegistry() {
		if (_ruleCategoriesRegistry != null) {
			return _ruleCategoriesRegistry;
		}

		_ruleCategoriesRegistry = (RuleCategoriesRegistry)request.getAttribute(
			"ruleCategoriesRegistry");

		return _ruleCategoriesRegistry;
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

		_userSegmentId = ParamUtil.getLong(request, "userSegmentId", 0);

		return _userSegmentId;
	}

	public String getUserSegmentTitle() {
		if (Validator.isNotNull(_userSegmentTitle)) {
			return _userSegmentTitle;
		}

		UserSegment userSegment = getUserSegment();

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (userSegment != null) {
			_userSegmentTitle = userSegment.getName(themeDisplay.getLocale());
		}
		else {
			PortletConfig portletConfig =
				(PortletConfig)liferayPortletRequest.getAttribute(
					JavaConstants.JAVAX_PORTLET_CONFIG);

			_userSegmentTitle = LanguageUtil.get(
				portletConfig.getResourceBundle(themeDisplay.getLocale()),
				"new-user-segment");
		}

		return _userSegmentTitle;
	}

	protected final LiferayPortletRequest liferayPortletRequest;
	protected final LiferayPortletResponse liferayPortletResponse;
	protected final HttpServletRequest request;

	private RuleCategoriesRegistry _ruleCategoriesRegistry;
	private UserSegment _userSegment;
	private Long _userSegmentId;
	private String _userSegmentTitle;

}