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

import com.liferay.content.targeting.NoSuchTacticException;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.impl.TacticImpl;
import com.liferay.content.targeting.model.impl.TacticModelImpl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the tactic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TacticPersistence
 * @see TacticUtil
 * @generated
 */
public class TacticPersistenceImpl extends BasePersistenceImpl<Tactic>
	implements TacticPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TacticUtil} to access the tactic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TacticImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TacticModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the tactics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByUuid(String uuid, int start, int end,
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

		List<Tactic> list = (List<Tactic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tactic tactic : list) {
				if (!Validator.equals(uuid, tactic.getUuid())) {
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

			query.append(_SQL_SELECT_TACTIC_WHERE);

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
				query.append(TacticModelImpl.ORDER_BY_JPQL);
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
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tactic>(list);
				}
				else {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first tactic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = fetchByUuid_First(uuid, orderByComparator);

		if (tactic != null) {
			return tactic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTacticException(msg.toString());
	}

	/**
	 * Returns the first tactic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tactic> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tactic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = fetchByUuid_Last(uuid, orderByComparator);

		if (tactic != null) {
			return tactic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTacticException(msg.toString());
	}

	/**
	 * Returns the last tactic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Tactic> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tactics before and after the current tactic in the ordered set where uuid = &#63;.
	 *
	 * @param tacticId the primary key of the current tactic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic[] findByUuid_PrevAndNext(long tacticId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = findByPrimaryKey(tacticId);

		Session session = null;

		try {
			session = openSession();

			Tactic[] array = new TacticImpl[3];

			array[0] = getByUuid_PrevAndNext(session, tactic, uuid,
					orderByComparator, true);

			array[1] = tactic;

			array[2] = getByUuid_PrevAndNext(session, tactic, uuid,
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

	protected Tactic getByUuid_PrevAndNext(Session session, Tactic tactic,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TACTIC_WHERE);

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
			query.append(TacticModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(tactic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tactic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tactics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Tactic tactic : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tactic);
		}
	}

	/**
	 * Returns the number of tactics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tactics
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

			query.append(_SQL_COUNT_TACTIC_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "tactic.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "tactic.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(tactic.uuid IS NULL OR tactic.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TacticModelImpl.UUID_COLUMN_BITMASK |
			TacticModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the tactic where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.content.targeting.NoSuchTacticException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByUUID_G(String uuid, long groupId)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = fetchByUUID_G(uuid, groupId);

		if (tactic == null) {
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

			throw new NoSuchTacticException(msg.toString());
		}

		return tactic;
	}

	/**
	 * Returns the tactic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the tactic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Tactic) {
			Tactic tactic = (Tactic)result;

			if (!Validator.equals(uuid, tactic.getUuid()) ||
					(groupId != tactic.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TACTIC_WHERE);

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

				List<Tactic> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Tactic tactic = list.get(0);

					result = tactic;

					cacheResult(tactic);

					if ((tactic.getUuid() == null) ||
							!tactic.getUuid().equals(uuid) ||
							(tactic.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, tactic);
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
			return (Tactic)result;
		}
	}

	/**
	 * Removes the tactic where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tactic that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic removeByUUID_G(String uuid, long groupId)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = findByUUID_G(uuid, groupId);

		return remove(tactic);
	}

	/**
	 * Returns the number of tactics where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tactics
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

			query.append(_SQL_COUNT_TACTIC_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "tactic.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "tactic.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(tactic.uuid IS NULL OR tactic.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "tactic.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TacticModelImpl.UUID_COLUMN_BITMASK |
			TacticModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the tactics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByUuid_C(String uuid, long companyId, int start,
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

		List<Tactic> list = (List<Tactic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tactic tactic : list) {
				if (!Validator.equals(uuid, tactic.getUuid()) ||
						(companyId != tactic.getCompanyId())) {
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

			query.append(_SQL_SELECT_TACTIC_WHERE);

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
				query.append(TacticModelImpl.ORDER_BY_JPQL);
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
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tactic>(list);
				}
				else {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (tactic != null) {
			return tactic;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTacticException(msg.toString());
	}

	/**
	 * Returns the first tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tactic> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (tactic != null) {
			return tactic;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTacticException(msg.toString());
	}

	/**
	 * Returns the last tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Tactic> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tactics before and after the current tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tacticId the primary key of the current tactic
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic[] findByUuid_C_PrevAndNext(long tacticId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = findByPrimaryKey(tacticId);

		Session session = null;

		try {
			session = openSession();

			Tactic[] array = new TacticImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, tactic, uuid,
					companyId, orderByComparator, true);

			array[1] = tactic;

			array[2] = getByUuid_C_PrevAndNext(session, tactic, uuid,
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

	protected Tactic getByUuid_C_PrevAndNext(Session session, Tactic tactic,
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

		query.append(_SQL_SELECT_TACTIC_WHERE);

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
			query.append(TacticModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(tactic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tactic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tactics where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Tactic tactic : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tactic);
		}
	}

	/**
	 * Returns the number of tactics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tactics
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

			query.append(_SQL_COUNT_TACTIC_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "tactic.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "tactic.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(tactic.uuid IS NULL OR tactic.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "tactic.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			TacticModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tactics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByGroupId(long groupId, int start, int end,
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

		List<Tactic> list = (List<Tactic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tactic tactic : list) {
				if ((groupId != tactic.getGroupId())) {
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

			query.append(_SQL_SELECT_TACTIC_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TacticModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tactic>(list);
				}
				else {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first tactic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = fetchByGroupId_First(groupId, orderByComparator);

		if (tactic != null) {
			return tactic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTacticException(msg.toString());
	}

	/**
	 * Returns the first tactic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tactic> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tactic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = fetchByGroupId_Last(groupId, orderByComparator);

		if (tactic != null) {
			return tactic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTacticException(msg.toString());
	}

	/**
	 * Returns the last tactic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Tactic> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tactics before and after the current tactic in the ordered set where groupId = &#63;.
	 *
	 * @param tacticId the primary key of the current tactic
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic[] findByGroupId_PrevAndNext(long tacticId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = findByPrimaryKey(tacticId);

		Session session = null;

		try {
			session = openSession();

			Tactic[] array = new TacticImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, tactic, groupId,
					orderByComparator, true);

			array[1] = tactic;

			array[2] = getByGroupId_PrevAndNext(session, tactic, groupId,
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

	protected Tactic getByGroupId_PrevAndNext(Session session, Tactic tactic,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TACTIC_WHERE);

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
			query.append(TacticModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tactic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tactic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the tactics that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tactics that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of matching tactics that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tactics that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TACTIC_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TACTIC_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TACTIC_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TacticModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TacticModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Tactic.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TacticImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TacticImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<Tactic>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the tactics before and after the current tactic in the ordered set of tactics that the user has permission to view where groupId = &#63;.
	 *
	 * @param tacticId the primary key of the current tactic
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic[] filterFindByGroupId_PrevAndNext(long tacticId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(tacticId, groupId,
				orderByComparator);
		}

		Tactic tactic = findByPrimaryKey(tacticId);

		Session session = null;

		try {
			session = openSession();

			Tactic[] array = new TacticImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, tactic, groupId,
					orderByComparator, true);

			array[1] = tactic;

			array[2] = filterGetByGroupId_PrevAndNext(session, tactic, groupId,
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

	protected Tactic filterGetByGroupId_PrevAndNext(Session session,
		Tactic tactic, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TACTIC_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TACTIC_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TACTIC_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TacticModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TacticModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Tactic.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TacticImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TacticImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tactic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tactic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tactics where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Tactic tactic : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tactic);
		}
	}

	/**
	 * Returns the number of tactics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tactics
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

			query.append(_SQL_COUNT_TACTIC_WHERE);

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

	/**
	 * Returns the number of tactics that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tactics that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TACTIC_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Tactic.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "tactic.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, TacticImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			TacticModelImpl.CAMPAIGNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tactics where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByCampaignId(long campaignId)
		throws SystemException {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByCampaignId(long campaignId, int start, int end)
		throws SystemException {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findByCampaignId(long campaignId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Tactic> list = (List<Tactic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tactic tactic : list) {
				if ((campaignId != tactic.getCampaignId())) {
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

			query.append(_SQL_SELECT_TACTIC_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TacticModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tactic>(list);
				}
				else {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first tactic in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = fetchByCampaignId_First(campaignId, orderByComparator);

		if (tactic != null) {
			return tactic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTacticException(msg.toString());
	}

	/**
	 * Returns the first tactic in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic, or <code>null</code> if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tactic> list = findByCampaignId(campaignId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tactic in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = fetchByCampaignId_Last(campaignId, orderByComparator);

		if (tactic != null) {
			return tactic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTacticException(msg.toString());
	}

	/**
	 * Returns the last tactic in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tactic, or <code>null</code> if a matching tactic could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<Tactic> list = findByCampaignId(campaignId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tactics before and after the current tactic in the ordered set where campaignId = &#63;.
	 *
	 * @param tacticId the primary key of the current tactic
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic[] findByCampaignId_PrevAndNext(long tacticId,
		long campaignId, OrderByComparator orderByComparator)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = findByPrimaryKey(tacticId);

		Session session = null;

		try {
			session = openSession();

			Tactic[] array = new TacticImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, tactic, campaignId,
					orderByComparator, true);

			array[1] = tactic;

			array[2] = getByCampaignId_PrevAndNext(session, tactic, campaignId,
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

	protected Tactic getByCampaignId_PrevAndNext(Session session,
		Tactic tactic, long campaignId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TACTIC_WHERE);

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
			query.append(TacticModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tactic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tactic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tactics where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long campaignId) throws SystemException {
		for (Tactic tactic : findByCampaignId(campaignId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tactic);
		}
	}

	/**
	 * Returns the number of tactics where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching tactics
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

			query.append(_SQL_COUNT_TACTIC_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "tactic.campaignId = ?";

	public TacticPersistenceImpl() {
		setModelClass(Tactic.class);
	}

	/**
	 * Caches the tactic in the entity cache if it is enabled.
	 *
	 * @param tactic the tactic
	 */
	@Override
	public void cacheResult(Tactic tactic) {
		EntityCacheUtil.putResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticImpl.class, tactic.getPrimaryKey(), tactic);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { tactic.getUuid(), tactic.getGroupId() }, tactic);

		tactic.resetOriginalValues();
	}

	/**
	 * Caches the tactics in the entity cache if it is enabled.
	 *
	 * @param tactics the tactics
	 */
	@Override
	public void cacheResult(List<Tactic> tactics) {
		for (Tactic tactic : tactics) {
			if (EntityCacheUtil.getResult(
						TacticModelImpl.ENTITY_CACHE_ENABLED, TacticImpl.class,
						tactic.getPrimaryKey()) == null) {
				cacheResult(tactic);
			}
			else {
				tactic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tactics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TacticImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TacticImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tactic.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tactic tactic) {
		EntityCacheUtil.removeResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticImpl.class, tactic.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(tactic);
	}

	@Override
	public void clearCache(List<Tactic> tactics) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Tactic tactic : tactics) {
			EntityCacheUtil.removeResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
				TacticImpl.class, tactic.getPrimaryKey());

			clearUniqueFindersCache(tactic);
		}
	}

	protected void cacheUniqueFindersCache(Tactic tactic) {
		if (tactic.isNew()) {
			Object[] args = new Object[] { tactic.getUuid(), tactic.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, tactic);
		}
		else {
			TacticModelImpl tacticModelImpl = (TacticModelImpl)tactic;

			if ((tacticModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tactic.getUuid(), tactic.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					tactic);
			}
		}
	}

	protected void clearUniqueFindersCache(Tactic tactic) {
		TacticModelImpl tacticModelImpl = (TacticModelImpl)tactic;

		Object[] args = new Object[] { tactic.getUuid(), tactic.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((tacticModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					tacticModelImpl.getOriginalUuid(),
					tacticModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new tactic with the primary key. Does not add the tactic to the database.
	 *
	 * @param tacticId the primary key for the new tactic
	 * @return the new tactic
	 */
	@Override
	public Tactic create(long tacticId) {
		Tactic tactic = new TacticImpl();

		tactic.setNew(true);
		tactic.setPrimaryKey(tacticId);

		String uuid = PortalUUIDUtil.generate();

		tactic.setUuid(uuid);

		return tactic;
	}

	/**
	 * Removes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tacticId the primary key of the tactic
	 * @return the tactic that was removed
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic remove(long tacticId)
		throws NoSuchTacticException, SystemException {
		return remove((Serializable)tacticId);
	}

	/**
	 * Removes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tactic
	 * @return the tactic that was removed
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic remove(Serializable primaryKey)
		throws NoSuchTacticException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Tactic tactic = (Tactic)session.get(TacticImpl.class, primaryKey);

			if (tactic == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTacticException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tactic);
		}
		catch (NoSuchTacticException nsee) {
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
	protected Tactic removeImpl(Tactic tactic) throws SystemException {
		tactic = toUnwrappedModel(tactic);

		tacticToUserSegmentTableMapper.deleteLeftPrimaryKeyTableMappings(tactic.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tactic)) {
				tactic = (Tactic)session.get(TacticImpl.class,
						tactic.getPrimaryKeyObj());
			}

			if (tactic != null) {
				session.delete(tactic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tactic != null) {
			clearCache(tactic);
		}

		return tactic;
	}

	@Override
	public Tactic updateImpl(com.liferay.content.targeting.model.Tactic tactic)
		throws SystemException {
		tactic = toUnwrappedModel(tactic);

		boolean isNew = tactic.isNew();

		TacticModelImpl tacticModelImpl = (TacticModelImpl)tactic;

		if (Validator.isNull(tactic.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			tactic.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (tactic.isNew()) {
				session.save(tactic);

				tactic.setNew(false);
			}
			else {
				session.merge(tactic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TacticModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tacticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { tacticModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { tacticModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((tacticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tacticModelImpl.getOriginalUuid(),
						tacticModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						tacticModelImpl.getUuid(),
						tacticModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((tacticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tacticModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { tacticModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((tacticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tacticModelImpl.getOriginalCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { tacticModelImpl.getCampaignId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}
		}

		EntityCacheUtil.putResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticImpl.class, tactic.getPrimaryKey(), tactic);

		clearUniqueFindersCache(tactic);
		cacheUniqueFindersCache(tactic);

		return tactic;
	}

	protected Tactic toUnwrappedModel(Tactic tactic) {
		if (tactic instanceof TacticImpl) {
			return tactic;
		}

		TacticImpl tacticImpl = new TacticImpl();

		tacticImpl.setNew(tactic.isNew());
		tacticImpl.setPrimaryKey(tactic.getPrimaryKey());

		tacticImpl.setUuid(tactic.getUuid());
		tacticImpl.setTacticId(tactic.getTacticId());
		tacticImpl.setGroupId(tactic.getGroupId());
		tacticImpl.setCompanyId(tactic.getCompanyId());
		tacticImpl.setUserId(tactic.getUserId());
		tacticImpl.setUserName(tactic.getUserName());
		tacticImpl.setCreateDate(tactic.getCreateDate());
		tacticImpl.setModifiedDate(tactic.getModifiedDate());
		tacticImpl.setCampaignId(tactic.getCampaignId());
		tacticImpl.setName(tactic.getName());
		tacticImpl.setDescription(tactic.getDescription());

		return tacticImpl;
	}

	/**
	 * Returns the tactic with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tactic
	 * @return the tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTacticException, SystemException {
		Tactic tactic = fetchByPrimaryKey(primaryKey);

		if (tactic == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTacticException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tactic;
	}

	/**
	 * Returns the tactic with the primary key or throws a {@link com.liferay.content.targeting.NoSuchTacticException} if it could not be found.
	 *
	 * @param tacticId the primary key of the tactic
	 * @return the tactic
	 * @throws com.liferay.content.targeting.NoSuchTacticException if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic findByPrimaryKey(long tacticId)
		throws NoSuchTacticException, SystemException {
		return findByPrimaryKey((Serializable)tacticId);
	}

	/**
	 * Returns the tactic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tactic
	 * @return the tactic, or <code>null</code> if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Tactic tactic = (Tactic)EntityCacheUtil.getResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
				TacticImpl.class, primaryKey);

		if (tactic == _nullTactic) {
			return null;
		}

		if (tactic == null) {
			Session session = null;

			try {
				session = openSession();

				tactic = (Tactic)session.get(TacticImpl.class, primaryKey);

				if (tactic != null) {
					cacheResult(tactic);
				}
				else {
					EntityCacheUtil.putResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
						TacticImpl.class, primaryKey, _nullTactic);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
					TacticImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tactic;
	}

	/**
	 * Returns the tactic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tacticId the primary key of the tactic
	 * @return the tactic, or <code>null</code> if a tactic with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tactic fetchByPrimaryKey(long tacticId) throws SystemException {
		return fetchByPrimaryKey((Serializable)tacticId);
	}

	/**
	 * Returns all the tactics.
	 *
	 * @return the tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tactics
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tactic> findAll(int start, int end,
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

		List<Tactic> list = (List<Tactic>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TACTIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TACTIC;

				if (pagination) {
					sql = sql.concat(TacticModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tactic>(list);
				}
				else {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the tactics from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Tactic tactic : findAll()) {
			remove(tactic);
		}
	}

	/**
	 * Returns the number of tactics.
	 *
	 * @return the number of tactics
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

				Query q = session.createQuery(_SQL_COUNT_TACTIC);

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

	/**
	 * Returns all the user segments associated with the tactic.
	 *
	 * @param pk the primary key of the tactic
	 * @return the user segments associated with the tactic
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk) throws SystemException {
		return getUserSegments(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the user segments associated with the tactic.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the tactic
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of user segments associated with the tactic
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end) throws SystemException {
		return getUserSegments(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segments associated with the tactic.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the tactic
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user segments associated with the tactic
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return tacticToUserSegmentTableMapper.getRightBaseModels(pk, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of user segments associated with the tactic.
	 *
	 * @param pk the primary key of the tactic
	 * @return the number of user segments associated with the tactic
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getUserSegmentsSize(long pk) throws SystemException {
		long[] pks = tacticToUserSegmentTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the user segment is associated with the tactic.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegmentPK the primary key of the user segment
	 * @return <code>true</code> if the user segment is associated with the tactic; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsUserSegment(long pk, long userSegmentPK)
		throws SystemException {
		return tacticToUserSegmentTableMapper.containsTableMapping(pk,
			userSegmentPK);
	}

	/**
	 * Returns <code>true</code> if the tactic has any user segments associated with it.
	 *
	 * @param pk the primary key of the tactic to check for associations with user segments
	 * @return <code>true</code> if the tactic has any user segments associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsUserSegments(long pk) throws SystemException {
		if (getUserSegmentsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegmentPK the primary key of the user segment
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addUserSegment(long pk, long userSegmentPK)
		throws SystemException {
		tacticToUserSegmentTableMapper.addTableMapping(pk, userSegmentPK);
	}

	/**
	 * Adds an association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegment the user segment
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment)
		throws SystemException {
		tacticToUserSegmentTableMapper.addTableMapping(pk,
			userSegment.getPrimaryKey());
	}

	/**
	 * Adds an association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegmentPKs the primary keys of the user segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addUserSegments(long pk, long[] userSegmentPKs)
		throws SystemException {
		for (long userSegmentPK : userSegmentPKs) {
			tacticToUserSegmentTableMapper.addTableMapping(pk, userSegmentPK);
		}
	}

	/**
	 * Adds an association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegments the user segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments)
		throws SystemException {
		for (com.liferay.content.targeting.model.UserSegment userSegment : userSegments) {
			tacticToUserSegmentTableMapper.addTableMapping(pk,
				userSegment.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the tactic and its user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic to clear the associated user segments from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearUserSegments(long pk) throws SystemException {
		tacticToUserSegmentTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegmentPK the primary key of the user segment
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeUserSegment(long pk, long userSegmentPK)
		throws SystemException {
		tacticToUserSegmentTableMapper.deleteTableMapping(pk, userSegmentPK);
	}

	/**
	 * Removes the association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegment the user segment
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment)
		throws SystemException {
		tacticToUserSegmentTableMapper.deleteTableMapping(pk,
			userSegment.getPrimaryKey());
	}

	/**
	 * Removes the association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegmentPKs the primary keys of the user segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeUserSegments(long pk, long[] userSegmentPKs)
		throws SystemException {
		for (long userSegmentPK : userSegmentPKs) {
			tacticToUserSegmentTableMapper.deleteTableMapping(pk, userSegmentPK);
		}
	}

	/**
	 * Removes the association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegments the user segments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments)
		throws SystemException {
		for (com.liferay.content.targeting.model.UserSegment userSegment : userSegments) {
			tacticToUserSegmentTableMapper.deleteTableMapping(pk,
				userSegment.getPrimaryKey());
		}
	}

	/**
	 * Sets the user segments associated with the tactic, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegmentPKs the primary keys of the user segments to be associated with the tactic
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setUserSegments(long pk, long[] userSegmentPKs)
		throws SystemException {
		Set<Long> newUserSegmentPKsSet = SetUtil.fromArray(userSegmentPKs);
		Set<Long> oldUserSegmentPKsSet = SetUtil.fromArray(tacticToUserSegmentTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeUserSegmentPKsSet = new HashSet<Long>(oldUserSegmentPKsSet);

		removeUserSegmentPKsSet.removeAll(newUserSegmentPKsSet);

		for (long removeUserSegmentPK : removeUserSegmentPKsSet) {
			tacticToUserSegmentTableMapper.deleteTableMapping(pk,
				removeUserSegmentPK);
		}

		newUserSegmentPKsSet.removeAll(oldUserSegmentPKsSet);

		for (long newUserSegmentPK : newUserSegmentPKsSet) {
			tacticToUserSegmentTableMapper.addTableMapping(pk, newUserSegmentPK);
		}
	}

	/**
	 * Sets the user segments associated with the tactic, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegments the user segments to be associated with the tactic
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments)
		throws SystemException {
		try {
			long[] userSegmentPKs = new long[userSegments.size()];

			for (int i = 0; i < userSegments.size(); i++) {
				com.liferay.content.targeting.model.UserSegment userSegment = userSegments.get(i);

				userSegmentPKs[i] = userSegment.getPrimaryKey();
			}

			setUserSegments(pk, userSegmentPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TacticModelImpl.MAPPING_TABLE_CT_TACTICS_USERSEGMENTS_NAME);
		}
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the tactic persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.model.Tactic")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Tactic>> listenersList = new ArrayList<ModelListener<Tactic>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Tactic>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		tacticToUserSegmentTableMapper = TableMapperFactory.getTableMapper("CT_Tactics_UserSegments",
				"tacticId", "userSegmentId", this, userSegmentPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TacticImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = UserSegmentPersistence.class)
	protected UserSegmentPersistence userSegmentPersistence;
	protected TableMapper<Tactic, com.liferay.content.targeting.model.UserSegment> tacticToUserSegmentTableMapper;
	private static final String _SQL_SELECT_TACTIC = "SELECT tactic FROM Tactic tactic";
	private static final String _SQL_SELECT_TACTIC_WHERE = "SELECT tactic FROM Tactic tactic WHERE ";
	private static final String _SQL_COUNT_TACTIC = "SELECT COUNT(tactic) FROM Tactic tactic";
	private static final String _SQL_COUNT_TACTIC_WHERE = "SELECT COUNT(tactic) FROM Tactic tactic WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "tactic.tacticId";
	private static final String _FILTER_SQL_SELECT_TACTIC_WHERE = "SELECT DISTINCT {tactic.*} FROM CT_Tactic tactic WHERE ";
	private static final String _FILTER_SQL_SELECT_TACTIC_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CT_Tactic.*} FROM (SELECT DISTINCT tactic.tacticId FROM CT_Tactic tactic WHERE ";
	private static final String _FILTER_SQL_SELECT_TACTIC_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CT_Tactic ON TEMP_TABLE.tacticId = CT_Tactic.tacticId";
	private static final String _FILTER_SQL_COUNT_TACTIC_WHERE = "SELECT COUNT(DISTINCT tactic.tacticId) AS COUNT_VALUE FROM CT_Tactic tactic WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "tactic";
	private static final String _FILTER_ENTITY_TABLE = "CT_Tactic";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tactic.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CT_Tactic.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Tactic exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Tactic exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TacticPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Tactic _nullTactic = new TacticImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Tactic> toCacheModel() {
				return _nullTacticCacheModel;
			}
		};

	private static CacheModel<Tactic> _nullTacticCacheModel = new CacheModel<Tactic>() {
			@Override
			public Tactic toEntityModel() {
				return _nullTactic;
			}
		};
}