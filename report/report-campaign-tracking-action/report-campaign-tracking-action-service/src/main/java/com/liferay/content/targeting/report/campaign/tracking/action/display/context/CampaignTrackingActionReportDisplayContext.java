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
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.util.TrackingActionTemplate;
import com.liferay.content.targeting.util.SearchContainerIterator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pavel Savinov
 */
public class CampaignTrackingActionReportDisplayContext
	extends BaseReportDisplayContext {

	public CampaignTrackingActionReportDisplayContext(
		HttpServletRequest request) {

		super(request);
	}

	public List<TrackingActionTemplate> getAddedTrackingActionTemplates() {
		if (_addedTrackingActionTemplates == null) {
			_addedTrackingActionTemplates =
				(List<TrackingActionTemplate>)displayContext.get(
					"addedTrackingActionTemplates");
		}

		return _addedTrackingActionTemplates;
	}

	public String getCssHasItemsClass() {
		if (getAddedTrackingActionTemplates().size() > 0) {
			return "has-items";
		}

		return "";
	}

	public SearchContainerIterator<CTActionTotal>
		getSearchContainerIterator() {

		if (_searchContainerIterator == null) {
			_searchContainerIterator =
				(SearchContainerIterator<CTActionTotal>)displayContext.get(
					"searchContainerIterator");
		}

		return _searchContainerIterator;
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
	private SearchContainerIterator<CTActionTotal> _searchContainerIterator;
	private List<TrackingActionTemplate> _trackingActionTemplates;

}