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

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.analytics.model.AnalyticsEvent;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Provides the local service interface for AnalyticsEvent. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventLocalServiceUtil
 * @see com.liferay.content.targeting.analytics.service.base.AnalyticsEventLocalServiceBaseImpl
 * @see com.liferay.content.targeting.analytics.service.impl.AnalyticsEventLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AnalyticsEventLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnalyticsEventLocalServiceUtil} to access the analytics event local service. Add custom service methods to {@link com.liferay.content.targeting.analytics.service.impl.AnalyticsEventLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the analytics event to the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsEvent the analytics event
	* @return the analytics event that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AnalyticsEvent addAnalyticsEvent(AnalyticsEvent analyticsEvent);

	public AnalyticsEvent addAnalyticsEvent(long userId, long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String clientIP,
		java.lang.String userAgent, java.lang.String languageId,
		java.lang.String URL, java.lang.String additionalInfo,
		ServiceContext serviceContext) throws PortalException;

	public AnalyticsEvent addAnalyticsEvent(long userId, long anonymousUserId,
		java.lang.String className, long classPK,
		java.lang.String referrerClassName, long[] referrerClassPKs,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String clientIP, java.lang.String userAgent,
		java.lang.String languageId, java.lang.String URL,
		java.lang.String additionalInfo, ServiceContext serviceContext)
		throws PortalException;

	public AnalyticsEvent addAnalyticsEvent(long userId, long anonymousUserId,
		java.lang.String className, long classPK,
		Map<java.lang.String, long[]> referrers, java.lang.String elementId,
		java.lang.String eventType, java.lang.String clientIP,
		java.lang.String userAgent, java.lang.String languageId,
		java.lang.String URL, java.lang.String additionalInfo,
		ServiceContext serviceContext) throws PortalException;

	public void checkAnalyticsEvents() throws PortalException;

	/**
	* Creates a new analytics event with the primary key. Does not add the analytics event to the database.
	*
	* @param analyticsEventId the primary key for the new analytics event
	* @return the new analytics event
	*/
	public AnalyticsEvent createAnalyticsEvent(long analyticsEventId);

	/**
	* Deletes the analytics event from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsEvent the analytics event
	* @return the analytics event that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public AnalyticsEvent deleteAnalyticsEvent(AnalyticsEvent analyticsEvent);

	/**
	* Deletes the analytics event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event that was removed
	* @throws PortalException if a analytics event with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public AnalyticsEvent deleteAnalyticsEvent(long analyticsEventId)
		throws PortalException;

	public void deleteAnalyticsEvents(long companyId, Date createDate)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnalyticsEvent fetchAnalyticsEvent(long analyticsEventId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the analytics event with the primary key.
	*
	* @param analyticsEventId the primary key of the analytics event
	* @return the analytics event
	* @throws PortalException if a analytics event with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnalyticsEvent getAnalyticsEvent(long analyticsEventId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsEvent> getAnalyticsEvents(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsEvent> getAnalyticsEvents(java.lang.String className,
		long classPK, java.lang.String eventType) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsEvent> getAnalyticsEvents(java.lang.String className,
		long classPK, java.lang.String eventType, Date createDate)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsEvent> getAnalyticsEvents(long companyId,
		Date createDate) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<java.lang.Object[]> getAnalyticsEvents(long companyId,
		java.lang.String referrerClassName, long referrerClassPK,
		Date createDate) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsEvent> getAnalyticsEvents(java.lang.String elementId,
		java.lang.String eventType, Date createDate) throws PortalException;

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
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsEvent> getAnalyticsEvents(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsEvent> getAnalyticsEventsContent(Date createDate)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getAnalyticsEventsContentIds(Date createDate)
		throws PortalException;

	/**
	* Returns the number of analytics events.
	*
	* @return the number of analytics events
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsEventsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsEventsCount(long anonymousUserId,
		java.lang.String className, long classPK, java.lang.String eventType)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsEventsCount(java.lang.String className,
		long classPK, java.lang.String eventType) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsEventsCount(java.lang.String className,
		long classPK, java.lang.String eventType, Date createDate)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsEventsCount(java.lang.String className,
		long classPK, java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String eventType, Date createDate) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsEventsCount(long companyId, Date createDate)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsEventsCount(java.lang.String elementId,
		java.lang.String eventType, Date createDate) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsEventsCount(java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, Date createDate) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getAnalyticsEventsIds(java.lang.String className,
		long classPK, java.lang.String eventType, Date createDate)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getAnalyticsEventsIds(java.lang.String elementId,
		java.lang.String eventType, Date createDate) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Date getMaxAge() throws PortalException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Updates the analytics event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param analyticsEvent the analytics event
	* @return the analytics event that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AnalyticsEvent updateAnalyticsEvent(AnalyticsEvent analyticsEvent);
}