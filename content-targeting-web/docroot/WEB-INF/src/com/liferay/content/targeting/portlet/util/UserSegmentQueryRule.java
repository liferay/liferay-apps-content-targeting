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

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.content.targeting.util.ContentTargetingUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Locale;

import javax.portlet.PortletConfig;

/**
 * @author Eudaldo Alonso
 */
public class UserSegmentQueryRule extends AssetQueryRule implements QueryRule {

	public UserSegmentQueryRule() throws PortalException {
		this(true, true, 0, null, 0, null);
	}

	public UserSegmentQueryRule(
			boolean andOperator, boolean contains, long assetEntryId,
			long[] userSegmentAssetCategoryIds, int index, Locale locale)
		throws PortalException {

		super(assetEntryId, index, locale);

		_andOperator = andOperator;
		_contains = contains;
		_userSegmentAssetCategoryIds = validateUserSegmentAssetCategoryIds(
			userSegmentAssetCategoryIds);
	}

	public boolean evaluate(long[] userSegmentAssetCategoryIds) {
		if (isDefaultRule()) {
			return true;
		}

		if (_contains) {
			if (_andOperator) {
				return ArrayUtil.containsAll(
					userSegmentAssetCategoryIds, _userSegmentAssetCategoryIds);
			}

			for (long userSegmentAssetCategoryId :
					_userSegmentAssetCategoryIds) {

				if (ArrayUtil.contains(
						userSegmentAssetCategoryIds,
						userSegmentAssetCategoryId)) {

					return true;
				}
			}

			return false;
		}

		if (_andOperator) {
			for (long userSegmentAssetCategoryId :
					_userSegmentAssetCategoryIds) {

				if (ArrayUtil.contains(
						userSegmentAssetCategoryIds,
						userSegmentAssetCategoryId)) {

					return false;
				}
			}

			return true;
		}

		for (long userSegmentAssetCategoryId : _userSegmentAssetCategoryIds) {
			if (!ArrayUtil.contains(
					userSegmentAssetCategoryIds, userSegmentAssetCategoryId)) {

				return true;
			}
		}

		return false;
	}

	@Override
	public String getSummary(PortletConfig portletConfig, Locale locale) {
		if (ArrayUtil.isEmpty(_userSegmentAssetCategoryIds)) {
			return LanguageUtil.get(
				portletConfig.getResourceBundle(locale), "default");
		}

		String summary = StringPool.BLANK;

		if (!_contains) {
			summary += htmlOperator(null, _contains, portletConfig, locale);
		}

		return summary +
			ContentTargetingUtil.getAssetCategoryNames(
				_userSegmentAssetCategoryIds, locale,
				htmlOperator(_andOperator, _contains, portletConfig, locale));
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

	public String getUserSegmentAssetCategoryNames(Locale locale) {
		return ContentTargetingUtil.getAssetCategoryNames(
			_userSegmentAssetCategoryIds, locale);
	}

	public String getUserSegmentNames(Locale locale) {
		return ContentTargetingUtil.getAssetCategoryNames(
			_userSegmentAssetCategoryIds, locale, StringPool.COMMA_AND_SPACE);
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

	protected long[] validateUserSegmentAssetCategoryIds(
		long[] userSegmentAssetCategoryIds) {

		if (Validator.isNull(userSegmentAssetCategoryIds)) {
			return userSegmentAssetCategoryIds;
		}

		long[] validatedUserSegmentAssetCategoryIds =
			userSegmentAssetCategoryIds;

		for (long userSegmentAssetCategoryId : userSegmentAssetCategoryIds) {
			try {
				AssetCategory assetCategory =
					AssetCategoryLocalServiceUtil.fetchAssetCategory(
						userSegmentAssetCategoryId);

				if (assetCategory == null) {
					validatedUserSegmentAssetCategoryIds = ArrayUtil.remove(
						validatedUserSegmentAssetCategoryIds,
						userSegmentAssetCategoryId);
				}
			}
			catch (Exception e) {
			}
		}

		return validatedUserSegmentAssetCategoryIds;
	}

	private boolean _andOperator;
	private boolean _contains = true;
	private long[] _userSegmentAssetCategoryIds;

}