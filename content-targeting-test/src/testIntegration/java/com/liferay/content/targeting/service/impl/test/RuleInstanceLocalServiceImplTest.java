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

package com.liferay.content.targeting.service.impl.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class RuleInstanceLocalServiceImplTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			_group.getGroupId(), TestPropsValues.getUserId());

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), "test-category");

		_userSegment = UserSegmentLocalServiceUtil.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, _serviceContext);
	}

	@Test
	public void testAddAndDeleteRuleInstance() throws Exception {
		int initRuleInstancesCount =
			RuleInstanceLocalServiceUtil.getRuleInstancesCount();

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.addRuleInstance(
				TestPropsValues.getUserId(), "rule-key",
				_userSegment.getUserSegmentId(), "type-settings",
				_serviceContext);

		Assert.assertEquals(
			initRuleInstancesCount + 1,
			RuleInstanceLocalServiceUtil.getRuleInstancesCount());

		RuleInstanceLocalServiceUtil.deleteRuleInstance(
			ruleInstance.getRuleInstanceId());

		Assert.assertEquals(
			initRuleInstancesCount,
			RuleInstanceLocalServiceUtil.getRuleInstancesCount());
	}

	@Test
	public void testDeleteUserSegment() throws Exception {
		int initRuleInstancesCount =
			RuleInstanceLocalServiceUtil.getRuleInstancesCount();

		RuleInstanceLocalServiceUtil.addRuleInstance(
			TestPropsValues.getUserId(), "rule-key",
			_userSegment.getUserSegmentId(), "type-settings", _serviceContext);

		UserSegmentLocalServiceUtil.deleteUserSegment(
			_userSegment.getUserSegmentId());

		Assert.assertEquals(
			initRuleInstancesCount,
			RuleInstanceLocalServiceUtil.getRuleInstancesCount());
	}

	@DeleteAfterTestRun
	private Group _group;

	private ServiceContext _serviceContext;
	private UserSegment _userSegment;

}