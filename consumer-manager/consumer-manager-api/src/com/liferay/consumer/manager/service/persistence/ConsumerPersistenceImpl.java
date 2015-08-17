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

package com.liferay.consumer.manager.service.persistence;

import com.liferay.consumer.manager.NoSuchConsumerException;
import com.liferay.consumer.manager.model.Consumer;
import com.liferay.consumer.manager.model.impl.ConsumerImpl;
import com.liferay.consumer.manager.model.impl.ConsumerModelImpl;

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
import com.liferay.portal.kernel.util.ArrayUtil;
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
 * The persistence implementation for the consumer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerPersistence
 * @see ConsumerUtil
 * @generated
 */
public class ConsumerPersistenceImpl extends BasePersistenceImpl<Consumer>
	implements ConsumerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConsumerUtil} to access the consumer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConsumerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ConsumerModelImpl.UUID_COLUMN_BITMASK |
			ConsumerModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the consumers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @return the range of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByUuid(String uuid, int start, int end,
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

		List<Consumer> list = (List<Consumer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Consumer consumer : list) {
				if (!Validator.equals(uuid, consumer.getUuid())) {
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

			query.append(_SQL_SELECT_CONSUMER_WHERE);

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
				query.append(ConsumerModelImpl.ORDER_BY_JPQL);
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
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Consumer>(list);
				}
				else {
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first consumer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = fetchByUuid_First(uuid, orderByComparator);

		if (consumer != null) {
			return consumer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerException(msg.toString());
	}

	/**
	 * Returns the first consumer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer, or <code>null</code> if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Consumer> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = fetchByUuid_Last(uuid, orderByComparator);

		if (consumer != null) {
			return consumer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerException(msg.toString());
	}

	/**
	 * Returns the last consumer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer, or <code>null</code> if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Consumer> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumers before and after the current consumer in the ordered set where uuid = &#63;.
	 *
	 * @param consumerId the primary key of the current consumer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer[] findByUuid_PrevAndNext(long consumerId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = findByPrimaryKey(consumerId);

		Session session = null;

		try {
			session = openSession();

			Consumer[] array = new ConsumerImpl[3];

			array[0] = getByUuid_PrevAndNext(session, consumer, uuid,
					orderByComparator, true);

			array[1] = consumer;

			array[2] = getByUuid_PrevAndNext(session, consumer, uuid,
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

	protected Consumer getByUuid_PrevAndNext(Session session,
		Consumer consumer, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMER_WHERE);

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
			query.append(ConsumerModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(consumer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Consumer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Consumer consumer : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(consumer);
		}
	}

	/**
	 * Returns the number of consumers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching consumers
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

			query.append(_SQL_COUNT_CONSUMER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "consumer.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "consumer.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(consumer.uuid IS NULL OR consumer.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ConsumerModelImpl.UUID_COLUMN_BITMASK |
			ConsumerModelImpl.COMPANYID_COLUMN_BITMASK |
			ConsumerModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the consumers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @return the range of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<Consumer> list = (List<Consumer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Consumer consumer : list) {
				if (!Validator.equals(uuid, consumer.getUuid()) ||
						(companyId != consumer.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONSUMER_WHERE);

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
				query.append(ConsumerModelImpl.ORDER_BY_JPQL);
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
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Consumer>(list);
				}
				else {
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first consumer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (consumer != null) {
			return consumer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerException(msg.toString());
	}

	/**
	 * Returns the first consumer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer, or <code>null</code> if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Consumer> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (consumer != null) {
			return consumer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerException(msg.toString());
	}

	/**
	 * Returns the last consumer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer, or <code>null</code> if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Consumer> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumers before and after the current consumer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param consumerId the primary key of the current consumer
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer[] findByUuid_C_PrevAndNext(long consumerId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = findByPrimaryKey(consumerId);

		Session session = null;

		try {
			session = openSession();

			Consumer[] array = new ConsumerImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, consumer, uuid,
					companyId, orderByComparator, true);

			array[1] = consumer;

			array[2] = getByUuid_C_PrevAndNext(session, consumer, uuid,
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

	protected Consumer getByUuid_C_PrevAndNext(Session session,
		Consumer consumer, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMER_WHERE);

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
			query.append(ConsumerModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(consumer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Consumer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Consumer consumer : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumer);
		}
	}

	/**
	 * Returns the number of consumers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching consumers
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

			query.append(_SQL_COUNT_CONSUMER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "consumer.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "consumer.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(consumer.uuid IS NULL OR consumer.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "consumer.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			ConsumerModelImpl.COMPANYID_COLUMN_BITMASK |
			ConsumerModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the consumers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the consumers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @return the range of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Consumer> list = (List<Consumer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Consumer consumer : list) {
				if ((companyId != consumer.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONSUMER_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Consumer>(list);
				}
				else {
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first consumer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = fetchByCompanyId_First(companyId, orderByComparator);

		if (consumer != null) {
			return consumer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerException(msg.toString());
	}

	/**
	 * Returns the first consumer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer, or <code>null</code> if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Consumer> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = fetchByCompanyId_Last(companyId, orderByComparator);

		if (consumer != null) {
			return consumer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerException(msg.toString());
	}

	/**
	 * Returns the last consumer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer, or <code>null</code> if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Consumer> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumers before and after the current consumer in the ordered set where companyId = &#63;.
	 *
	 * @param consumerId the primary key of the current consumer
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer[] findByCompanyId_PrevAndNext(long consumerId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = findByPrimaryKey(consumerId);

		Session session = null;

		try {
			session = openSession();

			Consumer[] array = new ConsumerImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, consumer, companyId,
					orderByComparator, true);

			array[1] = consumer;

			array[2] = getByCompanyId_PrevAndNext(session, consumer, companyId,
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

	protected Consumer getByCompanyId_PrevAndNext(Session session,
		Consumer consumer, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMER_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(ConsumerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(consumer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Consumer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumers where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Consumer consumer : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(consumer);
		}
	}

	/**
	 * Returns the number of consumers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONSUMER_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "consumer.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_C = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_C",
			new String[] { Long.class.getName(), String.class.getName() },
			ConsumerModelImpl.COMPANYID_COLUMN_BITMASK |
			ConsumerModelImpl.CONSUMERKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the consumer where companyId = &#63; and consumerKey = &#63; or throws a {@link com.liferay.consumer.manager.NoSuchConsumerException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param consumerKey the consumer key
	 * @return the matching consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByC_C(long companyId, String consumerKey)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = fetchByC_C(companyId, consumerKey);

		if (consumer == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", consumerKey=");
			msg.append(consumerKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchConsumerException(msg.toString());
		}

		return consumer;
	}

	/**
	 * Returns the consumer where companyId = &#63; and consumerKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param consumerKey the consumer key
	 * @return the matching consumer, or <code>null</code> if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByC_C(long companyId, String consumerKey)
		throws SystemException {
		return fetchByC_C(companyId, consumerKey, true);
	}

	/**
	 * Returns the consumer where companyId = &#63; and consumerKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param consumerKey the consumer key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching consumer, or <code>null</code> if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByC_C(long companyId, String consumerKey,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, consumerKey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_C,
					finderArgs, this);
		}

		if (result instanceof Consumer) {
			Consumer consumer = (Consumer)result;

			if ((companyId != consumer.getCompanyId()) ||
					!Validator.equals(consumerKey, consumer.getConsumerKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONSUMER_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

			boolean bindConsumerKey = false;

			if (consumerKey == null) {
				query.append(_FINDER_COLUMN_C_C_CONSUMERKEY_1);
			}
			else if (consumerKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_CONSUMERKEY_3);
			}
			else {
				bindConsumerKey = true;

				query.append(_FINDER_COLUMN_C_C_CONSUMERKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindConsumerKey) {
					qPos.add(consumerKey);
				}

				List<Consumer> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
						finderArgs, list);
				}
				else {
					Consumer consumer = list.get(0);

					result = consumer;

					cacheResult(consumer);

					if ((consumer.getCompanyId() != companyId) ||
							(consumer.getConsumerKey() == null) ||
							!consumer.getConsumerKey().equals(consumerKey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
							finderArgs, consumer);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C,
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
			return (Consumer)result;
		}
	}

	/**
	 * Removes the consumer where companyId = &#63; and consumerKey = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param consumerKey the consumer key
	 * @return the consumer that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer removeByC_C(long companyId, String consumerKey)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = findByC_C(companyId, consumerKey);

		return remove(consumer);
	}

	/**
	 * Returns the number of consumers where companyId = &#63; and consumerKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerKey the consumer key
	 * @return the number of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C(long companyId, String consumerKey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C;

		Object[] finderArgs = new Object[] { companyId, consumerKey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONSUMER_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

			boolean bindConsumerKey = false;

			if (consumerKey == null) {
				query.append(_FINDER_COLUMN_C_C_CONSUMERKEY_1);
			}
			else if (consumerKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_CONSUMERKEY_3);
			}
			else {
				bindConsumerKey = true;

				query.append(_FINDER_COLUMN_C_C_CONSUMERKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindConsumerKey) {
					qPos.add(consumerKey);
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

	private static final String _FINDER_COLUMN_C_C_COMPANYID_2 = "consumer.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CONSUMERKEY_1 = "consumer.consumerKey IS NULL";
	private static final String _FINDER_COLUMN_C_C_CONSUMERKEY_2 = "consumer.consumerKey = ?";
	private static final String _FINDER_COLUMN_C_C_CONSUMERKEY_3 = "(consumer.consumerKey IS NULL OR consumer.consumerKey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONSUMERIDS =
		new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConsumerIds",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERIDS =
		new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, ConsumerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConsumerIds",
			new String[] { Long.class.getName() },
			ConsumerModelImpl.CONSUMERID_COLUMN_BITMASK |
			ConsumerModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONSUMERIDS = new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConsumerIds",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CONSUMERIDS =
		new FinderPath(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByConsumerIds",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the consumers where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByConsumerIds(long consumerId)
		throws SystemException {
		return findByConsumerIds(consumerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumers where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @return the range of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByConsumerIds(long consumerId, int start, int end)
		throws SystemException {
		return findByConsumerIds(consumerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumers where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByConsumerIds(long consumerId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERIDS;
			finderArgs = new Object[] { consumerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONSUMERIDS;
			finderArgs = new Object[] { consumerId, start, end, orderByComparator };
		}

		List<Consumer> list = (List<Consumer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Consumer consumer : list) {
				if ((consumerId != consumer.getConsumerId())) {
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

			query.append(_SQL_SELECT_CONSUMER_WHERE);

			query.append(_FINDER_COLUMN_CONSUMERIDS_CONSUMERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(consumerId);

				if (!pagination) {
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Consumer>(list);
				}
				else {
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first consumer in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByConsumerIds_First(long consumerId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = fetchByConsumerIds_First(consumerId,
				orderByComparator);

		if (consumer != null) {
			return consumer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("consumerId=");
		msg.append(consumerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerException(msg.toString());
	}

	/**
	 * Returns the first consumer in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer, or <code>null</code> if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByConsumerIds_First(long consumerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Consumer> list = findByConsumerIds(consumerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByConsumerIds_Last(long consumerId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = fetchByConsumerIds_Last(consumerId,
				orderByComparator);

		if (consumer != null) {
			return consumer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("consumerId=");
		msg.append(consumerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerException(msg.toString());
	}

	/**
	 * Returns the last consumer in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer, or <code>null</code> if a matching consumer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByConsumerIds_Last(long consumerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByConsumerIds(consumerId);

		if (count == 0) {
			return null;
		}

		List<Consumer> list = findByConsumerIds(consumerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the consumers where consumerId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerIds the consumer IDs
	 * @return the matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByConsumerIds(long[] consumerIds)
		throws SystemException {
		return findByConsumerIds(consumerIds, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumers where consumerId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerIds the consumer IDs
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @return the range of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByConsumerIds(long[] consumerIds, int start,
		int end) throws SystemException {
		return findByConsumerIds(consumerIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumers where consumerId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerIds the consumer IDs
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findByConsumerIds(long[] consumerIds, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((consumerIds != null) && (consumerIds.length == 1)) {
			return findByConsumerIds(consumerIds[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(consumerIds) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(consumerIds),
					
					start, end, orderByComparator
				};
		}

		List<Consumer> list = (List<Consumer>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CONSUMERIDS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Consumer consumer : list) {
				if (!ArrayUtil.contains(consumerIds, consumer.getConsumerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_CONSUMER_WHERE);

			boolean conjunctionable = false;

			if ((consumerIds == null) || (consumerIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < consumerIds.length; i++) {
					query.append(_FINDER_COLUMN_CONSUMERIDS_CONSUMERID_5);

					if ((i + 1) < consumerIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (consumerIds != null) {
					qPos.add(consumerIds);
				}

				if (!pagination) {
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Consumer>(list);
				}
				else {
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CONSUMERIDS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_CONSUMERIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the consumers where consumerId = &#63; from the database.
	 *
	 * @param consumerId the consumer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByConsumerIds(long consumerId) throws SystemException {
		for (Consumer consumer : findByConsumerIds(consumerId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumer);
		}
	}

	/**
	 * Returns the number of consumers where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the number of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByConsumerIds(long consumerId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONSUMERIDS;

		Object[] finderArgs = new Object[] { consumerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONSUMER_WHERE);

			query.append(_FINDER_COLUMN_CONSUMERIDS_CONSUMERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(consumerId);

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

	/**
	 * Returns the number of consumers where consumerId = any &#63;.
	 *
	 * @param consumerIds the consumer IDs
	 * @return the number of matching consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByConsumerIds(long[] consumerIds) throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(consumerIds) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CONSUMERIDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_CONSUMER_WHERE);

			boolean conjunctionable = false;

			if ((consumerIds == null) || (consumerIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < consumerIds.length; i++) {
					query.append(_FINDER_COLUMN_CONSUMERIDS_CONSUMERID_5);

					if ((i + 1) < consumerIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (consumerIds != null) {
					qPos.add(consumerIds);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CONSUMERIDS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CONSUMERIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONSUMERIDS_CONSUMERID_2 = "consumer.consumerId = ?";
	private static final String _FINDER_COLUMN_CONSUMERIDS_CONSUMERID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_CONSUMERIDS_CONSUMERID_2) + ")";

	public ConsumerPersistenceImpl() {
		setModelClass(Consumer.class);
	}

	/**
	 * Caches the consumer in the entity cache if it is enabled.
	 *
	 * @param consumer the consumer
	 */
	@Override
	public void cacheResult(Consumer consumer) {
		EntityCacheUtil.putResult(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerImpl.class, consumer.getPrimaryKey(), consumer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
			new Object[] { consumer.getCompanyId(), consumer.getConsumerKey() },
			consumer);

		consumer.resetOriginalValues();
	}

	/**
	 * Caches the consumers in the entity cache if it is enabled.
	 *
	 * @param consumers the consumers
	 */
	@Override
	public void cacheResult(List<Consumer> consumers) {
		for (Consumer consumer : consumers) {
			if (EntityCacheUtil.getResult(
						ConsumerModelImpl.ENTITY_CACHE_ENABLED,
						ConsumerImpl.class, consumer.getPrimaryKey()) == null) {
				cacheResult(consumer);
			}
			else {
				consumer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all consumers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConsumerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConsumerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the consumer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Consumer consumer) {
		EntityCacheUtil.removeResult(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerImpl.class, consumer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(consumer);
	}

	@Override
	public void clearCache(List<Consumer> consumers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Consumer consumer : consumers) {
			EntityCacheUtil.removeResult(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
				ConsumerImpl.class, consumer.getPrimaryKey());

			clearUniqueFindersCache(consumer);
		}
	}

	protected void cacheUniqueFindersCache(Consumer consumer) {
		if (consumer.isNew()) {
			Object[] args = new Object[] {
					consumer.getCompanyId(), consumer.getConsumerKey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C, args, consumer);
		}
		else {
			ConsumerModelImpl consumerModelImpl = (ConsumerModelImpl)consumer;

			if ((consumerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumer.getCompanyId(), consumer.getConsumerKey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C, args,
					consumer);
			}
		}
	}

	protected void clearUniqueFindersCache(Consumer consumer) {
		ConsumerModelImpl consumerModelImpl = (ConsumerModelImpl)consumer;

		Object[] args = new Object[] {
				consumer.getCompanyId(), consumer.getConsumerKey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C, args);

		if ((consumerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_C.getColumnBitmask()) != 0) {
			args = new Object[] {
					consumerModelImpl.getOriginalCompanyId(),
					consumerModelImpl.getOriginalConsumerKey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C, args);
		}
	}

	/**
	 * Creates a new consumer with the primary key. Does not add the consumer to the database.
	 *
	 * @param consumerId the primary key for the new consumer
	 * @return the new consumer
	 */
	@Override
	public Consumer create(long consumerId) {
		Consumer consumer = new ConsumerImpl();

		consumer.setNew(true);
		consumer.setPrimaryKey(consumerId);

		String uuid = PortalUUIDUtil.generate();

		consumer.setUuid(uuid);

		return consumer;
	}

	/**
	 * Removes the consumer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param consumerId the primary key of the consumer
	 * @return the consumer that was removed
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer remove(long consumerId)
		throws NoSuchConsumerException, SystemException {
		return remove((Serializable)consumerId);
	}

	/**
	 * Removes the consumer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the consumer
	 * @return the consumer that was removed
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer remove(Serializable primaryKey)
		throws NoSuchConsumerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Consumer consumer = (Consumer)session.get(ConsumerImpl.class,
					primaryKey);

			if (consumer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConsumerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(consumer);
		}
		catch (NoSuchConsumerException nsee) {
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
	protected Consumer removeImpl(Consumer consumer) throws SystemException {
		consumer = toUnwrappedModel(consumer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(consumer)) {
				consumer = (Consumer)session.get(ConsumerImpl.class,
						consumer.getPrimaryKeyObj());
			}

			if (consumer != null) {
				session.delete(consumer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (consumer != null) {
			clearCache(consumer);
		}

		return consumer;
	}

	@Override
	public Consumer updateImpl(
		com.liferay.consumer.manager.model.Consumer consumer)
		throws SystemException {
		consumer = toUnwrappedModel(consumer);

		boolean isNew = consumer.isNew();

		ConsumerModelImpl consumerModelImpl = (ConsumerModelImpl)consumer;

		if (Validator.isNull(consumer.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			consumer.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (consumer.isNew()) {
				session.save(consumer);

				consumer.setNew(false);
			}
			else {
				session.merge(consumer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ConsumerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((consumerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { consumerModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { consumerModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((consumerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerModelImpl.getOriginalUuid(),
						consumerModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						consumerModelImpl.getUuid(),
						consumerModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((consumerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { consumerModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((consumerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerModelImpl.getOriginalConsumerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSUMERIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERIDS,
					args);

				args = new Object[] { consumerModelImpl.getConsumerId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSUMERIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERIDS,
					args);
			}
		}

		EntityCacheUtil.putResult(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerImpl.class, consumer.getPrimaryKey(), consumer);

		clearUniqueFindersCache(consumer);
		cacheUniqueFindersCache(consumer);

		return consumer;
	}

	protected Consumer toUnwrappedModel(Consumer consumer) {
		if (consumer instanceof ConsumerImpl) {
			return consumer;
		}

		ConsumerImpl consumerImpl = new ConsumerImpl();

		consumerImpl.setNew(consumer.isNew());
		consumerImpl.setPrimaryKey(consumer.getPrimaryKey());

		consumerImpl.setUuid(consumer.getUuid());
		consumerImpl.setConsumerId(consumer.getConsumerId());
		consumerImpl.setCompanyId(consumer.getCompanyId());
		consumerImpl.setUserId(consumer.getUserId());
		consumerImpl.setUserName(consumer.getUserName());
		consumerImpl.setCreateDate(consumer.getCreateDate());
		consumerImpl.setModifiedDate(consumer.getModifiedDate());
		consumerImpl.setConsumerKey(consumer.getConsumerKey());
		consumerImpl.setName(consumer.getName());
		consumerImpl.setDescription(consumer.getDescription());

		return consumerImpl;
	}

	/**
	 * Returns the consumer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the consumer
	 * @return the consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConsumerException, SystemException {
		Consumer consumer = fetchByPrimaryKey(primaryKey);

		if (consumer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConsumerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return consumer;
	}

	/**
	 * Returns the consumer with the primary key or throws a {@link com.liferay.consumer.manager.NoSuchConsumerException} if it could not be found.
	 *
	 * @param consumerId the primary key of the consumer
	 * @return the consumer
	 * @throws com.liferay.consumer.manager.NoSuchConsumerException if a consumer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer findByPrimaryKey(long consumerId)
		throws NoSuchConsumerException, SystemException {
		return findByPrimaryKey((Serializable)consumerId);
	}

	/**
	 * Returns the consumer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the consumer
	 * @return the consumer, or <code>null</code> if a consumer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Consumer consumer = (Consumer)EntityCacheUtil.getResult(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
				ConsumerImpl.class, primaryKey);

		if (consumer == _nullConsumer) {
			return null;
		}

		if (consumer == null) {
			Session session = null;

			try {
				session = openSession();

				consumer = (Consumer)session.get(ConsumerImpl.class, primaryKey);

				if (consumer != null) {
					cacheResult(consumer);
				}
				else {
					EntityCacheUtil.putResult(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
						ConsumerImpl.class, primaryKey, _nullConsumer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConsumerModelImpl.ENTITY_CACHE_ENABLED,
					ConsumerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return consumer;
	}

	/**
	 * Returns the consumer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param consumerId the primary key of the consumer
	 * @return the consumer, or <code>null</code> if a consumer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Consumer fetchByPrimaryKey(long consumerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)consumerId);
	}

	/**
	 * Returns all the consumers.
	 *
	 * @return the consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @return the range of consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumers
	 * @param end the upper bound of the range of consumers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of consumers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Consumer> findAll(int start, int end,
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

		List<Consumer> list = (List<Consumer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONSUMER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONSUMER;

				if (pagination) {
					sql = sql.concat(ConsumerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Consumer>(list);
				}
				else {
					list = (List<Consumer>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the consumers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Consumer consumer : findAll()) {
			remove(consumer);
		}
	}

	/**
	 * Returns the number of consumers.
	 *
	 * @return the number of consumers
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

				Query q = session.createQuery(_SQL_COUNT_CONSUMER);

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
	 * Initializes the consumer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consumer.manager.model.Consumer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Consumer>> listenersList = new ArrayList<ModelListener<Consumer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Consumer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConsumerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONSUMER = "SELECT consumer FROM Consumer consumer";
	private static final String _SQL_SELECT_CONSUMER_WHERE = "SELECT consumer FROM Consumer consumer WHERE ";
	private static final String _SQL_COUNT_CONSUMER = "SELECT COUNT(consumer) FROM Consumer consumer";
	private static final String _SQL_COUNT_CONSUMER_WHERE = "SELECT COUNT(consumer) FROM Consumer consumer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "consumer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Consumer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Consumer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConsumerPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Consumer _nullConsumer = new ConsumerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Consumer> toCacheModel() {
				return _nullConsumerCacheModel;
			}
		};

	private static CacheModel<Consumer> _nullConsumerCacheModel = new CacheModel<Consumer>() {
			@Override
			public Consumer toEntityModel() {
				return _nullConsumer;
			}
		};
}