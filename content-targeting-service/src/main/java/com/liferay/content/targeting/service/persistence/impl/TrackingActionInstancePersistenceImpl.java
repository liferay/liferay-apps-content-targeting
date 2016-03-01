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

package com.liferay.content.targeting.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.model.impl.TrackingActionInstanceImpl;
import com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl;
import com.liferay.content.targeting.service.persistence.TrackingActionInstancePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
 * @see com.liferay.content.targeting.service.persistence.TrackingActionInstanceUtil
 * @generated
 */
@ProviderType
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
	 */
	@Override
	public List<TrackingActionInstance> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByUuid(String uuid, int start,
		int end, OrderByComparator<TrackingActionInstance> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByUuid(String uuid, int start,
		int end, OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TrackingActionInstance> list = null;

		if (retrieveFromCache) {
			list = (List<TrackingActionInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrackingActionInstance trackingActionInstance : list) {
					if (!Validator.equals(uuid, trackingActionInstance.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByUuid_First(String uuid,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByUuid_First(String uuid,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByUuid_Last(String uuid,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByUuid_Last(String uuid,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance[] findByUuid_PrevAndNext(
		long trackingActionInstanceId, String uuid,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
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
	 */
	@Override
	public void removeByUuid(String uuid) {
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
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * Returns the tracking action instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTrackingActionInstanceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the tracking action instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
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
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					TrackingActionInstance trackingActionInstance = list.get(0);

					result = trackingActionInstance;

					cacheResult(trackingActionInstance);

					if ((trackingActionInstance.getUuid() == null) ||
							!trackingActionInstance.getUuid().equals(uuid) ||
							(trackingActionInstance.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, trackingActionInstance);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

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
	 */
	@Override
	public TrackingActionInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 */
	@Override
	public List<TrackingActionInstance> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TrackingActionInstance> list = null;

		if (retrieveFromCache) {
			list = (List<TrackingActionInstance>)finderCache.getResult(finderPath,
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
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance[] findByUuid_C_PrevAndNext(
		long trackingActionInstanceId, String uuid, long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
		long companyId,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
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
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
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
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 */
	@Override
	public List<TrackingActionInstance> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByGroupId(long groupId, int start,
		int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByGroupId(long groupId, int start,
		int end, OrderByComparator<TrackingActionInstance> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByGroupId(long groupId, int start,
		int end, OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TrackingActionInstance> list = null;

		if (retrieveFromCache) {
			list = (List<TrackingActionInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrackingActionInstance trackingActionInstance : list) {
					if ((groupId != trackingActionInstance.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByGroupId_First(long groupId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByGroupId_First(long groupId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByGroupId_Last(long groupId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByGroupId_Last(long groupId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance[] findByGroupId_PrevAndNext(
		long trackingActionInstanceId, long groupId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
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
	 */
	@Override
	public void removeByGroupId(long groupId) {
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
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 */
	@Override
	public List<TrackingActionInstance> findByCampaignId(long campaignId) {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByCampaignId(long campaignId,
		int start, int end) {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByCampaignId(long campaignId,
		int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return findByCampaignId(campaignId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByCampaignId(long campaignId,
		int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TrackingActionInstance> list = null;

		if (retrieveFromCache) {
			list = (List<TrackingActionInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrackingActionInstance trackingActionInstance : list) {
					if ((campaignId != trackingActionInstance.getCampaignId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByCampaignId_First(long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByCampaignId_First(long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByCampaignId_Last(long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByCampaignId_Last(long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance[] findByCampaignId_PrevAndNext(
		long trackingActionInstanceId, long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
		long campaignId,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
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
	 */
	@Override
	public void removeByCampaignId(long campaignId) {
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
	 */
	@Override
	public int countByCampaignId(long campaignId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNID;

		Object[] finderArgs = new Object[] { campaignId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "trackingActionInstance.campaignId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTINSTANCEID =
		new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReportInstanceId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID =
		new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByReportInstanceId", new String[] { Long.class.getName() },
			TrackingActionInstanceModelImpl.REPORTINSTANCEID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.TRACKINGACTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTINSTANCEID = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReportInstanceId", new String[] { Long.class.getName() });

	/**
	 * Returns all the tracking action instances where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @return the matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByReportInstanceId(
		long reportInstanceId) {
		return findByReportInstanceId(reportInstanceId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByReportInstanceId(
		long reportInstanceId, int start, int end) {
		return findByReportInstanceId(reportInstanceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByReportInstanceId(
		long reportInstanceId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return findByReportInstanceId(reportInstanceId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByReportInstanceId(
		long reportInstanceId, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID;
			finderArgs = new Object[] { reportInstanceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTINSTANCEID;
			finderArgs = new Object[] {
					reportInstanceId,
					
					start, end, orderByComparator
				};
		}

		List<TrackingActionInstance> list = null;

		if (retrieveFromCache) {
			list = (List<TrackingActionInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrackingActionInstance trackingActionInstance : list) {
					if ((reportInstanceId != trackingActionInstance.getReportInstanceId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_REPORTINSTANCEID_REPORTINSTANCEID_2);

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

				qPos.add(reportInstanceId);

				if (!pagination) {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tracking action instance in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByReportInstanceId_First(
		long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = fetchByReportInstanceId_First(reportInstanceId,
				orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the first tracking action instance in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance fetchByReportInstanceId_First(
		long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		List<TrackingActionInstance> list = findByReportInstanceId(reportInstanceId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracking action instance in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByReportInstanceId_Last(
		long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = fetchByReportInstanceId_Last(reportInstanceId,
				orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the last tracking action instance in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance fetchByReportInstanceId_Last(
		long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		int count = countByReportInstanceId(reportInstanceId);

		if (count == 0) {
			return null;
		}

		List<TrackingActionInstance> list = findByReportInstanceId(reportInstanceId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracking action instances before and after the current tracking action instance in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param trackingActionInstanceId the primary key of the current tracking action instance
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance[] findByReportInstanceId_PrevAndNext(
		long trackingActionInstanceId, long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = findByPrimaryKey(trackingActionInstanceId);

		Session session = null;

		try {
			session = openSession();

			TrackingActionInstance[] array = new TrackingActionInstanceImpl[3];

			array[0] = getByReportInstanceId_PrevAndNext(session,
					trackingActionInstance, reportInstanceId,
					orderByComparator, true);

			array[1] = trackingActionInstance;

			array[2] = getByReportInstanceId_PrevAndNext(session,
					trackingActionInstance, reportInstanceId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackingActionInstance getByReportInstanceId_PrevAndNext(
		Session session, TrackingActionInstance trackingActionInstance,
		long reportInstanceId,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_REPORTINSTANCEID_REPORTINSTANCEID_2);

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

		qPos.add(reportInstanceId);

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
	 * Removes all the tracking action instances where reportInstanceId = &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 */
	@Override
	public void removeByReportInstanceId(long reportInstanceId) {
		for (TrackingActionInstance trackingActionInstance : findByReportInstanceId(
				reportInstanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @return the number of matching tracking action instances
	 */
	@Override
	public int countByReportInstanceId(long reportInstanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPORTINSTANCEID;

		Object[] finderArgs = new Object[] { reportInstanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_REPORTINSTANCEID_REPORTINSTANCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REPORTINSTANCEID_REPORTINSTANCEID_2 =
		"trackingActionInstance.reportInstanceId = ?";
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
	 * Returns the tracking action instance where campaignId = &#63; and alias = &#63; or throws a {@link NoSuchTrackingActionInstanceException} if it could not be found.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @return the matching tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByC_A(long campaignId, String alias)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByC_A(long campaignId, String alias) {
		return fetchByC_A(campaignId, alias, true);
	}

	/**
	 * Returns the tracking action instance where campaignId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance fetchByC_A(long campaignId, String alias,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { campaignId, alias };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_A,
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
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_A, finderArgs,
						list);
				}
				else {
					TrackingActionInstance trackingActionInstance = list.get(0);

					result = trackingActionInstance;

					cacheResult(trackingActionInstance);

					if ((trackingActionInstance.getCampaignId() != campaignId) ||
							(trackingActionInstance.getAlias() == null) ||
							!trackingActionInstance.getAlias().equals(alias)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_A,
							finderArgs, trackingActionInstance);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_A, finderArgs);

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
	 */
	@Override
	public TrackingActionInstance removeByC_A(long campaignId, String alias)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public int countByC_A(long campaignId, String alias) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_A;

		Object[] finderArgs = new Object[] { campaignId, alias };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	public static final FinderPath FINDER_PATH_FETCH_BY_R_A = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByR_A",
			new String[] { Long.class.getName(), String.class.getName() },
			TrackingActionInstanceModelImpl.REPORTINSTANCEID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.ALIAS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_A = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_A",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the tracking action instance where reportInstanceId = &#63; and alias = &#63; or throws a {@link NoSuchTrackingActionInstanceException} if it could not be found.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param alias the alias
	 * @return the matching tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByR_A(long reportInstanceId, String alias)
		throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = fetchByR_A(reportInstanceId,
				alias);

		if (trackingActionInstance == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("reportInstanceId=");
			msg.append(reportInstanceId);

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
	 * Returns the tracking action instance where reportInstanceId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param alias the alias
	 * @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance fetchByR_A(long reportInstanceId, String alias) {
		return fetchByR_A(reportInstanceId, alias, true);
	}

	/**
	 * Returns the tracking action instance where reportInstanceId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param alias the alias
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance fetchByR_A(long reportInstanceId,
		String alias, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { reportInstanceId, alias };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_R_A,
					finderArgs, this);
		}

		if (result instanceof TrackingActionInstance) {
			TrackingActionInstance trackingActionInstance = (TrackingActionInstance)result;

			if ((reportInstanceId != trackingActionInstance.getReportInstanceId()) ||
					!Validator.equals(alias, trackingActionInstance.getAlias())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_R_A_REPORTINSTANCEID_2);

			boolean bindAlias = false;

			if (alias == null) {
				query.append(_FINDER_COLUMN_R_A_ALIAS_1);
			}
			else if (alias.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_A_ALIAS_3);
			}
			else {
				bindAlias = true;

				query.append(_FINDER_COLUMN_R_A_ALIAS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (bindAlias) {
					qPos.add(alias);
				}

				List<TrackingActionInstance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_R_A, finderArgs,
						list);
				}
				else {
					TrackingActionInstance trackingActionInstance = list.get(0);

					result = trackingActionInstance;

					cacheResult(trackingActionInstance);

					if ((trackingActionInstance.getReportInstanceId() != reportInstanceId) ||
							(trackingActionInstance.getAlias() == null) ||
							!trackingActionInstance.getAlias().equals(alias)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_R_A,
							finderArgs, trackingActionInstance);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_R_A, finderArgs);

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
	 * Removes the tracking action instance where reportInstanceId = &#63; and alias = &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param alias the alias
	 * @return the tracking action instance that was removed
	 */
	@Override
	public TrackingActionInstance removeByR_A(long reportInstanceId,
		String alias) throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = findByR_A(reportInstanceId,
				alias);

		return remove(trackingActionInstance);
	}

	/**
	 * Returns the number of tracking action instances where reportInstanceId = &#63; and alias = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param alias the alias
	 * @return the number of matching tracking action instances
	 */
	@Override
	public int countByR_A(long reportInstanceId, String alias) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_A;

		Object[] finderArgs = new Object[] { reportInstanceId, alias };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_R_A_REPORTINSTANCEID_2);

			boolean bindAlias = false;

			if (alias == null) {
				query.append(_FINDER_COLUMN_R_A_ALIAS_1);
			}
			else if (alias.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_A_ALIAS_3);
			}
			else {
				bindAlias = true;

				query.append(_FINDER_COLUMN_R_A_ALIAS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (bindAlias) {
					qPos.add(alias);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_R_A_REPORTINSTANCEID_2 = "trackingActionInstance.reportInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_R_A_ALIAS_1 = "trackingActionInstance.alias IS NULL";
	private static final String _FINDER_COLUMN_R_A_ALIAS_2 = "trackingActionInstance.alias = ?";
	private static final String _FINDER_COLUMN_R_A_ALIAS_3 = "(trackingActionInstance.alias IS NULL OR trackingActionInstance.alias = '')";
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
	 */
	@Override
	public List<TrackingActionInstance> findByC_E_E(long campaignId,
		String elementId, String eventType) {
		return findByC_E_E(campaignId, elementId, eventType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByC_E_E(long campaignId,
		String elementId, String eventType, int start, int end) {
		return findByC_E_E(campaignId, elementId, eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByC_E_E(long campaignId,
		String elementId, String eventType, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return findByC_E_E(campaignId, elementId, eventType, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where campaignId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByC_E_E(long campaignId,
		String elementId, String eventType, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TrackingActionInstance> list = null;

		if (retrieveFromCache) {
			list = (List<TrackingActionInstance>)finderCache.getResult(finderPath,
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
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByC_E_E_First(long campaignId,
		String elementId, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByC_E_E_First(long campaignId,
		String elementId, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByC_E_E_Last(long campaignId,
		String elementId, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByC_E_E_Last(long campaignId,
		String elementId, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance[] findByC_E_E_PrevAndNext(
		long trackingActionInstanceId, long campaignId, String elementId,
		String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
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
	 */
	@Override
	public void removeByC_E_E(long campaignId, String elementId,
		String eventType) {
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
	 */
	@Override
	public int countByC_E_E(long campaignId, String elementId, String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_E_E;

		Object[] finderArgs = new Object[] { campaignId, elementId, eventType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_E_E = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_E_E = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			TrackingActionInstanceModelImpl.REPORTINSTANCEID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.ELEMENTID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.EVENTTYPE_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.TRACKINGACTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_E_E = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByR_E_E(long reportInstanceId,
		String elementId, String eventType) {
		return findByR_E_E(reportInstanceId, elementId, eventType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByR_E_E(long reportInstanceId,
		String elementId, String eventType, int start, int end) {
		return findByR_E_E(reportInstanceId, elementId, eventType, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByR_E_E(long reportInstanceId,
		String elementId, String eventType, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return findByR_E_E(reportInstanceId, elementId, eventType, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByR_E_E(long reportInstanceId,
		String elementId, String eventType, int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_E_E;
			finderArgs = new Object[] { reportInstanceId, elementId, eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_E_E;
			finderArgs = new Object[] {
					reportInstanceId, elementId, eventType,
					
					start, end, orderByComparator
				};
		}

		List<TrackingActionInstance> list = null;

		if (retrieveFromCache) {
			list = (List<TrackingActionInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrackingActionInstance trackingActionInstance : list) {
					if ((reportInstanceId != trackingActionInstance.getReportInstanceId()) ||
							!Validator.equals(elementId,
								trackingActionInstance.getElementId()) ||
							!Validator.equals(eventType,
								trackingActionInstance.getEventType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_R_E_E_REPORTINSTANCEID_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_R_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_R_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_R_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_R_E_E_EVENTTYPE_2);
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

				qPos.add(reportInstanceId);

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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tracking action instance in the ordered set where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByR_E_E_First(long reportInstanceId,
		String elementId, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = fetchByR_E_E_First(reportInstanceId,
				elementId, eventType, orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(", elementId=");
		msg.append(elementId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the first tracking action instance in the ordered set where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance fetchByR_E_E_First(long reportInstanceId,
		String elementId, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		List<TrackingActionInstance> list = findByR_E_E(reportInstanceId,
				elementId, eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracking action instance in the ordered set where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByR_E_E_Last(long reportInstanceId,
		String elementId, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = fetchByR_E_E_Last(reportInstanceId,
				elementId, eventType, orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(", elementId=");
		msg.append(elementId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackingActionInstanceException(msg.toString());
	}

	/**
	 * Returns the last tracking action instance in the ordered set where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance fetchByR_E_E_Last(long reportInstanceId,
		String elementId, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		int count = countByR_E_E(reportInstanceId, elementId, eventType);

		if (count == 0) {
			return null;
		}

		List<TrackingActionInstance> list = findByR_E_E(reportInstanceId,
				elementId, eventType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracking action instances before and after the current tracking action instance in the ordered set where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param trackingActionInstanceId the primary key of the current tracking action instance
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance[] findByR_E_E_PrevAndNext(
		long trackingActionInstanceId, long reportInstanceId, String elementId,
		String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = findByPrimaryKey(trackingActionInstanceId);

		Session session = null;

		try {
			session = openSession();

			TrackingActionInstance[] array = new TrackingActionInstanceImpl[3];

			array[0] = getByR_E_E_PrevAndNext(session, trackingActionInstance,
					reportInstanceId, elementId, eventType, orderByComparator,
					true);

			array[1] = trackingActionInstance;

			array[2] = getByR_E_E_PrevAndNext(session, trackingActionInstance,
					reportInstanceId, elementId, eventType, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackingActionInstance getByR_E_E_PrevAndNext(Session session,
		TrackingActionInstance trackingActionInstance, long reportInstanceId,
		String elementId, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_R_E_E_REPORTINSTANCEID_2);

		boolean bindElementId = false;

		if (elementId == null) {
			query.append(_FINDER_COLUMN_R_E_E_ELEMENTID_1);
		}
		else if (elementId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_R_E_E_ELEMENTID_3);
		}
		else {
			bindElementId = true;

			query.append(_FINDER_COLUMN_R_E_E_ELEMENTID_2);
		}

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_R_E_E_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_R_E_E_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_R_E_E_EVENTTYPE_2);
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

		qPos.add(reportInstanceId);

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
	 * Removes all the tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 */
	@Override
	public void removeByR_E_E(long reportInstanceId, String elementId,
		String eventType) {
		for (TrackingActionInstance trackingActionInstance : findByR_E_E(
				reportInstanceId, elementId, eventType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances where reportInstanceId = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the number of matching tracking action instances
	 */
	@Override
	public int countByR_E_E(long reportInstanceId, String elementId,
		String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_E_E;

		Object[] finderArgs = new Object[] {
				reportInstanceId, elementId, eventType
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_R_E_E_REPORTINSTANCEID_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_R_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_R_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_R_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_R_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (bindEventType) {
					qPos.add(eventType);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_R_E_E_REPORTINSTANCEID_2 = "trackingActionInstance.reportInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_R_E_E_ELEMENTID_1 = "trackingActionInstance.elementId IS NULL AND ";
	private static final String _FINDER_COLUMN_R_E_E_ELEMENTID_2 = "trackingActionInstance.elementId = ? AND ";
	private static final String _FINDER_COLUMN_R_E_E_ELEMENTID_3 = "(trackingActionInstance.elementId IS NULL OR trackingActionInstance.elementId = '') AND ";
	private static final String _FINDER_COLUMN_R_E_E_EVENTTYPE_1 = "trackingActionInstance.eventType IS NULL";
	private static final String _FINDER_COLUMN_R_E_E_EVENTTYPE_2 = "trackingActionInstance.eventType = ?";
	private static final String _FINDER_COLUMN_R_E_E_EVENTTYPE_3 = "(trackingActionInstance.eventType IS NULL OR trackingActionInstance.eventType = '')";
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
	 */
	@Override
	public List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType) {
		return findByC_R_R_E(campaignId, referrerClassName, referrerClassPK,
			eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		int start, int end) {
		return findByC_R_R_E(campaignId, referrerClassName, referrerClassPK,
			eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 */
	@Override
	public List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return findByC_R_R_E(campaignId, referrerClassName, referrerClassPK,
			eventType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByC_R_R_E(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TrackingActionInstance> list = null;

		if (retrieveFromCache) {
			list = (List<TrackingActionInstance>)finderCache.getResult(finderPath,
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
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 2));
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByC_R_R_E_First(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByC_R_R_E_First(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByC_R_R_E_Last(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
	 */
	@Override
	public TrackingActionInstance fetchByC_R_R_E_Last(long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
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
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance[] findByC_R_R_E_PrevAndNext(
		long trackingActionInstanceId, long campaignId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
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
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(7 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
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
	 */
	@Override
	public void removeByC_R_R_E(long campaignId, String referrerClassName,
		long referrerClassPK, String eventType) {
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
	 */
	@Override
	public int countByC_R_R_E(long campaignId, String referrerClassName,
		long referrerClassPK, String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_R_R_E;

		Object[] finderArgs = new Object[] {
				campaignId, referrerClassName, referrerClassPK, eventType
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_R_R_E = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_R_R_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R_R_E =
		new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_R_R_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			TrackingActionInstanceModelImpl.REPORTINSTANCEID_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.REFERRERCLASSNAME_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.REFERRERCLASSPK_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.EVENTTYPE_COLUMN_BITMASK |
			TrackingActionInstanceModelImpl.TRACKINGACTIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_R_R_E = new FinderPath(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_R_R_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @return the matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByR_R_R_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType) {
		return findByR_R_R_E(reportInstanceId, referrerClassName,
			referrerClassPK, eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByR_R_R_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType,
		int start, int end) {
		return findByR_R_R_E(reportInstanceId, referrerClassName,
			referrerClassPK, eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByR_R_R_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType,
		int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return findByR_R_R_E(reportInstanceId, referrerClassName,
			referrerClassPK, eventType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findByR_R_R_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType,
		int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R_R_E;
			finderArgs = new Object[] {
					reportInstanceId, referrerClassName, referrerClassPK,
					eventType
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_R_R_E;
			finderArgs = new Object[] {
					reportInstanceId, referrerClassName, referrerClassPK,
					eventType,
					
					start, end, orderByComparator
				};
		}

		List<TrackingActionInstance> list = null;

		if (retrieveFromCache) {
			list = (List<TrackingActionInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TrackingActionInstance trackingActionInstance : list) {
					if ((reportInstanceId != trackingActionInstance.getReportInstanceId()) ||
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
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_R_R_R_E_REPORTINSTANCEID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_R_R_R_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_R_R_R_E_EVENTTYPE_2);
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

				qPos.add(reportInstanceId);

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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tracking action instance in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByR_R_R_E_First(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = fetchByR_R_R_E_First(reportInstanceId,
				referrerClassName, referrerClassPK, eventType, orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

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
	 * Returns the first tracking action instance in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance fetchByR_R_R_E_First(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		List<TrackingActionInstance> list = findByR_R_R_E(reportInstanceId,
				referrerClassName, referrerClassPK, eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tracking action instance in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance findByR_R_R_E_Last(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = fetchByR_R_R_E_Last(reportInstanceId,
				referrerClassName, referrerClassPK, eventType, orderByComparator);

		if (trackingActionInstance != null) {
			return trackingActionInstance;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

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
	 * Returns the last tracking action instance in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tracking action instance, or <code>null</code> if a matching tracking action instance could not be found
	 */
	@Override
	public TrackingActionInstance fetchByR_R_R_E_Last(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		int count = countByR_R_R_E(reportInstanceId, referrerClassName,
				referrerClassPK, eventType);

		if (count == 0) {
			return null;
		}

		List<TrackingActionInstance> list = findByR_R_R_E(reportInstanceId,
				referrerClassName, referrerClassPK, eventType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tracking action instances before and after the current tracking action instance in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param trackingActionInstanceId the primary key of the current tracking action instance
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance[] findByR_R_R_E_PrevAndNext(
		long trackingActionInstanceId, long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator)
		throws NoSuchTrackingActionInstanceException {
		TrackingActionInstance trackingActionInstance = findByPrimaryKey(trackingActionInstanceId);

		Session session = null;

		try {
			session = openSession();

			TrackingActionInstance[] array = new TrackingActionInstanceImpl[3];

			array[0] = getByR_R_R_E_PrevAndNext(session,
					trackingActionInstance, reportInstanceId,
					referrerClassName, referrerClassPK, eventType,
					orderByComparator, true);

			array[1] = trackingActionInstance;

			array[2] = getByR_R_R_E_PrevAndNext(session,
					trackingActionInstance, reportInstanceId,
					referrerClassName, referrerClassPK, eventType,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrackingActionInstance getByR_R_R_E_PrevAndNext(Session session,
		TrackingActionInstance trackingActionInstance, long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(7 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_R_R_R_E_REPORTINSTANCEID_2);

		boolean bindReferrerClassName = false;

		if (referrerClassName == null) {
			query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_1);
		}
		else if (referrerClassName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_3);
		}
		else {
			bindReferrerClassName = true;

			query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSPK_2);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_R_R_R_E_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_R_R_R_E_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_R_R_R_E_EVENTTYPE_2);
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

		qPos.add(reportInstanceId);

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
	 * Removes all the tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 */
	@Override
	public void removeByR_R_R_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String eventType) {
		for (TrackingActionInstance trackingActionInstance : findByR_R_R_E(
				reportInstanceId, referrerClassName, referrerClassPK,
				eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @return the number of matching tracking action instances
	 */
	@Override
	public int countByR_R_R_E(long reportInstanceId, String referrerClassName,
		long referrerClassPK, String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_R_R_E;

		Object[] finderArgs = new Object[] {
				reportInstanceId, referrerClassName, referrerClassPK, eventType
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_R_R_R_E_REPORTINSTANCEID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_R_R_E_REFERRERCLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_R_R_R_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_R_R_R_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_R_R_R_E_REPORTINSTANCEID_2 = "trackingActionInstance.reportInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_1 = "trackingActionInstance.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_2 = "trackingActionInstance.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_REFERRERCLASSNAME_3 = "(trackingActionInstance.referrerClassName IS NULL OR trackingActionInstance.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_REFERRERCLASSPK_2 = "trackingActionInstance.referrerClassPK = ? AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_EVENTTYPE_1 = "trackingActionInstance.eventType IS NULL";
	private static final String _FINDER_COLUMN_R_R_R_E_EVENTTYPE_2 = "trackingActionInstance.eventType = ?";
	private static final String _FINDER_COLUMN_R_R_R_E_EVENTTYPE_3 = "(trackingActionInstance.eventType IS NULL OR trackingActionInstance.eventType = '')";

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
		entityCache.putResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			trackingActionInstance.getPrimaryKey(), trackingActionInstance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				trackingActionInstance.getUuid(),
				trackingActionInstance.getGroupId()
			}, trackingActionInstance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_A,
			new Object[] {
				trackingActionInstance.getCampaignId(),
				trackingActionInstance.getAlias()
			}, trackingActionInstance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_R_A,
			new Object[] {
				trackingActionInstance.getReportInstanceId(),
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
			if (entityCache.getResult(
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
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TrackingActionInstanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tracking action instance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrackingActionInstance trackingActionInstance) {
		entityCache.removeResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			trackingActionInstance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TrackingActionInstanceModelImpl)trackingActionInstance);
	}

	@Override
	public void clearCache(List<TrackingActionInstance> trackingActionInstances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrackingActionInstance trackingActionInstance : trackingActionInstances) {
			entityCache.removeResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
				TrackingActionInstanceImpl.class,
				trackingActionInstance.getPrimaryKey());

			clearUniqueFindersCache((TrackingActionInstanceModelImpl)trackingActionInstance);
		}
	}

	protected void cacheUniqueFindersCache(
		TrackingActionInstanceModelImpl trackingActionInstanceModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					trackingActionInstanceModelImpl.getUuid(),
					trackingActionInstanceModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				trackingActionInstanceModelImpl);

			args = new Object[] {
					trackingActionInstanceModelImpl.getCampaignId(),
					trackingActionInstanceModelImpl.getAlias()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_C_A, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_C_A, args,
				trackingActionInstanceModelImpl);

			args = new Object[] {
					trackingActionInstanceModelImpl.getReportInstanceId(),
					trackingActionInstanceModelImpl.getAlias()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_R_A, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_R_A, args,
				trackingActionInstanceModelImpl);
		}
		else {
			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getUuid(),
						trackingActionInstanceModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					trackingActionInstanceModelImpl);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getCampaignId(),
						trackingActionInstanceModelImpl.getAlias()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_C_A, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_C_A, args,
					trackingActionInstanceModelImpl);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_R_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getReportInstanceId(),
						trackingActionInstanceModelImpl.getAlias()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_R_A, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_R_A, args,
					trackingActionInstanceModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		TrackingActionInstanceModelImpl trackingActionInstanceModelImpl) {
		Object[] args = new Object[] {
				trackingActionInstanceModelImpl.getUuid(),
				trackingActionInstanceModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((trackingActionInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					trackingActionInstanceModelImpl.getOriginalUuid(),
					trackingActionInstanceModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				trackingActionInstanceModelImpl.getCampaignId(),
				trackingActionInstanceModelImpl.getAlias()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_C_A, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_C_A, args);

		if ((trackingActionInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_A.getColumnBitmask()) != 0) {
			args = new Object[] {
					trackingActionInstanceModelImpl.getOriginalCampaignId(),
					trackingActionInstanceModelImpl.getOriginalAlias()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_A, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_A, args);
		}

		args = new Object[] {
				trackingActionInstanceModelImpl.getReportInstanceId(),
				trackingActionInstanceModelImpl.getAlias()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_R_A, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_R_A, args);

		if ((trackingActionInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_R_A.getColumnBitmask()) != 0) {
			args = new Object[] {
					trackingActionInstanceModelImpl.getOriginalReportInstanceId(),
					trackingActionInstanceModelImpl.getOriginalAlias()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_R_A, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_R_A, args);
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

		trackingActionInstance.setCompanyId(companyProvider.getCompanyId());

		return trackingActionInstance;
	}

	/**
	 * Removes the tracking action instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trackingActionInstanceId the primary key of the tracking action instance
	 * @return the tracking action instance that was removed
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance remove(long trackingActionInstanceId)
		throws NoSuchTrackingActionInstanceException {
		return remove((Serializable)trackingActionInstanceId);
	}

	/**
	 * Removes the tracking action instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tracking action instance
	 * @return the tracking action instance that was removed
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance remove(Serializable primaryKey)
		throws NoSuchTrackingActionInstanceException {
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
		TrackingActionInstance trackingActionInstance) {
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
		TrackingActionInstance trackingActionInstance) {
		trackingActionInstance = toUnwrappedModel(trackingActionInstance);

		boolean isNew = trackingActionInstance.isNew();

		TrackingActionInstanceModelImpl trackingActionInstanceModelImpl = (TrackingActionInstanceModelImpl)trackingActionInstance;

		if (Validator.isNull(trackingActionInstance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			trackingActionInstance.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (trackingActionInstance.getCreateDate() == null)) {
			if (serviceContext == null) {
				trackingActionInstance.setCreateDate(now);
			}
			else {
				trackingActionInstance.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!trackingActionInstanceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				trackingActionInstance.setModifiedDate(now);
			}
			else {
				trackingActionInstance.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (trackingActionInstance.isNew()) {
				session.save(trackingActionInstance);

				trackingActionInstance.setNew(false);
			}
			else {
				trackingActionInstance = (TrackingActionInstance)session.merge(trackingActionInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrackingActionInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { trackingActionInstanceModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalUuid(),
						trackingActionInstanceModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getUuid(),
						trackingActionInstanceModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { trackingActionInstanceModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalCampaignId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getCampaignId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalReportInstanceId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REPORTINSTANCEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getReportInstanceId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REPORTINSTANCEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalCampaignId(),
						trackingActionInstanceModelImpl.getOriginalElementId(),
						trackingActionInstanceModelImpl.getOriginalEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_E_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E_E,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getCampaignId(),
						trackingActionInstanceModelImpl.getElementId(),
						trackingActionInstanceModelImpl.getEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_E_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E_E,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_E_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalReportInstanceId(),
						trackingActionInstanceModelImpl.getOriginalElementId(),
						trackingActionInstanceModelImpl.getOriginalEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_E_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_E_E,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getReportInstanceId(),
						trackingActionInstanceModelImpl.getElementId(),
						trackingActionInstanceModelImpl.getEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_E_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_E_E,
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

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_R_R_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R_E,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getCampaignId(),
						trackingActionInstanceModelImpl.getReferrerClassName(),
						trackingActionInstanceModelImpl.getReferrerClassPK(),
						trackingActionInstanceModelImpl.getEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_R_R_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R_E,
					args);
			}

			if ((trackingActionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R_R_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trackingActionInstanceModelImpl.getOriginalReportInstanceId(),
						trackingActionInstanceModelImpl.getOriginalReferrerClassName(),
						trackingActionInstanceModelImpl.getOriginalReferrerClassPK(),
						trackingActionInstanceModelImpl.getOriginalEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_R_R_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R_R_E,
					args);

				args = new Object[] {
						trackingActionInstanceModelImpl.getReportInstanceId(),
						trackingActionInstanceModelImpl.getReferrerClassName(),
						trackingActionInstanceModelImpl.getReferrerClassPK(),
						trackingActionInstanceModelImpl.getEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_R_R_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R_R_E,
					args);
			}
		}

		entityCache.putResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			TrackingActionInstanceImpl.class,
			trackingActionInstance.getPrimaryKey(), trackingActionInstance,
			false);

		clearUniqueFindersCache(trackingActionInstanceModelImpl);
		cacheUniqueFindersCache(trackingActionInstanceModelImpl, isNew);

		trackingActionInstance.resetOriginalValues();

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
		trackingActionInstanceImpl.setReportInstanceId(trackingActionInstance.getReportInstanceId());
		trackingActionInstanceImpl.setAlias(trackingActionInstance.getAlias());
		trackingActionInstanceImpl.setReferrerClassName(trackingActionInstance.getReferrerClassName());
		trackingActionInstanceImpl.setReferrerClassPK(trackingActionInstance.getReferrerClassPK());
		trackingActionInstanceImpl.setElementId(trackingActionInstance.getElementId());
		trackingActionInstanceImpl.setEventType(trackingActionInstance.getEventType());
		trackingActionInstanceImpl.setTypeSettings(trackingActionInstance.getTypeSettings());

		return trackingActionInstanceImpl;
	}

	/**
	 * Returns the tracking action instance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tracking action instance
	 * @return the tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTrackingActionInstanceException {
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
	 * Returns the tracking action instance with the primary key or throws a {@link NoSuchTrackingActionInstanceException} if it could not be found.
	 *
	 * @param trackingActionInstanceId the primary key of the tracking action instance
	 * @return the tracking action instance
	 * @throws NoSuchTrackingActionInstanceException if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance findByPrimaryKey(
		long trackingActionInstanceId)
		throws NoSuchTrackingActionInstanceException {
		return findByPrimaryKey((Serializable)trackingActionInstanceId);
	}

	/**
	 * Returns the tracking action instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tracking action instance
	 * @return the tracking action instance, or <code>null</code> if a tracking action instance with the primary key could not be found
	 */
	@Override
	public TrackingActionInstance fetchByPrimaryKey(Serializable primaryKey) {
		TrackingActionInstance trackingActionInstance = (TrackingActionInstance)entityCache.getResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
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
					entityCache.putResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
						TrackingActionInstanceImpl.class, primaryKey,
						_nullTrackingActionInstance);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
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
	 */
	@Override
	public TrackingActionInstance fetchByPrimaryKey(
		long trackingActionInstanceId) {
		return fetchByPrimaryKey((Serializable)trackingActionInstanceId);
	}

	@Override
	public Map<Serializable, TrackingActionInstance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TrackingActionInstance> map = new HashMap<Serializable, TrackingActionInstance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TrackingActionInstance trackingActionInstance = fetchByPrimaryKey(primaryKey);

			if (trackingActionInstance != null) {
				map.put(primaryKey, trackingActionInstance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			TrackingActionInstance trackingActionInstance = (TrackingActionInstance)entityCache.getResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
					TrackingActionInstanceImpl.class, primaryKey);

			if (trackingActionInstance == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, trackingActionInstance);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TrackingActionInstance trackingActionInstance : (List<TrackingActionInstance>)q.list()) {
				map.put(trackingActionInstance.getPrimaryKeyObj(),
					trackingActionInstance);

				cacheResult(trackingActionInstance);

				uncachedPrimaryKeys.remove(trackingActionInstance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TrackingActionInstanceModelImpl.ENTITY_CACHE_ENABLED,
					TrackingActionInstanceImpl.class, primaryKey,
					_nullTrackingActionInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the tracking action instances.
	 *
	 * @return the tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tracking action instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @return the range of tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tracking action instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findAll(int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tracking action instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TrackingActionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tracking action instances
	 * @param end the upper bound of the range of tracking action instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tracking action instances
	 */
	@Override
	public List<TrackingActionInstance> findAll(int start, int end,
		OrderByComparator<TrackingActionInstance> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TrackingActionInstance> list = null;

		if (retrieveFromCache) {
			list = (List<TrackingActionInstance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrackingActionInstance>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 */
	@Override
	public void removeAll() {
		for (TrackingActionInstance trackingActionInstance : findAll()) {
			remove(trackingActionInstance);
		}
	}

	/**
	 * Returns the number of tracking action instances.
	 *
	 * @return the number of tracking action instances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRACKINGACTIONINSTANCE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TrackingActionInstanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tracking action instance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TrackingActionInstanceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TRACKINGACTIONINSTANCE = "SELECT trackingActionInstance FROM TrackingActionInstance trackingActionInstance";
	private static final String _SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE_PKS_IN = "SELECT trackingActionInstance FROM TrackingActionInstance trackingActionInstance WHERE trackingActionInstanceId IN (";
	private static final String _SQL_SELECT_TRACKINGACTIONINSTANCE_WHERE = "SELECT trackingActionInstance FROM TrackingActionInstance trackingActionInstance WHERE ";
	private static final String _SQL_COUNT_TRACKINGACTIONINSTANCE = "SELECT COUNT(trackingActionInstance) FROM TrackingActionInstance trackingActionInstance";
	private static final String _SQL_COUNT_TRACKINGACTIONINSTANCE_WHERE = "SELECT COUNT(trackingActionInstance) FROM TrackingActionInstance trackingActionInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trackingActionInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrackingActionInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrackingActionInstance exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TrackingActionInstancePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "alias"
			});
	private static final TrackingActionInstance _nullTrackingActionInstance = new TrackingActionInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TrackingActionInstance> toCacheModel() {
				return _nullTrackingActionInstanceCacheModel;
			}
		};

	private static final CacheModel<TrackingActionInstance> _nullTrackingActionInstanceCacheModel =
		new CacheModel<TrackingActionInstance>() {
			@Override
			public TrackingActionInstance toEntityModel() {
				return _nullTrackingActionInstance;
			}
		};
}