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

package com.liferay.content.targeting.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.model.TrackingActionInstance;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tracking action instance service. This utility wraps {@link com.liferay.content.targeting.service.persistence.impl.TrackingActionInstancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstancePersistence
 * @see com.liferay.content.targeting.service.persistence.impl.TrackingActionInstancePersistenceImpl
 * @generated
 */
@ProviderType
public class TrackingActionInstanceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TrackingActionInstance trackingActionInstance) {
		getPersistence().clearCache(trackingActionInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TrackingActionInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrackingActionInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrackingActionInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TrackingActionInstance update(
		TrackingActionInstance trackingActionInstance) {
		return getPersistence().update(trackingActionInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TrackingActionInstance update(
		TrackingActionInstance trackingActionInstance,
		ServiceContext serviceContext) {
		return getPersistence().update(trackingActionInstance, serviceContext);
	}

	/**
	* Returns all the tracking action instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the tracking action instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the tracking action instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tracking action instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tracking action instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByUuid_First(
		java.lang.String uuid,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first tracking action instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByUuid_First(
		java.lang.String uuid,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the tracking action instances before and after the current tracking action instance in the ordered set where uuid = &#63;.
	*
	* @param trackingActionInstanceId the primary key of the current tracking action instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance[] findByUuid_PrevAndNext(
		long trackingActionInstanceId, java.lang.String uuid,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByUuid_PrevAndNext(trackingActionInstanceId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the tracking action instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of tracking action instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching tracking action instances
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the tracking action instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTrackingActionInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the tracking action instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the tracking action instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the tracking action instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the tracking action instance that was removed
	*/
	public static TrackingActionInstance removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of tracking action instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching tracking action instances
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the tracking action instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByUuid_C(
		java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the tracking action instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the tracking action instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tracking action instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tracking action instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first tracking action instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the tracking action instances before and after the current tracking action instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param trackingActionInstanceId the primary key of the current tracking action instance
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance[] findByUuid_C_PrevAndNext(
		long trackingActionInstanceId, java.lang.String uuid, long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(trackingActionInstanceId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the tracking action instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of tracking action instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching tracking action instances
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the tracking action instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the tracking action instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByGroupId(long groupId,
		int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the tracking action instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByGroupId(long groupId,
		int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tracking action instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByGroupId(long groupId,
		int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tracking action instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByGroupId_First(long groupId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first tracking action instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByGroupId_First(long groupId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByGroupId_Last(long groupId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByGroupId_Last(long groupId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the tracking action instances before and after the current tracking action instance in the ordered set where groupId = &#63;.
	*
	* @param trackingActionInstanceId the primary key of the current tracking action instance
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance[] findByGroupId_PrevAndNext(
		long trackingActionInstanceId, long groupId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(trackingActionInstanceId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the tracking action instances where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of tracking action instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tracking action instances
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the tracking action instances where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByCampaignId(long campaignId) {
		return getPersistence().findByCampaignId(campaignId);
	}

	/**
	* Returns a range of all the tracking action instances where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByCampaignId(
		long campaignId, int start, int end) {
		return getPersistence().findByCampaignId(campaignId, start, end);
	}

	/**
	* Returns an ordered range of all the tracking action instances where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByCampaignId(
		long campaignId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tracking action instances where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByCampaignId(
		long campaignId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tracking action instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByCampaignId_First(
		long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first tracking action instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByCampaignId_First(
		long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByCampaignId_Last(
		long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByCampaignId_Last(
		long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the tracking action instances before and after the current tracking action instance in the ordered set where campaignId = &#63;.
	*
	* @param trackingActionInstanceId the primary key of the current tracking action instance
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance[] findByCampaignId_PrevAndNext(
		long trackingActionInstanceId, long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(trackingActionInstanceId,
			campaignId, orderByComparator);
	}

	/**
	* Removes all the tracking action instances where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	*/
	public static void removeByCampaignId(long campaignId) {
		getPersistence().removeByCampaignId(campaignId);
	}

	/**
	* Returns the number of tracking action instances where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching tracking action instances
	*/
	public static int countByCampaignId(long campaignId) {
		return getPersistence().countByCampaignId(campaignId);
	}

	/**
	* Returns all the tracking action instances where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @return the matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByReportInstanceId(
		long reportInstanceId) {
		return getPersistence().findByReportInstanceId(reportInstanceId);
	}

	/**
	* Returns a range of all the tracking action instances where reportInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByReportInstanceId(
		long reportInstanceId, int start, int end) {
		return getPersistence()
				   .findByReportInstanceId(reportInstanceId, start, end);
	}

	/**
	* Returns an ordered range of all the tracking action instances where reportInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByReportInstanceId(
		long reportInstanceId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .findByReportInstanceId(reportInstanceId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the tracking action instances where reportInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByReportInstanceId(
		long reportInstanceId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByReportInstanceId(reportInstanceId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tracking action instance in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByReportInstanceId_First(
		long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByReportInstanceId_First(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the first tracking action instance in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByReportInstanceId_First(
		long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByReportInstanceId_First(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByReportInstanceId_Last(
		long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByReportInstanceId_Last(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByReportInstanceId_Last(
		long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByReportInstanceId_Last(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the tracking action instances before and after the current tracking action instance in the ordered set where reportInstanceId = &#63;.
	*
	* @param trackingActionInstanceId the primary key of the current tracking action instance
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance[] findByReportInstanceId_PrevAndNext(
		long trackingActionInstanceId, long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByReportInstanceId_PrevAndNext(trackingActionInstanceId,
			reportInstanceId, orderByComparator);
	}

	/**
	* Removes all the tracking action instances where reportInstanceId = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	*/
	public static void removeByReportInstanceId(long reportInstanceId) {
		getPersistence().removeByReportInstanceId(reportInstanceId);
	}

	/**
	* Returns the number of tracking action instances where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @return the number of matching tracking action instances
	*/
	public static int countByReportInstanceId(long reportInstanceId) {
		return getPersistence().countByReportInstanceId(reportInstanceId);
	}

	/**
	* Returns the tracking action instance where campaignId = &#63; and alias = &#63; or throws a {@link NoSuchTrackingActionInstanceException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @return the matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByC_A(long campaignId,
		java.lang.String alias)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().findByC_A(campaignId, alias);
	}

	/**
	* Returns the tracking action instance where campaignId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByC_A(long campaignId,
		java.lang.String alias) {
		return getPersistence().fetchByC_A(campaignId, alias);
	}

	/**
	* Returns the tracking action instance where campaignId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByC_A(long campaignId,
		java.lang.String alias, boolean retrieveFromCache) {
		return getPersistence().fetchByC_A(campaignId, alias, retrieveFromCache);
	}

	/**
	* Removes the tracking action instance where campaignId = &#63; and alias = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @return the tracking action instance that was removed
	*/
	public static TrackingActionInstance removeByC_A(long campaignId,
		java.lang.String alias)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().removeByC_A(campaignId, alias);
	}

	/**
	* Returns the number of tracking action instances where campaignId = &#63; and alias = &#63;.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @return the number of matching tracking action instances
	*/
	public static int countByC_A(long campaignId, java.lang.String alias) {
		return getPersistence().countByC_A(campaignId, alias);
	}

	/**
	* Returns the tracking action instance where reportInstanceId = &#63; and alias = &#63; or throws a {@link NoSuchTrackingActionInstanceException} if it could not be found.
	*
	* @param reportInstanceId the report instance ID
	* @param alias the alias
	* @return the matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByR_A(long reportInstanceId,
		java.lang.String alias)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().findByR_A(reportInstanceId, alias);
	}

	/**
	* Returns the tracking action instance where reportInstanceId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param reportInstanceId the report instance ID
	* @param alias the alias
	* @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByR_A(long reportInstanceId,
		java.lang.String alias) {
		return getPersistence().fetchByR_A(reportInstanceId, alias);
	}

	/**
	* Returns the tracking action instance where reportInstanceId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param reportInstanceId the report instance ID
	* @param alias the alias
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByR_A(long reportInstanceId,
		java.lang.String alias, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByR_A(reportInstanceId, alias, retrieveFromCache);
	}

	/**
	* Removes the tracking action instance where reportInstanceId = &#63; and alias = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param alias the alias
	* @return the tracking action instance that was removed
	*/
	public static TrackingActionInstance removeByR_A(long reportInstanceId,
		java.lang.String alias)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().removeByR_A(reportInstanceId, alias);
	}

	/**
	* Returns the number of tracking action instances where reportInstanceId = &#63; and alias = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param alias the alias
	* @return the number of matching tracking action instances
	*/
	public static int countByR_A(long reportInstanceId, java.lang.String alias) {
		return getPersistence().countByR_A(reportInstanceId, alias);
	}

	/**
	* Returns all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByC_E_E(long campaignId,
		java.lang.String elementId, java.lang.String eventType) {
		return getPersistence().findByC_E_E(campaignId, elementId, eventType);
	}

	/**
	* Returns a range of all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByC_E_E(long campaignId,
		java.lang.String elementId, java.lang.String eventType, int start,
		int end) {
		return getPersistence()
				   .findByC_E_E(campaignId, elementId, eventType, start, end);
	}

	/**
	* Returns an ordered range of all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByC_E_E(long campaignId,
		java.lang.String elementId, java.lang.String eventType, int start,
		int end, OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .findByC_E_E(campaignId, elementId, eventType, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByC_E_E(long campaignId,
		java.lang.String elementId, java.lang.String eventType, int start,
		int end, OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_E_E(campaignId, elementId, eventType, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tracking action instance in the ordered set where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByC_E_E_First(long campaignId,
		java.lang.String elementId, java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByC_E_E_First(campaignId, elementId, eventType,
			orderByComparator);
	}

	/**
	* Returns the first tracking action instance in the ordered set where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByC_E_E_First(long campaignId,
		java.lang.String elementId, java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByC_E_E_First(campaignId, elementId, eventType,
			orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByC_E_E_Last(long campaignId,
		java.lang.String elementId, java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByC_E_E_Last(campaignId, elementId, eventType,
			orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByC_E_E_Last(long campaignId,
		java.lang.String elementId, java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByC_E_E_Last(campaignId, elementId, eventType,
			orderByComparator);
	}

	/**
	* Returns the tracking action instances before and after the current tracking action instance in the ordered set where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param trackingActionInstanceId the primary key of the current tracking action instance
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance[] findByC_E_E_PrevAndNext(
		long trackingActionInstanceId, long campaignId,
		java.lang.String elementId, java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByC_E_E_PrevAndNext(trackingActionInstanceId,
			campaignId, elementId, eventType, orderByComparator);
	}

	/**
	* Removes all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	*/
	public static void removeByC_E_E(long campaignId,
		java.lang.String elementId, java.lang.String eventType) {
		getPersistence().removeByC_E_E(campaignId, elementId, eventType);
	}

	/**
	* Returns the number of tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param eventType the event type
	* @return the number of matching tracking action instances
	*/
	public static int countByC_E_E(long campaignId, java.lang.String elementId,
		java.lang.String eventType) {
		return getPersistence().countByC_E_E(campaignId, elementId, eventType);
	}

	/**
	* Returns all the tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByR_E_E(
		long reportInstanceId, java.lang.String elementId,
		java.lang.String eventType) {
		return getPersistence()
				   .findByR_E_E(reportInstanceId, elementId, eventType);
	}

	/**
	* Returns a range of all the tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByR_E_E(
		long reportInstanceId, java.lang.String elementId,
		java.lang.String eventType, int start, int end) {
		return getPersistence()
				   .findByR_E_E(reportInstanceId, elementId, eventType, start,
			end);
	}

	/**
	* Returns an ordered range of all the tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByR_E_E(
		long reportInstanceId, java.lang.String elementId,
		java.lang.String eventType, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .findByR_E_E(reportInstanceId, elementId, eventType, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByR_E_E(
		long reportInstanceId, java.lang.String elementId,
		java.lang.String eventType, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByR_E_E(reportInstanceId, elementId, eventType, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tracking action instance in the ordered set where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByR_E_E_First(
		long reportInstanceId, java.lang.String elementId,
		java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByR_E_E_First(reportInstanceId, elementId, eventType,
			orderByComparator);
	}

	/**
	* Returns the first tracking action instance in the ordered set where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByR_E_E_First(
		long reportInstanceId, java.lang.String elementId,
		java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByR_E_E_First(reportInstanceId, elementId, eventType,
			orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByR_E_E_Last(
		long reportInstanceId, java.lang.String elementId,
		java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByR_E_E_Last(reportInstanceId, elementId, eventType,
			orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByR_E_E_Last(
		long reportInstanceId, java.lang.String elementId,
		java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByR_E_E_Last(reportInstanceId, elementId, eventType,
			orderByComparator);
	}

	/**
	* Returns the tracking action instances before and after the current tracking action instance in the ordered set where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param trackingActionInstanceId the primary key of the current tracking action instance
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance[] findByR_E_E_PrevAndNext(
		long trackingActionInstanceId, long reportInstanceId,
		java.lang.String elementId, java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByR_E_E_PrevAndNext(trackingActionInstanceId,
			reportInstanceId, elementId, eventType, orderByComparator);
	}

	/**
	* Removes all the tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	*/
	public static void removeByR_E_E(long reportInstanceId,
		java.lang.String elementId, java.lang.String eventType) {
		getPersistence().removeByR_E_E(reportInstanceId, elementId, eventType);
	}

	/**
	* Returns the number of tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param eventType the event type
	* @return the number of matching tracking action instances
	*/
	public static int countByR_E_E(long reportInstanceId,
		java.lang.String elementId, java.lang.String eventType) {
		return getPersistence()
				   .countByR_E_E(reportInstanceId, elementId, eventType);
	}

	/**
	* Returns all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @return the matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType) {
		return getPersistence()
				   .findByC_R_R_E(campaignId, referrerClassName,
			referrerClassPK, eventType);
	}

	/**
	* Returns a range of all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int start, int end) {
		return getPersistence()
				   .findByC_R_R_E(campaignId, referrerClassName,
			referrerClassPK, eventType, start, end);
	}

	/**
	* Returns an ordered range of all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .findByC_R_R_E(campaignId, referrerClassName,
			referrerClassPK, eventType, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_R_R_E(campaignId, referrerClassName,
			referrerClassPK, eventType, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tracking action instance in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByC_R_R_E_First(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByC_R_R_E_First(campaignId, referrerClassName,
			referrerClassPK, eventType, orderByComparator);
	}

	/**
	* Returns the first tracking action instance in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByC_R_R_E_First(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByC_R_R_E_First(campaignId, referrerClassName,
			referrerClassPK, eventType, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByC_R_R_E_Last(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByC_R_R_E_Last(campaignId, referrerClassName,
			referrerClassPK, eventType, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByC_R_R_E_Last(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByC_R_R_E_Last(campaignId, referrerClassName,
			referrerClassPK, eventType, orderByComparator);
	}

	/**
	* Returns the tracking action instances before and after the current tracking action instance in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param trackingActionInstanceId the primary key of the current tracking action instance
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance[] findByC_R_R_E_PrevAndNext(
		long trackingActionInstanceId, long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByC_R_R_E_PrevAndNext(trackingActionInstanceId,
			campaignId, referrerClassName, referrerClassPK, eventType,
			orderByComparator);
	}

	/**
	* Removes all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	*/
	public static void removeByC_R_R_E(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType) {
		getPersistence()
			.removeByC_R_R_E(campaignId, referrerClassName, referrerClassPK,
			eventType);
	}

	/**
	* Returns the number of tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @return the number of matching tracking action instances
	*/
	public static int countByC_R_R_E(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType) {
		return getPersistence()
				   .countByC_R_R_E(campaignId, referrerClassName,
			referrerClassPK, eventType);
	}

	/**
	* Returns all the tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @return the matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByR_R_R_E(
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String eventType) {
		return getPersistence()
				   .findByR_R_R_E(reportInstanceId, referrerClassName,
			referrerClassPK, eventType);
	}

	/**
	* Returns a range of all the tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByR_R_R_E(
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String eventType, int start, int end) {
		return getPersistence()
				   .findByR_R_R_E(reportInstanceId, referrerClassName,
			referrerClassPK, eventType, start, end);
	}

	/**
	* Returns an ordered range of all the tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByR_R_R_E(
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String eventType, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .findByR_R_R_E(reportInstanceId, referrerClassName,
			referrerClassPK, eventType, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tracking action instances
	*/
	public static List<TrackingActionInstance> findByR_R_R_E(
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String eventType, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByR_R_R_E(reportInstanceId, referrerClassName,
			referrerClassPK, eventType, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tracking action instance in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByR_R_R_E_First(
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByR_R_R_E_First(reportInstanceId, referrerClassName,
			referrerClassPK, eventType, orderByComparator);
	}

	/**
	* Returns the first tracking action instance in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByR_R_R_E_First(
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByR_R_R_E_First(reportInstanceId, referrerClassName,
			referrerClassPK, eventType, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance findByR_R_R_E_Last(
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByR_R_R_E_Last(reportInstanceId, referrerClassName,
			referrerClassPK, eventType, orderByComparator);
	}

	/**
	* Returns the last tracking action instance in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static TrackingActionInstance fetchByR_R_R_E_Last(
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence()
				   .fetchByR_R_R_E_Last(reportInstanceId, referrerClassName,
			referrerClassPK, eventType, orderByComparator);
	}

	/**
	* Returns the tracking action instances before and after the current tracking action instance in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param trackingActionInstanceId the primary key of the current tracking action instance
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance[] findByR_R_R_E_PrevAndNext(
		long trackingActionInstanceId, long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence()
				   .findByR_R_R_E_PrevAndNext(trackingActionInstanceId,
			reportInstanceId, referrerClassName, referrerClassPK, eventType,
			orderByComparator);
	}

	/**
	* Removes all the tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	*/
	public static void removeByR_R_R_E(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType) {
		getPersistence()
			.removeByR_R_R_E(reportInstanceId, referrerClassName,
			referrerClassPK, eventType);
	}

	/**
	* Returns the number of tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @return the number of matching tracking action instances
	*/
	public static int countByR_R_R_E(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType) {
		return getPersistence()
				   .countByR_R_R_E(reportInstanceId, referrerClassName,
			referrerClassPK, eventType);
	}

	/**
	* Caches the tracking action instance in the entity cache if it is enabled.
	*
	* @param trackingActionInstance the tracking action instance
	*/
	public static void cacheResult(
		TrackingActionInstance trackingActionInstance) {
		getPersistence().cacheResult(trackingActionInstance);
	}

	/**
	* Caches the tracking action instances in the entity cache if it is enabled.
	*
	* @param trackingActionInstances the tracking action instances
	*/
	public static void cacheResult(
		List<TrackingActionInstance> trackingActionInstances) {
		getPersistence().cacheResult(trackingActionInstances);
	}

	/**
	* Creates a new tracking action instance with the primary key. Does not add the tracking action instance to the database.
	*
	* @param trackingActionInstanceId the primary key for the new tracking action instance
	* @return the new tracking action instance
	*/
	public static TrackingActionInstance create(long trackingActionInstanceId) {
		return getPersistence().create(trackingActionInstanceId);
	}

	/**
	* Removes the tracking action instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstanceId the primary key of the tracking action instance
	* @return the tracking action instance that was removed
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance remove(long trackingActionInstanceId)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().remove(trackingActionInstanceId);
	}

	public static TrackingActionInstance updateImpl(
		TrackingActionInstance trackingActionInstance) {
		return getPersistence().updateImpl(trackingActionInstance);
	}

	/**
	* Returns the tracking action instance with the primary key or throws a {@link NoSuchTrackingActionInstanceException} if it could not be found.
	*
	* @param trackingActionInstanceId the primary key of the tracking action instance
	* @return the tracking action instance
	* @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance findByPrimaryKey(
		long trackingActionInstanceId)
		throws com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException {
		return getPersistence().findByPrimaryKey(trackingActionInstanceId);
	}

	/**
	* Returns the tracking action instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param trackingActionInstanceId the primary key of the tracking action instance
	* @return the tracking action instance, or <code>null</code> if a tracking action instance with the primary key could not be found
	*/
	public static TrackingActionInstance fetchByPrimaryKey(
		long trackingActionInstanceId) {
		return getPersistence().fetchByPrimaryKey(trackingActionInstanceId);
	}

	public static java.util.Map<java.io.Serializable, TrackingActionInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tracking action instances.
	*
	* @return the tracking action instances
	*/
	public static List<TrackingActionInstance> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tracking action instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of tracking action instances
	*/
	public static List<TrackingActionInstance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tracking action instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tracking action instances
	*/
	public static List<TrackingActionInstance> findAll(int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tracking action instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tracking action instances
	*/
	public static List<TrackingActionInstance> findAll(int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tracking action instances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tracking action instances.
	*
	* @return the number of tracking action instances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TrackingActionInstancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TrackingActionInstancePersistence, TrackingActionInstancePersistence> _serviceTracker =
		ServiceTrackerFactory.open(TrackingActionInstancePersistence.class);
}