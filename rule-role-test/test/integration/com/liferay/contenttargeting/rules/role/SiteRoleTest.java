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

package com.liferay.contenttargeting.rules.role;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.anonymoususers.service.AnonymousUserLocalService;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.service.RuleInstanceLocalService;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.role.test.util.TestUtil;

import java.util.List;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * @author Eudaldo Alonso
 */
@RunWith(Arquillian.class)
public class SiteRoleTest {

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
	public void testSiteRoleRule() throws Exception {
		ServiceContext serviceContext = TestUtil.getServiceContext();

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.addAnonymousUser(
				TestUtil.getUserId(), "127.0.0.1", StringPool.BLANK,
				serviceContext);

		List<Role> roles = RoleLocalServiceUtil.getRoles(
			TestUtil.getCompanyId(), new int[]{RoleConstants.TYPE_SITE});

		Role role = roles.get(0);

		Rule rule = _rulesRegistry.getRule("SiteRoleRule");

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestUtil.getUserId(), rule.getRuleKey(), 0,
			getTypeSettings(role.getRoleId()), serviceContext);

		UserGroupRoleLocalServiceUtil.addUserGroupRoles(
			new long[]{TestUtil.getUserId()}, _group.getGroupId(),
			role.getRoleId());

		Assert.assertTrue(rule.evaluate(null, ruleInstance, anonymousUser));
	}

	protected String getTypeSettings(long roleId)
		throws PortalException, SystemException {

		_group = TestUtil.addGroup();

		GroupLocalServiceUtil.addUserGroup(
			TestUtil.getUserId(), _group.getGroupId());

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("siteId", _group.getGroupId());
		jsonObj.put("roleId", roleId);

		return jsonObj.toString();
	}

	private AnonymousUserLocalService _anonymousUserLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private Group _group;
	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RulesRegistry _rulesRegistry;

}