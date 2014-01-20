/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.rules.time;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;

import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import freemarker.cache.ClassTemplateLoader;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Julio Camarero
 */
@Component(immediate = true)
public class TimeRule implements Rule {

	@Activate
	public void activate() {
	}

	@Deactivate
	public void deActivate() {
	}

	@Override
	public boolean evaluate(RuleInstance ruleInstance) {
		return true;
	}

	@Override
	public String getFormHTML(
		RuleInstance ruleInstance, Map<String, Object> context) {

		String content = StringPool.BLANK;

		try {
			if (ruleInstance != null) {
				String typeSettings = ruleInstance.getTypeSettings();

				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				context.put("endTimeHour", jsonObj.getInt("endTimeHour"));
				context.put("endTimeMinute", jsonObj.getInt("endTimeMinute"));
				context.put("endTimeAmPm", jsonObj.getInt("endTimeAmPm"));
				context.put("startTimeHour", jsonObj.getInt("startTimeHour"));
				context.put(
					"startTimeMinute", jsonObj.getInt("startTimeMinute"));
				context.put("startTimeAmPm", jsonObj.getInt("startTimeAmPm"));
			}
			else {
				context.put("endTimeHour", 0);
				context.put("endTimeMinute", 0);
				context.put("endTimeAmPm", 0);
				context.put("startTimeHour", 0);
				context.put("startTimeMinute", 0);
				context.put("startTimeAmPm", 0);
			}

			Configuration configuration = new Configuration();

			configuration.setObjectWrapper(new DefaultObjectWrapper());
			configuration.setTemplateLoader(
				new ClassTemplateLoader(TimeRule.class, StringPool.SLASH));
			configuration.setTemplateUpdateDelay(Integer.MAX_VALUE);

			Template template = configuration.getTemplate(_FORM_TEMPLATE_PATH);

			UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();

			template.process(context, unsyncStringWriter);

			content = unsyncStringWriter.toString();
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
		return "../aui/time";
	}

	@Override
	public String getName() {
		return "time";
	}

	@Override
	public String getRuleKey() {
		return "timeRule";
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		return "Time Rule Summary";
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response) {

		int endTimeHour = ParamUtil.getInteger(request, "endTimeHour");
		int endTimeMinute = ParamUtil.getInteger(request, "endTimeMinute");
		int endTimeAmPm = ParamUtil.getInteger(request, "endTimeAmPm");

		int startTimeHour = ParamUtil.getInteger(request, "startTimeHour");
		int startTimeMinute = ParamUtil.getInteger(request, "startTimeMinute");
		int startTimeAmPm = ParamUtil.getInteger(request, "startTimeAmPm");

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("endTimeHour", endTimeHour);
		jsonObj.put("endTimeMinute", endTimeMinute);
		jsonObj.put("endTimeAmPm", endTimeAmPm);
		jsonObj.put("startTimeHour", startTimeHour);
		jsonObj.put("startTimeMinute", startTimeMinute);
		jsonObj.put("startTimeAmPm", startTimeAmPm);

		return jsonObj.toString();
	}

	private static final String _FORM_TEMPLATE_PATH =
		"templates/ct_time_rule_fields.ftl";

	private static Log _log = LogFactoryUtil.getLog(TimeRule.class);

}