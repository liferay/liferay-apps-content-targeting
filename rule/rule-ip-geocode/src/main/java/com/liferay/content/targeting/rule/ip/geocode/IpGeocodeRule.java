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

package com.liferay.content.targeting.rule.ip.geocode;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.SessionAttributesRuleCategory;
import com.liferay.ip.geocoder.IPGeocoder;
import com.liferay.ip.geocoder.IPInfo;
import com.liferay.portal.kernel.exception.NoSuchRegionException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

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
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class IpGeocodeRule extends BaseRule {

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

		String ip = anonymousUser.getLastIp();

		IPInfo ipInfo = _ipGeocoder.getIPInfo(ip);

		if (ipInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Couldn't get ipInfo from " + ip + ", evaluation failed.");
			}

			return false;
		}

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
			ruleInstance.getTypeSettings());

		long countryId = jsonObj.getLong("countryId");
		long regionId = jsonObj.getLong("regionId");

		Country country = _countryService.fetchCountry(countryId);

		if (country == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Couldn't get country from " +
						countryId + ", evaluation failed.");
			}

			return false;
		}

		Region region = null;

		try {
			region = _regionService.getRegion(regionId);
		}
		catch (Exception e) {
		}

		String countryCode = ipInfo.getCountryCode();

		if (countryCode == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Couldn't get countryCode from " +
						ip + ", evaluation failed.");
			}

			return false;
		}

		if (countryCode.equals(country.getA2())) {
			String regionCode = ipInfo.getRegionCode();

			String regionName = ipInfo.getRegionName();

			if ((region == null) ||
				Validator.equals(regionName, region.getName()) ||
				Validator.equals(regionCode, region.getRegionCode())) {

				return true;
			}
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-location-arrow";
	}

	@Override
	public String getRuleCategoryKey() {
		return SessionAttributesRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		String summary = StringPool.BLANK;

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			long countryId = jsonObj.getLong("countryId");
			long regionId = jsonObj.getLong("regionId");

			Country country = _countryService.fetchCountry(countryId);
			Region region = null;

			try {
				region = _regionService.getRegion(regionId);
			}
			catch (NoSuchRegionException nsre) {
			}

			if (country != null) {
				if (region != null) {
					summary = LanguageUtil.format(
						locale, "users-from-x-x",
						new Object[] {
							country.getName(locale), region.getName()
						});
				}
				else {
					summary = LanguageUtil.format(
						locale, "users-from-x", country.getName(locale));
				}
			}
		}
		catch (Exception e) {
		}

		return summary;
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		long countryId = GetterUtil.getLong(values.get("countryId"));
		long regionId = GetterUtil.getLong(values.get("regionId"));

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("countryId", countryId);
		jsonObj.put("regionId", regionId);

		return jsonObj.toString();
	}

	@Reference(unbind = "unsetIPGeocoder")
	public void setIPGeocoder(IPGeocoder ipGeocoder) {
		_ipGeocoder = ipGeocoder;
	}

	public void unsetIPGeocoder(IPGeocoder ipGeocoder) {
		_ipGeocoder = null;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		long countryId = 0;
		long regionId = 0;

		if (!values.isEmpty()) {
			countryId = GetterUtil.getLong(values.get("countryId"));
			regionId = GetterUtil.getLong(values.get("regionId"));
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				countryId = jsonObj.getLong("countryId");
				regionId = jsonObj.getLong("regionId");
			}
			catch (JSONException jsone) {
			}
		}

		context.put("countryId", countryId);
		context.put("regionId", regionId);
	}

	@Reference(unbind = "-")
	protected void setCountryService(CountryService countryService) {
		_countryService = countryService;
	}

	@Reference(unbind = "-")
	protected void setRegionService(RegionService regionService) {
		_regionService = regionService;
	}

	private static final Log _log = LogFactoryUtil.getLog(IpGeocodeRule.class);

	private static IPGeocoder _ipGeocoder;

	private CountryService _countryService;
	private RegionService _regionService;

}