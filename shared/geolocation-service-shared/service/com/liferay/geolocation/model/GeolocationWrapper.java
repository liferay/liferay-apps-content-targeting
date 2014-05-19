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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Geolocation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Geolocation
 * @generated
 */
public class GeolocationWrapper implements Geolocation,
	ModelWrapper<Geolocation> {
	public GeolocationWrapper(Geolocation geolocation) {
		_geolocation = geolocation;
	}

	@Override
	public Class<?> getModelClass() {
		return Geolocation.class;
	}

	@Override
	public String getModelClassName() {
		return Geolocation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("geolocationId", getGeolocationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("areaCode", getAreaCode());
		attributes.put("city", getCity());
		attributes.put("countryCode", getCountryCode());
		attributes.put("countryName", getCountryName());
		attributes.put("metroCode", getMetroCode());
		attributes.put("regionCode", getRegionCode());
		attributes.put("regionName", getRegionName());
		attributes.put("zipCode", getZipCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long geolocationId = (Long)attributes.get("geolocationId");

		if (geolocationId != null) {
			setGeolocationId(geolocationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String areaCode = (String)attributes.get("areaCode");

		if (areaCode != null) {
			setAreaCode(areaCode);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		String metroCode = (String)attributes.get("metroCode");

		if (metroCode != null) {
			setMetroCode(metroCode);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String regionName = (String)attributes.get("regionName");

		if (regionName != null) {
			setRegionName(regionName);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}
	}

	/**
	* Returns the primary key of this geolocation.
	*
	* @return the primary key of this geolocation
	*/
	@Override
	public long getPrimaryKey() {
		return _geolocation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this geolocation.
	*
	* @param primaryKey the primary key of this geolocation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_geolocation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this geolocation.
	*
	* @return the uuid of this geolocation
	*/
	@Override
	public java.lang.String getUuid() {
		return _geolocation.getUuid();
	}

	/**
	* Sets the uuid of this geolocation.
	*
	* @param uuid the uuid of this geolocation
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_geolocation.setUuid(uuid);
	}

	/**
	* Returns the geolocation ID of this geolocation.
	*
	* @return the geolocation ID of this geolocation
	*/
	@Override
	public long getGeolocationId() {
		return _geolocation.getGeolocationId();
	}

	/**
	* Sets the geolocation ID of this geolocation.
	*
	* @param geolocationId the geolocation ID of this geolocation
	*/
	@Override
	public void setGeolocationId(long geolocationId) {
		_geolocation.setGeolocationId(geolocationId);
	}

	/**
	* Returns the company ID of this geolocation.
	*
	* @return the company ID of this geolocation
	*/
	@Override
	public long getCompanyId() {
		return _geolocation.getCompanyId();
	}

	/**
	* Sets the company ID of this geolocation.
	*
	* @param companyId the company ID of this geolocation
	*/
	@Override
	public void setCompanyId(long companyId) {
		_geolocation.setCompanyId(companyId);
	}

	/**
	* Returns the modified date of this geolocation.
	*
	* @return the modified date of this geolocation
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _geolocation.getModifiedDate();
	}

	/**
	* Sets the modified date of this geolocation.
	*
	* @param modifiedDate the modified date of this geolocation
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_geolocation.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the fully qualified class name of this geolocation.
	*
	* @return the fully qualified class name of this geolocation
	*/
	@Override
	public java.lang.String getClassName() {
		return _geolocation.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_geolocation.setClassName(className);
	}

	/**
	* Returns the class name ID of this geolocation.
	*
	* @return the class name ID of this geolocation
	*/
	@Override
	public long getClassNameId() {
		return _geolocation.getClassNameId();
	}

	/**
	* Sets the class name ID of this geolocation.
	*
	* @param classNameId the class name ID of this geolocation
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_geolocation.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this geolocation.
	*
	* @return the class p k of this geolocation
	*/
	@Override
	public long getClassPK() {
		return _geolocation.getClassPK();
	}

	/**
	* Sets the class p k of this geolocation.
	*
	* @param classPK the class p k of this geolocation
	*/
	@Override
	public void setClassPK(long classPK) {
		_geolocation.setClassPK(classPK);
	}

	/**
	* Returns the latitude of this geolocation.
	*
	* @return the latitude of this geolocation
	*/
	@Override
	public double getLatitude() {
		return _geolocation.getLatitude();
	}

	/**
	* Sets the latitude of this geolocation.
	*
	* @param latitude the latitude of this geolocation
	*/
	@Override
	public void setLatitude(double latitude) {
		_geolocation.setLatitude(latitude);
	}

	/**
	* Returns the longitude of this geolocation.
	*
	* @return the longitude of this geolocation
	*/
	@Override
	public double getLongitude() {
		return _geolocation.getLongitude();
	}

	/**
	* Sets the longitude of this geolocation.
	*
	* @param longitude the longitude of this geolocation
	*/
	@Override
	public void setLongitude(double longitude) {
		_geolocation.setLongitude(longitude);
	}

	/**
	* Returns the area code of this geolocation.
	*
	* @return the area code of this geolocation
	*/
	@Override
	public java.lang.String getAreaCode() {
		return _geolocation.getAreaCode();
	}

	/**
	* Sets the area code of this geolocation.
	*
	* @param areaCode the area code of this geolocation
	*/
	@Override
	public void setAreaCode(java.lang.String areaCode) {
		_geolocation.setAreaCode(areaCode);
	}

	/**
	* Returns the city of this geolocation.
	*
	* @return the city of this geolocation
	*/
	@Override
	public java.lang.String getCity() {
		return _geolocation.getCity();
	}

	/**
	* Sets the city of this geolocation.
	*
	* @param city the city of this geolocation
	*/
	@Override
	public void setCity(java.lang.String city) {
		_geolocation.setCity(city);
	}

	/**
	* Returns the country code of this geolocation.
	*
	* @return the country code of this geolocation
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _geolocation.getCountryCode();
	}

	/**
	* Sets the country code of this geolocation.
	*
	* @param countryCode the country code of this geolocation
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_geolocation.setCountryCode(countryCode);
	}

	/**
	* Returns the country name of this geolocation.
	*
	* @return the country name of this geolocation
	*/
	@Override
	public java.lang.String getCountryName() {
		return _geolocation.getCountryName();
	}

	/**
	* Sets the country name of this geolocation.
	*
	* @param countryName the country name of this geolocation
	*/
	@Override
	public void setCountryName(java.lang.String countryName) {
		_geolocation.setCountryName(countryName);
	}

	/**
	* Returns the metro code of this geolocation.
	*
	* @return the metro code of this geolocation
	*/
	@Override
	public java.lang.String getMetroCode() {
		return _geolocation.getMetroCode();
	}

	/**
	* Sets the metro code of this geolocation.
	*
	* @param metroCode the metro code of this geolocation
	*/
	@Override
	public void setMetroCode(java.lang.String metroCode) {
		_geolocation.setMetroCode(metroCode);
	}

	/**
	* Returns the region code of this geolocation.
	*
	* @return the region code of this geolocation
	*/
	@Override
	public java.lang.String getRegionCode() {
		return _geolocation.getRegionCode();
	}

	/**
	* Sets the region code of this geolocation.
	*
	* @param regionCode the region code of this geolocation
	*/
	@Override
	public void setRegionCode(java.lang.String regionCode) {
		_geolocation.setRegionCode(regionCode);
	}

	/**
	* Returns the region name of this geolocation.
	*
	* @return the region name of this geolocation
	*/
	@Override
	public java.lang.String getRegionName() {
		return _geolocation.getRegionName();
	}

	/**
	* Sets the region name of this geolocation.
	*
	* @param regionName the region name of this geolocation
	*/
	@Override
	public void setRegionName(java.lang.String regionName) {
		_geolocation.setRegionName(regionName);
	}

	/**
	* Returns the zip code of this geolocation.
	*
	* @return the zip code of this geolocation
	*/
	@Override
	public java.lang.String getZipCode() {
		return _geolocation.getZipCode();
	}

	/**
	* Sets the zip code of this geolocation.
	*
	* @param zipCode the zip code of this geolocation
	*/
	@Override
	public void setZipCode(java.lang.String zipCode) {
		_geolocation.setZipCode(zipCode);
	}

	@Override
	public boolean isNew() {
		return _geolocation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_geolocation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _geolocation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geolocation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _geolocation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _geolocation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_geolocation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _geolocation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_geolocation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_geolocation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_geolocation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeolocationWrapper((Geolocation)_geolocation.clone());
	}

	@Override
	public int compareTo(Geolocation geolocation) {
		return _geolocation.compareTo(geolocation);
	}

	@Override
	public int hashCode() {
		return _geolocation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Geolocation> toCacheModel() {
		return _geolocation.toCacheModel();
	}

	@Override
	public Geolocation toEscapedModel() {
		return new GeolocationWrapper(_geolocation.toEscapedModel());
	}

	@Override
	public Geolocation toUnescapedModel() {
		return new GeolocationWrapper(_geolocation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _geolocation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _geolocation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_geolocation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeolocationWrapper)) {
			return false;
		}

		GeolocationWrapper geolocationWrapper = (GeolocationWrapper)obj;

		if (Validator.equals(_geolocation, geolocationWrapper._geolocation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Geolocation getWrappedGeolocation() {
		return _geolocation;
	}

	@Override
	public Geolocation getWrappedModel() {
		return _geolocation;
	}

	@Override
	public void resetOriginalValues() {
		_geolocation.resetOriginalValues();
	}

	private Geolocation _geolocation;
}