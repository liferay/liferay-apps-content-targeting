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

import com.liferay.content.targeting.model.UserSegment;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user segment service. This utility wraps {@link com.liferay.content.targeting.service.persistence.impl.UserSegmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentPersistence
 * @see com.liferay.content.targeting.service.persistence.impl.UserSegmentPersistenceImpl
 * @generated
 */
@ProviderType
public class UserSegmentUtil {
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
	public static void clearCache(UserSegment userSegment) {
		getPersistence().clearCache(userSegment);
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
	public static List<UserSegment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserSegment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserSegment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserSegment update(UserSegment userSegment) {
		return getPersistence().update(userSegment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserSegment update(UserSegment userSegment,
		ServiceContext serviceContext) {
		return getPersistence().update(userSegment, serviceContext);
	}

	/**
	* Returns all the user segments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user segments
	*/
	public static List<UserSegment> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the user segments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of matching user segments
	*/
	public static List<UserSegment> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the user segments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user segments
	*/
	public static List<UserSegment> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user segments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user segments
	*/
	public static List<UserSegment> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user segment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public static UserSegment findByUuid_First(java.lang.String uuid,
		OrderByComparator<UserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first user segment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static UserSegment fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last user segment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public static UserSegment findByUuid_Last(java.lang.String uuid,
		OrderByComparator<UserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last user segment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static UserSegment fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the user segments before and after the current user segment in the ordered set where uuid = &#63;.
	*
	* @param userSegmentId the primary key of the current user segment
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public static UserSegment[] findByUuid_PrevAndNext(long userSegmentId,
		java.lang.String uuid, OrderByComparator<UserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence()
				   .findByUuid_PrevAndNext(userSegmentId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the user segments where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of user segments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user segments
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the user segment where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchUserSegmentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public static UserSegment findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the user segment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static UserSegment fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the user segment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static UserSegment fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the user segment where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the user segment that was removed
	*/
	public static UserSegment removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of user segments where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching user segments
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the user segments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching user segments
	*/
	public static List<UserSegment> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the user segments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of matching user segments
	*/
	public static List<UserSegment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the user segments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user segments
	*/
	public static List<UserSegment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user segments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user segments
	*/
	public static List<UserSegment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public static UserSegment findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<UserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static UserSegment fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public static UserSegment findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<UserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static UserSegment fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the user segments before and after the current user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param userSegmentId the primary key of the current user segment
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public static UserSegment[] findByUuid_C_PrevAndNext(long userSegmentId,
		java.lang.String uuid, long companyId,
		OrderByComparator<UserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(userSegmentId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the user segments where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of user segments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching user segments
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the user segments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching user segments
	*/
	public static List<UserSegment> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the user segments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of matching user segments
	*/
	public static List<UserSegment> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the user segments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user segments
	*/
	public static List<UserSegment> findByGroupId(long groupId, int start,
		int end, OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user segments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user segments
	*/
	public static List<UserSegment> findByGroupId(long groupId, int start,
		int end, OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user segment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public static UserSegment findByGroupId_First(long groupId,
		OrderByComparator<UserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first user segment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static UserSegment fetchByGroupId_First(long groupId,
		OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last user segment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public static UserSegment findByGroupId_Last(long groupId,
		OrderByComparator<UserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last user segment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static UserSegment fetchByGroupId_Last(long groupId,
		OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the user segments before and after the current user segment in the ordered set where groupId = &#63;.
	*
	* @param userSegmentId the primary key of the current user segment
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public static UserSegment[] findByGroupId_PrevAndNext(long userSegmentId,
		long groupId, OrderByComparator<UserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(userSegmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the user segments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching user segments that the user has permission to view
	*/
	public static List<UserSegment> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the user segments that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of matching user segments that the user has permission to view
	*/
	public static List<UserSegment> filterFindByGroupId(long groupId,
		int start, int end) {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the user segments that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user segments that the user has permission to view
	*/
	public static List<UserSegment> filterFindByGroupId(long groupId,
		int start, int end, OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the user segments before and after the current user segment in the ordered set of user segments that the user has permission to view where groupId = &#63;.
	*
	* @param userSegmentId the primary key of the current user segment
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public static UserSegment[] filterFindByGroupId_PrevAndNext(
		long userSegmentId, long groupId,
		OrderByComparator<UserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(userSegmentId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the user segments that the user has permission to view where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the matching user segments that the user has permission to view
	*/
	public static List<UserSegment> filterFindByGroupId(long[] groupIds) {
		return getPersistence().filterFindByGroupId(groupIds);
	}

	/**
	* Returns a range of all the user segments that the user has permission to view where groupId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupIds the group IDs
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of matching user segments that the user has permission to view
	*/
	public static List<UserSegment> filterFindByGroupId(long[] groupIds,
		int start, int end) {
		return getPersistence().filterFindByGroupId(groupIds, start, end);
	}

	/**
	* Returns an ordered range of all the user segments that the user has permission to view where groupId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupIds the group IDs
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user segments that the user has permission to view
	*/
	public static List<UserSegment> filterFindByGroupId(long[] groupIds,
		int start, int end, OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupIds, start, end, orderByComparator);
	}

	/**
	* Returns all the user segments where groupId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupIds the group IDs
	* @return the matching user segments
	*/
	public static List<UserSegment> findByGroupId(long[] groupIds) {
		return getPersistence().findByGroupId(groupIds);
	}

	/**
	* Returns a range of all the user segments where groupId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupIds the group IDs
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of matching user segments
	*/
	public static List<UserSegment> findByGroupId(long[] groupIds, int start,
		int end) {
		return getPersistence().findByGroupId(groupIds, start, end);
	}

	/**
	* Returns an ordered range of all the user segments where groupId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupIds the group IDs
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user segments
	*/
	public static List<UserSegment> findByGroupId(long[] groupIds, int start,
		int end, OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupIds, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user segments where groupId = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user segments
	*/
	public static List<UserSegment> findByGroupId(long[] groupIds, int start,
		int end, OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupIds, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Removes all the user segments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of user segments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching user segments
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of user segments where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the number of matching user segments
	*/
	public static int countByGroupId(long[] groupIds) {
		return getPersistence().countByGroupId(groupIds);
	}

	/**
	* Returns the number of user segments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching user segments that the user has permission to view
	*/
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of user segments that the user has permission to view where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the number of matching user segments that the user has permission to view
	*/
	public static int filterCountByGroupId(long[] groupIds) {
		return getPersistence().filterCountByGroupId(groupIds);
	}

	/**
	* Returns the user segment where assetCategoryId = &#63; or throws a {@link NoSuchUserSegmentException} if it could not be found.
	*
	* @param assetCategoryId the asset category ID
	* @return the matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public static UserSegment findByAssetCategoryId(long assetCategoryId)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence().findByAssetCategoryId(assetCategoryId);
	}

	/**
	* Returns the user segment where assetCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param assetCategoryId the asset category ID
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static UserSegment fetchByAssetCategoryId(long assetCategoryId) {
		return getPersistence().fetchByAssetCategoryId(assetCategoryId);
	}

	/**
	* Returns the user segment where assetCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param assetCategoryId the asset category ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public static UserSegment fetchByAssetCategoryId(long assetCategoryId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByAssetCategoryId(assetCategoryId, retrieveFromCache);
	}

	/**
	* Removes the user segment where assetCategoryId = &#63; from the database.
	*
	* @param assetCategoryId the asset category ID
	* @return the user segment that was removed
	*/
	public static UserSegment removeByAssetCategoryId(long assetCategoryId)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence().removeByAssetCategoryId(assetCategoryId);
	}

	/**
	* Returns the number of user segments where assetCategoryId = &#63;.
	*
	* @param assetCategoryId the asset category ID
	* @return the number of matching user segments
	*/
	public static int countByAssetCategoryId(long assetCategoryId) {
		return getPersistence().countByAssetCategoryId(assetCategoryId);
	}

	/**
	* Caches the user segment in the entity cache if it is enabled.
	*
	* @param userSegment the user segment
	*/
	public static void cacheResult(UserSegment userSegment) {
		getPersistence().cacheResult(userSegment);
	}

	/**
	* Caches the user segments in the entity cache if it is enabled.
	*
	* @param userSegments the user segments
	*/
	public static void cacheResult(List<UserSegment> userSegments) {
		getPersistence().cacheResult(userSegments);
	}

	/**
	* Creates a new user segment with the primary key. Does not add the user segment to the database.
	*
	* @param userSegmentId the primary key for the new user segment
	* @return the new user segment
	*/
	public static UserSegment create(long userSegmentId) {
		return getPersistence().create(userSegmentId);
	}

	/**
	* Removes the user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment that was removed
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public static UserSegment remove(long userSegmentId)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence().remove(userSegmentId);
	}

	public static UserSegment updateImpl(UserSegment userSegment) {
		return getPersistence().updateImpl(userSegment);
	}

	/**
	* Returns the user segment with the primary key or throws a {@link NoSuchUserSegmentException} if it could not be found.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public static UserSegment findByPrimaryKey(long userSegmentId)
		throws com.liferay.content.targeting.exception.NoSuchUserSegmentException {
		return getPersistence().findByPrimaryKey(userSegmentId);
	}

	/**
	* Returns the user segment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment, or <code>null</code> if a user segment with the primary key could not be found
	*/
	public static UserSegment fetchByPrimaryKey(long userSegmentId) {
		return getPersistence().fetchByPrimaryKey(userSegmentId);
	}

	public static java.util.Map<java.io.Serializable, UserSegment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user segments.
	*
	* @return the user segments
	*/
	public static List<UserSegment> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of user segments
	*/
	public static List<UserSegment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user segments
	*/
	public static List<UserSegment> findAll(int start, int end,
		OrderByComparator<UserSegment> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user segments
	*/
	public static List<UserSegment> findAll(int start, int end,
		OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user segments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user segments.
	*
	* @return the number of user segments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of campaigns associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return long[] of the primaryKeys of campaigns associated with the user segment
	*/
	public static long[] getCampaignPrimaryKeys(long pk) {
		return getPersistence().getCampaignPrimaryKeys(pk);
	}

	/**
	* Returns all the campaigns associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return the campaigns associated with the user segment
	*/
	public static List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long pk) {
		return getPersistence().getCampaigns(pk);
	}

	/**
	* Returns a range of all the campaigns associated with the user segment.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the user segment
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of campaigns associated with the user segment
	*/
	public static List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long pk, int start, int end) {
		return getPersistence().getCampaigns(pk, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns associated with the user segment.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the user segment
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaigns associated with the user segment
	*/
	public static List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long pk, int start, int end,
		OrderByComparator<com.liferay.content.targeting.model.Campaign> orderByComparator) {
		return getPersistence().getCampaigns(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of campaigns associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return the number of campaigns associated with the user segment
	*/
	public static int getCampaignsSize(long pk) {
		return getPersistence().getCampaignsSize(pk);
	}

	/**
	* Returns <code>true</code> if the campaign is associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @param campaignPK the primary key of the campaign
	* @return <code>true</code> if the campaign is associated with the user segment; <code>false</code> otherwise
	*/
	public static boolean containsCampaign(long pk, long campaignPK) {
		return getPersistence().containsCampaign(pk, campaignPK);
	}

	/**
	* Returns <code>true</code> if the user segment has any campaigns associated with it.
	*
	* @param pk the primary key of the user segment to check for associations with campaigns
	* @return <code>true</code> if the user segment has any campaigns associated with it; <code>false</code> otherwise
	*/
	public static boolean containsCampaigns(long pk) {
		return getPersistence().containsCampaigns(pk);
	}

	/**
	* Adds an association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaignPK the primary key of the campaign
	*/
	public static void addCampaign(long pk, long campaignPK) {
		getPersistence().addCampaign(pk, campaignPK);
	}

	/**
	* Adds an association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaign the campaign
	*/
	public static void addCampaign(long pk,
		com.liferay.content.targeting.model.Campaign campaign) {
		getPersistence().addCampaign(pk, campaign);
	}

	/**
	* Adds an association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaignPKs the primary keys of the campaigns
	*/
	public static void addCampaigns(long pk, long[] campaignPKs) {
		getPersistence().addCampaigns(pk, campaignPKs);
	}

	/**
	* Adds an association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaigns the campaigns
	*/
	public static void addCampaigns(long pk,
		List<com.liferay.content.targeting.model.Campaign> campaigns) {
		getPersistence().addCampaigns(pk, campaigns);
	}

	/**
	* Clears all associations between the user segment and its campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment to clear the associated campaigns from
	*/
	public static void clearCampaigns(long pk) {
		getPersistence().clearCampaigns(pk);
	}

	/**
	* Removes the association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaignPK the primary key of the campaign
	*/
	public static void removeCampaign(long pk, long campaignPK) {
		getPersistence().removeCampaign(pk, campaignPK);
	}

	/**
	* Removes the association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaign the campaign
	*/
	public static void removeCampaign(long pk,
		com.liferay.content.targeting.model.Campaign campaign) {
		getPersistence().removeCampaign(pk, campaign);
	}

	/**
	* Removes the association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaignPKs the primary keys of the campaigns
	*/
	public static void removeCampaigns(long pk, long[] campaignPKs) {
		getPersistence().removeCampaigns(pk, campaignPKs);
	}

	/**
	* Removes the association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaigns the campaigns
	*/
	public static void removeCampaigns(long pk,
		List<com.liferay.content.targeting.model.Campaign> campaigns) {
		getPersistence().removeCampaigns(pk, campaigns);
	}

	/**
	* Sets the campaigns associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaignPKs the primary keys of the campaigns to be associated with the user segment
	*/
	public static void setCampaigns(long pk, long[] campaignPKs) {
		getPersistence().setCampaigns(pk, campaignPKs);
	}

	/**
	* Sets the campaigns associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaigns the campaigns to be associated with the user segment
	*/
	public static void setCampaigns(long pk,
		List<com.liferay.content.targeting.model.Campaign> campaigns) {
		getPersistence().setCampaigns(pk, campaigns);
	}

	/**
	* Returns the primaryKeys of tactics associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return long[] of the primaryKeys of tactics associated with the user segment
	*/
	public static long[] getTacticPrimaryKeys(long pk) {
		return getPersistence().getTacticPrimaryKeys(pk);
	}

	/**
	* Returns all the tactics associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return the tactics associated with the user segment
	*/
	public static List<com.liferay.content.targeting.model.Tactic> getTactics(
		long pk) {
		return getPersistence().getTactics(pk);
	}

	/**
	* Returns a range of all the tactics associated with the user segment.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the user segment
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @return the range of tactics associated with the user segment
	*/
	public static List<com.liferay.content.targeting.model.Tactic> getTactics(
		long pk, int start, int end) {
		return getPersistence().getTactics(pk, start, end);
	}

	/**
	* Returns an ordered range of all the tactics associated with the user segment.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the user segment
	* @param start the lower bound of the range of user segments
	* @param end the upper bound of the range of user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tactics associated with the user segment
	*/
	public static List<com.liferay.content.targeting.model.Tactic> getTactics(
		long pk, int start, int end,
		OrderByComparator<com.liferay.content.targeting.model.Tactic> orderByComparator) {
		return getPersistence().getTactics(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of tactics associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return the number of tactics associated with the user segment
	*/
	public static int getTacticsSize(long pk) {
		return getPersistence().getTacticsSize(pk);
	}

	/**
	* Returns <code>true</code> if the tactic is associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @param tacticPK the primary key of the tactic
	* @return <code>true</code> if the tactic is associated with the user segment; <code>false</code> otherwise
	*/
	public static boolean containsTactic(long pk, long tacticPK) {
		return getPersistence().containsTactic(pk, tacticPK);
	}

	/**
	* Returns <code>true</code> if the user segment has any tactics associated with it.
	*
	* @param pk the primary key of the user segment to check for associations with tactics
	* @return <code>true</code> if the user segment has any tactics associated with it; <code>false</code> otherwise
	*/
	public static boolean containsTactics(long pk) {
		return getPersistence().containsTactics(pk);
	}

	/**
	* Adds an association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tacticPK the primary key of the tactic
	*/
	public static void addTactic(long pk, long tacticPK) {
		getPersistence().addTactic(pk, tacticPK);
	}

	/**
	* Adds an association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tactic the tactic
	*/
	public static void addTactic(long pk,
		com.liferay.content.targeting.model.Tactic tactic) {
		getPersistence().addTactic(pk, tactic);
	}

	/**
	* Adds an association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tacticPKs the primary keys of the tactics
	*/
	public static void addTactics(long pk, long[] tacticPKs) {
		getPersistence().addTactics(pk, tacticPKs);
	}

	/**
	* Adds an association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tactics the tactics
	*/
	public static void addTactics(long pk,
		List<com.liferay.content.targeting.model.Tactic> tactics) {
		getPersistence().addTactics(pk, tactics);
	}

	/**
	* Clears all associations between the user segment and its tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment to clear the associated tactics from
	*/
	public static void clearTactics(long pk) {
		getPersistence().clearTactics(pk);
	}

	/**
	* Removes the association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tacticPK the primary key of the tactic
	*/
	public static void removeTactic(long pk, long tacticPK) {
		getPersistence().removeTactic(pk, tacticPK);
	}

	/**
	* Removes the association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tactic the tactic
	*/
	public static void removeTactic(long pk,
		com.liferay.content.targeting.model.Tactic tactic) {
		getPersistence().removeTactic(pk, tactic);
	}

	/**
	* Removes the association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tacticPKs the primary keys of the tactics
	*/
	public static void removeTactics(long pk, long[] tacticPKs) {
		getPersistence().removeTactics(pk, tacticPKs);
	}

	/**
	* Removes the association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tactics the tactics
	*/
	public static void removeTactics(long pk,
		List<com.liferay.content.targeting.model.Tactic> tactics) {
		getPersistence().removeTactics(pk, tactics);
	}

	/**
	* Sets the tactics associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tacticPKs the primary keys of the tactics to be associated with the user segment
	*/
	public static void setTactics(long pk, long[] tacticPKs) {
		getPersistence().setTactics(pk, tacticPKs);
	}

	/**
	* Sets the tactics associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tactics the tactics to be associated with the user segment
	*/
	public static void setTactics(long pk,
		List<com.liferay.content.targeting.model.Tactic> tactics) {
		getPersistence().setTactics(pk, tactics);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UserSegmentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserSegmentPersistence, UserSegmentPersistence> _serviceTracker =
		ServiceTrackerFactory.open(UserSegmentPersistence.class);
}