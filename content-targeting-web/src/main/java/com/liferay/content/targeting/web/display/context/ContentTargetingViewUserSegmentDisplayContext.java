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
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.content.targeting.service.permission.ContentTargetingPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.content.targeting.util.BaseModelSearchResult;
import com.liferay.content.targeting.web.util.comparator.UserSegmentCreateDateComparator;
import com.liferay.content.targeting.web.util.comparator.UserSegmentModifiedDateComparator;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingViewUserSegmentDisplayContext
	extends BaseContentTargetingViewDisplayContext {

	public ContentTargetingViewUserSegmentDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);
	}

	@Override
	public String[] getDisplayViews() {
		return _USER_SEGMENTS_DISPLAY_VIEWS;
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
		PortletURL portletURL = liferayPortletResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/view.jsp");
		portletURL.setParameter("tabs1", "user-segments");

		if (Validator.isNotNull(getKeywords())) {
			portletURL.setParameter("keywords", getKeywords());
		}

		return portletURL;
	}

	public SearchContainer getUserSegmentSearchContainer()
		throws PortalException {

		if (_userSegmentSearchContainer != null) {
			return _userSegmentSearchContainer;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		SearchContainer userSegmentSearchContainer = new SearchContainer(
			liferayPortletRequest, getPortletURL(), null,
			"no-user-segments-were-found");

		userSegmentSearchContainer.setId("userSegments");
		userSegmentSearchContainer.setRowChecker(
			new EmptyOnClickRowChecker(liferayPortletResponse));
		userSegmentSearchContainer.setSearch(
			Validator.isNotNull(getKeywords()));

		if (Validator.isNotNull(getKeywords())) {
			Sort sort = null;

			if (isNavigationRecent()) {
				sort = new Sort(
					Field.MODIFIED_DATE, Sort.LONG_TYPE, isOrderByAsc());
			}
			else {
				sort = new Sort(Field.CREATE_DATE, Sort.LONG_TYPE, false);
			}

			BaseModelSearchResult<UserSegment> searchResults = null;

			if (isNavigationMine()) {
				searchResults = UserSegmentLocalServiceUtil.searchUserSegments(
					themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
					getKeywords(), userSegmentSearchContainer.getStart(),
					userSegmentSearchContainer.getEnd(), sort);
			}
			else {
				searchResults = UserSegmentLocalServiceUtil.searchUserSegments(
					themeDisplay.getScopeGroupId(), getKeywords(),
					userSegmentSearchContainer.getStart(),
					userSegmentSearchContainer.getEnd(), sort);
			}

			userSegmentSearchContainer.setTotal(searchResults.getLength());
			userSegmentSearchContainer.setResults(
				searchResults.getBaseModels());
		}
		else {
			if (isNavigationRecent()) {
				OrderByComparator<UserSegment> orderByComparator =
					new UserSegmentCreateDateComparator(false);

				userSegmentSearchContainer.setOrderByCol("create-date");
				userSegmentSearchContainer.setOrderByComparator(
					orderByComparator);
				userSegmentSearchContainer.setOrderByType("desc");
			}
			else {
				OrderByComparator<UserSegment> orderByComparator =
					new UserSegmentModifiedDateComparator(isOrderByAsc());

				userSegmentSearchContainer.setOrderByCol(getOrderByCol());
				userSegmentSearchContainer.setOrderByComparator(
					orderByComparator);
				userSegmentSearchContainer.setOrderByType(getOrderByType());
			}

			if (showAddButton()) {
				userSegmentSearchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			}

			int total = UserSegmentLocalServiceUtil.getUserSegmentsCount(
				themeDisplay.getScopeGroupId());

			userSegmentSearchContainer.setTotal(total);

			List results = null;

			if (isNavigationMine()) {
				results = UserSegmentLocalServiceUtil.getUserSegments(
					themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
					userSegmentSearchContainer.getStart(),
					userSegmentSearchContainer.getEnd(),
					userSegmentSearchContainer.getOrderByComparator());
			}
			else {
				results = UserSegmentLocalServiceUtil.getUserSegments(
					themeDisplay.getScopeGroupId(),
					userSegmentSearchContainer.getStart(),
					userSegmentSearchContainer.getEnd(),
					userSegmentSearchContainer.getOrderByComparator());
			}

			userSegmentSearchContainer.setResults(results);
		}

		_userSegmentSearchContainer = userSegmentSearchContainer;

		return _userSegmentSearchContainer;
	}

	public boolean isDisabledManagementBar()
		throws PortalException, PortletException {

		if (_isDisabledManagementBar != null) {
			return _isDisabledManagementBar;
		}

		SearchContainer userSegmentSearchContainer =
			getUserSegmentSearchContainer();

		_isDisabledManagementBar =
			(userSegmentSearchContainer.getTotal() <= 0) &&
			 Validator.isNull(getKeywords());

		return _isDisabledManagementBar;
	}

	public boolean isIncludeCheckBox() {
		if (_isIncludeCheckBox != null) {
			return _isIncludeCheckBox;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_isIncludeCheckBox = ContentTargetingPermission.contains(
			themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(),
			ActionKeys.DELETE_USER_SEGMENT);

		return _isIncludeCheckBox;
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

	public boolean isSearchEnabled() throws PortalException, PortletException {
		if (_isSearchEnabled != null) {
			return _isSearchEnabled;
		}

		_isSearchEnabled = true;

		if (isDisabledManagementBar()) {
			_isSearchEnabled = false;
		}

		return _isSearchEnabled;
	}

	public boolean showAddButton() {
		if (_showAddButton != null) {
			return _showAddButton;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_showAddButton = ContentTargetingPermission.contains(
			themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(),
			ActionKeys.ADD_USER_SEGMENT);

		return _showAddButton;
	}

	protected boolean isOrderByAsc() {
		String orderByType = getOrderByType();

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		return orderByAsc;
	}

	private static final String[] _USER_SEGMENTS_DISPLAY_VIEWS =
		new String[] {"descriptive", "icon", "list"};

	private Boolean _isDisabledManagementBar;
	private Boolean _isIncludeCheckBox;
	private Boolean _isSearchEnabled;
	private String _navigation;
	private Boolean _showAddButton;
	private SearchContainer _userSegmentSearchContainer;

}