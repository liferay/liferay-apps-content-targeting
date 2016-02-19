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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReportInstanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstanceLocalService
 * @generated
 */
@ProviderType
public class ReportInstanceLocalServiceWrapper
	implements ReportInstanceLocalService,
		ServiceWrapper<ReportInstanceLocalService> {
	public ReportInstanceLocalServiceWrapper(
		ReportInstanceLocalService reportInstanceLocalService) {
		_reportInstanceLocalService = reportInstanceLocalService;
	}

	/**
	* Adds the report instance to the database. Also notifies the appropriate model listeners.
	*
	* @param reportInstance the report instance
	* @return the report instance that was added
	*/
	@Override
	public com.liferay.content.targeting.model.ReportInstance addReportInstance(
		com.liferay.content.targeting.model.ReportInstance reportInstance) {
		return _reportInstanceLocalService.addReportInstance(reportInstance);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance addReportInstance(
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceLocalService.addReportInstance(userId, reportKey,
			className, classPK, nameMap, descriptionMap, typeSettings,
			serviceContext);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance addReportInstance(
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceLocalService.addReportInstance(userId, reportKey,
			className, classPK, typeSettings, serviceContext);
	}

	/**
	* Creates a new report instance with the primary key. Does not add the report instance to the database.
	*
	* @param reportInstanceId the primary key for the new report instance
	* @return the new report instance
	*/
	@Override
	public com.liferay.content.targeting.model.ReportInstance createReportInstance(
		long reportInstanceId) {
		return _reportInstanceLocalService.createReportInstance(reportInstanceId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the report instance from the database. Also notifies the appropriate model listeners.
	*
	* @param reportInstance the report instance
	* @return the report instance that was removed
	*/
	@Override
	public com.liferay.content.targeting.model.ReportInstance deleteReportInstance(
		com.liferay.content.targeting.model.ReportInstance reportInstance) {
		return _reportInstanceLocalService.deleteReportInstance(reportInstance);
	}

	/**
	* Deletes the report instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance that was removed
	* @throws PortalException if a report instance with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.ReportInstance deleteReportInstance(
		long reportInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceLocalService.deleteReportInstance(reportInstanceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _reportInstanceLocalService.dynamicQuery();
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
		return _reportInstanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _reportInstanceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _reportInstanceLocalService.dynamicQuery(dynamicQuery, start,
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
		return _reportInstanceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _reportInstanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		long reportInstanceId) {
		return _reportInstanceLocalService.fetchReportInstance(reportInstanceId);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		java.lang.String reportKey, java.lang.String className, long classPK) {
		return _reportInstanceLocalService.fetchReportInstance(reportKey,
			className, classPK);
	}

	/**
	* Returns the report instance matching the UUID and group.
	*
	* @param uuid the report instance's UUID
	* @param groupId the primary key of the group
	* @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.ReportInstance fetchReportInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _reportInstanceLocalService.fetchReportInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findReportInstances(
		java.lang.String reportKey, java.lang.String className, long classPK) {
		return _reportInstanceLocalService.findReportInstances(reportKey,
			className, classPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _reportInstanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _reportInstanceLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _reportInstanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _reportInstanceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.content.targeting.api.model.Report getReport(
		java.lang.String reportKey) {
		return _reportInstanceLocalService.getReport(reportKey);
	}

	/**
	* Returns the report instance with the primary key.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance
	* @throws PortalException if a report instance with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.ReportInstance getReportInstance(
		long reportInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceLocalService.getReportInstance(reportInstanceId);
	}

	/**
	* Returns the report instance matching the UUID and group.
	*
	* @param uuid the report instance's UUID
	* @param groupId the primary key of the group
	* @return the matching report instance
	* @throws PortalException if a matching report instance could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.ReportInstance getReportInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceLocalService.getReportInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public int getReportInstanceCount(java.lang.String reportKey,
		java.lang.String className, long classPK) {
		return _reportInstanceLocalService.getReportInstanceCount(reportKey,
			className, classPK);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstances(
		java.lang.String className, long classPK) {
		return _reportInstanceLocalService.getReportInstances(className, classPK);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstances(
		java.lang.String className, long classPK, int start, int end) {
		return _reportInstanceLocalService.getReportInstances(className,
			classPK, start, end);
	}

	/**
	* Returns a range of all the report instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of report instances
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstances(
		int start, int end) {
		return _reportInstanceLocalService.getReportInstances(start, end);
	}

	/**
	* Returns all the report instances matching the UUID and company.
	*
	* @param uuid the UUID of the report instances
	* @param companyId the primary key of the company
	* @return the matching report instances, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _reportInstanceLocalService.getReportInstancesByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of report instances matching the UUID and company.
	*
	* @param uuid the UUID of the report instances
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching report instances, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.ReportInstance> orderByComparator) {
		return _reportInstanceLocalService.getReportInstancesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of report instances.
	*
	* @return the number of report instances
	*/
	@Override
	public int getReportInstancesCount() {
		return _reportInstanceLocalService.getReportInstancesCount();
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> searchReportInstances(
		long groupId, java.lang.String className, long classPK,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceLocalService.searchReportInstances(groupId,
			className, classPK, keywords, start, end);
	}

	/**
	* Updates the report instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param reportInstance the report instance
	* @return the report instance that was updated
	*/
	@Override
	public com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		com.liferay.content.targeting.model.ReportInstance reportInstance) {
		return _reportInstanceLocalService.updateReportInstance(reportInstance);
	}

	@Override
	public com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		long reportInstanceId, long userId, java.lang.String reportKey,
		java.lang.String className, long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _reportInstanceLocalService.updateReportInstance(reportInstanceId,
			userId, reportKey, className, classPK, nameMap, descriptionMap,
			typeSettings, serviceContext);
	}

	@Override
	public ReportInstanceLocalService getWrappedService() {
		return _reportInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		ReportInstanceLocalService reportInstanceLocalService) {
		_reportInstanceLocalService = reportInstanceLocalService;
	}

	private ReportInstanceLocalService _reportInstanceLocalService;
}