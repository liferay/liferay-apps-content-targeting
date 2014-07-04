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

package com.liferay.contenttargeting.api.model;

import com.liferay.contenttargeting.model.TrackingActionInstance;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eduardo Garcia
 */
public interface TrackingAction {

	public void activate();

	public void deActivate();

	public String getDescription(Locale locale);

	public List<String> getEventTypes();

	public String getFormHTML(
		TrackingActionInstance trackingActionInstance,
		Map<String, Object> context);

	public String getIcon();

	public String getName(Locale locale);

	public String getSummary(
		TrackingActionInstance trackingActionInstance, Locale locale);

	public String getTrackingActionKey();

	public boolean isInstantiable();

	public void processTrackingAction(
		PortletRequest request, PortletResponse response);

}