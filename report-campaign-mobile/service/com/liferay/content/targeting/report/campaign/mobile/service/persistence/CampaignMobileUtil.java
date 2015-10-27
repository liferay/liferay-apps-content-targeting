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

package com.liferay.content.targeting.report.campaign.mobile.service.persistence;

import com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the campaign mobile service. This utility wraps {@link CampaignMobilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignMobilePersistence
 * @see CampaignMobilePersistenceImpl
 * @generated
 */
public class CampaignMobileUtil {
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
	public static void clearCache(CampaignMobile campaignMobile) {
		getPersistence().clearCache(campaignMobile);
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
	public static List<CampaignMobile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CampaignMobile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CampaignMobile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CampaignMobile update(CampaignMobile campaignMobile)
		throws SystemException {
		return getPersistence().update(campaignMobile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CampaignMobile update(CampaignMobile campaignMobile,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(campaignMobile, serviceContext);
	}

	/**
	* Returns all the campaign mobiles where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(campaignId);
	}

	/**
	* Returns a range of all the campaign mobiles where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign mobiles
	* @param end the upper bound of the range of campaign mobiles (not inclusive)
	* @return the range of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(campaignId, start, end);
	}

	/**
	* Returns an ordered range of all the campaign mobiles where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign mobiles
	* @param end the upper bound of the range of campaign mobiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator);
	}

	/**
	* Returns the first campaign mobile in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first campaign mobile in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last campaign mobile in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last campaign mobile in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the campaign mobiles before and after the current campaign mobile in the ordered set where campaignId = &#63;.
	*
	* @param campaignMobileId the primary key of the current campaign mobile
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile[] findByCampaignId_PrevAndNext(
		long campaignMobileId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(campaignMobileId, campaignId,
			orderByComparator);
	}

	/**
	* Removes all the campaign mobiles where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignId(campaignId);
	}

	/**
	* Returns the number of campaign mobiles where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignId(campaignId);
	}

	/**
	* Returns all the campaign mobiles where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByEventType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEventType(eventType);
	}

	/**
	* Returns a range of all the campaign mobiles where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of campaign mobiles
	* @param end the upper bound of the range of campaign mobiles (not inclusive)
	* @return the range of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByEventType(
		java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEventType(eventType, start, end);
	}

	/**
	* Returns an ordered range of all the campaign mobiles where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of campaign mobiles
	* @param end the upper bound of the range of campaign mobiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByEventType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventType(eventType, start, end, orderByComparator);
	}

	/**
	* Returns the first campaign mobile in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventType_First(eventType, orderByComparator);
	}

	/**
	* Returns the first campaign mobile in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventType_First(eventType, orderByComparator);
	}

	/**
	* Returns the last campaign mobile in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventType_Last(eventType, orderByComparator);
	}

	/**
	* Returns the last campaign mobile in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventType_Last(eventType, orderByComparator);
	}

	/**
	* Returns the campaign mobiles before and after the current campaign mobile in the ordered set where eventType = &#63;.
	*
	* @param campaignMobileId the primary key of the current campaign mobile
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile[] findByEventType_PrevAndNext(
		long campaignMobileId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventType_PrevAndNext(campaignMobileId, eventType,
			orderByComparator);
	}

	/**
	* Removes all the campaign mobiles where eventType = &#63; from the database.
	*
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEventType(eventType);
	}

	/**
	* Returns the number of campaign mobiles where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEventType(eventType);
	}

	/**
	* Returns all the campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByC_GtD(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_GtD(campaignId, modifiedDate);
	}

	/**
	* Returns a range of all the campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of campaign mobiles
	* @param end the upper bound of the range of campaign mobiles (not inclusive)
	* @return the range of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_GtD(campaignId, modifiedDate, start, end);
	}

	/**
	* Returns an ordered range of all the campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of campaign mobiles
	* @param end the upper bound of the range of campaign mobiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD(campaignId, modifiedDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_First(campaignId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the first campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_GtD_First(campaignId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_Last(campaignId, modifiedDate, orderByComparator);
	}

	/**
	* Returns the last campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_GtD_Last(campaignId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the campaign mobiles before and after the current campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignMobileId the primary key of the current campaign mobile
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile[] findByC_GtD_PrevAndNext(
		long campaignMobileId, long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_PrevAndNext(campaignMobileId, campaignId,
			modifiedDate, orderByComparator);
	}

	/**
	* Removes all the campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
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
	* Returns the number of campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the number of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_GtD(campaignId, modifiedDate);
	}

	/**
	* Returns the campaign mobile where campaignId = &#63; and consumerId = &#63; and placeholderId = &#63; and userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param consumerId the consumer ID
	* @param placeholderId the placeholder ID
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByC_C_P_U_C_C_E(
		long campaignId, long consumerId, long placeholderId,
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_P_U_C_C_E(campaignId, consumerId, placeholderId,
			userSegmentId, className, classPK, eventType);
	}

	/**
	* Returns the campaign mobile where campaignId = &#63; and consumerId = &#63; and placeholderId = &#63; and userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param consumerId the consumer ID
	* @param placeholderId the placeholder ID
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByC_C_P_U_C_C_E(
		long campaignId, long consumerId, long placeholderId,
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_P_U_C_C_E(campaignId, consumerId, placeholderId,
			userSegmentId, className, classPK, eventType);
	}

	/**
	* Returns the campaign mobile where campaignId = &#63; and consumerId = &#63; and placeholderId = &#63; and userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param consumerId the consumer ID
	* @param placeholderId the placeholder ID
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByC_C_P_U_C_C_E(
		long campaignId, long consumerId, long placeholderId,
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_P_U_C_C_E(campaignId, consumerId, placeholderId,
			userSegmentId, className, classPK, eventType, retrieveFromCache);
	}

	/**
	* Removes the campaign mobile where campaignId = &#63; and consumerId = &#63; and placeholderId = &#63; and userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param consumerId the consumer ID
	* @param placeholderId the placeholder ID
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the campaign mobile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile removeByC_C_P_U_C_C_E(
		long campaignId, long consumerId, long placeholderId,
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByC_C_P_U_C_C_E(campaignId, consumerId,
			placeholderId, userSegmentId, className, classPK, eventType);
	}

	/**
	* Returns the number of campaign mobiles where campaignId = &#63; and consumerId = &#63; and placeholderId = &#63; and userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param consumerId the consumer ID
	* @param placeholderId the placeholder ID
	* @param userSegmentId the user segment ID
	* @param className the class name
	* @param classPK the class p k
	* @param eventType the event type
	* @return the number of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_P_U_C_C_E(long campaignId, long consumerId,
		long placeholderId, long userSegmentId, java.lang.String className,
		long classPK, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_C_P_U_C_C_E(campaignId, consumerId, placeholderId,
			userSegmentId, className, classPK, eventType);
	}

	/**
	* Caches the campaign mobile in the entity cache if it is enabled.
	*
	* @param campaignMobile the campaign mobile
	*/
	public static void cacheResult(
		com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile campaignMobile) {
		getPersistence().cacheResult(campaignMobile);
	}

	/**
	* Caches the campaign mobiles in the entity cache if it is enabled.
	*
	* @param campaignMobiles the campaign mobiles
	*/
	public static void cacheResult(
		java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> campaignMobiles) {
		getPersistence().cacheResult(campaignMobiles);
	}

	/**
	* Creates a new campaign mobile with the primary key. Does not add the campaign mobile to the database.
	*
	* @param campaignMobileId the primary key for the new campaign mobile
	* @return the new campaign mobile
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile create(
		long campaignMobileId) {
		return getPersistence().create(campaignMobileId);
	}

	/**
	* Removes the campaign mobile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignMobileId the primary key of the campaign mobile
	* @return the campaign mobile that was removed
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile remove(
		long campaignMobileId)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(campaignMobileId);
	}

	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile updateImpl(
		com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile campaignMobile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(campaignMobile);
	}

	/**
	* Returns the campaign mobile with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException} if it could not be found.
	*
	* @param campaignMobileId the primary key of the campaign mobile
	* @return the campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByPrimaryKey(
		long campaignMobileId)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(campaignMobileId);
	}

	/**
	* Returns the campaign mobile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignMobileId the primary key of the campaign mobile
	* @return the campaign mobile, or <code>null</code> if a campaign mobile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByPrimaryKey(
		long campaignMobileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(campaignMobileId);
	}

	/**
	* Returns all the campaign mobiles.
	*
	* @return the campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the campaign mobiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign mobiles
	* @param end the upper bound of the range of campaign mobiles (not inclusive)
	* @return the range of campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the campaign mobiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign mobiles
	* @param end the upper bound of the range of campaign mobiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the campaign mobiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of campaign mobiles.
	*
	* @return the number of campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CampaignMobilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CampaignMobilePersistence)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.report.campaign.mobile.service.ClpSerializer.getServletContextName(),
					CampaignMobilePersistence.class.getName());

			ReferenceRegistry.registerReference(CampaignMobileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CampaignMobilePersistence persistence) {
	}

	private static CampaignMobilePersistence _persistence;
}