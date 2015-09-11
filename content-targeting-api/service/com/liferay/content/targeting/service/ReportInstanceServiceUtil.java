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
 * Provides the remote service utility for ReportInstance. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.ReportInstanceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstanceService
 * @see com.liferay.content.targeting.service.base.ReportInstanceServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.ReportInstanceServiceImpl
 * @generated
 */
public class ReportInstanceServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.ReportInstanceServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.content.targeting.model.ReportInstance addReportInstance(
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addReportInstance(userId, reportKey, className, classPK,
			nameMap, descriptionMap, typeSettings, serviceContext);
	}

	/**
	* @deprecated As of 2.0.0
	*/
	public static com.liferay.content.targeting.model.ReportInstance addReportInstance(
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addReportInstance(userId, reportKey, className, classPK,
			typeSettings, serviceContext);
	}

	public static com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		long reportInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchReportInstance(reportInstanceId);
	}

	public static com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		java.lang.String reportKey, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchReportInstance(reportKey, className, classPK);
	}

	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> findReportInstances(
		java.lang.String reportKey, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findReportInstances(reportKey, className, classPK);
	}

	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstances(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getReportInstances(className, classPK);
	}

	public static com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		long reportInstanceId, long userId, java.lang.String reportKey,
		java.lang.String className, long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateReportInstance(reportInstanceId, userId, reportKey,
			className, classPK, nameMap, descriptionMap, typeSettings,
			serviceContext);
	}

	public static com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		com.liferay.content.targeting.model.ReportInstance reportInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateReportInstance(reportInstance);
	}

	public static void clearService() {
		_service = null;
	}

	public static ReportInstanceService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ReportInstanceService.class.getName());

			if (invokableService instanceof ReportInstanceService) {
				_service = (ReportInstanceService)invokableService;
			}
			else {
				_service = new ReportInstanceServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ReportInstanceServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ReportInstanceService service) {
	}

	private static ReportInstanceService _service;
}