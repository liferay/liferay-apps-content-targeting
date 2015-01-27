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

package com.liferay.content.targeting.rule.custom.field;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.NoSuchTableException;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

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
public class CustomFieldRuleTest {

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
	public void testCustomFieldRule() throws Exception {
		ServiceContext serviceContext = ServiceTestUtil.getServiceContext();

		String attributeName = "Test Attribute";
		String attributeValue = "Test Attribute Value";

		// Add custom field for users

		_addUserExpandoColumn(
			serviceContext.getCompanyId(), User.class.getName(), attributeName,
			ExpandoColumnConstants.STRING);

		// Set custom field for test user

		ExpandoBridge userExpandoBridge =
			ExpandoBridgeFactoryUtil.getExpandoBridge(
				serviceContext.getCompanyId(), User.class.getName(),
				TestPropsValues.getUserId());

		userExpandoBridge.setAttribute(attributeName, attributeValue, false);

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				serviceContext);

		// Set custom field for rule

		long classPK = CounterLocalServiceUtil.increment();

		ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(
			serviceContext.getCompanyId(), User.class.getName(), classPK);

		expandoBridge.setAttribute(attributeName, attributeValue, false);

		Rule rule = _rulesRegistry.getRule("CustomFieldRule");

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("attributeName", attributeName);
		jsonObj.put("classPK", classPK);

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestPropsValues.getUserId(), rule.getRuleKey(), 0,
			jsonObj.toString(), serviceContext);

		Assert.assertTrue(rule.evaluate(null, ruleInstance, anonymousUser));

		userExpandoBridge.setAttribute(attributeName, StringPool.BLANK, false);

		Assert.assertFalse(rule.evaluate(null, ruleInstance, anonymousUser));
	}

	private void _addUserExpandoColumn(
			long companyId, String className, String columnName, int columnType)
		throws Exception {

		ExpandoTable expandoTable = null;

		try {
			expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(
				companyId, className);
		}
		catch (NoSuchTableException nste) {
			expandoTable = ExpandoTableLocalServiceUtil.addDefaultTable(
				companyId, className);
		}

		ExpandoColumn expandoColumn =
			ExpandoColumnLocalServiceUtil.getColumn(
					expandoTable.getTableId(), columnName);

		if (expandoColumn != null) {
			ExpandoColumnLocalServiceUtil.updateColumn(
				expandoColumn.getColumnId(), columnName, columnType);
		}
		else {
			ExpandoColumnLocalServiceUtil.addColumn(
				expandoTable.getTableId(), columnName, columnType);
		}
	}

	private AnonymousUserLocalService _anonymousUserLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RulesRegistry _rulesRegistry;

}