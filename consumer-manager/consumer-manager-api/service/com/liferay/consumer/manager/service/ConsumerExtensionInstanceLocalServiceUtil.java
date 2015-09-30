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

package com.liferay.consumer.manager.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ConsumerExtensionInstance. This utility wraps
 * {@link com.liferay.consumer.manager.service.impl.ConsumerExtensionInstanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerExtensionInstanceLocalService
 * @see com.liferay.consumer.manager.service.base.ConsumerExtensionInstanceLocalServiceBaseImpl
 * @see com.liferay.consumer.manager.service.impl.ConsumerExtensionInstanceLocalServiceImpl
 * @generated
 */
public class ConsumerExtensionInstanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.consumer.manager.service.impl.ConsumerExtensionInstanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the consumer extension instance to the database. Also notifies the appropriate model listeners.
	*
	* @param consumerExtensionInstance the consumer extension instance
	* @return the consumer extension instance that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance addConsumerExtensionInstance(
		com.liferay.consumer.manager.model.ConsumerExtensionInstance consumerExtensionInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addConsumerExtensionInstance(consumerExtensionInstance);
	}

	/**
	* Creates a new consumer extension instance with the primary key. Does not add the consumer extension instance to the database.
	*
	* @param consumerExtensionInstanceId the primary key for the new consumer extension instance
	* @return the new consumer extension instance
	*/
	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance createConsumerExtensionInstance(
		long consumerExtensionInstanceId) {
		return getService()
				   .createConsumerExtensionInstance(consumerExtensionInstanceId);
	}

	/**
	* Deletes the consumer extension instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerExtensionInstanceId the primary key of the consumer extension instance
	* @return the consumer extension instance that was removed
	* @throws PortalException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance deleteConsumerExtensionInstance(
		long consumerExtensionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteConsumerExtensionInstance(consumerExtensionInstanceId);
	}

	/**
	* Deletes the consumer extension instance from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerExtensionInstance the consumer extension instance
	* @return the consumer extension instance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance deleteConsumerExtensionInstance(
		com.liferay.consumer.manager.model.ConsumerExtensionInstance consumerExtensionInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteConsumerExtensionInstance(consumerExtensionInstance);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchConsumerExtensionInstance(
		long consumerExtensionInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchConsumerExtensionInstance(consumerExtensionInstanceId);
	}

	/**
	* Returns the consumer extension instance with the matching UUID and company.
	*
	* @param uuid the consumer extension instance's UUID
	* @param companyId the primary key of the company
	* @return the matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchConsumerExtensionInstanceByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchConsumerExtensionInstanceByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the consumer extension instance with the primary key.
	*
	* @param consumerExtensionInstanceId the primary key of the consumer extension instance
	* @return the consumer extension instance
	* @throws PortalException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance getConsumerExtensionInstance(
		long consumerExtensionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getConsumerExtensionInstance(consumerExtensionInstanceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the consumer extension instance with the matching UUID and company.
	*
	* @param uuid the consumer extension instance's UUID
	* @param companyId the primary key of the company
	* @return the matching consumer extension instance
	* @throws PortalException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance getConsumerExtensionInstanceByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getConsumerExtensionInstanceByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of all the consumer extension instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @return the range of consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> getConsumerExtensionInstances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumerExtensionInstances(start, end);
	}

	/**
	* Returns the number of consumer extension instances.
	*
	* @return the number of consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public static int getConsumerExtensionInstancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumerExtensionInstancesCount();
	}

	/**
	* Updates the consumer extension instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param consumerExtensionInstance the consumer extension instance
	* @return the consumer extension instance that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance updateConsumerExtensionInstance(
		com.liferay.consumer.manager.model.ConsumerExtensionInstance consumerExtensionInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateConsumerExtensionInstance(consumerExtensionInstance);
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

	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance addConsumerExtensionInstance(
		java.lang.String consumerExtensionKey, long consumerId,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addConsumerExtensionInstance(consumerExtensionKey,
			consumerId, typeSettings, serviceContext);
	}

	public static java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> getConsumerExtensionInstances(
		long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumerExtensionInstances(consumerId);
	}

	public static java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> getConsumerExtensionInstances(
		long consumerId, java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getConsumerExtensionInstances(consumerId,
			consumerExtensionKey);
	}

	public static com.liferay.consumer.manager.model.ConsumerExtensionInstance updateConsumerExtensionInstance(
		long consumerExtensionInstanceId,
		java.lang.String consumerExtensionKey, long consumerId,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateConsumerExtensionInstance(consumerExtensionInstanceId,
			consumerExtensionKey, consumerId, typeSettings, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ConsumerExtensionInstanceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ConsumerExtensionInstanceLocalService.class.getName());

			if (invokableLocalService instanceof ConsumerExtensionInstanceLocalService) {
				_service = (ConsumerExtensionInstanceLocalService)invokableLocalService;
			}
			else {
				_service = new ConsumerExtensionInstanceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ConsumerExtensionInstanceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ConsumerExtensionInstanceLocalService service) {
	}

	private static ConsumerExtensionInstanceLocalService _service;
}