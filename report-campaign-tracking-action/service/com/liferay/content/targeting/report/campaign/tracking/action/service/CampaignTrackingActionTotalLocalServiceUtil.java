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
 * Provides the local service utility for CampaignTrackingActionTotal. This utility wraps
 * {@link com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CampaignTrackingActionTotalLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingActionTotalLocalService
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.base.CampaignTrackingActionTotalLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CampaignTrackingActionTotalLocalServiceImpl
 * @generated
 */
public class CampaignTrackingActionTotalLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CampaignTrackingActionTotalLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the campaign tracking action total to the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingActionTotal the campaign tracking action total
	* @return the campaign tracking action total that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal addCampaignTrackingActionTotal(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal campaignTrackingActionTotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCampaignTrackingActionTotal(campaignTrackingActionTotal);
	}

	/**
	* Creates a new campaign tracking action total with the primary key. Does not add the campaign tracking action total to the database.
	*
	* @param campaignTrackingActionTotalId the primary key for the new campaign tracking action total
	* @return the new campaign tracking action total
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal createCampaignTrackingActionTotal(
		long campaignTrackingActionTotalId) {
		return getService()
				   .createCampaignTrackingActionTotal(campaignTrackingActionTotalId);
	}

	/**
	* Deletes the campaign tracking action total with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingActionTotalId the primary key of the campaign tracking action total
	* @return the campaign tracking action total that was removed
	* @throws PortalException if a campaign tracking action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal deleteCampaignTrackingActionTotal(
		long campaignTrackingActionTotalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteCampaignTrackingActionTotal(campaignTrackingActionTotalId);
	}

	/**
	* Deletes the campaign tracking action total from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingActionTotal the campaign tracking action total
	* @return the campaign tracking action total that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal deleteCampaignTrackingActionTotal(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal campaignTrackingActionTotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteCampaignTrackingActionTotal(campaignTrackingActionTotal);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal fetchCampaignTrackingActionTotal(
		long campaignTrackingActionTotalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchCampaignTrackingActionTotal(campaignTrackingActionTotalId);
	}

	/**
	* Returns the campaign tracking action total with the primary key.
	*
	* @param campaignTrackingActionTotalId the primary key of the campaign tracking action total
	* @return the campaign tracking action total
	* @throws PortalException if a campaign tracking action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal getCampaignTrackingActionTotal(
		long campaignTrackingActionTotalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCampaignTrackingActionTotal(campaignTrackingActionTotalId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the campaign tracking action totals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign tracking action totals
	* @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	* @return the range of campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> getCampaignTrackingActionTotals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingActionTotals(start, end);
	}

	/**
	* Returns the number of campaign tracking action totals.
	*
	* @return the number of campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public static int getCampaignTrackingActionTotalsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingActionTotalsCount();
	}

	/**
	* Updates the campaign tracking action total in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingActionTotal the campaign tracking action total
	* @return the campaign tracking action total that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal updateCampaignTrackingActionTotal(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal campaignTrackingActionTotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCampaignTrackingActionTotal(campaignTrackingActionTotal);
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

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal addCampaignTrackingActionTotal(
		long campaignId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCampaignTrackingActionTotal(campaignId, alias,
			referrerClassName, referrerClassPK, eventType, count);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal addCampaignTrackingActionTotal(
		long campaignId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCampaignTrackingActionTotal(campaignId, alias,
			referrerClassName, referrerClassPK, elementId, eventType, count);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal addCampaignTrackingActionTotal(
		long campaignId, java.lang.String alias, java.lang.String elementId,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCampaignTrackingActionTotal(campaignId, alias,
			elementId, eventType, count);
	}

	public static void checkCampaignTrackingActionTotalEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().checkCampaignTrackingActionTotalEvents();
	}

	public static void checkCampaignTrackingActionTotalEvents(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().checkCampaignTrackingActionTotalEvents(campaignId);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> getCampaignTrackingActionsTotal(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingActionsTotal(campaignId);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> getCampaignTrackingActionsTotal(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCampaignTrackingActionsTotal(campaignId, modifiedDate);
	}

	public static java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> getCampaignTrackingActionsTotal(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCampaignTrackingActionsTotal(campaignId, start, end,
			orderByComparator);
	}

	public static int getCampaignTrackingActionsTotalCount(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignTrackingActionsTotalCount(campaignId);
	}

	public static com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal getCampaignTrackingActionTotal(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCampaignTrackingActionTotal(campaignId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

	public static void clearService() {
		_service = null;
	}

	public static CampaignTrackingActionTotalLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CampaignTrackingActionTotalLocalService.class.getName());

			if (invokableLocalService instanceof CampaignTrackingActionTotalLocalService) {
				_service = (CampaignTrackingActionTotalLocalService)invokableLocalService;
			}
			else {
				_service = new CampaignTrackingActionTotalLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CampaignTrackingActionTotalLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CampaignTrackingActionTotalLocalService service) {
	}

	private static CampaignTrackingActionTotalLocalService _service;
}