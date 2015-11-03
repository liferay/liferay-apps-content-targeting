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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the campaign mobile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignMobilePersistenceImpl
 * @see CampaignMobileUtil
 * @generated
 */
public interface CampaignMobilePersistence extends BasePersistence<CampaignMobile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignMobileUtil} to access the campaign mobile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the campaign mobiles where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign mobile in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign mobile in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign mobile in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign mobile in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile[] findByCampaignId_PrevAndNext(
		long campaignMobileId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign mobiles where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign mobiles where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign mobiles where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByEventType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByEventType(
		java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByEventType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign mobile in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign mobile in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign mobile in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign mobile in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile[] findByEventType_PrevAndNext(
		long campaignMobileId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign mobiles where eventType = &#63; from the database.
	*
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign mobiles where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByC_GtD(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile[] findByC_GtD_PrevAndNext(
		long campaignMobileId, long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the number of matching campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByC_C_P_U_C_C_E(
		long campaignId, long consumerId, long placeholderId,
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByC_C_P_U_C_C_E(
		long campaignId, long consumerId, long placeholderId,
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByC_C_P_U_C_C_E(
		long campaignId, long consumerId, long placeholderId,
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile removeByC_C_P_U_C_C_E(
		long campaignId, long consumerId, long placeholderId,
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public int countByC_C_P_U_C_C_E(long campaignId, long consumerId,
		long placeholderId, long userSegmentId, java.lang.String className,
		long classPK, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the campaign mobile in the entity cache if it is enabled.
	*
	* @param campaignMobile the campaign mobile
	*/
	public void cacheResult(
		com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile campaignMobile);

	/**
	* Caches the campaign mobiles in the entity cache if it is enabled.
	*
	* @param campaignMobiles the campaign mobiles
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> campaignMobiles);

	/**
	* Creates a new campaign mobile with the primary key. Does not add the campaign mobile to the database.
	*
	* @param campaignMobileId the primary key for the new campaign mobile
	* @return the new campaign mobile
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile create(
		long campaignMobileId);

	/**
	* Removes the campaign mobile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignMobileId the primary key of the campaign mobile
	* @return the campaign mobile that was removed
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile remove(
		long campaignMobileId)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile updateImpl(
		com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile campaignMobile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign mobile with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException} if it could not be found.
	*
	* @param campaignMobileId the primary key of the campaign mobile
	* @return the campaign mobile
	* @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile findByPrimaryKey(
		long campaignMobileId)
		throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign mobile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignMobileId the primary key of the campaign mobile
	* @return the campaign mobile, or <code>null</code> if a campaign mobile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile fetchByPrimaryKey(
		long campaignMobileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign mobiles.
	*
	* @return the campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign mobiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign mobiles.
	*
	* @return the number of campaign mobiles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}