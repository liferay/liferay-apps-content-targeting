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

package com.liferay.content.targeting.report.campaign.mobile.service.persistence;

import com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException;
import com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile;
import com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileImpl;
import com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl;

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
 * The persistence implementation for the campaign mobile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignMobilePersistence
 * @see CampaignMobileUtil
 * @generated
 */
public class CampaignMobilePersistenceImpl extends BasePersistenceImpl<CampaignMobile>
	implements CampaignMobilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignMobileUtil} to access the campaign mobile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignMobileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED,
			CampaignMobileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED,
			CampaignMobileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED,
			CampaignMobileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED,
			CampaignMobileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			CampaignMobileModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignMobileModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the campaign mobiles where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findByCampaignId(long campaignId)
		throws SystemException {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign mobiles where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign mobiles
	 * @param end the upper bound of the range of campaign mobiles (not inclusive)
	 * @return the range of matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findByCampaignId(long campaignId, int start,
		int end) throws SystemException {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign mobiles where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign mobiles
	 * @param end the upper bound of the range of campaign mobiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findByCampaignId(long campaignId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<CampaignMobile> list = (List<CampaignMobile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignMobile campaignMobile : list) {
				if ((campaignId != campaignMobile.getCampaignId())) {
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

			query.append(_SQL_SELECT_CAMPAIGNMOBILE_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampaignMobileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<CampaignMobile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignMobile>(list);
				}
				else {
					list = (List<CampaignMobile>)QueryUtil.list(q,
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
	 * Returns the first campaign mobile in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile findByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = fetchByCampaignId_First(campaignId,
				orderByComparator);

		if (campaignMobile != null) {
			return campaignMobile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignMobileException(msg.toString());
	}

	/**
	 * Returns the first campaign mobile in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile fetchByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CampaignMobile> list = findByCampaignId(campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign mobile in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile findByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = fetchByCampaignId_Last(campaignId,
				orderByComparator);

		if (campaignMobile != null) {
			return campaignMobile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignMobileException(msg.toString());
	}

	/**
	 * Returns the last campaign mobile in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile fetchByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<CampaignMobile> list = findByCampaignId(campaignId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign mobiles before and after the current campaign mobile in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignMobileId the primary key of the current campaign mobile
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile[] findByCampaignId_PrevAndNext(
		long campaignMobileId, long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = findByPrimaryKey(campaignMobileId);

		Session session = null;

		try {
			session = openSession();

			CampaignMobile[] array = new CampaignMobileImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, campaignMobile,
					campaignId, orderByComparator, true);

			array[1] = campaignMobile;

			array[2] = getByCampaignId_PrevAndNext(session, campaignMobile,
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

	protected CampaignMobile getByCampaignId_PrevAndNext(Session session,
		CampaignMobile campaignMobile, long campaignId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNMOBILE_WHERE);

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
			query.append(CampaignMobileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignMobile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignMobile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign mobiles where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long campaignId) throws SystemException {
		for (CampaignMobile campaignMobile : findByCampaignId(campaignId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(campaignMobile);
		}
	}

	/**
	 * Returns the number of campaign mobiles where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching campaign mobiles
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

			query.append(_SQL_COUNT_CAMPAIGNMOBILE_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "campaignMobile.campaignId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED,
			CampaignMobileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEventType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED,
			CampaignMobileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventType",
			new String[] { String.class.getName() },
			CampaignMobileModelImpl.EVENTTYPE_COLUMN_BITMASK |
			CampaignMobileModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTTYPE = new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the campaign mobiles where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findByEventType(String eventType)
		throws SystemException {
		return findByEventType(eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the campaign mobiles where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of campaign mobiles
	 * @param end the upper bound of the range of campaign mobiles (not inclusive)
	 * @return the range of matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findByEventType(String eventType, int start,
		int end) throws SystemException {
		return findByEventType(eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign mobiles where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of campaign mobiles
	 * @param end the upper bound of the range of campaign mobiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findByEventType(String eventType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType, start, end, orderByComparator };
		}

		List<CampaignMobile> list = (List<CampaignMobile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignMobile campaignMobile : list) {
				if (!Validator.equals(eventType, campaignMobile.getEventType())) {
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

			query.append(_SQL_SELECT_CAMPAIGNMOBILE_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampaignMobileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
				}

				if (!pagination) {
					list = (List<CampaignMobile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignMobile>(list);
				}
				else {
					list = (List<CampaignMobile>)QueryUtil.list(q,
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
	 * Returns the first campaign mobile in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile findByEventType_First(String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = fetchByEventType_First(eventType,
				orderByComparator);

		if (campaignMobile != null) {
			return campaignMobile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignMobileException(msg.toString());
	}

	/**
	 * Returns the first campaign mobile in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile fetchByEventType_First(String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		List<CampaignMobile> list = findByEventType(eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign mobile in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile findByEventType_Last(String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = fetchByEventType_Last(eventType,
				orderByComparator);

		if (campaignMobile != null) {
			return campaignMobile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignMobileException(msg.toString());
	}

	/**
	 * Returns the last campaign mobile in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile fetchByEventType_Last(String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventType(eventType);

		if (count == 0) {
			return null;
		}

		List<CampaignMobile> list = findByEventType(eventType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign mobiles before and after the current campaign mobile in the ordered set where eventType = &#63;.
	 *
	 * @param campaignMobileId the primary key of the current campaign mobile
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile[] findByEventType_PrevAndNext(long campaignMobileId,
		String eventType, OrderByComparator orderByComparator)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = findByPrimaryKey(campaignMobileId);

		Session session = null;

		try {
			session = openSession();

			CampaignMobile[] array = new CampaignMobileImpl[3];

			array[0] = getByEventType_PrevAndNext(session, campaignMobile,
					eventType, orderByComparator, true);

			array[1] = campaignMobile;

			array[2] = getByEventType_PrevAndNext(session, campaignMobile,
					eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignMobile getByEventType_PrevAndNext(Session session,
		CampaignMobile campaignMobile, String eventType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNMOBILE_WHERE);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
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
			query.append(CampaignMobileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignMobile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignMobile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign mobiles where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventType(String eventType) throws SystemException {
		for (CampaignMobile campaignMobile : findByEventType(eventType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(campaignMobile);
		}
	}

	/**
	 * Returns the number of campaign mobiles where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventType(String eventType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTTYPE;

		Object[] finderArgs = new Object[] { eventType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPAIGNMOBILE_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1 = "campaignMobile.eventType IS NULL";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2 = "campaignMobile.eventType = ?";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3 = "(campaignMobile.eventType IS NULL OR campaignMobile.eventType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD = new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED,
			CampaignMobileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_GtD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_GTD = new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_GtD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @return the matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findByC_GtD(long campaignId, Date modifiedDate)
		throws SystemException {
		return findByC_GtD(campaignId, modifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of campaign mobiles
	 * @param end the upper bound of the range of campaign mobiles (not inclusive)
	 * @return the range of matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findByC_GtD(long campaignId, Date modifiedDate,
		int start, int end) throws SystemException {
		return findByC_GtD(campaignId, modifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of campaign mobiles
	 * @param end the upper bound of the range of campaign mobiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findByC_GtD(long campaignId, Date modifiedDate,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD;
		finderArgs = new Object[] {
				campaignId, modifiedDate,
				
				start, end, orderByComparator
			};

		List<CampaignMobile> list = (List<CampaignMobile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignMobile campaignMobile : list) {
				if ((campaignId != campaignMobile.getCampaignId()) ||
						(modifiedDate.getTime() >= campaignMobile.getModifiedDate()
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

			query.append(_SQL_SELECT_CAMPAIGNMOBILE_WHERE);

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
				query.append(CampaignMobileModelImpl.ORDER_BY_JPQL);
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
					list = (List<CampaignMobile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignMobile>(list);
				}
				else {
					list = (List<CampaignMobile>)QueryUtil.list(q,
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
	 * Returns the first campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile findByC_GtD_First(long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = fetchByC_GtD_First(campaignId,
				modifiedDate, orderByComparator);

		if (campaignMobile != null) {
			return campaignMobile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignMobileException(msg.toString());
	}

	/**
	 * Returns the first campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile fetchByC_GtD_First(long campaignId,
		Date modifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<CampaignMobile> list = findByC_GtD(campaignId, modifiedDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile findByC_GtD_Last(long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = fetchByC_GtD_Last(campaignId,
				modifiedDate, orderByComparator);

		if (campaignMobile != null) {
			return campaignMobile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignMobileException(msg.toString());
	}

	/**
	 * Returns the last campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile fetchByC_GtD_Last(long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_GtD(campaignId, modifiedDate);

		if (count == 0) {
			return null;
		}

		List<CampaignMobile> list = findByC_GtD(campaignId, modifiedDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign mobiles before and after the current campaign mobile in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignMobileId the primary key of the current campaign mobile
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile[] findByC_GtD_PrevAndNext(long campaignMobileId,
		long campaignId, Date modifiedDate, OrderByComparator orderByComparator)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = findByPrimaryKey(campaignMobileId);

		Session session = null;

		try {
			session = openSession();

			CampaignMobile[] array = new CampaignMobileImpl[3];

			array[0] = getByC_GtD_PrevAndNext(session, campaignMobile,
					campaignId, modifiedDate, orderByComparator, true);

			array[1] = campaignMobile;

			array[2] = getByC_GtD_PrevAndNext(session, campaignMobile,
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

	protected CampaignMobile getByC_GtD_PrevAndNext(Session session,
		CampaignMobile campaignMobile, long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNMOBILE_WHERE);

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
			query.append(CampaignMobileModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(campaignMobile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignMobile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_GtD(long campaignId, Date modifiedDate)
		throws SystemException {
		for (CampaignMobile campaignMobile : findByC_GtD(campaignId,
				modifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(campaignMobile);
		}
	}

	/**
	 * Returns the number of campaign mobiles where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @return the number of matching campaign mobiles
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

			query.append(_SQL_COUNT_CAMPAIGNMOBILE_WHERE);

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

	private static final String _FINDER_COLUMN_C_GTD_CAMPAIGNID_2 = "campaignMobile.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_GTD_MODIFIEDDATE_1 = "campaignMobile.modifiedDate > NULL";
	private static final String _FINDER_COLUMN_C_GTD_MODIFIEDDATE_2 = "campaignMobile.modifiedDate > ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E = new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED,
			CampaignMobileImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_C_P_U_C_C_E",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			CampaignMobileModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignMobileModelImpl.CONSUMERID_COLUMN_BITMASK |
			CampaignMobileModelImpl.PLACEHOLDERID_COLUMN_BITMASK |
			CampaignMobileModelImpl.USERSEGMENTID_COLUMN_BITMASK |
			CampaignMobileModelImpl.CLASSNAME_COLUMN_BITMASK |
			CampaignMobileModelImpl.CLASSPK_COLUMN_BITMASK |
			CampaignMobileModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_P_U_C_C_E = new FinderPath(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_P_U_C_C_E",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			});

	/**
	 * Returns the campaign mobile where campaignId = &#63; and consumerId = &#63; and placeholderId = &#63; and userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException} if it could not be found.
	 *
	 * @param campaignId the campaign ID
	 * @param consumerId the consumer ID
	 * @param placeholderId the placeholder ID
	 * @param userSegmentId the user segment ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the matching campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile findByC_C_P_U_C_C_E(long campaignId, long consumerId,
		long placeholderId, long userSegmentId, String className, long classPK,
		String eventType) throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = fetchByC_C_P_U_C_C_E(campaignId,
				consumerId, placeholderId, userSegmentId, className, classPK,
				eventType);

		if (campaignMobile == null) {
			StringBundler msg = new StringBundler(16);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

			msg.append(", consumerId=");
			msg.append(consumerId);

			msg.append(", placeholderId=");
			msg.append(placeholderId);

			msg.append(", userSegmentId=");
			msg.append(userSegmentId);

			msg.append(", className=");
			msg.append(className);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(", eventType=");
			msg.append(eventType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignMobileException(msg.toString());
		}

		return campaignMobile;
	}

	/**
	 * Returns the campaign mobile where campaignId = &#63; and consumerId = &#63; and placeholderId = &#63; and userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param consumerId the consumer ID
	 * @param placeholderId the placeholder ID
	 * @param userSegmentId the user segment ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile fetchByC_C_P_U_C_C_E(long campaignId,
		long consumerId, long placeholderId, long userSegmentId,
		String className, long classPK, String eventType)
		throws SystemException {
		return fetchByC_C_P_U_C_C_E(campaignId, consumerId, placeholderId,
			userSegmentId, className, classPK, eventType, true);
	}

	/**
	 * Returns the campaign mobile where campaignId = &#63; and consumerId = &#63; and placeholderId = &#63; and userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param consumerId the consumer ID
	 * @param placeholderId the placeholder ID
	 * @param userSegmentId the user segment ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching campaign mobile, or <code>null</code> if a matching campaign mobile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile fetchByC_C_P_U_C_C_E(long campaignId,
		long consumerId, long placeholderId, long userSegmentId,
		String className, long classPK, String eventType,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				campaignId, consumerId, placeholderId, userSegmentId, className,
				classPK, eventType
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E,
					finderArgs, this);
		}

		if (result instanceof CampaignMobile) {
			CampaignMobile campaignMobile = (CampaignMobile)result;

			if ((campaignId != campaignMobile.getCampaignId()) ||
					(consumerId != campaignMobile.getConsumerId()) ||
					(placeholderId != campaignMobile.getPlaceholderId()) ||
					(userSegmentId != campaignMobile.getUserSegmentId()) ||
					!Validator.equals(className, campaignMobile.getClassName()) ||
					(classPK != campaignMobile.getClassPK()) ||
					!Validator.equals(eventType, campaignMobile.getEventType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(9);

			query.append(_SQL_SELECT_CAMPAIGNMOBILE_WHERE);

			query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CONSUMERID_2);

			query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_PLACEHOLDERID_2);

			query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_USERSEGMENTID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				qPos.add(consumerId);

				qPos.add(placeholderId);

				qPos.add(userSegmentId);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				List<CampaignMobile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E,
						finderArgs, list);
				}
				else {
					CampaignMobile campaignMobile = list.get(0);

					result = campaignMobile;

					cacheResult(campaignMobile);

					if ((campaignMobile.getCampaignId() != campaignId) ||
							(campaignMobile.getConsumerId() != consumerId) ||
							(campaignMobile.getPlaceholderId() != placeholderId) ||
							(campaignMobile.getUserSegmentId() != userSegmentId) ||
							(campaignMobile.getClassName() == null) ||
							!campaignMobile.getClassName().equals(className) ||
							(campaignMobile.getClassPK() != classPK) ||
							(campaignMobile.getEventType() == null) ||
							!campaignMobile.getEventType().equals(eventType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E,
							finderArgs, campaignMobile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E,
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
			return (CampaignMobile)result;
		}
	}

	/**
	 * Removes the campaign mobile where campaignId = &#63; and consumerId = &#63; and placeholderId = &#63; and userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param consumerId the consumer ID
	 * @param placeholderId the placeholder ID
	 * @param userSegmentId the user segment ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the campaign mobile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile removeByC_C_P_U_C_C_E(long campaignId,
		long consumerId, long placeholderId, long userSegmentId,
		String className, long classPK, String eventType)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = findByC_C_P_U_C_C_E(campaignId,
				consumerId, placeholderId, userSegmentId, className, classPK,
				eventType);

		return remove(campaignMobile);
	}

	/**
	 * Returns the number of campaign mobiles where campaignId = &#63; and consumerId = &#63; and placeholderId = &#63; and userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param consumerId the consumer ID
	 * @param placeholderId the placeholder ID
	 * @param userSegmentId the user segment ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the number of matching campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_P_U_C_C_E(long campaignId, long consumerId,
		long placeholderId, long userSegmentId, String className, long classPK,
		String eventType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_P_U_C_C_E;

		Object[] finderArgs = new Object[] {
				campaignId, consumerId, placeholderId, userSegmentId, className,
				classPK, eventType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(8);

			query.append(_SQL_COUNT_CAMPAIGNMOBILE_WHERE);

			query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CONSUMERID_2);

			query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_PLACEHOLDERID_2);

			query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_USERSEGMENTID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_CLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_C_P_U_C_C_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				qPos.add(consumerId);

				qPos.add(placeholderId);

				qPos.add(userSegmentId);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_CAMPAIGNID_2 = "campaignMobile.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_CONSUMERID_2 = "campaignMobile.consumerId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_PLACEHOLDERID_2 = "campaignMobile.placeholderId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_USERSEGMENTID_2 = "campaignMobile.userSegmentId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_CLASSNAME_1 = "campaignMobile.className IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_CLASSNAME_2 = "campaignMobile.className = ? AND ";
	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_CLASSNAME_3 = "(campaignMobile.className IS NULL OR campaignMobile.className = '') AND ";
	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_CLASSPK_2 = "campaignMobile.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_EVENTTYPE_1 = "campaignMobile.eventType IS NULL";
	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_EVENTTYPE_2 = "campaignMobile.eventType = ?";
	private static final String _FINDER_COLUMN_C_C_P_U_C_C_E_EVENTTYPE_3 = "(campaignMobile.eventType IS NULL OR campaignMobile.eventType = '')";

	public CampaignMobilePersistenceImpl() {
		setModelClass(CampaignMobile.class);
	}

	/**
	 * Caches the campaign mobile in the entity cache if it is enabled.
	 *
	 * @param campaignMobile the campaign mobile
	 */
	@Override
	public void cacheResult(CampaignMobile campaignMobile) {
		EntityCacheUtil.putResult(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileImpl.class, campaignMobile.getPrimaryKey(),
			campaignMobile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E,
			new Object[] {
				campaignMobile.getCampaignId(), campaignMobile.getConsumerId(),
				campaignMobile.getPlaceholderId(),
				campaignMobile.getUserSegmentId(), campaignMobile.getClassName(),
				campaignMobile.getClassPK(), campaignMobile.getEventType()
			}, campaignMobile);

		campaignMobile.resetOriginalValues();
	}

	/**
	 * Caches the campaign mobiles in the entity cache if it is enabled.
	 *
	 * @param campaignMobiles the campaign mobiles
	 */
	@Override
	public void cacheResult(List<CampaignMobile> campaignMobiles) {
		for (CampaignMobile campaignMobile : campaignMobiles) {
			if (EntityCacheUtil.getResult(
						CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
						CampaignMobileImpl.class, campaignMobile.getPrimaryKey()) == null) {
				cacheResult(campaignMobile);
			}
			else {
				campaignMobile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campaign mobiles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CampaignMobileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CampaignMobileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campaign mobile.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CampaignMobile campaignMobile) {
		EntityCacheUtil.removeResult(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileImpl.class, campaignMobile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(campaignMobile);
	}

	@Override
	public void clearCache(List<CampaignMobile> campaignMobiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CampaignMobile campaignMobile : campaignMobiles) {
			EntityCacheUtil.removeResult(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
				CampaignMobileImpl.class, campaignMobile.getPrimaryKey());

			clearUniqueFindersCache(campaignMobile);
		}
	}

	protected void cacheUniqueFindersCache(CampaignMobile campaignMobile) {
		if (campaignMobile.isNew()) {
			Object[] args = new Object[] {
					campaignMobile.getCampaignId(),
					campaignMobile.getConsumerId(),
					campaignMobile.getPlaceholderId(),
					campaignMobile.getUserSegmentId(),
					campaignMobile.getClassName(), campaignMobile.getClassPK(),
					campaignMobile.getEventType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C_P_U_C_C_E, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E, args,
				campaignMobile);
		}
		else {
			CampaignMobileModelImpl campaignMobileModelImpl = (CampaignMobileModelImpl)campaignMobile;

			if ((campaignMobileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignMobile.getCampaignId(),
						campaignMobile.getConsumerId(),
						campaignMobile.getPlaceholderId(),
						campaignMobile.getUserSegmentId(),
						campaignMobile.getClassName(),
						campaignMobile.getClassPK(),
						campaignMobile.getEventType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C_P_U_C_C_E,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E,
					args, campaignMobile);
			}
		}
	}

	protected void clearUniqueFindersCache(CampaignMobile campaignMobile) {
		CampaignMobileModelImpl campaignMobileModelImpl = (CampaignMobileModelImpl)campaignMobile;

		Object[] args = new Object[] {
				campaignMobile.getCampaignId(), campaignMobile.getConsumerId(),
				campaignMobile.getPlaceholderId(),
				campaignMobile.getUserSegmentId(), campaignMobile.getClassName(),
				campaignMobile.getClassPK(), campaignMobile.getEventType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_P_U_C_C_E, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E, args);

		if ((campaignMobileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E.getColumnBitmask()) != 0) {
			args = new Object[] {
					campaignMobileModelImpl.getOriginalCampaignId(),
					campaignMobileModelImpl.getOriginalConsumerId(),
					campaignMobileModelImpl.getOriginalPlaceholderId(),
					campaignMobileModelImpl.getOriginalUserSegmentId(),
					campaignMobileModelImpl.getOriginalClassName(),
					campaignMobileModelImpl.getOriginalClassPK(),
					campaignMobileModelImpl.getOriginalEventType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_P_U_C_C_E,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C_P_U_C_C_E,
				args);
		}
	}

	/**
	 * Creates a new campaign mobile with the primary key. Does not add the campaign mobile to the database.
	 *
	 * @param campaignMobileId the primary key for the new campaign mobile
	 * @return the new campaign mobile
	 */
	@Override
	public CampaignMobile create(long campaignMobileId) {
		CampaignMobile campaignMobile = new CampaignMobileImpl();

		campaignMobile.setNew(true);
		campaignMobile.setPrimaryKey(campaignMobileId);

		return campaignMobile;
	}

	/**
	 * Removes the campaign mobile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignMobileId the primary key of the campaign mobile
	 * @return the campaign mobile that was removed
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile remove(long campaignMobileId)
		throws NoSuchCampaignMobileException, SystemException {
		return remove((Serializable)campaignMobileId);
	}

	/**
	 * Removes the campaign mobile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign mobile
	 * @return the campaign mobile that was removed
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile remove(Serializable primaryKey)
		throws NoSuchCampaignMobileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CampaignMobile campaignMobile = (CampaignMobile)session.get(CampaignMobileImpl.class,
					primaryKey);

			if (campaignMobile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignMobileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campaignMobile);
		}
		catch (NoSuchCampaignMobileException nsee) {
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
	protected CampaignMobile removeImpl(CampaignMobile campaignMobile)
		throws SystemException {
		campaignMobile = toUnwrappedModel(campaignMobile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campaignMobile)) {
				campaignMobile = (CampaignMobile)session.get(CampaignMobileImpl.class,
						campaignMobile.getPrimaryKeyObj());
			}

			if (campaignMobile != null) {
				session.delete(campaignMobile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (campaignMobile != null) {
			clearCache(campaignMobile);
		}

		return campaignMobile;
	}

	@Override
	public CampaignMobile updateImpl(
		com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile campaignMobile)
		throws SystemException {
		campaignMobile = toUnwrappedModel(campaignMobile);

		boolean isNew = campaignMobile.isNew();

		CampaignMobileModelImpl campaignMobileModelImpl = (CampaignMobileModelImpl)campaignMobile;

		Session session = null;

		try {
			session = openSession();

			if (campaignMobile.isNew()) {
				session.save(campaignMobile);

				campaignMobile.setNew(false);
			}
			else {
				session.merge(campaignMobile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CampaignMobileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((campaignMobileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignMobileModelImpl.getOriginalCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { campaignMobileModelImpl.getCampaignId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((campaignMobileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignMobileModelImpl.getOriginalEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);

				args = new Object[] { campaignMobileModelImpl.getEventType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
			CampaignMobileImpl.class, campaignMobile.getPrimaryKey(),
			campaignMobile);

		clearUniqueFindersCache(campaignMobile);
		cacheUniqueFindersCache(campaignMobile);

		return campaignMobile;
	}

	protected CampaignMobile toUnwrappedModel(CampaignMobile campaignMobile) {
		if (campaignMobile instanceof CampaignMobileImpl) {
			return campaignMobile;
		}

		CampaignMobileImpl campaignMobileImpl = new CampaignMobileImpl();

		campaignMobileImpl.setNew(campaignMobile.isNew());
		campaignMobileImpl.setPrimaryKey(campaignMobile.getPrimaryKey());

		campaignMobileImpl.setCampaignMobileId(campaignMobile.getCampaignMobileId());
		campaignMobileImpl.setCampaignId(campaignMobile.getCampaignId());
		campaignMobileImpl.setCount(campaignMobile.getCount());
		campaignMobileImpl.setModifiedDate(campaignMobile.getModifiedDate());
		campaignMobileImpl.setEventType(campaignMobile.getEventType());
		campaignMobileImpl.setClassName(campaignMobile.getClassName());
		campaignMobileImpl.setClassPK(campaignMobile.getClassPK());
		campaignMobileImpl.setElementId(campaignMobile.getElementId());
		campaignMobileImpl.setConsumerId(campaignMobile.getConsumerId());
		campaignMobileImpl.setPlaceholderId(campaignMobile.getPlaceholderId());
		campaignMobileImpl.setUserSegmentId(campaignMobile.getUserSegmentId());

		return campaignMobileImpl;
	}

	/**
	 * Returns the campaign mobile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign mobile
	 * @return the campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignMobileException, SystemException {
		CampaignMobile campaignMobile = fetchByPrimaryKey(primaryKey);

		if (campaignMobile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignMobileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return campaignMobile;
	}

	/**
	 * Returns the campaign mobile with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException} if it could not be found.
	 *
	 * @param campaignMobileId the primary key of the campaign mobile
	 * @return the campaign mobile
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchCampaignMobileException if a campaign mobile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile findByPrimaryKey(long campaignMobileId)
		throws NoSuchCampaignMobileException, SystemException {
		return findByPrimaryKey((Serializable)campaignMobileId);
	}

	/**
	 * Returns the campaign mobile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign mobile
	 * @return the campaign mobile, or <code>null</code> if a campaign mobile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CampaignMobile campaignMobile = (CampaignMobile)EntityCacheUtil.getResult(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
				CampaignMobileImpl.class, primaryKey);

		if (campaignMobile == _nullCampaignMobile) {
			return null;
		}

		if (campaignMobile == null) {
			Session session = null;

			try {
				session = openSession();

				campaignMobile = (CampaignMobile)session.get(CampaignMobileImpl.class,
						primaryKey);

				if (campaignMobile != null) {
					cacheResult(campaignMobile);
				}
				else {
					EntityCacheUtil.putResult(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
						CampaignMobileImpl.class, primaryKey,
						_nullCampaignMobile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CampaignMobileModelImpl.ENTITY_CACHE_ENABLED,
					CampaignMobileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return campaignMobile;
	}

	/**
	 * Returns the campaign mobile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignMobileId the primary key of the campaign mobile
	 * @return the campaign mobile, or <code>null</code> if a campaign mobile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignMobile fetchByPrimaryKey(long campaignMobileId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)campaignMobileId);
	}

	/**
	 * Returns all the campaign mobiles.
	 *
	 * @return the campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign mobiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign mobiles
	 * @param end the upper bound of the range of campaign mobiles (not inclusive)
	 * @return the range of campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign mobiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.CampaignMobileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign mobiles
	 * @param end the upper bound of the range of campaign mobiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaign mobiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignMobile> findAll(int start, int end,
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

		List<CampaignMobile> list = (List<CampaignMobile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAMPAIGNMOBILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNMOBILE;

				if (pagination) {
					sql = sql.concat(CampaignMobileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CampaignMobile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignMobile>(list);
				}
				else {
					list = (List<CampaignMobile>)QueryUtil.list(q,
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
	 * Removes all the campaign mobiles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CampaignMobile campaignMobile : findAll()) {
			remove(campaignMobile);
		}
	}

	/**
	 * Returns the number of campaign mobiles.
	 *
	 * @return the number of campaign mobiles
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

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGNMOBILE);

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
	 * Initializes the campaign mobile persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.report.campaign.mobile.model.CampaignMobile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CampaignMobile>> listenersList = new ArrayList<ModelListener<CampaignMobile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CampaignMobile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CampaignMobileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CAMPAIGNMOBILE = "SELECT campaignMobile FROM CampaignMobile campaignMobile";
	private static final String _SQL_SELECT_CAMPAIGNMOBILE_WHERE = "SELECT campaignMobile FROM CampaignMobile campaignMobile WHERE ";
	private static final String _SQL_COUNT_CAMPAIGNMOBILE = "SELECT COUNT(campaignMobile) FROM CampaignMobile campaignMobile";
	private static final String _SQL_COUNT_CAMPAIGNMOBILE_WHERE = "SELECT COUNT(campaignMobile) FROM CampaignMobile campaignMobile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignMobile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CampaignMobile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CampaignMobile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CampaignMobilePersistenceImpl.class);
	private static CampaignMobile _nullCampaignMobile = new CampaignMobileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CampaignMobile> toCacheModel() {
				return _nullCampaignMobileCacheModel;
			}
		};

	private static CacheModel<CampaignMobile> _nullCampaignMobileCacheModel = new CacheModel<CampaignMobile>() {
			@Override
			public CampaignMobile toEntityModel() {
				return _nullCampaignMobile;
			}
		};
}