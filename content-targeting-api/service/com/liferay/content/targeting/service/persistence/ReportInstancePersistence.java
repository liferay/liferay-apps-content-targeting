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

import com.liferay.content.targeting.model.ReportInstance;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the report instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstancePersistenceImpl
 * @see ReportInstanceUtil
 * @generated
 */
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
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the report instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the report instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report instances before and after the current report instance in the ordered set where uuid = &#63;.
	*
	* @param reportInstanceId the primary key of the current report instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance[] findByUuid_PrevAndNext(
		long reportInstanceId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the report instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of report instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report instance where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.content.targeting.NoSuchReportInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the report instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the report instance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of report instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the report instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the report instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the report instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report instances before and after the current report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param reportInstanceId the primary key of the current report instance
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance[] findByUuid_C_PrevAndNext(
		long reportInstanceId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the report instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of report instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the report instances where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByC_C(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the report instances where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByC_C(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the report instances where className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByC_C(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance findByC_C_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByC_C_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance findByC_C_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByC_C_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report instances before and after the current report instance in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param reportInstanceId the primary key of the current report instance
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance[] findByC_C_PrevAndNext(
		long reportInstanceId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the report instances where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of report instances where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @return the matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByR_C_C(
		java.lang.String reportKey, java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByR_C_C(
		java.lang.String reportKey, java.lang.String className, long classPK,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findByR_C_C(
		java.lang.String reportKey, java.lang.String className, long classPK,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance findByR_C_C_First(
		java.lang.String reportKey, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByR_C_C_First(
		java.lang.String reportKey, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance findByR_C_C_Last(
		java.lang.String reportKey, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByR_C_C_Last(
		java.lang.String reportKey, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report instances before and after the current report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportInstanceId the primary key of the current report instance
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance[] findByR_C_C_PrevAndNext(
		long reportInstanceId, java.lang.String reportKey,
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63; from the database.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByR_C_C(java.lang.String reportKey,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	*
	* @param reportKey the report key
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching report instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByR_C_C(java.lang.String reportKey,
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the report instance in the entity cache if it is enabled.
	*
	* @param reportInstance the report instance
	*/
	public void cacheResult(
		com.liferay.content.targeting.model.ReportInstance reportInstance);

	/**
	* Caches the report instances in the entity cache if it is enabled.
	*
	* @param reportInstances the report instances
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.model.ReportInstance> reportInstances);

	/**
	* Creates a new report instance with the primary key. Does not add the report instance to the database.
	*
	* @param reportInstanceId the primary key for the new report instance
	* @return the new report instance
	*/
	public com.liferay.content.targeting.model.ReportInstance create(
		long reportInstanceId);

	/**
	* Removes the report instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance that was removed
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance remove(
		long reportInstanceId)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.model.ReportInstance updateImpl(
		com.liferay.content.targeting.model.ReportInstance reportInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report instance with the primary key or throws a {@link com.liferay.content.targeting.NoSuchReportInstanceException} if it could not be found.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance
	* @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance findByPrimaryKey(
		long reportInstanceId)
		throws com.liferay.content.targeting.NoSuchReportInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the report instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportInstanceId the primary key of the report instance
	* @return the report instance, or <code>null</code> if a report instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.model.ReportInstance fetchByPrimaryKey(
		long reportInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the report instances.
	*
	* @return the report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the report instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @return the range of report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the report instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of report instances
	* @param end the upper bound of the range of report instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of report instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.model.ReportInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the report instances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of report instances.
	*
	* @return the number of report instances
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}