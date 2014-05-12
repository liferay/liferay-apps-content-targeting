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

package com.liferay.geolocation.util;

import com.liferay.geolocation.model.Geolocation;
import com.liferay.geolocation.service.GeolocationLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;

/**
 * @author Eudaldo Alonso
 */
public class IPGeocodeUtil {

	public static Geolocation getGeolocation(JSONObject jsonObject) {

		// {"region_name":"California","metro_code":"807","region_code":"CA",
		// "zipcode":"94043","areacode":"650","longitude":-122.0574,
		// "latitude":37.4192,"country_code":"US", "country_name":"United
		// States","city":"Mountain View", "ip":"173.194.0.41"}

		Geolocation geolocation = GeolocationLocalServiceUtil.createGeolocation(
			0);

		geolocation.setLatitude(
			GetterUtil.getDouble(jsonObject.getString("latitude")));
		geolocation.setLongitude(
			GetterUtil.getDouble(jsonObject.getString("longitude")));
		geolocation.setAreaCode(jsonObject.getString("areaCode"));
		geolocation.setCity(jsonObject.getString("city"));
		geolocation.setCountryCode(jsonObject.getString("country_code"));
		geolocation.setCountryName(jsonObject.getString("country_name"));
		geolocation.setMetroCode(jsonObject.getString("metro_code"));
		geolocation.setRegionCode(jsonObject.getString("region_code"));
		geolocation.setRegionName(jsonObject.getString("region_name"));
		geolocation.setZipCode(jsonObject.getString("zipcode"));

		return geolocation;
	}

	public static Geolocation getGeolocation(String ipAddress) {
		Http.Options options = new Http.Options();

		options.setLocation("http://freegeoip.net/json/" + ipAddress);

		try {
			String text = HttpUtil.URLtoString(options);

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(text);

			return getGeolocation(jsonObject);
		}
		catch (Exception e) {
		}

		return null;
	}

}