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

package com.liferay.contenttargeting.rules.ipgeocode.model;

import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Eudaldo Alonso
 */
public class IPInfo {

	// {"region_name":"California","metro_code":"807","region_code":"CA",
	// "zipcode":"94043","areacode":"650","longitude":-122.0574,
	// "latitude":37.4192,"country_code":"US", "country_name":"United
	// States","city":"Mountain View", "ip":"173.194.0.41"}

	public IPInfo(JSONObject jsonObject) {
		_areaCode = jsonObject.getString("areacode");
		_city = jsonObject.getString("city");
		_countryCode = jsonObject.getString("country_code");
		_countryName = jsonObject.getString("country_name");
		_latitude = jsonObject.getString("latitude");
		_longitude = jsonObject.getString("longitude");
		_metroCode = jsonObject.getString("metro_code");
		_regionCode = jsonObject.getString("region_code");
		_regionName = jsonObject.getString("region_name");
		_zipCode = jsonObject.getString("zipcode");
	}

	public String getAreaCode() {
		return _areaCode;
	}

	public String getCity() {
		return _city;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public String getCountryName() {
		return _countryName;
	}

	public String getLatitude() {
		return _latitude;
	}

	public String getLongitude() {
		return _longitude;
	}

	public String getMetroCode() {
		return _metroCode;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public String getRegionName() {
		return _regionName;
	}

	public String getZipCode() {
		return _zipCode;
	}

	private String _areaCode;
	private String _city;
	private String _countryCode;
	private String _countryName;
	private String _latitude;
	private String _longitude;
	private String _metroCode;
	private String _regionCode;
	private String _regionName;
	private String _zipCode;

}