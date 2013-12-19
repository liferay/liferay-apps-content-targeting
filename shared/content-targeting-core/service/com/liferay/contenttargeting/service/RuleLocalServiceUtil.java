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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Rule. This utility wraps
 * {@link com.liferay.contenttargeting.service.impl.RuleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RuleLocalService
 * @see com.liferay.contenttargeting.service.base.RuleLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.impl.RuleLocalServiceImpl
 * @generated
 */
public class RuleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contenttargeting.service.impl.RuleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rule to the database. Also notifies the appropriate model listeners.
	*
	* @param rule the rule
	* @return the rule that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Rule addRule(
		com.liferay.contenttargeting.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRule(rule);
	}

	/**
	* Creates a new rule with the primary key. Does not add the rule to the database.
	*
	* @param ruleId the primary key for the new rule
	* @return the new rule
	*/
	public static com.liferay.contenttargeting.model.Rule createRule(
		long ruleId) {
		return getService().createRule(ruleId);
	}

	/**
	* Deletes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleId the primary key of the rule
	* @return the rule that was removed
	* @throws PortalException if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Rule deleteRule(
		long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRule(ruleId);
	}

	/**
	* Deletes the rule from the database. Also notifies the appropriate model listeners.
	*
	* @param rule the rule
	* @return the rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Rule deleteRule(
		com.liferay.contenttargeting.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRule(rule);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.contenttargeting.model.Rule fetchRule(long ruleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRule(ruleId);
	}

	/**
	* Returns the rule with the matching UUID and company.
	*
	* @param uuid the rule's UUID
	* @param companyId the primary key of the company
	* @return the matching rule, or <code>null</code> if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Rule fetchRuleByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRuleByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rule matching the UUID and group.
	*
	* @param uuid the rule's UUID
	* @param groupId the primary key of the group
	* @return the matching rule, or <code>null</code> if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Rule fetchRuleByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRuleByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the rule with the primary key.
	*
	* @param ruleId the primary key of the rule
	* @return the rule
	* @throws PortalException if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Rule getRule(long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRule(ruleId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.liferay.contenttargeting.model.Rule getRuleByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleByUuidAndCompanyId(uuid, companyId);
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
	public static com.liferay.contenttargeting.model.Rule getRuleByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.liferay.contenttargeting.model.Rule> getRules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRules(start, end);
	}

	/**
	* Returns the number of rules.
	*
	* @return the number of rules
	* @throws SystemException if a system exception occurred
	*/
	public static int getRulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRulesCount();
	}

	/**
	* Updates the rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rule the rule
	* @return the rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.Rule updateRule(
		com.liferay.contenttargeting.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRule(rule);
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

	public static com.liferay.contenttargeting.model.Rule addRule(long userId,
		java.lang.String type, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addRule(userId, type, typeSettings, serviceContext);
	}

	public static com.liferay.contenttargeting.model.Rule updateRule(
		long ruleId, java.lang.String type, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateRule(ruleId, type, typeSettings, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static RuleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RuleLocalService.class.getName());

			if (invokableLocalService instanceof RuleLocalService) {
				_service = (RuleLocalService)invokableLocalService;
			}
			else {
				_service = new RuleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RuleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RuleLocalService service) {
	}

	private static RuleLocalService _service;
}