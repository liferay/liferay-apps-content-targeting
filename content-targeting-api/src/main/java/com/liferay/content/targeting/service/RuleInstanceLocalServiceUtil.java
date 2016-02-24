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
 * Provides the local service utility for RuleInstance. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.RuleInstanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstanceLocalService
 * @see com.liferay.content.targeting.service.base.RuleInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.RuleInstanceLocalServiceImpl
 * @generated
 */
@ProviderType
public class RuleInstanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.RuleInstanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rule instance to the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was added
	*/
	public static com.liferay.content.targeting.model.RuleInstance addRuleInstance(
		com.liferay.content.targeting.model.RuleInstance ruleInstance) {
		return getService().addRuleInstance(ruleInstance);
	}

	public static com.liferay.content.targeting.model.RuleInstance addRuleInstance(
		long userId, java.lang.String ruleKey, long userSegmentId,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addRuleInstance(userId, ruleKey, userSegmentId,
			typeSettings, serviceContext);
	}

	/**
	* Creates a new rule instance with the primary key. Does not add the rule instance to the database.
	*
	* @param ruleInstanceId the primary key for the new rule instance
	* @return the new rule instance
	*/
	public static com.liferay.content.targeting.model.RuleInstance createRuleInstance(
		long ruleInstanceId) {
		return getService().createRuleInstance(ruleInstanceId);
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
	* Deletes the rule instance from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was removed
	* @throws PortalException
	*/
	public static com.liferay.content.targeting.model.RuleInstance deleteRuleInstance(
		com.liferay.content.targeting.model.RuleInstance ruleInstance)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRuleInstance(ruleInstance);
	}

	/**
	* Deletes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance that was removed
	* @throws PortalException if a rule instance with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.RuleInstance deleteRuleInstance(
		long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRuleInstance(ruleInstanceId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.content.targeting.model.RuleInstance fetchRuleInstance(
		long ruleInstanceId) {
		return getService().fetchRuleInstance(ruleInstanceId);
	}

	/**
	* Returns the rule instance matching the UUID and group.
	*
	* @param uuid the rule instance's UUID
	* @param groupId the primary key of the group
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static com.liferay.content.targeting.model.RuleInstance fetchRuleInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchRuleInstanceByUuidAndGroupId(uuid, groupId);
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
	* Returns the rule instance with the primary key.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance
	* @throws PortalException if a rule instance with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.RuleInstance getRuleInstance(
		long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRuleInstance(ruleInstanceId);
	}

	/**
	* Returns the rule instance matching the UUID and group.
	*
	* @param uuid the rule instance's UUID
	* @param groupId the primary key of the group
	* @return the matching rule instance
	* @throws PortalException if a matching rule instance could not be found
	*/
	public static com.liferay.content.targeting.model.RuleInstance getRuleInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRuleInstanceByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances(
		java.lang.String ruleKey, long userSegmentId) {
		return getService().getRuleInstances(ruleKey, userSegmentId);
	}

	/**
	* Returns a range of all the rule instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of rule instances
	*/
	public static java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances(
		int start, int end) {
		return getService().getRuleInstances(start, end);
	}

	public static java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances(
		long userSegmentId) {
		return getService().getRuleInstances(userSegmentId);
	}

	/**
	* Returns all the rule instances matching the UUID and company.
	*
	* @param uuid the UUID of the rule instances
	* @param companyId the primary key of the company
	* @return the matching rule instances, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getRuleInstancesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of rule instances matching the UUID and company.
	*
	* @param uuid the UUID of the rule instances
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching rule instances, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.RuleInstance> orderByComparator) {
		return getService()
				   .getRuleInstancesByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rule instances.
	*
	* @return the number of rule instances
	*/
	public static int getRuleInstancesCount() {
		return getService().getRuleInstancesCount();
	}

	public static long getRuleInstancesCount(java.lang.String ruleKey,
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRuleInstancesCount(ruleKey, userSegmentId);
	}

	public static long getRuleInstancesCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRuleInstancesCount(userSegmentId);
	}

	/**
	* Updates the rule instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was updated
	*/
	public static com.liferay.content.targeting.model.RuleInstance updateRuleInstance(
		com.liferay.content.targeting.model.RuleInstance ruleInstance) {
		return getService().updateRuleInstance(ruleInstance);
	}

	public static com.liferay.content.targeting.model.RuleInstance updateRuleInstance(
		long ruleInstanceId, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateRuleInstance(ruleInstanceId, typeSettings,
			serviceContext);
	}

	public static RuleInstanceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RuleInstanceLocalService, RuleInstanceLocalService> _serviceTracker =
		ServiceTrackerFactory.open(RuleInstanceLocalService.class);
}