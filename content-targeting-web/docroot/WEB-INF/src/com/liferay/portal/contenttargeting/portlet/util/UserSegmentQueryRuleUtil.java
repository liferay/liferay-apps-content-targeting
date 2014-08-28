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

package com.liferay.portal.contenttargeting.portlet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

/**
 * @author Eudaldo Alonso
 */
public class UserSegmentQueryRuleUtil {

	public static UserSegmentQueryRule getQueryRule(
			ActionRequest request, int queryRulesIndex, Locale locale)
		throws PortalException, SystemException {

		boolean andOperator = ParamUtil.getBoolean(
			request, "queryAndOperator" + queryRulesIndex);
		boolean contains = ParamUtil.getBoolean(
			request, "queryContains" + queryRulesIndex, true);

		long assetEntryId = ParamUtil.getLong(
			request, "assetEntryId" + queryRulesIndex);

		long[] userSegmentAssetCategoryIds = StringUtil.split(
			ParamUtil.getString(
				request, "userSegmentAssetCategoryIds" + queryRulesIndex), 0L);

		return new UserSegmentQueryRule(
			andOperator, contains, assetEntryId, userSegmentAssetCategoryIds,
			queryRulesIndex, locale);
	}

	public static UserSegmentQueryRule getQueryRule(
			PortletPreferences portletPreferences, int queryRulesIndex,
			Locale locale)
		throws PortalException, SystemException {

		boolean andOperator = GetterUtil.getBoolean(
			portletPreferences.getValue(
				"queryAndOperator" + queryRulesIndex, null));
		boolean contains = GetterUtil.getBoolean(
			portletPreferences.getValue(
				"queryContains" + queryRulesIndex, null), true);

		long assetEntryId = GetterUtil.getLong(
			portletPreferences.getValue(
				"assetEntryId" + queryRulesIndex, null));

		long[] userSegmentAssetCategoryIds = GetterUtil.getLongValues(
			portletPreferences.getValues(
				"userSegmentAssetCategoryIds" + queryRulesIndex, null));

		return new UserSegmentQueryRule(
			andOperator, contains, assetEntryId, userSegmentAssetCategoryIds,
			queryRulesIndex, locale);
	}

	public static List<AssetQueryRule> getUserSegmentQueryRules(
			PortletPreferences portletPreferences, Locale locale)
		throws PortalException, SystemException {

		List<AssetQueryRule> userSegmentQueryRules =
			new ArrayList<AssetQueryRule>();

		int[] queryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null),
			new int[0]);

		for (int queryRulesIndex : queryRulesIndexes) {
			UserSegmentQueryRule userSegmentQueryRule =
				UserSegmentQueryRuleUtil.getQueryRule(
					portletPreferences, queryRulesIndex, locale);

			if (userSegmentQueryRule.getAssetEntry() != null) {
				userSegmentQueryRules.add(userSegmentQueryRule);
			}
		}

		userSegmentQueryRules.add(
			getDefaultQueryRule(portletPreferences, locale));

		return userSegmentQueryRules;
	}

	public static AssetQueryRule match(
		long[] userSegmentAssetCategoryIds, List<AssetQueryRule> queryRules) {

		for (AssetQueryRule queryRule : queryRules) {
			if (queryRule.evaluate(userSegmentAssetCategoryIds)) {
				return queryRule;
			}
		}

		return null;
	}

	protected static UserSegmentQueryRule getDefaultQueryRule(
			PortletPreferences portletPreferences, Locale locale)
		throws PortalException, SystemException {

		long assetEntryIdDefault = GetterUtil.getLong(
			portletPreferences.getValue("assetEntryIdDefault", null));

		return new UserSegmentQueryRule(
			true, true, assetEntryIdDefault, null, -1, locale);
	}

}