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

package com.liferay.analytics.service.persistence;

import com.liferay.analytics.model.AnalyticsEvent;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the analytics event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventPersistenceImpl
 * @see AnalyticsEventUtil
 * @generated
 */
public interface AnalyticsEventPersistence extends BasePersistence<AnalyticsEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnalyticsEventUtil} to access the analytics event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the analytics events where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the analytics events where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the analytics events where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where companyId = &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent[] findByCompanyId_PrevAndNext(
		long analyticsEventId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the analytics events where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of analytics events where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_GtD(
		long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_GtD(
		long companyId, java.util.Date createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_GtD(
		long companyId, java.util.Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByC_GtD_First(
		long companyId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByC_GtD_First(
		long companyId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByC_GtD_Last(
		long companyId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByC_GtD_Last(
		long companyId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent[] findByC_GtD_PrevAndNext(
		long analyticsEventId, long companyId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the analytics events where companyId = &#63; and createDate &gt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_GtD(long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the number of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_GtD(long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_LtD(
		long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_LtD(
		long companyId, java.util.Date createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_LtD(
		long companyId, java.util.Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByC_LtD_First(
		long companyId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByC_LtD_First(
		long companyId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByC_LtD_Last(
		long companyId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByC_LtD_Last(
		long companyId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent[] findByC_LtD_PrevAndNext(
		long analyticsEventId, long companyId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the analytics events where companyId = &#63; and createDate &lt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_LtD(long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the number of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_LtD(long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @return the matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		java.util.Date createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		java.util.Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByC_C_E_GtD_First(
		java.lang.String className, long classPK, java.lang.String eventType,
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByC_C_E_GtD_First(
		java.lang.String className, long classPK, java.lang.String eventType,
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByC_C_E_GtD_Last(
		java.lang.String className, long classPK, java.lang.String eventType,
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByC_C_E_GtD_Last(
		java.lang.String className, long classPK, java.lang.String eventType,
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	* @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent[] findByC_C_E_GtD_PrevAndNext(
		long analyticsEventId, java.lang.String className, long classPK,
		java.lang.String eventType, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_E_GtD(java.lang.String className, long classPK,
		java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @return the number of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_E_GtD(java.lang.String className, long classPK,
		java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the analytics events where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param createDate the create date
	* @return the matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_C_R_R_E_GtD(
		java.lang.String className, long classPK,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the analytics events where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_C_R_R_E_GtD(
		java.lang.String className, long classPK,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findByC_C_R_R_E_GtD(
		java.lang.String className, long classPK,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByC_C_R_R_E_GtD_First(
		java.lang.String className, long classPK,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByC_C_R_R_E_GtD_First(
		java.lang.String className, long classPK,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByC_C_R_R_E_GtD_Last(
		java.lang.String className, long classPK,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByC_C_R_R_E_GtD_Last(
		java.lang.String className, long classPK,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param className the class name
	* @param classPK the class p k
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent[] findByC_C_R_R_E_GtD_PrevAndNext(
		long analyticsEventId, java.lang.String className, long classPK,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the analytics events where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param createDate the create date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_R_R_E_GtD(java.lang.String className, long classPK,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of analytics events where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param eventType the event type
	* @param createDate the create date
	* @return the number of matching analytics events
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_R_R_E_GtD(java.lang.String className, long classPK,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the analytics event in the entity cache if it is enabled.
	*
	* @param analyticsEvent the analytics event
	*/
	public void cacheResult(
		com.liferay.analytics.model.AnalyticsEvent analyticsEvent);

	/**
	* Caches the analytics events in the entity cache if it is enabled.
	*
	* @param analyticsEvents the analytics events
	*/
	public void cacheResult(
		java.util.List<com.liferay.analytics.model.AnalyticsEvent> analyticsEvents);

	/**
	* Creates a new analytics event with the primary key. Does not add the analytics event to the database.
	*
	* @param analyticsEventId the primary key for the new analytics event
	* @return the new analytics event
	*/
	public com.liferay.analytics.model.AnalyticsEvent create(
		long analyticsEventId);

	/**
	* Removes the analytics event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event that was removed
	* @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent remove(
		long analyticsEventId)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.analytics.model.AnalyticsEvent updateImpl(
		com.liferay.analytics.model.AnalyticsEvent analyticsEvent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the analytics event with the primary key or throws a {@link com.liferay.analytics.NoSuchEventException} if it could not be found.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event
	* @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent findByPrimaryKey(
		long analyticsEventId)
		throws com.liferay.analytics.NoSuchEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the analytics event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event, or <code>null</code> if a analytics event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.analytics.model.AnalyticsEvent fetchByPrimaryKey(
		long analyticsEventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the analytics events.
	*
	* @return the analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the analytics events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the analytics events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of analytics events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.analytics.model.AnalyticsEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the analytics events from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of analytics events.
	*
	* @return the number of analytics events
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}