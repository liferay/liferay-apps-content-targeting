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

package com.liferay.content.targeting.rule.score.points.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException;
import com.liferay.content.targeting.rule.score.points.model.ScorePoint;
import com.liferay.content.targeting.rule.score.points.model.impl.ScorePointImpl;
import com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl;
import com.liferay.content.targeting.rule.score.points.service.persistence.ScorePointPersistence;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the score point service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScorePointPersistence
 * @see com.liferay.content.targeting.rule.score.points.service.persistence.ScorePointUtil
 * @generated
 */
@ProviderType
public class ScorePointPersistenceImpl extends BasePersistenceImpl<ScorePoint>
	implements ScorePointPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScorePointUtil} to access the score point persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScorePointImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, ScorePointImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, ScorePointImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, ScorePointImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, ScorePointImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ScorePointModelImpl.UUID_COLUMN_BITMASK |
			ScorePointModelImpl.ANONYMOUSUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the score points where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching score points
	 */
	@Override
	public List<ScorePoint> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the score points where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @return the range of matching score points
	 */
	@Override
	public List<ScorePoint> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the score points where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching score points
	 */
	@Override
	public List<ScorePoint> findByUuid(String uuid, int start, int end,
		OrderByComparator<ScorePoint> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the score points where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching score points
	 */
	@Override
	public List<ScorePoint> findByUuid(String uuid, int start, int end,
		OrderByComparator<ScorePoint> orderByComparator,
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

		List<ScorePoint> list = null;

		if (retrieveFromCache) {
			list = (List<ScorePoint>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ScorePoint scorePoint : list) {
					if (!Validator.equals(uuid, scorePoint.getUuid())) {
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

			query.append(_SQL_SELECT_SCOREPOINT_WHERE);

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
				query.append(ScorePointModelImpl.ORDER_BY_JPQL);
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
					list = (List<ScorePoint>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ScorePoint>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first score point in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching score point
	 * @throws NoSuchScorePointException if a matching score point could not be found
	 */
	@Override
	public ScorePoint findByUuid_First(String uuid,
		OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = fetchByUuid_First(uuid, orderByComparator);

		if (scorePoint != null) {
			return scorePoint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScorePointException(msg.toString());
	}

	/**
	 * Returns the first score point in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching score point, or <code>null</code> if a matching score point could not be found
	 */
	@Override
	public ScorePoint fetchByUuid_First(String uuid,
		OrderByComparator<ScorePoint> orderByComparator) {
		List<ScorePoint> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last score point in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching score point
	 * @throws NoSuchScorePointException if a matching score point could not be found
	 */
	@Override
	public ScorePoint findByUuid_Last(String uuid,
		OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = fetchByUuid_Last(uuid, orderByComparator);

		if (scorePoint != null) {
			return scorePoint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScorePointException(msg.toString());
	}

	/**
	 * Returns the last score point in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching score point, or <code>null</code> if a matching score point could not be found
	 */
	@Override
	public ScorePoint fetchByUuid_Last(String uuid,
		OrderByComparator<ScorePoint> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ScorePoint> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the score points before and after the current score point in the ordered set where uuid = &#63;.
	 *
	 * @param scorePointId the primary key of the current score point
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next score point
	 * @throws NoSuchScorePointException if a score point with the primary key could not be found
	 */
	@Override
	public ScorePoint[] findByUuid_PrevAndNext(long scorePointId, String uuid,
		OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = findByPrimaryKey(scorePointId);

		Session session = null;

		try {
			session = openSession();

			ScorePoint[] array = new ScorePointImpl[3];

			array[0] = getByUuid_PrevAndNext(session, scorePoint, uuid,
					orderByComparator, true);

			array[1] = scorePoint;

			array[2] = getByUuid_PrevAndNext(session, scorePoint, uuid,
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

	protected ScorePoint getByUuid_PrevAndNext(Session session,
		ScorePoint scorePoint, String uuid,
		OrderByComparator<ScorePoint> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCOREPOINT_WHERE);

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
			query.append(ScorePointModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(scorePoint);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScorePoint> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the score points where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ScorePoint scorePoint : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(scorePoint);
		}
	}

	/**
	 * Returns the number of score points where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching score points
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCOREPOINT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "scorePoint.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "scorePoint.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(scorePoint.uuid IS NULL OR scorePoint.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, ScorePointImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, ScorePointImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ScorePointModelImpl.UUID_COLUMN_BITMASK |
			ScorePointModelImpl.COMPANYID_COLUMN_BITMASK |
			ScorePointModelImpl.ANONYMOUSUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the score points where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching score points
	 */
	@Override
	public List<ScorePoint> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the score points where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @return the range of matching score points
	 */
	@Override
	public List<ScorePoint> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the score points where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching score points
	 */
	@Override
	public List<ScorePoint> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<ScorePoint> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the score points where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching score points
	 */
	@Override
	public List<ScorePoint> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<ScorePoint> orderByComparator,
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

		List<ScorePoint> list = null;

		if (retrieveFromCache) {
			list = (List<ScorePoint>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ScorePoint scorePoint : list) {
					if (!Validator.equals(uuid, scorePoint.getUuid()) ||
							(companyId != scorePoint.getCompanyId())) {
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

			query.append(_SQL_SELECT_SCOREPOINT_WHERE);

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
				query.append(ScorePointModelImpl.ORDER_BY_JPQL);
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
					list = (List<ScorePoint>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ScorePoint>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first score point in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching score point
	 * @throws NoSuchScorePointException if a matching score point could not be found
	 */
	@Override
	public ScorePoint findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (scorePoint != null) {
			return scorePoint;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScorePointException(msg.toString());
	}

	/**
	 * Returns the first score point in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching score point, or <code>null</code> if a matching score point could not be found
	 */
	@Override
	public ScorePoint fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ScorePoint> orderByComparator) {
		List<ScorePoint> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last score point in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching score point
	 * @throws NoSuchScorePointException if a matching score point could not be found
	 */
	@Override
	public ScorePoint findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (scorePoint != null) {
			return scorePoint;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScorePointException(msg.toString());
	}

	/**
	 * Returns the last score point in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching score point, or <code>null</code> if a matching score point could not be found
	 */
	@Override
	public ScorePoint fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ScorePoint> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ScorePoint> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the score points before and after the current score point in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param scorePointId the primary key of the current score point
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next score point
	 * @throws NoSuchScorePointException if a score point with the primary key could not be found
	 */
	@Override
	public ScorePoint[] findByUuid_C_PrevAndNext(long scorePointId,
		String uuid, long companyId,
		OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = findByPrimaryKey(scorePointId);

		Session session = null;

		try {
			session = openSession();

			ScorePoint[] array = new ScorePointImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, scorePoint, uuid,
					companyId, orderByComparator, true);

			array[1] = scorePoint;

			array[2] = getByUuid_C_PrevAndNext(session, scorePoint, uuid,
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

	protected ScorePoint getByUuid_C_PrevAndNext(Session session,
		ScorePoint scorePoint, String uuid, long companyId,
		OrderByComparator<ScorePoint> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SCOREPOINT_WHERE);

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
			query.append(ScorePointModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(scorePoint);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScorePoint> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the score points where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ScorePoint scorePoint : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scorePoint);
		}
	}

	/**
	 * Returns the number of score points where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching score points
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCOREPOINT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "scorePoint.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "scorePoint.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(scorePoint.uuid IS NULL OR scorePoint.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "scorePoint.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSEGMENTID =
		new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, ScorePointImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserSegmentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID =
		new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, ScorePointImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserSegmentId",
			new String[] { Long.class.getName() },
			ScorePointModelImpl.USERSEGMENTID_COLUMN_BITMASK |
			ScorePointModelImpl.ANONYMOUSUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERSEGMENTID = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserSegmentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the score points where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @return the matching score points
	 */
	@Override
	public List<ScorePoint> findByUserSegmentId(long userSegmentId) {
		return findByUserSegmentId(userSegmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the score points where userSegmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @return the range of matching score points
	 */
	@Override
	public List<ScorePoint> findByUserSegmentId(long userSegmentId, int start,
		int end) {
		return findByUserSegmentId(userSegmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the score points where userSegmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching score points
	 */
	@Override
	public List<ScorePoint> findByUserSegmentId(long userSegmentId, int start,
		int end, OrderByComparator<ScorePoint> orderByComparator) {
		return findByUserSegmentId(userSegmentId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the score points where userSegmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching score points
	 */
	@Override
	public List<ScorePoint> findByUserSegmentId(long userSegmentId, int start,
		int end, OrderByComparator<ScorePoint> orderByComparator,
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

		List<ScorePoint> list = null;

		if (retrieveFromCache) {
			list = (List<ScorePoint>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ScorePoint scorePoint : list) {
					if ((userSegmentId != scorePoint.getUserSegmentId())) {
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

			query.append(_SQL_SELECT_SCOREPOINT_WHERE);

			query.append(_FINDER_COLUMN_USERSEGMENTID_USERSEGMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScorePointModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userSegmentId);

				if (!pagination) {
					list = (List<ScorePoint>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ScorePoint>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first score point in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching score point
	 * @throws NoSuchScorePointException if a matching score point could not be found
	 */
	@Override
	public ScorePoint findByUserSegmentId_First(long userSegmentId,
		OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = fetchByUserSegmentId_First(userSegmentId,
				orderByComparator);

		if (scorePoint != null) {
			return scorePoint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userSegmentId=");
		msg.append(userSegmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScorePointException(msg.toString());
	}

	/**
	 * Returns the first score point in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching score point, or <code>null</code> if a matching score point could not be found
	 */
	@Override
	public ScorePoint fetchByUserSegmentId_First(long userSegmentId,
		OrderByComparator<ScorePoint> orderByComparator) {
		List<ScorePoint> list = findByUserSegmentId(userSegmentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last score point in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching score point
	 * @throws NoSuchScorePointException if a matching score point could not be found
	 */
	@Override
	public ScorePoint findByUserSegmentId_Last(long userSegmentId,
		OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = fetchByUserSegmentId_Last(userSegmentId,
				orderByComparator);

		if (scorePoint != null) {
			return scorePoint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userSegmentId=");
		msg.append(userSegmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScorePointException(msg.toString());
	}

	/**
	 * Returns the last score point in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching score point, or <code>null</code> if a matching score point could not be found
	 */
	@Override
	public ScorePoint fetchByUserSegmentId_Last(long userSegmentId,
		OrderByComparator<ScorePoint> orderByComparator) {
		int count = countByUserSegmentId(userSegmentId);

		if (count == 0) {
			return null;
		}

		List<ScorePoint> list = findByUserSegmentId(userSegmentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the score points before and after the current score point in the ordered set where userSegmentId = &#63;.
	 *
	 * @param scorePointId the primary key of the current score point
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next score point
	 * @throws NoSuchScorePointException if a score point with the primary key could not be found
	 */
	@Override
	public ScorePoint[] findByUserSegmentId_PrevAndNext(long scorePointId,
		long userSegmentId, OrderByComparator<ScorePoint> orderByComparator)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = findByPrimaryKey(scorePointId);

		Session session = null;

		try {
			session = openSession();

			ScorePoint[] array = new ScorePointImpl[3];

			array[0] = getByUserSegmentId_PrevAndNext(session, scorePoint,
					userSegmentId, orderByComparator, true);

			array[1] = scorePoint;

			array[2] = getByUserSegmentId_PrevAndNext(session, scorePoint,
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

	protected ScorePoint getByUserSegmentId_PrevAndNext(Session session,
		ScorePoint scorePoint, long userSegmentId,
		OrderByComparator<ScorePoint> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCOREPOINT_WHERE);

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
			query.append(ScorePointModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userSegmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scorePoint);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScorePoint> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the score points where userSegmentId = &#63; from the database.
	 *
	 * @param userSegmentId the user segment ID
	 */
	@Override
	public void removeByUserSegmentId(long userSegmentId) {
		for (ScorePoint scorePoint : findByUserSegmentId(userSegmentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scorePoint);
		}
	}

	/**
	 * Returns the number of score points where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @return the number of matching score points
	 */
	@Override
	public int countByUserSegmentId(long userSegmentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERSEGMENTID;

		Object[] finderArgs = new Object[] { userSegmentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCOREPOINT_WHERE);

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

	private static final String _FINDER_COLUMN_USERSEGMENTID_USERSEGMENTID_2 = "scorePoint.userSegmentId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_U = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, ScorePointImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			ScorePointModelImpl.ANONYMOUSUSERID_COLUMN_BITMASK |
			ScorePointModelImpl.USERSEGMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_U = new FinderPath(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or throws a {@link NoSuchScorePointException} if it could not be found.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param userSegmentId the user segment ID
	 * @return the matching score point
	 * @throws NoSuchScorePointException if a matching score point could not be found
	 */
	@Override
	public ScorePoint findByC_U(long anonymousUserId, long userSegmentId)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = fetchByC_U(anonymousUserId, userSegmentId);

		if (scorePoint == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("anonymousUserId=");
			msg.append(anonymousUserId);

			msg.append(", userSegmentId=");
			msg.append(userSegmentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchScorePointException(msg.toString());
		}

		return scorePoint;
	}

	/**
	 * Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param userSegmentId the user segment ID
	 * @return the matching score point, or <code>null</code> if a matching score point could not be found
	 */
	@Override
	public ScorePoint fetchByC_U(long anonymousUserId, long userSegmentId) {
		return fetchByC_U(anonymousUserId, userSegmentId, true);
	}

	/**
	 * Returns the score point where anonymousUserId = &#63; and userSegmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param userSegmentId the user segment ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching score point, or <code>null</code> if a matching score point could not be found
	 */
	@Override
	public ScorePoint fetchByC_U(long anonymousUserId, long userSegmentId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { anonymousUserId, userSegmentId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_U,
					finderArgs, this);
		}

		if (result instanceof ScorePoint) {
			ScorePoint scorePoint = (ScorePoint)result;

			if ((anonymousUserId != scorePoint.getAnonymousUserId()) ||
					(userSegmentId != scorePoint.getUserSegmentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SCOREPOINT_WHERE);

			query.append(_FINDER_COLUMN_C_U_ANONYMOUSUSERID_2);

			query.append(_FINDER_COLUMN_C_U_USERSEGMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anonymousUserId);

				qPos.add(userSegmentId);

				List<ScorePoint> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_U, finderArgs,
						list);
				}
				else {
					ScorePoint scorePoint = list.get(0);

					result = scorePoint;

					cacheResult(scorePoint);

					if ((scorePoint.getAnonymousUserId() != anonymousUserId) ||
							(scorePoint.getUserSegmentId() != userSegmentId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_U,
							finderArgs, scorePoint);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_U, finderArgs);

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
			return (ScorePoint)result;
		}
	}

	/**
	 * Removes the score point where anonymousUserId = &#63; and userSegmentId = &#63; from the database.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param userSegmentId the user segment ID
	 * @return the score point that was removed
	 */
	@Override
	public ScorePoint removeByC_U(long anonymousUserId, long userSegmentId)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = findByC_U(anonymousUserId, userSegmentId);

		return remove(scorePoint);
	}

	/**
	 * Returns the number of score points where anonymousUserId = &#63; and userSegmentId = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param userSegmentId the user segment ID
	 * @return the number of matching score points
	 */
	@Override
	public int countByC_U(long anonymousUserId, long userSegmentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_U;

		Object[] finderArgs = new Object[] { anonymousUserId, userSegmentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCOREPOINT_WHERE);

			query.append(_FINDER_COLUMN_C_U_ANONYMOUSUSERID_2);

			query.append(_FINDER_COLUMN_C_U_USERSEGMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anonymousUserId);

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

	private static final String _FINDER_COLUMN_C_U_ANONYMOUSUSERID_2 = "scorePoint.anonymousUserId = ? AND ";
	private static final String _FINDER_COLUMN_C_U_USERSEGMENTID_2 = "scorePoint.userSegmentId = ?";

	public ScorePointPersistenceImpl() {
		setModelClass(ScorePoint.class);
	}

	/**
	 * Caches the score point in the entity cache if it is enabled.
	 *
	 * @param scorePoint the score point
	 */
	@Override
	public void cacheResult(ScorePoint scorePoint) {
		entityCache.putResult(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointImpl.class, scorePoint.getPrimaryKey(), scorePoint);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_U,
			new Object[] {
				scorePoint.getAnonymousUserId(), scorePoint.getUserSegmentId()
			}, scorePoint);

		scorePoint.resetOriginalValues();
	}

	/**
	 * Caches the score points in the entity cache if it is enabled.
	 *
	 * @param scorePoints the score points
	 */
	@Override
	public void cacheResult(List<ScorePoint> scorePoints) {
		for (ScorePoint scorePoint : scorePoints) {
			if (entityCache.getResult(
						ScorePointModelImpl.ENTITY_CACHE_ENABLED,
						ScorePointImpl.class, scorePoint.getPrimaryKey()) == null) {
				cacheResult(scorePoint);
			}
			else {
				scorePoint.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all score points.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ScorePointImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the score point.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScorePoint scorePoint) {
		entityCache.removeResult(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointImpl.class, scorePoint.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ScorePointModelImpl)scorePoint);
	}

	@Override
	public void clearCache(List<ScorePoint> scorePoints) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScorePoint scorePoint : scorePoints) {
			entityCache.removeResult(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
				ScorePointImpl.class, scorePoint.getPrimaryKey());

			clearUniqueFindersCache((ScorePointModelImpl)scorePoint);
		}
	}

	protected void cacheUniqueFindersCache(
		ScorePointModelImpl scorePointModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					scorePointModelImpl.getAnonymousUserId(),
					scorePointModelImpl.getUserSegmentId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_C_U, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_C_U, args,
				scorePointModelImpl);
		}
		else {
			if ((scorePointModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scorePointModelImpl.getAnonymousUserId(),
						scorePointModelImpl.getUserSegmentId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_C_U, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_C_U, args,
					scorePointModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ScorePointModelImpl scorePointModelImpl) {
		Object[] args = new Object[] {
				scorePointModelImpl.getAnonymousUserId(),
				scorePointModelImpl.getUserSegmentId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_C_U, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_C_U, args);

		if ((scorePointModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_U.getColumnBitmask()) != 0) {
			args = new Object[] {
					scorePointModelImpl.getOriginalAnonymousUserId(),
					scorePointModelImpl.getOriginalUserSegmentId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_U, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_U, args);
		}
	}

	/**
	 * Creates a new score point with the primary key. Does not add the score point to the database.
	 *
	 * @param scorePointId the primary key for the new score point
	 * @return the new score point
	 */
	@Override
	public ScorePoint create(long scorePointId) {
		ScorePoint scorePoint = new ScorePointImpl();

		scorePoint.setNew(true);
		scorePoint.setPrimaryKey(scorePointId);

		String uuid = PortalUUIDUtil.generate();

		scorePoint.setUuid(uuid);

		scorePoint.setCompanyId(companyProvider.getCompanyId());

		return scorePoint;
	}

	/**
	 * Removes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scorePointId the primary key of the score point
	 * @return the score point that was removed
	 * @throws NoSuchScorePointException if a score point with the primary key could not be found
	 */
	@Override
	public ScorePoint remove(long scorePointId)
		throws NoSuchScorePointException {
		return remove((Serializable)scorePointId);
	}

	/**
	 * Removes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the score point
	 * @return the score point that was removed
	 * @throws NoSuchScorePointException if a score point with the primary key could not be found
	 */
	@Override
	public ScorePoint remove(Serializable primaryKey)
		throws NoSuchScorePointException {
		Session session = null;

		try {
			session = openSession();

			ScorePoint scorePoint = (ScorePoint)session.get(ScorePointImpl.class,
					primaryKey);

			if (scorePoint == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScorePointException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scorePoint);
		}
		catch (NoSuchScorePointException nsee) {
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
	protected ScorePoint removeImpl(ScorePoint scorePoint) {
		scorePoint = toUnwrappedModel(scorePoint);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scorePoint)) {
				scorePoint = (ScorePoint)session.get(ScorePointImpl.class,
						scorePoint.getPrimaryKeyObj());
			}

			if (scorePoint != null) {
				session.delete(scorePoint);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scorePoint != null) {
			clearCache(scorePoint);
		}

		return scorePoint;
	}

	@Override
	public ScorePoint updateImpl(ScorePoint scorePoint) {
		scorePoint = toUnwrappedModel(scorePoint);

		boolean isNew = scorePoint.isNew();

		ScorePointModelImpl scorePointModelImpl = (ScorePointModelImpl)scorePoint;

		if (Validator.isNull(scorePoint.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			scorePoint.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (scorePoint.isNew()) {
				session.save(scorePoint);

				scorePoint.setNew(false);
			}
			else {
				scorePoint = (ScorePoint)session.merge(scorePoint);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ScorePointModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scorePointModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scorePointModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { scorePointModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((scorePointModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scorePointModelImpl.getOriginalUuid(),
						scorePointModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						scorePointModelImpl.getUuid(),
						scorePointModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((scorePointModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scorePointModelImpl.getOriginalUserSegmentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERSEGMENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID,
					args);

				args = new Object[] { scorePointModelImpl.getUserSegmentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERSEGMENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID,
					args);
			}
		}

		entityCache.putResult(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
			ScorePointImpl.class, scorePoint.getPrimaryKey(), scorePoint, false);

		clearUniqueFindersCache(scorePointModelImpl);
		cacheUniqueFindersCache(scorePointModelImpl, isNew);

		scorePoint.resetOriginalValues();

		return scorePoint;
	}

	protected ScorePoint toUnwrappedModel(ScorePoint scorePoint) {
		if (scorePoint instanceof ScorePointImpl) {
			return scorePoint;
		}

		ScorePointImpl scorePointImpl = new ScorePointImpl();

		scorePointImpl.setNew(scorePoint.isNew());
		scorePointImpl.setPrimaryKey(scorePoint.getPrimaryKey());

		scorePointImpl.setUuid(scorePoint.getUuid());
		scorePointImpl.setScorePointId(scorePoint.getScorePointId());
		scorePointImpl.setCompanyId(scorePoint.getCompanyId());
		scorePointImpl.setAnonymousUserId(scorePoint.getAnonymousUserId());
		scorePointImpl.setUserSegmentId(scorePoint.getUserSegmentId());
		scorePointImpl.setPoints(scorePoint.getPoints());

		return scorePointImpl;
	}

	/**
	 * Returns the score point with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the score point
	 * @return the score point
	 * @throws NoSuchScorePointException if a score point with the primary key could not be found
	 */
	@Override
	public ScorePoint findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScorePointException {
		ScorePoint scorePoint = fetchByPrimaryKey(primaryKey);

		if (scorePoint == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScorePointException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scorePoint;
	}

	/**
	 * Returns the score point with the primary key or throws a {@link NoSuchScorePointException} if it could not be found.
	 *
	 * @param scorePointId the primary key of the score point
	 * @return the score point
	 * @throws NoSuchScorePointException if a score point with the primary key could not be found
	 */
	@Override
	public ScorePoint findByPrimaryKey(long scorePointId)
		throws NoSuchScorePointException {
		return findByPrimaryKey((Serializable)scorePointId);
	}

	/**
	 * Returns the score point with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the score point
	 * @return the score point, or <code>null</code> if a score point with the primary key could not be found
	 */
	@Override
	public ScorePoint fetchByPrimaryKey(Serializable primaryKey) {
		ScorePoint scorePoint = (ScorePoint)entityCache.getResult(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
				ScorePointImpl.class, primaryKey);

		if (scorePoint == _nullScorePoint) {
			return null;
		}

		if (scorePoint == null) {
			Session session = null;

			try {
				session = openSession();

				scorePoint = (ScorePoint)session.get(ScorePointImpl.class,
						primaryKey);

				if (scorePoint != null) {
					cacheResult(scorePoint);
				}
				else {
					entityCache.putResult(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
						ScorePointImpl.class, primaryKey, _nullScorePoint);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
					ScorePointImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scorePoint;
	}

	/**
	 * Returns the score point with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scorePointId the primary key of the score point
	 * @return the score point, or <code>null</code> if a score point with the primary key could not be found
	 */
	@Override
	public ScorePoint fetchByPrimaryKey(long scorePointId) {
		return fetchByPrimaryKey((Serializable)scorePointId);
	}

	@Override
	public Map<Serializable, ScorePoint> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ScorePoint> map = new HashMap<Serializable, ScorePoint>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ScorePoint scorePoint = fetchByPrimaryKey(primaryKey);

			if (scorePoint != null) {
				map.put(primaryKey, scorePoint);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			ScorePoint scorePoint = (ScorePoint)entityCache.getResult(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
					ScorePointImpl.class, primaryKey);

			if (scorePoint == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, scorePoint);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SCOREPOINT_WHERE_PKS_IN);

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

			for (ScorePoint scorePoint : (List<ScorePoint>)q.list()) {
				map.put(scorePoint.getPrimaryKeyObj(), scorePoint);

				cacheResult(scorePoint);

				uncachedPrimaryKeys.remove(scorePoint.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ScorePointModelImpl.ENTITY_CACHE_ENABLED,
					ScorePointImpl.class, primaryKey, _nullScorePoint);
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
	 * Returns all the score points.
	 *
	 * @return the score points
	 */
	@Override
	public List<ScorePoint> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the score points.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @return the range of score points
	 */
	@Override
	public List<ScorePoint> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the score points.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of score points
	 */
	@Override
	public List<ScorePoint> findAll(int start, int end,
		OrderByComparator<ScorePoint> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the score points.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of score points
	 */
	@Override
	public List<ScorePoint> findAll(int start, int end,
		OrderByComparator<ScorePoint> orderByComparator,
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

		List<ScorePoint> list = null;

		if (retrieveFromCache) {
			list = (List<ScorePoint>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SCOREPOINT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCOREPOINT;

				if (pagination) {
					sql = sql.concat(ScorePointModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScorePoint>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ScorePoint>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the score points from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ScorePoint scorePoint : findAll()) {
			remove(scorePoint);
		}
	}

	/**
	 * Returns the number of score points.
	 *
	 * @return the number of score points
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SCOREPOINT);

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
		return ScorePointModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the score point persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ScorePointImpl.class.getName());
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
	private static final String _SQL_SELECT_SCOREPOINT = "SELECT scorePoint FROM ScorePoint scorePoint";
	private static final String _SQL_SELECT_SCOREPOINT_WHERE_PKS_IN = "SELECT scorePoint FROM ScorePoint scorePoint WHERE scorePointId IN (";
	private static final String _SQL_SELECT_SCOREPOINT_WHERE = "SELECT scorePoint FROM ScorePoint scorePoint WHERE ";
	private static final String _SQL_COUNT_SCOREPOINT = "SELECT COUNT(scorePoint) FROM ScorePoint scorePoint";
	private static final String _SQL_COUNT_SCOREPOINT_WHERE = "SELECT COUNT(scorePoint) FROM ScorePoint scorePoint WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scorePoint.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScorePoint exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ScorePoint exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ScorePointPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static final ScorePoint _nullScorePoint = new ScorePointImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScorePoint> toCacheModel() {
				return _nullScorePointCacheModel;
			}
		};

	private static final CacheModel<ScorePoint> _nullScorePointCacheModel = new CacheModel<ScorePoint>() {
			@Override
			public ScorePoint toEntityModel() {
				return _nullScorePoint;
			}
		};
}