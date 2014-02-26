/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CampaignLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLocalService
 * @generated
 */
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Campaign addCampaign(
		com.liferay.contenttargeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.addCampaign(campaign);
	}

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	@Override
	public com.liferay.contenttargeting.model.Campaign createCampaign(
		long campaignId) {
		return _campaignLocalService.createCampaign(campaignId);
	}

	/**
	* Deletes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws PortalException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Campaign deleteCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.deleteCampaign(campaignId);
	}

	/**
	* Deletes the campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Campaign deleteCampaign(
		com.liferay.contenttargeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.deleteCampaign(campaign);
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.contenttargeting.model.Campaign fetchCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.fetchCampaign(campaignId);
	}

	/**
	* Returns the campaign with the matching UUID and company.
	*
	* @param uuid the campaign's UUID
	* @param companyId the primary key of the company
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Campaign fetchCampaignByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.fetchCampaignByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Campaign fetchCampaignByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.fetchCampaignByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the campaign with the primary key.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws PortalException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Campaign getCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaign(campaignId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the campaign with the matching UUID and company.
	*
	* @param uuid the campaign's UUID
	* @param companyId the primary key of the company
	* @return the matching campaign
	* @throws PortalException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Campaign getCampaignByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaignByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the campaign matching the UUID and group.
	*
	* @param uuid the campaign's UUID
	* @param groupId the primary key of the group
	* @return the matching campaign
	* @throws PortalException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Campaign getCampaignByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaignByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of campaigns
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contenttargeting.model.Campaign> getCampaigns(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaigns(start, end);
	}

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCampaignsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaignsCount();
	}

	/**
	* Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Campaign updateCampaign(
		com.liferay.contenttargeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.updateCampaign(campaign);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addUserSegmentCampaign(long userSegmentId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLocalService.addUserSegmentCampaign(userSegmentId, campaignId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addUserSegmentCampaign(long userSegmentId,
		com.liferay.contenttargeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLocalService.addUserSegmentCampaign(userSegmentId, campaign);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addUserSegmentCampaigns(long userSegmentId, long[] campaignIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLocalService.addUserSegmentCampaigns(userSegmentId, campaignIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addUserSegmentCampaigns(long userSegmentId,
		java.util.List<com.liferay.contenttargeting.model.Campaign> Campaigns)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLocalService.addUserSegmentCampaigns(userSegmentId, Campaigns);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearUserSegmentCampaigns(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLocalService.clearUserSegmentCampaigns(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteUserSegmentCampaign(long userSegmentId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLocalService.deleteUserSegmentCampaign(userSegmentId,
			campaignId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteUserSegmentCampaign(long userSegmentId,
		com.liferay.contenttargeting.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLocalService.deleteUserSegmentCampaign(userSegmentId, campaign);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteUserSegmentCampaigns(long userSegmentId,
		long[] campaignIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLocalService.deleteUserSegmentCampaigns(userSegmentId,
			campaignIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteUserSegmentCampaigns(long userSegmentId,
		java.util.List<com.liferay.contenttargeting.model.Campaign> Campaigns)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLocalService.deleteUserSegmentCampaigns(userSegmentId,
			Campaigns);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contenttargeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getUserSegmentCampaigns(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contenttargeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getUserSegmentCampaigns(userSegmentId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contenttargeting.model.Campaign> getUserSegmentCampaigns(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getUserSegmentCampaigns(userSegmentId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserSegmentCampaignsCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getUserSegmentCampaignsCount(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasUserSegmentCampaign(long userSegmentId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.hasUserSegmentCampaign(userSegmentId,
			campaignId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasUserSegmentCampaigns(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.hasUserSegmentCampaigns(userSegmentId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setUserSegmentCampaigns(long userSegmentId, long[] campaignIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLocalService.setUserSegmentCampaigns(userSegmentId, campaignIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _campaignLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _campaignLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.contenttargeting.model.Campaign addCampaign(
		long userId, java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		long[] userSegmentIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.addCampaign(userId, nameMap,
			descriptionMap, startDate, endDate, priority, userSegmentIds,
			serviceContext);
	}

	@Override
	public com.liferay.contenttargeting.model.Campaign fetchCurrentMaxPriorityCampaign(
		long groupId, long[] userSegmentIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.fetchCurrentMaxPriorityCampaign(groupId,
			userSegmentIds);
	}

	@Override
	public java.util.List<com.liferay.contenttargeting.model.Campaign> getCampaigns(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaigns(groupId);
	}

	@Override
	public java.util.List<com.liferay.contenttargeting.model.Campaign> getCampaigns(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaigns(groupIds);
	}

	@Override
	public long getCampaignsCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaignsCount(groupId);
	}

	@Override
	public long getCampaignsCount(long[] groupIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaignsCount(groupIds);
	}

	@Override
	public com.liferay.portal.kernel.search.Hits search(long groupId,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.search(groupId, keywords, start, end);
	}

	@Override
	public com.liferay.contenttargeting.util.BaseModelSearchResult<com.liferay.contenttargeting.model.Campaign> searchCampaigns(
		long groupId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.searchCampaigns(groupId, keywords, start,
			end);
	}

	@Override
	public com.liferay.contenttargeting.model.Campaign updateCampaign(
		long campaignId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Date startDate, java.util.Date endDate, int priority,
		long[] userSegmentIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.updateCampaign(campaignId, nameMap,
			descriptionMap, startDate, endDate, priority, userSegmentIds,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CampaignLocalService getWrappedCampaignLocalService() {
		return _campaignLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCampaignLocalService(
		CampaignLocalService campaignLocalService) {
		_campaignLocalService = campaignLocalService;
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