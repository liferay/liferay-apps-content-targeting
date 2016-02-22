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

import com.liferay.content.targeting.exception.NoSuchTacticException;
import com.liferay.content.targeting.model.Tactic;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the tactic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.persistence.impl.TacticPersistenceImpl
 * @see TacticUtil
 * @generated
 */
@ProviderType
public interface TacticPersistence extends BasePersistence<Tactic> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TacticUtil} to access the tactic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tactics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching tactics
	*/
	public java.util.List<Tactic> findByUuid(java.lang.String uuid);

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
	public java.util.List<Tactic> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Tactic> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

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
	public java.util.List<Tactic> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tactic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public Tactic findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Returns the first tactic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public Tactic fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

	/**
	* Returns the last tactic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public Tactic findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Returns the last tactic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public Tactic fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

	/**
	* Returns the tactics before and after the current tactic in the ordered set where uuid = &#63;.
	*
	* @param tacticId the primary key of the current tactic
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public Tactic[] findByUuid_PrevAndNext(long tacticId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Removes all the tactics where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of tactics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching tactics
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the tactic where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTacticException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public Tactic findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchTacticException;

	/**
	* Returns the tactic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public Tactic fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the tactic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public Tactic fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the tactic where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the tactic that was removed
	*/
	public Tactic removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchTacticException;

	/**
	* Returns the number of tactics where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching tactics
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the tactics where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching tactics
	*/
	public java.util.List<Tactic> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Tactic> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Tactic> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

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
	public java.util.List<Tactic> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public Tactic findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Returns the first tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public Tactic fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

	/**
	* Returns the last tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public Tactic findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Returns the last tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public Tactic fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

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
	public Tactic[] findByUuid_C_PrevAndNext(long tacticId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Removes all the tactics where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of tactics where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching tactics
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the tactics where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tactics
	*/
	public java.util.List<Tactic> findByGroupId(long groupId);

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
	public java.util.List<Tactic> findByGroupId(long groupId, int start, int end);

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
	public java.util.List<Tactic> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

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
	public java.util.List<Tactic> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tactic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public Tactic findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Returns the first tactic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public Tactic fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

	/**
	* Returns the last tactic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public Tactic findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Returns the last tactic in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public Tactic fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

	/**
	* Returns the tactics before and after the current tactic in the ordered set where groupId = &#63;.
	*
	* @param tacticId the primary key of the current tactic
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public Tactic[] findByGroupId_PrevAndNext(long tacticId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Returns all the tactics that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tactics that the user has permission to view
	*/
	public java.util.List<Tactic> filterFindByGroupId(long groupId);

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
	public java.util.List<Tactic> filterFindByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<Tactic> filterFindByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

	/**
	* Returns the tactics before and after the current tactic in the ordered set of tactics that the user has permission to view where groupId = &#63;.
	*
	* @param tacticId the primary key of the current tactic
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public Tactic[] filterFindByGroupId_PrevAndNext(long tacticId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Removes all the tactics where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of tactics where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tactics
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the number of tactics that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tactics that the user has permission to view
	*/
	public int filterCountByGroupId(long groupId);

	/**
	* Returns all the tactics where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching tactics
	*/
	public java.util.List<Tactic> findByCampaignId(long campaignId);

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
	public java.util.List<Tactic> findByCampaignId(long campaignId, int start,
		int end);

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
	public java.util.List<Tactic> findByCampaignId(long campaignId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

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
	public java.util.List<Tactic> findByCampaignId(long campaignId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first tactic in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public Tactic findByCampaignId_First(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Returns the first tactic in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public Tactic fetchByCampaignId_First(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

	/**
	* Returns the last tactic in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic
	* @throws NoSuchTacticException if a matching tactic could not be found
	*/
	public Tactic findByCampaignId_Last(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Returns the last tactic in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	*/
	public Tactic fetchByCampaignId_Last(long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

	/**
	* Returns the tactics before and after the current tactic in the ordered set where campaignId = &#63;.
	*
	* @param tacticId the primary key of the current tactic
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public Tactic[] findByCampaignId_PrevAndNext(long tacticId,
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException;

	/**
	* Removes all the tactics where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	*/
	public void removeByCampaignId(long campaignId);

	/**
	* Returns the number of tactics where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching tactics
	*/
	public int countByCampaignId(long campaignId);

	/**
	* Caches the tactic in the entity cache if it is enabled.
	*
	* @param tactic the tactic
	*/
	public void cacheResult(Tactic tactic);

	/**
	* Caches the tactics in the entity cache if it is enabled.
	*
	* @param tactics the tactics
	*/
	public void cacheResult(java.util.List<Tactic> tactics);

	/**
	* Creates a new tactic with the primary key. Does not add the tactic to the database.
	*
	* @param tacticId the primary key for the new tactic
	* @return the new tactic
	*/
	public Tactic create(long tacticId);

	/**
	* Removes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic that was removed
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public Tactic remove(long tacticId) throws NoSuchTacticException;

	public Tactic updateImpl(Tactic tactic);

	/**
	* Returns the tactic with the primary key or throws a {@link NoSuchTacticException} if it could not be found.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic
	* @throws NoSuchTacticException if a tactic with the primary key could not be found
	*/
	public Tactic findByPrimaryKey(long tacticId) throws NoSuchTacticException;

	/**
	* Returns the tactic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tacticId the primary key of the tactic
	* @return the tactic, or <code>null</code> if a tactic with the primary key could not be found
	*/
	public Tactic fetchByPrimaryKey(long tacticId);

	@Override
	public java.util.Map<java.io.Serializable, Tactic> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the tactics.
	*
	* @return the tactics
	*/
	public java.util.List<Tactic> findAll();

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
	public java.util.List<Tactic> findAll(int start, int end);

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
	public java.util.List<Tactic> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator);

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
	public java.util.List<Tactic> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tactic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the tactics from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of tactics.
	*
	* @return the number of tactics
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of user segments associated with the tactic.
	*
	* @param pk the primary key of the tactic
	* @return long[] of the primaryKeys of user segments associated with the tactic
	*/
	public long[] getUserSegmentPrimaryKeys(long pk);

	/**
	* Returns all the user segments associated with the tactic.
	*
	* @param pk the primary key of the tactic
	* @return the user segments associated with the tactic
	*/
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk);

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
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end);

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
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator);

	/**
	* Returns the number of user segments associated with the tactic.
	*
	* @param pk the primary key of the tactic
	* @return the number of user segments associated with the tactic
	*/
	public int getUserSegmentsSize(long pk);

	/**
	* Returns <code>true</code> if the user segment is associated with the tactic.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPK the primary key of the user segment
	* @return <code>true</code> if the user segment is associated with the tactic; <code>false</code> otherwise
	*/
	public boolean containsUserSegment(long pk, long userSegmentPK);

	/**
	* Returns <code>true</code> if the tactic has any user segments associated with it.
	*
	* @param pk the primary key of the tactic to check for associations with user segments
	* @return <code>true</code> if the tactic has any user segments associated with it; <code>false</code> otherwise
	*/
	public boolean containsUserSegments(long pk);

	/**
	* Adds an association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPK the primary key of the user segment
	*/
	public void addUserSegment(long pk, long userSegmentPK);

	/**
	* Adds an association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegment the user segment
	*/
	public void addUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment);

	/**
	* Adds an association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPKs the primary keys of the user segments
	*/
	public void addUserSegments(long pk, long[] userSegmentPKs);

	/**
	* Adds an association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegments the user segments
	*/
	public void addUserSegments(long pk,
		java.util.List<com.liferay.content.targeting.model.UserSegment> userSegments);

	/**
	* Clears all associations between the tactic and its user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic to clear the associated user segments from
	*/
	public void clearUserSegments(long pk);

	/**
	* Removes the association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPK the primary key of the user segment
	*/
	public void removeUserSegment(long pk, long userSegmentPK);

	/**
	* Removes the association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegment the user segment
	*/
	public void removeUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment);

	/**
	* Removes the association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPKs the primary keys of the user segments
	*/
	public void removeUserSegments(long pk, long[] userSegmentPKs);

	/**
	* Removes the association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegments the user segments
	*/
	public void removeUserSegments(long pk,
		java.util.List<com.liferay.content.targeting.model.UserSegment> userSegments);

	/**
	* Sets the user segments associated with the tactic, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegmentPKs the primary keys of the user segments to be associated with the tactic
	*/
	public void setUserSegments(long pk, long[] userSegmentPKs);

	/**
	* Sets the user segments associated with the tactic, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the tactic
	* @param userSegments the user segments to be associated with the tactic
	*/
	public void setUserSegments(long pk,
		java.util.List<com.liferay.content.targeting.model.UserSegment> userSegments);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}