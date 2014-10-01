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

package com.liferay.content.targeting.rule.weather;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.SessionAttributesRuleCategory;
import com.liferay.ip.geocoder.IPGeocoder;
import com.liferay.ip.geocoder.IPInfo;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Chan
 */
@Component(immediate = true, service = Rule.class)
public class WeatherRule extends BaseRule {

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

		String userWeather = getUserWeather(anonymousUser);

		String weather = ruleInstance.getTypeSettings();

		if (Validator.equals(userWeather, weather)) {
			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-sun";
	}

	@Override
	public String getRuleCategoryKey() {
		return SessionAttributesRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		return LanguageUtil.get(locale, ruleInstance.getTypeSettings());
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		return values.get("weather");
	}

	@Reference(unbind = "unsetIPGeocoder")
	public void setIPGeocoder(IPGeocoder ipGeocoder) {
		_ipGeocoder = ipGeocoder;
	}

	public void unsetIPGeocoder(IPGeocoder ipGeocoder) {
		_ipGeocoder = null;
	}

	protected String getCityFromIPAddress(String ipAddress) {
		IPInfo ipInfo = _ipGeocoder.getIPInfo(ipAddress);

		if (ipInfo == null) {
			return null;
		}

		return ipInfo.getCity() + StringPool.COMMA + ipInfo.getCountryCode();
	}

	protected String getCityFromUserProfile(long contactId, long companyId)
		throws PortalException, SystemException {

		List<Address> addresses = AddressLocalServiceUtil.getAddresses(companyId, Contact.class.getName(), contactId);

		if (addresses.isEmpty()) {
			return null;
		}

		Address address = addresses.get(0);

		return address.getCity() + StringPool.COMMA + address.getCountry().getA2();
	}

	protected String getUserWeather(AnonymousUser anonymousUser)
		throws PortalException, SystemException {

		User user = anonymousUser.getUser();

		//String city = getCityFromUserProfile(user.getContactId(), user.getCompanyId());

		String city = getCityFromIPAddress(anonymousUser.getLastIp());

		Http.Options options = new Http.Options();

		String location = HttpUtil.addParameter(API_URL, "q", city);
		location = HttpUtil.addParameter(location, "format", "json");

		options.setLocation(location);

		int weatherCode = 0;

		try {
			String text = HttpUtil.URLtoString(options);

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(text);

			weatherCode = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
		}
		catch (Exception e) {
			_log.error(e);
		}

		return getWeatherFromCode(weatherCode);
	}

	/*
	Data from http://openweathermap.org/weather-conditions

	800-801 --> sunny

	802-804 --> Clouds

	701-781 --> Mist

	600-622 --> Snow

	500-531 --> Rain

	300-321 --> Drizzle

	200-232 --> Storms
	*/

	protected String getWeatherFromCode(int code) {
		if (code == 800 || code == 801) {
			return "sunny";
		}
		else if (code > 801 && code < 805) {
			return "clouds";
		}
		else if (code > 701 && code < 782) {
			return "mist";
		}
		else if (code >= 600 && code < 622) {
			return "snow";
		}
		else if (code >= 500 && code < 532) {
			return "rain";
		}
		else if (code >= 300 && code < 322) {
			return "drizzle";
		}
		else if (code >= 200 && code < 232) {
			return "storms";
		}

		return null;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		String weather = "sunny";

		if (!values.isEmpty()) {
			// Values from Request

			weather = values.get("weather");
		}
		else if (ruleInstance != null) {
			// Values Stored

			weather = ruleInstance.getTypeSettings();
		}

		context.put("weather", weather);
	}

	private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

	private static Log _log = LogFactoryUtil.getLog(WeatherRule.class);

	private static IPGeocoder _ipGeocoder;

}