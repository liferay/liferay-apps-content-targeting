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

import com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException;
import com.liferay.content.targeting.analytics.model.AnalyticsEvent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the analytics event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.analytics.service.persistence.impl.AnalyticsEventPersistenceImpl
 * @see AnalyticsEventUtil
 * @generated
 */
@ProviderType
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
	*/
	public java.util.List<AnalyticsEvent> findByCompanyId(long companyId);

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
	public java.util.List<AnalyticsEvent> findByCompanyId(long companyId,
		int start, int end);

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
	public java.util.List<AnalyticsEvent> findByCompanyId(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public java.util.List<AnalyticsEvent> findByCompanyId(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public AnalyticsEvent findByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public AnalyticsEvent findByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

	/**
	* Returns the analytics events before and after the current analytics event in the ordered set where companyId = &#63;.
	*
	* @param analyticsEventId the primary key of the current analytics event
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public AnalyticsEvent[] findByCompanyId_PrevAndNext(long analyticsEventId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Removes all the analytics events where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of analytics events where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching analytics events
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the matching analytics events
	*/
	public java.util.List<AnalyticsEvent> findByC_GtD(long companyId,
		Date createDate);

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
	public java.util.List<AnalyticsEvent> findByC_GtD(long companyId,
		Date createDate, int start, int end);

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
	public java.util.List<AnalyticsEvent> findByC_GtD(long companyId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public java.util.List<AnalyticsEvent> findByC_GtD(long companyId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public AnalyticsEvent findByC_GtD_First(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByC_GtD_First(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public AnalyticsEvent findByC_GtD_Last(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByC_GtD_Last(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent[] findByC_GtD_PrevAndNext(long analyticsEventId,
		long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Removes all the analytics events where companyId = &#63; and createDate &gt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param createDate the create date
	*/
	public void removeByC_GtD(long companyId, Date createDate);

	/**
	* Returns the number of analytics events where companyId = &#63; and createDate &gt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the number of matching analytics events
	*/
	public int countByC_GtD(long companyId, Date createDate);

	/**
	* Returns all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the matching analytics events
	*/
	public java.util.List<AnalyticsEvent> findByC_LtD(long companyId,
		Date createDate);

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
	public java.util.List<AnalyticsEvent> findByC_LtD(long companyId,
		Date createDate, int start, int end);

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
	public java.util.List<AnalyticsEvent> findByC_LtD(long companyId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public java.util.List<AnalyticsEvent> findByC_LtD(long companyId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public AnalyticsEvent findByC_LtD_First(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the first analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByC_LtD_First(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public AnalyticsEvent findByC_LtD_Last(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the last analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByC_LtD_Last(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent[] findByC_LtD_PrevAndNext(long analyticsEventId,
		long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Removes all the analytics events where companyId = &#63; and createDate &lt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param createDate the create date
	*/
	public void removeByC_LtD(long companyId, Date createDate);

	/**
	* Returns the number of analytics events where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the number of matching analytics events
	*/
	public int countByC_LtD(long companyId, Date createDate);

	/**
	* Returns all the analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @return the matching analytics events
	*/
	public java.util.List<AnalyticsEvent> findByNotC_GtD(long classPK,
		Date createDate);

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
	public java.util.List<AnalyticsEvent> findByNotC_GtD(long classPK,
		Date createDate, int start, int end);

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
	public java.util.List<AnalyticsEvent> findByNotC_GtD(long classPK,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public java.util.List<AnalyticsEvent> findByNotC_GtD(long classPK,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public AnalyticsEvent findByNotC_GtD_First(long classPK, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the first analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByNotC_GtD_First(long classPK, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

	/**
	* Returns the last analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event
	* @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	*/
	public AnalyticsEvent findByNotC_GtD_Last(long classPK, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the last analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByNotC_GtD_Last(long classPK, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent[] findByNotC_GtD_PrevAndNext(long analyticsEventId,
		long classPK, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Removes all the analytics events where classPK &ne; &#63; and createDate &gt; &#63; from the database.
	*
	* @param classPK the class p k
	* @param createDate the create date
	*/
	public void removeByNotC_GtD(long classPK, Date createDate);

	/**
	* Returns the number of analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	*
	* @param classPK the class p k
	* @param createDate the create date
	* @return the number of matching analytics events
	*/
	public int countByNotC_GtD(long classPK, Date createDate);

	/**
	* Returns all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching analytics events
	*/
	public java.util.List<AnalyticsEvent> findByC_C_E(
		java.lang.String className, long classPK, java.lang.String eventType);

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
	public java.util.List<AnalyticsEvent> findByC_C_E(
		java.lang.String className, long classPK, java.lang.String eventType,
		int start, int end);

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
	public java.util.List<AnalyticsEvent> findByC_C_E(
		java.lang.String className, long classPK, java.lang.String eventType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public java.util.List<AnalyticsEvent> findByC_C_E(
		java.lang.String className, long classPK, java.lang.String eventType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache);

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
	public AnalyticsEvent findByC_C_E_First(java.lang.String className,
		long classPK, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByC_C_E_First(java.lang.String className,
		long classPK, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent findByC_C_E_Last(java.lang.String className,
		long classPK, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByC_C_E_Last(java.lang.String className,
		long classPK, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent[] findByC_C_E_PrevAndNext(long analyticsEventId,
		java.lang.String className, long classPK, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Removes all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	*/
	public void removeByC_C_E(java.lang.String className, long classPK,
		java.lang.String eventType);

	/**
	* Returns the number of analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the number of matching analytics events
	*/
	public int countByC_C_E(java.lang.String className, long classPK,
		java.lang.String eventType);

	/**
	* Returns all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @return the matching analytics events
	*/
	public java.util.List<AnalyticsEvent> findByE_E_GtD(
		java.lang.String elementId, java.lang.String eventType, Date createDate);

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
	public java.util.List<AnalyticsEvent> findByE_E_GtD(
		java.lang.String elementId, java.lang.String eventType,
		Date createDate, int start, int end);

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
	public java.util.List<AnalyticsEvent> findByE_E_GtD(
		java.lang.String elementId, java.lang.String eventType,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public java.util.List<AnalyticsEvent> findByE_E_GtD(
		java.lang.String elementId, java.lang.String eventType,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache);

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
	public AnalyticsEvent findByE_E_GtD_First(java.lang.String elementId,
		java.lang.String eventType, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the first analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByE_E_GtD_First(java.lang.String elementId,
		java.lang.String eventType, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent findByE_E_GtD_Last(java.lang.String elementId,
		java.lang.String eventType, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the last analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	*/
	public AnalyticsEvent fetchByE_E_GtD_Last(java.lang.String elementId,
		java.lang.String eventType, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent[] findByE_E_GtD_PrevAndNext(long analyticsEventId,
		java.lang.String elementId, java.lang.String eventType,
		Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Removes all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63; from the database.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	*/
	public void removeByE_E_GtD(java.lang.String elementId,
		java.lang.String eventType, Date createDate);

	/**
	* Returns the number of analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param elementId the element ID
	* @param eventType the event type
	* @param createDate the create date
	* @return the number of matching analytics events
	*/
	public int countByE_E_GtD(java.lang.String elementId,
		java.lang.String eventType, Date createDate);

	/**
	* Returns all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching analytics events
	*/
	public java.util.List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType);

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
	public java.util.List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		int start, int end);

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
	public java.util.List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public java.util.List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache);

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
	public AnalyticsEvent findByA_C_C_E_First(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

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
	public AnalyticsEvent fetchByA_C_C_E_First(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent findByA_C_C_E_Last(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

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
	public AnalyticsEvent fetchByA_C_C_E_Last(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent[] findByA_C_C_E_PrevAndNext(long analyticsEventId,
		long anonymousUserId, java.lang.String className, long classPK,
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Removes all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	*/
	public void removeByA_C_C_E(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType);

	/**
	* Returns the number of analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the number of matching analytics events
	*/
	public int countByA_C_C_E(long anonymousUserId, java.lang.String className,
		long classPK, java.lang.String eventType);

	/**
	* Returns all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @return the matching analytics events
	*/
	public java.util.List<AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate);

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
	public java.util.List<AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate, int start, int end);

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
	public java.util.List<AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public java.util.List<AnalyticsEvent> findByC_C_E_GtD(
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache);

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
	public AnalyticsEvent findByC_C_E_GtD_First(java.lang.String className,
		long classPK, java.lang.String eventType, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

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
	public AnalyticsEvent fetchByC_C_E_GtD_First(java.lang.String className,
		long classPK, java.lang.String eventType, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent findByC_C_E_GtD_Last(java.lang.String className,
		long classPK, java.lang.String eventType, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

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
	public AnalyticsEvent fetchByC_C_E_GtD_Last(java.lang.String className,
		long classPK, java.lang.String eventType, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public AnalyticsEvent[] findByC_C_E_GtD_PrevAndNext(long analyticsEventId,
		java.lang.String className, long classPK, java.lang.String eventType,
		Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException;

	/**
	* Removes all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	*/
	public void removeByC_C_E_GtD(java.lang.String className, long classPK,
		java.lang.String eventType, Date createDate);

	/**
	* Returns the number of analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param createDate the create date
	* @return the number of matching analytics events
	*/
	public int countByC_C_E_GtD(java.lang.String className, long classPK,
		java.lang.String eventType, Date createDate);

	/**
	* Caches the analytics event in the entity cache if it is enabled.
	*
	* @param analyticsEvent the analytics event
	*/
	public void cacheResult(AnalyticsEvent analyticsEvent);

	/**
	* Caches the analytics events in the entity cache if it is enabled.
	*
	* @param analyticsEvents the analytics events
	*/
	public void cacheResult(java.util.List<AnalyticsEvent> analyticsEvents);

	/**
	* Creates a new analytics event with the primary key. Does not add the analytics event to the database.
	*
	* @param analyticsEventId the primary key for the new analytics event
	* @return the new analytics event
	*/
	public AnalyticsEvent create(long analyticsEventId);

	/**
	* Removes the analytics event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event that was removed
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public AnalyticsEvent remove(long analyticsEventId)
		throws NoSuchAnalyticsEventException;

	public AnalyticsEvent updateImpl(AnalyticsEvent analyticsEvent);

	/**
	* Returns the analytics event with the primary key or throws a {@link NoSuchAnalyticsEventException} if it could not be found.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event
	* @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	*/
	public AnalyticsEvent findByPrimaryKey(long analyticsEventId)
		throws NoSuchAnalyticsEventException;

	/**
	* Returns the analytics event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event, or <code>null</code> if a analytics event with the primary key could not be found
	*/
	public AnalyticsEvent fetchByPrimaryKey(long analyticsEventId);

	@Override
	public java.util.Map<java.io.Serializable, AnalyticsEvent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the analytics events.
	*
	* @return the analytics events
	*/
	public java.util.List<AnalyticsEvent> findAll();

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
	public java.util.List<AnalyticsEvent> findAll(int start, int end);

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
	public java.util.List<AnalyticsEvent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator);

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
	public java.util.List<AnalyticsEvent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the analytics events from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of analytics events.
	*
	* @return the number of analytics events
	*/
	public int countAll();
}