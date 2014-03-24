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

package com.liferay.contenttargeting.rules.ipgeocode;

import aQute.bnd.annotation.component.Component;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.rules.ipgeocode.model.IPInfo;
import com.liferay.contenttargeting.rules.ipgeocode.util.IPGeocodeUtil;
import com.liferay.portal.NoSuchRegionException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, provide = Rule.class)
public class IpGeocodeRule extends BaseRule {

	@Override
	public boolean evaluate(
			RuleInstance ruleInstance, AnonymousUser anonymousUser)
		throws Exception {

		IPInfo ipInfo = IPGeocodeUtil.getIPInfo(anonymousUser.getLastIp());

		if (ipInfo == null) {
			return false;
		}

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
			ruleInstance.getTypeSettings());

		long countryId = jsonObj.getLong("countryId");
		long regionId = jsonObj.getLong("regionId");

		Country country = CountryServiceUtil.fetchCountry(countryId);

		if (country == null) {
			return false;
		}

		Region region = null;

		try {
			region = RegionServiceUtil.getRegion(regionId);
		}
		catch (Exception e) {
		}

		String countryCode = ipInfo.getCountryCode();

		if (countryCode.equals(country.getA2())) {
			String regionName = ipInfo.getRegionName();

			if ((region == null) || regionName.equals(region.getName())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-globe";
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		String summary = StringPool.BLANK;

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			long countryId = jsonObj.getLong("countryId");
			long regionId = jsonObj.getLong("regionId");

			Country country = CountryServiceUtil.fetchCountry(countryId);
			Region region = null;

			try {
				region = RegionServiceUtil.getRegion(regionId);
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
		PortletRequest request, PortletResponse response) {

		long countryId = ParamUtil.getLong(request, "countryId");
		long regionId = ParamUtil.getLong(request, "regionId");

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("countryId", countryId);
		jsonObj.put("regionId", regionId);

		return jsonObj.toString();
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		long countryId = 0;
		long regionId = 0;

		if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				countryId = jsonObj.getLong("countryId");
				regionId = jsonObj.getLong("regionId");
			}
			catch (JSONException jse) {
			}
		}

		context.put("countryId", countryId);
		context.put("regionId", regionId);
	}

}