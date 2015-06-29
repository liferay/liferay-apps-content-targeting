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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrackingActionInstanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstanceLocalService
 * @generated
 */
public class TrackingActionInstanceLocalServiceWrapper
	implements TrackingActionInstanceLocalService,
		ServiceWrapper<TrackingActionInstanceLocalService> {
	public TrackingActionInstanceLocalServiceWrapper(
		TrackingActionInstanceLocalService trackingActionInstanceLocalService) {
		_trackingActionInstanceLocalService = trackingActionInstanceLocalService;
	}

	/**
	* Adds the tracking action instance to the database. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstance the tracking action instance
	* @return the tracking action instance that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		com.liferay.content.targeting.model.TrackingActionInstance trackingActionInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.addTrackingActionInstance(trackingActionInstance);
	}

	/**
	* Creates a new tracking action instance with the primary key. Does not add the tracking action instance to the database.
	*
	* @param trackingActionInstanceId the primary key for the new tracking action instance
	* @return the new tracking action instance
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance createTrackingActionInstance(
		long trackingActionInstanceId) {
		return _trackingActionInstanceLocalService.createTrackingActionInstance(trackingActionInstanceId);
	}

	/**
	* Deletes the tracking action instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstanceId the primary key of the tracking action instance
	* @return the tracking action instance that was removed
	* @throws PortalException if a tracking action instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance deleteTrackingActionInstance(
		long trackingActionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.deleteTrackingActionInstance(trackingActionInstanceId);
	}

	/**
	* Deletes the tracking action instance from the database. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstance the tracking action instance
	* @return the tracking action instance that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance deleteTrackingActionInstance(
		com.liferay.content.targeting.model.TrackingActionInstance trackingActionInstance)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.deleteTrackingActionInstance(trackingActionInstance);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trackingActionInstanceLocalService.dynamicQuery();
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
		return _trackingActionInstanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _trackingActionInstanceLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _trackingActionInstanceLocalService.dynamicQuery(dynamicQuery,
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
		return _trackingActionInstanceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _trackingActionInstanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstance(
		long trackingActionInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.fetchTrackingActionInstance(trackingActionInstanceId);
	}

	/**
	* Returns the tracking action instance with the matching UUID and company.
	*
	* @param uuid the tracking action instance's UUID
	* @param companyId the primary key of the company
	* @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstanceByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.fetchTrackingActionInstanceByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the tracking action instance matching the UUID and group.
	*
	* @param uuid the tracking action instance's UUID
	* @param groupId the primary key of the group
	* @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.fetchTrackingActionInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the tracking action instance with the primary key.
	*
	* @param trackingActionInstanceId the primary key of the tracking action instance
	* @return the tracking action instance
	* @throws PortalException if a tracking action instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance getTrackingActionInstance(
		long trackingActionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.getTrackingActionInstance(trackingActionInstanceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the tracking action instance with the matching UUID and company.
	*
	* @param uuid the tracking action instance's UUID
	* @param companyId the primary key of the company
	* @return the matching tracking action instance
	* @throws PortalException if a matching tracking action instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance getTrackingActionInstanceByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.getTrackingActionInstanceByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the tracking action instance matching the UUID and group.
	*
	* @param uuid the tracking action instance's UUID
	* @param groupId the primary key of the group
	* @return the matching tracking action instance
	* @throws PortalException if a matching tracking action instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance getTrackingActionInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.getTrackingActionInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the tracking action instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of tracking action instances
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.getTrackingActionInstances(start,
			end);
	}

	/**
	* Returns the number of tracking action instances.
	*
	* @return the number of tracking action instances
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTrackingActionInstancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.getTrackingActionInstancesCount();
	}

	/**
	* Updates the tracking action instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstance the tracking action instance
	* @return the tracking action instance that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance updateTrackingActionInstance(
		com.liferay.content.targeting.model.TrackingActionInstance trackingActionInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.updateTrackingActionInstance(trackingActionInstance);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _trackingActionInstanceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trackingActionInstanceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _trackingActionInstanceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		long userId, java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.addTrackingActionInstance(userId,
			trackingActionKey, campaignId, alias, referrerClassName,
			referrerClassPK, elementId, eventType, typeSettings, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstance(
		long campaignId, java.lang.String alias)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.fetchTrackingActionInstance(campaignId,
			alias);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.getTrackingActionInstances(campaignId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		long campaignId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.getTrackingActionInstances(campaignId,
			className, classPK, eventType);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		long campaignId, java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.getTrackingActionInstances(campaignId,
			elementId, eventType);
	}

	@Override
	public int getTrackingActionInstancesCount(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.getTrackingActionInstancesCount(campaignId);
	}

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance updateTrackingActionInstance(
		long trackingActionInstanceId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trackingActionInstanceLocalService.updateTrackingActionInstance(trackingActionInstanceId,
			alias, referrerClassName, referrerClassPK, elementId, eventType,
			typeSettings, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TrackingActionInstanceLocalService getWrappedTrackingActionInstanceLocalService() {
		return _trackingActionInstanceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTrackingActionInstanceLocalService(
		TrackingActionInstanceLocalService trackingActionInstanceLocalService) {
		_trackingActionInstanceLocalService = trackingActionInstanceLocalService;
	}

	@Override
	public TrackingActionInstanceLocalService getWrappedService() {
		return _trackingActionInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		TrackingActionInstanceLocalService trackingActionInstanceLocalService) {
		_trackingActionInstanceLocalService = trackingActionInstanceLocalService;
	}

	private TrackingActionInstanceLocalService _trackingActionInstanceLocalService;
}