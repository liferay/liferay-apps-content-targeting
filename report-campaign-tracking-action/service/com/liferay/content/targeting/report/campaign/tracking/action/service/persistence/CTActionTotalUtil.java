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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the c t action total service. This utility wraps {@link CTActionTotalPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotalPersistence
 * @see CTActionTotalPersistenceImpl
 * @generated
 */
public class CTActionTotalUtil {
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
	public static void clearCache(CTActionTotal ctActionTotal) {
		getPersistence().clearCache(ctActionTotal);
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
	public static List<CTActionTotal> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CTActionTotal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CTActionTotal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CTActionTotal update(CTActionTotal ctActionTotal)
		throws SystemException {
		return getPersistence().update(ctActionTotal);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CTActionTotal update(CTActionTotal ctActionTotal,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ctActionTotal, serviceContext);
	}

	/**
	* Returns all the c t action totals where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(campaignId);
	}

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
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(campaignId, start, end);
	}

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
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator);
	}

	/**
	* Returns the first c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total, or <code>null</code> if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total, or <code>null</code> if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_Last(campaignId, orderByComparator);
	}

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
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal[] findByCampaignId_PrevAndNext(
		long CTActionTotalId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(CTActionTotalId, campaignId,
			orderByComparator);
	}

	/**
	* Removes all the c t action totals where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignId(campaignId);
	}

	/**
	* Returns the number of c t action totals where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignId(campaignId);
	}

	/**
	* Returns all the c t action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByC_GtD(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_GtD(campaignId, modifiedDate);
	}

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
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_GtD(campaignId, modifiedDate, start, end);
	}

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
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD(campaignId, modifiedDate, start, end,
			orderByComparator);
	}

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
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_First(campaignId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the first c t action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total, or <code>null</code> if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_GtD_First(campaignId, modifiedDate,
			orderByComparator);
	}

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
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_Last(campaignId, modifiedDate, orderByComparator);
	}

	/**
	* Returns the last c t action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total, or <code>null</code> if a matching c t action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_GtD_Last(campaignId, modifiedDate,
			orderByComparator);
	}

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
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal[] findByC_GtD_PrevAndNext(
		long CTActionTotalId, long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_PrevAndNext(CTActionTotalId, campaignId,
			modifiedDate, orderByComparator);
	}

	/**
	* Removes all the c t action totals where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_GtD(long campaignId,
		java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_GtD(campaignId, modifiedDate);
	}

	/**
	* Returns the number of c t action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the number of matching c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_GtD(campaignId, modifiedDate);
	}

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
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_R_E_E(campaignId, referrerClassName,
			referrerClassPK, elementId, eventType);
	}

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
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_R_E_E(campaignId, referrerClassName,
			referrerClassPK, elementId, eventType);
	}

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
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_R_E_E(campaignId, referrerClassName,
			referrerClassPK, elementId, eventType, retrieveFromCache);
	}

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
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal removeByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByC_R_R_E_E(campaignId, referrerClassName,
			referrerClassPK, elementId, eventType);
	}

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
	public static int countByC_R_R_E_E(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_R_R_E_E(campaignId, referrerClassName,
			referrerClassPK, elementId, eventType);
	}

	/**
	* Caches the c t action total in the entity cache if it is enabled.
	*
	* @param ctActionTotal the c t action total
	*/
	public static void cacheResult(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal) {
		getPersistence().cacheResult(ctActionTotal);
	}

	/**
	* Caches the c t action totals in the entity cache if it is enabled.
	*
	* @param ctActionTotals the c t action totals
	*/
	public static void cacheResult(
		java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> ctActionTotals) {
		getPersistence().cacheResult(ctActionTotals);
	}

	/**
	* Creates a new c t action total with the primary key. Does not add the c t action total to the database.
	*
	* @param CTActionTotalId the primary key for the new c t action total
	* @return the new c t action total
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal create(
		long CTActionTotalId) {
		return getPersistence().create(CTActionTotalId);
	}

	/**
	* Removes the c t action total with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total that was removed
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal remove(
		long CTActionTotalId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(CTActionTotalId);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal updateImpl(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ctActionTotal);
	}

	/**
	* Returns the c t action total with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException} if it could not be found.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal findByPrimaryKey(
		long CTActionTotalId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(CTActionTotalId);
	}

	/**
	* Returns the c t action total with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total, or <code>null</code> if a c t action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchByPrimaryKey(
		long CTActionTotalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(CTActionTotalId);
	}

	/**
	* Returns all the c t action totals.
	*
	* @return the c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the c t action totals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of c t action totals.
	*
	* @return the number of c t action totals
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CTActionTotalPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CTActionTotalPersistence)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.report.campaign.tracking.action.service.ClpSerializer.getServletContextName(),
					CTActionTotalPersistence.class.getName());

			ReferenceRegistry.registerReference(CTActionTotalUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CTActionTotalPersistence persistence) {
	}

	private static CTActionTotalPersistence _persistence;
}