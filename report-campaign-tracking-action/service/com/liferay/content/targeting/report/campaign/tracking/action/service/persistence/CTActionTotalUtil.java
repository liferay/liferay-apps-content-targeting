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

import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the c t action total service. This utility wraps {@link com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.impl.CTActionTotalPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotalPersistence
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.impl.CTActionTotalPersistenceImpl
 * @generated
 */
@ProviderType
public class CTActionTotalUtil {
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
	public static void clearCache(CTActionTotal ctActionTotal) {
		getPersistence().clearCache(ctActionTotal);
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
	public static List<CTActionTotal> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CTActionTotal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CTActionTotal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CTActionTotal update(CTActionTotal ctActionTotal) {
		return getPersistence().update(ctActionTotal);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CTActionTotal update(CTActionTotal ctActionTotal,
		ServiceContext serviceContext) {
		return getPersistence().update(ctActionTotal, serviceContext);
	}

	/**
	* Returns all the c t action totals where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching c t action totals
	*/
	public static List<CTActionTotal> findByCampaignId(long campaignId) {
		return getPersistence().findByCampaignId(campaignId);
	}

	/**
	* Returns a range of all the c t action totals where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @return the range of matching c t action totals
	*/
	public static List<CTActionTotal> findByCampaignId(long campaignId,
		int start, int end) {
		return getPersistence().findByCampaignId(campaignId, start, end);
	}

	/**
	* Returns an ordered range of all the c t action totals where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t action totals
	*/
	public static List<CTActionTotal> findByCampaignId(long campaignId,
		int start, int end, OrderByComparator<CTActionTotal> orderByComparator) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the c t action totals where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c t action totals
	*/
	public static List<CTActionTotal> findByCampaignId(long campaignId,
		int start, int end, OrderByComparator<CTActionTotal> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total
	* @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	*/
	public static CTActionTotal findByCampaignId_First(long campaignId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total, or <code>null</code> if a matching c t action total could not be found
	*/
	public static CTActionTotal fetchByCampaignId_First(long campaignId,
		OrderByComparator<CTActionTotal> orderByComparator) {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total
	* @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	*/
	public static CTActionTotal findByCampaignId_Last(long campaignId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last c t action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total, or <code>null</code> if a matching c t action total could not be found
	*/
	public static CTActionTotal fetchByCampaignId_Last(long campaignId,
		OrderByComparator<CTActionTotal> orderByComparator) {
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
	* @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	*/
	public static CTActionTotal[] findByCampaignId_PrevAndNext(
		long CTActionTotalId, long campaignId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(CTActionTotalId, campaignId,
			orderByComparator);
	}

	/**
	* Removes all the c t action totals where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	*/
	public static void removeByCampaignId(long campaignId) {
		getPersistence().removeByCampaignId(campaignId);
	}

	/**
	* Returns the number of c t action totals where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching c t action totals
	*/
	public static int countByCampaignId(long campaignId) {
		return getPersistence().countByCampaignId(campaignId);
	}

	/**
	* Returns all the c t action totals where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @return the matching c t action totals
	*/
	public static List<CTActionTotal> findByReportInstanceId(
		long reportInstanceId) {
		return getPersistence().findByReportInstanceId(reportInstanceId);
	}

	/**
	* Returns a range of all the c t action totals where reportInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @return the range of matching c t action totals
	*/
	public static List<CTActionTotal> findByReportInstanceId(
		long reportInstanceId, int start, int end) {
		return getPersistence()
				   .findByReportInstanceId(reportInstanceId, start, end);
	}

	/**
	* Returns an ordered range of all the c t action totals where reportInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t action totals
	*/
	public static List<CTActionTotal> findByReportInstanceId(
		long reportInstanceId, int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator) {
		return getPersistence()
				   .findByReportInstanceId(reportInstanceId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the c t action totals where reportInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c t action totals
	*/
	public static List<CTActionTotal> findByReportInstanceId(
		long reportInstanceId, int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByReportInstanceId(reportInstanceId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first c t action total in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total
	* @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	*/
	public static CTActionTotal findByReportInstanceId_First(
		long reportInstanceId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .findByReportInstanceId_First(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the first c t action total in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total, or <code>null</code> if a matching c t action total could not be found
	*/
	public static CTActionTotal fetchByReportInstanceId_First(
		long reportInstanceId,
		OrderByComparator<CTActionTotal> orderByComparator) {
		return getPersistence()
				   .fetchByReportInstanceId_First(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last c t action total in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total
	* @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	*/
	public static CTActionTotal findByReportInstanceId_Last(
		long reportInstanceId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .findByReportInstanceId_Last(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last c t action total in the ordered set where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total, or <code>null</code> if a matching c t action total could not be found
	*/
	public static CTActionTotal fetchByReportInstanceId_Last(
		long reportInstanceId,
		OrderByComparator<CTActionTotal> orderByComparator) {
		return getPersistence()
				   .fetchByReportInstanceId_Last(reportInstanceId,
			orderByComparator);
	}

	/**
	* Returns the c t action totals before and after the current c t action total in the ordered set where reportInstanceId = &#63;.
	*
	* @param CTActionTotalId the primary key of the current c t action total
	* @param reportInstanceId the report instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action total
	* @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	*/
	public static CTActionTotal[] findByReportInstanceId_PrevAndNext(
		long CTActionTotalId, long reportInstanceId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .findByReportInstanceId_PrevAndNext(CTActionTotalId,
			reportInstanceId, orderByComparator);
	}

	/**
	* Removes all the c t action totals where reportInstanceId = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	*/
	public static void removeByReportInstanceId(long reportInstanceId) {
		getPersistence().removeByReportInstanceId(reportInstanceId);
	}

	/**
	* Returns the number of c t action totals where reportInstanceId = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @return the number of matching c t action totals
	*/
	public static int countByReportInstanceId(long reportInstanceId) {
		return getPersistence().countByReportInstanceId(reportInstanceId);
	}

	/**
	* Returns all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @return the matching c t action totals
	*/
	public static List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate) {
		return getPersistence().findByR_GtD(reportInstanceId, modifiedDate);
	}

	/**
	* Returns a range of all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @return the range of matching c t action totals
	*/
	public static List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end) {
		return getPersistence()
				   .findByR_GtD(reportInstanceId, modifiedDate, start, end);
	}

	/**
	* Returns an ordered range of all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t action totals
	*/
	public static List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator) {
		return getPersistence()
				   .findByR_GtD(reportInstanceId, modifiedDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching c t action totals
	*/
	public static List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByR_GtD(reportInstanceId, modifiedDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total
	* @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	*/
	public static CTActionTotal findByR_GtD_First(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTActionTotal> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .findByR_GtD_First(reportInstanceId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the first c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action total, or <code>null</code> if a matching c t action total could not be found
	*/
	public static CTActionTotal fetchByR_GtD_First(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTActionTotal> orderByComparator) {
		return getPersistence()
				   .fetchByR_GtD_First(reportInstanceId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total
	* @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	*/
	public static CTActionTotal findByR_GtD_Last(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTActionTotal> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .findByR_GtD_Last(reportInstanceId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action total, or <code>null</code> if a matching c t action total could not be found
	*/
	public static CTActionTotal fetchByR_GtD_Last(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTActionTotal> orderByComparator) {
		return getPersistence()
				   .fetchByR_GtD_Last(reportInstanceId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the c t action totals before and after the current c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param CTActionTotalId the primary key of the current c t action total
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action total
	* @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	*/
	public static CTActionTotal[] findByR_GtD_PrevAndNext(
		long CTActionTotalId, long reportInstanceId, Date modifiedDate,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .findByR_GtD_PrevAndNext(CTActionTotalId, reportInstanceId,
			modifiedDate, orderByComparator);
	}

	/**
	* Removes all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	*/
	public static void removeByR_GtD(long reportInstanceId, Date modifiedDate) {
		getPersistence().removeByR_GtD(reportInstanceId, modifiedDate);
	}

	/**
	* Returns the number of c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param modifiedDate the modified date
	* @return the number of matching c t action totals
	*/
	public static int countByR_GtD(long reportInstanceId, Date modifiedDate) {
		return getPersistence().countByR_GtD(reportInstanceId, modifiedDate);
	}

	/**
	* Returns the c t action total where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link NoSuchCTActionTotalException} if it could not be found.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching c t action total
	* @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	*/
	public static CTActionTotal findByR_R_R_E_E(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .findByR_R_R_E_E(reportInstanceId, referrerClassName,
			referrerClassPK, elementId, eventType);
	}

	/**
	* Returns the c t action total where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching c t action total, or <code>null</code> if a matching c t action total could not be found
	*/
	public static CTActionTotal fetchByR_R_R_E_E(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType) {
		return getPersistence()
				   .fetchByR_R_R_E_E(reportInstanceId, referrerClassName,
			referrerClassPK, elementId, eventType);
	}

	/**
	* Returns the c t action total where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching c t action total, or <code>null</code> if a matching c t action total could not be found
	*/
	public static CTActionTotal fetchByR_R_R_E_E(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByR_R_R_E_E(reportInstanceId, referrerClassName,
			referrerClassPK, elementId, eventType, retrieveFromCache);
	}

	/**
	* Removes the c t action total where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; from the database.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the c t action total that was removed
	*/
	public static CTActionTotal removeByR_R_R_E_E(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence()
				   .removeByR_R_R_E_E(reportInstanceId, referrerClassName,
			referrerClassPK, elementId, eventType);
	}

	/**
	* Returns the number of c t action totals where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param reportInstanceId the report instance ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the number of matching c t action totals
	*/
	public static int countByR_R_R_E_E(long reportInstanceId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType) {
		return getPersistence()
				   .countByR_R_R_E_E(reportInstanceId, referrerClassName,
			referrerClassPK, elementId, eventType);
	}

	/**
	* Caches the c t action total in the entity cache if it is enabled.
	*
	* @param ctActionTotal the c t action total
	*/
	public static void cacheResult(CTActionTotal ctActionTotal) {
		getPersistence().cacheResult(ctActionTotal);
	}

	/**
	* Caches the c t action totals in the entity cache if it is enabled.
	*
	* @param ctActionTotals the c t action totals
	*/
	public static void cacheResult(List<CTActionTotal> ctActionTotals) {
		getPersistence().cacheResult(ctActionTotals);
	}

	/**
	* Creates a new c t action total with the primary key. Does not add the c t action total to the database.
	*
	* @param CTActionTotalId the primary key for the new c t action total
	* @return the new c t action total
	*/
	public static CTActionTotal create(long CTActionTotalId) {
		return getPersistence().create(CTActionTotalId);
	}

	/**
	* Removes the c t action total with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total that was removed
	* @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	*/
	public static CTActionTotal remove(long CTActionTotalId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence().remove(CTActionTotalId);
	}

	public static CTActionTotal updateImpl(CTActionTotal ctActionTotal) {
		return getPersistence().updateImpl(ctActionTotal);
	}

	/**
	* Returns the c t action total with the primary key or throws a {@link NoSuchCTActionTotalException} if it could not be found.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total
	* @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	*/
	public static CTActionTotal findByPrimaryKey(long CTActionTotalId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException {
		return getPersistence().findByPrimaryKey(CTActionTotalId);
	}

	/**
	* Returns the c t action total with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total, or <code>null</code> if a c t action total with the primary key could not be found
	*/
	public static CTActionTotal fetchByPrimaryKey(long CTActionTotalId) {
		return getPersistence().fetchByPrimaryKey(CTActionTotalId);
	}

	public static java.util.Map<java.io.Serializable, CTActionTotal> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the c t action totals.
	*
	* @return the c t action totals
	*/
	public static List<CTActionTotal> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the c t action totals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @return the range of c t action totals
	*/
	public static List<CTActionTotal> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the c t action totals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of c t action totals
	*/
	public static List<CTActionTotal> findAll(int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the c t action totals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of c t action totals
	*/
	public static List<CTActionTotal> findAll(int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the c t action totals from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of c t action totals.
	*
	* @return the number of c t action totals
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CTActionTotalPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CTActionTotalPersistence, CTActionTotalPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CTActionTotalPersistence.class);
}