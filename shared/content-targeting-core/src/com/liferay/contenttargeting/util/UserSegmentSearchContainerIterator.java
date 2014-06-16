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

package com.liferay.contenttargeting.util;

import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.service.UserSegmentLocalService;
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
 * @author Eduardo Garcia
 */
public class UserSegmentSearchContainerIterator
	extends SearchContainerIterator<UserSegment> {

	public UserSegmentSearchContainerIterator(long groupId, String keywords)
		throws PortletException {

		super(groupId, keywords);

		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, bundle.getBundleContext());
	}

	@Override
	public List<UserSegment> getResults(int start, int end)
		throws PortalException, SystemException {

		if (Validator.isNull(keywords)) {
			return _userSegmentLocalService.getUserSegments(
				groupId, start, end, null);
		}

		BaseModelSearchResult<UserSegment> searchResults =
			_userSegmentLocalService.searchUserSegments(
				groupId, keywords, start, end);

		return searchResults.getBaseModels();
	}

	@Override
	public int getTotal() throws PortalException, SystemException {
		if (Validator.isNull(keywords)) {
			return _userSegmentLocalService.getUserSegmentsCount(groupId);
		}

		BaseModelSearchResult<UserSegment> searchResults =
			_userSegmentLocalService.searchUserSegments(
				groupId, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		return searchResults.getLength();
	}

	private UserSegmentLocalService _userSegmentLocalService;

}