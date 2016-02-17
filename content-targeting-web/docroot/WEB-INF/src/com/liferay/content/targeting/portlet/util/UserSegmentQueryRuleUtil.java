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

	public static QueryRule getQueryRule(
			ActionRequest request, int queryRulesIndex, Locale locale)
		throws PortalException {

		boolean andOperator = ParamUtil.getBoolean(
			request, "queryAndOperator" + queryRulesIndex);
		boolean contains = ParamUtil.getBoolean(
			request, "queryContains" + queryRulesIndex, true);

		long assetEntryId = ParamUtil.getLong(
			request, "assetEntryId" + queryRulesIndex);

		long[] userSegmentAssetCategoryIds = StringUtil.split(
			ParamUtil.getString(
				request, "userSegmentAssetCategoryIds" + queryRulesIndex),
			0L);

		return new UserSegmentQueryRule(
			andOperator, contains, assetEntryId, userSegmentAssetCategoryIds,
			queryRulesIndex, locale);
	}

	public static QueryRule getQueryRule(
			PortletPreferences portletPreferences, int queryRulesIndex,
			Locale locale)
		throws PortalException {

		boolean andOperator = GetterUtil.getBoolean(
			portletPreferences.getValue(
				"queryAndOperator" + queryRulesIndex, null));
		boolean contains = GetterUtil.getBoolean(
			portletPreferences.getValue(
				"queryContains" + queryRulesIndex, null),
			true);

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

	public static List<QueryRule> getUserSegmentQueryRules(
			PortletPreferences portletPreferences, Locale locale,
			boolean includeEmptyQueryRule)
		throws PortalException {

		List<QueryRule> userSegmentQueryRules = new ArrayList<>();

		int[] queryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null),
			new int[0]);

		for (int queryRulesIndex : queryRulesIndexes) {
			QueryRule userSegmentQueryRule = getQueryRule(
				portletPreferences, queryRulesIndex, locale);

			if (userSegmentQueryRule.isValid()) {
				userSegmentQueryRules.add(userSegmentQueryRule);
			}
		}

		if (userSegmentQueryRules.isEmpty() && includeEmptyQueryRule) {
			userSegmentQueryRules.add(new UserSegmentQueryRule());
		}

		userSegmentQueryRules.add(
			getDefaultQueryRule(portletPreferences, locale));

		return userSegmentQueryRules;
	}

	public static QueryRule match(
		long[] userSegmentAssetCategoryIds, List<QueryRule> queryRules) {

		for (QueryRule queryRule : queryRules) {
			if (queryRule.evaluate(userSegmentAssetCategoryIds)) {
				return queryRule;
			}
		}

		return queryRules.get(queryRules.size() - 1);
	}

	protected static QueryRule getDefaultQueryRule(
			PortletPreferences portletPreferences, Locale locale)
		throws PortalException {

		long assetEntryIdDefault = GetterUtil.getLong(
			portletPreferences.getValue("assetEntryIdDefault", null));

		return new UserSegmentQueryRule(
			true, true, assetEntryIdDefault, null, -1, locale);
	}

}