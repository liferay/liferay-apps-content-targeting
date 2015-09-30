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
 * Provides the local service utility for Consumer. This utility wraps
 * {@link com.liferay.consumer.manager.service.impl.ConsumerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerLocalService
 * @see com.liferay.consumer.manager.service.base.ConsumerLocalServiceBaseImpl
 * @see com.liferay.consumer.manager.service.impl.ConsumerLocalServiceImpl
 * @generated
 */
public class ConsumerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.consumer.manager.service.impl.ConsumerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the consumer to the database. Also notifies the appropriate model listeners.
	*
	* @param consumer the consumer
	* @return the consumer that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer addConsumer(
		com.liferay.consumer.manager.model.Consumer consumer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addConsumer(consumer);
	}

	/**
	* Creates a new consumer with the primary key. Does not add the consumer to the database.
	*
	* @param consumerId the primary key for the new consumer
	* @return the new consumer
	*/
	public static com.liferay.consumer.manager.model.Consumer createConsumer(
		long consumerId) {
		return getService().createConsumer(consumerId);
	}

	/**
	* Deletes the consumer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerId the primary key of the consumer
	* @return the consumer that was removed
	* @throws PortalException if a consumer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer deleteConsumer(
		long consumerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteConsumer(consumerId);
	}

	/**
	* Deletes the consumer from the database. Also notifies the appropriate model listeners.
	*
	* @param consumer the consumer
	* @return the consumer that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer deleteConsumer(
		com.liferay.consumer.manager.model.Consumer consumer)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteConsumer(consumer);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.consumer.manager.model.Consumer fetchConsumer(
		long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchConsumer(consumerId);
	}

	/**
	* Returns the consumer with the matching UUID and company.
	*
	* @param uuid the consumer's UUID
	* @param companyId the primary key of the company
	* @return the matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchConsumerByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchConsumerByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the consumer with the primary key.
	*
	* @param consumerId the primary key of the consumer
	* @return the consumer
	* @throws PortalException if a consumer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer getConsumer(
		long consumerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumer(consumerId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the consumer with the matching UUID and company.
	*
	* @param uuid the consumer's UUID
	* @param companyId the primary key of the company
	* @return the matching consumer
	* @throws PortalException if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer getConsumerByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumerByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of all the consumers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @return the range of consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> getConsumers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumers(start, end);
	}

	/**
	* Returns the number of consumers.
	*
	* @return the number of consumers
	* @throws SystemException if a system exception occurred
	*/
	public static int getConsumersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumersCount();
	}

	/**
	* Updates the consumer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param consumer the consumer
	* @return the consumer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer updateConsumer(
		com.liferay.consumer.manager.model.Consumer consumer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateConsumer(consumer);
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

	public static com.liferay.consumer.manager.model.Consumer addConsumer(
		java.lang.String consumerKey,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addConsumer(consumerKey, descriptionMap, nameMap,
			serviceContext);
	}

	public static com.liferay.consumer.manager.model.Consumer getConsumer(
		long companyId, java.lang.String consumerKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumer(companyId, consumerKey);
	}

	public static java.util.List<com.liferay.consumer.manager.model.Consumer> getConsumers()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumers();
	}

	public static java.util.List<com.liferay.consumer.manager.model.Consumer> getConsumers(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumers(companyId);
	}

	public static java.util.List<com.liferay.consumer.manager.model.Consumer> getConsumers(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumers(companyId, start, end, obc);
	}

	public static java.util.List<com.liferay.consumer.manager.model.Consumer> getConsumersByConsumerExtensionKey(
		long companyId, java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getConsumersByConsumerExtensionKey(companyId,
			consumerExtensionKey);
	}

	public static int getConsumersCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConsumersCount(companyId);
	}

	public static com.liferay.portal.kernel.search.Hits search(long companyId,
		java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().search(companyId, keywords, start, end);
	}

	public static com.liferay.consumer.manager.util.BaseModelSearchResult<com.liferay.consumer.manager.model.Consumer> searchConsumers(
		long companyId, java.lang.String keywords, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().searchConsumers(companyId, keywords, start, end);
	}

	public static com.liferay.consumer.manager.model.Consumer updateConsumer(
		long consumerId, java.lang.String consumerKey,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateConsumer(consumerId, consumerKey, descriptionMap,
			nameMap, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ConsumerLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ConsumerLocalService.class.getName());

			if (invokableLocalService instanceof ConsumerLocalService) {
				_service = (ConsumerLocalService)invokableLocalService;
			}
			else {
				_service = new ConsumerLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ConsumerLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ConsumerLocalService service) {
	}

	private static ConsumerLocalService _service;
}