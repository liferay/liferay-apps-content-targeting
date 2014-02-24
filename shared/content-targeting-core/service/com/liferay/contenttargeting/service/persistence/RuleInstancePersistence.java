/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service.persistence;

import com.liferay.contenttargeting.model.RuleInstance;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the rule instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstancePersistenceImpl
 * @see RuleInstanceUtil
 * @generated
 */
public interface RuleInstancePersistence extends BasePersistence<RuleInstance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RuleInstanceUtil} to access the rule instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rule instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rule instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rule instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where uuid = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance[] findByUuid_PrevAndNext(
		long ruleInstanceId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rule instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rule instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule instance where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.contenttargeting.NoSuchRuleInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rule instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rule instance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rule instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rule instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rule instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rule instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance[] findByUuid_C_PrevAndNext(
		long ruleInstanceId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rule instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rule instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rule instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rule instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rule instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where groupId = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance[] findByGroupId_PrevAndNext(
		long ruleInstanceId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rule instances where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rule instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rule instances where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByUserSegmentId(
		long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rule instances where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByUserSegmentId(
		long userSegmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rule instances where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByUserSegmentId(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByUserSegmentId_First(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByUserSegmentId_First(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByUserSegmentId_Last(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByUserSegmentId_Last(
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance[] findByUserSegmentId_PrevAndNext(
		long ruleInstanceId, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rule instances where userSegmentId = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserSegmentId(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rule instances where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the number of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserSegmentId(long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @return the matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByR_U(
		java.lang.String ruleKey, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByR_U(
		java.lang.String ruleKey, long userSegmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findByR_U(
		java.lang.String ruleKey, long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByR_U_First(
		java.lang.String ruleKey, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByR_U_First(
		java.lang.String ruleKey, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByR_U_Last(
		java.lang.String ruleKey, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByR_U_Last(
		java.lang.String ruleKey, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance[] findByR_U_PrevAndNext(
		long ruleInstanceId, java.lang.String ruleKey, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rule instances where ruleKey = &#63; and userSegmentId = &#63; from the database.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByR_U(java.lang.String ruleKey, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @return the number of matching rule instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByR_U(java.lang.String ruleKey, long userSegmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rule instance in the entity cache if it is enabled.
	*
	* @param ruleInstance the rule instance
	*/
	public void cacheResult(
		com.liferay.contenttargeting.model.RuleInstance ruleInstance);

	/**
	* Caches the rule instances in the entity cache if it is enabled.
	*
	* @param ruleInstances the rule instances
	*/
	public void cacheResult(
		java.util.List<com.liferay.contenttargeting.model.RuleInstance> ruleInstances);

	/**
	* Creates a new rule instance with the primary key. Does not add the rule instance to the database.
	*
	* @param ruleInstanceId the primary key for the new rule instance
	* @return the new rule instance
	*/
	public com.liferay.contenttargeting.model.RuleInstance create(
		long ruleInstanceId);

	/**
	* Removes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance that was removed
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance remove(
		long ruleInstanceId)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.contenttargeting.model.RuleInstance updateImpl(
		com.liferay.contenttargeting.model.RuleInstance ruleInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule instance with the primary key or throws a {@link com.liferay.contenttargeting.NoSuchRuleInstanceException} if it could not be found.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance
	* @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance findByPrimaryKey(
		long ruleInstanceId)
		throws com.liferay.contenttargeting.NoSuchRuleInstanceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance, or <code>null</code> if a rule instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contenttargeting.model.RuleInstance fetchByPrimaryKey(
		long ruleInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rule instances.
	*
	* @return the rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rule instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rule instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rule instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contenttargeting.model.RuleInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rule instances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rule instances.
	*
	* @return the number of rule instances
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}