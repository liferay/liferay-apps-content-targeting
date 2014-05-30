/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.util;

import com.liferay.contenttargeting.model.Campaign;
import com.liferay.contenttargeting.service.CampaignLocalService;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eduardo Garcia
 */
public class CampaignSearchContainerIterator
	extends SearchContainerIterator<Campaign> {

	public CampaignSearchContainerIterator(long groupId, String keywords)
		throws PortletException {

		super(groupId, keywords);

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, bundle.getBundleContext());
	}

	@Override
	public List<Campaign> getResults(int start, int end)
		throws PortalException, SystemException {

		if (Validator.isNull(keywords)) {
			return _campaignLocalService.getCampaigns(
					groupId, start, end, null);
		}

		BaseModelSearchResult<Campaign> searchResults =
			_campaignLocalService.searchCampaigns(
				groupId, keywords, start, end);

		return searchResults.getBaseModels();
	}

	@Override
	public int getTotal() throws PortalException, SystemException {
		if (Validator.isNull(keywords)) {
			return _campaignLocalService.getCampaignsCount(groupId);
		}

		BaseModelSearchResult<Campaign> searchResults =
			_campaignLocalService.searchCampaigns(
				groupId, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		return searchResults.getLength();
	}

	private CampaignLocalService _campaignLocalService;

}