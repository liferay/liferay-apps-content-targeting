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

package com.liferay.content.targeting.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.util.BaseModelSearchResult;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Provides the local service interface for Campaign. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalServiceUtil
 * @see com.liferay.content.targeting.service.base.CampaignLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.CampaignLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CampaignLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignLocalServiceUtil} to access the campaign local service. Add custom service methods to {@link com.liferay.content.targeting.service.impl.CampaignLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the campaign to the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Campaign addCampaign(Campaign campaign);

	@Indexable(type = IndexableType.REINDEX)
	public Campaign addCampaign(long userId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap, Date startDate,
		Date endDate, int priority, boolean active, long[] userSegmentIds,
		ServiceContext serviceContext) throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public Campaign addCampaign(long userId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap, Date startDate,
		Date endDate, java.lang.String timeZoneId, int priority,
		boolean active, long[] userSegmentIds, ServiceContext serviceContext)
		throws PortalException;

	public void addCampaignResources(Campaign campaign,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws PortalException;

	public void addCampaignResources(Campaign campaign,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws PortalException;

	public void addUserSegmentCampaign(long userSegmentId, Campaign campaign);

	public void addUserSegmentCampaign(long userSegmentId, long campaignId);

	public void addUserSegmentCampaigns(long userSegmentId,
		List<Campaign> Campaigns);

	public void addUserSegmentCampaigns(long userSegmentId, long[] campaignIds);

	public void clearUserSegmentCampaigns(long userSegmentId);

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	public Campaign createCampaign(long campaignId);

	/**
	* Deletes the campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	public Campaign deleteCampaign(Campaign campaign) throws PortalException;

	/**
	* Deletes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws PortalException if a campaign with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Campaign deleteCampaign(long campaignId) throws PortalException;

	public void deleteCampaigns(long groupId) throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deleteUserSegmentCampaign(long userSegmentId, Campaign campaign);

	public void deleteUserSegmentCampaign(long userSegmentId, long campaignId);

	public void deleteUserSegmentCampaigns(long userSegmentId,
		List<Campaign> Campaigns);

	public void deleteUserSegmentCampaigns(long userSegmentId,
		long[] campaignIds);

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Campaign fetchCampaign(long campaignId);

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Campaign fetchCampaignByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Campaign fetchCurrentMaxPriorityCampaign(long[] groupIds,
		long[] userSegmentIds);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the campaign with the primary key.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws PortalException if a campaign with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Campaign getCampaign(long campaignId) throws PortalException;

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign
	* @throws PortalException if a matching campaign could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Campaign getCampaignByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getCampaigns(long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getCampaigns(long groupId, int start, int end,
		OrderByComparator obc) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getCampaigns(long[] groupIds)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getCampaigns(long[] groupIds, int start, int end,
		OrderByComparator obc) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getCampaigns(long[] groupIds, long[] userSegmentIds)
		throws PortalException;

	/**
	* Returns a range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of campaigns
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getCampaigns(int start, int end);

	/**
	* Returns all the campaigns matching the UUID and company.
	*
	* @param uuid the UUID of the campaigns
	* @param companyId the primary key of the company
	* @return the matching campaigns, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getCampaignsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of campaigns matching the UUID and company.
	*
	* @param uuid the UUID of the campaigns
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching campaigns, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getCampaignsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<Campaign> orderByComparator);

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCampaignsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCampaignsCount(long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCampaignsCount(long[] groupIds) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getUserSegmentCampaigns(long userSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getUserSegmentCampaigns(long userSegmentId,
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Campaign> getUserSegmentCampaigns(long userSegmentId,
		int start, int end, OrderByComparator<Campaign> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserSegmentCampaignsCount(long userSegmentId);

	/**
	* Returns the userSegmentIds of the user segments associated with the campaign.
	*
	* @param campaignId the campaignId of the campaign
	* @return long[] the userSegmentIds of user segments associated with the campaign
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getUserSegmentPrimaryKeys(long campaignId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasUserSegmentCampaign(long userSegmentId, long campaignId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasUserSegmentCampaigns(long userSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(long groupId, java.lang.String keywords, int start,
		int end) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BaseModelSearchResult<Campaign> searchCampaigns(long groupId,
		java.lang.String keywords, int start, int end)
		throws PortalException;

	public void setUserSegmentCampaigns(long userSegmentId, long[] campaignIds);

	/**
	* Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Campaign updateCampaign(Campaign campaign);

	@Indexable(type = IndexableType.REINDEX)
	public Campaign updateCampaign(long campaignId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap, Date startDate,
		Date endDate, int priority, boolean active, long[] userSegmentIds,
		ServiceContext serviceContext) throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public Campaign updateCampaign(long campaignId,
		Map<Locale, java.lang.String> nameMap,
		Map<Locale, java.lang.String> descriptionMap, Date startDate,
		Date endDate, java.lang.String timeZoneId, int priority,
		boolean active, long[] userSegmentIds, ServiceContext serviceContext)
		throws PortalException;

	public void updateCampaignResources(Campaign campaign,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws PortalException;
}