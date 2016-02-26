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

import com.liferay.content.targeting.exception.NoSuchUserSegmentException;
import com.liferay.content.targeting.model.UserSegment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.persistence.impl.UserSegmentPersistenceImpl
 * @see UserSegmentUtil
 * @generated
 */
@ProviderType
public interface UserSegmentPersistence extends BasePersistence<UserSegment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserSegmentUtil} to access the user segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user segments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user segments
	*/
	public java.util.List<UserSegment> findByUuid(java.lang.String uuid);

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
	public java.util.List<UserSegment> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<UserSegment> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

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
	public java.util.List<UserSegment> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user segment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public UserSegment findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException;

	/**
	* Returns the first user segment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public UserSegment fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

	/**
	* Returns the last user segment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public UserSegment findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException;

	/**
	* Returns the last user segment in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public UserSegment fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

	/**
	* Returns the user segments before and after the current user segment in the ordered set where uuid = &#63;.
	*
	* @param userSegmentId the primary key of the current user segment
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public UserSegment[] findByUuid_PrevAndNext(long userSegmentId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException;

	/**
	* Removes all the user segments where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of user segments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user segments
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the user segment where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchUserSegmentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public UserSegment findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchUserSegmentException;

	/**
	* Returns the user segment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public UserSegment fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the user segment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public UserSegment fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the user segment where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the user segment that was removed
	*/
	public UserSegment removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchUserSegmentException;

	/**
	* Returns the number of user segments where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching user segments
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the user segments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching user segments
	*/
	public java.util.List<UserSegment> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<UserSegment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<UserSegment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

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
	public java.util.List<UserSegment> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public UserSegment findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException;

	/**
	* Returns the first user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public UserSegment fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

	/**
	* Returns the last user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public UserSegment findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException;

	/**
	* Returns the last user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public UserSegment fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

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
	public UserSegment[] findByUuid_C_PrevAndNext(long userSegmentId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException;

	/**
	* Removes all the user segments where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of user segments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching user segments
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the user segments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching user segments
	*/
	public java.util.List<UserSegment> findByGroupId(long groupId);

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
	public java.util.List<UserSegment> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<UserSegment> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

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
	public java.util.List<UserSegment> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user segment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public UserSegment findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException;

	/**
	* Returns the first user segment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public UserSegment fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

	/**
	* Returns the last user segment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public UserSegment findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException;

	/**
	* Returns the last user segment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public UserSegment fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

	/**
	* Returns the user segments before and after the current user segment in the ordered set where groupId = &#63;.
	*
	* @param userSegmentId the primary key of the current user segment
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public UserSegment[] findByGroupId_PrevAndNext(long userSegmentId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException;

	/**
	* Returns all the user segments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching user segments that the user has permission to view
	*/
	public java.util.List<UserSegment> filterFindByGroupId(long groupId);

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
	public java.util.List<UserSegment> filterFindByGroupId(long groupId,
		int start, int end);

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
	public java.util.List<UserSegment> filterFindByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

	/**
	* Returns the user segments before and after the current user segment in the ordered set of user segments that the user has permission to view where groupId = &#63;.
	*
	* @param userSegmentId the primary key of the current user segment
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user segment
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public UserSegment[] filterFindByGroupId_PrevAndNext(long userSegmentId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException;

	/**
	* Returns all the user segments that the user has permission to view where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the matching user segments that the user has permission to view
	*/
	public java.util.List<UserSegment> filterFindByGroupId(long[] groupIds);

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
	public java.util.List<UserSegment> filterFindByGroupId(long[] groupIds,
		int start, int end);

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
	public java.util.List<UserSegment> filterFindByGroupId(long[] groupIds,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

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
	public java.util.List<UserSegment> findByGroupId(long[] groupIds);

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
	public java.util.List<UserSegment> findByGroupId(long[] groupIds,
		int start, int end);

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
	public java.util.List<UserSegment> findByGroupId(long[] groupIds,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

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
	public java.util.List<UserSegment> findByGroupId(long[] groupIds,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user segments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of user segments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching user segments
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the number of user segments where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the number of matching user segments
	*/
	public int countByGroupId(long[] groupIds);

	/**
	* Returns the number of user segments that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching user segments that the user has permission to view
	*/
	public int filterCountByGroupId(long groupId);

	/**
	* Returns the number of user segments that the user has permission to view where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the number of matching user segments that the user has permission to view
	*/
	public int filterCountByGroupId(long[] groupIds);

	/**
	* Returns the user segment where assetCategoryId = &#63; or throws a {@link NoSuchUserSegmentException} if it could not be found.
	*
	* @param assetCategoryId the asset category ID
	* @return the matching user segment
	* @throws NoSuchUserSegmentException if a matching user segment could not be found
	*/
	public UserSegment findByAssetCategoryId(long assetCategoryId)
		throws NoSuchUserSegmentException;

	/**
	* Returns the user segment where assetCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param assetCategoryId the asset category ID
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public UserSegment fetchByAssetCategoryId(long assetCategoryId);

	/**
	* Returns the user segment where assetCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param assetCategoryId the asset category ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	*/
	public UserSegment fetchByAssetCategoryId(long assetCategoryId,
		boolean retrieveFromCache);

	/**
	* Removes the user segment where assetCategoryId = &#63; from the database.
	*
	* @param assetCategoryId the asset category ID
	* @return the user segment that was removed
	*/
	public UserSegment removeByAssetCategoryId(long assetCategoryId)
		throws NoSuchUserSegmentException;

	/**
	* Returns the number of user segments where assetCategoryId = &#63;.
	*
	* @param assetCategoryId the asset category ID
	* @return the number of matching user segments
	*/
	public int countByAssetCategoryId(long assetCategoryId);

	/**
	* Caches the user segment in the entity cache if it is enabled.
	*
	* @param userSegment the user segment
	*/
	public void cacheResult(UserSegment userSegment);

	/**
	* Caches the user segments in the entity cache if it is enabled.
	*
	* @param userSegments the user segments
	*/
	public void cacheResult(java.util.List<UserSegment> userSegments);

	/**
	* Creates a new user segment with the primary key. Does not add the user segment to the database.
	*
	* @param userSegmentId the primary key for the new user segment
	* @return the new user segment
	*/
	public UserSegment create(long userSegmentId);

	/**
	* Removes the user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment that was removed
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public UserSegment remove(long userSegmentId)
		throws NoSuchUserSegmentException;

	public UserSegment updateImpl(UserSegment userSegment);

	/**
	* Returns the user segment with the primary key or throws a {@link NoSuchUserSegmentException} if it could not be found.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment
	* @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	*/
	public UserSegment findByPrimaryKey(long userSegmentId)
		throws NoSuchUserSegmentException;

	/**
	* Returns the user segment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userSegmentId the primary key of the user segment
	* @return the user segment, or <code>null</code> if a user segment with the primary key could not be found
	*/
	public UserSegment fetchByPrimaryKey(long userSegmentId);

	@Override
	public java.util.Map<java.io.Serializable, UserSegment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user segments.
	*
	* @return the user segments
	*/
	public java.util.List<UserSegment> findAll();

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
	public java.util.List<UserSegment> findAll(int start, int end);

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
	public java.util.List<UserSegment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator);

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
	public java.util.List<UserSegment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user segments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user segments.
	*
	* @return the number of user segments
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of campaigns associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return long[] of the primaryKeys of campaigns associated with the user segment
	*/
	public long[] getCampaignPrimaryKeys(long pk);

	/**
	* Returns all the campaigns associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return the campaigns associated with the user segment
	*/
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long pk);

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
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long pk, int start, int end);

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
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.Campaign> orderByComparator);

	/**
	* Returns the number of campaigns associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return the number of campaigns associated with the user segment
	*/
	public int getCampaignsSize(long pk);

	/**
	* Returns <code>true</code> if the campaign is associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @param campaignPK the primary key of the campaign
	* @return <code>true</code> if the campaign is associated with the user segment; <code>false</code> otherwise
	*/
	public boolean containsCampaign(long pk, long campaignPK);

	/**
	* Returns <code>true</code> if the user segment has any campaigns associated with it.
	*
	* @param pk the primary key of the user segment to check for associations with campaigns
	* @return <code>true</code> if the user segment has any campaigns associated with it; <code>false</code> otherwise
	*/
	public boolean containsCampaigns(long pk);

	/**
	* Adds an association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaignPK the primary key of the campaign
	*/
	public void addCampaign(long pk, long campaignPK);

	/**
	* Adds an association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaign the campaign
	*/
	public void addCampaign(long pk,
		com.liferay.content.targeting.model.Campaign campaign);

	/**
	* Adds an association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaignPKs the primary keys of the campaigns
	*/
	public void addCampaigns(long pk, long[] campaignPKs);

	/**
	* Adds an association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaigns the campaigns
	*/
	public void addCampaigns(long pk,
		java.util.List<com.liferay.content.targeting.model.Campaign> campaigns);

	/**
	* Clears all associations between the user segment and its campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment to clear the associated campaigns from
	*/
	public void clearCampaigns(long pk);

	/**
	* Removes the association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaignPK the primary key of the campaign
	*/
	public void removeCampaign(long pk, long campaignPK);

	/**
	* Removes the association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaign the campaign
	*/
	public void removeCampaign(long pk,
		com.liferay.content.targeting.model.Campaign campaign);

	/**
	* Removes the association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaignPKs the primary keys of the campaigns
	*/
	public void removeCampaigns(long pk, long[] campaignPKs);

	/**
	* Removes the association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaigns the campaigns
	*/
	public void removeCampaigns(long pk,
		java.util.List<com.liferay.content.targeting.model.Campaign> campaigns);

	/**
	* Sets the campaigns associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaignPKs the primary keys of the campaigns to be associated with the user segment
	*/
	public void setCampaigns(long pk, long[] campaignPKs);

	/**
	* Sets the campaigns associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param campaigns the campaigns to be associated with the user segment
	*/
	public void setCampaigns(long pk,
		java.util.List<com.liferay.content.targeting.model.Campaign> campaigns);

	/**
	* Returns the primaryKeys of tactics associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return long[] of the primaryKeys of tactics associated with the user segment
	*/
	public long[] getTacticPrimaryKeys(long pk);

	/**
	* Returns all the tactics associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return the tactics associated with the user segment
	*/
	public java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		long pk);

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
	public java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		long pk, int start, int end);

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
	public java.util.List<com.liferay.content.targeting.model.Tactic> getTactics(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.Tactic> orderByComparator);

	/**
	* Returns the number of tactics associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @return the number of tactics associated with the user segment
	*/
	public int getTacticsSize(long pk);

	/**
	* Returns <code>true</code> if the tactic is associated with the user segment.
	*
	* @param pk the primary key of the user segment
	* @param tacticPK the primary key of the tactic
	* @return <code>true</code> if the tactic is associated with the user segment; <code>false</code> otherwise
	*/
	public boolean containsTactic(long pk, long tacticPK);

	/**
	* Returns <code>true</code> if the user segment has any tactics associated with it.
	*
	* @param pk the primary key of the user segment to check for associations with tactics
	* @return <code>true</code> if the user segment has any tactics associated with it; <code>false</code> otherwise
	*/
	public boolean containsTactics(long pk);

	/**
	* Adds an association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tacticPK the primary key of the tactic
	*/
	public void addTactic(long pk, long tacticPK);

	/**
	* Adds an association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tactic the tactic
	*/
	public void addTactic(long pk,
		com.liferay.content.targeting.model.Tactic tactic);

	/**
	* Adds an association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tacticPKs the primary keys of the tactics
	*/
	public void addTactics(long pk, long[] tacticPKs);

	/**
	* Adds an association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tactics the tactics
	*/
	public void addTactics(long pk,
		java.util.List<com.liferay.content.targeting.model.Tactic> tactics);

	/**
	* Clears all associations between the user segment and its tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment to clear the associated tactics from
	*/
	public void clearTactics(long pk);

	/**
	* Removes the association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tacticPK the primary key of the tactic
	*/
	public void removeTactic(long pk, long tacticPK);

	/**
	* Removes the association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tactic the tactic
	*/
	public void removeTactic(long pk,
		com.liferay.content.targeting.model.Tactic tactic);

	/**
	* Removes the association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tacticPKs the primary keys of the tactics
	*/
	public void removeTactics(long pk, long[] tacticPKs);

	/**
	* Removes the association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tactics the tactics
	*/
	public void removeTactics(long pk,
		java.util.List<com.liferay.content.targeting.model.Tactic> tactics);

	/**
	* Sets the tactics associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tacticPKs the primary keys of the tactics to be associated with the user segment
	*/
	public void setTactics(long pk, long[] tacticPKs);

	/**
	* Sets the tactics associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the user segment
	* @param tactics the tactics to be associated with the user segment
	*/
	public void setTactics(long pk,
		java.util.List<com.liferay.content.targeting.model.Tactic> tactics);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}