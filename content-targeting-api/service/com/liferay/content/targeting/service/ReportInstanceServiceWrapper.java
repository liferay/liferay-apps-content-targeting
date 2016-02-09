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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReportInstanceService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstanceService
 * @generated
 */
@ProviderType
public class ReportInstanceServiceWrapper implements ReportInstanceService,
	ServiceWrapper<ReportInstanceService> {
	public ReportInstanceServiceWrapper(
		ReportInstanceService reportInstanceService) {
		_reportInstanceService = reportInstanceService;
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance addReportInstance(
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceService.addReportInstance(userId, reportKey,
			className, classPK, nameMap, descriptionMap, typeSettings,
			serviceContext);
	}

	/**
	* @deprecated As of 2.0.0
	*/
	@Deprecated
	@Override
	public com.liferay.content.targeting.model.ReportInstance addReportInstance(
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceService.addReportInstance(userId, reportKey,
			className, classPK, typeSettings, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		long reportInstanceId) {
		return _reportInstanceService.fetchReportInstance(reportInstanceId);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		java.lang.String reportKey, java.lang.String className, long classPK) {
		return _reportInstanceService.fetchReportInstance(reportKey, className,
			classPK);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findReportInstances(
		java.lang.String reportKey, java.lang.String className, long classPK) {
		return _reportInstanceService.findReportInstances(reportKey, className,
			classPK);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _reportInstanceService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstances(
		java.lang.String className, long classPK) {
		return _reportInstanceService.getReportInstances(className, classPK);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		com.liferay.content.targeting.model.ReportInstance reportInstance) {
		return _reportInstanceService.updateReportInstance(reportInstance);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		long reportInstanceId, long userId, java.lang.String reportKey,
		java.lang.String className, long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceService.updateReportInstance(reportInstanceId,
			userId, reportKey, className, classPK, nameMap, descriptionMap,
			typeSettings, serviceContext);
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