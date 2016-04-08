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
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.permission.ContentTargetingPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.content.targeting.util.BaseModelSearchResult;
import com.liferay.content.targeting.web.util.comparator.CampaignCreateDateComparator;
import com.liferay.content.targeting.web.util.comparator.CampaignModifiedDateComparator;
import com.liferay.content.targeting.web.util.comparator.CampaignPriorityComparator;
import com.liferay.content.targeting.web.util.comparator.CampaignStartDateComparator;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
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
public class ContentTargetingViewCampaignDisplayContext
	extends BaseContentTargetingViewDisplayContext {

	public ContentTargetingViewCampaignDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);
	}

	public SearchContainer getCampaignSearchContainer()
		throws PortalException, PortletException {

		if (_campaignSearchContainer != null) {
			return _campaignSearchContainer;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		SearchContainer campaignSearchContainer = new SearchContainer(
			liferayPortletRequest,
			PortletURLUtil.clone(getPortletURL(), liferayPortletResponse), null,
			"no-campaigns-were-found");

		campaignSearchContainer.setId("campaigns");
		campaignSearchContainer.setRowChecker(
			new EmptyOnClickRowChecker(liferayPortletResponse));
		campaignSearchContainer.setSearch(Validator.isNotNull(getKeywords()));

		if (Validator.isNotNull(getKeywords())) {
			Sort sort = null;

			if (isNavigationRecent()) {
				sort = new Sort(
					Field.MODIFIED_DATE, Sort.LONG_TYPE, isOrderByAsc());
			}
			else {
				sort = new Sort(Field.CREATE_DATE, Sort.LONG_TYPE, false);
			}

			BaseModelSearchResult<Campaign> searchResults = null;

			if (isNavigationMine()) {
				searchResults = CampaignLocalServiceUtil.searchCampaigns(
					themeDisplay.getScopeGroupId(), getKeywords(),
					campaignSearchContainer.getStart(),
					campaignSearchContainer.getEnd(), sort);
			}
			else {
				searchResults = CampaignLocalServiceUtil.searchCampaigns(
					themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
					getKeywords(), campaignSearchContainer.getStart(),
					campaignSearchContainer.getEnd(), sort);
			}

			campaignSearchContainer.setTotal(searchResults.getLength());
			campaignSearchContainer.setResults(searchResults.getBaseModels());
		}
		else {
			if (isNavigationRecent()) {
				OrderByComparator<Campaign> orderByComparator =
					new CampaignCreateDateComparator(false);

				campaignSearchContainer.setOrderByCol("create-date");
				campaignSearchContainer.setOrderByComparator(orderByComparator);
				campaignSearchContainer.setOrderByType("desc");
			}
			else {
				OrderByComparator<Campaign> orderByComparator = null;

				if (Validator.equals(getOrderByCol(), "modified-date")) {
					orderByComparator = new CampaignModifiedDateComparator(
						isOrderByAsc());
				}
				else if (Validator.equals(getOrderByCol(), "priority")) {
					orderByComparator = new CampaignPriorityComparator(
						isOrderByAsc());
				}
				else if (Validator.equals(getOrderByCol(), "start-date")) {
					orderByComparator = new CampaignStartDateComparator(
						isOrderByAsc());
				}

				campaignSearchContainer.setOrderByCol(getOrderByCol());
				campaignSearchContainer.setOrderByComparator(orderByComparator);
				campaignSearchContainer.setOrderByType(getOrderByType());
			}

			if (showAddButton()) {
				campaignSearchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			}

			int total = CampaignLocalServiceUtil.getCampaignsCount(
				themeDisplay.getScopeGroupId());

			campaignSearchContainer.setTotal(total);

			List<Campaign> results = null;

			if (isNavigationMine()) {
				results = CampaignLocalServiceUtil.getCampaigns(
					themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
					campaignSearchContainer.getStart(),
					campaignSearchContainer.getEnd(),
					campaignSearchContainer.getOrderByComparator());
			}
			else {
				results = CampaignLocalServiceUtil.getCampaigns(
					themeDisplay.getScopeGroupId(),
					campaignSearchContainer.getStart(),
					campaignSearchContainer.getEnd(),
					campaignSearchContainer.getOrderByComparator());
			}

			campaignSearchContainer.setResults(results);
		}

		_campaignSearchContainer = campaignSearchContainer;

		return _campaignSearchContainer;
	}

	@Override
	public String[] getDisplayViews() {
		return _CAMPAIGN_DISPLAY_VIEWS;
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
		portletURL.setParameter("tabs1", "campaigns");

		if (Validator.isNotNull(getKeywords())) {
			portletURL.setParameter("keywords", getKeywords());
		}

		return portletURL;
	}

	public boolean isDisabledManagementBar()
		throws PortalException, PortletException {

		if (_isDisabledManagementBar != null) {
			return _isDisabledManagementBar;
		}

		SearchContainer campaignSearchContainer = getCampaignSearchContainer();

		_isDisabledManagementBar = (campaignSearchContainer.getTotal() <= 0) &&
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
			ActionKeys.DELETE_CAMPAIGN);

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
			ActionKeys.ADD_CAMPAIGN);

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

	private static final String[] _CAMPAIGN_DISPLAY_VIEWS =
		new String[] {"descriptive", "list"};

	private SearchContainer _campaignSearchContainer;
	private Boolean _isDisabledManagementBar;
	private Boolean _isIncludeCheckBox;
	private Boolean _isSearchEnabled;
	private String _navigation;
	private Boolean _showAddButton;

}