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

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.portlet.ContentTargetingMVCCommand;
import com.liferay.content.targeting.portlet.ContentTargetingPath;
import com.liferay.content.targeting.portlet.util.comparator.TacticModifiedDateComparator;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.content.targeting.service.permission.CampaignPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.content.targeting.util.BaseModelSearchResult;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jürgen Kappler
 */
public class ContentTargetingViewTacticsDisplayContext {

	public ContentTargetingViewTacticsDisplayContext(
		LiferayPortletResponse liferayPortletResponse,
		RenderRequest renderRequest, RenderResponse renderResponse,
		HttpServletRequest request) {

		_liferayPortletResponse = liferayPortletResponse;
		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_request = request;
	}

	public String getBackURL() {
		if (Validator.isNotNull(_backURL)) {
			return _backURL;
		}

		String backURL = ParamUtil.getString(_request, "backURL");

		if (Validator.isNull(backURL)) {
			PortletURL backURLObject =
				_liferayPortletResponse.createRenderURL();

			backURLObject.setParameter("mvcPath", ContentTargetingPath.VIEW);
			backURLObject.setParameter("tabs1", "campaigns");

			backURL = backURLObject.toString();
		}

		_backURL = backURL;

		return _backURL;
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

		_campaignId = ParamUtil.getLong(_request, "campaignId", 0);

		return _campaignId;
	}

	public String getCampaignTitle() {
		if (Validator.isNotNull(_campaignTitle)) {
			return _campaignTitle;
		}

		Campaign campaign = getCampaign();

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (campaign != null) {
			_campaignTitle = campaign.getName(themeDisplay.getLocale());
		}

		return _campaignTitle;
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
		PortletURL portletURL = _renderResponse.createRenderURL();

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

		SearchContainer tacticsSearchContainer = new SearchContainer(
			_renderRequest, getPortletURL(), null, "no-promotions-were-found");

		tacticsSearchContainer.setId("tactics");
		tacticsSearchContainer.setRowChecker(
			new EmptyOnClickRowChecker(_renderResponse));
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

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		long scopeGroupId = themeDisplay.getScopeGroupId();

		if (Validator.isNotNull(getKeywords())) {
			Sort sort = new Sort(
				Field.MODIFIED_DATE, Sort.LONG_TYPE, orderByAsc);

			BaseModelSearchResult<Tactic> searchResults =
				TacticLocalServiceUtil.searchTactics(
					getCampaignId(), scopeGroupId, getKeywords(),
					tacticsSearchContainer.getStart(),
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

		Campaign campaign = getCampaign();

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (campaign != null) {
			_hasUpdatePermission = CampaignPermission.contains(
				themeDisplay.getPermissionChecker(), campaign,
				ActionKeys.UPDATE);
		}
		else {
			_hasUpdatePermission = false;
		}

		return _hasUpdatePermission;
	}

	private String _backURL;
	private Campaign _campaign;
	private Long _campaignId;
	private String _campaignTitle;
	private String _displayStyle;
	private Boolean _hasUpdatePermission;
	private String _keywords;
	private final LiferayPortletResponse _liferayPortletResponse;
	private String _orderByCol;
	private String _orderByType;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private final HttpServletRequest _request;
	private SearchContainer _tacticSearchContainer;

}