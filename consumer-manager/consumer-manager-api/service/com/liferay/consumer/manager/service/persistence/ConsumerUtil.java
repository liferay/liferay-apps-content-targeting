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

import com.liferay.consumer.manager.model.Consumer;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the consumer service. This utility wraps {@link ConsumerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerPersistence
 * @see ConsumerPersistenceImpl
 * @generated
 */
public class ConsumerUtil {
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
	public static void clearCache(Consumer consumer) {
		getPersistence().clearCache(consumer);
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
	public static List<Consumer> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Consumer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Consumer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Consumer update(Consumer consumer) throws SystemException {
		return getPersistence().update(consumer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Consumer update(Consumer consumer,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(consumer, serviceContext);
	}

	/**
	* Returns all the consumers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the consumers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @return the range of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the consumers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first consumer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first consumer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last consumer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last consumer in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the consumers before and after the current consumer in the ordered set where uuid = &#63;.
	*
	* @param consumerId the primary key of the current consumer
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer[] findByUuid_PrevAndNext(
		long consumerId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(consumerId, uuid, orderByComparator);
	}

	/**
	* Removes all the consumers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of consumers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the consumers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the consumers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @return the range of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the consumers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first consumer in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first consumer in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last consumer in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last consumer in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the consumers before and after the current consumer in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param consumerId the primary key of the current consumer
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer[] findByUuid_C_PrevAndNext(
		long consumerId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(consumerId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the consumers where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of consumers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the consumers where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the consumers where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @return the range of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the consumers where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first consumer in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first consumer in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last consumer in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last consumer in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the consumers before and after the current consumer in the ordered set where companyId = &#63;.
	*
	* @param consumerId the primary key of the current consumer
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer[] findByCompanyId_PrevAndNext(
		long consumerId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(consumerId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the consumers where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of consumers where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the consumer where companyId = &#63; and consumerKey = &#63; or throws a {@link com.liferay.consumer.manager.NoSuchConsumerException} if it could not be found.
	*
	* @param companyId the company ID
	* @param consumerKey the consumer key
	* @return the matching consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer findByC_C(
		long companyId, java.lang.String consumerKey)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_C(companyId, consumerKey);
	}

	/**
	* Returns the consumer where companyId = &#63; and consumerKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param consumerKey the consumer key
	* @return the matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByC_C(
		long companyId, java.lang.String consumerKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_C(companyId, consumerKey);
	}

	/**
	* Returns the consumer where companyId = &#63; and consumerKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param consumerKey the consumer key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByC_C(
		long companyId, java.lang.String consumerKey, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C(companyId, consumerKey, retrieveFromCache);
	}

	/**
	* Removes the consumer where companyId = &#63; and consumerKey = &#63; from the database.
	*
	* @param companyId the company ID
	* @param consumerKey the consumer key
	* @return the consumer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer removeByC_C(
		long companyId, java.lang.String consumerKey)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByC_C(companyId, consumerKey);
	}

	/**
	* Returns the number of consumers where companyId = &#63; and consumerKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerKey the consumer key
	* @return the number of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C(long companyId, java.lang.String consumerKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_C(companyId, consumerKey);
	}

	/**
	* Returns all the consumers where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @return the matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByConsumerIds(
		long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByConsumerIds(consumerId);
	}

	/**
	* Returns a range of all the consumers where consumerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerId the consumer ID
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @return the range of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByConsumerIds(
		long consumerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByConsumerIds(consumerId, start, end);
	}

	/**
	* Returns an ordered range of all the consumers where consumerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerId the consumer ID
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByConsumerIds(
		long consumerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConsumerIds(consumerId, start, end, orderByComparator);
	}

	/**
	* Returns the first consumer in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer findByConsumerIds_First(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConsumerIds_First(consumerId, orderByComparator);
	}

	/**
	* Returns the first consumer in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByConsumerIds_First(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByConsumerIds_First(consumerId, orderByComparator);
	}

	/**
	* Returns the last consumer in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer findByConsumerIds_Last(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConsumerIds_Last(consumerId, orderByComparator);
	}

	/**
	* Returns the last consumer in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer, or <code>null</code> if a matching consumer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByConsumerIds_Last(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByConsumerIds_Last(consumerId, orderByComparator);
	}

	/**
	* Returns all the consumers where consumerId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerIds the consumer IDs
	* @return the matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByConsumerIds(
		long[] consumerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByConsumerIds(consumerIds);
	}

	/**
	* Returns a range of all the consumers where consumerId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerIds the consumer IDs
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @return the range of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByConsumerIds(
		long[] consumerIds, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByConsumerIds(consumerIds, start, end);
	}

	/**
	* Returns an ordered range of all the consumers where consumerId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerIds the consumer IDs
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findByConsumerIds(
		long[] consumerIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConsumerIds(consumerIds, start, end, orderByComparator);
	}

	/**
	* Removes all the consumers where consumerId = &#63; from the database.
	*
	* @param consumerId the consumer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByConsumerIds(long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByConsumerIds(consumerId);
	}

	/**
	* Returns the number of consumers where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @return the number of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByConsumerIds(long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByConsumerIds(consumerId);
	}

	/**
	* Returns the number of consumers where consumerId = any &#63;.
	*
	* @param consumerIds the consumer IDs
	* @return the number of matching consumers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByConsumerIds(long[] consumerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByConsumerIds(consumerIds);
	}

	/**
	* Caches the consumer in the entity cache if it is enabled.
	*
	* @param consumer the consumer
	*/
	public static void cacheResult(
		com.liferay.consumer.manager.model.Consumer consumer) {
		getPersistence().cacheResult(consumer);
	}

	/**
	* Caches the consumers in the entity cache if it is enabled.
	*
	* @param consumers the consumers
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consumer.manager.model.Consumer> consumers) {
		getPersistence().cacheResult(consumers);
	}

	/**
	* Creates a new consumer with the primary key. Does not add the consumer to the database.
	*
	* @param consumerId the primary key for the new consumer
	* @return the new consumer
	*/
	public static com.liferay.consumer.manager.model.Consumer create(
		long consumerId) {
		return getPersistence().create(consumerId);
	}

	/**
	* Removes the consumer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerId the primary key of the consumer
	* @return the consumer that was removed
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer remove(
		long consumerId)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(consumerId);
	}

	public static com.liferay.consumer.manager.model.Consumer updateImpl(
		com.liferay.consumer.manager.model.Consumer consumer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(consumer);
	}

	/**
	* Returns the consumer with the primary key or throws a {@link com.liferay.consumer.manager.NoSuchConsumerException} if it could not be found.
	*
	* @param consumerId the primary key of the consumer
	* @return the consumer
	* @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer findByPrimaryKey(
		long consumerId)
		throws com.liferay.consumer.manager.NoSuchConsumerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(consumerId);
	}

	/**
	* Returns the consumer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param consumerId the primary key of the consumer
	* @return the consumer, or <code>null</code> if a consumer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.Consumer fetchByPrimaryKey(
		long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(consumerId);
	}

	/**
	* Returns all the consumers.
	*
	* @return the consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the consumers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @return the range of consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the consumers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumers
	* @param end the upper bound of the range of consumers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of consumers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.Consumer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the consumers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of consumers.
	*
	* @return the number of consumers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ConsumerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ConsumerPersistence)PortletBeanLocatorUtil.locate(com.liferay.consumer.manager.service.ClpSerializer.getServletContextName(),
					ConsumerPersistence.class.getName());

			ReferenceRegistry.registerReference(ConsumerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ConsumerPersistence persistence) {
	}

	private static ConsumerPersistence _persistence;
}