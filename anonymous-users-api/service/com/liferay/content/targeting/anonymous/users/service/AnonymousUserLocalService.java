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

package com.liferay.content.targeting.anonymous.users.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for AnonymousUser. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserLocalServiceUtil
 * @see com.liferay.content.targeting.anonymous.users.service.base.AnonymousUserLocalServiceBaseImpl
 * @see com.liferay.content.targeting.anonymous.users.service.impl.AnonymousUserLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AnonymousUserLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnonymousUserLocalServiceUtil} to access the anonymous user local service. Add custom service methods to {@link com.liferay.content.targeting.anonymous.users.service.impl.AnonymousUserLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the anonymous user to the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUser the anonymous user
	* @return the anonymous user that was added
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser addAnonymousUser(
		com.liferay.content.targeting.anonymous.users.model.AnonymousUser anonymousUser);

	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser addAnonymousUser(
		long userId, java.lang.String lastIp, java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException, SystemException;

	public void checkAnonymousUsers() throws PortalException, SystemException;

	/**
	* Creates a new anonymous user with the primary key. Does not add the anonymous user to the database.
	*
	* @param anonymousUserId the primary key for the new anonymous user
	* @return the new anonymous user
	*/
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser createAnonymousUser(
		long anonymousUserId);

	/**
	* Deletes the anonymous user from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUser the anonymous user
	* @return the anonymous user that was removed
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser deleteAnonymousUser(
		com.liferay.content.targeting.anonymous.users.model.AnonymousUser anonymousUser);

	/**
	* Deletes the anonymous user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param anonymousUserId the primary key of the anonymous user
	* @return the anonymous user that was removed
	* @throws PortalException if a anonymous user with the primary key could not be found
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser deleteAnonymousUser(
		long anonymousUserId) throws PortalException;

	public void deleteAnonymousUsers(long companyId, java.util.Date createDate,
		boolean includeUsers) throws PortalException, SystemException;

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws PortalException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.anonymous.users.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.anonymous.users.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser fetchAnonymousUser(
		long anonymousUserId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser fetchAnonymousUserByUserId(
		long userId) throws PortalException, SystemException;

	/**
	* Returns the anonymous user with the matching UUID and company.
	*
	* @param uuid the anonymous user's UUID
	* @param companyId the primary key of the company
	* @return the matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser fetchAnonymousUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the anonymous user with the primary key.
	*
	* @param anonymousUserId the primary key of the anonymous user
	* @return the anonymous user
	* @throws PortalException if a anonymous user with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser getAnonymousUser(
		long anonymousUserId) throws PortalException;

	/**
	* Returns the anonymous user with the matching UUID and company.
	*
	* @param uuid the anonymous user's UUID
	* @param companyId the primary key of the company
	* @return the matching anonymous user
	* @throws PortalException if a matching anonymous user could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser getAnonymousUserByUuidAndCompanyId(
		java.lang.String uuid, long companyId) throws PortalException;

	/**
	* Returns a range of all the anonymous users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.anonymous.users.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of anonymous users
	* @param end the upper bound of the range of anonymous users (not inclusive)
	* @return the range of anonymous users
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsers(
		int start, int end);

	/**
	* Returns the number of anonymous users.
	*
	* @return the number of anonymous users
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnonymousUsersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.portlet.exportimport.lar.PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Date getMaxAge() throws PortalException, SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj) throws PortalException;

	/**
	* Updates the anonymous user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param anonymousUser the anonymous user
	* @return the anonymous user that was updated
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser updateAnonymousUser(
		com.liferay.content.targeting.anonymous.users.model.AnonymousUser anonymousUser);

	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser updateAnonymousUser(
		long anonymousUserId, long userId, java.lang.String lastIp,
		java.lang.String typeSettings,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException, SystemException;

	public com.liferay.content.targeting.anonymous.users.model.AnonymousUser updateLastIp(
		long anonymousUserId, java.lang.String lastIp)
		throws PortalException, SystemException;
}