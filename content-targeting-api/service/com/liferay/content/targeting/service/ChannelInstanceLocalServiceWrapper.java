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
 * Provides a wrapper for {@link ChannelInstanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstanceLocalService
 * @generated
 */
@ProviderType
public class ChannelInstanceLocalServiceWrapper
	implements ChannelInstanceLocalService,
		ServiceWrapper<ChannelInstanceLocalService> {
	public ChannelInstanceLocalServiceWrapper(
		ChannelInstanceLocalService channelInstanceLocalService) {
		_channelInstanceLocalService = channelInstanceLocalService;
	}

	/**
	* Adds the channel instance to the database. Also notifies the appropriate model listeners.
	*
	* @param channelInstance the channel instance
	* @return the channel instance that was added
	*/
	@Override
	public com.liferay.content.targeting.model.ChannelInstance addChannelInstance(
		com.liferay.content.targeting.model.ChannelInstance channelInstance) {
		return _channelInstanceLocalService.addChannelInstance(channelInstance);
	}

	@Override
	public com.liferay.content.targeting.model.ChannelInstance addChannelInstance(
		long userId, long tacticId, java.lang.String channelKey,
		long campaignId, java.lang.String alias, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.addChannelInstance(userId,
			tacticId, channelKey, campaignId, alias, typeSettings,
			serviceContext);
	}

	/**
	* Creates a new channel instance with the primary key. Does not add the channel instance to the database.
	*
	* @param channelInstanceId the primary key for the new channel instance
	* @return the new channel instance
	*/
	@Override
	public com.liferay.content.targeting.model.ChannelInstance createChannelInstance(
		long channelInstanceId) {
		return _channelInstanceLocalService.createChannelInstance(channelInstanceId);
	}

	/**
	* Deletes the channel instance from the database. Also notifies the appropriate model listeners.
	*
	* @param channelInstance the channel instance
	* @return the channel instance that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.content.targeting.model.ChannelInstance deleteChannelInstance(
		com.liferay.content.targeting.model.ChannelInstance channelInstance)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.deleteChannelInstance(channelInstance);
	}

	/**
	* Deletes the channel instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance that was removed
	* @throws PortalException if a channel instance with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.ChannelInstance deleteChannelInstance(
		long channelInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.deleteChannelInstance(channelInstanceId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _channelInstanceLocalService.dynamicQuery();
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
		return _channelInstanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _channelInstanceLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _channelInstanceLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _channelInstanceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _channelInstanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.model.ChannelInstance fetchChannelInstance(
		long channelInstanceId) {
		return _channelInstanceLocalService.fetchChannelInstance(channelInstanceId);
	}

	/**
	* Returns the channel instance matching the UUID and group.
	*
	* @param uuid the channel instance's UUID
	* @param groupId the primary key of the group
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.ChannelInstance fetchChannelInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _channelInstanceLocalService.fetchChannelInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _channelInstanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> getCampaignChannelInstances(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.getCampaignChannelInstances(campaignId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> getCampaignChannelInstances(
		long campaignId, java.lang.String channelKey)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.getCampaignChannelInstances(campaignId,
			channelKey);
	}

	/**
	* Returns the channel instance with the primary key.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance
	* @throws PortalException if a channel instance with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.ChannelInstance getChannelInstance(
		long channelInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.getChannelInstance(channelInstanceId);
	}

	/**
	* Returns the channel instance matching the UUID and group.
	*
	* @param uuid the channel instance's UUID
	* @param groupId the primary key of the group
	* @return the matching channel instance
	* @throws PortalException if a matching channel instance could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.ChannelInstance getChannelInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.getChannelInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the channel instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of channel instances
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstances(
		int start, int end) {
		return _channelInstanceLocalService.getChannelInstances(start, end);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstances(
		long tacticId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.getChannelInstances(tacticId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstances(
		long tacticId, java.lang.String channelKey)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.getChannelInstances(tacticId,
			channelKey);
	}

	/**
	* Returns all the channel instances matching the UUID and company.
	*
	* @param uuid the UUID of the channel instances
	* @param companyId the primary key of the company
	* @return the matching channel instances, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _channelInstanceLocalService.getChannelInstancesByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of channel instances matching the UUID and company.
	*
	* @param uuid the UUID of the channel instances
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching channel instances, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> getChannelInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.ChannelInstance> orderByComparator) {
		return _channelInstanceLocalService.getChannelInstancesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of channel instances.
	*
	* @return the number of channel instances
	*/
	@Override
	public int getChannelInstancesCount() {
		return _channelInstanceLocalService.getChannelInstancesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _channelInstanceLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _channelInstanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _channelInstanceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the channel instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param channelInstance the channel instance
	* @return the channel instance that was updated
	*/
	@Override
	public com.liferay.content.targeting.model.ChannelInstance updateChannelInstance(
		com.liferay.content.targeting.model.ChannelInstance channelInstance) {
		return _channelInstanceLocalService.updateChannelInstance(channelInstance);
	}

	@Override
	public com.liferay.content.targeting.model.ChannelInstance updateChannelInstance(
		long channelInstanceId, java.lang.String alias,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _channelInstanceLocalService.updateChannelInstance(channelInstanceId,
			alias, typeSettings, serviceContext);
	}

	@Override
	public ChannelInstanceLocalService getWrappedService() {
		return _channelInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		ChannelInstanceLocalService channelInstanceLocalService) {
		_channelInstanceLocalService = channelInstanceLocalService;
	}

	private ChannelInstanceLocalService _channelInstanceLocalService;
}