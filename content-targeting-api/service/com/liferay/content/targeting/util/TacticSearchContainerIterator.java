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
import com.liferay.content.targeting.service.TacticLocalService;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Pavel Savinov
 */
public class TacticSearchContainerIterator
	extends SearchContainerIterator<Tactic> {

	public TacticSearchContainerIterator(long groupId, String keywords)
		throws PortletException {

		super(groupId, keywords);

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_tacticLocalService = ServiceTrackerUtil.getService(
			TacticLocalService.class, bundle.getBundleContext());
	}

	@Override
	public List<Tactic> getResults(int start, int end)
		throws PortalException, SystemException {

		if (Validator.isNull(keywords)) {
			return _tacticLocalService.getTactics(start, end);
		}

		BaseModelSearchResult<Tactic> searchResults =
				_tacticLocalService.searchTactics(
						groupId, keywords, start, end);

		return searchResults.getBaseModels();
	}

	public List<Tactic> getResults(long campaignId, int start, int end)
		throws PortalException, SystemException {

		if (Validator.isNull(keywords)) {
			return _tacticLocalService.getResults(campaignId, start, end);
		}

		BaseModelSearchResult<Tactic> searchResults =
				_tacticLocalService.searchTactics(
						groupId, keywords, start, end);

		return searchResults.getBaseModels();
	}

	@Override
	public int getTotal() throws PortalException, SystemException {
		if (Validator.isNull(keywords)) {
			return _tacticLocalService.getTacticsCount();
		}

		BaseModelSearchResult<Tactic> searchResults =
			_tacticLocalService.searchTactics(
				groupId, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		return searchResults.getLength();
	}

	public int getTotal(long campaignId)
		throws PortalException, SystemException {

		if (Validator.isNull(keywords)) {
			return _tacticLocalService.getTotal(campaignId);
		}

		BaseModelSearchResult<Tactic> searchResults =
				_tacticLocalService.searchTactics(
						campaignId, groupId, keywords, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS);

		return searchResults.getLength();
	}

	private TacticLocalService _tacticLocalService;

}