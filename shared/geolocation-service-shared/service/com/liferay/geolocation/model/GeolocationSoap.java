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

package com.liferay.geolocation.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.geolocation.service.http.GeolocationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.geolocation.service.http.GeolocationServiceSoap
 * @generated
 */
public class GeolocationSoap implements Serializable {
	public static GeolocationSoap toSoapModel(Geolocation model) {
		GeolocationSoap soapModel = new GeolocationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGeolocationId(model.getGeolocationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setAreaCode(model.getAreaCode());
		soapModel.setCity(model.getCity());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setCountryName(model.getCountryName());
		soapModel.setMetroCode(model.getMetroCode());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setRegionName(model.getRegionName());
		soapModel.setZipCode(model.getZipCode());

		return soapModel;
	}

	public static GeolocationSoap[] toSoapModels(Geolocation[] models) {
		GeolocationSoap[] soapModels = new GeolocationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeolocationSoap[][] toSoapModels(Geolocation[][] models) {
		GeolocationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeolocationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeolocationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeolocationSoap[] toSoapModels(List<Geolocation> models) {
		List<GeolocationSoap> soapModels = new ArrayList<GeolocationSoap>(models.size());

		for (Geolocation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeolocationSoap[soapModels.size()]);
	}

	public GeolocationSoap() {
	}

	public long getPrimaryKey() {
		return _geolocationId;
	}

	public void setPrimaryKey(long pk) {
		setGeolocationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGeolocationId() {
		return _geolocationId;
	}

	public void setGeolocationId(long geolocationId) {
		_geolocationId = geolocationId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	public String getAreaCode() {
		return _areaCode;
	}

	public void setAreaCode(String areaCode) {
		_areaCode = areaCode;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public String getCountryName() {
		return _countryName;
	}

	public void setCountryName(String countryName) {
		_countryName = countryName;
	}

	public String getMetroCode() {
		return _metroCode;
	}

	public void setMetroCode(String metroCode) {
		_metroCode = metroCode;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public String getRegionName() {
		return _regionName;
	}

	public void setRegionName(String regionName) {
		_regionName = regionName;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	private String _uuid;
	private long _geolocationId;
	private long _companyId;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private double _latitude;
	private double _longitude;
	private String _areaCode;
	private String _city;
	private String _countryCode;
	private String _countryName;
	private String _metroCode;
	private String _regionCode;
	private String _regionName;
	private String _zipCode;
}