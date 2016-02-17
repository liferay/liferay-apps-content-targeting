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
import org.junit.Test;

/**
 * @author Eduardo Garcia
 */
public class CampaignQueryRuleUtilTest {

	@Test
	public void testCampaignQueryRule() throws Exception {
		QueryRule queryRule1 = new CampaignQueryRuleMock(20, 1, 0);
		QueryRule queryRuleDefault = new CampaignQueryRuleMock(10, 0, -1);

		List<QueryRule> queryRules = new ArrayList<>();

		queryRules.add(queryRule1);
		queryRules.add(queryRuleDefault);

		long[] campaignIds = new long[0];

		QueryRule queryRule = CampaignQueryRuleUtil.match(
			campaignIds, queryRules);

		Assert.assertEquals(
			queryRuleDefault.getAssetEntryId(), queryRule.getAssetEntryId());

		campaignIds = new long[] {1, 2};

		queryRule = CampaignQueryRuleUtil.match(campaignIds, queryRules);

		Assert.assertEquals(
			queryRule1.getAssetEntryId(), queryRule.getAssetEntryId());
	}

	private class CampaignQueryRuleMock extends CampaignQueryRule {

		public CampaignQueryRuleMock(
				long assetEntryId, long campaignId, int index)
			throws PortalException {

			super(assetEntryId, campaignId, index, LocaleUtil.getDefault());
		}

		@Override
		protected void initAssetEntry(Locale locale) throws PortalException {
		}

		@Override
		protected void initCampaign() {
		}

	}

}