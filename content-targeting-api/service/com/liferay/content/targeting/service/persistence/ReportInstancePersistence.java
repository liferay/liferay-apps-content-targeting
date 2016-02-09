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

import com.liferay.content.targeting.exception.NoSuchReportInstanceException;
import com.liferay.content.targeting.model.ReportInstance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the report instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.persistence.impl.ReportInstancePersistenceImpl
 * @see ReportInstanceUtil
 * @generated
 */
@ProviderType
public interface ReportInstancePersistence extends BasePersistence<ReportInstance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReportInstanceUtil} to access the report instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the report instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching report instances
	*/
	public java.util.List<ReportInstance> findByUuid(java.lang.String uuid);

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
	public java.util.List<ReportInstance> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<ReportInstance> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

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
	public java.util.List<ReportInstance> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public ReportInstance findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Returns the first report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public ReportInstance fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

	/**
	* Returns the last report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public ReportInstance findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Returns the last report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public ReportInstance fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

	/**
	* Returns the report instances before and after the current report instance in the ordered set where uuid = &#63;.
	*
	* @param reportInstanceId the primary key of the current report instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report instance
	* @throws NoSuchReportInstanceException if a report instance with the primary key could not be found
	*/
	public ReportInstance[] findByUuid_PrevAndNext(long reportInstanceId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Removes all the report instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of report instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching report instances
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the report instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchReportInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public ReportInstance findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchReportInstanceException;

	/**
	* Returns the report instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public ReportInstance fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the report instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public ReportInstance fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the report instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the report instance that was removed
	*/
	public ReportInstance removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchReportInstanceException;

	/**
	* Returns the number of report instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching report instances
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the report instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching report instances
	*/
	public java.util.List<ReportInstance> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<ReportInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<ReportInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

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
	public java.util.List<ReportInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public ReportInstance findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Returns the first report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public ReportInstance fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

	/**
	* Returns the last report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public ReportInstance findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Returns the last report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public ReportInstance fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

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
	public ReportInstance[] findByUuid_C_PrevAndNext(long reportInstanceId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Removes all the report instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of report instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching report instances
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the report instances where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching report instances
	*/
	public java.util.List<ReportInstance> findByC_C(
		java.lang.String className, long classPK);

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
	public java.util.List<ReportInstance> findByC_C(
		java.lang.String className, long classPK, int start, int end);

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
	public java.util.List<ReportInstance> findByC_C(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

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
	public java.util.List<ReportInstance> findByC_C(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public ReportInstance findByC_C_First(java.lang.String className,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Returns the first report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public ReportInstance fetchByC_C_First(java.lang.String className,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

	/**
	* Returns the last report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws NoSuchReportInstanceException if a matching report instance could not be found
	*/
	public ReportInstance findByC_C_Last(java.lang.String className,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Returns the last report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public ReportInstance fetchByC_C_Last(java.lang.String className,
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

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
	public ReportInstance[] findByC_C_PrevAndNext(long reportInstanceId,
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Removes all the report instances where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	*/
	public void removeByC_C(java.lang.String className, long classPK);

	/**
	* Returns the number of report instances where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching report instances
	*/
	public int countByC_C(java.lang.String className, long classPK);

	/**
	* Returns all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @return the matching report instances
	*/
	public java.util.List<ReportInstance> findByR_C_C(
		java.lang.String reportKey, java.lang.String className, long classPK);

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
	public java.util.List<ReportInstance> findByR_C_C(
		java.lang.String reportKey, java.lang.String className, long classPK,
		int start, int end);

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
	public java.util.List<ReportInstance> findByR_C_C(
		java.lang.String reportKey, java.lang.String className, long classPK,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

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
	public java.util.List<ReportInstance> findByR_C_C(
		java.lang.String reportKey, java.lang.String className, long classPK,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator,
		boolean retrieveFromCache);

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
	public ReportInstance findByR_C_C_First(java.lang.String reportKey,
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Returns the first report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public ReportInstance fetchByR_C_C_First(java.lang.String reportKey,
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

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
	public ReportInstance findByR_C_C_Last(java.lang.String reportKey,
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Returns the last report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	*/
	public ReportInstance fetchByR_C_C_Last(java.lang.String reportKey,
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

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
	public ReportInstance[] findByR_C_C_PrevAndNext(long reportInstanceId,
		java.lang.String reportKey, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator)
		throws NoSuchReportInstanceException;

	/**
	* Removes all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63; from the database.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	*/
	public void removeByR_C_C(java.lang.String reportKey,
		java.lang.String className, long classPK);

	/**
	* Returns the number of report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching report instances
	*/
	public int countByR_C_C(java.lang.String reportKey,
		java.lang.String className, long classPK);

	/**
	* Caches the report instance in the entity cache if it is enabled.
	*
	* @param reportInstance the report instance
	*/
	public void cacheResult(ReportInstance reportInstance);

	/**
	* Caches the report instances in the entity cache if it is enabled.
	*
	* @param reportInstances the report instances
	*/
	public void cacheResult(java.util.List<ReportInstance> reportInstances);

	/**
	* Creates a new report instance with the primary key. Does not add the report instance to the database.
	*
	* @param reportInstanceId the primary key for the new report instance
	* @return the new report instance
	*/
	public ReportInstance create(long reportInstanceId);

	/**
	* Removes the report instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance that was removed
	* @throws NoSuchReportInstanceException if a report instance with the primary key could not be found
	*/
	public ReportInstance remove(long reportInstanceId)
		throws NoSuchReportInstanceException;

	public ReportInstance updateImpl(ReportInstance reportInstance);

	/**
	* Returns the report instance with the primary key or throws a {@link NoSuchReportInstanceException} if it could not be found.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance
	* @throws NoSuchReportInstanceException if a report instance with the primary key could not be found
	*/
	public ReportInstance findByPrimaryKey(long reportInstanceId)
		throws NoSuchReportInstanceException;

	/**
	* Returns the report instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance, or <code>null</code> if a report instance with the primary key could not be found
	*/
	public ReportInstance fetchByPrimaryKey(long reportInstanceId);

	@Override
	public java.util.Map<java.io.Serializable, ReportInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the report instances.
	*
	* @return the report instances
	*/
	public java.util.List<ReportInstance> findAll();

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
	public java.util.List<ReportInstance> findAll(int start, int end);

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
	public java.util.List<ReportInstance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator);

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
	public java.util.List<ReportInstance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReportInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the report instances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of report instances.
	*
	* @return the number of report instances
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}