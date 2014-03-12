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

package com.liferay.anonymoususers.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AnonymousUser. This utility wraps
 * {@link com.liferay.anonymoususers.service.impl.AnonymousUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserLocalService
 * @see com.liferay.anonymoususers.service.base.AnonymousUserLocalServiceBaseImpl
 * @see com.liferay.anonymoususers.service.impl.AnonymousUserLocalServiceImpl
 * @generated
 */
public class AnonymousUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.anonymoususers.service.impl.AnonymousUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the anonymous user to the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUser the anonymous user
	* @return the anonymous user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.anonymoususers.model.AnonymousUser addAnonymousUser(
		com.liferay.anonymoususers.model.AnonymousUser anonymousUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAnonymousUser(anonymousUser);
	}

	/**
	* Creates a new anonymous user with the primary key. Does not add the anonymous user to the database.
	*
	* @param AnonymousUserId the primary key for the new anonymous user
	* @return the new anonymous user
	*/
	public static com.liferay.anonymoususers.model.AnonymousUser createAnonymousUser(
		long AnonymousUserId) {
		return getService().createAnonymousUser(AnonymousUserId);
	}

	/**
	* Deletes the anonymous user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param AnonymousUserId the primary key of the anonymous user
	* @return the anonymous user that was removed
	* @throws PortalException if a anonymous user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.anonymoususers.model.AnonymousUser deleteAnonymousUser(
		long AnonymousUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAnonymousUser(AnonymousUserId);
	}

	/**
	* Deletes the anonymous user from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUser the anonymous user
	* @return the anonymous user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.anonymoususers.model.AnonymousUser deleteAnonymousUser(
		com.liferay.anonymoususers.model.AnonymousUser anonymousUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAnonymousUser(anonymousUser);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.anonymoususers.model.AnonymousUser fetchAnonymousUser(
		long AnonymousUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAnonymousUser(AnonymousUserId);
	}

	/**
	* Returns the anonymous user with the matching UUID and company.
	*
	* @param uuid the anonymous user's UUID
	* @param companyId the primary key of the company
	* @return the matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.anonymoususers.model.AnonymousUser fetchAnonymousUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAnonymousUserByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the anonymous user with the primary key.
	*
	* @param AnonymousUserId the primary key of the anonymous user
	* @return the anonymous user
	* @throws PortalException if a anonymous user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.anonymoususers.model.AnonymousUser getAnonymousUser(
		long AnonymousUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnonymousUser(AnonymousUserId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the anonymous user with the matching UUID and company.
	*
	* @param uuid the anonymous user's UUID
	* @param companyId the primary key of the company
	* @return the matching anonymous user
	* @throws PortalException if a matching anonymous user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.anonymoususers.model.AnonymousUser getAnonymousUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnonymousUserByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of all the anonymous users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.anonymoususers.model.AnonymousUser> getAnonymousUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnonymousUsers(start, end);
	}

	/**
	* Returns the number of anonymous users.
	*
	* @return the number of anonymous users
	* @throws SystemException if a system exception occurred
	*/
	public static int getAnonymousUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnonymousUsersCount();
	}

	/**
	* Updates the anonymous user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param anonymousUser the anonymous user
	* @return the anonymous user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.anonymoususers.model.AnonymousUser updateAnonymousUser(
		com.liferay.anonymoususers.model.AnonymousUser anonymousUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAnonymousUser(anonymousUser);
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

	public static com.liferay.anonymoususers.model.AnonymousUser addAnonymousUser(
		long userId, java.lang.String lastIp, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAnonymousUser(userId, lastIp, typeSettings,
			serviceContext);
	}

	public static com.liferay.anonymoususers.model.AnonymousUser fetchAnonymousUserByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAnonymousUserByUserId(userId);
	}

	public static com.liferay.anonymoususers.model.AnonymousUser updateAnonymousUser(
		long userId, java.lang.String lastIp, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateAnonymousUser(userId, lastIp, typeSettings,
			serviceContext);
	}

	public static com.liferay.anonymoususers.model.AnonymousUser updateLastIp(
		long AnonymousUserId, java.lang.String lastIp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLastIp(AnonymousUserId, lastIp);
	}

	public static void clearService() {
		_service = null;
	}

	public static AnonymousUserLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AnonymousUserLocalService.class.getName());

			if (invokableLocalService instanceof AnonymousUserLocalService) {
				_service = (AnonymousUserLocalService)invokableLocalService;
			}
			else {
				_service = new AnonymousUserLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AnonymousUserLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AnonymousUserLocalService service) {
	}

	private static AnonymousUserLocalService _service;
}