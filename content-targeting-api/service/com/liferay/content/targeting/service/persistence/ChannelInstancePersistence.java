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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the channel instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstancePersistenceImpl
 * @see ChannelInstanceUtil
 * @generated
 */
public interface ChannelInstancePersistence extends BasePersistence<ChannelInstance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChannelInstanceUtil} to access the channel instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the channel instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.model.ChannelInstance[] findByUuid_PrevAndNext(
		long channelInstanceId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the channel instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.content.targeting.NoSuchChannelInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the channel instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the channel instance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the channel instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.model.ChannelInstance findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.model.ChannelInstance findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.model.ChannelInstance[] findByUuid_C_PrevAndNext(
		long channelInstanceId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the channel instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the channel instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.model.ChannelInstance[] findByGroupId_PrevAndNext(
		long channelInstanceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the channel instances where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the channel instances where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.model.ChannelInstance[] findByCampaignId_PrevAndNext(
		long channelInstanceId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the channel instances where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel instances where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the channel instances where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @return the matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByTacticId(
		long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByTacticId(
		long tacticId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findByTacticId(
		long tacticId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance findByTacticId_First(
		long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByTacticId_First(
		long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance findByTacticId_Last(
		long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByTacticId_Last(
		long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.content.targeting.model.ChannelInstance[] findByTacticId_PrevAndNext(
		long channelInstanceId, long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the channel instances where tacticId = &#63; from the database.
	*
	* @param tacticId the tactic ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTacticId(long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel instances where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @return the number of matching channel instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByTacticId(long tacticId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the channel instance in the entity cache if it is enabled.
	*
	* @param channelInstance the channel instance
	*/
	public void cacheResult(
		com.liferay.content.targeting.model.ChannelInstance channelInstance);

	/**
	* Caches the channel instances in the entity cache if it is enabled.
	*
	* @param channelInstances the channel instances
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.model.ChannelInstance> channelInstances);

	/**
	* Creates a new channel instance with the primary key. Does not add the channel instance to the database.
	*
	* @param channelInstanceId the primary key for the new channel instance
	* @return the new channel instance
	*/
	public com.liferay.content.targeting.model.ChannelInstance create(
		long channelInstanceId);

	/**
	* Removes the channel instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance that was removed
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance remove(
		long channelInstanceId)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.model.ChannelInstance updateImpl(
		com.liferay.content.targeting.model.ChannelInstance channelInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the channel instance with the primary key or throws a {@link com.liferay.content.targeting.NoSuchChannelInstanceException} if it could not be found.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance
	* @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance findByPrimaryKey(
		long channelInstanceId)
		throws com.liferay.content.targeting.NoSuchChannelInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the channel instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance, or <code>null</code> if a channel instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ChannelInstance fetchByPrimaryKey(
		long channelInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the channel instances.
	*
	* @return the channel instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.content.targeting.model.ChannelInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the channel instances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of channel instances.
	*
	* @return the number of channel instances
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}