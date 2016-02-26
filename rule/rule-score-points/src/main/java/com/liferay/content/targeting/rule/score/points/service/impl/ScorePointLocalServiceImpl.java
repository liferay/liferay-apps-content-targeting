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

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.score.points.model.ScorePoint;
import com.liferay.content.targeting.rule.score.points.service.base.ScorePointLocalServiceBaseImpl;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.List;

/**
 * The implementation of the score point local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.rule.score.points.service.ScorePointLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.score.points.service.base.ScorePointLocalServiceBaseImpl
 * @see com.liferay.content.targeting.rule.score.points.service.ScorePointLocalServiceUtil
 */
public class ScorePointLocalServiceImpl extends ScorePointLocalServiceBaseImpl {

	@Override
	public ScorePoint addScorePoints(
		long anonymousUserId, long userSegmentId, long points) {

		ScorePoint scorePoint = scorePointPersistence.fetchByC_U(
			anonymousUserId, userSegmentId);

		if (scorePoint == null) {
			UserSegment userSegment = _userSegmentLocalService.fetchUserSegment
				(userSegmentId);

			long scorePointId = counterLocalService.increment();

			scorePoint = scorePointPersistence.create(scorePointId);

			scorePoint.setCompanyId(userSegment.getCompanyId());
			scorePoint.setAnonymousUserId(anonymousUserId);
			scorePoint.setUserSegmentId(userSegmentId);
			scorePoint.setPoints(points);
		}
		else {
			scorePoint.setPoints(scorePoint.getPoints() + points);
		}

		scorePointPersistence.update(scorePoint);

		return scorePoint;
	}

	@Override
	public long getPoints(long anonymousUserId, long userSegmentId) {
		ScorePoint scorePoint = scorePointPersistence.fetchByC_U(
			anonymousUserId, userSegmentId);

		if (scorePoint == null) {
			return 0;
		}

		return scorePoint.getPoints();
	}

	@Override
	public List<ScorePoint> getScorePoints(long userSegmentId) {
		return scorePointPersistence.findByUserSegmentId(userSegmentId);
	}

	@Override
	public long incrementPoints(
		long anonymousUserId, long userSegmentId, long points) {

		ScorePoint scorePoint = scorePointPersistence.fetchByC_U(
			anonymousUserId, userSegmentId);

		if (scorePoint == null) {
			try {
				scorePointLocalService.addScorePoints(
					anonymousUserId, userSegmentId, points);
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(e);
				}
			}

			return points;
		}

		long total = scorePoint.getPoints() + points;

		scorePoint.setPoints(total);

		scorePointPersistence.update(scorePoint);

		return total;
	}

	@Override
	public ScorePoint updateScorePoints(
		long anonymousUserId, long userSegmentId, long points) {

		ScorePoint scorePoint = scorePointPersistence.fetchByC_U(
			anonymousUserId, userSegmentId);

		scorePoint.setPoints(points);

		scorePointPersistence.update(scorePoint);

		return scorePoint;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ScorePointLocalServiceImpl.class);

	@ServiceReference(type = UserSegmentLocalService.class)
	private UserSegmentLocalService _userSegmentLocalService;

}