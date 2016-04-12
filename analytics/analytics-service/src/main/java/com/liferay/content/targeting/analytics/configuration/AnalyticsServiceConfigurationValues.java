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

package com.liferay.content.targeting.analytics.configuration;

/**
 * @author Eduardo Garcia
 */
public class AnalyticsServiceConfigurationValues {

	public static final boolean ANALYTICS_CONTENT_ENABLED =
		AnalyticsServiceConfigurationUtil.getBoolean(
			AnalyticsServiceConfigurationKeys.ANALYTICS_CONTENT_ENABLED);

	public static final int ANALYTICS_EVENTS_CHECK_INTERVAL =
		AnalyticsServiceConfigurationUtil.getInteger(
			AnalyticsServiceConfigurationKeys.ANALYTICS_EVENTS_CHECK_INTERVAL);

	public static final int ANALYTICS_EVENTS_MAX_AGE =
		AnalyticsServiceConfigurationUtil.getInteger(
			AnalyticsServiceConfigurationKeys.ANALYTICS_EVENTS_MAX_AGE);

	public static final int ANALYTICS_FLUSH_INTERVAL =
		AnalyticsServiceConfigurationUtil.getInteger(
			AnalyticsServiceConfigurationKeys.ANALYTICS_FLUSH_INTERVAL);

	public static final boolean ANALYTICS_FORM_ENABLED =
		AnalyticsServiceConfigurationUtil.getBoolean(
			AnalyticsServiceConfigurationKeys.ANALYTICS_EVENTS_CHECK_INTERVAL);

	public static final String ANALYTICS_FORM_EXCLUDED_IDS_REGEX =
		AnalyticsServiceConfigurationUtil.get(
			AnalyticsServiceConfigurationKeys.
				ANALYTICS_FORM_EXCLUDED_IDS_REGEX);

	public static final boolean ANALYTICS_FORM_INTERACT_ENABLED =
		AnalyticsServiceConfigurationUtil.getBoolean(
			AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_INTERACT_ENABLED);

	public static final boolean ANALYTICS_FORM_SUBMIT_ENABLED =
		AnalyticsServiceConfigurationUtil.getBoolean(
			AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_SUBMIT_ENABLED);

	public static final boolean ANALYTICS_FORM_VIEW_ENABLED =
		AnalyticsServiceConfigurationUtil.getBoolean(
			AnalyticsServiceConfigurationKeys.ANALYTICS_FORM_VIEW_ENABLED);

	public static final boolean ANALYTICS_LINK_CLICK_ENABLED =
		AnalyticsServiceConfigurationUtil.getBoolean(
			AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_CLICK_ENABLED);

	public static final boolean ANALYTICS_LINK_ENABLED =
		AnalyticsServiceConfigurationUtil.getBoolean(
			AnalyticsServiceConfigurationKeys.ANALYTICS_LINK_ENABLED);

	public static final String ANALYTICS_LINK_EXCLUDED_IDS_REGEX =
		AnalyticsServiceConfigurationUtil.get(
			AnalyticsServiceConfigurationKeys.
				ANALYTICS_LINK_EXCLUDED_IDS_REGEX);

	public static final boolean ANALYTICS_PAGE_ENABLED =
		AnalyticsServiceConfigurationUtil.getBoolean(
			AnalyticsServiceConfigurationKeys.ANALYTICS_PAGE_ENABLED);

	public static final boolean ANALYTICS_YOUTUBE_ENABLED =
		AnalyticsServiceConfigurationUtil.getBoolean(
			AnalyticsServiceConfigurationKeys.ANALYTICS_YOUTUBE_ENABLED);

}