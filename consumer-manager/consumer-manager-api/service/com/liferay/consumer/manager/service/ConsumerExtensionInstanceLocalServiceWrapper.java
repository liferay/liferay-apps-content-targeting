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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConsumerExtensionInstanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerExtensionInstanceLocalService
 * @generated
 */
public class ConsumerExtensionInstanceLocalServiceWrapper
	implements ConsumerExtensionInstanceLocalService,
		ServiceWrapper<ConsumerExtensionInstanceLocalService> {
	public ConsumerExtensionInstanceLocalServiceWrapper(
		ConsumerExtensionInstanceLocalService consumerExtensionInstanceLocalService) {
		_consumerExtensionInstanceLocalService = consumerExtensionInstanceLocalService;
	}

	/**
	* Adds the consumer extension instance to the database. Also notifies the appropriate model listeners.
	*
	* @param consumerExtensionInstance the consumer extension instance
	* @return the consumer extension instance that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance addConsumerExtensionInstance(
		com.liferay.consumer.manager.model.ConsumerExtensionInstance consumerExtensionInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.addConsumerExtensionInstance(consumerExtensionInstance);
	}

	/**
	* Creates a new consumer extension instance with the primary key. Does not add the consumer extension instance to the database.
	*
	* @param consumerExtensionInstanceId the primary key for the new consumer extension instance
	* @return the new consumer extension instance
	*/
	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance createConsumerExtensionInstance(
		long consumerExtensionInstanceId) {
		return _consumerExtensionInstanceLocalService.createConsumerExtensionInstance(consumerExtensionInstanceId);
	}

	/**
	* Deletes the consumer extension instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerExtensionInstanceId the primary key of the consumer extension instance
	* @return the consumer extension instance that was removed
	* @throws PortalException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance deleteConsumerExtensionInstance(
		long consumerExtensionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.deleteConsumerExtensionInstance(consumerExtensionInstanceId);
	}

	/**
	* Deletes the consumer extension instance from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerExtensionInstance the consumer extension instance
	* @return the consumer extension instance that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance deleteConsumerExtensionInstance(
		com.liferay.consumer.manager.model.ConsumerExtensionInstance consumerExtensionInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.deleteConsumerExtensionInstance(consumerExtensionInstance);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _consumerExtensionInstanceLocalService.dynamicQuery();
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
		return _consumerExtensionInstanceLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _consumerExtensionInstanceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _consumerExtensionInstanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchConsumerExtensionInstance(
		long consumerExtensionInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.fetchConsumerExtensionInstance(consumerExtensionInstanceId);
	}

	/**
	* Returns the consumer extension instance with the matching UUID and company.
	*
	* @param uuid the consumer extension instance's UUID
	* @param companyId the primary key of the company
	* @return the matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchConsumerExtensionInstanceByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.fetchConsumerExtensionInstanceByUuidAndCompanyId(uuid,
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
	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance getConsumerExtensionInstance(
		long consumerExtensionInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.getConsumerExtensionInstance(consumerExtensionInstanceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance getConsumerExtensionInstanceByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.getConsumerExtensionInstanceByUuidAndCompanyId(uuid,
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
	@Override
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> getConsumerExtensionInstances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.getConsumerExtensionInstances(start,
			end);
	}

	/**
	* Returns the number of consumer extension instances.
	*
	* @return the number of consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getConsumerExtensionInstancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.getConsumerExtensionInstancesCount();
	}

	/**
	* Updates the consumer extension instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param consumerExtensionInstance the consumer extension instance
	* @return the consumer extension instance that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance updateConsumerExtensionInstance(
		com.liferay.consumer.manager.model.ConsumerExtensionInstance consumerExtensionInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.updateConsumerExtensionInstance(consumerExtensionInstance);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _consumerExtensionInstanceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_consumerExtensionInstanceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _consumerExtensionInstanceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance addConsumerExtensionInstance(
		java.lang.String consumerExtensionKey, long consumerId,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.addConsumerExtensionInstance(consumerExtensionKey,
			consumerId, typeSettings, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> getConsumerExtensionInstances(
		long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.getConsumerExtensionInstances(consumerId);
	}

	@Override
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> getConsumerExtensionInstances(
		long consumerId, java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.getConsumerExtensionInstances(consumerId,
			consumerExtensionKey);
	}

	@Override
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance updateConsumerExtensionInstance(
		long consumerExtensionInstanceId,
		java.lang.String consumerExtensionKey, long consumerId,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerExtensionInstanceLocalService.updateConsumerExtensionInstance(consumerExtensionInstanceId,
			consumerExtensionKey, consumerId, typeSettings, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ConsumerExtensionInstanceLocalService getWrappedConsumerExtensionInstanceLocalService() {
		return _consumerExtensionInstanceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedConsumerExtensionInstanceLocalService(
		ConsumerExtensionInstanceLocalService consumerExtensionInstanceLocalService) {
		_consumerExtensionInstanceLocalService = consumerExtensionInstanceLocalService;
	}

	@Override
	public ConsumerExtensionInstanceLocalService getWrappedService() {
		return _consumerExtensionInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		ConsumerExtensionInstanceLocalService consumerExtensionInstanceLocalService) {
		_consumerExtensionInstanceLocalService = consumerExtensionInstanceLocalService;
	}

	private ConsumerExtensionInstanceLocalService _consumerExtensionInstanceLocalService;
}