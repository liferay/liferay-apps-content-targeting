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

import com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException;
import com.liferay.content.targeting.model.AnonymousUserUserSegment;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the anonymous user user segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.persistence.impl.AnonymousUserUserSegmentPersistenceImpl
 * @see AnonymousUserUserSegmentUtil
 * @generated
 */
@ProviderType
public interface AnonymousUserUserSegmentPersistence extends BasePersistence<AnonymousUserUserSegment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnonymousUserUserSegmentUtil} to access the anonymous user user segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId);

	/**
	* Returns a range of all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId, int start, int end);

	/**
	* Returns an ordered range of all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns an ordered range of all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment findByA_U_First(long anonymousUserId,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment fetchByA_U_First(long anonymousUserId,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment findByA_U_Last(long anonymousUserId,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment fetchByA_U_Last(long anonymousUserId,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns the anonymous user user segments before and after the current anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserUserSegmentId the primary key of the current anonymous user user segment
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	*/
	public AnonymousUserUserSegment[] findByA_U_PrevAndNext(
		long anonymousUserUserSegmentId, long anonymousUserId,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Removes all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	*/
	public void removeByA_U(long anonymousUserId, long userSegmentId);

	/**
	* Returns the number of anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the number of matching anonymous user user segments
	*/
	public int countByA_U(long anonymousUserId, long userSegmentId);

	/**
	* Returns all the anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @return the matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active);

	/**
	* Returns a range of all the anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active, int start, int end);

	/**
	* Returns an ordered range of all the anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns an ordered range of all the anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment findByAnonymousUserId_First(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment fetchByAnonymousUserId_First(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment findByAnonymousUserId_Last(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment fetchByAnonymousUserId_Last(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns the anonymous user user segments before and after the current anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserUserSegmentId the primary key of the current anonymous user user segment
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	*/
	public AnonymousUserUserSegment[] findByAnonymousUserId_PrevAndNext(
		long anonymousUserUserSegmentId, long anonymousUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Removes all the anonymous user user segments where anonymousUserId = &#63; and active = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	*/
	public void removeByAnonymousUserId(long anonymousUserId, boolean active);

	/**
	* Returns the number of anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @return the number of matching anonymous user user segments
	*/
	public int countByAnonymousUserId(long anonymousUserId, boolean active);

	/**
	* Returns all the anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @return the matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active);

	/**
	* Returns a range of all the anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active, int start, int end);

	/**
	* Returns an ordered range of all the anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns an ordered range of all the anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment findByUserSegmentIds_First(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Returns the first anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment fetchByUserSegmentIds_First(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns the last anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment findByUserSegmentIds_Last(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Returns the last anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment fetchByUserSegmentIds_Last(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns the anonymous user user segments before and after the current anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param anonymousUserUserSegmentId the primary key of the current anonymous user user segment
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	*/
	public AnonymousUserUserSegment[] findByUserSegmentIds_PrevAndNext(
		long anonymousUserUserSegmentId, long userSegmentId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Returns all the anonymous user user segments where userSegmentId = any &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentIds the user segment IDs
	* @param active the active
	* @return the matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active);

	/**
	* Returns a range of all the anonymous user user segments where userSegmentId = any &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentIds the user segment IDs
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active, int start, int end);

	/**
	* Returns an ordered range of all the anonymous user user segments where userSegmentId = any &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentIds the user segment IDs
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns an ordered range of all the anonymous user user segments where userSegmentId = &#63; and active = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the anonymous user user segments where userSegmentId = &#63; and active = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	*/
	public void removeByUserSegmentIds(long userSegmentId, boolean active);

	/**
	* Returns the number of anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @return the number of matching anonymous user user segments
	*/
	public int countByUserSegmentIds(long userSegmentId, boolean active);

	/**
	* Returns the number of anonymous user user segments where userSegmentId = any &#63; and active = &#63;.
	*
	* @param userSegmentIds the user segment IDs
	* @param active the active
	* @return the number of matching anonymous user user segments
	*/
	public int countByUserSegmentIds(long[] userSegmentIds, boolean active);

	/**
	* Returns all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @return the matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByC_LtD_M(
		long companyId, Date modifiedDate, boolean manual);

	/**
	* Returns a range of all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByC_LtD_M(
		long companyId, Date modifiedDate, boolean manual, int start, int end);

	/**
	* Returns an ordered range of all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByC_LtD_M(
		long companyId, Date modifiedDate, boolean manual, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns an ordered range of all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findByC_LtD_M(
		long companyId, Date modifiedDate, boolean manual, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment findByC_LtD_M_First(long companyId,
		Date modifiedDate, boolean manual,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Returns the first anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment fetchByC_LtD_M_First(long companyId,
		Date modifiedDate, boolean manual,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns the last anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment findByC_LtD_M_Last(long companyId,
		Date modifiedDate, boolean manual,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Returns the last anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public AnonymousUserUserSegment fetchByC_LtD_M_Last(long companyId,
		Date modifiedDate, boolean manual,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns the anonymous user user segments before and after the current anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param anonymousUserUserSegmentId the primary key of the current anonymous user user segment
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	*/
	public AnonymousUserUserSegment[] findByC_LtD_M_PrevAndNext(
		long anonymousUserUserSegmentId, long companyId, Date modifiedDate,
		boolean manual,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Removes all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63; from the database.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	*/
	public void removeByC_LtD_M(long companyId, Date modifiedDate,
		boolean manual);

	/**
	* Returns the number of anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @return the number of matching anonymous user user segments
	*/
	public int countByC_LtD_M(long companyId, Date modifiedDate, boolean manual);

	/**
	* Caches the anonymous user user segment in the entity cache if it is enabled.
	*
	* @param anonymousUserUserSegment the anonymous user user segment
	*/
	public void cacheResult(AnonymousUserUserSegment anonymousUserUserSegment);

	/**
	* Caches the anonymous user user segments in the entity cache if it is enabled.
	*
	* @param anonymousUserUserSegments the anonymous user user segments
	*/
	public void cacheResult(
		java.util.List<AnonymousUserUserSegment> anonymousUserUserSegments);

	/**
	* Creates a new anonymous user user segment with the primary key. Does not add the anonymous user user segment to the database.
	*
	* @param anonymousUserUserSegmentId the primary key for the new anonymous user user segment
	* @return the new anonymous user user segment
	*/
	public AnonymousUserUserSegment create(long anonymousUserUserSegmentId);

	/**
	* Removes the anonymous user user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment that was removed
	* @throws NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	*/
	public AnonymousUserUserSegment remove(long anonymousUserUserSegmentId)
		throws NoSuchAnonymousUserUserSegmentException;

	public AnonymousUserUserSegment updateImpl(
		AnonymousUserUserSegment anonymousUserUserSegment);

	/**
	* Returns the anonymous user user segment with the primary key or throws a {@link NoSuchAnonymousUserUserSegmentException} if it could not be found.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	*/
	public AnonymousUserUserSegment findByPrimaryKey(
		long anonymousUserUserSegmentId)
		throws NoSuchAnonymousUserUserSegmentException;

	/**
	* Returns the anonymous user user segment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment, or <code>null</code> if a anonymous user user segment with the primary key could not be found
	*/
	public AnonymousUserUserSegment fetchByPrimaryKey(
		long anonymousUserUserSegmentId);

	@Override
	public java.util.Map<java.io.Serializable, AnonymousUserUserSegment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the anonymous user user segments.
	*
	* @return the anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findAll();

	/**
	* Returns a range of all the anonymous user user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findAll(int start, int end);

	/**
	* Returns an ordered range of all the anonymous user user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator);

	/**
	* Returns an ordered range of all the anonymous user user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of anonymous user user segments
	*/
	public java.util.List<AnonymousUserUserSegment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the anonymous user user segments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of anonymous user user segments.
	*
	* @return the number of anonymous user user segments
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}