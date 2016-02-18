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

package com.liferay.content.targeting.rule.device;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.device.test.util.MockiPhoneDevice;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.GroupTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.mobile.device.rules.model.MDRRuleGroup;
import com.liferay.mobile.device.rules.service.MDRRuleGroupLocalServiceUtil;
import com.liferay.mobile.device.rules.service.MDRRuleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.mobile.device.Device;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.service.component.annotations.Reference;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Julio Camarero
 */
@RunWith(Arquillian.class)
public class DeviceRuleTest {

	@Test
	public void testMatchingDeviceRule() throws Exception {
		Group group = GroupTestUtil.addGroup();

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				serviceContext);

		// This rule is valid for any device

		long mdrRuleGroupId = addMDRRuleGroup(StringPool.BLANK, serviceContext);

		Rule rule = _rulesRegistry.getRule("DeviceRule");

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestPropsValues.getUserId(), rule.getRuleKey(), 0,
			getTypeSettings(mdrRuleGroupId), serviceContext);

		Assert.assertTrue(
			rule.evaluate(getRequest(), ruleInstance, anonymousUser));
	}

	@Test
	public void testNotMatchingDeviceRule() throws Exception {
		Group group = GroupTestUtil.addGroup();

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				serviceContext);

		// This rule is valid for Android devices only.

		long mdrRuleGroupId = addMDRRuleGroup("os=Android", serviceContext);

		Rule rule = _rulesRegistry.getRule("DeviceRule");

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestPropsValues.getUserId(), rule.getRuleKey(), 0,
			getTypeSettings(mdrRuleGroupId), serviceContext);

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

	@Reference(unbind = "-")
	protected void setAnonymousUserLocalService(
		AnonymousUserLocalService anonymousUserLocalService) {

		_anonymousUserLocalService = anonymousUserLocalService;
	}

	@Reference(unbind = "-")
	protected void setRuleInstanceLocalService(
		RuleInstanceLocalService ruleInstanceLocalService) {

		_ruleInstanceLocalService = ruleInstanceLocalService;
	}

	@Reference(unbind = "-")
	protected void setRulesRegistry(RulesRegistry rulesRegistry) {
		_rulesRegistry = rulesRegistry;
	}

	private AnonymousUserLocalService _anonymousUserLocalService;
	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RulesRegistry _rulesRegistry;

}