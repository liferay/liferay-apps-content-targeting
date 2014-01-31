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

import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.CTUser;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.text.Format;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Julio Camarero
 */
@Component(immediate = true, provide = Rule.class)
public class TimeRule extends BaseRule {

	@Activate
	public void activate() {
	}

	@Deactivate
	public void deActivate() {
	}

	@Override
	public boolean evaluate(RuleInstance ruleInstance, CTUser ctUser)
		throws Exception {

		if (ruleInstance == null) {
			return false;
		}

		String typeSettings = ruleInstance.getTypeSettings();

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

		int endTimeHour = jsonObj.getInt("endTimeHour");
		int endTimeMinute = jsonObj.getInt("endTimeMinute");
		int endTimeAmPm = jsonObj.getInt("endTimeAmPm");

		if (endTimeAmPm == Calendar.PM) {
			endTimeHour += 12;
		}

		int startTimeHour = jsonObj.getInt("startTimeHour");
		int startTimeMinute = jsonObj.getInt("startTimeMinute");
		int startTimeAmPm = jsonObj.getInt("startTimeAmPm");

		if (startTimeAmPm == Calendar.PM) {
			startTimeHour += 12;
		}

		Calendar now = CalendarFactoryUtil.getCalendar();

		int day = now.get(Calendar.DATE);
		int month = now.get(Calendar.MONTH);
		int year = now.get(Calendar.YEAR);

		Calendar startCalendar = CalendarFactoryUtil.getCalendar(
			year, month, day, startTimeHour, startTimeMinute);

		Calendar endCalendar = CalendarFactoryUtil.getCalendar(
			year, month, day, endTimeHour, endTimeMinute);

		if (startCalendar.before(now) && endCalendar.after(now)) {
			return true;
		}

		return false;
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

			content = parseTemplate(
				TimeRule.class, _FORM_TEMPLATE_PATH, context);
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
		return "icon-time";
	}

	@Override
	public String getName(Locale locale) {
		return LanguageUtil.get(locale, "time");
	}

	@Override
	public String getRuleKey() {
		return "timeRule";
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		Format format = FastDateFormatFactoryUtil.getSimpleDateFormat(
			_SIMPLE_DATE_FORMAT_PATTERN, locale);

		StringBundler sb = new StringBundler(4);

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			int startTimeHour = jsonObj.getInt("startTimeHour");
			int startTimeMinute = jsonObj.getInt("startTimeMinute");
			int startTimeAmPm = jsonObj.getInt("startTimeAmPm");

			if (startTimeAmPm == Calendar.PM) {
				startTimeHour += 12;
			}

			Calendar startCalendar = CalendarFactoryUtil.getCalendar(
				1970, 0, 1, startTimeHour, startTimeMinute);

			int endTimeHour = jsonObj.getInt("endTimeHour");
			int endTimeMinute = jsonObj.getInt("endTimeMinute");
			int endTimeAmPm = jsonObj.getInt("endTimeAmPm");

			if (endTimeAmPm == Calendar.PM) {
				endTimeHour += 12;
			}

			Calendar endCalendar = CalendarFactoryUtil.getCalendar(
				1970, 0, 1, endTimeHour, endTimeMinute);

			sb.append("Users browsing the Site from ");
			sb.append(format.format(startCalendar.getTime()));
			sb.append(" to ");
			sb.append(format.format(endCalendar.getTime()));
		}
		catch (JSONException jse) {
		}

		return sb.toString();
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

	private static final String _SIMPLE_DATE_FORMAT_PATTERN = "hh:mm a";

	private static Log _log = LogFactoryUtil.getLog(TimeRule.class);

}