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

package com.liferay.content.targeting.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for TrackingActionInstance. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.TrackingActionInstanceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstanceService
 * @see com.liferay.content.targeting.service.base.TrackingActionInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.TrackingActionInstanceServiceImpl
 * @generated
 */
public class TrackingActionInstanceServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.TrackingActionInstanceServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.liferay.content.targeting.service.TrackingActionInstanceServiceUtil} to access the tracking action instance remote service.
	*/
	public static com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		long userId, java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTrackingActionInstance(userId, trackingActionKey,
			campaignId, alias, referrerClassName, referrerClassPK, elementId,
			eventType, typeSettings, serviceContext);
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance deleteTrackingActionInstance(
		long trackingActionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteTrackingActionInstance(trackingActionInstanceId);
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstance(
		long campaignId, java.lang.String alias) throws java.lang.Exception {
		return getService().fetchTrackingActionInstance(campaignId, alias);
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrackingActionInstances(campaignId);
	}

	public static int getTrackingActionInstancesCount(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTrackingActionInstancesCount(campaignId);
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance updateTrackingActionInstance(
		long trackingActionInstanceId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTrackingActionInstance(trackingActionInstanceId,
			alias, referrerClassName, referrerClassPK, elementId, eventType,
			typeSettings, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TrackingActionInstanceService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TrackingActionInstanceService.class.getName());

			if (invokableService instanceof TrackingActionInstanceService) {
				_service = (TrackingActionInstanceService)invokableService;
			}
			else {
				_service = new TrackingActionInstanceServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(TrackingActionInstanceServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TrackingActionInstanceService service) {
	}

	private static TrackingActionInstanceService _service;
}