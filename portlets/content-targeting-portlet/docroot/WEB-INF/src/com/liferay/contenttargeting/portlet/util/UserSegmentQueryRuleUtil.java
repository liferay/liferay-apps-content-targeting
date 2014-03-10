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
import com.liferay.portal.kernel.util.StringUtil;

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

	public static UserSegmentQueryRule match(
			long[] userSegmentAssetCategoryIds,
			PortletPreferences portletPreferences, Locale locale)
		throws PortalException, SystemException {

		int[] queryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null));

		for (int queryRuleIndex : queryRulesIndexes) {
			UserSegmentQueryRule queryRule = getQueryRule(
				portletPreferences, queryRuleIndex, locale);

			if (queryRule.isValid() &&
				queryRule.evaluate(userSegmentAssetCategoryIds)) {

				return queryRule;
			}
		}

		return null;
	}

}