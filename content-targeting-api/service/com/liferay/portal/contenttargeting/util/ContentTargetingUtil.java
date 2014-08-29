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

package com.liferay.portal.contenttargeting.util;

import com.liferay.portal.contenttargeting.model.UserSegment;
import com.liferay.portal.contenttargeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;

import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class ContentTargetingUtil {

	public static long[] getAncestorsAndCurrentGroupIds(long groupId)
		throws PortalException, SystemException {

		Group scopeGroup = GroupLocalServiceUtil.fetchGroup(groupId);

		if (scopeGroup == null) {
			return null;
		}

		if (scopeGroup.isStagingGroup()) {
			scopeGroup = scopeGroup.getLiveGroup();
		}

		List<Group> groups = scopeGroup.getAncestors();

		groups.add(scopeGroup);

		Group companyGroup = GroupLocalServiceUtil.getCompanyGroup(
			scopeGroup.getCompanyId());

		groups.add(companyGroup);

		long[] groupIds = new long[groups.size()];

		for (int i = 0; i < groups.size(); i++) {
			Group group = groups.get(i);

			groupIds[i] = group.getGroupId();
		}

		return groupIds;
	}

	public static long[] getAssetCategoryIds(
			long groupId, long[] userSegmentIds)
		throws SystemException {

		if (userSegmentIds == null) {
			return new long[0];
		}

		long[] assetCategoryIds = new long[userSegmentIds.length];

		for (int i = 0; i < userSegmentIds.length; i++) {
			UserSegment userSegment =
				UserSegmentLocalServiceUtil.fetchUserSegment(userSegmentIds[i]);

			assetCategoryIds[i] = userSegment.getAssetCategoryId(groupId);
		}

		return assetCategoryIds;
	}

}