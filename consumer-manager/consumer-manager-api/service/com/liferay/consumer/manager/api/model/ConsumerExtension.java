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

package com.liferay.consumer.manager.api.model;

import com.liferay.consumer.manager.InvalidConsumerExtensionException;
import com.liferay.consumer.manager.model.ConsumerExtensionInstance;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * Provides ConsumerExtension interface to allow creation of custom extensions
 * for Consumer Manager portlet
 *
 * @author Pavel Savinov
 */
public interface ConsumerExtension {

	/**
	 * Does processing when the extension is installed.
	 */
	public void activate();

	/**
	 * Does processing when the extension is uninstalled.
	 */
	public void deActivate();

	/**
	 * Returns the key that identifies the consumer extension. The consumer
	 * extension instances of this consumer extension are identified by
	 * their consumer extension key.
	 *
	 * @return the key that identifies the rule
	 */
	public String getConsumerExtensionKey();

	/**
	 * Returns the rule localized description.
	 *
	 * @param  locale the language locale
	 * @return the rule localized description
	 */
	public String getDescription(Locale locale);

	/**
	 * Returns the HTML code containing the form fields required to edit the
	 * consumer extension instance configuration, based on the context.
	 *
	 * @param  consumerExtensionInstance the consumer extension instance with
	 *         stored configuration
	 * @param  context the map defining the form evaluation context
	 * @param  values the values configured by users for the current consumer
	 *         extension instance based on the form controls from the HTML.
	 *         This will be used when there is an error and the form is
	 *         reloaded.
	 * @return the HTML code containing the form fields required to edit the
	 *         rule instance configuration, based on the context
	 */
	public String getFormHTML(
		ConsumerExtensionInstance consumerExtensionInstance,
		Map<String, Object> context, Map<String, String> values);

	/**
	 * Returns the Font Awesome CSS class for the consumer extension icon.
	 *
	 * @return the Font Awesome CSS class for the consumer extension icon
	 * @see    <a href="http://fortawesome.github.io/Font-Awesome/3.2.1/">Font
	 *         Awesome documentation</a>
	 */
	public String getIcon();

	/**
	 * Returns the consumer extension localized name.
	 *
	 * @param  locale the language locale
	 * @return the consumer extension localized name
	 */
	public String getName(Locale locale);

	/**
	 * Returns the consumer extension localized short description.
	 *
	 * @param  locale the language locale
	 * @return the consumer extension localized short description
	 */
	public String getShortDescription(Locale locale);

	/**
	 * Returns the consumer extension instance localized summary.
	 *
	 * @param  consumerExtensionInstance the consumer extension instance with
	 *         stored configuration
	 * @param  locale the language locale
	 * @return the consumer extension instance localized summary
	 */
	public String getSummary(
		ConsumerExtensionInstance consumerExtensionInstance, Locale locale);

	/**
	 * Returns <code>true</code> if the extension can be used more than
	 * once with different values for a consumer.
	 *
	 * @return <code>true</code> if the extension can be used more than once;
	 *         <code>false</code> otherwise
	 */
	public boolean isInstantiable();

	/**
	 * Returns <code>true</code> if the consumer extension is visible.
	 *
	 * @return <code>true</code> if the consumer extension is visible;
	 *         <code>false</code> otherwise
	 */
	public boolean isVisible();

	/**
	 * Returns the result of evaluating the consumer extension form
	 * fields in the context of the request and response.
	 *
	 * @param  request the request from which to get the request parameters
	 * @param  response the response to receive the render parameters
	 * @param  id the identifier that differentiates between consumer extension
	 *         instances of the same type of an instantiable consumer extension
	 * @param  values the values configured by users for the current channel
	 *         instance based on the form controls from the HTML
	 * @return the result of evaluating the channel form fields in the
	 * 		   context of the request and response
	 */
	public String processConsumerExtension(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidConsumerExtensionException;

}