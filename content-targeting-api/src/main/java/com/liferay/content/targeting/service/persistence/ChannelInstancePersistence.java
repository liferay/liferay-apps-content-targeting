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

import com.liferay.content.targeting.exception.NoSuchChannelInstanceException;
import com.liferay.content.targeting.model.ChannelInstance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the channel instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.persistence.impl.ChannelInstancePersistenceImpl
 * @see ChannelInstanceUtil
 * @generated
 */
@ProviderType
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
	*/
	public java.util.List<ChannelInstance> findByUuid(java.lang.String uuid);

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
	public java.util.List<ChannelInstance> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<ChannelInstance> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public java.util.List<ChannelInstance> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where uuid = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public ChannelInstance[] findByUuid_PrevAndNext(long channelInstanceId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Removes all the channel instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of channel instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching channel instances
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchChannelInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the channel instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the channel instance that was removed
	*/
	public ChannelInstance removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the number of channel instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching channel instances
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the channel instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching channel instances
	*/
	public java.util.List<ChannelInstance> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<ChannelInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<ChannelInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public java.util.List<ChannelInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the first channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the last channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public ChannelInstance[] findByUuid_C_PrevAndNext(long channelInstanceId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Removes all the channel instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of channel instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching channel instances
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the channel instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching channel instances
	*/
	public java.util.List<ChannelInstance> findByGroupId(long groupId);

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
	public java.util.List<ChannelInstance> findByGroupId(long groupId,
		int start, int end);

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
	public java.util.List<ChannelInstance> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public java.util.List<ChannelInstance> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the first channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the last channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the last channel instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where groupId = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public ChannelInstance[] findByGroupId_PrevAndNext(long channelInstanceId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Removes all the channel instances where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of channel instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching channel instances
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the channel instances where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @return the matching channel instances
	*/
	public java.util.List<ChannelInstance> findByChannelKey(
		java.lang.String channelKey);

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
	public java.util.List<ChannelInstance> findByChannelKey(
		java.lang.String channelKey, int start, int end);

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
	public java.util.List<ChannelInstance> findByChannelKey(
		java.lang.String channelKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public java.util.List<ChannelInstance> findByChannelKey(
		java.lang.String channelKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first channel instance in the ordered set where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByChannelKey_First(java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the first channel instance in the ordered set where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByChannelKey_First(
		java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the last channel instance in the ordered set where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByChannelKey_Last(java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the last channel instance in the ordered set where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByChannelKey_Last(java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where channelKey = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public ChannelInstance[] findByChannelKey_PrevAndNext(
		long channelInstanceId, java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Removes all the channel instances where channelKey = &#63; from the database.
	*
	* @param channelKey the channel key
	*/
	public void removeByChannelKey(java.lang.String channelKey);

	/**
	* Returns the number of channel instances where channelKey = &#63;.
	*
	* @param channelKey the channel key
	* @return the number of matching channel instances
	*/
	public int countByChannelKey(java.lang.String channelKey);

	/**
	* Returns all the channel instances where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching channel instances
	*/
	public java.util.List<ChannelInstance> findByCampaignId(long campaignId);

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
	public java.util.List<ChannelInstance> findByCampaignId(long campaignId,
		int start, int end);

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
	public java.util.List<ChannelInstance> findByCampaignId(long campaignId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public java.util.List<ChannelInstance> findByCampaignId(long campaignId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByCampaignId_First(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByCampaignId_First(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByCampaignId_Last(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByCampaignId_Last(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where campaignId = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public ChannelInstance[] findByCampaignId_PrevAndNext(
		long channelInstanceId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Removes all the channel instances where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	*/
	public void removeByCampaignId(long campaignId);

	/**
	* Returns the number of channel instances where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching channel instances
	*/
	public int countByCampaignId(long campaignId);

	/**
	* Returns all the channel instances where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @return the matching channel instances
	*/
	public java.util.List<ChannelInstance> findByTacticId(long tacticId);

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
	public java.util.List<ChannelInstance> findByTacticId(long tacticId,
		int start, int end);

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
	public java.util.List<ChannelInstance> findByTacticId(long tacticId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public java.util.List<ChannelInstance> findByTacticId(long tacticId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByTacticId_First(long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByTacticId_First(long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByTacticId_Last(long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByTacticId_Last(long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the channel instances before and after the current channel instance in the ordered set where tacticId = &#63;.
	*
	* @param channelInstanceId the primary key of the current channel instance
	* @param tacticId the tactic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public ChannelInstance[] findByTacticId_PrevAndNext(
		long channelInstanceId, long tacticId,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Removes all the channel instances where tacticId = &#63; from the database.
	*
	* @param tacticId the tactic ID
	*/
	public void removeByTacticId(long tacticId);

	/**
	* Returns the number of channel instances where tacticId = &#63;.
	*
	* @param tacticId the tactic ID
	* @return the number of matching channel instances
	*/
	public int countByTacticId(long tacticId);

	/**
	* Returns all the channel instances where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @return the matching channel instances
	*/
	public java.util.List<ChannelInstance> findByC_K(long campaignId,
		java.lang.String channelKey);

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
	public java.util.List<ChannelInstance> findByC_K(long campaignId,
		java.lang.String channelKey, int start, int end);

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
	public java.util.List<ChannelInstance> findByC_K(long campaignId,
		java.lang.String channelKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public java.util.List<ChannelInstance> findByC_K(long campaignId,
		java.lang.String channelKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByC_K_First(long campaignId,
		java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the first channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByC_K_First(long campaignId,
		java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByC_K_Last(long campaignId,
		java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the last channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByC_K_Last(long campaignId,
		java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public ChannelInstance[] findByC_K_PrevAndNext(long channelInstanceId,
		long campaignId, java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Removes all the channel instances where campaignId = &#63; and channelKey = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	*/
	public void removeByC_K(long campaignId, java.lang.String channelKey);

	/**
	* Returns the number of channel instances where campaignId = &#63; and channelKey = &#63;.
	*
	* @param campaignId the campaign ID
	* @param channelKey the channel key
	* @return the number of matching channel instances
	*/
	public int countByC_K(long campaignId, java.lang.String channelKey);

	/**
	* Returns all the channel instances where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @return the matching channel instances
	*/
	public java.util.List<ChannelInstance> findByT_K(long tacticId,
		java.lang.String channelKey);

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
	public java.util.List<ChannelInstance> findByT_K(long tacticId,
		java.lang.String channelKey, int start, int end);

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
	public java.util.List<ChannelInstance> findByT_K(long tacticId,
		java.lang.String channelKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public java.util.List<ChannelInstance> findByT_K(long tacticId,
		java.lang.String channelKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByT_K_First(long tacticId,
		java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the first channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByT_K_First(long tacticId,
		java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByT_K_Last(long tacticId,
		java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the last channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByT_K_Last(long tacticId,
		java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public ChannelInstance[] findByT_K_PrevAndNext(long channelInstanceId,
		long tacticId, java.lang.String channelKey,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException;

	/**
	* Removes all the channel instances where tacticId = &#63; and channelKey = &#63; from the database.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	*/
	public void removeByT_K(long tacticId, java.lang.String channelKey);

	/**
	* Returns the number of channel instances where tacticId = &#63; and channelKey = &#63;.
	*
	* @param tacticId the tactic ID
	* @param channelKey the channel key
	* @return the number of matching channel instances
	*/
	public int countByT_K(long tacticId, java.lang.String channelKey);

	/**
	* Returns the channel instance where tacticId = &#63; and alias = &#63; or throws a {@link NoSuchChannelInstanceException} if it could not be found.
	*
	* @param tacticId the tactic ID
	* @param alias the alias
	* @return the matching channel instance
	* @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	*/
	public ChannelInstance findByT_A(long tacticId, java.lang.String alias)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the channel instance where tacticId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tacticId the tactic ID
	* @param alias the alias
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByT_A(long tacticId, java.lang.String alias);

	/**
	* Returns the channel instance where tacticId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tacticId the tactic ID
	* @param alias the alias
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	*/
	public ChannelInstance fetchByT_A(long tacticId, java.lang.String alias,
		boolean retrieveFromCache);

	/**
	* Removes the channel instance where tacticId = &#63; and alias = &#63; from the database.
	*
	* @param tacticId the tactic ID
	* @param alias the alias
	* @return the channel instance that was removed
	*/
	public ChannelInstance removeByT_A(long tacticId, java.lang.String alias)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the number of channel instances where tacticId = &#63; and alias = &#63;.
	*
	* @param tacticId the tactic ID
	* @param alias the alias
	* @return the number of matching channel instances
	*/
	public int countByT_A(long tacticId, java.lang.String alias);

	/**
	* Caches the channel instance in the entity cache if it is enabled.
	*
	* @param channelInstance the channel instance
	*/
	public void cacheResult(ChannelInstance channelInstance);

	/**
	* Caches the channel instances in the entity cache if it is enabled.
	*
	* @param channelInstances the channel instances
	*/
	public void cacheResult(java.util.List<ChannelInstance> channelInstances);

	/**
	* Creates a new channel instance with the primary key. Does not add the channel instance to the database.
	*
	* @param channelInstanceId the primary key for the new channel instance
	* @return the new channel instance
	*/
	public ChannelInstance create(long channelInstanceId);

	/**
	* Removes the channel instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance that was removed
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public ChannelInstance remove(long channelInstanceId)
		throws NoSuchChannelInstanceException;

	public ChannelInstance updateImpl(ChannelInstance channelInstance);

	/**
	* Returns the channel instance with the primary key or throws a {@link NoSuchChannelInstanceException} if it could not be found.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance
	* @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	*/
	public ChannelInstance findByPrimaryKey(long channelInstanceId)
		throws NoSuchChannelInstanceException;

	/**
	* Returns the channel instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param channelInstanceId the primary key of the channel instance
	* @return the channel instance, or <code>null</code> if a channel instance with the primary key could not be found
	*/
	public ChannelInstance fetchByPrimaryKey(long channelInstanceId);

	@Override
	public java.util.Map<java.io.Serializable, ChannelInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the channel instances.
	*
	* @return the channel instances
	*/
	public java.util.List<ChannelInstance> findAll();

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
	public java.util.List<ChannelInstance> findAll(int start, int end);

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
	public java.util.List<ChannelInstance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator);

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
	public java.util.List<ChannelInstance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the channel instances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of channel instances.
	*
	* @return the number of channel instances
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}