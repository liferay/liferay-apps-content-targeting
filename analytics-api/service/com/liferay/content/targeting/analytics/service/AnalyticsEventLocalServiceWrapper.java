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

package com.liferay.content.targeting.analytics.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnalyticsEventLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventLocalService
 * @generated
 */
public class AnalyticsEventLocalServiceWrapper
	implements AnalyticsEventLocalService,
		ServiceWrapper<AnalyticsEventLocalService> {
	public AnalyticsEventLocalServiceWrapper(
		AnalyticsEventLocalService analyticsEventLocalService) {
		_analyticsEventLocalService = analyticsEventLocalService;
	}

	/**
	* Adds the analytics event to the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsEvent the analytics event
	* @return the analytics event that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsEvent addAnalyticsEvent(
		com.liferay.content.targeting.analytics.model.AnalyticsEvent analyticsEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.addAnalyticsEvent(analyticsEvent);
	}

	/**
	* Creates a new analytics event with the primary key. Does not add the analytics event to the database.
	*
	* @param analyticsEventId the primary key for the new analytics event
	* @return the new analytics event
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsEvent createAnalyticsEvent(
		long analyticsEventId) {
		return _analyticsEventLocalService.createAnalyticsEvent(analyticsEventId);
	}

	/**
	* Deletes the analytics event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event that was removed
	* @throws PortalException if a analytics event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsEvent deleteAnalyticsEvent(
		long analyticsEventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.deleteAnalyticsEvent(analyticsEventId);
	}

	/**
	* Deletes the analytics event from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsEvent the analytics event
	* @return the analytics event that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsEvent deleteAnalyticsEvent(
		com.liferay.content.targeting.analytics.model.AnalyticsEvent analyticsEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.deleteAnalyticsEvent(analyticsEvent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _analyticsEventLocalService.dynamicQuery();
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
		return _analyticsEventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _analyticsEventLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _analyticsEventLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _analyticsEventLocalService.dynamicQueryCount(dynamicQuery);
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
		return _analyticsEventLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsEvent fetchAnalyticsEvent(
		long analyticsEventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.fetchAnalyticsEvent(analyticsEventId);
	}

	/**
	* Returns the analytics event with the primary key.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event
	* @throws PortalException if a analytics event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsEvent getAnalyticsEvent(
		long analyticsEventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEvent(analyticsEventId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the analytics events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics events
	* @param end the upper bound of the range of analytics events (not inclusive)
	* @return the range of analytics events
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEvents(start, end);
	}

	/**
	* Returns the number of analytics events.
	*
	* @return the number of analytics events
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAnalyticsEventsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsCount();
	}

	/**
	* Updates the analytics event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param analyticsEvent the analytics event
	* @return the analytics event that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsEvent updateAnalyticsEvent(
		com.liferay.content.targeting.analytics.model.AnalyticsEvent analyticsEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.updateAnalyticsEvent(analyticsEvent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _analyticsEventLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_analyticsEventLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _analyticsEventLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsEvent addAnalyticsEvent(
		long userId, long anonymousUserId, java.lang.String className,
		long classPK, java.lang.String referrerClassName,
		long[] referrerClassPKs, java.lang.String elementId,
		java.lang.String eventType, java.lang.String clientIP,
		java.lang.String userAgent, java.lang.String languageId,
		java.lang.String URL, java.lang.String additionalInfo,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.addAnalyticsEvent(userId,
			anonymousUserId, className, classPK, referrerClassName,
			referrerClassPKs, elementId, eventType, clientIP, userAgent,
			languageId, URL, additionalInfo, serviceContext);
	}

	@Override
	public com.liferay.content.targeting.analytics.model.AnalyticsEvent addAnalyticsEvent(
		long userId, long anonymousUserId, java.lang.String className,
		long classPK, java.lang.String elementId, java.lang.String eventType,
		java.lang.String clientIP, java.lang.String userAgent,
		java.lang.String languageId, java.lang.String URL,
		java.lang.String additionalInfo,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.addAnalyticsEvent(userId,
			anonymousUserId, className, classPK, elementId, eventType,
			clientIP, userAgent, languageId, URL, additionalInfo, serviceContext);
	}

	@Override
	public void checkAnalyticsEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_analyticsEventLocalService.checkAnalyticsEvents();
	}

	@Override
	public void deleteAnalyticsEvents(long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_analyticsEventLocalService.deleteAnalyticsEvents(companyId, createDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEvents(companyId,
			createDate);
	}

	@Override
	public java.util.List<java.lang.Object[]> getAnalyticsEvents(
		long companyId, java.lang.String referrerClassName,
		long referrerClassPK, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEvents(companyId,
			referrerClassName, referrerClassPK, createDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		long anonymousUserId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEvents(anonymousUserId,
			className, classPK, eventType);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		java.lang.String className, long classPK, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEvents(className,
			classPK, eventType);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		java.lang.String className, long classPK, java.lang.String eventType,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEvents(className,
			classPK, eventType, createDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEvents(
		java.lang.String elementId, java.lang.String eventType,
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEvents(elementId,
			eventType, createDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.analytics.model.AnalyticsEvent> getAnalyticsEventsContent(
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsContent(createDate);
	}

	@Override
	public long[] getAnalyticsEventsContentIds(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsContentIds(createDate);
	}

	@Override
	public int getAnalyticsEventsCount(long companyId, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsCount(companyId,
			createDate);
	}

	@Override
	public int getAnalyticsEventsCount(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsCount(anonymousUserId,
			className, classPK, eventType);
	}

	@Override
	public int getAnalyticsEventsCount(java.lang.String className,
		long classPK, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsCount(className,
			classPK, eventType);
	}

	@Override
	public int getAnalyticsEventsCount(java.lang.String className,
		long classPK, java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsCount(className,
			classPK, eventType, createDate);
	}

	@Override
	public int getAnalyticsEventsCount(java.lang.String className,
		long classPK, java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsCount(className,
			classPK, referrerClassName, referrerClassPK, eventType, createDate);
	}

	@Override
	public int getAnalyticsEventsCount(java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsCount(referrerClassName,
			referrerClassPK, elementId, eventType, createDate);
	}

	@Override
	public int getAnalyticsEventsCount(java.lang.String elementId,
		java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsCount(elementId,
			eventType, createDate);
	}

	@Override
	public long[] getAnalyticsEventsIds(java.lang.String className,
		long classPK, java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsIds(className,
			classPK, eventType, createDate);
	}

	@Override
	public long[] getAnalyticsEventsIds(java.lang.String elementId,
		java.lang.String eventType, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getAnalyticsEventsIds(elementId,
			eventType, createDate);
	}

	@Override
	public java.util.Date getMaxAge()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _analyticsEventLocalService.getMaxAge();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AnalyticsEventLocalService getWrappedAnalyticsEventLocalService() {
		return _analyticsEventLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAnalyticsEventLocalService(
		AnalyticsEventLocalService analyticsEventLocalService) {
		_analyticsEventLocalService = analyticsEventLocalService;
	}

	@Override
	public AnalyticsEventLocalService getWrappedService() {
		return _analyticsEventLocalService;
	}

	@Override
	public void setWrappedService(
		AnalyticsEventLocalService analyticsEventLocalService) {
		_analyticsEventLocalService = analyticsEventLocalService;
	}

	private AnalyticsEventLocalService _analyticsEventLocalService;
}