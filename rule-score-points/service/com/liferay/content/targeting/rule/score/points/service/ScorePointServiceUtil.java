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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

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
public class ScorePointServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.rule.score.points.service.impl.ScorePointServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static long getPoints(long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPoints(anonymousUserId, userSegmentId);
	}

	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> getScorePoints(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getScorePoints(userSegmentId);
	}

	public static long incrementPoints(long anonymousUserId,
		long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .incrementPoints(anonymousUserId, userSegmentId, points);
	}

	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint updateScorePoints(
		long anonymousUserId, long userSegmentId, long points)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateScorePoints(anonymousUserId, userSegmentId, points);
	}

	public static void clearService() {
		_service = null;
	}

	public static ScorePointService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ScorePointService.class.getName());

			if (invokableService instanceof ScorePointService) {
				_service = (ScorePointService)invokableService;
			}
			else {
				_service = new ScorePointServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ScorePointServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ScorePointService service) {
	}

	private static ScorePointService _service;
}