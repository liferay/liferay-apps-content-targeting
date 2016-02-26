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

package com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalImpl;
import com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionTotalModelImpl;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionTotalPersistence;

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
 * The persistence implementation for the c t action total service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotalPersistence
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionTotalUtil
 * @generated
 */
@ProviderType
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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CTActionTotalImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CTActionTotalImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignId", new String[] { Long.class.getName() },
			CTActionTotalModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CTActionTotalModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the c t action totals where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching c t action totals
	 */
	@Override
	public List<CTActionTotal> findByCampaignId(long campaignId) {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t action totals where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @return the range of matching c t action totals
	 */
	@Override
	public List<CTActionTotal> findByCampaignId(long campaignId, int start,
		int end) {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t action totals where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c t action totals
	 */
	@Override
	public List<CTActionTotal> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator<CTActionTotal> orderByComparator) {
		return findByCampaignId(campaignId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the c t action totals where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching c t action totals
	 */
	@Override
	public List<CTActionTotal> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator<CTActionTotal> orderByComparator,
		boolean retrieveFromCache) {
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

		List<CTActionTotal> list = null;

		if (retrieveFromCache) {
			list = (List<CTActionTotal>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CTActionTotal ctActionTotal : list) {
					if ((campaignId != ctActionTotal.getCampaignId())) {
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

			query.append(_SQL_SELECT_CTACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

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

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c t action total in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action total
	 * @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	 */
	@Override
	public CTActionTotal findByCampaignId_First(long campaignId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws NoSuchCTActionTotalException {
		CTActionTotal ctActionTotal = fetchByCampaignId_First(campaignId,
				orderByComparator);

		if (ctActionTotal != null) {
			return ctActionTotal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionTotalException(msg.toString());
	}

	/**
	 * Returns the first c t action total in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action total, or <code>null</code> if a matching c t action total could not be found
	 */
	@Override
	public CTActionTotal fetchByCampaignId_First(long campaignId,
		OrderByComparator<CTActionTotal> orderByComparator) {
		List<CTActionTotal> list = findByCampaignId(campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c t action total in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action total
	 * @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	 */
	@Override
	public CTActionTotal findByCampaignId_Last(long campaignId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws NoSuchCTActionTotalException {
		CTActionTotal ctActionTotal = fetchByCampaignId_Last(campaignId,
				orderByComparator);

		if (ctActionTotal != null) {
			return ctActionTotal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionTotalException(msg.toString());
	}

	/**
	 * Returns the last c t action total in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action total, or <code>null</code> if a matching c t action total could not be found
	 */
	@Override
	public CTActionTotal fetchByCampaignId_Last(long campaignId,
		OrderByComparator<CTActionTotal> orderByComparator) {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<CTActionTotal> list = findByCampaignId(campaignId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c t action totals before and after the current c t action total in the ordered set where campaignId = &#63;.
	 *
	 * @param CTActionTotalId the primary key of the current c t action total
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c t action total
	 * @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 */
	@Override
	public CTActionTotal[] findByCampaignId_PrevAndNext(long CTActionTotalId,
		long campaignId, OrderByComparator<CTActionTotal> orderByComparator)
		throws NoSuchCTActionTotalException {
		CTActionTotal ctActionTotal = findByPrimaryKey(CTActionTotalId);

		Session session = null;

		try {
			session = openSession();

			CTActionTotal[] array = new CTActionTotalImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, ctActionTotal,
					campaignId, orderByComparator, true);

			array[1] = ctActionTotal;

			array[2] = getByCampaignId_PrevAndNext(session, ctActionTotal,
					campaignId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CTActionTotal getByCampaignId_PrevAndNext(Session session,
		CTActionTotal ctActionTotal, long campaignId,
		OrderByComparator<CTActionTotal> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CTACTIONTOTAL_WHERE);

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
			query.append(CTActionTotalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

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
	 * Removes all the c t action totals where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 */
	@Override
	public void removeByCampaignId(long campaignId) {
		for (CTActionTotal ctActionTotal : findByCampaignId(campaignId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ctActionTotal);
		}
	}

	/**
	 * Returns the number of c t action totals where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching c t action totals
	 */
	@Override
	public int countByCampaignId(long campaignId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNID;

		Object[] finderArgs = new Object[] { campaignId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CTACTIONTOTAL_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "ctActionTotal.campaignId = ?";
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
	 */
	@Override
	public List<CTActionTotal> findByReportInstanceId(long reportInstanceId) {
		return findByReportInstanceId(reportInstanceId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t action totals where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @return the range of matching c t action totals
	 */
	@Override
	public List<CTActionTotal> findByReportInstanceId(long reportInstanceId,
		int start, int end) {
		return findByReportInstanceId(reportInstanceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t action totals where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c t action totals
	 */
	@Override
	public List<CTActionTotal> findByReportInstanceId(long reportInstanceId,
		int start, int end, OrderByComparator<CTActionTotal> orderByComparator) {
		return findByReportInstanceId(reportInstanceId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the c t action totals where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching c t action totals
	 */
	@Override
	public List<CTActionTotal> findByReportInstanceId(long reportInstanceId,
		int start, int end, OrderByComparator<CTActionTotal> orderByComparator,
		boolean retrieveFromCache) {
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

		List<CTActionTotal> list = null;

		if (retrieveFromCache) {
			list = (List<CTActionTotal>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CTActionTotal ctActionTotal : list) {
					if ((reportInstanceId != ctActionTotal.getReportInstanceId())) {
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c t action total in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action total
	 * @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	 */
	@Override
	public CTActionTotal findByReportInstanceId_First(long reportInstanceId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws NoSuchCTActionTotalException {
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
	 */
	@Override
	public CTActionTotal fetchByReportInstanceId_First(long reportInstanceId,
		OrderByComparator<CTActionTotal> orderByComparator) {
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
	 * @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	 */
	@Override
	public CTActionTotal findByReportInstanceId_Last(long reportInstanceId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws NoSuchCTActionTotalException {
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
	 */
	@Override
	public CTActionTotal fetchByReportInstanceId_Last(long reportInstanceId,
		OrderByComparator<CTActionTotal> orderByComparator) {
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
	 * @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 */
	@Override
	public CTActionTotal[] findByReportInstanceId_PrevAndNext(
		long CTActionTotalId, long reportInstanceId,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws NoSuchCTActionTotalException {
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
		OrderByComparator<CTActionTotal> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
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
	 */
	@Override
	public void removeByReportInstanceId(long reportInstanceId) {
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
	 */
	@Override
	public int countByReportInstanceId(long reportInstanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPORTINSTANCEID;

		Object[] finderArgs = new Object[] { reportInstanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

	private static final String _FINDER_COLUMN_REPORTINSTANCEID_REPORTINSTANCEID_2 =
		"ctActionTotal.reportInstanceId = ?";
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
	 */
	@Override
	public List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate) {
		return findByR_GtD(reportInstanceId, modifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @return the range of matching c t action totals
	 */
	@Override
	public List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end) {
		return findByR_GtD(reportInstanceId, modifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c t action totals
	 */
	@Override
	public List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator) {
		return findByR_GtD(reportInstanceId, modifiedDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the c t action totals where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching c t action totals
	 */
	@Override
	public List<CTActionTotal> findByR_GtD(long reportInstanceId,
		Date modifiedDate, int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_GTD;
		finderArgs = new Object[] {
				reportInstanceId, modifiedDate,
				
				start, end, orderByComparator
			};

		List<CTActionTotal> list = null;

		if (retrieveFromCache) {
			list = (List<CTActionTotal>)finderCache.getResult(finderPath,
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
					qPos.add(new Timestamp(modifiedDate.getTime()));
				}

				if (!pagination) {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c t action total in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action total
	 * @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	 */
	@Override
	public CTActionTotal findByR_GtD_First(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTActionTotal> orderByComparator)
		throws NoSuchCTActionTotalException {
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
	 */
	@Override
	public CTActionTotal fetchByR_GtD_First(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTActionTotal> orderByComparator) {
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
	 * @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	 */
	@Override
	public CTActionTotal findByR_GtD_Last(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTActionTotal> orderByComparator)
		throws NoSuchCTActionTotalException {
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
	 */
	@Override
	public CTActionTotal fetchByR_GtD_Last(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTActionTotal> orderByComparator) {
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
	 * @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 */
	@Override
	public CTActionTotal[] findByR_GtD_PrevAndNext(long CTActionTotalId,
		long reportInstanceId, Date modifiedDate,
		OrderByComparator<CTActionTotal> orderByComparator)
		throws NoSuchCTActionTotalException {
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
		OrderByComparator<CTActionTotal> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
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
			qPos.add(new Timestamp(modifiedDate.getTime()));
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
	 */
	@Override
	public void removeByR_GtD(long reportInstanceId, Date modifiedDate) {
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
	 */
	@Override
	public int countByR_GtD(long reportInstanceId, Date modifiedDate) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_R_GTD;

		Object[] finderArgs = new Object[] { reportInstanceId, modifiedDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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
					qPos.add(new Timestamp(modifiedDate.getTime()));
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

	private static final String _FINDER_COLUMN_R_GTD_REPORTINSTANCEID_2 = "ctActionTotal.reportInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_R_GTD_MODIFIEDDATE_1 = "ctActionTotal.modifiedDate IS NULL";
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
	 * Returns the c t action total where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link NoSuchCTActionTotalException} if it could not be found.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching c t action total
	 * @throws NoSuchCTActionTotalException if a matching c t action total could not be found
	 */
	@Override
	public CTActionTotal findByR_R_R_E_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) throws NoSuchCTActionTotalException {
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
	 */
	@Override
	public CTActionTotal fetchByR_R_R_E_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) {
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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching c t action total, or <code>null</code> if a matching c t action total could not be found
	 */
	@Override
	public CTActionTotal fetchByR_R_R_E_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				reportInstanceId, referrerClassName, referrerClassPK, elementId,
				eventType
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_R_R_R_E_E,
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
					finderCache.putResult(FINDER_PATH_FETCH_BY_R_R_R_E_E,
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
						finderCache.putResult(FINDER_PATH_FETCH_BY_R_R_R_E_E,
							finderArgs, ctActionTotal);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_R_R_R_E_E,
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
	 */
	@Override
	public CTActionTotal removeByR_R_R_E_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) throws NoSuchCTActionTotalException {
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
	 */
	@Override
	public int countByR_R_R_E_E(long reportInstanceId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_R_R_E_E;

		Object[] finderArgs = new Object[] {
				reportInstanceId, referrerClassName, referrerClassPK, elementId,
				eventType
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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
		entityCache.putResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalImpl.class, ctActionTotal.getPrimaryKey(),
			ctActionTotal);

		finderCache.putResult(FINDER_PATH_FETCH_BY_R_R_R_E_E,
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
			if (entityCache.getResult(
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
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CTActionTotalImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the c t action total.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CTActionTotal ctActionTotal) {
		entityCache.removeResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalImpl.class, ctActionTotal.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CTActionTotalModelImpl)ctActionTotal);
	}

	@Override
	public void clearCache(List<CTActionTotal> ctActionTotals) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CTActionTotal ctActionTotal : ctActionTotals) {
			entityCache.removeResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
				CTActionTotalImpl.class, ctActionTotal.getPrimaryKey());

			clearUniqueFindersCache((CTActionTotalModelImpl)ctActionTotal);
		}
	}

	protected void cacheUniqueFindersCache(
		CTActionTotalModelImpl ctActionTotalModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					ctActionTotalModelImpl.getReportInstanceId(),
					ctActionTotalModelImpl.getReferrerClassName(),
					ctActionTotalModelImpl.getReferrerClassPK(),
					ctActionTotalModelImpl.getElementId(),
					ctActionTotalModelImpl.getEventType()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_R_R_R_E_E, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_R_R_R_E_E, args,
				ctActionTotalModelImpl);
		}
		else {
			if ((ctActionTotalModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_R_R_R_E_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ctActionTotalModelImpl.getReportInstanceId(),
						ctActionTotalModelImpl.getReferrerClassName(),
						ctActionTotalModelImpl.getReferrerClassPK(),
						ctActionTotalModelImpl.getElementId(),
						ctActionTotalModelImpl.getEventType()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_R_R_R_E_E, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_R_R_R_E_E, args,
					ctActionTotalModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CTActionTotalModelImpl ctActionTotalModelImpl) {
		Object[] args = new Object[] {
				ctActionTotalModelImpl.getReportInstanceId(),
				ctActionTotalModelImpl.getReferrerClassName(),
				ctActionTotalModelImpl.getReferrerClassPK(),
				ctActionTotalModelImpl.getElementId(),
				ctActionTotalModelImpl.getEventType()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_R_R_R_E_E, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_R_R_R_E_E, args);

		if ((ctActionTotalModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_R_R_R_E_E.getColumnBitmask()) != 0) {
			args = new Object[] {
					ctActionTotalModelImpl.getOriginalReportInstanceId(),
					ctActionTotalModelImpl.getOriginalReferrerClassName(),
					ctActionTotalModelImpl.getOriginalReferrerClassPK(),
					ctActionTotalModelImpl.getOriginalElementId(),
					ctActionTotalModelImpl.getOriginalEventType()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_R_R_R_E_E, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_R_R_R_E_E, args);
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

		ctActionTotal.setCompanyId(companyProvider.getCompanyId());

		return ctActionTotal;
	}

	/**
	 * Removes the c t action total with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CTActionTotalId the primary key of the c t action total
	 * @return the c t action total that was removed
	 * @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 */
	@Override
	public CTActionTotal remove(long CTActionTotalId)
		throws NoSuchCTActionTotalException {
		return remove((Serializable)CTActionTotalId);
	}

	/**
	 * Removes the c t action total with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the c t action total
	 * @return the c t action total that was removed
	 * @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 */
	@Override
	public CTActionTotal remove(Serializable primaryKey)
		throws NoSuchCTActionTotalException {
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
	protected CTActionTotal removeImpl(CTActionTotal ctActionTotal) {
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
	public CTActionTotal updateImpl(CTActionTotal ctActionTotal) {
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
				ctActionTotal = (CTActionTotal)session.merge(ctActionTotal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CTActionTotalModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ctActionTotalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ctActionTotalModelImpl.getOriginalCampaignId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { ctActionTotalModelImpl.getCampaignId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((ctActionTotalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ctActionTotalModelImpl.getOriginalReportInstanceId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REPORTINSTANCEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID,
					args);

				args = new Object[] { ctActionTotalModelImpl.getReportInstanceId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REPORTINSTANCEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID,
					args);
			}
		}

		entityCache.putResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CTActionTotalImpl.class, ctActionTotal.getPrimaryKey(),
			ctActionTotal, false);

		clearUniqueFindersCache(ctActionTotalModelImpl);
		cacheUniqueFindersCache(ctActionTotalModelImpl, isNew);

		ctActionTotal.resetOriginalValues();

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
	 * Returns the c t action total with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the c t action total
	 * @return the c t action total
	 * @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 */
	@Override
	public CTActionTotal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCTActionTotalException {
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
	 * Returns the c t action total with the primary key or throws a {@link NoSuchCTActionTotalException} if it could not be found.
	 *
	 * @param CTActionTotalId the primary key of the c t action total
	 * @return the c t action total
	 * @throws NoSuchCTActionTotalException if a c t action total with the primary key could not be found
	 */
	@Override
	public CTActionTotal findByPrimaryKey(long CTActionTotalId)
		throws NoSuchCTActionTotalException {
		return findByPrimaryKey((Serializable)CTActionTotalId);
	}

	/**
	 * Returns the c t action total with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the c t action total
	 * @return the c t action total, or <code>null</code> if a c t action total with the primary key could not be found
	 */
	@Override
	public CTActionTotal fetchByPrimaryKey(Serializable primaryKey) {
		CTActionTotal ctActionTotal = (CTActionTotal)entityCache.getResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
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
					entityCache.putResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
						CTActionTotalImpl.class, primaryKey, _nullCTActionTotal);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
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
	 */
	@Override
	public CTActionTotal fetchByPrimaryKey(long CTActionTotalId) {
		return fetchByPrimaryKey((Serializable)CTActionTotalId);
	}

	@Override
	public Map<Serializable, CTActionTotal> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CTActionTotal> map = new HashMap<Serializable, CTActionTotal>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CTActionTotal ctActionTotal = fetchByPrimaryKey(primaryKey);

			if (ctActionTotal != null) {
				map.put(primaryKey, ctActionTotal);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			CTActionTotal ctActionTotal = (CTActionTotal)entityCache.getResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
					CTActionTotalImpl.class, primaryKey);

			if (ctActionTotal == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, ctActionTotal);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CTACTIONTOTAL_WHERE_PKS_IN);

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

			for (CTActionTotal ctActionTotal : (List<CTActionTotal>)q.list()) {
				map.put(ctActionTotal.getPrimaryKeyObj(), ctActionTotal);

				cacheResult(ctActionTotal);

				uncachedPrimaryKeys.remove(ctActionTotal.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CTActionTotalModelImpl.ENTITY_CACHE_ENABLED,
					CTActionTotalImpl.class, primaryKey, _nullCTActionTotal);
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
	 * Returns all the c t action totals.
	 *
	 * @return the c t action totals
	 */
	@Override
	public List<CTActionTotal> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t action totals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @return the range of c t action totals
	 */
	@Override
	public List<CTActionTotal> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t action totals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of c t action totals
	 */
	@Override
	public List<CTActionTotal> findAll(int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the c t action totals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c t action totals
	 * @param end the upper bound of the range of c t action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of c t action totals
	 */
	@Override
	public List<CTActionTotal> findAll(int start, int end,
		OrderByComparator<CTActionTotal> orderByComparator,
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

		List<CTActionTotal> list = null;

		if (retrieveFromCache) {
			list = (List<CTActionTotal>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTActionTotal>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the c t action totals from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CTActionTotal ctActionTotal : findAll()) {
			remove(ctActionTotal);
		}
	}

	/**
	 * Returns the number of c t action totals.
	 *
	 * @return the number of c t action totals
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CTACTIONTOTAL);

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
		return CTActionTotalModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the c t action total persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CTActionTotalImpl.class.getName());
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
	private static final String _SQL_SELECT_CTACTIONTOTAL = "SELECT ctActionTotal FROM CTActionTotal ctActionTotal";
	private static final String _SQL_SELECT_CTACTIONTOTAL_WHERE_PKS_IN = "SELECT ctActionTotal FROM CTActionTotal ctActionTotal WHERE CTActionTotalId IN (";
	private static final String _SQL_SELECT_CTACTIONTOTAL_WHERE = "SELECT ctActionTotal FROM CTActionTotal ctActionTotal WHERE ";
	private static final String _SQL_COUNT_CTACTIONTOTAL = "SELECT COUNT(ctActionTotal) FROM CTActionTotal ctActionTotal";
	private static final String _SQL_COUNT_CTACTIONTOTAL_WHERE = "SELECT COUNT(ctActionTotal) FROM CTActionTotal ctActionTotal WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ctActionTotal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CTActionTotal exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CTActionTotal exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CTActionTotalPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"alias"
			});
	private static final CTActionTotal _nullCTActionTotal = new CTActionTotalImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CTActionTotal> toCacheModel() {
				return _nullCTActionTotalCacheModel;
			}
		};

	private static final CacheModel<CTActionTotal> _nullCTActionTotalCacheModel = new CacheModel<CTActionTotal>() {
			@Override
			public CTActionTotal toEntityModel() {
				return _nullCTActionTotal;
			}
		};
}