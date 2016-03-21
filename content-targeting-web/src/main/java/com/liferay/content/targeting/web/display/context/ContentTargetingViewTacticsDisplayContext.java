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
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.content.targeting.util.BaseModelSearchResult;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.web.util.comparator.TacticModifiedDateComparator;
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
public class ContentTargetingViewTacticsDisplayContext
	extends BaseContentTargetingViewDisplayContext {

	public ContentTargetingViewTacticsDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);
	}

	public String getBackURL() {
		String backURL = ParamUtil.getString(request, "backURL");

		if (Validator.isNotNull(backURL)) {
			return backURL;
		}

		PortletURL backURLObject = liferayPortletResponse.createRenderURL();

		backURLObject.setParameter("mvcPath", "/view.jsp");
		backURLObject.setParameter("tabs1", "campaigns");

		return backURLObject.toString();
	}

	public Campaign getCampaign() {
		if (_campaign != null) {
			return _campaign;
		}

		long campaignId = getCampaignId();

		if (campaignId > 0) {
			_campaign = CampaignLocalServiceUtil.fetchCampaign(campaignId);
		}

		return _campaign;
	}

	public long getCampaignId() {
		if (_campaignId != null) {
			return _campaignId;
		}

		_campaignId = ParamUtil.getLong(request, "campaignId", 0);

		return _campaignId;
	}

	public String getCampaignTitle() {
		if (Validator.isNotNull(_campaignTitle)) {
			return _campaignTitle;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Campaign campaign = getCampaign();

		if (campaign != null) {
			_campaignTitle = campaign.getName(themeDisplay.getLocale());
		}

		return _campaignTitle;
	}

	public PortletURL getPortletURL() {
		PortletURL portletURL = liferayPortletResponse.createRenderURL();

		portletURL.setParameter(
			"mvcRenderCommandName", ContentTargetingMVCCommand.VIEW_TACTICS);
		portletURL.setParameter("className", Campaign.class.getName());
		portletURL.setParameter("classPK", String.valueOf(getCampaignId()));
		portletURL.setParameter("campaignId", String.valueOf(getCampaignId()));

		return portletURL;
	}

	public SearchContainer getTacticSearchContainer() throws PortalException {
		if (_tacticSearchContainer != null) {
			return _tacticSearchContainer;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		SearchContainer tacticsSearchContainer = new SearchContainer(
			liferayPortletRequest, getPortletURL(), null,
			"no-promotions-were-found");

		tacticsSearchContainer.setId("tactics");
		tacticsSearchContainer.setRowChecker(
			new EmptyOnClickRowChecker(liferayPortletResponse));
		tacticsSearchContainer.setSearch(Validator.isNotNull(getKeywords()));

		String orderByType = getOrderByType();

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<Tactic> orderByComparator =
			new TacticModifiedDateComparator(orderByAsc);

		tacticsSearchContainer.setOrderByCol(getOrderByCol());
		tacticsSearchContainer.setOrderByComparator(orderByComparator);
		tacticsSearchContainer.setOrderByType(orderByType);

		if (Validator.isNotNull(getKeywords())) {
			Sort sort = new Sort(
				Field.MODIFIED_DATE, Sort.LONG_TYPE, orderByAsc);

			BaseModelSearchResult<Tactic> searchResults =
				TacticLocalServiceUtil.searchTactics(
					getCampaignId(), themeDisplay.getScopeGroupId(),
					getKeywords(), tacticsSearchContainer.getStart(),
					tacticsSearchContainer.getEnd(), sort);

			tacticsSearchContainer.setTotal(searchResults.getLength());
			tacticsSearchContainer.setResults(searchResults.getBaseModels());
		}
		else {
			int total = TacticLocalServiceUtil.getTacticsCount(getCampaignId());

			tacticsSearchContainer.setTotal(total);

			List results = TacticLocalServiceUtil.getTactics(
				getCampaignId(), tacticsSearchContainer.getStart(),
				tacticsSearchContainer.getEnd(),
				tacticsSearchContainer.getOrderByComparator());

			tacticsSearchContainer.setResults(results);
		}

		_tacticSearchContainer = tacticsSearchContainer;

		return _tacticSearchContainer;
	}

	public boolean hasUpdatePermission() {
		if (_hasUpdatePermission != null) {
			return _hasUpdatePermission;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (getCampaign() != null) {
			_hasUpdatePermission = CampaignPermission.contains(
				themeDisplay.getPermissionChecker(), getCampaign(),
				ActionKeys.UPDATE);
		}
		else {
			_hasUpdatePermission = false;
		}

		return _hasUpdatePermission;
	}

	public boolean isDisabledManagementBar()
		throws PortalException, PortletException {

		if (_isDisabledManagementBar != null) {
			return _isDisabledManagementBar;
		}

		SearchContainer tacticSearchContainer = getTacticSearchContainer();

		_isDisabledManagementBar = true;

		if (tacticSearchContainer.getTotal() > 0) {
			_isDisabledManagementBar = false;
		}

		if (Validator.isNotNull(getKeywords())) {
			_isDisabledManagementBar = false;
		}

		return _isDisabledManagementBar;
	}

	public boolean isIncludeCheckbox() {
		if (hasUpdatePermission()) {
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
		if (hasUpdatePermission()) {
			return true;
		}

		return false;
	}

	private Campaign _campaign;
	private Long _campaignId;
	private String _campaignTitle;
	private Boolean _hasUpdatePermission;
	private Boolean _isDisabledManagementBar;
	private Boolean _isSearchEnabled;
	private SearchContainer _tacticSearchContainer;

}