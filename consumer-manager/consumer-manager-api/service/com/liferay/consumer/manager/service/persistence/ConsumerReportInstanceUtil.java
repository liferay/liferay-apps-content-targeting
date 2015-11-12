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

import com.liferay.consumer.manager.model.ConsumerReportInstance;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the consumer report instance service. This utility wraps {@link ConsumerReportInstancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerReportInstancePersistence
 * @see ConsumerReportInstancePersistenceImpl
 * @generated
 */
public class ConsumerReportInstanceUtil {
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
	public static void clearCache(ConsumerReportInstance consumerReportInstance) {
		getPersistence().clearCache(consumerReportInstance);
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
	public static List<ConsumerReportInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConsumerReportInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConsumerReportInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ConsumerReportInstance update(
		ConsumerReportInstance consumerReportInstance)
		throws SystemException {
		return getPersistence().update(consumerReportInstance);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ConsumerReportInstance update(
		ConsumerReportInstance consumerReportInstance,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(consumerReportInstance, serviceContext);
	}

	/**
	* Returns all the consumer report instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the consumer report instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @return the range of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the consumer report instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first consumer report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first consumer report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last consumer report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last consumer report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the consumer report instances before and after the current consumer report instance in the ordered set where uuid = &#63;.
	*
	* @param consumerReportInstanceId the primary key of the current consumer report instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance[] findByUuid_PrevAndNext(
		long consumerReportInstanceId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(consumerReportInstanceId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the consumer report instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of consumer report instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the consumer report instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the consumer report instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @return the range of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the consumer report instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first consumer report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first consumer report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last consumer report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last consumer report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the consumer report instances before and after the current consumer report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param consumerReportInstanceId the primary key of the current consumer report instance
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance[] findByUuid_C_PrevAndNext(
		long consumerReportInstanceId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(consumerReportInstanceId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the consumer report instances where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of consumer report instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the consumer report instances where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @return the matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByConsumerId(
		long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByConsumerId(consumerId);
	}

	/**
	* Returns a range of all the consumer report instances where consumerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerId the consumer ID
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @return the range of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByConsumerId(
		long consumerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByConsumerId(consumerId, start, end);
	}

	/**
	* Returns an ordered range of all the consumer report instances where consumerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerId the consumer ID
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByConsumerId(
		long consumerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConsumerId(consumerId, start, end, orderByComparator);
	}

	/**
	* Returns the first consumer report instance in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByConsumerId_First(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConsumerId_First(consumerId, orderByComparator);
	}

	/**
	* Returns the first consumer report instance in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByConsumerId_First(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByConsumerId_First(consumerId, orderByComparator);
	}

	/**
	* Returns the last consumer report instance in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByConsumerId_Last(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConsumerId_Last(consumerId, orderByComparator);
	}

	/**
	* Returns the last consumer report instance in the ordered set where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByConsumerId_Last(
		long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByConsumerId_Last(consumerId, orderByComparator);
	}

	/**
	* Returns the consumer report instances before and after the current consumer report instance in the ordered set where consumerId = &#63;.
	*
	* @param consumerReportInstanceId the primary key of the current consumer report instance
	* @param consumerId the consumer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance[] findByConsumerId_PrevAndNext(
		long consumerReportInstanceId, long consumerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConsumerId_PrevAndNext(consumerReportInstanceId,
			consumerId, orderByComparator);
	}

	/**
	* Removes all the consumer report instances where consumerId = &#63; from the database.
	*
	* @param consumerId the consumer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByConsumerId(long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByConsumerId(consumerId);
	}

	/**
	* Returns the number of consumer report instances where consumerId = &#63;.
	*
	* @param consumerId the consumer ID
	* @return the number of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByConsumerId(long consumerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByConsumerId(consumerId);
	}

	/**
	* Returns all the consumer report instances where consumerId = &#63; and reportKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param reportKey the report key
	* @return the matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByC_R(
		long consumerId, java.lang.String reportKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_R(consumerId, reportKey);
	}

	/**
	* Returns a range of all the consumer report instances where consumerId = &#63; and reportKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerId the consumer ID
	* @param reportKey the report key
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @return the range of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByC_R(
		long consumerId, java.lang.String reportKey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_R(consumerId, reportKey, start, end);
	}

	/**
	* Returns an ordered range of all the consumer report instances where consumerId = &#63; and reportKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param consumerId the consumer ID
	* @param reportKey the report key
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByC_R(
		long consumerId, java.lang.String reportKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R(consumerId, reportKey, start, end,
			orderByComparator);
	}

	/**
	* Returns the first consumer report instance in the ordered set where consumerId = &#63; and reportKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param reportKey the report key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByC_R_First(
		long consumerId, java.lang.String reportKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_First(consumerId, reportKey, orderByComparator);
	}

	/**
	* Returns the first consumer report instance in the ordered set where consumerId = &#63; and reportKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param reportKey the report key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByC_R_First(
		long consumerId, java.lang.String reportKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_First(consumerId, reportKey, orderByComparator);
	}

	/**
	* Returns the last consumer report instance in the ordered set where consumerId = &#63; and reportKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param reportKey the report key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByC_R_Last(
		long consumerId, java.lang.String reportKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_Last(consumerId, reportKey, orderByComparator);
	}

	/**
	* Returns the last consumer report instance in the ordered set where consumerId = &#63; and reportKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param reportKey the report key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByC_R_Last(
		long consumerId, java.lang.String reportKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_R_Last(consumerId, reportKey, orderByComparator);
	}

	/**
	* Returns the consumer report instances before and after the current consumer report instance in the ordered set where consumerId = &#63; and reportKey = &#63;.
	*
	* @param consumerReportInstanceId the primary key of the current consumer report instance
	* @param consumerId the consumer ID
	* @param reportKey the report key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance[] findByC_R_PrevAndNext(
		long consumerReportInstanceId, long consumerId,
		java.lang.String reportKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_R_PrevAndNext(consumerReportInstanceId, consumerId,
			reportKey, orderByComparator);
	}

	/**
	* Removes all the consumer report instances where consumerId = &#63; and reportKey = &#63; from the database.
	*
	* @param consumerId the consumer ID
	* @param reportKey the report key
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_R(long consumerId, java.lang.String reportKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_R(consumerId, reportKey);
	}

	/**
	* Returns the number of consumer report instances where consumerId = &#63; and reportKey = &#63;.
	*
	* @param consumerId the consumer ID
	* @param reportKey the report key
	* @return the number of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_R(long consumerId, java.lang.String reportKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_R(consumerId, reportKey);
	}

	/**
	* Returns all the consumer report instances where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerId the consumer ID
	* @param reportCategoryKey the report category key
	* @return the matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByC_C_R(
		long companyId, long consumerId, java.lang.String reportCategoryKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_R(companyId, consumerId, reportCategoryKey);
	}

	/**
	* Returns a range of all the consumer report instances where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param consumerId the consumer ID
	* @param reportCategoryKey the report category key
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @return the range of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByC_C_R(
		long companyId, long consumerId, java.lang.String reportCategoryKey,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_R(companyId, consumerId, reportCategoryKey,
			start, end);
	}

	/**
	* Returns an ordered range of all the consumer report instances where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param consumerId the consumer ID
	* @param reportCategoryKey the report category key
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findByC_C_R(
		long companyId, long consumerId, java.lang.String reportCategoryKey,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_R(companyId, consumerId, reportCategoryKey,
			start, end, orderByComparator);
	}

	/**
	* Returns the first consumer report instance in the ordered set where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerId the consumer ID
	* @param reportCategoryKey the report category key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByC_C_R_First(
		long companyId, long consumerId, java.lang.String reportCategoryKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_R_First(companyId, consumerId, reportCategoryKey,
			orderByComparator);
	}

	/**
	* Returns the first consumer report instance in the ordered set where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerId the consumer ID
	* @param reportCategoryKey the report category key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByC_C_R_First(
		long companyId, long consumerId, java.lang.String reportCategoryKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_R_First(companyId, consumerId,
			reportCategoryKey, orderByComparator);
	}

	/**
	* Returns the last consumer report instance in the ordered set where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerId the consumer ID
	* @param reportCategoryKey the report category key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByC_C_R_Last(
		long companyId, long consumerId, java.lang.String reportCategoryKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_R_Last(companyId, consumerId, reportCategoryKey,
			orderByComparator);
	}

	/**
	* Returns the last consumer report instance in the ordered set where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerId the consumer ID
	* @param reportCategoryKey the report category key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByC_C_R_Last(
		long companyId, long consumerId, java.lang.String reportCategoryKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_C_R_Last(companyId, consumerId, reportCategoryKey,
			orderByComparator);
	}

	/**
	* Returns the consumer report instances before and after the current consumer report instance in the ordered set where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	*
	* @param consumerReportInstanceId the primary key of the current consumer report instance
	* @param companyId the company ID
	* @param consumerId the consumer ID
	* @param reportCategoryKey the report category key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance[] findByC_C_R_PrevAndNext(
		long consumerReportInstanceId, long companyId, long consumerId,
		java.lang.String reportCategoryKey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_C_R_PrevAndNext(consumerReportInstanceId,
			companyId, consumerId, reportCategoryKey, orderByComparator);
	}

	/**
	* Removes all the consumer report instances where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63; from the database.
	*
	* @param companyId the company ID
	* @param consumerId the consumer ID
	* @param reportCategoryKey the report category key
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_C_R(long companyId, long consumerId,
		java.lang.String reportCategoryKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_C_R(companyId, consumerId, reportCategoryKey);
	}

	/**
	* Returns the number of consumer report instances where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	*
	* @param companyId the company ID
	* @param consumerId the consumer ID
	* @param reportCategoryKey the report category key
	* @return the number of matching consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_C_R(long companyId, long consumerId,
		java.lang.String reportCategoryKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_C_R(companyId, consumerId, reportCategoryKey);
	}

	/**
	* Caches the consumer report instance in the entity cache if it is enabled.
	*
	* @param consumerReportInstance the consumer report instance
	*/
	public static void cacheResult(
		com.liferay.consumer.manager.model.ConsumerReportInstance consumerReportInstance) {
		getPersistence().cacheResult(consumerReportInstance);
	}

	/**
	* Caches the consumer report instances in the entity cache if it is enabled.
	*
	* @param consumerReportInstances the consumer report instances
	*/
	public static void cacheResult(
		java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> consumerReportInstances) {
		getPersistence().cacheResult(consumerReportInstances);
	}

	/**
	* Creates a new consumer report instance with the primary key. Does not add the consumer report instance to the database.
	*
	* @param consumerReportInstanceId the primary key for the new consumer report instance
	* @return the new consumer report instance
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance create(
		long consumerReportInstanceId) {
		return getPersistence().create(consumerReportInstanceId);
	}

	/**
	* Removes the consumer report instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param consumerReportInstanceId the primary key of the consumer report instance
	* @return the consumer report instance that was removed
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance remove(
		long consumerReportInstanceId)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(consumerReportInstanceId);
	}

	public static com.liferay.consumer.manager.model.ConsumerReportInstance updateImpl(
		com.liferay.consumer.manager.model.ConsumerReportInstance consumerReportInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(consumerReportInstance);
	}

	/**
	* Returns the consumer report instance with the primary key or throws a {@link com.liferay.consumer.manager.NoSuchConsumerReportInstanceException} if it could not be found.
	*
	* @param consumerReportInstanceId the primary key of the consumer report instance
	* @return the consumer report instance
	* @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance findByPrimaryKey(
		long consumerReportInstanceId)
		throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(consumerReportInstanceId);
	}

	/**
	* Returns the consumer report instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param consumerReportInstanceId the primary key of the consumer report instance
	* @return the consumer report instance, or <code>null</code> if a consumer report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.consumer.manager.model.ConsumerReportInstance fetchByPrimaryKey(
		long consumerReportInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(consumerReportInstanceId);
	}

	/**
	* Returns all the consumer report instances.
	*
	* @return the consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the consumer report instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @return the range of consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the consumer report instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of consumer report instances
	* @param end the upper bound of the range of consumer report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.consumer.manager.model.ConsumerReportInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the consumer report instances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of consumer report instances.
	*
	* @return the number of consumer report instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ConsumerReportInstancePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ConsumerReportInstancePersistence)PortletBeanLocatorUtil.locate(com.liferay.consumer.manager.service.ClpSerializer.getServletContextName(),
					ConsumerReportInstancePersistence.class.getName());

			ReferenceRegistry.registerReference(ConsumerReportInstanceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ConsumerReportInstancePersistence persistence) {
	}

	private static ConsumerReportInstancePersistence _persistence;
}