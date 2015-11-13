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

import com.liferay.consumer.manager.NoSuchConsumerReportInstanceException;
import com.liferay.consumer.manager.model.ConsumerReportInstance;
import com.liferay.consumer.manager.model.impl.ConsumerReportInstanceImpl;
import com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl;

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
 * The persistence implementation for the consumer report instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerReportInstancePersistence
 * @see ConsumerReportInstanceUtil
 * @generated
 */
public class ConsumerReportInstancePersistenceImpl extends BasePersistenceImpl<ConsumerReportInstance>
	implements ConsumerReportInstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConsumerReportInstanceUtil} to access the consumer report instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConsumerReportInstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ConsumerReportInstanceModelImpl.UUID_COLUMN_BITMASK |
			ConsumerReportInstanceModelImpl.REPORTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the consumer report instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer report instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @return the range of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer report instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByUuid(String uuid, int start,
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

		List<ConsumerReportInstance> list = (List<ConsumerReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerReportInstance consumerReportInstance : list) {
				if (!Validator.equals(uuid, consumerReportInstance.getUuid())) {
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

			query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE);

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
				query.append(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerReportInstance>(list);
				}
				else {
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer report instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByUuid_First(uuid,
				orderByComparator);

		if (consumerReportInstance != null) {
			return consumerReportInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerReportInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer report instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConsumerReportInstance> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer report instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByUuid_Last(uuid,
				orderByComparator);

		if (consumerReportInstance != null) {
			return consumerReportInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerReportInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer report instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ConsumerReportInstance> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer report instances before and after the current consumer report instance in the ordered set where uuid = &#63;.
	 *
	 * @param consumerReportInstanceId the primary key of the current consumer report instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance[] findByUuid_PrevAndNext(
		long consumerReportInstanceId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = findByPrimaryKey(consumerReportInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerReportInstance[] array = new ConsumerReportInstanceImpl[3];

			array[0] = getByUuid_PrevAndNext(session, consumerReportInstance,
					uuid, orderByComparator, true);

			array[1] = consumerReportInstance;

			array[2] = getByUuid_PrevAndNext(session, consumerReportInstance,
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

	protected ConsumerReportInstance getByUuid_PrevAndNext(Session session,
		ConsumerReportInstance consumerReportInstance, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE);

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
			query.append(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(consumerReportInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerReportInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer report instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ConsumerReportInstance consumerReportInstance : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumerReportInstance);
		}
	}

	/**
	 * Returns the number of consumer report instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching consumer report instances
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

			query.append(_SQL_COUNT_CONSUMERREPORTINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "consumerReportInstance.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "consumerReportInstance.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(consumerReportInstance.uuid IS NULL OR consumerReportInstance.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ConsumerReportInstanceModelImpl.UUID_COLUMN_BITMASK |
			ConsumerReportInstanceModelImpl.COMPANYID_COLUMN_BITMASK |
			ConsumerReportInstanceModelImpl.REPORTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the consumer report instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer report instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @return the range of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByUuid_C(String uuid,
		long companyId, int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer report instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByUuid_C(String uuid,
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

		List<ConsumerReportInstance> list = (List<ConsumerReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerReportInstance consumerReportInstance : list) {
				if (!Validator.equals(uuid, consumerReportInstance.getUuid()) ||
						(companyId != consumerReportInstance.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE);

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
				query.append(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerReportInstance>(list);
				}
				else {
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (consumerReportInstance != null) {
			return consumerReportInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerReportInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ConsumerReportInstance> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (consumerReportInstance != null) {
			return consumerReportInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerReportInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ConsumerReportInstance> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer report instances before and after the current consumer report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param consumerReportInstanceId the primary key of the current consumer report instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance[] findByUuid_C_PrevAndNext(
		long consumerReportInstanceId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = findByPrimaryKey(consumerReportInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerReportInstance[] array = new ConsumerReportInstanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, consumerReportInstance,
					uuid, companyId, orderByComparator, true);

			array[1] = consumerReportInstance;

			array[2] = getByUuid_C_PrevAndNext(session, consumerReportInstance,
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

	protected ConsumerReportInstance getByUuid_C_PrevAndNext(Session session,
		ConsumerReportInstance consumerReportInstance, String uuid,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE);

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
			query.append(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(consumerReportInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerReportInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer report instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ConsumerReportInstance consumerReportInstance : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumerReportInstance);
		}
	}

	/**
	 * Returns the number of consumer report instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching consumer report instances
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

			query.append(_SQL_COUNT_CONSUMERREPORTINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "consumerReportInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "consumerReportInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(consumerReportInstance.uuid IS NULL OR consumerReportInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "consumerReportInstance.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONSUMERID =
		new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConsumerId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERID =
		new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConsumerId",
			new String[] { Long.class.getName() },
			ConsumerReportInstanceModelImpl.CONSUMERID_COLUMN_BITMASK |
			ConsumerReportInstanceModelImpl.REPORTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONSUMERID = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConsumerId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the consumer report instances where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByConsumerId(long consumerId)
		throws SystemException {
		return findByConsumerId(consumerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer report instances where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @return the range of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByConsumerId(long consumerId,
		int start, int end) throws SystemException {
		return findByConsumerId(consumerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer report instances where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByConsumerId(long consumerId,
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

		List<ConsumerReportInstance> list = (List<ConsumerReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerReportInstance consumerReportInstance : list) {
				if ((consumerId != consumerReportInstance.getConsumerId())) {
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

			query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_CONSUMERID_CONSUMERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(consumerId);

				if (!pagination) {
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerReportInstance>(list);
				}
				else {
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer report instance in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByConsumerId_First(long consumerId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByConsumerId_First(consumerId,
				orderByComparator);

		if (consumerReportInstance != null) {
			return consumerReportInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("consumerId=");
		msg.append(consumerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerReportInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer report instance in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByConsumerId_First(long consumerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConsumerReportInstance> list = findByConsumerId(consumerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer report instance in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByConsumerId_Last(long consumerId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByConsumerId_Last(consumerId,
				orderByComparator);

		if (consumerReportInstance != null) {
			return consumerReportInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("consumerId=");
		msg.append(consumerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerReportInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer report instance in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByConsumerId_Last(long consumerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByConsumerId(consumerId);

		if (count == 0) {
			return null;
		}

		List<ConsumerReportInstance> list = findByConsumerId(consumerId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer report instances before and after the current consumer report instance in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerReportInstanceId the primary key of the current consumer report instance
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance[] findByConsumerId_PrevAndNext(
		long consumerReportInstanceId, long consumerId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = findByPrimaryKey(consumerReportInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerReportInstance[] array = new ConsumerReportInstanceImpl[3];

			array[0] = getByConsumerId_PrevAndNext(session,
					consumerReportInstance, consumerId, orderByComparator, true);

			array[1] = consumerReportInstance;

			array[2] = getByConsumerId_PrevAndNext(session,
					consumerReportInstance, consumerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsumerReportInstance getByConsumerId_PrevAndNext(
		Session session, ConsumerReportInstance consumerReportInstance,
		long consumerId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE);

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
			query.append(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(consumerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(consumerReportInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerReportInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer report instances where consumerId = &#63; from the database.
	 *
	 * @param consumerId the consumer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByConsumerId(long consumerId) throws SystemException {
		for (ConsumerReportInstance consumerReportInstance : findByConsumerId(
				consumerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumerReportInstance);
		}
	}

	/**
	 * Returns the number of consumer report instances where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the number of matching consumer report instances
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

			query.append(_SQL_COUNT_CONSUMERREPORTINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_CONSUMERID_CONSUMERID_2 = "consumerReportInstance.consumerId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R",
			new String[] { Long.class.getName(), String.class.getName() },
			ConsumerReportInstanceModelImpl.CONSUMERID_COLUMN_BITMASK |
			ConsumerReportInstanceModelImpl.REPORTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the consumer report instances where consumerId = &#63; and reportKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param reportKey the report key
	 * @return the matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByC_R(long consumerId,
		String reportKey) throws SystemException {
		return findByC_R(consumerId, reportKey, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer report instances where consumerId = &#63; and reportKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param reportKey the report key
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @return the range of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByC_R(long consumerId,
		String reportKey, int start, int end) throws SystemException {
		return findByC_R(consumerId, reportKey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer report instances where consumerId = &#63; and reportKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param reportKey the report key
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByC_R(long consumerId,
		String reportKey, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R;
			finderArgs = new Object[] { consumerId, reportKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R;
			finderArgs = new Object[] {
					consumerId, reportKey,
					
					start, end, orderByComparator
				};
		}

		List<ConsumerReportInstance> list = (List<ConsumerReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerReportInstance consumerReportInstance : list) {
				if ((consumerId != consumerReportInstance.getConsumerId()) ||
						!Validator.equals(reportKey,
							consumerReportInstance.getReportKey())) {
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

			query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_R_CONSUMERID_2);

			boolean bindReportKey = false;

			if (reportKey == null) {
				query.append(_FINDER_COLUMN_C_R_REPORTKEY_1);
			}
			else if (reportKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_REPORTKEY_3);
			}
			else {
				bindReportKey = true;

				query.append(_FINDER_COLUMN_C_R_REPORTKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(consumerId);

				if (bindReportKey) {
					qPos.add(reportKey);
				}

				if (!pagination) {
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerReportInstance>(list);
				}
				else {
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer report instance in the ordered set where consumerId = &#63; and reportKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param reportKey the report key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByC_R_First(long consumerId,
		String reportKey, OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByC_R_First(consumerId,
				reportKey, orderByComparator);

		if (consumerReportInstance != null) {
			return consumerReportInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("consumerId=");
		msg.append(consumerId);

		msg.append(", reportKey=");
		msg.append(reportKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerReportInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer report instance in the ordered set where consumerId = &#63; and reportKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param reportKey the report key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByC_R_First(long consumerId,
		String reportKey, OrderByComparator orderByComparator)
		throws SystemException {
		List<ConsumerReportInstance> list = findByC_R(consumerId, reportKey, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer report instance in the ordered set where consumerId = &#63; and reportKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param reportKey the report key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByC_R_Last(long consumerId,
		String reportKey, OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByC_R_Last(consumerId,
				reportKey, orderByComparator);

		if (consumerReportInstance != null) {
			return consumerReportInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("consumerId=");
		msg.append(consumerId);

		msg.append(", reportKey=");
		msg.append(reportKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerReportInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer report instance in the ordered set where consumerId = &#63; and reportKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param reportKey the report key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByC_R_Last(long consumerId,
		String reportKey, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_R(consumerId, reportKey);

		if (count == 0) {
			return null;
		}

		List<ConsumerReportInstance> list = findByC_R(consumerId, reportKey,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer report instances before and after the current consumer report instance in the ordered set where consumerId = &#63; and reportKey = &#63;.
	 *
	 * @param consumerReportInstanceId the primary key of the current consumer report instance
	 * @param consumerId the consumer ID
	 * @param reportKey the report key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance[] findByC_R_PrevAndNext(
		long consumerReportInstanceId, long consumerId, String reportKey,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = findByPrimaryKey(consumerReportInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerReportInstance[] array = new ConsumerReportInstanceImpl[3];

			array[0] = getByC_R_PrevAndNext(session, consumerReportInstance,
					consumerId, reportKey, orderByComparator, true);

			array[1] = consumerReportInstance;

			array[2] = getByC_R_PrevAndNext(session, consumerReportInstance,
					consumerId, reportKey, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsumerReportInstance getByC_R_PrevAndNext(Session session,
		ConsumerReportInstance consumerReportInstance, long consumerId,
		String reportKey, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_C_R_CONSUMERID_2);

		boolean bindReportKey = false;

		if (reportKey == null) {
			query.append(_FINDER_COLUMN_C_R_REPORTKEY_1);
		}
		else if (reportKey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_REPORTKEY_3);
		}
		else {
			bindReportKey = true;

			query.append(_FINDER_COLUMN_C_R_REPORTKEY_2);
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
			query.append(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(consumerId);

		if (bindReportKey) {
			qPos.add(reportKey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(consumerReportInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerReportInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer report instances where consumerId = &#63; and reportKey = &#63; from the database.
	 *
	 * @param consumerId the consumer ID
	 * @param reportKey the report key
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_R(long consumerId, String reportKey)
		throws SystemException {
		for (ConsumerReportInstance consumerReportInstance : findByC_R(
				consumerId, reportKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(consumerReportInstance);
		}
	}

	/**
	 * Returns the number of consumer report instances where consumerId = &#63; and reportKey = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param reportKey the report key
	 * @return the number of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_R(long consumerId, String reportKey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_R;

		Object[] finderArgs = new Object[] { consumerId, reportKey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONSUMERREPORTINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_R_CONSUMERID_2);

			boolean bindReportKey = false;

			if (reportKey == null) {
				query.append(_FINDER_COLUMN_C_R_REPORTKEY_1);
			}
			else if (reportKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_REPORTKEY_3);
			}
			else {
				bindReportKey = true;

				query.append(_FINDER_COLUMN_C_R_REPORTKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(consumerId);

				if (bindReportKey) {
					qPos.add(reportKey);
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

	private static final String _FINDER_COLUMN_C_R_CONSUMERID_2 = "consumerReportInstance.consumerId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_REPORTKEY_1 = "consumerReportInstance.reportKey IS NULL";
	private static final String _FINDER_COLUMN_C_R_REPORTKEY_2 = "consumerReportInstance.reportKey = ?";
	private static final String _FINDER_COLUMN_C_R_REPORTKEY_3 = "(consumerReportInstance.reportKey IS NULL OR consumerReportInstance.reportKey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_R = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_R = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			ConsumerReportInstanceModelImpl.COMPANYID_COLUMN_BITMASK |
			ConsumerReportInstanceModelImpl.CONSUMERID_COLUMN_BITMASK |
			ConsumerReportInstanceModelImpl.REPORTCATEGORYKEY_COLUMN_BITMASK |
			ConsumerReportInstanceModelImpl.REPORTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_R = new FinderPath(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the consumer report instances where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerId the consumer ID
	 * @param reportCategoryKey the report category key
	 * @return the matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByC_C_R(long companyId,
		long consumerId, String reportCategoryKey) throws SystemException {
		return findByC_C_R(companyId, consumerId, reportCategoryKey,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer report instances where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param consumerId the consumer ID
	 * @param reportCategoryKey the report category key
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @return the range of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByC_C_R(long companyId,
		long consumerId, String reportCategoryKey, int start, int end)
		throws SystemException {
		return findByC_C_R(companyId, consumerId, reportCategoryKey, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the consumer report instances where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param consumerId the consumer ID
	 * @param reportCategoryKey the report category key
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findByC_C_R(long companyId,
		long consumerId, String reportCategoryKey, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_R;
			finderArgs = new Object[] { companyId, consumerId, reportCategoryKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_R;
			finderArgs = new Object[] {
					companyId, consumerId, reportCategoryKey,
					
					start, end, orderByComparator
				};
		}

		List<ConsumerReportInstance> list = (List<ConsumerReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerReportInstance consumerReportInstance : list) {
				if ((companyId != consumerReportInstance.getCompanyId()) ||
						(consumerId != consumerReportInstance.getConsumerId()) ||
						!Validator.equals(reportCategoryKey,
							consumerReportInstance.getReportCategoryKey())) {
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

			query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_C_R_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_R_CONSUMERID_2);

			boolean bindReportCategoryKey = false;

			if (reportCategoryKey == null) {
				query.append(_FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_1);
			}
			else if (reportCategoryKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_3);
			}
			else {
				bindReportCategoryKey = true;

				query.append(_FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(consumerId);

				if (bindReportCategoryKey) {
					qPos.add(reportCategoryKey);
				}

				if (!pagination) {
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerReportInstance>(list);
				}
				else {
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
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
	 * Returns the first consumer report instance in the ordered set where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerId the consumer ID
	 * @param reportCategoryKey the report category key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByC_C_R_First(long companyId,
		long consumerId, String reportCategoryKey,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByC_C_R_First(companyId,
				consumerId, reportCategoryKey, orderByComparator);

		if (consumerReportInstance != null) {
			return consumerReportInstance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", consumerId=");
		msg.append(consumerId);

		msg.append(", reportCategoryKey=");
		msg.append(reportCategoryKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerReportInstanceException(msg.toString());
	}

	/**
	 * Returns the first consumer report instance in the ordered set where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerId the consumer ID
	 * @param reportCategoryKey the report category key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByC_C_R_First(long companyId,
		long consumerId, String reportCategoryKey,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConsumerReportInstance> list = findByC_C_R(companyId, consumerId,
				reportCategoryKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer report instance in the ordered set where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerId the consumer ID
	 * @param reportCategoryKey the report category key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByC_C_R_Last(long companyId,
		long consumerId, String reportCategoryKey,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByC_C_R_Last(companyId,
				consumerId, reportCategoryKey, orderByComparator);

		if (consumerReportInstance != null) {
			return consumerReportInstance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", consumerId=");
		msg.append(consumerId);

		msg.append(", reportCategoryKey=");
		msg.append(reportCategoryKey);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerReportInstanceException(msg.toString());
	}

	/**
	 * Returns the last consumer report instance in the ordered set where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerId the consumer ID
	 * @param reportCategoryKey the report category key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByC_C_R_Last(long companyId,
		long consumerId, String reportCategoryKey,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_C_R(companyId, consumerId, reportCategoryKey);

		if (count == 0) {
			return null;
		}

		List<ConsumerReportInstance> list = findByC_C_R(companyId, consumerId,
				reportCategoryKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer report instances before and after the current consumer report instance in the ordered set where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	 *
	 * @param consumerReportInstanceId the primary key of the current consumer report instance
	 * @param companyId the company ID
	 * @param consumerId the consumer ID
	 * @param reportCategoryKey the report category key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance[] findByC_C_R_PrevAndNext(
		long consumerReportInstanceId, long companyId, long consumerId,
		String reportCategoryKey, OrderByComparator orderByComparator)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = findByPrimaryKey(consumerReportInstanceId);

		Session session = null;

		try {
			session = openSession();

			ConsumerReportInstance[] array = new ConsumerReportInstanceImpl[3];

			array[0] = getByC_C_R_PrevAndNext(session, consumerReportInstance,
					companyId, consumerId, reportCategoryKey,
					orderByComparator, true);

			array[1] = consumerReportInstance;

			array[2] = getByC_C_R_PrevAndNext(session, consumerReportInstance,
					companyId, consumerId, reportCategoryKey,
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

	protected ConsumerReportInstance getByC_C_R_PrevAndNext(Session session,
		ConsumerReportInstance consumerReportInstance, long companyId,
		long consumerId, String reportCategoryKey,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_C_C_R_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_C_R_CONSUMERID_2);

		boolean bindReportCategoryKey = false;

		if (reportCategoryKey == null) {
			query.append(_FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_1);
		}
		else if (reportCategoryKey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_3);
		}
		else {
			bindReportCategoryKey = true;

			query.append(_FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_2);
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
			query.append(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(consumerId);

		if (bindReportCategoryKey) {
			qPos.add(reportCategoryKey);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(consumerReportInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerReportInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer report instances where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param consumerId the consumer ID
	 * @param reportCategoryKey the report category key
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_R(long companyId, long consumerId,
		String reportCategoryKey) throws SystemException {
		for (ConsumerReportInstance consumerReportInstance : findByC_C_R(
				companyId, consumerId, reportCategoryKey, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(consumerReportInstance);
		}
	}

	/**
	 * Returns the number of consumer report instances where companyId = &#63; and consumerId = &#63; and reportCategoryKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param consumerId the consumer ID
	 * @param reportCategoryKey the report category key
	 * @return the number of matching consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_R(long companyId, long consumerId,
		String reportCategoryKey) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_R;

		Object[] finderArgs = new Object[] {
				companyId, consumerId, reportCategoryKey
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONSUMERREPORTINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_C_C_R_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_R_CONSUMERID_2);

			boolean bindReportCategoryKey = false;

			if (reportCategoryKey == null) {
				query.append(_FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_1);
			}
			else if (reportCategoryKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_3);
			}
			else {
				bindReportCategoryKey = true;

				query.append(_FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(consumerId);

				if (bindReportCategoryKey) {
					qPos.add(reportCategoryKey);
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

	private static final String _FINDER_COLUMN_C_C_R_COMPANYID_2 = "consumerReportInstance.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_R_CONSUMERID_2 = "consumerReportInstance.consumerId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_1 = "consumerReportInstance.reportCategoryKey IS NULL";
	private static final String _FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_2 = "consumerReportInstance.reportCategoryKey = ?";
	private static final String _FINDER_COLUMN_C_C_R_REPORTCATEGORYKEY_3 = "(consumerReportInstance.reportCategoryKey IS NULL OR consumerReportInstance.reportCategoryKey = '')";

	public ConsumerReportInstancePersistenceImpl() {
		setModelClass(ConsumerReportInstance.class);
	}

	/**
	 * Caches the consumer report instance in the entity cache if it is enabled.
	 *
	 * @param consumerReportInstance the consumer report instance
	 */
	@Override
	public void cacheResult(ConsumerReportInstance consumerReportInstance) {
		EntityCacheUtil.putResult(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			consumerReportInstance.getPrimaryKey(), consumerReportInstance);

		consumerReportInstance.resetOriginalValues();
	}

	/**
	 * Caches the consumer report instances in the entity cache if it is enabled.
	 *
	 * @param consumerReportInstances the consumer report instances
	 */
	@Override
	public void cacheResult(
		List<ConsumerReportInstance> consumerReportInstances) {
		for (ConsumerReportInstance consumerReportInstance : consumerReportInstances) {
			if (EntityCacheUtil.getResult(
						ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ConsumerReportInstanceImpl.class,
						consumerReportInstance.getPrimaryKey()) == null) {
				cacheResult(consumerReportInstance);
			}
			else {
				consumerReportInstance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all consumer report instances.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConsumerReportInstanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConsumerReportInstanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the consumer report instance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConsumerReportInstance consumerReportInstance) {
		EntityCacheUtil.removeResult(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			consumerReportInstance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ConsumerReportInstance> consumerReportInstances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConsumerReportInstance consumerReportInstance : consumerReportInstances) {
			EntityCacheUtil.removeResult(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ConsumerReportInstanceImpl.class,
				consumerReportInstance.getPrimaryKey());
		}
	}

	/**
	 * Creates a new consumer report instance with the primary key. Does not add the consumer report instance to the database.
	 *
	 * @param consumerReportInstanceId the primary key for the new consumer report instance
	 * @return the new consumer report instance
	 */
	@Override
	public ConsumerReportInstance create(long consumerReportInstanceId) {
		ConsumerReportInstance consumerReportInstance = new ConsumerReportInstanceImpl();

		consumerReportInstance.setNew(true);
		consumerReportInstance.setPrimaryKey(consumerReportInstanceId);

		String uuid = PortalUUIDUtil.generate();

		consumerReportInstance.setUuid(uuid);

		return consumerReportInstance;
	}

	/**
	 * Removes the consumer report instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param consumerReportInstanceId the primary key of the consumer report instance
	 * @return the consumer report instance that was removed
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance remove(long consumerReportInstanceId)
		throws NoSuchConsumerReportInstanceException, SystemException {
		return remove((Serializable)consumerReportInstanceId);
	}

	/**
	 * Removes the consumer report instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the consumer report instance
	 * @return the consumer report instance that was removed
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance remove(Serializable primaryKey)
		throws NoSuchConsumerReportInstanceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ConsumerReportInstance consumerReportInstance = (ConsumerReportInstance)session.get(ConsumerReportInstanceImpl.class,
					primaryKey);

			if (consumerReportInstance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConsumerReportInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(consumerReportInstance);
		}
		catch (NoSuchConsumerReportInstanceException nsee) {
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
	protected ConsumerReportInstance removeImpl(
		ConsumerReportInstance consumerReportInstance)
		throws SystemException {
		consumerReportInstance = toUnwrappedModel(consumerReportInstance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(consumerReportInstance)) {
				consumerReportInstance = (ConsumerReportInstance)session.get(ConsumerReportInstanceImpl.class,
						consumerReportInstance.getPrimaryKeyObj());
			}

			if (consumerReportInstance != null) {
				session.delete(consumerReportInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (consumerReportInstance != null) {
			clearCache(consumerReportInstance);
		}

		return consumerReportInstance;
	}

	@Override
	public ConsumerReportInstance updateImpl(
		com.liferay.consumer.manager.model.ConsumerReportInstance consumerReportInstance)
		throws SystemException {
		consumerReportInstance = toUnwrappedModel(consumerReportInstance);

		boolean isNew = consumerReportInstance.isNew();

		ConsumerReportInstanceModelImpl consumerReportInstanceModelImpl = (ConsumerReportInstanceModelImpl)consumerReportInstance;

		if (Validator.isNull(consumerReportInstance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			consumerReportInstance.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (consumerReportInstance.isNew()) {
				session.save(consumerReportInstance);

				consumerReportInstance.setNew(false);
			}
			else {
				session.merge(consumerReportInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ConsumerReportInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((consumerReportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerReportInstanceModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { consumerReportInstanceModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((consumerReportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerReportInstanceModelImpl.getOriginalUuid(),
						consumerReportInstanceModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						consumerReportInstanceModelImpl.getUuid(),
						consumerReportInstanceModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((consumerReportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerReportInstanceModelImpl.getOriginalConsumerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSUMERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERID,
					args);

				args = new Object[] {
						consumerReportInstanceModelImpl.getConsumerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSUMERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSUMERID,
					args);
			}

			if ((consumerReportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerReportInstanceModelImpl.getOriginalConsumerId(),
						consumerReportInstanceModelImpl.getOriginalReportKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R,
					args);

				args = new Object[] {
						consumerReportInstanceModelImpl.getConsumerId(),
						consumerReportInstanceModelImpl.getReportKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R,
					args);
			}

			if ((consumerReportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerReportInstanceModelImpl.getOriginalCompanyId(),
						consumerReportInstanceModelImpl.getOriginalConsumerId(),
						consumerReportInstanceModelImpl.getOriginalReportCategoryKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_R,
					args);

				args = new Object[] {
						consumerReportInstanceModelImpl.getCompanyId(),
						consumerReportInstanceModelImpl.getConsumerId(),
						consumerReportInstanceModelImpl.getReportCategoryKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_R,
					args);
			}
		}

		EntityCacheUtil.putResult(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerReportInstanceImpl.class,
			consumerReportInstance.getPrimaryKey(), consumerReportInstance);

		return consumerReportInstance;
	}

	protected ConsumerReportInstance toUnwrappedModel(
		ConsumerReportInstance consumerReportInstance) {
		if (consumerReportInstance instanceof ConsumerReportInstanceImpl) {
			return consumerReportInstance;
		}

		ConsumerReportInstanceImpl consumerReportInstanceImpl = new ConsumerReportInstanceImpl();

		consumerReportInstanceImpl.setNew(consumerReportInstance.isNew());
		consumerReportInstanceImpl.setPrimaryKey(consumerReportInstance.getPrimaryKey());

		consumerReportInstanceImpl.setUuid(consumerReportInstance.getUuid());
		consumerReportInstanceImpl.setConsumerReportInstanceId(consumerReportInstance.getConsumerReportInstanceId());
		consumerReportInstanceImpl.setCompanyId(consumerReportInstance.getCompanyId());
		consumerReportInstanceImpl.setUserId(consumerReportInstance.getUserId());
		consumerReportInstanceImpl.setUserName(consumerReportInstance.getUserName());
		consumerReportInstanceImpl.setCreateDate(consumerReportInstance.getCreateDate());
		consumerReportInstanceImpl.setModifiedDate(consumerReportInstance.getModifiedDate());
		consumerReportInstanceImpl.setConsumerId(consumerReportInstance.getConsumerId());
		consumerReportInstanceImpl.setReportCategoryKey(consumerReportInstance.getReportCategoryKey());
		consumerReportInstanceImpl.setReportKey(consumerReportInstance.getReportKey());
		consumerReportInstanceImpl.setName(consumerReportInstance.getName());
		consumerReportInstanceImpl.setDescription(consumerReportInstance.getDescription());
		consumerReportInstanceImpl.setTypeSettings(consumerReportInstance.getTypeSettings());

		return consumerReportInstanceImpl;
	}

	/**
	 * Returns the consumer report instance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the consumer report instance
	 * @return the consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConsumerReportInstanceException, SystemException {
		ConsumerReportInstance consumerReportInstance = fetchByPrimaryKey(primaryKey);

		if (consumerReportInstance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConsumerReportInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return consumerReportInstance;
	}

	/**
	 * Returns the consumer report instance with the primary key or throws a {@link com.liferay.consumer.manager.NoSuchConsumerReportInstanceException} if it could not be found.
	 *
	 * @param consumerReportInstanceId the primary key of the consumer report instance
	 * @return the consumer report instance
	 * @throws com.liferay.consumer.manager.NoSuchConsumerReportInstanceException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance findByPrimaryKey(
		long consumerReportInstanceId)
		throws NoSuchConsumerReportInstanceException, SystemException {
		return findByPrimaryKey((Serializable)consumerReportInstanceId);
	}

	/**
	 * Returns the consumer report instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the consumer report instance
	 * @return the consumer report instance, or <code>null</code> if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ConsumerReportInstance consumerReportInstance = (ConsumerReportInstance)EntityCacheUtil.getResult(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ConsumerReportInstanceImpl.class, primaryKey);

		if (consumerReportInstance == _nullConsumerReportInstance) {
			return null;
		}

		if (consumerReportInstance == null) {
			Session session = null;

			try {
				session = openSession();

				consumerReportInstance = (ConsumerReportInstance)session.get(ConsumerReportInstanceImpl.class,
						primaryKey);

				if (consumerReportInstance != null) {
					cacheResult(consumerReportInstance);
				}
				else {
					EntityCacheUtil.putResult(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ConsumerReportInstanceImpl.class, primaryKey,
						_nullConsumerReportInstance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConsumerReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
					ConsumerReportInstanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return consumerReportInstance;
	}

	/**
	 * Returns the consumer report instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param consumerReportInstanceId the primary key of the consumer report instance
	 * @return the consumer report instance, or <code>null</code> if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchByPrimaryKey(
		long consumerReportInstanceId) throws SystemException {
		return fetchByPrimaryKey((Serializable)consumerReportInstanceId);
	}

	/**
	 * Returns all the consumer report instances.
	 *
	 * @return the consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer report instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @return the range of consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer report instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> findAll(int start, int end,
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

		List<ConsumerReportInstance> list = (List<ConsumerReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONSUMERREPORTINSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONSUMERREPORTINSTANCE;

				if (pagination) {
					sql = sql.concat(ConsumerReportInstanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerReportInstance>(list);
				}
				else {
					list = (List<ConsumerReportInstance>)QueryUtil.list(q,
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
	 * Removes all the consumer report instances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ConsumerReportInstance consumerReportInstance : findAll()) {
			remove(consumerReportInstance);
		}
	}

	/**
	 * Returns the number of consumer report instances.
	 *
	 * @return the number of consumer report instances
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

				Query q = session.createQuery(_SQL_COUNT_CONSUMERREPORTINSTANCE);

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
	 * Initializes the consumer report instance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.consumer.manager.model.ConsumerReportInstance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ConsumerReportInstance>> listenersList = new ArrayList<ModelListener<ConsumerReportInstance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ConsumerReportInstance>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConsumerReportInstanceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONSUMERREPORTINSTANCE = "SELECT consumerReportInstance FROM ConsumerReportInstance consumerReportInstance";
	private static final String _SQL_SELECT_CONSUMERREPORTINSTANCE_WHERE = "SELECT consumerReportInstance FROM ConsumerReportInstance consumerReportInstance WHERE ";
	private static final String _SQL_COUNT_CONSUMERREPORTINSTANCE = "SELECT COUNT(consumerReportInstance) FROM ConsumerReportInstance consumerReportInstance";
	private static final String _SQL_COUNT_CONSUMERREPORTINSTANCE_WHERE = "SELECT COUNT(consumerReportInstance) FROM ConsumerReportInstance consumerReportInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "consumerReportInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConsumerReportInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ConsumerReportInstance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConsumerReportInstancePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ConsumerReportInstance _nullConsumerReportInstance = new ConsumerReportInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ConsumerReportInstance> toCacheModel() {
				return _nullConsumerReportInstanceCacheModel;
			}
		};

	private static CacheModel<ConsumerReportInstance> _nullConsumerReportInstanceCacheModel =
		new CacheModel<ConsumerReportInstance>() {
			@Override
			public ConsumerReportInstance toEntityModel() {
				return _nullConsumerReportInstance;
			}
		};
}