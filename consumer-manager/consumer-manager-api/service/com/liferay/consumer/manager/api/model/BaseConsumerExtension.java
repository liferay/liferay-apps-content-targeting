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
import com.liferay.consumer.manager.util.ConsumerManagerContextUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.permission.ResourceActionsUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Pavel Savinov
 */
public class BaseConsumerExtension implements ConsumerExtension {

	@Override
	public void activate() {
		if (_log.isDebugEnabled()) {
			_log.debug(
				"ConsumerExtension activate: " + getClass().getSimpleName());
		}
	}

	@Override
	public void deActivate() {
		if (_log.isDebugEnabled()) {
			_log.debug(
				"ConsumerExtension deactivate: " + getClass().getSimpleName());
		}
	}

	@Override
	public String getConsumerExtensionKey() {
		return getClass().getSimpleName();
	}

	@Override
	public String getDescription(Locale locale) {
		String key = getClass().getName().concat(".description");

		String description = ResourceActionsUtil.getModelResource(locale, key);

		if (description.endsWith(key)) {
			description = getShortDescription(locale);
		}

		return description;
	}

	@Override
	public String getFormHTML(
		ConsumerExtensionInstance consumerExtensionInstance,
		Map<String, Object> context, Map<String, String> values) {

		String content = StringPool.BLANK;

		try {
			populateContext(consumerExtensionInstance, context, values);

			content = ConsumerManagerContextUtil.parseTemplate(
				getClass(), _FORM_TEMPLATE_PATH, context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing consumer extension form template " +
					_FORM_TEMPLATE_PATH,
				e);
		}

		return content;
	}

	@Override
	public String getIcon() {
		return "icon-file";
	}

	@Override
	public String getName(Locale locale) {
		return ResourceActionsUtil.getModelResource(
			locale, getClass().getName());
	}

	@Override
	public String getShortDescription(Locale locale) {
		String key = getClass().getName().concat(".shortDescription");

		String shortDescription = ResourceActionsUtil.getModelResource(
			locale, key);

		if (shortDescription.endsWith(key)) {
			shortDescription = StringPool.BLANK;
		}

		return shortDescription;
	}

	@Override
	public String getSummary(
		ConsumerExtensionInstance consumerExtensionInstance, Locale locale) {

		return StringPool.BLANK;
	}

	@Override
	public boolean isInstantiable() {
		return false;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public String processConsumerExtension(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws InvalidConsumerExtensionException {

		return StringPool.BLANK;
	}

	protected void populateContext(
		ConsumerExtensionInstance consumerExtensionInstance,
		Map<String, Object> context, Map<String, String> values) {
	}

	protected static final String _FORM_TEMPLATE_PATH =
		"templates/cm_extension.ftl";

	private static Log _log = LogFactoryUtil.getLog(
		BaseConsumerExtension.class);

}