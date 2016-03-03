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

package com.liferay.content.targeting.rule.device.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.device.test.util.MockiPhoneDevice;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.mobile.device.rules.model.MDRRuleGroup;
import com.liferay.mobile.device.rules.service.MDRRuleGroupLocalServiceUtil;
import com.liferay.mobile.device.rules.service.MDRRuleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.mobile.device.Device;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Julio Camarero
 */
@RunWith(Arquillian.class)
public class DeviceRuleTest {

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
	public void testMatchingDeviceRule() throws Exception {
		AnonymousUser anonymousUser =
			AnonymousUserLocalServiceUtil.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				_serviceContext);

		// This rule is valid for any device

		long mdrRuleGroupId = addMDRRuleGroup(
			StringPool.BLANK, _serviceContext);

		Rule rule = _rulesRegistry.getRule("DeviceRule");

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.addRuleInstance(
				TestPropsValues.getUserId(), rule.getRuleKey(), 0,
				getTypeSettings(mdrRuleGroupId), _serviceContext);

		Assert.assertTrue(
			rule.evaluate(getRequest(), ruleInstance, anonymousUser));
	}

	@Test
	public void testNotMatchingDeviceRule() throws Exception {
		AnonymousUser anonymousUser =
			AnonymousUserLocalServiceUtil.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				_serviceContext);

		// This rule is valid for Android devices only.

		long mdrRuleGroupId = addMDRRuleGroup("os=Android", _serviceContext);

		Rule rule = _rulesRegistry.getRule("DeviceRule");

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.addRuleInstance(
				TestPropsValues.getUserId(), rule.getRuleKey(), 0,
				getTypeSettings(mdrRuleGroupId), _serviceContext);

		Assert.assertFalse(
			rule.evaluate(getRequest(), ruleInstance, anonymousUser));
	}

	protected long addMDRRuleGroup(
			String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		MDRRuleGroup mdrRuleGroup = MDRRuleGroupLocalServiceUtil.addRuleGroup(
			serviceContext.getScopeGroupId(), nameMap, nameMap, serviceContext);

		MDRRuleLocalServiceUtil.addRule(
			mdrRuleGroup.getRuleGroupId(), nameMap, nameMap,
			"com.liferay.mobile.device.rules.rule.group.rule.SimpleRuleHandler",
			typeSettings, serviceContext);

		return mdrRuleGroup.getRuleGroupId();
	}

	protected HttpServletRequest getRequest() {
		HttpServletRequest request = new MockHttpServletRequest();

		ThemeDisplay themeDisplay = new ThemeDisplay();

		Device device = new MockiPhoneDevice();

		themeDisplay.setDevice(device);

		request.setAttribute(WebKeys.THEME_DISPLAY, themeDisplay);

		return request;
	}

	protected String getTypeSettings(long mdrRuleGroupId) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("mdrRuleGroupId", mdrRuleGroupId);

		return jsonObj.toString();
	}

	@DeleteAfterTestRun
	private Group _group;

	private RulesRegistry _rulesRegistry;
	private ServiceContext _serviceContext;

}