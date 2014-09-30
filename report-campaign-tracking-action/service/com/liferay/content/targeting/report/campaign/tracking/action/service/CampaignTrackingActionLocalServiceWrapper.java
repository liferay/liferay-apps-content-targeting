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

package com.liferay.content.targeting.report.campaign.tracking.action.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CampaignTrackingActionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingActionLocalService
 * @generated
 */
public class CampaignTrackingActionLocalServiceWrapper
	implements CampaignTrackingActionLocalService,
		ServiceWrapper<CampaignTrackingActionLocalService> {
	public CampaignTrackingActionLocalServiceWrapper(
		CampaignTrackingActionLocalService campaignTrackingActionLocalService) {
		_campaignTrackingActionLocalService = campaignTrackingActionLocalService;
	}

	/**
	* Adds the campaign tracking action to the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingAction the campaign tracking action
	* @return the campaign tracking action that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction addCampaignTrackingAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction campaignTrackingAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.addCampaignTrackingAction(campaignTrackingAction);
	}

	/**
	* Creates a new campaign tracking action with the primary key. Does not add the campaign tracking action to the database.
	*
	* @param campaignTrackingActionId the primary key for the new campaign tracking action
	* @return the new campaign tracking action
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction createCampaignTrackingAction(
		long campaignTrackingActionId) {
		return _campaignTrackingActionLocalService.createCampaignTrackingAction(campaignTrackingActionId);
	}

	/**
	* Deletes the campaign tracking action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingActionId the primary key of the campaign tracking action
	* @return the campaign tracking action that was removed
	* @throws PortalException if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction deleteCampaignTrackingAction(
		long campaignTrackingActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.deleteCampaignTrackingAction(campaignTrackingActionId);
	}

	/**
	* Deletes the campaign tracking action from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingAction the campaign tracking action
	* @return the campaign tracking action that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction deleteCampaignTrackingAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction campaignTrackingAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.deleteCampaignTrackingAction(campaignTrackingAction);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _campaignTrackingActionLocalService.dynamicQuery();
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
		return _campaignTrackingActionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _campaignTrackingActionLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _campaignTrackingActionLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _campaignTrackingActionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _campaignTrackingActionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchCampaignTrackingAction(
		long campaignTrackingActionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.fetchCampaignTrackingAction(campaignTrackingActionId);
	}

	/**
	* Returns the campaign tracking action with the primary key.
	*
	* @param campaignTrackingActionId the primary key of the campaign tracking action
	* @return the campaign tracking action
	* @throws PortalException if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction getCampaignTrackingAction(
		long campaignTrackingActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getCampaignTrackingAction(campaignTrackingActionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the campaign tracking actions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign tracking actions
	* @param end the upper bound of the range of campaign tracking actions (not inclusive)
	* @return the range of campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getCampaignTrackingActions(start,
			end);
	}

	/**
	* Returns the number of campaign tracking actions.
	*
	* @return the number of campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCampaignTrackingActionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getCampaignTrackingActionsCount();
	}

	/**
	* Updates the campaign tracking action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingAction the campaign tracking action
	* @return the campaign tracking action that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction updateCampaignTrackingAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction campaignTrackingAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.updateCampaignTrackingAction(campaignTrackingAction);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _campaignTrackingActionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignTrackingActionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _campaignTrackingActionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction addCampaignTrackingAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.addCampaignTrackingAction(campaignId,
			userSegmentId, alias, referrerClassName, referrerClassPK,
			eventType, count);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction addCampaignTrackingAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.addCampaignTrackingAction(campaignId,
			userSegmentId, alias, referrerClassName, referrerClassPK,
			elementId, eventType, count);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction addCampaignTrackingAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.addCampaignTrackingAction(campaignId,
			userSegmentId, alias, elementId, eventType, count);
	}

	@Override
	public void checkCampaignTrackingActionEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_campaignTrackingActionLocalService.checkCampaignTrackingActionEvents();
	}

	@Override
	public void checkCampaignTrackingActionEvents(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_campaignTrackingActionLocalService.checkCampaignTrackingActionEvents(campaignId);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction getCampaignTrackingAction(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getCampaignTrackingAction(campaignId,
			userSegmentId, referrerClassName, referrerClassPK, elementId,
			eventType);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getCampaignTrackingActions(campaignId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		long campaignId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getCampaignTrackingActions(campaignId,
			elementId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		long campaignId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getCampaignTrackingActions(campaignId,
			className, classPK);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getCampaignTrackingActions(campaignId,
			modifiedDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getCampaignTrackingActions(campaignId,
			start, end, orderByComparator);
	}

	@Override
	public int getCampaignTrackingActionsCount(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignTrackingActionLocalService.getCampaignTrackingActionsCount(campaignId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CampaignTrackingActionLocalService getWrappedCampaignTrackingActionLocalService() {
		return _campaignTrackingActionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCampaignTrackingActionLocalService(
		CampaignTrackingActionLocalService campaignTrackingActionLocalService) {
		_campaignTrackingActionLocalService = campaignTrackingActionLocalService;
	}

	@Override
	public CampaignTrackingActionLocalService getWrappedService() {
		return _campaignTrackingActionLocalService;
	}

	@Override
	public void setWrappedService(
		CampaignTrackingActionLocalService campaignTrackingActionLocalService) {
		_campaignTrackingActionLocalService = campaignTrackingActionLocalService;
	}

	private CampaignTrackingActionLocalService _campaignTrackingActionLocalService;
}