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

package com.liferay.content.targeting.rule.score.points.messaging;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.score.points.api.model.ScorePointsAssigner;
import com.liferay.content.targeting.rule.score.points.service.ScorePointLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = ScorePointsAssigner.class)
public class DefaultScorePointsAssignerImpl implements ScorePointsAssigner {

	public void assignPoints(
			long groupId, long anonymousUserId, String className, long classPK)
		throws Exception {

		AssetEntry entry = _assetEntryLocalService.fetchEntry(
			className, classPK);

		if (entry == null) {
			return;
		}

		long[] groupIds = ContentTargetingUtil.getAncestorsAndCurrentGroupIds(
			groupId);

		List<UserSegment> userSegments =
			_userSegmentLocalService.getUserSegments(groupIds);

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

				try {
					_scorePointLocalService.incrementPoints(
						anonymousUserId, userSegment.getUserSegmentId(),
						points);
				}
				catch (SystemException se) {
					if (_log.isWarnEnabled()) {
						_log.warn(
							"Not possible to increment " + points +
								" points for anonymousUserId " +
								anonymousUserId + " and userSegmentId " +
								userSegment.getUserSegmentId(),
							se);
					}
				}
			}
		}
	}

	@Reference(unbind = "-")
	public void setScorePointLocalService(
		ScorePointLocalService scorePointLocalService) {

		_scorePointLocalService = scorePointLocalService;
	}

	@Reference(unbind = "-")
	public void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	protected long getScorePoints(
		String className, long classPK, long userSegmentId) {

		return _DEFAULT_POINTS;
	}

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
	}

	private static final long _DEFAULT_POINTS = 1;

	private static final Log _log = LogFactoryUtil.getLog(
		DefaultScorePointsAssignerImpl.class);

	private AssetEntryLocalService _assetEntryLocalService;
	private ScorePointLocalService _scorePointLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}