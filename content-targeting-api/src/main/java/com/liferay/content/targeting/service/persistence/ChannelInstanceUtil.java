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

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.model.ChannelInstance;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the channel instance service. This utility wraps {@link com.liferay.content.targeting.service.persistence.impl.ChannelInstancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstancePersistence
 * @see com.liferay.content.targeting.service.persistence.impl.ChannelInstancePersistenceImpl
 * @generated
 */
@ProviderType
public class ChannelInstanceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ChannelInstance channelInstance) {
		getPersistence().clearCache(channelInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChannelInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChannelInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChannelInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChannelInstance update(ChannelInstance channelInstance) {
		return getPersistence().update(channelInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChannelInstance update(ChannelInstance channelInstance,
		ServiceContext serviceContext) {
		return getPersistence().update(channelInstance, serviceContext);
	}

	/**
	* Returns all the channel instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching channel instances
	*/
	public static List<ChannelInstance> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the channel instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	*/
	public static List<ChannelInstance> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the channel instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByUuid_First(java.lang.String uuid,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByUuid_Last(java.lang.String uuid,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where uuid = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance[] findByUuid_PrevAndNext(
		long channelInstanceId, java.lang.String uuid,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByUuid_PrevAndNext(channelInstanceId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the channel instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of channel instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching channel instances
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchChannelInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the channel instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the channel instance that was removed
	*/
	public static ChannelInstance removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of channel instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching channel instances
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the channel instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching channel instances
	*/
	public static List<ChannelInstance> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the channel instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	*/
	public static List<ChannelInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the channel instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
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
	*/
	public static ChannelInstance fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ChannelInstance> orderByComparator) {
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
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
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
	*/
	public static ChannelInstance fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ChannelInstance> orderByComparator) {
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
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance[] findByUuid_C_PrevAndNext(
		long channelInstanceId, java.lang.String uuid, long companyId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(channelInstanceId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the channel instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of channel instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching channel instances
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the channel instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching channel instances
	*/
	public static List<ChannelInstance> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the channel instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	*/
	public static List<ChannelInstance> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByGroupId(long groupId, int start,
		int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the channel instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByGroupId(long groupId, int start,
		int end, OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByGroupId_First(long groupId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByGroupId_First(long groupId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByGroupId_Last(long groupId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByGroupId_Last(long groupId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where groupId = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance[] findByGroupId_PrevAndNext(
		long channelInstanceId, long groupId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(channelInstanceId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the channel instances where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of channel instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching channel instances
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the channel instances where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @return the matching channel instances
	*/
	public static List<ChannelInstance> findByChannelKey(
		java.lang.String channelKey) {
		return getPersistence().findByChannelKey(channelKey);
	}

	/**
	* Returns a range of all the channel instances where channelKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param channelKey the channel key
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	*/
	public static List<ChannelInstance> findByChannelKey(
		java.lang.String channelKey, int start, int end) {
		return getPersistence().findByChannelKey(channelKey, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where channelKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param channelKey the channel key
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByChannelKey(
		java.lang.String channelKey, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .findByChannelKey(channelKey, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the channel instances where channelKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param channelKey the channel key
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByChannelKey(
		java.lang.String channelKey, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByChannelKey(channelKey, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first channel instance in the ordered set where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByChannelKey_First(
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByChannelKey_First(channelKey, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByChannelKey_First(
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .fetchByChannelKey_First(channelKey, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByChannelKey_Last(
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByChannelKey_Last(channelKey, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByChannelKey_Last(
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .fetchByChannelKey_Last(channelKey, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where channelKey = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance[] findByChannelKey_PrevAndNext(
		long channelInstanceId, java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByChannelKey_PrevAndNext(channelInstanceId, channelKey,
			orderByComparator);
	}

	/**
	* Removes all the channel instances where channelKey = &#63; from the database.
	*
	* @param channelKey the channel key
	*/
	public static void removeByChannelKey(java.lang.String channelKey) {
		getPersistence().removeByChannelKey(channelKey);
	}

	/**
	* Returns the number of channel instances where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @return the number of matching channel instances
	*/
	public static int countByChannelKey(java.lang.String channelKey) {
		return getPersistence().countByChannelKey(channelKey);
	}

	/**
	* Returns all the channel instances where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching channel instances
	*/
	public static List<ChannelInstance> findByCampaignId(long campaignId) {
		return getPersistence().findByCampaignId(campaignId);
	}

	/**
	* Returns a range of all the channel instances where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	*/
	public static List<ChannelInstance> findByCampaignId(long campaignId,
		int start, int end) {
		return getPersistence().findByCampaignId(campaignId, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByCampaignId(long campaignId,
		int start, int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the channel instances where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByCampaignId(long campaignId,
		int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByCampaignId_First(long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByCampaignId_First(long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByCampaignId_Last(long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByCampaignId_Last(long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator) {
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
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance[] findByCampaignId_PrevAndNext(
		long channelInstanceId, long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(channelInstanceId, campaignId,
			orderByComparator);
	}

	/**
	* Removes all the channel instances where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	*/
	public static void removeByCampaignId(long campaignId) {
		getPersistence().removeByCampaignId(campaignId);
	}

	/**
	* Returns the number of channel instances where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching channel instances
	*/
	public static int countByCampaignId(long campaignId) {
		return getPersistence().countByCampaignId(campaignId);
	}

	/**
	* Returns all the channel instances where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @return the matching channel instances
	*/
	public static List<ChannelInstance> findByTacticId(long tacticId) {
		return getPersistence().findByTacticId(tacticId);
	}

	/**
	* Returns a range of all the channel instances where tacticId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tacticId the tactic ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	*/
	public static List<ChannelInstance> findByTacticId(long tacticId,
		int start, int end) {
		return getPersistence().findByTacticId(tacticId, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where tacticId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tacticId the tactic ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByTacticId(long tacticId,
		int start, int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .findByTacticId(tacticId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the channel instances where tacticId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tacticId the tactic ID
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByTacticId(long tacticId,
		int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTacticId(tacticId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByTacticId_First(long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().findByTacticId_First(tacticId, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByTacticId_First(long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .fetchByTacticId_First(tacticId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByTacticId_Last(long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().findByTacticId_Last(tacticId, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByTacticId_Last(long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence().fetchByTacticId_Last(tacticId, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where tacticId = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance[] findByTacticId_PrevAndNext(
		long channelInstanceId, long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByTacticId_PrevAndNext(channelInstanceId, tacticId,
			orderByComparator);
	}

	/**
	* Removes all the channel instances where tacticId = &#63; from the database.
	*
	* @param tacticId the tactic ID
	*/
	public static void removeByTacticId(long tacticId) {
		getPersistence().removeByTacticId(tacticId);
	}

	/**
	* Returns the number of channel instances where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @return the number of matching channel instances
	*/
	public static int countByTacticId(long tacticId) {
		return getPersistence().countByTacticId(tacticId);
	}

	/**
	* Returns all the channel instances where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @return the matching channel instances
	*/
	public static List<ChannelInstance> findByC_K(long campaignId,
		java.lang.String channelKey) {
		return getPersistence().findByC_K(campaignId, channelKey);
	}

	/**
	* Returns a range of all the channel instances where campaignId = &#63; and channelKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	*/
	public static List<ChannelInstance> findByC_K(long campaignId,
		java.lang.String channelKey, int start, int end) {
		return getPersistence().findByC_K(campaignId, channelKey, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where campaignId = &#63; and channelKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByC_K(long campaignId,
		java.lang.String channelKey, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .findByC_K(campaignId, channelKey, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the channel instances where campaignId = &#63; and channelKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByC_K(long campaignId,
		java.lang.String channelKey, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_K(campaignId, channelKey, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByC_K_First(long campaignId,
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByC_K_First(campaignId, channelKey, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByC_K_First(long campaignId,
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .fetchByC_K_First(campaignId, channelKey, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByC_K_Last(long campaignId,
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByC_K_Last(campaignId, channelKey, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByC_K_Last(long campaignId,
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .fetchByC_K_Last(campaignId, channelKey, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance[] findByC_K_PrevAndNext(
		long channelInstanceId, long campaignId, java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByC_K_PrevAndNext(channelInstanceId, campaignId,
			channelKey, orderByComparator);
	}

	/**
	* Removes all the channel instances where campaignId = &#63; and channelKey = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	*/
	public static void removeByC_K(long campaignId, java.lang.String channelKey) {
		getPersistence().removeByC_K(campaignId, channelKey);
	}

	/**
	* Returns the number of channel instances where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @return the number of matching channel instances
	*/
	public static int countByC_K(long campaignId, java.lang.String channelKey) {
		return getPersistence().countByC_K(campaignId, channelKey);
	}

	/**
	* Returns all the channel instances where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @return the matching channel instances
	*/
	public static List<ChannelInstance> findByT_K(long tacticId,
		java.lang.String channelKey) {
		return getPersistence().findByT_K(tacticId, channelKey);
	}

	/**
	* Returns a range of all the channel instances where tacticId = &#63; and channelKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of matching channel instances
	*/
	public static List<ChannelInstance> findByT_K(long tacticId,
		java.lang.String channelKey, int start, int end) {
		return getPersistence().findByT_K(tacticId, channelKey, start, end);
	}

	/**
	* Returns an ordered range of all the channel instances where tacticId = &#63; and channelKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByT_K(long tacticId,
		java.lang.String channelKey, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .findByT_K(tacticId, channelKey, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the channel instances where tacticId = &#63; and channelKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching channel instances
	*/
	public static List<ChannelInstance> findByT_K(long tacticId,
		java.lang.String channelKey, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByT_K(tacticId, channelKey, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByT_K_First(long tacticId,
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByT_K_First(tacticId, channelKey, orderByComparator);
	}

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByT_K_First(long tacticId,
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .fetchByT_K_First(tacticId, channelKey, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByT_K_Last(long tacticId,
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByT_K_Last(tacticId, channelKey, orderByComparator);
	}

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByT_K_Last(long tacticId,
		java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence()
				   .fetchByT_K_Last(tacticId, channelKey, orderByComparator);
	}

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance[] findByT_K_PrevAndNext(
		long channelInstanceId, long tacticId, java.lang.String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence()
				   .findByT_K_PrevAndNext(channelInstanceId, tacticId,
			channelKey, orderByComparator);
	}

	/**
	* Removes all the channel instances where tacticId = &#63; and channelKey = &#63; from the database.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	*/
	public static void removeByT_K(long tacticId, java.lang.String channelKey) {
		getPersistence().removeByT_K(tacticId, channelKey);
	}

	/**
	* Returns the number of channel instances where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @return the number of matching channel instances
	*/
	public static int countByT_K(long tacticId, java.lang.String channelKey) {
		return getPersistence().countByT_K(tacticId, channelKey);
	}

	/**
	* Returns the channel instance where tacticId = &#63; and alias = &#63; or throws a {@link NoSuchChannelInstanceException} if it could not be found.
	*
	* @param tacticId the tactic ID
	* @param alias the alias
	* @return the matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public static ChannelInstance findByT_A(long tacticId,
		java.lang.String alias)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().findByT_A(tacticId, alias);
	}

	/**
	* Returns the channel instance where tacticId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tacticId the tactic ID
	* @param alias the alias
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByT_A(long tacticId,
		java.lang.String alias) {
		return getPersistence().fetchByT_A(tacticId, alias);
	}

	/**
	* Returns the channel instance where tacticId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tacticId the tactic ID
	* @param alias the alias
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public static ChannelInstance fetchByT_A(long tacticId,
		java.lang.String alias, boolean retrieveFromCache) {
		return getPersistence().fetchByT_A(tacticId, alias, retrieveFromCache);
	}

	/**
	* Removes the channel instance where tacticId = &#63; and alias = &#63; from the database.
	*
	* @param tacticId the tactic ID
	* @param alias the alias
	* @return the channel instance that was removed
	*/
	public static ChannelInstance removeByT_A(long tacticId,
		java.lang.String alias)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().removeByT_A(tacticId, alias);
	}

	/**
	* Returns the number of channel instances where tacticId = &#63; and alias = &#63;.
	*
	* @param tacticId the tactic ID
	* @param alias the alias
	* @return the number of matching channel instances
	*/
	public static int countByT_A(long tacticId, java.lang.String alias) {
		return getPersistence().countByT_A(tacticId, alias);
	}

	/**
	* Caches the channel instance in the entity cache if it is enabled.
	*
	* @param channelInstance the channel instance
	*/
	public static void cacheResult(ChannelInstance channelInstance) {
		getPersistence().cacheResult(channelInstance);
	}

	/**
	* Caches the channel instances in the entity cache if it is enabled.
	*
	* @param channelInstances the channel instances
	*/
	public static void cacheResult(List<ChannelInstance> channelInstances) {
		getPersistence().cacheResult(channelInstances);
	}

	/**
	* Creates a new channel instance with the primary key. Does not add the channel instance to the database.
	*
	* @param channelInstanceId the primary key for the new channel instance
	* @return the new channel instance
	*/
	public static ChannelInstance create(long channelInstanceId) {
		return getPersistence().create(channelInstanceId);
	}

	/**
	* Removes the channel instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance that was removed
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance remove(long channelInstanceId)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().remove(channelInstanceId);
	}

	public static ChannelInstance updateImpl(ChannelInstance channelInstance) {
		return getPersistence().updateImpl(channelInstance);
	}

	/**
	* Returns the channel instance with the primary key or throws a {@link NoSuchChannelInstanceException} if it could not be found.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance findByPrimaryKey(long channelInstanceId)
		throws com.liferay.content.targeting.exception.NoSuchChannelInstanceException {
		return getPersistence().findByPrimaryKey(channelInstanceId);
	}

	/**
	* Returns the channel instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance, or <code>null</code> if a channel instance with the primary key could not be found
	*/
	public static ChannelInstance fetchByPrimaryKey(long channelInstanceId) {
		return getPersistence().fetchByPrimaryKey(channelInstanceId);
	}

	public static java.util.Map<java.io.Serializable, ChannelInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the channel instances.
	*
	* @return the channel instances
	*/
	public static List<ChannelInstance> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the channel instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @return the range of channel instances
	*/
	public static List<ChannelInstance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the channel instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of channel instances
	*/
	public static List<ChannelInstance> findAll(int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the channel instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of channel instances
	* @param end the upper bound of the range of channel instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of channel instances
	*/
	public static List<ChannelInstance> findAll(int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the channel instances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of channel instances.
	*
	* @return the number of channel instances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ChannelInstancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ChannelInstancePersistence, ChannelInstancePersistence> _serviceTracker =
		ServiceTrackerFactory.open(ChannelInstancePersistence.class);
}