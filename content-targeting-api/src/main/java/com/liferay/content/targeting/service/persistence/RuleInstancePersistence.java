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

import com.liferay.content.targeting.exception.NoSuchRuleInstanceException;
import com.liferay.content.targeting.model.RuleInstance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the rule instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.persistence.impl.RuleInstancePersistenceImpl
 * @see RuleInstanceUtil
 * @generated
 */
@ProviderType
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
	*/
	public java.util.List<RuleInstance> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the rule instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the rule instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns an ordered range of all the rule instances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where uuid = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public RuleInstance[] findByUuid_PrevAndNext(long ruleInstanceId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Removes all the rule instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of rule instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rule instances
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the rule instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchRuleInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the rule instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the rule instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the rule instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rule instance that was removed
	*/
	public RuleInstance removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the number of rule instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rule instances
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the rule instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rule instances
	*/
	public java.util.List<RuleInstance> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the rule instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the rule instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns an ordered range of all the rule instances where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public RuleInstance[] findByUuid_C_PrevAndNext(long ruleInstanceId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Removes all the rule instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of rule instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rule instances
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the rule instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching rule instances
	*/
	public java.util.List<RuleInstance> findByGroupId(long groupId);

	/**
	* Returns a range of all the rule instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByGroupId(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the rule instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns an ordered range of all the rule instances where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the first rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the last rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the last rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where groupId = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public RuleInstance[] findByGroupId_PrevAndNext(long ruleInstanceId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Removes all the rule instances where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of rule instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching rule instances
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the rule instances where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the matching rule instances
	*/
	public java.util.List<RuleInstance> findByUserSegmentId(long userSegmentId);

	/**
	* Returns a range of all the rule instances where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByUserSegmentId(
		long userSegmentId, int start, int end);

	/**
	* Returns an ordered range of all the rule instances where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByUserSegmentId(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns an ordered range of all the rule instances where userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByUserSegmentId(
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByUserSegmentId_First(long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the first rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByUserSegmentId_First(long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the last rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByUserSegmentId_Last(long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the last rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByUserSegmentId_Last(long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public RuleInstance[] findByUserSegmentId_PrevAndNext(long ruleInstanceId,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Removes all the rule instances where userSegmentId = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	*/
	public void removeByUserSegmentId(long userSegmentId);

	/**
	* Returns the number of rule instances where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the number of matching rule instances
	*/
	public int countByUserSegmentId(long userSegmentId);

	/**
	* Returns all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @return the matching rule instances
	*/
	public java.util.List<RuleInstance> findByR_U(java.lang.String ruleKey,
		long userSegmentId);

	/**
	* Returns a range of all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByR_U(java.lang.String ruleKey,
		long userSegmentId, int start, int end);

	/**
	* Returns an ordered range of all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByR_U(java.lang.String ruleKey,
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns an ordered range of all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching rule instances
	*/
	public java.util.List<RuleInstance> findByR_U(java.lang.String ruleKey,
		long userSegmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByR_U_First(java.lang.String ruleKey,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the first rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByR_U_First(java.lang.String ruleKey,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the last rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public RuleInstance findByR_U_Last(java.lang.String ruleKey,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the last rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public RuleInstance fetchByR_U_Last(java.lang.String ruleKey,
		long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public RuleInstance[] findByR_U_PrevAndNext(long ruleInstanceId,
		java.lang.String ruleKey, long userSegmentId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException;

	/**
	* Removes all the rule instances where ruleKey = &#63; and userSegmentId = &#63; from the database.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	*/
	public void removeByR_U(java.lang.String ruleKey, long userSegmentId);

	/**
	* Returns the number of rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @return the number of matching rule instances
	*/
	public int countByR_U(java.lang.String ruleKey, long userSegmentId);

	/**
	* Caches the rule instance in the entity cache if it is enabled.
	*
	* @param ruleInstance the rule instance
	*/
	public void cacheResult(RuleInstance ruleInstance);

	/**
	* Caches the rule instances in the entity cache if it is enabled.
	*
	* @param ruleInstances the rule instances
	*/
	public void cacheResult(java.util.List<RuleInstance> ruleInstances);

	/**
	* Creates a new rule instance with the primary key. Does not add the rule instance to the database.
	*
	* @param ruleInstanceId the primary key for the new rule instance
	* @return the new rule instance
	*/
	public RuleInstance create(long ruleInstanceId);

	/**
	* Removes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance that was removed
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public RuleInstance remove(long ruleInstanceId)
		throws NoSuchRuleInstanceException;

	public RuleInstance updateImpl(RuleInstance ruleInstance);

	/**
	* Returns the rule instance with the primary key or throws a {@link NoSuchRuleInstanceException} if it could not be found.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public RuleInstance findByPrimaryKey(long ruleInstanceId)
		throws NoSuchRuleInstanceException;

	/**
	* Returns the rule instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance, or <code>null</code> if a rule instance with the primary key could not be found
	*/
	public RuleInstance fetchByPrimaryKey(long ruleInstanceId);

	@Override
	public java.util.Map<java.io.Serializable, RuleInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the rule instances.
	*
	* @return the rule instances
	*/
	public java.util.List<RuleInstance> findAll();

	/**
	* Returns a range of all the rule instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @return the range of rule instances
	*/
	public java.util.List<RuleInstance> findAll(int start, int end);

	/**
	* Returns an ordered range of all the rule instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rule instances
	*/
	public java.util.List<RuleInstance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator);

	/**
	* Returns an ordered range of all the rule instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rule instances
	* @param end the upper bound of the range of rule instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of rule instances
	*/
	public java.util.List<RuleInstance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the rule instances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of rule instances.
	*
	* @return the number of rule instances
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}