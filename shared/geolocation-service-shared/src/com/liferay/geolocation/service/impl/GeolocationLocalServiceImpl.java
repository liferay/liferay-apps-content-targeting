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

package com.liferay.geolocation.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.geolocation.model.Geolocation;
import com.liferay.geolocation.service.base.GeolocationLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;

/**
 * The implementation of the geolocation local service.
 *
 * @author Julio Camarero
 * @see com.liferay.geolocation.service.base.GeolocationLocalServiceBaseImpl
 * @see com.liferay.geolocation.service.GeolocationLocalServiceUtil
 */
public class GeolocationLocalServiceImpl
	extends GeolocationLocalServiceBaseImpl {

	@Override
	public Geolocation addGeolocation(
			long companyId, String className, long classPK, double latitude,
			double longitude, String areaCode, String city, String countryCode,
			String countryName, String metroCode, String regionCode,
			String regionName, String zipCode, ServiceContext serviceContext)
		throws PortalException, SystemException {

		long geolocationId = CounterLocalServiceUtil.increment();

		Geolocation geolocation = geolocationPersistence.create(geolocationId);

		geolocation.setCompanyId(companyId);

		Date now = new Date();

		geolocation.setModifiedDate(serviceContext.getModifiedDate(now));

		long classNameId = classNameLocalService.getClassNameId(className);

		geolocation.setClassNameId(classNameId);
		geolocation.setClassPK(classPK);
		geolocation.setLatitude(latitude);
		geolocation.setLongitude(longitude);
		geolocation.setAreaCode(areaCode);
		geolocation.setCity(city);
		geolocation.setCountryCode(countryCode);
		geolocation.setCountryName(countryName);
		geolocation.setMetroCode(metroCode);
		geolocation.setRegionCode(regionCode);
		geolocation.setRegionName(regionName);
		geolocation.setZipCode(zipCode);

		geolocationPersistence.update(geolocation);

		return geolocation;
	}

	@Override
	public Geolocation updateGeolocation(
			long companyId, String className, long classPK, double latitude,
			double longitude, String areaCode, String city, String countryCode,
			String countryName, String metroCode, String regionCode,
			String regionName, String zipCode, ServiceContext serviceContext)
		throws PortalException, SystemException {

		long classNameId = classNameLocalService.getClassNameId(className);

		Geolocation geolocation = geolocationPersistence.fetchByC_C(
			classNameId, classPK);

		if (geolocation == null) {
			return addGeolocation(
				companyId, className, classPK, latitude, longitude, areaCode,
				city, countryCode, countryName, metroCode, regionCode,
				regionName, zipCode, serviceContext);
		}

		Date now = new Date();

		geolocation.setModifiedDate(serviceContext.getModifiedDate(now));

		geolocation.setLatitude(latitude);
		geolocation.setLongitude(longitude);
		geolocation.setAreaCode(areaCode);
		geolocation.setCity(city);
		geolocation.setCountryCode(countryCode);
		geolocation.setCountryName(countryName);
		geolocation.setMetroCode(metroCode);
		geolocation.setRegionCode(regionCode);
		geolocation.setRegionName(regionName);
		geolocation.setZipCode(zipCode);

		geolocationPersistence.update(geolocation);

		return geolocation;
	}

}