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

package com.liferay.content.targeting.report.campaign.tracking.action.display.context;

import com.liferay.content.targeting.display.context.BaseReportDisplayContext;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalServiceUtil;
import com.liferay.content.targeting.report.campaign.tracking.action.util.TrackingActionTemplate;
import com.liferay.content.targeting.report.campaign.tracking.action.util.comparator.CTActionTotalCountComparator;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pavel Savinov
 */
public class CampaignTrackingActionReportDisplayContext
	extends BaseReportDisplayContext {

	public CampaignTrackingActionReportDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest request) {

		super(liferayPortletResponse, request);

		_liferayPortletRequest = liferayPortletRequest;
	}

	public List<TrackingActionTemplate> getAddedTrackingActionTemplates() {
		if (_addedTrackingActionTemplates == null) {
			_addedTrackingActionTemplates =
				(List<TrackingActionTemplate>)displayContext.get(
					"addedTrackingActionTemplates");
		}

		return _addedTrackingActionTemplates;
	}

	public SearchContainer getSearchContainer() throws PortalException {
		if (_searchContainer != null) {
			return _searchContainer;
		}

		SearchContainer searchContainer = new SearchContainer(
			_liferayPortletRequest, getPortletURL(), null,
			"there-is-not-enough-data-to-generate-this-report");

		int total = CTActionTotalLocalServiceUtil.getCTActionsTotalCount(
			getReportInstanceId());

		searchContainer.setTotal(total);

		List results = CTActionTotalLocalServiceUtil.getCTActionsTotal(
			getReportInstanceId(), searchContainer.getStart(),
			searchContainer.getEnd(), new CTActionTotalCountComparator());

		searchContainer.setResults(results);

		_searchContainer = searchContainer;

		return _searchContainer;
	}

	public List<TrackingActionTemplate> getTrackingActionTemplates() {
		if (_trackingActionTemplates == null) {
			_trackingActionTemplates =
				(List<TrackingActionTemplate>)displayContext.get(
					"trackingActionTemplates");
		}

		return _trackingActionTemplates;
	}

	private List<TrackingActionTemplate> _addedTrackingActionTemplates;
	private final LiferayPortletRequest _liferayPortletRequest;
	private SearchContainer _searchContainer;
	private List<TrackingActionTemplate> _trackingActionTemplates;

}