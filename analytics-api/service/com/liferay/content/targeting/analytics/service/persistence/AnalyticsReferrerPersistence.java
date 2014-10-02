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

package com.liferay.content.targeting.analytics.service.persistence;

import com.liferay.content.targeting.analytics.model.AnalyticsReferrer;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the analytics referrer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsReferrerPersistenceImpl
 * @see AnalyticsReferrerUtil
 * @generated
 */
public interface AnalyticsReferrerPersistence extends BasePersistence<AnalyticsReferrer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnalyticsReferrerUtil} to access the analytics referrer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findByR_R(
		java.lang.String referrerClassName, long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findByR_R(
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findByR_R(
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics referrer
	* @throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer findByR_R_First(
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer fetchByR_R_First(
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics referrer
	* @throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer findByR_R_Last(
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer fetchByR_R_Last(
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the analytics referrers before and after the current analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsReferrerId the primary key of the current analytics referrer
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics referrer
	* @throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer[] findByR_R_PrevAndNext(
		long analyticsReferrerId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByR_R(java.lang.String referrerClassName,
		long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the number of matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public int countByR_R(java.lang.String referrerClassName,
		long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findByA_R_R(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findByA_R_R(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findByA_R_R(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics referrer
	* @throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer findByA_R_R_First(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer fetchByA_R_R_First(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics referrer
	* @throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer findByA_R_R_Last(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer fetchByA_R_R_Last(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the analytics referrers before and after the current analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsReferrerId the primary key of the current analytics referrer
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics referrer
	* @throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer[] findByA_R_R_PrevAndNext(
		long analyticsReferrerId, long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventIds the analytics event IDs
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findByA_R_R(
		long[] analyticsEventIds, java.lang.String referrerClassName,
		long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventIds the analytics event IDs
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findByA_R_R(
		long[] analyticsEventIds, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventIds the analytics event IDs
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findByA_R_R(
		long[] analyticsEventIds, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByA_R_R(long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the number of matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public int countByA_R_R(long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventIds the analytics event IDs
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the number of matching analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public int countByA_R_R(long[] analyticsEventIds,
		java.lang.String referrerClassName, long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the analytics referrer in the entity cache if it is enabled.
	*
	* @param analyticsReferrer the analytics referrer
	*/
	public void cacheResult(
		com.liferay.content.targeting.analytics.model.AnalyticsReferrer analyticsReferrer);

	/**
	* Caches the analytics referrers in the entity cache if it is enabled.
	*
	* @param analyticsReferrers the analytics referrers
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> analyticsReferrers);

	/**
	* Creates a new analytics referrer with the primary key. Does not add the analytics referrer to the database.
	*
	* @param analyticsReferrerId the primary key for the new analytics referrer
	* @return the new analytics referrer
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer create(
		long analyticsReferrerId);

	/**
	* Removes the analytics referrer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer that was removed
	* @throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer remove(
		long analyticsReferrerId)
		throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer updateImpl(
		com.liferay.content.targeting.analytics.model.AnalyticsReferrer analyticsReferrer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the analytics referrer with the primary key or throws a {@link com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException} if it could not be found.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer
	* @throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer findByPrimaryKey(
		long analyticsReferrerId)
		throws com.liferay.content.targeting.analytics.NoSuchAnalyticsReferrerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the analytics referrer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer, or <code>null</code> if a analytics referrer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.analytics.model.AnalyticsReferrer fetchByPrimaryKey(
		long analyticsReferrerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the analytics referrers.
	*
	* @return the analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the analytics referrers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the analytics referrers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsReferrer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the analytics referrers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of analytics referrers.
	*
	* @return the number of analytics referrers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}