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

import com.liferay.content.targeting.model.ReportInstance;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the report instance service. This utility wraps {@link com.liferay.content.targeting.service.persistence.impl.ReportInstancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstancePersistence
 * @see com.liferay.content.targeting.service.persistence.impl.ReportInstancePersistenceImpl
 * @generated
 */
@ProviderType
public class ReportInstanceUtil {
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
	public static void clearCache(ReportInstance reportInstance) {
		getPersistence().clearCache(reportInstance);
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
	public static List<ReportInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ReportInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ReportInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ReportInstance update(ReportInstance reportInstance) {
		return getPersistence().update(reportInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ReportInstance update(ReportInstance reportInstance,
		ServiceContext serviceContext) {
		return getPersistence().update(reportInstance, serviceContext);
	}

	/**
	* Returns all the report instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching report instances
	*/
	public static List<ReportInstance> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the report instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of matching report instances
	*/
	public static List<ReportInstance> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the report instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching report instances
	*/
	public static List<ReportInstance> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the report instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching report instances
	*/
	public static List<ReportInstance> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<ReportInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public static ReportInstance findByUuid_First(java.lang.String uuid,
		OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static ReportInstance fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public static ReportInstance findByUuid_Last(java.lang.String uuid,
		OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static ReportInstance fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the report instances before and after the current report instance in the ordered set where uuid = &#63;.
	*
	* @param reportInstanceId the primary key of the current report instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report instance
	* @throws NoSuchReportInstanceException if a report instance with the primary key could not be found
	*/
	public static ReportInstance[] findByUuid_PrevAndNext(
		long reportInstanceId, java.lang.String uuid,
		OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence()
				   .findByUuid_PrevAndNext(reportInstanceId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the report instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of report instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching report instances
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the report instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchReportInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public static ReportInstance findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the report instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static ReportInstance fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the report instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static ReportInstance fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the report instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the report instance that was removed
	*/
	public static ReportInstance removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of report instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching report instances
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the report instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching report instances
	*/
	public static List<ReportInstance> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the report instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of matching report instances
	*/
	public static List<ReportInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the report instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching report instances
	*/
	public static List<ReportInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the report instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching report instances
	*/
	public static List<ReportInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<ReportInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public static ReportInstance findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static ReportInstance fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public static ReportInstance findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static ReportInstance fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the report instances before and after the current report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param reportInstanceId the primary key of the current report instance
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report instance
	* @throws NoSuchReportInstanceException if a report instance with the primary key could not be found
	*/
	public static ReportInstance[] findByUuid_C_PrevAndNext(
		long reportInstanceId, java.lang.String uuid, long companyId,
		OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(reportInstanceId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the report instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of report instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching report instances
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the report instances where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching report instances
	*/
	public static List<ReportInstance> findByC_C(java.lang.String className,
		long classPK) {
		return getPersistence().findByC_C(className, classPK);
	}

	/**
	* Returns a range of all the report instances where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of matching report instances
	*/
	public static List<ReportInstance> findByC_C(java.lang.String className,
		long classPK, int start, int end) {
		return getPersistence().findByC_C(className, classPK, start, end);
	}

	/**
	* Returns an ordered range of all the report instances where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching report instances
	*/
	public static List<ReportInstance> findByC_C(java.lang.String className,
		long classPK, int start, int end,
		OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence()
				   .findByC_C(className, classPK, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the report instances where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching report instances
	*/
	public static List<ReportInstance> findByC_C(java.lang.String className,
		long classPK, int start, int end,
		OrderByComparator<ReportInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_C(className, classPK, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public static ReportInstance findByC_C_First(java.lang.String className,
		long classPK, OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence()
				   .findByC_C_First(className, classPK, orderByComparator);
	}

	/**
	* Returns the first report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static ReportInstance fetchByC_C_First(java.lang.String className,
		long classPK, OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence()
				   .fetchByC_C_First(className, classPK, orderByComparator);
	}

	/**
	* Returns the last report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public static ReportInstance findByC_C_Last(java.lang.String className,
		long classPK, OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence()
				   .findByC_C_Last(className, classPK, orderByComparator);
	}

	/**
	* Returns the last report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static ReportInstance fetchByC_C_Last(java.lang.String className,
		long classPK, OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence()
				   .fetchByC_C_Last(className, classPK, orderByComparator);
	}

	/**
	* Returns the report instances before and after the current report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param reportInstanceId the primary key of the current report instance
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report instance
	* @throws NoSuchReportInstanceException if a report instance with the primary key could not be found
	*/
	public static ReportInstance[] findByC_C_PrevAndNext(
		long reportInstanceId, java.lang.String className, long classPK,
		OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence()
				   .findByC_C_PrevAndNext(reportInstanceId, className, classPK,
			orderByComparator);
	}

	/**
	* Removes all the report instances where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	*/
	public static void removeByC_C(java.lang.String className, long classPK) {
		getPersistence().removeByC_C(className, classPK);
	}

	/**
	* Returns the number of report instances where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching report instances
	*/
	public static int countByC_C(java.lang.String className, long classPK) {
		return getPersistence().countByC_C(className, classPK);
	}

	/**
	* Returns all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @return the matching report instances
	*/
	public static List<ReportInstance> findByR_C_C(java.lang.String reportKey,
		java.lang.String className, long classPK) {
		return getPersistence().findByR_C_C(reportKey, className, classPK);
	}

	/**
	* Returns a range of all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of matching report instances
	*/
	public static List<ReportInstance> findByR_C_C(java.lang.String reportKey,
		java.lang.String className, long classPK, int start, int end) {
		return getPersistence()
				   .findByR_C_C(reportKey, className, classPK, start, end);
	}

	/**
	* Returns an ordered range of all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching report instances
	*/
	public static List<ReportInstance> findByR_C_C(java.lang.String reportKey,
		java.lang.String className, long classPK, int start, int end,
		OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence()
				   .findByR_C_C(reportKey, className, classPK, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching report instances
	*/
	public static List<ReportInstance> findByR_C_C(java.lang.String reportKey,
		java.lang.String className, long classPK, int start, int end,
		OrderByComparator<ReportInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByR_C_C(reportKey, className, classPK, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public static ReportInstance findByR_C_C_First(java.lang.String reportKey,
		java.lang.String className, long classPK,
		OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence()
				   .findByR_C_C_First(reportKey, className, classPK,
			orderByComparator);
	}

	/**
	* Returns the first report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static ReportInstance fetchByR_C_C_First(
		java.lang.String reportKey, java.lang.String className, long classPK,
		OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence()
				   .fetchByR_C_C_First(reportKey, className, classPK,
			orderByComparator);
	}

	/**
	* Returns the last report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public static ReportInstance findByR_C_C_Last(java.lang.String reportKey,
		java.lang.String className, long classPK,
		OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence()
				   .findByR_C_C_Last(reportKey, className, classPK,
			orderByComparator);
	}

	/**
	* Returns the last report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public static ReportInstance fetchByR_C_C_Last(java.lang.String reportKey,
		java.lang.String className, long classPK,
		OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence()
				   .fetchByR_C_C_Last(reportKey, className, classPK,
			orderByComparator);
	}

	/**
	* Returns the report instances before and after the current report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportInstanceId the primary key of the current report instance
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report instance
	* @throws NoSuchReportInstanceException if a report instance with the primary key could not be found
	*/
	public static ReportInstance[] findByR_C_C_PrevAndNext(
		long reportInstanceId, java.lang.String reportKey,
		java.lang.String className, long classPK,
		OrderByComparator<ReportInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence()
				   .findByR_C_C_PrevAndNext(reportInstanceId, reportKey,
			className, classPK, orderByComparator);
	}

	/**
	* Removes all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63; from the database.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	*/
	public static void removeByR_C_C(java.lang.String reportKey,
		java.lang.String className, long classPK) {
		getPersistence().removeByR_C_C(reportKey, className, classPK);
	}

	/**
	* Returns the number of report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching report instances
	*/
	public static int countByR_C_C(java.lang.String reportKey,
		java.lang.String className, long classPK) {
		return getPersistence().countByR_C_C(reportKey, className, classPK);
	}

	/**
	* Caches the report instance in the entity cache if it is enabled.
	*
	* @param reportInstance the report instance
	*/
	public static void cacheResult(ReportInstance reportInstance) {
		getPersistence().cacheResult(reportInstance);
	}

	/**
	* Caches the report instances in the entity cache if it is enabled.
	*
	* @param reportInstances the report instances
	*/
	public static void cacheResult(List<ReportInstance> reportInstances) {
		getPersistence().cacheResult(reportInstances);
	}

	/**
	* Creates a new report instance with the primary key. Does not add the report instance to the database.
	*
	* @param reportInstanceId the primary key for the new report instance
	* @return the new report instance
	*/
	public static ReportInstance create(long reportInstanceId) {
		return getPersistence().create(reportInstanceId);
	}

	/**
	* Removes the report instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance that was removed
	* @throws NoSuchReportInstanceException if a report instance with the primary key could not be found
	*/
	public static ReportInstance remove(long reportInstanceId)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence().remove(reportInstanceId);
	}

	public static ReportInstance updateImpl(ReportInstance reportInstance) {
		return getPersistence().updateImpl(reportInstance);
	}

	/**
	* Returns the report instance with the primary key or throws a {@link NoSuchReportInstanceException} if it could not be found.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance
	* @throws NoSuchReportInstanceException if a report instance with the primary key could not be found
	*/
	public static ReportInstance findByPrimaryKey(long reportInstanceId)
		throws com.liferay.content.targeting.exception.NoSuchReportInstanceException {
		return getPersistence().findByPrimaryKey(reportInstanceId);
	}

	/**
	* Returns the report instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance, or <code>null</code> if a report instance with the primary key could not be found
	*/
	public static ReportInstance fetchByPrimaryKey(long reportInstanceId) {
		return getPersistence().fetchByPrimaryKey(reportInstanceId);
	}

	public static java.util.Map<java.io.Serializable, ReportInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the report instances.
	*
	* @return the report instances
	*/
	public static List<ReportInstance> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the report instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of report instances
	*/
	public static List<ReportInstance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the report instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of report instances
	*/
	public static List<ReportInstance> findAll(int start, int end,
		OrderByComparator<ReportInstance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the report instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of report instances
	*/
	public static List<ReportInstance> findAll(int start, int end,
		OrderByComparator<ReportInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the report instances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of report instances.
	*
	* @return the number of report instances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ReportInstancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ReportInstancePersistence, ReportInstancePersistence> _serviceTracker =
		ServiceTrackerFactory.open(ReportInstancePersistence.class);
}