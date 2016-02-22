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

import com.liferay.content.targeting.rule.score.points.model.ScorePoint;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the score point service. This utility wraps {@link com.liferay.content.targeting.rule.score.points.service.persistence.impl.ScorePointPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointPersistence
 * @see com.liferay.content.targeting.rule.score.points.service.persistence.impl.ScorePointPersistenceImpl
 * @generated
 */
@ProviderType
public class ScorePointUtil {
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
	public static void clearCache(ScorePoint scorePoint) {
		getPersistence().clearCache(scorePoint);
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
	public static List<ScorePoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ScorePoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ScorePoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ScorePoint> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ScorePoint update(ScorePoint scorePoint) {
		return getPersistence().update(scorePoint);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ScorePoint update(ScorePoint scorePoint,
		ServiceContext serviceContext) {
		return getPersistence().update(scorePoint, serviceContext);
	}

	/**
	* Returns all the score points where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching score points
	*/
	public static List<ScorePoint> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ScorePoint> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ScorePoint> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<ScorePoint> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ScorePoint> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<ScorePoint> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public static ScorePoint findByUuid_First(java.lang.String uuid,
		OrderByComparator<ScorePoint> orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public static ScorePoint fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<ScorePoint> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public static ScorePoint findByUuid_Last(java.lang.String uuid,
		OrderByComparator<ScorePoint> orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last score point in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public static ScorePoint fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<ScorePoint> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the score points before and after the current score point in the ordered set where uuid = &#63;.
	*
	* @param scorePointId the primary key of the current score point
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next score point
	* @throws NoSuchScorePointException if a score point with the primary key could not be found
	*/
	public static ScorePoint[] findByUuid_PrevAndNext(long scorePointId,
		java.lang.String uuid, OrderByComparator<ScorePoint> orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence()
				   .findByUuid_PrevAndNext(scorePointId, uuid, orderByComparator);
	}

	/**
	* Removes all the score points where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of score points where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching score points
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the score points where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching score points
	*/
	public static List<ScorePoint> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<ScorePoint> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<ScorePoint> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ScorePoint> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<ScorePoint> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ScorePoint> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first score point in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public static ScorePoint findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ScorePoint> orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first score point in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public static ScorePoint fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ScorePoint> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last score point in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public static ScorePoint findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ScorePoint> orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last score point in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public static ScorePoint fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ScorePoint> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static ScorePoint[] findByUuid_C_PrevAndNext(long scorePointId,
		java.lang.String uuid, long companyId,
		OrderByComparator<ScorePoint> orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(scorePointId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the score points where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of score points where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching score points
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the score points where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the matching score points
	*/
	public static List<ScorePoint> findByUserSegmentId(long userSegmentId) {
		return getPersistence().findByUserSegmentId(userSegmentId);
	}

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
	public static List<ScorePoint> findByUserSegmentId(long userSegmentId,
		int start, int end) {
		return getPersistence().findByUserSegmentId(userSegmentId, start, end);
	}

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
	public static List<ScorePoint> findByUserSegmentId(long userSegmentId,
		int start, int end, OrderByComparator<ScorePoint> orderByComparator) {
		return getPersistence()
				   .findByUserSegmentId(userSegmentId, start, end,
			orderByComparator);
	}

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
	public static List<ScorePoint> findByUserSegmentId(long userSegmentId,
		int start, int end, OrderByComparator<ScorePoint> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserSegmentId(userSegmentId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public static ScorePoint findByUserSegmentId_First(long userSegmentId,
		OrderByComparator<ScorePoint> orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence()
				   .findByUserSegmentId_First(userSegmentId, orderByComparator);
	}

	/**
	* Returns the first score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public static ScorePoint fetchByUserSegmentId_First(long userSegmentId,
		OrderByComparator<ScorePoint> orderByComparator) {
		return getPersistence()
				   .fetchByUserSegmentId_First(userSegmentId, orderByComparator);
	}

	/**
	* Returns the last score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public static ScorePoint findByUserSegmentId_Last(long userSegmentId,
		OrderByComparator<ScorePoint> orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence()
				   .findByUserSegmentId_Last(userSegmentId, orderByComparator);
	}

	/**
	* Returns the last score point in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public static ScorePoint fetchByUserSegmentId_Last(long userSegmentId,
		OrderByComparator<ScorePoint> orderByComparator) {
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
	* @throws NoSuchScorePointException if a score point with the primary key could not be found
	*/
	public static ScorePoint[] findByUserSegmentId_PrevAndNext(
		long scorePointId, long userSegmentId,
		OrderByComparator<ScorePoint> orderByComparator)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence()
				   .findByUserSegmentId_PrevAndNext(scorePointId,
			userSegmentId, orderByComparator);
	}

	/**
	* Removes all the score points where userSegmentId = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	*/
	public static void removeByUserSegmentId(long userSegmentId) {
		getPersistence().removeByUserSegmentId(userSegmentId);
	}

	/**
	* Returns the number of score points where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the number of matching score points
	*/
	public static int countByUserSegmentId(long userSegmentId) {
		return getPersistence().countByUserSegmentId(userSegmentId);
	}

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or throws a {@link NoSuchScorePointException} if it could not be found.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching score point
	* @throws NoSuchScorePointException if a matching score point could not be found
	*/
	public static ScorePoint findByC_U(long anonymousUserId, long userSegmentId)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence().findByC_U(anonymousUserId, userSegmentId);
	}

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public static ScorePoint fetchByC_U(long anonymousUserId, long userSegmentId) {
		return getPersistence().fetchByC_U(anonymousUserId, userSegmentId);
	}

	/**
	* Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching score point, or <code>null</code> if a matching score point could not be found
	*/
	public static ScorePoint fetchByC_U(long anonymousUserId,
		long userSegmentId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_U(anonymousUserId, userSegmentId, retrieveFromCache);
	}

	/**
	* Removes the score point where anonymousUserId = &#63; and userSegmentId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the score point that was removed
	*/
	public static ScorePoint removeByC_U(long anonymousUserId,
		long userSegmentId)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence().removeByC_U(anonymousUserId, userSegmentId);
	}

	/**
	* Returns the number of score points where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the number of matching score points
	*/
	public static int countByC_U(long anonymousUserId, long userSegmentId) {
		return getPersistence().countByC_U(anonymousUserId, userSegmentId);
	}

	/**
	* Caches the score point in the entity cache if it is enabled.
	*
	* @param scorePoint the score point
	*/
	public static void cacheResult(ScorePoint scorePoint) {
		getPersistence().cacheResult(scorePoint);
	}

	/**
	* Caches the score points in the entity cache if it is enabled.
	*
	* @param scorePoints the score points
	*/
	public static void cacheResult(List<ScorePoint> scorePoints) {
		getPersistence().cacheResult(scorePoints);
	}

	/**
	* Creates a new score point with the primary key. Does not add the score point to the database.
	*
	* @param scorePointId the primary key for the new score point
	* @return the new score point
	*/
	public static ScorePoint create(long scorePointId) {
		return getPersistence().create(scorePointId);
	}

	/**
	* Removes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point that was removed
	* @throws NoSuchScorePointException if a score point with the primary key could not be found
	*/
	public static ScorePoint remove(long scorePointId)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence().remove(scorePointId);
	}

	public static ScorePoint updateImpl(ScorePoint scorePoint) {
		return getPersistence().updateImpl(scorePoint);
	}

	/**
	* Returns the score point with the primary key or throws a {@link NoSuchScorePointException} if it could not be found.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point
	* @throws NoSuchScorePointException if a score point with the primary key could not be found
	*/
	public static ScorePoint findByPrimaryKey(long scorePointId)
		throws com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException {
		return getPersistence().findByPrimaryKey(scorePointId);
	}

	/**
	* Returns the score point with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scorePointId the primary key of the score point
	* @return the score point, or <code>null</code> if a score point with the primary key could not be found
	*/
	public static ScorePoint fetchByPrimaryKey(long scorePointId) {
		return getPersistence().fetchByPrimaryKey(scorePointId);
	}

	public static java.util.Map<java.io.Serializable, ScorePoint> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the score points.
	*
	* @return the score points
	*/
	public static List<ScorePoint> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ScorePoint> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ScorePoint> findAll(int start, int end,
		OrderByComparator<ScorePoint> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ScorePoint> findAll(int start, int end,
		OrderByComparator<ScorePoint> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the score points from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of score points.
	*
	* @return the number of score points
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ScorePointPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ScorePointPersistence, ScorePointPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ScorePointPersistence.class);
}