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
 * Provides a wrapper for {@link CTActionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CTActionLocalService
 * @generated
 */
public class CTActionLocalServiceWrapper implements CTActionLocalService,
	ServiceWrapper<CTActionLocalService> {
	public CTActionLocalServiceWrapper(
		CTActionLocalService ctActionLocalService) {
		_ctActionLocalService = ctActionLocalService;
	}

	/**
	* Adds the c t action to the database. Also notifies the appropriate model listeners.
	*
	* @param ctAction the c t action
	* @return the c t action that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.addCTAction(ctAction);
	}

	/**
	* Creates a new c t action with the primary key. Does not add the c t action to the database.
	*
	* @param CTActionId the primary key for the new c t action
	* @return the new c t action
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction createCTAction(
		long CTActionId) {
		return _ctActionLocalService.createCTAction(CTActionId);
	}

	/**
	* Deletes the c t action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action that was removed
	* @throws PortalException if a c t action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction deleteCTAction(
		long CTActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.deleteCTAction(CTActionId);
	}

	/**
	* Deletes the c t action from the database. Also notifies the appropriate model listeners.
	*
	* @param ctAction the c t action
	* @return the c t action that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction deleteCTAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.deleteCTAction(ctAction);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ctActionLocalService.dynamicQuery();
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
		return _ctActionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ctActionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ctActionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _ctActionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ctActionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchCTAction(
		long CTActionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.fetchCTAction(CTActionId);
	}

	/**
	* Returns the c t action with the primary key.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action
	* @throws PortalException if a c t action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction getCTAction(
		long CTActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getCTAction(CTActionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getCTActions(start, end);
	}

	/**
	* Returns the number of c t actions.
	*
	* @return the number of c t actions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCTActionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getCTActionsCount();
	}

	/**
	* Updates the c t action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ctAction the c t action
	* @return the c t action that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction updateCTAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.updateCTAction(ctAction);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ctActionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ctActionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ctActionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.addCTAction(campaignId, userSegmentId,
			alias, referrerClassName, referrerClassPK, eventType, count);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.addCTAction(campaignId, userSegmentId,
			alias, referrerClassName, referrerClassPK, elementId, eventType,
			count);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.addCTAction(campaignId, userSegmentId,
			alias, elementId, eventType, count);
	}

	@Override
	public void checkCTActionEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ctActionLocalService.checkCTActionEvents();
	}

	@Override
	public void checkCTActionEvents(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ctActionLocalService.checkCTActionEvents(campaignId);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction getCTAction(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getCTAction(campaignId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getCTActions(campaignId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getCTActions(campaignId, modifiedDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getCTActions(campaignId, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long campaignId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getCTActions(campaignId, elementId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long campaignId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getCTActions(campaignId, className, classPK);
	}

	@Override
	public int getCTActionsCount(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionLocalService.getCTActionsCount(campaignId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CTActionLocalService getWrappedCTActionLocalService() {
		return _ctActionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCTActionLocalService(
		CTActionLocalService ctActionLocalService) {
		_ctActionLocalService = ctActionLocalService;
	}

	@Override
	public CTActionLocalService getWrappedService() {
		return _ctActionLocalService;
	}

	@Override
	public void setWrappedService(CTActionLocalService ctActionLocalService) {
		_ctActionLocalService = ctActionLocalService;
	}

	private CTActionLocalService _ctActionLocalService;
}