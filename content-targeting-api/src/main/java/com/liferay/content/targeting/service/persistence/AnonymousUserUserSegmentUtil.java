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

import com.liferay.content.targeting.model.AnonymousUserUserSegment;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the anonymous user user segment service. This utility wraps {@link com.liferay.content.targeting.service.persistence.impl.AnonymousUserUserSegmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegmentPersistence
 * @see com.liferay.content.targeting.service.persistence.impl.AnonymousUserUserSegmentPersistenceImpl
 * @generated
 */
@ProviderType
public class AnonymousUserUserSegmentUtil {
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
	public static void clearCache(
		AnonymousUserUserSegment anonymousUserUserSegment) {
		getPersistence().clearCache(anonymousUserUserSegment);
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
	public static List<AnonymousUserUserSegment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnonymousUserUserSegment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnonymousUserUserSegment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnonymousUserUserSegment update(
		AnonymousUserUserSegment anonymousUserUserSegment) {
		return getPersistence().update(anonymousUserUserSegment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnonymousUserUserSegment update(
		AnonymousUserUserSegment anonymousUserUserSegment,
		ServiceContext serviceContext) {
		return getPersistence().update(anonymousUserUserSegment, serviceContext);
	}

	/**
	* Returns all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the matching anonymous user user segments
	*/
	public static List<AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId) {
		return getPersistence().findByA_U(anonymousUserId, userSegmentId);
	}

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
	public static List<AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId, int start, int end) {
		return getPersistence()
				   .findByA_U(anonymousUserId, userSegmentId, start, end);
	}

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
	public static List<AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .findByA_U(anonymousUserId, userSegmentId, start, end,
			orderByComparator);
	}

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
	public static List<AnonymousUserUserSegment> findByA_U(
		long anonymousUserId, long userSegmentId, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByA_U(anonymousUserId, userSegmentId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment findByA_U_First(
		long anonymousUserId, long userSegmentId,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByA_U_First(anonymousUserId, userSegmentId,
			orderByComparator);
	}

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment fetchByA_U_First(
		long anonymousUserId, long userSegmentId,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .fetchByA_U_First(anonymousUserId, userSegmentId,
			orderByComparator);
	}

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment findByA_U_Last(
		long anonymousUserId, long userSegmentId,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByA_U_Last(anonymousUserId, userSegmentId,
			orderByComparator);
	}

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment fetchByA_U_Last(
		long anonymousUserId, long userSegmentId,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .fetchByA_U_Last(anonymousUserId, userSegmentId,
			orderByComparator);
	}

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
	public static AnonymousUserUserSegment[] findByA_U_PrevAndNext(
		long anonymousUserUserSegmentId, long anonymousUserId,
		long userSegmentId,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByA_U_PrevAndNext(anonymousUserUserSegmentId,
			anonymousUserId, userSegmentId, orderByComparator);
	}

	/**
	* Removes all the anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	*/
	public static void removeByA_U(long anonymousUserId, long userSegmentId) {
		getPersistence().removeByA_U(anonymousUserId, userSegmentId);
	}

	/**
	* Returns the number of anonymous user user segments where anonymousUserId = &#63; and userSegmentId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param userSegmentId the user segment ID
	* @return the number of matching anonymous user user segments
	*/
	public static int countByA_U(long anonymousUserId, long userSegmentId) {
		return getPersistence().countByA_U(anonymousUserId, userSegmentId);
	}

	/**
	* Returns all the anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @return the matching anonymous user user segments
	*/
	public static List<AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active) {
		return getPersistence().findByAnonymousUserId(anonymousUserId, active);
	}

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
	public static List<AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active, int start, int end) {
		return getPersistence()
				   .findByAnonymousUserId(anonymousUserId, active, start, end);
	}

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
	public static List<AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .findByAnonymousUserId(anonymousUserId, active, start, end,
			orderByComparator);
	}

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
	public static List<AnonymousUserUserSegment> findByAnonymousUserId(
		long anonymousUserId, boolean active, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAnonymousUserId(anonymousUserId, active, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment findByAnonymousUserId_First(
		long anonymousUserId, boolean active,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByAnonymousUserId_First(anonymousUserId, active,
			orderByComparator);
	}

	/**
	* Returns the first anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment fetchByAnonymousUserId_First(
		long anonymousUserId, boolean active,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .fetchByAnonymousUserId_First(anonymousUserId, active,
			orderByComparator);
	}

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment findByAnonymousUserId_Last(
		long anonymousUserId, boolean active,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByAnonymousUserId_Last(anonymousUserId, active,
			orderByComparator);
	}

	/**
	* Returns the last anonymous user user segment in the ordered set where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment fetchByAnonymousUserId_Last(
		long anonymousUserId, boolean active,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .fetchByAnonymousUserId_Last(anonymousUserId, active,
			orderByComparator);
	}

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
	public static AnonymousUserUserSegment[] findByAnonymousUserId_PrevAndNext(
		long anonymousUserUserSegmentId, long anonymousUserId, boolean active,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByAnonymousUserId_PrevAndNext(anonymousUserUserSegmentId,
			anonymousUserId, active, orderByComparator);
	}

	/**
	* Removes all the anonymous user user segments where anonymousUserId = &#63; and active = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	*/
	public static void removeByAnonymousUserId(long anonymousUserId,
		boolean active) {
		getPersistence().removeByAnonymousUserId(anonymousUserId, active);
	}

	/**
	* Returns the number of anonymous user user segments where anonymousUserId = &#63; and active = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param active the active
	* @return the number of matching anonymous user user segments
	*/
	public static int countByAnonymousUserId(long anonymousUserId,
		boolean active) {
		return getPersistence().countByAnonymousUserId(anonymousUserId, active);
	}

	/**
	* Returns all the anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @return the matching anonymous user user segments
	*/
	public static List<AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active) {
		return getPersistence().findByUserSegmentIds(userSegmentId, active);
	}

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
	public static List<AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active, int start, int end) {
		return getPersistence()
				   .findByUserSegmentIds(userSegmentId, active, start, end);
	}

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
	public static List<AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .findByUserSegmentIds(userSegmentId, active, start, end,
			orderByComparator);
	}

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
	public static List<AnonymousUserUserSegment> findByUserSegmentIds(
		long userSegmentId, boolean active, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserSegmentIds(userSegmentId, active, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment findByUserSegmentIds_First(
		long userSegmentId, boolean active,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByUserSegmentIds_First(userSegmentId, active,
			orderByComparator);
	}

	/**
	* Returns the first anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment fetchByUserSegmentIds_First(
		long userSegmentId, boolean active,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .fetchByUserSegmentIds_First(userSegmentId, active,
			orderByComparator);
	}

	/**
	* Returns the last anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment findByUserSegmentIds_Last(
		long userSegmentId, boolean active,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByUserSegmentIds_Last(userSegmentId, active,
			orderByComparator);
	}

	/**
	* Returns the last anonymous user user segment in the ordered set where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment fetchByUserSegmentIds_Last(
		long userSegmentId, boolean active,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .fetchByUserSegmentIds_Last(userSegmentId, active,
			orderByComparator);
	}

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
	public static AnonymousUserUserSegment[] findByUserSegmentIds_PrevAndNext(
		long anonymousUserUserSegmentId, long userSegmentId, boolean active,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByUserSegmentIds_PrevAndNext(anonymousUserUserSegmentId,
			userSegmentId, active, orderByComparator);
	}

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
	public static List<AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active) {
		return getPersistence().findByUserSegmentIds(userSegmentIds, active);
	}

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
	public static List<AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active, int start, int end) {
		return getPersistence()
				   .findByUserSegmentIds(userSegmentIds, active, start, end);
	}

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
	public static List<AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .findByUserSegmentIds(userSegmentIds, active, start, end,
			orderByComparator);
	}

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
	public static List<AnonymousUserUserSegment> findByUserSegmentIds(
		long[] userSegmentIds, boolean active, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserSegmentIds(userSegmentIds, active, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the anonymous user user segments where userSegmentId = &#63; and active = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	*/
	public static void removeByUserSegmentIds(long userSegmentId, boolean active) {
		getPersistence().removeByUserSegmentIds(userSegmentId, active);
	}

	/**
	* Returns the number of anonymous user user segments where userSegmentId = &#63; and active = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param active the active
	* @return the number of matching anonymous user user segments
	*/
	public static int countByUserSegmentIds(long userSegmentId, boolean active) {
		return getPersistence().countByUserSegmentIds(userSegmentId, active);
	}

	/**
	* Returns the number of anonymous user user segments where userSegmentId = any &#63; and active = &#63;.
	*
	* @param userSegmentIds the user segment IDs
	* @param active the active
	* @return the number of matching anonymous user user segments
	*/
	public static int countByUserSegmentIds(long[] userSegmentIds,
		boolean active) {
		return getPersistence().countByUserSegmentIds(userSegmentIds, active);
	}

	/**
	* Returns all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @return the matching anonymous user user segments
	*/
	public static List<AnonymousUserUserSegment> findByC_LtD_M(long companyId,
		Date modifiedDate, boolean manual) {
		return getPersistence().findByC_LtD_M(companyId, modifiedDate, manual);
	}

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
	public static List<AnonymousUserUserSegment> findByC_LtD_M(long companyId,
		Date modifiedDate, boolean manual, int start, int end) {
		return getPersistence()
				   .findByC_LtD_M(companyId, modifiedDate, manual, start, end);
	}

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
	public static List<AnonymousUserUserSegment> findByC_LtD_M(long companyId,
		Date modifiedDate, boolean manual, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .findByC_LtD_M(companyId, modifiedDate, manual, start, end,
			orderByComparator);
	}

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
	public static List<AnonymousUserUserSegment> findByC_LtD_M(long companyId,
		Date modifiedDate, boolean manual, int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_LtD_M(companyId, modifiedDate, manual, start, end,
			orderByComparator, retrieveFromCache);
	}

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
	public static AnonymousUserUserSegment findByC_LtD_M_First(long companyId,
		Date modifiedDate, boolean manual,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByC_LtD_M_First(companyId, modifiedDate, manual,
			orderByComparator);
	}

	/**
	* Returns the first anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment fetchByC_LtD_M_First(
		long companyId, Date modifiedDate, boolean manual,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .fetchByC_LtD_M_First(companyId, modifiedDate, manual,
			orderByComparator);
	}

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
	public static AnonymousUserUserSegment findByC_LtD_M_Last(long companyId,
		Date modifiedDate, boolean manual,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByC_LtD_M_Last(companyId, modifiedDate, manual,
			orderByComparator);
	}

	/**
	* Returns the last anonymous user user segment in the ordered set where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anonymous user user segment, or <code>null</code> if a matching anonymous user user segment could not be found
	*/
	public static AnonymousUserUserSegment fetchByC_LtD_M_Last(long companyId,
		Date modifiedDate, boolean manual,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence()
				   .fetchByC_LtD_M_Last(companyId, modifiedDate, manual,
			orderByComparator);
	}

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
	public static AnonymousUserUserSegment[] findByC_LtD_M_PrevAndNext(
		long anonymousUserUserSegmentId, long companyId, Date modifiedDate,
		boolean manual,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence()
				   .findByC_LtD_M_PrevAndNext(anonymousUserUserSegmentId,
			companyId, modifiedDate, manual, orderByComparator);
	}

	/**
	* Removes all the anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63; from the database.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	*/
	public static void removeByC_LtD_M(long companyId, Date modifiedDate,
		boolean manual) {
		getPersistence().removeByC_LtD_M(companyId, modifiedDate, manual);
	}

	/**
	* Returns the number of anonymous user user segments where companyId = &#63; and modifiedDate &lt; &#63; and manual = &#63;.
	*
	* @param companyId the company ID
	* @param modifiedDate the modified date
	* @param manual the manual
	* @return the number of matching anonymous user user segments
	*/
	public static int countByC_LtD_M(long companyId, Date modifiedDate,
		boolean manual) {
		return getPersistence().countByC_LtD_M(companyId, modifiedDate, manual);
	}

	/**
	* Caches the anonymous user user segment in the entity cache if it is enabled.
	*
	* @param anonymousUserUserSegment the anonymous user user segment
	*/
	public static void cacheResult(
		AnonymousUserUserSegment anonymousUserUserSegment) {
		getPersistence().cacheResult(anonymousUserUserSegment);
	}

	/**
	* Caches the anonymous user user segments in the entity cache if it is enabled.
	*
	* @param anonymousUserUserSegments the anonymous user user segments
	*/
	public static void cacheResult(
		List<AnonymousUserUserSegment> anonymousUserUserSegments) {
		getPersistence().cacheResult(anonymousUserUserSegments);
	}

	/**
	* Creates a new anonymous user user segment with the primary key. Does not add the anonymous user user segment to the database.
	*
	* @param anonymousUserUserSegmentId the primary key for the new anonymous user user segment
	* @return the new anonymous user user segment
	*/
	public static AnonymousUserUserSegment create(
		long anonymousUserUserSegmentId) {
		return getPersistence().create(anonymousUserUserSegmentId);
	}

	/**
	* Removes the anonymous user user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment that was removed
	* @throws NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	*/
	public static AnonymousUserUserSegment remove(
		long anonymousUserUserSegmentId)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence().remove(anonymousUserUserSegmentId);
	}

	public static AnonymousUserUserSegment updateImpl(
		AnonymousUserUserSegment anonymousUserUserSegment) {
		return getPersistence().updateImpl(anonymousUserUserSegment);
	}

	/**
	* Returns the anonymous user user segment with the primary key or throws a {@link NoSuchAnonymousUserUserSegmentException} if it could not be found.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment
	* @throws NoSuchAnonymousUserUserSegmentException if a anonymous user user segment with the primary key could not be found
	*/
	public static AnonymousUserUserSegment findByPrimaryKey(
		long anonymousUserUserSegmentId)
		throws com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException {
		return getPersistence().findByPrimaryKey(anonymousUserUserSegmentId);
	}

	/**
	* Returns the anonymous user user segment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment, or <code>null</code> if a anonymous user user segment with the primary key could not be found
	*/
	public static AnonymousUserUserSegment fetchByPrimaryKey(
		long anonymousUserUserSegmentId) {
		return getPersistence().fetchByPrimaryKey(anonymousUserUserSegmentId);
	}

	public static java.util.Map<java.io.Serializable, AnonymousUserUserSegment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the anonymous user user segments.
	*
	* @return the anonymous user user segments
	*/
	public static List<AnonymousUserUserSegment> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AnonymousUserUserSegment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AnonymousUserUserSegment> findAll(int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AnonymousUserUserSegment> findAll(int start, int end,
		OrderByComparator<AnonymousUserUserSegment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the anonymous user user segments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of anonymous user user segments.
	*
	* @return the number of anonymous user user segments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AnonymousUserUserSegmentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnonymousUserUserSegmentPersistence, AnonymousUserUserSegmentPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AnonymousUserUserSegmentPersistence.class);
}