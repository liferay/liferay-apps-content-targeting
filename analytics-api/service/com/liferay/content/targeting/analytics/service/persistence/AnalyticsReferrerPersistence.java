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

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsReferrerException;
import com.liferay.content.targeting.analytics.model.AnalyticsReferrer;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the analytics referrer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.analytics.service.persistence.impl.AnalyticsReferrerPersistenceImpl
 * @see AnalyticsReferrerUtil
 * @generated
 */
@ProviderType
public interface AnalyticsReferrerPersistence extends BasePersistence<AnalyticsReferrer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnalyticsReferrerUtil} to access the analytics referrer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the analytics referrers where analyticsEventId = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @return the matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByAnalyticsEventId(
		long analyticsEventId);

	/**
	* Returns a range of all the analytics referrers where analyticsEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventId the analytics event ID
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByAnalyticsEventId(
		long analyticsEventId, int start, int end);

	/**
	* Returns an ordered range of all the analytics referrers where analyticsEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventId the analytics event ID
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByAnalyticsEventId(
		long analyticsEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns an ordered range of all the analytics referrers where analyticsEventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventId the analytics event ID
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByAnalyticsEventId(
		long analyticsEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analytics referrer in the ordered set where analyticsEventId = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics referrer
	* @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer findByAnalyticsEventId_First(
		long analyticsEventId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException;

	/**
	* Returns the first analytics referrer in the ordered set where analyticsEventId = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer fetchByAnalyticsEventId_First(
		long analyticsEventId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns the last analytics referrer in the ordered set where analyticsEventId = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics referrer
	* @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer findByAnalyticsEventId_Last(
		long analyticsEventId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException;

	/**
	* Returns the last analytics referrer in the ordered set where analyticsEventId = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer fetchByAnalyticsEventId_Last(
		long analyticsEventId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns the analytics referrers before and after the current analytics referrer in the ordered set where analyticsEventId = &#63;.
	*
	* @param analyticsReferrerId the primary key of the current analytics referrer
	* @param analyticsEventId the analytics event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics referrer
	* @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	*/
	public AnalyticsReferrer[] findByAnalyticsEventId_PrevAndNext(
		long analyticsReferrerId, long analyticsEventId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException;

	/**
	* Removes all the analytics referrers where analyticsEventId = &#63; from the database.
	*
	* @param analyticsEventId the analytics event ID
	*/
	public void removeByAnalyticsEventId(long analyticsEventId);

	/**
	* Returns the number of analytics referrers where analyticsEventId = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @return the number of matching analytics referrers
	*/
	public int countByAnalyticsEventId(long analyticsEventId);

	/**
	* Returns all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByR_R(
		java.lang.String referrerClassName, long referrerClassPK);

	/**
	* Returns a range of all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByR_R(
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end);

	/**
	* Returns an ordered range of all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByR_R(
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns an ordered range of all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByR_R(
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics referrer
	* @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer findByR_R_First(
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException;

	/**
	* Returns the first analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer fetchByR_R_First(
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns the last analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics referrer
	* @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer findByR_R_Last(
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException;

	/**
	* Returns the last analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer fetchByR_R_Last(
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns the analytics referrers before and after the current analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsReferrerId the primary key of the current analytics referrer
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics referrer
	* @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	*/
	public AnalyticsReferrer[] findByR_R_PrevAndNext(long analyticsReferrerId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException;

	/**
	* Removes all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	*/
	public void removeByR_R(java.lang.String referrerClassName,
		long referrerClassPK);

	/**
	* Returns the number of analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the number of matching analytics referrers
	*/
	public int countByR_R(java.lang.String referrerClassName,
		long referrerClassPK);

	/**
	* Returns all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByA_R_R(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK);

	/**
	* Returns a range of all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByA_R_R(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end);

	/**
	* Returns an ordered range of all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByA_R_R(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns an ordered range of all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByA_R_R(
		long analyticsEventId, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics referrer
	* @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer findByA_R_R_First(long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException;

	/**
	* Returns the first analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer fetchByA_R_R_First(long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns the last analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics referrer
	* @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer findByA_R_R_Last(long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException;

	/**
	* Returns the last analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	*/
	public AnalyticsReferrer fetchByA_R_R_Last(long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns the analytics referrers before and after the current analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsReferrerId the primary key of the current analytics referrer
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics referrer
	* @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	*/
	public AnalyticsReferrer[] findByA_R_R_PrevAndNext(
		long analyticsReferrerId, long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException;

	/**
	* Returns all the analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventIds the analytics event IDs
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByA_R_R(
		long[] analyticsEventIds, java.lang.String referrerClassName,
		long referrerClassPK);

	/**
	* Returns a range of all the analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventIds the analytics event IDs
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByA_R_R(
		long[] analyticsEventIds, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end);

	/**
	* Returns an ordered range of all the analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventIds the analytics event IDs
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByA_R_R(
		long[] analyticsEventIds, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns an ordered range of all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findByA_R_R(
		long[] analyticsEventIds, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	*/
	public void removeByA_R_R(long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK);

	/**
	* Returns the number of analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventId the analytics event ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the number of matching analytics referrers
	*/
	public int countByA_R_R(long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK);

	/**
	* Returns the number of analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param analyticsEventIds the analytics event IDs
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the number of matching analytics referrers
	*/
	public int countByA_R_R(long[] analyticsEventIds,
		java.lang.String referrerClassName, long referrerClassPK);

	/**
	* Caches the analytics referrer in the entity cache if it is enabled.
	*
	* @param analyticsReferrer the analytics referrer
	*/
	public void cacheResult(AnalyticsReferrer analyticsReferrer);

	/**
	* Caches the analytics referrers in the entity cache if it is enabled.
	*
	* @param analyticsReferrers the analytics referrers
	*/
	public void cacheResult(
		java.util.List<AnalyticsReferrer> analyticsReferrers);

	/**
	* Creates a new analytics referrer with the primary key. Does not add the analytics referrer to the database.
	*
	* @param analyticsReferrerId the primary key for the new analytics referrer
	* @return the new analytics referrer
	*/
	public AnalyticsReferrer create(long analyticsReferrerId);

	/**
	* Removes the analytics referrer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer that was removed
	* @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	*/
	public AnalyticsReferrer remove(long analyticsReferrerId)
		throws NoSuchAnalyticsReferrerException;

	public AnalyticsReferrer updateImpl(AnalyticsReferrer analyticsReferrer);

	/**
	* Returns the analytics referrer with the primary key or throws a {@link NoSuchAnalyticsReferrerException} if it could not be found.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer
	* @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	*/
	public AnalyticsReferrer findByPrimaryKey(long analyticsReferrerId)
		throws NoSuchAnalyticsReferrerException;

	/**
	* Returns the analytics referrer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer, or <code>null</code> if a analytics referrer with the primary key could not be found
	*/
	public AnalyticsReferrer fetchByPrimaryKey(long analyticsReferrerId);

	@Override
	public java.util.Map<java.io.Serializable, AnalyticsReferrer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the analytics referrers.
	*
	* @return the analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findAll();

	/**
	* Returns a range of all the analytics referrers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findAll(int start, int end);

	/**
	* Returns an ordered range of all the analytics referrers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator);

	/**
	* Returns an ordered range of all the analytics referrers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of analytics referrers
	*/
	public java.util.List<AnalyticsReferrer> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsReferrer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the analytics referrers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of analytics referrers.
	*
	* @return the number of analytics referrers
	*/
	public int countAll();
}