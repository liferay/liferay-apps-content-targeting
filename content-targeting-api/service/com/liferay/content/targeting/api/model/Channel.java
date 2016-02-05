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

import com.liferay.content.targeting.exception.InvalidChannelException;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Element;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * Provides the Channel interface, allowing custom chanel
 * creation and evaluation for the Content Targeting Portlet.
 *
 * @author Pavel Savinov
 */
public interface Channel {

	/**
	 * Does processing when the channel is installed.
	 */
	public void activate();

	/**
	 * Does processing when the channel is uninstalled.
	 */
	public void deActivate();

	/**
	 * Removes any additional data added by this channel when the
	 * channel instance is removed.
	 *
	 * @param channelInstance the channel instance with the
	 *        stored configuration
	 */
	public void deleteData(ChannelInstance channelInstance)
		throws PortalException;

	/**
	 * Exports any additional data added by this channel when the
	 * channel instance is exported.
	 *
	 * @param portletDataContext the context of the data export
	 * @param tacticElement the element with the tactic export data
	 * @param tactic the tactic containing the channel instance
	 * @param channelInstanceElement the element with the channel
	 *        instance export data
	 * @param channelInstance the channel instance with stored
	 *        configuration
	 */
	public void exportData(
			PortletDataContext portletDataContext, Element tacticElement,
			Tactic tactic, Element channelInstanceElement,
			ChannelInstance channelInstance)
		throws Exception;

	/**
	 * Returns the key that identifies the channel. The channel
	 * instances of this channel are identified by their channel
	 * key.
	 *
	 * @return the key that identifies the channel
	 */
	public String getChannelKey();

	/**
	 * Returns the channel localized description.
	 *
	 * @param  locale the language locale
	 * @return the channel localized description
	 */
	public String getDescription(Locale locale);

	/**
	 * Returns the HTML code containing the form fields required to edit the
	 * channel instance configuration, based on the context.
	 *
	 * @param  channelInstance the channel instance with stored
	 *         configuration
	 * @param  context the map defining the form evaluation context
	 * @param  values the values configured by users for the current channel
	 *         instance based on the form controls from the HTML. This
	 *         will be used when there is an error and the form is reloaded.
	 * @return the HTML code containing the form fields required to edit the
	 *         channel instance configuration, based on the context
	 */
	public String getFormHTML(
		ChannelInstance channelInstance, Map<String, Object> context,
		Map<String, String> values);

	/**
	 * Returns the Font Awesome CSS class for the channel icon.
	 *
	 * @return the Font Awesome CSS class for the channel icon
	 * @see    <a href="http://fortawesome.github.io/Font-Awesome/3.2.1/">Font
	 *         Awesome documentation</a>
	 */
	public String getIcon();

	/**
	 * Returns the channel localized name.
	 *
	 * @param  locale the language locale
	 * @return the channel localized name
	 */
	public String getName(Locale locale);

	/**
	 * Returns the channel localized short description.
	 *
	 * @param  locale the language locale
	 * @return the channel localized short description
	 */
	public String getShortDescription(Locale locale);

	/**
	 * Returns the channel instance localized summary.
	 *
	 * @param  channelInstance the channel instance with stored
	 *         configuration
	 * @param  locale the language locale
	 * @return the channel instance localized summary
	 */
	public String getSummary(ChannelInstance channelInstance, Locale locale);

	/**
	 * Imports any additional data added by this channel when the
	 * channel instance is imported.
	 *
	 * @param portletDataContext the context of the data import
	 * @param tactic the tactic containing the channel instance
	 * @param channelInstance the channel instance with stored
	 *        configuration
	 */
	public void importData(
			PortletDataContext portletDataContext, Tactic tactic,
			ChannelInstance channelInstance)
		throws Exception;

	/**
	 * Returns <code>true</code> if the channel can be used more than
	 * once with different values for a campaign.
	 *
	 * @return <code>true</code> if the channel can be used more than once;
	 *         <code>false</code> otherwise
	 */
	public boolean isInstantiable();

	/**
	 * Returns <code>true</code> if the channel is visible.
	 *
	 * @return <code>true</code> if the channel is visible; <code>false</code>
	 *         otherwise
	 */
	public boolean isVisible();

	/**
	 * Returns the result of evaluating the channel form fields in the
	 * context of the request and response.
	 *
	 * @param  request the request from which to get the request parameters
	 * @param  response the response to receive the render parameters
	 * @param  id the identifier that differentiates between channel
	 *         instances of the same type of an instantiable channel
	 * @param  values the values configured by users for the current channel
	 *                instance based on the form controls from the HTML
	 * @return the result of evaluating the channel form fields in the
	 * 		   context of the request and response
	 */
	public String processChannel(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidChannelException;

	/**
	 * Associates current channel with id of channel instance
	 *
	 * @param typeSettings processed settings for the channel
	 * @param channelInstanceId id of channel instance to associate
	 */
	public void updateChannel(String typeSettings, long channelInstanceId);

}