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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CTActionTotalLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotalLocalService
 * @generated
 */
@ProviderType
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
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal addCTActionTotal(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal) {
		return _ctActionTotalLocalService.addCTActionTotal(ctActionTotal);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal addCTActionTotal(
		long reportInstanceId, java.lang.String alias,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.addCTActionTotal(reportInstanceId,
			alias, elementId, eventType, count);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal addCTActionTotal(
		long reportInstanceId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.addCTActionTotal(reportInstanceId,
			alias, referrerClassName, referrerClassPK, elementId, eventType,
			count);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal addCTActionTotal(
		long reportInstanceId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.addCTActionTotal(reportInstanceId,
			alias, referrerClassName, referrerClassPK, eventType, count);
	}

	@Override
	public void checkCTActionTotalEvents()
		throws com.liferay.portal.kernel.exception.PortalException {
		_ctActionTotalLocalService.checkCTActionTotalEvents();
	}

	@Override
	public void checkCTActionTotalEvents(long reportInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_ctActionTotalLocalService.checkCTActionTotalEvents(reportInstanceId);
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
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal deleteCTActionTotal(
		long CTActionTotalId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.deleteCTActionTotal(CTActionTotalId);
	}

	/**
	* Deletes the c t action total from the database. Also notifies the appropriate model listeners.
	*
	* @param ctActionTotal the c t action total
	* @return the c t action total that was removed
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal deleteCTActionTotal(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal) {
		return _ctActionTotalLocalService.deleteCTActionTotal(ctActionTotal);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.deletePersistedModel(persistedModel);
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _ctActionTotalLocalService.dynamicQuery(dynamicQuery, start,
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
		return _ctActionTotalLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ctActionTotalLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal fetchCTActionTotal(
		long CTActionTotalId) {
		return _ctActionTotalLocalService.fetchCTActionTotal(CTActionTotalId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ctActionTotalLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the c t action total with the primary key.
	*
	* @param CTActionTotalId the primary key of the c t action total
	* @return the c t action total
	* @throws PortalException if a c t action total with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal getCTActionTotal(
		long CTActionTotalId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.getCTActionTotal(CTActionTotalId);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal getCTActionTotal(
		long reportInstanceId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.getCTActionTotal(reportInstanceId,
			referrerClassName, referrerClassPK, elementId, eventType);
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
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> getCTActionTotals(
		int start, int end) {
		return _ctActionTotalLocalService.getCTActionTotals(start, end);
	}

	/**
	* Returns the number of c t action totals.
	*
	* @return the number of c t action totals
	*/
	@Override
	public int getCTActionTotalsCount() {
		return _ctActionTotalLocalService.getCTActionTotalsCount();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> getCTActionsTotal(
		long reportInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.getCTActionsTotal(reportInstanceId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> getCTActionsTotal(
		long reportInstanceId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.getCTActionsTotal(reportInstanceId,
			modifiedDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal> getCTActionsTotal(
		long reportInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.getCTActionsTotal(reportInstanceId,
			start, end, orderByComparator);
	}

	@Override
	public int getCTActionsTotalCount(long reportInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.getCTActionsTotalCount(reportInstanceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ctActionTotalLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _ctActionTotalLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ctActionTotalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the c t action total in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ctActionTotal the c t action total
	* @return the c t action total that was updated
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal updateCTActionTotal(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal) {
		return _ctActionTotalLocalService.updateCTActionTotal(ctActionTotal);
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