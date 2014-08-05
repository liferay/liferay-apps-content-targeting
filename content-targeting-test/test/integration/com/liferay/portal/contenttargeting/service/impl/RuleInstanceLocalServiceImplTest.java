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

package com.liferay.portal.contenttargeting.service.impl;

import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.contenttargeting.model.RuleInstance;
import com.liferay.portal.contenttargeting.model.UserSegment;
import com.liferay.portal.contenttargeting.service.RuleInstanceLocalService;
import com.liferay.portal.contenttargeting.service.UserSegmentLocalService;
import com.liferay.portal.contenttargeting.test.util.TestUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
public class RuleInstanceLocalServiceImplTest {

	@Before
	public void setUp() throws PortalException, SystemException {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_ruleInstanceLocalService = ServiceTrackerUtil.getService(
			RuleInstanceLocalService.class, _bundle.getBundleContext());
		_userLocalService = ServiceTrackerUtil.getService(
			UserLocalService.class, _bundle.getBundleContext());
		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, _bundle.getBundleContext());

		Group group = TestUtil.addGroup();

		_serviceContext = TestUtil.getServiceContext(
			group.getGroupId(), TestUtil.getUserId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-category");

		_userSegment = _userSegmentLocalService.addUserSegment(
			TestUtil.getUserId(), nameMap, null, _serviceContext);
	}

	@Test
	public void testAddAndDeleteRuleInstance() throws Exception {
		int initRuleInstancesCount =
			_ruleInstanceLocalService.getRuleInstancesCount();

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestUtil.getUserId(), "rule-key", _userSegment.getUserSegmentId(),
			"type-settings", _serviceContext);

		Assert.assertEquals(
			initRuleInstancesCount + 1,
			_ruleInstanceLocalService.getRuleInstancesCount());

		_ruleInstanceLocalService.deleteRuleInstance(
			ruleInstance.getRuleInstanceId());

		Assert.assertEquals(
			initRuleInstancesCount,
			_ruleInstanceLocalService.getRuleInstancesCount());
	}

	@Test
	public void testDeleteUserSegment() throws Exception {
		int initRuleInstancesCount =
			_ruleInstanceLocalService.getRuleInstancesCount();

		_ruleInstanceLocalService.addRuleInstance(
			TestUtil.getUserId(), "rule-key", _userSegment.getUserSegmentId(),
			"type-settings", _serviceContext);

		_userSegmentLocalService.deleteUserSegment(
			_userSegment.getUserSegmentId());

		Assert.assertEquals(
			initRuleInstancesCount,
			_ruleInstanceLocalService.getRuleInstancesCount());
	}

	@ArquillianResource
	private Bundle _bundle;

	private RuleInstanceLocalService _ruleInstanceLocalService;
	private ServiceContext _serviceContext;
	private UserLocalService _userLocalService;
	private UserSegment _userSegment;
	private UserSegmentLocalService _userSegmentLocalService;

}