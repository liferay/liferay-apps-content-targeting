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

import com.liferay.content.targeting.model.AnonymousUserUserSegment;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the anonymous user user segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegmentPersistenceImpl
 * @see AnonymousUserUserSegmentUtil
 * @generated
 */
public interface AnonymousUserUserSegmentPersistence extends BasePersistence<AnonymousUserUserSegment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnonymousUserUserSegmentUtil} to access the anonymous user user segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @return the matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment findByAnonymousUserId_First(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment fetchByAnonymousUserId_First(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment findByAnonymousUserId_Last(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment fetchByAnonymousUserId_Last(
		long anonymousUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous user user segments before and after the current anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserUserSegmentId the primary key of the current anonymous user user segment
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment[] findByAnonymousUserId_PrevAndNext(
		long anonymousUserUserSegmentId, long anonymousUserId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anonymous user user segments where anonymousUserId = &#63; and active = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAnonymousUserId(long anonymousUserId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @return the number of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public int countByAnonymousUserId(long anonymousUserId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment findByA_U_First(
		long anonymousUserId, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment fetchByA_U_First(
		long anonymousUserId, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment findByA_U_Last(
		long anonymousUserId, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment fetchByA_U_Last(
		long anonymousUserId, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous user user segments before and after the current anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserUserSegmentId the primary key of the current anonymous user user segment
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment[] findByA_U_PrevAndNext(
		long anonymousUserUserSegmentId, long anonymousUserId,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByA_U(long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the number of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public int countByA_U(long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @return the matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByC_LtD_M(
		long companyId, java.util.Date modifiedDate, boolean manual)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByC_LtD_M(
		long companyId, java.util.Date modifiedDate, boolean manual, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByC_LtD_M(
		long companyId, java.util.Date modifiedDate, boolean manual, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment findByC_LtD_M_First(
		long companyId, java.util.Date modifiedDate, boolean manual,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment fetchByC_LtD_M_First(
		long companyId, java.util.Date modifiedDate, boolean manual,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment findByC_LtD_M_Last(
		long companyId, java.util.Date modifiedDate, boolean manual,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment fetchByC_LtD_M_Last(
		long companyId, java.util.Date modifiedDate, boolean manual,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous user user segments before and after the current anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param anonymousUserUserSegmentId the primary key of the current anonymous user user segment
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment[] findByC_LtD_M_PrevAndNext(
		long anonymousUserUserSegmentId, long companyId,
		java.util.Date modifiedDate, boolean manual,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63; from the database.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_LtD_M(long companyId, java.util.Date modifiedDate,
		boolean manual)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @return the number of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_LtD_M(long companyId, java.util.Date modifiedDate,
		boolean manual)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @return the matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment findByUserSegmentIds_First(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment fetchByUserSegmentIds_First(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment findByUserSegmentIds_Last(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment fetchByUserSegmentIds_Last(
		long userSegmentId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous user user segments before and after the current anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param anonymousUserUserSegmentId the primary key of the current anonymous user user segment
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment[] findByUserSegmentIds_PrevAndNext(
		long anonymousUserUserSegmentId, long userSegmentId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anonymous user user segments where userSegmentId = any &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentIds the user segment IDs
	* @param active the active
	* @return the matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anonymous user user segments where userSegmentId = any &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentIds the user segment IDs
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anonymous user user segments where userSegmentId = any &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentIds the user segment IDs
	* @param active the active
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anonymous user user segments where userSegmentId = &#63; and active = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserSegmentIds(long userSegmentId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @return the number of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserSegmentIds(long userSegmentId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anonymous user user segments where userSegmentId = any &#63; and active = &#63;.
	*
	* @param userSegmentIds the user segment IDs
	* @param active the active
	* @return the number of matching anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserSegmentIds(long[] userSegmentIds, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the anonymous user user segment in the entity cache if it is enabled.
	*
	* @param anonymousUserUserSegment the anonymous user user segment
	*/
	public void cacheResult(
		com.liferay.content.targeting.model.AnonymousUserUserSegment anonymousUserUserSegment);

	/**
	* Caches the anonymous user user segments in the entity cache if it is enabled.
	*
	* @param anonymousUserUserSegments the anonymous user user segments
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> anonymousUserUserSegments);

	/**
	* Creates a new anonymous user user segment with the primary key. Does not add the anonymous user user segment to the database.
	*
	* @param anonymousUserUserSegmentId the primary key for the new anonymous user user segment
	* @return the new anonymous user user segment
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment create(
		long anonymousUserUserSegmentId);

	/**
	* Removes the anonymous user user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment that was removed
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment remove(
		long anonymousUserUserSegmentId)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.model.AnonymousUserUserSegment updateImpl(
		com.liferay.content.targeting.model.AnonymousUserUserSegment anonymousUserUserSegment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous user user segment with the primary key or throws a {@link com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException} if it could not be found.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment
	* @throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment findByPrimaryKey(
		long anonymousUserUserSegmentId)
		throws com.liferay.content.targeting.NoSuchAnonymousUserUserSegmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anonymous user user segment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment, or <code>null</code> if a anonymous user user segment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.AnonymousUserUserSegment fetchByPrimaryKey(
		long anonymousUserUserSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anonymous user user segments.
	*
	* @return the anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anonymous user user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anonymous user user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anonymous user user segments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anonymous user user segments.
	*
	* @return the number of anonymous user user segments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}