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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the geolocation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GeolocationPersistenceImpl
 * @see GeolocationUtil
 * @generated
 */
public interface GeolocationPersistence extends BasePersistence<Geolocation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeolocationUtil} to access the geolocation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the geolocations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first geolocation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.geolocation.model.Geolocation findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first geolocation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.geolocation.model.Geolocation fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last geolocation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.geolocation.model.Geolocation findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last geolocation in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.geolocation.model.Geolocation fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation[] findByUuid_PrevAndNext(
		long geolocationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the geolocations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of geolocations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the geolocations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.geolocation.model.Geolocation fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geolocation, or <code>null</code> if a matching geolocation could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.geolocation.model.Geolocation fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation[] findByUuid_C_PrevAndNext(
		long geolocationId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the geolocations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of geolocations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByC_C_C(
		long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation findByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation fetchByC_C_C_First(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation findByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation fetchByC_C_C_Last(
		long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation[] findByC_C_C_PrevAndNext(
		long geolocationId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching geolocations
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByC_M_C_C(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByC_M_C_C(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findByC_M_C_C(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation findByC_M_C_C_First(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation fetchByC_M_C_C_First(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation findByC_M_C_C_Last(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation fetchByC_M_C_C_Last(
		long companyId, java.util.Date modifiedDate, long classNameId,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.geolocation.model.Geolocation[] findByC_M_C_C_PrevAndNext(
		long geolocationId, long companyId, java.util.Date modifiedDate,
		long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_M_C_C(long companyId, java.util.Date modifiedDate,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByC_M_C_C(long companyId, java.util.Date modifiedDate,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the geolocation in the entity cache if it is enabled.
	*
	* @param geolocation the geolocation
	*/
	public void cacheResult(
		com.liferay.geolocation.model.Geolocation geolocation);

	/**
	* Caches the geolocations in the entity cache if it is enabled.
	*
	* @param geolocations the geolocations
	*/
	public void cacheResult(
		java.util.List<com.liferay.geolocation.model.Geolocation> geolocations);

	/**
	* Creates a new geolocation with the primary key. Does not add the geolocation to the database.
	*
	* @param geolocationId the primary key for the new geolocation
	* @return the new geolocation
	*/
	public com.liferay.geolocation.model.Geolocation create(long geolocationId);

	/**
	* Removes the geolocation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geolocationId the primary key of the geolocation
	* @return the geolocation that was removed
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.geolocation.model.Geolocation remove(long geolocationId)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.geolocation.model.Geolocation updateImpl(
		com.liferay.geolocation.model.Geolocation geolocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the geolocation with the primary key or throws a {@link com.liferay.geolocation.NoSuchGeolocationException} if it could not be found.
	*
	* @param geolocationId the primary key of the geolocation
	* @return the geolocation
	* @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.geolocation.model.Geolocation findByPrimaryKey(
		long geolocationId)
		throws com.liferay.geolocation.NoSuchGeolocationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the geolocation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geolocationId the primary key of the geolocation
	* @return the geolocation, or <code>null</code> if a geolocation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.geolocation.model.Geolocation fetchByPrimaryKey(
		long geolocationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the geolocations.
	*
	* @return the geolocations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.geolocation.model.Geolocation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.geolocation.model.Geolocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the geolocations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of geolocations.
	*
	* @return the number of geolocations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}