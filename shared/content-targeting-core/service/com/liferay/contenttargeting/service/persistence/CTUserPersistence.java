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

package com.liferay.contenttargeting.service.persistence;

import com.liferay.contenttargeting.model.CTUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the c t user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTUserPersistenceImpl
 * @see CTUserUtil
 * @generated
 */
public interface CTUserPersistence extends BasePersistence<CTUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CTUserUtil} to access the c t user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the c t users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c t users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of c t users
	* @param end the upper bound of the range of c t users (not inclusive)
	* @return the range of matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c t users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of c t users
	* @param end the upper bound of the range of c t users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c t user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c t user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t user, or <code>null</code> if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c t user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c t user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t user, or <code>null</code> if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t users before and after the current c t user in the ordered set where uuid = &#63;.
	*
	* @param CTUserId the primary key of the current c t user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a c t user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser[] findByUuid_PrevAndNext(
		long CTUserId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c t users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c t users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t user where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.contenttargeting.NoSuchUserException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching c t user, or <code>null</code> if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching c t user, or <code>null</code> if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the c t user where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the c t user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c t users where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the c t users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c t users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of c t users
	* @param end the upper bound of the range of c t users (not inclusive)
	* @return the range of matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c t users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of c t users
	* @param end the upper bound of the range of c t users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c t user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c t user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t user, or <code>null</code> if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c t user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c t user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t user, or <code>null</code> if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t users before and after the current c t user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param CTUserId the primary key of the current c t user
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a c t user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser[] findByUuid_C_PrevAndNext(
		long CTUserId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c t users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c t users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the c t users where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c t users where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c t users
	* @param end the upper bound of the range of c t users (not inclusive)
	* @return the range of matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c t users where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of c t users
	* @param end the upper bound of the range of c t users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c t user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c t user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t user, or <code>null</code> if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c t user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c t user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t user, or <code>null</code> if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t users before and after the current c t user in the ordered set where groupId = &#63;.
	*
	* @param CTUserId the primary key of the current c t user
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a c t user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser[] findByGroupId_PrevAndNext(
		long CTUserId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c t users where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c t users where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching c t users
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the c t user in the entity cache if it is enabled.
	*
	* @param ctUser the c t user
	*/
	public void cacheResult(com.liferay.contenttargeting.model.CTUser ctUser);

	/**
	* Caches the c t users in the entity cache if it is enabled.
	*
	* @param ctUsers the c t users
	*/
	public void cacheResult(
		java.util.List<com.liferay.contenttargeting.model.CTUser> ctUsers);

	/**
	* Creates a new c t user with the primary key. Does not add the c t user to the database.
	*
	* @param CTUserId the primary key for the new c t user
	* @return the new c t user
	*/
	public com.liferay.contenttargeting.model.CTUser create(long CTUserId);

	/**
	* Removes the c t user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTUserId the primary key of the c t user
	* @return the c t user that was removed
	* @throws com.liferay.contenttargeting.NoSuchUserException if a c t user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser remove(long CTUserId)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.contenttargeting.model.CTUser updateImpl(
		com.liferay.contenttargeting.model.CTUser ctUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t user with the primary key or throws a {@link com.liferay.contenttargeting.NoSuchUserException} if it could not be found.
	*
	* @param CTUserId the primary key of the c t user
	* @return the c t user
	* @throws com.liferay.contenttargeting.NoSuchUserException if a c t user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser findByPrimaryKey(
		long CTUserId)
		throws com.liferay.contenttargeting.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CTUserId the primary key of the c t user
	* @return the c t user, or <code>null</code> if a c t user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.CTUser fetchByPrimaryKey(
		long CTUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the c t users.
	*
	* @return the c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c t users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t users
	* @param end the upper bound of the range of c t users (not inclusive)
	* @return the range of c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c t users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t users
	* @param end the upper bound of the range of c t users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of c t users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.CTUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c t users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c t users.
	*
	* @return the number of c t users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}