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

import com.liferay.content.targeting.exception.NoSuchCampaignException;
import com.liferay.content.targeting.model.Campaign;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.persistence.impl.CampaignPersistenceImpl
 * @see CampaignUtil
 * @generated
 */
@ProviderType
public interface CampaignPersistence extends BasePersistence<Campaign> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignUtil} to access the campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the campaigns where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching campaigns
	*/
	public java.util.List<Campaign> findByUuid(java.lang.String uuid);

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
	public java.util.List<Campaign> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<Campaign> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

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
	public java.util.List<Campaign> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first campaign in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public Campaign findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator)
		throws NoSuchCampaignException;

	/**
	* Returns the first campaign in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public Campaign fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

	/**
	* Returns the last campaign in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public Campaign findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator)
		throws NoSuchCampaignException;

	/**
	* Returns the last campaign in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public Campaign fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

	/**
	* Returns the campaigns before and after the current campaign in the ordered set where uuid = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public Campaign[] findByUuid_PrevAndNext(long campaignId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator)
		throws NoSuchCampaignException;

	/**
	* Removes all the campaigns where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of campaigns where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching campaigns
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the campaign where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchCampaignException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public Campaign findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchCampaignException;

	/**
	* Returns the campaign where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public Campaign fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the campaign where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public Campaign fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the campaign where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the campaign that was removed
	*/
	public Campaign removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchCampaignException;

	/**
	* Returns the number of campaigns where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching campaigns
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the campaigns where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching campaigns
	*/
	public java.util.List<Campaign> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Campaign> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Campaign> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

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
	public java.util.List<Campaign> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public Campaign findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator)
		throws NoSuchCampaignException;

	/**
	* Returns the first campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public Campaign fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

	/**
	* Returns the last campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public Campaign findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator)
		throws NoSuchCampaignException;

	/**
	* Returns the last campaign in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public Campaign fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

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
	public Campaign[] findByUuid_C_PrevAndNext(long campaignId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator)
		throws NoSuchCampaignException;

	/**
	* Removes all the campaigns where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of campaigns where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching campaigns
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the campaigns where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching campaigns
	*/
	public java.util.List<Campaign> findByGroupId(long groupId);

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
	public java.util.List<Campaign> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<Campaign> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

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
	public java.util.List<Campaign> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first campaign in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public Campaign findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator)
		throws NoSuchCampaignException;

	/**
	* Returns the first campaign in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public Campaign fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

	/**
	* Returns the last campaign in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws NoSuchCampaignException if a matching campaign could not be found
	*/
	public Campaign findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator)
		throws NoSuchCampaignException;

	/**
	* Returns the last campaign in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public Campaign fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

	/**
	* Returns the campaigns before and after the current campaign in the ordered set where groupId = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public Campaign[] findByGroupId_PrevAndNext(long campaignId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator)
		throws NoSuchCampaignException;

	/**
	* Returns all the campaigns that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching campaigns that the user has permission to view
	*/
	public java.util.List<Campaign> filterFindByGroupId(long groupId);

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
	public java.util.List<Campaign> filterFindByGroupId(long groupId,
		int start, int end);

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
	public java.util.List<Campaign> filterFindByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

	/**
	* Returns the campaigns before and after the current campaign in the ordered set of campaigns that the user has permission to view where groupId = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public Campaign[] filterFindByGroupId_PrevAndNext(long campaignId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator)
		throws NoSuchCampaignException;

	/**
	* Returns all the campaigns that the user has permission to view where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the matching campaigns that the user has permission to view
	*/
	public java.util.List<Campaign> filterFindByGroupId(long[] groupIds);

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
	public java.util.List<Campaign> filterFindByGroupId(long[] groupIds,
		int start, int end);

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
	public java.util.List<Campaign> filterFindByGroupId(long[] groupIds,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

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
	public java.util.List<Campaign> findByGroupId(long[] groupIds);

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
	public java.util.List<Campaign> findByGroupId(long[] groupIds, int start,
		int end);

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
	public java.util.List<Campaign> findByGroupId(long[] groupIds, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

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
	public java.util.List<Campaign> findByGroupId(long[] groupIds, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the campaigns where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of campaigns where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching campaigns
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the number of campaigns where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the number of matching campaigns
	*/
	public int countByGroupId(long[] groupIds);

	/**
	* Returns the number of campaigns that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching campaigns that the user has permission to view
	*/
	public int filterCountByGroupId(long groupId);

	/**
	* Returns the number of campaigns that the user has permission to view where groupId = any &#63;.
	*
	* @param groupIds the group IDs
	* @return the number of matching campaigns that the user has permission to view
	*/
	public int filterCountByGroupId(long[] groupIds);

	/**
	* Caches the campaign in the entity cache if it is enabled.
	*
	* @param campaign the campaign
	*/
	public void cacheResult(Campaign campaign);

	/**
	* Caches the campaigns in the entity cache if it is enabled.
	*
	* @param campaigns the campaigns
	*/
	public void cacheResult(java.util.List<Campaign> campaigns);

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	public Campaign create(long campaignId);

	/**
	* Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public Campaign remove(long campaignId) throws NoSuchCampaignException;

	public Campaign updateImpl(Campaign campaign);

	/**
	* Returns the campaign with the primary key or throws a {@link NoSuchCampaignException} if it could not be found.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws NoSuchCampaignException if a campaign with the primary key could not be found
	*/
	public Campaign findByPrimaryKey(long campaignId)
		throws NoSuchCampaignException;

	/**
	* Returns the campaign with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
	*/
	public Campaign fetchByPrimaryKey(long campaignId);

	@Override
	public java.util.Map<java.io.Serializable, Campaign> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the campaigns.
	*
	* @return the campaigns
	*/
	public java.util.List<Campaign> findAll();

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
	public java.util.List<Campaign> findAll(int start, int end);

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
	public java.util.List<Campaign> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator);

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
	public java.util.List<Campaign> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campaign> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the campaigns from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of user segments associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @return long[] of the primaryKeys of user segments associated with the campaign
	*/
	public long[] getUserSegmentPrimaryKeys(long pk);

	/**
	* Returns all the user segments associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @return the user segments associated with the campaign
	*/
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk);

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
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end);

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
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator);

	/**
	* Returns the number of user segments associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @return the number of user segments associated with the campaign
	*/
	public int getUserSegmentsSize(long pk);

	/**
	* Returns <code>true</code> if the user segment is associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPK the primary key of the user segment
	* @return <code>true</code> if the user segment is associated with the campaign; <code>false</code> otherwise
	*/
	public boolean containsUserSegment(long pk, long userSegmentPK);

	/**
	* Returns <code>true</code> if the campaign has any user segments associated with it.
	*
	* @param pk the primary key of the campaign to check for associations with user segments
	* @return <code>true</code> if the campaign has any user segments associated with it; <code>false</code> otherwise
	*/
	public boolean containsUserSegments(long pk);

	/**
	* Adds an association between the campaign and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPK the primary key of the user segment
	*/
	public void addUserSegment(long pk, long userSegmentPK);

	/**
	* Adds an association between the campaign and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegment the user segment
	*/
	public void addUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment);

	/**
	* Adds an association between the campaign and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPKs the primary keys of the user segments
	*/
	public void addUserSegments(long pk, long[] userSegmentPKs);

	/**
	* Adds an association between the campaign and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegments the user segments
	*/
	public void addUserSegments(long pk,
		java.util.List<com.liferay.content.targeting.model.UserSegment> userSegments);

	/**
	* Clears all associations between the campaign and its user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign to clear the associated user segments from
	*/
	public void clearUserSegments(long pk);

	/**
	* Removes the association between the campaign and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPK the primary key of the user segment
	*/
	public void removeUserSegment(long pk, long userSegmentPK);

	/**
	* Removes the association between the campaign and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegment the user segment
	*/
	public void removeUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment);

	/**
	* Removes the association between the campaign and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPKs the primary keys of the user segments
	*/
	public void removeUserSegments(long pk, long[] userSegmentPKs);

	/**
	* Removes the association between the campaign and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegments the user segments
	*/
	public void removeUserSegments(long pk,
		java.util.List<com.liferay.content.targeting.model.UserSegment> userSegments);

	/**
	* Sets the user segments associated with the campaign, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegmentPKs the primary keys of the user segments to be associated with the campaign
	*/
	public void setUserSegments(long pk, long[] userSegmentPKs);

	/**
	* Sets the user segments associated with the campaign, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the campaign
	* @param userSegments the user segments to be associated with the campaign
	*/
	public void setUserSegments(long pk,
		java.util.List<com.liferay.content.targeting.model.UserSegment> userSegments);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}