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

package com.liferay.contenttargeting.rules.organizationmember;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.anonymoususers.service.AnonymousUserLocalService;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.api.model.RulesRegistry;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.service.RuleInstanceLocalService;
import com.liferay.organizationmember.test.util.TestUtil;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;

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
public class OrganizationMemberTest {

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
	public void testOrganizationMemberRule() throws Exception {
		ServiceContext serviceContext = TestUtil.getServiceContext();

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.addAnonymousUser(
				TestUtil.getUserId(), "127.0.0.1", StringPool.BLANK,
				serviceContext);

		Rule rule = _rulesRegistry.getRule("OrganizationMemberRule");

		Organization organization =
			OrganizationLocalServiceUtil.addOrganization(
				TestUtil.getUserId(),
				OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID,
				StringUtil.randomString(), false);

		OrganizationLocalServiceUtil.addUserOrganization(
			TestUtil.getUserId(), organization.getOrganizationId());

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestUtil.getUserId(), rule.getRuleKey(), 0,
			String.valueOf(organization.getOrganizationId()), serviceContext);

		Assert.assertTrue(rule.evaluate(null, ruleInstance, anonymousUser));
	}

	private AnonymousUserLocalService _anonymousUserLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RulesRegistry _rulesRegistry;

}