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

package com.liferay.content.targeting.rule.time;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.SessionAttributesRuleCategory;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.text.Format;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Julio Camarero
 */
@Component(immediate = true, service = Rule.class)
public class TimeRule extends BaseRule {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		String typeSettings = ruleInstance.getTypeSettings();

		Calendar startCalendar = _getStartCalendar(typeSettings);
		Calendar endCalendar = _getEndCalendar(typeSettings);

		Calendar now = CalendarFactoryUtil.getCalendar();

		if (startCalendar.before(now) && endCalendar.after(now)) {
			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-time";
	}

	@Override
	public String getRuleCategoryKey() {
		return SessionAttributesRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		Format format = FastDateFormatFactoryUtil.getSimpleDateFormat(
			_SIMPLE_DATE_FORMAT_PATTERN, locale);

		Calendar startCalendar = _getStartCalendar(typeSettings);
		Calendar endCalendar = _getEndCalendar(typeSettings);

		String summary = LanguageUtil.format(
			locale, "users-browsing-the-site-from-x-to-x",
			new Object[] {
				format.format(startCalendar.getTime()),
				format.format(endCalendar.getTime())
			});

		return summary;
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		int endTimeHour = GetterUtil.getInteger(values.get("endTimeHour"));
		int endTimeMinute = GetterUtil.getInteger(values.get("endTimeMinute"));
		int endTimeAmPm = GetterUtil.getInteger(values.get("endTimeAmPm"));

		int startTimeHour = GetterUtil.getInteger(values.get("startTimeHour"));
		int startTimeMinute = GetterUtil.getInteger(
			values.get("startTimeMinute"));
		int startTimeAmPm = GetterUtil.getInteger(values.get("startTimeAmPm"));

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("endTimeHour", endTimeHour);
		jsonObj.put("endTimeMinute", endTimeMinute);
		jsonObj.put("endTimeAmPm", endTimeAmPm);
		jsonObj.put("startTimeHour", startTimeHour);
		jsonObj.put("startTimeMinute", startTimeMinute);
		jsonObj.put("startTimeAmPm", startTimeAmPm);

		return jsonObj.toString();
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		int endTimeHour = 0;
		int endTimeMinute = 0;
		int endTimeAmPm = 0;

		int startTimeHour = 0;
		int startTimeMinute = 0;
		int startTimeAmPm = 0;

		if (!values.isEmpty()) {
			endTimeHour = GetterUtil.getInteger(values.get("endTimeHour"));
			endTimeMinute = GetterUtil.getInteger(values.get("endTimeMinute"));
			endTimeAmPm = GetterUtil.getInteger(values.get("endTimeAmPm"));
			startTimeHour = GetterUtil.getInteger(values.get("startTimeHour"));
			startTimeMinute = GetterUtil.getInteger(
				values.get("startTimeMinute"));
			startTimeAmPm = GetterUtil.getInteger(values.get("startTimeAmPm"));
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				endTimeHour = jsonObj.getInt("endTimeHour");
				endTimeMinute = jsonObj.getInt("endTimeMinute");
				endTimeAmPm = jsonObj.getInt("endTimeAmPm");
				startTimeHour = jsonObj.getInt("startTimeHour");
				startTimeMinute = jsonObj.getInt("startTimeMinute");
				startTimeAmPm = jsonObj.getInt("startTimeAmPm");
			}
			catch (JSONException jsone) {
			}
		}

		context.put("endTimeHour", endTimeHour);
		context.put("endTimeMinute", endTimeMinute);
		context.put("endTimeAmPm", endTimeAmPm);
		context.put("startTimeHour", startTimeHour);
		context.put("startTimeMinute", startTimeMinute);
		context.put("startTimeAmPm", startTimeAmPm);

		Calendar now = CalendarFactoryUtil.getCalendar();

		context.put("now", now.getTime());
	}

	private Calendar _getEndCalendar(String typeSettings) {
		Calendar now = CalendarFactoryUtil.getCalendar();

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			int endTimeHour = jsonObj.getInt("endTimeHour");
			int endTimeMinute = jsonObj.getInt("endTimeMinute");
			int endTimeAmPm = jsonObj.getInt("endTimeAmPm");

			if (endTimeAmPm == Calendar.PM) {
				endTimeHour += 12;
			}

			int day = now.get(Calendar.DATE);
			int month = now.get(Calendar.MONTH);
			int year = now.get(Calendar.YEAR);

			Calendar endCalendar = CalendarFactoryUtil.getCalendar(
				year, month, day, endTimeHour, endTimeMinute);

			return endCalendar;
		}
		catch (JSONException jsone) {
		}

		return now;
	}

	private Calendar _getStartCalendar(String typeSettings) {
		Calendar now = CalendarFactoryUtil.getCalendar();

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			int startTimeHour = jsonObj.getInt("startTimeHour");
			int startTimeMinute = jsonObj.getInt("startTimeMinute");
			int startTimeAmPm = jsonObj.getInt("startTimeAmPm");

			if (startTimeAmPm == Calendar.PM) {
				startTimeHour += 12;
			}

			int day = now.get(Calendar.DATE);
			int month = now.get(Calendar.MONTH);
			int year = now.get(Calendar.YEAR);

			Calendar startCalendar = CalendarFactoryUtil.getCalendar(
				year, month, day, startTimeHour, startTimeMinute);

			return startCalendar;
		}
		catch (JSONException jsone) {
		}

		return now;
	}

	private static final String _SIMPLE_DATE_FORMAT_PATTERN = "hh:mm a";

}