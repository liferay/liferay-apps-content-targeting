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

import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the c t action service. This utility wraps {@link CTActionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionPersistence
 * @see CTActionPersistenceImpl
 * @generated
 */
public class CTActionUtil {
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
	public static void clearCache(CTAction ctAction) {
		getPersistence().clearCache(ctAction);
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
	public static List<CTAction> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CTAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CTAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CTAction update(CTAction ctAction) throws SystemException {
		return getPersistence().update(ctAction);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CTAction update(CTAction ctAction,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ctAction, serviceContext);
	}

	/**
	* Returns all the c t actions where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(campaignId);
	}

	/**
	* Returns a range of all the c t actions where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(campaignId, start, end);
	}

	/**
	* Returns an ordered range of all the c t actions where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a c t action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction[] findByCampaignId_PrevAndNext(
		long CTActionId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(CTActionId, campaignId,
			orderByComparator);
	}

	/**
	* Removes all the c t actions where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignId(campaignId);
	}

	/**
	* Returns the number of c t actions where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignId(campaignId);
	}

	/**
	* Returns all the c t actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByC_GtD(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_GtD(campaignId, modifiedDate);
	}

	/**
	* Returns a range of all the c t actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_GtD(campaignId, modifiedDate, start, end);
	}

	/**
	* Returns an ordered range of all the c t actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD(campaignId, modifiedDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction findByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_First(campaignId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_GtD_First(campaignId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction findByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_Last(campaignId, modifiedDate, orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_GtD_Last(campaignId, modifiedDate,
			orderByComparator);
	}

	/**
	* Returns the c t actions before and after the current c t action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param CTActionId the primary key of the current c t action
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a c t action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction[] findByC_GtD_PrevAndNext(
		long CTActionId, long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_GtD_PrevAndNext(CTActionId, campaignId,
			modifiedDate, orderByComparator);
	}

	/**
	* Removes all the c t actions where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
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
	* Returns the number of c t actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the number of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_GtD(campaignId, modifiedDate);
	}

	/**
	* Returns all the c t actions where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @return the matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByC_E(
		long campaignId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_E(campaignId, elementId);
	}

	/**
	* Returns a range of all the c t actions where campaignId = &#63; and elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByC_E(
		long campaignId, java.lang.String elementId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_E(campaignId, elementId, start, end);
	}

	/**
	* Returns an ordered range of all the c t actions where campaignId = &#63; and elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByC_E(
		long campaignId, java.lang.String elementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_E(campaignId, elementId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction findByC_E_First(
		long campaignId, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_E_First(campaignId, elementId, orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByC_E_First(
		long campaignId, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_E_First(campaignId, elementId, orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction findByC_E_Last(
		long campaignId, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_E_Last(campaignId, elementId, orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByC_E_Last(
		long campaignId, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_E_Last(campaignId, elementId, orderByComparator);
	}

	/**
	* Returns the c t actions before and after the current c t action in the ordered set where campaignId = &#63; and elementId = &#63;.
	*
	* @param CTActionId the primary key of the current c t action
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a c t action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction[] findByC_E_PrevAndNext(
		long CTActionId, long campaignId, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_E_PrevAndNext(CTActionId, campaignId, elementId,
			orderByComparator);
	}

	/**
	* Removes all the c t actions where campaignId = &#63; and elementId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_E(long campaignId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_E(campaignId, elementId);
	}

	/**
	* Returns the number of c t actions where campaignId = &#63; and elementId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param elementId the element ID
	* @return the number of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_E(long campaignId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_E(campaignId, elementId);
	}

	/**
	* Returns all the c t actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByC_R_R(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_R(campaignId, referrerClassName, referrerClassPK);
	}

	/**
	* Returns a range of all the c t actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByC_R_R(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_R(campaignId, referrerClassName, referrerClassPK,
			start, end);
	}

	/**
	* Returns an ordered range of all the c t actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findByC_R_R(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_R(campaignId, referrerClassName, referrerClassPK,
			start, end, orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction findByC_R_R_First(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_R_First(campaignId, referrerClassName,
			referrerClassPK, orderByComparator);
	}

	/**
	* Returns the first c t action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByC_R_R_First(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_R_First(campaignId, referrerClassName,
			referrerClassPK, orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction findByC_R_R_Last(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_R_Last(campaignId, referrerClassName,
			referrerClassPK, orderByComparator);
	}

	/**
	* Returns the last c t action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByC_R_R_Last(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_R_Last(campaignId, referrerClassName,
			referrerClassPK, orderByComparator);
	}

	/**
	* Returns the c t actions before and after the current c t action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param CTActionId the primary key of the current c t action
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a c t action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction[] findByC_R_R_PrevAndNext(
		long CTActionId, long campaignId, java.lang.String referrerClassName,
		long referrerClassPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_R_PrevAndNext(CTActionId, campaignId,
			referrerClassName, referrerClassPK, orderByComparator);
	}

	/**
	* Removes all the c t actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_R_R(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByC_R_R(campaignId, referrerClassName, referrerClassPK);
	}

	/**
	* Returns the number of c t actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @return the number of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_R_R(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_R_R(campaignId, referrerClassName, referrerClassPK);
	}

	/**
	* Returns the c t action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction findByC_U_R_R_E_E(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_U_R_R_E_E(campaignId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

	/**
	* Returns the c t action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching c t action, or <code>null</code> if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByC_U_R_R_E_E(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_U_R_R_E_E(campaignId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

	/**
	* Returns the c t action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching c t action, or <code>null</code> if a matching c t action could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByC_U_R_R_E_E(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_U_R_R_E_E(campaignId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType,
			retrieveFromCache);
	}

	/**
	* Removes the c t action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the c t action that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction removeByC_U_R_R_E_E(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByC_U_R_R_E_E(campaignId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

	/**
	* Returns the number of c t actions where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param userSegmentId the user segment ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the number of matching c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_U_R_R_E_E(long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_U_R_R_E_E(campaignId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

	/**
	* Caches the c t action in the entity cache if it is enabled.
	*
	* @param ctAction the c t action
	*/
	public static void cacheResult(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction) {
		getPersistence().cacheResult(ctAction);
	}

	/**
	* Caches the c t actions in the entity cache if it is enabled.
	*
	* @param ctActions the c t actions
	*/
	public static void cacheResult(
		java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> ctActions) {
		getPersistence().cacheResult(ctActions);
	}

	/**
	* Creates a new c t action with the primary key. Does not add the c t action to the database.
	*
	* @param CTActionId the primary key for the new c t action
	* @return the new c t action
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction create(
		long CTActionId) {
		return getPersistence().create(CTActionId);
	}

	/**
	* Removes the c t action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action that was removed
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a c t action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction remove(
		long CTActionId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(CTActionId);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction updateImpl(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ctAction);
	}

	/**
	* Returns the c t action with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException} if it could not be found.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException if a c t action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction findByPrimaryKey(
		long CTActionId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(CTActionId);
	}

	/**
	* Returns the c t action with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action, or <code>null</code> if a c t action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchByPrimaryKey(
		long CTActionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(CTActionId);
	}

	/**
	* Returns all the c t actions.
	*
	* @return the c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the c t actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @return the range of c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the c t actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t actions
	* @param end the upper bound of the range of c t actions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the c t actions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of c t actions.
	*
	* @return the number of c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CTActionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CTActionPersistence)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.report.campaign.tracking.action.service.ClpSerializer.getServletContextName(),
					CTActionPersistence.class.getName());

			ReferenceRegistry.registerReference(CTActionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CTActionPersistence persistence) {
	}

	private static CTActionPersistence _persistence;
}