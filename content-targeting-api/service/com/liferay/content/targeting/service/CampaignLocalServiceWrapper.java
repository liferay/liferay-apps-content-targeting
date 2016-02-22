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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CampaignLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalService
 * @generated
 */
@ProviderType
public class CampaignLocalServiceWrapper implements CampaignLocalService,
	ServiceWrapper<CampaignLocalService> {
	public CampaignLocalServiceWrapper(
		CampaignLocalService campaignLocalService) {
		_campaignLocalService = campaignLocalService;
	}

	/**
	* Adds the campaign to the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was added
	*/
	@Override
	public com.liferay.content.targeting.model.Campaign addCampaign(
		com.liferay.content.targeting.model.Campaign campaign) {
		return _campaignLocalService.addCampaign(campaign);
	}

	@Override
	public com.liferay.content.targeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		boolean active, long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.addCampaign(userId, nameMap,
			descriptionMap, startDate, endDate, priority, active,
			userSegmentIds, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String timeZoneId, int priority, boolean active,
		long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.addCampaign(userId, nameMap,
			descriptionMap, startDate, endDate, timeZoneId, priority, active,
			userSegmentIds, serviceContext);
	}

	@Override
	public void addCampaignResources(
		com.liferay.content.targeting.model.Campaign campaign,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		_campaignLocalService.addCampaignResources(campaign,
			addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addCampaignResources(
		com.liferay.content.targeting.model.Campaign campaign,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		_campaignLocalService.addCampaignResources(campaign, groupPermissions,
			guestPermissions);
	}

	@Override
	public void addUserSegmentCampaign(long userSegmentId,
		com.liferay.content.targeting.model.Campaign campaign) {
		_campaignLocalService.addUserSegmentCampaign(userSegmentId, campaign);
	}

	@Override
	public void addUserSegmentCampaign(long userSegmentId, long campaignId) {
		_campaignLocalService.addUserSegmentCampaign(userSegmentId, campaignId);
	}

	@Override
	public void addUserSegmentCampaigns(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Campaign> Campaigns) {
		_campaignLocalService.addUserSegmentCampaigns(userSegmentId, Campaigns);
	}

	@Override
	public void addUserSegmentCampaigns(long userSegmentId, long[] campaignIds) {
		_campaignLocalService.addUserSegmentCampaigns(userSegmentId, campaignIds);
	}

	@Override
	public void clearUserSegmentCampaigns(long userSegmentId) {
		_campaignLocalService.clearUserSegmentCampaigns(userSegmentId);
	}

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	@Override
	public com.liferay.content.targeting.model.Campaign createCampaign(
		long campaignId) {
		return _campaignLocalService.createCampaign(campaignId);
	}

	/**
	* Deletes the campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.content.targeting.model.Campaign deleteCampaign(
		com.liferay.content.targeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.deleteCampaign(campaign);
	}

	/**
	* Deletes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws PortalException if a campaign with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.Campaign deleteCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.deleteCampaign(campaignId);
	}

	@Override
	public void deleteCampaigns(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_campaignLocalService.deleteCampaigns(groupId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteUserSegmentCampaign(long userSegmentId,
		com.liferay.content.targeting.model.Campaign campaign) {
		_campaignLocalService.deleteUserSegmentCampaign(userSegmentId, campaign);
	}

	@Override
	public void deleteUserSegmentCampaign(long userSegmentId, long campaignId) {
		_campaignLocalService.deleteUserSegmentCampaign(userSegmentId,
			campaignId);
	}

	@Override
	public void deleteUserSegmentCampaigns(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Campaign> Campaigns) {
		_campaignLocalService.deleteUserSegmentCampaigns(userSegmentId,
			Campaigns);
	}

	@Override
	public void deleteUserSegmentCampaigns(long userSegmentId,
		long[] campaignIds) {
		_campaignLocalService.deleteUserSegmentCampaigns(userSegmentId,
			campaignIds);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _campaignLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _campaignLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _campaignLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _campaignLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _campaignLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _campaignLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.content.targeting.model.Campaign fetchCampaign(
		long campaignId) {
		return _campaignLocalService.fetchCampaign(campaignId);
	}

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.Campaign fetchCampaignByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _campaignLocalService.fetchCampaignByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.content.targeting.model.Campaign fetchCurrentMaxPriorityCampaign(
		long[] groupIds, long[] userSegmentIds) {
		return _campaignLocalService.fetchCurrentMaxPriorityCampaign(groupIds,
			userSegmentIds);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _campaignLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the campaign with the primary key.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws PortalException if a campaign with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.Campaign getCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getCampaign(campaignId);
	}

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign
	* @throws PortalException if a matching campaign could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.Campaign getCampaignByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getCampaignByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getCampaigns(groupId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getCampaigns(groupId, start, end, obc);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getCampaigns(groupIds);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long[] groupIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getCampaigns(groupIds, start, end, obc);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long[] groupIds, long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getCampaigns(groupIds, userSegmentIds);
	}

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
	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		int start, int end) {
		return _campaignLocalService.getCampaigns(start, end);
	}

	/**
	* Returns all the campaigns matching the UUID and company.
	*
	* @param uuid the UUID of the campaigns
	* @param companyId the primary key of the company
	* @return the matching campaigns, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaignsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _campaignLocalService.getCampaignsByUuidAndCompanyId(uuid,
			companyId);
	}

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
	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getCampaignsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.Campaign> orderByComparator) {
		return _campaignLocalService.getCampaignsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	*/
	@Override
	public int getCampaignsCount() {
		return _campaignLocalService.getCampaignsCount();
	}

	@Override
	public int getCampaignsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getCampaignsCount(groupId);
	}

	@Override
	public int getCampaignsCount(long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getCampaignsCount(groupIds);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _campaignLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _campaignLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _campaignLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId) {
		return _campaignLocalService.getUserSegmentCampaigns(userSegmentId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId, int start, int end) {
		return _campaignLocalService.getUserSegmentCampaigns(userSegmentId,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.Campaign> orderByComparator) {
		return _campaignLocalService.getUserSegmentCampaigns(userSegmentId,
			start, end, orderByComparator);
	}

	@Override
	public int getUserSegmentCampaignsCount(long userSegmentId) {
		return _campaignLocalService.getUserSegmentCampaignsCount(userSegmentId);
	}

	/**
	* Returns the userSegmentIds of the user segments associated with the campaign.
	*
	* @param campaignId the campaignId of the campaign
	* @return long[] the userSegmentIds of user segments associated with the campaign
	*/
	@Override
	public long[] getUserSegmentPrimaryKeys(long campaignId) {
		return _campaignLocalService.getUserSegmentPrimaryKeys(campaignId);
	}

	@Override
	public boolean hasUserSegmentCampaign(long userSegmentId, long campaignId) {
		return _campaignLocalService.hasUserSegmentCampaign(userSegmentId,
			campaignId);
	}

	@Override
	public boolean hasUserSegmentCampaigns(long userSegmentId) {
		return _campaignLocalService.hasUserSegmentCampaigns(userSegmentId);
	}

	@Override
	public com.liferay.portal.kernel.search.Hits search(long groupId,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.search(groupId, keywords, start, end);
	}

	@Override
	public com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.Campaign> searchCampaigns(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.searchCampaigns(groupId, keywords, start,
			end);
	}

	@Override
	public void setUserSegmentCampaigns(long userSegmentId, long[] campaignIds) {
		_campaignLocalService.setUserSegmentCampaigns(userSegmentId, campaignIds);
	}

	/**
	* Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was updated
	*/
	@Override
	public com.liferay.content.targeting.model.Campaign updateCampaign(
		com.liferay.content.targeting.model.Campaign campaign) {
		return _campaignLocalService.updateCampaign(campaign);
	}

	@Override
	public com.liferay.content.targeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		boolean active, long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.updateCampaign(campaignId, nameMap,
			descriptionMap, startDate, endDate, priority, active,
			userSegmentIds, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String timeZoneId, int priority, boolean active,
		long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignLocalService.updateCampaign(campaignId, nameMap,
			descriptionMap, startDate, endDate, timeZoneId, priority, active,
			userSegmentIds, serviceContext);
	}

	@Override
	public void updateCampaignResources(
		com.liferay.content.targeting.model.Campaign campaign,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		_campaignLocalService.updateCampaignResources(campaign,
			groupPermissions, guestPermissions);
	}

	@Override
	public CampaignLocalService getWrappedService() {
		return _campaignLocalService;
	}

	@Override
	public void setWrappedService(CampaignLocalService campaignLocalService) {
		_campaignLocalService = campaignLocalService;
	}

	private CampaignLocalService _campaignLocalService;
}