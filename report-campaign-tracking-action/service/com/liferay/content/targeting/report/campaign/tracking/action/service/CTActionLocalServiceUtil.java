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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

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
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCTAction(ctAction);
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
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction deleteCTAction(
		long CTActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCTAction(CTActionId);
	}

	/**
	* Deletes the c t action from the database. Also notifies the appropriate model listeners.
	*
	* @param ctAction the c t action
	* @return the c t action that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction deleteCTAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCTAction(ctAction);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction fetchCTAction(
		long CTActionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCTAction(CTActionId);
	}

	/**
	* Returns the c t action with the primary key.
	*
	* @param CTActionId the primary key of the c t action
	* @return the c t action
	* @throws PortalException if a c t action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction getCTAction(
		long CTActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCTAction(CTActionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCTActions(start, end);
	}

	/**
	* Returns the number of c t actions.
	*
	* @return the number of c t actions
	* @throws SystemException if a system exception occurred
	*/
	public static int getCTActionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCTActionsCount();
	}

	/**
	* Updates the c t action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ctAction the c t action
	* @return the c t action that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction updateCTAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCTAction(ctAction);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCTAction(campaignId, userSegmentId, alias,
			referrerClassName, referrerClassPK, eventType, count);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCTAction(campaignId, userSegmentId, alias,
			referrerClassName, referrerClassPK, elementId, eventType, count);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction addCTAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCTAction(campaignId, userSegmentId, alias, elementId,
			eventType, count);
	}

	public static void checkCTActionEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().checkCTActionEvents();
	}

	public static void checkCTActionEvents(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().checkCTActionEvents(campaignId);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction getCTAction(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCTAction(campaignId, userSegmentId, referrerClassName,
			referrerClassPK, elementId, eventType);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCTActions(campaignId);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCTActions(campaignId, modifiedDate);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCTActions(campaignId, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long campaignId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCTActions(campaignId, elementId);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> getCTActions(
		long campaignId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCTActions(campaignId, className, classPK);
	}

	public static int getCTActionsCount(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCTActionsCount(campaignId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CTActionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CTActionLocalService.class.getName());

			if (invokableLocalService instanceof CTActionLocalService) {
				_service = (CTActionLocalService)invokableLocalService;
			}
			else {
				_service = new CTActionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CTActionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CTActionLocalService service) {
	}

	private static CTActionLocalService _service;
}