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
 * Provides the local service utility for RuleInstance. This utility wraps
 * {@link com.liferay.contenttargeting.service.impl.RuleInstanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstanceLocalService
 * @see com.liferay.contenttargeting.service.base.RuleInstanceLocalServiceBaseImpl
 * @see com.liferay.contenttargeting.service.impl.RuleInstanceLocalServiceImpl
 * @generated
 */
public class RuleInstanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contenttargeting.service.impl.RuleInstanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rule instance to the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.RuleInstance addRuleInstance(
		com.liferay.contenttargeting.model.RuleInstance ruleInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRuleInstance(ruleInstance);
	}

	/**
	* Creates a new rule instance with the primary key. Does not add the rule instance to the database.
	*
	* @param ruleInstanceId the primary key for the new rule instance
	* @return the new rule instance
	*/
	public static com.liferay.contenttargeting.model.RuleInstance createRuleInstance(
		long ruleInstanceId) {
		return getService().createRuleInstance(ruleInstanceId);
	}

	/**
	* Deletes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance that was removed
	* @throws PortalException if a rule instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.RuleInstance deleteRuleInstance(
		long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRuleInstance(ruleInstanceId);
	}

	/**
	* Deletes the rule instance from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.RuleInstance deleteRuleInstance(
		com.liferay.contenttargeting.model.RuleInstance ruleInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRuleInstance(ruleInstance);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.contenttargeting.model.RuleInstance fetchRuleInstance(
		long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRuleInstance(ruleInstanceId);
	}

	/**
	* Returns the rule instance with the matching UUID and company.
	*
	* @param uuid the rule instance's UUID
	* @param companyId the primary key of the company
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.RuleInstance fetchRuleInstanceByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRuleInstanceByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rule instance matching the UUID and group.
	*
	* @param uuid the rule instance's UUID
	* @param groupId the primary key of the group
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.RuleInstance fetchRuleInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRuleInstanceByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the rule instance with the primary key.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance
	* @throws PortalException if a rule instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.RuleInstance getRuleInstance(
		long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleInstance(ruleInstanceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rule instance with the matching UUID and company.
	*
	* @param uuid the rule instance's UUID
	* @param companyId the primary key of the company
	* @return the matching rule instance
	* @throws PortalException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.RuleInstance getRuleInstanceByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleInstanceByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the rule instance matching the UUID and group.
	*
	* @param uuid the rule instance's UUID
	* @param groupId the primary key of the group
	* @return the matching rule instance
	* @throws PortalException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.RuleInstance getRuleInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleInstanceByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the rule instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of rule instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contenttargeting.model.RuleInstance> getRuleInstances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleInstances(start, end);
	}

	/**
	* Returns the number of rule instances.
	*
	* @return the number of rule instances
	* @throws SystemException if a system exception occurred
	*/
	public static int getRuleInstancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleInstancesCount();
	}

	/**
	* Updates the rule instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ruleInstance the rule instance
	* @return the rule instance that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contenttargeting.model.RuleInstance updateRuleInstance(
		com.liferay.contenttargeting.model.RuleInstance ruleInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRuleInstance(ruleInstance);
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

	public static com.liferay.contenttargeting.model.RuleInstance addRuleInstance(
		long userId, java.lang.String ruleKey, long userSegmentId,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addRuleInstance(userId, ruleKey, userSegmentId,
			typeSettings, serviceContext);
	}

	public static java.util.List<com.liferay.contenttargeting.model.RuleInstance> getRuleInstances(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleInstances(userSegmentId);
	}

	public static java.util.List<com.liferay.contenttargeting.model.RuleInstance> getRuleInstances(
		java.lang.String ruleKey, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleInstances(ruleKey, userSegmentId);
	}

	public static long getRuleInstancesCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleInstancesCount(userSegmentId);
	}

	public static long getRuleInstancesCount(java.lang.String ruleKey,
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRuleInstancesCount(ruleKey, userSegmentId);
	}

	public static com.liferay.contenttargeting.model.RuleInstance updateRuleInstance(
		long ruleInstanceId, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateRuleInstance(ruleInstanceId, typeSettings,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static RuleInstanceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RuleInstanceLocalService.class.getName());

			if (invokableLocalService instanceof RuleInstanceLocalService) {
				_service = (RuleInstanceLocalService)invokableLocalService;
			}
			else {
				_service = new RuleInstanceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RuleInstanceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RuleInstanceLocalService service) {
	}

	private static RuleInstanceLocalService _service;
}