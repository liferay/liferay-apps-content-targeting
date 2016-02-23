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

package com.liferay.content.targeting.internal;

import com.liferay.content.targeting.InvalidRuleException;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesEngine;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.GroupTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ServiceContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Pavel Savinov
 */
@RunWith(Arquillian.class)
public class DefaultRulesEngineImplTest {

	@Before
	public void setUp() throws Exception {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_anonymousUserLocalService = ServiceTrackerUtil.getService(
			AnonymousUserLocalService.class, _bundle.getBundleContext());
		_ruleInstanceLocalService = ServiceTrackerUtil.getService(
			RuleInstanceLocalService.class, _bundle.getBundleContext());
		_rulesEngine = ServiceTrackerUtil.getService(
			RulesEngine.class, _bundle.getBundleContext());
		_rulesRegistry = ServiceTrackerUtil.getService(
			RulesRegistry.class, _bundle.getBundleContext());
		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, _bundle.getBundleContext());

		Group group = GroupTestUtil.addGroup();

		_serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), "test-category");

		_anonymousUser = _anonymousUserLocalService.addAnonymousUser(
			1, "127.0.0.1", StringPool.BLANK, _serviceContext);
		_userSegment = _userSegmentLocalService.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, _serviceContext);
	}

	@After
	public void tearDown() throws Exception {
		_anonymousUserLocalService.deleteAnonymousUser(_anonymousUser);
		_userSegmentLocalService.deleteUserSegment(_userSegment);
	}

	@Test
	public void testGetMatchingUserSegmentIds() throws Exception {
		Rule rule = getTestRule();

		_rulesRegistry.getRules().put(rule.getRuleKey(), rule);

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("lastIP", "127.0.0.1");
		jsonObj.put("userAgent", "Mozilla");

		String typeSettings = jsonObj.toString();

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestPropsValues.getUserId(), "TestRule",
			_userSegment.getUserSegmentId(), typeSettings, _serviceContext);

		HttpServletRequest mockRequest = getMockRequestMatch();

		List<UserSegment> userSegments = new ArrayList<UserSegment>();

		userSegments.add(_userSegment);

		long[] userSegmentIds = _rulesEngine.getMatchingUserSegmentIds(
			mockRequest, _anonymousUser, userSegments);

		Assert.assertEquals(1, userSegmentIds.length);

		Assert.assertEquals(userSegmentIds[0], _userSegment.getUserSegmentId());

		_ruleInstanceLocalService.deleteRuleInstance(ruleInstance);
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

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestPropsValues.getUserId(), "TestRule",
			_userSegment.getUserSegmentId(), typeSettings, _serviceContext);

		List<RuleInstance> ruleInstances =
			_ruleInstanceLocalService.getRuleInstances(
				_userSegment.getUserSegmentId());

		HttpServletRequest mockRequest = getMockRequestMatch();

		Assert.assertTrue(
			_rulesEngine.matches(mockRequest, _anonymousUser, ruleInstances));

		_ruleInstanceLocalService.deleteRuleInstance(ruleInstance);
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

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestPropsValues.getUserId(), "TestRule",
			_userSegment.getUserSegmentId(), typeSettings, _serviceContext);

		List<RuleInstance> ruleInstances =
			_ruleInstanceLocalService.getRuleInstances(
				_userSegment.getUserSegmentId());

		HttpServletRequest mockRequest = getMockRequestNoMatch();

		Assert.assertFalse(
			_rulesEngine.matches(mockRequest, _anonymousUser, ruleInstances));

		_ruleInstanceLocalService.deleteRuleInstance(ruleInstance);
		_rulesRegistry.getRules().clear();
	}

	protected  HttpServletRequest getMockRequestMatch() {
		MockHttpServletRequest request = new MockHttpServletRequest();

		request.addHeader("User-Agent", "Mozilla/5.0 AppleWebKit/537.36");

		return request;
	}

	protected  HttpServletRequest getMockRequestNoMatch() {
		MockHttpServletRequest request = new MockHttpServletRequest();

		request.addHeader("User-Agent", "GoogleBot");

		return request;
	}

	protected Rule getTestRule() {
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
	private AnonymousUserLocalService _anonymousUserLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RulesEngine _rulesEngine;
	private RulesRegistry _rulesRegistry;
	private ServiceContext _serviceContext;
	private UserSegment _userSegment;
	private UserSegmentLocalService _userSegmentLocalService;

}