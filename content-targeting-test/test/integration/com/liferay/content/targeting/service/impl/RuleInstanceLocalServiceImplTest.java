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

import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
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
public class RuleInstanceLocalServiceImplTest {

	@Before
	public void setUp() throws Exception {
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

		Group group = GroupTestUtil.addGroup();

		_serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-category");

		_userSegment = _userSegmentLocalService.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, _serviceContext);
	}

	@Test
	public void testAddAndDeleteRuleInstance() throws Exception {
		int initRuleInstancesCount =
			_ruleInstanceLocalService.getRuleInstancesCount();

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestPropsValues.getUserId(), "rule-key",
			_userSegment.getUserSegmentId(), "type-settings", _serviceContext);

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
			TestPropsValues.getUserId(), "rule-key",
			_userSegment.getUserSegmentId(), "type-settings", _serviceContext);

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