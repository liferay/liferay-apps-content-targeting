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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Campaign. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.CampaignLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalService
 * @see com.liferay.content.targeting.service.base.CampaignLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.CampaignLocalServiceImpl
 * @generated
 */
@ProviderType
public class CampaignLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.CampaignLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the campaign to the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was added
	*/
	public static com.liferay.content.targeting.model.Campaign addCampaign(
		com.liferay.content.targeting.model.Campaign campaign) {
		return getService().addCampaign(campaign);
	}

	public static com.liferay.content.targeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		boolean active, long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCampaign(userId, nameMap, descriptionMap, startDate,
			endDate, priority, active, userSegmentIds, serviceContext);
	}

	public static com.liferay.content.targeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String timeZoneId, int priority, boolean active,
		long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCampaign(userId, nameMap, descriptionMap, startDate,
			endDate, timeZoneId, priority, active, userSegmentIds,
			serviceContext);
	}

	public static void addCampaignResources(
		com.liferay.content.targeting.model.Campaign campaign,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService()
			.addCampaignResources(campaign, addGroupPermissions,
			addGuestPermissions);
	}

	public static void addCampaignResources(
		com.liferay.content.targeting.model.Campaign campaign,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService()
			.addCampaignResources(campaign, groupPermissions, guestPermissions);
	}

	public static void addUserSegmentCampaign(long userSegmentId,
		com.liferay.content.targeting.model.Campaign campaign) {
		getService().addUserSegmentCampaign(userSegmentId, campaign);
	}

	public static void addUserSegmentCampaign(long userSegmentId,
		long campaignId) {
		getService().addUserSegmentCampaign(userSegmentId, campaignId);
	}

	public static void addUserSegmentCampaigns(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Campaign> Campaigns) {
		getService().addUserSegmentCampaigns(userSegmentId, Campaigns);
	}

	public static void addUserSegmentCampaigns(long userSegmentId,
		long[] campaignIds) {
		getService().addUserSegmentCampaigns(userSegmentId, campaignIds);
	}

	public static void clearUserSegmentCampaigns(long userSegmentId) {
		getService().clearUserSegmentCampaigns(userSegmentId);
	}

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	public static com.liferay.content.targeting.model.Campaign createCampaign(
		long campaignId) {
		return getService().createCampaign(campaignId);
	}

	/**
	* Deletes the campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was removed
	* @throws PortalException
	*/
	public static com.liferay.content.targeting.model.Campaign deleteCampaign(
		com.liferay.content.targeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCampaign(campaign);
	}

	/**
	* Deletes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws PortalException if a campaign with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.Campaign deleteCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCampaign(campaignId);
	}

	public static void deleteCampaigns(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().deleteCampaigns(groupId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteUserSegmentCampaign(long userSegmentId,
		com.liferay.content.targeting.model.Campaign campaign) {
		getService().deleteUserSegmentCampaign(userSegmentId, campaign);
	}

	public static void deleteUserSegmentCampaign(long userSegmentId,
		long campaignId) {
		getService().deleteUserSegmentCampaign(userSegmentId, campaignId);
	}

	public static void deleteUserSegmentCampaigns(long userSegmentId,
		java.util.List<com.liferay.content.targeting.model.Campaign> Campaigns) {
		getService().deleteUserSegmentCampaigns(userSegmentId, Campaigns);
	}

	public static void deleteUserSegmentCampaigns(long userSegmentId,
		long[] campaignIds) {
		getService().deleteUserSegmentCampaigns(userSegmentId, campaignIds);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.content.targeting.model.Campaign fetchCampaign(
		long campaignId) {
		return getService().fetchCampaign(campaignId);
	}

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	*/
	public static com.liferay.content.targeting.model.Campaign fetchCampaignByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchCampaignByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.content.targeting.model.Campaign fetchCurrentMaxPriorityCampaign(
		long[] groupIds, long[] userSegmentIds) {
		return getService()
				   .fetchCurrentMaxPriorityCampaign(groupIds, userSegmentIds);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the campaign with the primary key.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws PortalException if a campaign with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.Campaign getCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaign(campaignId);
	}

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign
	* @throws PortalException if a matching campaign could not be found
	*/
	public static com.liferay.content.targeting.model.Campaign getCampaignByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaignByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaigns(groupId);
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaigns(groupId, start, end, obc);
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaigns(groupIds);
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long[] groupIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaigns(groupIds, start, end, obc);
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long[] groupIds, long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaigns(groupIds, userSegmentIds);
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
	public static java.util.List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		int start, int end) {
		return getService().getCampaigns(start, end);
	}

	/**
	* Returns all the campaigns matching the UUID and company.
	*
	* @param uuid the UUID of the campaigns
	* @param companyId the primary key of the company
	* @return the matching campaigns, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.content.targeting.model.Campaign> getCampaignsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getCampaignsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.liferay.content.targeting.model.Campaign> getCampaignsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.Campaign> orderByComparator) {
		return getService()
				   .getCampaignsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	*/
	public static int getCampaignsCount() {
		return getService().getCampaignsCount();
	}

	public static int getCampaignsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaignsCount(groupId);
	}

	public static int getCampaignsCount(long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCampaignsCount(groupIds);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId) {
		return getService().getUserSegmentCampaigns(userSegmentId);
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId, int start, int end) {
		return getService().getUserSegmentCampaigns(userSegmentId, start, end);
	}

	public static java.util.List<com.liferay.content.targeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.Campaign> orderByComparator) {
		return getService()
				   .getUserSegmentCampaigns(userSegmentId, start, end,
			orderByComparator);
	}

	public static int getUserSegmentCampaignsCount(long userSegmentId) {
		return getService().getUserSegmentCampaignsCount(userSegmentId);
	}

	/**
	* Returns the userSegmentIds of the user segments associated with the campaign.
	*
	* @param campaignId the campaignId of the campaign
	* @return long[] the userSegmentIds of user segments associated with the campaign
	*/
	public static long[] getUserSegmentPrimaryKeys(long campaignId) {
		return getService().getUserSegmentPrimaryKeys(campaignId);
	}

	public static boolean hasUserSegmentCampaign(long userSegmentId,
		long campaignId) {
		return getService().hasUserSegmentCampaign(userSegmentId, campaignId);
	}

	public static boolean hasUserSegmentCampaigns(long userSegmentId) {
		return getService().hasUserSegmentCampaigns(userSegmentId);
	}

	public static com.liferay.portal.kernel.search.Hits search(long groupId,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().search(groupId, keywords, start, end);
	}

	public static com.liferay.content.targeting.util.BaseModelSearchResult<com.liferay.content.targeting.model.Campaign> searchCampaigns(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().searchCampaigns(groupId, keywords, start, end);
	}

	public static void setUserSegmentCampaigns(long userSegmentId,
		long[] campaignIds) {
		getService().setUserSegmentCampaigns(userSegmentId, campaignIds);
	}

	/**
	* Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was updated
	*/
	public static com.liferay.content.targeting.model.Campaign updateCampaign(
		com.liferay.content.targeting.model.Campaign campaign) {
		return getService().updateCampaign(campaign);
	}

	public static com.liferay.content.targeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		boolean active, long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateCampaign(campaignId, nameMap, descriptionMap,
			startDate, endDate, priority, active, userSegmentIds, serviceContext);
	}

	public static com.liferay.content.targeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String timeZoneId, int priority, boolean active,
		long[] userSegmentIds,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateCampaign(campaignId, nameMap, descriptionMap,
			startDate, endDate, timeZoneId, priority, active, userSegmentIds,
			serviceContext);
	}

	public static void updateCampaignResources(
		com.liferay.content.targeting.model.Campaign campaign,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService()
			.updateCampaignResources(campaign, groupPermissions,
			guestPermissions);
	}

	public static CampaignLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CampaignLocalService, CampaignLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CampaignLocalService.class);
}