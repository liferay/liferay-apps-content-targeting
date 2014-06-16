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

package com.liferay.geolocation.service.persistence;

import com.liferay.geolocation.model.Geolocation;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the geolocation service. This utility wraps {@link GeolocationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GeolocationPersistence
 * @see GeolocationPersistenceImpl
 * @generated
 */
public class GeolocationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Geolocation geolocation) {
		getPersistence().clearCache(geolocation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Geolocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Geolocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Geolocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Geolocation update(Geolocation geolocation)
		throws SystemException {
		return getPersistence().update(geolocation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Geolocation update(Geolocation geolocation,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(geolocation, serviceContext);
	}

	/**
	* Returns all the geolocations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the geolocations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of geolocations
	* @param end the upper bound of the range of geolocations (not inclusive)
	* @return the range of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the geolocations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of geolocations
	* @param end the upper bound of the range of geolocations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first geolocation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first geolocation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last geolocation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last geolocation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the geolocations before and after the current geolocation in the ordered set where uuid = &#63;.
	*
	* @param geolocationId the primary key of the current geolocation
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation[] findByUuid_PrevAndNext(
		long geolocationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(geolocationId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the geolocations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of geolocations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the geolocations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the geolocations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of geolocations
	* @param end the upper bound of the range of geolocations (not inclusive)
	* @return the range of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the geolocations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of geolocations
	* @param end the upper bound of the range of geolocations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the geolocations before and after the current geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param geolocationId the primary key of the current geolocation
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation[] findByUuid_C_PrevAndNext(
		long geolocationId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(geolocationId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the geolocations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of geolocations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByC_C_C(
		long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Returns a range of all the geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of geolocations
	* @param end the upper bound of the range of geolocations (not inclusive)
	* @return the range of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C(companyId, classNameId, classPK, start, end);
	}

	/**
	* Returns an ordered range of all the geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of geolocations
	* @param end the upper bound of the range of geolocations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C(companyId, classNameId, classPK, start, end,
			orderByComparator);
	}

	/**
	* Returns the first geolocation in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation findByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_First(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the first geolocation in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation fetchByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_First(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the last geolocation in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation findByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_Last(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the last geolocation in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation fetchByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_C_Last(companyId, classNameId, classPK,
			orderByComparator);
	}

	/**
	* Returns the geolocations before and after the current geolocation in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param geolocationId the primary key of the current geolocation
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation[] findByC_C_C_PrevAndNext(
		long geolocationId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_C_PrevAndNext(geolocationId, companyId,
			classNameId, classPK, orderByComparator);
	}

	/**
	* Removes all the geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C_C(long companyId, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Returns the number of geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_C(long companyId, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C_C(companyId, classNameId, classPK);
	}

	/**
	* Returns all the geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByC_M_C_C(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_M_C_C(companyId, modifiedDate, classNameId, classPK);
	}

	/**
	* Returns a range of all the geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of geolocations
	* @param end the upper bound of the range of geolocations (not inclusive)
	* @return the range of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByC_M_C_C(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_M_C_C(companyId, modifiedDate, classNameId,
			classPK, start, end);
	}

	/**
	* Returns an ordered range of all the geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param start the lower bound of the range of geolocations
	* @param end the upper bound of the range of geolocations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findByC_M_C_C(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_M_C_C(companyId, modifiedDate, classNameId,
			classPK, start, end, orderByComparator);
	}

	/**
	* Returns the first geolocation in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation findByC_M_C_C_First(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_M_C_C_First(companyId, modifiedDate, classNameId,
			classPK, orderByComparator);
	}

	/**
	* Returns the first geolocation in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation fetchByC_M_C_C_First(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_M_C_C_First(companyId, modifiedDate, classNameId,
			classPK, orderByComparator);
	}

	/**
	* Returns the last geolocation in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation findByC_M_C_C_Last(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_M_C_C_Last(companyId, modifiedDate, classNameId,
			classPK, orderByComparator);
	}

	/**
	* Returns the last geolocation in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation fetchByC_M_C_C_Last(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_M_C_C_Last(companyId, modifiedDate, classNameId,
			classPK, orderByComparator);
	}

	/**
	* Returns the geolocations before and after the current geolocation in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param geolocationId the primary key of the current geolocation
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation[] findByC_M_C_C_PrevAndNext(
		long geolocationId, long companyId, java.util.Date modifiedDate,
		long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_M_C_C_PrevAndNext(geolocationId, companyId,
			modifiedDate, classNameId, classPK, orderByComparator);
	}

	/**
	* Removes all the geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_M_C_C(long companyId,
		java.util.Date modifiedDate, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByC_M_C_C(companyId, modifiedDate, classNameId, classPK);
	}

	/**
	* Returns the number of geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_M_C_C(long companyId,
		java.util.Date modifiedDate, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_M_C_C(companyId, modifiedDate, classNameId, classPK);
	}

	/**
	* Caches the geolocation in the entity cache if it is enabled.
	*
	* @param geolocation the geolocation
	*/
	public static void cacheResult(
		com.liferay.geolocation.model.Geolocation geolocation) {
		getPersistence().cacheResult(geolocation);
	}

	/**
	* Caches the geolocations in the entity cache if it is enabled.
	*
	* @param geolocations the geolocations
	*/
	public static void cacheResult(
		java.util.List<com.liferay.geolocation.model.Geolocation> geolocations) {
		getPersistence().cacheResult(geolocations);
	}

	/**
	* Creates a new geolocation with the primary key. Does not add the geolocation to the database.
	*
	* @param geolocationId the primary key for the new geolocation
	* @return the new geolocation
	*/
	public static com.liferay.geolocation.model.Geolocation create(
		long geolocationId) {
		return getPersistence().create(geolocationId);
	}

	/**
	* Removes the geolocation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geolocationId the primary key of the geolocation
	* @return the geolocation that was removed
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation remove(
		long geolocationId)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(geolocationId);
	}

	public static com.liferay.geolocation.model.Geolocation updateImpl(
		com.liferay.geolocation.model.Geolocation geolocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(geolocation);
	}

	/**
	* Returns the geolocation with the primary key or throws a {@link com.liferay.geolocation.NoSuchGeolocationException} if it could not be found.
	*
	* @param geolocationId the primary key of the geolocation
	* @return the geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation findByPrimaryKey(
		long geolocationId)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(geolocationId);
	}

	/**
	* Returns the geolocation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geolocationId the primary key of the geolocation
	* @return the geolocation, or <code>null</code> if a geolocation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.geolocation.model.Geolocation fetchByPrimaryKey(
		long geolocationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(geolocationId);
	}

	/**
	* Returns all the geolocations.
	*
	* @return the geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the geolocations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geolocations
	* @param end the upper bound of the range of geolocations (not inclusive)
	* @return the range of geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the geolocations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geolocations
	* @param end the upper bound of the range of geolocations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.geolocation.model.Geolocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the geolocations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of geolocations.
	*
	* @return the number of geolocations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GeolocationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GeolocationPersistence)PortletBeanLocatorUtil.locate(com.liferay.geolocation.service.ClpSerializer.getServletContextName(),
					GeolocationPersistence.class.getName());

			ReferenceRegistry.registerReference(GeolocationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GeolocationPersistence persistence) {
	}

	private static GeolocationPersistence _persistence;
}