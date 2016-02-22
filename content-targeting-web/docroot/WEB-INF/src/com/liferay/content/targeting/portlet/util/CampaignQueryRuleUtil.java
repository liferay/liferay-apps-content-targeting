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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

/**
 * @author Eudaldo Alonso
 */
public class CampaignQueryRuleUtil {

	public static List<QueryRule> getCampaignQueryRules(
			PortletPreferences portletPreferences, Locale locale,
			boolean includeEmptyQueryRule)
		throws PortalException {

		List<QueryRule> campaignQueryRules = new ArrayList<>();

		int[] queryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null),
			new int[0]);

		for (int queryRulesIndex : queryRulesIndexes) {
			QueryRule campaignQueryRule = getQueryRule(
				portletPreferences, queryRulesIndex, locale);

			if (campaignQueryRule.isValid()) {
				campaignQueryRules.add(campaignQueryRule);
			}
		}

		if (campaignQueryRules.isEmpty() && includeEmptyQueryRule) {
			campaignQueryRules.add(new CampaignQueryRule());
		}

		Collections.sort(campaignQueryRules);

		campaignQueryRules.add(getDefaultQueryRule(portletPreferences, locale));

		return campaignQueryRules;
	}

	public static QueryRule getQueryRule(
			ActionRequest request, int queryRulesIndex, Locale locale)
		throws PortalException {

		long assetEntryId = ParamUtil.getLong(
			request, "assetEntryId" + queryRulesIndex);

		long campaignId = ParamUtil.getLong(
			request, "campaignId" + queryRulesIndex);

		return new CampaignQueryRule(
			assetEntryId, campaignId, queryRulesIndex, locale);
	}

	public static QueryRule getQueryRule(
			PortletPreferences portletPreferences, int queryRulesIndex,
			Locale locale)
		throws PortalException {

		long assetEntryId = GetterUtil.getLong(
			portletPreferences.getValue(
				"assetEntryId" + queryRulesIndex, null));

		long campaignId = GetterUtil.getLong(
			portletPreferences.getValue("campaignId" + queryRulesIndex, null));

		return new CampaignQueryRule(
			assetEntryId, campaignId, queryRulesIndex, locale);
	}

	public static QueryRule match(
			long[] campaignIds, List<QueryRule> queryRules)
		throws PortalException {

		for (QueryRule queryRule : queryRules) {
			if (queryRule.evaluate(campaignIds)) {
				return queryRule;
			}
		}

		return queryRules.get(queryRules.size() - 1);
	}

	protected static CampaignQueryRule getDefaultQueryRule(
			PortletPreferences portletPreferences, Locale locale)
		throws PortalException {

		long assetEntryIdDefault = GetterUtil.getLong(
			portletPreferences.getValue("assetEntryIdDefault", null));

		return new CampaignQueryRule(assetEntryIdDefault, 0, -1, locale);
	}

}