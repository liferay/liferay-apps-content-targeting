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

package com.liferay.content.targeting.report.user.segment.content.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserSegmentContent. This utility wraps
 * {@link com.liferay.content.targeting.report.user.segment.content.service.impl.UserSegmentContentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentContentLocalService
 * @see com.liferay.content.targeting.report.user.segment.content.service.base.UserSegmentContentLocalServiceBaseImpl
 * @see com.liferay.content.targeting.report.user.segment.content.service.impl.UserSegmentContentLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserSegmentContentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.content.targeting.report.user.segment.content.service.impl.UserSegmentContentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user segment content to the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentContent the user segment content
	* @return the user segment content that was added
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent addUserSegmentContent(
		com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent userSegmentContent) {
		return getService().addUserSegmentContent(userSegmentContent);
	}

	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent addUserSegmentContent(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addUserSegmentContent(userSegmentId, className, classPK,
			eventType, count);
	}

	public static void checkUserSegmentContentEvents()
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().checkUserSegmentContentEvents();
	}

	public static void checkUserSegmentContentEvents(long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().checkUserSegmentContentEvents(userSegmentId);
	}

	/**
	* Creates a new user segment content with the primary key. Does not add the user segment content to the database.
	*
	* @param userSegmentContentId the primary key for the new user segment content
	* @return the new user segment content
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent createUserSegmentContent(
		long userSegmentContentId) {
		return getService().createUserSegmentContent(userSegmentContentId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the user segment content from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentContent the user segment content
	* @return the user segment content that was removed
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent deleteUserSegmentContent(
		com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent userSegmentContent) {
		return getService().deleteUserSegmentContent(userSegmentContent);
	}

	/**
	* Deletes the user segment content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentContentId the primary key of the user segment content
	* @return the user segment content that was removed
	* @throws PortalException if a user segment content with the primary key could not be found
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent deleteUserSegmentContent(
		long userSegmentContentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserSegmentContent(userSegmentContentId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchUserSegmentContent(
		long userSegmentContentId) {
		return getService().fetchUserSegmentContent(userSegmentContentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
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

	/**
	* Returns the user segment content with the primary key.
	*
	* @param userSegmentContentId the primary key of the user segment content
	* @return the user segment content
	* @throws PortalException if a user segment content with the primary key could not be found
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent getUserSegmentContent(
		long userSegmentContentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentContent(userSegmentContentId);
	}

	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent getUserSegmentContent(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getUserSegmentContent(userSegmentId, className, classPK,
			eventType);
	}

	/**
	* Returns a range of all the user segment contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user segment contents
	* @param end the upper bound of the range of user segment contents (not inclusive)
	* @return the range of user segment contents
	*/
	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> getUserSegmentContents(
		int start, int end) {
		return getService().getUserSegmentContents(start, end);
	}

	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> getUserSegmentContents(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentContents(userSegmentId);
	}

	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> getUserSegmentContents(
		long userSegmentId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentContents(userSegmentId, modifiedDate);
	}

	public static java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> getUserSegmentContents(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getUserSegmentContents(userSegmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of user segment contents.
	*
	* @return the number of user segment contents
	*/
	public static int getUserSegmentContentsCount() {
		return getService().getUserSegmentContentsCount();
	}

	public static int getUserSegmentContentsCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserSegmentContentsCount(userSegmentId);
	}

	/**
	* Updates the user segment content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSegmentContent the user segment content
	* @return the user segment content that was updated
	*/
	public static com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent updateUserSegmentContent(
		com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent userSegmentContent) {
		return getService().updateUserSegmentContent(userSegmentContent);
	}

	public static UserSegmentContentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserSegmentContentLocalService, UserSegmentContentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(UserSegmentContentLocalService.class);
}