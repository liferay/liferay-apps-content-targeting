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

import com.liferay.content.targeting.analytics.model.AnalyticsEvent;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the analytics event service. This utility wraps {@link com.liferay.content.targeting.analytics.service.persistence.impl.AnalyticsEventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventPersistence
 * @see com.liferay.content.targeting.analytics.service.persistence.impl.AnalyticsEventPersistenceImpl
 * @generated
 */
@ProviderType
public class AnalyticsEventUtil {
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
	public static void clearCache(AnalyticsEvent analyticsEvent) {
		getPersistence().clearCache(analyticsEvent);
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
	public static List<AnalyticsEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnalyticsEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnalyticsEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnalyticsEvent update(AnalyticsEvent analyticsEvent) {
		return getPersistence().update(analyticsEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnalyticsEvent update(AnalyticsEvent analyticsEvent,
		ServiceContext serviceContext) {
		return getPersistence().update(analyticsEvent, serviceContext);
	}

	/**
	* Returns all the analytics events where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching analytics events
	*/
	public static List<AnalyticsEvent> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the analytics events where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByCompanyId(long companyId,
		int start, int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the analytics events where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByCompanyId(long companyId,
		int start, int end, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analytics events where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByCompanyId(long companyId,
		int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByCompanyId_First(long companyId,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByCompanyId_First(long companyId,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByCompanyId_Last(long companyId,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByCompanyId_Last(long companyId,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where companyId = &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent[] findByCompanyId_PrevAndNext(
		long analyticsEventId, long companyId,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(analyticsEventId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the analytics events where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of analytics events where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching analytics events
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_GtD(long companyId,
		Date createDate) {
		return getPersistence().findByC_GtD(companyId, createDate);
	}

	/**
	* Returns a range of all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_GtD(long companyId,
		Date createDate, int start, int end) {
		return getPersistence().findByC_GtD(companyId, createDate, start, end);
	}

	/**
	* Returns an ordered range of all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_GtD(long companyId,
		Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .findByC_GtD(companyId, createDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_GtD(long companyId,
		Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_GtD(companyId, createDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByC_GtD_First(long companyId,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_GtD_First(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByC_GtD_First(long companyId,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByC_GtD_First(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByC_GtD_Last(long companyId,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_GtD_Last(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByC_GtD_Last(long companyId,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByC_GtD_Last(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent[] findByC_GtD_PrevAndNext(
		long analyticsEventId, long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_GtD_PrevAndNext(analyticsEventId, companyId,
			createDate, orderByComparator);
	}

	/**
	* Removes all the analytics events where companyId = &#63; and createDate &gt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param createDate the create date
	*/
	public static void removeByC_GtD(long companyId, Date createDate) {
		getPersistence().removeByC_GtD(companyId, createDate);
	}

	/**
	* Returns the number of analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the number of matching analytics events
	*/
	public static int countByC_GtD(long companyId, Date createDate) {
		return getPersistence().countByC_GtD(companyId, createDate);
	}

	/**
	* Returns all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_LtD(long companyId,
		Date createDate) {
		return getPersistence().findByC_LtD(companyId, createDate);
	}

	/**
	* Returns a range of all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_LtD(long companyId,
		Date createDate, int start, int end) {
		return getPersistence().findByC_LtD(companyId, createDate, start, end);
	}

	/**
	* Returns an ordered range of all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_LtD(long companyId,
		Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .findByC_LtD(companyId, createDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_LtD(long companyId,
		Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_LtD(companyId, createDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByC_LtD_First(long companyId,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_LtD_First(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByC_LtD_First(long companyId,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByC_LtD_First(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByC_LtD_Last(long companyId,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_LtD_Last(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByC_LtD_Last(long companyId,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByC_LtD_Last(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent[] findByC_LtD_PrevAndNext(
		long analyticsEventId, long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_LtD_PrevAndNext(analyticsEventId, companyId,
			createDate, orderByComparator);
	}

	/**
	* Removes all the analytics events where companyId = &#63; and createDate &lt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param createDate the create date
	*/
	public static void removeByC_LtD(long companyId, Date createDate) {
		getPersistence().removeByC_LtD(companyId, createDate);
	}

	/**
	* Returns the number of analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the number of matching analytics events
	*/
	public static int countByC_LtD(long companyId, Date createDate) {
		return getPersistence().countByC_LtD(companyId, createDate);
	}

	/**
	* Returns all the analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @return the matching analytics events
	*/
	public static List<AnalyticsEvent> findByNotC_GtD(long classPK,
		Date createDate) {
		return getPersistence().findByNotC_GtD(classPK, createDate);
	}

	/**
	* Returns a range of all the analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByNotC_GtD(long classPK,
		Date createDate, int start, int end) {
		return getPersistence().findByNotC_GtD(classPK, createDate, start, end);
	}

	/**
	* Returns an ordered range of all the analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByNotC_GtD(long classPK,
		Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .findByNotC_GtD(classPK, createDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByNotC_GtD(long classPK,
		Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByNotC_GtD(classPK, createDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByNotC_GtD_First(long classPK,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByNotC_GtD_First(classPK, createDate, orderByComparator);
	}

	/**
	* Returns the first analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByNotC_GtD_First(long classPK,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByNotC_GtD_First(classPK, createDate, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByNotC_GtD_Last(long classPK,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByNotC_GtD_Last(classPK, createDate, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByNotC_GtD_Last(long classPK,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByNotC_GtD_Last(classPK, createDate, orderByComparator);
	}

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param classPK the class p k
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent[] findByNotC_GtD_PrevAndNext(
		long analyticsEventId, long classPK, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByNotC_GtD_PrevAndNext(analyticsEventId, classPK,
			createDate, orderByComparator);
	}

	/**
	* Removes all the analytics events where classPK &ne; &#63; and createDate &gt; &#63; from the database.
	*
	* @param classPK the class p k
	* @param createDate the create date
	*/
	public static void removeByNotC_GtD(long classPK, Date createDate) {
		getPersistence().removeByNotC_GtD(classPK, createDate);
	}

	/**
	* Returns the number of analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @return the number of matching analytics events
	*/
	public static int countByNotC_GtD(long classPK, Date createDate) {
		return getPersistence().countByNotC_GtD(classPK, createDate);
	}

	/**
	* Returns all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_C_E(java.lang.String className,
		long classPK, java.lang.String eventType) {
		return getPersistence().findByC_C_E(className, classPK, eventType);
	}

	/**
	* Returns a range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_C_E(java.lang.String className,
		long classPK, java.lang.String eventType, int start, int end) {
		return getPersistence()
				   .findByC_C_E(className, classPK, eventType, start, end);
	}

	/**
	* Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_C_E(java.lang.String className,
		long classPK, java.lang.String eventType, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .findByC_C_E(className, classPK, eventType, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_C_E(java.lang.String className,
		long classPK, java.lang.String eventType, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_C_E(className, classPK, eventType, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByC_C_E_First(java.lang.String className,
		long classPK, java.lang.String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_C_E_First(className, classPK, eventType,
			orderByComparator);
	}

	/**
	* Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByC_C_E_First(
		java.lang.String className, long classPK, java.lang.String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByC_C_E_First(className, classPK, eventType,
			orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByC_C_E_Last(java.lang.String className,
		long classPK, java.lang.String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_C_E_Last(className, classPK, eventType,
			orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByC_C_E_Last(java.lang.String className,
		long classPK, java.lang.String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByC_C_E_Last(className, classPK, eventType,
			orderByComparator);
	}

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent[] findByC_C_E_PrevAndNext(
		long analyticsEventId, java.lang.String className, long classPK,
		java.lang.String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_C_E_PrevAndNext(analyticsEventId, className,
			classPK, eventType, orderByComparator);
	}

	/**
	* Removes all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	*/
	public static void removeByC_C_E(java.lang.String className, long classPK,
		java.lang.String eventType) {
		getPersistence().removeByC_C_E(className, classPK, eventType);
	}

	/**
	* Returns the number of analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the number of matching analytics events
	*/
	public static int countByC_C_E(java.lang.String className, long classPK,
		java.lang.String eventType) {
		return getPersistence().countByC_C_E(className, classPK, eventType);
	}

	/**
	* Returns all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @return the matching analytics events
	*/
	public static List<AnalyticsEvent> findByE_E_GtD(
		java.lang.String elementId, java.lang.String eventType, Date createDate) {
		return getPersistence().findByE_E_GtD(elementId, eventType, createDate);
	}

	/**
	* Returns a range of all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByE_E_GtD(
		java.lang.String elementId, java.lang.String eventType,
		Date createDate, int start, int end) {
		return getPersistence()
				   .findByE_E_GtD(elementId, eventType, createDate, start, end);
	}

	/**
	* Returns an ordered range of all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByE_E_GtD(
		java.lang.String elementId, java.lang.String eventType,
		Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .findByE_E_GtD(elementId, eventType, createDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByE_E_GtD(
		java.lang.String elementId, java.lang.String eventType,
		Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByE_E_GtD(elementId, eventType, createDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByE_E_GtD_First(
		java.lang.String elementId, java.lang.String eventType,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByE_E_GtD_First(elementId, eventType, createDate,
			orderByComparator);
	}

	/**
	* Returns the first analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByE_E_GtD_First(
		java.lang.String elementId, java.lang.String eventType,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByE_E_GtD_First(elementId, eventType, createDate,
			orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByE_E_GtD_Last(
		java.lang.String elementId, java.lang.String eventType,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByE_E_GtD_Last(elementId, eventType, createDate,
			orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByE_E_GtD_Last(
		java.lang.String elementId, java.lang.String eventType,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByE_E_GtD_Last(elementId, eventType, createDate,
			orderByComparator);
	}

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent[] findByE_E_GtD_PrevAndNext(
		long analyticsEventId, java.lang.String elementId,
		java.lang.String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByE_E_GtD_PrevAndNext(analyticsEventId, elementId,
			eventType, createDate, orderByComparator);
	}

	/**
	* Removes all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63; from the database.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	*/
	public static void removeByE_E_GtD(java.lang.String elementId,
		java.lang.String eventType, Date createDate) {
		getPersistence().removeByE_E_GtD(elementId, eventType, createDate);
	}

	/**
	* Returns the number of analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @return the number of matching analytics events
	*/
	public static int countByE_E_GtD(java.lang.String elementId,
		java.lang.String eventType, Date createDate) {
		return getPersistence().countByE_E_GtD(elementId, eventType, createDate);
	}

	/**
	* Returns all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching analytics events
	*/
	public static List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType) {
		return getPersistence()
				   .findByA_C_C_E(anonymousUserId, className, classPK, eventType);
	}

	/**
	* Returns a range of all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		int start, int end) {
		return getPersistence()
				   .findByA_C_C_E(anonymousUserId, className, classPK,
			eventType, start, end);
	}

	/**
	* Returns an ordered range of all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		int start, int end, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .findByA_C_C_E(anonymousUserId, className, classPK,
			eventType, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByA_C_C_E(anonymousUserId, className, classPK,
			eventType, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analytics event in the ordered set where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByA_C_C_E_First(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByA_C_C_E_First(anonymousUserId, className, classPK,
			eventType, orderByComparator);
	}

	/**
	* Returns the first analytics event in the ordered set where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByA_C_C_E_First(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByA_C_C_E_First(anonymousUserId, className, classPK,
			eventType, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByA_C_C_E_Last(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByA_C_C_E_Last(anonymousUserId, className, classPK,
			eventType, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByA_C_C_E_Last(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByA_C_C_E_Last(anonymousUserId, className, classPK,
			eventType, orderByComparator);
	}

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent[] findByA_C_C_E_PrevAndNext(
		long analyticsEventId, long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByA_C_C_E_PrevAndNext(analyticsEventId,
			anonymousUserId, className, classPK, eventType, orderByComparator);
	}

	/**
	* Removes all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	*/
	public static void removeByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType) {
		getPersistence()
			.removeByA_C_C_E(anonymousUserId, className, classPK, eventType);
	}

	/**
	* Returns the number of analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the number of matching analytics events
	*/
	public static int countByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType) {
		return getPersistence()
				   .countByA_C_C_E(anonymousUserId, className, classPK,
			eventType);
	}

	/**
	* Returns all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @return the matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate) {
		return getPersistence()
				   .findByC_C_E_GtD(className, classPK, eventType, createDate);
	}

	/**
	* Returns a range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate, int start, int end) {
		return getPersistence()
				   .findByC_C_E_GtD(className, classPK, eventType, createDate,
			start, end);
	}

	/**
	* Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .findByC_C_E_GtD(className, classPK, eventType, createDate,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analytics events
	*/
	public static List<AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_C_E_GtD(className, classPK, eventType, createDate,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByC_C_E_GtD_First(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_C_E_GtD_First(className, classPK, eventType,
			createDate, orderByComparator);
	}

	/**
	* Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByC_C_E_GtD_First(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByC_C_E_GtD_First(className, classPK, eventType,
			createDate, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public static AnalyticsEvent findByC_C_E_GtD_Last(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_C_E_GtD_Last(className, classPK, eventType,
			createDate, orderByComparator);
	}

	/**
	* Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public static AnalyticsEvent fetchByC_C_E_GtD_Last(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence()
				   .fetchByC_C_E_GtD_Last(className, classPK, eventType,
			createDate, orderByComparator);
	}

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent[] findByC_C_E_GtD_PrevAndNext(
		long analyticsEventId, java.lang.String className, long classPK,
		java.lang.String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence()
				   .findByC_C_E_GtD_PrevAndNext(analyticsEventId, className,
			classPK, eventType, createDate, orderByComparator);
	}

	/**
	* Removes all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	*/
	public static void removeByC_C_E_GtD(java.lang.String className,
		long classPK, java.lang.String eventType, Date createDate) {
		getPersistence()
			.removeByC_C_E_GtD(className, classPK, eventType, createDate);
	}

	/**
	* Returns the number of analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @return the number of matching analytics events
	*/
	public static int countByC_C_E_GtD(java.lang.String className,
		long classPK, java.lang.String eventType, Date createDate) {
		return getPersistence()
				   .countByC_C_E_GtD(className, classPK, eventType, createDate);
	}

	/**
	* Caches the analytics event in the entity cache if it is enabled.
	*
	* @param analyticsEvent the analytics event
	*/
	public static void cacheResult(AnalyticsEvent analyticsEvent) {
		getPersistence().cacheResult(analyticsEvent);
	}

	/**
	* Caches the analytics events in the entity cache if it is enabled.
	*
	* @param analyticsEvents the analytics events
	*/
	public static void cacheResult(List<AnalyticsEvent> analyticsEvents) {
		getPersistence().cacheResult(analyticsEvents);
	}

	/**
	* Creates a new analytics event with the primary key. Does not add the analytics event to the database.
	*
	* @param analyticsEventId the primary key for the new analytics event
	* @return the new analytics event
	*/
	public static AnalyticsEvent create(long analyticsEventId) {
		return getPersistence().create(analyticsEventId);
	}

	/**
	* Removes the analytics event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event that was removed
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent remove(long analyticsEventId)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence().remove(analyticsEventId);
	}

	public static AnalyticsEvent updateImpl(AnalyticsEvent analyticsEvent) {
		return getPersistence().updateImpl(analyticsEvent);
	}

	/**
	* Returns the analytics event with the primary key or throws a {@link NoSuchAnalyticsEventException} if it could not be found.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent findByPrimaryKey(long analyticsEventId)
		throws com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException {
		return getPersistence().findByPrimaryKey(analyticsEventId);
	}

	/**
	* Returns the analytics event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event, or <code>null</code> if a analytics event with the primary key could not be found
	*/
	public static AnalyticsEvent fetchByPrimaryKey(long analyticsEventId) {
		return getPersistence().fetchByPrimaryKey(analyticsEventId);
	}

	public static java.util.Map<java.io.Serializable, AnalyticsEvent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the analytics events.
	*
	* @return the analytics events
	*/
	public static List<AnalyticsEvent> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the analytics events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of analytics events
	*/
	public static List<AnalyticsEvent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the analytics events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of analytics events
	*/
	public static List<AnalyticsEvent> findAll(int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analytics events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of analytics events
	*/
	public static List<AnalyticsEvent> findAll(int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the analytics events from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of analytics events.
	*
	* @return the number of analytics events
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AnalyticsEventPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnalyticsEventPersistence, AnalyticsEventPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AnalyticsEventPersistence.class);
}