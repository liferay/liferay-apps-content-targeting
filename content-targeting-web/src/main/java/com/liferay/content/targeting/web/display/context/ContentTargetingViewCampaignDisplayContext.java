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
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.CampaignConstants;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingViewCampaignDisplayContext
	extends BaseContentTargetingCampaignDisplayContext {

	public ContentTargetingViewCampaignDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse, null);
	}

	public ContentTargetingViewCampaignDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		UserSegmentLocalService userSegmentLocalService) {

		super(
			liferayPortletRequest, liferayPortletResponse,
			userSegmentLocalService);
	}

	@Override
	public long getCampaignId() {
		if (_campaignId != null) {
			return _campaignId;
		}

		if (Validator.equals(getTabs1(), "reports")) {
			_campaignId = ParamUtil.getLong(request, "classPK");
		}
		else {
			_campaignId = ParamUtil.getLong(request, "campaignId");
		}

		return _campaignId;
	}

	public long getClassPK() {
		if (_classPK != null) {
			return _classPK;
		}

		if (Validator.equals(getTabs1(), "reports")) {
			_classPK = ParamUtil.getLong(request, "classPK");
		}
		else {
			_classPK = ParamUtil.getLong(request, "campaignId");
		}

		return _classPK;
	}

	public String getReportsURL() {
		if (Validator.isNotNull(_reportsURL)) {
			return _reportsURL;
		}

		PortletURL reportsURL = liferayPortletResponse.createRenderURL();

		reportsURL.setParameter(
			"mvcRenderCommandName",
			ContentTargetingMVCCommand.VIEW_REPORTS_CAMPAIGN);
		reportsURL.setParameter("tabs1", "reports");
		reportsURL.setParameter(
			"classNameId",
			String.valueOf(
				PortalUtil.getClassNameId(Campaign.class.getName())));
		reportsURL.setParameter("classPK", String.valueOf(getClassPK()));
		reportsURL.setParameter("viewType", CampaignConstants.VIEW_TYPE);

		_reportsURL = reportsURL.toString();

		return _reportsURL;
	}

	public String getSummaryURL() {
		if (Validator.isNotNull(_summaryURL)) {
			return _summaryURL;
		}

		PortletURL summaryURL = liferayPortletResponse.createRenderURL();

		summaryURL.setParameter(
			"mvcRenderCommandName", ContentTargetingMVCCommand.VIEW_CAMPAIGN);
		summaryURL.setParameter("tabs1", "summary");
		summaryURL.setParameter("campaignId", String.valueOf(getCampaignId()));

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

	private Long _campaignId;
	private Long _classPK;
	private Boolean _isDisabledReportsManagementBar;
	private String _reportsURL;
	private String _summaryURL;
	private String _tabs1;

}