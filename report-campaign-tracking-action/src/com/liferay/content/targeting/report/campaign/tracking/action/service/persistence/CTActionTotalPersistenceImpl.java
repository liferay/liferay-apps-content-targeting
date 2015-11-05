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

package com.liferay.content.targeting.report.campaign.tracking.action.service.persistence;

import com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalImpl;
import com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the c t action total service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotalPersistence
 * @see CTActionTotalUtil
 * @generated
 */
public class CTActionTotalPersistenceImpl extends BasePersistenceImpl<CTActionTotal>
	implements CTActionTotalPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CTActionTotalUtil} to access the c t action total persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CTActionTotalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CTActionTotalImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CTActionTotalImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_GTD = new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CTActionTotalImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByR_GtD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_R_GTD = new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByR_GtD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @return the matching c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate) throws SystemException {
		return findByR_GtD(reportInstanceId, modifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @return the range of matching c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end) throws SystemException {
		return findByR_GtD(reportInstanceId, modifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_GTD;
		finderArgs = new Object[] {
				reportInstanceId, modifiedDate,
				
				start, end, orderByComparator
			};

		List<CTActionTotal> list = (List<CTActionTotal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CTActionTotal ctActionTotal : list) {
				if ((reportInstanceId != ctActionTotal.getReportInstanceId()) ||
						(modifiedDate.getTime() >= ctActionTotal.getModifiedDate()
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

			query.append(_SQL_SELECT_CTACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_R_GTD_REPORTINSTANCEID_2);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_R_GTD_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_R_GTD_MODIFIEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CTActionTotalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (bindModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				if (!pagination) {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CTActionTotal>(list);
				}
				else {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal findByR_GtD_First(long reportInstanceId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws NoSuchCTActionTotalException, SystemException {
		CTActionTotal ctActionTotal = fetchByR_GtD_First(reportInstanceId,
				modifiedDate, orderByComparator);

		if (ctActionTotal != null) {
			return ctActionTotal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionTotalException(msg.toString());
	}

	/**
	 * Returns the first c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action total, or <code>null</code> if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal fetchByR_GtD_First(long reportInstanceId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<CTActionTotal> list = findByR_GtD(reportInstanceId, modifiedDate,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal findByR_GtD_Last(long reportInstanceId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws NoSuchCTActionTotalException, SystemException {
		CTActionTotal ctActionTotal = fetchByR_GtD_Last(reportInstanceId,
				modifiedDate, orderByComparator);

		if (ctActionTotal != null) {
			return ctActionTotal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionTotalException(msg.toString());
	}

	/**
	 * Returns the last c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action total, or <code>null</code> if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal fetchByR_GtD_Last(long reportInstanceId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByR_GtD(reportInstanceId, modifiedDate);

		if (count == 0) {
			return null;
		}

		List<CTActionTotal> list = findByR_GtD(reportInstanceId, modifiedDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c t action totals before and after the current c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param CTActionTotalId the primary key of the current c t action total
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c t action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal[] findByR_GtD_PrevAndNext(long CTActionTotalId,
		long reportInstanceId, Date modifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchCTActionTotalException, SystemException {
		CTActionTotal ctActionTotal = findByPrimaryKey(CTActionTotalId);

		Session session = null;

		try {
			session = openSession();

			CTActionTotal[] array = new CTActionTotalImpl[3];

			array[0] = getByR_GtD_PrevAndNext(session, ctActionTotal,
					reportInstanceId, modifiedDate, orderByComparator, true);

			array[1] = ctActionTotal;

			array[2] = getByR_GtD_PrevAndNext(session, ctActionTotal,
					reportInstanceId, modifiedDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CTActionTotal getByR_GtD_PrevAndNext(Session session,
		CTActionTotal ctActionTotal, long reportInstanceId, Date modifiedDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CTACTIONTOTAL_WHERE);

		query.append(_FINDER_COLUMN_R_GTD_REPORTINSTANCEID_2);

		boolean bindModifiedDate = false;

		if (modifiedDate == null) {
			query.append(_FINDER_COLUMN_R_GTD_MODIFIEDDATE_1);
		}
		else {
			bindModifiedDate = true;

			query.append(_FINDER_COLUMN_R_GTD_MODIFIEDDATE_2);
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
			query.append(CTActionTotalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(reportInstanceId);

		if (bindModifiedDate) {
			qPos.add(CalendarUtil.getTimestamp(modifiedDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ctActionTotal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CTActionTotal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByR_GtD(long reportInstanceId, Date modifiedDate)
		throws SystemException {
		for (CTActionTotal ctActionTotal : findByR_GtD(reportInstanceId,
				modifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ctActionTotal);
		}
	}

	/**
	 * Returns the number of c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @return the number of matching c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByR_GtD(long reportInstanceId, Date modifiedDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_R_GTD;

		Object[] finderArgs = new Object[] { reportInstanceId, modifiedDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CTACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_R_GTD_REPORTINSTANCEID_2);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_R_GTD_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_R_GTD_MODIFIEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (bindModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
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

	private static final String _FINDER_COLUMN_R_GTD_REPORTINSTANCEID_2 = "ctActionTotal.reportInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_R_GTD_MODIFIEDDATE_1 = "ctActionTotal.modifiedDate > NULL";
	private static final String _FINDER_COLUMN_R_GTD_MODIFIEDDATE_2 = "ctActionTotal.modifiedDate > ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_R_R_R_E_E = new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CTActionTotalImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByR_R_R_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			CTActionTotalModelImpl.REPORTINSTANCEID_COLUMN_BITMASK |
			CTActionTotalModelImpl.REFERRERCLASSNAME_COLUMN_BITMASK |
			CTActionTotalModelImpl.REFERRERCLASSPK_COLUMN_BITMASK |
			CTActionTotalModelImpl.ELEMENTID_COLUMN_BITMASK |
			CTActionTotalModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_R_R_E_E = new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_R_R_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the c t action total where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException} if it could not be found.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching c t action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal findByR_R_R_E_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) throws NoSuchCTActionTotalException, SystemException {
		CTActionTotal ctActionTotal = fetchByR_R_R_E_E(reportInstanceId,
				referrerClassName, referrerClassPK, elementId, eventType);

		if (ctActionTotal == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("reportInstanceId=");
			msg.append(reportInstanceId);

			msg.append(", referrerClassName=");
			msg.append(referrerClassName);

			msg.append(", referrerClassPK=");
			msg.append(referrerClassPK);

			msg.append(", elementId=");
			msg.append(elementId);

			msg.append(", eventType=");
			msg.append(eventType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCTActionTotalException(msg.toString());
		}

		return ctActionTotal;
	}

	/**
	 * Returns the c t action total where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching c t action total, or <code>null</code> if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal fetchByR_R_R_E_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) throws SystemException {
		return fetchByR_R_R_E_E(reportInstanceId, referrerClassName,
			referrerClassPK, elementId, eventType, true);
	}

	/**
	 * Returns the c t action total where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching c t action total, or <code>null</code> if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal fetchByR_R_R_E_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				reportInstanceId, referrerClassName, referrerClassPK, elementId,
				eventType
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_R_R_R_E_E,
					finderArgs, this);
		}

		if (result instanceof CTActionTotal) {
			CTActionTotal ctActionTotal = (CTActionTotal)result;

			if ((reportInstanceId != ctActionTotal.getReportInstanceId()) ||
					!Validator.equals(referrerClassName,
						ctActionTotal.getReferrerClassName()) ||
					(referrerClassPK != ctActionTotal.getReferrerClassPK()) ||
					!Validator.equals(elementId, ctActionTotal.getElementId()) ||
					!Validator.equals(eventType, ctActionTotal.getEventType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_CTACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_R_R_R_E_E_REPORTINSTANCEID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSPK_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_R_R_R_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_R_R_R_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (bindEventType) {
					qPos.add(eventType);
				}

				List<CTActionTotal> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_R_R_R_E_E,
						finderArgs, list);
				}
				else {
					CTActionTotal ctActionTotal = list.get(0);

					result = ctActionTotal;

					cacheResult(ctActionTotal);

					if ((ctActionTotal.getReportInstanceId() != reportInstanceId) ||
							(ctActionTotal.getReferrerClassName() == null) ||
							!ctActionTotal.getReferrerClassName()
											  .equals(referrerClassName) ||
							(ctActionTotal.getReferrerClassPK() != referrerClassPK) ||
							(ctActionTotal.getElementId() == null) ||
							!ctActionTotal.getElementId().equals(elementId) ||
							(ctActionTotal.getEventType() == null) ||
							!ctActionTotal.getEventType().equals(eventType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_R_R_R_E_E,
							finderArgs, ctActionTotal);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_R_R_R_E_E,
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
			return (CTActionTotal)result;
		}
	}

	/**
	 * Removes the c t action total where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the c t action total that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal removeByR_R_R_E_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) throws NoSuchCTActionTotalException, SystemException {
		CTActionTotal ctActionTotal = findByR_R_R_E_E(reportInstanceId,
				referrerClassName, referrerClassPK, elementId, eventType);

		return remove(ctActionTotal);
	}

	/**
	 * Returns the number of c t action totals where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the number of matching c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByR_R_R_E_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_R_R_E_E;

		Object[] finderArgs = new Object[] {
				reportInstanceId, referrerClassName, referrerClassPK, elementId,
				eventType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_CTACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_R_R_R_E_E_REPORTINSTANCEID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSPK_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_R_R_R_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_R_R_R_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (bindReferrerClassName) {
					qPos.add(referrerClassName);
				}

				qPos.add(referrerClassPK);

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (bindEventType) {
					qPos.add(eventType);
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

	private static final String _FINDER_COLUMN_R_R_R_E_E_REPORTINSTANCEID_2 = "ctActionTotal.reportInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSNAME_1 = "ctActionTotal.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSNAME_2 = "ctActionTotal.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSNAME_3 = "(ctActionTotal.referrerClassName IS NULL OR ctActionTotal.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_E_REFERRERCLASSPK_2 = "ctActionTotal.referrerClassPK = ? AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_E_ELEMENTID_1 = "ctActionTotal.elementId IS NULL AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_E_ELEMENTID_2 = "ctActionTotal.elementId = ? AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_E_ELEMENTID_3 = "(ctActionTotal.elementId IS NULL OR ctActionTotal.elementId = '') AND ";
	private static final String _FINDER_COLUMN_R_R_R_E_E_EVENTTYPE_1 = "ctActionTotal.eventType IS NULL";
	private static final String _FINDER_COLUMN_R_R_R_E_E_EVENTTYPE_2 = "ctActionTotal.eventType = ?";
	private static final String _FINDER_COLUMN_R_R_R_E_E_EVENTTYPE_3 = "(ctActionTotal.eventType IS NULL OR ctActionTotal.eventType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTINSTANCEID =
		new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CTActionTotalImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReportInstanceId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID =
		new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CTActionTotalImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByReportInstanceId", new String[] { Long.class.getName() },
			CTActionTotalModelImpl.REPORTINSTANCEID_COLUMN_BITMASK |
			CTActionTotalModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTINSTANCEID = new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReportInstanceId", new String[] { Long.class.getName() });

	/**
	 * Returns all the c t action totals where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @return the matching c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CTActionTotal> findByReportInstanceId(long reportInstanceId)
		throws SystemException {
		return findByReportInstanceId(reportInstanceId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t action totals where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @return the range of matching c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CTActionTotal> findByReportInstanceId(long reportInstanceId,
		int start, int end) throws SystemException {
		return findByReportInstanceId(reportInstanceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t action totals where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CTActionTotal> findByReportInstanceId(long reportInstanceId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID;
			finderArgs = new Object[] { reportInstanceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTINSTANCEID;
			finderArgs = new Object[] {
					reportInstanceId,
					
					start, end, orderByComparator
				};
		}

		List<CTActionTotal> list = (List<CTActionTotal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CTActionTotal ctActionTotal : list) {
				if ((reportInstanceId != ctActionTotal.getReportInstanceId())) {
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

			query.append(_SQL_SELECT_CTACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_REPORTINSTANCEID_REPORTINSTANCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CTActionTotalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (!pagination) {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CTActionTotal>(list);
				}
				else {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c t action total in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal findByReportInstanceId_First(long reportInstanceId,
		OrderByComparator orderByComparator)
		throws NoSuchCTActionTotalException, SystemException {
		CTActionTotal ctActionTotal = fetchByReportInstanceId_First(reportInstanceId,
				orderByComparator);

		if (ctActionTotal != null) {
			return ctActionTotal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionTotalException(msg.toString());
	}

	/**
	 * Returns the first c t action total in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action total, or <code>null</code> if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal fetchByReportInstanceId_First(long reportInstanceId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CTActionTotal> list = findByReportInstanceId(reportInstanceId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c t action total in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal findByReportInstanceId_Last(long reportInstanceId,
		OrderByComparator orderByComparator)
		throws NoSuchCTActionTotalException, SystemException {
		CTActionTotal ctActionTotal = fetchByReportInstanceId_Last(reportInstanceId,
				orderByComparator);

		if (ctActionTotal != null) {
			return ctActionTotal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionTotalException(msg.toString());
	}

	/**
	 * Returns the last c t action total in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action total, or <code>null</code> if a matching c t action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal fetchByReportInstanceId_Last(long reportInstanceId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReportInstanceId(reportInstanceId);

		if (count == 0) {
			return null;
		}

		List<CTActionTotal> list = findByReportInstanceId(reportInstanceId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c t action totals before and after the current c t action total in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param CTActionTotalId the primary key of the current c t action total
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c t action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal[] findByReportInstanceId_PrevAndNext(
		long CTActionTotalId, long reportInstanceId,
		OrderByComparator orderByComparator)
		throws NoSuchCTActionTotalException, SystemException {
		CTActionTotal ctActionTotal = findByPrimaryKey(CTActionTotalId);

		Session session = null;

		try {
			session = openSession();

			CTActionTotal[] array = new CTActionTotalImpl[3];

			array[0] = getByReportInstanceId_PrevAndNext(session,
					ctActionTotal, reportInstanceId, orderByComparator, true);

			array[1] = ctActionTotal;

			array[2] = getByReportInstanceId_PrevAndNext(session,
					ctActionTotal, reportInstanceId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CTActionTotal getByReportInstanceId_PrevAndNext(Session session,
		CTActionTotal ctActionTotal, long reportInstanceId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CTACTIONTOTAL_WHERE);

		query.append(_FINDER_COLUMN_REPORTINSTANCEID_REPORTINSTANCEID_2);

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
			query.append(CTActionTotalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(reportInstanceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ctActionTotal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CTActionTotal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the c t action totals where reportInstanceId = &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReportInstanceId(long reportInstanceId)
		throws SystemException {
		for (CTActionTotal ctActionTotal : findByReportInstanceId(
				reportInstanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ctActionTotal);
		}
	}

	/**
	 * Returns the number of c t action totals where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @return the number of matching c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReportInstanceId(long reportInstanceId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPORTINSTANCEID;

		Object[] finderArgs = new Object[] { reportInstanceId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CTACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_REPORTINSTANCEID_REPORTINSTANCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

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

	private static final String _FINDER_COLUMN_REPORTINSTANCEID_REPORTINSTANCEID_2 =
		"ctActionTotal.reportInstanceId = ?";

	public CTActionTotalPersistenceImpl() {
		setModelClass(CTActionTotal.class);
	}

	/**
	 * Caches the c t action total in the entity cache if it is enabled.
	 *
	 * @param ctActionTotal the c t action total
	 */
	@Override
	public void cacheResult(CTActionTotal ctActionTotal) {
		EntityCacheUtil.putResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalImpl.class, ctActionTotal.getPrimaryKey(),
			ctActionTotal);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_R_R_R_E_E,
			new Object[] {
				ctActionTotal.getReportInstanceId(),
				ctActionTotal.getReferrerClassName(),
				ctActionTotal.getReferrerClassPK(), ctActionTotal.getElementId(),
				ctActionTotal.getEventType()
			}, ctActionTotal);

		ctActionTotal.resetOriginalValues();
	}

	/**
	 * Caches the c t action totals in the entity cache if it is enabled.
	 *
	 * @param ctActionTotals the c t action totals
	 */
	@Override
	public void cacheResult(List<CTActionTotal> ctActionTotals) {
		for (CTActionTotal ctActionTotal : ctActionTotals) {
			if (EntityCacheUtil.getResult(
						CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
						CTActionTotalImpl.class, ctActionTotal.getPrimaryKey()) == null) {
				cacheResult(ctActionTotal);
			}
			else {
				ctActionTotal.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all c t action totals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CTActionTotalImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CTActionTotalImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the c t action total.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CTActionTotal ctActionTotal) {
		EntityCacheUtil.removeResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalImpl.class, ctActionTotal.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(ctActionTotal);
	}

	@Override
	public void clearCache(List<CTActionTotal> ctActionTotals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CTActionTotal ctActionTotal : ctActionTotals) {
			EntityCacheUtil.removeResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
				CTActionTotalImpl.class, ctActionTotal.getPrimaryKey());

			clearUniqueFindersCache(ctActionTotal);
		}
	}

	protected void cacheUniqueFindersCache(CTActionTotal ctActionTotal) {
		if (ctActionTotal.isNew()) {
			Object[] args = new Object[] {
					ctActionTotal.getReportInstanceId(),
					ctActionTotal.getReferrerClassName(),
					ctActionTotal.getReferrerClassPK(),
					ctActionTotal.getElementId(), ctActionTotal.getEventType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_R_R_R_E_E, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_R_R_R_E_E, args,
				ctActionTotal);
		}
		else {
			CTActionTotalModelImpl ctActionTotalModelImpl = (CTActionTotalModelImpl)ctActionTotal;

			if ((ctActionTotalModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_R_R_R_E_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ctActionTotal.getReportInstanceId(),
						ctActionTotal.getReferrerClassName(),
						ctActionTotal.getReferrerClassPK(),
						ctActionTotal.getElementId(),
						ctActionTotal.getEventType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_R_R_R_E_E, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_R_R_R_E_E, args,
					ctActionTotal);
			}
		}
	}

	protected void clearUniqueFindersCache(CTActionTotal ctActionTotal) {
		CTActionTotalModelImpl ctActionTotalModelImpl = (CTActionTotalModelImpl)ctActionTotal;

		Object[] args = new Object[] {
				ctActionTotal.getReportInstanceId(),
				ctActionTotal.getReferrerClassName(),
				ctActionTotal.getReferrerClassPK(), ctActionTotal.getElementId(),
				ctActionTotal.getEventType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_R_R_E_E, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_R_R_R_E_E, args);

		if ((ctActionTotalModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_R_R_R_E_E.getColumnBitmask()) != 0) {
			args = new Object[] {
					ctActionTotalModelImpl.getOriginalReportInstanceId(),
					ctActionTotalModelImpl.getOriginalReferrerClassName(),
					ctActionTotalModelImpl.getOriginalReferrerClassPK(),
					ctActionTotalModelImpl.getOriginalElementId(),
					ctActionTotalModelImpl.getOriginalEventType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_R_R_E_E, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_R_R_R_E_E, args);
		}
	}

	/**
	 * Creates a new c t action total with the primary key. Does not add the c t action total to the database.
	 *
	 * @param CTActionTotalId the primary key for the new c t action total
	 * @return the new c t action total
	 */
	@Override
	public CTActionTotal create(long CTActionTotalId) {
		CTActionTotal ctActionTotal = new CTActionTotalImpl();

		ctActionTotal.setNew(true);
		ctActionTotal.setPrimaryKey(CTActionTotalId);

		return ctActionTotal;
	}

	/**
	 * Removes the c t action total with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CTActionTotalId the primary key of the c t action total
	 * @return the c t action total that was removed
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal remove(long CTActionTotalId)
		throws NoSuchCTActionTotalException, SystemException {
		return remove((Serializable)CTActionTotalId);
	}

	/**
	 * Removes the c t action total with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the c t action total
	 * @return the c t action total that was removed
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal remove(Serializable primaryKey)
		throws NoSuchCTActionTotalException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CTActionTotal ctActionTotal = (CTActionTotal)session.get(CTActionTotalImpl.class,
					primaryKey);

			if (ctActionTotal == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCTActionTotalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ctActionTotal);
		}
		catch (NoSuchCTActionTotalException nsee) {
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
	protected CTActionTotal removeImpl(CTActionTotal ctActionTotal)
		throws SystemException {
		ctActionTotal = toUnwrappedModel(ctActionTotal);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ctActionTotal)) {
				ctActionTotal = (CTActionTotal)session.get(CTActionTotalImpl.class,
						ctActionTotal.getPrimaryKeyObj());
			}

			if (ctActionTotal != null) {
				session.delete(ctActionTotal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ctActionTotal != null) {
			clearCache(ctActionTotal);
		}

		return ctActionTotal;
	}

	@Override
	public CTActionTotal updateImpl(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal ctActionTotal)
		throws SystemException {
		ctActionTotal = toUnwrappedModel(ctActionTotal);

		boolean isNew = ctActionTotal.isNew();

		CTActionTotalModelImpl ctActionTotalModelImpl = (CTActionTotalModelImpl)ctActionTotal;

		Session session = null;

		try {
			session = openSession();

			if (ctActionTotal.isNew()) {
				session.save(ctActionTotal);

				ctActionTotal.setNew(false);
			}
			else {
				session.merge(ctActionTotal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CTActionTotalModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ctActionTotalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ctActionTotalModelImpl.getOriginalReportInstanceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORTINSTANCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID,
					args);

				args = new Object[] { ctActionTotalModelImpl.getReportInstanceId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORTINSTANCEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID,
					args);
			}
		}

		EntityCacheUtil.putResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalImpl.class, ctActionTotal.getPrimaryKey(),
			ctActionTotal);

		clearUniqueFindersCache(ctActionTotal);
		cacheUniqueFindersCache(ctActionTotal);

		return ctActionTotal;
	}

	protected CTActionTotal toUnwrappedModel(CTActionTotal ctActionTotal) {
		if (ctActionTotal instanceof CTActionTotalImpl) {
			return ctActionTotal;
		}

		CTActionTotalImpl ctActionTotalImpl = new CTActionTotalImpl();

		ctActionTotalImpl.setNew(ctActionTotal.isNew());
		ctActionTotalImpl.setPrimaryKey(ctActionTotal.getPrimaryKey());

		ctActionTotalImpl.setCTActionTotalId(ctActionTotal.getCTActionTotalId());
		ctActionTotalImpl.setCompanyId(ctActionTotal.getCompanyId());
		ctActionTotalImpl.setCampaignId(ctActionTotal.getCampaignId());
		ctActionTotalImpl.setReportInstanceId(ctActionTotal.getReportInstanceId());
		ctActionTotalImpl.setAlias(ctActionTotal.getAlias());
		ctActionTotalImpl.setReferrerClassName(ctActionTotal.getReferrerClassName());
		ctActionTotalImpl.setReferrerClassPK(ctActionTotal.getReferrerClassPK());
		ctActionTotalImpl.setElementId(ctActionTotal.getElementId());
		ctActionTotalImpl.setEventType(ctActionTotal.getEventType());
		ctActionTotalImpl.setCount(ctActionTotal.getCount());
		ctActionTotalImpl.setModifiedDate(ctActionTotal.getModifiedDate());

		return ctActionTotalImpl;
	}

	/**
	 * Returns the c t action total with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the c t action total
	 * @return the c t action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCTActionTotalException, SystemException {
		CTActionTotal ctActionTotal = fetchByPrimaryKey(primaryKey);

		if (ctActionTotal == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCTActionTotalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ctActionTotal;
	}

	/**
	 * Returns the c t action total with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException} if it could not be found.
	 *
	 * @param CTActionTotalId the primary key of the c t action total
	 * @return the c t action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal findByPrimaryKey(long CTActionTotalId)
		throws NoSuchCTActionTotalException, SystemException {
		return findByPrimaryKey((Serializable)CTActionTotalId);
	}

	/**
	 * Returns the c t action total with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the c t action total
	 * @return the c t action total, or <code>null</code> if a c t action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CTActionTotal ctActionTotal = (CTActionTotal)EntityCacheUtil.getResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
				CTActionTotalImpl.class, primaryKey);

		if (ctActionTotal == _nullCTActionTotal) {
			return null;
		}

		if (ctActionTotal == null) {
			Session session = null;

			try {
				session = openSession();

				ctActionTotal = (CTActionTotal)session.get(CTActionTotalImpl.class,
						primaryKey);

				if (ctActionTotal != null) {
					cacheResult(ctActionTotal);
				}
				else {
					EntityCacheUtil.putResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
						CTActionTotalImpl.class, primaryKey, _nullCTActionTotal);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
					CTActionTotalImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ctActionTotal;
	}

	/**
	 * Returns the c t action total with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param CTActionTotalId the primary key of the c t action total
	 * @return the c t action total, or <code>null</code> if a c t action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTActionTotal fetchByPrimaryKey(long CTActionTotalId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)CTActionTotalId);
	}

	/**
	 * Returns all the c t action totals.
	 *
	 * @return the c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CTActionTotal> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t action totals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @return the range of c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CTActionTotal> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t action totals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of c t action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CTActionTotal> findAll(int start, int end,
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

		List<CTActionTotal> list = (List<CTActionTotal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CTACTIONTOTAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CTACTIONTOTAL;

				if (pagination) {
					sql = sql.concat(CTActionTotalModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CTActionTotal>(list);
				}
				else {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the c t action totals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CTActionTotal ctActionTotal : findAll()) {
			remove(ctActionTotal);
		}
	}

	/**
	 * Returns the number of c t action totals.
	 *
	 * @return the number of c t action totals
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

				Query q = session.createQuery(_SQL_COUNT_CTACTIONTOTAL);

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
	 * Initializes the c t action total persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CTActionTotal>> listenersList = new ArrayList<ModelListener<CTActionTotal>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CTActionTotal>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CTActionTotalImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CTACTIONTOTAL = "SELECT ctActionTotal FROM CTActionTotal ctActionTotal";
	private static final String _SQL_SELECT_CTACTIONTOTAL_WHERE = "SELECT ctActionTotal FROM CTActionTotal ctActionTotal WHERE ";
	private static final String _SQL_COUNT_CTACTIONTOTAL = "SELECT COUNT(ctActionTotal) FROM CTActionTotal ctActionTotal";
	private static final String _SQL_COUNT_CTACTIONTOTAL_WHERE = "SELECT COUNT(ctActionTotal) FROM CTActionTotal ctActionTotal WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ctActionTotal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CTActionTotal exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CTActionTotal exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CTActionTotalPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"alias"
			});
	private static CTActionTotal _nullCTActionTotal = new CTActionTotalImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CTActionTotal> toCacheModel() {
				return _nullCTActionTotalCacheModel;
			}
		};

	private static CacheModel<CTActionTotal> _nullCTActionTotalCacheModel = new CacheModel<CTActionTotal>() {
			@Override
			public CTActionTotal toEntityModel() {
				return _nullCTActionTotal;
			}
		};
}