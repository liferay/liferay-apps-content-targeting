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

package com.liferay.content.targeting.rule.score.points.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScorePointService}.
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointService
 * @generated
 */
@ProviderType
public class ScorePointServiceWrapper implements ScorePointService,
	ServiceWrapper<ScorePointService> {
	public ScorePointServiceWrapper(ScorePointService scorePointService) {
		_scorePointService = scorePointService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _scorePointService.getOSGiServiceIdentifier();
	}

	@Override
	public long getPoints(long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scorePointService.getPoints(anonymousUserId, userSegmentId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> getScorePoints(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scorePointService.getScorePoints(userSegmentId);
	}

	@Override
	public long incrementPoints(long anonymousUserId, long userSegmentId,
		long points) throws com.liferay.portal.kernel.exception.PortalException {
		return _scorePointService.incrementPoints(anonymousUserId,
			userSegmentId, points);
	}

	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint updateScorePoints(
		long anonymousUserId, long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _scorePointService.updateScorePoints(anonymousUserId,
			userSegmentId, points);
	}

	@Override
	public ScorePointService getWrappedService() {
		return _scorePointService;
	}

	@Override
	public void setWrappedService(ScorePointService scorePointService) {
		_scorePointService = scorePointService;
	}

	private ScorePointService _scorePointService;
}