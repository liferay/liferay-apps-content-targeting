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

package com.liferay.content.targeting.rule.score.points.service.impl;

import com.liferay.content.targeting.rule.score.points.model.ScorePoint;
import com.liferay.content.targeting.rule.score.points.service.base.ScorePointServiceBaseImpl;
import com.liferay.content.targeting.service.permission.UserSegmentPermission;
import com.liferay.content.targeting.util.ActionKeys;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * The implementation of the score point remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.rule.score.points.service.ScorePointService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Julio Camarero
 * @see com.liferay.content.targeting.rule.score.points.service.base.ScorePointServiceBaseImpl
 * @see com.liferay.content.targeting.rule.score.points.service.ScorePointServiceUtil
 */
public class ScorePointServiceImpl extends ScorePointServiceBaseImpl {

	public long getPoints(long anonymousUserId, long userSegmentId)
		throws PortalException {

		UserSegmentPermission.check(
			getPermissionChecker(), userSegmentId, ActionKeys.UPDATE);

		return scorePointLocalService.getPoints(anonymousUserId, userSegmentId);
	}

	public List<ScorePoint> getScorePoints(long userSegmentId)
		throws PortalException {

		UserSegmentPermission.check(
			getPermissionChecker(), userSegmentId, ActionKeys.UPDATE);

		return scorePointLocalService.getScorePoints(userSegmentId);
	}

	public long incrementPoints(
			long anonymousUserId, long userSegmentId, long points)
		throws PortalException {

		UserSegmentPermission.check(
			getPermissionChecker(), userSegmentId, ActionKeys.UPDATE);

		return scorePointLocalService.incrementPoints(
			anonymousUserId, userSegmentId, points);
	}

	public ScorePoint updateScorePoints(
			long anonymousUserId, long userSegmentId, long points)
		throws PortalException {

		UserSegmentPermission.check(
			getPermissionChecker(), userSegmentId, ActionKeys.UPDATE);

		return scorePointLocalService.updateScorePoints(
			anonymousUserId, userSegmentId, points);
	}

}