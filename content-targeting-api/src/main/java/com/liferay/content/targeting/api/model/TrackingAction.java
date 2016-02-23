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

package com.liferay.content.targeting.api.model;

import com.liferay.content.targeting.exception.InvalidTrackingActionException;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Element;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * Provides the TrackingAction interface, allowing custom tracking action
 * creation and evaluation for the Content Targeting Portlet.
 *
 * @author Eduardo Garcia
 */
public interface TrackingAction {

	/**
	 * Does processing when the tracking action is installed.
	 */
	public void activate();

	/**
	 * Does processing when the tracking action is uninstalled.
	 */
	public void deActivate();

	/**
	 * Removes any additional data added by this tracking action when the
	 * tracking action instance is removed.
	 *
	 * @param trackingActionInstance the tracking action instance with the
	 *        stored configuration
	 */
	public void deleteData(TrackingActionInstance trackingActionInstance)
		throws PortalException;

	/**
	 * Exports any additional data added by this tracking action when the
	 * tracking action instance is exported.
	 *
	 * @param portletDataContext the context of the data export
	 * @param campaignElement the element with the campaign export data
	 * @param campaign the campaign containing the tracking action instance
	 * @param trackingActionInstanceElement the element with the tracking action
	 *        instance export data
	 * @param trackingActionInstance the tracking action instance with stored
	 *        configuration
	 */
	public void exportData(
			PortletDataContext portletDataContext, Element campaignElement,
			Campaign campaign, Element trackingActionInstanceElement,
			TrackingActionInstance trackingActionInstance)
		throws Exception;

	/**
	 * Returns the tracking action localized description.
	 *
	 * @param  locale the language locale
	 * @return the tracking action localized description
	 */
	public String getDescription(Locale locale);

	/**
	 * Returns the list with the event types that can be monitored by this
	 * tracking action.
	 *
	 * @return the list with the event types that can be monitored by this
	 *         tracking action
	 */
	public List<String> getEventTypes();

	/**
	 * Returns the HTML code containing the form fields required to edit the
	 * tracking action instance configuration, based on the context.
	 *
	 * @param  trackingActionInstance the tracking action instance with stored
	 *         configuration
	 * @param  context the map defining the form evaluation context
	 * @param  values the values configured by users for the current tracking
	 *         action instance based on the form controls from the HTML. This
	 *         will be used when there is an error and the form is reloaded.
	 * @return the HTML code containing the form fields required to edit the
	 *         tracking action instance configuration, based on the context
	 */
	public String getFormHTML(
		TrackingActionInstance trackingActionInstance,
		Map<String, Object> context, Map<String, String> values);

	/**
	 * Returns the Font Awesome CSS class for the tracking action icon.
	 *
	 * @return the Font Awesome CSS class for the tracking action icon
	 * @see    <a href="http://fortawesome.github.io/Font-Awesome/3.2.1/">Font
	 *         Awesome documentation</a>
	 */
	public String getIcon();

	/**
	 * Returns the tracking action localized name.
	 *
	 * @param  locale the language locale
	 * @return the tracking action localized name
	 */
	public String getName(Locale locale);

	/**
	 * Returns the tracking action localized short description.
	 *
	 * @param  locale the language locale
	 * @return the tracking action localized short description
	 */
	public String getShortDescription(Locale locale);

	/**
	 * Returns the tracking action instance localized summary.
	 *
	 * @param  trackingActionInstance the tracking action instance with stored
	 *         configuration
	 * @param  locale the language locale
	 * @return the tracking action instance localized summary
	 */
	public String getSummary(
		TrackingActionInstance trackingActionInstance, Locale locale);

	/**
	 * Returns the key that identifies the tracking action. The tracking action
	 * instances of this tracking action are identified by their tracking action
	 * key.
	 *
	 * @return the key that identifies the tracking action
	 */
	public String getTrackingActionKey();

	/**
	 * Imports any additional data added by this tracking action when the
	 * tracking action instance is imported.
	 *
	 * @param portletDataContext the context of the data import
	 * @param campaign the campaign containing the tracing action instance
	 * @param trackingActionInstance the tracking action instance with stored
	 *        configuration
	 */
	public void importData(
			PortletDataContext portletDataContext, Campaign campaign,
			TrackingActionInstance trackingActionInstance)
		throws Exception;

	/**
	 * Returns <code>true</code> if the tracking action can be used more than
	 * once with different values for a campaign.
	 *
	 * @return <code>true</code> if the tracking action can be used more than once;
	 *         <code>false</code> otherwise
	 */
	public boolean isInstantiable();

	/**
	 * Returns <code>true</code> if the tracking action is visible.
	 *
	 * @return <code>true</code> if the tracking action is visible;
	 *         <code>false</code> otherwise
	 */
	public boolean isVisible();

	/**
	 * Returns <code>true</code> if the tracking action is visible.
	 *
	 * @param className the class name of the entity to check if the tracking
	 *        action is visible within this entity
	 * @param classPK the id of the entity to check if the tracking action is
	 *        visible within this entity
	 *
	 * @return <code>true</code> if the tracking action is visible within
	 * 		   specific entity; <code>false</code> otherwise
	 */
	public boolean isVisible(String className, long classPK);

	/**
	 * Returns the result of evaluating the tracking action form fields in the
	 * context of the request and response.
	 *
	 * @param  request the request from which to get the request parameters
	 * @param  response the response to receive the render parameters
	 * @param  id the identifier that differentiates between tracking action
	 *         instances of the same type of an instantiable tracing action
	 * @param  values the values configured by users for the current tracking
	 *         action instance based on the form controls from the HTML
	 * @return the result of evaluating the tracking action form fields in the
	 * 		   context of the request and response
	 */
	public String processTrackingAction(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidTrackingActionException;

}