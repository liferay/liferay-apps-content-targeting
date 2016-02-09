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

import com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException;
import com.liferay.content.targeting.analytics.model.AnalyticsEvent;
import com.liferay.content.targeting.analytics.model.impl.AnalyticsEventImpl;
import com.liferay.content.targeting.analytics.model.impl.AnalyticsEventModelImpl;
import com.liferay.content.targeting.analytics.service.persistence.AnalyticsEventPersistence;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the analytics event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventPersistence
 * @see com.liferay.content.targeting.analytics.service.persistence.AnalyticsEventUtil
 * @generated
 */
@ProviderType
public class AnalyticsEventPersistenceImpl extends BasePersistenceImpl<AnalyticsEvent>
	implements AnalyticsEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnalyticsEventUtil} to access the analytics event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnalyticsEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			AnalyticsEventModelImpl.COMPANYID_COLUMN_BITMASK |
			AnalyticsEventModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the analytics events where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByCompanyId(long companyId) {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the analytics events where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByCompanyId(long companyId, int start,
		int end) {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return findByCompanyId(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics events where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
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

		List<AnalyticsEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsEvent analyticsEvent : list) {
					if ((companyId != analyticsEvent.getCompanyId())) {
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

			query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByCompanyId_First(long companyId,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByCompanyId_First(long companyId,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		List<AnalyticsEvent> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByCompanyId_Last(long companyId,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByCompanyId_Last(long companyId,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<AnalyticsEvent> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics events before and after the current analytics event in the ordered set where companyId = &#63;.
	 *
	 * @param analyticsEventId the primary key of the current analytics event
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics event
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent[] findByCompanyId_PrevAndNext(long analyticsEventId,
		long companyId, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = findByPrimaryKey(analyticsEventId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent[] array = new AnalyticsEventImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, analyticsEvent,
					companyId, orderByComparator, true);

			array[1] = analyticsEvent;

			array[2] = getByCompanyId_PrevAndNext(session, analyticsEvent,
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

	protected AnalyticsEvent getByCompanyId_PrevAndNext(Session session,
		AnalyticsEvent analyticsEvent, long companyId,
		OrderByComparator<AnalyticsEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

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
			query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics events where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (AnalyticsEvent analyticsEvent : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching analytics events
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANALYTICSEVENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "analyticsEvent.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_GtD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_GTD = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_GtD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @return the matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_GtD(long companyId, Date createDate) {
		return findByC_GtD(companyId, createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_GtD(long companyId, Date createDate,
		int start, int end) {
		return findByC_GtD(companyId, createDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_GtD(long companyId, Date createDate,
		int start, int end, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return findByC_GtD(companyId, createDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_GtD(long companyId, Date createDate,
		int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD;
		finderArgs = new Object[] {
				companyId, createDate,
				
				start, end, orderByComparator
			};

		List<AnalyticsEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsEvent analyticsEvent : list) {
					if ((companyId != analyticsEvent.getCompanyId()) ||
							(createDate.getTime() >= analyticsEvent.getCreateDate()
																	   .getTime())) {
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

			query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

			query.append(_FINDER_COLUMN_C_GTD_COMPANYID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_GTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_GTD_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByC_GtD_First(long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByC_GtD_First(companyId,
				createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByC_GtD_First(long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		List<AnalyticsEvent> list = findByC_GtD(companyId, createDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByC_GtD_Last(long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByC_GtD_Last(companyId,
				createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByC_GtD_Last(long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		int count = countByC_GtD(companyId, createDate);

		if (count == 0) {
			return null;
		}

		List<AnalyticsEvent> list = findByC_GtD(companyId, createDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics events before and after the current analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * @param analyticsEventId the primary key of the current analytics event
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics event
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent[] findByC_GtD_PrevAndNext(long analyticsEventId,
		long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = findByPrimaryKey(analyticsEventId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent[] array = new AnalyticsEventImpl[3];

			array[0] = getByC_GtD_PrevAndNext(session, analyticsEvent,
					companyId, createDate, orderByComparator, true);

			array[1] = analyticsEvent;

			array[2] = getByC_GtD_PrevAndNext(session, analyticsEvent,
					companyId, createDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalyticsEvent getByC_GtD_PrevAndNext(Session session,
		AnalyticsEvent analyticsEvent, long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

		query.append(_FINDER_COLUMN_C_GTD_COMPANYID_2);

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_C_GTD_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_C_GTD_CREATEDATE_2);
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
			query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics events where companyId = &#63; and createDate &gt; &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 */
	@Override
	public void removeByC_GtD(long companyId, Date createDate) {
		for (AnalyticsEvent analyticsEvent : findByC_GtD(companyId, createDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @return the number of matching analytics events
	 */
	@Override
	public int countByC_GtD(long companyId, Date createDate) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_GTD;

		Object[] finderArgs = new Object[] { companyId, createDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANALYTICSEVENT_WHERE);

			query.append(_FINDER_COLUMN_C_GTD_COMPANYID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_GTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_GTD_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_C_GTD_COMPANYID_2 = "analyticsEvent.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_GTD_CREATEDATE_1 = "analyticsEvent.createDate IS NULL";
	private static final String _FINDER_COLUMN_C_GTD_CREATEDATE_2 = "analyticsEvent.createDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_LTD = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_LtD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_LTD = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_LtD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @return the matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_LtD(long companyId, Date createDate) {
		return findByC_LtD(companyId, createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_LtD(long companyId, Date createDate,
		int start, int end) {
		return findByC_LtD(companyId, createDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_LtD(long companyId, Date createDate,
		int start, int end, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return findByC_LtD(companyId, createDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_LtD(long companyId, Date createDate,
		int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_LTD;
		finderArgs = new Object[] {
				companyId, createDate,
				
				start, end, orderByComparator
			};

		List<AnalyticsEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsEvent analyticsEvent : list) {
					if ((companyId != analyticsEvent.getCompanyId()) ||
							(createDate.getTime() <= analyticsEvent.getCreateDate()
																	   .getTime())) {
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

			query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

			query.append(_FINDER_COLUMN_C_LTD_COMPANYID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_LTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_LTD_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByC_LtD_First(long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByC_LtD_First(companyId,
				createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByC_LtD_First(long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		List<AnalyticsEvent> list = findByC_LtD(companyId, createDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByC_LtD_Last(long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByC_LtD_Last(companyId,
				createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByC_LtD_Last(long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		int count = countByC_LtD(companyId, createDate);

		if (count == 0) {
			return null;
		}

		List<AnalyticsEvent> list = findByC_LtD(companyId, createDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics events before and after the current analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param analyticsEventId the primary key of the current analytics event
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics event
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent[] findByC_LtD_PrevAndNext(long analyticsEventId,
		long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = findByPrimaryKey(analyticsEventId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent[] array = new AnalyticsEventImpl[3];

			array[0] = getByC_LtD_PrevAndNext(session, analyticsEvent,
					companyId, createDate, orderByComparator, true);

			array[1] = analyticsEvent;

			array[2] = getByC_LtD_PrevAndNext(session, analyticsEvent,
					companyId, createDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalyticsEvent getByC_LtD_PrevAndNext(Session session,
		AnalyticsEvent analyticsEvent, long companyId, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

		query.append(_FINDER_COLUMN_C_LTD_COMPANYID_2);

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_C_LTD_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_C_LTD_CREATEDATE_2);
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
			query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics events where companyId = &#63; and createDate &lt; &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 */
	@Override
	public void removeByC_LtD(long companyId, Date createDate) {
		for (AnalyticsEvent analyticsEvent : findByC_LtD(companyId, createDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @return the number of matching analytics events
	 */
	@Override
	public int countByC_LtD(long companyId, Date createDate) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_LTD;

		Object[] finderArgs = new Object[] { companyId, createDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANALYTICSEVENT_WHERE);

			query.append(_FINDER_COLUMN_C_LTD_COMPANYID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_LTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_LTD_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_C_LTD_COMPANYID_2 = "analyticsEvent.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_LTD_CREATEDATE_1 = "analyticsEvent.createDate IS NULL";
	private static final String _FINDER_COLUMN_C_LTD_CREATEDATE_2 = "analyticsEvent.createDate < ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTC_GTD = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNotC_GtD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTC_GTD =
		new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNotC_GtD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	 *
	 * @param classPK the class p k
	 * @param createDate the create date
	 * @return the matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByNotC_GtD(long classPK, Date createDate) {
		return findByNotC_GtD(classPK, createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classPK the class p k
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByNotC_GtD(long classPK, Date createDate,
		int start, int end) {
		return findByNotC_GtD(classPK, createDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classPK the class p k
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByNotC_GtD(long classPK, Date createDate,
		int start, int end, OrderByComparator<AnalyticsEvent> orderByComparator) {
		return findByNotC_GtD(classPK, createDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classPK the class p k
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByNotC_GtD(long classPK, Date createDate,
		int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTC_GTD;
		finderArgs = new Object[] {
				classPK, createDate,
				
				start, end, orderByComparator
			};

		List<AnalyticsEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsEvent analyticsEvent : list) {
					if ((classPK == analyticsEvent.getClassPK()) ||
							(createDate.getTime() >= analyticsEvent.getCreateDate()
																	   .getTime())) {
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

			query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

			query.append(_FINDER_COLUMN_NOTC_GTD_CLASSPK_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_NOTC_GTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_NOTC_GTD_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classPK);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	 *
	 * @param classPK the class p k
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByNotC_GtD_First(long classPK, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByNotC_GtD_First(classPK,
				createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classPK=");
		msg.append(classPK);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	 *
	 * @param classPK the class p k
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByNotC_GtD_First(long classPK, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		List<AnalyticsEvent> list = findByNotC_GtD(classPK, createDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	 *
	 * @param classPK the class p k
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByNotC_GtD_Last(long classPK, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByNotC_GtD_Last(classPK,
				createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classPK=");
		msg.append(classPK);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	 *
	 * @param classPK the class p k
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByNotC_GtD_Last(long classPK, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		int count = countByNotC_GtD(classPK, createDate);

		if (count == 0) {
			return null;
		}

		List<AnalyticsEvent> list = findByNotC_GtD(classPK, createDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics events before and after the current analytics event in the ordered set where classPK &ne; &#63; and createDate &gt; &#63;.
	 *
	 * @param analyticsEventId the primary key of the current analytics event
	 * @param classPK the class p k
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics event
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent[] findByNotC_GtD_PrevAndNext(long analyticsEventId,
		long classPK, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = findByPrimaryKey(analyticsEventId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent[] array = new AnalyticsEventImpl[3];

			array[0] = getByNotC_GtD_PrevAndNext(session, analyticsEvent,
					classPK, createDate, orderByComparator, true);

			array[1] = analyticsEvent;

			array[2] = getByNotC_GtD_PrevAndNext(session, analyticsEvent,
					classPK, createDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalyticsEvent getByNotC_GtD_PrevAndNext(Session session,
		AnalyticsEvent analyticsEvent, long classPK, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

		query.append(_FINDER_COLUMN_NOTC_GTD_CLASSPK_2);

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_NOTC_GTD_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_NOTC_GTD_CREATEDATE_2);
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
			query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(classPK);

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics events where classPK &ne; &#63; and createDate &gt; &#63; from the database.
	 *
	 * @param classPK the class p k
	 * @param createDate the create date
	 */
	@Override
	public void removeByNotC_GtD(long classPK, Date createDate) {
		for (AnalyticsEvent analyticsEvent : findByNotC_GtD(classPK,
				createDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events where classPK &ne; &#63; and createDate &gt; &#63;.
	 *
	 * @param classPK the class p k
	 * @param createDate the create date
	 * @return the number of matching analytics events
	 */
	@Override
	public int countByNotC_GtD(long classPK, Date createDate) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTC_GTD;

		Object[] finderArgs = new Object[] { classPK, createDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANALYTICSEVENT_WHERE);

			query.append(_FINDER_COLUMN_NOTC_GTD_CLASSPK_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_NOTC_GTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_NOTC_GTD_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classPK);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_NOTC_GTD_CLASSPK_2 = "analyticsEvent.classPK != ? AND ";
	private static final String _FINDER_COLUMN_NOTC_GTD_CREATEDATE_1 = "analyticsEvent.createDate IS NULL";
	private static final String _FINDER_COLUMN_NOTC_GTD_CREATEDATE_2 = "analyticsEvent.createDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_E = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C_E",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_E = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_E",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			AnalyticsEventModelImpl.CLASSNAME_COLUMN_BITMASK |
			AnalyticsEventModelImpl.CLASSPK_COLUMN_BITMASK |
			AnalyticsEventModelImpl.EVENTTYPE_COLUMN_BITMASK |
			AnalyticsEventModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_E = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_E",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E(String className, long classPK,
		String eventType) {
		return findByC_C_E(className, classPK, eventType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E(String className, long classPK,
		String eventType, int start, int end) {
		return findByC_C_E(className, classPK, eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E(String className, long classPK,
		String eventType, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return findByC_C_E(className, classPK, eventType, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E(String className, long classPK,
		String eventType, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_E;
			finderArgs = new Object[] { className, classPK, eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_E;
			finderArgs = new Object[] {
					className, classPK, eventType,
					
					start, end, orderByComparator
				};
		}

		List<AnalyticsEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsEvent analyticsEvent : list) {
					if (!Validator.equals(className,
								analyticsEvent.getClassName()) ||
							(classPK != analyticsEvent.getClassPK()) ||
							!Validator.equals(eventType,
								analyticsEvent.getEventType())) {
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

			query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_E_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_E_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_E_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_E_CLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_C_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_C_E_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByC_C_E_First(String className, long classPK,
		String eventType, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByC_C_E_First(className, classPK,
				eventType, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByC_C_E_First(String className, long classPK,
		String eventType, OrderByComparator<AnalyticsEvent> orderByComparator) {
		List<AnalyticsEvent> list = findByC_C_E(className, classPK, eventType,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByC_C_E_Last(String className, long classPK,
		String eventType, OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByC_C_E_Last(className, classPK,
				eventType, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByC_C_E_Last(String className, long classPK,
		String eventType, OrderByComparator<AnalyticsEvent> orderByComparator) {
		int count = countByC_C_E(className, classPK, eventType);

		if (count == 0) {
			return null;
		}

		List<AnalyticsEvent> list = findByC_C_E(className, classPK, eventType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics events before and after the current analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param analyticsEventId the primary key of the current analytics event
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics event
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent[] findByC_C_E_PrevAndNext(long analyticsEventId,
		String className, long classPK, String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = findByPrimaryKey(analyticsEventId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent[] array = new AnalyticsEventImpl[3];

			array[0] = getByC_C_E_PrevAndNext(session, analyticsEvent,
					className, classPK, eventType, orderByComparator, true);

			array[1] = analyticsEvent;

			array[2] = getByC_C_E_PrevAndNext(session, analyticsEvent,
					className, classPK, eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalyticsEvent getByC_C_E_PrevAndNext(Session session,
		AnalyticsEvent analyticsEvent, String className, long classPK,
		String eventType, OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_C_C_E_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_E_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_C_C_E_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_C_C_E_CLASSPK_2);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_C_C_E_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_E_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_C_C_E_EVENTTYPE_2);
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
			query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 */
	@Override
	public void removeByC_C_E(String className, long classPK, String eventType) {
		for (AnalyticsEvent analyticsEvent : findByC_C_E(className, classPK,
				eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events where className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the number of matching analytics events
	 */
	@Override
	public int countByC_C_E(String className, long classPK, String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_E;

		Object[] finderArgs = new Object[] { className, classPK, eventType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ANALYTICSEVENT_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_E_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_E_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_E_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_E_CLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_C_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_C_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (bindEventType) {
					qPos.add(eventType);
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

	private static final String _FINDER_COLUMN_C_C_E_CLASSNAME_1 = "analyticsEvent.className IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_E_CLASSNAME_2 = "analyticsEvent.className = ? AND ";
	private static final String _FINDER_COLUMN_C_C_E_CLASSNAME_3 = "(analyticsEvent.className IS NULL OR analyticsEvent.className = '') AND ";
	private static final String _FINDER_COLUMN_C_C_E_CLASSPK_2 = "analyticsEvent.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_E_EVENTTYPE_1 = "analyticsEvent.eventType IS NULL";
	private static final String _FINDER_COLUMN_C_C_E_EVENTTYPE_2 = "analyticsEvent.eventType = ?";
	private static final String _FINDER_COLUMN_C_C_E_EVENTTYPE_3 = "(analyticsEvent.eventType IS NULL OR analyticsEvent.eventType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_E_E_GTD = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByE_E_GtD",
			new String[] {
				String.class.getName(), String.class.getName(),
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_E_E_GTD = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByE_E_GtD",
			new String[] {
				String.class.getName(), String.class.getName(),
				Date.class.getName()
			});

	/**
	 * Returns all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 * @return the matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByE_E_GtD(String elementId,
		String eventType, Date createDate) {
		return findByE_E_GtD(elementId, eventType, createDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByE_E_GtD(String elementId,
		String eventType, Date createDate, int start, int end) {
		return findByE_E_GtD(elementId, eventType, createDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByE_E_GtD(String elementId,
		String eventType, Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return findByE_E_GtD(elementId, eventType, createDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByE_E_GtD(String elementId,
		String eventType, Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_E_E_GTD;
		finderArgs = new Object[] {
				elementId, eventType, createDate,
				
				start, end, orderByComparator
			};

		List<AnalyticsEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsEvent analyticsEvent : list) {
					if (!Validator.equals(elementId,
								analyticsEvent.getElementId()) ||
							!Validator.equals(eventType,
								analyticsEvent.getEventType()) ||
							(createDate.getTime() >= analyticsEvent.getCreateDate()
																	   .getTime())) {
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

			query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_E_E_GTD_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_E_E_GTD_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_E_E_GTD_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_E_E_GTD_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_E_E_GTD_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_E_E_GTD_EVENTTYPE_2);
			}

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_E_E_GTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_E_E_GTD_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByE_E_GtD_First(String elementId,
		String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByE_E_GtD_First(elementId,
				eventType, createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("elementId=");
		msg.append(elementId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByE_E_GtD_First(String elementId,
		String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		List<AnalyticsEvent> list = findByE_E_GtD(elementId, eventType,
				createDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByE_E_GtD_Last(String elementId,
		String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByE_E_GtD_Last(elementId,
				eventType, createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("elementId=");
		msg.append(elementId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByE_E_GtD_Last(String elementId,
		String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		int count = countByE_E_GtD(elementId, eventType, createDate);

		if (count == 0) {
			return null;
		}

		List<AnalyticsEvent> list = findByE_E_GtD(elementId, eventType,
				createDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics events before and after the current analytics event in the ordered set where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param analyticsEventId the primary key of the current analytics event
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics event
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent[] findByE_E_GtD_PrevAndNext(long analyticsEventId,
		String elementId, String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = findByPrimaryKey(analyticsEventId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent[] array = new AnalyticsEventImpl[3];

			array[0] = getByE_E_GtD_PrevAndNext(session, analyticsEvent,
					elementId, eventType, createDate, orderByComparator, true);

			array[1] = analyticsEvent;

			array[2] = getByE_E_GtD_PrevAndNext(session, analyticsEvent,
					elementId, eventType, createDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalyticsEvent getByE_E_GtD_PrevAndNext(Session session,
		AnalyticsEvent analyticsEvent, String elementId, String eventType,
		Date createDate, OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

		boolean bindElementId = false;

		if (elementId == null) {
			query.append(_FINDER_COLUMN_E_E_GTD_ELEMENTID_1);
		}
		else if (elementId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_E_E_GTD_ELEMENTID_3);
		}
		else {
			bindElementId = true;

			query.append(_FINDER_COLUMN_E_E_GTD_ELEMENTID_2);
		}

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_E_E_GTD_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_E_E_GTD_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_E_E_GTD_EVENTTYPE_2);
		}

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_E_E_GTD_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_E_E_GTD_CREATEDATE_2);
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
			query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindElementId) {
			qPos.add(elementId);
		}

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63; from the database.
	 *
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 */
	@Override
	public void removeByE_E_GtD(String elementId, String eventType,
		Date createDate) {
		for (AnalyticsEvent analyticsEvent : findByE_E_GtD(elementId,
				eventType, createDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events where elementId = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param createDate the create date
	 * @return the number of matching analytics events
	 */
	@Override
	public int countByE_E_GtD(String elementId, String eventType,
		Date createDate) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_E_E_GTD;

		Object[] finderArgs = new Object[] { elementId, eventType, createDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ANALYTICSEVENT_WHERE);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_E_E_GTD_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_E_E_GTD_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_E_E_GTD_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_E_E_GTD_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_E_E_GTD_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_E_E_GTD_EVENTTYPE_2);
			}

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_E_E_GTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_E_E_GTD_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_E_E_GTD_ELEMENTID_1 = "analyticsEvent.elementId IS NULL AND ";
	private static final String _FINDER_COLUMN_E_E_GTD_ELEMENTID_2 = "analyticsEvent.elementId = ? AND ";
	private static final String _FINDER_COLUMN_E_E_GTD_ELEMENTID_3 = "(analyticsEvent.elementId IS NULL OR analyticsEvent.elementId = '') AND ";
	private static final String _FINDER_COLUMN_E_E_GTD_EVENTTYPE_1 = "analyticsEvent.eventType IS NULL AND ";
	private static final String _FINDER_COLUMN_E_E_GTD_EVENTTYPE_2 = "analyticsEvent.eventType = ? AND ";
	private static final String _FINDER_COLUMN_E_E_GTD_EVENTTYPE_3 = "(analyticsEvent.eventType IS NULL OR analyticsEvent.eventType = '') AND ";
	private static final String _FINDER_COLUMN_E_E_GTD_CREATEDATE_1 = "analyticsEvent.createDate IS NULL";
	private static final String _FINDER_COLUMN_E_E_GTD_CREATEDATE_2 = "analyticsEvent.createDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_A_C_C_E = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByA_C_C_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_C_C_E =
		new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByA_C_C_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			AnalyticsEventModelImpl.ANONYMOUSUSERID_COLUMN_BITMASK |
			AnalyticsEventModelImpl.CLASSNAME_COLUMN_BITMASK |
			AnalyticsEventModelImpl.CLASSPK_COLUMN_BITMASK |
			AnalyticsEventModelImpl.EVENTTYPE_COLUMN_BITMASK |
			AnalyticsEventModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_C_C_E = new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_C_C_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		String className, long classPK, String eventType) {
		return findByA_C_C_E(anonymousUserId, className, classPK, eventType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		String className, long classPK, String eventType, int start, int end) {
		return findByA_C_C_E(anonymousUserId, className, classPK, eventType,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		String className, long classPK, String eventType, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return findByA_C_C_E(anonymousUserId, className, classPK, eventType,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByA_C_C_E(long anonymousUserId,
		String className, long classPK, String eventType, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_C_C_E;
			finderArgs = new Object[] {
					anonymousUserId, className, classPK, eventType
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_A_C_C_E;
			finderArgs = new Object[] {
					anonymousUserId, className, classPK, eventType,
					
					start, end, orderByComparator
				};
		}

		List<AnalyticsEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsEvent analyticsEvent : list) {
					if ((anonymousUserId != analyticsEvent.getAnonymousUserId()) ||
							!Validator.equals(className,
								analyticsEvent.getClassName()) ||
							(classPK != analyticsEvent.getClassPK()) ||
							!Validator.equals(eventType,
								analyticsEvent.getEventType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

			query.append(_FINDER_COLUMN_A_C_C_E_ANONYMOUSUSERID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_A_C_C_E_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_A_C_C_E_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_A_C_C_E_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_A_C_C_E_CLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_A_C_C_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_A_C_C_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_A_C_C_E_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anonymousUserId);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByA_C_C_E_First(long anonymousUserId,
		String className, long classPK, String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByA_C_C_E_First(anonymousUserId,
				className, classPK, eventType, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anonymousUserId=");
		msg.append(anonymousUserId);

		msg.append(", className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByA_C_C_E_First(long anonymousUserId,
		String className, long classPK, String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		List<AnalyticsEvent> list = findByA_C_C_E(anonymousUserId, className,
				classPK, eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics event in the ordered set where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByA_C_C_E_Last(long anonymousUserId,
		String className, long classPK, String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByA_C_C_E_Last(anonymousUserId,
				className, classPK, eventType, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anonymousUserId=");
		msg.append(anonymousUserId);

		msg.append(", className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByA_C_C_E_Last(long anonymousUserId,
		String className, long classPK, String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		int count = countByA_C_C_E(anonymousUserId, className, classPK,
				eventType);

		if (count == 0) {
			return null;
		}

		List<AnalyticsEvent> list = findByA_C_C_E(anonymousUserId, className,
				classPK, eventType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics events before and after the current analytics event in the ordered set where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param analyticsEventId the primary key of the current analytics event
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics event
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent[] findByA_C_C_E_PrevAndNext(long analyticsEventId,
		long anonymousUserId, String className, long classPK, String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = findByPrimaryKey(analyticsEventId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent[] array = new AnalyticsEventImpl[3];

			array[0] = getByA_C_C_E_PrevAndNext(session, analyticsEvent,
					anonymousUserId, className, classPK, eventType,
					orderByComparator, true);

			array[1] = analyticsEvent;

			array[2] = getByA_C_C_E_PrevAndNext(session, analyticsEvent,
					anonymousUserId, className, classPK, eventType,
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

	protected AnalyticsEvent getByA_C_C_E_PrevAndNext(Session session,
		AnalyticsEvent analyticsEvent, long anonymousUserId, String className,
		long classPK, String eventType,
		OrderByComparator<AnalyticsEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(7 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

		query.append(_FINDER_COLUMN_A_C_C_E_ANONYMOUSUSERID_2);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_A_C_C_E_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_A_C_C_E_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_A_C_C_E_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_A_C_C_E_CLASSPK_2);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_A_C_C_E_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_A_C_C_E_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_A_C_C_E_EVENTTYPE_2);
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
			query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(anonymousUserId);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 */
	@Override
	public void removeByA_C_C_E(long anonymousUserId, String className,
		long classPK, String eventType) {
		for (AnalyticsEvent analyticsEvent : findByA_C_C_E(anonymousUserId,
				className, classPK, eventType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events where anonymousUserId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the number of matching analytics events
	 */
	@Override
	public int countByA_C_C_E(long anonymousUserId, String className,
		long classPK, String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_C_C_E;

		Object[] finderArgs = new Object[] {
				anonymousUserId, className, classPK, eventType
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_ANALYTICSEVENT_WHERE);

			query.append(_FINDER_COLUMN_A_C_C_E_ANONYMOUSUSERID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_A_C_C_E_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_A_C_C_E_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_A_C_C_E_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_A_C_C_E_CLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_A_C_C_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_A_C_C_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_A_C_C_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anonymousUserId);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (bindEventType) {
					qPos.add(eventType);
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

	private static final String _FINDER_COLUMN_A_C_C_E_ANONYMOUSUSERID_2 = "analyticsEvent.anonymousUserId = ? AND ";
	private static final String _FINDER_COLUMN_A_C_C_E_CLASSNAME_1 = "analyticsEvent.className IS NULL AND ";
	private static final String _FINDER_COLUMN_A_C_C_E_CLASSNAME_2 = "analyticsEvent.className = ? AND ";
	private static final String _FINDER_COLUMN_A_C_C_E_CLASSNAME_3 = "(analyticsEvent.className IS NULL OR analyticsEvent.className = '') AND ";
	private static final String _FINDER_COLUMN_A_C_C_E_CLASSPK_2 = "analyticsEvent.classPK = ? AND ";
	private static final String _FINDER_COLUMN_A_C_C_E_EVENTTYPE_1 = "analyticsEvent.eventType IS NULL";
	private static final String _FINDER_COLUMN_A_C_C_E_EVENTTYPE_2 = "analyticsEvent.eventType = ?";
	private static final String _FINDER_COLUMN_A_C_C_E_EVENTTYPE_3 = "(analyticsEvent.eventType IS NULL OR analyticsEvent.eventType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_E_GTD =
		new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C_E_GtD",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_C_E_GTD =
		new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_C_E_GtD",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @return the matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate) {
		return findByC_C_E_GtD(className, classPK, eventType, createDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate, int start, int end) {
		return findByC_C_E_GtD(className, classPK, eventType, createDate,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return findByC_C_E_GtD(className, classPK, eventType, createDate,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching analytics events
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate, int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_E_GTD;
		finderArgs = new Object[] {
				className, classPK, eventType, createDate,
				
				start, end, orderByComparator
			};

		List<AnalyticsEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalyticsEvent analyticsEvent : list) {
					if (!Validator.equals(className,
								analyticsEvent.getClassName()) ||
							(classPK != analyticsEvent.getClassPK()) ||
							!Validator.equals(eventType,
								analyticsEvent.getEventType()) ||
							(createDate.getTime() >= analyticsEvent.getCreateDate()
																	   .getTime())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_2);
			}

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_C_E_GTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_C_E_GTD_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByC_C_E_GtD_First(String className, long classPK,
		String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByC_C_E_GtD_First(className,
				classPK, eventType, createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByC_C_E_GtD_First(String className,
		long classPK, String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		List<AnalyticsEvent> list = findByC_C_E_GtD(className, classPK,
				eventType, createDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event
	 * @throws NoSuchAnalyticsEventException if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent findByC_C_E_GtD_Last(String className, long classPK,
		String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByC_C_E_GtD_Last(className,
				classPK, eventType, createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnalyticsEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 */
	@Override
	public AnalyticsEvent fetchByC_C_E_GtD_Last(String className, long classPK,
		String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		int count = countByC_C_E_GtD(className, classPK, eventType, createDate);

		if (count == 0) {
			return null;
		}

		List<AnalyticsEvent> list = findByC_C_E_GtD(className, classPK,
				eventType, createDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics events before and after the current analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param analyticsEventId the primary key of the current analytics event
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics event
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent[] findByC_C_E_GtD_PrevAndNext(long analyticsEventId,
		String className, long classPK, String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = findByPrimaryKey(analyticsEventId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent[] array = new AnalyticsEventImpl[3];

			array[0] = getByC_C_E_GtD_PrevAndNext(session, analyticsEvent,
					className, classPK, eventType, createDate,
					orderByComparator, true);

			array[1] = analyticsEvent;

			array[2] = getByC_C_E_GtD_PrevAndNext(session, analyticsEvent,
					className, classPK, eventType, createDate,
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

	protected AnalyticsEvent getByC_C_E_GtD_PrevAndNext(Session session,
		AnalyticsEvent analyticsEvent, String className, long classPK,
		String eventType, Date createDate,
		OrderByComparator<AnalyticsEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(7 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSPK_2);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_2);
		}

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_C_C_E_GTD_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_C_C_E_GTD_CREATEDATE_2);
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
			query.append(AnalyticsEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analyticsEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalyticsEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 */
	@Override
	public void removeByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate) {
		for (AnalyticsEvent analyticsEvent : findByC_C_E_GtD(className,
				classPK, eventType, createDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @return the number of matching analytics events
	 */
	@Override
	public int countByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_C_E_GTD;

		Object[] finderArgs = new Object[] {
				className, classPK, eventType, createDate
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_ANALYTICSEVENT_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_E_GTD_CLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_2);
			}

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_C_E_GTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_C_E_GTD_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_C_C_E_GTD_CLASSNAME_1 = "analyticsEvent.className IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_CLASSNAME_2 = "analyticsEvent.className = ? AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_CLASSNAME_3 = "(analyticsEvent.className IS NULL OR analyticsEvent.className = '') AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_CLASSPK_2 = "analyticsEvent.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_1 = "analyticsEvent.eventType IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_2 = "analyticsEvent.eventType = ? AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_3 = "(analyticsEvent.eventType IS NULL OR analyticsEvent.eventType = '') AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_CREATEDATE_1 = "analyticsEvent.createDate IS NULL";
	private static final String _FINDER_COLUMN_C_C_E_GTD_CREATEDATE_2 = "analyticsEvent.createDate > ?";

	public AnalyticsEventPersistenceImpl() {
		setModelClass(AnalyticsEvent.class);
	}

	/**
	 * Caches the analytics event in the entity cache if it is enabled.
	 *
	 * @param analyticsEvent the analytics event
	 */
	@Override
	public void cacheResult(AnalyticsEvent analyticsEvent) {
		entityCache.putResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventImpl.class, analyticsEvent.getPrimaryKey(),
			analyticsEvent);

		analyticsEvent.resetOriginalValues();
	}

	/**
	 * Caches the analytics events in the entity cache if it is enabled.
	 *
	 * @param analyticsEvents the analytics events
	 */
	@Override
	public void cacheResult(List<AnalyticsEvent> analyticsEvents) {
		for (AnalyticsEvent analyticsEvent : analyticsEvents) {
			if (entityCache.getResult(
						AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
						AnalyticsEventImpl.class, analyticsEvent.getPrimaryKey()) == null) {
				cacheResult(analyticsEvent);
			}
			else {
				analyticsEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all analytics events.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnalyticsEventImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the analytics event.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnalyticsEvent analyticsEvent) {
		entityCache.removeResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventImpl.class, analyticsEvent.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnalyticsEvent> analyticsEvents) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnalyticsEvent analyticsEvent : analyticsEvents) {
			entityCache.removeResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
				AnalyticsEventImpl.class, analyticsEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new analytics event with the primary key. Does not add the analytics event to the database.
	 *
	 * @param analyticsEventId the primary key for the new analytics event
	 * @return the new analytics event
	 */
	@Override
	public AnalyticsEvent create(long analyticsEventId) {
		AnalyticsEvent analyticsEvent = new AnalyticsEventImpl();

		analyticsEvent.setNew(true);
		analyticsEvent.setPrimaryKey(analyticsEventId);

		analyticsEvent.setCompanyId(companyProvider.getCompanyId());

		return analyticsEvent;
	}

	/**
	 * Removes the analytics event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param analyticsEventId the primary key of the analytics event
	 * @return the analytics event that was removed
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent remove(long analyticsEventId)
		throws NoSuchAnalyticsEventException {
		return remove((Serializable)analyticsEventId);
	}

	/**
	 * Removes the analytics event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the analytics event
	 * @return the analytics event that was removed
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent remove(Serializable primaryKey)
		throws NoSuchAnalyticsEventException {
		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent analyticsEvent = (AnalyticsEvent)session.get(AnalyticsEventImpl.class,
					primaryKey);

			if (analyticsEvent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnalyticsEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(analyticsEvent);
		}
		catch (NoSuchAnalyticsEventException nsee) {
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
	protected AnalyticsEvent removeImpl(AnalyticsEvent analyticsEvent) {
		analyticsEvent = toUnwrappedModel(analyticsEvent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(analyticsEvent)) {
				analyticsEvent = (AnalyticsEvent)session.get(AnalyticsEventImpl.class,
						analyticsEvent.getPrimaryKeyObj());
			}

			if (analyticsEvent != null) {
				session.delete(analyticsEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (analyticsEvent != null) {
			clearCache(analyticsEvent);
		}

		return analyticsEvent;
	}

	@Override
	public AnalyticsEvent updateImpl(AnalyticsEvent analyticsEvent) {
		analyticsEvent = toUnwrappedModel(analyticsEvent);

		boolean isNew = analyticsEvent.isNew();

		AnalyticsEventModelImpl analyticsEventModelImpl = (AnalyticsEventModelImpl)analyticsEvent;

		Session session = null;

		try {
			session = openSession();

			if (analyticsEvent.isNew()) {
				session.save(analyticsEvent);

				analyticsEvent.setNew(false);
			}
			else {
				analyticsEvent = (AnalyticsEvent)session.merge(analyticsEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnalyticsEventModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((analyticsEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analyticsEventModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { analyticsEventModelImpl.getCompanyId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((analyticsEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analyticsEventModelImpl.getOriginalClassName(),
						analyticsEventModelImpl.getOriginalClassPK(),
						analyticsEventModelImpl.getOriginalEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_C_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_E,
					args);

				args = new Object[] {
						analyticsEventModelImpl.getClassName(),
						analyticsEventModelImpl.getClassPK(),
						analyticsEventModelImpl.getEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_C_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_E,
					args);
			}

			if ((analyticsEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_C_C_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analyticsEventModelImpl.getOriginalAnonymousUserId(),
						analyticsEventModelImpl.getOriginalClassName(),
						analyticsEventModelImpl.getOriginalClassPK(),
						analyticsEventModelImpl.getOriginalEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_A_C_C_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_C_C_E,
					args);

				args = new Object[] {
						analyticsEventModelImpl.getAnonymousUserId(),
						analyticsEventModelImpl.getClassName(),
						analyticsEventModelImpl.getClassPK(),
						analyticsEventModelImpl.getEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_A_C_C_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_C_C_E,
					args);
			}
		}

		entityCache.putResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventImpl.class, analyticsEvent.getPrimaryKey(),
			analyticsEvent, false);

		analyticsEvent.resetOriginalValues();

		return analyticsEvent;
	}

	protected AnalyticsEvent toUnwrappedModel(AnalyticsEvent analyticsEvent) {
		if (analyticsEvent instanceof AnalyticsEventImpl) {
			return analyticsEvent;
		}

		AnalyticsEventImpl analyticsEventImpl = new AnalyticsEventImpl();

		analyticsEventImpl.setNew(analyticsEvent.isNew());
		analyticsEventImpl.setPrimaryKey(analyticsEvent.getPrimaryKey());

		analyticsEventImpl.setAnalyticsEventId(analyticsEvent.getAnalyticsEventId());
		analyticsEventImpl.setCompanyId(analyticsEvent.getCompanyId());
		analyticsEventImpl.setUserId(analyticsEvent.getUserId());
		analyticsEventImpl.setAnonymousUserId(analyticsEvent.getAnonymousUserId());
		analyticsEventImpl.setClassName(analyticsEvent.getClassName());
		analyticsEventImpl.setClassPK(analyticsEvent.getClassPK());
		analyticsEventImpl.setElementId(analyticsEvent.getElementId());
		analyticsEventImpl.setEventType(analyticsEvent.getEventType());
		analyticsEventImpl.setClientIP(analyticsEvent.getClientIP());
		analyticsEventImpl.setUserAgent(analyticsEvent.getUserAgent());
		analyticsEventImpl.setLanguageId(analyticsEvent.getLanguageId());
		analyticsEventImpl.setURL(analyticsEvent.getURL());
		analyticsEventImpl.setAdditionalInfo(analyticsEvent.getAdditionalInfo());
		analyticsEventImpl.setCreateDate(analyticsEvent.getCreateDate());

		return analyticsEventImpl;
	}

	/**
	 * Returns the analytics event with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the analytics event
	 * @return the analytics event
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnalyticsEventException {
		AnalyticsEvent analyticsEvent = fetchByPrimaryKey(primaryKey);

		if (analyticsEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnalyticsEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return analyticsEvent;
	}

	/**
	 * Returns the analytics event with the primary key or throws a {@link NoSuchAnalyticsEventException} if it could not be found.
	 *
	 * @param analyticsEventId the primary key of the analytics event
	 * @return the analytics event
	 * @throws NoSuchAnalyticsEventException if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent findByPrimaryKey(long analyticsEventId)
		throws NoSuchAnalyticsEventException {
		return findByPrimaryKey((Serializable)analyticsEventId);
	}

	/**
	 * Returns the analytics event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the analytics event
	 * @return the analytics event, or <code>null</code> if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent fetchByPrimaryKey(Serializable primaryKey) {
		AnalyticsEvent analyticsEvent = (AnalyticsEvent)entityCache.getResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
				AnalyticsEventImpl.class, primaryKey);

		if (analyticsEvent == _nullAnalyticsEvent) {
			return null;
		}

		if (analyticsEvent == null) {
			Session session = null;

			try {
				session = openSession();

				analyticsEvent = (AnalyticsEvent)session.get(AnalyticsEventImpl.class,
						primaryKey);

				if (analyticsEvent != null) {
					cacheResult(analyticsEvent);
				}
				else {
					entityCache.putResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
						AnalyticsEventImpl.class, primaryKey,
						_nullAnalyticsEvent);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
					AnalyticsEventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return analyticsEvent;
	}

	/**
	 * Returns the analytics event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param analyticsEventId the primary key of the analytics event
	 * @return the analytics event, or <code>null</code> if a analytics event with the primary key could not be found
	 */
	@Override
	public AnalyticsEvent fetchByPrimaryKey(long analyticsEventId) {
		return fetchByPrimaryKey((Serializable)analyticsEventId);
	}

	@Override
	public Map<Serializable, AnalyticsEvent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AnalyticsEvent> map = new HashMap<Serializable, AnalyticsEvent>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AnalyticsEvent analyticsEvent = fetchByPrimaryKey(primaryKey);

			if (analyticsEvent != null) {
				map.put(primaryKey, analyticsEvent);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			AnalyticsEvent analyticsEvent = (AnalyticsEvent)entityCache.getResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
					AnalyticsEventImpl.class, primaryKey);

			if (analyticsEvent == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, analyticsEvent);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE_PKS_IN);

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

			for (AnalyticsEvent analyticsEvent : (List<AnalyticsEvent>)q.list()) {
				map.put(analyticsEvent.getPrimaryKeyObj(), analyticsEvent);

				cacheResult(analyticsEvent);

				uncachedPrimaryKeys.remove(analyticsEvent.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
					AnalyticsEventImpl.class, primaryKey, _nullAnalyticsEvent);
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
	 * Returns all the analytics events.
	 *
	 * @return the analytics events
	 */
	@Override
	public List<AnalyticsEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of analytics events
	 */
	@Override
	public List<AnalyticsEvent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of analytics events
	 */
	@Override
	public List<AnalyticsEvent> findAll(int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the analytics events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of analytics events
	 */
	@Override
	public List<AnalyticsEvent> findAll(int start, int end,
		OrderByComparator<AnalyticsEvent> orderByComparator,
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

		List<AnalyticsEvent> list = null;

		if (retrieveFromCache) {
			list = (List<AnalyticsEvent>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ANALYTICSEVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANALYTICSEVENT;

				if (pagination) {
					sql = sql.concat(AnalyticsEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Removes all the analytics events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnalyticsEvent analyticsEvent : findAll()) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events.
	 *
	 * @return the number of analytics events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANALYTICSEVENT);

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
		return AnalyticsEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the analytics event persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AnalyticsEventImpl.class.getName());
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
	private static final String _SQL_SELECT_ANALYTICSEVENT = "SELECT analyticsEvent FROM AnalyticsEvent analyticsEvent";
	private static final String _SQL_SELECT_ANALYTICSEVENT_WHERE_PKS_IN = "SELECT analyticsEvent FROM AnalyticsEvent analyticsEvent WHERE analyticsEventId IN (";
	private static final String _SQL_SELECT_ANALYTICSEVENT_WHERE = "SELECT analyticsEvent FROM AnalyticsEvent analyticsEvent WHERE ";
	private static final String _SQL_COUNT_ANALYTICSEVENT = "SELECT COUNT(analyticsEvent) FROM AnalyticsEvent analyticsEvent";
	private static final String _SQL_COUNT_ANALYTICSEVENT_WHERE = "SELECT COUNT(analyticsEvent) FROM AnalyticsEvent analyticsEvent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "analyticsEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnalyticsEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AnalyticsEvent exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AnalyticsEventPersistenceImpl.class);
	private static final AnalyticsEvent _nullAnalyticsEvent = new AnalyticsEventImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AnalyticsEvent> toCacheModel() {
				return _nullAnalyticsEventCacheModel;
			}
		};

	private static final CacheModel<AnalyticsEvent> _nullAnalyticsEventCacheModel =
		new CacheModel<AnalyticsEvent>() {
			@Override
			public AnalyticsEvent toEntityModel() {
				return _nullAnalyticsEvent;
			}
		};
}