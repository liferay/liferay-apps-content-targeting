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

package com.liferay.anonymoususers.service.persistence;

import com.liferay.anonymoususers.model.AnonymousUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the anonymous user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserPersistenceImpl
 * @see AnonymousUserUtil
 * @generated
 */
public interface AnonymousUserPersistence extends BasePersistence<AnonymousUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnonymousUserUtil} to access the anonymous user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the anonymous users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anonymous users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anonymous users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous users before and after the current anonymous user in the ordered set where uuid = &#63;.
	*
	* @param AnonymousUserId the primary key of the current anonymous user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser[] findByUuid_PrevAndNext(
		long AnonymousUserId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anonymous users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anonymous users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous users before and after the current anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param AnonymousUserId the primary key of the current anonymous user
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser[] findByUuid_C_PrevAndNext(
		long AnonymousUserId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anonymous users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anonymous users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anonymous users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anonymous users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous users before and after the current anonymous user in the ordered set where userId = &#63;.
	*
	* @param AnonymousUserId the primary key of the current anonymous user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser[] findByUserId_PrevAndNext(
		long AnonymousUserId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anonymous users where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anonymous users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the anonymous user in the entity cache if it is enabled.
	*
	* @param anonymousUser the anonymous user
	*/
	public void cacheResult(
		com.liferay.anonymoususers.model.AnonymousUser anonymousUser);

	/**
	* Caches the anonymous users in the entity cache if it is enabled.
	*
	* @param anonymousUsers the anonymous users
	*/
	public void cacheResult(
		java.util.List<com.liferay.anonymoususers.model.AnonymousUser> anonymousUsers);

	/**
	* Creates a new anonymous user with the primary key. Does not add the anonymous user to the database.
	*
	* @param AnonymousUserId the primary key for the new anonymous user
	* @return the new anonymous user
	*/
	public com.liferay.anonymoususers.model.AnonymousUser create(
		long AnonymousUserId);

	/**
	* Removes the anonymous user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param AnonymousUserId the primary key of the anonymous user
	* @return the anonymous user that was removed
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser remove(
		long AnonymousUserId)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.anonymoususers.model.AnonymousUser updateImpl(
		com.liferay.anonymoususers.model.AnonymousUser anonymousUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous user with the primary key or throws a {@link com.liferay.anonymoususers.NoSuchAnonymousUserException} if it could not be found.
	*
	* @param AnonymousUserId the primary key of the anonymous user
	* @return the anonymous user
	* @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser findByPrimaryKey(
		long AnonymousUserId)
		throws com.liferay.anonymoususers.NoSuchAnonymousUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param AnonymousUserId the primary key of the anonymous user
	* @return the anonymous user, or <code>null</code> if a anonymous user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.anonymoususers.model.AnonymousUser fetchByPrimaryKey(
		long AnonymousUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anonymous users.
	*
	* @return the anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anonymous users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anonymous users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.anonymoususers.model.AnonymousUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anonymous users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anonymous users.
	*
	* @return the number of anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}