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

import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the c t action service. This utility wraps {@link com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.impl.CTActionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionPersistence
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.impl.CTActionPersistenceImpl
 * @generated
 */
@ProviderType
public class CTActionUtil {
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
	public static void clearCache(CTAction ctAction) {
		getPersistence().clearCache(ctAction);
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
	public static List<CTAction> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CTAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CTAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CTAction update(CTAction ctAction) {
		return getPersistence().update(ctAction);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CTAction update(CTAction ctAction,
		ServiceContext serviceContext) {
		return getPersistence().update(ctAction, serviceContext);
	}

	/**
	* Returns all the c t actions where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching c t actions
	*/
	public static List<CTAction> findByCampaignId(long campaignId) {
		return getPersistence().findByCampaignId(campaignId);
	}

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
	public static List<CTAction> findByCampaignId(long campaignId, int start,
		int end) {
		return getPersistence().findByCampaignId(campaignId, start, end);
	}

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
	public static List<CTAction> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator);
	}

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
	public static List<CTAction> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public static CTAction findByCampaignId_First(long campaignId,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public static CTAction fetchByCampaignId_First(long campaignId,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public static CTAction findByCampaignId_Last(long campaignId,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public static CTAction fetchByCampaignId_Last(long campaignId,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .fetchByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the c t actions before and after the current c t action in the ordered set where campaignId = &#63;.
	*
	* @param CTActionId the primary key of the current c t action
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public static CTAction[] findByCampaignId_PrevAndNext(long CTActionId,
		long campaignId, OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(CTActionId, campaignId,
			orderByComparator);
	}

	/**
	* Removes all the c t actions where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	*/
	public static void removeByCampaignId(long campaignId) {
		getPersistence().removeByCampaignId(campaignId);
	}

	/**
	* Returns the number of c t actions where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching c t actions
	*/
	public static int countByCampaignId(long campaignId) {
		return getPersistence().countByCampaignId(campaignId);
	}

	/**
	* Returns all the c t actions where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @return the matching c t actions
	*/
	public static List<CTAction> findByReportInstanceId(long reportInstanceId) {
		return getPersistence().findByReportInstanceId(reportInstanceId);
	}

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
	public static List<CTAction> findByReportInstanceId(long reportInstanceId,
		int start, int end) {
		return getPersistence()
				   .findByReportInstanceId(reportInstanceId, start, end);
	}

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
	public static List<CTAction> findByReportInstanceId(long reportInstanceId,
		int start, int end, OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .findByReportInstanceId(reportInstanceId, start, end,
			orderByComparator);
	}

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
	public static List<CTAction> findByReportInstanceId(long reportInstanceId,
		int start, int end, OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByReportInstanceId(reportInstanceId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public static CTAction findByReportInstanceId_First(long reportInstanceId,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByReportInstanceId_First(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public static CTAction fetchByReportInstanceId_First(
		long reportInstanceId, OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .fetchByReportInstanceId_First(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public static CTAction findByReportInstanceId_Last(long reportInstanceId,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByReportInstanceId_Last(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public static CTAction fetchByReportInstanceId_Last(long reportInstanceId,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .fetchByReportInstanceId_Last(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the c t actions before and after the current c t action in the ordered set where reportInstanceId = &#63;.
	*
	* @param CTActionId the primary key of the current c t action
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public static CTAction[] findByReportInstanceId_PrevAndNext(
		long CTActionId, long reportInstanceId,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByReportInstanceId_PrevAndNext(CTActionId,
			reportInstanceId, orderByComparator);
	}

	/**
	* Removes all the c t actions where reportInstanceId = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	*/
	public static void removeByReportInstanceId(long reportInstanceId) {
		getPersistence().removeByReportInstanceId(reportInstanceId);
	}

	/**
	* Returns the number of c t actions where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @return the number of matching c t actions
	*/
	public static int countByReportInstanceId(long reportInstanceId) {
		return getPersistence().countByReportInstanceId(reportInstanceId);
	}

	/**
	* Returns all the c t actions where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @return the matching c t actions
	*/
	public static List<CTAction> findByR_E(long reportInstanceId,
		java.lang.String elementId) {
		return getPersistence().findByR_E(reportInstanceId, elementId);
	}

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
	public static List<CTAction> findByR_E(long reportInstanceId,
		java.lang.String elementId, int start, int end) {
		return getPersistence()
				   .findByR_E(reportInstanceId, elementId, start, end);
	}

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
	public static List<CTAction> findByR_E(long reportInstanceId,
		java.lang.String elementId, int start, int end,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .findByR_E(reportInstanceId, elementId, start, end,
			orderByComparator);
	}

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
	public static List<CTAction> findByR_E(long reportInstanceId,
		java.lang.String elementId, int start, int end,
		OrderByComparator<CTAction> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByR_E(reportInstanceId, elementId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public static CTAction findByR_E_First(long reportInstanceId,
		java.lang.String elementId,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByR_E_First(reportInstanceId, elementId,
			orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public static CTAction fetchByR_E_First(long reportInstanceId,
		java.lang.String elementId,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .fetchByR_E_First(reportInstanceId, elementId,
			orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public static CTAction findByR_E_Last(long reportInstanceId,
		java.lang.String elementId,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByR_E_Last(reportInstanceId, elementId,
			orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public static CTAction fetchByR_E_Last(long reportInstanceId,
		java.lang.String elementId,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .fetchByR_E_Last(reportInstanceId, elementId,
			orderByComparator);
	}

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
	public static CTAction[] findByR_E_PrevAndNext(long CTActionId,
		long reportInstanceId, java.lang.String elementId,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByR_E_PrevAndNext(CTActionId, reportInstanceId,
			elementId, orderByComparator);
	}

	/**
	* Removes all the c t actions where reportInstanceId = &#63; and elementId = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	*/
	public static void removeByR_E(long reportInstanceId,
		java.lang.String elementId) {
		getPersistence().removeByR_E(reportInstanceId, elementId);
	}

	/**
	* Returns the number of c t actions where reportInstanceId = &#63; and elementId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param elementId the element ID
	* @return the number of matching c t actions
	*/
	public static int countByR_E(long reportInstanceId,
		java.lang.String elementId) {
		return getPersistence().countByR_E(reportInstanceId, elementId);
	}

	/**
	* Returns all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @return the matching c t actions
	*/
	public static List<CTAction> findByR_GtD(long reportInstanceId,
		Date modifiedDate) {
		return getPersistence().findByR_GtD(reportInstanceId, modifiedDate);
	}

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
	public static List<CTAction> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end) {
		return getPersistence()
				   .findByR_GtD(reportInstanceId, modifiedDate, start, end);
	}

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
	public static List<CTAction> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .findByR_GtD(reportInstanceId, modifiedDate, start, end,
			orderByComparator);
	}

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
	public static List<CTAction> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end,
		OrderByComparator<CTAction> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByR_GtD(reportInstanceId, modifiedDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public static CTAction findByR_GtD_First(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByR_GtD_First(reportInstanceId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public static CTAction fetchByR_GtD_First(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .fetchByR_GtD_First(reportInstanceId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws NoSuchCTActionException if a matching c t action could not be found
	*/
	public static CTAction findByR_GtD_Last(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByR_GtD_Last(reportInstanceId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public static CTAction fetchByR_GtD_Last(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .fetchByR_GtD_Last(reportInstanceId, modifiedDate,
			orderByComparator);
	}

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
	public static CTAction[] findByR_GtD_PrevAndNext(long CTActionId,
		long reportInstanceId, Date modifiedDate,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByR_GtD_PrevAndNext(CTActionId, reportInstanceId,
			modifiedDate, orderByComparator);
	}

	/**
	* Removes all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	*/
	public static void removeByR_GtD(long reportInstanceId, Date modifiedDate) {
		getPersistence().removeByR_GtD(reportInstanceId, modifiedDate);
	}

	/**
	* Returns the number of c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @return the number of matching c t actions
	*/
	public static int countByR_GtD(long reportInstanceId, Date modifiedDate) {
		return getPersistence().countByR_GtD(reportInstanceId, modifiedDate);
	}

	/**
	* Returns all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the matching c t actions
	*/
	public static List<CTAction> findByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK) {
		return getPersistence()
				   .findByR_R_R(reportInstanceId, referrerClassName,
			referrerClassPK);
	}

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
	public static List<CTAction> findByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end) {
		return getPersistence()
				   .findByR_R_R(reportInstanceId, referrerClassName,
			referrerClassPK, start, end);
	}

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
	public static List<CTAction> findByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end, OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .findByR_R_R(reportInstanceId, referrerClassName,
			referrerClassPK, start, end, orderByComparator);
	}

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
	public static List<CTAction> findByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK, int start,
		int end, OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByR_R_R(reportInstanceId, referrerClassName,
			referrerClassPK, start, end, orderByComparator, retrieveFromCache);
	}

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
	public static CTAction findByR_R_R_First(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByR_R_R_First(reportInstanceId, referrerClassName,
			referrerClassPK, orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public static CTAction fetchByR_R_R_First(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .fetchByR_R_R_First(reportInstanceId, referrerClassName,
			referrerClassPK, orderByComparator);
	}

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
	public static CTAction findByR_R_R_Last(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByR_R_R_Last(reportInstanceId, referrerClassName,
			referrerClassPK, orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	*/
	public static CTAction fetchByR_R_R_Last(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence()
				   .fetchByR_R_R_Last(reportInstanceId, referrerClassName,
			referrerClassPK, orderByComparator);
	}

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
	public static CTAction[] findByR_R_R_PrevAndNext(long CTActionId,
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK, OrderByComparator<CTAction> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByR_R_R_PrevAndNext(CTActionId, reportInstanceId,
			referrerClassName, referrerClassPK, orderByComparator);
	}

	/**
	* Removes all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	*/
	public static void removeByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK) {
		getPersistence()
			.removeByR_R_R(reportInstanceId, referrerClassName, referrerClassPK);
	}

	/**
	* Returns the number of c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the number of matching c t actions
	*/
	public static int countByR_R_R(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK) {
		return getPersistence()
				   .countByR_R_R(reportInstanceId, referrerClassName,
			referrerClassPK);
	}

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
	public static CTAction findByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .findByR_U_R_R_E_E(reportInstanceId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

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
	public static CTAction fetchByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType) {
		return getPersistence()
				   .fetchByR_U_R_R_E_E(reportInstanceId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

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
	public static CTAction fetchByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByR_U_R_R_E_E(reportInstanceId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType,
			retrieveFromCache);
	}

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
	public static CTAction removeByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence()
				   .removeByR_U_R_R_E_E(reportInstanceId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

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
	public static int countByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType) {
		return getPersistence()
				   .countByR_U_R_R_E_E(reportInstanceId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

	/**
	* Caches the c t action in the entity cache if it is enabled.
	*
	* @param ctAction the c t action
	*/
	public static void cacheResult(CTAction ctAction) {
		getPersistence().cacheResult(ctAction);
	}

	/**
	* Caches the c t actions in the entity cache if it is enabled.
	*
	* @param ctActions the c t actions
	*/
	public static void cacheResult(List<CTAction> ctActions) {
		getPersistence().cacheResult(ctActions);
	}

	/**
	* Creates a new c t action with the primary key. Does not add the c t action to the database.
	*
	* @param CTActionId the primary key for the new c t action
	* @return the new c t action
	*/
	public static CTAction create(long CTActionId) {
		return getPersistence().create(CTActionId);
	}

	/**
	* Removes the c t action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action that was removed
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public static CTAction remove(long CTActionId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence().remove(CTActionId);
	}

	public static CTAction updateImpl(CTAction ctAction) {
		return getPersistence().updateImpl(ctAction);
	}

	/**
	* Returns the c t action with the primary key or throws a {@link NoSuchCTActionException} if it could not be found.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action
	* @throws NoSuchCTActionException if a c t action with the primary key could not be found
	*/
	public static CTAction findByPrimaryKey(long CTActionId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException {
		return getPersistence().findByPrimaryKey(CTActionId);
	}

	/**
	* Returns the c t action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action, or <code>null</code> if a c t action with the primary key could not be found
	*/
	public static CTAction fetchByPrimaryKey(long CTActionId) {
		return getPersistence().fetchByPrimaryKey(CTActionId);
	}

	public static java.util.Map<java.io.Serializable, CTAction> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the c t actions.
	*
	* @return the c t actions
	*/
	public static List<CTAction> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CTAction> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CTAction> findAll(int start, int end,
		OrderByComparator<CTAction> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<CTAction> findAll(int start, int end,
		OrderByComparator<CTAction> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the c t actions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of c t actions.
	*
	* @return the number of c t actions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CTActionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CTActionPersistence, CTActionPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CTActionPersistence.class);
}