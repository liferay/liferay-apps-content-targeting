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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AnonymousUserUserSegment. This utility wraps
 * {@link com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegmentLocalService
 * @see com.liferay.content.targeting.service.base.AnonymousUserUserSegmentLocalServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentLocalServiceImpl
 * @generated
 */
@ProviderType
public class AnonymousUserUserSegmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.content.targeting.model.AnonymousUserUserSegment addAnonymousUserUserSegment(
		long anonymousUserId, long userSegmentId, boolean manual,
		boolean active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addAnonymousUserUserSegment(anonymousUserId, userSegmentId,
			manual, active, serviceContext);
	}

	/**
	* Adds the anonymous user user segment to the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegment the anonymous user user segment
	* @return the anonymous user user segment that was added
	*/
	public static com.liferay.content.targeting.model.AnonymousUserUserSegment addAnonymousUserUserSegment(
		com.liferay.content.targeting.model.AnonymousUserUserSegment anonymousUserUserSegment) {
		return getService().addAnonymousUserUserSegment(anonymousUserUserSegment);
	}

	public static void checkAnonymousUserUserSegments()
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().checkAnonymousUserUserSegments();
	}

	/**
	* Creates a new anonymous user user segment with the primary key. Does not add the anonymous user user segment to the database.
	*
	* @param anonymousUserUserSegmentId the primary key for the new anonymous user user segment
	* @return the new anonymous user user segment
	*/
	public static com.liferay.content.targeting.model.AnonymousUserUserSegment createAnonymousUserUserSegment(
		long anonymousUserUserSegmentId) {
		return getService()
				   .createAnonymousUserUserSegment(anonymousUserUserSegmentId);
	}

	/**
	* Deletes the anonymous user user segment from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegment the anonymous user user segment
	* @return the anonymous user user segment that was removed
	*/
	public static com.liferay.content.targeting.model.AnonymousUserUserSegment deleteAnonymousUserUserSegment(
		com.liferay.content.targeting.model.AnonymousUserUserSegment anonymousUserUserSegment) {
		return getService()
				   .deleteAnonymousUserUserSegment(anonymousUserUserSegment);
	}

	/**
	* Deletes the anonymous user user segment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment that was removed
	* @throws PortalException if a anonymous user user segment with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.AnonymousUserUserSegment deleteAnonymousUserUserSegment(
		long anonymousUserUserSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteAnonymousUserUserSegment(anonymousUserUserSegmentId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.content.targeting.model.AnonymousUserUserSegment fetchAnonymousUserUserSegment(
		long anonymousUserUserSegmentId) {
		return getService()
				   .fetchAnonymousUserUserSegment(anonymousUserUserSegmentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the anonymous user user segment with the primary key.
	*
	* @param anonymousUserUserSegmentId the primary key of the anonymous user user segment
	* @return the anonymous user user segment
	* @throws PortalException if a anonymous user user segment with the primary key could not be found
	*/
	public static com.liferay.content.targeting.model.AnonymousUserUserSegment getAnonymousUserUserSegment(
		long anonymousUserUserSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getAnonymousUserUserSegment(anonymousUserUserSegmentId);
	}

	public static java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> getAnonymousUserUserSegments(
		long anonymousUserId, long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getAnonymousUserUserSegments(anonymousUserId, userSegmentId);
	}

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
	public static java.util.List<com.liferay.content.targeting.model.AnonymousUserUserSegment> getAnonymousUserUserSegments(
		int start, int end) {
		return getService().getAnonymousUserUserSegments(start, end);
	}

	/**
	* Returns the number of anonymous user user segments.
	*
	* @return the number of anonymous user user segments
	*/
	public static int getAnonymousUserUserSegmentsCount() {
		return getService().getAnonymousUserUserSegmentsCount();
	}

	public static java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentId(
		long userSegmentId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getAnonymousUsersByUserSegmentId(userSegmentId, active);
	}

	public static int getAnonymousUsersByUserSegmentIdCount(
		long userSegmentId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getAnonymousUsersByUserSegmentIdCount(userSegmentId, active);
	}

	public static java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentIds(
		long[] userSegmentIds, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getAnonymousUsersByUserSegmentIds(userSegmentIds, active);
	}

	public static int getAnonymousUsersByUserSegmentIdsCount(
		long[] userSegmentIds, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getAnonymousUsersByUserSegmentIdsCount(userSegmentIds,
			active);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.Date getMaxAge()
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMaxAge();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByAnonymousUserId(
		long anonymousUserId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getUserSegmentsByAnonymousUserId(anonymousUserId, active);
	}

	public static int getUserSegmentsByAnonymousUserIdCount(
		long anonymousUserId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getUserSegmentsByAnonymousUserIdCount(anonymousUserId,
			active);
	}

	public static java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByUserId(
		long userId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentsByUserId(userId, active);
	}

	public static int getUserSegmentsByUserIdCount(long userId, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentsByUserIdCount(userId, active);
	}

	/**
	* Updates the anonymous user user segment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserUserSegment the anonymous user user segment
	* @return the anonymous user user segment that was updated
	*/
	public static com.liferay.content.targeting.model.AnonymousUserUserSegment updateAnonymousUserUserSegment(
		com.liferay.content.targeting.model.AnonymousUserUserSegment anonymousUserUserSegment) {
		return getService()
				   .updateAnonymousUserUserSegment(anonymousUserUserSegment);
	}

	public static com.liferay.content.targeting.model.AnonymousUserUserSegment updateAnonymousUserUserSegment(
		long anonymousUserUserSegmentId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateAnonymousUserUserSegment(anonymousUserUserSegmentId,
			serviceContext);
	}

	public static void updateAnonymousUserUserSegments(long companyId,
		java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().updateAnonymousUserUserSegments(companyId, modifiedDate);
	}

	public static AnonymousUserUserSegmentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnonymousUserUserSegmentLocalService, AnonymousUserUserSegmentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(AnonymousUserUserSegmentLocalService.class);
}