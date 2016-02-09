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

import com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the anonymous user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.anonymous.users.service.persistence.impl.AnonymousUserPersistenceImpl
 * @see AnonymousUserUtil
 * @generated
 */
@ProviderType
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
	*/
	public java.util.List<AnonymousUser> findByUuid(java.lang.String uuid);

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
	public java.util.List<AnonymousUser> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<AnonymousUser> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

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
	public java.util.List<AnonymousUser> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public AnonymousUser findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public AnonymousUser fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public AnonymousUser findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public AnonymousUser fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

	/**
	* Returns the anonymous users before and after the current anonymous user in the ordered set where uuid = &#63;.
	*
	* @param anonymousUserId the primary key of the current anonymous user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user
	* @throws NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	*/
	public AnonymousUser[] findByUuid_PrevAndNext(long anonymousUserId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Removes all the anonymous users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of anonymous users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching anonymous users
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching anonymous users
	*/
	public java.util.List<AnonymousUser> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<AnonymousUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<AnonymousUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

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
	public java.util.List<AnonymousUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public AnonymousUser findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Returns the first anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public AnonymousUser fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public AnonymousUser findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Returns the last anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public AnonymousUser fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

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
	public AnonymousUser[] findByUuid_C_PrevAndNext(long anonymousUserId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Removes all the anonymous users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of anonymous users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching anonymous users
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the anonymous users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching anonymous users
	*/
	public java.util.List<AnonymousUser> findByUserId(long userId);

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
	public java.util.List<AnonymousUser> findByUserId(long userId, int start,
		int end);

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
	public java.util.List<AnonymousUser> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

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
	public java.util.List<AnonymousUser> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public AnonymousUser findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Returns the first anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public AnonymousUser fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

	/**
	* Returns the last anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public AnonymousUser findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Returns the last anonymous user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public AnonymousUser fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

	/**
	* Returns the anonymous users before and after the current anonymous user in the ordered set where userId = &#63;.
	*
	* @param anonymousUserId the primary key of the current anonymous user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user
	* @throws NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	*/
	public AnonymousUser[] findByUserId_PrevAndNext(long anonymousUserId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Removes all the anonymous users where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of anonymous users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching anonymous users
	*/
	public int countByUserId(long userId);

	/**
	* Returns all the anonymous users where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the matching anonymous users
	*/
	public java.util.List<AnonymousUser> findByC_LtD(long companyId,
		Date createDate);

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
	public java.util.List<AnonymousUser> findByC_LtD(long companyId,
		Date createDate, int start, int end);

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
	public java.util.List<AnonymousUser> findByC_LtD(long companyId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

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
	public java.util.List<AnonymousUser> findByC_LtD(long companyId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first anonymous user in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public AnonymousUser findByC_LtD_First(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Returns the first anonymous user in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public AnonymousUser fetchByC_LtD_First(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

	/**
	* Returns the last anonymous user in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user
	* @throws NoSuchAnonymousUserException if a matching anonymous user could not be found
	*/
	public AnonymousUser findByC_LtD_Last(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Returns the last anonymous user in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	public AnonymousUser fetchByC_LtD_Last(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

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
	public AnonymousUser[] findByC_LtD_PrevAndNext(long anonymousUserId,
		long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator)
		throws NoSuchAnonymousUserException;

	/**
	* Removes all the anonymous users where companyId = &#63; and createDate &lt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param createDate the create date
	*/
	public void removeByC_LtD(long companyId, Date createDate);

	/**
	* Returns the number of anonymous users where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the number of matching anonymous users
	*/
	public int countByC_LtD(long companyId, Date createDate);

	/**
	* Caches the anonymous user in the entity cache if it is enabled.
	*
	* @param anonymousUser the anonymous user
	*/
	public void cacheResult(AnonymousUser anonymousUser);

	/**
	* Caches the anonymous users in the entity cache if it is enabled.
	*
	* @param anonymousUsers the anonymous users
	*/
	public void cacheResult(java.util.List<AnonymousUser> anonymousUsers);

	/**
	* Creates a new anonymous user with the primary key. Does not add the anonymous user to the database.
	*
	* @param anonymousUserId the primary key for the new anonymous user
	* @return the new anonymous user
	*/
	public AnonymousUser create(long anonymousUserId);

	/**
	* Removes the anonymous user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserId the primary key of the anonymous user
	* @return the anonymous user that was removed
	* @throws NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	*/
	public AnonymousUser remove(long anonymousUserId)
		throws NoSuchAnonymousUserException;

	public AnonymousUser updateImpl(AnonymousUser anonymousUser);

	/**
	* Returns the anonymous user with the primary key or throws a {@link NoSuchAnonymousUserException} if it could not be found.
	*
	* @param anonymousUserId the primary key of the anonymous user
	* @return the anonymous user
	* @throws NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	*/
	public AnonymousUser findByPrimaryKey(long anonymousUserId)
		throws NoSuchAnonymousUserException;

	/**
	* Returns the anonymous user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param anonymousUserId the primary key of the anonymous user
	* @return the anonymous user, or <code>null</code> if a anonymous user with the primary key could not be found
	*/
	public AnonymousUser fetchByPrimaryKey(long anonymousUserId);

	@Override
	public java.util.Map<java.io.Serializable, AnonymousUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the anonymous users.
	*
	* @return the anonymous users
	*/
	public java.util.List<AnonymousUser> findAll();

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
	public java.util.List<AnonymousUser> findAll(int start, int end);

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
	public java.util.List<AnonymousUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator);

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
	public java.util.List<AnonymousUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the anonymous users from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of anonymous users.
	*
	* @return the number of anonymous users
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}