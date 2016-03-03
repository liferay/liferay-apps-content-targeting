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

package com.liferay.content.targeting.internal.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesEngine;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.exception.InvalidRuleException;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Pavel Savinov
 */
@RunWith(Arquillian.class)
public class DefaultRulesEngineImplTest {

	@ClassRule
	@org.junit.Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			_group.getGroupId(), TestPropsValues.getUserId());

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), "test-category");

		_anonymousUser = AnonymousUserLocalServiceUtil.addAnonymousUser(
			1, "127.0.0.1", StringPool.BLANK, _serviceContext);
		_userSegment = UserSegmentLocalServiceUtil.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, _serviceContext);

		Registry registry = RegistryUtil.getRegistry();

		_rulesEngine = registry.getService(RulesEngine.class);
		_rulesRegistry = registry.getService(RulesRegistry.class);
	}

	@Test
	public void testGetMatchingUserSegmentIds() throws Exception {
		Rule rule = getTestRule();

		_rulesRegistry.getRules().put(rule.getRuleKey(), rule);

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("lastIP", "127.0.0.1");
		jsonObj.put("userAgent", "Mozilla");

		String typeSettings = jsonObj.toString();

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.addRuleInstance(
				TestPropsValues.getUserId(), "TestRule",
				_userSegment.getUserSegmentId(), typeSettings, _serviceContext);

		HttpServletRequest mockRequest = getMockRequestMatch();

		List<UserSegment> userSegments = new ArrayList<>();

		userSegments.add(_userSegment);

		long[] userSegmentIds = _rulesEngine.getMatchingUserSegmentIds(
			mockRequest, _anonymousUser, userSegments);

		Assert.assertEquals(1, userSegmentIds.length);

		Assert.assertEquals(userSegmentIds[0], _userSegment.getUserSegmentId());

		RuleInstanceLocalServiceUtil.deleteRuleInstance(ruleInstance);
		_rulesRegistry.getRules().clear();
	}

	@Test
	public void testMatches() throws Exception {
		Rule rule = getTestRule();

		_rulesRegistry.getRules().put(rule.getRuleKey(), rule);

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("lastIP", "127.0.0.1");
		jsonObj.put("userAgent", "Mozilla");

		String typeSettings = jsonObj.toString();

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.addRuleInstance(
				TestPropsValues.getUserId(), "TestRule",
				_userSegment.getUserSegmentId(), typeSettings, _serviceContext);

		List<RuleInstance> ruleInstances =
			RuleInstanceLocalServiceUtil.getRuleInstances(
				_userSegment.getUserSegmentId());

		HttpServletRequest mockRequest = getMockRequestMatch();

		Assert.assertTrue(
			_rulesEngine.matches(mockRequest, _anonymousUser, ruleInstances));

		RuleInstanceLocalServiceUtil.deleteRuleInstance(ruleInstance);

		_rulesRegistry.getRules().clear();
	}

	@Test
	public void testNoMatches() throws Exception {
		Rule rule = getTestRule();

		_rulesRegistry.getRules().put(rule.getRuleKey(), rule);

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("lastIP", "127.0.0.1");
		jsonObj.put("userAgent", "Mozilla");

		String typeSettings = jsonObj.toString();

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.addRuleInstance(
				TestPropsValues.getUserId(), "TestRule",
				_userSegment.getUserSegmentId(), typeSettings, _serviceContext);

		List<RuleInstance> ruleInstances =
			RuleInstanceLocalServiceUtil.getRuleInstances(
				_userSegment.getUserSegmentId());

		HttpServletRequest mockRequest = getMockRequestNoMatch();

		Assert.assertFalse(
			_rulesEngine.matches(mockRequest, _anonymousUser, ruleInstances));

		RuleInstanceLocalServiceUtil.deleteRuleInstance(ruleInstance);

		_rulesRegistry.getRules().clear();
	}

	protected HttpServletRequest getMockRequestMatch() {
		MockHttpServletRequest request = new MockHttpServletRequest();

		request.addHeader("User-Agent", "Mozilla/5.0 AppleWebKit/537.36");

		return request;
	}

	protected HttpServletRequest getMockRequestNoMatch() {
		MockHttpServletRequest request = new MockHttpServletRequest();

		request.addHeader("User-Agent", "GoogleBot");

		return request;
	}

	protected com.liferay.content.targeting.api.model.Rule getTestRule() {
		Rule rule = new BaseRule() {

			@Override
			public boolean evaluate(
				HttpServletRequest request, RuleInstance ruleInstance,
				AnonymousUser anonymousUser) throws Exception {

				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					ruleInstance.getTypeSettings());

				if (!anonymousUser.getLastIp().equals(
						jsonObj.getString("lastIP"))) {

					return false;
				}

				if (!request.getHeader("User-Agent").contains(
						jsonObj.getString("userAgent"))) {

					return false;
				}

				return true;
			}

			@Override
			public String getRuleKey() {
				return "TestRule";
			}

			@Override
			public String getSummary(RuleInstance ruleInstance, Locale locale) {
				return "Test";
			}

			@Override
			public String processRule(
				PortletRequest request, PortletResponse response, String id,
				Map<String, String> values) throws InvalidRuleException {

				return null;
			}

		};

		return rule;
	}

	private AnonymousUser _anonymousUser;

	@DeleteAfterTestRun
	private Group _group;

	private RulesEngine _rulesEngine;
	private RulesRegistry _rulesRegistry;
	private ServiceContext _serviceContext;
	private UserSegment _userSegment;

}