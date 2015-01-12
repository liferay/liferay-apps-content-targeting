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

import com.liferay.content.targeting.rule.score.points.model.ScorePoint;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the score point service. This utility wraps {@link ScorePointPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointPersistence
 * @see ScorePointPersistenceImpl
 * @generated
 */
public class ScorePointUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ScorePoint scorePoint) {
		getPersistence().clearCache(scorePoint);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ScorePoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ScorePoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ScorePoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ScorePoint update(ScorePoint scorePoint)
		throws SystemException {
		return getPersistence().update(scorePoint);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ScorePoint update(ScorePoint scorePoint,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(scorePoint, serviceContext);
	}

	/**
	* Returns all the score points where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching score points
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the score points where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the score points where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point
	* @throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point, or <code>null</code> if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point
	* @throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point, or <code>null</code> if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the score points before and after the current score point in the ordered set where uuid = &#63;.
	*
	* @param scorePointId the primary key of the current score point
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next score point
	* @throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint[] findByUuid_PrevAndNext(
		long scorePointId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(scorePointId, uuid, orderByComparator);
	}

	/**
	* Removes all the score points where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of score points where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the score points where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the matching score points
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> findByUserSegmentId(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserSegmentId(userSegmentId);
	}

	/**
	* Returns a range of all the score points where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> findByUserSegmentId(
		long userSegmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserSegmentId(userSegmentId, start, end);
	}

	/**
	* Returns an ordered range of all the score points where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> findByUserSegmentId(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserSegmentId(userSegmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point
	* @throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint findByUserSegmentId_First(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserSegmentId_First(userSegmentId, orderByComparator);
	}

	/**
	* Returns the first score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point, or <code>null</code> if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint fetchByUserSegmentId_First(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserSegmentId_First(userSegmentId, orderByComparator);
	}

	/**
	* Returns the last score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point
	* @throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint findByUserSegmentId_Last(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserSegmentId_Last(userSegmentId, orderByComparator);
	}

	/**
	* Returns the last score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point, or <code>null</code> if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint fetchByUserSegmentId_Last(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserSegmentId_Last(userSegmentId, orderByComparator);
	}

	/**
	* Returns the score points before and after the current score point in the ordered set where userSegmentId = &#63;.
	*
	* @param scorePointId the primary key of the current score point
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next score point
	* @throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint[] findByUserSegmentId_PrevAndNext(
		long scorePointId, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserSegmentId_PrevAndNext(scorePointId,
			userSegmentId, orderByComparator);
	}

	/**
	* Removes all the score points where userSegmentId = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserSegmentId(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserSegmentId(userSegmentId);
	}

	/**
	* Returns the number of score points where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the number of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserSegmentId(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserSegmentId(userSegmentId);
	}

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or throws a {@link com.liferay.content.targeting.rule.score.points.NoSuchScorePointException} if it could not be found.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching score point
	* @throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint findByC_U(
		long anonymousUserId, long userSegmentId)
		throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_U(anonymousUserId, userSegmentId);
	}

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching score point, or <code>null</code> if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint fetchByC_U(
		long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_U(anonymousUserId, userSegmentId);
	}

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching score point, or <code>null</code> if a matching score point could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint fetchByC_U(
		long anonymousUserId, long userSegmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_U(anonymousUserId, userSegmentId, retrieveFromCache);
	}

	/**
	* Removes the score point where anonymousUserId = &#63; and userSegmentId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the score point that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint removeByC_U(
		long anonymousUserId, long userSegmentId)
		throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByC_U(anonymousUserId, userSegmentId);
	}

	/**
	* Returns the number of score points where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the number of matching score points
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_U(long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_U(anonymousUserId, userSegmentId);
	}

	/**
	* Caches the score point in the entity cache if it is enabled.
	*
	* @param scorePoint the score point
	*/
	public static void cacheResult(
		com.liferay.content.targeting.rule.score.points.model.ScorePoint scorePoint) {
		getPersistence().cacheResult(scorePoint);
	}

	/**
	* Caches the score points in the entity cache if it is enabled.
	*
	* @param scorePoints the score points
	*/
	public static void cacheResult(
		java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> scorePoints) {
		getPersistence().cacheResult(scorePoints);
	}

	/**
	* Creates a new score point with the primary key. Does not add the score point to the database.
	*
	* @param scorePointId the primary key for the new score point
	* @return the new score point
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint create(
		long scorePointId) {
		return getPersistence().create(scorePointId);
	}

	/**
	* Removes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point that was removed
	* @throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint remove(
		long scorePointId)
		throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(scorePointId);
	}

	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint updateImpl(
		com.liferay.content.targeting.rule.score.points.model.ScorePoint scorePoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(scorePoint);
	}

	/**
	* Returns the score point with the primary key or throws a {@link com.liferay.content.targeting.rule.score.points.NoSuchScorePointException} if it could not be found.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point
	* @throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint findByPrimaryKey(
		long scorePointId)
		throws com.liferay.content.targeting.rule.score.points.NoSuchScorePointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(scorePointId);
	}

	/**
	* Returns the score point with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point, or <code>null</code> if a score point with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.score.points.model.ScorePoint fetchByPrimaryKey(
		long scorePointId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scorePointId);
	}

	/**
	* Returns all the score points.
	*
	* @return the score points
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the score points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @return the range of score points
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the score points.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of score points
	* @param end the upper bound of the range of score points (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of score points
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.score.points.model.ScorePoint> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the score points from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of score points.
	*
	* @return the number of score points
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ScorePointPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ScorePointPersistence)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.rule.score.points.service.ClpSerializer.getServletContextName(),
					ScorePointPersistence.class.getName());

			ReferenceRegistry.registerReference(ScorePointUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ScorePointPersistence persistence) {
	}

	private static ScorePointPersistence _persistence;
}