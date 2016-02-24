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

package com.liferay.content.targeting.util;

import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;

/**
 * @author Pavel Savinov
 */
public class TacticSearchContainerIterator
	extends SearchContainerIterator<Tactic> {

	public TacticSearchContainerIterator() {
		_campaignId = 0;
	}

	public TacticSearchContainerIterator(
			long campaignId, long groupId, String keywords)
		throws PortletException {

		super(groupId, keywords);

		_campaignId = campaignId;
	}

	@Override
	public List<Tactic> getResults(int start, int end) throws PortalException {
		if (Validator.isNull(keywords)) {
			return TacticLocalServiceUtil.getTactics(
				_campaignId, start, end, null);
		}

		BaseModelSearchResult<Tactic> searchResults =
			TacticLocalServiceUtil.searchTactics(
				_campaignId, groupId, keywords, start, end);

		return searchResults.getBaseModels();
	}

	public List<Tactic> getResults(long campaignId, int start, int end)
		throws PortalException {

		if (Validator.isNull(keywords)) {
			return TacticLocalServiceUtil.getTactics(
				campaignId, start, end, null);
		}

		BaseModelSearchResult<Tactic> searchResults =
			TacticLocalServiceUtil.searchTactics(
				campaignId, groupId, keywords, start, end);

		return searchResults.getBaseModels();
	}

	@Override
	public int getTotal() throws PortalException {
		if (Validator.isNull(keywords)) {
			return TacticLocalServiceUtil.getTacticsCount(_campaignId);
		}

		BaseModelSearchResult<Tactic> searchResults =
			TacticLocalServiceUtil.searchTactics(
				_campaignId, groupId, keywords, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		return searchResults.getLength();
	}

	public int getTotal(long campaignId) throws PortalException {
		if (Validator.isNull(keywords)) {
			return TacticLocalServiceUtil.getTacticsCount(campaignId);
		}

		BaseModelSearchResult<Tactic> searchResults =
			TacticLocalServiceUtil.searchTactics(
				campaignId, groupId, keywords, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		return searchResults.getLength();
	}

	private final long _campaignId;

}