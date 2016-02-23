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

import com.liferay.content.targeting.model.RuleInstance;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the rule instance service. This utility wraps {@link com.liferay.content.targeting.service.persistence.impl.RuleInstancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstancePersistence
 * @see com.liferay.content.targeting.service.persistence.impl.RuleInstancePersistenceImpl
 * @generated
 */
@ProviderType
public class RuleInstanceUtil {
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
	public static void clearCache(RuleInstance ruleInstance) {
		getPersistence().clearCache(ruleInstance);
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
	public static List<RuleInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RuleInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RuleInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RuleInstance update(RuleInstance ruleInstance) {
		return getPersistence().update(ruleInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RuleInstance update(RuleInstance ruleInstance,
		ServiceContext serviceContext) {
		return getPersistence().update(ruleInstance, serviceContext);
	}

	/**
	* Returns all the rule instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rule instances
	*/
	public static List<RuleInstance> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<RuleInstance> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<RuleInstance> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<RuleInstance> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByUuid_First(java.lang.String uuid,
		OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByUuid_Last(java.lang.String uuid,
		OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where uuid = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public static RuleInstance[] findByUuid_PrevAndNext(long ruleInstanceId,
		java.lang.String uuid, OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByUuid_PrevAndNext(ruleInstanceId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the rule instances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of rule instances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rule instances
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the rule instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchRuleInstanceException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the rule instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the rule instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the rule instance where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the rule instance that was removed
	*/
	public static RuleInstance removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of rule instances where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching rule instances
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the rule instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching rule instances
	*/
	public static List<RuleInstance> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<RuleInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<RuleInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<RuleInstance> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static RuleInstance[] findByUuid_C_PrevAndNext(long ruleInstanceId,
		java.lang.String uuid, long companyId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(ruleInstanceId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the rule instances where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of rule instances where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching rule instances
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the rule instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching rule instances
	*/
	public static List<RuleInstance> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<RuleInstance> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<RuleInstance> findByGroupId(long groupId, int start,
		int end, OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static List<RuleInstance> findByGroupId(long groupId, int start,
		int end, OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByGroupId_First(long groupId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByGroupId_First(long groupId,
		OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByGroupId_Last(long groupId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last rule instance in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByGroupId_Last(long groupId,
		OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where groupId = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public static RuleInstance[] findByGroupId_PrevAndNext(
		long ruleInstanceId, long groupId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(ruleInstanceId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the rule instances where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of rule instances where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching rule instances
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the rule instances where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the matching rule instances
	*/
	public static List<RuleInstance> findByUserSegmentId(long userSegmentId) {
		return getPersistence().findByUserSegmentId(userSegmentId);
	}

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
	public static List<RuleInstance> findByUserSegmentId(long userSegmentId,
		int start, int end) {
		return getPersistence().findByUserSegmentId(userSegmentId, start, end);
	}

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
	public static List<RuleInstance> findByUserSegmentId(long userSegmentId,
		int start, int end, OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .findByUserSegmentId(userSegmentId, start, end,
			orderByComparator);
	}

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
	public static List<RuleInstance> findByUserSegmentId(long userSegmentId,
		int start, int end, OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserSegmentId(userSegmentId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByUserSegmentId_First(long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByUserSegmentId_First(userSegmentId, orderByComparator);
	}

	/**
	* Returns the first rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByUserSegmentId_First(long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .fetchByUserSegmentId_First(userSegmentId, orderByComparator);
	}

	/**
	* Returns the last rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByUserSegmentId_Last(long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByUserSegmentId_Last(userSegmentId, orderByComparator);
	}

	/**
	* Returns the last rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByUserSegmentId_Last(long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .fetchByUserSegmentId_Last(userSegmentId, orderByComparator);
	}

	/**
	* Returns the rule instances before and after the current rule instance in the ordered set where userSegmentId = &#63;.
	*
	* @param ruleInstanceId the primary key of the current rule instance
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule instance
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public static RuleInstance[] findByUserSegmentId_PrevAndNext(
		long ruleInstanceId, long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByUserSegmentId_PrevAndNext(ruleInstanceId,
			userSegmentId, orderByComparator);
	}

	/**
	* Removes all the rule instances where userSegmentId = &#63; from the database.
	*
	* @param userSegmentId the user segment ID
	*/
	public static void removeByUserSegmentId(long userSegmentId) {
		getPersistence().removeByUserSegmentId(userSegmentId);
	}

	/**
	* Returns the number of rule instances where userSegmentId = &#63;.
	*
	* @param userSegmentId the user segment ID
	* @return the number of matching rule instances
	*/
	public static int countByUserSegmentId(long userSegmentId) {
		return getPersistence().countByUserSegmentId(userSegmentId);
	}

	/**
	* Returns all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @return the matching rule instances
	*/
	public static List<RuleInstance> findByR_U(java.lang.String ruleKey,
		long userSegmentId) {
		return getPersistence().findByR_U(ruleKey, userSegmentId);
	}

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
	public static List<RuleInstance> findByR_U(java.lang.String ruleKey,
		long userSegmentId, int start, int end) {
		return getPersistence().findByR_U(ruleKey, userSegmentId, start, end);
	}

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
	public static List<RuleInstance> findByR_U(java.lang.String ruleKey,
		long userSegmentId, int start, int end,
		OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .findByR_U(ruleKey, userSegmentId, start, end,
			orderByComparator);
	}

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
	public static List<RuleInstance> findByR_U(java.lang.String ruleKey,
		long userSegmentId, int start, int end,
		OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByR_U(ruleKey, userSegmentId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByR_U_First(java.lang.String ruleKey,
		long userSegmentId, OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByR_U_First(ruleKey, userSegmentId, orderByComparator);
	}

	/**
	* Returns the first rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByR_U_First(java.lang.String ruleKey,
		long userSegmentId, OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .fetchByR_U_First(ruleKey, userSegmentId, orderByComparator);
	}

	/**
	* Returns the last rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance
	* @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	*/
	public static RuleInstance findByR_U_Last(java.lang.String ruleKey,
		long userSegmentId, OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByR_U_Last(ruleKey, userSegmentId, orderByComparator);
	}

	/**
	* Returns the last rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	*/
	public static RuleInstance fetchByR_U_Last(java.lang.String ruleKey,
		long userSegmentId, OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence()
				   .fetchByR_U_Last(ruleKey, userSegmentId, orderByComparator);
	}

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
	public static RuleInstance[] findByR_U_PrevAndNext(long ruleInstanceId,
		java.lang.String ruleKey, long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence()
				   .findByR_U_PrevAndNext(ruleInstanceId, ruleKey,
			userSegmentId, orderByComparator);
	}

	/**
	* Removes all the rule instances where ruleKey = &#63; and userSegmentId = &#63; from the database.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	*/
	public static void removeByR_U(java.lang.String ruleKey, long userSegmentId) {
		getPersistence().removeByR_U(ruleKey, userSegmentId);
	}

	/**
	* Returns the number of rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	*
	* @param ruleKey the rule key
	* @param userSegmentId the user segment ID
	* @return the number of matching rule instances
	*/
	public static int countByR_U(java.lang.String ruleKey, long userSegmentId) {
		return getPersistence().countByR_U(ruleKey, userSegmentId);
	}

	/**
	* Caches the rule instance in the entity cache if it is enabled.
	*
	* @param ruleInstance the rule instance
	*/
	public static void cacheResult(RuleInstance ruleInstance) {
		getPersistence().cacheResult(ruleInstance);
	}

	/**
	* Caches the rule instances in the entity cache if it is enabled.
	*
	* @param ruleInstances the rule instances
	*/
	public static void cacheResult(List<RuleInstance> ruleInstances) {
		getPersistence().cacheResult(ruleInstances);
	}

	/**
	* Creates a new rule instance with the primary key. Does not add the rule instance to the database.
	*
	* @param ruleInstanceId the primary key for the new rule instance
	* @return the new rule instance
	*/
	public static RuleInstance create(long ruleInstanceId) {
		return getPersistence().create(ruleInstanceId);
	}

	/**
	* Removes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance that was removed
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public static RuleInstance remove(long ruleInstanceId)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence().remove(ruleInstanceId);
	}

	public static RuleInstance updateImpl(RuleInstance ruleInstance) {
		return getPersistence().updateImpl(ruleInstance);
	}

	/**
	* Returns the rule instance with the primary key or throws a {@link NoSuchRuleInstanceException} if it could not be found.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance
	* @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	*/
	public static RuleInstance findByPrimaryKey(long ruleInstanceId)
		throws com.liferay.content.targeting.exception.NoSuchRuleInstanceException {
		return getPersistence().findByPrimaryKey(ruleInstanceId);
	}

	/**
	* Returns the rule instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ruleInstanceId the primary key of the rule instance
	* @return the rule instance, or <code>null</code> if a rule instance with the primary key could not be found
	*/
	public static RuleInstance fetchByPrimaryKey(long ruleInstanceId) {
		return getPersistence().fetchByPrimaryKey(ruleInstanceId);
	}

	public static java.util.Map<java.io.Serializable, RuleInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the rule instances.
	*
	* @return the rule instances
	*/
	public static List<RuleInstance> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<RuleInstance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<RuleInstance> findAll(int start, int end,
		OrderByComparator<RuleInstance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<RuleInstance> findAll(int start, int end,
		OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the rule instances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rule instances.
	*
	* @return the number of rule instances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static RuleInstancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RuleInstancePersistence, RuleInstancePersistence> _serviceTracker =
		ServiceTrackerFactory.open(RuleInstancePersistence.class);
}