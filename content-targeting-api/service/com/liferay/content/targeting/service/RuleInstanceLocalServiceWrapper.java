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
 * Provides a wrapper for {@link RuleInstanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstanceLocalService
 * @generated
 */
@ProviderType
public class RuleInstanceLocalServiceWrapper implements RuleInstanceLocalService,
	ServiceWrapper<RuleInstanceLocalService> {
	public RuleInstanceLocalServiceWrapper(
		RuleInstanceLocalService ruleInstanceLocalService) {
		_ruleInstanceLocalService = ruleInstanceLocalService;
	}

	/**
	* Adds the rule instance to the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was added
	*/
	@Override
	public com.liferay.content.targeting.model.RuleInstance addRuleInstance(
		com.liferay.content.targeting.model.RuleInstance ruleInstance) {
		return _ruleInstanceLocalService.addRuleInstance(ruleInstance);
	}

	@Override
	public com.liferay.content.targeting.model.RuleInstance addRuleInstance(
		long userId, java.lang.String ruleKey, long userSegmentId,
		java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceLocalService.addRuleInstance(userId, ruleKey,
			userSegmentId, typeSettings, serviceContext);
	}

	/**
	* Creates a new rule instance with the primary key. Does not add the rule instance to the database.
	*
	* @param ruleInstanceId the primary key for the new rule instance
	* @return the new rule instance
	*/
	@Override
	public com.liferay.content.targeting.model.RuleInstance createRuleInstance(
		long ruleInstanceId) {
		return _ruleInstanceLocalService.createRuleInstance(ruleInstanceId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the rule instance from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was removed
	* @throws PortalException
	*/
	@Override
	public com.liferay.content.targeting.model.RuleInstance deleteRuleInstance(
		com.liferay.content.targeting.model.RuleInstance ruleInstance)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceLocalService.deleteRuleInstance(ruleInstance);
	}

	/**
	* Deletes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance that was removed
	* @throws PortalException if a rule instance with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.RuleInstance deleteRuleInstance(
		long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceLocalService.deleteRuleInstance(ruleInstanceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ruleInstanceLocalService.dynamicQuery();
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
		return _ruleInstanceLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _ruleInstanceLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _ruleInstanceLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _ruleInstanceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ruleInstanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.model.RuleInstance fetchRuleInstance(
		long ruleInstanceId) {
		return _ruleInstanceLocalService.fetchRuleInstance(ruleInstanceId);
	}

	/**
	* Returns the rule instance matching the UUID and group.
	*
	* @param uuid the rule instance's UUID
	* @param groupId the primary key of the group
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.RuleInstance fetchRuleInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _ruleInstanceLocalService.fetchRuleInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ruleInstanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _ruleInstanceLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ruleInstanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _ruleInstanceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rule instance with the primary key.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance
	* @throws PortalException if a rule instance with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.RuleInstance getRuleInstance(
		long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceLocalService.getRuleInstance(ruleInstanceId);
	}

	/**
	* Returns the rule instance matching the UUID and group.
	*
	* @param uuid the rule instance's UUID
	* @param groupId the primary key of the group
	* @return the matching rule instance
	* @throws PortalException if a matching rule instance could not be found
	*/
	@Override
	public com.liferay.content.targeting.model.RuleInstance getRuleInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceLocalService.getRuleInstanceByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances(
		java.lang.String ruleKey, long userSegmentId) {
		return _ruleInstanceLocalService.getRuleInstances(ruleKey, userSegmentId);
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
	@Override
	public java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances(
		int start, int end) {
		return _ruleInstanceLocalService.getRuleInstances(start, end);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstances(
		long userSegmentId) {
		return _ruleInstanceLocalService.getRuleInstances(userSegmentId);
	}

	/**
	* Returns all the rule instances matching the UUID and company.
	*
	* @param uuid the UUID of the rule instances
	* @param companyId the primary key of the company
	* @return the matching rule instances, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _ruleInstanceLocalService.getRuleInstancesByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<com.liferay.content.targeting.model.RuleInstance> getRuleInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.RuleInstance> orderByComparator) {
		return _ruleInstanceLocalService.getRuleInstancesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rule instances.
	*
	* @return the number of rule instances
	*/
	@Override
	public int getRuleInstancesCount() {
		return _ruleInstanceLocalService.getRuleInstancesCount();
	}

	@Override
	public long getRuleInstancesCount(java.lang.String ruleKey,
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceLocalService.getRuleInstancesCount(ruleKey,
			userSegmentId);
	}

	@Override
	public long getRuleInstancesCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceLocalService.getRuleInstancesCount(userSegmentId);
	}

	/**
	* Updates the rule instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was updated
	*/
	@Override
	public com.liferay.content.targeting.model.RuleInstance updateRuleInstance(
		com.liferay.content.targeting.model.RuleInstance ruleInstance) {
		return _ruleInstanceLocalService.updateRuleInstance(ruleInstance);
	}

	@Override
	public com.liferay.content.targeting.model.RuleInstance updateRuleInstance(
		long ruleInstanceId, java.lang.String typeSettings,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ruleInstanceLocalService.updateRuleInstance(ruleInstanceId,
			typeSettings, serviceContext);
	}

	@Override
	public RuleInstanceLocalService getWrappedService() {
		return _ruleInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		RuleInstanceLocalService ruleInstanceLocalService) {
		_ruleInstanceLocalService = ruleInstanceLocalService;
	}

	private RuleInstanceLocalService _ruleInstanceLocalService;
}