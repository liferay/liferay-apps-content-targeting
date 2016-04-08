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

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.service.permission.UserSegmentPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.content.targeting.util.BaseModelSearchResult;
import com.liferay.content.targeting.util.CampaignConstants;
import com.liferay.content.targeting.util.UserSegmentConstants;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.web.util.ReportInstanceRowChecker;
import com.liferay.content.targeting.web.util.comparator.ReportInstanceCreateDateComparator;
import com.liferay.content.targeting.web.util.comparator.ReportInstanceModifiedDateComparator;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PredicateFilter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Collection;
import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingViewReportsDisplayContext
	extends BaseContentTargetingViewDisplayContext {

	public ContentTargetingViewReportsDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);
	}

	public PortletURL getAddReportURL() {
		PortletURL addReportURL = liferayPortletResponse.createRenderURL();

		addReportURL.setParameter(
			"mvcRenderCommandName", ContentTargetingMVCCommand.EDIT_REPORT);

		if (getClassName().equals(Campaign.class.getName())) {
			addReportURL.setParameter("viewType", CampaignConstants.VIEW_TYPE);
		}
		else {
			addReportURL.setParameter(
				"viewType", UserSegmentConstants.VIEW_TYPE);
		}

		addReportURL.setParameter(
			"classNameId", String.valueOf(getClassNameId()));
		addReportURL.setParameter("classPK", String.valueOf(getClassPK()));

		return addReportURL;
	}

	public String getBackURL() {
		String backURL = ParamUtil.getString(request, "backURL");

		if (Validator.isNotNull(backURL)) {
			return backURL;
		}

		PortletURL backURLObject = liferayPortletResponse.createRenderURL();

		backURLObject.setParameter("mvcPath", "/view.jsp");

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

		_className = PortalUtil.getClassName(getClassNameId());

		return _className;
	}

	public long getClassNameId() {
		if (Validator.isNotNull(_classNameId)) {
			return _classNameId;
		}

		_classNameId = ParamUtil.getLong(request, "classNameId");

		return _classNameId;
	}

	public Long getClassPK() {
		if (_classPK != null) {
			return _classPK;
		}

		_classPK = ParamUtil.getLong(request, "classPK");

		return _classPK;
	}

	@Override
	public String[] getDisplayViews() {
		return _REPORTS_DISPLAY_VIEWS;
	}

	public String getNavigation() {
		if (_navigation != null) {
			return _navigation;
		}

		_navigation = ParamUtil.getString(
			liferayPortletRequest, "navigation", "all");

		return _navigation;
	}

	public PortletURL getPortletURL() {
		String className = getClassName();

		PortletURL portletURL = liferayPortletResponse.createRenderURL();

		portletURL.setParameter("backURL", getBackURL());
		portletURL.setParameter("redirect", getRedirect());

		if (className.equals(Campaign.class.getName())) {
			portletURL.setParameter(
				"mvcRenderCommandName",
				ContentTargetingMVCCommand.VIEW_REPORTS_CAMPAIGN);
			portletURL.setParameter("viewType", CampaignConstants.VIEW_TYPE);
		}
		else if (className.equals(UserSegment.class.getName())) {
			portletURL.setParameter(
				"mvcRenderCommandName",
				ContentTargetingMVCCommand.VIEW_REPORTS_USER_SEGMENT);
			portletURL.setParameter("viewType", UserSegmentConstants.VIEW_TYPE);
		}
		else {
			portletURL.setParameter("mvcPath", "/view_reports.jsp");
		}

		portletURL.setParameter(
			"classNameId", String.valueOf(getClassNameId()));
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

		_redirect = ParamUtil.getString(request, "redirect");

		return _redirect;
	}

	public List<Report> getReports() {
		if (_reports != null) {
			return _reports;
		}

		_reports = (List<Report>)request.getAttribute("reports");

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
		if (_reportsSearchContainer != null) {
			return _reportsSearchContainer;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		SearchContainer reportsSearchContainer = new SearchContainer(
			liferayPortletRequest, getPortletURL(), null,
			"no-reports-were-found");

		reportsSearchContainer.setId("reports");
		reportsSearchContainer.setRowChecker(
			new ReportInstanceRowChecker(liferayPortletResponse));
		reportsSearchContainer.setSearch(true);

		if (Validator.isNotNull(getKeywords())) {
			Sort sort = null;

			if (isNavigationRecent()) {
				sort = new Sort(
					Field.MODIFIED_DATE, Sort.LONG_TYPE, isOrderByAsc());
			}
			else {
				sort = new Sort(Field.CREATE_DATE, Sort.LONG_TYPE, false);
			}

			BaseModelSearchResult<ReportInstance> searchResults = null;

			if (isNavigationMine()) {
				searchResults =
					ReportInstanceLocalServiceUtil.searchReportInstances(
						getScopeGroupId(), themeDisplay.getUserId(),
						getClassName(), getClassPK(), getKeywords(),
						reportsSearchContainer.getStart(),
						reportsSearchContainer.getEnd(), sort);
			}
			else {
				searchResults =
					ReportInstanceLocalServiceUtil.searchReportInstances(
						getScopeGroupId(), getClassName(), getClassPK(),
						getKeywords(), reportsSearchContainer.getStart(),
						reportsSearchContainer.getEnd(), sort);
			}

			reportsSearchContainer.setTotal(searchResults.getLength());
			reportsSearchContainer.setResults(searchResults.getBaseModels());
		}
		else {
			if (isNavigationRecent()) {
				OrderByComparator<ReportInstance> orderByComparator =
					new ReportInstanceCreateDateComparator(false);

				reportsSearchContainer.setOrderByCol("create-date");
				reportsSearchContainer.setOrderByComparator(orderByComparator);
				reportsSearchContainer.setOrderByType("desc");
			}
			else {
				OrderByComparator<ReportInstance> orderByComparator =
					new ReportInstanceModifiedDateComparator(isOrderByAsc());

				reportsSearchContainer.setOrderByCol(getOrderByCol());
				reportsSearchContainer.setOrderByComparator(orderByComparator);
				reportsSearchContainer.setOrderByType(getOrderByType());
			}

			if (showAddButton()) {
				reportsSearchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			}

			int total = ReportInstanceLocalServiceUtil.getReportInstancesCount(
				getClassName(), getClassPK());

			reportsSearchContainer.setTotal(total);

			List results = null;

			if (isNavigationMine()) {
				results = ReportInstanceLocalServiceUtil.getReportInstances(
					themeDisplay.getUserId(), getClassName(), getClassPK(),
					reportsSearchContainer.getStart(),
					reportsSearchContainer.getEnd(),
					reportsSearchContainer.getOrderByComparator());
			}
			else {
				results = ReportInstanceLocalServiceUtil.getReportInstances(
					getClassName(), getClassPK(),
					reportsSearchContainer.getStart(),
					reportsSearchContainer.getEnd(),
					reportsSearchContainer.getOrderByComparator());
			}

			reportsSearchContainer.setResults(results);
		}

		_reportsSearchContainer = reportsSearchContainer;

		return _reportsSearchContainer;
	}

	public String getReportsTitle() {
		if (Validator.isNotNull(_reportsTitle)) {
			return _reportsTitle;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletConfig portletConfig =
			(PortletConfig)liferayPortletRequest.getAttribute(
				JavaConstants.JAVAX_PORTLET_CONFIG);

		_reportsTitle = LanguageUtil.get(
			portletConfig.getResourceBundle(themeDisplay.getLocale()),
			"reports");

		return _reportsTitle;
	}

	public long getScopeGroupId() {
		if (_scopeGroupId != null) {
			return _scopeGroupId;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_scopeGroupId = themeDisplay.getScopeGroupId();

		return _scopeGroupId;
	}

	public boolean hasReports() {
		if (getClassPK() > 0) {
			return true;
		}

		return false;
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

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
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

	public boolean isNavigationMine() {
		if (Validator.equals(getNavigation(), "mine")) {
			return true;
		}

		return false;
	}

	public boolean isNavigationRecent() {
		if (Validator.equals(getNavigation(), "recent")) {
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

	protected boolean isOrderByAsc() {
		String orderByType = getOrderByType();

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		return orderByAsc;
	}

	private static final String[] _REPORTS_DISPLAY_VIEWS =
		new String[] {"descriptive", "list"};

	private String _className;
	private Long _classNameId;
	private Long _classPK;
	private Boolean _hasUpdatePermission;
	private Boolean _isDisabledManagementBar;
	private String _navigation;
	private String _redirect;
	private List<Report> _reports;
	private SearchContainer _reportsSearchContainer;
	private String _reportsTitle;
	private Long _scopeGroupId;

}