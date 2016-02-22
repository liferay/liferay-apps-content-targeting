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

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CTAction. This utility wraps
 * {@link com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CTActionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CTActionLocalService
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.base.CTActionLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CTActionLocalServiceImpl
 * @generated
 */
@ProviderType
public class CTActionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CTActionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the c t action to the database. Also notifies the appropriate model listeners.
	*
	* @param ctAction the c t action
	* @return the c t action that was added
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction) {
		return getService().addCTAction(ctAction);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		long reportInstanceId, long userSegmentId, java.lang.String alias,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCTAction(reportInstanceId, userSegmentId, alias,
			elementId, eventType, count);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		long reportInstanceId, long userSegmentId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCTAction(reportInstanceId, userSegmentId, alias,
			referrerClassName, referrerClassPK, elementId, eventType, count);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		long reportInstanceId, long userSegmentId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCTAction(reportInstanceId, userSegmentId, alias,
			referrerClassName, referrerClassPK, eventType, count);
	}

	public static void checkCTActionEvents()
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().checkCTActionEvents();
	}

	public static void checkCTActionEvents(long reportInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().checkCTActionEvents(reportInstanceId);
	}

	/**
	* Creates a new c t action with the primary key. Does not add the c t action to the database.
	*
	* @param CTActionId the primary key for the new c t action
	* @return the new c t action
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction createCTAction(
		long CTActionId) {
		return getService().createCTAction(CTActionId);
	}

	/**
	* Deletes the c t action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action that was removed
	* @throws PortalException if a c t action with the primary key could not be found
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction deleteCTAction(
		long CTActionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCTAction(CTActionId);
	}

	/**
	* Deletes the c t action from the database. Also notifies the appropriate model listeners.
	*
	* @param ctAction the c t action
	* @return the c t action that was removed
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction deleteCTAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction) {
		return getService().deleteCTAction(ctAction);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchCTAction(
		long CTActionId) {
		return getService().fetchCTAction(CTActionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the c t action with the primary key.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action
	* @throws PortalException if a c t action with the primary key could not be found
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction getCTAction(
		long CTActionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCTAction(CTActionId);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction getCTAction(
		long reportInstanceId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getCTAction(reportInstanceId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long reportInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCTActions(reportInstanceId);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long reportInstanceId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCTActions(reportInstanceId, className, classPK);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long reportInstanceId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCTActions(reportInstanceId, elementId);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long reportInstanceId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCTActions(reportInstanceId, modifiedDate);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long reportInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getCTActions(reportInstanceId, start, end, orderByComparator);
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
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		int start, int end) {
		return getService().getCTActions(start, end);
	}

	/**
	* Returns the number of c t actions.
	*
	* @return the number of c t actions
	*/
	public static int getCTActionsCount() {
		return getService().getCTActionsCount();
	}

	public static int getCTActionsCount(long reportInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCTActionsCount(reportInstanceId);
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
	* Updates the c t action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ctAction the c t action
	* @return the c t action that was updated
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction updateCTAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction) {
		return getService().updateCTAction(ctAction);
	}

	public static CTActionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CTActionLocalService, CTActionLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CTActionLocalService.class);
}