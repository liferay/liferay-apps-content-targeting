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

package com.liferay.content.targeting.rule.visited.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalServiceUtil;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eudaldo Alonso
 */
@RunWith(Arquillian.class)
public class PageVisitedRuleTest {

	@ClassRule
	@org.junit.Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			_group.getGroupId(), TestPropsValues.getUserId());

		Registry registry = RegistryUtil.getRegistry();

		_rulesRegistry = registry.getService(RulesRegistry.class);
	}

	@Test
	public void testNotVisitedPageRule() throws Exception {
		AnonymousUser anonymousUser =
			AnonymousUserLocalServiceUtil.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				_serviceContext);

		Rule rule = _rulesRegistry.getRule("PageVisitedRule");

		Layout layout = LayoutLocalServiceUtil.addLayout(
			TestPropsValues.getUserId(), _group.getGroupId(), false,
			LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, "Layout", "Layout",
			StringPool.BLANK, LayoutConstants.TYPE_PORTLET, false,
			StringPool.BLANK, _serviceContext);

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.addRuleInstance(
				TestPropsValues.getUserId(), rule.getRuleKey(), 0,
				String.valueOf(layout.getPlid()), _serviceContext);

		Assert.assertFalse(rule.evaluate(null, ruleInstance, anonymousUser));
	}

	@Test
	public void testVisitedPageRule() throws Exception {
		AnonymousUser anonymousUser =
			AnonymousUserLocalServiceUtil.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				_serviceContext);

		Rule rule = _rulesRegistry.getRule("PageVisitedRule");

		Layout layout = LayoutLocalServiceUtil.addLayout(
			TestPropsValues.getUserId(), _group.getGroupId(), false,
			LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, "Layout", "Layout",
			StringPool.BLANK, LayoutConstants.TYPE_PORTLET, false,
			StringPool.BLANK, _serviceContext);

		AnalyticsEventLocalServiceUtil.addAnalyticsEvent(
			1, anonymousUser.getAnonymousUserId(), Layout.class.getName(),
			layout.getPlid(), Layout.class.getName(), new long[] {1}, null,
			"view", "127.0.0.1", "User Agent", "ES", "http://localhost", null,
			_serviceContext);

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.addRuleInstance(
				TestPropsValues.getUserId(), rule.getRuleKey(), 0,
				String.valueOf(layout.getPlid()), _serviceContext);

		Assert.assertTrue(rule.evaluate(null, ruleInstance, anonymousUser));
	}

	@DeleteAfterTestRun
	private Group _group;

	private RulesRegistry _rulesRegistry;
	private ServiceContext _serviceContext;

}