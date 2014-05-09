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

import com.liferay.geolocation.service.ClpSerializer;
import com.liferay.geolocation.service.GeolocationLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class GeolocationClp extends BaseModelImpl<Geolocation>
	implements Geolocation {
	public GeolocationClp() {
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
	public long getPrimaryKey() {
		return _geolocationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGeolocationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _geolocationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_geolocationRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGeolocationId() {
		return _geolocationId;
	}

	@Override
	public void setGeolocationId(long geolocationId) {
		_geolocationId = geolocationId;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setGeolocationId", long.class);

				method.invoke(_geolocationRemoteModel, geolocationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_geolocationRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_geolocationRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setClassNameId", long.class);

				method.invoke(_geolocationRemoteModel, classNameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_geolocationRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(double latitude) {
		_latitude = latitude;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", double.class);

				method.invoke(_geolocationRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(double longitude) {
		_longitude = longitude;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", double.class);

				method.invoke(_geolocationRemoteModel, longitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAreaCode() {
		return _areaCode;
	}

	@Override
	public void setAreaCode(String areaCode) {
		_areaCode = areaCode;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setAreaCode", String.class);

				method.invoke(_geolocationRemoteModel, areaCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_geolocationRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryCode() {
		return _countryCode;
	}

	@Override
	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_geolocationRemoteModel, countryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryName() {
		return _countryName;
	}

	@Override
	public void setCountryName(String countryName) {
		_countryName = countryName;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryName", String.class);

				method.invoke(_geolocationRemoteModel, countryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMetroCode() {
		return _metroCode;
	}

	@Override
	public void setMetroCode(String metroCode) {
		_metroCode = metroCode;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setMetroCode", String.class);

				method.invoke(_geolocationRemoteModel, metroCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionCode() {
		return _regionCode;
	}

	@Override
	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_geolocationRemoteModel, regionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionName() {
		return _regionName;
	}

	@Override
	public void setRegionName(String regionName) {
		_regionName = regionName;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionName", String.class);

				method.invoke(_geolocationRemoteModel, regionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZipCode() {
		return _zipCode;
	}

	@Override
	public void setZipCode(String zipCode) {
		_zipCode = zipCode;

		if (_geolocationRemoteModel != null) {
			try {
				Class<?> clazz = _geolocationRemoteModel.getClass();

				Method method = clazz.getMethod("setZipCode", String.class);

				method.invoke(_geolocationRemoteModel, zipCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGeolocationRemoteModel() {
		return _geolocationRemoteModel;
	}

	public void setGeolocationRemoteModel(BaseModel<?> geolocationRemoteModel) {
		_geolocationRemoteModel = geolocationRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _geolocationRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_geolocationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeolocationLocalServiceUtil.addGeolocation(this);
		}
		else {
			GeolocationLocalServiceUtil.updateGeolocation(this);
		}
	}

	@Override
	public Geolocation toEscapedModel() {
		return (Geolocation)ProxyUtil.newProxyInstance(Geolocation.class.getClassLoader(),
			new Class[] { Geolocation.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeolocationClp clone = new GeolocationClp();

		clone.setUuid(getUuid());
		clone.setGeolocationId(getGeolocationId());
		clone.setCompanyId(getCompanyId());
		clone.setModifiedDate(getModifiedDate());
		clone.setClassNameId(getClassNameId());
		clone.setClassPK(getClassPK());
		clone.setLatitude(getLatitude());
		clone.setLongitude(getLongitude());
		clone.setAreaCode(getAreaCode());
		clone.setCity(getCity());
		clone.setCountryCode(getCountryCode());
		clone.setCountryName(getCountryName());
		clone.setMetroCode(getMetroCode());
		clone.setRegionCode(getRegionCode());
		clone.setRegionName(getRegionName());
		clone.setZipCode(getZipCode());

		return clone;
	}

	@Override
	public int compareTo(Geolocation geolocation) {
		long primaryKey = geolocation.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeolocationClp)) {
			return false;
		}

		GeolocationClp geolocation = (GeolocationClp)obj;

		long primaryKey = geolocation.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", geolocationId=");
		sb.append(getGeolocationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", areaCode=");
		sb.append(getAreaCode());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", countryName=");
		sb.append(getCountryName());
		sb.append(", metroCode=");
		sb.append(getMetroCode());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", regionName=");
		sb.append(getRegionName());
		sb.append(", zipCode=");
		sb.append(getZipCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.liferay.geolocation.model.Geolocation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geolocationId</column-name><column-value><![CDATA[");
		sb.append(getGeolocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>areaCode</column-name><column-value><![CDATA[");
		sb.append(getAreaCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryName</column-name><column-value><![CDATA[");
		sb.append(getCountryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metroCode</column-name><column-value><![CDATA[");
		sb.append(getMetroCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionName</column-name><column-value><![CDATA[");
		sb.append(getRegionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipCode</column-name><column-value><![CDATA[");
		sb.append(getZipCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _geolocationRemoteModel;
}