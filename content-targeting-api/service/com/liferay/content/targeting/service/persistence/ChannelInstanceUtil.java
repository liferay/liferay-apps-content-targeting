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

package com.liferay.content.targeting.service.persistence;

import com.liferay.content.targeting.model.ChannelInstance;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the channel instance service. This utility wraps {@link ChannelInstancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstancePersistence
 * @see ChannelInstancePersistenceImpl
 * @generated
 */
public class ChannelInstanceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ChannelInstance channelInstance) {
		getPersistence().clearCache(channelInstance);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChannelInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChannelInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChannelInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ChannelInstance update(ChannelInstance channelInstance)
		throws SystemException {
		return getPersistence().update(channelInstance);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ChannelInstance update(ChannelInstance channelInstance,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(channelInstance, serviceContext);
	}

	/**
	* Returns all the channel instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the channel instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where uuid = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance[] findByUuid_PrevAndNext(
		long channelInstanceId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(channelInstanceId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the channel instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of channel instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.content.targeting.NoSuchChannelInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the channel instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the channel instance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of channel instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the channel instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the channel instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance[] findByUuid_C_PrevAndNext(
		long channelInstanceId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(channelInstanceId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the channel instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of channel instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the channel instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the channel instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where groupId = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance[] findByGroupId_PrevAndNext(
		long channelInstanceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(channelInstanceId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the channel instances where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of channel instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the channel instances where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(campaignId);
	}

	/**
	* Returns a range of all the channel instances where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(campaignId, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where campaignId = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance[] findByCampaignId_PrevAndNext(
		long channelInstanceId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(channelInstanceId, campaignId,
			orderByComparator);
	}

	/**
	* Removes all the channel instances where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignId(campaignId);
	}

	/**
	* Returns the number of channel instances where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignId(campaignId);
	}

	/**
	* Returns all the channel instances where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @return the matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByTacticId(
		long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTacticId(tacticId);
	}

	/**
	* Returns a range of all the channel instances where tacticId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tacticId the tactic ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByTacticId(
		long tacticId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTacticId(tacticId, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where tacticId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tacticId the tactic ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByTacticId(
		long tacticId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTacticId(tacticId, start, end, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByTacticId_First(
		long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTacticId_First(tacticId, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByTacticId_First(
		long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTacticId_First(tacticId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByTacticId_Last(
		long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTacticId_Last(tacticId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByTacticId_Last(
		long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTacticId_Last(tacticId, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where tacticId = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance[] findByTacticId_PrevAndNext(
		long channelInstanceId, long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTacticId_PrevAndNext(channelInstanceId, tacticId,
			orderByComparator);
	}

	/**
	* Removes all the channel instances where tacticId = &#63; from the database.
	*
	* @param tacticId the tactic ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTacticId(long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTacticId(tacticId);
	}

	/**
	* Returns the number of channel instances where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTacticId(long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTacticId(tacticId);
	}

	/**
	* Caches the channel instance in the entity cache if it is enabled.
	*
	* @param channelInstance the channel instance
	*/
	public static void cacheResult(
		com.liferay.content.targeting.model.ChannelInstance channelInstance) {
		getPersistence().cacheResult(channelInstance);
	}

	/**
	* Caches the channel instances in the entity cache if it is enabled.
	*
	* @param channelInstances the channel instances
	*/
	public static void cacheResult(
		java.util.List<com.liferay.content.targeting.model.ChannelInstance> channelInstances) {
		getPersistence().cacheResult(channelInstances);
	}

	/**
	* Creates a new channel instance with the primary key. Does not add the channel instance to the database.
	*
	* @param channelInstanceId the primary key for the new channel instance
	* @return the new channel instance
	*/
	public static com.liferay.content.targeting.model.ChannelInstance create(
		long channelInstanceId) {
		return getPersistence().create(channelInstanceId);
	}

	/**
	* Removes the channel instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance that was removed
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance remove(
		long channelInstanceId)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(channelInstanceId);
	}

	public static com.liferay.content.targeting.model.ChannelInstance updateImpl(
		com.liferay.content.targeting.model.ChannelInstance channelInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(channelInstance);
	}

	/**
	* Returns the channel instance with the primary key or throws a {@link com.liferay.content.targeting.NoSuchChannelInstanceException} if it could not be found.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance findByPrimaryKey(
		long channelInstanceId)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(channelInstanceId);
	}

	/**
	* Returns the channel instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance, or <code>null</code> if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.model.ChannelInstance fetchByPrimaryKey(
		long channelInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(channelInstanceId);
	}

	/**
	* Returns all the channel instances.
	*
	* @return the channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the channel instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the channel instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.model.ChannelInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the channel instances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of channel instances.
	*
	* @return the number of channel instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ChannelInstancePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ChannelInstancePersistence)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.service.ClpSerializer.getServletContextName(),
					ChannelInstancePersistence.class.getName());

			ReferenceRegistry.registerReference(ChannelInstanceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ChannelInstancePersistence persistence) {
	}

	private static ChannelInstancePersistence _persistence;
}