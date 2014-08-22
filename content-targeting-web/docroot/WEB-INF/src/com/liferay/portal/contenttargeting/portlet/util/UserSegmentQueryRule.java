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
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;

import java.util.Locale;

import javax.portlet.PortletConfig;

/**
 * @author Eudaldo Alonso
 */
public class UserSegmentQueryRule extends AssetQueryRule {

	public UserSegmentQueryRule(
			boolean andOperator, boolean contains, long assetEntryId,
			long[] userSegmentAssetCategoryIds, int index, Locale locale)
		throws PortalException, SystemException {

		super(assetEntryId, index, locale);

		_andOperator = andOperator;
		_contains = contains;
		_userSegmentAssetCategoryIds = userSegmentAssetCategoryIds;
	}

	public boolean evaluate(long[] userSegmentAssetCategoryIds) {
		if (_contains) {
			if (_andOperator) {
				return ArrayUtil.containsAll(
					_userSegmentAssetCategoryIds, userSegmentAssetCategoryIds);
			}
			else {
				for (long userSegmentAssetCategoryId :
						userSegmentAssetCategoryIds) {

					if (ArrayUtil.contains(
							_userSegmentAssetCategoryIds,
							userSegmentAssetCategoryId)) {

						return true;
					}
				}

				return false;
			}
		}
		else {
			if (_andOperator) {
				for (long userSegmentAssetCategoryId :
						userSegmentAssetCategoryIds) {

					if (ArrayUtil.contains(
							_userSegmentAssetCategoryIds,
							userSegmentAssetCategoryId)) {

						return false;
					}
				}

				return true;
			}
			else {
				for (long userSegmentAssetCategoryId :
						userSegmentAssetCategoryIds) {

					if (!ArrayUtil.contains(
							_userSegmentAssetCategoryIds,
							userSegmentAssetCategoryId)) {

						return true;
					}
				}

				return false;
			}
		}
	}

	public String getSummary(PortletConfig portletConfig, Locale locale)
		throws SystemException {

		String userSegmentNames = getUserSegmentNames(locale);

		if (ArrayUtil.isEmpty(_userSegmentAssetCategoryIds)) {
			return LanguageUtil.get(portletConfig, locale, "default");
		}

		String userSegmentQueryRuleContains =
			_contains ? "belongs" : "does-not-belong";

		String userSegmentQueryRuleAndOperator = _andOperator ? "all" : "any";

		if (_contains) {
			String operator = _andOperator ?
				LanguageUtil.get(portletConfig, locale, "and") :
				LanguageUtil.get(portletConfig, locale, "or");

			return getUserSegmentNames(
				locale,
				StringPool.SPACE + StringUtil.toLowerCase(operator) +
					StringPool.SPACE);
		}
		else {
			String operator = _andOperator ?
				LanguageUtil.get(portletConfig, locale, "and") :
				LanguageUtil.get(portletConfig, locale, "or");

			String notOperator = LanguageUtil.get(portletConfig, locale, "not");

			return notOperator + StringPool.SPACE + getUserSegmentNames(
				locale,
				StringPool.SPACE + StringUtil.toLowerCase(operator) +
					StringPool.SPACE + StringUtil.toLowerCase(notOperator) +
					StringPool.SPACE);
		}
	}

	public long[] getUserSegmentAssetCategoryIds() {
		return _userSegmentAssetCategoryIds;
	}

	public String getUserSegmentAssetCategoryIdsAsString() {
		if (ArrayUtil.isEmpty(_userSegmentAssetCategoryIds)) {
			return StringPool.BLANK;
		}

		return StringUtil.merge(_userSegmentAssetCategoryIds);
	}

	public String getUserSegmentAssetCategoryNames(Locale locale)
		throws SystemException {

		return getUserSegmentNames(locale, _CATEGORY_SEPARATOR);
	}

	public String getUserSegmentNames(Locale locale) throws SystemException {
		return getUserSegmentNames(locale, StringPool.COMMA_AND_SPACE);
	}

	public boolean isAndOperator() {
		return _andOperator;
	}

	public boolean isContains() {
		return _contains;
	}

	public boolean isValid() {
		if (!super.isValid() ||
			ArrayUtil.isEmpty(_userSegmentAssetCategoryIds)) {

			return false;
		}

		return true;
	}

	public void setAndOperator(boolean andOperator) {
		_andOperator = andOperator;
	}

	public void setContains(boolean contains) {
		_contains = contains;
	}

	public void setUserSegmentAssetCategoryIds(
		long[] userSegmentAssetCategoryIds) {

		_userSegmentAssetCategoryIds = userSegmentAssetCategoryIds;
	}

	protected String getUserSegmentNames(Locale locale, String separator)
		throws SystemException {

		if (ArrayUtil.isEmpty(_userSegmentAssetCategoryIds)) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(
			(_userSegmentAssetCategoryIds.length * 2) - 1);

		for (int i = 0; i < _userSegmentAssetCategoryIds.length; i++) {
			AssetCategory assetCategory =
				AssetCategoryLocalServiceUtil.fetchAssetCategory(
					_userSegmentAssetCategoryIds[i]);

			if (assetCategory == null) {
				continue;
			}

			sb.append(assetCategory.getTitle(locale));

			if (i != (_userSegmentAssetCategoryIds.length - 1)) {
				sb.append(separator);
			}
		}

		return sb.toString();
	}

	private static final String _CATEGORY_SEPARATOR = "_CATEGORY_";

	private boolean _andOperator;
	private boolean _contains = true;
	private long[] _userSegmentAssetCategoryIds;

}