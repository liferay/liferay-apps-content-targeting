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

import com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalImpl;
import com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl;

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
 * The persistence implementation for the campaign tracking action total service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingActionTotalPersistence
 * @see CampaignTrackingActionTotalUtil
 * @generated
 */
public class CampaignTrackingActionTotalPersistenceImpl
	extends BasePersistenceImpl<CampaignTrackingActionTotal>
	implements CampaignTrackingActionTotalPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignTrackingActionTotalUtil} to access the campaign tracking action total persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignTrackingActionTotalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionTotalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionTotalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionTotalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionTotalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			CampaignTrackingActionTotalModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignTrackingActionTotalModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignId", new String[] { Long.class.getName() });

	/**
	 * Returns all the campaign tracking action totals where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingActionTotal> findByCampaignId(long campaignId)
		throws SystemException {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign tracking action totals where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign tracking action totals
	 * @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	 * @return the range of matching campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingActionTotal> findByCampaignId(long campaignId,
		int start, int end) throws SystemException {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign tracking action totals where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign tracking action totals
	 * @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingActionTotal> findByCampaignId(long campaignId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<CampaignTrackingActionTotal> list = (List<CampaignTrackingActionTotal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignTrackingActionTotal campaignTrackingActionTotal : list) {
				if ((campaignId != campaignTrackingActionTotal.getCampaignId())) {
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

			query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampaignTrackingActionTotalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<CampaignTrackingActionTotal>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignTrackingActionTotal>(list);
				}
				else {
					list = (List<CampaignTrackingActionTotal>)QueryUtil.list(q,
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
	 * Returns the first campaign tracking action total in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal findByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		CampaignTrackingActionTotal campaignTrackingActionTotal = fetchByCampaignId_First(campaignId,
				orderByComparator);

		if (campaignTrackingActionTotal != null) {
			return campaignTrackingActionTotal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionTotalException(msg.toString());
	}

	/**
	 * Returns the first campaign tracking action total in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal fetchByCampaignId_First(
		long campaignId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CampaignTrackingActionTotal> list = findByCampaignId(campaignId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign tracking action total in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal findByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		CampaignTrackingActionTotal campaignTrackingActionTotal = fetchByCampaignId_Last(campaignId,
				orderByComparator);

		if (campaignTrackingActionTotal != null) {
			return campaignTrackingActionTotal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionTotalException(msg.toString());
	}

	/**
	 * Returns the last campaign tracking action total in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal fetchByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<CampaignTrackingActionTotal> list = findByCampaignId(campaignId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign tracking action totals before and after the current campaign tracking action total in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignTrackingActionTotalId the primary key of the current campaign tracking action total
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign tracking action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a campaign tracking action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal[] findByCampaignId_PrevAndNext(
		long campaignTrackingActionTotalId, long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		CampaignTrackingActionTotal campaignTrackingActionTotal = findByPrimaryKey(campaignTrackingActionTotalId);

		Session session = null;

		try {
			session = openSession();

			CampaignTrackingActionTotal[] array = new CampaignTrackingActionTotalImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session,
					campaignTrackingActionTotal, campaignId, orderByComparator,
					true);

			array[1] = campaignTrackingActionTotal;

			array[2] = getByCampaignId_PrevAndNext(session,
					campaignTrackingActionTotal, campaignId, orderByComparator,
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

	protected CampaignTrackingActionTotal getByCampaignId_PrevAndNext(
		Session session,
		CampaignTrackingActionTotal campaignTrackingActionTotal,
		long campaignId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTIONTOTAL_WHERE);

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
			query.append(CampaignTrackingActionTotalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignTrackingActionTotal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignTrackingActionTotal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign tracking action totals where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long campaignId) throws SystemException {
		for (CampaignTrackingActionTotal campaignTrackingActionTotal : findByCampaignId(
				campaignId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(campaignTrackingActionTotal);
		}
	}

	/**
	 * Returns the number of campaign tracking action totals where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching campaign tracking action totals
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

			query.append(_SQL_COUNT_CAMPAIGNTRACKINGACTIONTOTAL_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "campaignTrackingActionTotal.campaignId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD = new FinderPath(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionTotalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_GtD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_GTD = new FinderPath(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_GtD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the campaign tracking action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @return the matching campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingActionTotal> findByC_GtD(long campaignId,
		Date modifiedDate) throws SystemException {
		return findByC_GtD(campaignId, modifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign tracking action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of campaign tracking action totals
	 * @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	 * @return the range of matching campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingActionTotal> findByC_GtD(long campaignId,
		Date modifiedDate, int start, int end) throws SystemException {
		return findByC_GtD(campaignId, modifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign tracking action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of campaign tracking action totals
	 * @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingActionTotal> findByC_GtD(long campaignId,
		Date modifiedDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD;
		finderArgs = new Object[] {
				campaignId, modifiedDate,
				
				start, end, orderByComparator
			};

		List<CampaignTrackingActionTotal> list = (List<CampaignTrackingActionTotal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignTrackingActionTotal campaignTrackingActionTotal : list) {
				if ((campaignId != campaignTrackingActionTotal.getCampaignId()) ||
						(modifiedDate.getTime() >= campaignTrackingActionTotal.getModifiedDate()
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

			query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_C_GTD_CAMPAIGNID_2);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_C_GTD_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_C_GTD_MODIFIEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampaignTrackingActionTotalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				if (!pagination) {
					list = (List<CampaignTrackingActionTotal>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignTrackingActionTotal>(list);
				}
				else {
					list = (List<CampaignTrackingActionTotal>)QueryUtil.list(q,
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
	 * Returns the first campaign tracking action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal findByC_GtD_First(long campaignId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		CampaignTrackingActionTotal campaignTrackingActionTotal = fetchByC_GtD_First(campaignId,
				modifiedDate, orderByComparator);

		if (campaignTrackingActionTotal != null) {
			return campaignTrackingActionTotal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionTotalException(msg.toString());
	}

	/**
	 * Returns the first campaign tracking action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal fetchByC_GtD_First(long campaignId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<CampaignTrackingActionTotal> list = findByC_GtD(campaignId,
				modifiedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign tracking action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal findByC_GtD_Last(long campaignId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		CampaignTrackingActionTotal campaignTrackingActionTotal = fetchByC_GtD_Last(campaignId,
				modifiedDate, orderByComparator);

		if (campaignTrackingActionTotal != null) {
			return campaignTrackingActionTotal;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionTotalException(msg.toString());
	}

	/**
	 * Returns the last campaign tracking action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal fetchByC_GtD_Last(long campaignId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_GtD(campaignId, modifiedDate);

		if (count == 0) {
			return null;
		}

		List<CampaignTrackingActionTotal> list = findByC_GtD(campaignId,
				modifiedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign tracking action totals before and after the current campaign tracking action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignTrackingActionTotalId the primary key of the current campaign tracking action total
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign tracking action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a campaign tracking action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal[] findByC_GtD_PrevAndNext(
		long campaignTrackingActionTotalId, long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		CampaignTrackingActionTotal campaignTrackingActionTotal = findByPrimaryKey(campaignTrackingActionTotalId);

		Session session = null;

		try {
			session = openSession();

			CampaignTrackingActionTotal[] array = new CampaignTrackingActionTotalImpl[3];

			array[0] = getByC_GtD_PrevAndNext(session,
					campaignTrackingActionTotal, campaignId, modifiedDate,
					orderByComparator, true);

			array[1] = campaignTrackingActionTotal;

			array[2] = getByC_GtD_PrevAndNext(session,
					campaignTrackingActionTotal, campaignId, modifiedDate,
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

	protected CampaignTrackingActionTotal getByC_GtD_PrevAndNext(
		Session session,
		CampaignTrackingActionTotal campaignTrackingActionTotal,
		long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTIONTOTAL_WHERE);

		query.append(_FINDER_COLUMN_C_GTD_CAMPAIGNID_2);

		boolean bindModifiedDate = false;

		if (modifiedDate == null) {
			query.append(_FINDER_COLUMN_C_GTD_MODIFIEDDATE_1);
		}
		else {
			bindModifiedDate = true;

			query.append(_FINDER_COLUMN_C_GTD_MODIFIEDDATE_2);
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
			query.append(CampaignTrackingActionTotalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (bindModifiedDate) {
			qPos.add(CalendarUtil.getTimestamp(modifiedDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignTrackingActionTotal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignTrackingActionTotal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign tracking action totals where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_GtD(long campaignId, Date modifiedDate)
		throws SystemException {
		for (CampaignTrackingActionTotal campaignTrackingActionTotal : findByC_GtD(
				campaignId, modifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(campaignTrackingActionTotal);
		}
	}

	/**
	 * Returns the number of campaign tracking action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @return the number of matching campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_GtD(long campaignId, Date modifiedDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_GTD;

		Object[] finderArgs = new Object[] { campaignId, modifiedDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CAMPAIGNTRACKINGACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_C_GTD_CAMPAIGNID_2);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_C_GTD_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_C_GTD_MODIFIEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

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

	private static final String _FINDER_COLUMN_C_GTD_CAMPAIGNID_2 = "campaignTrackingActionTotal.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_GTD_MODIFIEDDATE_1 = "campaignTrackingActionTotal.modifiedDate > NULL";
	private static final String _FINDER_COLUMN_C_GTD_MODIFIEDDATE_2 = "campaignTrackingActionTotal.modifiedDate > ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_R_R_E_E = new FinderPath(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionTotalImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_R_R_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			CampaignTrackingActionTotalModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignTrackingActionTotalModelImpl.REFERRERCLASSNAME_COLUMN_BITMASK |
			CampaignTrackingActionTotalModelImpl.REFERRERCLASSPK_COLUMN_BITMASK |
			CampaignTrackingActionTotalModelImpl.ELEMENTID_COLUMN_BITMASK |
			CampaignTrackingActionTotalModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R_R_E_E = new FinderPath(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByC_R_R_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the campaign tracking action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException} if it could not be found.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching campaign tracking action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal findByC_R_R_E_E(long campaignId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		CampaignTrackingActionTotal campaignTrackingActionTotal = fetchByC_R_R_E_E(campaignId,
				referrerClassName, referrerClassPK, elementId, eventType);

		if (campaignTrackingActionTotal == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

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

			throw new NoSuchCampaignTrackingActionTotalException(msg.toString());
		}

		return campaignTrackingActionTotal;
	}

	/**
	 * Returns the campaign tracking action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal fetchByC_R_R_E_E(long campaignId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) throws SystemException {
		return fetchByC_R_R_E_E(campaignId, referrerClassName, referrerClassPK,
			elementId, eventType, true);
	}

	/**
	 * Returns the campaign tracking action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal fetchByC_R_R_E_E(long campaignId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				campaignId, referrerClassName, referrerClassPK, elementId,
				eventType
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_R_R_E_E,
					finderArgs, this);
		}

		if (result instanceof CampaignTrackingActionTotal) {
			CampaignTrackingActionTotal campaignTrackingActionTotal = (CampaignTrackingActionTotal)result;

			if ((campaignId != campaignTrackingActionTotal.getCampaignId()) ||
					!Validator.equals(referrerClassName,
						campaignTrackingActionTotal.getReferrerClassName()) ||
					(referrerClassPK != campaignTrackingActionTotal.getReferrerClassPK()) ||
					!Validator.equals(elementId,
						campaignTrackingActionTotal.getElementId()) ||
					!Validator.equals(eventType,
						campaignTrackingActionTotal.getEventType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_C_R_R_E_E_CAMPAIGNID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSPK_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_C_R_R_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_R_R_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

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

				List<CampaignTrackingActionTotal> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_R_R_E_E,
						finderArgs, list);
				}
				else {
					CampaignTrackingActionTotal campaignTrackingActionTotal = list.get(0);

					result = campaignTrackingActionTotal;

					cacheResult(campaignTrackingActionTotal);

					if ((campaignTrackingActionTotal.getCampaignId() != campaignId) ||
							(campaignTrackingActionTotal.getReferrerClassName() == null) ||
							!campaignTrackingActionTotal.getReferrerClassName()
															.equals(referrerClassName) ||
							(campaignTrackingActionTotal.getReferrerClassPK() != referrerClassPK) ||
							(campaignTrackingActionTotal.getElementId() == null) ||
							!campaignTrackingActionTotal.getElementId()
															.equals(elementId) ||
							(campaignTrackingActionTotal.getEventType() == null) ||
							!campaignTrackingActionTotal.getEventType()
															.equals(eventType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_R_R_E_E,
							finderArgs, campaignTrackingActionTotal);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_R_R_E_E,
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
			return (CampaignTrackingActionTotal)result;
		}
	}

	/**
	 * Removes the campaign tracking action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the campaign tracking action total that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal removeByC_R_R_E_E(long campaignId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		CampaignTrackingActionTotal campaignTrackingActionTotal = findByC_R_R_E_E(campaignId,
				referrerClassName, referrerClassPK, elementId, eventType);

		return remove(campaignTrackingActionTotal);
	}

	/**
	 * Returns the number of campaign tracking action totals where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the number of matching campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_R_R_E_E(long campaignId, String referrerClassName,
		long referrerClassPK, String elementId, String eventType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_R_R_E_E;

		Object[] finderArgs = new Object[] {
				campaignId, referrerClassName, referrerClassPK, elementId,
				eventType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_CAMPAIGNTRACKINGACTIONTOTAL_WHERE);

			query.append(_FINDER_COLUMN_C_R_R_E_E_CAMPAIGNID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSPK_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_C_R_R_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_R_R_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

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

	private static final String _FINDER_COLUMN_C_R_R_E_E_CAMPAIGNID_2 = "campaignTrackingActionTotal.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSNAME_1 = "campaignTrackingActionTotal.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSNAME_2 = "campaignTrackingActionTotal.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSNAME_3 = "(campaignTrackingActionTotal.referrerClassName IS NULL OR campaignTrackingActionTotal.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_E_REFERRERCLASSPK_2 = "campaignTrackingActionTotal.referrerClassPK = ? AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_E_ELEMENTID_1 = "campaignTrackingActionTotal.elementId IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_E_ELEMENTID_2 = "campaignTrackingActionTotal.elementId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_E_ELEMENTID_3 = "(campaignTrackingActionTotal.elementId IS NULL OR campaignTrackingActionTotal.elementId = '') AND ";
	private static final String _FINDER_COLUMN_C_R_R_E_E_EVENTTYPE_1 = "campaignTrackingActionTotal.eventType IS NULL";
	private static final String _FINDER_COLUMN_C_R_R_E_E_EVENTTYPE_2 = "campaignTrackingActionTotal.eventType = ?";
	private static final String _FINDER_COLUMN_C_R_R_E_E_EVENTTYPE_3 = "(campaignTrackingActionTotal.eventType IS NULL OR campaignTrackingActionTotal.eventType = '')";

	public CampaignTrackingActionTotalPersistenceImpl() {
		setModelClass(CampaignTrackingActionTotal.class);
	}

	/**
	 * Caches the campaign tracking action total in the entity cache if it is enabled.
	 *
	 * @param campaignTrackingActionTotal the campaign tracking action total
	 */
	@Override
	public void cacheResult(
		CampaignTrackingActionTotal campaignTrackingActionTotal) {
		EntityCacheUtil.putResult(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalImpl.class,
			campaignTrackingActionTotal.getPrimaryKey(),
			campaignTrackingActionTotal);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_R_R_E_E,
			new Object[] {
				campaignTrackingActionTotal.getCampaignId(),
				campaignTrackingActionTotal.getReferrerClassName(),
				campaignTrackingActionTotal.getReferrerClassPK(),
				campaignTrackingActionTotal.getElementId(),
				campaignTrackingActionTotal.getEventType()
			}, campaignTrackingActionTotal);

		campaignTrackingActionTotal.resetOriginalValues();
	}

	/**
	 * Caches the campaign tracking action totals in the entity cache if it is enabled.
	 *
	 * @param campaignTrackingActionTotals the campaign tracking action totals
	 */
	@Override
	public void cacheResult(
		List<CampaignTrackingActionTotal> campaignTrackingActionTotals) {
		for (CampaignTrackingActionTotal campaignTrackingActionTotal : campaignTrackingActionTotals) {
			if (EntityCacheUtil.getResult(
						CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
						CampaignTrackingActionTotalImpl.class,
						campaignTrackingActionTotal.getPrimaryKey()) == null) {
				cacheResult(campaignTrackingActionTotal);
			}
			else {
				campaignTrackingActionTotal.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campaign tracking action totals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CampaignTrackingActionTotalImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CampaignTrackingActionTotalImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campaign tracking action total.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		CampaignTrackingActionTotal campaignTrackingActionTotal) {
		EntityCacheUtil.removeResult(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalImpl.class,
			campaignTrackingActionTotal.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(campaignTrackingActionTotal);
	}

	@Override
	public void clearCache(
		List<CampaignTrackingActionTotal> campaignTrackingActionTotals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CampaignTrackingActionTotal campaignTrackingActionTotal : campaignTrackingActionTotals) {
			EntityCacheUtil.removeResult(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
				CampaignTrackingActionTotalImpl.class,
				campaignTrackingActionTotal.getPrimaryKey());

			clearUniqueFindersCache(campaignTrackingActionTotal);
		}
	}

	protected void cacheUniqueFindersCache(
		CampaignTrackingActionTotal campaignTrackingActionTotal) {
		if (campaignTrackingActionTotal.isNew()) {
			Object[] args = new Object[] {
					campaignTrackingActionTotal.getCampaignId(),
					campaignTrackingActionTotal.getReferrerClassName(),
					campaignTrackingActionTotal.getReferrerClassPK(),
					campaignTrackingActionTotal.getElementId(),
					campaignTrackingActionTotal.getEventType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_R_R_E_E, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_R_R_E_E, args,
				campaignTrackingActionTotal);
		}
		else {
			CampaignTrackingActionTotalModelImpl campaignTrackingActionTotalModelImpl =
				(CampaignTrackingActionTotalModelImpl)campaignTrackingActionTotal;

			if ((campaignTrackingActionTotalModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_R_R_E_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignTrackingActionTotal.getCampaignId(),
						campaignTrackingActionTotal.getReferrerClassName(),
						campaignTrackingActionTotal.getReferrerClassPK(),
						campaignTrackingActionTotal.getElementId(),
						campaignTrackingActionTotal.getEventType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_R_R_E_E, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_R_R_E_E, args,
					campaignTrackingActionTotal);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CampaignTrackingActionTotal campaignTrackingActionTotal) {
		CampaignTrackingActionTotalModelImpl campaignTrackingActionTotalModelImpl =
			(CampaignTrackingActionTotalModelImpl)campaignTrackingActionTotal;

		Object[] args = new Object[] {
				campaignTrackingActionTotal.getCampaignId(),
				campaignTrackingActionTotal.getReferrerClassName(),
				campaignTrackingActionTotal.getReferrerClassPK(),
				campaignTrackingActionTotal.getElementId(),
				campaignTrackingActionTotal.getEventType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R_R_E_E, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_R_R_E_E, args);

		if ((campaignTrackingActionTotalModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_R_R_E_E.getColumnBitmask()) != 0) {
			args = new Object[] {
					campaignTrackingActionTotalModelImpl.getOriginalCampaignId(),
					campaignTrackingActionTotalModelImpl.getOriginalReferrerClassName(),
					campaignTrackingActionTotalModelImpl.getOriginalReferrerClassPK(),
					campaignTrackingActionTotalModelImpl.getOriginalElementId(),
					campaignTrackingActionTotalModelImpl.getOriginalEventType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R_R_E_E, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_R_R_E_E, args);
		}
	}

	/**
	 * Creates a new campaign tracking action total with the primary key. Does not add the campaign tracking action total to the database.
	 *
	 * @param campaignTrackingActionTotalId the primary key for the new campaign tracking action total
	 * @return the new campaign tracking action total
	 */
	@Override
	public CampaignTrackingActionTotal create(
		long campaignTrackingActionTotalId) {
		CampaignTrackingActionTotal campaignTrackingActionTotal = new CampaignTrackingActionTotalImpl();

		campaignTrackingActionTotal.setNew(true);
		campaignTrackingActionTotal.setPrimaryKey(campaignTrackingActionTotalId);

		return campaignTrackingActionTotal;
	}

	/**
	 * Removes the campaign tracking action total with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignTrackingActionTotalId the primary key of the campaign tracking action total
	 * @return the campaign tracking action total that was removed
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a campaign tracking action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal remove(
		long campaignTrackingActionTotalId)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		return remove((Serializable)campaignTrackingActionTotalId);
	}

	/**
	 * Removes the campaign tracking action total with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign tracking action total
	 * @return the campaign tracking action total that was removed
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a campaign tracking action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal remove(Serializable primaryKey)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CampaignTrackingActionTotal campaignTrackingActionTotal = (CampaignTrackingActionTotal)session.get(CampaignTrackingActionTotalImpl.class,
					primaryKey);

			if (campaignTrackingActionTotal == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignTrackingActionTotalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campaignTrackingActionTotal);
		}
		catch (NoSuchCampaignTrackingActionTotalException nsee) {
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
	protected CampaignTrackingActionTotal removeImpl(
		CampaignTrackingActionTotal campaignTrackingActionTotal)
		throws SystemException {
		campaignTrackingActionTotal = toUnwrappedModel(campaignTrackingActionTotal);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campaignTrackingActionTotal)) {
				campaignTrackingActionTotal = (CampaignTrackingActionTotal)session.get(CampaignTrackingActionTotalImpl.class,
						campaignTrackingActionTotal.getPrimaryKeyObj());
			}

			if (campaignTrackingActionTotal != null) {
				session.delete(campaignTrackingActionTotal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (campaignTrackingActionTotal != null) {
			clearCache(campaignTrackingActionTotal);
		}

		return campaignTrackingActionTotal;
	}

	@Override
	public CampaignTrackingActionTotal updateImpl(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal campaignTrackingActionTotal)
		throws SystemException {
		campaignTrackingActionTotal = toUnwrappedModel(campaignTrackingActionTotal);

		boolean isNew = campaignTrackingActionTotal.isNew();

		CampaignTrackingActionTotalModelImpl campaignTrackingActionTotalModelImpl =
			(CampaignTrackingActionTotalModelImpl)campaignTrackingActionTotal;

		Session session = null;

		try {
			session = openSession();

			if (campaignTrackingActionTotal.isNew()) {
				session.save(campaignTrackingActionTotal);

				campaignTrackingActionTotal.setNew(false);
			}
			else {
				session.merge(campaignTrackingActionTotal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!CampaignTrackingActionTotalModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((campaignTrackingActionTotalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignTrackingActionTotalModelImpl.getOriginalCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] {
						campaignTrackingActionTotalModelImpl.getCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}
		}

		EntityCacheUtil.putResult(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionTotalImpl.class,
			campaignTrackingActionTotal.getPrimaryKey(),
			campaignTrackingActionTotal);

		clearUniqueFindersCache(campaignTrackingActionTotal);
		cacheUniqueFindersCache(campaignTrackingActionTotal);

		return campaignTrackingActionTotal;
	}

	protected CampaignTrackingActionTotal toUnwrappedModel(
		CampaignTrackingActionTotal campaignTrackingActionTotal) {
		if (campaignTrackingActionTotal instanceof CampaignTrackingActionTotalImpl) {
			return campaignTrackingActionTotal;
		}

		CampaignTrackingActionTotalImpl campaignTrackingActionTotalImpl = new CampaignTrackingActionTotalImpl();

		campaignTrackingActionTotalImpl.setNew(campaignTrackingActionTotal.isNew());
		campaignTrackingActionTotalImpl.setPrimaryKey(campaignTrackingActionTotal.getPrimaryKey());

		campaignTrackingActionTotalImpl.setCampaignTrackingActionTotalId(campaignTrackingActionTotal.getCampaignTrackingActionTotalId());
		campaignTrackingActionTotalImpl.setCampaignId(campaignTrackingActionTotal.getCampaignId());
		campaignTrackingActionTotalImpl.setAlias(campaignTrackingActionTotal.getAlias());
		campaignTrackingActionTotalImpl.setReferrerClassName(campaignTrackingActionTotal.getReferrerClassName());
		campaignTrackingActionTotalImpl.setReferrerClassPK(campaignTrackingActionTotal.getReferrerClassPK());
		campaignTrackingActionTotalImpl.setElementId(campaignTrackingActionTotal.getElementId());
		campaignTrackingActionTotalImpl.setEventType(campaignTrackingActionTotal.getEventType());
		campaignTrackingActionTotalImpl.setCount(campaignTrackingActionTotal.getCount());
		campaignTrackingActionTotalImpl.setModifiedDate(campaignTrackingActionTotal.getModifiedDate());

		return campaignTrackingActionTotalImpl;
	}

	/**
	 * Returns the campaign tracking action total with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign tracking action total
	 * @return the campaign tracking action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a campaign tracking action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		CampaignTrackingActionTotal campaignTrackingActionTotal = fetchByPrimaryKey(primaryKey);

		if (campaignTrackingActionTotal == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignTrackingActionTotalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return campaignTrackingActionTotal;
	}

	/**
	 * Returns the campaign tracking action total with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException} if it could not be found.
	 *
	 * @param campaignTrackingActionTotalId the primary key of the campaign tracking action total
	 * @return the campaign tracking action total
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a campaign tracking action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal findByPrimaryKey(
		long campaignTrackingActionTotalId)
		throws NoSuchCampaignTrackingActionTotalException, SystemException {
		return findByPrimaryKey((Serializable)campaignTrackingActionTotalId);
	}

	/**
	 * Returns the campaign tracking action total with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign tracking action total
	 * @return the campaign tracking action total, or <code>null</code> if a campaign tracking action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		CampaignTrackingActionTotal campaignTrackingActionTotal = (CampaignTrackingActionTotal)EntityCacheUtil.getResult(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
				CampaignTrackingActionTotalImpl.class, primaryKey);

		if (campaignTrackingActionTotal == _nullCampaignTrackingActionTotal) {
			return null;
		}

		if (campaignTrackingActionTotal == null) {
			Session session = null;

			try {
				session = openSession();

				campaignTrackingActionTotal = (CampaignTrackingActionTotal)session.get(CampaignTrackingActionTotalImpl.class,
						primaryKey);

				if (campaignTrackingActionTotal != null) {
					cacheResult(campaignTrackingActionTotal);
				}
				else {
					EntityCacheUtil.putResult(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
						CampaignTrackingActionTotalImpl.class, primaryKey,
						_nullCampaignTrackingActionTotal);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CampaignTrackingActionTotalModelImpl.ENTITY_CACHE_ENABLED,
					CampaignTrackingActionTotalImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return campaignTrackingActionTotal;
	}

	/**
	 * Returns the campaign tracking action total with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignTrackingActionTotalId the primary key of the campaign tracking action total
	 * @return the campaign tracking action total, or <code>null</code> if a campaign tracking action total with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingActionTotal fetchByPrimaryKey(
		long campaignTrackingActionTotalId) throws SystemException {
		return fetchByPrimaryKey((Serializable)campaignTrackingActionTotalId);
	}

	/**
	 * Returns all the campaign tracking action totals.
	 *
	 * @return the campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingActionTotal> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign tracking action totals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign tracking action totals
	 * @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	 * @return the range of campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingActionTotal> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign tracking action totals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign tracking action totals
	 * @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaign tracking action totals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingActionTotal> findAll(int start, int end,
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

		List<CampaignTrackingActionTotal> list = (List<CampaignTrackingActionTotal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTIONTOTAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNTRACKINGACTIONTOTAL;

				if (pagination) {
					sql = sql.concat(CampaignTrackingActionTotalModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CampaignTrackingActionTotal>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignTrackingActionTotal>(list);
				}
				else {
					list = (List<CampaignTrackingActionTotal>)QueryUtil.list(q,
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
	 * Removes all the campaign tracking action totals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CampaignTrackingActionTotal campaignTrackingActionTotal : findAll()) {
			remove(campaignTrackingActionTotal);
		}
	}

	/**
	 * Returns the number of campaign tracking action totals.
	 *
	 * @return the number of campaign tracking action totals
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

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGNTRACKINGACTIONTOTAL);

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
	 * Initializes the campaign tracking action total persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CampaignTrackingActionTotal>> listenersList = new ArrayList<ModelListener<CampaignTrackingActionTotal>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CampaignTrackingActionTotal>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CampaignTrackingActionTotalImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CAMPAIGNTRACKINGACTIONTOTAL = "SELECT campaignTrackingActionTotal FROM CampaignTrackingActionTotal campaignTrackingActionTotal";
	private static final String _SQL_SELECT_CAMPAIGNTRACKINGACTIONTOTAL_WHERE = "SELECT campaignTrackingActionTotal FROM CampaignTrackingActionTotal campaignTrackingActionTotal WHERE ";
	private static final String _SQL_COUNT_CAMPAIGNTRACKINGACTIONTOTAL = "SELECT COUNT(campaignTrackingActionTotal) FROM CampaignTrackingActionTotal campaignTrackingActionTotal";
	private static final String _SQL_COUNT_CAMPAIGNTRACKINGACTIONTOTAL_WHERE = "SELECT COUNT(campaignTrackingActionTotal) FROM CampaignTrackingActionTotal campaignTrackingActionTotal WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignTrackingActionTotal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CampaignTrackingActionTotal exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CampaignTrackingActionTotal exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CampaignTrackingActionTotalPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"alias"
			});
	private static CampaignTrackingActionTotal _nullCampaignTrackingActionTotal = new CampaignTrackingActionTotalImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CampaignTrackingActionTotal> toCacheModel() {
				return _nullCampaignTrackingActionTotalCacheModel;
			}
		};

	private static CacheModel<CampaignTrackingActionTotal> _nullCampaignTrackingActionTotalCacheModel =
		new CacheModel<CampaignTrackingActionTotal>() {
			@Override
			public CampaignTrackingActionTotal toEntityModel() {
				return _nullCampaignTrackingActionTotal;
			}
		};
}