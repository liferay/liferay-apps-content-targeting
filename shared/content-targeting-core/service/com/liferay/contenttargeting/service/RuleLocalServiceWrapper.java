/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RuleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RuleLocalService
 * @generated
 */
public class RuleLocalServiceWrapper implements RuleLocalService,
	ServiceWrapper<RuleLocalService> {
	public RuleLocalServiceWrapper(RuleLocalService ruleLocalService) {
		_ruleLocalService = ruleLocalService;
	}

	/**
	* Adds the rule to the database. Also notifies the appropriate model listeners.
	*
	* @param rule the rule
	* @return the rule that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Rule addRule(
		com.liferay.contenttargeting.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.addRule(rule);
	}

	/**
	* Creates a new rule with the primary key. Does not add the rule to the database.
	*
	* @param ruleId the primary key for the new rule
	* @return the new rule
	*/
	@Override
	public com.liferay.contenttargeting.model.Rule createRule(long ruleId) {
		return _ruleLocalService.createRule(ruleId);
	}

	/**
	* Deletes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleId the primary key of the rule
	* @return the rule that was removed
	* @throws PortalException if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Rule deleteRule(long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.deleteRule(ruleId);
	}

	/**
	* Deletes the rule from the database. Also notifies the appropriate model listeners.
	*
	* @param rule the rule
	* @return the rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Rule deleteRule(
		com.liferay.contenttargeting.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.deleteRule(rule);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ruleLocalService.dynamicQuery();
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
		return _ruleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ruleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ruleLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _ruleLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ruleLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.contenttargeting.model.Rule fetchRule(long ruleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.fetchRule(ruleId);
	}

	/**
	* Returns the rule with the matching UUID and company.
	*
	* @param uuid the rule's UUID
	* @param companyId the primary key of the company
	* @return the matching rule, or <code>null</code> if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Rule fetchRuleByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.fetchRuleByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rule matching the UUID and group.
	*
	* @param uuid the rule's UUID
	* @param groupId the primary key of the group
	* @return the matching rule, or <code>null</code> if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Rule fetchRuleByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.fetchRuleByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the rule with the primary key.
	*
	* @param ruleId the primary key of the rule
	* @return the rule
	* @throws PortalException if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Rule getRule(long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRule(ruleId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rule with the matching UUID and company.
	*
	* @param uuid the rule's UUID
	* @param companyId the primary key of the company
	* @return the matching rule
	* @throws PortalException if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Rule getRuleByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRuleByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rule matching the UUID and group.
	*
	* @param uuid the rule's UUID
	* @param groupId the primary key of the group
	* @return the matching rule
	* @throws PortalException if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Rule getRuleByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRuleByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rules
	* @param end the upper bound of the range of rules (not inclusive)
	* @return the range of rules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contenttargeting.model.Rule> getRules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRules(start, end);
	}

	/**
	* Returns the number of rules.
	*
	* @return the number of rules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.getRulesCount();
	}

	/**
	* Updates the rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rule the rule
	* @return the rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.Rule updateRule(
		com.liferay.contenttargeting.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.updateRule(rule);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ruleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ruleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ruleLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.contenttargeting.model.Rule addRule(long userId,
		java.lang.String type, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.addRule(userId, type, typeSettings,
			serviceContext);
	}

	@Override
	public com.liferay.contenttargeting.model.Rule updateRule(long ruleId,
		java.lang.String type, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ruleLocalService.updateRule(ruleId, type, typeSettings,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RuleLocalService getWrappedRuleLocalService() {
		return _ruleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRuleLocalService(RuleLocalService ruleLocalService) {
		_ruleLocalService = ruleLocalService;
	}

	@Override
	public RuleLocalService getWrappedService() {
		return _ruleLocalService;
	}

	@Override
	public void setWrappedService(RuleLocalService ruleLocalService) {
		_ruleLocalService = ruleLocalService;
	}

	private RuleLocalService _ruleLocalService;
}