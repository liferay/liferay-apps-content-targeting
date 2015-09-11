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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReportInstanceService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstanceService
 * @generated
 */
public class ReportInstanceServiceWrapper implements ReportInstanceService,
	ServiceWrapper<ReportInstanceService> {
	public ReportInstanceServiceWrapper(
		ReportInstanceService reportInstanceService) {
		_reportInstanceService = reportInstanceService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _reportInstanceService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_reportInstanceService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _reportInstanceService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance addReportInstance(
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportInstanceService.addReportInstance(userId, reportKey,
			className, classPK, nameMap, descriptionMap, typeSettings,
			serviceContext);
	}

	/**
	* @deprecated As of 2.0.0
	*/
	@Override
	public com.liferay.content.targeting.model.ReportInstance addReportInstance(
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportInstanceService.addReportInstance(userId, reportKey,
			className, classPK, typeSettings, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		long reportInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportInstanceService.fetchReportInstance(reportInstanceId);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		java.lang.String reportKey, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportInstanceService.fetchReportInstance(reportKey, className,
			classPK);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findReportInstances(
		java.lang.String reportKey, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportInstanceService.findReportInstances(reportKey, className,
			classPK);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstances(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportInstanceService.getReportInstances(className, classPK);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		long reportInstanceId, long userId, java.lang.String reportKey,
		java.lang.String className, long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reportInstanceService.updateReportInstance(reportInstanceId,
			userId, reportKey, className, classPK, nameMap, descriptionMap,
			typeSettings, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		com.liferay.content.targeting.model.ReportInstance reportInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reportInstanceService.updateReportInstance(reportInstance);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ReportInstanceService getWrappedReportInstanceService() {
		return _reportInstanceService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedReportInstanceService(
		ReportInstanceService reportInstanceService) {
		_reportInstanceService = reportInstanceService;
	}

	@Override
	public ReportInstanceService getWrappedService() {
		return _reportInstanceService;
	}

	@Override
	public void setWrappedService(ReportInstanceService reportInstanceService) {
		_reportInstanceService = reportInstanceService;
	}

	private ReportInstanceService _reportInstanceService;
}