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

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService;
import com.liferay.content.targeting.util.UserSegmentConstants;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingViewUserSegmentDisplayContext
	extends BaseContentTargetingUserSegmentDisplayContext {

	public ContentTargetingViewUserSegmentDisplayContext(
		AnonymousUserUserSegmentLocalService
			anonymousUserUserSegmentLocalService,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);

		_anonymousUserUserSegmentLocalService =
			anonymousUserUserSegmentLocalService;
	}

	public ContentTargetingViewUserSegmentDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);

		_anonymousUserUserSegmentLocalService = null;
	}

	public long getClassPK() {
		if (_classPK != null) {
			return _classPK;
		}

		if (Validator.equals(getTabs1(), "reports")) {
			_classPK = ParamUtil.getLong(request, "classPK");
		}
		else {
			_classPK = ParamUtil.getLong(request, "userSegmentId");
		}

		return _classPK;
	}

	public String getDescription() {
		if (Validator.isNotNull(_description)) {
			return _description;
		}

		UserSegment userSegment = getUserSegment();

		if (userSegment != null) {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			_description = userSegment.getDescription(themeDisplay.getLocale());
		}

		return _description;
	}

	public String getReportsURL() {
		if (Validator.isNotNull(_reportsURL)) {
			return _reportsURL;
		}

		PortletURL reportsURL = liferayPortletResponse.createRenderURL();

		reportsURL.setParameter(
			"mvcRenderCommandName",
			ContentTargetingMVCCommand.VIEW_REPORTS_USER_SEGMENT);
		reportsURL.setParameter("tabs1", "reports");
		reportsURL.setParameter(
			"classNameId",
			String.valueOf(
				PortalUtil.getClassNameId(UserSegment.class.getName())));
		reportsURL.setParameter("classPK", String.valueOf(getClassPK()));
		reportsURL.setParameter("viewType", UserSegmentConstants.VIEW_TYPE);

		_reportsURL = reportsURL.toString();

		return _reportsURL;
	}

	public String getSummaryURL() {
		if (Validator.isNotNull(_summaryURL)) {
			return _summaryURL;
		}

		PortletURL summaryURL = liferayPortletResponse.createRenderURL();

		summaryURL.setParameter(
			"mvcRenderCommandName",
			ContentTargetingMVCCommand.VIEW_USER_SEGMENT);
		summaryURL.setParameter("tabs1", "summary");
		summaryURL.setParameter(
			"userSegmentId", String.valueOf(getUserSegmentId()));

		_summaryURL = summaryURL.toString();

		return _summaryURL;
	}

	public String getTabs1() {
		if (Validator.isNotNull(_tabs1)) {
			return _tabs1;
		}

		_tabs1 = ParamUtil.getString(request, "tabs1", "summary");

		return _tabs1;
	}

	@Override
	public long getUserSegmentId() {
		if (_userSegmentId != null) {
			return _userSegmentId;
		}

		if (Validator.equals(getTabs1(), "reports")) {
			_userSegmentId = ParamUtil.getLong(request, "classPK");
		}
		else {
			_userSegmentId = ParamUtil.getLong(request, "userSegmentId");
		}

		return _userSegmentId;
	}

	public int getUsersNumber() throws PortalException {
		if (_usersNumber != null) {
			return _usersNumber;
		}

		if (_anonymousUserUserSegmentLocalService != null) {
			_usersNumber =
				_anonymousUserUserSegmentLocalService.
					getAnonymousUsersByUserSegmentIdCount(
						getUserSegmentId(), true);
		}
		else {
			_usersNumber = 0;
		}

		return _usersNumber;
	}

	public boolean isDisabledReportsManagementBar()
		throws PortalException, PortletException {

		if (_isDisabledReportsManagementBar != null) {
			return _isDisabledReportsManagementBar;
		}

		ContentTargetingViewReportsDisplayContext
			contentTargetingViewReportsDisplayContext =
				new ContentTargetingViewReportsDisplayContext(
					liferayPortletRequest, liferayPortletResponse);

		_isDisabledReportsManagementBar = false;

		if (isShowReports() &&
			!contentTargetingViewReportsDisplayContext.isDisabledManagementBar(
				)) {

			_isDisabledReportsManagementBar = true;
		}

		return _isDisabledReportsManagementBar;
	}

	public boolean isShowReports() {
		if (Validator.equals(getTabs1(), "reports")) {
			return true;
		}

		return false;
	}

	public boolean isShowSummary() {
		if (Validator.equals(getTabs1(), "summary")) {
			return true;
		}

		return false;
	}

	private final AnonymousUserUserSegmentLocalService
		_anonymousUserUserSegmentLocalService;
	private Long _classPK;
	private String _description;
	private Boolean _isDisabledReportsManagementBar;
	private String _reportsURL;
	private String _summaryURL;
	private String _tabs1;
	private Long _userSegmentId;
	private Integer _usersNumber;

}