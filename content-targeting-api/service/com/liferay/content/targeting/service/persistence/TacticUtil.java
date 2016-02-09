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

import com.liferay.content.targeting.model.Tactic;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the tactic service. This utility wraps {@link com.liferay.content.targeting.service.persistence.impl.TacticPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TacticPersistence
 * @see com.liferay.content.targeting.service.persistence.impl.TacticPersistenceImpl
 * @generated
 */
@ProviderType
public class TacticUtil {
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
	public static void clearCache(Tactic tactic) {
		getPersistence().clearCache(tactic);
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
	public static List<Tactic> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Tactic> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Tactic> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Tactic> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Tactic update(Tactic tactic) {
		return getPersistence().update(tactic);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Tactic update(Tactic tactic, ServiceContext serviceContext) {
		return getPersistence().update(tactic, serviceContext);
	}

	/**
	* Returns all the tactics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching tactics
	*/
	public static List<Tactic> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the tactics where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @return the range of matching tactics
	*/
	public static List<Tactic> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the tactics where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tactics
	*/
	public static List<Tactic> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Tactic> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tactics where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tactics
	*/
	public static List<Tactic> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Tactic> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tactic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public static Tactic findByUuid_First(java.lang.String uuid,
		OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first tactic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static Tactic fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Tactic> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last tactic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public static Tactic findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last tactic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static Tactic fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Tactic> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the tactics before and after the current tactic in the ordered set where uuid = &#63;.
	*
	* @param tacticId the primary key of the current tactic
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public static Tactic[] findByUuid_PrevAndNext(long tacticId,
		java.lang.String uuid, OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence()
				   .findByUuid_PrevAndNext(tacticId, uuid, orderByComparator);
	}

	/**
	* Removes all the tactics where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of tactics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching tactics
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the tactic where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTacticException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public static Tactic findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the tactic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static Tactic fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the tactic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static Tactic fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the tactic where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the tactic that was removed
	*/
	public static Tactic removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of tactics where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching tactics
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the tactics where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching tactics
	*/
	public static List<Tactic> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the tactics where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @return the range of matching tactics
	*/
	public static List<Tactic> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the tactics where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tactics
	*/
	public static List<Tactic> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Tactic> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tactics where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tactics
	*/
	public static List<Tactic> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Tactic> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public static Tactic findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static Tactic fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Tactic> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public static Tactic findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static Tactic fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Tactic> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the tactics before and after the current tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param tacticId the primary key of the current tactic
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public static Tactic[] findByUuid_C_PrevAndNext(long tacticId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(tacticId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the tactics where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of tactics where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching tactics
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the tactics where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tactics
	*/
	public static List<Tactic> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the tactics where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @return the range of matching tactics
	*/
	public static List<Tactic> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the tactics where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tactics
	*/
	public static List<Tactic> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Tactic> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tactics where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tactics
	*/
	public static List<Tactic> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Tactic> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tactic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public static Tactic findByGroupId_First(long groupId,
		OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first tactic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static Tactic fetchByGroupId_First(long groupId,
		OrderByComparator<Tactic> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last tactic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public static Tactic findByGroupId_Last(long groupId,
		OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last tactic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static Tactic fetchByGroupId_Last(long groupId,
		OrderByComparator<Tactic> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the tactics before and after the current tactic in the ordered set where groupId = &#63;.
	*
	* @param tacticId the primary key of the current tactic
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public static Tactic[] findByGroupId_PrevAndNext(long tacticId,
		long groupId, OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(tacticId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the tactics that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tactics that the user has permission to view
	*/
	public static List<Tactic> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the tactics that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @return the range of matching tactics that the user has permission to view
	*/
	public static List<Tactic> filterFindByGroupId(long groupId, int start,
		int end) {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the tactics that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tactics that the user has permission to view
	*/
	public static List<Tactic> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator<Tactic> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the tactics before and after the current tactic in the ordered set of tactics that the user has permission to view where groupId = &#63;.
	*
	* @param tacticId the primary key of the current tactic
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public static Tactic[] filterFindByGroupId_PrevAndNext(long tacticId,
		long groupId, OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(tacticId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the tactics where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of tactics where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tactics
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of tactics that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tactics that the user has permission to view
	*/
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the tactics where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching tactics
	*/
	public static List<Tactic> findByCampaignId(long campaignId) {
		return getPersistence().findByCampaignId(campaignId);
	}

	/**
	* Returns a range of all the tactics where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @return the range of matching tactics
	*/
	public static List<Tactic> findByCampaignId(long campaignId, int start,
		int end) {
		return getPersistence().findByCampaignId(campaignId, start, end);
	}

	/**
	* Returns an ordered range of all the tactics where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tactics
	*/
	public static List<Tactic> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator<Tactic> orderByComparator) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tactics where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching tactics
	*/
	public static List<Tactic> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator<Tactic> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCampaignId(campaignId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first tactic in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public static Tactic findByCampaignId_First(long campaignId,
		OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first tactic in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static Tactic fetchByCampaignId_First(long campaignId,
		OrderByComparator<Tactic> orderByComparator) {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last tactic in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public static Tactic findByCampaignId_Last(long campaignId,
		OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last tactic in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public static Tactic fetchByCampaignId_Last(long campaignId,
		OrderByComparator<Tactic> orderByComparator) {
		return getPersistence()
				   .fetchByCampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the tactics before and after the current tactic in the ordered set where campaignId = &#63;.
	*
	* @param tacticId the primary key of the current tactic
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public static Tactic[] findByCampaignId_PrevAndNext(long tacticId,
		long campaignId, OrderByComparator<Tactic> orderByComparator)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(tacticId, campaignId,
			orderByComparator);
	}

	/**
	* Removes all the tactics where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	*/
	public static void removeByCampaignId(long campaignId) {
		getPersistence().removeByCampaignId(campaignId);
	}

	/**
	* Returns the number of tactics where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching tactics
	*/
	public static int countByCampaignId(long campaignId) {
		return getPersistence().countByCampaignId(campaignId);
	}

	/**
	* Caches the tactic in the entity cache if it is enabled.
	*
	* @param tactic the tactic
	*/
	public static void cacheResult(Tactic tactic) {
		getPersistence().cacheResult(tactic);
	}

	/**
	* Caches the tactics in the entity cache if it is enabled.
	*
	* @param tactics the tactics
	*/
	public static void cacheResult(List<Tactic> tactics) {
		getPersistence().cacheResult(tactics);
	}

	/**
	* Creates a new tactic with the primary key. Does not add the tactic to the database.
	*
	* @param tacticId the primary key for the new tactic
	* @return the new tactic
	*/
	public static Tactic create(long tacticId) {
		return getPersistence().create(tacticId);
	}

	/**
	* Removes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic that was removed
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public static Tactic remove(long tacticId)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence().remove(tacticId);
	}

	public static Tactic updateImpl(Tactic tactic) {
		return getPersistence().updateImpl(tactic);
	}

	/**
	* Returns the tactic with the primary key or throws a {@link NoSuchTacticException} if it could not be found.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public static Tactic findByPrimaryKey(long tacticId)
		throws com.liferay.content.targeting.exception.NoSuchTacticException {
		return getPersistence().findByPrimaryKey(tacticId);
	}

	/**
	* Returns the tactic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic, or <code>null</code> if a tactic with the primary key could not be found
	*/
	public static Tactic fetchByPrimaryKey(long tacticId) {
		return getPersistence().fetchByPrimaryKey(tacticId);
	}

	public static java.util.Map<java.io.Serializable, Tactic> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the tactics.
	*
	* @return the tactics
	*/
	public static List<Tactic> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tactics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @return the range of tactics
	*/
	public static List<Tactic> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tactics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tactics
	*/
	public static List<Tactic> findAll(int start, int end,
		OrderByComparator<Tactic> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the tactics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of tactics
	*/
	public static List<Tactic> findAll(int start, int end,
		OrderByComparator<Tactic> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the tactics from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tactics.
	*
	* @return the number of tactics
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of user segments associated with the tactic.
	*
	* @param pk the primary key of the tactic
	* @return long[] of the primaryKeys of user segments associated with the tactic
	*/
	public static long[] getUserSegmentPrimaryKeys(long pk) {
		return getPersistence().getUserSegmentPrimaryKeys(pk);
	}

	/**
	* Returns all the user segments associated with the tactic.
	*
	* @param pk the primary key of the tactic
	* @return the user segments associated with the tactic
	*/
	public static List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk) {
		return getPersistence().getUserSegments(pk);
	}

	/**
	* Returns a range of all the user segments associated with the tactic.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the tactic
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @return the range of user segments associated with the tactic
	*/
	public static List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end) {
		return getPersistence().getUserSegments(pk, start, end);
	}

	/**
	* Returns an ordered range of all the user segments associated with the tactic.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the tactic
	* @param start the lower bound of the range of tactics
	* @param end the upper bound of the range of tactics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user segments associated with the tactic
	*/
	public static List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end,
		OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator) {
		return getPersistence()
				   .getUserSegments(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of user segments associated with the tactic.
	*
	* @param pk the primary key of the tactic
	* @return the number of user segments associated with the tactic
	*/
	public static int getUserSegmentsSize(long pk) {
		return getPersistence().getUserSegmentsSize(pk);
	}

	/**
	* Returns <code>true</code> if the user segment is associated with the tactic.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPK the primary key of the user segment
	* @return <code>true</code> if the user segment is associated with the tactic; <code>false</code> otherwise
	*/
	public static boolean containsUserSegment(long pk, long userSegmentPK) {
		return getPersistence().containsUserSegment(pk, userSegmentPK);
	}

	/**
	* Returns <code>true</code> if the tactic has any user segments associated with it.
	*
	* @param pk the primary key of the tactic to check for associations with user segments
	* @return <code>true</code> if the tactic has any user segments associated with it; <code>false</code> otherwise
	*/
	public static boolean containsUserSegments(long pk) {
		return getPersistence().containsUserSegments(pk);
	}

	/**
	* Adds an association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPK the primary key of the user segment
	*/
	public static void addUserSegment(long pk, long userSegmentPK) {
		getPersistence().addUserSegment(pk, userSegmentPK);
	}

	/**
	* Adds an association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegment the user segment
	*/
	public static void addUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		getPersistence().addUserSegment(pk, userSegment);
	}

	/**
	* Adds an association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPKs the primary keys of the user segments
	*/
	public static void addUserSegments(long pk, long[] userSegmentPKs) {
		getPersistence().addUserSegments(pk, userSegmentPKs);
	}

	/**
	* Adds an association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegments the user segments
	*/
	public static void addUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments) {
		getPersistence().addUserSegments(pk, userSegments);
	}

	/**
	* Clears all associations between the tactic and its user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic to clear the associated user segments from
	*/
	public static void clearUserSegments(long pk) {
		getPersistence().clearUserSegments(pk);
	}

	/**
	* Removes the association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPK the primary key of the user segment
	*/
	public static void removeUserSegment(long pk, long userSegmentPK) {
		getPersistence().removeUserSegment(pk, userSegmentPK);
	}

	/**
	* Removes the association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegment the user segment
	*/
	public static void removeUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		getPersistence().removeUserSegment(pk, userSegment);
	}

	/**
	* Removes the association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPKs the primary keys of the user segments
	*/
	public static void removeUserSegments(long pk, long[] userSegmentPKs) {
		getPersistence().removeUserSegments(pk, userSegmentPKs);
	}

	/**
	* Removes the association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegments the user segments
	*/
	public static void removeUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments) {
		getPersistence().removeUserSegments(pk, userSegments);
	}

	/**
	* Sets the user segments associated with the tactic, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPKs the primary keys of the user segments to be associated with the tactic
	*/
	public static void setUserSegments(long pk, long[] userSegmentPKs) {
		getPersistence().setUserSegments(pk, userSegmentPKs);
	}

	/**
	* Sets the user segments associated with the tactic, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegments the user segments to be associated with the tactic
	*/
	public static void setUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments) {
		getPersistence().setUserSegments(pk, userSegments);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TacticPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TacticPersistence, TacticPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TacticPersistence.class);
}