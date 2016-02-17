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

package com.liferay.content.targeting.analytics.util;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author Eduardo Garcia
 */
public class AnalyticsUtil {

	public static String getAnalyticsFormExcludedIdsRegex(long groupId) {
		return _getString(
			groupId, "content.targeting.analytics.form.excluded.ids.regex",
			StringPool.BLANK);
	}

	public static String getAnalyticsLinkExcludedIdsRegex(long groupId) {
		return _getString(
			groupId, "content.targeting.analytics.link.excluded.ids.regex",
			StringPool.BLANK);
	}

	public static Boolean isAnalyticsContentEnabled(long groupId) {
		return _getBoolean(
			groupId, "content.targeting.analytics.content.enabled", true);
	}

	public static Boolean isAnalyticsFormEnabled(long groupId) {
		return _getBoolean(
			groupId, "content.targeting.analytics.form.enabled", false);
	}

	public static Boolean isAnalyticsFormInteractEnabled(long groupId) {
		if (!isAnalyticsFormEnabled(groupId)) {
			return false;
		}

		return _getBoolean(
			groupId, "content.targeting.analytics.form.interact.enabled",
			false);
	}

	public static Boolean isAnalyticsFormSubmitEnabled(long groupId) {
		if (!isAnalyticsFormEnabled(groupId)) {
			return false;
		}

		return _getBoolean(
			groupId, "content.targeting.analytics.form.submit.enabled", false);
	}

	public static Boolean isAnalyticsFormViewEnabled(long groupId) {
		if (!isAnalyticsFormEnabled(groupId)) {
			return false;
		}

		return _getBoolean(
			groupId, "content.targeting.analytics.form.view.enabled", false);
	}

	public static Boolean isAnalyticsLinkClickEnabled(long groupId) {
		if (!isAnalyticsLinkEnabled(groupId)) {
			return false;
		}

		return _getBoolean(
			groupId, "content.targeting.analytics.link.click.enabled", false);
	}

	public static Boolean isAnalyticsLinkEnabled(long groupId) {
		return _getBoolean(
			groupId, "content.targeting.analytics.link.enabled", false);
	}

	public static Boolean isAnalyticsPageEnabled(long groupId) {
		return _getBoolean(
			groupId, "content.targeting.analytics.page.enabled", true);
	}

	public static Boolean isAnalyticsYoutubeEnabled(long groupId) {
		return _getBoolean(
			groupId, "content.targeting.analytics.youtube.enabled", false);
	}

	private static Boolean _getBoolean(
		long groupId, String key, boolean defaultValue) {

		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);

			UnicodeProperties typeSettingsProperties =
				group.getParentLiveGroupTypeSettingsProperties();

			boolean companyValue = PrefsPropsUtil.getBoolean(
				group.getCompanyId(), key);

			if (!companyValue) {
				return false;
			}

			return GetterUtil.getBoolean(
				typeSettingsProperties.getProperty(key), companyValue);
		}
		catch (Exception e) {
			return defaultValue;
		}
	}

	private static String _getString(
		long groupId, String key, String defaultValue) {

		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);

			UnicodeProperties typeSettingsProperties =
				group.getParentLiveGroupTypeSettingsProperties();

			String companyValue = PrefsPropsUtil.getString(
				group.getCompanyId(), key);

			return GetterUtil.getString(
				typeSettingsProperties.getProperty(key), companyValue);
		}
		catch (Exception e) {
			return defaultValue;
		}
	}

}