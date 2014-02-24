/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.service.persistence;

import com.liferay.contenttargeting.NoSuchRuleInstanceException;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.model.impl.RuleInstanceImpl;
import com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl;

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
 * The persistence implementation for the rule instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleInstancePersistence
 * @see RuleInstanceUtil
 * @generated
 */
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @return the range of matching rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByUuid(String uuid, int start, int end,
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

		List<RuleInstance> list = (List<RuleInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RuleInstance ruleInstance : list) {
				if (!Validator.equals(uuid, ruleInstance.getUuid())) {
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

					list = new UnmodifiableList<RuleInstance>(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rule instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance[] findByUuid_PrevAndNext(long ruleInstanceId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
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
	 * Returns the rule instance where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.contenttargeting.NoSuchRuleInstanceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rule instance
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rule instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rule instance, or <code>null</code> if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
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
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RuleInstance ruleInstance = list.get(0);

					result = ruleInstance;

					cacheResult(ruleInstance);

					if ((ruleInstance.getUuid() == null) ||
							!ruleInstance.getUuid().equals(uuid) ||
							(ruleInstance.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, ruleInstance);
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
			return (RuleInstance)result;
		}
	}

	/**
	 * Removes the rule instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rule instance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchRuleInstanceException, SystemException {
		RuleInstance ruleInstance = findByUUID_G(uuid, groupId);

		return remove(ruleInstance);
	}

	/**
	 * Returns the number of rule instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rule instances
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @return the range of matching rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByUuid_C(String uuid, long companyId,
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

		List<RuleInstance> list = (List<RuleInstance>)FinderCacheUtil.getResult(finderPath,
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

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
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

					list = new UnmodifiableList<RuleInstance>(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rule instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance[] findByUuid_C_PrevAndNext(long ruleInstanceId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @return the range of matching rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule instances where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<RuleInstance> list = (List<RuleInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RuleInstance ruleInstance : list) {
				if ((groupId != ruleInstance.getGroupId())) {
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

					list = new UnmodifiableList<RuleInstance>(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rule instance in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance[] findByGroupId_PrevAndNext(long ruleInstanceId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByUserSegmentId(long userSegmentId)
		throws SystemException {
		return findByUserSegmentId(userSegmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule instances where userSegmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @return the range of matching rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByUserSegmentId(long userSegmentId,
		int start, int end) throws SystemException {
		return findByUserSegmentId(userSegmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule instances where userSegmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByUserSegmentId(long userSegmentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<RuleInstance> list = (List<RuleInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RuleInstance ruleInstance : list) {
				if ((userSegmentId != ruleInstance.getUserSegmentId())) {
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

					list = new UnmodifiableList<RuleInstance>(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rule instance in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByUserSegmentId_First(long userSegmentId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByUserSegmentId_First(long userSegmentId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByUserSegmentId_Last(long userSegmentId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByUserSegmentId_Last(long userSegmentId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance[] findByUserSegmentId_PrevAndNext(long ruleInstanceId,
		long userSegmentId, OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserSegmentId(long userSegmentId)
		throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserSegmentId(long userSegmentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERSEGMENTID;

		Object[] finderArgs = new Object[] { userSegmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByR_U(String ruleKey, long userSegmentId)
		throws SystemException {
		return findByR_U(ruleKey, userSegmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleKey the rule key
	 * @param userSegmentId the user segment ID
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @return the range of matching rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByR_U(String ruleKey, long userSegmentId,
		int start, int end) throws SystemException {
		return findByR_U(ruleKey, userSegmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule instances where ruleKey = &#63; and userSegmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleKey the rule key
	 * @param userSegmentId the user segment ID
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findByR_U(String ruleKey, long userSegmentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<RuleInstance> list = (List<RuleInstance>)FinderCacheUtil.getResult(finderPath,
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

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
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

					list = new UnmodifiableList<RuleInstance>(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rule instance in the ordered set where ruleKey = &#63; and userSegmentId = &#63;.
	 *
	 * @param ruleKey the rule key
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule instance
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByR_U_First(String ruleKey, long userSegmentId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByR_U_First(String ruleKey, long userSegmentId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a matching rule instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByR_U_Last(String ruleKey, long userSegmentId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByR_U_Last(String ruleKey, long userSegmentId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance[] findByR_U_PrevAndNext(long ruleInstanceId,
		String ruleKey, long userSegmentId, OrderByComparator orderByComparator)
		throws NoSuchRuleInstanceException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByR_U(String ruleKey, long userSegmentId)
		throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByR_U(String ruleKey, long userSegmentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_U;

		Object[] finderArgs = new Object[] { ruleKey, userSegmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

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
		EntityCacheUtil.putResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceImpl.class, ruleInstance.getPrimaryKey(), ruleInstance);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			if (EntityCacheUtil.getResult(
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
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RuleInstanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RuleInstanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rule instance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RuleInstance ruleInstance) {
		EntityCacheUtil.removeResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceImpl.class, ruleInstance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(ruleInstance);
	}

	@Override
	public void clearCache(List<RuleInstance> ruleInstances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RuleInstance ruleInstance : ruleInstances) {
			EntityCacheUtil.removeResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
				RuleInstanceImpl.class, ruleInstance.getPrimaryKey());

			clearUniqueFindersCache(ruleInstance);
		}
	}

	protected void cacheUniqueFindersCache(RuleInstance ruleInstance) {
		if (ruleInstance.isNew()) {
			Object[] args = new Object[] {
					ruleInstance.getUuid(), ruleInstance.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				ruleInstance);
		}
		else {
			RuleInstanceModelImpl ruleInstanceModelImpl = (RuleInstanceModelImpl)ruleInstance;

			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstance.getUuid(), ruleInstance.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					ruleInstance);
			}
		}
	}

	protected void clearUniqueFindersCache(RuleInstance ruleInstance) {
		RuleInstanceModelImpl ruleInstanceModelImpl = (RuleInstanceModelImpl)ruleInstance;

		Object[] args = new Object[] {
				ruleInstance.getUuid(), ruleInstance.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((ruleInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					ruleInstanceModelImpl.getOriginalUuid(),
					ruleInstanceModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
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

		return ruleInstance;
	}

	/**
	 * Removes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleInstanceId the primary key of the rule instance
	 * @return the rule instance that was removed
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance remove(long ruleInstanceId)
		throws NoSuchRuleInstanceException, SystemException {
		return remove((Serializable)ruleInstanceId);
	}

	/**
	 * Removes the rule instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rule instance
	 * @return the rule instance that was removed
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance remove(Serializable primaryKey)
		throws NoSuchRuleInstanceException, SystemException {
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
	protected RuleInstance removeImpl(RuleInstance ruleInstance)
		throws SystemException {
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
	public RuleInstance updateImpl(
		com.liferay.contenttargeting.model.RuleInstance ruleInstance)
		throws SystemException {
		ruleInstance = toUnwrappedModel(ruleInstance);

		boolean isNew = ruleInstance.isNew();

		RuleInstanceModelImpl ruleInstanceModelImpl = (RuleInstanceModelImpl)ruleInstance;

		if (Validator.isNull(ruleInstance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ruleInstance.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (ruleInstance.isNew()) {
				session.save(ruleInstance);

				ruleInstance.setNew(false);
			}
			else {
				session.merge(ruleInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RuleInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { ruleInstanceModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getOriginalUuid(),
						ruleInstanceModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						ruleInstanceModelImpl.getUuid(),
						ruleInstanceModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { ruleInstanceModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getOriginalUserSegmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERSEGMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID,
					args);

				args = new Object[] { ruleInstanceModelImpl.getUserSegmentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERSEGMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID,
					args);
			}

			if ((ruleInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleInstanceModelImpl.getOriginalRuleKey(),
						ruleInstanceModelImpl.getOriginalUserSegmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_U,
					args);

				args = new Object[] {
						ruleInstanceModelImpl.getRuleKey(),
						ruleInstanceModelImpl.getUserSegmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_U,
					args);
			}
		}

		EntityCacheUtil.putResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
			RuleInstanceImpl.class, ruleInstance.getPrimaryKey(), ruleInstance);

		clearUniqueFindersCache(ruleInstance);
		cacheUniqueFindersCache(ruleInstance);

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
	 * Returns the rule instance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule instance
	 * @return the rule instance
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRuleInstanceException, SystemException {
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
	 * Returns the rule instance with the primary key or throws a {@link com.liferay.contenttargeting.NoSuchRuleInstanceException} if it could not be found.
	 *
	 * @param ruleInstanceId the primary key of the rule instance
	 * @return the rule instance
	 * @throws com.liferay.contenttargeting.NoSuchRuleInstanceException if a rule instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance findByPrimaryKey(long ruleInstanceId)
		throws NoSuchRuleInstanceException, SystemException {
		return findByPrimaryKey((Serializable)ruleInstanceId);
	}

	/**
	 * Returns the rule instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule instance
	 * @return the rule instance, or <code>null</code> if a rule instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RuleInstance ruleInstance = (RuleInstance)EntityCacheUtil.getResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
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
					EntityCacheUtil.putResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
						RuleInstanceImpl.class, primaryKey, _nullRuleInstance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RuleInstanceModelImpl.ENTITY_CACHE_ENABLED,
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleInstance fetchByPrimaryKey(long ruleInstanceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)ruleInstanceId);
	}

	/**
	 * Returns all the rule instances.
	 *
	 * @return the rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @return the range of rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contenttargeting.model.impl.RuleInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule instances
	 * @param end the upper bound of the range of rule instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rule instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleInstance> findAll(int start, int end,
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

		List<RuleInstance> list = (List<RuleInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

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

					list = new UnmodifiableList<RuleInstance>(list);
				}
				else {
					list = (List<RuleInstance>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rule instances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RuleInstance ruleInstance : findAll()) {
			remove(ruleInstance);
		}
	}

	/**
	 * Returns the number of rule instances.
	 *
	 * @return the number of rule instances
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

				Query q = session.createQuery(_SQL_COUNT_RULEINSTANCE);

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
	 * Initializes the rule instance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.contenttargeting.model.RuleInstance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RuleInstance>> listenersList = new ArrayList<ModelListener<RuleInstance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RuleInstance>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RuleInstanceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RULEINSTANCE = "SELECT ruleInstance FROM RuleInstance ruleInstance";
	private static final String _SQL_SELECT_RULEINSTANCE_WHERE = "SELECT ruleInstance FROM RuleInstance ruleInstance WHERE ";
	private static final String _SQL_COUNT_RULEINSTANCE = "SELECT COUNT(ruleInstance) FROM RuleInstance ruleInstance";
	private static final String _SQL_COUNT_RULEINSTANCE_WHERE = "SELECT COUNT(ruleInstance) FROM RuleInstance ruleInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ruleInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RuleInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RuleInstance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RuleInstancePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static RuleInstance _nullRuleInstance = new RuleInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RuleInstance> toCacheModel() {
				return _nullRuleInstanceCacheModel;
			}
		};

	private static CacheModel<RuleInstance> _nullRuleInstanceCacheModel = new CacheModel<RuleInstance>() {
			@Override
			public RuleInstance toEntityModel() {
				return _nullRuleInstance;
			}
		};
}