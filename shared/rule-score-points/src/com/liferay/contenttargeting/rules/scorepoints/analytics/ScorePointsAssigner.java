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

package com.liferay.contenttargeting.rules.scorepoints.analytics;

import com.liferay.contenttargeting.model.UserSegment;
import com.liferay.contenttargeting.rules.scorepoints.service.ScorePointLocalServiceUtil;
import com.liferay.contenttargeting.service.UserSegmentLocalService;
import com.liferay.contenttargeting.util.ContentTargetingUtil;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eudaldo Alonso
 */
public class ScorePointsAssigner {

	public static void assignPoints(
			long groupId, long anonymousUserId, String className, long classPK)
		throws Exception {

		AssetEntry entry = AssetEntryLocalServiceUtil.fetchEntry(
			className, classPK);

		if (entry == null) {
			return;
		}

		long[] groupIds = ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
			groupId);

		Bundle bundle = FrameworkUtil.getBundle(ScorePointsAssigner.class);

		if (bundle == null) {
			return;
		}

		UserSegmentLocalService userSegmentLocalService =
			ServiceTrackerUtil.getService(
				UserSegmentLocalService.class, bundle.getBundleContext());

		List<UserSegment> userSegments =
			userSegmentLocalService.getUserSegments(groupIds);

		long[] assetCategoryIds = entry.getCategoryIds();

		if (userSegments.isEmpty() || ArrayUtil.isEmpty(assetCategoryIds)) {
			return;
		}

		for (UserSegment userSegment : userSegments) {
			long userSegmentAssetCategoryId = userSegment.getAssetCategoryId();

			if (ArrayUtil.contains(
					assetCategoryIds, userSegmentAssetCategoryId)) {

				long points = getScorePoints(
					className, classPK, userSegment.getUserSegmentId());

				ScorePointLocalServiceUtil.incrementPoints(
					anonymousUserId, userSegment.getUserSegmentId(), points);
			}
		}
	}

	protected static long getScorePoints(
		String className, long classPK, long userSegmentId) {

		return DEFAULT_POINTS;
	}

	private static final long DEFAULT_POINTS = 1;

}