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

package com.liferay.geolocation.model.impl;

import com.liferay.geolocation.model.Geolocation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Geolocation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Geolocation
 * @generated
 */
public class GeolocationCacheModel implements CacheModel<Geolocation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", geolocationId=");
		sb.append(geolocationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", areaCode=");
		sb.append(areaCode);
		sb.append(", city=");
		sb.append(city);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", countryName=");
		sb.append(countryName);
		sb.append(", metroCode=");
		sb.append(metroCode);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", regionName=");
		sb.append(regionName);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Geolocation toEntityModel() {
		GeolocationImpl geolocationImpl = new GeolocationImpl();

		if (uuid == null) {
			geolocationImpl.setUuid(StringPool.BLANK);
		}
		else {
			geolocationImpl.setUuid(uuid);
		}

		geolocationImpl.setGeolocationId(geolocationId);
		geolocationImpl.setCompanyId(companyId);

		if (modifiedDate == Long.MIN_VALUE) {
			geolocationImpl.setModifiedDate(null);
		}
		else {
			geolocationImpl.setModifiedDate(new Date(modifiedDate));
		}

		geolocationImpl.setClassNameId(classNameId);
		geolocationImpl.setClassPK(classPK);
		geolocationImpl.setLatitude(latitude);
		geolocationImpl.setLongitude(longitude);

		if (areaCode == null) {
			geolocationImpl.setAreaCode(StringPool.BLANK);
		}
		else {
			geolocationImpl.setAreaCode(areaCode);
		}

		if (city == null) {
			geolocationImpl.setCity(StringPool.BLANK);
		}
		else {
			geolocationImpl.setCity(city);
		}

		if (countryCode == null) {
			geolocationImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			geolocationImpl.setCountryCode(countryCode);
		}

		if (countryName == null) {
			geolocationImpl.setCountryName(StringPool.BLANK);
		}
		else {
			geolocationImpl.setCountryName(countryName);
		}

		if (metroCode == null) {
			geolocationImpl.setMetroCode(StringPool.BLANK);
		}
		else {
			geolocationImpl.setMetroCode(metroCode);
		}

		if (regionCode == null) {
			geolocationImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			geolocationImpl.setRegionCode(regionCode);
		}

		if (regionName == null) {
			geolocationImpl.setRegionName(StringPool.BLANK);
		}
		else {
			geolocationImpl.setRegionName(regionName);
		}

		if (zipCode == null) {
			geolocationImpl.setZipCode(StringPool.BLANK);
		}
		else {
			geolocationImpl.setZipCode(zipCode);
		}

		geolocationImpl.resetOriginalValues();

		return geolocationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		geolocationId = objectInput.readLong();
		companyId = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		latitude = objectInput.readDouble();
		longitude = objectInput.readDouble();
		areaCode = objectInput.readUTF();
		city = objectInput.readUTF();
		countryCode = objectInput.readUTF();
		countryName = objectInput.readUTF();
		metroCode = objectInput.readUTF();
		regionCode = objectInput.readUTF();
		regionName = objectInput.readUTF();
		zipCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(geolocationId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);
		objectOutput.writeDouble(latitude);
		objectOutput.writeDouble(longitude);

		if (areaCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(areaCode);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (countryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryName);
		}

		if (metroCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(metroCode);
		}

		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
		}

		if (regionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionName);
		}

		if (zipCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zipCode);
		}
	}

	public String uuid;
	public long geolocationId;
	public long companyId;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public double latitude;
	public double longitude;
	public String areaCode;
	public String city;
	public String countryCode;
	public String countryName;
	public String metroCode;
	public String regionCode;
	public String regionName;
	public String zipCode;
}