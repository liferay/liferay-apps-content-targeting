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

package com.liferay.portal.contenttargeting.api.model;

import com.liferay.portal.contenttargeting.model.TrackingActionInstance;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.permission.ResourceActionsUtil;

import freemarker.cache.ClassTemplateLoader;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eduardo Garcia
 */
public abstract class BaseTrackingAction implements TrackingAction {

	@Override
	public void activate() {
		if (_log.isDebugEnabled()) {
			_log.debug(
				"Tracking Action activate: " + getClass().getSimpleName());
		}
	}

	@Override
	public void deActivate() {
		if (_log.isDebugEnabled()) {
			_log.debug(
				"Tracking Action deactivate: " + getClass().getSimpleName());
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String key = getClass().getName().concat(".description");

		String description = ResourceActionsUtil.getModelResource(locale, key);

		if (description.equals(key)) {
			description = StringPool.BLANK;
		}

		return description;
	}

	@Override
	public String getFormHTML(
		TrackingActionInstance trackingActionInstance,
		Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			populateContext(trackingActionInstance, context);

			content = parseTemplate(getClass(), _FORM_TEMPLATE_PATH, context);
		}
		catch (Exception e) {
			_log.error(
				"Error while processing tracking action form template " +
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
	public String getTrackingActionKey() {
		return getClass().getSimpleName();
	}

	@Override
	public boolean isInstantiable() {
		return true;
	}

	@Override
	public String processTrackingAction(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values)
		throws Exception {

		return null;
	}

	protected String parseTemplate(
			Class clazz, String templatePath, Map<String, Object> context)
		throws Exception {

		Configuration configuration = new Configuration();

		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setTemplateLoader(
			new ClassTemplateLoader(clazz, StringPool.SLASH));
		configuration.setTemplateUpdateDelay(Integer.MAX_VALUE);

		Template template = configuration.getTemplate(templatePath);

		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();

		template.process(context, unsyncStringWriter);

		return unsyncStringWriter.toString();
	}

	protected void populateContext(
		TrackingActionInstance trackingActionInstance,
		Map<String, Object> context) {
	}

	protected static final String _FORM_TEMPLATE_PATH =
		"templates/ct_tracking_action.ftl";

	private static Log _log = LogFactoryUtil.getLog(BaseTrackingAction.class);

}