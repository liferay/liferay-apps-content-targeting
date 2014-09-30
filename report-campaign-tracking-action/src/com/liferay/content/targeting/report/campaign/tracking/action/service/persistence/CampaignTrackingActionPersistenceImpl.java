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

import com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction;
import com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionImpl;
import com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl;

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
 * The persistence implementation for the campaign tracking action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingActionPersistence
 * @see CampaignTrackingActionUtil
 * @generated
 */
public class CampaignTrackingActionPersistenceImpl extends BasePersistenceImpl<CampaignTrackingAction>
	implements CampaignTrackingActionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignTrackingActionUtil} to access the campaign tracking action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignTrackingActionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			CampaignTrackingActionModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the campaign tracking actions where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByCampaignId(long campaignId)
		throws SystemException {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign tracking actions where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign tracking actions
	 * @param end the upper bound of the range of campaign tracking actions (not inclusive)
	 * @return the range of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByCampaignId(long campaignId,
		int start, int end) throws SystemException {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign tracking actions where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign tracking actions
	 * @param end the upper bound of the range of campaign tracking actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByCampaignId(long campaignId,
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

		List<CampaignTrackingAction> list = (List<CampaignTrackingAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignTrackingAction campaignTrackingAction : list) {
				if ((campaignId != campaignTrackingAction.getCampaignId())) {
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

			query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTION_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampaignTrackingActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<CampaignTrackingAction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignTrackingAction>(list);
				}
				else {
					list = (List<CampaignTrackingAction>)QueryUtil.list(q,
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
	 * Returns the first campaign tracking action in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = fetchByCampaignId_First(campaignId,
				orderByComparator);

		if (campaignTrackingAction != null) {
			return campaignTrackingAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionException(msg.toString());
	}

	/**
	 * Returns the first campaign tracking action in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CampaignTrackingAction> list = findByCampaignId(campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign tracking action in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = fetchByCampaignId_Last(campaignId,
				orderByComparator);

		if (campaignTrackingAction != null) {
			return campaignTrackingAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionException(msg.toString());
	}

	/**
	 * Returns the last campaign tracking action in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<CampaignTrackingAction> list = findByCampaignId(campaignId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign tracking actions before and after the current campaign tracking action in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignTrackingActionId the primary key of the current campaign tracking action
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction[] findByCampaignId_PrevAndNext(
		long campaignTrackingActionId, long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = findByPrimaryKey(campaignTrackingActionId);

		Session session = null;

		try {
			session = openSession();

			CampaignTrackingAction[] array = new CampaignTrackingActionImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session,
					campaignTrackingAction, campaignId, orderByComparator, true);

			array[1] = campaignTrackingAction;

			array[2] = getByCampaignId_PrevAndNext(session,
					campaignTrackingAction, campaignId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignTrackingAction getByCampaignId_PrevAndNext(
		Session session, CampaignTrackingAction campaignTrackingAction,
		long campaignId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTION_WHERE);

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
			query.append(CampaignTrackingActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignTrackingAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignTrackingAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign tracking actions where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long campaignId) throws SystemException {
		for (CampaignTrackingAction campaignTrackingAction : findByCampaignId(
				campaignId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(campaignTrackingAction);
		}
	}

	/**
	 * Returns the number of campaign tracking actions where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching campaign tracking actions
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

			query.append(_SQL_COUNT_CAMPAIGNTRACKINGACTION_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "campaignTrackingAction.campaignId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_GtD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_GTD = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_GtD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the campaign tracking actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @return the matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByC_GtD(long campaignId,
		Date modifiedDate) throws SystemException {
		return findByC_GtD(campaignId, modifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign tracking actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of campaign tracking actions
	 * @param end the upper bound of the range of campaign tracking actions (not inclusive)
	 * @return the range of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByC_GtD(long campaignId,
		Date modifiedDate, int start, int end) throws SystemException {
		return findByC_GtD(campaignId, modifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign tracking actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of campaign tracking actions
	 * @param end the upper bound of the range of campaign tracking actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByC_GtD(long campaignId,
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

		List<CampaignTrackingAction> list = (List<CampaignTrackingAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignTrackingAction campaignTrackingAction : list) {
				if ((campaignId != campaignTrackingAction.getCampaignId()) ||
						(modifiedDate.getTime() >= campaignTrackingAction.getModifiedDate()
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

			query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTION_WHERE);

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
				query.append(CampaignTrackingActionModelImpl.ORDER_BY_JPQL);
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
					list = (List<CampaignTrackingAction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignTrackingAction>(list);
				}
				else {
					list = (List<CampaignTrackingAction>)QueryUtil.list(q,
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
	 * Returns the first campaign tracking action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByC_GtD_First(long campaignId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = fetchByC_GtD_First(campaignId,
				modifiedDate, orderByComparator);

		if (campaignTrackingAction != null) {
			return campaignTrackingAction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionException(msg.toString());
	}

	/**
	 * Returns the first campaign tracking action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByC_GtD_First(long campaignId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<CampaignTrackingAction> list = findByC_GtD(campaignId,
				modifiedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign tracking action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByC_GtD_Last(long campaignId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = fetchByC_GtD_Last(campaignId,
				modifiedDate, orderByComparator);

		if (campaignTrackingAction != null) {
			return campaignTrackingAction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionException(msg.toString());
	}

	/**
	 * Returns the last campaign tracking action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByC_GtD_Last(long campaignId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_GtD(campaignId, modifiedDate);

		if (count == 0) {
			return null;
		}

		List<CampaignTrackingAction> list = findByC_GtD(campaignId,
				modifiedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign tracking actions before and after the current campaign tracking action in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignTrackingActionId the primary key of the current campaign tracking action
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction[] findByC_GtD_PrevAndNext(
		long campaignTrackingActionId, long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = findByPrimaryKey(campaignTrackingActionId);

		Session session = null;

		try {
			session = openSession();

			CampaignTrackingAction[] array = new CampaignTrackingActionImpl[3];

			array[0] = getByC_GtD_PrevAndNext(session, campaignTrackingAction,
					campaignId, modifiedDate, orderByComparator, true);

			array[1] = campaignTrackingAction;

			array[2] = getByC_GtD_PrevAndNext(session, campaignTrackingAction,
					campaignId, modifiedDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignTrackingAction getByC_GtD_PrevAndNext(Session session,
		CampaignTrackingAction campaignTrackingAction, long campaignId,
		Date modifiedDate, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTION_WHERE);

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
			query.append(CampaignTrackingActionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(campaignTrackingAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignTrackingAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign tracking actions where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_GtD(long campaignId, Date modifiedDate)
		throws SystemException {
		for (CampaignTrackingAction campaignTrackingAction : findByC_GtD(
				campaignId, modifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(campaignTrackingAction);
		}
	}

	/**
	 * Returns the number of campaign tracking actions where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @return the number of matching campaign tracking actions
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

			query.append(_SQL_COUNT_CAMPAIGNTRACKINGACTION_WHERE);

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

	private static final String _FINDER_COLUMN_C_GTD_CAMPAIGNID_2 = "campaignTrackingAction.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_GTD_MODIFIEDDATE_1 = "campaignTrackingAction.modifiedDate > NULL";
	private static final String _FINDER_COLUMN_C_GTD_MODIFIEDDATE_2 = "campaignTrackingAction.modifiedDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_E = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_E",
			new String[] { Long.class.getName(), String.class.getName() },
			CampaignTrackingActionModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.ELEMENTID_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_E = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_E",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the campaign tracking actions where campaignId = &#63; and elementId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @return the matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByC_E(long campaignId,
		String elementId) throws SystemException {
		return findByC_E(campaignId, elementId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign tracking actions where campaignId = &#63; and elementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param start the lower bound of the range of campaign tracking actions
	 * @param end the upper bound of the range of campaign tracking actions (not inclusive)
	 * @return the range of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByC_E(long campaignId,
		String elementId, int start, int end) throws SystemException {
		return findByC_E(campaignId, elementId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign tracking actions where campaignId = &#63; and elementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param start the lower bound of the range of campaign tracking actions
	 * @param end the upper bound of the range of campaign tracking actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByC_E(long campaignId,
		String elementId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E;
			finderArgs = new Object[] { campaignId, elementId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_E;
			finderArgs = new Object[] {
					campaignId, elementId,
					
					start, end, orderByComparator
				};
		}

		List<CampaignTrackingAction> list = (List<CampaignTrackingAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignTrackingAction campaignTrackingAction : list) {
				if ((campaignId != campaignTrackingAction.getCampaignId()) ||
						!Validator.equals(elementId,
							campaignTrackingAction.getElementId())) {
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

			query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTION_WHERE);

			query.append(_FINDER_COLUMN_C_E_CAMPAIGNID_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_C_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_C_E_ELEMENTID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampaignTrackingActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (!pagination) {
					list = (List<CampaignTrackingAction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignTrackingAction>(list);
				}
				else {
					list = (List<CampaignTrackingAction>)QueryUtil.list(q,
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
	 * Returns the first campaign tracking action in the ordered set where campaignId = &#63; and elementId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByC_E_First(long campaignId,
		String elementId, OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = fetchByC_E_First(campaignId,
				elementId, orderByComparator);

		if (campaignTrackingAction != null) {
			return campaignTrackingAction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", elementId=");
		msg.append(elementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionException(msg.toString());
	}

	/**
	 * Returns the first campaign tracking action in the ordered set where campaignId = &#63; and elementId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByC_E_First(long campaignId,
		String elementId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CampaignTrackingAction> list = findByC_E(campaignId, elementId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign tracking action in the ordered set where campaignId = &#63; and elementId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByC_E_Last(long campaignId,
		String elementId, OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = fetchByC_E_Last(campaignId,
				elementId, orderByComparator);

		if (campaignTrackingAction != null) {
			return campaignTrackingAction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", elementId=");
		msg.append(elementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionException(msg.toString());
	}

	/**
	 * Returns the last campaign tracking action in the ordered set where campaignId = &#63; and elementId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByC_E_Last(long campaignId,
		String elementId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_E(campaignId, elementId);

		if (count == 0) {
			return null;
		}

		List<CampaignTrackingAction> list = findByC_E(campaignId, elementId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign tracking actions before and after the current campaign tracking action in the ordered set where campaignId = &#63; and elementId = &#63;.
	 *
	 * @param campaignTrackingActionId the primary key of the current campaign tracking action
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction[] findByC_E_PrevAndNext(
		long campaignTrackingActionId, long campaignId, String elementId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = findByPrimaryKey(campaignTrackingActionId);

		Session session = null;

		try {
			session = openSession();

			CampaignTrackingAction[] array = new CampaignTrackingActionImpl[3];

			array[0] = getByC_E_PrevAndNext(session, campaignTrackingAction,
					campaignId, elementId, orderByComparator, true);

			array[1] = campaignTrackingAction;

			array[2] = getByC_E_PrevAndNext(session, campaignTrackingAction,
					campaignId, elementId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignTrackingAction getByC_E_PrevAndNext(Session session,
		CampaignTrackingAction campaignTrackingAction, long campaignId,
		String elementId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTION_WHERE);

		query.append(_FINDER_COLUMN_C_E_CAMPAIGNID_2);

		boolean bindElementId = false;

		if (elementId == null) {
			query.append(_FINDER_COLUMN_C_E_ELEMENTID_1);
		}
		else if (elementId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_E_ELEMENTID_3);
		}
		else {
			bindElementId = true;

			query.append(_FINDER_COLUMN_C_E_ELEMENTID_2);
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
			query.append(CampaignTrackingActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (bindElementId) {
			qPos.add(elementId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignTrackingAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignTrackingAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign tracking actions where campaignId = &#63; and elementId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_E(long campaignId, String elementId)
		throws SystemException {
		for (CampaignTrackingAction campaignTrackingAction : findByC_E(
				campaignId, elementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(campaignTrackingAction);
		}
	}

	/**
	 * Returns the number of campaign tracking actions where campaignId = &#63; and elementId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param elementId the element ID
	 * @return the number of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_E(long campaignId, String elementId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_E;

		Object[] finderArgs = new Object[] { campaignId, elementId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CAMPAIGNTRACKINGACTION_WHERE);

			query.append(_FINDER_COLUMN_C_E_CAMPAIGNID_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_C_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_C_E_ELEMENTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindElementId) {
					qPos.add(elementId);
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

	private static final String _FINDER_COLUMN_C_E_CAMPAIGNID_2 = "campaignTrackingAction.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_E_ELEMENTID_1 = "campaignTrackingAction.elementId IS NULL";
	private static final String _FINDER_COLUMN_C_E_ELEMENTID_2 = "campaignTrackingAction.elementId = ?";
	private static final String _FINDER_COLUMN_C_E_ELEMENTID_3 = "(campaignTrackingAction.elementId IS NULL OR campaignTrackingAction.elementId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_R = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_R_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_R_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			CampaignTrackingActionModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.REFERRERCLASSNAME_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.REFERRERCLASSPK_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R_R = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_R_R",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the campaign tracking actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @return the matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByC_R_R(long campaignId,
		String referrerClassName, long referrerClassPK)
		throws SystemException {
		return findByC_R_R(campaignId, referrerClassName, referrerClassPK,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign tracking actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of campaign tracking actions
	 * @param end the upper bound of the range of campaign tracking actions (not inclusive)
	 * @return the range of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByC_R_R(long campaignId,
		String referrerClassName, long referrerClassPK, int start, int end)
		throws SystemException {
		return findByC_R_R(campaignId, referrerClassName, referrerClassPK,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign tracking actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param start the lower bound of the range of campaign tracking actions
	 * @param end the upper bound of the range of campaign tracking actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findByC_R_R(long campaignId,
		String referrerClassName, long referrerClassPK, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R;
			finderArgs = new Object[] {
					campaignId, referrerClassName, referrerClassPK
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_R_R;
			finderArgs = new Object[] {
					campaignId, referrerClassName, referrerClassPK,
					
					start, end, orderByComparator
				};
		}

		List<CampaignTrackingAction> list = (List<CampaignTrackingAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignTrackingAction campaignTrackingAction : list) {
				if ((campaignId != campaignTrackingAction.getCampaignId()) ||
						!Validator.equals(referrerClassName,
							campaignTrackingAction.getReferrerClassName()) ||
						(referrerClassPK != campaignTrackingAction.getReferrerClassPK())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTION_WHERE);

			query.append(_FINDER_COLUMN_C_R_R_CAMPAIGNID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampaignTrackingActionModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<CampaignTrackingAction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignTrackingAction>(list);
				}
				else {
					list = (List<CampaignTrackingAction>)QueryUtil.list(q,
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
	 * Returns the first campaign tracking action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByC_R_R_First(long campaignId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = fetchByC_R_R_First(campaignId,
				referrerClassName, referrerClassPK, orderByComparator);

		if (campaignTrackingAction != null) {
			return campaignTrackingAction;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionException(msg.toString());
	}

	/**
	 * Returns the first campaign tracking action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByC_R_R_First(long campaignId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator orderByComparator) throws SystemException {
		List<CampaignTrackingAction> list = findByC_R_R(campaignId,
				referrerClassName, referrerClassPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign tracking action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByC_R_R_Last(long campaignId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = fetchByC_R_R_Last(campaignId,
				referrerClassName, referrerClassPK, orderByComparator);

		if (campaignTrackingAction != null) {
			return campaignTrackingAction;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", referrerClassName=");
		msg.append(referrerClassName);

		msg.append(", referrerClassPK=");
		msg.append(referrerClassPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignTrackingActionException(msg.toString());
	}

	/**
	 * Returns the last campaign tracking action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByC_R_R_Last(long campaignId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_R_R(campaignId, referrerClassName, referrerClassPK);

		if (count == 0) {
			return null;
		}

		List<CampaignTrackingAction> list = findByC_R_R(campaignId,
				referrerClassName, referrerClassPK, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign tracking actions before and after the current campaign tracking action in the ordered set where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param campaignTrackingActionId the primary key of the current campaign tracking action
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction[] findByC_R_R_PrevAndNext(
		long campaignTrackingActionId, long campaignId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = findByPrimaryKey(campaignTrackingActionId);

		Session session = null;

		try {
			session = openSession();

			CampaignTrackingAction[] array = new CampaignTrackingActionImpl[3];

			array[0] = getByC_R_R_PrevAndNext(session, campaignTrackingAction,
					campaignId, referrerClassName, referrerClassPK,
					orderByComparator, true);

			array[1] = campaignTrackingAction;

			array[2] = getByC_R_R_PrevAndNext(session, campaignTrackingAction,
					campaignId, referrerClassName, referrerClassPK,
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

	protected CampaignTrackingAction getByC_R_R_PrevAndNext(Session session,
		CampaignTrackingAction campaignTrackingAction, long campaignId,
		String referrerClassName, long referrerClassPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTION_WHERE);

		query.append(_FINDER_COLUMN_C_R_R_CAMPAIGNID_2);

		boolean bindReferrerClassName = false;

		if (referrerClassName == null) {
			query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_1);
		}
		else if (referrerClassName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_3);
		}
		else {
			bindReferrerClassName = true;

			query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSPK_2);

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
			query.append(CampaignTrackingActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (bindReferrerClassName) {
			qPos.add(referrerClassName);
		}

		qPos.add(referrerClassPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignTrackingAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignTrackingAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign tracking actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_R_R(long campaignId, String referrerClassName,
		long referrerClassPK) throws SystemException {
		for (CampaignTrackingAction campaignTrackingAction : findByC_R_R(
				campaignId, referrerClassName, referrerClassPK,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(campaignTrackingAction);
		}
	}

	/**
	 * Returns the number of campaign tracking actions where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @return the number of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_R_R(long campaignId, String referrerClassName,
		long referrerClassPK) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_R_R;

		Object[] finderArgs = new Object[] {
				campaignId, referrerClassName, referrerClassPK
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CAMPAIGNTRACKINGACTION_WHERE);

			query.append(_FINDER_COLUMN_C_R_R_CAMPAIGNID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_R_R_REFERRERCLASSPK_2);

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

	private static final String _FINDER_COLUMN_C_R_R_CAMPAIGNID_2 = "campaignTrackingAction.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_1 = "campaignTrackingAction.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_2 = "campaignTrackingAction.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_C_R_R_REFERRERCLASSNAME_3 = "(campaignTrackingAction.referrerClassName IS NULL OR campaignTrackingAction.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_C_R_R_REFERRERCLASSPK_2 = "campaignTrackingAction.referrerClassPK = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_U_R_R_E_E = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED,
			CampaignTrackingActionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_U_R_R_E_E",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			CampaignTrackingActionModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.USERSEGMENTID_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.REFERRERCLASSNAME_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.REFERRERCLASSPK_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.ELEMENTID_COLUMN_BITMASK |
			CampaignTrackingActionModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_U_R_R_E_E = new FinderPath(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U_R_R_E_E",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns the campaign tracking action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException} if it could not be found.
	 *
	 * @param campaignId the campaign ID
	 * @param userSegmentId the user segment ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByC_U_R_R_E_E(long campaignId,
		long userSegmentId, String referrerClassName, long referrerClassPK,
		String elementId, String eventType)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = fetchByC_U_R_R_E_E(campaignId,
				userSegmentId, referrerClassName, referrerClassPK, elementId,
				eventType);

		if (campaignTrackingAction == null) {
			StringBundler msg = new StringBundler(14);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

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

			throw new NoSuchCampaignTrackingActionException(msg.toString());
		}

		return campaignTrackingAction;
	}

	/**
	 * Returns the campaign tracking action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param userSegmentId the user segment ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByC_U_R_R_E_E(long campaignId,
		long userSegmentId, String referrerClassName, long referrerClassPK,
		String elementId, String eventType) throws SystemException {
		return fetchByC_U_R_R_E_E(campaignId, userSegmentId, referrerClassName,
			referrerClassPK, elementId, eventType, true);
	}

	/**
	 * Returns the campaign tracking action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param userSegmentId the user segment ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching campaign tracking action, or <code>null</code> if a matching campaign tracking action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByC_U_R_R_E_E(long campaignId,
		long userSegmentId, String referrerClassName, long referrerClassPK,
		String elementId, String eventType, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				campaignId, userSegmentId, referrerClassName, referrerClassPK,
				elementId, eventType
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_U_R_R_E_E,
					finderArgs, this);
		}

		if (result instanceof CampaignTrackingAction) {
			CampaignTrackingAction campaignTrackingAction = (CampaignTrackingAction)result;

			if ((campaignId != campaignTrackingAction.getCampaignId()) ||
					(userSegmentId != campaignTrackingAction.getUserSegmentId()) ||
					!Validator.equals(referrerClassName,
						campaignTrackingAction.getReferrerClassName()) ||
					(referrerClassPK != campaignTrackingAction.getReferrerClassPK()) ||
					!Validator.equals(elementId,
						campaignTrackingAction.getElementId()) ||
					!Validator.equals(eventType,
						campaignTrackingAction.getEventType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(8);

			query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTION_WHERE);

			query.append(_FINDER_COLUMN_C_U_R_R_E_E_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_C_U_R_R_E_E_USERSEGMENTID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSPK_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_C_U_R_R_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_U_R_R_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

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

				List<CampaignTrackingAction> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_U_R_R_E_E,
						finderArgs, list);
				}
				else {
					CampaignTrackingAction campaignTrackingAction = list.get(0);

					result = campaignTrackingAction;

					cacheResult(campaignTrackingAction);

					if ((campaignTrackingAction.getCampaignId() != campaignId) ||
							(campaignTrackingAction.getUserSegmentId() != userSegmentId) ||
							(campaignTrackingAction.getReferrerClassName() == null) ||
							!campaignTrackingAction.getReferrerClassName()
													   .equals(referrerClassName) ||
							(campaignTrackingAction.getReferrerClassPK() != referrerClassPK) ||
							(campaignTrackingAction.getElementId() == null) ||
							!campaignTrackingAction.getElementId()
													   .equals(elementId) ||
							(campaignTrackingAction.getEventType() == null) ||
							!campaignTrackingAction.getEventType()
													   .equals(eventType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_U_R_R_E_E,
							finderArgs, campaignTrackingAction);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_U_R_R_E_E,
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
			return (CampaignTrackingAction)result;
		}
	}

	/**
	 * Removes the campaign tracking action where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param userSegmentId the user segment ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the campaign tracking action that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction removeByC_U_R_R_E_E(long campaignId,
		long userSegmentId, String referrerClassName, long referrerClassPK,
		String elementId, String eventType)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = findByC_U_R_R_E_E(campaignId,
				userSegmentId, referrerClassName, referrerClassPK, elementId,
				eventType);

		return remove(campaignTrackingAction);
	}

	/**
	 * Returns the number of campaign tracking actions where campaignId = &#63; and userSegmentId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param userSegmentId the user segment ID
	 * @param referrerClassName the referrer class name
	 * @param referrerClassPK the referrer class p k
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the number of matching campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_U_R_R_E_E(long campaignId, long userSegmentId,
		String referrerClassName, long referrerClassPK, String elementId,
		String eventType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_U_R_R_E_E;

		Object[] finderArgs = new Object[] {
				campaignId, userSegmentId, referrerClassName, referrerClassPK,
				elementId, eventType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_CAMPAIGNTRACKINGACTION_WHERE);

			query.append(_FINDER_COLUMN_C_U_R_R_E_E_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_C_U_R_R_E_E_USERSEGMENTID_2);

			boolean bindReferrerClassName = false;

			if (referrerClassName == null) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSNAME_1);
			}
			else if (referrerClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSNAME_3);
			}
			else {
				bindReferrerClassName = true;

				query.append(_FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSPK_2);

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_C_U_R_R_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_U_R_R_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_U_R_R_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

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

	private static final String _FINDER_COLUMN_C_U_R_R_E_E_CAMPAIGNID_2 = "campaignTrackingAction.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_USERSEGMENTID_2 = "campaignTrackingAction.userSegmentId = ? AND ";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSNAME_1 = "campaignTrackingAction.referrerClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSNAME_2 = "campaignTrackingAction.referrerClassName = ? AND ";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSNAME_3 = "(campaignTrackingAction.referrerClassName IS NULL OR campaignTrackingAction.referrerClassName = '') AND ";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_REFERRERCLASSPK_2 = "campaignTrackingAction.referrerClassPK = ? AND ";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_ELEMENTID_1 = "campaignTrackingAction.elementId IS NULL AND ";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_ELEMENTID_2 = "campaignTrackingAction.elementId = ? AND ";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_ELEMENTID_3 = "(campaignTrackingAction.elementId IS NULL OR campaignTrackingAction.elementId = '') AND ";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_EVENTTYPE_1 = "campaignTrackingAction.eventType IS NULL";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_EVENTTYPE_2 = "campaignTrackingAction.eventType = ?";
	private static final String _FINDER_COLUMN_C_U_R_R_E_E_EVENTTYPE_3 = "(campaignTrackingAction.eventType IS NULL OR campaignTrackingAction.eventType = '')";

	public CampaignTrackingActionPersistenceImpl() {
		setModelClass(CampaignTrackingAction.class);
	}

	/**
	 * Caches the campaign tracking action in the entity cache if it is enabled.
	 *
	 * @param campaignTrackingAction the campaign tracking action
	 */
	@Override
	public void cacheResult(CampaignTrackingAction campaignTrackingAction) {
		EntityCacheUtil.putResult(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			campaignTrackingAction.getPrimaryKey(), campaignTrackingAction);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_U_R_R_E_E,
			new Object[] {
				campaignTrackingAction.getCampaignId(),
				campaignTrackingAction.getUserSegmentId(),
				campaignTrackingAction.getReferrerClassName(),
				campaignTrackingAction.getReferrerClassPK(),
				campaignTrackingAction.getElementId(),
				campaignTrackingAction.getEventType()
			}, campaignTrackingAction);

		campaignTrackingAction.resetOriginalValues();
	}

	/**
	 * Caches the campaign tracking actions in the entity cache if it is enabled.
	 *
	 * @param campaignTrackingActions the campaign tracking actions
	 */
	@Override
	public void cacheResult(
		List<CampaignTrackingAction> campaignTrackingActions) {
		for (CampaignTrackingAction campaignTrackingAction : campaignTrackingActions) {
			if (EntityCacheUtil.getResult(
						CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
						CampaignTrackingActionImpl.class,
						campaignTrackingAction.getPrimaryKey()) == null) {
				cacheResult(campaignTrackingAction);
			}
			else {
				campaignTrackingAction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campaign tracking actions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CampaignTrackingActionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CampaignTrackingActionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campaign tracking action.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CampaignTrackingAction campaignTrackingAction) {
		EntityCacheUtil.removeResult(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			campaignTrackingAction.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(campaignTrackingAction);
	}

	@Override
	public void clearCache(List<CampaignTrackingAction> campaignTrackingActions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CampaignTrackingAction campaignTrackingAction : campaignTrackingActions) {
			EntityCacheUtil.removeResult(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
				CampaignTrackingActionImpl.class,
				campaignTrackingAction.getPrimaryKey());

			clearUniqueFindersCache(campaignTrackingAction);
		}
	}

	protected void cacheUniqueFindersCache(
		CampaignTrackingAction campaignTrackingAction) {
		if (campaignTrackingAction.isNew()) {
			Object[] args = new Object[] {
					campaignTrackingAction.getCampaignId(),
					campaignTrackingAction.getUserSegmentId(),
					campaignTrackingAction.getReferrerClassName(),
					campaignTrackingAction.getReferrerClassPK(),
					campaignTrackingAction.getElementId(),
					campaignTrackingAction.getEventType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_U_R_R_E_E, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_U_R_R_E_E, args,
				campaignTrackingAction);
		}
		else {
			CampaignTrackingActionModelImpl campaignTrackingActionModelImpl = (CampaignTrackingActionModelImpl)campaignTrackingAction;

			if ((campaignTrackingActionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_U_R_R_E_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignTrackingAction.getCampaignId(),
						campaignTrackingAction.getUserSegmentId(),
						campaignTrackingAction.getReferrerClassName(),
						campaignTrackingAction.getReferrerClassPK(),
						campaignTrackingAction.getElementId(),
						campaignTrackingAction.getEventType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_U_R_R_E_E,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_U_R_R_E_E,
					args, campaignTrackingAction);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CampaignTrackingAction campaignTrackingAction) {
		CampaignTrackingActionModelImpl campaignTrackingActionModelImpl = (CampaignTrackingActionModelImpl)campaignTrackingAction;

		Object[] args = new Object[] {
				campaignTrackingAction.getCampaignId(),
				campaignTrackingAction.getUserSegmentId(),
				campaignTrackingAction.getReferrerClassName(),
				campaignTrackingAction.getReferrerClassPK(),
				campaignTrackingAction.getElementId(),
				campaignTrackingAction.getEventType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_U_R_R_E_E, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_U_R_R_E_E, args);

		if ((campaignTrackingActionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_U_R_R_E_E.getColumnBitmask()) != 0) {
			args = new Object[] {
					campaignTrackingActionModelImpl.getOriginalCampaignId(),
					campaignTrackingActionModelImpl.getOriginalUserSegmentId(),
					campaignTrackingActionModelImpl.getOriginalReferrerClassName(),
					campaignTrackingActionModelImpl.getOriginalReferrerClassPK(),
					campaignTrackingActionModelImpl.getOriginalElementId(),
					campaignTrackingActionModelImpl.getOriginalEventType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_U_R_R_E_E, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_U_R_R_E_E, args);
		}
	}

	/**
	 * Creates a new campaign tracking action with the primary key. Does not add the campaign tracking action to the database.
	 *
	 * @param campaignTrackingActionId the primary key for the new campaign tracking action
	 * @return the new campaign tracking action
	 */
	@Override
	public CampaignTrackingAction create(long campaignTrackingActionId) {
		CampaignTrackingAction campaignTrackingAction = new CampaignTrackingActionImpl();

		campaignTrackingAction.setNew(true);
		campaignTrackingAction.setPrimaryKey(campaignTrackingActionId);

		return campaignTrackingAction;
	}

	/**
	 * Removes the campaign tracking action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignTrackingActionId the primary key of the campaign tracking action
	 * @return the campaign tracking action that was removed
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction remove(long campaignTrackingActionId)
		throws NoSuchCampaignTrackingActionException, SystemException {
		return remove((Serializable)campaignTrackingActionId);
	}

	/**
	 * Removes the campaign tracking action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign tracking action
	 * @return the campaign tracking action that was removed
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction remove(Serializable primaryKey)
		throws NoSuchCampaignTrackingActionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CampaignTrackingAction campaignTrackingAction = (CampaignTrackingAction)session.get(CampaignTrackingActionImpl.class,
					primaryKey);

			if (campaignTrackingAction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignTrackingActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campaignTrackingAction);
		}
		catch (NoSuchCampaignTrackingActionException nsee) {
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
	protected CampaignTrackingAction removeImpl(
		CampaignTrackingAction campaignTrackingAction)
		throws SystemException {
		campaignTrackingAction = toUnwrappedModel(campaignTrackingAction);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campaignTrackingAction)) {
				campaignTrackingAction = (CampaignTrackingAction)session.get(CampaignTrackingActionImpl.class,
						campaignTrackingAction.getPrimaryKeyObj());
			}

			if (campaignTrackingAction != null) {
				session.delete(campaignTrackingAction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (campaignTrackingAction != null) {
			clearCache(campaignTrackingAction);
		}

		return campaignTrackingAction;
	}

	@Override
	public CampaignTrackingAction updateImpl(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction campaignTrackingAction)
		throws SystemException {
		campaignTrackingAction = toUnwrappedModel(campaignTrackingAction);

		boolean isNew = campaignTrackingAction.isNew();

		CampaignTrackingActionModelImpl campaignTrackingActionModelImpl = (CampaignTrackingActionModelImpl)campaignTrackingAction;

		Session session = null;

		try {
			session = openSession();

			if (campaignTrackingAction.isNew()) {
				session.save(campaignTrackingAction);

				campaignTrackingAction.setNew(false);
			}
			else {
				session.merge(campaignTrackingAction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CampaignTrackingActionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((campaignTrackingActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignTrackingActionModelImpl.getOriginalCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] {
						campaignTrackingActionModelImpl.getCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((campaignTrackingActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignTrackingActionModelImpl.getOriginalCampaignId(),
						campaignTrackingActionModelImpl.getOriginalElementId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E,
					args);

				args = new Object[] {
						campaignTrackingActionModelImpl.getCampaignId(),
						campaignTrackingActionModelImpl.getElementId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_E,
					args);
			}

			if ((campaignTrackingActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignTrackingActionModelImpl.getOriginalCampaignId(),
						campaignTrackingActionModelImpl.getOriginalReferrerClassName(),
						campaignTrackingActionModelImpl.getOriginalReferrerClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R,
					args);

				args = new Object[] {
						campaignTrackingActionModelImpl.getCampaignId(),
						campaignTrackingActionModelImpl.getReferrerClassName(),
						campaignTrackingActionModelImpl.getReferrerClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_R_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_R_R,
					args);
			}
		}

		EntityCacheUtil.putResult(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
			CampaignTrackingActionImpl.class,
			campaignTrackingAction.getPrimaryKey(), campaignTrackingAction);

		clearUniqueFindersCache(campaignTrackingAction);
		cacheUniqueFindersCache(campaignTrackingAction);

		return campaignTrackingAction;
	}

	protected CampaignTrackingAction toUnwrappedModel(
		CampaignTrackingAction campaignTrackingAction) {
		if (campaignTrackingAction instanceof CampaignTrackingActionImpl) {
			return campaignTrackingAction;
		}

		CampaignTrackingActionImpl campaignTrackingActionImpl = new CampaignTrackingActionImpl();

		campaignTrackingActionImpl.setNew(campaignTrackingAction.isNew());
		campaignTrackingActionImpl.setPrimaryKey(campaignTrackingAction.getPrimaryKey());

		campaignTrackingActionImpl.setCampaignTrackingActionId(campaignTrackingAction.getCampaignTrackingActionId());
		campaignTrackingActionImpl.setCampaignId(campaignTrackingAction.getCampaignId());
		campaignTrackingActionImpl.setUserSegmentId(campaignTrackingAction.getUserSegmentId());
		campaignTrackingActionImpl.setAlias(campaignTrackingAction.getAlias());
		campaignTrackingActionImpl.setReferrerClassName(campaignTrackingAction.getReferrerClassName());
		campaignTrackingActionImpl.setReferrerClassPK(campaignTrackingAction.getReferrerClassPK());
		campaignTrackingActionImpl.setElementId(campaignTrackingAction.getElementId());
		campaignTrackingActionImpl.setEventType(campaignTrackingAction.getEventType());
		campaignTrackingActionImpl.setCount(campaignTrackingAction.getCount());
		campaignTrackingActionImpl.setModifiedDate(campaignTrackingAction.getModifiedDate());

		return campaignTrackingActionImpl;
	}

	/**
	 * Returns the campaign tracking action with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign tracking action
	 * @return the campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignTrackingActionException, SystemException {
		CampaignTrackingAction campaignTrackingAction = fetchByPrimaryKey(primaryKey);

		if (campaignTrackingAction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignTrackingActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return campaignTrackingAction;
	}

	/**
	 * Returns the campaign tracking action with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException} if it could not be found.
	 *
	 * @param campaignTrackingActionId the primary key of the campaign tracking action
	 * @return the campaign tracking action
	 * @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionException if a campaign tracking action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction findByPrimaryKey(
		long campaignTrackingActionId)
		throws NoSuchCampaignTrackingActionException, SystemException {
		return findByPrimaryKey((Serializable)campaignTrackingActionId);
	}

	/**
	 * Returns the campaign tracking action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign tracking action
	 * @return the campaign tracking action, or <code>null</code> if a campaign tracking action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CampaignTrackingAction campaignTrackingAction = (CampaignTrackingAction)EntityCacheUtil.getResult(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
				CampaignTrackingActionImpl.class, primaryKey);

		if (campaignTrackingAction == _nullCampaignTrackingAction) {
			return null;
		}

		if (campaignTrackingAction == null) {
			Session session = null;

			try {
				session = openSession();

				campaignTrackingAction = (CampaignTrackingAction)session.get(CampaignTrackingActionImpl.class,
						primaryKey);

				if (campaignTrackingAction != null) {
					cacheResult(campaignTrackingAction);
				}
				else {
					EntityCacheUtil.putResult(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
						CampaignTrackingActionImpl.class, primaryKey,
						_nullCampaignTrackingAction);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CampaignTrackingActionModelImpl.ENTITY_CACHE_ENABLED,
					CampaignTrackingActionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return campaignTrackingAction;
	}

	/**
	 * Returns the campaign tracking action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignTrackingActionId the primary key of the campaign tracking action
	 * @return the campaign tracking action, or <code>null</code> if a campaign tracking action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignTrackingAction fetchByPrimaryKey(
		long campaignTrackingActionId) throws SystemException {
		return fetchByPrimaryKey((Serializable)campaignTrackingActionId);
	}

	/**
	 * Returns all the campaign tracking actions.
	 *
	 * @return the campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign tracking actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign tracking actions
	 * @param end the upper bound of the range of campaign tracking actions (not inclusive)
	 * @return the range of campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign tracking actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign tracking actions
	 * @param end the upper bound of the range of campaign tracking actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaign tracking actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignTrackingAction> findAll(int start, int end,
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

		List<CampaignTrackingAction> list = (List<CampaignTrackingAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAMPAIGNTRACKINGACTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNTRACKINGACTION;

				if (pagination) {
					sql = sql.concat(CampaignTrackingActionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CampaignTrackingAction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignTrackingAction>(list);
				}
				else {
					list = (List<CampaignTrackingAction>)QueryUtil.list(q,
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
	 * Removes all the campaign tracking actions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CampaignTrackingAction campaignTrackingAction : findAll()) {
			remove(campaignTrackingAction);
		}
	}

	/**
	 * Returns the number of campaign tracking actions.
	 *
	 * @return the number of campaign tracking actions
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

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGNTRACKINGACTION);

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
	 * Initializes the campaign tracking action persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingAction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CampaignTrackingAction>> listenersList = new ArrayList<ModelListener<CampaignTrackingAction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CampaignTrackingAction>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CampaignTrackingActionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CAMPAIGNTRACKINGACTION = "SELECT campaignTrackingAction FROM CampaignTrackingAction campaignTrackingAction";
	private static final String _SQL_SELECT_CAMPAIGNTRACKINGACTION_WHERE = "SELECT campaignTrackingAction FROM CampaignTrackingAction campaignTrackingAction WHERE ";
	private static final String _SQL_COUNT_CAMPAIGNTRACKINGACTION = "SELECT COUNT(campaignTrackingAction) FROM CampaignTrackingAction campaignTrackingAction";
	private static final String _SQL_COUNT_CAMPAIGNTRACKINGACTION_WHERE = "SELECT COUNT(campaignTrackingAction) FROM CampaignTrackingAction campaignTrackingAction WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignTrackingAction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CampaignTrackingAction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CampaignTrackingAction exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CampaignTrackingActionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"alias"
			});
	private static CampaignTrackingAction _nullCampaignTrackingAction = new CampaignTrackingActionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CampaignTrackingAction> toCacheModel() {
				return _nullCampaignTrackingActionCacheModel;
			}
		};

	private static CacheModel<CampaignTrackingAction> _nullCampaignTrackingActionCacheModel =
		new CacheModel<CampaignTrackingAction>() {
			@Override
			public CampaignTrackingAction toEntityModel() {
				return _nullCampaignTrackingAction;
			}
		};
}