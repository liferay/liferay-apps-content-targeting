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

import com.liferay.content.targeting.analytics.configuration.AnalyticsServiceConfigurationKeys;
import com.liferay.content.targeting.analytics.configuration.AnalyticsServiceConfigurationValues;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eduardo Garcia
 */
public class AnalyticsUtil {

	public static String getAnalyticsFormExcludedIdsRegex(long groupId) {
		return _getString(
			groupId,
			AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_EXCLUDED_IDS_REGEX,
			AnalyticsServiceConfigurationValues.
				ANALYTICS_FORM_EXCLUDED_IDS_REGEX);
	}

	public static String getAnalyticsLinkExcludedIdsRegex(long groupId) {
		return _getString(
			groupId,
			AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_EXCLUDED_IDS_REGEX,
			AnalyticsServiceConfigurationValues.
				ANALYTICS_LINK_EXCLUDED_IDS_REGEX);
	}

	public static boolean isAnalyticsContentEnabled(long groupId) {
		return _getBoolean(
			groupId,
			AnalyticsServiceConfigurationKeys.ANALYTICS_CONTENT_ENABLED,
			AnalyticsServiceConfigurationValues.ANALYTICS_CONTENT_ENABLED);
	}

	public static boolean isAnalyticsFormEnabled(long groupId) {
		return _getBoolean(
			groupId, AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_ENABLED,
			AnalyticsServiceConfigurationValues.ANALYTICS_FORM_ENABLED);
	}

	public static boolean isAnalyticsFormInteractEnabled(long groupId) {
		if (!isAnalyticsFormEnabled(groupId)) {
			return false;
		}

		return _getBoolean(
			groupId,
			AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_INTERACT_ENABLED,
			AnalyticsServiceConfigurationValues.
				ANALYTICS_FORM_INTERACT_ENABLED);
	}

	public static boolean isAnalyticsFormSubmitEnabled(long groupId) {
		if (!isAnalyticsFormEnabled(groupId)) {
			return false;
		}

		return _getBoolean(
			groupId,
			AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_SUBMIT_ENABLED,
			AnalyticsServiceConfigurationValues.ANALYTICS_FORM_SUBMIT_ENABLED);
	}

	public static boolean isAnalyticsFormViewEnabled(long groupId) {
		if (!isAnalyticsFormEnabled(groupId)) {
			return false;
		}

		return _getBoolean(
			groupId,
			AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_VIEW_ENABLED,
			AnalyticsServiceConfigurationValues.ANALYTICS_FORM_VIEW_ENABLED);
	}

	public static boolean isAnalyticsLinkClickEnabled(long groupId) {
		if (!isAnalyticsLinkEnabled(groupId)) {
			return false;
		}

		return _getBoolean(
			groupId,
			AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_CLICK_ENABLED,
			AnalyticsServiceConfigurationValues.ANALYTICS_LINK_CLICK_ENABLED);
	}

	public static boolean isAnalyticsLinkEnabled(long groupId) {
		return _getBoolean(
			groupId, AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_ENABLED,
			AnalyticsServiceConfigurationValues.ANALYTICS_LINK_ENABLED);
	}

	public static boolean isAnalyticsPageEnabled(long groupId) {
		return _getBoolean(
			groupId, AnalyticsServiceConfigurationKeys.ANALYTICS_PAGE_ENABLED,
			AnalyticsServiceConfigurationValues.ANALYTICS_PAGE_ENABLED);
	}

	public static boolean isAnalyticsYoutubeEnabled(long groupId) {
		return _getBoolean(
			groupId,
			AnalyticsServiceConfigurationKeys.ANALYTICS_YOUTUBE_ENABLED,
			AnalyticsServiceConfigurationValues.ANALYTICS_YOUTUBE_ENABLED);
	}

	public static boolean isIncludeAnalytics(
		Layout layout, HttpServletRequest request) {

		try {
			Group group = layout.getGroup();

			if (!group.isStagingGroup() && !group.isLayoutSetPrototype() &&
				!group.isLayoutPrototype() && !layout.isTypeControlPanel() &&
				!GetterUtil.getBoolean(
					request.getAttribute("isSimulatedUserSegments"))) {

				return true;
			}
		}
		catch (PortalException pe) {
		}

		return false;
	}

	private static Boolean _getBoolean(
		long groupId, String key, boolean defaultValue) {

		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);

			UnicodeProperties typeSettingsProperties =
				group.getParentLiveGroupTypeSettingsProperties();

			boolean companyValue = PrefsPropsUtil.getBoolean(
				group.getCompanyId(), key, defaultValue);

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
				group.getCompanyId(), key, defaultValue);

			return GetterUtil.getString(
				typeSettingsProperties.getProperty(key), companyValue);
		}
		catch (Exception e) {
			return defaultValue;
		}
	}

}