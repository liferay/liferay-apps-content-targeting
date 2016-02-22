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

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the c t action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.impl.CTActionPersistenceImpl
 * @see CTActionUtil
 * @generated
 */
@ProviderType
public interface CTActionPersistence extends BasePersistence<CTAction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CTActionUtil} to access the c t action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the c t actions where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching c t actions
	*/
	public java.util.List<CTAction> findByCampaignId(long campaignId);

	/**
	* Returns a range of all the c t actions where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of matching c t actions
	*/
	public java.util.List<CTAction> findByCampaignId(long campaignId,
		int start, int end);

	/**
	* Returns an ordered range of all the c t actions where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t actions
	*/
	public java.util.List<CTAction> findByCampaignId(long campaignId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns an ordered range of all the c t actions where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c t actions
	*/
	public java.util.List<CTAction> findByCampaignId(long campaignId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByCampaignId_First(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByCampaignId_First(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByCampaignId_Last(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByCampaignId_Last(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns the c t actions before and after the current c t action in the ordered set where campaignId = &#63;.
	*
	* @param CTActionId the primary key of the current c t action
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public CTAction[] findByCampaignId_PrevAndNext(long CTActionId,
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Removes all the c t actions where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	*/
	public void removeByCampaignId(long campaignId);

	/**
	* Returns the number of c t actions where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching c t actions
	*/
	public int countByCampaignId(long campaignId);

	/**
	* Returns all the c t actions where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @return the matching c t actions
	*/
	public java.util.List<CTAction> findByReportInstanceId(
		long reportInstanceId);

	/**
	* Returns a range of all the c t actions where reportInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of matching c t actions
	*/
	public java.util.List<CTAction> findByReportInstanceId(
		long reportInstanceId, int start, int end);

	/**
	* Returns an ordered range of all the c t actions where reportInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t actions
	*/
	public java.util.List<CTAction> findByReportInstanceId(
		long reportInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns an ordered range of all the c t actions where reportInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c t actions
	*/
	public java.util.List<CTAction> findByReportInstanceId(
		long reportInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByReportInstanceId_First(long reportInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByReportInstanceId_First(long reportInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByReportInstanceId_Last(long reportInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByReportInstanceId_Last(long reportInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns the c t actions before and after the current c t action in the ordered set where reportInstanceId = &#63;.
	*
	* @param CTActionId the primary key of the current c t action
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public CTAction[] findByReportInstanceId_PrevAndNext(long CTActionId,
		long reportInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Removes all the c t actions where reportInstanceId = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	*/
	public void removeByReportInstanceId(long reportInstanceId);

	/**
	* Returns the number of c t actions where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @return the number of matching c t actions
	*/
	public int countByReportInstanceId(long reportInstanceId);

	/**
	* Returns all the c t actions where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @return the matching c t actions
	*/
	public java.util.List<CTAction> findByR_E(long reportInstanceId,
		java.lang.String elementId);

	/**
	* Returns a range of all the c t actions where reportInstanceId = &#63; and elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of matching c t actions
	*/
	public java.util.List<CTAction> findByR_E(long reportInstanceId,
		java.lang.String elementId, int start, int end);

	/**
	* Returns an ordered range of all the c t actions where reportInstanceId = &#63; and elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t actions
	*/
	public java.util.List<CTAction> findByR_E(long reportInstanceId,
		java.lang.String elementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns an ordered range of all the c t actions where reportInstanceId = &#63; and elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c t actions
	*/
	public java.util.List<CTAction> findByR_E(long reportInstanceId,
		java.lang.String elementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByR_E_First(long reportInstanceId,
		java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByR_E_First(long reportInstanceId,
		java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByR_E_Last(long reportInstanceId,
		java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByR_E_Last(long reportInstanceId,
		java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns the c t actions before and after the current c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param CTActionId the primary key of the current c t action
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public CTAction[] findByR_E_PrevAndNext(long CTActionId,
		long reportInstanceId, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Removes all the c t actions where reportInstanceId = &#63; and elementId = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	*/
	public void removeByR_E(long reportInstanceId, java.lang.String elementId);

	/**
	* Returns the number of c t actions where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @return the number of matching c t actions
	*/
	public int countByR_E(long reportInstanceId, java.lang.String elementId);

	/**
	* Returns all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @return the matching c t actions
	*/
	public java.util.List<CTAction> findByR_GtD(long reportInstanceId,
		Date modifiedDate);

	/**
	* Returns a range of all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of matching c t actions
	*/
	public java.util.List<CTAction> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end);

	/**
	* Returns an ordered range of all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t actions
	*/
	public java.util.List<CTAction> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns an ordered range of all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c t actions
	*/
	public java.util.List<CTAction> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByR_GtD_First(long reportInstanceId, Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByR_GtD_First(long reportInstanceId,
		Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByR_GtD_Last(long reportInstanceId, Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByR_GtD_Last(long reportInstanceId, Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns the c t actions before and after the current c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param CTActionId the primary key of the current c t action
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public CTAction[] findByR_GtD_PrevAndNext(long CTActionId,
		long reportInstanceId, Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Removes all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	*/
	public void removeByR_GtD(long reportInstanceId, Date modifiedDate);

	/**
	* Returns the number of c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @return the number of matching c t actions
	*/
	public int countByR_GtD(long reportInstanceId, Date modifiedDate);

	/**
	* Returns all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the matching c t actions
	*/
	public java.util.List<CTAction> findByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK);

	/**
	* Returns a range of all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of matching c t actions
	*/
	public java.util.List<CTAction> findByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end);

	/**
	* Returns an ordered range of all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t actions
	*/
	public java.util.List<CTAction> findByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns an ordered range of all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c t actions
	*/
	public java.util.List<CTAction> findByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByR_R_R_First(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByR_R_R_First(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByR_R_R_Last(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByR_R_R_Last(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns the c t actions before and after the current c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param CTActionId the primary key of the current c t action
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public CTAction[] findByR_R_R_PrevAndNext(long CTActionId,
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException;

	/**
	* Removes all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	*/
	public void removeByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK);

	/**
	* Returns the number of c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the number of matching c t actions
	*/
	public int countByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK);

	/**
	* Returns the c t action where reportInstanceId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link NoSuchCTActionException} if it could not be found.
	*
	* @param reportInstanceId the report instance ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public CTAction findByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType) throws NoSuchCTActionException;

	/**
	* Returns the c t action where reportInstanceId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param reportInstanceId the report instance ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType);

	/**
	* Returns the c t action where reportInstanceId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param reportInstanceId the report instance ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public CTAction fetchByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, boolean retrieveFromCache);

	/**
	* Removes the c t action where reportInstanceId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the c t action that was removed
	*/
	public CTAction removeByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType) throws NoSuchCTActionException;

	/**
	* Returns the number of c t actions where reportInstanceId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the number of matching c t actions
	*/
	public int countByR_U_R_R_E_E(long reportInstanceId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType);

	/**
	* Caches the c t action in the entity cache if it is enabled.
	*
	* @param ctAction the c t action
	*/
	public void cacheResult(CTAction ctAction);

	/**
	* Caches the c t actions in the entity cache if it is enabled.
	*
	* @param ctActions the c t actions
	*/
	public void cacheResult(java.util.List<CTAction> ctActions);

	/**
	* Creates a new c t action with the primary key. Does not add the c t action to the database.
	*
	* @param CTActionId the primary key for the new c t action
	* @return the new c t action
	*/
	public CTAction create(long CTActionId);

	/**
	* Removes the c t action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action that was removed
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public CTAction remove(long CTActionId) throws NoSuchCTActionException;

	public CTAction updateImpl(CTAction ctAction);

	/**
	* Returns the c t action with the primary key or throws a {@link NoSuchCTActionException} if it could not be found.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public CTAction findByPrimaryKey(long CTActionId)
		throws NoSuchCTActionException;

	/**
	* Returns the c t action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action, or <code>null</code> if a c t action with the primary key could not be found
	*/
	public CTAction fetchByPrimaryKey(long CTActionId);

	@Override
	public java.util.Map<java.io.Serializable, CTAction> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the c t actions.
	*
	* @return the c t actions
	*/
	public java.util.List<CTAction> findAll();

	/**
	* Returns a range of all the c t actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of c t actions
	*/
	public java.util.List<CTAction> findAll(int start, int end);

	/**
	* Returns an ordered range of all the c t actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of c t actions
	*/
	public java.util.List<CTAction> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator);

	/**
	* Returns an ordered range of all the c t actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of c t actions
	*/
	public java.util.List<CTAction> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the c t actions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of c t actions.
	*
	* @return the number of c t actions
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}