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

import com.liferay.content.targeting.exception.NoSuchChannelInstanceException;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.impl.ChannelInstanceImpl;
import com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl;
import com.liferay.content.targeting.service.persistence.ChannelInstancePersistence;

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
 * The persistence implementation for the channel instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstancePersistence
 * @see com.liferay.content.targeting.service.persistence.ChannelInstanceUtil
 * @generated
 */
@ProviderType
public class ChannelInstancePersistenceImpl extends BasePersistenceImpl<ChannelInstance>
	implements ChannelInstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChannelInstanceUtil} to access the channel instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChannelInstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ChannelInstanceModelImpl.UUID_COLUMN_BITMASK |
			ChannelInstanceModelImpl.CHANNELKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the channel instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByUuid(String uuid, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channel instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByUuid(String uuid, int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
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

		List<ChannelInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ChannelInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChannelInstance channelInstance : list) {
					if (!Validator.equals(uuid, channelInstance.getUuid())) {
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

			query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

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
				query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ChannelInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByUuid_First(String uuid,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByUuid_First(uuid,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the first channel instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByUuid_First(String uuid,
		OrderByComparator<ChannelInstance> orderByComparator) {
		List<ChannelInstance> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByUuid_Last(String uuid,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByUuid_Last(uuid,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the last channel instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByUuid_Last(String uuid,
		OrderByComparator<ChannelInstance> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ChannelInstance> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel instances before and after the current channel instance in the ordered set where uuid = &#63;.
	 *
	 * @param channelInstanceId the primary key of the current channel instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel instance
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance[] findByUuid_PrevAndNext(long channelInstanceId,
		String uuid, OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = findByPrimaryKey(channelInstanceId);

		Session session = null;

		try {
			session = openSession();

			ChannelInstance[] array = new ChannelInstanceImpl[3];

			array[0] = getByUuid_PrevAndNext(session, channelInstance, uuid,
					orderByComparator, true);

			array[1] = channelInstance;

			array[2] = getByUuid_PrevAndNext(session, channelInstance, uuid,
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

	protected ChannelInstance getByUuid_PrevAndNext(Session session,
		ChannelInstance channelInstance, String uuid,
		OrderByComparator<ChannelInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

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
			query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(channelInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channel instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ChannelInstance channelInstance : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(channelInstance);
		}
	}

	/**
	 * Returns the number of channel instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching channel instances
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHANNELINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "channelInstance.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "channelInstance.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(channelInstance.uuid IS NULL OR channelInstance.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ChannelInstanceModelImpl.UUID_COLUMN_BITMASK |
			ChannelInstanceModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the channel instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchChannelInstanceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByUUID_G(uuid, groupId);

		if (channelInstance == null) {
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

			throw new NoSuchChannelInstanceException(msg.toString());
		}

		return channelInstance;
	}

	/**
	 * Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ChannelInstance) {
			ChannelInstance channelInstance = (ChannelInstance)result;

			if (!Validator.equals(uuid, channelInstance.getUuid()) ||
					(groupId != channelInstance.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

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

				List<ChannelInstance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ChannelInstance channelInstance = list.get(0);

					result = channelInstance;

					cacheResult(channelInstance);

					if ((channelInstance.getUuid() == null) ||
							!channelInstance.getUuid().equals(uuid) ||
							(channelInstance.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, channelInstance);
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
			return (ChannelInstance)result;
		}
	}

	/**
	 * Removes the channel instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the channel instance that was removed
	 */
	@Override
	public ChannelInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = findByUUID_G(uuid, groupId);

		return remove(channelInstance);
	}

	/**
	 * Returns the number of channel instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching channel instances
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHANNELINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "channelInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "channelInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(channelInstance.uuid IS NULL OR channelInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "channelInstance.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ChannelInstanceModelImpl.UUID_COLUMN_BITMASK |
			ChannelInstanceModelImpl.COMPANYID_COLUMN_BITMASK |
			ChannelInstanceModelImpl.CHANNELKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the channel instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channel instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
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

		List<ChannelInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ChannelInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChannelInstance channelInstance : list) {
					if (!Validator.equals(uuid, channelInstance.getUuid()) ||
							(companyId != channelInstance.getCompanyId())) {
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

			query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

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
				query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ChannelInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the first channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		List<ChannelInstance> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the last channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ChannelInstance> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel instances before and after the current channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param channelInstanceId the primary key of the current channel instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel instance
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance[] findByUuid_C_PrevAndNext(long channelInstanceId,
		String uuid, long companyId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = findByPrimaryKey(channelInstanceId);

		Session session = null;

		try {
			session = openSession();

			ChannelInstance[] array = new ChannelInstanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, channelInstance, uuid,
					companyId, orderByComparator, true);

			array[1] = channelInstance;

			array[2] = getByUuid_C_PrevAndNext(session, channelInstance, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChannelInstance getByUuid_C_PrevAndNext(Session session,
		ChannelInstance channelInstance, String uuid, long companyId,
		OrderByComparator<ChannelInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

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
			query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(channelInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channel instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ChannelInstance channelInstance : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(channelInstance);
		}
	}

	/**
	 * Returns the number of channel instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching channel instances
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHANNELINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "channelInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "channelInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(channelInstance.uuid IS NULL OR channelInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "channelInstance.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ChannelInstanceModelImpl.GROUPID_COLUMN_BITMASK |
			ChannelInstanceModelImpl.CHANNELKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the channel instances where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByGroupId(long groupId, int start,
		int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channel instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByGroupId(long groupId, int start,
		int end, OrderByComparator<ChannelInstance> orderByComparator,
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

		List<ChannelInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ChannelInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChannelInstance channelInstance : list) {
					if ((groupId != channelInstance.getGroupId())) {
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

			query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ChannelInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByGroupId_First(long groupId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByGroupId_First(groupId,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the first channel instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByGroupId_First(long groupId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		List<ChannelInstance> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByGroupId_Last(long groupId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the last channel instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByGroupId_Last(long groupId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ChannelInstance> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel instances before and after the current channel instance in the ordered set where groupId = &#63;.
	 *
	 * @param channelInstanceId the primary key of the current channel instance
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel instance
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance[] findByGroupId_PrevAndNext(long channelInstanceId,
		long groupId, OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = findByPrimaryKey(channelInstanceId);

		Session session = null;

		try {
			session = openSession();

			ChannelInstance[] array = new ChannelInstanceImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, channelInstance,
					groupId, orderByComparator, true);

			array[1] = channelInstance;

			array[2] = getByGroupId_PrevAndNext(session, channelInstance,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChannelInstance getByGroupId_PrevAndNext(Session session,
		ChannelInstance channelInstance, long groupId,
		OrderByComparator<ChannelInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

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
			query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(channelInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channel instances where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ChannelInstance channelInstance : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(channelInstance);
		}
	}

	/**
	 * Returns the number of channel instances where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching channel instances
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHANNELINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "channelInstance.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHANNELKEY =
		new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByChannelKey",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHANNELKEY =
		new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChannelKey",
			new String[] { String.class.getName() },
			ChannelInstanceModelImpl.CHANNELKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHANNELKEY = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChannelKey",
			new String[] { String.class.getName() });

	/**
	 * Returns all the channel instances where channelKey = &#63;.
	 *
	 * @param channelKey the channel key
	 * @return the matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByChannelKey(String channelKey) {
		return findByChannelKey(channelKey, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where channelKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param channelKey the channel key
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByChannelKey(String channelKey, int start,
		int end) {
		return findByChannelKey(channelKey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where channelKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param channelKey the channel key
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByChannelKey(String channelKey, int start,
		int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return findByChannelKey(channelKey, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channel instances where channelKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param channelKey the channel key
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByChannelKey(String channelKey, int start,
		int end, OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHANNELKEY;
			finderArgs = new Object[] { channelKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHANNELKEY;
			finderArgs = new Object[] { channelKey, start, end, orderByComparator };
		}

		List<ChannelInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ChannelInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChannelInstance channelInstance : list) {
					if (!Validator.equals(channelKey,
								channelInstance.getChannelKey())) {
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

			query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

			boolean bindChannelKey = false;

			if (channelKey == null) {
				query.append(_FINDER_COLUMN_CHANNELKEY_CHANNELKEY_1);
			}
			else if (channelKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHANNELKEY_CHANNELKEY_3);
			}
			else {
				bindChannelKey = true;

				query.append(_FINDER_COLUMN_CHANNELKEY_CHANNELKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindChannelKey) {
					qPos.add(channelKey);
				}

				if (!pagination) {
					list = (List<ChannelInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where channelKey = &#63;.
	 *
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByChannelKey_First(String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByChannelKey_First(channelKey,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("channelKey=");
		msg.append(channelKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the first channel instance in the ordered set where channelKey = &#63;.
	 *
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByChannelKey_First(String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		List<ChannelInstance> list = findByChannelKey(channelKey, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel instance in the ordered set where channelKey = &#63;.
	 *
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByChannelKey_Last(String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByChannelKey_Last(channelKey,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("channelKey=");
		msg.append(channelKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the last channel instance in the ordered set where channelKey = &#63;.
	 *
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByChannelKey_Last(String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		int count = countByChannelKey(channelKey);

		if (count == 0) {
			return null;
		}

		List<ChannelInstance> list = findByChannelKey(channelKey, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel instances before and after the current channel instance in the ordered set where channelKey = &#63;.
	 *
	 * @param channelInstanceId the primary key of the current channel instance
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel instance
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance[] findByChannelKey_PrevAndNext(
		long channelInstanceId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = findByPrimaryKey(channelInstanceId);

		Session session = null;

		try {
			session = openSession();

			ChannelInstance[] array = new ChannelInstanceImpl[3];

			array[0] = getByChannelKey_PrevAndNext(session, channelInstance,
					channelKey, orderByComparator, true);

			array[1] = channelInstance;

			array[2] = getByChannelKey_PrevAndNext(session, channelInstance,
					channelKey, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChannelInstance getByChannelKey_PrevAndNext(Session session,
		ChannelInstance channelInstance, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

		boolean bindChannelKey = false;

		if (channelKey == null) {
			query.append(_FINDER_COLUMN_CHANNELKEY_CHANNELKEY_1);
		}
		else if (channelKey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CHANNELKEY_CHANNELKEY_3);
		}
		else {
			bindChannelKey = true;

			query.append(_FINDER_COLUMN_CHANNELKEY_CHANNELKEY_2);
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
			query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindChannelKey) {
			qPos.add(channelKey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(channelInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channel instances where channelKey = &#63; from the database.
	 *
	 * @param channelKey the channel key
	 */
	@Override
	public void removeByChannelKey(String channelKey) {
		for (ChannelInstance channelInstance : findByChannelKey(channelKey,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(channelInstance);
		}
	}

	/**
	 * Returns the number of channel instances where channelKey = &#63;.
	 *
	 * @param channelKey the channel key
	 * @return the number of matching channel instances
	 */
	@Override
	public int countByChannelKey(String channelKey) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHANNELKEY;

		Object[] finderArgs = new Object[] { channelKey };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHANNELINSTANCE_WHERE);

			boolean bindChannelKey = false;

			if (channelKey == null) {
				query.append(_FINDER_COLUMN_CHANNELKEY_CHANNELKEY_1);
			}
			else if (channelKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHANNELKEY_CHANNELKEY_3);
			}
			else {
				bindChannelKey = true;

				query.append(_FINDER_COLUMN_CHANNELKEY_CHANNELKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindChannelKey) {
					qPos.add(channelKey);
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

	private static final String _FINDER_COLUMN_CHANNELKEY_CHANNELKEY_1 = "channelInstance.channelKey IS NULL";
	private static final String _FINDER_COLUMN_CHANNELKEY_CHANNELKEY_2 = "channelInstance.channelKey = ?";
	private static final String _FINDER_COLUMN_CHANNELKEY_CHANNELKEY_3 = "(channelInstance.channelKey IS NULL OR channelInstance.channelKey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			ChannelInstanceModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			ChannelInstanceModelImpl.CHANNELKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the channel instances where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByCampaignId(long campaignId) {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByCampaignId(long campaignId, int start,
		int end) {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return findByCampaignId(campaignId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channel instances where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator<ChannelInstance> orderByComparator,
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

		List<ChannelInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ChannelInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChannelInstance channelInstance : list) {
					if ((campaignId != channelInstance.getCampaignId())) {
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

			query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<ChannelInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByCampaignId_First(long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByCampaignId_First(campaignId,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the first channel instance in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByCampaignId_First(long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		List<ChannelInstance> list = findByCampaignId(campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel instance in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByCampaignId_Last(long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByCampaignId_Last(campaignId,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the last channel instance in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByCampaignId_Last(long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<ChannelInstance> list = findByCampaignId(campaignId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel instances before and after the current channel instance in the ordered set where campaignId = &#63;.
	 *
	 * @param channelInstanceId the primary key of the current channel instance
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel instance
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance[] findByCampaignId_PrevAndNext(
		long channelInstanceId, long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = findByPrimaryKey(channelInstanceId);

		Session session = null;

		try {
			session = openSession();

			ChannelInstance[] array = new ChannelInstanceImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, channelInstance,
					campaignId, orderByComparator, true);

			array[1] = channelInstance;

			array[2] = getByCampaignId_PrevAndNext(session, channelInstance,
					campaignId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChannelInstance getByCampaignId_PrevAndNext(Session session,
		ChannelInstance channelInstance, long campaignId,
		OrderByComparator<ChannelInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

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
			query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(channelInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channel instances where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 */
	@Override
	public void removeByCampaignId(long campaignId) {
		for (ChannelInstance channelInstance : findByCampaignId(campaignId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(channelInstance);
		}
	}

	/**
	 * Returns the number of channel instances where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching channel instances
	 */
	@Override
	public int countByCampaignId(long campaignId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNID;

		Object[] finderArgs = new Object[] { campaignId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHANNELINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "channelInstance.campaignId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TACTICID = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTacticId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TACTICID =
		new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTacticId",
			new String[] { Long.class.getName() },
			ChannelInstanceModelImpl.TACTICID_COLUMN_BITMASK |
			ChannelInstanceModelImpl.CHANNELKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TACTICID = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTacticId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the channel instances where tacticId = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @return the matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByTacticId(long tacticId) {
		return findByTacticId(tacticId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the channel instances where tacticId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tacticId the tactic ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByTacticId(long tacticId, int start,
		int end) {
		return findByTacticId(tacticId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where tacticId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tacticId the tactic ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByTacticId(long tacticId, int start,
		int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return findByTacticId(tacticId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channel instances where tacticId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tacticId the tactic ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByTacticId(long tacticId, int start,
		int end, OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TACTICID;
			finderArgs = new Object[] { tacticId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TACTICID;
			finderArgs = new Object[] { tacticId, start, end, orderByComparator };
		}

		List<ChannelInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ChannelInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChannelInstance channelInstance : list) {
					if ((tacticId != channelInstance.getTacticId())) {
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

			query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_TACTICID_TACTICID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tacticId);

				if (!pagination) {
					list = (List<ChannelInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where tacticId = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByTacticId_First(long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByTacticId_First(tacticId,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tacticId=");
		msg.append(tacticId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the first channel instance in the ordered set where tacticId = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByTacticId_First(long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		List<ChannelInstance> list = findByTacticId(tacticId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel instance in the ordered set where tacticId = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByTacticId_Last(long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByTacticId_Last(tacticId,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tacticId=");
		msg.append(tacticId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the last channel instance in the ordered set where tacticId = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByTacticId_Last(long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator) {
		int count = countByTacticId(tacticId);

		if (count == 0) {
			return null;
		}

		List<ChannelInstance> list = findByTacticId(tacticId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel instances before and after the current channel instance in the ordered set where tacticId = &#63;.
	 *
	 * @param channelInstanceId the primary key of the current channel instance
	 * @param tacticId the tactic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel instance
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance[] findByTacticId_PrevAndNext(
		long channelInstanceId, long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = findByPrimaryKey(channelInstanceId);

		Session session = null;

		try {
			session = openSession();

			ChannelInstance[] array = new ChannelInstanceImpl[3];

			array[0] = getByTacticId_PrevAndNext(session, channelInstance,
					tacticId, orderByComparator, true);

			array[1] = channelInstance;

			array[2] = getByTacticId_PrevAndNext(session, channelInstance,
					tacticId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChannelInstance getByTacticId_PrevAndNext(Session session,
		ChannelInstance channelInstance, long tacticId,
		OrderByComparator<ChannelInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_TACTICID_TACTICID_2);

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
			query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tacticId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(channelInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channel instances where tacticId = &#63; from the database.
	 *
	 * @param tacticId the tactic ID
	 */
	@Override
	public void removeByTacticId(long tacticId) {
		for (ChannelInstance channelInstance : findByTacticId(tacticId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(channelInstance);
		}
	}

	/**
	 * Returns the number of channel instances where tacticId = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @return the number of matching channel instances
	 */
	@Override
	public int countByTacticId(long tacticId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TACTICID;

		Object[] finderArgs = new Object[] { tacticId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHANNELINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_TACTICID_TACTICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tacticId);

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

	private static final String _FINDER_COLUMN_TACTICID_TACTICID_2 = "channelInstance.tacticId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_K = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_K",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_K = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_K",
			new String[] { Long.class.getName(), String.class.getName() },
			ChannelInstanceModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			ChannelInstanceModelImpl.CHANNELKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_K = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_K",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the channel instances where campaignId = &#63; and channelKey = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 * @return the matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByC_K(long campaignId, String channelKey) {
		return findByC_K(campaignId, channelKey, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where campaignId = &#63; and channelKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByC_K(long campaignId, String channelKey,
		int start, int end) {
		return findByC_K(campaignId, channelKey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where campaignId = &#63; and channelKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByC_K(long campaignId, String channelKey,
		int start, int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return findByC_K(campaignId, channelKey, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the channel instances where campaignId = &#63; and channelKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByC_K(long campaignId, String channelKey,
		int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_K;
			finderArgs = new Object[] { campaignId, channelKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_K;
			finderArgs = new Object[] {
					campaignId, channelKey,
					
					start, end, orderByComparator
				};
		}

		List<ChannelInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ChannelInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChannelInstance channelInstance : list) {
					if ((campaignId != channelInstance.getCampaignId()) ||
							!Validator.equals(channelKey,
								channelInstance.getChannelKey())) {
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

			query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_K_CAMPAIGNID_2);

			boolean bindChannelKey = false;

			if (channelKey == null) {
				query.append(_FINDER_COLUMN_C_K_CHANNELKEY_1);
			}
			else if (channelKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_K_CHANNELKEY_3);
			}
			else {
				bindChannelKey = true;

				query.append(_FINDER_COLUMN_C_K_CHANNELKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindChannelKey) {
					qPos.add(channelKey);
				}

				if (!pagination) {
					list = (List<ChannelInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByC_K_First(long campaignId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByC_K_First(campaignId,
				channelKey, orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", channelKey=");
		msg.append(channelKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the first channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByC_K_First(long campaignId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		List<ChannelInstance> list = findByC_K(campaignId, channelKey, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByC_K_Last(long campaignId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByC_K_Last(campaignId,
				channelKey, orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", channelKey=");
		msg.append(channelKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the last channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByC_K_Last(long campaignId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		int count = countByC_K(campaignId, channelKey);

		if (count == 0) {
			return null;
		}

		List<ChannelInstance> list = findByC_K(campaignId, channelKey,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel instances before and after the current channel instance in the ordered set where campaignId = &#63; and channelKey = &#63;.
	 *
	 * @param channelInstanceId the primary key of the current channel instance
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel instance
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance[] findByC_K_PrevAndNext(long channelInstanceId,
		long campaignId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = findByPrimaryKey(channelInstanceId);

		Session session = null;

		try {
			session = openSession();

			ChannelInstance[] array = new ChannelInstanceImpl[3];

			array[0] = getByC_K_PrevAndNext(session, channelInstance,
					campaignId, channelKey, orderByComparator, true);

			array[1] = channelInstance;

			array[2] = getByC_K_PrevAndNext(session, channelInstance,
					campaignId, channelKey, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChannelInstance getByC_K_PrevAndNext(Session session,
		ChannelInstance channelInstance, long campaignId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_C_K_CAMPAIGNID_2);

		boolean bindChannelKey = false;

		if (channelKey == null) {
			query.append(_FINDER_COLUMN_C_K_CHANNELKEY_1);
		}
		else if (channelKey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_K_CHANNELKEY_3);
		}
		else {
			bindChannelKey = true;

			query.append(_FINDER_COLUMN_C_K_CHANNELKEY_2);
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
			query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (bindChannelKey) {
			qPos.add(channelKey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(channelInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channel instances where campaignId = &#63; and channelKey = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 */
	@Override
	public void removeByC_K(long campaignId, String channelKey) {
		for (ChannelInstance channelInstance : findByC_K(campaignId,
				channelKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(channelInstance);
		}
	}

	/**
	 * Returns the number of channel instances where campaignId = &#63; and channelKey = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param channelKey the channel key
	 * @return the number of matching channel instances
	 */
	@Override
	public int countByC_K(long campaignId, String channelKey) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_K;

		Object[] finderArgs = new Object[] { campaignId, channelKey };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHANNELINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_K_CAMPAIGNID_2);

			boolean bindChannelKey = false;

			if (channelKey == null) {
				query.append(_FINDER_COLUMN_C_K_CHANNELKEY_1);
			}
			else if (channelKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_K_CHANNELKEY_3);
			}
			else {
				bindChannelKey = true;

				query.append(_FINDER_COLUMN_C_K_CHANNELKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindChannelKey) {
					qPos.add(channelKey);
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

	private static final String _FINDER_COLUMN_C_K_CAMPAIGNID_2 = "channelInstance.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_K_CHANNELKEY_1 = "channelInstance.channelKey IS NULL";
	private static final String _FINDER_COLUMN_C_K_CHANNELKEY_2 = "channelInstance.channelKey = ?";
	private static final String _FINDER_COLUMN_C_K_CHANNELKEY_3 = "(channelInstance.channelKey IS NULL OR channelInstance.channelKey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_K = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByT_K",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_K = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_K",
			new String[] { Long.class.getName(), String.class.getName() },
			ChannelInstanceModelImpl.TACTICID_COLUMN_BITMASK |
			ChannelInstanceModelImpl.CHANNELKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_K = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_K",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the channel instances where tacticId = &#63; and channelKey = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 * @return the matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByT_K(long tacticId, String channelKey) {
		return findByT_K(tacticId, channelKey, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where tacticId = &#63; and channelKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByT_K(long tacticId, String channelKey,
		int start, int end) {
		return findByT_K(tacticId, channelKey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where tacticId = &#63; and channelKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByT_K(long tacticId, String channelKey,
		int start, int end, OrderByComparator<ChannelInstance> orderByComparator) {
		return findByT_K(tacticId, channelKey, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the channel instances where tacticId = &#63; and channelKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching channel instances
	 */
	@Override
	public List<ChannelInstance> findByT_K(long tacticId, String channelKey,
		int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_K;
			finderArgs = new Object[] { tacticId, channelKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_K;
			finderArgs = new Object[] {
					tacticId, channelKey,
					
					start, end, orderByComparator
				};
		}

		List<ChannelInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ChannelInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChannelInstance channelInstance : list) {
					if ((tacticId != channelInstance.getTacticId()) ||
							!Validator.equals(channelKey,
								channelInstance.getChannelKey())) {
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

			query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_T_K_TACTICID_2);

			boolean bindChannelKey = false;

			if (channelKey == null) {
				query.append(_FINDER_COLUMN_T_K_CHANNELKEY_1);
			}
			else if (channelKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_K_CHANNELKEY_3);
			}
			else {
				bindChannelKey = true;

				query.append(_FINDER_COLUMN_T_K_CHANNELKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tacticId);

				if (bindChannelKey) {
					qPos.add(channelKey);
				}

				if (!pagination) {
					list = (List<ChannelInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByT_K_First(long tacticId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByT_K_First(tacticId,
				channelKey, orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tacticId=");
		msg.append(tacticId);

		msg.append(", channelKey=");
		msg.append(channelKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the first channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByT_K_First(long tacticId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		List<ChannelInstance> list = findByT_K(tacticId, channelKey, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByT_K_Last(long tacticId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByT_K_Last(tacticId, channelKey,
				orderByComparator);

		if (channelInstance != null) {
			return channelInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tacticId=");
		msg.append(tacticId);

		msg.append(", channelKey=");
		msg.append(channelKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChannelInstanceException(msg.toString());
	}

	/**
	 * Returns the last channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByT_K_Last(long tacticId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator) {
		int count = countByT_K(tacticId, channelKey);

		if (count == 0) {
			return null;
		}

		List<ChannelInstance> list = findByT_K(tacticId, channelKey, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the channel instances before and after the current channel instance in the ordered set where tacticId = &#63; and channelKey = &#63;.
	 *
	 * @param channelInstanceId the primary key of the current channel instance
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel instance
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance[] findByT_K_PrevAndNext(long channelInstanceId,
		long tacticId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = findByPrimaryKey(channelInstanceId);

		Session session = null;

		try {
			session = openSession();

			ChannelInstance[] array = new ChannelInstanceImpl[3];

			array[0] = getByT_K_PrevAndNext(session, channelInstance, tacticId,
					channelKey, orderByComparator, true);

			array[1] = channelInstance;

			array[2] = getByT_K_PrevAndNext(session, channelInstance, tacticId,
					channelKey, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChannelInstance getByT_K_PrevAndNext(Session session,
		ChannelInstance channelInstance, long tacticId, String channelKey,
		OrderByComparator<ChannelInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_T_K_TACTICID_2);

		boolean bindChannelKey = false;

		if (channelKey == null) {
			query.append(_FINDER_COLUMN_T_K_CHANNELKEY_1);
		}
		else if (channelKey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_T_K_CHANNELKEY_3);
		}
		else {
			bindChannelKey = true;

			query.append(_FINDER_COLUMN_T_K_CHANNELKEY_2);
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
			query.append(ChannelInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tacticId);

		if (bindChannelKey) {
			qPos.add(channelKey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(channelInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChannelInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channel instances where tacticId = &#63; and channelKey = &#63; from the database.
	 *
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 */
	@Override
	public void removeByT_K(long tacticId, String channelKey) {
		for (ChannelInstance channelInstance : findByT_K(tacticId, channelKey,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(channelInstance);
		}
	}

	/**
	 * Returns the number of channel instances where tacticId = &#63; and channelKey = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param channelKey the channel key
	 * @return the number of matching channel instances
	 */
	@Override
	public int countByT_K(long tacticId, String channelKey) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_K;

		Object[] finderArgs = new Object[] { tacticId, channelKey };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHANNELINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_T_K_TACTICID_2);

			boolean bindChannelKey = false;

			if (channelKey == null) {
				query.append(_FINDER_COLUMN_T_K_CHANNELKEY_1);
			}
			else if (channelKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_K_CHANNELKEY_3);
			}
			else {
				bindChannelKey = true;

				query.append(_FINDER_COLUMN_T_K_CHANNELKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tacticId);

				if (bindChannelKey) {
					qPos.add(channelKey);
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

	private static final String _FINDER_COLUMN_T_K_TACTICID_2 = "channelInstance.tacticId = ? AND ";
	private static final String _FINDER_COLUMN_T_K_CHANNELKEY_1 = "channelInstance.channelKey IS NULL";
	private static final String _FINDER_COLUMN_T_K_CHANNELKEY_2 = "channelInstance.channelKey = ?";
	private static final String _FINDER_COLUMN_T_K_CHANNELKEY_3 = "(channelInstance.channelKey IS NULL OR channelInstance.channelKey = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_T_A = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED,
			ChannelInstanceImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByT_A",
			new String[] { Long.class.getName(), String.class.getName() },
			ChannelInstanceModelImpl.TACTICID_COLUMN_BITMASK |
			ChannelInstanceModelImpl.ALIAS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_A = new FinderPath(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_A",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the channel instance where tacticId = &#63; and alias = &#63; or throws a {@link NoSuchChannelInstanceException} if it could not be found.
	 *
	 * @param tacticId the tactic ID
	 * @param alias the alias
	 * @return the matching channel instance
	 * @throws NoSuchChannelInstanceException if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance findByT_A(long tacticId, String alias)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByT_A(tacticId, alias);

		if (channelInstance == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tacticId=");
			msg.append(tacticId);

			msg.append(", alias=");
			msg.append(alias);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchChannelInstanceException(msg.toString());
		}

		return channelInstance;
	}

	/**
	 * Returns the channel instance where tacticId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tacticId the tactic ID
	 * @param alias the alias
	 * @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByT_A(long tacticId, String alias) {
		return fetchByT_A(tacticId, alias, true);
	}

	/**
	 * Returns the channel instance where tacticId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tacticId the tactic ID
	 * @param alias the alias
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 */
	@Override
	public ChannelInstance fetchByT_A(long tacticId, String alias,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { tacticId, alias };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_T_A,
					finderArgs, this);
		}

		if (result instanceof ChannelInstance) {
			ChannelInstance channelInstance = (ChannelInstance)result;

			if ((tacticId != channelInstance.getTacticId()) ||
					!Validator.equals(alias, channelInstance.getAlias())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_T_A_TACTICID_2);

			boolean bindAlias = false;

			if (alias == null) {
				query.append(_FINDER_COLUMN_T_A_ALIAS_1);
			}
			else if (alias.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_A_ALIAS_3);
			}
			else {
				bindAlias = true;

				query.append(_FINDER_COLUMN_T_A_ALIAS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tacticId);

				if (bindAlias) {
					qPos.add(alias);
				}

				List<ChannelInstance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_T_A, finderArgs,
						list);
				}
				else {
					ChannelInstance channelInstance = list.get(0);

					result = channelInstance;

					cacheResult(channelInstance);

					if ((channelInstance.getTacticId() != tacticId) ||
							(channelInstance.getAlias() == null) ||
							!channelInstance.getAlias().equals(alias)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_T_A,
							finderArgs, channelInstance);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_T_A, finderArgs);

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
			return (ChannelInstance)result;
		}
	}

	/**
	 * Removes the channel instance where tacticId = &#63; and alias = &#63; from the database.
	 *
	 * @param tacticId the tactic ID
	 * @param alias the alias
	 * @return the channel instance that was removed
	 */
	@Override
	public ChannelInstance removeByT_A(long tacticId, String alias)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = findByT_A(tacticId, alias);

		return remove(channelInstance);
	}

	/**
	 * Returns the number of channel instances where tacticId = &#63; and alias = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param alias the alias
	 * @return the number of matching channel instances
	 */
	@Override
	public int countByT_A(long tacticId, String alias) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_A;

		Object[] finderArgs = new Object[] { tacticId, alias };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHANNELINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_T_A_TACTICID_2);

			boolean bindAlias = false;

			if (alias == null) {
				query.append(_FINDER_COLUMN_T_A_ALIAS_1);
			}
			else if (alias.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_A_ALIAS_3);
			}
			else {
				bindAlias = true;

				query.append(_FINDER_COLUMN_T_A_ALIAS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tacticId);

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

	private static final String _FINDER_COLUMN_T_A_TACTICID_2 = "channelInstance.tacticId = ? AND ";
	private static final String _FINDER_COLUMN_T_A_ALIAS_1 = "channelInstance.alias IS NULL";
	private static final String _FINDER_COLUMN_T_A_ALIAS_2 = "channelInstance.alias = ?";
	private static final String _FINDER_COLUMN_T_A_ALIAS_3 = "(channelInstance.alias IS NULL OR channelInstance.alias = '')";

	public ChannelInstancePersistenceImpl() {
		setModelClass(ChannelInstance.class);
	}

	/**
	 * Caches the channel instance in the entity cache if it is enabled.
	 *
	 * @param channelInstance the channel instance
	 */
	@Override
	public void cacheResult(ChannelInstance channelInstance) {
		entityCache.putResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceImpl.class, channelInstance.getPrimaryKey(),
			channelInstance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { channelInstance.getUuid(), channelInstance.getGroupId() },
			channelInstance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_T_A,
			new Object[] {
				channelInstance.getTacticId(), channelInstance.getAlias()
			}, channelInstance);

		channelInstance.resetOriginalValues();
	}

	/**
	 * Caches the channel instances in the entity cache if it is enabled.
	 *
	 * @param channelInstances the channel instances
	 */
	@Override
	public void cacheResult(List<ChannelInstance> channelInstances) {
		for (ChannelInstance channelInstance : channelInstances) {
			if (entityCache.getResult(
						ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ChannelInstanceImpl.class,
						channelInstance.getPrimaryKey()) == null) {
				cacheResult(channelInstance);
			}
			else {
				channelInstance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all channel instances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChannelInstanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the channel instance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChannelInstance channelInstance) {
		entityCache.removeResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceImpl.class, channelInstance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ChannelInstanceModelImpl)channelInstance);
	}

	@Override
	public void clearCache(List<ChannelInstance> channelInstances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChannelInstance channelInstance : channelInstances) {
			entityCache.removeResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ChannelInstanceImpl.class, channelInstance.getPrimaryKey());

			clearUniqueFindersCache((ChannelInstanceModelImpl)channelInstance);
		}
	}

	protected void cacheUniqueFindersCache(
		ChannelInstanceModelImpl channelInstanceModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					channelInstanceModelImpl.getUuid(),
					channelInstanceModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				channelInstanceModelImpl);

			args = new Object[] {
					channelInstanceModelImpl.getTacticId(),
					channelInstanceModelImpl.getAlias()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_T_A, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_T_A, args,
				channelInstanceModelImpl);
		}
		else {
			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getUuid(),
						channelInstanceModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					channelInstanceModelImpl);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_T_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getTacticId(),
						channelInstanceModelImpl.getAlias()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_T_A, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_T_A, args,
					channelInstanceModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ChannelInstanceModelImpl channelInstanceModelImpl) {
		Object[] args = new Object[] {
				channelInstanceModelImpl.getUuid(),
				channelInstanceModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((channelInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					channelInstanceModelImpl.getOriginalUuid(),
					channelInstanceModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				channelInstanceModelImpl.getTacticId(),
				channelInstanceModelImpl.getAlias()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_T_A, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_T_A, args);

		if ((channelInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_T_A.getColumnBitmask()) != 0) {
			args = new Object[] {
					channelInstanceModelImpl.getOriginalTacticId(),
					channelInstanceModelImpl.getOriginalAlias()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_T_A, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_T_A, args);
		}
	}

	/**
	 * Creates a new channel instance with the primary key. Does not add the channel instance to the database.
	 *
	 * @param channelInstanceId the primary key for the new channel instance
	 * @return the new channel instance
	 */
	@Override
	public ChannelInstance create(long channelInstanceId) {
		ChannelInstance channelInstance = new ChannelInstanceImpl();

		channelInstance.setNew(true);
		channelInstance.setPrimaryKey(channelInstanceId);

		String uuid = PortalUUIDUtil.generate();

		channelInstance.setUuid(uuid);

		channelInstance.setCompanyId(companyProvider.getCompanyId());

		return channelInstance;
	}

	/**
	 * Removes the channel instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param channelInstanceId the primary key of the channel instance
	 * @return the channel instance that was removed
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance remove(long channelInstanceId)
		throws NoSuchChannelInstanceException {
		return remove((Serializable)channelInstanceId);
	}

	/**
	 * Removes the channel instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the channel instance
	 * @return the channel instance that was removed
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance remove(Serializable primaryKey)
		throws NoSuchChannelInstanceException {
		Session session = null;

		try {
			session = openSession();

			ChannelInstance channelInstance = (ChannelInstance)session.get(ChannelInstanceImpl.class,
					primaryKey);

			if (channelInstance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChannelInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(channelInstance);
		}
		catch (NoSuchChannelInstanceException nsee) {
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
	protected ChannelInstance removeImpl(ChannelInstance channelInstance) {
		channelInstance = toUnwrappedModel(channelInstance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(channelInstance)) {
				channelInstance = (ChannelInstance)session.get(ChannelInstanceImpl.class,
						channelInstance.getPrimaryKeyObj());
			}

			if (channelInstance != null) {
				session.delete(channelInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (channelInstance != null) {
			clearCache(channelInstance);
		}

		return channelInstance;
	}

	@Override
	public ChannelInstance updateImpl(ChannelInstance channelInstance) {
		channelInstance = toUnwrappedModel(channelInstance);

		boolean isNew = channelInstance.isNew();

		ChannelInstanceModelImpl channelInstanceModelImpl = (ChannelInstanceModelImpl)channelInstance;

		if (Validator.isNull(channelInstance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			channelInstance.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (channelInstance.getCreateDate() == null)) {
			if (serviceContext == null) {
				channelInstance.setCreateDate(now);
			}
			else {
				channelInstance.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!channelInstanceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				channelInstance.setModifiedDate(now);
			}
			else {
				channelInstance.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (channelInstance.isNew()) {
				session.save(channelInstance);

				channelInstance.setNew(false);
			}
			else {
				channelInstance = (ChannelInstance)session.merge(channelInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ChannelInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { channelInstanceModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalUuid(),
						channelInstanceModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						channelInstanceModelImpl.getUuid(),
						channelInstanceModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { channelInstanceModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHANNELKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalChannelKey()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CHANNELKEY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHANNELKEY,
					args);

				args = new Object[] { channelInstanceModelImpl.getChannelKey() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CHANNELKEY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHANNELKEY,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalCampaignId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { channelInstanceModelImpl.getCampaignId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TACTICID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalTacticId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TACTICID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TACTICID,
					args);

				args = new Object[] { channelInstanceModelImpl.getTacticId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TACTICID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TACTICID,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_K.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalCampaignId(),
						channelInstanceModelImpl.getOriginalChannelKey()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_K, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_K,
					args);

				args = new Object[] {
						channelInstanceModelImpl.getCampaignId(),
						channelInstanceModelImpl.getChannelKey()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_K, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_K,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_K.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalTacticId(),
						channelInstanceModelImpl.getOriginalChannelKey()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_T_K, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_K,
					args);

				args = new Object[] {
						channelInstanceModelImpl.getTacticId(),
						channelInstanceModelImpl.getChannelKey()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_T_K, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_K,
					args);
			}
		}

		entityCache.putResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceImpl.class, channelInstance.getPrimaryKey(),
			channelInstance, false);

		clearUniqueFindersCache(channelInstanceModelImpl);
		cacheUniqueFindersCache(channelInstanceModelImpl, isNew);

		channelInstance.resetOriginalValues();

		return channelInstance;
	}

	protected ChannelInstance toUnwrappedModel(ChannelInstance channelInstance) {
		if (channelInstance instanceof ChannelInstanceImpl) {
			return channelInstance;
		}

		ChannelInstanceImpl channelInstanceImpl = new ChannelInstanceImpl();

		channelInstanceImpl.setNew(channelInstance.isNew());
		channelInstanceImpl.setPrimaryKey(channelInstance.getPrimaryKey());

		channelInstanceImpl.setUuid(channelInstance.getUuid());
		channelInstanceImpl.setChannelInstanceId(channelInstance.getChannelInstanceId());
		channelInstanceImpl.setGroupId(channelInstance.getGroupId());
		channelInstanceImpl.setCompanyId(channelInstance.getCompanyId());
		channelInstanceImpl.setUserId(channelInstance.getUserId());
		channelInstanceImpl.setUserName(channelInstance.getUserName());
		channelInstanceImpl.setCreateDate(channelInstance.getCreateDate());
		channelInstanceImpl.setModifiedDate(channelInstance.getModifiedDate());
		channelInstanceImpl.setChannelKey(channelInstance.getChannelKey());
		channelInstanceImpl.setCampaignId(channelInstance.getCampaignId());
		channelInstanceImpl.setTacticId(channelInstance.getTacticId());
		channelInstanceImpl.setAlias(channelInstance.getAlias());
		channelInstanceImpl.setTypeSettings(channelInstance.getTypeSettings());

		return channelInstanceImpl;
	}

	/**
	 * Returns the channel instance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the channel instance
	 * @return the channel instance
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChannelInstanceException {
		ChannelInstance channelInstance = fetchByPrimaryKey(primaryKey);

		if (channelInstance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChannelInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return channelInstance;
	}

	/**
	 * Returns the channel instance with the primary key or throws a {@link NoSuchChannelInstanceException} if it could not be found.
	 *
	 * @param channelInstanceId the primary key of the channel instance
	 * @return the channel instance
	 * @throws NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance findByPrimaryKey(long channelInstanceId)
		throws NoSuchChannelInstanceException {
		return findByPrimaryKey((Serializable)channelInstanceId);
	}

	/**
	 * Returns the channel instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the channel instance
	 * @return the channel instance, or <code>null</code> if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance fetchByPrimaryKey(Serializable primaryKey) {
		ChannelInstance channelInstance = (ChannelInstance)entityCache.getResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ChannelInstanceImpl.class, primaryKey);

		if (channelInstance == _nullChannelInstance) {
			return null;
		}

		if (channelInstance == null) {
			Session session = null;

			try {
				session = openSession();

				channelInstance = (ChannelInstance)session.get(ChannelInstanceImpl.class,
						primaryKey);

				if (channelInstance != null) {
					cacheResult(channelInstance);
				}
				else {
					entityCache.putResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ChannelInstanceImpl.class, primaryKey,
						_nullChannelInstance);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
					ChannelInstanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return channelInstance;
	}

	/**
	 * Returns the channel instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param channelInstanceId the primary key of the channel instance
	 * @return the channel instance, or <code>null</code> if a channel instance with the primary key could not be found
	 */
	@Override
	public ChannelInstance fetchByPrimaryKey(long channelInstanceId) {
		return fetchByPrimaryKey((Serializable)channelInstanceId);
	}

	@Override
	public Map<Serializable, ChannelInstance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ChannelInstance> map = new HashMap<Serializable, ChannelInstance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ChannelInstance channelInstance = fetchByPrimaryKey(primaryKey);

			if (channelInstance != null) {
				map.put(primaryKey, channelInstance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			ChannelInstance channelInstance = (ChannelInstance)entityCache.getResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
					ChannelInstanceImpl.class, primaryKey);

			if (channelInstance == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, channelInstance);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CHANNELINSTANCE_WHERE_PKS_IN);

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

			for (ChannelInstance channelInstance : (List<ChannelInstance>)q.list()) {
				map.put(channelInstance.getPrimaryKeyObj(), channelInstance);

				cacheResult(channelInstance);

				uncachedPrimaryKeys.remove(channelInstance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
					ChannelInstanceImpl.class, primaryKey, _nullChannelInstance);
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
	 * Returns all the channel instances.
	 *
	 * @return the channel instances
	 */
	@Override
	public List<ChannelInstance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of channel instances
	 */
	@Override
	public List<ChannelInstance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of channel instances
	 */
	@Override
	public List<ChannelInstance> findAll(int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the channel instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of channel instances
	 */
	@Override
	public List<ChannelInstance> findAll(int start, int end,
		OrderByComparator<ChannelInstance> orderByComparator,
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

		List<ChannelInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ChannelInstance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CHANNELINSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHANNELINSTANCE;

				if (pagination) {
					sql = sql.concat(ChannelInstanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ChannelInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Removes all the channel instances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChannelInstance channelInstance : findAll()) {
			remove(channelInstance);
		}
	}

	/**
	 * Returns the number of channel instances.
	 *
	 * @return the number of channel instances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHANNELINSTANCE);

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
		return ChannelInstanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the channel instance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ChannelInstanceImpl.class.getName());
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
	private static final String _SQL_SELECT_CHANNELINSTANCE = "SELECT channelInstance FROM ChannelInstance channelInstance";
	private static final String _SQL_SELECT_CHANNELINSTANCE_WHERE_PKS_IN = "SELECT channelInstance FROM ChannelInstance channelInstance WHERE channelInstanceId IN (";
	private static final String _SQL_SELECT_CHANNELINSTANCE_WHERE = "SELECT channelInstance FROM ChannelInstance channelInstance WHERE ";
	private static final String _SQL_COUNT_CHANNELINSTANCE = "SELECT COUNT(channelInstance) FROM ChannelInstance channelInstance";
	private static final String _SQL_COUNT_CHANNELINSTANCE_WHERE = "SELECT COUNT(channelInstance) FROM ChannelInstance channelInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "channelInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChannelInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChannelInstance exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ChannelInstancePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "alias"
			});
	private static final ChannelInstance _nullChannelInstance = new ChannelInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChannelInstance> toCacheModel() {
				return _nullChannelInstanceCacheModel;
			}
		};

	private static final CacheModel<ChannelInstance> _nullChannelInstanceCacheModel =
		new CacheModel<ChannelInstance>() {
			@Override
			public ChannelInstance toEntityModel() {
				return _nullChannelInstance;
			}
		};
}