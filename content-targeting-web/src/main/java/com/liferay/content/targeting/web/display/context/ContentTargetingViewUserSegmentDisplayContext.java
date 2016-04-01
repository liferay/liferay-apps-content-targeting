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

		boolean orderByAsc = false;

		String orderByType = getOrderByType();

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<UserSegment> orderByComparator =
			new UserSegmentModifiedDateComparator(orderByAsc);

		userSegmentSearchContainer.setOrderByCol(getOrderByCol());
		userSegmentSearchContainer.setOrderByComparator(orderByComparator);
		userSegmentSearchContainer.setOrderByType(orderByType);

		if (Validator.isNotNull(getKeywords())) {
			Sort sort = new Sort(
				Field.MODIFIED_DATE, Sort.LONG_TYPE, orderByAsc);

			BaseModelSearchResult<UserSegment> searchResults =
				UserSegmentLocalServiceUtil.searchUserSegments(
					themeDisplay.getScopeGroupId(), getKeywords(),
					userSegmentSearchContainer.getStart(),
					userSegmentSearchContainer.getEnd(), sort);

			userSegmentSearchContainer.setTotal(searchResults.getLength());
			userSegmentSearchContainer.setResults(
				searchResults.getBaseModels());
		}
		else {
			if (showAddButton()) {
				userSegmentSearchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			}

			int total = UserSegmentLocalServiceUtil.getUserSegmentsCount(
				themeDisplay.getScopeGroupId());

			userSegmentSearchContainer.setTotal(total);

			List results = UserSegmentLocalServiceUtil.getUserSegments(
				themeDisplay.getScopeGroupId(),
				userSegmentSearchContainer.getStart(),
				userSegmentSearchContainer.getEnd(),
				userSegmentSearchContainer.getOrderByComparator());

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

	private static final String[] _USER_SEGMENTS_DISPLAY_VIEWS =
		new String[] {"descriptive", "icon", "list"};

	private Boolean _isDisabledManagementBar;
	private Boolean _isIncludeCheckBox;
	private Boolean _isSearchEnabled;
	private Boolean _showAddButton;
	private SearchContainer _userSegmentSearchContainer;

}