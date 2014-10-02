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
 * Provides a wrapper for {@link CTActionTotalLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotalLocalService
 * @generated
 */
public class CTActionTotalLocalServiceWrapper
	implements CTActionTotalLocalService,
		ServiceWrapper<CTActionTotalLocalService> {
	public CTActionTotalLocalServiceWrapper(
		CTActionTotalLocalService ctActionTotalLocalService) {
		_ctActionTotalLocalService = ctActionTotalLocalService;
	}

	/**
	* Adds the c t action total to the database. Also notifies the appropriate model listeners.
	*
	* @param ctActionTotal the c t action total
	* @return the c t action total that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal addCTActionTotal(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.addCTActionTotal(ctActionTotal);
	}

	/**
	* Creates a new c t action total with the primary key. Does not add the c t action total to the database.
	*
	* @param CTActionTotalId the primary key for the new c t action total
	* @return the new c t action total
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal createCTActionTotal(
		long CTActionTotalId) {
		return _ctActionTotalLocalService.createCTActionTotal(CTActionTotalId);
	}

	/**
	* Deletes the c t action total with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total that was removed
	* @throws PortalException if a c t action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal deleteCTActionTotal(
		long CTActionTotalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.deleteCTActionTotal(CTActionTotalId);
	}

	/**
	* Deletes the c t action total from the database. Also notifies the appropriate model listeners.
	*
	* @param ctActionTotal the c t action total
	* @return the c t action total that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal deleteCTActionTotal(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.deleteCTActionTotal(ctActionTotal);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ctActionTotalLocalService.dynamicQuery();
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
		return _ctActionTotalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ctActionTotalLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ctActionTotalLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _ctActionTotalLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ctActionTotalLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchCTActionTotal(
		long CTActionTotalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.fetchCTActionTotal(CTActionTotalId);
	}

	/**
	* Returns the c t action total with the primary key.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total
	* @throws PortalException if a c t action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal getCTActionTotal(
		long CTActionTotalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.getCTActionTotal(CTActionTotalId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the c t action totals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t action totals
	* @param end the upper bound of the range of c t action totals (not inclusive)
	* @return the range of c t action totals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> getCTActionTotals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.getCTActionTotals(start, end);
	}

	/**
	* Returns the number of c t action totals.
	*
	* @return the number of c t action totals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCTActionTotalsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.getCTActionTotalsCount();
	}

	/**
	* Updates the c t action total in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ctActionTotal the c t action total
	* @return the c t action total that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal updateCTActionTotal(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.updateCTActionTotal(ctActionTotal);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ctActionTotalLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ctActionTotalLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ctActionTotalLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal addCTActionTotal(
		long campaignId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.addCTActionTotal(campaignId, alias,
			referrerClassName, referrerClassPK, eventType, count);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal addCTActionTotal(
		long campaignId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.addCTActionTotal(campaignId, alias,
			referrerClassName, referrerClassPK, elementId, eventType, count);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal addCTActionTotal(
		long campaignId, java.lang.String alias, java.lang.String elementId,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.addCTActionTotal(campaignId, alias,
			elementId, eventType, count);
	}

	@Override
	public void checkCTActionTotalEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ctActionTotalLocalService.checkCTActionTotalEvents();
	}

	@Override
	public void checkCTActionTotalEvents(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ctActionTotalLocalService.checkCTActionTotalEvents(campaignId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> getCTActionsTotal(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.getCTActionsTotal(campaignId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> getCTActionsTotal(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.getCTActionsTotal(campaignId,
			modifiedDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> getCTActionsTotal(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.getCTActionsTotal(campaignId, start,
			end, orderByComparator);
	}

	@Override
	public int getCTActionsTotalCount(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.getCTActionsTotalCount(campaignId);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal getCTActionTotal(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctActionTotalLocalService.getCTActionTotal(campaignId,
			referrerClassName, referrerClassPK, elementId, eventType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CTActionTotalLocalService getWrappedCTActionTotalLocalService() {
		return _ctActionTotalLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCTActionTotalLocalService(
		CTActionTotalLocalService ctActionTotalLocalService) {
		_ctActionTotalLocalService = ctActionTotalLocalService;
	}

	@Override
	public CTActionTotalLocalService getWrappedService() {
		return _ctActionTotalLocalService;
	}

	@Override
	public void setWrappedService(
		CTActionTotalLocalService ctActionTotalLocalService) {
		_ctActionTotalLocalService = ctActionTotalLocalService;
	}

	private CTActionTotalLocalService _ctActionTotalLocalService;
}