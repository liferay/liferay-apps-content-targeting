/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.portlet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

/**
 * @author Eudaldo Alonso
 */
public class CampaignQueryRuleUtil {

	public static CampaignQueryRule getQueryRule(
			ActionRequest request, int queryRulesIndex, Locale locale)
		throws PortalException, SystemException {

		long assetEntryId = ParamUtil.getLong(
			request, "assetEntryId" + queryRulesIndex);

		long campaignId = ParamUtil.getLong(
			request, "campaignId" + queryRulesIndex);

		return new CampaignQueryRule(
			assetEntryId, campaignId, queryRulesIndex, locale);
	}

	public static CampaignQueryRule getQueryRule(
			PortletPreferences portletPreferences, int queryRulesIndex,
			Locale locale)
		throws PortalException, SystemException {

		long assetEntryId = GetterUtil.getLong(
			portletPreferences.getValue(
				"assetEntryId" + queryRulesIndex, null));

		long campaignId = GetterUtil.getLong(
			portletPreferences.getValue("campaignId" + queryRulesIndex, null));

		return new CampaignQueryRule(
			assetEntryId, campaignId, queryRulesIndex, locale);
	}

	public static CampaignQueryRule match(
			long campaignId, PortletPreferences portletPreferences,
			Locale locale)
		throws PortalException, SystemException {

		int[] queryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null));

		for (int queryRuleIndex : queryRulesIndexes) {
			CampaignQueryRule queryRule = getQueryRule(
				portletPreferences, queryRuleIndex, locale);

			if (queryRule.isValid() &&
				(queryRule.getCampaignId() == campaignId)) {

				return queryRule;
			}
		}

		return null;
	}

}