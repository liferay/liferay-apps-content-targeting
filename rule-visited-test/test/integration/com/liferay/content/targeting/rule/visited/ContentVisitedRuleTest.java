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

package com.liferay.content.targeting.rule.visited;

import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.GroupTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;

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
public class ContentVisitedRuleTest {

	@Before
	public void setUp() {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_analyticsEventLocalService = ServiceTrackerUtil.getService(
			AnalyticsEventLocalService.class, _bundle.getBundleContext());
		_anonymousUserLocalService = ServiceTrackerUtil.getService(
			AnonymousUserLocalService.class, _bundle.getBundleContext());
		_ruleInstanceLocalService = ServiceTrackerUtil.getService(
			RuleInstanceLocalService.class, _bundle.getBundleContext());
		_rulesRegistry = ServiceTrackerUtil.getService(
			RulesRegistry.class, _bundle.getBundleContext());
	}

	@Test
	public void testNotVisitedContentRule() throws Exception {
		Group group = GroupTestUtil.addGroup();

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
				group.getGroupId(), TestPropsValues.getUserId());

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				serviceContext);

		Rule rule = _rulesRegistry.getRule("ContentVisitedRule");

		BlogsEntry entry = BlogsEntryLocalServiceUtil.addEntry(
			TestPropsValues.getUserId(), "title", StringPool.BLANK,
			"This is a blog entry for testing purposes", 1, 1, 1965, 0, 0, true,
			true, null, false, null, null, null, serviceContext);

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
			BlogsEntry.class.getName(), entry.getEntryId());

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestPropsValues.getUserId(), rule.getRuleKey(), 0,
			String.valueOf(assetEntry.getEntryId()), serviceContext);

		Assert.assertFalse(rule.evaluate(null, ruleInstance, anonymousUser));
	}

	@Test
	public void testVisitedContentRule() throws Exception {
		Group group = GroupTestUtil.addGroup();

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.addAnonymousUser(
				TestPropsValues.getUserId(), "127.0.0.1", StringPool.BLANK,
				serviceContext);

		Rule rule = _rulesRegistry.getRule("ContentVisitedRule");

		BlogsEntry entry = BlogsEntryLocalServiceUtil.addEntry(
			TestPropsValues.getUserId(), "title", StringPool.BLANK,
			"This is a blog entry for testing purposes", 1, 1, 1965, 0, 0, true,
			true, null, false, null, null, null, serviceContext);

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
			BlogsEntry.class.getName(), entry.getEntryId());

		_analyticsEventLocalService.addAnalyticsEvent(
			1, anonymousUser.getAnonymousUserId(), BlogsEntry.class.getName(),
			entry.getEntryId(), Layout.class.getName(), new long[]{1}, null,
			"view", "127.0.0.1", "User Agent", "ES", "http://localhost", null,
			serviceContext);

		RuleInstance ruleInstance = _ruleInstanceLocalService.addRuleInstance(
			TestPropsValues.getUserId(), rule.getRuleKey(), 0,
			String.valueOf(assetEntry.getEntryId()), serviceContext);

		Assert.assertTrue(rule.evaluate(null, ruleInstance, anonymousUser));
	}

	private AnalyticsEventLocalService _analyticsEventLocalService;
	private AnonymousUserLocalService _anonymousUserLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RulesRegistry _rulesRegistry;

}