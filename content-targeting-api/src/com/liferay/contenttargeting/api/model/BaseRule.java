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

import com.liferay.contenttargeting.model.RuleInstance;
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

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eduardo Garcia
 */
public abstract class BaseRule implements Rule {

	@Activate
	public void activate() {
		if (_log.isDebugEnabled()) {
			_log.debug("Rule activate: " + getClass().getSimpleName());
		}
	}

	@Deactivate
	public void deActivate() {
		if (_log.isDebugEnabled()) {
			_log.debug("Rule deactivate: " + getClass().getSimpleName());
		}
	}

	@Override
	public String getCategory() {
		return StringPool.BLANK;
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
		RuleInstance ruleInstance, Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			populateContext(ruleInstance, context);

			content = parseTemplate(getClass(), getFormTemplatePath(), context);
		}
		catch (Exception e) {
			_log.error(
			"Error while processing rule form template " +
				_FORM_TEMPLATE_PATH,
			e);
		}

		return content;
	}

	@Override
	public String getIcon() {
		return "icon-retweet";
	}

	@Override
	public String getName(Locale locale) {
		return ResourceActionsUtil.getModelResource(
			locale, getClass().getName());
	}

	@Override
	public String getRuleKey() {
		return getClass().getSimpleName();
	}

	@Override
	public boolean isInstantiable() {
		return false;
	}

	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH;
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
		RuleInstance ruleInstance, Map<String, Object> context) {
	}

	protected static final String _FORM_TEMPLATE_PATH =
		"templates/ct_fields.ftl";

	private static Log _log = LogFactoryUtil.getLog(BaseRule.class);

}