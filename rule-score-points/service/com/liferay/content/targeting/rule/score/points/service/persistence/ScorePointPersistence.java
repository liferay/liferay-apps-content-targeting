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

package com.liferay.content.targeting.rule.score.points.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException;
import com.liferay.content.targeting.rule.score.points.model.ScorePoint;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the score point service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.score.points.service.persistence.impl.ScorePointPersistenceImpl
 * @see ScorePointUtil
 * @generated
 */
@ProviderType
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
	*/
	public java.util.List<ScorePoint> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the score points where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of matching score points
	*/
	public java.util.List<ScorePoint> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the score points where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching score points
	*/
	public java.util.List<ScorePoint> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator);

	/**
	* Returns an ordered range of all the score points where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching score points
	*/
	public java.util.List<ScorePoint> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public ScorePoint findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException;

	/**
	* Returns the first score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public ScorePoint fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator);

	/**
	* Returns the last score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public ScorePoint findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException;

	/**
	* Returns the last score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public ScorePoint fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator);

	/**
	* Returns the score points before and after the current score point in the ordered set where uuid = &#63;.
	*
	* @param scorePointId the primary key of the current score point
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next score point
	* @throws NoSuchScorePointException if a score point with the primary key could not be found
	*/
	public ScorePoint[] findByUuid_PrevAndNext(long scorePointId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException;

	/**
	* Removes all the score points where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of score points where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching score points
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the score points where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching score points
	*/
	public java.util.List<ScorePoint> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the score points where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of matching score points
	*/
	public java.util.List<ScorePoint> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the score points where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching score points
	*/
	public java.util.List<ScorePoint> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator);

	/**
	* Returns an ordered range of all the score points where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching score points
	*/
	public java.util.List<ScorePoint> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first score point in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public ScorePoint findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException;

	/**
	* Returns the first score point in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public ScorePoint fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator);

	/**
	* Returns the last score point in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public ScorePoint findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException;

	/**
	* Returns the last score point in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public ScorePoint fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator);

	/**
	* Returns the score points before and after the current score point in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param scorePointId the primary key of the current score point
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next score point
	* @throws NoSuchScorePointException if a score point with the primary key could not be found
	*/
	public ScorePoint[] findByUuid_C_PrevAndNext(long scorePointId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException;

	/**
	* Removes all the score points where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of score points where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching score points
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the score points where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the matching score points
	*/
	public java.util.List<ScorePoint> findByUserSegmentId(long userSegmentId);

	/**
	* Returns a range of all the score points where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of matching score points
	*/
	public java.util.List<ScorePoint> findByUserSegmentId(long userSegmentId,
		int start, int end);

	/**
	* Returns an ordered range of all the score points where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching score points
	*/
	public java.util.List<ScorePoint> findByUserSegmentId(long userSegmentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator);

	/**
	* Returns an ordered range of all the score points where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching score points
	*/
	public java.util.List<ScorePoint> findByUserSegmentId(long userSegmentId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public ScorePoint findByUserSegmentId_First(long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException;

	/**
	* Returns the first score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public ScorePoint fetchByUserSegmentId_First(long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator);

	/**
	* Returns the last score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public ScorePoint findByUserSegmentId_Last(long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException;

	/**
	* Returns the last score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public ScorePoint fetchByUserSegmentId_Last(long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator);

	/**
	* Returns the score points before and after the current score point in the ordered set where userSegmentId = &#63;.
	*
	* @param scorePointId the primary key of the current score point
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next score point
	* @throws NoSuchScorePointException if a score point with the primary key could not be found
	*/
	public ScorePoint[] findByUserSegmentId_PrevAndNext(long scorePointId,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException;

	/**
	* Removes all the score points where userSegmentId = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	*/
	public void removeByUserSegmentId(long userSegmentId);

	/**
	* Returns the number of score points where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the number of matching score points
	*/
	public int countByUserSegmentId(long userSegmentId);

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or throws a {@link NoSuchScorePointException} if it could not be found.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public ScorePoint findByC_U(long anonymousUserId, long userSegmentId)
		throws NoSuchScorePointException;

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public ScorePoint fetchByC_U(long anonymousUserId, long userSegmentId);

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public ScorePoint fetchByC_U(long anonymousUserId, long userSegmentId,
		boolean retrieveFromCache);

	/**
	* Removes the score point where anonymousUserId = &#63; and userSegmentId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the score point that was removed
	*/
	public ScorePoint removeByC_U(long anonymousUserId, long userSegmentId)
		throws NoSuchScorePointException;

	/**
	* Returns the number of score points where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the number of matching score points
	*/
	public int countByC_U(long anonymousUserId, long userSegmentId);

	/**
	* Caches the score point in the entity cache if it is enabled.
	*
	* @param scorePoint the score point
	*/
	public void cacheResult(ScorePoint scorePoint);

	/**
	* Caches the score points in the entity cache if it is enabled.
	*
	* @param scorePoints the score points
	*/
	public void cacheResult(java.util.List<ScorePoint> scorePoints);

	/**
	* Creates a new score point with the primary key. Does not add the score point to the database.
	*
	* @param scorePointId the primary key for the new score point
	* @return the new score point
	*/
	public ScorePoint create(long scorePointId);

	/**
	* Removes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point that was removed
	* @throws NoSuchScorePointException if a score point with the primary key could not be found
	*/
	public ScorePoint remove(long scorePointId)
		throws NoSuchScorePointException;

	public ScorePoint updateImpl(ScorePoint scorePoint);

	/**
	* Returns the score point with the primary key or throws a {@link NoSuchScorePointException} if it could not be found.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point
	* @throws NoSuchScorePointException if a score point with the primary key could not be found
	*/
	public ScorePoint findByPrimaryKey(long scorePointId)
		throws NoSuchScorePointException;

	/**
	* Returns the score point with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point, or <code>null</code> if a score point with the primary key could not be found
	*/
	public ScorePoint fetchByPrimaryKey(long scorePointId);

	@Override
	public java.util.Map<java.io.Serializable, ScorePoint> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the score points.
	*
	* @return the score points
	*/
	public java.util.List<ScorePoint> findAll();

	/**
	* Returns a range of all the score points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of score points
	*/
	public java.util.List<ScorePoint> findAll(int start, int end);

	/**
	* Returns an ordered range of all the score points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of score points
	*/
	public java.util.List<ScorePoint> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator);

	/**
	* Returns an ordered range of all the score points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of score points
	*/
	public java.util.List<ScorePoint> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ScorePoint> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the score points from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of score points.
	*
	* @return the number of score points
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}