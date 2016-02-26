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

import com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;
import com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionImpl;
import com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionPersistence;

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
 * The persistence implementation for the c t action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionPersistence
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionUtil
 * @generated
 */
@ProviderType
public class CTActionPersistenceImpl extends BasePersistenceImpl<CTAction>
	implements CTActionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CTActionUtil} to access the c t action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CTActionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			CTActionModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CTActionModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the c t actions where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching c t actions
	 */
	@Override
	public List<CTAction> findByCampaignId(long campaignId) {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t actions where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @return the range of matching c t actions
	 */
	@Override
	public List<CTAction> findByCampaignId(long campaignId, int start, int end) {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t actions where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c t actions
	 */
	@Override
	public List<CTAction> findByCampaignId(long campaignId, int start, int end,
		OrderByComparator<CTAction> orderByComparator) {
		return findByCampaignId(campaignId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the c t actions where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching c t actions
	 */
	@Override
	public List<CTAction> findByCampaignId(long campaignId, int start, int end,
		OrderByComparator<CTAction> orderByComparator, boolean retrieveFromCache) {
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

		List<CTAction> list = null;

		if (retrieveFromCache) {
			list = (List<CTAction>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CTAction ctAction : list) {
					if ((campaignId != ctAction.getCampaignId())) {
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

			query.append(_SQL_SELECT_CTACTION_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CTActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c t action in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByCampaignId_First(long campaignId,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByCampaignId_First(campaignId,
				orderByComparator);

		if (ctAction != null) {
			return ctAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionException(msg.toString());
	}

	/**
	 * Returns the first c t action in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByCampaignId_First(long campaignId,
		OrderByComparator<CTAction> orderByComparator) {
		List<CTAction> list = findByCampaignId(campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c t action in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByCampaignId_Last(long campaignId,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByCampaignId_Last(campaignId, orderByComparator);

		if (ctAction != null) {
			return ctAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionException(msg.toString());
	}

	/**
	 * Returns the last c t action in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByCampaignId_Last(long campaignId,
		OrderByComparator<CTAction> orderByComparator) {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<CTAction> list = findByCampaignId(campaignId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c t actions before and after the current c t action in the ordered set where campaignId = &#63;.
	 *
	 * @param CTActionId the primary key of the current c t action
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c t action
	 * @throws NoSuchCTActionException if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction[] findByCampaignId_PrevAndNext(long CTActionId,
		long campaignId, OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = findByPrimaryKey(CTActionId);

		Session session = null;

		try {
			session = openSession();

			CTAction[] array = new CTActionImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, ctAction,
					campaignId, orderByComparator, true);

			array[1] = ctAction;

			array[2] = getByCampaignId_PrevAndNext(session, ctAction,
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

	protected CTAction getByCampaignId_PrevAndNext(Session session,
		CTAction ctAction, long campaignId,
		OrderByComparator<CTAction> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CTACTION_WHERE);

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
			query.append(CTActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ctAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CTAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the c t actions where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 */
	@Override
	public void removeByCampaignId(long campaignId) {
		for (CTAction ctAction : findByCampaignId(campaignId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ctAction);
		}
	}

	/**
	 * Returns the number of c t actions where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching c t actions
	 */
	@Override
	public int countByCampaignId(long campaignId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNID;

		Object[] finderArgs = new Object[] { campaignId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CTACTION_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "ctAction.campaignId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTINSTANCEID =
		new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReportInstanceId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID =
		new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByReportInstanceId", new String[] { Long.class.getName() },
			CTActionModelImpl.REPORTINSTANCEID_COLUMN_BITMASK |
			CTActionModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTINSTANCEID = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReportInstanceId", new String[] { Long.class.getName() });

	/**
	 * Returns all the c t actions where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @return the matching c t actions
	 */
	@Override
	public List<CTAction> findByReportInstanceId(long reportInstanceId) {
		return findByReportInstanceId(reportInstanceId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t actions where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @return the range of matching c t actions
	 */
	@Override
	public List<CTAction> findByReportInstanceId(long reportInstanceId,
		int start, int end) {
		return findByReportInstanceId(reportInstanceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t actions where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c t actions
	 */
	@Override
	public List<CTAction> findByReportInstanceId(long reportInstanceId,
		int start, int end, OrderByComparator<CTAction> orderByComparator) {
		return findByReportInstanceId(reportInstanceId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the c t actions where reportInstanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching c t actions
	 */
	@Override
	public List<CTAction> findByReportInstanceId(long reportInstanceId,
		int start, int end, OrderByComparator<CTAction> orderByComparator,
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

		List<CTAction> list = null;

		if (retrieveFromCache) {
			list = (List<CTAction>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CTAction ctAction : list) {
					if ((reportInstanceId != ctAction.getReportInstanceId())) {
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

			query.append(_SQL_SELECT_CTACTION_WHERE);

			query.append(_FINDER_COLUMN_REPORTINSTANCEID_REPORTINSTANCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CTActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (!pagination) {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c t action in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByReportInstanceId_First(long reportInstanceId,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByReportInstanceId_First(reportInstanceId,
				orderByComparator);

		if (ctAction != null) {
			return ctAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionException(msg.toString());
	}

	/**
	 * Returns the first c t action in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByReportInstanceId_First(long reportInstanceId,
		OrderByComparator<CTAction> orderByComparator) {
		List<CTAction> list = findByReportInstanceId(reportInstanceId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c t action in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByReportInstanceId_Last(long reportInstanceId,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByReportInstanceId_Last(reportInstanceId,
				orderByComparator);

		if (ctAction != null) {
			return ctAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionException(msg.toString());
	}

	/**
	 * Returns the last c t action in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByReportInstanceId_Last(long reportInstanceId,
		OrderByComparator<CTAction> orderByComparator) {
		int count = countByReportInstanceId(reportInstanceId);

		if (count == 0) {
			return null;
		}

		List<CTAction> list = findByReportInstanceId(reportInstanceId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c t actions before and after the current c t action in the ordered set where reportInstanceId = &#63;.
	 *
	 * @param CTActionId the primary key of the current c t action
	 * @param reportInstanceId the report instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c t action
	 * @throws NoSuchCTActionException if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction[] findByReportInstanceId_PrevAndNext(long CTActionId,
		long reportInstanceId, OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = findByPrimaryKey(CTActionId);

		Session session = null;

		try {
			session = openSession();

			CTAction[] array = new CTActionImpl[3];

			array[0] = getByReportInstanceId_PrevAndNext(session, ctAction,
					reportInstanceId, orderByComparator, true);

			array[1] = ctAction;

			array[2] = getByReportInstanceId_PrevAndNext(session, ctAction,
					reportInstanceId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CTAction getByReportInstanceId_PrevAndNext(Session session,
		CTAction ctAction, long reportInstanceId,
		OrderByComparator<CTAction> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CTACTION_WHERE);

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
			query.append(CTActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(reportInstanceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ctAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CTAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the c t actions where reportInstanceId = &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 */
	@Override
	public void removeByReportInstanceId(long reportInstanceId) {
		for (CTAction ctAction : findByReportInstanceId(reportInstanceId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ctAction);
		}
	}

	/**
	 * Returns the number of c t actions where reportInstanceId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @return the number of matching c t actions
	 */
	@Override
	public int countByReportInstanceId(long reportInstanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPORTINSTANCEID;

		Object[] finderArgs = new Object[] { reportInstanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CTACTION_WHERE);

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
		"ctAction.reportInstanceId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_E = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_E = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_E",
			new String[] { Long.class.getName(), String.class.getName() },
			CTActionModelImpl.REPORTINSTANCEID_COLUMN_BITMASK |
			CTActionModelImpl.ELEMENTID_COLUMN_BITMASK |
			CTActionModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_E = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_E",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the c t actions where reportInstanceId = &#63; and elementId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @return the matching c t actions
	 */
	@Override
	public List<CTAction> findByR_E(long reportInstanceId, String elementId) {
		return findByR_E(reportInstanceId, elementId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t actions where reportInstanceId = &#63; and elementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @return the range of matching c t actions
	 */
	@Override
	public List<CTAction> findByR_E(long reportInstanceId, String elementId,
		int start, int end) {
		return findByR_E(reportInstanceId, elementId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t actions where reportInstanceId = &#63; and elementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c t actions
	 */
	@Override
	public List<CTAction> findByR_E(long reportInstanceId, String elementId,
		int start, int end, OrderByComparator<CTAction> orderByComparator) {
		return findByR_E(reportInstanceId, elementId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the c t actions where reportInstanceId = &#63; and elementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching c t actions
	 */
	@Override
	public List<CTAction> findByR_E(long reportInstanceId, String elementId,
		int start, int end, OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_E;
			finderArgs = new Object[] { reportInstanceId, elementId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_E;
			finderArgs = new Object[] {
					reportInstanceId, elementId,
					
					start, end, orderByComparator
				};
		}

		List<CTAction> list = null;

		if (retrieveFromCache) {
			list = (List<CTAction>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CTAction ctAction : list) {
					if ((reportInstanceId != ctAction.getReportInstanceId()) ||
							!Validator.equals(elementId, ctAction.getElementId())) {
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

			query.append(_SQL_SELECT_CTACTION_WHERE);

			query.append(_FINDER_COLUMN_R_E_REPORTINSTANCEID_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_R_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_R_E_ELEMENTID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CTActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (!pagination) {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByR_E_First(long reportInstanceId, String elementId,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByR_E_First(reportInstanceId, elementId,
				orderByComparator);

		if (ctAction != null) {
			return ctAction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(", elementId=");
		msg.append(elementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionException(msg.toString());
	}

	/**
	 * Returns the first c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByR_E_First(long reportInstanceId, String elementId,
		OrderByComparator<CTAction> orderByComparator) {
		List<CTAction> list = findByR_E(reportInstanceId, elementId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByR_E_Last(long reportInstanceId, String elementId,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByR_E_Last(reportInstanceId, elementId,
				orderByComparator);

		if (ctAction != null) {
			return ctAction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(", elementId=");
		msg.append(elementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionException(msg.toString());
	}

	/**
	 * Returns the last c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByR_E_Last(long reportInstanceId, String elementId,
		OrderByComparator<CTAction> orderByComparator) {
		int count = countByR_E(reportInstanceId, elementId);

		if (count == 0) {
			return null;
		}

		List<CTAction> list = findByR_E(reportInstanceId, elementId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c t actions before and after the current c t action in the ordered set where reportInstanceId = &#63; and elementId = &#63;.
	 *
	 * @param CTActionId the primary key of the current c t action
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c t action
	 * @throws NoSuchCTActionException if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction[] findByR_E_PrevAndNext(long CTActionId,
		long reportInstanceId, String elementId,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = findByPrimaryKey(CTActionId);

		Session session = null;

		try {
			session = openSession();

			CTAction[] array = new CTActionImpl[3];

			array[0] = getByR_E_PrevAndNext(session, ctAction,
					reportInstanceId, elementId, orderByComparator, true);

			array[1] = ctAction;

			array[2] = getByR_E_PrevAndNext(session, ctAction,
					reportInstanceId, elementId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CTAction getByR_E_PrevAndNext(Session session, CTAction ctAction,
		long reportInstanceId, String elementId,
		OrderByComparator<CTAction> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CTACTION_WHERE);

		query.append(_FINDER_COLUMN_R_E_REPORTINSTANCEID_2);

		boolean bindElementId = false;

		if (elementId == null) {
			query.append(_FINDER_COLUMN_R_E_ELEMENTID_1);
		}
		else if (elementId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_R_E_ELEMENTID_3);
		}
		else {
			bindElementId = true;

			query.append(_FINDER_COLUMN_R_E_ELEMENTID_2);
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
			query.append(CTActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(reportInstanceId);

		if (bindElementId) {
			qPos.add(elementId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ctAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CTAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the c t actions where reportInstanceId = &#63; and elementId = &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 */
	@Override
	public void removeByR_E(long reportInstanceId, String elementId) {
		for (CTAction ctAction : findByR_E(reportInstanceId, elementId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ctAction);
		}
	}

	/**
	 * Returns the number of c t actions where reportInstanceId = &#63; and elementId = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param elementId the element ID
	 * @return the number of matching c t actions
	 */
	@Override
	public int countByR_E(long reportInstanceId, String elementId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_E;

		Object[] finderArgs = new Object[] { reportInstanceId, elementId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CTACTION_WHERE);

			query.append(_FINDER_COLUMN_R_E_REPORTINSTANCEID_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_R_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_R_E_ELEMENTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				if (bindElementId) {
					qPos.add(elementId);
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

	private static final String _FINDER_COLUMN_R_E_REPORTINSTANCEID_2 = "ctAction.reportInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_R_E_ELEMENTID_1 = "ctAction.elementId IS NULL";
	private static final String _FINDER_COLUMN_R_E_ELEMENTID_2 = "ctAction.elementId = ?";
	private static final String _FINDER_COLUMN_R_E_ELEMENTID_3 = "(ctAction.elementId IS NULL OR ctAction.elementId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_GTD = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_GtD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_R_GTD = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByR_GtD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @return the matching c t actions
	 */
	@Override
	public List<CTAction> findByR_GtD(long reportInstanceId, Date modifiedDate) {
		return findByR_GtD(reportInstanceId, modifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @return the range of matching c t actions
	 */
	@Override
	public List<CTAction> findByR_GtD(long reportInstanceId, Date modifiedDate,
		int start, int end) {
		return findByR_GtD(reportInstanceId, modifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c t actions
	 */
	@Override
	public List<CTAction> findByR_GtD(long reportInstanceId, Date modifiedDate,
		int start, int end, OrderByComparator<CTAction> orderByComparator) {
		return findByR_GtD(reportInstanceId, modifiedDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching c t actions
	 */
	@Override
	public List<CTAction> findByR_GtD(long reportInstanceId, Date modifiedDate,
		int start, int end, OrderByComparator<CTAction> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_GTD;
		finderArgs = new Object[] {
				reportInstanceId, modifiedDate,
				
				start, end, orderByComparator
			};

		List<CTAction> list = null;

		if (retrieveFromCache) {
			list = (List<CTAction>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CTAction ctAction : list) {
					if ((reportInstanceId != ctAction.getReportInstanceId()) ||
							(modifiedDate.getTime() >= ctAction.getModifiedDate()
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

			query.append(_SQL_SELECT_CTACTION_WHERE);

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
				query.append(CTActionModelImpl.ORDER_BY_JPQL);
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
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByR_GtD_First(long reportInstanceId, Date modifiedDate,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByR_GtD_First(reportInstanceId, modifiedDate,
				orderByComparator);

		if (ctAction != null) {
			return ctAction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionException(msg.toString());
	}

	/**
	 * Returns the first c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByR_GtD_First(long reportInstanceId,
		Date modifiedDate, OrderByComparator<CTAction> orderByComparator) {
		List<CTAction> list = findByR_GtD(reportInstanceId, modifiedDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByR_GtD_Last(long reportInstanceId, Date modifiedDate,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByR_GtD_Last(reportInstanceId, modifiedDate,
				orderByComparator);

		if (ctAction != null) {
			return ctAction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionException(msg.toString());
	}

	/**
	 * Returns the last c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByR_GtD_Last(long reportInstanceId, Date modifiedDate,
		OrderByComparator<CTAction> orderByComparator) {
		int count = countByR_GtD(reportInstanceId, modifiedDate);

		if (count == 0) {
			return null;
		}

		List<CTAction> list = findByR_GtD(reportInstanceId, modifiedDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c t actions before and after the current c t action in the ordered set where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param CTActionId the primary key of the current c t action
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c t action
	 * @throws NoSuchCTActionException if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction[] findByR_GtD_PrevAndNext(long CTActionId,
		long reportInstanceId, Date modifiedDate,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = findByPrimaryKey(CTActionId);

		Session session = null;

		try {
			session = openSession();

			CTAction[] array = new CTActionImpl[3];

			array[0] = getByR_GtD_PrevAndNext(session, ctAction,
					reportInstanceId, modifiedDate, orderByComparator, true);

			array[1] = ctAction;

			array[2] = getByR_GtD_PrevAndNext(session, ctAction,
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

	protected CTAction getByR_GtD_PrevAndNext(Session session,
		CTAction ctAction, long reportInstanceId, Date modifiedDate,
		OrderByComparator<CTAction> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CTACTION_WHERE);

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
			query.append(CTActionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ctAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CTAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 */
	@Override
	public void removeByR_GtD(long reportInstanceId, Date modifiedDate) {
		for (CTAction ctAction : findByR_GtD(reportInstanceId, modifiedDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ctAction);
		}
	}

	/**
	 * Returns the number of c t actions where reportInstanceId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param modifiedDate the modified date
	 * @return the number of matching c t actions
	 */
	@Override
	public int countByR_GtD(long reportInstanceId, Date modifiedDate) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_R_GTD;

		Object[] finderArgs = new Object[] { reportInstanceId, modifiedDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CTACTION_WHERE);

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

	private static final String _FINDER_COLUMN_R_GTD_REPORTINSTANCEID_2 = "ctAction.reportInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_R_GTD_MODIFIEDDATE_1 = "ctAction.modifiedDate IS NULL";
	private static final String _FINDER_COLUMN_R_GTD_MODIFIEDDATE_2 = "ctAction.modifiedDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_R_R = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_R_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R_R = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_R_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			CTActionModelImpl.REPORTINSTANCEID_COLUMN_BITMASK |
			CTActionModelImpl.REFERRERCLASSNAME_COLUMN_BITMASK |
			CTActionModelImpl.REFERRERCLASSPK_COLUMN_BITMASK |
			CTActionModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_R_R = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_R_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @return the matching c t actions
	 */
	@Override
	public List<CTAction> findByR_R_R(long reportInstanceId,
		String referrerClassName, long referrerClassPK) {
		return findByR_R_R(reportInstanceId, referrerClassName,
			referrerClassPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @return the range of matching c t actions
	 */
	@Override
	public List<CTAction> findByR_R_R(long reportInstanceId,
		String referrerClassName, long referrerClassPK, int start, int end) {
		return findByR_R_R(reportInstanceId, referrerClassName,
			referrerClassPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching c t actions
	 */
	@Override
	public List<CTAction> findByR_R_R(long reportInstanceId,
		String referrerClassName, long referrerClassPK, int start, int end,
		OrderByComparator<CTAction> orderByComparator) {
		return findByR_R_R(reportInstanceId, referrerClassName,
			referrerClassPK, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching c t actions
	 */
	@Override
	public List<CTAction> findByR_R_R(long reportInstanceId,
		String referrerClassName, long referrerClassPK, int start, int end,
		OrderByComparator<CTAction> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R_R;
			finderArgs = new Object[] {
					reportInstanceId, referrerClassName, referrerClassPK
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_R_R;
			finderArgs = new Object[] {
					reportInstanceId, referrerClassName, referrerClassPK,
					
					start, end, orderByComparator
				};
		}

		List<CTAction> list = null;

		if (retrieveFromCache) {
			list = (List<CTAction>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CTAction ctAction : list) {
					if ((reportInstanceId != ctAction.getReportInstanceId()) ||
							!Validator.equals(referrerClassName,
								ctAction.getReferrerClassName()) ||
							(referrerClassPK != ctAction.getReferrerClassPK())) {
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

			query.append(_SQL_SELECT_CTACTION_WHERE);

			query.append(_FINDER_COLUMN_R_R_R_REPORTINSTANCEID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CTActionModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByR_R_R_First(long reportInstanceId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByR_R_R_First(reportInstanceId,
				referrerClassName, referrerClassPK, orderByComparator);

		if (ctAction != null) {
			return ctAction;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(", referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionException(msg.toString());
	}

	/**
	 * Returns the first c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByR_R_R_First(long reportInstanceId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<CTAction> orderByComparator) {
		List<CTAction> list = findByR_R_R(reportInstanceId, referrerClassName,
				referrerClassPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByR_R_R_Last(long reportInstanceId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByR_R_R_Last(reportInstanceId,
				referrerClassName, referrerClassPK, orderByComparator);

		if (ctAction != null) {
			return ctAction;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportInstanceId=");
		msg.append(reportInstanceId);

		msg.append(", referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCTActionException(msg.toString());
	}

	/**
	 * Returns the last c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByR_R_R_Last(long reportInstanceId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator<CTAction> orderByComparator) {
		int count = countByR_R_R(reportInstanceId, referrerClassName,
				referrerClassPK);

		if (count == 0) {
			return null;
		}

		List<CTAction> list = findByR_R_R(reportInstanceId, referrerClassName,
				referrerClassPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the c t actions before and after the current c t action in the ordered set where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param CTActionId the primary key of the current c t action
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next c t action
	 * @throws NoSuchCTActionException if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction[] findByR_R_R_PrevAndNext(long CTActionId,
		long reportInstanceId, String referrerClassName, long referrerClassPK,
		OrderByComparator<CTAction> orderByComparator)
		throws NoSuchCTActionException {
		CTAction ctAction = findByPrimaryKey(CTActionId);

		Session session = null;

		try {
			session = openSession();

			CTAction[] array = new CTActionImpl[3];

			array[0] = getByR_R_R_PrevAndNext(session, ctAction,
					reportInstanceId, referrerClassName, referrerClassPK,
					orderByComparator, true);

			array[1] = ctAction;

			array[2] = getByR_R_R_PrevAndNext(session, ctAction,
					reportInstanceId, referrerClassName, referrerClassPK,
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

	protected CTAction getByR_R_R_PrevAndNext(Session session,
		CTAction ctAction, long reportInstanceId, String referrerClassName,
		long referrerClassPK, OrderByComparator<CTAction> orderByComparator,
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

		query.append(_SQL_SELECT_CTACTION_WHERE);

		query.append(_FINDER_COLUMN_R_R_R_REPORTINSTANCEID_2);

		boolean bindReferrerClassName = false;

		if (referrerClassName == null) {
			query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_1);
		}
		else if (referrerClassName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_3);
		}
		else {
			bindReferrerClassName = true;

			query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSPK_2);

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
			query.append(CTActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(reportInstanceId);

		if (bindReferrerClassName) {
			qPos.add(referrerClassName);
		}

		qPos.add(referrerClassPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ctAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CTAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 */
	@Override
	public void removeByR_R_R(long reportInstanceId, String referrerClassName,
		long referrerClassPK) {
		for (CTAction ctAction : findByR_R_R(reportInstanceId,
				referrerClassName, referrerClassPK, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ctAction);
		}
	}

	/**
	 * Returns the number of c t actions where reportInstanceId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @return the number of matching c t actions
	 */
	@Override
	public int countByR_R_R(long reportInstanceId, String referrerClassName,
		long referrerClassPK) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_R_R;

		Object[] finderArgs = new Object[] {
				reportInstanceId, referrerClassName, referrerClassPK
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CTACTION_WHERE);

			query.append(_FINDER_COLUMN_R_R_R_REPORTINSTANCEID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_R_R_REFERRERCLASSPK_2);

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

	private static final String _FINDER_COLUMN_R_R_R_REPORTINSTANCEID_2 = "ctAction.reportInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_1 = "ctAction.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_2 = "ctAction.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_R_R_R_REFERRERCLASSNAME_3 = "(ctAction.referrerClassName IS NULL OR ctAction.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_R_R_R_REFERRERCLASSPK_2 = "ctAction.referrerClassPK = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_R_U_R_R_E_E = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, CTActionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByR_U_R_R_E_E",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			CTActionModelImpl.REPORTINSTANCEID_COLUMN_BITMASK |
			CTActionModelImpl.USERSEGMENTID_COLUMN_BITMASK |
			CTActionModelImpl.REFERRERCLASSNAME_COLUMN_BITMASK |
			CTActionModelImpl.REFERRERCLASSPK_COLUMN_BITMASK |
			CTActionModelImpl.ELEMENTID_COLUMN_BITMASK |
			CTActionModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_U_R_R_E_E = new FinderPath(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_U_R_R_E_E",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns the c t action where reportInstanceId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link NoSuchCTActionException} if it could not be found.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param userSegmentId the user segment ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching c t action
	 * @throws NoSuchCTActionException if a matching c t action could not be found
	 */
	@Override
	public CTAction findByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, String referrerClassName, long referrerClassPK,
		String elementId, String eventType) throws NoSuchCTActionException {
		CTAction ctAction = fetchByR_U_R_R_E_E(reportInstanceId, userSegmentId,
				referrerClassName, referrerClassPK, elementId, eventType);

		if (ctAction == null) {
			StringBundler msg = new StringBundler(14);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("reportInstanceId=");
			msg.append(reportInstanceId);

			msg.append(", userSegmentId=");
			msg.append(userSegmentId);

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

			throw new NoSuchCTActionException(msg.toString());
		}

		return ctAction;
	}

	/**
	 * Returns the c t action where reportInstanceId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param userSegmentId the user segment ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, String referrerClassName, long referrerClassPK,
		String elementId, String eventType) {
		return fetchByR_U_R_R_E_E(reportInstanceId, userSegmentId,
			referrerClassName, referrerClassPK, elementId, eventType, true);
	}

	/**
	 * Returns the c t action where reportInstanceId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param userSegmentId the user segment ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching c t action, or <code>null</code> if a matching c t action could not be found
	 */
	@Override
	public CTAction fetchByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, String referrerClassName, long referrerClassPK,
		String elementId, String eventType, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				reportInstanceId, userSegmentId, referrerClassName,
				referrerClassPK, elementId, eventType
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_R_U_R_R_E_E,
					finderArgs, this);
		}

		if (result instanceof CTAction) {
			CTAction ctAction = (CTAction)result;

			if ((reportInstanceId != ctAction.getReportInstanceId()) ||
					(userSegmentId != ctAction.getUserSegmentId()) ||
					!Validator.equals(referrerClassName,
						ctAction.getReferrerClassName()) ||
					(referrerClassPK != ctAction.getReferrerClassPK()) ||
					!Validator.equals(elementId, ctAction.getElementId()) ||
					!Validator.equals(eventType, ctAction.getEventType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(8);

			query.append(_SQL_SELECT_CTACTION_WHERE);

			query.append(_FINDER_COLUMN_R_U_R_R_E_E_REPORTINSTANCEID_2);

			query.append(_FINDER_COLUMN_R_U_R_R_E_E_USERSEGMENTID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSPK_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_R_U_R_R_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_R_U_R_R_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				qPos.add(userSegmentId);

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

				List<CTAction> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_R_U_R_R_E_E,
						finderArgs, list);
				}
				else {
					CTAction ctAction = list.get(0);

					result = ctAction;

					cacheResult(ctAction);

					if ((ctAction.getReportInstanceId() != reportInstanceId) ||
							(ctAction.getUserSegmentId() != userSegmentId) ||
							(ctAction.getReferrerClassName() == null) ||
							!ctAction.getReferrerClassName()
										 .equals(referrerClassName) ||
							(ctAction.getReferrerClassPK() != referrerClassPK) ||
							(ctAction.getElementId() == null) ||
							!ctAction.getElementId().equals(elementId) ||
							(ctAction.getEventType() == null) ||
							!ctAction.getEventType().equals(eventType)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_R_U_R_R_E_E,
							finderArgs, ctAction);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_R_U_R_R_E_E,
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
			return (CTAction)result;
		}
	}

	/**
	 * Removes the c t action where reportInstanceId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; from the database.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param userSegmentId the user segment ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the c t action that was removed
	 */
	@Override
	public CTAction removeByR_U_R_R_E_E(long reportInstanceId,
		long userSegmentId, String referrerClassName, long referrerClassPK,
		String elementId, String eventType) throws NoSuchCTActionException {
		CTAction ctAction = findByR_U_R_R_E_E(reportInstanceId, userSegmentId,
				referrerClassName, referrerClassPK, elementId, eventType);

		return remove(ctAction);
	}

	/**
	 * Returns the number of c t actions where reportInstanceId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param reportInstanceId the report instance ID
	 * @param userSegmentId the user segment ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the number of matching c t actions
	 */
	@Override
	public int countByR_U_R_R_E_E(long reportInstanceId, long userSegmentId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_U_R_R_E_E;

		Object[] finderArgs = new Object[] {
				reportInstanceId, userSegmentId, referrerClassName,
				referrerClassPK, elementId, eventType
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_CTACTION_WHERE);

			query.append(_FINDER_COLUMN_R_U_R_R_E_E_REPORTINSTANCEID_2);

			query.append(_FINDER_COLUMN_R_U_R_R_E_E_USERSEGMENTID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSPK_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_R_U_R_R_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_U_R_R_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_R_U_R_R_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportInstanceId);

				qPos.add(userSegmentId);

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

	private static final String _FINDER_COLUMN_R_U_R_R_E_E_REPORTINSTANCEID_2 = "ctAction.reportInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_USERSEGMENTID_2 = "ctAction.userSegmentId = ? AND ";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSNAME_1 = "ctAction.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSNAME_2 = "ctAction.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSNAME_3 = "(ctAction.referrerClassName IS NULL OR ctAction.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_REFERRERCLASSPK_2 = "ctAction.referrerClassPK = ? AND ";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_ELEMENTID_1 = "ctAction.elementId IS NULL AND ";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_ELEMENTID_2 = "ctAction.elementId = ? AND ";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_ELEMENTID_3 = "(ctAction.elementId IS NULL OR ctAction.elementId = '') AND ";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_EVENTTYPE_1 = "ctAction.eventType IS NULL";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_EVENTTYPE_2 = "ctAction.eventType = ?";
	private static final String _FINDER_COLUMN_R_U_R_R_E_E_EVENTTYPE_3 = "(ctAction.eventType IS NULL OR ctAction.eventType = '')";

	public CTActionPersistenceImpl() {
		setModelClass(CTAction.class);
	}

	/**
	 * Caches the c t action in the entity cache if it is enabled.
	 *
	 * @param ctAction the c t action
	 */
	@Override
	public void cacheResult(CTAction ctAction) {
		entityCache.putResult(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionImpl.class, ctAction.getPrimaryKey(), ctAction);

		finderCache.putResult(FINDER_PATH_FETCH_BY_R_U_R_R_E_E,
			new Object[] {
				ctAction.getReportInstanceId(), ctAction.getUserSegmentId(),
				ctAction.getReferrerClassName(), ctAction.getReferrerClassPK(),
				ctAction.getElementId(), ctAction.getEventType()
			}, ctAction);

		ctAction.resetOriginalValues();
	}

	/**
	 * Caches the c t actions in the entity cache if it is enabled.
	 *
	 * @param ctActions the c t actions
	 */
	@Override
	public void cacheResult(List<CTAction> ctActions) {
		for (CTAction ctAction : ctActions) {
			if (entityCache.getResult(CTActionModelImpl.ENTITY_CACHE_ENABLED,
						CTActionImpl.class, ctAction.getPrimaryKey()) == null) {
				cacheResult(ctAction);
			}
			else {
				ctAction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all c t actions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CTActionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the c t action.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CTAction ctAction) {
		entityCache.removeResult(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionImpl.class, ctAction.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CTActionModelImpl)ctAction);
	}

	@Override
	public void clearCache(List<CTAction> ctActions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CTAction ctAction : ctActions) {
			entityCache.removeResult(CTActionModelImpl.ENTITY_CACHE_ENABLED,
				CTActionImpl.class, ctAction.getPrimaryKey());

			clearUniqueFindersCache((CTActionModelImpl)ctAction);
		}
	}

	protected void cacheUniqueFindersCache(
		CTActionModelImpl ctActionModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					ctActionModelImpl.getReportInstanceId(),
					ctActionModelImpl.getUserSegmentId(),
					ctActionModelImpl.getReferrerClassName(),
					ctActionModelImpl.getReferrerClassPK(),
					ctActionModelImpl.getElementId(),
					ctActionModelImpl.getEventType()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_R_U_R_R_E_E, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_R_U_R_R_E_E, args,
				ctActionModelImpl);
		}
		else {
			if ((ctActionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_R_U_R_R_E_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ctActionModelImpl.getReportInstanceId(),
						ctActionModelImpl.getUserSegmentId(),
						ctActionModelImpl.getReferrerClassName(),
						ctActionModelImpl.getReferrerClassPK(),
						ctActionModelImpl.getElementId(),
						ctActionModelImpl.getEventType()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_R_U_R_R_E_E, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_R_U_R_R_E_E, args,
					ctActionModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(CTActionModelImpl ctActionModelImpl) {
		Object[] args = new Object[] {
				ctActionModelImpl.getReportInstanceId(),
				ctActionModelImpl.getUserSegmentId(),
				ctActionModelImpl.getReferrerClassName(),
				ctActionModelImpl.getReferrerClassPK(),
				ctActionModelImpl.getElementId(),
				ctActionModelImpl.getEventType()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_R_U_R_R_E_E, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_R_U_R_R_E_E, args);

		if ((ctActionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_R_U_R_R_E_E.getColumnBitmask()) != 0) {
			args = new Object[] {
					ctActionModelImpl.getOriginalReportInstanceId(),
					ctActionModelImpl.getOriginalUserSegmentId(),
					ctActionModelImpl.getOriginalReferrerClassName(),
					ctActionModelImpl.getOriginalReferrerClassPK(),
					ctActionModelImpl.getOriginalElementId(),
					ctActionModelImpl.getOriginalEventType()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_R_U_R_R_E_E, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_R_U_R_R_E_E, args);
		}
	}

	/**
	 * Creates a new c t action with the primary key. Does not add the c t action to the database.
	 *
	 * @param CTActionId the primary key for the new c t action
	 * @return the new c t action
	 */
	@Override
	public CTAction create(long CTActionId) {
		CTAction ctAction = new CTActionImpl();

		ctAction.setNew(true);
		ctAction.setPrimaryKey(CTActionId);

		ctAction.setCompanyId(companyProvider.getCompanyId());

		return ctAction;
	}

	/**
	 * Removes the c t action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CTActionId the primary key of the c t action
	 * @return the c t action that was removed
	 * @throws NoSuchCTActionException if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction remove(long CTActionId) throws NoSuchCTActionException {
		return remove((Serializable)CTActionId);
	}

	/**
	 * Removes the c t action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the c t action
	 * @return the c t action that was removed
	 * @throws NoSuchCTActionException if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction remove(Serializable primaryKey)
		throws NoSuchCTActionException {
		Session session = null;

		try {
			session = openSession();

			CTAction ctAction = (CTAction)session.get(CTActionImpl.class,
					primaryKey);

			if (ctAction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCTActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ctAction);
		}
		catch (NoSuchCTActionException nsee) {
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
	protected CTAction removeImpl(CTAction ctAction) {
		ctAction = toUnwrappedModel(ctAction);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ctAction)) {
				ctAction = (CTAction)session.get(CTActionImpl.class,
						ctAction.getPrimaryKeyObj());
			}

			if (ctAction != null) {
				session.delete(ctAction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ctAction != null) {
			clearCache(ctAction);
		}

		return ctAction;
	}

	@Override
	public CTAction updateImpl(CTAction ctAction) {
		ctAction = toUnwrappedModel(ctAction);

		boolean isNew = ctAction.isNew();

		CTActionModelImpl ctActionModelImpl = (CTActionModelImpl)ctAction;

		Session session = null;

		try {
			session = openSession();

			if (ctAction.isNew()) {
				session.save(ctAction);

				ctAction.setNew(false);
			}
			else {
				ctAction = (CTAction)session.merge(ctAction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CTActionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ctActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ctActionModelImpl.getOriginalCampaignId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { ctActionModelImpl.getCampaignId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((ctActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ctActionModelImpl.getOriginalReportInstanceId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REPORTINSTANCEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID,
					args);

				args = new Object[] { ctActionModelImpl.getReportInstanceId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REPORTINSTANCEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTINSTANCEID,
					args);
			}

			if ((ctActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ctActionModelImpl.getOriginalReportInstanceId(),
						ctActionModelImpl.getOriginalElementId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_E,
					args);

				args = new Object[] {
						ctActionModelImpl.getReportInstanceId(),
						ctActionModelImpl.getElementId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_E,
					args);
			}

			if ((ctActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ctActionModelImpl.getOriginalReportInstanceId(),
						ctActionModelImpl.getOriginalReferrerClassName(),
						ctActionModelImpl.getOriginalReferrerClassPK()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_R_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R_R,
					args);

				args = new Object[] {
						ctActionModelImpl.getReportInstanceId(),
						ctActionModelImpl.getReferrerClassName(),
						ctActionModelImpl.getReferrerClassPK()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_R_R_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_R_R,
					args);
			}
		}

		entityCache.putResult(CTActionModelImpl.ENTITY_CACHE_ENABLED,
			CTActionImpl.class, ctAction.getPrimaryKey(), ctAction, false);

		clearUniqueFindersCache(ctActionModelImpl);
		cacheUniqueFindersCache(ctActionModelImpl, isNew);

		ctAction.resetOriginalValues();

		return ctAction;
	}

	protected CTAction toUnwrappedModel(CTAction ctAction) {
		if (ctAction instanceof CTActionImpl) {
			return ctAction;
		}

		CTActionImpl ctActionImpl = new CTActionImpl();

		ctActionImpl.setNew(ctAction.isNew());
		ctActionImpl.setPrimaryKey(ctAction.getPrimaryKey());

		ctActionImpl.setCTActionId(ctAction.getCTActionId());
		ctActionImpl.setCompanyId(ctAction.getCompanyId());
		ctActionImpl.setCampaignId(ctAction.getCampaignId());
		ctActionImpl.setReportInstanceId(ctAction.getReportInstanceId());
		ctActionImpl.setUserSegmentId(ctAction.getUserSegmentId());
		ctActionImpl.setAlias(ctAction.getAlias());
		ctActionImpl.setReferrerClassName(ctAction.getReferrerClassName());
		ctActionImpl.setReferrerClassPK(ctAction.getReferrerClassPK());
		ctActionImpl.setElementId(ctAction.getElementId());
		ctActionImpl.setEventType(ctAction.getEventType());
		ctActionImpl.setCount(ctAction.getCount());
		ctActionImpl.setModifiedDate(ctAction.getModifiedDate());

		return ctActionImpl;
	}

	/**
	 * Returns the c t action with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the c t action
	 * @return the c t action
	 * @throws NoSuchCTActionException if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCTActionException {
		CTAction ctAction = fetchByPrimaryKey(primaryKey);

		if (ctAction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCTActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ctAction;
	}

	/**
	 * Returns the c t action with the primary key or throws a {@link NoSuchCTActionException} if it could not be found.
	 *
	 * @param CTActionId the primary key of the c t action
	 * @return the c t action
	 * @throws NoSuchCTActionException if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction findByPrimaryKey(long CTActionId)
		throws NoSuchCTActionException {
		return findByPrimaryKey((Serializable)CTActionId);
	}

	/**
	 * Returns the c t action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the c t action
	 * @return the c t action, or <code>null</code> if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction fetchByPrimaryKey(Serializable primaryKey) {
		CTAction ctAction = (CTAction)entityCache.getResult(CTActionModelImpl.ENTITY_CACHE_ENABLED,
				CTActionImpl.class, primaryKey);

		if (ctAction == _nullCTAction) {
			return null;
		}

		if (ctAction == null) {
			Session session = null;

			try {
				session = openSession();

				ctAction = (CTAction)session.get(CTActionImpl.class, primaryKey);

				if (ctAction != null) {
					cacheResult(ctAction);
				}
				else {
					entityCache.putResult(CTActionModelImpl.ENTITY_CACHE_ENABLED,
						CTActionImpl.class, primaryKey, _nullCTAction);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CTActionModelImpl.ENTITY_CACHE_ENABLED,
					CTActionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ctAction;
	}

	/**
	 * Returns the c t action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param CTActionId the primary key of the c t action
	 * @return the c t action, or <code>null</code> if a c t action with the primary key could not be found
	 */
	@Override
	public CTAction fetchByPrimaryKey(long CTActionId) {
		return fetchByPrimaryKey((Serializable)CTActionId);
	}

	@Override
	public Map<Serializable, CTAction> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CTAction> map = new HashMap<Serializable, CTAction>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CTAction ctAction = fetchByPrimaryKey(primaryKey);

			if (ctAction != null) {
				map.put(primaryKey, ctAction);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			CTAction ctAction = (CTAction)entityCache.getResult(CTActionModelImpl.ENTITY_CACHE_ENABLED,
					CTActionImpl.class, primaryKey);

			if (ctAction == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, ctAction);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CTACTION_WHERE_PKS_IN);

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

			for (CTAction ctAction : (List<CTAction>)q.list()) {
				map.put(ctAction.getPrimaryKeyObj(), ctAction);

				cacheResult(ctAction);

				uncachedPrimaryKeys.remove(ctAction.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CTActionModelImpl.ENTITY_CACHE_ENABLED,
					CTActionImpl.class, primaryKey, _nullCTAction);
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
	 * Returns all the c t actions.
	 *
	 * @return the c t actions
	 */
	@Override
	public List<CTAction> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the c t actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @return the range of c t actions
	 */
	@Override
	public List<CTAction> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the c t actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of c t actions
	 */
	@Override
	public List<CTAction> findAll(int start, int end,
		OrderByComparator<CTAction> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the c t actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of c t actions
	 */
	@Override
	public List<CTAction> findAll(int start, int end,
		OrderByComparator<CTAction> orderByComparator, boolean retrieveFromCache) {
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

		List<CTAction> list = null;

		if (retrieveFromCache) {
			list = (List<CTAction>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CTACTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CTACTION;

				if (pagination) {
					sql = sql.concat(CTActionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTAction>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the c t actions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CTAction ctAction : findAll()) {
			remove(ctAction);
		}
	}

	/**
	 * Returns the number of c t actions.
	 *
	 * @return the number of c t actions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CTACTION);

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
		return CTActionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the c t action persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CTActionImpl.class.getName());
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
	private static final String _SQL_SELECT_CTACTION = "SELECT ctAction FROM CTAction ctAction";
	private static final String _SQL_SELECT_CTACTION_WHERE_PKS_IN = "SELECT ctAction FROM CTAction ctAction WHERE CTActionId IN (";
	private static final String _SQL_SELECT_CTACTION_WHERE = "SELECT ctAction FROM CTAction ctAction WHERE ";
	private static final String _SQL_COUNT_CTACTION = "SELECT COUNT(ctAction) FROM CTAction ctAction";
	private static final String _SQL_COUNT_CTACTION_WHERE = "SELECT COUNT(ctAction) FROM CTAction ctAction WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ctAction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CTAction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CTAction exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CTActionPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"alias"
			});
	private static final CTAction _nullCTAction = new CTActionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CTAction> toCacheModel() {
				return _nullCTActionCacheModel;
			}
		};

	private static final CacheModel<CTAction> _nullCTActionCacheModel = new CacheModel<CTAction>() {
			@Override
			public CTAction toEntityModel() {
				return _nullCTAction;
			}
		};
}