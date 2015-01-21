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
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.mobile.device.Device;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.mobiledevicerules.model.MDRRuleGroup;
import com.liferay.portlet.mobiledevicerules.service.MDRRuleGroupLocalServiceUtil;
import com.liferay.portlet.mobiledevicerules.service.MDRRuleLocalServiceUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Julio Camarero
 */
@RunWith(Arquillian.class)
public class DeviceRuleTest {

	@Before
	public void setUp() {
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
		_rulesRegistry = ServiceTrackerUtil.getService(
			RulesRegistry.class, _bundle.getBundleContext());
	}

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
		throws PortalException, SystemException {

		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		MDRRuleGroup mdrRuleGroup = MDRRuleGroupLocalServiceUtil.addRuleGroup(
			serviceContext.getScopeGroupId(), nameMap, nameMap, serviceContext);

		MDRRuleLocalServiceUtil.addRule(
			mdrRuleGroup.getRuleGroupId(), nameMap, nameMap,
			"com.liferay.portal.mobile.device.rulegroup.rule.impl." +
				"SimpleRuleHandler", typeSettings, serviceContext);

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

	private AnonymousUserLocalService _anonymousUserLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RulesRegistry _rulesRegistry;

}