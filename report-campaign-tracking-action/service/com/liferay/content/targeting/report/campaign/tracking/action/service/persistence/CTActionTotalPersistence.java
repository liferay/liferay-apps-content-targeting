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

package com.liferay.content.targeting.report.campaign.tracking.action.service.persistence;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the c t action total service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotalPersistenceImpl
 * @see CTActionTotalUtil
 * @generated
 */
public interface CTActionTotalPersistence extends BasePersistence<CTActionTotal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CTActionTotalUtil} to access the c t action total persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the c t action totals where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c t action totals where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @return the range of matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c t action totals where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total, or <code>null</code> if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total, or <code>null</code> if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t action totals before and after the current c t action total in the ordered set where campaignId = &#63;.
	*
	* @param CTActionTotalId the primary key of the current c t action total
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal[] findByCampaignId_PrevAndNext(
		long CTActionTotalId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c t action totals where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c t action totals where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the c t action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByC_GtD(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c t action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @return the range of matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c t action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c t action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first c t action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total, or <code>null</code> if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c t action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last c t action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total, or <code>null</code> if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t action totals before and after the current c t action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param CTActionTotalId the primary key of the current c t action total
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal[] findByC_GtD_PrevAndNext(
		long CTActionTotalId, long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c t action totals where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c t action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the number of matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching c t action total, or <code>null</code> if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching c t action total, or <code>null</code> if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the c t action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the c t action total that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal removeByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c t action totals where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the number of matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_R_R_E_E(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the c t action total in the entity cache if it is enabled.
	*
	* @param ctActionTotal the c t action total
	*/
	public void cacheResult(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal);

	/**
	* Caches the c t action totals in the entity cache if it is enabled.
	*
	* @param ctActionTotals the c t action totals
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> ctActionTotals);

	/**
	* Creates a new c t action total with the primary key. Does not add the c t action total to the database.
	*
	* @param CTActionTotalId the primary key for the new c t action total
	* @return the new c t action total
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal create(
		long CTActionTotalId);

	/**
	* Removes the c t action total with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total that was removed
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal remove(
		long CTActionTotalId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal updateImpl(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t action total with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException} if it could not be found.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByPrimaryKey(
		long CTActionTotalId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the c t action total with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total, or <code>null</code> if a c t action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByPrimaryKey(
		long CTActionTotalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the c t action totals.
	*
	* @return the c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the c t action totals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @return the range of c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the c t action totals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the c t action totals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of c t action totals.
	*
	* @return the number of c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}