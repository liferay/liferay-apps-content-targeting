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

package com.liferay.content.targeting.rule.role.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eudaldo Alonso
 */
@RunWith(Arquillian.class)
public class OrganizationRoleRuleTest {

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
	public void testOrganizationRoleRule() throws Exception {
		AnonymousUser anonymousUser =
			AnonymousUserLocalServiceUtil.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				_serviceContext);

		List<Role> roles = RoleLocalServiceUtil.getRoles(
			TestPropsValues.getCompanyId(),
			new int[] {RoleConstants.TYPE_ORGANIZATION});

		Role role = roles.get(0);

		Rule rule = _rulesRegistry.getRule("OrganizationRoleRule");

		Organization organization =
			OrganizationLocalServiceUtil.addOrganization(
				TestPropsValues.getUserId(),
				OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID,
				StringUtil.randomString(), false);

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.addRuleInstance(
				TestPropsValues.getUserId(), rule.getRuleKey(), 0,
				getTypeSettings(
					role.getRoleId(), organization.getOrganizationId()),
				_serviceContext);

		UserGroupRoleLocalServiceUtil.addUserGroupRoles(
			new long[] {TestPropsValues.getUserId()}, organization.getGroupId(),
			role.getRoleId());

		Assert.assertTrue(rule.evaluate(null, ruleInstance, anonymousUser));
	}

	protected String getTypeSettings(long roleId, long organizationId)
		throws PortalException {

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("organizationId", organizationId);
		jsonObj.put("roleId", roleId);

		return jsonObj.toString();
	}

	@DeleteAfterTestRun
	private Group _group;

	private RulesRegistry _rulesRegistry;
	private ServiceContext _serviceContext;

}