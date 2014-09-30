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
 * Provides the local service utility for CampaignTrackingAction. This utility wraps
 * {@link com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CampaignTrackingActionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingActionLocalService
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.base.CampaignTrackingActionLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CampaignTrackingActionLocalServiceImpl
 * @generated
 */
public class CampaignTrackingActionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CampaignTrackingActionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the campaign tracking action to the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingAction the campaign tracking action
	* @return the campaign tracking action that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction addCampaignTrackingAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction campaignTrackingAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCampaignTrackingAction(campaignTrackingAction);
	}

	/**
	* Creates a new campaign tracking action with the primary key. Does not add the campaign tracking action to the database.
	*
	* @param campaignTrackingActionId the primary key for the new campaign tracking action
	* @return the new campaign tracking action
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction createCampaignTrackingAction(
		long campaignTrackingActionId) {
		return getService()
				   .createCampaignTrackingAction(campaignTrackingActionId);
	}

	/**
	* Deletes the campaign tracking action with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingActionId the primary key of the campaign tracking action
	* @return the campaign tracking action that was removed
	* @throws PortalException if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction deleteCampaignTrackingAction(
		long campaignTrackingActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteCampaignTrackingAction(campaignTrackingActionId);
	}

	/**
	* Deletes the campaign tracking action from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingAction the campaign tracking action
	* @return the campaign tracking action that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction deleteCampaignTrackingAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction campaignTrackingAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCampaignTrackingAction(campaignTrackingAction);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction fetchCampaignTrackingAction(
		long campaignTrackingActionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCampaignTrackingAction(campaignTrackingActionId);
	}

	/**
	* Returns the campaign tracking action with the primary key.
	*
	* @param campaignTrackingActionId the primary key of the campaign tracking action
	* @return the campaign tracking action
	* @throws PortalException if a campaign tracking action with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction getCampaignTrackingAction(
		long campaignTrackingActionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingAction(campaignTrackingActionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingActions(start, end);
	}

	/**
	* Returns the number of campaign tracking actions.
	*
	* @return the number of campaign tracking actions
	* @throws SystemException if a system exception occurred
	*/
	public static int getCampaignTrackingActionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingActionsCount();
	}

	/**
	* Updates the campaign tracking action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingAction the campaign tracking action
	* @return the campaign tracking action that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction updateCampaignTrackingAction(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction campaignTrackingAction)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCampaignTrackingAction(campaignTrackingAction);
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

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction addCampaignTrackingAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCampaignTrackingAction(campaignId, userSegmentId, alias,
			referrerClassName, referrerClassPK, eventType, count);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction addCampaignTrackingAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCampaignTrackingAction(campaignId, userSegmentId, alias,
			referrerClassName, referrerClassPK, elementId, eventType, count);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction addCampaignTrackingAction(
		long campaignId, long userSegmentId, java.lang.String alias,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCampaignTrackingAction(campaignId, userSegmentId, alias,
			elementId, eventType, count);
	}

	public static void checkCampaignTrackingActionEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().checkCampaignTrackingActionEvents();
	}

	public static void checkCampaignTrackingActionEvents(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().checkCampaignTrackingActionEvents(campaignId);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction getCampaignTrackingAction(
		long campaignId, long userSegmentId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCampaignTrackingAction(campaignId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingActions(campaignId);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		long campaignId, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingActions(campaignId, elementId);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		long campaignId, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCampaignTrackingActions(campaignId, className, classPK);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingActions(campaignId, modifiedDate);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction> getCampaignTrackingActions(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCampaignTrackingActions(campaignId, start, end,
			orderByComparator);
	}

	public static int getCampaignTrackingActionsCount(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingActionsCount(campaignId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CampaignTrackingActionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CampaignTrackingActionLocalService.class.getName());

			if (invokableLocalService instanceof CampaignTrackingActionLocalService) {
				_service = (CampaignTrackingActionLocalService)invokableLocalService;
			}
			else {
				_service = new CampaignTrackingActionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CampaignTrackingActionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CampaignTrackingActionLocalService service) {
	}

	private static CampaignTrackingActionLocalService _service;
}