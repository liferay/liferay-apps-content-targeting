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

package com.liferay.analytics.service.persistence;

import com.liferay.analytics.NoSuchEventException;
import com.liferay.analytics.model.AnalyticsEvent;
import com.liferay.analytics.model.impl.AnalyticsEventImpl;
import com.liferay.analytics.model.impl.AnalyticsEventModelImpl;

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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the analytics event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventPersistence
 * @see AnalyticsEventUtil
 * @generated
 */
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the analytics events where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<AnalyticsEvent> list = (List<AnalyticsEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AnalyticsEvent analyticsEvent : list) {
				if ((companyId != analyticsEvent.getCompanyId())) {
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

					list = new UnmodifiableList<AnalyticsEvent>(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent[] findByCompanyId_PrevAndNext(long analyticsEventId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_GtD(long companyId, Date createDate)
		throws SystemException {
		return findByC_GtD(companyId, createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_GtD(long companyId, Date createDate,
		int start, int end) throws SystemException {
		return findByC_GtD(companyId, createDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_GtD(long companyId, Date createDate,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD;
		finderArgs = new Object[] {
				companyId, createDate,
				
				start, end, orderByComparator
			};

		List<AnalyticsEvent> list = (List<AnalyticsEvent>)FinderCacheUtil.getResult(finderPath,
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

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
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
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AnalyticsEvent>(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByC_GtD_First(long companyId, Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByC_GtD_First(long companyId, Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByC_GtD_Last(long companyId, Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where companyId = &#63; and createDate &gt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByC_GtD_Last(long companyId, Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent[] findByC_GtD_PrevAndNext(long analyticsEventId,
		long companyId, Date createDate, OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
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
			qPos.add(CalendarUtil.getTimestamp(createDate));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_GtD(long companyId, Date createDate)
		throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_GtD(long companyId, Date createDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_GTD;

		Object[] finderArgs = new Object[] { companyId, createDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

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
					qPos.add(CalendarUtil.getTimestamp(createDate));
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

	private static final String _FINDER_COLUMN_C_GTD_COMPANYID_2 = "analyticsEvent.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_GTD_CREATEDATE_1 = "analyticsEvent.createDate > NULL";
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_LtD(long companyId, Date createDate)
		throws SystemException {
		return findByC_LtD(companyId, createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_LtD(long companyId, Date createDate,
		int start, int end) throws SystemException {
		return findByC_LtD(companyId, createDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_LtD(long companyId, Date createDate,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_LTD;
		finderArgs = new Object[] {
				companyId, createDate,
				
				start, end, orderByComparator
			};

		List<AnalyticsEvent> list = (List<AnalyticsEvent>)FinderCacheUtil.getResult(finderPath,
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

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
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
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AnalyticsEvent>(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByC_LtD_First(long companyId, Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByC_LtD_First(long companyId, Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByC_LtD_Last(long companyId, Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByC_LtD_Last(long companyId, Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent[] findByC_LtD_PrevAndNext(long analyticsEventId,
		long companyId, Date createDate, OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
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
			qPos.add(CalendarUtil.getTimestamp(createDate));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_LtD(long companyId, Date createDate)
		throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_LtD(long companyId, Date createDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_LTD;

		Object[] finderArgs = new Object[] { companyId, createDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

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
					qPos.add(CalendarUtil.getTimestamp(createDate));
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

	private static final String _FINDER_COLUMN_C_LTD_COMPANYID_2 = "analyticsEvent.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_LTD_CREATEDATE_1 = "analyticsEvent.createDate < NULL";
	private static final String _FINDER_COLUMN_C_LTD_CREATEDATE_2 = "analyticsEvent.createDate < ?";
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate) throws SystemException {
		return findByC_C_E_GtD(className, classPK, eventType, createDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate, int start, int end)
		throws SystemException {
		return findByC_C_E_GtD(className, classPK, eventType, createDate,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_E_GTD;
		finderArgs = new Object[] {
				className, classPK, eventType, createDate,
				
				start, end, orderByComparator
			};

		List<AnalyticsEvent> list = (List<AnalyticsEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AnalyticsEvent analyticsEvent : list) {
				if (!Validator.equals(className, analyticsEvent.getClassName()) ||
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

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
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
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AnalyticsEvent>(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByC_C_E_GtD_First(String className, long classPK,
		String eventType, Date createDate, OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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

		throw new NoSuchEventException(msg.toString());
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByC_C_E_GtD_First(String className,
		long classPK, String eventType, Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
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
	 * @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByC_C_E_GtD_Last(String className, long classPK,
		String eventType, Date createDate, OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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

		throw new NoSuchEventException(msg.toString());
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByC_C_E_GtD_Last(String className, long classPK,
		String eventType, Date createDate, OrderByComparator orderByComparator)
		throws SystemException {
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
	 * @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent[] findByC_C_E_GtD_PrevAndNext(long analyticsEventId,
		String className, long classPK, String eventType, Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
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
		String eventType, Date createDate, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
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
			qPos.add(CalendarUtil.getTimestamp(createDate));
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate) throws SystemException {
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_E_GtD(String className, long classPK,
		String eventType, Date createDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_C_E_GTD;

		Object[] finderArgs = new Object[] {
				className, classPK, eventType, createDate
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

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
					qPos.add(CalendarUtil.getTimestamp(createDate));
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

	private static final String _FINDER_COLUMN_C_C_E_GTD_CLASSNAME_1 = "analyticsEvent.className IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_CLASSNAME_2 = "analyticsEvent.className = ? AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_CLASSNAME_3 = "(analyticsEvent.className IS NULL OR analyticsEvent.className = '') AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_CLASSPK_2 = "analyticsEvent.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_1 = "analyticsEvent.eventType IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_2 = "analyticsEvent.eventType = ? AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_EVENTTYPE_3 = "(analyticsEvent.eventType IS NULL OR analyticsEvent.eventType = '') AND ";
	private static final String _FINDER_COLUMN_C_C_E_GTD_CREATEDATE_1 = "analyticsEvent.createDate > NULL";
	private static final String _FINDER_COLUMN_C_C_E_GTD_CREATEDATE_2 = "analyticsEvent.createDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_R_R_E_GTD =
		new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED,
			AnalyticsEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C_R_R_E_GtD",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				String.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_C_R_R_E_GTD =
		new FinderPath(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_C_R_R_E_GtD",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				String.class.getName(), Date.class.getName()
			});

	/**
	 * Returns all the analytics events where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @return the matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_R_R_E_GtD(String className,
		long classPK, String referrerClassName, long referrerClassPK,
		String eventType, Date createDate) throws SystemException {
		return findByC_C_R_R_E_GtD(className, classPK, referrerClassName,
			referrerClassPK, eventType, createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_R_R_E_GtD(String className,
		long classPK, String referrerClassName, long referrerClassPK,
		String eventType, Date createDate, int start, int end)
		throws SystemException {
		return findByC_C_R_R_E_GtD(className, classPK, referrerClassName,
			referrerClassPK, eventType, createDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findByC_C_R_R_E_GtD(String className,
		long classPK, String referrerClassName, long referrerClassPK,
		String eventType, Date createDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_R_R_E_GTD;
		finderArgs = new Object[] {
				className, classPK, referrerClassName, referrerClassPK,
				eventType, createDate,
				
				start, end, orderByComparator
			};

		List<AnalyticsEvent> list = (List<AnalyticsEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AnalyticsEvent analyticsEvent : list) {
				if (!Validator.equals(className, analyticsEvent.getClassName()) ||
						(classPK != analyticsEvent.getClassPK()) ||
						!Validator.equals(referrerClassName,
							analyticsEvent.getReferrerClassName()) ||
						(referrerClassPK != analyticsEvent.getReferrerClassPK()) ||
						!Validator.equals(eventType,
							analyticsEvent.getEventType()) ||
						(createDate.getTime() >= analyticsEvent.getCreateDate()
																   .getTime())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(8 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(8);
			}

			query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSPK_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_2);
			}

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CREATEDATE_2);
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

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (bindCreateDate) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				if (!pagination) {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AnalyticsEvent>(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event
	 * @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByC_C_R_R_E_GtD_First(String className,
		long classPK, String referrerClassName, long referrerClassPK,
		String eventType, Date createDate, OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		AnalyticsEvent analyticsEvent = fetchByC_C_R_R_E_GtD_First(className,
				classPK, referrerClassName, referrerClassPK, eventType,
				createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the first analytics event in the ordered set where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByC_C_R_R_E_GtD_First(String className,
		long classPK, String referrerClassName, long referrerClassPK,
		String eventType, Date createDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<AnalyticsEvent> list = findByC_C_R_R_E_GtD(className, classPK,
				referrerClassName, referrerClassPK, eventType, createDate, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event
	 * @throws com.liferay.analytics.NoSuchEventException if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByC_C_R_R_E_GtD_Last(String className,
		long classPK, String referrerClassName, long referrerClassPK,
		String eventType, Date createDate, OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		AnalyticsEvent analyticsEvent = fetchByC_C_R_R_E_GtD_Last(className,
				classPK, referrerClassName, referrerClassPK, eventType,
				createDate, orderByComparator);

		if (analyticsEvent != null) {
			return analyticsEvent;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventException(msg.toString());
	}

	/**
	 * Returns the last analytics event in the ordered set where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analytics event, or <code>null</code> if a matching analytics event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByC_C_R_R_E_GtD_Last(String className,
		long classPK, String referrerClassName, long referrerClassPK,
		String eventType, Date createDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_R_R_E_GtD(className, classPK, referrerClassName,
				referrerClassPK, eventType, createDate);

		if (count == 0) {
			return null;
		}

		List<AnalyticsEvent> list = findByC_C_R_R_E_GtD(className, classPK,
				referrerClassName, referrerClassPK, eventType, createDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the analytics events before and after the current analytics event in the ordered set where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param analyticsEventId the primary key of the current analytics event
	 * @param className the class name
	 * @param classPK the class p k
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next analytics event
	 * @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent[] findByC_C_R_R_E_GtD_PrevAndNext(
		long analyticsEventId, String className, long classPK,
		String referrerClassName, long referrerClassPK, String eventType,
		Date createDate, OrderByComparator orderByComparator)
		throws NoSuchEventException, SystemException {
		AnalyticsEvent analyticsEvent = findByPrimaryKey(analyticsEventId);

		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent[] array = new AnalyticsEventImpl[3];

			array[0] = getByC_C_R_R_E_GtD_PrevAndNext(session, analyticsEvent,
					className, classPK, referrerClassName, referrerClassPK,
					eventType, createDate, orderByComparator, true);

			array[1] = analyticsEvent;

			array[2] = getByC_C_R_R_E_GtD_PrevAndNext(session, analyticsEvent,
					className, classPK, referrerClassName, referrerClassPK,
					eventType, createDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalyticsEvent getByC_C_R_R_E_GtD_PrevAndNext(Session session,
		AnalyticsEvent analyticsEvent, String className, long classPK,
		String referrerClassName, long referrerClassPK, String eventType,
		Date createDate, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANALYTICSEVENT_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSPK_2);

		boolean bindReferrerClassName = false;

		if (referrerClassName == null) {
			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_1);
		}
		else if (referrerClassName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_3);
		}
		else {
			bindReferrerClassName = true;

			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSPK_2);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_2);
		}

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CREATEDATE_2);
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

		if (bindReferrerClassName) {
			qPos.add(referrerClassName);
		}

		qPos.add(referrerClassPK);

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (bindCreateDate) {
			qPos.add(CalendarUtil.getTimestamp(createDate));
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
	 * Removes all the analytics events where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_R_R_E_GtD(String className, long classPK,
		String referrerClassName, long referrerClassPK, String eventType,
		Date createDate) throws SystemException {
		for (AnalyticsEvent analyticsEvent : findByC_C_R_R_E_GtD(className,
				classPK, referrerClassName, referrerClassPK, eventType,
				createDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events where className = &#63; and classPK = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and eventType = &#63; and createDate &gt; &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param eventType the event type
	 * @param createDate the create date
	 * @return the number of matching analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_R_R_E_GtD(String className, long classPK,
		String referrerClassName, long referrerClassPK, String eventType,
		Date createDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_C_R_R_E_GTD;

		Object[] finderArgs = new Object[] {
				className, classPK, referrerClassName, referrerClassPK,
				eventType, createDate
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_ANALYTICSEVENT_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CLASSPK_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_2);
			}

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_C_R_R_E_GTD_CREATEDATE_2);
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

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (bindCreateDate) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
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

	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_1 = "analyticsEvent.className IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_2 = "analyticsEvent.className = ? AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_CLASSNAME_3 = "(analyticsEvent.className IS NULL OR analyticsEvent.className = '') AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_CLASSPK_2 = "analyticsEvent.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_1 =
		"analyticsEvent.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_2 =
		"analyticsEvent.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSNAME_3 =
		"(analyticsEvent.referrerClassName IS NULL OR analyticsEvent.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_REFERRERCLASSPK_2 = "analyticsEvent.referrerClassPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_1 = "analyticsEvent.eventType IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_2 = "analyticsEvent.eventType = ? AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_EVENTTYPE_3 = "(analyticsEvent.eventType IS NULL OR analyticsEvent.eventType = '') AND ";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_CREATEDATE_1 = "analyticsEvent.createDate > NULL";
	private static final String _FINDER_COLUMN_C_C_R_R_E_GTD_CREATEDATE_2 = "analyticsEvent.createDate > ?";

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
		EntityCacheUtil.putResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
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
			if (EntityCacheUtil.getResult(
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
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnalyticsEventImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnalyticsEventImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the analytics event.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnalyticsEvent analyticsEvent) {
		EntityCacheUtil.removeResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventImpl.class, analyticsEvent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnalyticsEvent> analyticsEvents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnalyticsEvent analyticsEvent : analyticsEvents) {
			EntityCacheUtil.removeResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
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

		return analyticsEvent;
	}

	/**
	 * Removes the analytics event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param analyticsEventId the primary key of the analytics event
	 * @return the analytics event that was removed
	 * @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent remove(long analyticsEventId)
		throws NoSuchEventException, SystemException {
		return remove((Serializable)analyticsEventId);
	}

	/**
	 * Removes the analytics event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the analytics event
	 * @return the analytics event that was removed
	 * @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent remove(Serializable primaryKey)
		throws NoSuchEventException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AnalyticsEvent analyticsEvent = (AnalyticsEvent)session.get(AnalyticsEventImpl.class,
					primaryKey);

			if (analyticsEvent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(analyticsEvent);
		}
		catch (NoSuchEventException nsee) {
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
	protected AnalyticsEvent removeImpl(AnalyticsEvent analyticsEvent)
		throws SystemException {
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
	public AnalyticsEvent updateImpl(
		com.liferay.analytics.model.AnalyticsEvent analyticsEvent)
		throws SystemException {
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
				session.merge(analyticsEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnalyticsEventModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((analyticsEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analyticsEventModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { analyticsEventModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
			AnalyticsEventImpl.class, analyticsEvent.getPrimaryKey(),
			analyticsEvent);

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
		analyticsEventImpl.setReferrerClassName(analyticsEvent.getReferrerClassName());
		analyticsEventImpl.setReferrerClassPK(analyticsEvent.getReferrerClassPK());
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
	 * Returns the analytics event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the analytics event
	 * @return the analytics event
	 * @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventException, SystemException {
		AnalyticsEvent analyticsEvent = fetchByPrimaryKey(primaryKey);

		if (analyticsEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return analyticsEvent;
	}

	/**
	 * Returns the analytics event with the primary key or throws a {@link com.liferay.analytics.NoSuchEventException} if it could not be found.
	 *
	 * @param analyticsEventId the primary key of the analytics event
	 * @return the analytics event
	 * @throws com.liferay.analytics.NoSuchEventException if a analytics event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent findByPrimaryKey(long analyticsEventId)
		throws NoSuchEventException, SystemException {
		return findByPrimaryKey((Serializable)analyticsEventId);
	}

	/**
	 * Returns the analytics event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the analytics event
	 * @return the analytics event, or <code>null</code> if a analytics event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AnalyticsEvent analyticsEvent = (AnalyticsEvent)EntityCacheUtil.getResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
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
					EntityCacheUtil.putResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
						AnalyticsEventImpl.class, primaryKey,
						_nullAnalyticsEvent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AnalyticsEventModelImpl.ENTITY_CACHE_ENABLED,
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnalyticsEvent fetchByPrimaryKey(long analyticsEventId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)analyticsEventId);
	}

	/**
	 * Returns all the analytics events.
	 *
	 * @return the analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the analytics events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @return the range of analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the analytics events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.analytics.model.impl.AnalyticsEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of analytics events
	 * @param end the upper bound of the range of analytics events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of analytics events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnalyticsEvent> findAll(int start, int end,
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

		List<AnalyticsEvent> list = (List<AnalyticsEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

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

					list = new UnmodifiableList<AnalyticsEvent>(list);
				}
				else {
					list = (List<AnalyticsEvent>)QueryUtil.list(q,
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
	 * Removes all the analytics events from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AnalyticsEvent analyticsEvent : findAll()) {
			remove(analyticsEvent);
		}
	}

	/**
	 * Returns the number of analytics events.
	 *
	 * @return the number of analytics events
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

				Query q = session.createQuery(_SQL_COUNT_ANALYTICSEVENT);

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
	 * Initializes the analytics event persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.analytics.model.AnalyticsEvent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AnalyticsEvent>> listenersList = new ArrayList<ModelListener<AnalyticsEvent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AnalyticsEvent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AnalyticsEventImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ANALYTICSEVENT = "SELECT analyticsEvent FROM AnalyticsEvent analyticsEvent";
	private static final String _SQL_SELECT_ANALYTICSEVENT_WHERE = "SELECT analyticsEvent FROM AnalyticsEvent analyticsEvent WHERE ";
	private static final String _SQL_COUNT_ANALYTICSEVENT = "SELECT COUNT(analyticsEvent) FROM AnalyticsEvent analyticsEvent";
	private static final String _SQL_COUNT_ANALYTICSEVENT_WHERE = "SELECT COUNT(analyticsEvent) FROM AnalyticsEvent analyticsEvent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "analyticsEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnalyticsEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AnalyticsEvent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnalyticsEventPersistenceImpl.class);
	private static AnalyticsEvent _nullAnalyticsEvent = new AnalyticsEventImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AnalyticsEvent> toCacheModel() {
				return _nullAnalyticsEventCacheModel;
			}
		};

	private static CacheModel<AnalyticsEvent> _nullAnalyticsEventCacheModel = new CacheModel<AnalyticsEvent>() {
			@Override
			public AnalyticsEvent toEntityModel() {
				return _nullAnalyticsEvent;
			}
		};
}