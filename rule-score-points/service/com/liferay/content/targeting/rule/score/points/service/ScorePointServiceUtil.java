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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ScorePoint. This utility wraps
 * {@link com.liferay.content.targeting.rule.score.points.service.impl.ScorePointServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointService
 * @see com.liferay.content.targeting.rule.score.points.service.base.ScorePointServiceBaseImpl
 * @see com.liferay.content.targeting.rule.score.points.service.impl.ScorePointServiceImpl
 * @generated
 */
@ProviderType
public class ScorePointServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.rule.score.points.service.impl.ScorePointServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static long getPoints(long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPoints(anonymousUserId, userSegmentId);
	}

	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> getScorePoints(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getScorePoints(userSegmentId);
	}

	public static long incrementPoints(long anonymousUserId,
		long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .incrementPoints(anonymousUserId, userSegmentId, points);
	}

	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint updateScorePoints(
		long anonymousUserId, long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateScorePoints(anonymousUserId, userSegmentId, points);
	}

	public static ScorePointService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ScorePointService, ScorePointService> _serviceTracker =
		ServiceTrackerFactory.open(ScorePointService.class);
}