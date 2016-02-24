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

import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.GroupTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class ReportInstanceLocalServiceImplTest {

	@Before
	public void setUp() throws Exception {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_reportInstanceLocalService = ServiceTrackerUtil.getService(
			ReportInstanceLocalService.class, _bundle.getBundleContext());
		_userLocalService = ServiceTrackerUtil.getService(
			UserLocalService.class, _bundle.getBundleContext());
		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, _bundle.getBundleContext());

		Group group = GroupTestUtil.addGroup();

		_serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-category");

		_userSegment = _userSegmentLocalService.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, _serviceContext);
	}

	@Test
	public void testAddAndDeleteReportInstance() throws Exception {
		int initReportInstancesCount =
			_reportInstanceLocalService.getReportInstancesCount();

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-report");

		ReportInstance reportInstance =
			_reportInstanceLocalService.addReportInstance(
				TestPropsValues.getUserId(), "report-key",
				UserSegment.class.getName(), _userSegment.getUserSegmentId(),
				nameMap, null, "type-settings", _serviceContext);

		Assert.assertEquals(
			initReportInstancesCount + 1,
			_reportInstanceLocalService.getReportInstancesCount());

		_reportInstanceLocalService.deleteReportInstance(
			reportInstance.getReportInstanceId());

		Assert.assertEquals(
			initReportInstancesCount,
			_reportInstanceLocalService.getReportInstancesCount());
	}

	@Test
	public void testDeleteUserSegment() throws Exception {
		int initReportInstancesCount =
			_reportInstanceLocalService.getReportInstancesCount();

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-report");

		_reportInstanceLocalService.addReportInstance(
			TestPropsValues.getUserId(), "report-key",
			UserSegment.class.getName(), _userSegment.getUserSegmentId(),
			nameMap, null, "type-settings", _serviceContext);

		_userSegmentLocalService.deleteUserSegment(
			_userSegment.getUserSegmentId());

		Assert.assertEquals(
			initReportInstancesCount,
			_reportInstanceLocalService.getReportInstancesCount());
	}

	@ArquillianResource
	private Bundle _bundle;

	private ReportInstanceLocalService _reportInstanceLocalService;
	private ServiceContext _serviceContext;
	private UserLocalService _userLocalService;
	private UserSegment _userSegment;
	private UserSegmentLocalService _userSegmentLocalService;

}