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

package com.liferay.content.targeting.analytics.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsReferrerException;
import com.liferay.content.targeting.analytics.model.AnalyticsReferrer;
import com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerImpl;
import com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl;
import com.liferay.content.targeting.analytics.service.persistence.AnalyticsReferrerPersistence;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the analytics referrer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsReferrerPersistence
 * @see com.liferay.content.targeting.analytics.service.persistence.AnalyticsReferrerUtil
 * @generated
 */
@ProviderType
public class AnalyticsReferrerPersistenceImpl extends BasePersistenceImpl<AnalyticsReferrer>
	implements AnalyticsReferrerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnalyticsReferrerUtil} to access the analytics referrer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnalyticsReferrerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsReferrerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsReferrerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANALYTICSEVENTID =
		new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsReferrerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAnalyticsEventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANALYTICSEVENTID =
		new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsReferrerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAnalyticsEventId", new String[] { Long.class.getName() },
			AnalyticsReferrerModelImpl.ANALYTICSEVENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANALYTICSEVENTID = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAnalyticsEventId", new String[] { Long.class.getName() });

	/**
	 * Returns all the analytics referrers where analyticsEventId = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @return the matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByAnalyticsEventId(long analyticsEventId) {
		return findByAnalyticsEventId(analyticsEventId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics referrers where analyticsEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @return the range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByAnalyticsEventId(
		long analyticsEventId, int start, int end) {
		return findByAnalyticsEventId(analyticsEventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics referrers where analyticsEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByAnalyticsEventId(
		long analyticsEventId, int start, int end,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		return findByAnalyticsEventId(analyticsEventId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics referrers where analyticsEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByAnalyticsEventId(
		long analyticsEventId, int start, int end,
		OrderByComparator<AnalyticsReferrer> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANALYTICSEVENTID;
			finderArgs = new Object[] { analyticsEventId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ANALYTICSEVENTID;
			finderArgs = new Object[] {
					analyticsEventId,
					
					start, end, orderByComparator
				};
		}

		List<AnalyticsReferrer> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsReferrer>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsReferrer analyticsReferrer : list) {
					if ((analyticsEventId != analyticsReferrer.getAnalyticsEventId())) {
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

			query.append(_SQL_SELECT_ANALYTICSREFERRER_WHERE);

			query.append(_FINDER_COLUMN_ANALYTICSEVENTID_ANALYTICSEVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsReferrerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analyticsEventId);

				if (!pagination) {
					list = (List<AnalyticsReferrer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsReferrer>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first analytics referrer in the ordered set where analyticsEventId = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer findByAnalyticsEventId_First(
		long analyticsEventId,
		OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException {
		AnalyticsReferrer analyticsReferrer = fetchByAnalyticsEventId_First(analyticsEventId,
				orderByComparator);

		if (analyticsReferrer != null) {
			return analyticsReferrer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("analyticsEventId=");
		msg.append(analyticsEventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsReferrerException(msg.toString());
	}

	/**
	 * Returns the first analytics referrer in the ordered set where analyticsEventId = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer fetchByAnalyticsEventId_First(
		long analyticsEventId,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		List<AnalyticsReferrer> list = findByAnalyticsEventId(analyticsEventId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics referrer in the ordered set where analyticsEventId = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer findByAnalyticsEventId_Last(
		long analyticsEventId,
		OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException {
		AnalyticsReferrer analyticsReferrer = fetchByAnalyticsEventId_Last(analyticsEventId,
				orderByComparator);

		if (analyticsReferrer != null) {
			return analyticsReferrer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("analyticsEventId=");
		msg.append(analyticsEventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsReferrerException(msg.toString());
	}

	/**
	 * Returns the last analytics referrer in the ordered set where analyticsEventId = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer fetchByAnalyticsEventId_Last(
		long analyticsEventId,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		int count = countByAnalyticsEventId(analyticsEventId);

		if (count == 0) {
			return null;
		}

		List<AnalyticsReferrer> list = findByAnalyticsEventId(analyticsEventId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics referrers before and after the current analytics referrer in the ordered set where analyticsEventId = &#63;.
	 *
	 * @param analyticsReferrerId the primary key of the current analytics referrer
	 * @param analyticsEventId the analytics event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	 */
	@Override
	public AnalyticsReferrer[] findByAnalyticsEventId_PrevAndNext(
		long analyticsReferrerId, long analyticsEventId,
		OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException {
		AnalyticsReferrer analyticsReferrer = findByPrimaryKey(analyticsReferrerId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsReferrer[] array = new AnalyticsReferrerImpl[3];

			array[0] = getByAnalyticsEventId_PrevAndNext(session,
					analyticsReferrer, analyticsEventId, orderByComparator, true);

			array[1] = analyticsReferrer;

			array[2] = getByAnalyticsEventId_PrevAndNext(session,
					analyticsReferrer, analyticsEventId, orderByComparator,
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

	protected AnalyticsReferrer getByAnalyticsEventId_PrevAndNext(
		Session session, AnalyticsReferrer analyticsReferrer,
		long analyticsEventId,
		OrderByComparator<AnalyticsReferrer> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANALYTICSREFERRER_WHERE);

		query.append(_FINDER_COLUMN_ANALYTICSEVENTID_ANALYTICSEVENTID_2);

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
			query.append(AnalyticsReferrerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(analyticsEventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsReferrer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsReferrer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics referrers where analyticsEventId = &#63; from the database.
	 *
	 * @param analyticsEventId the analytics event ID
	 */
	@Override
	public void removeByAnalyticsEventId(long analyticsEventId) {
		for (AnalyticsReferrer analyticsReferrer : findByAnalyticsEventId(
				analyticsEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analyticsReferrer);
		}
	}

	/**
	 * Returns the number of analytics referrers where analyticsEventId = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @return the number of matching analytics referrers
	 */
	@Override
	public int countByAnalyticsEventId(long analyticsEventId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ANALYTICSEVENTID;

		Object[] finderArgs = new Object[] { analyticsEventId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANALYTICSREFERRER_WHERE);

			query.append(_FINDER_COLUMN_ANALYTICSEVENTID_ANALYTICSEVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analyticsEventId);

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

	private static final String _FINDER_COLUMN_ANALYTICSEVENTID_ANALYTICSEVENTID_2 =
		"analyticsReferrer.analyticsEventId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_R = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsReferrerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_R",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsReferrerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_R",
			new String[] { String.class.getName(), Long.class.getName() },
			AnalyticsReferrerModelImpl.REFERRERCLASSNAME_COLUMN_BITMASK |
			AnalyticsReferrerModelImpl.REFERRERCLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_R = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_R",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @return the matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByR_R(String referrerClassName,
		long referrerClassPK) {
		return findByR_R(referrerClassName, referrerClassPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @return the range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByR_R(String referrerClassName,
		long referrerClassPK, int start, int end) {
		return findByR_R(referrerClassName, referrerClassPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByR_R(String referrerClassName,
		long referrerClassPK, int start, int end,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		return findByR_R(referrerClassName, referrerClassPK, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByR_R(String referrerClassName,
		long referrerClassPK, int start, int end,
		OrderByComparator<AnalyticsReferrer> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R;
			finderArgs = new Object[] { referrerClassName, referrerClassPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_R;
			finderArgs = new Object[] {
					referrerClassName, referrerClassPK,
					
					start, end, orderByComparator
				};
		}

		List<AnalyticsReferrer> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsReferrer>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsReferrer analyticsReferrer : list) {
					if (!Validator.equals(referrerClassName,
								analyticsReferrer.getReferrerClassName()) ||
							(referrerClassPK != analyticsReferrer.getReferrerClassPK())) {
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

			query.append(_SQL_SELECT_ANALYTICSREFERRER_WHERE);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_R_R_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_R_R_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_R_REFERRERCLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsReferrerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				if (!pagination) {
					list = (List<AnalyticsReferrer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsReferrer>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer findByR_R_First(String referrerClassName,
		long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException {
		AnalyticsReferrer analyticsReferrer = fetchByR_R_First(referrerClassName,
				referrerClassPK, orderByComparator);

		if (analyticsReferrer != null) {
			return analyticsReferrer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsReferrerException(msg.toString());
	}

	/**
	 * Returns the first analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer fetchByR_R_First(String referrerClassName,
		long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		List<AnalyticsReferrer> list = findByR_R(referrerClassName,
				referrerClassPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer findByR_R_Last(String referrerClassName,
		long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException {
		AnalyticsReferrer analyticsReferrer = fetchByR_R_Last(referrerClassName,
				referrerClassPK, orderByComparator);

		if (analyticsReferrer != null) {
			return analyticsReferrer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsReferrerException(msg.toString());
	}

	/**
	 * Returns the last analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer fetchByR_R_Last(String referrerClassName,
		long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		int count = countByR_R(referrerClassName, referrerClassPK);

		if (count == 0) {
			return null;
		}

		List<AnalyticsReferrer> list = findByR_R(referrerClassName,
				referrerClassPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics referrers before and after the current analytics referrer in the ordered set where referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param analyticsReferrerId the primary key of the current analytics referrer
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	 */
	@Override
	public AnalyticsReferrer[] findByR_R_PrevAndNext(long analyticsReferrerId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException {
		AnalyticsReferrer analyticsReferrer = findByPrimaryKey(analyticsReferrerId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsReferrer[] array = new AnalyticsReferrerImpl[3];

			array[0] = getByR_R_PrevAndNext(session, analyticsReferrer,
					referrerClassName, referrerClassPK, orderByComparator, true);

			array[1] = analyticsReferrer;

			array[2] = getByR_R_PrevAndNext(session, analyticsReferrer,
					referrerClassName, referrerClassPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalyticsReferrer getByR_R_PrevAndNext(Session session,
		AnalyticsReferrer analyticsReferrer, String referrerClassName,
		long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ANALYTICSREFERRER_WHERE);

		boolean bindReferrerClassName = false;

		if (referrerClassName == null) {
			query.append(_FINDER_COLUMN_R_R_REFERRERCLASSNAME_1);
		}
		else if (referrerClassName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_R_R_REFERRERCLASSNAME_3);
		}
		else {
			bindReferrerClassName = true;

			query.append(_FINDER_COLUMN_R_R_REFERRERCLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_R_R_REFERRERCLASSPK_2);

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
			query.append(AnalyticsReferrerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindReferrerClassName) {
			qPos.add(referrerClassName);
		}

		qPos.add(referrerClassPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsReferrer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsReferrer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	 *
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 */
	@Override
	public void removeByR_R(String referrerClassName, long referrerClassPK) {
		for (AnalyticsReferrer analyticsReferrer : findByR_R(
				referrerClassName, referrerClassPK, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(analyticsReferrer);
		}
	}

	/**
	 * Returns the number of analytics referrers where referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @return the number of matching analytics referrers
	 */
	@Override
	public int countByR_R(String referrerClassName, long referrerClassPK) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_R;

		Object[] finderArgs = new Object[] { referrerClassName, referrerClassPK };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANALYTICSREFERRER_WHERE);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_R_R_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_R_R_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_R_REFERRERCLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

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

	private static final String _FINDER_COLUMN_R_R_REFERRERCLASSNAME_1 = "analyticsReferrer.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_R_R_REFERRERCLASSNAME_2 = "analyticsReferrer.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_R_R_REFERRERCLASSNAME_3 = "(analyticsReferrer.referrerClassName IS NULL OR analyticsReferrer.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_R_R_REFERRERCLASSPK_2 = "analyticsReferrer.referrerClassPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_A_R_R = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsReferrerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByA_R_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_R_R = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsReferrerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByA_R_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			AnalyticsReferrerModelImpl.ANALYTICSEVENTID_COLUMN_BITMASK |
			AnalyticsReferrerModelImpl.REFERRERCLASSNAME_COLUMN_BITMASK |
			AnalyticsReferrerModelImpl.REFERRERCLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_R_R = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_R_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_A_R_R = new FinderPath(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByA_R_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @return the matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByA_R_R(long analyticsEventId,
		String referrerClassName, long referrerClassPK) {
		return findByA_R_R(analyticsEventId, referrerClassName,
			referrerClassPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @return the range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByA_R_R(long analyticsEventId,
		String referrerClassName, long referrerClassPK, int start, int end) {
		return findByA_R_R(analyticsEventId, referrerClassName,
			referrerClassPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByA_R_R(long analyticsEventId,
		String referrerClassName, long referrerClassPK, int start, int end,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		return findByA_R_R(analyticsEventId, referrerClassName,
			referrerClassPK, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByA_R_R(long analyticsEventId,
		String referrerClassName, long referrerClassPK, int start, int end,
		OrderByComparator<AnalyticsReferrer> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_R_R;
			finderArgs = new Object[] {
					analyticsEventId, referrerClassName, referrerClassPK
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_A_R_R;
			finderArgs = new Object[] {
					analyticsEventId, referrerClassName, referrerClassPK,
					
					start, end, orderByComparator
				};
		}

		List<AnalyticsReferrer> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsReferrer>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsReferrer analyticsReferrer : list) {
					if ((analyticsEventId != analyticsReferrer.getAnalyticsEventId()) ||
							!Validator.equals(referrerClassName,
								analyticsReferrer.getReferrerClassName()) ||
							(referrerClassPK != analyticsReferrer.getReferrerClassPK())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ANALYTICSREFERRER_WHERE);

			query.append(_FINDER_COLUMN_A_R_R_ANALYTICSEVENTID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsReferrerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analyticsEventId);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				if (!pagination) {
					list = (List<AnalyticsReferrer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsReferrer>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer findByA_R_R_First(long analyticsEventId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException {
		AnalyticsReferrer analyticsReferrer = fetchByA_R_R_First(analyticsEventId,
				referrerClassName, referrerClassPK, orderByComparator);

		if (analyticsReferrer != null) {
			return analyticsReferrer;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("analyticsEventId=");
		msg.append(analyticsEventId);

		msg.append(", referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsReferrerException(msg.toString());
	}

	/**
	 * Returns the first analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer fetchByA_R_R_First(long analyticsEventId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		List<AnalyticsReferrer> list = findByA_R_R(analyticsEventId,
				referrerClassName, referrerClassPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer findByA_R_R_Last(long analyticsEventId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException {
		AnalyticsReferrer analyticsReferrer = fetchByA_R_R_Last(analyticsEventId,
				referrerClassName, referrerClassPK, orderByComparator);

		if (analyticsReferrer != null) {
			return analyticsReferrer;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("analyticsEventId=");
		msg.append(analyticsEventId);

		msg.append(", referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsReferrerException(msg.toString());
	}

	/**
	 * Returns the last analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics referrer, or <code>null</code> if a matching analytics referrer could not be found
	 */
	@Override
	public AnalyticsReferrer fetchByA_R_R_Last(long analyticsEventId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		int count = countByA_R_R(analyticsEventId, referrerClassName,
				referrerClassPK);

		if (count == 0) {
			return null;
		}

		List<AnalyticsReferrer> list = findByA_R_R(analyticsEventId,
				referrerClassName, referrerClassPK, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics referrers before and after the current analytics referrer in the ordered set where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param analyticsReferrerId the primary key of the current analytics referrer
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	 */
	@Override
	public AnalyticsReferrer[] findByA_R_R_PrevAndNext(
		long analyticsReferrerId, long analyticsEventId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator)
		throws NoSuchAnalyticsReferrerException {
		AnalyticsReferrer analyticsReferrer = findByPrimaryKey(analyticsReferrerId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsReferrer[] array = new AnalyticsReferrerImpl[3];

			array[0] = getByA_R_R_PrevAndNext(session, analyticsReferrer,
					analyticsEventId, referrerClassName, referrerClassPK,
					orderByComparator, true);

			array[1] = analyticsReferrer;

			array[2] = getByA_R_R_PrevAndNext(session, analyticsReferrer,
					analyticsEventId, referrerClassName, referrerClassPK,
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

	protected AnalyticsReferrer getByA_R_R_PrevAndNext(Session session,
		AnalyticsReferrer analyticsReferrer, long analyticsEventId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<AnalyticsReferrer> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_ANALYTICSREFERRER_WHERE);

		query.append(_FINDER_COLUMN_A_R_R_ANALYTICSEVENTID_2);

		boolean bindReferrerClassName = false;

		if (referrerClassName == null) {
			query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_1);
		}
		else if (referrerClassName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_3);
		}
		else {
			bindReferrerClassName = true;

			query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSPK_2);

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
			query.append(AnalyticsReferrerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(analyticsEventId);

		if (bindReferrerClassName) {
			qPos.add(referrerClassName);
		}

		qPos.add(referrerClassPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsReferrer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsReferrer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param analyticsEventIds the analytics event IDs
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @return the matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByA_R_R(long[] analyticsEventIds,
		String referrerClassName, long referrerClassPK) {
		return findByA_R_R(analyticsEventIds, referrerClassName,
			referrerClassPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param analyticsEventIds the analytics event IDs
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @return the range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByA_R_R(long[] analyticsEventIds,
		String referrerClassName, long referrerClassPK, int start, int end) {
		return findByA_R_R(analyticsEventIds, referrerClassName,
			referrerClassPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param analyticsEventIds the analytics event IDs
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByA_R_R(long[] analyticsEventIds,
		String referrerClassName, long referrerClassPK, int start, int end,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		return findByA_R_R(analyticsEventIds, referrerClassName,
			referrerClassPK, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findByA_R_R(long[] analyticsEventIds,
		String referrerClassName, long referrerClassPK, int start, int end,
		OrderByComparator<AnalyticsReferrer> orderByComparator,
		boolean retrieveFromCache) {
		if (analyticsEventIds == null) {
			analyticsEventIds = new long[0];
		}
		else if (analyticsEventIds.length > 1) {
			analyticsEventIds = ArrayUtil.unique(analyticsEventIds);

			Arrays.sort(analyticsEventIds);
		}

		if (analyticsEventIds.length == 1) {
			return findByA_R_R(analyticsEventIds[0], referrerClassName,
				referrerClassPK, start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					StringUtil.merge(analyticsEventIds), referrerClassName,
					referrerClassPK
				};
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(analyticsEventIds), referrerClassName,
					referrerClassPK,
					
					start, end, orderByComparator
				};
		}

		List<AnalyticsReferrer> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsReferrer>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_A_R_R,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsReferrer analyticsReferrer : list) {
					if (!ArrayUtil.contains(analyticsEventIds,
								analyticsReferrer.getAnalyticsEventId()) ||
							!Validator.equals(referrerClassName,
								analyticsReferrer.getReferrerClassName()) ||
							(referrerClassPK != analyticsReferrer.getReferrerClassPK())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_ANALYTICSREFERRER_WHERE);

			if (analyticsEventIds.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				query.append(_FINDER_COLUMN_A_R_R_ANALYTICSEVENTID_7);

				query.append(StringUtil.merge(analyticsEventIds));

				query.append(StringPool.CLOSE_PARENTHESIS);

				query.append(StringPool.CLOSE_PARENTHESIS);

				query.append(WHERE_AND);
			}

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSPK_2);

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsReferrerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				if (!pagination) {
					list = (List<AnalyticsReferrer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsReferrer>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_A_R_R,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_A_R_R,
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
	 * Removes all the analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 */
	@Override
	public void removeByA_R_R(long analyticsEventId, String referrerClassName,
		long referrerClassPK) {
		for (AnalyticsReferrer analyticsReferrer : findByA_R_R(
				analyticsEventId, referrerClassName, referrerClassPK,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analyticsReferrer);
		}
	}

	/**
	 * Returns the number of analytics referrers where analyticsEventId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param analyticsEventId the analytics event ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @return the number of matching analytics referrers
	 */
	@Override
	public int countByA_R_R(long analyticsEventId, String referrerClassName,
		long referrerClassPK) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_R_R;

		Object[] finderArgs = new Object[] {
				analyticsEventId, referrerClassName, referrerClassPK
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ANALYTICSREFERRER_WHERE);

			query.append(_FINDER_COLUMN_A_R_R_ANALYTICSEVENTID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analyticsEventId);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

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
	 * Returns the number of analytics referrers where analyticsEventId = any &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param analyticsEventIds the analytics event IDs
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @return the number of matching analytics referrers
	 */
	@Override
	public int countByA_R_R(long[] analyticsEventIds, String referrerClassName,
		long referrerClassPK) {
		if (analyticsEventIds == null) {
			analyticsEventIds = new long[0];
		}
		else if (analyticsEventIds.length > 1) {
			analyticsEventIds = ArrayUtil.unique(analyticsEventIds);

			Arrays.sort(analyticsEventIds);
		}

		Object[] finderArgs = new Object[] {
				StringUtil.merge(analyticsEventIds), referrerClassName,
				referrerClassPK
			};

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_A_R_R,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_ANALYTICSREFERRER_WHERE);

			if (analyticsEventIds.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				query.append(_FINDER_COLUMN_A_R_R_ANALYTICSEVENTID_7);

				query.append(StringUtil.merge(analyticsEventIds));

				query.append(StringPool.CLOSE_PARENTHESIS);

				query.append(StringPool.CLOSE_PARENTHESIS);

				query.append(WHERE_AND);
			}

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_A_R_R_REFERRERCLASSPK_2);

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_A_R_R,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_A_R_R,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_A_R_R_ANALYTICSEVENTID_2 = "analyticsReferrer.analyticsEventId = ? AND ";
	private static final String _FINDER_COLUMN_A_R_R_ANALYTICSEVENTID_7 = "analyticsReferrer.analyticsEventId IN (";
	private static final String _FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_1 = "analyticsReferrer.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_2 = "analyticsReferrer.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_A_R_R_REFERRERCLASSNAME_3 = "(analyticsReferrer.referrerClassName IS NULL OR analyticsReferrer.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_A_R_R_REFERRERCLASSPK_2 = "analyticsReferrer.referrerClassPK = ?";

	public AnalyticsReferrerPersistenceImpl() {
		setModelClass(AnalyticsReferrer.class);
	}

	/**
	 * Caches the analytics referrer in the entity cache if it is enabled.
	 *
	 * @param analyticsReferrer the analytics referrer
	 */
	@Override
	public void cacheResult(AnalyticsReferrer analyticsReferrer) {
		entityCache.putResult(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerImpl.class, analyticsReferrer.getPrimaryKey(),
			analyticsReferrer);

		analyticsReferrer.resetOriginalValues();
	}

	/**
	 * Caches the analytics referrers in the entity cache if it is enabled.
	 *
	 * @param analyticsReferrers the analytics referrers
	 */
	@Override
	public void cacheResult(List<AnalyticsReferrer> analyticsReferrers) {
		for (AnalyticsReferrer analyticsReferrer : analyticsReferrers) {
			if (entityCache.getResult(
						AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
						AnalyticsReferrerImpl.class,
						analyticsReferrer.getPrimaryKey()) == null) {
				cacheResult(analyticsReferrer);
			}
			else {
				analyticsReferrer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all analytics referrers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnalyticsReferrerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the analytics referrer.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnalyticsReferrer analyticsReferrer) {
		entityCache.removeResult(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerImpl.class, analyticsReferrer.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnalyticsReferrer> analyticsReferrers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnalyticsReferrer analyticsReferrer : analyticsReferrers) {
			entityCache.removeResult(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
				AnalyticsReferrerImpl.class, analyticsReferrer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new analytics referrer with the primary key. Does not add the analytics referrer to the database.
	 *
	 * @param analyticsReferrerId the primary key for the new analytics referrer
	 * @return the new analytics referrer
	 */
	@Override
	public AnalyticsReferrer create(long analyticsReferrerId) {
		AnalyticsReferrer analyticsReferrer = new AnalyticsReferrerImpl();

		analyticsReferrer.setNew(true);
		analyticsReferrer.setPrimaryKey(analyticsReferrerId);

		return analyticsReferrer;
	}

	/**
	 * Removes the analytics referrer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param analyticsReferrerId the primary key of the analytics referrer
	 * @return the analytics referrer that was removed
	 * @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	 */
	@Override
	public AnalyticsReferrer remove(long analyticsReferrerId)
		throws NoSuchAnalyticsReferrerException {
		return remove((Serializable)analyticsReferrerId);
	}

	/**
	 * Removes the analytics referrer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the analytics referrer
	 * @return the analytics referrer that was removed
	 * @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	 */
	@Override
	public AnalyticsReferrer remove(Serializable primaryKey)
		throws NoSuchAnalyticsReferrerException {
		Session session = null;

		try {
			session = openSession();

			AnalyticsReferrer analyticsReferrer = (AnalyticsReferrer)session.get(AnalyticsReferrerImpl.class,
					primaryKey);

			if (analyticsReferrer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnalyticsReferrerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(analyticsReferrer);
		}
		catch (NoSuchAnalyticsReferrerException nsee) {
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
	protected AnalyticsReferrer removeImpl(AnalyticsReferrer analyticsReferrer) {
		analyticsReferrer = toUnwrappedModel(analyticsReferrer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(analyticsReferrer)) {
				analyticsReferrer = (AnalyticsReferrer)session.get(AnalyticsReferrerImpl.class,
						analyticsReferrer.getPrimaryKeyObj());
			}

			if (analyticsReferrer != null) {
				session.delete(analyticsReferrer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (analyticsReferrer != null) {
			clearCache(analyticsReferrer);
		}

		return analyticsReferrer;
	}

	@Override
	public AnalyticsReferrer updateImpl(AnalyticsReferrer analyticsReferrer) {
		analyticsReferrer = toUnwrappedModel(analyticsReferrer);

		boolean isNew = analyticsReferrer.isNew();

		AnalyticsReferrerModelImpl analyticsReferrerModelImpl = (AnalyticsReferrerModelImpl)analyticsReferrer;

		Session session = null;

		try {
			session = openSession();

			if (analyticsReferrer.isNew()) {
				session.save(analyticsReferrer);

				analyticsReferrer.setNew(false);
			}
			else {
				analyticsReferrer = (AnalyticsReferrer)session.merge(analyticsReferrer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnalyticsReferrerModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((analyticsReferrerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANALYTICSEVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analyticsReferrerModelImpl.getOriginalAnalyticsEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ANALYTICSEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANALYTICSEVENTID,
					args);

				args = new Object[] {
						analyticsReferrerModelImpl.getAnalyticsEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ANALYTICSEVENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANALYTICSEVENTID,
					args);
			}

			if ((analyticsReferrerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analyticsReferrerModelImpl.getOriginalReferrerClassName(),
						analyticsReferrerModelImpl.getOriginalReferrerClassPK()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R,
					args);

				args = new Object[] {
						analyticsReferrerModelImpl.getReferrerClassName(),
						analyticsReferrerModelImpl.getReferrerClassPK()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R,
					args);
			}

			if ((analyticsReferrerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_R_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analyticsReferrerModelImpl.getOriginalAnalyticsEventId(),
						analyticsReferrerModelImpl.getOriginalReferrerClassName(),
						analyticsReferrerModelImpl.getOriginalReferrerClassPK()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_A_R_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_R_R,
					args);

				args = new Object[] {
						analyticsReferrerModelImpl.getAnalyticsEventId(),
						analyticsReferrerModelImpl.getReferrerClassName(),
						analyticsReferrerModelImpl.getReferrerClassPK()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_A_R_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_R_R,
					args);
			}
		}

		entityCache.putResult(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsReferrerImpl.class, analyticsReferrer.getPrimaryKey(),
			analyticsReferrer, false);

		analyticsReferrer.resetOriginalValues();

		return analyticsReferrer;
	}

	protected AnalyticsReferrer toUnwrappedModel(
		AnalyticsReferrer analyticsReferrer) {
		if (analyticsReferrer instanceof AnalyticsReferrerImpl) {
			return analyticsReferrer;
		}

		AnalyticsReferrerImpl analyticsReferrerImpl = new AnalyticsReferrerImpl();

		analyticsReferrerImpl.setNew(analyticsReferrer.isNew());
		analyticsReferrerImpl.setPrimaryKey(analyticsReferrer.getPrimaryKey());

		analyticsReferrerImpl.setAnalyticsReferrerId(analyticsReferrer.getAnalyticsReferrerId());
		analyticsReferrerImpl.setAnalyticsEventId(analyticsReferrer.getAnalyticsEventId());
		analyticsReferrerImpl.setReferrerClassName(analyticsReferrer.getReferrerClassName());
		analyticsReferrerImpl.setReferrerClassPK(analyticsReferrer.getReferrerClassPK());

		return analyticsReferrerImpl;
	}

	/**
	 * Returns the analytics referrer with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the analytics referrer
	 * @return the analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	 */
	@Override
	public AnalyticsReferrer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnalyticsReferrerException {
		AnalyticsReferrer analyticsReferrer = fetchByPrimaryKey(primaryKey);

		if (analyticsReferrer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnalyticsReferrerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return analyticsReferrer;
	}

	/**
	 * Returns the analytics referrer with the primary key or throws a {@link NoSuchAnalyticsReferrerException} if it could not be found.
	 *
	 * @param analyticsReferrerId the primary key of the analytics referrer
	 * @return the analytics referrer
	 * @throws NoSuchAnalyticsReferrerException if a analytics referrer with the primary key could not be found
	 */
	@Override
	public AnalyticsReferrer findByPrimaryKey(long analyticsReferrerId)
		throws NoSuchAnalyticsReferrerException {
		return findByPrimaryKey((Serializable)analyticsReferrerId);
	}

	/**
	 * Returns the analytics referrer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the analytics referrer
	 * @return the analytics referrer, or <code>null</code> if a analytics referrer with the primary key could not be found
	 */
	@Override
	public AnalyticsReferrer fetchByPrimaryKey(Serializable primaryKey) {
		AnalyticsReferrer analyticsReferrer = (AnalyticsReferrer)entityCache.getResult(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
				AnalyticsReferrerImpl.class, primaryKey);

		if (analyticsReferrer == _nullAnalyticsReferrer) {
			return null;
		}

		if (analyticsReferrer == null) {
			Session session = null;

			try {
				session = openSession();

				analyticsReferrer = (AnalyticsReferrer)session.get(AnalyticsReferrerImpl.class,
						primaryKey);

				if (analyticsReferrer != null) {
					cacheResult(analyticsReferrer);
				}
				else {
					entityCache.putResult(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
						AnalyticsReferrerImpl.class, primaryKey,
						_nullAnalyticsReferrer);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
					AnalyticsReferrerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return analyticsReferrer;
	}

	/**
	 * Returns the analytics referrer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param analyticsReferrerId the primary key of the analytics referrer
	 * @return the analytics referrer, or <code>null</code> if a analytics referrer with the primary key could not be found
	 */
	@Override
	public AnalyticsReferrer fetchByPrimaryKey(long analyticsReferrerId) {
		return fetchByPrimaryKey((Serializable)analyticsReferrerId);
	}

	@Override
	public Map<Serializable, AnalyticsReferrer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AnalyticsReferrer> map = new HashMap<Serializable, AnalyticsReferrer>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AnalyticsReferrer analyticsReferrer = fetchByPrimaryKey(primaryKey);

			if (analyticsReferrer != null) {
				map.put(primaryKey, analyticsReferrer);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			AnalyticsReferrer analyticsReferrer = (AnalyticsReferrer)entityCache.getResult(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
					AnalyticsReferrerImpl.class, primaryKey);

			if (analyticsReferrer == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, analyticsReferrer);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ANALYTICSREFERRER_WHERE_PKS_IN);

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

			for (AnalyticsReferrer analyticsReferrer : (List<AnalyticsReferrer>)q.list()) {
				map.put(analyticsReferrer.getPrimaryKeyObj(), analyticsReferrer);

				cacheResult(analyticsReferrer);

				uncachedPrimaryKeys.remove(analyticsReferrer.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AnalyticsReferrerModelImpl.ENTITY_CACHE_ENABLED,
					AnalyticsReferrerImpl.class, primaryKey,
					_nullAnalyticsReferrer);
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
	 * Returns all the analytics referrers.
	 *
	 * @return the analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics referrers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @return the range of analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics referrers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findAll(int start, int end,
		OrderByComparator<AnalyticsReferrer> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics referrers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics referrers
	 * @param end the upper bound of the range of analytics referrers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of analytics referrers
	 */
	@Override
	public List<AnalyticsReferrer> findAll(int start, int end,
		OrderByComparator<AnalyticsReferrer> orderByComparator,
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

		List<AnalyticsReferrer> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsReferrer>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ANALYTICSREFERRER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANALYTICSREFERRER;

				if (pagination) {
					sql = sql.concat(AnalyticsReferrerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AnalyticsReferrer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsReferrer>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the analytics referrers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnalyticsReferrer analyticsReferrer : findAll()) {
			remove(analyticsReferrer);
		}
	}

	/**
	 * Returns the number of analytics referrers.
	 *
	 * @return the number of analytics referrers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANALYTICSREFERRER);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return AnalyticsReferrerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the analytics referrer persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AnalyticsReferrerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ANALYTICSREFERRER = "SELECT analyticsReferrer FROM AnalyticsReferrer analyticsReferrer";
	private static final String _SQL_SELECT_ANALYTICSREFERRER_WHERE_PKS_IN = "SELECT analyticsReferrer FROM AnalyticsReferrer analyticsReferrer WHERE analyticsReferrerId IN (";
	private static final String _SQL_SELECT_ANALYTICSREFERRER_WHERE = "SELECT analyticsReferrer FROM AnalyticsReferrer analyticsReferrer WHERE ";
	private static final String _SQL_COUNT_ANALYTICSREFERRER = "SELECT COUNT(analyticsReferrer) FROM AnalyticsReferrer analyticsReferrer";
	private static final String _SQL_COUNT_ANALYTICSREFERRER_WHERE = "SELECT COUNT(analyticsReferrer) FROM AnalyticsReferrer analyticsReferrer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "analyticsReferrer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnalyticsReferrer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AnalyticsReferrer exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AnalyticsReferrerPersistenceImpl.class);
	private static final AnalyticsReferrer _nullAnalyticsReferrer = new AnalyticsReferrerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AnalyticsReferrer> toCacheModel() {
				return _nullAnalyticsReferrerCacheModel;
			}
		};

	private static final CacheModel<AnalyticsReferrer> _nullAnalyticsReferrerCacheModel =
		new CacheModel<AnalyticsReferrer>() {
			@Override
			public AnalyticsReferrer toEntityModel() {
				return _nullAnalyticsReferrer;
			}
		};
}