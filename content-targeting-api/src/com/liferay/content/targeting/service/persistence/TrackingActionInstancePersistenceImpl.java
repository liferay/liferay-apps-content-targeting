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

import com.liferay.content.targeting.NoSuchTrackingActionInstanceException;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.model.impl.TrackingActionInstanceImpl;
import com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the tracking action instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstancePersistence
 * @see TrackingActionInstanceUtil
 * @generated
 */
public class TrackingActionInstancePersistenceImpl extends BasePersistenceImpl<TrackingActionInstance>
	implements TrackingActionInstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TrackingActionInstanceUtil} to access the tracking action instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TrackingActionInstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TrackingActionInstanceModelImpl.UUID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.TRACKINGACTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the tracking action instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<TrackingActionInstance> list = (List<TrackingActionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrackingActionInstance trackingActionInstance : list) {
				if (!Validator.equals(uuid, trackingActionInstance.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrackingActionInstance>(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tracking action instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByUuid_First(uuid,
				orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the first tracking action instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<TrackingActionInstance> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracking action instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByUuid_Last(uuid,
				orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the last tracking action instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TrackingActionInstance> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracking action instances before and after the current tracking action instance in the ordered set where uuid = &#63;.
	 *
	 * @param trackingActionInstanceId the primary key of the current tracking action instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance[] findByUuid_PrevAndNext(
		long trackingActionInstanceId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = findByPrimaryKey(trackingActionInstanceId);

		Session session = null;

		try {
			session = openSession();

			TrackingActionInstance[] array = new TrackingActionInstanceImpl[3];

			array[0] = getByUuid_PrevAndNext(session, trackingActionInstance,
					uuid, orderByComparator, true);

			array[1] = trackingActionInstance;

			array[2] = getByUuid_PrevAndNext(session, trackingActionInstance,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackingActionInstance getByUuid_PrevAndNext(Session session,
		TrackingActionInstance trackingActionInstance, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trackingActionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrackingActionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tracking action instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (TrackingActionInstance trackingActionInstance : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "trackingActionInstance.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "trackingActionInstance.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(trackingActionInstance.uuid IS NULL OR trackingActionInstance.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TrackingActionInstanceModelImpl.UUID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the tracking action instance where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.content.targeting.NoSuchTrackingActionInstanceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByUUID_G(uuid,
				groupId);

		if (trackingActionInstance == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTrackingActionInstanceException(msg.toString());
		}

		return trackingActionInstance;
	}

	/**
	 * Returns the tracking action instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the tracking action instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof TrackingActionInstance) {
			TrackingActionInstance trackingActionInstance = (TrackingActionInstance)result;

			if (!Validator.equals(uuid, trackingActionInstance.getUuid()) ||
					(groupId != trackingActionInstance.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<TrackingActionInstance> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					TrackingActionInstance trackingActionInstance = list.get(0);

					result = trackingActionInstance;

					cacheResult(trackingActionInstance);

					if ((trackingActionInstance.getUuid() == null) ||
							!trackingActionInstance.getUuid().equals(uuid) ||
							(trackingActionInstance.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, trackingActionInstance);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TrackingActionInstance)result;
		}
	}

	/**
	 * Removes the tracking action instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tracking action instance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = findByUUID_G(uuid,
				groupId);

		return remove(trackingActionInstance);
	}

	/**
	 * Returns the number of tracking action instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "trackingActionInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "trackingActionInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(trackingActionInstance.uuid IS NULL OR trackingActionInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "trackingActionInstance.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TrackingActionInstanceModelImpl.UUID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.COMPANYID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.TRACKINGACTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the tracking action instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByUuid_C(String uuid,
		long companyId, int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByUuid_C(String uuid,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<TrackingActionInstance> list = (List<TrackingActionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrackingActionInstance trackingActionInstance : list) {
				if (!Validator.equals(uuid, trackingActionInstance.getUuid()) ||
						(companyId != trackingActionInstance.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrackingActionInstance>(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tracking action instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the first tracking action instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TrackingActionInstance> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracking action instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the last tracking action instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TrackingActionInstance> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracking action instances before and after the current tracking action instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param trackingActionInstanceId the primary key of the current tracking action instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance[] findByUuid_C_PrevAndNext(
		long trackingActionInstanceId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = findByPrimaryKey(trackingActionInstanceId);

		Session session = null;

		try {
			session = openSession();

			TrackingActionInstance[] array = new TrackingActionInstanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, trackingActionInstance,
					uuid, companyId, orderByComparator, true);

			array[1] = trackingActionInstance;

			array[2] = getByUuid_C_PrevAndNext(session, trackingActionInstance,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackingActionInstance getByUuid_C_PrevAndNext(Session session,
		TrackingActionInstance trackingActionInstance, String uuid,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trackingActionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrackingActionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tracking action instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (TrackingActionInstance trackingActionInstance : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "trackingActionInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "trackingActionInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(trackingActionInstance.uuid IS NULL OR trackingActionInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "trackingActionInstance.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			TrackingActionInstanceModelImpl.GROUPID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.TRACKINGACTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tracking action instances where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<TrackingActionInstance> list = (List<TrackingActionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrackingActionInstance trackingActionInstance : list) {
				if ((groupId != trackingActionInstance.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrackingActionInstance>(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tracking action instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByGroupId_First(groupId,
				orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the first tracking action instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TrackingActionInstance> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracking action instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the last tracking action instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<TrackingActionInstance> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracking action instances before and after the current tracking action instance in the ordered set where groupId = &#63;.
	 *
	 * @param trackingActionInstanceId the primary key of the current tracking action instance
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance[] findByGroupId_PrevAndNext(
		long trackingActionInstanceId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = findByPrimaryKey(trackingActionInstanceId);

		Session session = null;

		try {
			session = openSession();

			TrackingActionInstance[] array = new TrackingActionInstanceImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					trackingActionInstance, groupId, orderByComparator, true);

			array[1] = trackingActionInstance;

			array[2] = getByGroupId_PrevAndNext(session,
					trackingActionInstance, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackingActionInstance getByGroupId_PrevAndNext(Session session,
		TrackingActionInstance trackingActionInstance, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trackingActionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrackingActionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tracking action instances where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (TrackingActionInstance trackingActionInstance : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "trackingActionInstance.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			TrackingActionInstanceModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.TRACKINGACTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tracking action instances where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByCampaignId(long campaignId)
		throws SystemException {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByCampaignId(long campaignId,
		int start, int end) throws SystemException {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByCampaignId(long campaignId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID;
			finderArgs = new Object[] { campaignId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID;
			finderArgs = new Object[] { campaignId, start, end, orderByComparator };
		}

		List<TrackingActionInstance> list = (List<TrackingActionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrackingActionInstance trackingActionInstance : list) {
				if ((campaignId != trackingActionInstance.getCampaignId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrackingActionInstance>(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tracking action instance in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByCampaignId_First(campaignId,
				orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the first tracking action instance in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TrackingActionInstance> list = findByCampaignId(campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracking action instance in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByCampaignId_Last(campaignId,
				orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the last tracking action instance in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<TrackingActionInstance> list = findByCampaignId(campaignId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracking action instances before and after the current tracking action instance in the ordered set where campaignId = &#63;.
	 *
	 * @param trackingActionInstanceId the primary key of the current tracking action instance
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance[] findByCampaignId_PrevAndNext(
		long trackingActionInstanceId, long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = findByPrimaryKey(trackingActionInstanceId);

		Session session = null;

		try {
			session = openSession();

			TrackingActionInstance[] array = new TrackingActionInstanceImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session,
					trackingActionInstance, campaignId, orderByComparator, true);

			array[1] = trackingActionInstance;

			array[2] = getByCampaignId_PrevAndNext(session,
					trackingActionInstance, campaignId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackingActionInstance getByCampaignId_PrevAndNext(
		Session session, TrackingActionInstance trackingActionInstance,
		long campaignId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trackingActionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrackingActionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tracking action instances where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long campaignId) throws SystemException {
		for (TrackingActionInstance trackingActionInstance : findByCampaignId(
				campaignId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignId(long campaignId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNID;

		Object[] finderArgs = new Object[] { campaignId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "trackingActionInstance.campaignId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_A = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_A",
			new String[] { Long.class.getName(), String.class.getName() },
			TrackingActionInstanceModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.ALIAS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_A = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_A",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the tracking action instance where campaignId = &#63; and alias = &#63; or throws a {@link com.liferay.content.targeting.NoSuchTrackingActionInstanceException} if it could not be found.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @return the matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByC_A(long campaignId, String alias)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByC_A(campaignId,
				alias);

		if (trackingActionInstance == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

			msg.append(", alias=");
			msg.append(alias);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTrackingActionInstanceException(msg.toString());
		}

		return trackingActionInstance;
	}

	/**
	 * Returns the tracking action instance where campaignId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByC_A(long campaignId, String alias)
		throws SystemException {
		return fetchByC_A(campaignId, alias, true);
	}

	/**
	 * Returns the tracking action instance where campaignId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByC_A(long campaignId, String alias,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { campaignId, alias };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_A,
					finderArgs, this);
		}

		if (result instanceof TrackingActionInstance) {
			TrackingActionInstance trackingActionInstance = (TrackingActionInstance)result;

			if ((campaignId != trackingActionInstance.getCampaignId()) ||
					!Validator.equals(alias, trackingActionInstance.getAlias())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_A_CAMPAIGNID_2);

			boolean bindAlias = false;

			if (alias == null) {
				query.append(_FINDER_COLUMN_C_A_ALIAS_1);
			}
			else if (alias.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_A_ALIAS_3);
			}
			else {
				bindAlias = true;

				query.append(_FINDER_COLUMN_C_A_ALIAS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindAlias) {
					qPos.add(alias);
				}

				List<TrackingActionInstance> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_A,
						finderArgs, list);
				}
				else {
					TrackingActionInstance trackingActionInstance = list.get(0);

					result = trackingActionInstance;

					cacheResult(trackingActionInstance);

					if ((trackingActionInstance.getCampaignId() != campaignId) ||
							(trackingActionInstance.getAlias() == null) ||
							!trackingActionInstance.getAlias().equals(alias)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_A,
							finderArgs, trackingActionInstance);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_A,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TrackingActionInstance)result;
		}
	}

	/**
	 * Removes the tracking action instance where campaignId = &#63; and alias = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @return the tracking action instance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance removeByC_A(long campaignId, String alias)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = findByC_A(campaignId,
				alias);

		return remove(trackingActionInstance);
	}

	/**
	 * Returns the number of tracking action instances where campaignId = &#63; and alias = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @return the number of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_A(long campaignId, String alias)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_A;

		Object[] finderArgs = new Object[] { campaignId, alias };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_A_CAMPAIGNID_2);

			boolean bindAlias = false;

			if (alias == null) {
				query.append(_FINDER_COLUMN_C_A_ALIAS_1);
			}
			else if (alias.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_A_ALIAS_3);
			}
			else {
				bindAlias = true;

				query.append(_FINDER_COLUMN_C_A_ALIAS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindAlias) {
					qPos.add(alias);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_A_CAMPAIGNID_2 = "trackingActionInstance.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_A_ALIAS_1 = "trackingActionInstance.alias IS NULL";
	private static final String _FINDER_COLUMN_C_A_ALIAS_2 = "trackingActionInstance.alias = ?";
	private static final String _FINDER_COLUMN_C_A_ALIAS_3 = "(trackingActionInstance.alias IS NULL OR trackingActionInstance.alias = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_E_E = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E_E = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			TrackingActionInstanceModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.ELEMENTID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.EVENTTYPE_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.TRACKINGACTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_E_E = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByC_E_E(long campaignId,
		String elementId, String eventType) throws SystemException {
		return findByC_E_E(campaignId, elementId, eventType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByC_E_E(long campaignId,
		String elementId, String eventType, int start, int end)
		throws SystemException {
		return findByC_E_E(campaignId, elementId, eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByC_E_E(long campaignId,
		String elementId, String eventType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E_E;
			finderArgs = new Object[] { campaignId, elementId, eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_E_E;
			finderArgs = new Object[] {
					campaignId, elementId, eventType,
					
					start, end, orderByComparator
				};
		}

		List<TrackingActionInstance> list = (List<TrackingActionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrackingActionInstance trackingActionInstance : list) {
				if ((campaignId != trackingActionInstance.getCampaignId()) ||
						!Validator.equals(elementId,
							trackingActionInstance.getElementId()) ||
						!Validator.equals(eventType,
							trackingActionInstance.getEventType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_E_E_CAMPAIGNID_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_C_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_C_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_E_E_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (!pagination) {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrackingActionInstance>(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tracking action instance in the ordered set where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByC_E_E_First(long campaignId,
		String elementId, String eventType, OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByC_E_E_First(campaignId,
				elementId, eventType, orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", elementId=");
		msg.append(elementId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the first tracking action instance in the ordered set where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByC_E_E_First(long campaignId,
		String elementId, String eventType, OrderByComparator orderByComparator)
		throws SystemException {
		List<TrackingActionInstance> list = findByC_E_E(campaignId, elementId,
				eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracking action instance in the ordered set where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByC_E_E_Last(long campaignId,
		String elementId, String eventType, OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByC_E_E_Last(campaignId,
				elementId, eventType, orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", elementId=");
		msg.append(elementId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the last tracking action instance in the ordered set where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByC_E_E_Last(long campaignId,
		String elementId, String eventType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_E_E(campaignId, elementId, eventType);

		if (count == 0) {
			return null;
		}

		List<TrackingActionInstance> list = findByC_E_E(campaignId, elementId,
				eventType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracking action instances before and after the current tracking action instance in the ordered set where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param trackingActionInstanceId the primary key of the current tracking action instance
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance[] findByC_E_E_PrevAndNext(
		long trackingActionInstanceId, long campaignId, String elementId,
		String eventType, OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = findByPrimaryKey(trackingActionInstanceId);

		Session session = null;

		try {
			session = openSession();

			TrackingActionInstance[] array = new TrackingActionInstanceImpl[3];

			array[0] = getByC_E_E_PrevAndNext(session, trackingActionInstance,
					campaignId, elementId, eventType, orderByComparator, true);

			array[1] = trackingActionInstance;

			array[2] = getByC_E_E_PrevAndNext(session, trackingActionInstance,
					campaignId, elementId, eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackingActionInstance getByC_E_E_PrevAndNext(Session session,
		TrackingActionInstance trackingActionInstance, long campaignId,
		String elementId, String eventType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_C_E_E_CAMPAIGNID_2);

		boolean bindElementId = false;

		if (elementId == null) {
			query.append(_FINDER_COLUMN_C_E_E_ELEMENTID_1);
		}
		else if (elementId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_E_E_ELEMENTID_3);
		}
		else {
			bindElementId = true;

			query.append(_FINDER_COLUMN_C_E_E_ELEMENTID_2);
		}

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_C_E_E_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_E_E_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_C_E_E_EVENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (bindElementId) {
			qPos.add(elementId);
		}

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trackingActionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrackingActionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_E_E(long campaignId, String elementId,
		String eventType) throws SystemException {
		for (TrackingActionInstance trackingActionInstance : findByC_E_E(
				campaignId, elementId, eventType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the number of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_E_E(long campaignId, String elementId, String eventType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_E_E;

		Object[] finderArgs = new Object[] { campaignId, elementId, eventType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_E_E_CAMPAIGNID_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_C_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_C_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (bindEventType) {
					qPos.add(eventType);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_E_E_CAMPAIGNID_2 = "trackingActionInstance.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_E_E_ELEMENTID_1 = "trackingActionInstance.elementId IS NULL AND ";
	private static final String _FINDER_COLUMN_C_E_E_ELEMENTID_2 = "trackingActionInstance.elementId = ? AND ";
	private static final String _FINDER_COLUMN_C_E_E_ELEMENTID_3 = "(trackingActionInstance.elementId IS NULL OR trackingActionInstance.elementId = '') AND ";
	private static final String _FINDER_COLUMN_C_E_E_EVENTTYPE_1 = "trackingActionInstance.eventType IS NULL";
	private static final String _FINDER_COLUMN_C_E_E_EVENTTYPE_2 = "trackingActionInstance.eventType = ?";
	private static final String _FINDER_COLUMN_C_E_E_EVENTTYPE_3 = "(trackingActionInstance.eventType IS NULL OR trackingActionInstance.eventType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_R_E = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R_R_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R_E =
		new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R_R_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			TrackingActionInstanceModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.REFERRERCLASSNAME_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.REFERRERCLASSPK_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.EVENTTYPE_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.TRACKINGACTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R_R_E = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R_R_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @return the matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType)
		throws SystemException {
		return findByC_R_R_E(campaignId, referrerClassName, referrerClassPK,
			eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		int start, int end) throws SystemException {
		return findByC_R_R_E(campaignId, referrerClassName, referrerClassPK,
			eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R_E;
			finderArgs = new Object[] {
					campaignId, referrerClassName, referrerClassPK, eventType
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_R_E;
			finderArgs = new Object[] {
					campaignId, referrerClassName, referrerClassPK, eventType,
					
					start, end, orderByComparator
				};
		}

		List<TrackingActionInstance> list = (List<TrackingActionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrackingActionInstance trackingActionInstance : list) {
				if ((campaignId != trackingActionInstance.getCampaignId()) ||
						!Validator.equals(referrerClassName,
							trackingActionInstance.getReferrerClassName()) ||
						(referrerClassPK != trackingActionInstance.getReferrerClassPK()) ||
						!Validator.equals(eventType,
							trackingActionInstance.getEventType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_R_R_E_CAMPAIGNID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_R_R_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_R_R_E_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (!pagination) {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrackingActionInstance>(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tracking action instance in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByC_R_R_E_First(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByC_R_R_E_First(campaignId,
				referrerClassName, referrerClassPK, eventType, orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the first tracking action instance in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByC_R_R_E_First(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		List<TrackingActionInstance> list = findByC_R_R_E(campaignId,
				referrerClassName, referrerClassPK, eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracking action instance in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByC_R_R_E_Last(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByC_R_R_E_Last(campaignId,
				referrerClassName, referrerClassPK, eventType, orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the last tracking action instance in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByC_R_R_E_Last(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_R_R_E(campaignId, referrerClassName,
				referrerClassPK, eventType);

		if (count == 0) {
			return null;
		}

		List<TrackingActionInstance> list = findByC_R_R_E(campaignId,
				referrerClassName, referrerClassPK, eventType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracking action instances before and after the current tracking action instance in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param trackingActionInstanceId the primary key of the current tracking action instance
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance[] findByC_R_R_E_PrevAndNext(
		long trackingActionInstanceId, long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = findByPrimaryKey(trackingActionInstanceId);

		Session session = null;

		try {
			session = openSession();

			TrackingActionInstance[] array = new TrackingActionInstanceImpl[3];

			array[0] = getByC_R_R_E_PrevAndNext(session,
					trackingActionInstance, campaignId, referrerClassName,
					referrerClassPK, eventType, orderByComparator, true);

			array[1] = trackingActionInstance;

			array[2] = getByC_R_R_E_PrevAndNext(session,
					trackingActionInstance, campaignId, referrerClassName,
					referrerClassPK, eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackingActionInstance getByC_R_R_E_PrevAndNext(Session session,
		TrackingActionInstance trackingActionInstance, long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_C_R_R_E_CAMPAIGNID_2);

		boolean bindReferrerClassName = false;

		if (referrerClassName == null) {
			query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_1);
		}
		else if (referrerClassName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_3);
		}
		else {
			bindReferrerClassName = true;

			query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSPK_2);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_C_R_R_E_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_R_E_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_C_R_R_E_EVENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (bindReferrerClassName) {
			qPos.add(referrerClassName);
		}

		qPos.add(referrerClassPK);

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trackingActionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrackingActionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_R_R_E(long campaignId, String referrerClassName,
		long referrerClassPK, String eventType) throws SystemException {
		for (TrackingActionInstance trackingActionInstance : findByC_R_R_E(
				campaignId, referrerClassName, referrerClassPK, eventType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @return the number of matching tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_R_R_E(long campaignId, String referrerClassName,
		long referrerClassPK, String eventType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_R_R_E;

		Object[] finderArgs = new Object[] {
				campaignId, referrerClassName, referrerClassPK, eventType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_R_R_E_CAMPAIGNID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_R_R_E_REFERRERCLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_R_R_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_R_R_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_R_R_E_CAMPAIGNID_2 = "trackingActionInstance.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_1 = "trackingActionInstance.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_2 = "trackingActionInstance.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_REFERRERCLASSNAME_3 = "(trackingActionInstance.referrerClassName IS NULL OR trackingActionInstance.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_REFERRERCLASSPK_2 = "trackingActionInstance.referrerClassPK = ? AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_EVENTTYPE_1 = "trackingActionInstance.eventType IS NULL";
	private static final String _FINDER_COLUMN_C_R_R_E_EVENTTYPE_2 = "trackingActionInstance.eventType = ?";
	private static final String _FINDER_COLUMN_C_R_R_E_EVENTTYPE_3 = "(trackingActionInstance.eventType IS NULL OR trackingActionInstance.eventType = '')";

	public TrackingActionInstancePersistenceImpl() {
		setModelClass(TrackingActionInstance.class);
	}

	/**
	 * Caches the tracking action instance in the entity cache if it is enabled.
	 *
	 * @param trackingActionInstance the tracking action instance
	 */
	@Override
	public void cacheResult(TrackingActionInstance trackingActionInstance) {
		EntityCacheUtil.putResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			trackingActionInstance.getPrimaryKey(), trackingActionInstance);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				trackingActionInstance.getUuid(),
				trackingActionInstance.getGroupId()
			}, trackingActionInstance);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_A,
			new Object[] {
				trackingActionInstance.getCampaignId(),
				trackingActionInstance.getAlias()
			}, trackingActionInstance);

		trackingActionInstance.resetOriginalValues();
	}

	/**
	 * Caches the tracking action instances in the entity cache if it is enabled.
	 *
	 * @param trackingActionInstances the tracking action instances
	 */
	@Override
	public void cacheResult(
		List<TrackingActionInstance> trackingActionInstances) {
		for (TrackingActionInstance trackingActionInstance : trackingActionInstances) {
			if (EntityCacheUtil.getResult(
						TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
						TrackingActionInstanceImpl.class,
						trackingActionInstance.getPrimaryKey()) == null) {
				cacheResult(trackingActionInstance);
			}
			else {
				trackingActionInstance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tracking action instances.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TrackingActionInstanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TrackingActionInstanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tracking action instance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrackingActionInstance trackingActionInstance) {
		EntityCacheUtil.removeResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			trackingActionInstance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(trackingActionInstance);
	}

	@Override
	public void clearCache(List<TrackingActionInstance> trackingActionInstances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrackingActionInstance trackingActionInstance : trackingActionInstances) {
			EntityCacheUtil.removeResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
				TrackingActionInstanceImpl.class,
				trackingActionInstance.getPrimaryKey());

			clearUniqueFindersCache(trackingActionInstance);
		}
	}

	protected void cacheUniqueFindersCache(
		TrackingActionInstance trackingActionInstance) {
		if (trackingActionInstance.isNew()) {
			Object[] args = new Object[] {
					trackingActionInstance.getUuid(),
					trackingActionInstance.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				trackingActionInstance);

			args = new Object[] {
					trackingActionInstance.getCampaignId(),
					trackingActionInstance.getAlias()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_A, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_A, args,
				trackingActionInstance);
		}
		else {
			TrackingActionInstanceModelImpl trackingActionInstanceModelImpl = (TrackingActionInstanceModelImpl)trackingActionInstance;

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstance.getUuid(),
						trackingActionInstance.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					trackingActionInstance);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstance.getCampaignId(),
						trackingActionInstance.getAlias()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_A, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_A, args,
					trackingActionInstance);
			}
		}
	}

	protected void clearUniqueFindersCache(
		TrackingActionInstance trackingActionInstance) {
		TrackingActionInstanceModelImpl trackingActionInstanceModelImpl = (TrackingActionInstanceModelImpl)trackingActionInstance;

		Object[] args = new Object[] {
				trackingActionInstance.getUuid(),
				trackingActionInstance.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((trackingActionInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					trackingActionInstanceModelImpl.getOriginalUuid(),
					trackingActionInstanceModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				trackingActionInstance.getCampaignId(),
				trackingActionInstance.getAlias()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_A, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_A, args);

		if ((trackingActionInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_A.getColumnBitmask()) != 0) {
			args = new Object[] {
					trackingActionInstanceModelImpl.getOriginalCampaignId(),
					trackingActionInstanceModelImpl.getOriginalAlias()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_A, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_A, args);
		}
	}

	/**
	 * Creates a new tracking action instance with the primary key. Does not add the tracking action instance to the database.
	 *
	 * @param trackingActionInstanceId the primary key for the new tracking action instance
	 * @return the new tracking action instance
	 */
	@Override
	public TrackingActionInstance create(long trackingActionInstanceId) {
		TrackingActionInstance trackingActionInstance = new TrackingActionInstanceImpl();

		trackingActionInstance.setNew(true);
		trackingActionInstance.setPrimaryKey(trackingActionInstanceId);

		String uuid = PortalUUIDUtil.generate();

		trackingActionInstance.setUuid(uuid);

		return trackingActionInstance;
	}

	/**
	 * Removes the tracking action instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trackingActionInstanceId the primary key of the tracking action instance
	 * @return the tracking action instance that was removed
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance remove(long trackingActionInstanceId)
		throws NoSuchTrackingActionInstanceException, SystemException {
		return remove((Serializable)trackingActionInstanceId);
	}

	/**
	 * Removes the tracking action instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tracking action instance
	 * @return the tracking action instance that was removed
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance remove(Serializable primaryKey)
		throws NoSuchTrackingActionInstanceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TrackingActionInstance trackingActionInstance = (TrackingActionInstance)session.get(TrackingActionInstanceImpl.class,
					primaryKey);

			if (trackingActionInstance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrackingActionInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trackingActionInstance);
		}
		catch (NoSuchTrackingActionInstanceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TrackingActionInstance removeImpl(
		TrackingActionInstance trackingActionInstance)
		throws SystemException {
		trackingActionInstance = toUnwrappedModel(trackingActionInstance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(trackingActionInstance)) {
				trackingActionInstance = (TrackingActionInstance)session.get(TrackingActionInstanceImpl.class,
						trackingActionInstance.getPrimaryKeyObj());
			}

			if (trackingActionInstance != null) {
				session.delete(trackingActionInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (trackingActionInstance != null) {
			clearCache(trackingActionInstance);
		}

		return trackingActionInstance;
	}

	@Override
	public TrackingActionInstance updateImpl(
		com.liferay.content.targeting.model.TrackingActionInstance trackingActionInstance)
		throws SystemException {
		trackingActionInstance = toUnwrappedModel(trackingActionInstance);

		boolean isNew = trackingActionInstance.isNew();

		TrackingActionInstanceModelImpl trackingActionInstanceModelImpl = (TrackingActionInstanceModelImpl)trackingActionInstance;

		if (Validator.isNull(trackingActionInstance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			trackingActionInstance.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (trackingActionInstance.isNew()) {
				session.save(trackingActionInstance);

				trackingActionInstance.setNew(false);
			}
			else {
				session.merge(trackingActionInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrackingActionInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { trackingActionInstanceModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalUuid(),
						trackingActionInstanceModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getUuid(),
						trackingActionInstanceModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { trackingActionInstanceModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalCampaignId(),
						trackingActionInstanceModelImpl.getOriginalElementId(),
						trackingActionInstanceModelImpl.getOriginalEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_E_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E_E,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getCampaignId(),
						trackingActionInstanceModelImpl.getElementId(),
						trackingActionInstanceModelImpl.getEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_E_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E_E,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalCampaignId(),
						trackingActionInstanceModelImpl.getOriginalReferrerClassName(),
						trackingActionInstanceModelImpl.getOriginalReferrerClassPK(),
						trackingActionInstanceModelImpl.getOriginalEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R_R_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R_E,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getCampaignId(),
						trackingActionInstanceModelImpl.getReferrerClassName(),
						trackingActionInstanceModelImpl.getReferrerClassPK(),
						trackingActionInstanceModelImpl.getEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R_R_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R_E,
					args);
			}
		}

		EntityCacheUtil.putResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			trackingActionInstance.getPrimaryKey(), trackingActionInstance);

		clearUniqueFindersCache(trackingActionInstance);
		cacheUniqueFindersCache(trackingActionInstance);

		return trackingActionInstance;
	}

	protected TrackingActionInstance toUnwrappedModel(
		TrackingActionInstance trackingActionInstance) {
		if (trackingActionInstance instanceof TrackingActionInstanceImpl) {
			return trackingActionInstance;
		}

		TrackingActionInstanceImpl trackingActionInstanceImpl = new TrackingActionInstanceImpl();

		trackingActionInstanceImpl.setNew(trackingActionInstance.isNew());
		trackingActionInstanceImpl.setPrimaryKey(trackingActionInstance.getPrimaryKey());

		trackingActionInstanceImpl.setUuid(trackingActionInstance.getUuid());
		trackingActionInstanceImpl.setTrackingActionInstanceId(trackingActionInstance.getTrackingActionInstanceId());
		trackingActionInstanceImpl.setGroupId(trackingActionInstance.getGroupId());
		trackingActionInstanceImpl.setCompanyId(trackingActionInstance.getCompanyId());
		trackingActionInstanceImpl.setUserId(trackingActionInstance.getUserId());
		trackingActionInstanceImpl.setUserName(trackingActionInstance.getUserName());
		trackingActionInstanceImpl.setCreateDate(trackingActionInstance.getCreateDate());
		trackingActionInstanceImpl.setModifiedDate(trackingActionInstance.getModifiedDate());
		trackingActionInstanceImpl.setTrackingActionKey(trackingActionInstance.getTrackingActionKey());
		trackingActionInstanceImpl.setCampaignId(trackingActionInstance.getCampaignId());
		trackingActionInstanceImpl.setAlias(trackingActionInstance.getAlias());
		trackingActionInstanceImpl.setReferrerClassName(trackingActionInstance.getReferrerClassName());
		trackingActionInstanceImpl.setReferrerClassPK(trackingActionInstance.getReferrerClassPK());
		trackingActionInstanceImpl.setElementId(trackingActionInstance.getElementId());
		trackingActionInstanceImpl.setEventType(trackingActionInstance.getEventType());
		trackingActionInstanceImpl.setTypeSettings(trackingActionInstance.getTypeSettings());

		return trackingActionInstanceImpl;
	}

	/**
	 * Returns the tracking action instance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tracking action instance
	 * @return the tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTrackingActionInstanceException, SystemException {
		TrackingActionInstance trackingActionInstance = fetchByPrimaryKey(primaryKey);

		if (trackingActionInstance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTrackingActionInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return trackingActionInstance;
	}

	/**
	 * Returns the tracking action instance with the primary key or throws a {@link com.liferay.content.targeting.NoSuchTrackingActionInstanceException} if it could not be found.
	 *
	 * @param trackingActionInstanceId the primary key of the tracking action instance
	 * @return the tracking action instance
	 * @throws com.liferay.content.targeting.NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance findByPrimaryKey(
		long trackingActionInstanceId)
		throws NoSuchTrackingActionInstanceException, SystemException {
		return findByPrimaryKey((Serializable)trackingActionInstanceId);
	}

	/**
	 * Returns the tracking action instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tracking action instance
	 * @return the tracking action instance, or <code>null</code> if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TrackingActionInstance trackingActionInstance = (TrackingActionInstance)EntityCacheUtil.getResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
				TrackingActionInstanceImpl.class, primaryKey);

		if (trackingActionInstance == _nullTrackingActionInstance) {
			return null;
		}

		if (trackingActionInstance == null) {
			Session session = null;

			try {
				session = openSession();

				trackingActionInstance = (TrackingActionInstance)session.get(TrackingActionInstanceImpl.class,
						primaryKey);

				if (trackingActionInstance != null) {
					cacheResult(trackingActionInstance);
				}
				else {
					EntityCacheUtil.putResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
						TrackingActionInstanceImpl.class, primaryKey,
						_nullTrackingActionInstance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
					TrackingActionInstanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return trackingActionInstance;
	}

	/**
	 * Returns the tracking action instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trackingActionInstanceId the primary key of the tracking action instance
	 * @return the tracking action instance, or <code>null</code> if a tracking action instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrackingActionInstance fetchByPrimaryKey(
		long trackingActionInstanceId) throws SystemException {
		return fetchByPrimaryKey((Serializable)trackingActionInstanceId);
	}

	/**
	 * Returns all the tracking action instances.
	 *
	 * @return the tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrackingActionInstance> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TrackingActionInstance> list = (List<TrackingActionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRACKINGACTIONINSTANCE;

				if (pagination) {
					sql = sql.concat(TrackingActionInstanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrackingActionInstance>(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tracking action instances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TrackingActionInstance trackingActionInstance : findAll()) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances.
	 *
	 * @return the number of tracking action instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRACKINGACTIONINSTANCE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the tracking action instance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.model.TrackingActionInstance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TrackingActionInstance>> listenersList = new ArrayList<ModelListener<TrackingActionInstance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TrackingActionInstance>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TrackingActionInstanceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TRACKINGACTIONINSTANCE = "SELECT trackingActionInstance FROM TrackingActionInstance trackingActionInstance";
	private static final String _SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE = "SELECT trackingActionInstance FROM TrackingActionInstance trackingActionInstance WHERE ";
	private static final String _SQL_COUNT_TRACKINGACTIONINSTANCE = "SELECT COUNT(trackingActionInstance) FROM TrackingActionInstance trackingActionInstance";
	private static final String _SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE = "SELECT COUNT(trackingActionInstance) FROM TrackingActionInstance trackingActionInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trackingActionInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrackingActionInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrackingActionInstance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TrackingActionInstancePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "alias"
			});
	private static TrackingActionInstance _nullTrackingActionInstance = new TrackingActionInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TrackingActionInstance> toCacheModel() {
				return _nullTrackingActionInstanceCacheModel;
			}
		};

	private static CacheModel<TrackingActionInstance> _nullTrackingActionInstanceCacheModel =
		new CacheModel<TrackingActionInstance>() {
			@Override
			public TrackingActionInstance toEntityModel() {
				return _nullTrackingActionInstance;
			}
		};
}