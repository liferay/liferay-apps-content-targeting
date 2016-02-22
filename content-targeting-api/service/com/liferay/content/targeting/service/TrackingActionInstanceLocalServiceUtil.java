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
 * Provides the local service utility for TrackingActionInstance. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.TrackingActionInstanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstanceLocalService
 * @see com.liferay.content.targeting.service.base.TrackingActionInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.TrackingActionInstanceLocalServiceImpl
 * @generated
 */
@ProviderType
public class TrackingActionInstanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.TrackingActionInstanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tracking action instance to the database. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstance the tracking action instance
	* @return the tracking action instance that was added
	*/
	public static com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		com.liferay.content.targeting.model.TrackingActionInstance trackingActionInstance) {
		return getService().addTrackingActionInstance(trackingActionInstance);
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		long userId, long reportInstanceId, java.lang.String trackingActionKey,
		long campaignId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTrackingActionInstance(userId, reportInstanceId,
			trackingActionKey, campaignId, alias, referrerClassName,
			referrerClassPK, elementId, eventType, typeSettings, serviceContext);
	}

	/**
	* @deprecated As of 2.0.0
	*/
	@Deprecated
	public static com.liferay.content.targeting.model.TrackingActionInstance addTrackingActionInstance(
		long userId, java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTrackingActionInstance(userId, trackingActionKey,
			campaignId, alias, referrerClassName, referrerClassPK, elementId,
			eventType, typeSettings, serviceContext);
	}

	/**
	* Creates a new tracking action instance with the primary key. Does not add the tracking action instance to the database.
	*
	* @param trackingActionInstanceId the primary key for the new tracking action instance
	* @return the new tracking action instance
	*/
	public static com.liferay.content.targeting.model.TrackingActionInstance createTrackingActionInstance(
		long trackingActionInstanceId) {
		return getService()
				   .createTrackingActionInstance(trackingActionInstanceId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the tracking action instance from the database. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstance the tracking action instance
	* @return the tracking action instance that was removed
	* @throws PortalException
	*/
	public static com.liferay.content.targeting.model.TrackingActionInstance deleteTrackingActionInstance(
		com.liferay.content.targeting.model.TrackingActionInstance trackingActionInstance)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTrackingActionInstance(trackingActionInstance);
	}

	/**
	* Deletes the tracking action instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstanceId the primary key of the tracking action instance
	* @return the tracking action instance that was removed
	* @throws PortalException if a tracking action instance with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.TrackingActionInstance deleteTrackingActionInstance(
		long trackingActionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteTrackingActionInstance(trackingActionInstanceId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstance(
		long campaignId, java.lang.String alias) {
		return getService().fetchTrackingActionInstance(campaignId, alias);
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstance(
		long trackingActionInstanceId) {
		return getService().fetchTrackingActionInstance(trackingActionInstanceId);
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstanceByReportInstanceId(
		long reportInstanceId, java.lang.String alias) {
		return getService()
				   .fetchTrackingActionInstanceByReportInstanceId(reportInstanceId,
			alias);
	}

	/**
	* Returns the tracking action instance matching the UUID and group.
	*
	* @param uuid the tracking action instance's UUID
	* @param groupId the primary key of the group
	* @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	public static com.liferay.content.targeting.model.TrackingActionInstance fetchTrackingActionInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService()
				   .fetchTrackingActionInstanceByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
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

	/**
	* Returns the tracking action instance with the primary key.
	*
	* @param trackingActionInstanceId the primary key of the tracking action instance
	* @return the tracking action instance
	* @throws PortalException if a tracking action instance with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.TrackingActionInstance getTrackingActionInstance(
		long trackingActionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTrackingActionInstance(trackingActionInstanceId);
	}

	/**
	* Returns the tracking action instance matching the UUID and group.
	*
	* @param uuid the tracking action instance's UUID
	* @param groupId the primary key of the group
	* @return the matching tracking action instance
	* @throws PortalException if a matching tracking action instance could not be found
	*/
	public static com.liferay.content.targeting.model.TrackingActionInstance getTrackingActionInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getTrackingActionInstanceByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		long campaignId) {
		return getService().getTrackingActionInstances(campaignId);
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		long campaignId, java.lang.String className, long classPK,
		java.lang.String eventType) {
		return getService()
				   .getTrackingActionInstances(campaignId, className, classPK,
			eventType);
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		long campaignId, java.lang.String elementId, java.lang.String eventType) {
		return getService()
				   .getTrackingActionInstances(campaignId, elementId, eventType);
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
	*/
	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstances(
		int start, int end) {
		return getService().getTrackingActionInstances(start, end);
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstancesByReportInstanceId(
		long reportInstanceId) {
		return getService()
				   .getTrackingActionInstancesByReportInstanceId(reportInstanceId);
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstancesByReportInstanceId(
		long reportInstanceId, java.lang.String className, long classPK,
		java.lang.String eventType) {
		return getService()
				   .getTrackingActionInstancesByReportInstanceId(reportInstanceId,
			className, classPK, eventType);
	}

	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstancesByReportInstanceId(
		long reportInstanceId, java.lang.String elementId,
		java.lang.String eventType) {
		return getService()
				   .getTrackingActionInstancesByReportInstanceId(reportInstanceId,
			elementId, eventType);
	}

	/**
	* Returns all the tracking action instances matching the UUID and company.
	*
	* @param uuid the UUID of the tracking action instances
	* @param companyId the primary key of the company
	* @return the matching tracking action instances, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .getTrackingActionInstancesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of tracking action instances matching the UUID and company.
	*
	* @param uuid the UUID of the tracking action instances
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching tracking action instances, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.content.targeting.model.TrackingActionInstance> getTrackingActionInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.TrackingActionInstance> orderByComparator) {
		return getService()
				   .getTrackingActionInstancesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of tracking action instances.
	*
	* @return the number of tracking action instances
	*/
	public static int getTrackingActionInstancesCount() {
		return getService().getTrackingActionInstancesCount();
	}

	public static int getTrackingActionInstancesCount(long campaignId) {
		return getService().getTrackingActionInstancesCount(campaignId);
	}

	/**
	* Updates the tracking action instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstance the tracking action instance
	* @return the tracking action instance that was updated
	*/
	public static com.liferay.content.targeting.model.TrackingActionInstance updateTrackingActionInstance(
		com.liferay.content.targeting.model.TrackingActionInstance trackingActionInstance) {
		return getService().updateTrackingActionInstance(trackingActionInstance);
	}

	public static com.liferay.content.targeting.model.TrackingActionInstance updateTrackingActionInstance(
		long trackingActionInstanceId, long reportInstanceId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateTrackingActionInstance(trackingActionInstanceId,
			reportInstanceId, alias, referrerClassName, referrerClassPK,
			elementId, eventType, typeSettings, serviceContext);
	}

	public static TrackingActionInstanceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TrackingActionInstanceLocalService, TrackingActionInstanceLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TrackingActionInstanceLocalService.class);
}