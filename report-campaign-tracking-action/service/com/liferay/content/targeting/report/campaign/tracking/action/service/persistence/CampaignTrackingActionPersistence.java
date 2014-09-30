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

import com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the campaign tracking action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingActionPersistenceImpl
 * @see CampaignTrackingActionUtil
 * @generated
 */
public interface CampaignTrackingActionPersistence extends BasePersistence<CampaignTrackingAction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignTrackingActionUtil} to access the campaign tracking action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the campaign tracking actions where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the campaign tracking actions where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @return the range of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the campaign tracking actions where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking actions before and after the current campaign tracking action in the ordered set where campaignId = &#63;.
	*
	* @param campaignTrackingActionId the primary key of the current campaign tracking action
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction[] findByCampaignId_PrevAndNext(
		long campaignTrackingActionId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign tracking actions where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign tracking actions where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign tracking actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByC_GtD(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the campaign tracking actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @return the range of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the campaign tracking actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction findByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction findByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking actions before and after the current campaign tracking action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignTrackingActionId the primary key of the current campaign tracking action
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction[] findByC_GtD_PrevAndNext(
		long campaignTrackingActionId, long campaignId,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign tracking actions where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign tracking actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the number of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign tracking actions where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @return the matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByC_E(
		long campaignId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the campaign tracking actions where campaignId = &#63; and elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @return the range of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByC_E(
		long campaignId, java.lang.String elementId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the campaign tracking actions where campaignId = &#63; and elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByC_E(
		long campaignId, java.lang.String elementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action in the ordered set where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction findByC_E_First(
		long campaignId, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action in the ordered set where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByC_E_First(
		long campaignId, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action in the ordered set where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction findByC_E_Last(
		long campaignId, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action in the ordered set where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByC_E_Last(
		long campaignId, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking actions before and after the current campaign tracking action in the ordered set where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignTrackingActionId the primary key of the current campaign tracking action
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction[] findByC_E_PrevAndNext(
		long campaignTrackingActionId, long campaignId,
		java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign tracking actions where campaignId = &#63; and elementId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_E(long campaignId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign tracking actions where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @return the number of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_E(long campaignId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign tracking actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByC_R_R(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the campaign tracking actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @return the range of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByC_R_R(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the campaign tracking actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findByC_R_R(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction findByC_R_R_First(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByC_R_R_First(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction findByC_R_R_Last(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByC_R_R_Last(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking actions before and after the current campaign tracking action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignTrackingActionId the primary key of the current campaign tracking action
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction[] findByC_R_R_PrevAndNext(
		long campaignTrackingActionId, long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign tracking actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_R_R(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign tracking actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the number of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_R_R(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction findByC_U_R_R_E_E(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByC_U_R_R_E_E(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByC_U_R_R_E_E(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the campaign tracking action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the campaign tracking action that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction removeByC_U_R_R_E_E(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign tracking actions where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the number of matching campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_U_R_R_E_E(long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the campaign tracking action in the entity cache if it is enabled.
	*
	* @param campaignTrackingAction the campaign tracking action
	*/
	public void cacheResult(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction campaignTrackingAction);

	/**
	* Caches the campaign tracking actions in the entity cache if it is enabled.
	*
	* @param campaignTrackingActions the campaign tracking actions
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> campaignTrackingActions);

	/**
	* Creates a new campaign tracking action with the primary key. Does not add the campaign tracking action to the database.
	*
	* @param campaignTrackingActionId the primary key for the new campaign tracking action
	* @return the new campaign tracking action
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction create(
		long campaignTrackingActionId);

	/**
	* Removes the campaign tracking action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingActionId the primary key of the campaign tracking action
	* @return the campaign tracking action that was removed
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction remove(
		long campaignTrackingActionId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction updateImpl(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction campaignTrackingAction)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException} if it could not be found.
	*
	* @param campaignTrackingActionId the primary key of the campaign tracking action
	* @return the campaign tracking action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction findByPrimaryKey(
		long campaignTrackingActionId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignTrackingActionId the primary key of the campaign tracking action
	* @return the campaign tracking action, or <code>null</code> if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchByPrimaryKey(
		long campaignTrackingActionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign tracking actions.
	*
	* @return the campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the campaign tracking actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @return the range of campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the campaign tracking actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign tracking actions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign tracking actions.
	*
	* @return the number of campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}