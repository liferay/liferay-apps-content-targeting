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

import com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException;
import com.liferay.consumer.manager.model.ConsumerExtensionInstance;
import com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceImpl;
import com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl;

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
 * The persistence implementation for the consumer extension instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerExtensionInstancePersistence
 * @see ConsumerExtensionInstanceUtil
 * @generated
 */
public class ConsumerExtensionInstancePersistenceImpl
	extends BasePersistenceImpl<ConsumerExtensionInstance>
	implements ConsumerExtensionInstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConsumerExtensionInstanceUtil} to access the consumer extension instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConsumerExtensionInstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ConsumerExtensionInstanceModelImpl.UUID_COLUMN_BITMASK |
			ConsumerExtensionInstanceModelImpl.CONSUMEREXTENSIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the consumer extension instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer extension instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @return the range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer extension instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByUuid(String uuid, int start,
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

		List<ConsumerExtensionInstance> list = (List<ConsumerExtensionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerExtensionInstance consumerExtensionInstance : list) {
				if (!Validator.equals(uuid, consumerExtensionInstance.getUuid())) {
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

			query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

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
				query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerExtensionInstance>(list);
				}
				else {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer extension instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByUuid_First(uuid,
				orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer extension instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConsumerExtensionInstance> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByUuid_Last(uuid,
				orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ConsumerExtensionInstance> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where uuid = &#63;.
	 *
	 * @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance[] findByUuid_PrevAndNext(
		long consumerExtensionInstanceId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = findByPrimaryKey(consumerExtensionInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerExtensionInstance[] array = new ConsumerExtensionInstanceImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					consumerExtensionInstance, uuid, orderByComparator, true);

			array[1] = consumerExtensionInstance;

			array[2] = getByUuid_PrevAndNext(session,
					consumerExtensionInstance, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsumerExtensionInstance getByUuid_PrevAndNext(Session session,
		ConsumerExtensionInstance consumerExtensionInstance, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

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
			query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(consumerExtensionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerExtensionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer extension instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ConsumerExtensionInstance consumerExtensionInstance : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumerExtensionInstance);
		}
	}

	/**
	 * Returns the number of consumer extension instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching consumer extension instances
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

			query.append(_SQL_COUNT_CONSUMEREXTENSIONINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "consumerExtensionInstance.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "consumerExtensionInstance.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(consumerExtensionInstance.uuid IS NULL OR consumerExtensionInstance.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ConsumerExtensionInstanceModelImpl.UUID_COLUMN_BITMASK |
			ConsumerExtensionInstanceModelImpl.COMPANYID_COLUMN_BITMASK |
			ConsumerExtensionInstanceModelImpl.CONSUMEREXTENSIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the consumer extension instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByUuid_C(String uuid,
		long companyId) throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer extension instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @return the range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByUuid_C(String uuid,
		long companyId, int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer extension instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByUuid_C(String uuid,
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

		List<ConsumerExtensionInstance> list = (List<ConsumerExtensionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerExtensionInstance consumerExtensionInstance : list) {
				if (!Validator.equals(uuid, consumerExtensionInstance.getUuid()) ||
						(companyId != consumerExtensionInstance.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

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
				query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerExtensionInstance>(list);
				}
				else {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer extension instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer extension instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ConsumerExtensionInstance> list = findByUuid_C(uuid, companyId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ConsumerExtensionInstance> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance[] findByUuid_C_PrevAndNext(
		long consumerExtensionInstanceId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = findByPrimaryKey(consumerExtensionInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerExtensionInstance[] array = new ConsumerExtensionInstanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session,
					consumerExtensionInstance, uuid, companyId,
					orderByComparator, true);

			array[1] = consumerExtensionInstance;

			array[2] = getByUuid_C_PrevAndNext(session,
					consumerExtensionInstance, uuid, companyId,
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

	protected ConsumerExtensionInstance getByUuid_C_PrevAndNext(
		Session session, ConsumerExtensionInstance consumerExtensionInstance,
		String uuid, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

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
			query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(consumerExtensionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerExtensionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer extension instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ConsumerExtensionInstance consumerExtensionInstance : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumerExtensionInstance);
		}
	}

	/**
	 * Returns the number of consumer extension instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching consumer extension instances
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

			query.append(_SQL_COUNT_CONSUMEREXTENSIONINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "consumerExtensionInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "consumerExtensionInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(consumerExtensionInstance.uuid IS NULL OR consumerExtensionInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "consumerExtensionInstance.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			ConsumerExtensionInstanceModelImpl.COMPANYID_COLUMN_BITMASK |
			ConsumerExtensionInstanceModelImpl.CONSUMEREXTENSIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyId", new String[] { Long.class.getName() });

	/**
	 * Returns all the consumer extension instances where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the consumer extension instances where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @return the range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByCompanyId(long companyId,
		int start, int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer extension instances where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByCompanyId(long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ConsumerExtensionInstance> list = (List<ConsumerExtensionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerExtensionInstance consumerExtensionInstance : list) {
				if ((companyId != consumerExtensionInstance.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerExtensionInstance>(list);
				}
				else {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer extension instance in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer extension instance in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConsumerExtensionInstance> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<ConsumerExtensionInstance> list = findByCompanyId(companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where companyId = &#63;.
	 *
	 * @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance[] findByCompanyId_PrevAndNext(
		long consumerExtensionInstanceId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = findByPrimaryKey(consumerExtensionInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerExtensionInstance[] array = new ConsumerExtensionInstanceImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session,
					consumerExtensionInstance, companyId, orderByComparator,
					true);

			array[1] = consumerExtensionInstance;

			array[2] = getByCompanyId_PrevAndNext(session,
					consumerExtensionInstance, companyId, orderByComparator,
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

	protected ConsumerExtensionInstance getByCompanyId_PrevAndNext(
		Session session, ConsumerExtensionInstance consumerExtensionInstance,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

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
			query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(consumerExtensionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerExtensionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer extension instances where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (ConsumerExtensionInstance consumerExtensionInstance : findByCompanyId(
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumerExtensionInstance);
		}
	}

	/**
	 * Returns the number of consumer extension instances where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching consumer extension instances
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

			query.append(_SQL_COUNT_CONSUMEREXTENSIONINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "consumerExtensionInstance.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONSUMERID =
		new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConsumerId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERID =
		new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConsumerId",
			new String[] { Long.class.getName() },
			ConsumerExtensionInstanceModelImpl.CONSUMERID_COLUMN_BITMASK |
			ConsumerExtensionInstanceModelImpl.CONSUMEREXTENSIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONSUMERID = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByConsumerId", new String[] { Long.class.getName() });

	/**
	 * Returns all the consumer extension instances where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByConsumerId(long consumerId)
		throws SystemException {
		return findByConsumerId(consumerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer extension instances where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @return the range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByConsumerId(long consumerId,
		int start, int end) throws SystemException {
		return findByConsumerId(consumerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer extension instances where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByConsumerId(long consumerId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERID;
			finderArgs = new Object[] { consumerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONSUMERID;
			finderArgs = new Object[] { consumerId, start, end, orderByComparator };
		}

		List<ConsumerExtensionInstance> list = (List<ConsumerExtensionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerExtensionInstance consumerExtensionInstance : list) {
				if ((consumerId != consumerExtensionInstance.getConsumerId())) {
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

			query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_CONSUMERID_CONSUMERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(consumerId);

				if (!pagination) {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerExtensionInstance>(list);
				}
				else {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer extension instance in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByConsumerId_First(long consumerId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByConsumerId_First(consumerId,
				orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("consumerId=");
		msg.append(consumerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer extension instance in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByConsumerId_First(long consumerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConsumerExtensionInstance> list = findByConsumerId(consumerId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByConsumerId_Last(long consumerId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByConsumerId_Last(consumerId,
				orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("consumerId=");
		msg.append(consumerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByConsumerId_Last(long consumerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByConsumerId(consumerId);

		if (count == 0) {
			return null;
		}

		List<ConsumerExtensionInstance> list = findByConsumerId(consumerId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance[] findByConsumerId_PrevAndNext(
		long consumerExtensionInstanceId, long consumerId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = findByPrimaryKey(consumerExtensionInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerExtensionInstance[] array = new ConsumerExtensionInstanceImpl[3];

			array[0] = getByConsumerId_PrevAndNext(session,
					consumerExtensionInstance, consumerId, orderByComparator,
					true);

			array[1] = consumerExtensionInstance;

			array[2] = getByConsumerId_PrevAndNext(session,
					consumerExtensionInstance, consumerId, orderByComparator,
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

	protected ConsumerExtensionInstance getByConsumerId_PrevAndNext(
		Session session, ConsumerExtensionInstance consumerExtensionInstance,
		long consumerId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_CONSUMERID_CONSUMERID_2);

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
			query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(consumerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(consumerExtensionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerExtensionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer extension instances where consumerId = &#63; from the database.
	 *
	 * @param consumerId the consumer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByConsumerId(long consumerId) throws SystemException {
		for (ConsumerExtensionInstance consumerExtensionInstance : findByConsumerId(
				consumerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumerExtensionInstance);
		}
	}

	/**
	 * Returns the number of consumer extension instances where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the number of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByConsumerId(long consumerId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONSUMERID;

		Object[] finderArgs = new Object[] { consumerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONSUMEREXTENSIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_CONSUMERID_CONSUMERID_2);

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

	private static final String _FINDER_COLUMN_CONSUMERID_CONSUMERID_2 = "consumerExtensionInstance.consumerId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C",
			new String[] { Long.class.getName(), String.class.getName() },
			ConsumerExtensionInstanceModelImpl.COMPANYID_COLUMN_BITMASK |
			ConsumerExtensionInstanceModelImpl.CONSUMEREXTENSIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByC_C",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the consumer extension instances where companyId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerExtensionKey the consumer extension key
	 * @return the matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByC_C(long companyId,
		String consumerExtensionKey) throws SystemException {
		return findByC_C(companyId, consumerExtensionKey, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer extension instances where companyId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @return the range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByC_C(long companyId,
		String consumerExtensionKey, int start, int end)
		throws SystemException {
		return findByC_C(companyId, consumerExtensionKey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer extension instances where companyId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByC_C(long companyId,
		String consumerExtensionKey, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C;
			finderArgs = new Object[] { companyId, consumerExtensionKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C;
			finderArgs = new Object[] {
					companyId, consumerExtensionKey,
					
					start, end, orderByComparator
				};
		}

		List<ConsumerExtensionInstance> list = (List<ConsumerExtensionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerExtensionInstance consumerExtensionInstance : list) {
				if ((companyId != consumerExtensionInstance.getCompanyId()) ||
						!Validator.equals(consumerExtensionKey,
							consumerExtensionInstance.getConsumerExtensionKey())) {
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

			query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

			boolean bindConsumerExtensionKey = false;

			if (consumerExtensionKey == null) {
				query.append(_FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_1);
			}
			else if (consumerExtensionKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_3);
			}
			else {
				bindConsumerExtensionKey = true;

				query.append(_FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindConsumerExtensionKey) {
					qPos.add(consumerExtensionKey);
				}

				if (!pagination) {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerExtensionInstance>(list);
				}
				else {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer extension instance in the ordered set where companyId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByC_C_First(long companyId,
		String consumerExtensionKey, OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByC_C_First(companyId,
				consumerExtensionKey, orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", consumerExtensionKey=");
		msg.append(consumerExtensionKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer extension instance in the ordered set where companyId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByC_C_First(long companyId,
		String consumerExtensionKey, OrderByComparator orderByComparator)
		throws SystemException {
		List<ConsumerExtensionInstance> list = findByC_C(companyId,
				consumerExtensionKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where companyId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByC_C_Last(long companyId,
		String consumerExtensionKey, OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByC_C_Last(companyId,
				consumerExtensionKey, orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", consumerExtensionKey=");
		msg.append(consumerExtensionKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where companyId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByC_C_Last(long companyId,
		String consumerExtensionKey, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C(companyId, consumerExtensionKey);

		if (count == 0) {
			return null;
		}

		List<ConsumerExtensionInstance> list = findByC_C(companyId,
				consumerExtensionKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where companyId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	 * @param companyId the company ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance[] findByC_C_PrevAndNext(
		long consumerExtensionInstanceId, long companyId,
		String consumerExtensionKey, OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = findByPrimaryKey(consumerExtensionInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerExtensionInstance[] array = new ConsumerExtensionInstanceImpl[3];

			array[0] = getByC_C_PrevAndNext(session, consumerExtensionInstance,
					companyId, consumerExtensionKey, orderByComparator, true);

			array[1] = consumerExtensionInstance;

			array[2] = getByC_C_PrevAndNext(session, consumerExtensionInstance,
					companyId, consumerExtensionKey, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsumerExtensionInstance getByC_C_PrevAndNext(Session session,
		ConsumerExtensionInstance consumerExtensionInstance, long companyId,
		String consumerExtensionKey, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

		boolean bindConsumerExtensionKey = false;

		if (consumerExtensionKey == null) {
			query.append(_FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_1);
		}
		else if (consumerExtensionKey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_3);
		}
		else {
			bindConsumerExtensionKey = true;

			query.append(_FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_2);
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
			query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindConsumerExtensionKey) {
			qPos.add(consumerExtensionKey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(consumerExtensionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerExtensionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer extension instances where companyId = &#63; and consumerExtensionKey = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param consumerExtensionKey the consumer extension key
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C(long companyId, String consumerExtensionKey)
		throws SystemException {
		for (ConsumerExtensionInstance consumerExtensionInstance : findByC_C(
				companyId, consumerExtensionKey, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(consumerExtensionInstance);
		}
	}

	/**
	 * Returns the number of consumer extension instances where companyId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerExtensionKey the consumer extension key
	 * @return the number of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C(long companyId, String consumerExtensionKey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C;

		Object[] finderArgs = new Object[] { companyId, consumerExtensionKey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONSUMEREXTENSIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_C_COMPANYID_2);

			boolean bindConsumerExtensionKey = false;

			if (consumerExtensionKey == null) {
				query.append(_FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_1);
			}
			else if (consumerExtensionKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_3);
			}
			else {
				bindConsumerExtensionKey = true;

				query.append(_FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindConsumerExtensionKey) {
					qPos.add(consumerExtensionKey);
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

	private static final String _FINDER_COLUMN_C_C_COMPANYID_2 = "consumerExtensionInstance.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_1 = "consumerExtensionInstance.consumerExtensionKey IS NULL";
	private static final String _FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_2 = "consumerExtensionInstance.consumerExtensionKey = ?";
	private static final String _FINDER_COLUMN_C_C_CONSUMEREXTENSIONKEY_3 = "(consumerExtensionInstance.consumerExtensionKey IS NULL OR consumerExtensionInstance.consumerExtensionKey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_K = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_K",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_K = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_K",
			new String[] { Long.class.getName(), String.class.getName() },
			ConsumerExtensionInstanceModelImpl.CONSUMERID_COLUMN_BITMASK |
			ConsumerExtensionInstanceModelImpl.CONSUMEREXTENSIONKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_K = new FinderPath(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByC_K",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the consumer extension instances where consumerId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param consumerExtensionKey the consumer extension key
	 * @return the matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByC_K(long consumerId,
		String consumerExtensionKey) throws SystemException {
		return findByC_K(consumerId, consumerExtensionKey, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer extension instances where consumerId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @return the range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByC_K(long consumerId,
		String consumerExtensionKey, int start, int end)
		throws SystemException {
		return findByC_K(consumerId, consumerExtensionKey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer extension instances where consumerId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findByC_K(long consumerId,
		String consumerExtensionKey, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_K;
			finderArgs = new Object[] { consumerId, consumerExtensionKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_K;
			finderArgs = new Object[] {
					consumerId, consumerExtensionKey,
					
					start, end, orderByComparator
				};
		}

		List<ConsumerExtensionInstance> list = (List<ConsumerExtensionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerExtensionInstance consumerExtensionInstance : list) {
				if ((consumerId != consumerExtensionInstance.getConsumerId()) ||
						!Validator.equals(consumerExtensionKey,
							consumerExtensionInstance.getConsumerExtensionKey())) {
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

			query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_K_CONSUMERID_2);

			boolean bindConsumerExtensionKey = false;

			if (consumerExtensionKey == null) {
				query.append(_FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_1);
			}
			else if (consumerExtensionKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_3);
			}
			else {
				bindConsumerExtensionKey = true;

				query.append(_FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(consumerId);

				if (bindConsumerExtensionKey) {
					qPos.add(consumerExtensionKey);
				}

				if (!pagination) {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerExtensionInstance>(list);
				}
				else {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer extension instance in the ordered set where consumerId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByC_K_First(long consumerId,
		String consumerExtensionKey, OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByC_K_First(consumerId,
				consumerExtensionKey, orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("consumerId=");
		msg.append(consumerId);

		msg.append(", consumerExtensionKey=");
		msg.append(consumerExtensionKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer extension instance in the ordered set where consumerId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByC_K_First(long consumerId,
		String consumerExtensionKey, OrderByComparator orderByComparator)
		throws SystemException {
		List<ConsumerExtensionInstance> list = findByC_K(consumerId,
				consumerExtensionKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where consumerId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByC_K_Last(long consumerId,
		String consumerExtensionKey, OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByC_K_Last(consumerId,
				consumerExtensionKey, orderByComparator);

		if (consumerExtensionInstance != null) {
			return consumerExtensionInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("consumerId=");
		msg.append(consumerId);

		msg.append(", consumerExtensionKey=");
		msg.append(consumerExtensionKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerExtensionInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer extension instance in the ordered set where consumerId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer extension instance, or <code>null</code> if a matching consumer extension instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByC_K_Last(long consumerId,
		String consumerExtensionKey, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_K(consumerId, consumerExtensionKey);

		if (count == 0) {
			return null;
		}

		List<ConsumerExtensionInstance> list = findByC_K(consumerId,
				consumerExtensionKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer extension instances before and after the current consumer extension instance in the ordered set where consumerId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param consumerExtensionInstanceId the primary key of the current consumer extension instance
	 * @param consumerId the consumer ID
	 * @param consumerExtensionKey the consumer extension key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance[] findByC_K_PrevAndNext(
		long consumerExtensionInstanceId, long consumerId,
		String consumerExtensionKey, OrderByComparator orderByComparator)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = findByPrimaryKey(consumerExtensionInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerExtensionInstance[] array = new ConsumerExtensionInstanceImpl[3];

			array[0] = getByC_K_PrevAndNext(session, consumerExtensionInstance,
					consumerId, consumerExtensionKey, orderByComparator, true);

			array[1] = consumerExtensionInstance;

			array[2] = getByC_K_PrevAndNext(session, consumerExtensionInstance,
					consumerId, consumerExtensionKey, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsumerExtensionInstance getByC_K_PrevAndNext(Session session,
		ConsumerExtensionInstance consumerExtensionInstance, long consumerId,
		String consumerExtensionKey, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_C_K_CONSUMERID_2);

		boolean bindConsumerExtensionKey = false;

		if (consumerExtensionKey == null) {
			query.append(_FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_1);
		}
		else if (consumerExtensionKey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_3);
		}
		else {
			bindConsumerExtensionKey = true;

			query.append(_FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_2);
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
			query.append(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(consumerId);

		if (bindConsumerExtensionKey) {
			qPos.add(consumerExtensionKey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(consumerExtensionInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerExtensionInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer extension instances where consumerId = &#63; and consumerExtensionKey = &#63; from the database.
	 *
	 * @param consumerId the consumer ID
	 * @param consumerExtensionKey the consumer extension key
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_K(long consumerId, String consumerExtensionKey)
		throws SystemException {
		for (ConsumerExtensionInstance consumerExtensionInstance : findByC_K(
				consumerId, consumerExtensionKey, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(consumerExtensionInstance);
		}
	}

	/**
	 * Returns the number of consumer extension instances where consumerId = &#63; and consumerExtensionKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param consumerExtensionKey the consumer extension key
	 * @return the number of matching consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_K(long consumerId, String consumerExtensionKey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_K;

		Object[] finderArgs = new Object[] { consumerId, consumerExtensionKey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONSUMEREXTENSIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_K_CONSUMERID_2);

			boolean bindConsumerExtensionKey = false;

			if (consumerExtensionKey == null) {
				query.append(_FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_1);
			}
			else if (consumerExtensionKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_3);
			}
			else {
				bindConsumerExtensionKey = true;

				query.append(_FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(consumerId);

				if (bindConsumerExtensionKey) {
					qPos.add(consumerExtensionKey);
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

	private static final String _FINDER_COLUMN_C_K_CONSUMERID_2 = "consumerExtensionInstance.consumerId = ? AND ";
	private static final String _FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_1 = "consumerExtensionInstance.consumerExtensionKey IS NULL";
	private static final String _FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_2 = "consumerExtensionInstance.consumerExtensionKey = ?";
	private static final String _FINDER_COLUMN_C_K_CONSUMEREXTENSIONKEY_3 = "(consumerExtensionInstance.consumerExtensionKey IS NULL OR consumerExtensionInstance.consumerExtensionKey = '')";

	public ConsumerExtensionInstancePersistenceImpl() {
		setModelClass(ConsumerExtensionInstance.class);
	}

	/**
	 * Caches the consumer extension instance in the entity cache if it is enabled.
	 *
	 * @param consumerExtensionInstance the consumer extension instance
	 */
	@Override
	public void cacheResult(ConsumerExtensionInstance consumerExtensionInstance) {
		EntityCacheUtil.putResult(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			consumerExtensionInstance.getPrimaryKey(), consumerExtensionInstance);

		consumerExtensionInstance.resetOriginalValues();
	}

	/**
	 * Caches the consumer extension instances in the entity cache if it is enabled.
	 *
	 * @param consumerExtensionInstances the consumer extension instances
	 */
	@Override
	public void cacheResult(
		List<ConsumerExtensionInstance> consumerExtensionInstances) {
		for (ConsumerExtensionInstance consumerExtensionInstance : consumerExtensionInstances) {
			if (EntityCacheUtil.getResult(
						ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ConsumerExtensionInstanceImpl.class,
						consumerExtensionInstance.getPrimaryKey()) == null) {
				cacheResult(consumerExtensionInstance);
			}
			else {
				consumerExtensionInstance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all consumer extension instances.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConsumerExtensionInstanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConsumerExtensionInstanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the consumer extension instance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConsumerExtensionInstance consumerExtensionInstance) {
		EntityCacheUtil.removeResult(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			consumerExtensionInstance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ConsumerExtensionInstance> consumerExtensionInstances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConsumerExtensionInstance consumerExtensionInstance : consumerExtensionInstances) {
			EntityCacheUtil.removeResult(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ConsumerExtensionInstanceImpl.class,
				consumerExtensionInstance.getPrimaryKey());
		}
	}

	/**
	 * Creates a new consumer extension instance with the primary key. Does not add the consumer extension instance to the database.
	 *
	 * @param consumerExtensionInstanceId the primary key for the new consumer extension instance
	 * @return the new consumer extension instance
	 */
	@Override
	public ConsumerExtensionInstance create(long consumerExtensionInstanceId) {
		ConsumerExtensionInstance consumerExtensionInstance = new ConsumerExtensionInstanceImpl();

		consumerExtensionInstance.setNew(true);
		consumerExtensionInstance.setPrimaryKey(consumerExtensionInstanceId);

		String uuid = PortalUUIDUtil.generate();

		consumerExtensionInstance.setUuid(uuid);

		return consumerExtensionInstance;
	}

	/**
	 * Removes the consumer extension instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param consumerExtensionInstanceId the primary key of the consumer extension instance
	 * @return the consumer extension instance that was removed
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance remove(long consumerExtensionInstanceId)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		return remove((Serializable)consumerExtensionInstanceId);
	}

	/**
	 * Removes the consumer extension instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the consumer extension instance
	 * @return the consumer extension instance that was removed
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance remove(Serializable primaryKey)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ConsumerExtensionInstance consumerExtensionInstance = (ConsumerExtensionInstance)session.get(ConsumerExtensionInstanceImpl.class,
					primaryKey);

			if (consumerExtensionInstance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConsumerExtensionInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(consumerExtensionInstance);
		}
		catch (NoSuchConsumerExtensionInstanceException nsee) {
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
	protected ConsumerExtensionInstance removeImpl(
		ConsumerExtensionInstance consumerExtensionInstance)
		throws SystemException {
		consumerExtensionInstance = toUnwrappedModel(consumerExtensionInstance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(consumerExtensionInstance)) {
				consumerExtensionInstance = (ConsumerExtensionInstance)session.get(ConsumerExtensionInstanceImpl.class,
						consumerExtensionInstance.getPrimaryKeyObj());
			}

			if (consumerExtensionInstance != null) {
				session.delete(consumerExtensionInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (consumerExtensionInstance != null) {
			clearCache(consumerExtensionInstance);
		}

		return consumerExtensionInstance;
	}

	@Override
	public ConsumerExtensionInstance updateImpl(
		com.liferay.consumer.manager.model.ConsumerExtensionInstance consumerExtensionInstance)
		throws SystemException {
		consumerExtensionInstance = toUnwrappedModel(consumerExtensionInstance);

		boolean isNew = consumerExtensionInstance.isNew();

		ConsumerExtensionInstanceModelImpl consumerExtensionInstanceModelImpl = (ConsumerExtensionInstanceModelImpl)consumerExtensionInstance;

		if (Validator.isNull(consumerExtensionInstance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			consumerExtensionInstance.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (consumerExtensionInstance.isNew()) {
				session.save(consumerExtensionInstance);

				consumerExtensionInstance.setNew(false);
			}
			else {
				session.merge(consumerExtensionInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!ConsumerExtensionInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((consumerExtensionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerExtensionInstanceModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { consumerExtensionInstanceModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((consumerExtensionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerExtensionInstanceModelImpl.getOriginalUuid(),
						consumerExtensionInstanceModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						consumerExtensionInstanceModelImpl.getUuid(),
						consumerExtensionInstanceModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((consumerExtensionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerExtensionInstanceModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						consumerExtensionInstanceModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((consumerExtensionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerExtensionInstanceModelImpl.getOriginalConsumerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSUMERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERID,
					args);

				args = new Object[] {
						consumerExtensionInstanceModelImpl.getConsumerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSUMERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERID,
					args);
			}

			if ((consumerExtensionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerExtensionInstanceModelImpl.getOriginalCompanyId(),
						consumerExtensionInstanceModelImpl.getOriginalConsumerExtensionKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);

				args = new Object[] {
						consumerExtensionInstanceModelImpl.getCompanyId(),
						consumerExtensionInstanceModelImpl.getConsumerExtensionKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);
			}

			if ((consumerExtensionInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_K.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerExtensionInstanceModelImpl.getOriginalConsumerId(),
						consumerExtensionInstanceModelImpl.getOriginalConsumerExtensionKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_K, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_K,
					args);

				args = new Object[] {
						consumerExtensionInstanceModelImpl.getConsumerId(),
						consumerExtensionInstanceModelImpl.getConsumerExtensionKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_K, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_K,
					args);
			}
		}

		EntityCacheUtil.putResult(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerExtensionInstanceImpl.class,
			consumerExtensionInstance.getPrimaryKey(), consumerExtensionInstance);

		return consumerExtensionInstance;
	}

	protected ConsumerExtensionInstance toUnwrappedModel(
		ConsumerExtensionInstance consumerExtensionInstance) {
		if (consumerExtensionInstance instanceof ConsumerExtensionInstanceImpl) {
			return consumerExtensionInstance;
		}

		ConsumerExtensionInstanceImpl consumerExtensionInstanceImpl = new ConsumerExtensionInstanceImpl();

		consumerExtensionInstanceImpl.setNew(consumerExtensionInstance.isNew());
		consumerExtensionInstanceImpl.setPrimaryKey(consumerExtensionInstance.getPrimaryKey());

		consumerExtensionInstanceImpl.setUuid(consumerExtensionInstance.getUuid());
		consumerExtensionInstanceImpl.setConsumerExtensionInstanceId(consumerExtensionInstance.getConsumerExtensionInstanceId());
		consumerExtensionInstanceImpl.setCompanyId(consumerExtensionInstance.getCompanyId());
		consumerExtensionInstanceImpl.setUserId(consumerExtensionInstance.getUserId());
		consumerExtensionInstanceImpl.setUserName(consumerExtensionInstance.getUserName());
		consumerExtensionInstanceImpl.setCreateDate(consumerExtensionInstance.getCreateDate());
		consumerExtensionInstanceImpl.setModifiedDate(consumerExtensionInstance.getModifiedDate());
		consumerExtensionInstanceImpl.setConsumerExtensionKey(consumerExtensionInstance.getConsumerExtensionKey());
		consumerExtensionInstanceImpl.setConsumerId(consumerExtensionInstance.getConsumerId());
		consumerExtensionInstanceImpl.setTypeSettings(consumerExtensionInstance.getTypeSettings());

		return consumerExtensionInstanceImpl;
	}

	/**
	 * Returns the consumer extension instance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the consumer extension instance
	 * @return the consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = fetchByPrimaryKey(primaryKey);

		if (consumerExtensionInstance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConsumerExtensionInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return consumerExtensionInstance;
	}

	/**
	 * Returns the consumer extension instance with the primary key or throws a {@link com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException} if it could not be found.
	 *
	 * @param consumerExtensionInstanceId the primary key of the consumer extension instance
	 * @return the consumer extension instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerExtensionInstanceException if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance findByPrimaryKey(
		long consumerExtensionInstanceId)
		throws NoSuchConsumerExtensionInstanceException, SystemException {
		return findByPrimaryKey((Serializable)consumerExtensionInstanceId);
	}

	/**
	 * Returns the consumer extension instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the consumer extension instance
	 * @return the consumer extension instance, or <code>null</code> if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ConsumerExtensionInstance consumerExtensionInstance = (ConsumerExtensionInstance)EntityCacheUtil.getResult(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ConsumerExtensionInstanceImpl.class, primaryKey);

		if (consumerExtensionInstance == _nullConsumerExtensionInstance) {
			return null;
		}

		if (consumerExtensionInstance == null) {
			Session session = null;

			try {
				session = openSession();

				consumerExtensionInstance = (ConsumerExtensionInstance)session.get(ConsumerExtensionInstanceImpl.class,
						primaryKey);

				if (consumerExtensionInstance != null) {
					cacheResult(consumerExtensionInstance);
				}
				else {
					EntityCacheUtil.putResult(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ConsumerExtensionInstanceImpl.class, primaryKey,
						_nullConsumerExtensionInstance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConsumerExtensionInstanceModelImpl.ENTITY_CACHE_ENABLED,
					ConsumerExtensionInstanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return consumerExtensionInstance;
	}

	/**
	 * Returns the consumer extension instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param consumerExtensionInstanceId the primary key of the consumer extension instance
	 * @return the consumer extension instance, or <code>null</code> if a consumer extension instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerExtensionInstance fetchByPrimaryKey(
		long consumerExtensionInstanceId) throws SystemException {
		return fetchByPrimaryKey((Serializable)consumerExtensionInstanceId);
	}

	/**
	 * Returns all the consumer extension instances.
	 *
	 * @return the consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer extension instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @return the range of consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer extension instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerExtensionInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer extension instances
	 * @param end the upper bound of the range of consumer extension instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of consumer extension instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerExtensionInstance> findAll(int start, int end,
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

		List<ConsumerExtensionInstance> list = (List<ConsumerExtensionInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONSUMEREXTENSIONINSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONSUMEREXTENSIONINSTANCE;

				if (pagination) {
					sql = sql.concat(ConsumerExtensionInstanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerExtensionInstance>(list);
				}
				else {
					list = (List<ConsumerExtensionInstance>)QueryUtil.list(q,
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
	 * Removes all the consumer extension instances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ConsumerExtensionInstance consumerExtensionInstance : findAll()) {
			remove(consumerExtensionInstance);
		}
	}

	/**
	 * Returns the number of consumer extension instances.
	 *
	 * @return the number of consumer extension instances
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

				Query q = session.createQuery(_SQL_COUNT_CONSUMEREXTENSIONINSTANCE);

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
	 * Initializes the consumer extension instance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consumer.manager.model.ConsumerExtensionInstance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ConsumerExtensionInstance>> listenersList = new ArrayList<ModelListener<ConsumerExtensionInstance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ConsumerExtensionInstance>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConsumerExtensionInstanceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONSUMEREXTENSIONINSTANCE = "SELECT consumerExtensionInstance FROM ConsumerExtensionInstance consumerExtensionInstance";
	private static final String _SQL_SELECT_CONSUMEREXTENSIONINSTANCE_WHERE = "SELECT consumerExtensionInstance FROM ConsumerExtensionInstance consumerExtensionInstance WHERE ";
	private static final String _SQL_COUNT_CONSUMEREXTENSIONINSTANCE = "SELECT COUNT(consumerExtensionInstance) FROM ConsumerExtensionInstance consumerExtensionInstance";
	private static final String _SQL_COUNT_CONSUMEREXTENSIONINSTANCE_WHERE = "SELECT COUNT(consumerExtensionInstance) FROM ConsumerExtensionInstance consumerExtensionInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "consumerExtensionInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConsumerExtensionInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ConsumerExtensionInstance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConsumerExtensionInstancePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ConsumerExtensionInstance _nullConsumerExtensionInstance = new ConsumerExtensionInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ConsumerExtensionInstance> toCacheModel() {
				return _nullConsumerExtensionInstanceCacheModel;
			}
		};

	private static CacheModel<ConsumerExtensionInstance> _nullConsumerExtensionInstanceCacheModel =
		new CacheModel<ConsumerExtensionInstance>() {
			@Override
			public ConsumerExtensionInstance toEntityModel() {
				return _nullConsumerExtensionInstance;
			}
		};
}