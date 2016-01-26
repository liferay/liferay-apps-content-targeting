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

package com.liferay.content.targeting.rule.engine.service.persistence;

import com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException;
import com.liferay.content.targeting.rule.engine.model.RuleEngine;
import com.liferay.content.targeting.rule.engine.model.impl.RuleEngineImpl;
import com.liferay.content.targeting.rule.engine.model.impl.RuleEngineModelImpl;

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
 * The persistence implementation for the rule engine service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleEnginePersistence
 * @see RuleEngineUtil
 * @generated
 */
public class RuleEnginePersistenceImpl extends BasePersistenceImpl<RuleEngine>
	implements RuleEnginePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RuleEngineUtil} to access the rule engine persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RuleEngineImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
			RuleEngineModelImpl.FINDER_CACHE_ENABLED, RuleEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
			RuleEngineModelImpl.FINDER_CACHE_ENABLED, RuleEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
			RuleEngineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
			RuleEngineModelImpl.FINDER_CACHE_ENABLED, RuleEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
			RuleEngineModelImpl.FINDER_CACHE_ENABLED, RuleEngineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RuleEngineModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
			RuleEngineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rule engines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rule engines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleEngine> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule engines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.engine.model.impl.RuleEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rule engines
	 * @param end the upper bound of the range of rule engines (not inclusive)
	 * @return the range of matching rule engines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleEngine> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule engines where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.engine.model.impl.RuleEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rule engines
	 * @param end the upper bound of the range of rule engines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule engines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleEngine> findByUuid(String uuid, int start, int end,
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

		List<RuleEngine> list = (List<RuleEngine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RuleEngine ruleEngine : list) {
				if (!Validator.equals(uuid, ruleEngine.getUuid())) {
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

			query.append(_SQL_SELECT_RULEENGINE_WHERE);

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
				query.append(RuleEngineModelImpl.ORDER_BY_JPQL);
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
					list = (List<RuleEngine>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RuleEngine>(list);
				}
				else {
					list = (List<RuleEngine>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rule engine in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule engine
	 * @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a matching rule engine could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRuleEngineException, SystemException {
		RuleEngine ruleEngine = fetchByUuid_First(uuid, orderByComparator);

		if (ruleEngine != null) {
			return ruleEngine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleEngineException(msg.toString());
	}

	/**
	 * Returns the first rule engine in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule engine, or <code>null</code> if a matching rule engine could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RuleEngine> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rule engine in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule engine
	 * @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a matching rule engine could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRuleEngineException, SystemException {
		RuleEngine ruleEngine = fetchByUuid_Last(uuid, orderByComparator);

		if (ruleEngine != null) {
			return ruleEngine;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleEngineException(msg.toString());
	}

	/**
	 * Returns the last rule engine in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule engine, or <code>null</code> if a matching rule engine could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RuleEngine> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rule engines before and after the current rule engine in the ordered set where uuid = &#63;.
	 *
	 * @param dummyId the primary key of the current rule engine
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule engine
	 * @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a rule engine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine[] findByUuid_PrevAndNext(long dummyId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRuleEngineException, SystemException {
		RuleEngine ruleEngine = findByPrimaryKey(dummyId);

		Session session = null;

		try {
			session = openSession();

			RuleEngine[] array = new RuleEngineImpl[3];

			array[0] = getByUuid_PrevAndNext(session, ruleEngine, uuid,
					orderByComparator, true);

			array[1] = ruleEngine;

			array[2] = getByUuid_PrevAndNext(session, ruleEngine, uuid,
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

	protected RuleEngine getByUuid_PrevAndNext(Session session,
		RuleEngine ruleEngine, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULEENGINE_WHERE);

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
			query.append(RuleEngineModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ruleEngine);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RuleEngine> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rule engines where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RuleEngine ruleEngine : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ruleEngine);
		}
	}

	/**
	 * Returns the number of rule engines where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rule engines
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

			query.append(_SQL_COUNT_RULEENGINE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "ruleEngine.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "ruleEngine.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(ruleEngine.uuid IS NULL OR ruleEngine.uuid = '')";

	public RuleEnginePersistenceImpl() {
		setModelClass(RuleEngine.class);
	}

	/**
	 * Caches the rule engine in the entity cache if it is enabled.
	 *
	 * @param ruleEngine the rule engine
	 */
	@Override
	public void cacheResult(RuleEngine ruleEngine) {
		EntityCacheUtil.putResult(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
			RuleEngineImpl.class, ruleEngine.getPrimaryKey(), ruleEngine);

		ruleEngine.resetOriginalValues();
	}

	/**
	 * Caches the rule engines in the entity cache if it is enabled.
	 *
	 * @param ruleEngines the rule engines
	 */
	@Override
	public void cacheResult(List<RuleEngine> ruleEngines) {
		for (RuleEngine ruleEngine : ruleEngines) {
			if (EntityCacheUtil.getResult(
						RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
						RuleEngineImpl.class, ruleEngine.getPrimaryKey()) == null) {
				cacheResult(ruleEngine);
			}
			else {
				ruleEngine.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rule engines.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RuleEngineImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RuleEngineImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rule engine.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RuleEngine ruleEngine) {
		EntityCacheUtil.removeResult(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
			RuleEngineImpl.class, ruleEngine.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RuleEngine> ruleEngines) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RuleEngine ruleEngine : ruleEngines) {
			EntityCacheUtil.removeResult(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
				RuleEngineImpl.class, ruleEngine.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rule engine with the primary key. Does not add the rule engine to the database.
	 *
	 * @param dummyId the primary key for the new rule engine
	 * @return the new rule engine
	 */
	@Override
	public RuleEngine create(long dummyId) {
		RuleEngine ruleEngine = new RuleEngineImpl();

		ruleEngine.setNew(true);
		ruleEngine.setPrimaryKey(dummyId);

		String uuid = PortalUUIDUtil.generate();

		ruleEngine.setUuid(uuid);

		return ruleEngine;
	}

	/**
	 * Removes the rule engine with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dummyId the primary key of the rule engine
	 * @return the rule engine that was removed
	 * @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a rule engine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine remove(long dummyId)
		throws NoSuchRuleEngineException, SystemException {
		return remove((Serializable)dummyId);
	}

	/**
	 * Removes the rule engine with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rule engine
	 * @return the rule engine that was removed
	 * @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a rule engine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine remove(Serializable primaryKey)
		throws NoSuchRuleEngineException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RuleEngine ruleEngine = (RuleEngine)session.get(RuleEngineImpl.class,
					primaryKey);

			if (ruleEngine == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRuleEngineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ruleEngine);
		}
		catch (NoSuchRuleEngineException nsee) {
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
	protected RuleEngine removeImpl(RuleEngine ruleEngine)
		throws SystemException {
		ruleEngine = toUnwrappedModel(ruleEngine);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ruleEngine)) {
				ruleEngine = (RuleEngine)session.get(RuleEngineImpl.class,
						ruleEngine.getPrimaryKeyObj());
			}

			if (ruleEngine != null) {
				session.delete(ruleEngine);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ruleEngine != null) {
			clearCache(ruleEngine);
		}

		return ruleEngine;
	}

	@Override
	public RuleEngine updateImpl(
		com.liferay.content.targeting.rule.engine.model.RuleEngine ruleEngine)
		throws SystemException {
		ruleEngine = toUnwrappedModel(ruleEngine);

		boolean isNew = ruleEngine.isNew();

		RuleEngineModelImpl ruleEngineModelImpl = (RuleEngineModelImpl)ruleEngine;

		if (Validator.isNull(ruleEngine.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ruleEngine.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (ruleEngine.isNew()) {
				session.save(ruleEngine);

				ruleEngine.setNew(false);
			}
			else {
				session.merge(ruleEngine);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RuleEngineModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ruleEngineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleEngineModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { ruleEngineModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
			RuleEngineImpl.class, ruleEngine.getPrimaryKey(), ruleEngine);

		return ruleEngine;
	}

	protected RuleEngine toUnwrappedModel(RuleEngine ruleEngine) {
		if (ruleEngine instanceof RuleEngineImpl) {
			return ruleEngine;
		}

		RuleEngineImpl ruleEngineImpl = new RuleEngineImpl();

		ruleEngineImpl.setNew(ruleEngine.isNew());
		ruleEngineImpl.setPrimaryKey(ruleEngine.getPrimaryKey());

		ruleEngineImpl.setUuid(ruleEngine.getUuid());
		ruleEngineImpl.setDummyId(ruleEngine.getDummyId());

		return ruleEngineImpl;
	}

	/**
	 * Returns the rule engine with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule engine
	 * @return the rule engine
	 * @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a rule engine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRuleEngineException, SystemException {
		RuleEngine ruleEngine = fetchByPrimaryKey(primaryKey);

		if (ruleEngine == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRuleEngineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ruleEngine;
	}

	/**
	 * Returns the rule engine with the primary key or throws a {@link com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException} if it could not be found.
	 *
	 * @param dummyId the primary key of the rule engine
	 * @return the rule engine
	 * @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a rule engine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine findByPrimaryKey(long dummyId)
		throws NoSuchRuleEngineException, SystemException {
		return findByPrimaryKey((Serializable)dummyId);
	}

	/**
	 * Returns the rule engine with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule engine
	 * @return the rule engine, or <code>null</code> if a rule engine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RuleEngine ruleEngine = (RuleEngine)EntityCacheUtil.getResult(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
				RuleEngineImpl.class, primaryKey);

		if (ruleEngine == _nullRuleEngine) {
			return null;
		}

		if (ruleEngine == null) {
			Session session = null;

			try {
				session = openSession();

				ruleEngine = (RuleEngine)session.get(RuleEngineImpl.class,
						primaryKey);

				if (ruleEngine != null) {
					cacheResult(ruleEngine);
				}
				else {
					EntityCacheUtil.putResult(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
						RuleEngineImpl.class, primaryKey, _nullRuleEngine);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RuleEngineModelImpl.ENTITY_CACHE_ENABLED,
					RuleEngineImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ruleEngine;
	}

	/**
	 * Returns the rule engine with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dummyId the primary key of the rule engine
	 * @return the rule engine, or <code>null</code> if a rule engine with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RuleEngine fetchByPrimaryKey(long dummyId) throws SystemException {
		return fetchByPrimaryKey((Serializable)dummyId);
	}

	/**
	 * Returns all the rule engines.
	 *
	 * @return the rule engines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleEngine> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule engines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.engine.model.impl.RuleEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule engines
	 * @param end the upper bound of the range of rule engines (not inclusive)
	 * @return the range of rule engines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleEngine> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule engines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.engine.model.impl.RuleEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule engines
	 * @param end the upper bound of the range of rule engines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rule engines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RuleEngine> findAll(int start, int end,
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

		List<RuleEngine> list = (List<RuleEngine>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RULEENGINE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RULEENGINE;

				if (pagination) {
					sql = sql.concat(RuleEngineModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RuleEngine>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RuleEngine>(list);
				}
				else {
					list = (List<RuleEngine>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rule engines from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RuleEngine ruleEngine : findAll()) {
			remove(ruleEngine);
		}
	}

	/**
	 * Returns the number of rule engines.
	 *
	 * @return the number of rule engines
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

				Query q = session.createQuery(_SQL_COUNT_RULEENGINE);

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
	 * Initializes the rule engine persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.rule.engine.model.RuleEngine")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RuleEngine>> listenersList = new ArrayList<ModelListener<RuleEngine>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RuleEngine>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RuleEngineImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RULEENGINE = "SELECT ruleEngine FROM RuleEngine ruleEngine";
	private static final String _SQL_SELECT_RULEENGINE_WHERE = "SELECT ruleEngine FROM RuleEngine ruleEngine WHERE ";
	private static final String _SQL_COUNT_RULEENGINE = "SELECT COUNT(ruleEngine) FROM RuleEngine ruleEngine";
	private static final String _SQL_COUNT_RULEENGINE_WHERE = "SELECT COUNT(ruleEngine) FROM RuleEngine ruleEngine WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ruleEngine.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RuleEngine exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RuleEngine exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RuleEnginePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static RuleEngine _nullRuleEngine = new RuleEngineImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RuleEngine> toCacheModel() {
				return _nullRuleEngineCacheModel;
			}
		};

	private static CacheModel<RuleEngine> _nullRuleEngineCacheModel = new CacheModel<RuleEngine>() {
			@Override
			public RuleEngine toEntityModel() {
				return _nullRuleEngine;
			}
		};
}