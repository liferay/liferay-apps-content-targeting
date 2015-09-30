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

package com.liferay.consumer.manager.service.persistence;

import com.liferay.consumer.manager.model.ConsumerExtensionInstance;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the consumer extension instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerExtensionInstancePersistenceImpl
 * @see ConsumerExtensionInstanceUtil
 * @generated
 */
public interface ConsumerExtensionInstancePersistence extends BasePersistence<ConsumerExtensionInstance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConsumerExtensionInstanceUtil} to access the consumer extension instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the consumer extension instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer extension instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @return the range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer extension instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where uuid = &#63;.
	*
	* @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance[] findByUuid_PrevAndNext(
		long consumerExtensionInstanceId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer extension instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer extension instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the consumer extension instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer extension instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @return the range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer extension instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance[] findByUuid_C_PrevAndNext(
		long consumerExtensionInstanceId, java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer extension instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer extension instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the consumer extension instances where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer extension instances where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @return the range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer extension instances where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where companyId = &#63;.
	*
	* @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance[] findByCompanyId_PrevAndNext(
		long consumerExtensionInstanceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer extension instances where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer extension instances where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the consumer extension instances where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @return the matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByConsumerId(
		long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer extension instances where consumerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerId the consumer ID
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @return the range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByConsumerId(
		long consumerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer extension instances where consumerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerId the consumer ID
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByConsumerId(
		long consumerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByConsumerId_First(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByConsumerId_First(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByConsumerId_Last(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByConsumerId_Last(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where consumerId = &#63;.
	*
	* @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance[] findByConsumerId_PrevAndNext(
		long consumerExtensionInstanceId, long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer extension instances where consumerId = &#63; from the database.
	*
	* @param consumerId the consumer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByConsumerId(long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer extension instances where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @return the number of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByConsumerId(long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the consumer extension instances where companyId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerExtensionKey the consumer extension key
	* @return the matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByC_C(
		long companyId, java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer extension instances where companyId = &#63; and consumerExtensionKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param consumerExtensionKey the consumer extension key
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @return the range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByC_C(
		long companyId, java.lang.String consumerExtensionKey, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer extension instances where companyId = &#63; and consumerExtensionKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param consumerExtensionKey the consumer extension key
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByC_C(
		long companyId, java.lang.String consumerExtensionKey, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where companyId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerExtensionKey the consumer extension key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByC_C_First(
		long companyId, java.lang.String consumerExtensionKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where companyId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerExtensionKey the consumer extension key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByC_C_First(
		long companyId, java.lang.String consumerExtensionKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where companyId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerExtensionKey the consumer extension key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByC_C_Last(
		long companyId, java.lang.String consumerExtensionKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where companyId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerExtensionKey the consumer extension key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByC_C_Last(
		long companyId, java.lang.String consumerExtensionKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where companyId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	* @param companyId the company ID
	* @param consumerExtensionKey the consumer extension key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance[] findByC_C_PrevAndNext(
		long consumerExtensionInstanceId, long companyId,
		java.lang.String consumerExtensionKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer extension instances where companyId = &#63; and consumerExtensionKey = &#63; from the database.
	*
	* @param companyId the company ID
	* @param consumerExtensionKey the consumer extension key
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C(long companyId,
		java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer extension instances where companyId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerExtensionKey the consumer extension key
	* @return the number of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C(long companyId, java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the consumer extension instances where consumerId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param consumerExtensionKey the consumer extension key
	* @return the matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByC_K(
		long consumerId, java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer extension instances where consumerId = &#63; and consumerExtensionKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerId the consumer ID
	* @param consumerExtensionKey the consumer extension key
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @return the range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByC_K(
		long consumerId, java.lang.String consumerExtensionKey, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer extension instances where consumerId = &#63; and consumerExtensionKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerId the consumer ID
	* @param consumerExtensionKey the consumer extension key
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findByC_K(
		long consumerId, java.lang.String consumerExtensionKey, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where consumerId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param consumerExtensionKey the consumer extension key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByC_K_First(
		long consumerId, java.lang.String consumerExtensionKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first consumer extension instance in the ordered set where consumerId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param consumerExtensionKey the consumer extension key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByC_K_First(
		long consumerId, java.lang.String consumerExtensionKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where consumerId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param consumerExtensionKey the consumer extension key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByC_K_Last(
		long consumerId, java.lang.String consumerExtensionKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last consumer extension instance in the ordered set where consumerId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param consumerExtensionKey the consumer extension key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByC_K_Last(
		long consumerId, java.lang.String consumerExtensionKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where consumerId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	* @param consumerId the consumer ID
	* @param consumerExtensionKey the consumer extension key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance[] findByC_K_PrevAndNext(
		long consumerExtensionInstanceId, long consumerId,
		java.lang.String consumerExtensionKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer extension instances where consumerId = &#63; and consumerExtensionKey = &#63; from the database.
	*
	* @param consumerId the consumer ID
	* @param consumerExtensionKey the consumer extension key
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_K(long consumerId,
		java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer extension instances where consumerId = &#63; and consumerExtensionKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param consumerExtensionKey the consumer extension key
	* @return the number of matching consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_K(long consumerId, java.lang.String consumerExtensionKey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the consumer extension instance in the entity cache if it is enabled.
	*
	* @param consumerExtensionInstance the consumer extension instance
	*/
	public void cacheResult(
		com.liferay.consumer.manager.model.ConsumerExtensionInstance consumerExtensionInstance);

	/**
	* Caches the consumer extension instances in the entity cache if it is enabled.
	*
	* @param consumerExtensionInstances the consumer extension instances
	*/
	public void cacheResult(
		java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> consumerExtensionInstances);

	/**
	* Creates a new consumer extension instance with the primary key. Does not add the consumer extension instance to the database.
	*
	* @param consumerExtensionInstanceId the primary key for the new consumer extension instance
	* @return the new consumer extension instance
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance create(
		long consumerExtensionInstanceId);

	/**
	* Removes the consumer extension instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerExtensionInstanceId the primary key of the consumer extension instance
	* @return the consumer extension instance that was removed
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance remove(
		long consumerExtensionInstanceId)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.consumer.manager.model.ConsumerExtensionInstance updateImpl(
		com.liferay.consumer.manager.model.ConsumerExtensionInstance consumerExtensionInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer extension instance with the primary key or throws a {@link com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException} if it could not be found.
	*
	* @param consumerExtensionInstanceId the primary key of the consumer extension instance
	* @return the consumer extension instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance findByPrimaryKey(
		long consumerExtensionInstanceId)
		throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the consumer extension instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param consumerExtensionInstanceId the primary key of the consumer extension instance
	* @return the consumer extension instance, or <code>null</code> if a consumer extension instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.consumer.manager.model.ConsumerExtensionInstance fetchByPrimaryKey(
		long consumerExtensionInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the consumer extension instances.
	*
	* @return the consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the consumer extension instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @return the range of consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the consumer extension instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumer extension instances
	* @param end the upper bound of the range of consumer extension instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.consumer.manager.model.ConsumerExtensionInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the consumer extension instances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of consumer extension instances.
	*
	* @return the number of consumer extension instances
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}