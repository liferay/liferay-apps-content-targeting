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

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Pavel Savinov
 */
@ExtendedObjectClassDefinition(category = "content-targeting")
@Meta.OCD(
	id = "com.liferay.content.targeting.analytics.configuration.AnalyticsServiceConfiguration",
	localization = "content/Language",
	name = "%content.targeting.analytics.service.configuration.name"
)
public interface AnalyticsServiceConfiguration {

	@Meta.AD(deflt = "1", required = true)
	public int analyticsEventsCheckInterval();

	@Meta.AD(deflt = "3", required = true)
	public int analyticsEventsMaxAge();

	@Meta.AD(deflt = "20000", required = true)
	public int analyticsFlushInterval();

	@Meta.AD(deflt = "true", required = true)
	public boolean contentTrackingEnabled();

	@Meta.AD(required = false)
	public String formExcludedIdsRegExp();

	@Meta.AD(deflt = "true", required = true)
	public boolean formTrackingEnabled();

	@Meta.AD(deflt = "true", required = true)
	public boolean formInteractionTrackingEnabled();

	@Meta.AD(deflt = "true", required = true)
	public boolean formSubmitTrackingEnabled();

	@Meta.AD(deflt = "true", required = true)
	public boolean formViewTrackingEnabled();

	@Meta.AD(required = false)
	public String linkExcludedIdsRegExp();

	@Meta.AD(deflt = "false", required = true)
	public boolean linkTrackingEnabled();

	@Meta.AD(deflt = "false", required = true)
	public boolean linkClickTrackingEnabled();

	@Meta.AD(deflt = "true", required = true)
	public boolean pageTrackingEnabled();

	@Meta.AD(deflt = "false", required = true)
	public boolean youtubeTrackingEnabled();

}