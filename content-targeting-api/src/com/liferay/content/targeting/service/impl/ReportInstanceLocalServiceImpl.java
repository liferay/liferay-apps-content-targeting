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

package com.liferay.content.targeting.service.impl;

import com.liferay.content.targeting.api.model.Report;
import com.liferay.content.targeting.api.model.ReportsRegistry;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
import com.liferay.content.targeting.service.base.ReportInstanceLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * The implementation of the report instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.service.ReportInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.base.ReportInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil
 */
public class ReportInstanceLocalServiceImpl
	extends ReportInstanceLocalServiceBaseImpl {

	public ReportInstanceLocalServiceImpl() {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		_reportsRegistry = ServiceTrackerUtil.getService(
			ReportsRegistry.class, bundle.getBundleContext());
		_trackingActionInstanceLocalService = ServiceTrackerUtil.getService(
			TrackingActionInstanceLocalService.class,
			bundle.getBundleContext());
	}

	@Override
	public ReportInstance addReportInstance(
			long userId, String reportKey, String className, long classPK,
			Map<Locale, String> nameMap, Map<Locale, String> descriptionMap,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUser(userId);

		long groupId = serviceContext.getScopeGroupId();

		long reportInstanceId = CounterLocalServiceUtil.increment();

		ReportInstance reportInstance = reportInstancePersistence.create(
			reportInstanceId);

		reportInstance.setGroupId(groupId);
		reportInstance.setCompanyId(user.getCompanyId());
		reportInstance.setUserId(user.getUserId());
		reportInstance.setUserName(user.getFullName());

		reportInstance.setModifiedDate(new Date());
		reportInstance.setReportKey(reportKey);
		reportInstance.setClassName(className);
		reportInstance.setClassPK(classPK);
		reportInstance.setNameMap(nameMap);
		reportInstance.setDescriptionMap(descriptionMap);
		reportInstance.setTypeSettings(typeSettings);

		reportInstancePersistence.update(reportInstance);

		return reportInstance;
	}

	/**
	* @deprecated As of 2.0.0
	*/
	@Deprecated
	@Override
	public ReportInstance addReportInstance(
			long userId, String reportKey, String className, long classPK,
			String typeSettings, ServiceContext serviceContext)
		throws PortalException, SystemException {

		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		Locale[] availableLocales = LanguageUtil.getAvailableLocales();

		Report report = _reportsRegistry.getReport(reportKey);

		for (Locale locale : availableLocales) {
			nameMap.put(locale, report.getName(locale));
			descriptionMap.put(locale, report.getDescription(locale));
		}

		return addReportInstance(
			userId, reportKey, className, classPK, nameMap, descriptionMap,
			typeSettings, serviceContext);
	}

	@Override
	public ReportInstance deleteReportInstance(long reportInstanceId)
		throws PortalException, SystemException {

		ReportInstance reportInstance = reportInstancePersistence.remove(
			reportInstanceId);

		List<TrackingActionInstance> trackingActionInstances =
			_trackingActionInstanceLocalService.
				getTrackingActionInstancesByReportInstanceId(reportInstanceId);

		for (TrackingActionInstance trackingActionInstance
				: trackingActionInstances) {

			_trackingActionInstanceLocalService.deleteTrackingActionInstance(
				trackingActionInstance.getTrackingActionInstanceId());
		}

		return reportInstance;
	}

	@Override
	public ReportInstance fetchReportInstance(
			String reportKey, String className, long classPK)
		throws SystemException {

		List<ReportInstance> reportInstances =
			reportInstancePersistence.findByR_C_C(
				reportKey, className, classPK);

		if (reportInstances.isEmpty() || (reportInstances.size() > 1)) {
			return null;
		}

		return reportInstances.get(0);
	}

	@Override
	public List<ReportInstance> findReportInstances(
			String reportKey, String className, long classPK)
		throws SystemException {

		return reportInstancePersistence.findByR_C_C(
			reportKey, className, classPK);
	}

	@Override
	public List<ReportInstance> getReportInstances(
			String className, long classPK)
		throws SystemException {

		return reportInstancePersistence.findByC_C(className, classPK);
	}

	@Override
	public ReportInstance updateReportInstance(
			long reportInstanceId, long userId, String reportKey,
			String className, long classPK, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, String typeSettings,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		ReportInstance reportInstance = getReportInstance(reportInstanceId);

		reportInstance.setModifiedDate(new Date());
		reportInstance.setReportKey(reportKey);
		reportInstance.setClassName(className);
		reportInstance.setClassPK(classPK);
		reportInstance.setNameMap(nameMap);
		reportInstance.setDescriptionMap(descriptionMap);
		reportInstance.setTypeSettings(typeSettings);

		reportInstancePersistence.update(reportInstance);

		return reportInstance;
	}

	private ReportsRegistry _reportsRegistry;
	private TrackingActionInstanceLocalService
		_trackingActionInstanceLocalService;

}