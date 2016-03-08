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

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.portlet.util.ReportInstanceRowChecker;
import com.liferay.content.targeting.portlet.util.comparator.ReportInstanceModifiedDateComparator;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.service.permission.UserSegmentPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.content.targeting.util.BaseModelSearchResult;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PredicateFilter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Collection;
import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingViewReportsDisplayContext {

	public ContentTargetingViewReportsDisplayContext(
		PortletConfig portletConfig, RenderRequest renderRequest,
		RenderResponse renderResponse, HttpServletRequest request) {

		_portletConfig = portletConfig;
		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_request = request;
	}

	public PortletURL getAddReportURL() {
		ThemeDisplay themeDisplay = (ThemeDisplay) _request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL addReportURL = _renderResponse.createRenderURL();

		addReportURL.setParameter(
			"mvcRenderCommandName", ContentTargetingMVCCommand.EDIT_REPORT);
		addReportURL.setParameter("redirect", themeDisplay.getURLCurrent());

		if (getClassName().equals(Campaign.class.getName())) {
			addReportURL.setParameter(
				"campaignId", String.valueOf(getClassPK()));
		}
		else {
			addReportURL.setParameter(
				"userSegmentId", String.valueOf(getClassPK()));
		}

		addReportURL.setParameter("className", getClassName());
		addReportURL.setParameter("classPK", String.valueOf(getClassPK()));

		return addReportURL;
	}

	public String getBackURL() {
		String backURL = ParamUtil.getString(_request, "backURL");

		if (Validator.isNotNull(backURL)) {
			return backURL;
		}

		PortletURL backURLObject = _renderResponse.createRenderURL();

		backURLObject.setParameter("mvcPath", ContentTargetingPath.VIEW);

		if (getClassName().equals(Campaign.class.getName())) {
			backURLObject.setParameter("tabs1", "campaigns");
		}
		else {
			backURLObject.setParameter("tabs1", "user-segments");
		}

		return backURLObject.toString();
	}

	public String getClassName() {
		if (Validator.isNotNull(_className)) {
			return _className;
		}

		_className = ParamUtil.getString(_request, "className");

		return _className;
	}

	public Long getClassPK() {
		if (_classPK != null) {
			return _classPK;
		}

		_classPK = ParamUtil.getLong(_request, "classPK");

		return _classPK;
	}

	public String getDisplayStyle() {
		if (Validator.isNotNull(_displayStyle)) {
			return _displayStyle;
		}

		_displayStyle = ParamUtil.getString(_request, "displayStyle", "list");

		return _displayStyle;
	}

	public String getKeywords() {
		if (Validator.isNotNull(_keywords)) {
			return _keywords;
		}

		_keywords = ParamUtil.getString(_request, "keywords");

		return _keywords;
	}

	public String getOrderByCol() {
		if (Validator.isNotNull(_orderByCol)) {
			return _orderByCol;
		}

		_orderByCol = ParamUtil.getString(
			_request, "orderByCol", "modified-date");

		return _orderByCol;
	}

	public String getOrderByType() {
		if (Validator.isNotNull(_orderByType)) {
			return _orderByType;
		}

		_orderByType = ParamUtil.getString(_request, "orderByType", "asc");

		return _orderByType;
	}

	public PortletURL getPortletURL() {
		String className = getClassName();

		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter("backURL", getBackURL());
		portletURL.setParameter("redirect", getRedirect());

		if (className.equals(Campaign.class.getName())) {
			portletURL.setParameter(
				"mvcRenderCommandName",
				ContentTargetingMVCCommand.VIEW_REPORTS_CAMPAIGN);
			portletURL.setParameter("campaignId", String.valueOf(getClassPK()));
		}
		else if (className.equals(UserSegment.class.getName())) {
			portletURL.setParameter(
				"mvcRenderCommandName",
				ContentTargetingMVCCommand.VIEW_REPORTS_USER_SEGMENT);
			portletURL.setParameter(
				"userSegmentId", String.valueOf(getClassPK()));
		}
		else {
			portletURL.setParameter(
				"mvcPath", ContentTargetingPath.VIEW_REPORTS);
		}

		portletURL.setParameter("className", className);
		portletURL.setParameter("classPK", String.valueOf(getClassPK()));

		if (Validator.isNotNull(getKeywords())) {
			portletURL.setParameter("keywords", getKeywords());
		}

		return portletURL;
	}

	public String getRedirect() {
		if (Validator.isNotNull(_redirect)) {
			return _redirect;
		}

		_redirect = ParamUtil.getString(_request, "redirect");

		return _redirect;
	}

	public List<Report> getReports() {
		if (_reports != null) {
			return _reports;
		}

		_reports = (List<Report>)_request.getAttribute("reports");

		_reports = ListUtil.filter(
			_reports,
			new PredicateFilter<Report>() {

				@Override
				public boolean filter(Report report) {
					return report.isInstantiable();
				}

			});

		return _reports;
	}

	public SearchContainer getReportsSearchContainer() throws PortalException {
		SearchContainer reportsSearchContainer = new SearchContainer(
			_renderRequest, getPortletURL(), null, "no-reports-were-found");

		reportsSearchContainer.setId("reports");
		reportsSearchContainer.setRowChecker(
			new ReportInstanceRowChecker(_renderResponse));
		reportsSearchContainer.setSearch(true);

		boolean orderByAsc = false;

		String orderByType = getOrderByType();

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<ReportInstance> orderByComparator =
			new ReportInstanceModifiedDateComparator(orderByAsc);

		reportsSearchContainer.setOrderByCol(getOrderByCol());
		reportsSearchContainer.setOrderByComparator(orderByComparator);
		reportsSearchContainer.setOrderByType(orderByType);

		if (Validator.isNotNull(getKeywords())) {
			Sort sort = new Sort(
				Field.MODIFIED_DATE, Sort.LONG_TYPE, orderByAsc);

			BaseModelSearchResult<ReportInstance> searchResults =
				ReportInstanceLocalServiceUtil.searchReportInstances(
					getScopeGroupId(), getClassName(), getClassPK(),
					getKeywords(), reportsSearchContainer.getStart(),
					reportsSearchContainer.getEnd(), sort);

			reportsSearchContainer.setTotal(searchResults.getLength());
			reportsSearchContainer.setResults(searchResults.getBaseModels());
		}
		else {
			int total = ReportInstanceLocalServiceUtil.getReportInstancesCount(
				getClassName(), getClassPK());

			reportsSearchContainer.setTotal(total);

			List results = ReportInstanceLocalServiceUtil.getReportInstances(
				getClassName(), getClassPK(), reportsSearchContainer.getStart(),
				reportsSearchContainer.getEnd(),
				reportsSearchContainer.getOrderByComparator());

			reportsSearchContainer.setResults(results);
		}

		_reportsSearchContainer = reportsSearchContainer;

		return _reportsSearchContainer;
	}

	public String getReportsTitle() {
		if (Validator.isNotNull(_reportsTitle)) {
			return _reportsTitle;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_reportsTitle = LanguageUtil.get(
			_portletConfig.getResourceBundle(themeDisplay.getLocale()),
			"reports");

		return _reportsTitle;
	}

	public long getScopeGroupId() {
		if (_scopeGroupId != null) {
			return _scopeGroupId;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_scopeGroupId = themeDisplay.getScopeGroupId();

		return _scopeGroupId;
	}

	public boolean hasReports() {
		return getClassPK() > 0;
	}

	public Boolean hasUpdatePermission() throws PortalException {
		if (_hasUpdatePermission != null) {
			return _hasUpdatePermission;
		}

		boolean instantiableExists = false;

		Collection<Report> reports = getReports();

		for (Report report : reports) {
			if (report.isInstantiable()) {
				instantiableExists = true;

				break;
			}
		}

		boolean hasUpdatePermission = false;

		if (instantiableExists) {
			String className = getClassName();

			ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
				WebKeys.THEME_DISPLAY);

			PermissionChecker permissionChecker =
				themeDisplay.getPermissionChecker();

			if (className.equals(Campaign.class.getName()) &&
				CampaignPermission.contains(
					permissionChecker, getClassPK(), ActionKeys.UPDATE)) {

				hasUpdatePermission = true;
			}
			else if (className.equals(UserSegment.class.getName()) &&
					 UserSegmentPermission.contains(
						 permissionChecker, getClassPK(), ActionKeys.UPDATE)) {

				hasUpdatePermission = true;
			}
		}

		_hasUpdatePermission = hasUpdatePermission;

		return _hasUpdatePermission;
	}

	public boolean isDisabledManagementBar()
		throws PortalException, PortletException {

		if (_isDisabledManagementBar != null) {
			return _isDisabledManagementBar;
		}

		SearchContainer reportsSearchContainer = getReportsSearchContainer();

		_isDisabledManagementBar = (reportsSearchContainer.getTotal() <= 0) &&
			Validator.isNull(getKeywords());

		return _isDisabledManagementBar;
	}

	public boolean isIncludeCheckBox() throws PortalException {
		if (hasUpdatePermission()) {
			return true;
		}

		return false;
	}

	public boolean isStagingGroup() {
		long scopeGroupId = getScopeGroupId();

		Group scopeGroup = GroupLocalServiceUtil.fetchGroup(scopeGroupId);

		return scopeGroup.isStagingGroup();
	}

	public boolean showAddButton() throws PortalException {
		if (hasUpdatePermission()) {
			return true;
		}

		return false;
	}

	private String _className;
	private Long _classPK;
	private String _displayStyle;
	private Boolean _hasUpdatePermission;
	private Boolean _isDisabledManagementBar;
	private String _keywords;
	private String _orderByCol;
	private String _orderByType;
	private final PortletConfig _portletConfig;
	private String _redirect;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private List<Report> _reports;
	private SearchContainer _reportsSearchContainer;
	private String _reportsTitle;
	private final HttpServletRequest _request;
	private Long _scopeGroupId;

}