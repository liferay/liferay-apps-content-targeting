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

package com.liferay.content.targeting.report.campaign.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConsumerDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerDataLocalService
 * @generated
 */
public class ConsumerDataLocalServiceWrapper implements ConsumerDataLocalService,
	ServiceWrapper<ConsumerDataLocalService> {
	public ConsumerDataLocalServiceWrapper(
		ConsumerDataLocalService consumerDataLocalService) {
		_consumerDataLocalService = consumerDataLocalService;
	}

	/**
	* Adds the consumer data to the database. Also notifies the appropriate model listeners.
	*
	* @param consumerData the consumer data
	* @return the consumer data that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData addConsumerData(
		com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData consumerData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.addConsumerData(consumerData);
	}

	/**
	* Creates a new consumer data with the primary key. Does not add the consumer data to the database.
	*
	* @param consumerDataId the primary key for the new consumer data
	* @return the new consumer data
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData createConsumerData(
		long consumerDataId) {
		return _consumerDataLocalService.createConsumerData(consumerDataId);
	}

	/**
	* Deletes the consumer data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerDataId the primary key of the consumer data
	* @return the consumer data that was removed
	* @throws PortalException if a consumer data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData deleteConsumerData(
		long consumerDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.deleteConsumerData(consumerDataId);
	}

	/**
	* Deletes the consumer data from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerData the consumer data
	* @return the consumer data that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData deleteConsumerData(
		com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData consumerData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.deleteConsumerData(consumerData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _consumerDataLocalService.dynamicQuery();
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
		return _consumerDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _consumerDataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _consumerDataLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _consumerDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _consumerDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData fetchConsumerData(
		long consumerDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.fetchConsumerData(consumerDataId);
	}

	/**
	* Returns the consumer data with the primary key.
	*
	* @param consumerDataId the primary key of the consumer data
	* @return the consumer data
	* @throws PortalException if a consumer data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData getConsumerData(
		long consumerDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.getConsumerData(consumerDataId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the consumer datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumer datas
	* @param end the upper bound of the range of consumer datas (not inclusive)
	* @return the range of consumer datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData> getConsumerDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.getConsumerDatas(start, end);
	}

	/**
	* Returns the number of consumer datas.
	*
	* @return the number of consumer datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getConsumerDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.getConsumerDatasCount();
	}

	/**
	* Updates the consumer data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param consumerData the consumer data
	* @return the consumer data that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData updateConsumerData(
		com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData consumerData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.updateConsumerData(consumerData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _consumerDataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_consumerDataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _consumerDataLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData addConsumerData(
		long campaignId, java.lang.String elementId, long consumerId,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.addConsumerData(campaignId, elementId,
			consumerId, eventType, count);
	}

	@Override
	public void checkConsumerDataEvents(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_consumerDataLocalService.checkConsumerDataEvents(campaignId);
	}

	@Override
	public void checkConsumerDataEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_consumerDataLocalService.checkConsumerDataEvents();
	}

	@Override
	public com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData getConsumerData(
		long campaignId, long consumerId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _consumerDataLocalService.getConsumerData(campaignId,
			consumerId, eventType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ConsumerDataLocalService getWrappedConsumerDataLocalService() {
		return _consumerDataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedConsumerDataLocalService(
		ConsumerDataLocalService consumerDataLocalService) {
		_consumerDataLocalService = consumerDataLocalService;
	}

	@Override
	public ConsumerDataLocalService getWrappedService() {
		return _consumerDataLocalService;
	}

	@Override
	public void setWrappedService(
		ConsumerDataLocalService consumerDataLocalService) {
		_consumerDataLocalService = consumerDataLocalService;
	}

	private ConsumerDataLocalService _consumerDataLocalService;
}