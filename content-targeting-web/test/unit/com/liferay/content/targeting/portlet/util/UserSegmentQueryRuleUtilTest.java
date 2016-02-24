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

package com.liferay.content.targeting.portlet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Eduardo Garcia
 */
public class UserSegmentQueryRuleUtilTest {

	@Before
	public void setUp() throws Exception {
		_queryRuleDefault = new UserSegmentQueryRuleMock(
			true, true, 10, null, -1);
	}

	@Test
	public void testUserSegmentQueryRuleContainsAll() throws Exception {
		QueryRule queryRule1and2 = new UserSegmentQueryRuleMock(
			true, true, 20, new long[] {1, 2}, 0);

		_queryRules.add(queryRule1and2);
		_queryRules.add(_queryRuleDefault);

		long[] userSegmentAssetCategoryIds = new long[] {1};

		QueryRule queryRule = UserSegmentQueryRuleUtil.match(
			userSegmentAssetCategoryIds, _queryRules);

		Assert.assertEquals(
			_queryRuleDefault.getAssetEntryId(), queryRule.getAssetEntryId());

		userSegmentAssetCategoryIds = new long[] {1, 2};

		queryRule = UserSegmentQueryRuleUtil.match(
			userSegmentAssetCategoryIds, _queryRules);

		Assert.assertEquals(
			queryRule1and2.getAssetEntryId(), queryRule.getAssetEntryId());
	}

	@Test
	public void testUserSegmentQueryRuleContainsAny() throws Exception {
		QueryRule queryRule1or2 = new UserSegmentQueryRuleMock(
			false, true, 20, new long[] {1, 2}, 0);

		_queryRules.add(queryRule1or2);
		_queryRules.add(_queryRuleDefault);

		long[] userSegmentAssetCategoryIds = new long[] {1};

		QueryRule queryRule = UserSegmentQueryRuleUtil.match(
			userSegmentAssetCategoryIds, _queryRules);

		Assert.assertEquals(
			queryRule1or2.getAssetEntryId(), queryRule.getAssetEntryId());
	}

	@Test
	public void testUserSegmentQueryRuleNotContainsAll() throws Exception {
		QueryRule queryRuleNot1and2 = new UserSegmentQueryRuleMock(
			true, false, 20, new long[] {1, 2}, 0);

		_queryRules.add(queryRuleNot1and2);
		_queryRules.add(_queryRuleDefault);

		long[] userSegmentAssetCategoryIds = new long[0];

		QueryRule queryRule = UserSegmentQueryRuleUtil.match(
			userSegmentAssetCategoryIds, _queryRules);

		Assert.assertEquals(
			queryRuleNot1and2.getAssetEntryId(), queryRule.getAssetEntryId());

		userSegmentAssetCategoryIds = new long[] {1};

		queryRule = UserSegmentQueryRuleUtil.match(
			userSegmentAssetCategoryIds, _queryRules);

		Assert.assertEquals(
			_queryRuleDefault.getAssetEntryId(), queryRule.getAssetEntryId());
	}

	@Test
	public void testUserSegmentQueryRuleNotContainsAny() throws Exception {
		QueryRule queryRuleNot1or2 = new UserSegmentQueryRuleMock(
			false, false, 20, new long[] {1, 2}, 0);

		_queryRules.add(queryRuleNot1or2);
		_queryRules.add(_queryRuleDefault);

		long[] userSegmentAssetCategoryIds = new long[] {1};

		QueryRule queryRule = UserSegmentQueryRuleUtil.match(
			userSegmentAssetCategoryIds, _queryRules);

		Assert.assertEquals(
			queryRuleNot1or2.getAssetEntryId(), queryRule.getAssetEntryId());

		userSegmentAssetCategoryIds = new long[] {1, 2};

		queryRule = UserSegmentQueryRuleUtil.match(
			userSegmentAssetCategoryIds, _queryRules);

		Assert.assertEquals(
			_queryRuleDefault.getAssetEntryId(), queryRule.getAssetEntryId());
	}

	private QueryRule _queryRuleDefault;
	private final List<QueryRule> _queryRules = new ArrayList<>();

	private class UserSegmentQueryRuleMock extends UserSegmentQueryRule {

		public UserSegmentQueryRuleMock(
				boolean andOperator, boolean contains, long assetEntryId,
				long[] userSegmentAssetCategoryIds, int index)
			throws PortalException {

			super(
				andOperator, contains, assetEntryId,
				userSegmentAssetCategoryIds, index, LocaleUtil.getDefault());
		}

		@Override
		protected void initAssetEntry(Locale locale) throws PortalException {
		}

		@Override
		protected long[] validateUserSegmentAssetCategoryIds(
			long[] userSegmentAssetCategoryIds) {

			return userSegmentAssetCategoryIds;
		}

	}

}