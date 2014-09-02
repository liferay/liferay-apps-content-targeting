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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserSegmentContentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentContentLocalService
 * @generated
 */
public class UserSegmentContentLocalServiceWrapper
	implements UserSegmentContentLocalService,
		ServiceWrapper<UserSegmentContentLocalService> {
	public UserSegmentContentLocalServiceWrapper(
		UserSegmentContentLocalService userSegmentContentLocalService) {
		_userSegmentContentLocalService = userSegmentContentLocalService;
	}

	/**
	* Adds the user segment content to the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentContent the user segment content
	* @return the user segment content that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent addUserSegmentContent(
		com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent userSegmentContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.addUserSegmentContent(userSegmentContent);
	}

	/**
	* Creates a new user segment content with the primary key. Does not add the user segment content to the database.
	*
	* @param userSegmentContentId the primary key for the new user segment content
	* @return the new user segment content
	*/
	@Override
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent createUserSegmentContent(
		long userSegmentContentId) {
		return _userSegmentContentLocalService.createUserSegmentContent(userSegmentContentId);
	}

	/**
	* Deletes the user segment content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentContentId the primary key of the user segment content
	* @return the user segment content that was removed
	* @throws PortalException if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent deleteUserSegmentContent(
		long userSegmentContentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.deleteUserSegmentContent(userSegmentContentId);
	}

	/**
	* Deletes the user segment content from the database. Also notifies the appropriate model listeners.
	*
	* @param userSegmentContent the user segment content
	* @return the user segment content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent deleteUserSegmentContent(
		com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent userSegmentContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.deleteUserSegmentContent(userSegmentContent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userSegmentContentLocalService.dynamicQuery();
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
		return _userSegmentContentLocalService.dynamicQuery(dynamicQuery);
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.dynamicQuery(dynamicQuery,
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
		return _userSegmentContentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userSegmentContentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent fetchUserSegmentContent(
		long userSegmentContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.fetchUserSegmentContent(userSegmentContentId);
	}

	/**
	* Returns the user segment content with the primary key.
	*
	* @param userSegmentContentId the primary key of the user segment content
	* @return the user segment content
	* @throws PortalException if a user segment content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent getUserSegmentContent(
		long userSegmentContentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.getUserSegmentContent(userSegmentContentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.getPersistedModel(primaryKeyObj);
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
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> getUserSegmentContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.getUserSegmentContents(start, end);
	}

	/**
	* Returns the number of user segment contents.
	*
	* @return the number of user segment contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserSegmentContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.getUserSegmentContentsCount();
	}

	/**
	* Updates the user segment content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSegmentContent the user segment content
	* @return the user segment content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent updateUserSegmentContent(
		com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent userSegmentContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.updateUserSegmentContent(userSegmentContent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userSegmentContentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userSegmentContentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userSegmentContentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent addUserSegmentContent(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType, int count)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.addUserSegmentContent(userSegmentId,
			className, classPK, eventType, count);
	}

	@Override
	public void checkUserSegmentContentEvents()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userSegmentContentLocalService.checkUserSegmentContentEvents();
	}

	@Override
	public void checkUserSegmentContentEvents(long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userSegmentContentLocalService.checkUserSegmentContentEvents(userSegmentId);
	}

	@Override
	public com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent getUserSegmentContent(
		long userSegmentId, java.lang.String className, long classPK,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.getUserSegmentContent(userSegmentId,
			className, classPK, eventType);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> getUserSegmentContents(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.getUserSegmentContents(userSegmentId);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> getUserSegmentContents(
		long userSegmentId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.getUserSegmentContents(userSegmentId,
			modifiedDate);
	}

	@Override
	public java.util.List<com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent> getUserSegmentContents(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.getUserSegmentContents(userSegmentId,
			start, end, orderByComparator);
	}

	@Override
	public int getUserSegmentContentsCount(long userSegmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegmentContentLocalService.getUserSegmentContentsCount(userSegmentId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserSegmentContentLocalService getWrappedUserSegmentContentLocalService() {
		return _userSegmentContentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserSegmentContentLocalService(
		UserSegmentContentLocalService userSegmentContentLocalService) {
		_userSegmentContentLocalService = userSegmentContentLocalService;
	}

	@Override
	public UserSegmentContentLocalService getWrappedService() {
		return _userSegmentContentLocalService;
	}

	@Override
	public void setWrappedService(
		UserSegmentContentLocalService userSegmentContentLocalService) {
		_userSegmentContentLocalService = userSegmentContentLocalService;
	}

	private UserSegmentContentLocalService _userSegmentContentLocalService;
}