/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CTUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CTUserLocalService
 * @generated
 */
public class CTUserLocalServiceWrapper implements CTUserLocalService,
	ServiceWrapper<CTUserLocalService> {
	public CTUserLocalServiceWrapper(CTUserLocalService ctUserLocalService) {
		_ctUserLocalService = ctUserLocalService;
	}

	/**
	* Adds the c t user to the database. Also notifies the appropriate model listeners.
	*
	* @param ctUser the c t user
	* @return the c t user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.CTUser addCTUser(
		com.liferay.contenttargeting.model.CTUser ctUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.addCTUser(ctUser);
	}

	/**
	* Creates a new c t user with the primary key. Does not add the c t user to the database.
	*
	* @param CTUserId the primary key for the new c t user
	* @return the new c t user
	*/
	@Override
	public com.liferay.contenttargeting.model.CTUser createCTUser(long CTUserId) {
		return _ctUserLocalService.createCTUser(CTUserId);
	}

	/**
	* Deletes the c t user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CTUserId the primary key of the c t user
	* @return the c t user that was removed
	* @throws PortalException if a c t user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.CTUser deleteCTUser(long CTUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.deleteCTUser(CTUserId);
	}

	/**
	* Deletes the c t user from the database. Also notifies the appropriate model listeners.
	*
	* @param ctUser the c t user
	* @return the c t user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.CTUser deleteCTUser(
		com.liferay.contenttargeting.model.CTUser ctUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.deleteCTUser(ctUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ctUserLocalService.dynamicQuery();
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
		return _ctUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ctUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ctUserLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _ctUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ctUserLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.contenttargeting.model.CTUser fetchCTUser(long CTUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.fetchCTUser(CTUserId);
	}

	/**
	* Returns the c t user with the matching UUID and company.
	*
	* @param uuid the c t user's UUID
	* @param companyId the primary key of the company
	* @return the matching c t user, or <code>null</code> if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.CTUser fetchCTUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.fetchCTUserByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the c t user matching the UUID and group.
	*
	* @param uuid the c t user's UUID
	* @param groupId the primary key of the group
	* @return the matching c t user, or <code>null</code> if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.CTUser fetchCTUserByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.fetchCTUserByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the c t user with the primary key.
	*
	* @param CTUserId the primary key of the c t user
	* @return the c t user
	* @throws PortalException if a c t user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.CTUser getCTUser(long CTUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.getCTUser(CTUserId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the c t user with the matching UUID and company.
	*
	* @param uuid the c t user's UUID
	* @param companyId the primary key of the company
	* @return the matching c t user
	* @throws PortalException if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.CTUser getCTUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.getCTUserByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the c t user matching the UUID and group.
	*
	* @param uuid the c t user's UUID
	* @param groupId the primary key of the group
	* @return the matching c t user
	* @throws PortalException if a matching c t user could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.CTUser getCTUserByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.getCTUserByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the c t users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.CTUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of c t users
	* @param end the upper bound of the range of c t users (not inclusive)
	* @return the range of c t users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contenttargeting.model.CTUser> getCTUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.getCTUsers(start, end);
	}

	/**
	* Returns the number of c t users.
	*
	* @return the number of c t users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCTUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.getCTUsersCount();
	}

	/**
	* Updates the c t user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ctUser the c t user
	* @return the c t user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contenttargeting.model.CTUser updateCTUser(
		com.liferay.contenttargeting.model.CTUser ctUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ctUserLocalService.updateCTUser(ctUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ctUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ctUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ctUserLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CTUserLocalService getWrappedCTUserLocalService() {
		return _ctUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCTUserLocalService(
		CTUserLocalService ctUserLocalService) {
		_ctUserLocalService = ctUserLocalService;
	}

	@Override
	public CTUserLocalService getWrappedService() {
		return _ctUserLocalService;
	}

	@Override
	public void setWrappedService(CTUserLocalService ctUserLocalService) {
		_ctUserLocalService = ctUserLocalService;
	}

	private CTUserLocalService _ctUserLocalService;
}