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

package com.liferay.content.targeting.rule.organization.member;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@RunWith(Arquillian.class)
public class OrganizationMemberRuleTest {

	@Test
	public void testOrganizationMemberRule() throws Exception {
		ServiceContext serviceContext = ServiceTestUtil.getServiceContext();

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				serviceContext);

		Rule rule = _rulesRegistry.getRule("OrganizationMemberRule");

		Organization organization =
			OrganizationLocalServiceUtil.addOrganization(
				TestPropsValues.getUserId(),
				OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID,
				StringUtil.randomString(), false);

		OrganizationLocalServiceUtil.addUserOrganization(
			TestPropsValues.getUserId(), organization.getOrganizationId());

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestPropsValues.getUserId(), rule.getRuleKey(), 0,
			String.valueOf(organization.getOrganizationId()), serviceContext);

		Assert.assertTrue(rule.evaluate(null, ruleInstance, anonymousUser));
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