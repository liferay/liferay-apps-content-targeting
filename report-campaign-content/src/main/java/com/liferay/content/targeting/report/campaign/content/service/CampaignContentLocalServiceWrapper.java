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

package com.liferay.content.targeting.report.campaign.content.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CampaignContentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignContentLocalService
 * @generated
 */
@ProviderType
public class CampaignContentLocalServiceWrapper
	implements CampaignContentLocalService,
		ServiceWrapper<CampaignContentLocalService> {
	public CampaignContentLocalServiceWrapper(
		CampaignContentLocalService campaignContentLocalService) {
		_campaignContentLocalService = campaignContentLocalService;
	}

	/**
	* Adds the campaign content to the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content
	* @return the campaign content that was added
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent addCampaignContent(
		com.liferay.content.targeting.report.campaign.content.model.CampaignContent campaignContent) {
		return _campaignContentLocalService.addCampaignContent(campaignContent);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent addCampaignContent(
		long campaignId, java.lang.String className, long classPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignContentLocalService.addCampaignContent(campaignId,
			className, classPK, eventType, count);
	}

	@Override
	public void checkCampaignContentEvents()
		throws com.liferay.portal.kernel.exception.PortalException {
		_campaignContentLocalService.checkCampaignContentEvents();
	}

	@Override
	public void checkCampaignContentEvents(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_campaignContentLocalService.checkCampaignContentEvents(campaignId);
	}

	/**
	* Creates a new campaign content with the primary key. Does not add the campaign content to the database.
	*
	* @param campaignContentId the primary key for the new campaign content
	* @return the new campaign content
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent createCampaignContent(
		long campaignContentId) {
		return _campaignContentLocalService.createCampaignContent(campaignContentId);
	}

	/**
	* Deletes the campaign content from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content
	* @return the campaign content that was removed
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent deleteCampaignContent(
		com.liferay.content.targeting.report.campaign.content.model.CampaignContent campaignContent) {
		return _campaignContentLocalService.deleteCampaignContent(campaignContent);
	}

	/**
	* Deletes the campaign content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContentId the primary key of the campaign content
	* @return the campaign content that was removed
	* @throws PortalException if a campaign content with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent deleteCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignContentLocalService.deleteCampaignContent(campaignContentId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignContentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _campaignContentLocalService.dynamicQuery();
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
		return _campaignContentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.content.model.impl.CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _campaignContentLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.content.model.impl.CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _campaignContentLocalService.dynamicQuery(dynamicQuery, start,
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
		return _campaignContentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _campaignContentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent fetchCampaignContent(
		long campaignContentId) {
		return _campaignContentLocalService.fetchCampaignContent(campaignContentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _campaignContentLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the campaign content with the primary key.
	*
	* @param campaignContentId the primary key of the campaign content
	* @return the campaign content
	* @throws PortalException if a campaign content with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent getCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignContentLocalService.getCampaignContent(campaignContentId);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent getCampaignContent(
		long campaignId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignContentLocalService.getCampaignContent(campaignId,
			className, classPK, eventType);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.content.model.CampaignContent> getCampaignContents(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignContentLocalService.getCampaignContents(campaignId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.content.model.CampaignContent> getCampaignContents(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignContentLocalService.getCampaignContents(campaignId,
			modifiedDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.content.model.CampaignContent> getCampaignContents(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignContentLocalService.getCampaignContents(campaignId,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the campaign contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.content.model.impl.CampaignContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @return the range of campaign contents
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.content.model.CampaignContent> getCampaignContents(
		int start, int end) {
		return _campaignContentLocalService.getCampaignContents(start, end);
	}

	/**
	* Returns the number of campaign contents.
	*
	* @return the number of campaign contents
	*/
	@Override
	public int getCampaignContentsCount() {
		return _campaignContentLocalService.getCampaignContentsCount();
	}

	@Override
	public int getCampaignContentsCount(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignContentLocalService.getCampaignContentsCount(campaignId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _campaignContentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _campaignContentLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campaignContentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the campaign content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content
	* @return the campaign content that was updated
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.content.model.CampaignContent updateCampaignContent(
		com.liferay.content.targeting.report.campaign.content.model.CampaignContent campaignContent) {
		return _campaignContentLocalService.updateCampaignContent(campaignContent);
	}

	@Override
	public CampaignContentLocalService getWrappedService() {
		return _campaignContentLocalService;
	}

	@Override
	public void setWrappedService(
		CampaignContentLocalService campaignContentLocalService) {
		_campaignContentLocalService = campaignContentLocalService;
	}

	private CampaignContentLocalService _campaignContentLocalService;
}