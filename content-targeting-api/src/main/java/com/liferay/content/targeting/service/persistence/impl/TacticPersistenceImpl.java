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

import com.liferay.content.targeting.exception.NoSuchTacticException;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.model.impl.TacticImpl;
import com.liferay.content.targeting.model.impl.TacticModelImpl;
import com.liferay.content.targeting.service.persistence.TacticPersistence;
import com.liferay.content.targeting.service.persistence.UserSegmentPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
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
 * The persistence implementation for the tactic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TacticPersistence
 * @see com.liferay.content.targeting.service.persistence.TacticUtil
 * @generated
 */
@ProviderType
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
	 */
	@Override
	public List<Tactic> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of matching tactics
	 */
	@Override
	public List<Tactic> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tactics
	 */
	@Override
	public List<Tactic> findByUuid(String uuid, int start, int end,
		OrderByComparator<Tactic> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tactics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tactics
	 */
	@Override
	public List<Tactic> findByUuid(String uuid, int start, int end,
		OrderByComparator<Tactic> orderByComparator, boolean retrieveFromCache) {
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

		List<Tactic> list = null;

		if (retrieveFromCache) {
			list = (List<Tactic>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Tactic tactic : list) {
					if (!Validator.equals(uuid, tactic.getUuid())) {
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first tactic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic
	 * @throws NoSuchTacticException if a matching tactic could not be found
	 */
	@Override
	public Tactic findByUuid_First(String uuid,
		OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
	 */
	@Override
	public Tactic fetchByUuid_First(String uuid,
		OrderByComparator<Tactic> orderByComparator) {
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
	 * @throws NoSuchTacticException if a matching tactic could not be found
	 */
	@Override
	public Tactic findByUuid_Last(String uuid,
		OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
	 */
	@Override
	public Tactic fetchByUuid_Last(String uuid,
		OrderByComparator<Tactic> orderByComparator) {
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
	 * @throws NoSuchTacticException if a tactic with the primary key could not be found
	 */
	@Override
	public Tactic[] findByUuid_PrevAndNext(long tacticId, String uuid,
		OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
		String uuid, OrderByComparator<Tactic> orderByComparator,
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
	 */
	@Override
	public void removeByUuid(String uuid) {
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
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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
	 * Returns the tactic where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTacticException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching tactic
	 * @throws NoSuchTacticException if a matching tactic could not be found
	 */
	@Override
	public Tactic findByUUID_G(String uuid, long groupId)
		throws NoSuchTacticException {
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
	 */
	@Override
	public Tactic fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the tactic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tactic, or <code>null</code> if a matching tactic could not be found
	 */
	@Override
	public Tactic fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
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
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Tactic tactic = list.get(0);

					result = tactic;

					cacheResult(tactic);

					if ((tactic.getUuid() == null) ||
							!tactic.getUuid().equals(uuid) ||
							(tactic.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, tactic);
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
			return (Tactic)result;
		}
	}

	/**
	 * Removes the tactic where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the tactic that was removed
	 */
	@Override
	public Tactic removeByUUID_G(String uuid, long groupId)
		throws NoSuchTacticException {
		Tactic tactic = findByUUID_G(uuid, groupId);

		return remove(tactic);
	}

	/**
	 * Returns the number of tactics where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tactics
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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
	 */
	@Override
	public List<Tactic> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of matching tactics
	 */
	@Override
	public List<Tactic> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tactics
	 */
	@Override
	public List<Tactic> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Tactic> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tactics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tactics
	 */
	@Override
	public List<Tactic> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Tactic> orderByComparator,
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

		List<Tactic> list = null;

		if (retrieveFromCache) {
			list = (List<Tactic>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Tactic tactic : list) {
					if (!Validator.equals(uuid, tactic.getUuid()) ||
							(companyId != tactic.getCompanyId())) {
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first tactic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic
	 * @throws NoSuchTacticException if a matching tactic could not be found
	 */
	@Override
	public Tactic findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
	 */
	@Override
	public Tactic fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Tactic> orderByComparator) {
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
	 * @throws NoSuchTacticException if a matching tactic could not be found
	 */
	@Override
	public Tactic findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
	 */
	@Override
	public Tactic fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Tactic> orderByComparator) {
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
	 * @throws NoSuchTacticException if a tactic with the primary key could not be found
	 */
	@Override
	public Tactic[] findByUuid_C_PrevAndNext(long tacticId, String uuid,
		long companyId, OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
		String uuid, long companyId,
		OrderByComparator<Tactic> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
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
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
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
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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
	 */
	@Override
	public List<Tactic> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of matching tactics
	 */
	@Override
	public List<Tactic> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tactics
	 */
	@Override
	public List<Tactic> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Tactic> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tactics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tactics
	 */
	@Override
	public List<Tactic> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Tactic> orderByComparator, boolean retrieveFromCache) {
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

		List<Tactic> list = null;

		if (retrieveFromCache) {
			list = (List<Tactic>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Tactic tactic : list) {
					if ((groupId != tactic.getGroupId())) {
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first tactic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic
	 * @throws NoSuchTacticException if a matching tactic could not be found
	 */
	@Override
	public Tactic findByGroupId_First(long groupId,
		OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
	 */
	@Override
	public Tactic fetchByGroupId_First(long groupId,
		OrderByComparator<Tactic> orderByComparator) {
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
	 * @throws NoSuchTacticException if a matching tactic could not be found
	 */
	@Override
	public Tactic findByGroupId_Last(long groupId,
		OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
	 */
	@Override
	public Tactic fetchByGroupId_Last(long groupId,
		OrderByComparator<Tactic> orderByComparator) {
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
	 * @throws NoSuchTacticException if a tactic with the primary key could not be found
	 */
	@Override
	public Tactic[] findByGroupId_PrevAndNext(long tacticId, long groupId,
		OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
		long groupId, OrderByComparator<Tactic> orderByComparator,
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
	 */
	@Override
	public List<Tactic> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of matching tactics that the user has permission to view
	 */
	@Override
	public List<Tactic> filterFindByGroupId(long groupId, int start, int end) {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tactics that the user has permission to view
	 */
	@Override
	public List<Tactic> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator<Tactic> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(4);
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

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

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
	 * @throws NoSuchTacticException if a tactic with the primary key could not be found
	 */
	@Override
	public Tactic[] filterFindByGroupId_PrevAndNext(long tacticId,
		long groupId, OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
		Tactic tactic, long groupId,
		OrderByComparator<Tactic> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
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

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

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
	 */
	@Override
	public void removeByGroupId(long groupId) {
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
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

	/**
	 * Returns the number of tactics that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tactics that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
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

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

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
	 */
	@Override
	public List<Tactic> findByCampaignId(long campaignId) {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of matching tactics
	 */
	@Override
	public List<Tactic> findByCampaignId(long campaignId, int start, int end) {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tactics
	 */
	@Override
	public List<Tactic> findByCampaignId(long campaignId, int start, int end,
		OrderByComparator<Tactic> orderByComparator) {
		return findByCampaignId(campaignId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tactics where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tactics
	 */
	@Override
	public List<Tactic> findByCampaignId(long campaignId, int start, int end,
		OrderByComparator<Tactic> orderByComparator, boolean retrieveFromCache) {
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

		List<Tactic> list = null;

		if (retrieveFromCache) {
			list = (List<Tactic>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Tactic tactic : list) {
					if ((campaignId != tactic.getCampaignId())) {
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first tactic in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tactic
	 * @throws NoSuchTacticException if a matching tactic could not be found
	 */
	@Override
	public Tactic findByCampaignId_First(long campaignId,
		OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
	 */
	@Override
	public Tactic fetchByCampaignId_First(long campaignId,
		OrderByComparator<Tactic> orderByComparator) {
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
	 * @throws NoSuchTacticException if a matching tactic could not be found
	 */
	@Override
	public Tactic findByCampaignId_Last(long campaignId,
		OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
	 */
	@Override
	public Tactic fetchByCampaignId_Last(long campaignId,
		OrderByComparator<Tactic> orderByComparator) {
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
	 * @throws NoSuchTacticException if a tactic with the primary key could not be found
	 */
	@Override
	public Tactic[] findByCampaignId_PrevAndNext(long tacticId,
		long campaignId, OrderByComparator<Tactic> orderByComparator)
		throws NoSuchTacticException {
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
		Tactic tactic, long campaignId,
		OrderByComparator<Tactic> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
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
	 */
	@Override
	public void removeByCampaignId(long campaignId) {
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
	 */
	@Override
	public int countByCampaignId(long campaignId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNID;

		Object[] finderArgs = new Object[] { campaignId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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
		entityCache.putResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticImpl.class, tactic.getPrimaryKey(), tactic);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			if (entityCache.getResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
						TacticImpl.class, tactic.getPrimaryKey()) == null) {
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
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TacticImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tactic.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tactic tactic) {
		entityCache.removeResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticImpl.class, tactic.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TacticModelImpl)tactic);
	}

	@Override
	public void clearCache(List<Tactic> tactics) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Tactic tactic : tactics) {
			entityCache.removeResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
				TacticImpl.class, tactic.getPrimaryKey());

			clearUniqueFindersCache((TacticModelImpl)tactic);
		}
	}

	protected void cacheUniqueFindersCache(TacticModelImpl tacticModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					tacticModelImpl.getUuid(), tacticModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				tacticModelImpl);
		}
		else {
			if ((tacticModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tacticModelImpl.getUuid(), tacticModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					tacticModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(TacticModelImpl tacticModelImpl) {
		Object[] args = new Object[] {
				tacticModelImpl.getUuid(), tacticModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((tacticModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					tacticModelImpl.getOriginalUuid(),
					tacticModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
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

		tactic.setCompanyId(companyProvider.getCompanyId());

		return tactic;
	}

	/**
	 * Removes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tacticId the primary key of the tactic
	 * @return the tactic that was removed
	 * @throws NoSuchTacticException if a tactic with the primary key could not be found
	 */
	@Override
	public Tactic remove(long tacticId) throws NoSuchTacticException {
		return remove((Serializable)tacticId);
	}

	/**
	 * Removes the tactic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tactic
	 * @return the tactic that was removed
	 * @throws NoSuchTacticException if a tactic with the primary key could not be found
	 */
	@Override
	public Tactic remove(Serializable primaryKey) throws NoSuchTacticException {
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
	protected Tactic removeImpl(Tactic tactic) {
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
	public Tactic updateImpl(Tactic tactic) {
		tactic = toUnwrappedModel(tactic);

		boolean isNew = tactic.isNew();

		TacticModelImpl tacticModelImpl = (TacticModelImpl)tactic;

		if (Validator.isNull(tactic.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			tactic.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (tactic.getCreateDate() == null)) {
			if (serviceContext == null) {
				tactic.setCreateDate(now);
			}
			else {
				tactic.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!tacticModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				tactic.setModifiedDate(now);
			}
			else {
				tactic.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (tactic.isNew()) {
				session.save(tactic);

				tactic.setNew(false);
			}
			else {
				tactic = (Tactic)session.merge(tactic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TacticModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tacticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { tacticModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { tacticModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((tacticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tacticModelImpl.getOriginalUuid(),
						tacticModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						tacticModelImpl.getUuid(),
						tacticModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((tacticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tacticModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { tacticModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((tacticModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tacticModelImpl.getOriginalCampaignId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { tacticModelImpl.getCampaignId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}
		}

		entityCache.putResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
			TacticImpl.class, tactic.getPrimaryKey(), tactic, false);

		clearUniqueFindersCache(tacticModelImpl);
		cacheUniqueFindersCache(tacticModelImpl, isNew);

		tactic.resetOriginalValues();

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
	 * Returns the tactic with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tactic
	 * @return the tactic
	 * @throws NoSuchTacticException if a tactic with the primary key could not be found
	 */
	@Override
	public Tactic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTacticException {
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
	 * Returns the tactic with the primary key or throws a {@link NoSuchTacticException} if it could not be found.
	 *
	 * @param tacticId the primary key of the tactic
	 * @return the tactic
	 * @throws NoSuchTacticException if a tactic with the primary key could not be found
	 */
	@Override
	public Tactic findByPrimaryKey(long tacticId) throws NoSuchTacticException {
		return findByPrimaryKey((Serializable)tacticId);
	}

	/**
	 * Returns the tactic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tactic
	 * @return the tactic, or <code>null</code> if a tactic with the primary key could not be found
	 */
	@Override
	public Tactic fetchByPrimaryKey(Serializable primaryKey) {
		Tactic tactic = (Tactic)entityCache.getResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
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
					entityCache.putResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
						TacticImpl.class, primaryKey, _nullTactic);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
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
	 */
	@Override
	public Tactic fetchByPrimaryKey(long tacticId) {
		return fetchByPrimaryKey((Serializable)tacticId);
	}

	@Override
	public Map<Serializable, Tactic> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Tactic> map = new HashMap<Serializable, Tactic>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Tactic tactic = fetchByPrimaryKey(primaryKey);

			if (tactic != null) {
				map.put(primaryKey, tactic);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Tactic tactic = (Tactic)entityCache.getResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
					TacticImpl.class, primaryKey);

			if (tactic == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, tactic);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TACTIC_WHERE_PKS_IN);

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

			for (Tactic tactic : (List<Tactic>)q.list()) {
				map.put(tactic.getPrimaryKeyObj(), tactic);

				cacheResult(tactic);

				uncachedPrimaryKeys.remove(tactic.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TacticModelImpl.ENTITY_CACHE_ENABLED,
					TacticImpl.class, primaryKey, _nullTactic);
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
	 * Returns all the tactics.
	 *
	 * @return the tactics
	 */
	@Override
	public List<Tactic> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tactics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of tactics
	 */
	@Override
	public List<Tactic> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tactics
	 */
	@Override
	public List<Tactic> findAll(int start, int end,
		OrderByComparator<Tactic> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tactics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tactics
	 */
	@Override
	public List<Tactic> findAll(int start, int end,
		OrderByComparator<Tactic> orderByComparator, boolean retrieveFromCache) {
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

		List<Tactic> list = null;

		if (retrieveFromCache) {
			list = (List<Tactic>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tactic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the tactics from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Tactic tactic : findAll()) {
			remove(tactic);
		}
	}

	/**
	 * Returns the number of tactics.
	 *
	 * @return the number of tactics
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TACTIC);

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

	/**
	 * Returns the primaryKeys of user segments associated with the tactic.
	 *
	 * @param pk the primary key of the tactic
	 * @return long[] of the primaryKeys of user segments associated with the tactic
	 */
	@Override
	public long[] getUserSegmentPrimaryKeys(long pk) {
		long[] pks = tacticToUserSegmentTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the user segments associated with the tactic.
	 *
	 * @param pk the primary key of the tactic
	 * @return the user segments associated with the tactic
	 */
	@Override
	public List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk) {
		return getUserSegments(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the user segments associated with the tactic.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the tactic
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @return the range of user segments associated with the tactic
	 */
	@Override
	public List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end) {
		return getUserSegments(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segments associated with the tactic.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TacticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the tactic
	 * @param start the lower bound of the range of tactics
	 * @param end the upper bound of the range of tactics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user segments associated with the tactic
	 */
	@Override
	public List<com.liferay.content.targeting.model.UserSegment> getUserSegments(
		long pk, int start, int end,
		OrderByComparator<com.liferay.content.targeting.model.UserSegment> orderByComparator) {
		return tacticToUserSegmentTableMapper.getRightBaseModels(pk, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of user segments associated with the tactic.
	 *
	 * @param pk the primary key of the tactic
	 * @return the number of user segments associated with the tactic
	 */
	@Override
	public int getUserSegmentsSize(long pk) {
		long[] pks = tacticToUserSegmentTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the user segment is associated with the tactic.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegmentPK the primary key of the user segment
	 * @return <code>true</code> if the user segment is associated with the tactic; <code>false</code> otherwise
	 */
	@Override
	public boolean containsUserSegment(long pk, long userSegmentPK) {
		return tacticToUserSegmentTableMapper.containsTableMapping(pk,
			userSegmentPK);
	}

	/**
	 * Returns <code>true</code> if the tactic has any user segments associated with it.
	 *
	 * @param pk the primary key of the tactic to check for associations with user segments
	 * @return <code>true</code> if the tactic has any user segments associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsUserSegments(long pk) {
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
	 */
	@Override
	public void addUserSegment(long pk, long userSegmentPK) {
		Tactic tactic = fetchByPrimaryKey(pk);

		if (tactic == null) {
			tacticToUserSegmentTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, userSegmentPK);
		}
		else {
			tacticToUserSegmentTableMapper.addTableMapping(tactic.getCompanyId(),
				pk, userSegmentPK);
		}
	}

	/**
	 * Adds an association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegment the user segment
	 */
	@Override
	public void addUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		Tactic tactic = fetchByPrimaryKey(pk);

		if (tactic == null) {
			tacticToUserSegmentTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, userSegment.getPrimaryKey());
		}
		else {
			tacticToUserSegmentTableMapper.addTableMapping(tactic.getCompanyId(),
				pk, userSegment.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegmentPKs the primary keys of the user segments
	 */
	@Override
	public void addUserSegments(long pk, long[] userSegmentPKs) {
		long companyId = 0;

		Tactic tactic = fetchByPrimaryKey(pk);

		if (tactic == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = tactic.getCompanyId();
		}

		for (long userSegmentPK : userSegmentPKs) {
			tacticToUserSegmentTableMapper.addTableMapping(companyId, pk,
				userSegmentPK);
		}
	}

	/**
	 * Adds an association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegments the user segments
	 */
	@Override
	public void addUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments) {
		long companyId = 0;

		Tactic tactic = fetchByPrimaryKey(pk);

		if (tactic == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = tactic.getCompanyId();
		}

		for (com.liferay.content.targeting.model.UserSegment userSegment : userSegments) {
			tacticToUserSegmentTableMapper.addTableMapping(companyId, pk,
				userSegment.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the tactic and its user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic to clear the associated user segments from
	 */
	@Override
	public void clearUserSegments(long pk) {
		tacticToUserSegmentTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegmentPK the primary key of the user segment
	 */
	@Override
	public void removeUserSegment(long pk, long userSegmentPK) {
		tacticToUserSegmentTableMapper.deleteTableMapping(pk, userSegmentPK);
	}

	/**
	 * Removes the association between the tactic and the user segment. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegment the user segment
	 */
	@Override
	public void removeUserSegment(long pk,
		com.liferay.content.targeting.model.UserSegment userSegment) {
		tacticToUserSegmentTableMapper.deleteTableMapping(pk,
			userSegment.getPrimaryKey());
	}

	/**
	 * Removes the association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegmentPKs the primary keys of the user segments
	 */
	@Override
	public void removeUserSegments(long pk, long[] userSegmentPKs) {
		for (long userSegmentPK : userSegmentPKs) {
			tacticToUserSegmentTableMapper.deleteTableMapping(pk, userSegmentPK);
		}
	}

	/**
	 * Removes the association between the tactic and the user segments. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegments the user segments
	 */
	@Override
	public void removeUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments) {
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
	 */
	@Override
	public void setUserSegments(long pk, long[] userSegmentPKs) {
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

		long companyId = 0;

		Tactic tactic = fetchByPrimaryKey(pk);

		if (tactic == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = tactic.getCompanyId();
		}

		for (long newUserSegmentPK : newUserSegmentPKsSet) {
			tacticToUserSegmentTableMapper.addTableMapping(companyId, pk,
				newUserSegmentPK);
		}
	}

	/**
	 * Sets the user segments associated with the tactic, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the tactic
	 * @param userSegments the user segments to be associated with the tactic
	 */
	@Override
	public void setUserSegments(long pk,
		List<com.liferay.content.targeting.model.UserSegment> userSegments) {
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
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TacticModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tactic persistence.
	 */
	public void afterPropertiesSet() {
		tacticToUserSegmentTableMapper = TableMapperFactory.getTableMapper("CT_Tactics_UserSegments",
				"companyId", "tacticId", "userSegmentId", this,
				userSegmentPersistence);
	}

	public void destroy() {
		entityCache.removeCache(TacticImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("CT_Tactics_UserSegments");
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = UserSegmentPersistence.class)
	protected UserSegmentPersistence userSegmentPersistence;
	protected TableMapper<Tactic, com.liferay.content.targeting.model.UserSegment> tacticToUserSegmentTableMapper;
	private static final String _SQL_SELECT_TACTIC = "SELECT tactic FROM Tactic tactic";
	private static final String _SQL_SELECT_TACTIC_WHERE_PKS_IN = "SELECT tactic FROM Tactic tactic WHERE tacticId IN (";
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
	private static final Log _log = LogFactoryUtil.getLog(TacticPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static final Tactic _nullTactic = new TacticImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Tactic> toCacheModel() {
				return _nullTacticCacheModel;
			}
		};

	private static final CacheModel<Tactic> _nullTacticCacheModel = new CacheModel<Tactic>() {
			@Override
			public Tactic toEntityModel() {
				return _nullTactic;
			}
		};
}