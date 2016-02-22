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

package com.liferay.content.targeting.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.model.Campaign;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the campaign service. This utility wraps {@link com.liferay.content.targeting.service.persistence.impl.CampaignPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignPersistence
 * @see com.liferay.content.targeting.service.persistence.impl.CampaignPersistenceImpl
 * @generated
 */
@ProviderType
public class CampaignUtil {
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
	public static void clearCache(Campaign campaign) {
		getPersistence().clearCache(campaign);
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
	public static List<Campaign> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Campaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Campaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Campaign> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Campaign update(Campaign campaign) {
		return getPersistence().update(campaign);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Campaign update(Campaign campaign,
		ServiceContext serviceContext) {
		return getPersistence().update(campaign, serviceContext);
	}

	/**
	* Returns all the campaigns where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching campaigns
	*/
	public static List<Campaign> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns
	*/
	public static List<Campaign> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	*/
	public static List<Campaign> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Campaign> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching campaigns
	*/
	public static List<Campaign> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Campaign> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first campaign in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public static Campaign findByUuid_First(java.lang.String uuid,
		OrderByComparator<Campaign> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first campaign in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public static Campaign fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Campaign> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last campaign in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public static Campaign findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Campaign> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last campaign in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public static Campaign fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Campaign> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the campaigns before and after the current campaign in the ordered set where uuid = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public static Campaign[] findByUuid_PrevAndNext(long campaignId,
		java.lang.String uuid, OrderByComparator<Campaign> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence()
				   .findByUuid_PrevAndNext(campaignId, uuid, orderByComparator);
	}

	/**
	* Removes all the campaigns where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of campaigns where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching campaigns
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the campaign where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchCampaignException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public static Campaign findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the campaign where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public static Campaign fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the campaign where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public static Campaign fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the campaign where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the campaign that was removed
	*/
	public static Campaign removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of campaigns where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching campaigns
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the campaigns where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching campaigns
	*/
	public static List<Campaign> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the campaigns where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns
	*/
	public static List<Campaign> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	*/
	public static List<Campaign> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Campaign> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campaigns where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching campaigns
	*/
	public static List<Campaign> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Campaign> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public static Campaign findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Campaign> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public static Campaign fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Campaign> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public static Campaign findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Campaign> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public static Campaign fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Campaign> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the campaigns before and after the current campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public static Campaign[] findByUuid_C_PrevAndNext(long campaignId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Campaign> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(campaignId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the campaigns where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of campaigns where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching campaigns
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the campaigns where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching campaigns
	*/
	public static List<Campaign> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the campaigns where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns
	*/
	public static List<Campaign> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	*/
	public static List<Campaign> findByGroupId(long groupId, int start,
		int end, OrderByComparator<Campaign> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campaigns where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching campaigns
	*/
	public static List<Campaign> findByGroupId(long groupId, int start,
		int end, OrderByComparator<Campaign> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first campaign in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public static Campaign findByGroupId_First(long groupId,
		OrderByComparator<Campaign> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first campaign in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public static Campaign fetchByGroupId_First(long groupId,
		OrderByComparator<Campaign> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last campaign in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public static Campaign findByGroupId_Last(long groupId,
		OrderByComparator<Campaign> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last campaign in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public static Campaign fetchByGroupId_Last(long groupId,
		OrderByComparator<Campaign> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the campaigns before and after the current campaign in the ordered set where groupId = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public static Campaign[] findByGroupId_PrevAndNext(long campaignId,
		long groupId, OrderByComparator<Campaign> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(campaignId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the campaigns that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching campaigns that the user has permission to view
	*/
	public static List<Campaign> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the campaigns that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns that the user has permission to view
	*/
	public static List<Campaign> filterFindByGroupId(long groupId, int start,
		int end) {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns that the user has permission to view
	*/
	public static List<Campaign> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator<Campaign> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the campaigns before and after the current campaign in the ordered set of campaigns that the user has permission to view where groupId = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public static Campaign[] filterFindByGroupId_PrevAndNext(long campaignId,
		long groupId, OrderByComparator<Campaign> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(campaignId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the campaigns that the user has permission to view where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the matching campaigns that the user has permission to view
	*/
	public static List<Campaign> filterFindByGroupId(long[] groupIds) {
		return getPersistence().filterFindByGroupId(groupIds);
	}

	/**
	* Returns a range of all the campaigns that the user has permission to view where groupId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupIds the group IDs
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns that the user has permission to view
	*/
	public static List<Campaign> filterFindByGroupId(long[] groupIds,
		int start, int end) {
		return getPersistence().filterFindByGroupId(groupIds, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns that the user has permission to view where groupId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupIds the group IDs
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns that the user has permission to view
	*/
	public static List<Campaign> filterFindByGroupId(long[] groupIds,
		int start, int end, OrderByComparator<Campaign> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupIds, start, end, orderByComparator);
	}

	/**
	* Returns all the campaigns where groupId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupIds the group IDs
	* @return the matching campaigns
	*/
	public static List<Campaign> findByGroupId(long[] groupIds) {
		return getPersistence().findByGroupId(groupIds);
	}

	/**
	* Returns a range of all the campaigns where groupId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupIds the group IDs
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns
	*/
	public static List<Campaign> findByGroupId(long[] groupIds, int start,
		int end) {
		return getPersistence().findByGroupId(groupIds, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns where groupId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupIds the group IDs
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	*/
	public static List<Campaign> findByGroupId(long[] groupIds, int start,
		int end, OrderByComparator<Campaign> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupIds, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campaigns where groupId = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching campaigns
	*/
	public static List<Campaign> findByGroupId(long[] groupIds, int start,
		int end, OrderByComparator<Campaign> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupIds, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Removes all the campaigns where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of campaigns where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching campaigns
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of campaigns where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the number of matching campaigns
	*/
	public static int countByGroupId(long[] groupIds) {
		return getPersistence().countByGroupId(groupIds);
	}

	/**
	* Returns the number of campaigns that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching campaigns that the user has permission to view
	*/
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of campaigns that the user has permission to view where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the number of matching campaigns that the user has permission to view
	*/
	public static int filterCountByGroupId(long[] groupIds) {
		return getPersistence().filterCountByGroupId(groupIds);
	}

	/**
	* Caches the campaign in the entity cache if it is enabled.
	*
	* @param campaign the campaign
	*/
	public static void cacheResult(Campaign campaign) {
		getPersistence().cacheResult(campaign);
	}

	/**
	* Caches the campaigns in the entity cache if it is enabled.
	*
	* @param campaigns the campaigns
	*/
	public static void cacheResult(List<Campaign> campaigns) {
		getPersistence().cacheResult(campaigns);
	}

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	public static Campaign create(long campaignId) {
		return getPersistence().create(campaignId);
	}

	/**
	* Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public static Campaign remove(long campaignId)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence().remove(campaignId);
	}

	public static Campaign updateImpl(Campaign campaign) {
		return getPersistence().updateImpl(campaign);
	}

	/**
	* Returns the campaign with the primary key or throws a {@link NoSuchCampaignException} if it could not be found.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public static Campaign findByPrimaryKey(long campaignId)
		throws com.liferay.content.targeting.exception.NoSuchCampaignException {
		return getPersistence().findByPrimaryKey(campaignId);
	}

	/**
	* Returns the campaign with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
	*/
	public static Campaign fetchByPrimaryKey(long campaignId) {
		return getPersistence().fetchByPrimaryKey(campaignId);
	}

	public static java.util.Map<java.io.Serializable, Campaign> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the campaigns.
	*
	* @return the campaigns
	*/
	public static List<Campaign> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of campaigns
	*/
	public static List<Campaign> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaigns
	*/
	public static List<Campaign> findAll(int start, int end,
		OrderByComparator<Campaign> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of campaigns
	*/
	public static List<Campaign> findAll(int start, int end,
		OrderByComparator<Campaign> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the campaigns from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of user segments associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @return long[] of the primaryKeys of user segments associated with the campaign
	*/
	public static long[] getUserSegmentPrimaryKeys(long pk) {
		return getPersistence().getUserSegmentPrimaryKeys(pk);
	}

	/**
	* Returns all the user segments associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @return the user segments associated with the campaign
	*/
	public static List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk) {
		return getPersistence().getUserSegments(pk);
	}

	/**
	* Returns a range of all the user segments associated with the campaign.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the campaign
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of user segments associated with the campaign
	*/
	public static List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end) {
		return getPersistence().getUserSegments(pk, start, end);
	}

	/**
	* Returns an ordered range of all the user segments associated with the campaign.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the campaign
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user segments associated with the campaign
	*/
	public static List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end,
		OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator) {
		return getPersistence()
				   .getUserSegments(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of user segments associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @return the number of user segments associated with the campaign
	*/
	public static int getUserSegmentsSize(long pk) {
		return getPersistence().getUserSegmentsSize(pk);
	}

	/**
	* Returns <code>true</code> if the user segment is associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPK the primary key of the user segment
	* @return <code>true</code> if the user segment is associated with the campaign; <code>false</code> otherwise
	*/
	public static boolean containsUserSegment(long pk, long userSegmentPK) {
		return getPersistence().containsUserSegment(pk, userSegmentPK);
	}

	/**
	* Returns <code>true</code> if the campaign has any user segments associated with it.
	*
	* @param pk the primary key of the campaign to check for associations with user segments
	* @return <code>true</code> if the campaign has any user segments associated with it; <code>false</code> otherwise
	*/
	public static boolean containsUserSegments(long pk) {
		return getPersistence().containsUserSegments(pk);
	}

	/**
	* Adds an association between the campaign and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPK the primary key of the user segment
	*/
	public static void addUserSegment(long pk, long userSegmentPK) {
		getPersistence().addUserSegment(pk, userSegmentPK);
	}

	/**
	* Adds an association between the campaign and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegment the user segment
	*/
	public static void addUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		getPersistence().addUserSegment(pk, userSegment);
	}

	/**
	* Adds an association between the campaign and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPKs the primary keys of the user segments
	*/
	public static void addUserSegments(long pk, long[] userSegmentPKs) {
		getPersistence().addUserSegments(pk, userSegmentPKs);
	}

	/**
	* Adds an association between the campaign and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegments the user segments
	*/
	public static void addUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments) {
		getPersistence().addUserSegments(pk, userSegments);
	}

	/**
	* Clears all associations between the campaign and its user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign to clear the associated user segments from
	*/
	public static void clearUserSegments(long pk) {
		getPersistence().clearUserSegments(pk);
	}

	/**
	* Removes the association between the campaign and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPK the primary key of the user segment
	*/
	public static void removeUserSegment(long pk, long userSegmentPK) {
		getPersistence().removeUserSegment(pk, userSegmentPK);
	}

	/**
	* Removes the association between the campaign and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegment the user segment
	*/
	public static void removeUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		getPersistence().removeUserSegment(pk, userSegment);
	}

	/**
	* Removes the association between the campaign and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPKs the primary keys of the user segments
	*/
	public static void removeUserSegments(long pk, long[] userSegmentPKs) {
		getPersistence().removeUserSegments(pk, userSegmentPKs);
	}

	/**
	* Removes the association between the campaign and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegments the user segments
	*/
	public static void removeUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments) {
		getPersistence().removeUserSegments(pk, userSegments);
	}

	/**
	* Sets the user segments associated with the campaign, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPKs the primary keys of the user segments to be associated with the campaign
	*/
	public static void setUserSegments(long pk, long[] userSegmentPKs) {
		getPersistence().setUserSegments(pk, userSegmentPKs);
	}

	/**
	* Sets the user segments associated with the campaign, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegments the user segments to be associated with the campaign
	*/
	public static void setUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments) {
		getPersistence().setUserSegments(pk, userSegments);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CampaignPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CampaignPersistence, CampaignPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CampaignPersistence.class);
}