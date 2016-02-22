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

import com.liferay.content.targeting.exception.NoSuchRuleInstanceException;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.impl.RuleInstanceImpl;
import com.liferay.content.targeting.model.impl.RuleInstanceModelImpl;
import com.liferay.content.targeting.service.persistence.RuleInstancePersistence;

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
 * The persistence implementation for the rule instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstancePersistence
 * @see com.liferay.content.targeting.service.persistence.RuleInstanceUtil
 * @generated
 */
@ProviderType
public class RuleInstancePersistenceImpl extends BasePersistenceImpl<RuleInstance>
	implements RuleInstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RuleInstanceUtil} to access the rule instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RuleInstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RuleInstanceModelImpl.UUID_COLUMN_BITMASK |
			RuleInstanceModelImpl.RULEKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rule instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rule instances
	 */
	@Override
	public List<RuleInstance> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RuleInstance> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<RuleInstance> findByUuid(String uuid, int start, int end,
		OrderByComparator<RuleInstance> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<RuleInstance> findByUuid(String uuid, int start, int end,
		OrderByComparator<RuleInstance> orderByComparator,
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

		List<RuleInstance> list = null;

		if (retrieveFromCache) {
			list = (List<RuleInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RuleInstance ruleInstance : list) {
					if (!Validator.equals(uuid, ruleInstance.getUuid())) {
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

			query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

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
				query.append(RuleInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first rule instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance
	 * @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance findByUuid_First(String uuid,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByUuid_First(uuid, orderByComparator);

		if (ruleInstance != null) {
			return ruleInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleInstanceException(msg.toString());
	}

	/**
	 * Returns the first rule instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByUuid_First(String uuid,
		OrderByComparator<RuleInstance> orderByComparator) {
		List<RuleInstance> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rule instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule instance
	 * @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance findByUuid_Last(String uuid,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByUuid_Last(uuid, orderByComparator);

		if (ruleInstance != null) {
			return ruleInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleInstanceException(msg.toString());
	}

	/**
	 * Returns the last rule instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByUuid_Last(String uuid,
		OrderByComparator<RuleInstance> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RuleInstance> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RuleInstance[] findByUuid_PrevAndNext(long ruleInstanceId,
		String uuid, OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = findByPrimaryKey(ruleInstanceId);

		Session session = null;

		try {
			session = openSession();

			RuleInstance[] array = new RuleInstanceImpl[3];

			array[0] = getByUuid_PrevAndNext(session, ruleInstance, uuid,
					orderByComparator, true);

			array[1] = ruleInstance;

			array[2] = getByUuid_PrevAndNext(session, ruleInstance, uuid,
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

	protected RuleInstance getByUuid_PrevAndNext(Session session,
		RuleInstance ruleInstance, String uuid,
		OrderByComparator<RuleInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

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
			query.append(RuleInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ruleInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RuleInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rule instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RuleInstance ruleInstance : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ruleInstance);
		}
	}

	/**
	 * Returns the number of rule instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rule instances
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RULEINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "ruleInstance.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "ruleInstance.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(ruleInstance.uuid IS NULL OR ruleInstance.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RuleInstanceModelImpl.UUID_COLUMN_BITMASK |
			RuleInstanceModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the rule instance where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchRuleInstanceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rule instance
	 * @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByUUID_G(uuid, groupId);

		if (ruleInstance == null) {
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

			throw new NoSuchRuleInstanceException(msg.toString());
		}

		return ruleInstance;
	}

	/**
	 * Returns the rule instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rule instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof RuleInstance) {
			RuleInstance ruleInstance = (RuleInstance)result;

			if (!Validator.equals(uuid, ruleInstance.getUuid()) ||
					(groupId != ruleInstance.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

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

				List<RuleInstance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RuleInstance ruleInstance = list.get(0);

					result = ruleInstance;

					cacheResult(ruleInstance);

					if ((ruleInstance.getUuid() == null) ||
							!ruleInstance.getUuid().equals(uuid) ||
							(ruleInstance.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, ruleInstance);
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
			return (RuleInstance)result;
		}
	}

	/**
	 * Removes the rule instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rule instance that was removed
	 */
	@Override
	public RuleInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = findByUUID_G(uuid, groupId);

		return remove(ruleInstance);
	}

	/**
	 * Returns the number of rule instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rule instances
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RULEINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "ruleInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "ruleInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(ruleInstance.uuid IS NULL OR ruleInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "ruleInstance.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RuleInstanceModelImpl.UUID_COLUMN_BITMASK |
			RuleInstanceModelImpl.COMPANYID_COLUMN_BITMASK |
			RuleInstanceModelImpl.RULEKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rule instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rule instances
	 */
	@Override
	public List<RuleInstance> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<RuleInstance> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<RuleInstance> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<RuleInstance> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<RuleInstance> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<RuleInstance> orderByComparator,
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

		List<RuleInstance> list = null;

		if (retrieveFromCache) {
			list = (List<RuleInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RuleInstance ruleInstance : list) {
					if (!Validator.equals(uuid, ruleInstance.getUuid()) ||
							(companyId != ruleInstance.getCompanyId())) {
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

			query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

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
				query.append(RuleInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance
	 * @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (ruleInstance != null) {
			return ruleInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleInstanceException(msg.toString());
	}

	/**
	 * Returns the first rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<RuleInstance> orderByComparator) {
		List<RuleInstance> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RuleInstance findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (ruleInstance != null) {
			return ruleInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleInstanceException(msg.toString());
	}

	/**
	 * Returns the last rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<RuleInstance> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RuleInstance> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RuleInstance[] findByUuid_C_PrevAndNext(long ruleInstanceId,
		String uuid, long companyId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = findByPrimaryKey(ruleInstanceId);

		Session session = null;

		try {
			session = openSession();

			RuleInstance[] array = new RuleInstanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, ruleInstance, uuid,
					companyId, orderByComparator, true);

			array[1] = ruleInstance;

			array[2] = getByUuid_C_PrevAndNext(session, ruleInstance, uuid,
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

	protected RuleInstance getByUuid_C_PrevAndNext(Session session,
		RuleInstance ruleInstance, String uuid, long companyId,
		OrderByComparator<RuleInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

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
			query.append(RuleInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ruleInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RuleInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rule instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (RuleInstance ruleInstance : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ruleInstance);
		}
	}

	/**
	 * Returns the number of rule instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rule instances
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RULEINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "ruleInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "ruleInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(ruleInstance.uuid IS NULL OR ruleInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "ruleInstance.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			RuleInstanceModelImpl.GROUPID_COLUMN_BITMASK |
			RuleInstanceModelImpl.RULEKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rule instances where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching rule instances
	 */
	@Override
	public List<RuleInstance> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RuleInstance> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<RuleInstance> findByGroupId(long groupId, int start, int end,
		OrderByComparator<RuleInstance> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<RuleInstance> findByGroupId(long groupId, int start, int end,
		OrderByComparator<RuleInstance> orderByComparator,
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

		List<RuleInstance> list = null;

		if (retrieveFromCache) {
			list = (List<RuleInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RuleInstance ruleInstance : list) {
					if ((groupId != ruleInstance.getGroupId())) {
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

			query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RuleInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first rule instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance
	 * @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance findByGroupId_First(long groupId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByGroupId_First(groupId,
				orderByComparator);

		if (ruleInstance != null) {
			return ruleInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleInstanceException(msg.toString());
	}

	/**
	 * Returns the first rule instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByGroupId_First(long groupId,
		OrderByComparator<RuleInstance> orderByComparator) {
		List<RuleInstance> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rule instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule instance
	 * @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance findByGroupId_Last(long groupId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (ruleInstance != null) {
			return ruleInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleInstanceException(msg.toString());
	}

	/**
	 * Returns the last rule instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByGroupId_Last(long groupId,
		OrderByComparator<RuleInstance> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<RuleInstance> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RuleInstance[] findByGroupId_PrevAndNext(long ruleInstanceId,
		long groupId, OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = findByPrimaryKey(ruleInstanceId);

		Session session = null;

		try {
			session = openSession();

			RuleInstance[] array = new RuleInstanceImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, ruleInstance, groupId,
					orderByComparator, true);

			array[1] = ruleInstance;

			array[2] = getByGroupId_PrevAndNext(session, ruleInstance, groupId,
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

	protected RuleInstance getByGroupId_PrevAndNext(Session session,
		RuleInstance ruleInstance, long groupId,
		OrderByComparator<RuleInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

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
			query.append(RuleInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ruleInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RuleInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rule instances where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (RuleInstance ruleInstance : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ruleInstance);
		}
	}

	/**
	 * Returns the number of rule instances where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching rule instances
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RULEINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "ruleInstance.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSEGMENTID =
		new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserSegmentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID =
		new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserSegmentId",
			new String[] { Long.class.getName() },
			RuleInstanceModelImpl.USERSEGMENTID_COLUMN_BITMASK |
			RuleInstanceModelImpl.RULEKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERSEGMENTID = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserSegmentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rule instances where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @return the matching rule instances
	 */
	@Override
	public List<RuleInstance> findByUserSegmentId(long userSegmentId) {
		return findByUserSegmentId(userSegmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<RuleInstance> findByUserSegmentId(long userSegmentId,
		int start, int end) {
		return findByUserSegmentId(userSegmentId, start, end, null);
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
	@Override
	public List<RuleInstance> findByUserSegmentId(long userSegmentId,
		int start, int end, OrderByComparator<RuleInstance> orderByComparator) {
		return findByUserSegmentId(userSegmentId, start, end,
			orderByComparator, true);
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
	@Override
	public List<RuleInstance> findByUserSegmentId(long userSegmentId,
		int start, int end, OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID;
			finderArgs = new Object[] { userSegmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSEGMENTID;
			finderArgs = new Object[] {
					userSegmentId,
					
					start, end, orderByComparator
				};
		}

		List<RuleInstance> list = null;

		if (retrieveFromCache) {
			list = (List<RuleInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RuleInstance ruleInstance : list) {
					if ((userSegmentId != ruleInstance.getUserSegmentId())) {
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

			query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_USERSEGMENTID_USERSEGMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RuleInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userSegmentId);

				if (!pagination) {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first rule instance in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance
	 * @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance findByUserSegmentId_First(long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByUserSegmentId_First(userSegmentId,
				orderByComparator);

		if (ruleInstance != null) {
			return ruleInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userSegmentId=");
		msg.append(userSegmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleInstanceException(msg.toString());
	}

	/**
	 * Returns the first rule instance in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByUserSegmentId_First(long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator) {
		List<RuleInstance> list = findByUserSegmentId(userSegmentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rule instance in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule instance
	 * @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance findByUserSegmentId_Last(long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByUserSegmentId_Last(userSegmentId,
				orderByComparator);

		if (ruleInstance != null) {
			return ruleInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userSegmentId=");
		msg.append(userSegmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleInstanceException(msg.toString());
	}

	/**
	 * Returns the last rule instance in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByUserSegmentId_Last(long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator) {
		int count = countByUserSegmentId(userSegmentId);

		if (count == 0) {
			return null;
		}

		List<RuleInstance> list = findByUserSegmentId(userSegmentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RuleInstance[] findByUserSegmentId_PrevAndNext(long ruleInstanceId,
		long userSegmentId, OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = findByPrimaryKey(ruleInstanceId);

		Session session = null;

		try {
			session = openSession();

			RuleInstance[] array = new RuleInstanceImpl[3];

			array[0] = getByUserSegmentId_PrevAndNext(session, ruleInstance,
					userSegmentId, orderByComparator, true);

			array[1] = ruleInstance;

			array[2] = getByUserSegmentId_PrevAndNext(session, ruleInstance,
					userSegmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RuleInstance getByUserSegmentId_PrevAndNext(Session session,
		RuleInstance ruleInstance, long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_USERSEGMENTID_USERSEGMENTID_2);

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
			query.append(RuleInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userSegmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ruleInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RuleInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rule instances where userSegmentId = &#63; from the database.
	 *
	 * @param userSegmentId the user segment ID
	 */
	@Override
	public void removeByUserSegmentId(long userSegmentId) {
		for (RuleInstance ruleInstance : findByUserSegmentId(userSegmentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ruleInstance);
		}
	}

	/**
	 * Returns the number of rule instances where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @return the number of matching rule instances
	 */
	@Override
	public int countByUserSegmentId(long userSegmentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERSEGMENTID;

		Object[] finderArgs = new Object[] { userSegmentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RULEINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_USERSEGMENTID_USERSEGMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userSegmentId);

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

	private static final String _FINDER_COLUMN_USERSEGMENTID_USERSEGMENTID_2 = "ruleInstance.userSegmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_U = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_U",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_U = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, RuleInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_U",
			new String[] { String.class.getName(), Long.class.getName() },
			RuleInstanceModelImpl.RULEKEY_COLUMN_BITMASK |
			RuleInstanceModelImpl.USERSEGMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_U = new FinderPath(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_U",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	 *
	 * @param ruleKey the rule key
	 * @param userSegmentId the user segment ID
	 * @return the matching rule instances
	 */
	@Override
	public List<RuleInstance> findByR_U(String ruleKey, long userSegmentId) {
		return findByR_U(ruleKey, userSegmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<RuleInstance> findByR_U(String ruleKey, long userSegmentId,
		int start, int end) {
		return findByR_U(ruleKey, userSegmentId, start, end, null);
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
	@Override
	public List<RuleInstance> findByR_U(String ruleKey, long userSegmentId,
		int start, int end, OrderByComparator<RuleInstance> orderByComparator) {
		return findByR_U(ruleKey, userSegmentId, start, end, orderByComparator,
			true);
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
	@Override
	public List<RuleInstance> findByR_U(String ruleKey, long userSegmentId,
		int start, int end, OrderByComparator<RuleInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_U;
			finderArgs = new Object[] { ruleKey, userSegmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_U;
			finderArgs = new Object[] {
					ruleKey, userSegmentId,
					
					start, end, orderByComparator
				};
		}

		List<RuleInstance> list = null;

		if (retrieveFromCache) {
			list = (List<RuleInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RuleInstance ruleInstance : list) {
					if (!Validator.equals(ruleKey, ruleInstance.getRuleKey()) ||
							(userSegmentId != ruleInstance.getUserSegmentId())) {
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

			query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

			boolean bindRuleKey = false;

			if (ruleKey == null) {
				query.append(_FINDER_COLUMN_R_U_RULEKEY_1);
			}
			else if (ruleKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_U_RULEKEY_3);
			}
			else {
				bindRuleKey = true;

				query.append(_FINDER_COLUMN_R_U_RULEKEY_2);
			}

			query.append(_FINDER_COLUMN_R_U_USERSEGMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RuleInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRuleKey) {
					qPos.add(ruleKey);
				}

				qPos.add(userSegmentId);

				if (!pagination) {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	 *
	 * @param ruleKey the rule key
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance
	 * @throws NoSuchRuleInstanceException if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance findByR_U_First(String ruleKey, long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByR_U_First(ruleKey, userSegmentId,
				orderByComparator);

		if (ruleInstance != null) {
			return ruleInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleKey=");
		msg.append(ruleKey);

		msg.append(", userSegmentId=");
		msg.append(userSegmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleInstanceException(msg.toString());
	}

	/**
	 * Returns the first rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	 *
	 * @param ruleKey the rule key
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByR_U_First(String ruleKey, long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator) {
		List<RuleInstance> list = findByR_U(ruleKey, userSegmentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RuleInstance findByR_U_Last(String ruleKey, long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByR_U_Last(ruleKey, userSegmentId,
				orderByComparator);

		if (ruleInstance != null) {
			return ruleInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleKey=");
		msg.append(ruleKey);

		msg.append(", userSegmentId=");
		msg.append(userSegmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleInstanceException(msg.toString());
	}

	/**
	 * Returns the last rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	 *
	 * @param ruleKey the rule key
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 */
	@Override
	public RuleInstance fetchByR_U_Last(String ruleKey, long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator) {
		int count = countByR_U(ruleKey, userSegmentId);

		if (count == 0) {
			return null;
		}

		List<RuleInstance> list = findByR_U(ruleKey, userSegmentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RuleInstance[] findByR_U_PrevAndNext(long ruleInstanceId,
		String ruleKey, long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = findByPrimaryKey(ruleInstanceId);

		Session session = null;

		try {
			session = openSession();

			RuleInstance[] array = new RuleInstanceImpl[3];

			array[0] = getByR_U_PrevAndNext(session, ruleInstance, ruleKey,
					userSegmentId, orderByComparator, true);

			array[1] = ruleInstance;

			array[2] = getByR_U_PrevAndNext(session, ruleInstance, ruleKey,
					userSegmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RuleInstance getByR_U_PrevAndNext(Session session,
		RuleInstance ruleInstance, String ruleKey, long userSegmentId,
		OrderByComparator<RuleInstance> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_RULEINSTANCE_WHERE);

		boolean bindRuleKey = false;

		if (ruleKey == null) {
			query.append(_FINDER_COLUMN_R_U_RULEKEY_1);
		}
		else if (ruleKey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_R_U_RULEKEY_3);
		}
		else {
			bindRuleKey = true;

			query.append(_FINDER_COLUMN_R_U_RULEKEY_2);
		}

		query.append(_FINDER_COLUMN_R_U_USERSEGMENTID_2);

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
			query.append(RuleInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRuleKey) {
			qPos.add(ruleKey);
		}

		qPos.add(userSegmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ruleInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RuleInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rule instances where ruleKey = &#63; and userSegmentId = &#63; from the database.
	 *
	 * @param ruleKey the rule key
	 * @param userSegmentId the user segment ID
	 */
	@Override
	public void removeByR_U(String ruleKey, long userSegmentId) {
		for (RuleInstance ruleInstance : findByR_U(ruleKey, userSegmentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ruleInstance);
		}
	}

	/**
	 * Returns the number of rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	 *
	 * @param ruleKey the rule key
	 * @param userSegmentId the user segment ID
	 * @return the number of matching rule instances
	 */
	@Override
	public int countByR_U(String ruleKey, long userSegmentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_U;

		Object[] finderArgs = new Object[] { ruleKey, userSegmentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RULEINSTANCE_WHERE);

			boolean bindRuleKey = false;

			if (ruleKey == null) {
				query.append(_FINDER_COLUMN_R_U_RULEKEY_1);
			}
			else if (ruleKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_U_RULEKEY_3);
			}
			else {
				bindRuleKey = true;

				query.append(_FINDER_COLUMN_R_U_RULEKEY_2);
			}

			query.append(_FINDER_COLUMN_R_U_USERSEGMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRuleKey) {
					qPos.add(ruleKey);
				}

				qPos.add(userSegmentId);

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

	private static final String _FINDER_COLUMN_R_U_RULEKEY_1 = "ruleInstance.ruleKey IS NULL AND ";
	private static final String _FINDER_COLUMN_R_U_RULEKEY_2 = "ruleInstance.ruleKey = ? AND ";
	private static final String _FINDER_COLUMN_R_U_RULEKEY_3 = "(ruleInstance.ruleKey IS NULL OR ruleInstance.ruleKey = '') AND ";
	private static final String _FINDER_COLUMN_R_U_USERSEGMENTID_2 = "ruleInstance.userSegmentId = ?";

	public RuleInstancePersistenceImpl() {
		setModelClass(RuleInstance.class);
	}

	/**
	 * Caches the rule instance in the entity cache if it is enabled.
	 *
	 * @param ruleInstance the rule instance
	 */
	@Override
	public void cacheResult(RuleInstance ruleInstance) {
		entityCache.putResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceImpl.class, ruleInstance.getPrimaryKey(), ruleInstance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { ruleInstance.getUuid(), ruleInstance.getGroupId() },
			ruleInstance);

		ruleInstance.resetOriginalValues();
	}

	/**
	 * Caches the rule instances in the entity cache if it is enabled.
	 *
	 * @param ruleInstances the rule instances
	 */
	@Override
	public void cacheResult(List<RuleInstance> ruleInstances) {
		for (RuleInstance ruleInstance : ruleInstances) {
			if (entityCache.getResult(
						RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
						RuleInstanceImpl.class, ruleInstance.getPrimaryKey()) == null) {
				cacheResult(ruleInstance);
			}
			else {
				ruleInstance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rule instances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RuleInstanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rule instance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RuleInstance ruleInstance) {
		entityCache.removeResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceImpl.class, ruleInstance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((RuleInstanceModelImpl)ruleInstance);
	}

	@Override
	public void clearCache(List<RuleInstance> ruleInstances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RuleInstance ruleInstance : ruleInstances) {
			entityCache.removeResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
				RuleInstanceImpl.class, ruleInstance.getPrimaryKey());

			clearUniqueFindersCache((RuleInstanceModelImpl)ruleInstance);
		}
	}

	protected void cacheUniqueFindersCache(
		RuleInstanceModelImpl ruleInstanceModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					ruleInstanceModelImpl.getUuid(),
					ruleInstanceModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				ruleInstanceModelImpl);
		}
		else {
			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getUuid(),
						ruleInstanceModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					ruleInstanceModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		RuleInstanceModelImpl ruleInstanceModelImpl) {
		Object[] args = new Object[] {
				ruleInstanceModelImpl.getUuid(),
				ruleInstanceModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((ruleInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					ruleInstanceModelImpl.getOriginalUuid(),
					ruleInstanceModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new rule instance with the primary key. Does not add the rule instance to the database.
	 *
	 * @param ruleInstanceId the primary key for the new rule instance
	 * @return the new rule instance
	 */
	@Override
	public RuleInstance create(long ruleInstanceId) {
		RuleInstance ruleInstance = new RuleInstanceImpl();

		ruleInstance.setNew(true);
		ruleInstance.setPrimaryKey(ruleInstanceId);

		String uuid = PortalUUIDUtil.generate();

		ruleInstance.setUuid(uuid);

		ruleInstance.setCompanyId(companyProvider.getCompanyId());

		return ruleInstance;
	}

	/**
	 * Removes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleInstanceId the primary key of the rule instance
	 * @return the rule instance that was removed
	 * @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 */
	@Override
	public RuleInstance remove(long ruleInstanceId)
		throws NoSuchRuleInstanceException {
		return remove((Serializable)ruleInstanceId);
	}

	/**
	 * Removes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rule instance
	 * @return the rule instance that was removed
	 * @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 */
	@Override
	public RuleInstance remove(Serializable primaryKey)
		throws NoSuchRuleInstanceException {
		Session session = null;

		try {
			session = openSession();

			RuleInstance ruleInstance = (RuleInstance)session.get(RuleInstanceImpl.class,
					primaryKey);

			if (ruleInstance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRuleInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ruleInstance);
		}
		catch (NoSuchRuleInstanceException nsee) {
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
	protected RuleInstance removeImpl(RuleInstance ruleInstance) {
		ruleInstance = toUnwrappedModel(ruleInstance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ruleInstance)) {
				ruleInstance = (RuleInstance)session.get(RuleInstanceImpl.class,
						ruleInstance.getPrimaryKeyObj());
			}

			if (ruleInstance != null) {
				session.delete(ruleInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ruleInstance != null) {
			clearCache(ruleInstance);
		}

		return ruleInstance;
	}

	@Override
	public RuleInstance updateImpl(RuleInstance ruleInstance) {
		ruleInstance = toUnwrappedModel(ruleInstance);

		boolean isNew = ruleInstance.isNew();

		RuleInstanceModelImpl ruleInstanceModelImpl = (RuleInstanceModelImpl)ruleInstance;

		if (Validator.isNull(ruleInstance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ruleInstance.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ruleInstance.getCreateDate() == null)) {
			if (serviceContext == null) {
				ruleInstance.setCreateDate(now);
			}
			else {
				ruleInstance.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!ruleInstanceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ruleInstance.setModifiedDate(now);
			}
			else {
				ruleInstance.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ruleInstance.isNew()) {
				session.save(ruleInstance);

				ruleInstance.setNew(false);
			}
			else {
				ruleInstance = (RuleInstance)session.merge(ruleInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RuleInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { ruleInstanceModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getOriginalUuid(),
						ruleInstanceModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						ruleInstanceModelImpl.getUuid(),
						ruleInstanceModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { ruleInstanceModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getOriginalUserSegmentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERSEGMENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID,
					args);

				args = new Object[] { ruleInstanceModelImpl.getUserSegmentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERSEGMENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID,
					args);
			}

			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getOriginalRuleKey(),
						ruleInstanceModelImpl.getOriginalUserSegmentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_U,
					args);

				args = new Object[] {
						ruleInstanceModelImpl.getRuleKey(),
						ruleInstanceModelImpl.getUserSegmentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_U,
					args);
			}
		}

		entityCache.putResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceImpl.class, ruleInstance.getPrimaryKey(), ruleInstance,
			false);

		clearUniqueFindersCache(ruleInstanceModelImpl);
		cacheUniqueFindersCache(ruleInstanceModelImpl, isNew);

		ruleInstance.resetOriginalValues();

		return ruleInstance;
	}

	protected RuleInstance toUnwrappedModel(RuleInstance ruleInstance) {
		if (ruleInstance instanceof RuleInstanceImpl) {
			return ruleInstance;
		}

		RuleInstanceImpl ruleInstanceImpl = new RuleInstanceImpl();

		ruleInstanceImpl.setNew(ruleInstance.isNew());
		ruleInstanceImpl.setPrimaryKey(ruleInstance.getPrimaryKey());

		ruleInstanceImpl.setUuid(ruleInstance.getUuid());
		ruleInstanceImpl.setRuleInstanceId(ruleInstance.getRuleInstanceId());
		ruleInstanceImpl.setGroupId(ruleInstance.getGroupId());
		ruleInstanceImpl.setCompanyId(ruleInstance.getCompanyId());
		ruleInstanceImpl.setUserId(ruleInstance.getUserId());
		ruleInstanceImpl.setUserName(ruleInstance.getUserName());
		ruleInstanceImpl.setCreateDate(ruleInstance.getCreateDate());
		ruleInstanceImpl.setModifiedDate(ruleInstance.getModifiedDate());
		ruleInstanceImpl.setRuleKey(ruleInstance.getRuleKey());
		ruleInstanceImpl.setUserSegmentId(ruleInstance.getUserSegmentId());
		ruleInstanceImpl.setTypeSettings(ruleInstance.getTypeSettings());

		return ruleInstanceImpl;
	}

	/**
	 * Returns the rule instance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule instance
	 * @return the rule instance
	 * @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 */
	@Override
	public RuleInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRuleInstanceException {
		RuleInstance ruleInstance = fetchByPrimaryKey(primaryKey);

		if (ruleInstance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRuleInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ruleInstance;
	}

	/**
	 * Returns the rule instance with the primary key or throws a {@link NoSuchRuleInstanceException} if it could not be found.
	 *
	 * @param ruleInstanceId the primary key of the rule instance
	 * @return the rule instance
	 * @throws NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 */
	@Override
	public RuleInstance findByPrimaryKey(long ruleInstanceId)
		throws NoSuchRuleInstanceException {
		return findByPrimaryKey((Serializable)ruleInstanceId);
	}

	/**
	 * Returns the rule instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule instance
	 * @return the rule instance, or <code>null</code> if a rule instance with the primary key could not be found
	 */
	@Override
	public RuleInstance fetchByPrimaryKey(Serializable primaryKey) {
		RuleInstance ruleInstance = (RuleInstance)entityCache.getResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
				RuleInstanceImpl.class, primaryKey);

		if (ruleInstance == _nullRuleInstance) {
			return null;
		}

		if (ruleInstance == null) {
			Session session = null;

			try {
				session = openSession();

				ruleInstance = (RuleInstance)session.get(RuleInstanceImpl.class,
						primaryKey);

				if (ruleInstance != null) {
					cacheResult(ruleInstance);
				}
				else {
					entityCache.putResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
						RuleInstanceImpl.class, primaryKey, _nullRuleInstance);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
					RuleInstanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ruleInstance;
	}

	/**
	 * Returns the rule instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleInstanceId the primary key of the rule instance
	 * @return the rule instance, or <code>null</code> if a rule instance with the primary key could not be found
	 */
	@Override
	public RuleInstance fetchByPrimaryKey(long ruleInstanceId) {
		return fetchByPrimaryKey((Serializable)ruleInstanceId);
	}

	@Override
	public Map<Serializable, RuleInstance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RuleInstance> map = new HashMap<Serializable, RuleInstance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RuleInstance ruleInstance = fetchByPrimaryKey(primaryKey);

			if (ruleInstance != null) {
				map.put(primaryKey, ruleInstance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			RuleInstance ruleInstance = (RuleInstance)entityCache.getResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
					RuleInstanceImpl.class, primaryKey);

			if (ruleInstance == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, ruleInstance);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RULEINSTANCE_WHERE_PKS_IN);

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

			for (RuleInstance ruleInstance : (List<RuleInstance>)q.list()) {
				map.put(ruleInstance.getPrimaryKeyObj(), ruleInstance);

				cacheResult(ruleInstance);

				uncachedPrimaryKeys.remove(ruleInstance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
					RuleInstanceImpl.class, primaryKey, _nullRuleInstance);
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
	 * Returns all the rule instances.
	 *
	 * @return the rule instances
	 */
	@Override
	public List<RuleInstance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RuleInstance> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<RuleInstance> findAll(int start, int end,
		OrderByComparator<RuleInstance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<RuleInstance> findAll(int start, int end,
		OrderByComparator<RuleInstance> orderByComparator,
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

		List<RuleInstance> list = null;

		if (retrieveFromCache) {
			list = (List<RuleInstance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RULEINSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RULEINSTANCE;

				if (pagination) {
					sql = sql.concat(RuleInstanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the rule instances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RuleInstance ruleInstance : findAll()) {
			remove(ruleInstance);
		}
	}

	/**
	 * Returns the number of rule instances.
	 *
	 * @return the number of rule instances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RULEINSTANCE);

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
		return RuleInstanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rule instance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RuleInstanceImpl.class.getName());
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
	private static final String _SQL_SELECT_RULEINSTANCE = "SELECT ruleInstance FROM RuleInstance ruleInstance";
	private static final String _SQL_SELECT_RULEINSTANCE_WHERE_PKS_IN = "SELECT ruleInstance FROM RuleInstance ruleInstance WHERE ruleInstanceId IN (";
	private static final String _SQL_SELECT_RULEINSTANCE_WHERE = "SELECT ruleInstance FROM RuleInstance ruleInstance WHERE ";
	private static final String _SQL_COUNT_RULEINSTANCE = "SELECT COUNT(ruleInstance) FROM RuleInstance ruleInstance";
	private static final String _SQL_COUNT_RULEINSTANCE_WHERE = "SELECT COUNT(ruleInstance) FROM RuleInstance ruleInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ruleInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RuleInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RuleInstance exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RuleInstancePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static final RuleInstance _nullRuleInstance = new RuleInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RuleInstance> toCacheModel() {
				return _nullRuleInstanceCacheModel;
			}
		};

	private static final CacheModel<RuleInstance> _nullRuleInstanceCacheModel = new CacheModel<RuleInstance>() {
			@Override
			public RuleInstance toEntityModel() {
				return _nullRuleInstance;
			}
		};
}