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

import com.liferay.content.targeting.model.TrackingActionInstance;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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

import java.util.List;

/**
 * Provides the local service interface for TrackingActionInstance. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstanceLocalServiceUtil
 * @see com.liferay.content.targeting.service.base.TrackingActionInstanceLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.TrackingActionInstanceLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TrackingActionInstanceLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrackingActionInstanceLocalServiceUtil} to access the tracking action instance local service. Add custom service methods to {@link com.liferay.content.targeting.service.impl.TrackingActionInstanceLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the tracking action instance to the database. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstance the tracking action instance
	* @return the tracking action instance that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TrackingActionInstance addTrackingActionInstance(
		TrackingActionInstance trackingActionInstance);

	public TrackingActionInstance addTrackingActionInstance(long userId,
		long reportInstanceId, java.lang.String trackingActionKey,
		long campaignId, java.lang.String alias,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType,
		java.lang.String typeSettings, ServiceContext serviceContext)
		throws PortalException;

	/**
	* @deprecated As of 2.0.0
	*/
	@java.lang.Deprecated
	public TrackingActionInstance addTrackingActionInstance(long userId,
		java.lang.String trackingActionKey, long campaignId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Creates a new tracking action instance with the primary key. Does not add the tracking action instance to the database.
	*
	* @param trackingActionInstanceId the primary key for the new tracking action instance
	* @return the new tracking action instance
	*/
	public TrackingActionInstance createTrackingActionInstance(
		long trackingActionInstanceId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the tracking action instance from the database. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstance the tracking action instance
	* @return the tracking action instance that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	public TrackingActionInstance deleteTrackingActionInstance(
		TrackingActionInstance trackingActionInstance)
		throws PortalException;

	/**
	* Deletes the tracking action instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstanceId the primary key of the tracking action instance
	* @return the tracking action instance that was removed
	* @throws PortalException if a tracking action instance with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public TrackingActionInstance deleteTrackingActionInstance(
		long trackingActionInstanceId) throws PortalException;

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public TrackingActionInstance fetchTrackingActionInstance(long campaignId,
		java.lang.String alias);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrackingActionInstance fetchTrackingActionInstance(
		long trackingActionInstanceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrackingActionInstance fetchTrackingActionInstanceByReportInstanceId(
		long reportInstanceId, java.lang.String alias);

	/**
	* Returns the tracking action instance matching the UUID and group.
	*
	* @param uuid the tracking action instance's UUID
	* @param groupId the primary key of the group
	* @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrackingActionInstance fetchTrackingActionInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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
	* Returns the tracking action instance with the primary key.
	*
	* @param trackingActionInstanceId the primary key of the tracking action instance
	* @return the tracking action instance
	* @throws PortalException if a tracking action instance with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrackingActionInstance getTrackingActionInstance(
		long trackingActionInstanceId) throws PortalException;

	/**
	* Returns the tracking action instance matching the UUID and group.
	*
	* @param uuid the tracking action instance's UUID
	* @param groupId the primary key of the group
	* @return the matching tracking action instance
	* @throws PortalException if a matching tracking action instance could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TrackingActionInstance getTrackingActionInstanceByUuidAndGroupId(
		java.lang.String uuid, long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstances(
		long campaignId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstances(
		long campaignId, java.lang.String className, long classPK,
		java.lang.String eventType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstances(
		long campaignId, java.lang.String elementId, java.lang.String eventType);

	/**
	* Returns a range of all the tracking action instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @return the range of tracking action instances
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstances(int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstancesByReportInstanceId(
		long reportInstanceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstancesByReportInstanceId(
		long reportInstanceId, java.lang.String className, long classPK,
		java.lang.String eventType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstancesByReportInstanceId(
		long reportInstanceId, java.lang.String elementId,
		java.lang.String eventType);

	/**
	* Returns all the tracking action instances matching the UUID and company.
	*
	* @param uuid the UUID of the tracking action instances
	* @param companyId the primary key of the company
	* @return the matching tracking action instances, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of tracking action instances matching the UUID and company.
	*
	* @param uuid the UUID of the tracking action instances
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of tracking action instances
	* @param end the upper bound of the range of tracking action instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching tracking action instances, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TrackingActionInstance> getTrackingActionInstancesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator);

	/**
	* Returns the number of tracking action instances.
	*
	* @return the number of tracking action instances
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTrackingActionInstancesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTrackingActionInstancesCount(long campaignId);

	/**
	* Updates the tracking action instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trackingActionInstance the tracking action instance
	* @return the tracking action instance that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TrackingActionInstance updateTrackingActionInstance(
		TrackingActionInstance trackingActionInstance);

	public TrackingActionInstance updateTrackingActionInstance(
		long trackingActionInstanceId, long reportInstanceId,
		java.lang.String alias, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, java.lang.String typeSettings,
		ServiceContext serviceContext) throws PortalException;
}