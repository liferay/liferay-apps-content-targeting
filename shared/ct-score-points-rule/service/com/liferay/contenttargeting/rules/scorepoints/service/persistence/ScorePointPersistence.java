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

package com.liferay.contenttargeting.rules.scorepoints.service.persistence;

import com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the score point service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointPersistenceImpl
 * @see ScorePointUtil
 * @generated
 */
public interface ScorePointPersistence extends BasePersistence<ScorePoint> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScorePointUtil} to access the score point persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the score points where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching score points
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the score points where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.rules.scorepoints.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the score points where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.rules.scorepoints.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point
	* @throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point, or <code>null</code> if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point
	* @throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point, or <code>null</code> if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the score points before and after the current score point in the ordered set where uuid = &#63;.
	*
	* @param Id the primary key of the current score point
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next score point
	* @throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint[] findByUuid_PrevAndNext(
		long Id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the score points where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of score points where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or throws a {@link com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException} if it could not be found.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching score point
	* @throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint findByC_U(
		long anonymousUserId, long userSegmentId)
		throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching score point, or <code>null</code> if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint fetchByC_U(
		long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching score point, or <code>null</code> if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint fetchByC_U(
		long anonymousUserId, long userSegmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the score point where anonymousUserId = &#63; and userSegmentId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the score point that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint removeByC_U(
		long anonymousUserId, long userSegmentId)
		throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of score points where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the number of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_U(long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the score point in the entity cache if it is enabled.
	*
	* @param scorePoint the score point
	*/
	public void cacheResult(
		com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint scorePoint);

	/**
	* Caches the score points in the entity cache if it is enabled.
	*
	* @param scorePoints the score points
	*/
	public void cacheResult(
		java.util.List<com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint> scorePoints);

	/**
	* Creates a new score point with the primary key. Does not add the score point to the database.
	*
	* @param Id the primary key for the new score point
	* @return the new score point
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint create(
		long Id);

	/**
	* Removes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the score point
	* @return the score point that was removed
	* @throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint remove(
		long Id)
		throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint updateImpl(
		com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint scorePoint)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the score point with the primary key or throws a {@link com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException} if it could not be found.
	*
	* @param Id the primary key of the score point
	* @return the score point
	* @throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint findByPrimaryKey(
		long Id)
		throws com.liferay.contenttargeting.rules.scorepoints.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the score point with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Id the primary key of the score point
	* @return the score point, or <code>null</code> if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint fetchByPrimaryKey(
		long Id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the score points.
	*
	* @return the score points
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the score points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.rules.scorepoints.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of score points
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the score points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.rules.scorepoints.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of score points
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.rules.scorepoints.model.ScorePoint> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the score points from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of score points.
	*
	* @return the number of score points
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}