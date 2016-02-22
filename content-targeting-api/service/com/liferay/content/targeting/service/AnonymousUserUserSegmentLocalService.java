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

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.model.AnonymousUserUserSegment;
import com.liferay.content.targeting.model.UserSegment;

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

/**
 * Provides the local service interface for AnonymousUserUserSegment. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegmentLocalServiceUtil
 * @see com.liferay.content.targeting.service.base.AnonymousUserUserSegmentLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AnonymousUserUserSegmentLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnonymousUserUserSegmentLocalServiceUtil} to access the anonymous user user segment local service. Add custom service methods to {@link com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public AnonymousUserUserSegment addAnonymousUserUserSegment(
		long anonymousUserId, long userSegmentId, boolean manual,
		boolean active, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Adds the anonymous user user segment to the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegment the anonymous user user segment
	* @return the anonymous user user segment that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AnonymousUserUserSegment addAnonymousUserUserSegment(
		AnonymousUserUserSegment anonymousUserUserSegment);

	public void checkAnonymousUserUserSegments() throws PortalException;

	/**
	* Creates a new anonymous user user segment with the primary key. Does not add the anonymous user user segment to the database.
	*
	* @param anonymousUserUserSegmentId the primary key for the new anonymous user user segment
	* @return the new anonymous user user segment
	*/
	public AnonymousUserUserSegment createAnonymousUserUserSegment(
		long anonymousUserUserSegmentId);

	/**
	* Deletes the anonymous user user segment from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegment the anonymous user user segment
	* @return the anonymous user user segment that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public AnonymousUserUserSegment deleteAnonymousUserUserSegment(
		AnonymousUserUserSegment anonymousUserUserSegment);

	/**
	* Deletes the anonymous user user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment that was removed
	* @throws PortalException if a anonymous user user segment with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public AnonymousUserUserSegment deleteAnonymousUserUserSegment(
		long anonymousUserUserSegmentId) throws PortalException;

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public AnonymousUserUserSegment fetchAnonymousUserUserSegment(
		long anonymousUserUserSegmentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the anonymous user user segment with the primary key.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment
	* @throws PortalException if a anonymous user user segment with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnonymousUserUserSegment getAnonymousUserUserSegment(
		long anonymousUserUserSegmentId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnonymousUserUserSegment> getAnonymousUserUserSegments(
		long anonymousUserId, long userSegmentId) throws PortalException;

	/**
	* Returns a range of all the anonymous user user segments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.AnonymousUserUserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous user user segments
	* @param end the upper bound of the range of anonymous user user segments (not inclusive)
	* @return the range of anonymous user user segments
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnonymousUserUserSegment> getAnonymousUserUserSegments(
		int start, int end);

	/**
	* Returns the number of anonymous user user segments.
	*
	* @return the number of anonymous user user segments
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnonymousUserUserSegmentsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnonymousUser> getAnonymousUsersByUserSegmentId(
		long userSegmentId, boolean active) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnonymousUsersByUserSegmentIdCount(long userSegmentId,
		boolean active) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnonymousUser> getAnonymousUsersByUserSegmentIds(
		long[] userSegmentIds, boolean active) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnonymousUsersByUserSegmentIdsCount(long[] userSegmentIds,
		boolean active) throws PortalException;

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getUserSegmentsByAnonymousUserId(
		long anonymousUserId, boolean active) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserSegmentsByAnonymousUserIdCount(long anonymousUserId,
		boolean active) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserSegment> getUserSegmentsByUserId(long userId, boolean active)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserSegmentsByUserIdCount(long userId, boolean active)
		throws PortalException;

	/**
	* Updates the anonymous user user segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegment the anonymous user user segment
	* @return the anonymous user user segment that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AnonymousUserUserSegment updateAnonymousUserUserSegment(
		AnonymousUserUserSegment anonymousUserUserSegment);

	public AnonymousUserUserSegment updateAnonymousUserUserSegment(
		long anonymousUserUserSegmentId, ServiceContext serviceContext)
		throws PortalException;

	public void updateAnonymousUserUserSegments(long companyId,
		Date modifiedDate) throws PortalException;
}