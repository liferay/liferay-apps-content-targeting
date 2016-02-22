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
 * Provides the local service utility for ReportInstance. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.ReportInstanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstanceLocalService
 * @see com.liferay.content.targeting.service.base.ReportInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.ReportInstanceLocalServiceImpl
 * @generated
 */
@ProviderType
public class ReportInstanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.ReportInstanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the report instance to the database. Also notifies the appropriate model listeners.
	*
	* @param reportInstance the report instance
	* @return the report instance that was added
	*/
	public static com.liferay.content.targeting.model.ReportInstance addReportInstance(
		com.liferay.content.targeting.model.ReportInstance reportInstance) {
		return getService().addReportInstance(reportInstance);
	}

	public static com.liferay.content.targeting.model.ReportInstance addReportInstance(
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addReportInstance(userId, reportKey, className, classPK,
			nameMap, descriptionMap, typeSettings, serviceContext);
	}

	public static com.liferay.content.targeting.model.ReportInstance addReportInstance(
		long userId, java.lang.String reportKey, java.lang.String className,
		long classPK, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addReportInstance(userId, reportKey, className, classPK,
			typeSettings, serviceContext);
	}

	/**
	* Creates a new report instance with the primary key. Does not add the report instance to the database.
	*
	* @param reportInstanceId the primary key for the new report instance
	* @return the new report instance
	*/
	public static com.liferay.content.targeting.model.ReportInstance createReportInstance(
		long reportInstanceId) {
		return getService().createReportInstance(reportInstanceId);
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
	* Deletes the report instance from the database. Also notifies the appropriate model listeners.
	*
	* @param reportInstance the report instance
	* @return the report instance that was removed
	*/
	public static com.liferay.content.targeting.model.ReportInstance deleteReportInstance(
		com.liferay.content.targeting.model.ReportInstance reportInstance) {
		return getService().deleteReportInstance(reportInstance);
	}

	/**
	* Deletes the report instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance that was removed
	* @throws PortalException if a report instance with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.ReportInstance deleteReportInstance(
		long reportInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteReportInstance(reportInstanceId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		long reportInstanceId) {
		return getService().fetchReportInstance(reportInstanceId);
	}

	public static com.liferay.content.targeting.model.ReportInstance fetchReportInstance(
		java.lang.String reportKey, java.lang.String className, long classPK) {
		return getService().fetchReportInstance(reportKey, className, classPK);
	}

	/**
	* Returns the report instance matching the UUID and group.
	*
	* @param uuid the report instance's UUID
	* @param groupId the primary key of the group
	* @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static com.liferay.content.targeting.model.ReportInstance fetchReportInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchReportInstanceByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> findReportInstances(
		java.lang.String reportKey, java.lang.String className, long classPK) {
		return getService().findReportInstances(reportKey, className, classPK);
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

	public static com.liferay.content.targeting.api.model.Report getReport(
		java.lang.String reportKey) {
		return getService().getReport(reportKey);
	}

	/**
	* Returns the report instance with the primary key.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance
	* @throws PortalException if a report instance with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.ReportInstance getReportInstance(
		long reportInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getReportInstance(reportInstanceId);
	}

	/**
	* Returns the report instance matching the UUID and group.
	*
	* @param uuid the report instance's UUID
	* @param groupId the primary key of the group
	* @return the matching report instance
	* @throws PortalException if a matching report instance could not be found
	*/
	public static com.liferay.content.targeting.model.ReportInstance getReportInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getReportInstanceByUuidAndGroupId(uuid, groupId);
	}

	public static int getReportInstanceCount(java.lang.String reportKey,
		java.lang.String className, long classPK) {
		return getService().getReportInstanceCount(reportKey, className, classPK);
	}

	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstances(
		java.lang.String className, long classPK) {
		return getService().getReportInstances(className, classPK);
	}

	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstances(
		java.lang.String className, long classPK, int start, int end) {
		return getService().getReportInstances(className, classPK, start, end);
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
	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstances(
		int start, int end) {
		return getService().getReportInstances(start, end);
	}

	/**
	* Returns all the report instances matching the UUID and company.
	*
	* @param uuid the UUID of the report instances
	* @param companyId the primary key of the company
	* @return the matching report instances, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getReportInstancesByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> getReportInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.ReportInstance> orderByComparator) {
		return getService()
				   .getReportInstancesByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of report instances.
	*
	* @return the number of report instances
	*/
	public static int getReportInstancesCount() {
		return getService().getReportInstancesCount();
	}

	public static java.util.List<com.liferay.content.targeting.model.ReportInstance> searchReportInstances(
		long groupId, java.lang.String className, long classPK,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .searchReportInstances(groupId, className, classPK,
			keywords, start, end);
	}

	/**
	* Updates the report instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param reportInstance the report instance
	* @return the report instance that was updated
	*/
	public static com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		com.liferay.content.targeting.model.ReportInstance reportInstance) {
		return getService().updateReportInstance(reportInstance);
	}

	public static com.liferay.content.targeting.model.ReportInstance updateReportInstance(
		long reportInstanceId, long userId, java.lang.String reportKey,
		java.lang.String className, long classPK,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateReportInstance(reportInstanceId, userId, reportKey,
			className, classPK, nameMap, descriptionMap, typeSettings,
			serviceContext);
	}

	public static ReportInstanceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReportInstanceLocalService, ReportInstanceLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ReportInstanceLocalService.class);
}