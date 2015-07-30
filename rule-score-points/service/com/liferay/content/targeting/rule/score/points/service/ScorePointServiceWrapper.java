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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScorePointService}.
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointService
 * @generated
 */
public class ScorePointServiceWrapper implements ScorePointService,
	ServiceWrapper<ScorePointService> {
	public ScorePointServiceWrapper(ScorePointService scorePointService) {
		_scorePointService = scorePointService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scorePointService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scorePointService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scorePointService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public long getPoints(long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scorePointService.getPoints(anonymousUserId, userSegmentId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> getScorePoints(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scorePointService.getScorePoints(userSegmentId);
	}

	@Override
	public long incrementPoints(long anonymousUserId, long userSegmentId,
		long points)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scorePointService.incrementPoints(anonymousUserId,
			userSegmentId, points);
	}

	@Override
	public com.liferay.content.targeting.rule.score.points.model.ScorePoint updateScorePoints(
		long anonymousUserId, long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scorePointService.updateScorePoints(anonymousUserId,
			userSegmentId, points);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScorePointService getWrappedScorePointService() {
		return _scorePointService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScorePointService(ScorePointService scorePointService) {
		_scorePointService = scorePointService;
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