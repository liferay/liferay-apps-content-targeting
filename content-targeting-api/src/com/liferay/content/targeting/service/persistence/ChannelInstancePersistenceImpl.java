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

import com.liferay.content.targeting.NoSuchChannelInstanceException;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.impl.ChannelInstanceImpl;
import com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl;

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
 * The persistence implementation for the channel instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChannelInstancePersistence
 * @see ChannelInstanceUtil
 * @generated
 */
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<ChannelInstance> list = (List<ChannelInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChannelInstance channelInstance : list) {
				if (!Validator.equals(uuid, channelInstance.getUuid())) {
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

					list = new UnmodifiableList<ChannelInstance>(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance[] findByUuid_PrevAndNext(long channelInstanceId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
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
	 * Returns the channel instance where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.content.targeting.NoSuchChannelInstanceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching channel instance
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the channel instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching channel instance, or <code>null</code> if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
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
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ChannelInstance channelInstance = list.get(0);

					result = channelInstance;

					cacheResult(channelInstance);

					if ((channelInstance.getUuid() == null) ||
							!channelInstance.getUuid().equals(uuid) ||
							(channelInstance.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, channelInstance);
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
			return (ChannelInstance)result;
		}
	}

	/**
	 * Removes the channel instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the channel instance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchChannelInstanceException, SystemException {
		ChannelInstance channelInstance = findByUUID_G(uuid, groupId);

		return remove(channelInstance);
	}

	/**
	 * Returns the number of channel instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching channel instances
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
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

		List<ChannelInstance> list = (List<ChannelInstance>)FinderCacheUtil.getResult(finderPath,
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

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
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

					list = new UnmodifiableList<ChannelInstance>(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance[] findByUuid_C_PrevAndNext(long channelInstanceId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByGroupId(long groupId, int start,
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

		List<ChannelInstance> list = (List<ChannelInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChannelInstance channelInstance : list) {
				if ((groupId != channelInstance.getGroupId())) {
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

					list = new UnmodifiableList<ChannelInstance>(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance[] findByGroupId_PrevAndNext(long channelInstanceId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "channelInstance.groupId = ?";
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByCampaignId(long campaignId)
		throws SystemException {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByCampaignId(long campaignId, int start,
		int end) throws SystemException {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ChannelInstance> list = (List<ChannelInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChannelInstance channelInstance : list) {
				if ((campaignId != channelInstance.getCampaignId())) {
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

					list = new UnmodifiableList<ChannelInstance>(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance[] findByCampaignId_PrevAndNext(
		long channelInstanceId, long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long campaignId) throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByTacticId(long tacticId)
		throws SystemException {
		return findByTacticId(tacticId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the channel instances where tacticId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tacticId the tactic ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of matching channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByTacticId(long tacticId, int start,
		int end) throws SystemException {
		return findByTacticId(tacticId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances where tacticId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tacticId the tactic ID
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findByTacticId(long tacticId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ChannelInstance> list = (List<ChannelInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChannelInstance channelInstance : list) {
				if ((tacticId != channelInstance.getTacticId())) {
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

					list = new UnmodifiableList<ChannelInstance>(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Returns the first channel instance in the ordered set where tacticId = &#63;.
	 *
	 * @param tacticId the tactic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel instance
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByTacticId_First(long tacticId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByTacticId_First(long tacticId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a matching channel instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByTacticId_Last(long tacticId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByTacticId_Last(long tacticId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance[] findByTacticId_PrevAndNext(
		long channelInstanceId, long tacticId,
		OrderByComparator orderByComparator)
		throws NoSuchChannelInstanceException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTacticId(long tacticId) throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTacticId(long tacticId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TACTICID;

		Object[] finderArgs = new Object[] { tacticId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

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

	private static final String _FINDER_COLUMN_TACTICID_TACTICID_2 = "channelInstance.tacticId = ?";

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
		EntityCacheUtil.putResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceImpl.class, channelInstance.getPrimaryKey(),
			channelInstance);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { channelInstance.getUuid(), channelInstance.getGroupId() },
			channelInstance);

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
			if (EntityCacheUtil.getResult(
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
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChannelInstanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChannelInstanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the channel instance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChannelInstance channelInstance) {
		EntityCacheUtil.removeResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceImpl.class, channelInstance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(channelInstance);
	}

	@Override
	public void clearCache(List<ChannelInstance> channelInstances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChannelInstance channelInstance : channelInstances) {
			EntityCacheUtil.removeResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ChannelInstanceImpl.class, channelInstance.getPrimaryKey());

			clearUniqueFindersCache(channelInstance);
		}
	}

	protected void cacheUniqueFindersCache(ChannelInstance channelInstance) {
		if (channelInstance.isNew()) {
			Object[] args = new Object[] {
					channelInstance.getUuid(), channelInstance.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				channelInstance);
		}
		else {
			ChannelInstanceModelImpl channelInstanceModelImpl = (ChannelInstanceModelImpl)channelInstance;

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstance.getUuid(), channelInstance.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					channelInstance);
			}
		}
	}

	protected void clearUniqueFindersCache(ChannelInstance channelInstance) {
		ChannelInstanceModelImpl channelInstanceModelImpl = (ChannelInstanceModelImpl)channelInstance;

		Object[] args = new Object[] {
				channelInstance.getUuid(), channelInstance.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((channelInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					channelInstanceModelImpl.getOriginalUuid(),
					channelInstanceModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
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

		return channelInstance;
	}

	/**
	 * Removes the channel instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param channelInstanceId the primary key of the channel instance
	 * @return the channel instance that was removed
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance remove(long channelInstanceId)
		throws NoSuchChannelInstanceException, SystemException {
		return remove((Serializable)channelInstanceId);
	}

	/**
	 * Removes the channel instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the channel instance
	 * @return the channel instance that was removed
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance remove(Serializable primaryKey)
		throws NoSuchChannelInstanceException, SystemException {
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
	protected ChannelInstance removeImpl(ChannelInstance channelInstance)
		throws SystemException {
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
	public ChannelInstance updateImpl(
		com.liferay.content.targeting.model.ChannelInstance channelInstance)
		throws SystemException {
		channelInstance = toUnwrappedModel(channelInstance);

		boolean isNew = channelInstance.isNew();

		ChannelInstanceModelImpl channelInstanceModelImpl = (ChannelInstanceModelImpl)channelInstance;

		if (Validator.isNull(channelInstance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			channelInstance.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (channelInstance.isNew()) {
				session.save(channelInstance);

				channelInstance.setNew(false);
			}
			else {
				session.merge(channelInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ChannelInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { channelInstanceModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalUuid(),
						channelInstanceModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						channelInstanceModelImpl.getUuid(),
						channelInstanceModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { channelInstanceModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { channelInstanceModelImpl.getCampaignId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((channelInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TACTICID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						channelInstanceModelImpl.getOriginalTacticId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TACTICID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TACTICID,
					args);

				args = new Object[] { channelInstanceModelImpl.getTacticId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TACTICID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TACTICID,
					args);
			}
		}

		EntityCacheUtil.putResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ChannelInstanceImpl.class, channelInstance.getPrimaryKey(),
			channelInstance);

		clearUniqueFindersCache(channelInstance);
		cacheUniqueFindersCache(channelInstance);

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
	 * Returns the channel instance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the channel instance
	 * @return the channel instance
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChannelInstanceException, SystemException {
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
	 * Returns the channel instance with the primary key or throws a {@link com.liferay.content.targeting.NoSuchChannelInstanceException} if it could not be found.
	 *
	 * @param channelInstanceId the primary key of the channel instance
	 * @return the channel instance
	 * @throws com.liferay.content.targeting.NoSuchChannelInstanceException if a channel instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance findByPrimaryKey(long channelInstanceId)
		throws NoSuchChannelInstanceException, SystemException {
		return findByPrimaryKey((Serializable)channelInstanceId);
	}

	/**
	 * Returns the channel instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the channel instance
	 * @return the channel instance, or <code>null</code> if a channel instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ChannelInstance channelInstance = (ChannelInstance)EntityCacheUtil.getResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
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
					EntityCacheUtil.putResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ChannelInstanceImpl.class, primaryKey,
						_nullChannelInstance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ChannelInstanceModelImpl.ENTITY_CACHE_ENABLED,
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChannelInstance fetchByPrimaryKey(long channelInstanceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)channelInstanceId);
	}

	/**
	 * Returns all the channel instances.
	 *
	 * @return the channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the channel instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @return the range of channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the channel instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ChannelInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of channel instances
	 * @param end the upper bound of the range of channel instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of channel instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChannelInstance> findAll(int start, int end,
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

		List<ChannelInstance> list = (List<ChannelInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

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

					list = new UnmodifiableList<ChannelInstance>(list);
				}
				else {
					list = (List<ChannelInstance>)QueryUtil.list(q,
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
	 * Removes all the channel instances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ChannelInstance channelInstance : findAll()) {
			remove(channelInstance);
		}
	}

	/**
	 * Returns the number of channel instances.
	 *
	 * @return the number of channel instances
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

				Query q = session.createQuery(_SQL_COUNT_CHANNELINSTANCE);

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
	 * Initializes the channel instance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.model.ChannelInstance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChannelInstance>> listenersList = new ArrayList<ModelListener<ChannelInstance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChannelInstance>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChannelInstanceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CHANNELINSTANCE = "SELECT channelInstance FROM ChannelInstance channelInstance";
	private static final String _SQL_SELECT_CHANNELINSTANCE_WHERE = "SELECT channelInstance FROM ChannelInstance channelInstance WHERE ";
	private static final String _SQL_COUNT_CHANNELINSTANCE = "SELECT COUNT(channelInstance) FROM ChannelInstance channelInstance";
	private static final String _SQL_COUNT_CHANNELINSTANCE_WHERE = "SELECT COUNT(channelInstance) FROM ChannelInstance channelInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "channelInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChannelInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChannelInstance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChannelInstancePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "alias"
			});
	private static ChannelInstance _nullChannelInstance = new ChannelInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChannelInstance> toCacheModel() {
				return _nullChannelInstanceCacheModel;
			}
		};

	private static CacheModel<ChannelInstance> _nullChannelInstanceCacheModel = new CacheModel<ChannelInstance>() {
			@Override
			public ChannelInstance toEntityModel() {
				return _nullChannelInstance;
			}
		};
}