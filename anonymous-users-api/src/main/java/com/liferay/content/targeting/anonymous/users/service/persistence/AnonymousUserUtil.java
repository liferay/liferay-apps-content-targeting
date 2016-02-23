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

package com.liferay.content.targeting.anonymous.users.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the anonymous user service. This utility wraps {@link com.liferay.content.targeting.anonymous.users.service.persistence.impl.AnonymousUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserPersistence
 * @see com.liferay.content.targeting.anonymous.users.service.persistence.impl.AnonymousUserPersistenceImpl
 * @generated
 */
@ProviderType
public class AnonymousUserUtil {
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
	public static void clearCache(AnonymousUser anonymousUser) {
		getPersistence().clearCache(anonymousUser);
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
	public static List<AnonymousUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnonymousUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnonymousUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnonymousUser update(AnonymousUser anonymousUser) {
		return getPersistence().update(anonymousUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnonymousUser update(AnonymousUser anonymousUser,
		ServiceContext serviceContext) {
		return getPersistence().update(anonymousUser, serviceContext);
	}

	/**
	* Returns all the anonymous users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching anonymous users
	*/
	public static List<AnonymousUser> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the anonymous users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of matching anonymous users
	*/
	public static List<AnonymousUser> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the anonymous users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous users
	*/
	public static List<AnonymousUser> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the anonymous users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching anonymous users
	*/
	public static List<AnonymousUser> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<AnonymousUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public static AnonymousUser findByUuid_First(java.lang.String uuid,
		OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public static AnonymousUser fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public static AnonymousUser findByUuid_Last(java.lang.String uuid,
		OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public static AnonymousUser fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the anonymous users before and after the current anonymous user in the ordered set where uuid = &#63;.
	*
	* @param anonymousUserId the primary key of the current anonymous user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user
	* @throws NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	*/
	public static AnonymousUser[] findByUuid_PrevAndNext(long anonymousUserId,
		java.lang.String uuid,
		OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence()
				   .findByUuid_PrevAndNext(anonymousUserId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the anonymous users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of anonymous users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching anonymous users
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching anonymous users
	*/
	public static List<AnonymousUser> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of matching anonymous users
	*/
	public static List<AnonymousUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous users
	*/
	public static List<AnonymousUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching anonymous users
	*/
	public static List<AnonymousUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<AnonymousUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public static AnonymousUser findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public static AnonymousUser fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public static AnonymousUser findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public static AnonymousUser fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the anonymous users before and after the current anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param anonymousUserId the primary key of the current anonymous user
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user
	* @throws NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	*/
	public static AnonymousUser[] findByUuid_C_PrevAndNext(
		long anonymousUserId, java.lang.String uuid, long companyId,
		OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(anonymousUserId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the anonymous users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching anonymous users
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the anonymous users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching anonymous users
	*/
	public static List<AnonymousUser> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the anonymous users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of matching anonymous users
	*/
	public static List<AnonymousUser> findByUserId(long userId, int start,
		int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the anonymous users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous users
	*/
	public static List<AnonymousUser> findByUserId(long userId, int start,
		int end, OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the anonymous users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching anonymous users
	*/
	public static List<AnonymousUser> findByUserId(long userId, int start,
		int end, OrderByComparator<AnonymousUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public static AnonymousUser findByUserId_First(long userId,
		OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public static AnonymousUser fetchByUserId_First(long userId,
		OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public static AnonymousUser findByUserId_Last(long userId,
		OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public static AnonymousUser fetchByUserId_Last(long userId,
		OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the anonymous users before and after the current anonymous user in the ordered set where userId = &#63;.
	*
	* @param anonymousUserId the primary key of the current anonymous user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user
	* @throws NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	*/
	public static AnonymousUser[] findByUserId_PrevAndNext(
		long anonymousUserId, long userId,
		OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence()
				   .findByUserId_PrevAndNext(anonymousUserId, userId,
			orderByComparator);
	}

	/**
	* Removes all the anonymous users where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of anonymous users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching anonymous users
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the anonymous users where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the matching anonymous users
	*/
	public static List<AnonymousUser> findByC_LtD(long companyId,
		Date createDate) {
		return getPersistence().findByC_LtD(companyId, createDate);
	}

	/**
	* Returns a range of all the anonymous users where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of matching anonymous users
	*/
	public static List<AnonymousUser> findByC_LtD(long companyId,
		Date createDate, int start, int end) {
		return getPersistence().findByC_LtD(companyId, createDate, start, end);
	}

	/**
	* Returns an ordered range of all the anonymous users where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous users
	*/
	public static List<AnonymousUser> findByC_LtD(long companyId,
		Date createDate, int start, int end,
		OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence()
				   .findByC_LtD(companyId, createDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the anonymous users where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching anonymous users
	*/
	public static List<AnonymousUser> findByC_LtD(long companyId,
		Date createDate, int start, int end,
		OrderByComparator<AnonymousUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_LtD(companyId, createDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first anonymous user in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public static AnonymousUser findByC_LtD_First(long companyId,
		Date createDate, OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence()
				   .findByC_LtD_First(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the first anonymous user in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public static AnonymousUser fetchByC_LtD_First(long companyId,
		Date createDate, OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence()
				   .fetchByC_LtD_First(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the last anonymous user in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public static AnonymousUser findByC_LtD_Last(long companyId,
		Date createDate, OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence()
				   .findByC_LtD_Last(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the last anonymous user in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public static AnonymousUser fetchByC_LtD_Last(long companyId,
		Date createDate, OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence()
				   .fetchByC_LtD_Last(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the anonymous users before and after the current anonymous user in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param anonymousUserId the primary key of the current anonymous user
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user
	* @throws NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	*/
	public static AnonymousUser[] findByC_LtD_PrevAndNext(
		long anonymousUserId, long companyId, Date createDate,
		OrderByComparator<AnonymousUser> orderByComparator)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence()
				   .findByC_LtD_PrevAndNext(anonymousUserId, companyId,
			createDate, orderByComparator);
	}

	/**
	* Removes all the anonymous users where companyId = &#63; and createDate &lt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param createDate the create date
	*/
	public static void removeByC_LtD(long companyId, Date createDate) {
		getPersistence().removeByC_LtD(companyId, createDate);
	}

	/**
	* Returns the number of anonymous users where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the number of matching anonymous users
	*/
	public static int countByC_LtD(long companyId, Date createDate) {
		return getPersistence().countByC_LtD(companyId, createDate);
	}

	/**
	* Caches the anonymous user in the entity cache if it is enabled.
	*
	* @param anonymousUser the anonymous user
	*/
	public static void cacheResult(AnonymousUser anonymousUser) {
		getPersistence().cacheResult(anonymousUser);
	}

	/**
	* Caches the anonymous users in the entity cache if it is enabled.
	*
	* @param anonymousUsers the anonymous users
	*/
	public static void cacheResult(List<AnonymousUser> anonymousUsers) {
		getPersistence().cacheResult(anonymousUsers);
	}

	/**
	* Creates a new anonymous user with the primary key. Does not add the anonymous user to the database.
	*
	* @param anonymousUserId the primary key for the new anonymous user
	* @return the new anonymous user
	*/
	public static AnonymousUser create(long anonymousUserId) {
		return getPersistence().create(anonymousUserId);
	}

	/**
	* Removes the anonymous user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserId the primary key of the anonymous user
	* @return the anonymous user that was removed
	* @throws NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	*/
	public static AnonymousUser remove(long anonymousUserId)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence().remove(anonymousUserId);
	}

	public static AnonymousUser updateImpl(AnonymousUser anonymousUser) {
		return getPersistence().updateImpl(anonymousUser);
	}

	/**
	* Returns the anonymous user with the primary key or throws a {@link NoSuchAnonymousUserException} if it could not be found.
	*
	* @param anonymousUserId the primary key of the anonymous user
	* @return the anonymous user
	* @throws NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	*/
	public static AnonymousUser findByPrimaryKey(long anonymousUserId)
		throws com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException {
		return getPersistence().findByPrimaryKey(anonymousUserId);
	}

	/**
	* Returns the anonymous user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param anonymousUserId the primary key of the anonymous user
	* @return the anonymous user, or <code>null</code> if a anonymous user with the primary key could not be found
	*/
	public static AnonymousUser fetchByPrimaryKey(long anonymousUserId) {
		return getPersistence().fetchByPrimaryKey(anonymousUserId);
	}

	public static java.util.Map<java.io.Serializable, AnonymousUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the anonymous users.
	*
	* @return the anonymous users
	*/
	public static List<AnonymousUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the anonymous users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of anonymous users
	*/
	public static List<AnonymousUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the anonymous users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of anonymous users
	*/
	public static List<AnonymousUser> findAll(int start, int end,
		OrderByComparator<AnonymousUser> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the anonymous users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of anonymous users
	*/
	public static List<AnonymousUser> findAll(int start, int end,
		OrderByComparator<AnonymousUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the anonymous users from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of anonymous users.
	*
	* @return the number of anonymous users
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AnonymousUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnonymousUserPersistence, AnonymousUserPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AnonymousUserPersistence.class);
}