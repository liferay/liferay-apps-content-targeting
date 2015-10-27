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

import com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException;
import com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData;
import com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataImpl;
import com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl;

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
 * The persistence implementation for the consumer data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerDataPersistence
 * @see ConsumerDataUtil
 * @generated
 */
public class ConsumerDataPersistenceImpl extends BasePersistenceImpl<ConsumerData>
	implements ConsumerDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConsumerDataUtil} to access the consumer data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConsumerDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, ConsumerDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, ConsumerDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, ConsumerDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, ConsumerDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			ConsumerDataModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			ConsumerDataModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the consumer datas where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findByCampaignId(long campaignId)
		throws SystemException {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer datas where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of consumer datas
	 * @param end the upper bound of the range of consumer datas (not inclusive)
	 * @return the range of matching consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findByCampaignId(long campaignId, int start,
		int end) throws SystemException {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer datas where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of consumer datas
	 * @param end the upper bound of the range of consumer datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findByCampaignId(long campaignId, int start,
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

		List<ConsumerData> list = (List<ConsumerData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerData consumerData : list) {
				if ((campaignId != consumerData.getCampaignId())) {
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

			query.append(_SQL_SELECT_CONSUMERDATA_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConsumerDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<ConsumerData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerData>(list);
				}
				else {
					list = (List<ConsumerData>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first consumer data in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData findByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = fetchByCampaignId_First(campaignId,
				orderByComparator);

		if (consumerData != null) {
			return consumerData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerDataException(msg.toString());
	}

	/**
	 * Returns the first consumer data in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer data, or <code>null</code> if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData fetchByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConsumerData> list = findByCampaignId(campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer data in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData findByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = fetchByCampaignId_Last(campaignId,
				orderByComparator);

		if (consumerData != null) {
			return consumerData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerDataException(msg.toString());
	}

	/**
	 * Returns the last consumer data in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer data, or <code>null</code> if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData fetchByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<ConsumerData> list = findByCampaignId(campaignId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer datas before and after the current consumer data in the ordered set where campaignId = &#63;.
	 *
	 * @param consumerDataId the primary key of the current consumer data
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData[] findByCampaignId_PrevAndNext(long consumerDataId,
		long campaignId, OrderByComparator orderByComparator)
		throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = findByPrimaryKey(consumerDataId);

		Session session = null;

		try {
			session = openSession();

			ConsumerData[] array = new ConsumerDataImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, consumerData,
					campaignId, orderByComparator, true);

			array[1] = consumerData;

			array[2] = getByCampaignId_PrevAndNext(session, consumerData,
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

	protected ConsumerData getByCampaignId_PrevAndNext(Session session,
		ConsumerData consumerData, long campaignId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMERDATA_WHERE);

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
			query.append(ConsumerDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(consumerData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer datas where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long campaignId) throws SystemException {
		for (ConsumerData consumerData : findByCampaignId(campaignId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumerData);
		}
	}

	/**
	 * Returns the number of consumer datas where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching consumer datas
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

			query.append(_SQL_COUNT_CONSUMERDATA_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "consumerData.campaignId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, ConsumerDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, ConsumerDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventType",
			new String[] { String.class.getName() },
			ConsumerDataModelImpl.EVENTTYPE_COLUMN_BITMASK |
			ConsumerDataModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTTYPE = new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the consumer datas where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findByEventType(String eventType)
		throws SystemException {
		return findByEventType(eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the consumer datas where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of consumer datas
	 * @param end the upper bound of the range of consumer datas (not inclusive)
	 * @return the range of matching consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findByEventType(String eventType, int start,
		int end) throws SystemException {
		return findByEventType(eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer datas where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of consumer datas
	 * @param end the upper bound of the range of consumer datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findByEventType(String eventType, int start,
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

		List<ConsumerData> list = (List<ConsumerData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerData consumerData : list) {
				if (!Validator.equals(eventType, consumerData.getEventType())) {
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

			query.append(_SQL_SELECT_CONSUMERDATA_WHERE);

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
				query.append(ConsumerDataModelImpl.ORDER_BY_JPQL);
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
					list = (List<ConsumerData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerData>(list);
				}
				else {
					list = (List<ConsumerData>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first consumer data in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData findByEventType_First(String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = fetchByEventType_First(eventType,
				orderByComparator);

		if (consumerData != null) {
			return consumerData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerDataException(msg.toString());
	}

	/**
	 * Returns the first consumer data in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer data, or <code>null</code> if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData fetchByEventType_First(String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConsumerData> list = findByEventType(eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer data in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData findByEventType_Last(String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = fetchByEventType_Last(eventType,
				orderByComparator);

		if (consumerData != null) {
			return consumerData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerDataException(msg.toString());
	}

	/**
	 * Returns the last consumer data in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer data, or <code>null</code> if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData fetchByEventType_Last(String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventType(eventType);

		if (count == 0) {
			return null;
		}

		List<ConsumerData> list = findByEventType(eventType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer datas before and after the current consumer data in the ordered set where eventType = &#63;.
	 *
	 * @param consumerDataId the primary key of the current consumer data
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData[] findByEventType_PrevAndNext(long consumerDataId,
		String eventType, OrderByComparator orderByComparator)
		throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = findByPrimaryKey(consumerDataId);

		Session session = null;

		try {
			session = openSession();

			ConsumerData[] array = new ConsumerDataImpl[3];

			array[0] = getByEventType_PrevAndNext(session, consumerData,
					eventType, orderByComparator, true);

			array[1] = consumerData;

			array[2] = getByEventType_PrevAndNext(session, consumerData,
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

	protected ConsumerData getByEventType_PrevAndNext(Session session,
		ConsumerData consumerData, String eventType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMERDATA_WHERE);

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
			query.append(ConsumerDataModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(consumerData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer datas where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventType(String eventType) throws SystemException {
		for (ConsumerData consumerData : findByEventType(eventType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumerData);
		}
	}

	/**
	 * Returns the number of consumer datas where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching consumer datas
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

			query.append(_SQL_COUNT_CONSUMERDATA_WHERE);

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

	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1 = "consumerData.eventType IS NULL";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2 = "consumerData.eventType = ?";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3 = "(consumerData.eventType IS NULL OR consumerData.eventType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD = new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, ConsumerDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_GtD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_GTD = new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_GtD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the consumer datas where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @return the matching consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findByC_GtD(long campaignId, Date modifiedDate)
		throws SystemException {
		return findByC_GtD(campaignId, modifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer datas where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of consumer datas
	 * @param end the upper bound of the range of consumer datas (not inclusive)
	 * @return the range of matching consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findByC_GtD(long campaignId, Date modifiedDate,
		int start, int end) throws SystemException {
		return findByC_GtD(campaignId, modifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer datas where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of consumer datas
	 * @param end the upper bound of the range of consumer datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findByC_GtD(long campaignId, Date modifiedDate,
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

		List<ConsumerData> list = (List<ConsumerData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConsumerData consumerData : list) {
				if ((campaignId != consumerData.getCampaignId()) ||
						(modifiedDate.getTime() >= consumerData.getModifiedDate()
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

			query.append(_SQL_SELECT_CONSUMERDATA_WHERE);

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
				query.append(ConsumerDataModelImpl.ORDER_BY_JPQL);
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
					list = (List<ConsumerData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerData>(list);
				}
				else {
					list = (List<ConsumerData>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first consumer data in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData findByC_GtD_First(long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = fetchByC_GtD_First(campaignId,
				modifiedDate, orderByComparator);

		if (consumerData != null) {
			return consumerData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerDataException(msg.toString());
	}

	/**
	 * Returns the first consumer data in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer data, or <code>null</code> if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData fetchByC_GtD_First(long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConsumerData> list = findByC_GtD(campaignId, modifiedDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer data in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData findByC_GtD_Last(long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = fetchByC_GtD_Last(campaignId, modifiedDate,
				orderByComparator);

		if (consumerData != null) {
			return consumerData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConsumerDataException(msg.toString());
	}

	/**
	 * Returns the last consumer data in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer data, or <code>null</code> if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData fetchByC_GtD_Last(long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_GtD(campaignId, modifiedDate);

		if (count == 0) {
			return null;
		}

		List<ConsumerData> list = findByC_GtD(campaignId, modifiedDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer datas before and after the current consumer data in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param consumerDataId the primary key of the current consumer data
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData[] findByC_GtD_PrevAndNext(long consumerDataId,
		long campaignId, Date modifiedDate, OrderByComparator orderByComparator)
		throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = findByPrimaryKey(consumerDataId);

		Session session = null;

		try {
			session = openSession();

			ConsumerData[] array = new ConsumerDataImpl[3];

			array[0] = getByC_GtD_PrevAndNext(session, consumerData,
					campaignId, modifiedDate, orderByComparator, true);

			array[1] = consumerData;

			array[2] = getByC_GtD_PrevAndNext(session, consumerData,
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

	protected ConsumerData getByC_GtD_PrevAndNext(Session session,
		ConsumerData consumerData, long campaignId, Date modifiedDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSUMERDATA_WHERE);

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
			query.append(ConsumerDataModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(consumerData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConsumerData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer datas where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_GtD(long campaignId, Date modifiedDate)
		throws SystemException {
		for (ConsumerData consumerData : findByC_GtD(campaignId, modifiedDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(consumerData);
		}
	}

	/**
	 * Returns the number of consumer datas where campaignId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param modifiedDate the modified date
	 * @return the number of matching consumer datas
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

			query.append(_SQL_COUNT_CONSUMERDATA_WHERE);

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

	private static final String _FINDER_COLUMN_C_GTD_CAMPAIGNID_2 = "consumerData.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_GTD_MODIFIEDDATE_1 = "consumerData.modifiedDate > NULL";
	private static final String _FINDER_COLUMN_C_GTD_MODIFIEDDATE_2 = "consumerData.modifiedDate > ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_C_E = new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, ConsumerDataImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_C_E",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			ConsumerDataModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			ConsumerDataModelImpl.CONSUMERID_COLUMN_BITMASK |
			ConsumerDataModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_E = new FinderPath(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_E",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the consumer data where campaignId = &#63; and consumerId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException} if it could not be found.
	 *
	 * @param campaignId the campaign ID
	 * @param consumerId the consumer ID
	 * @param eventType the event type
	 * @return the matching consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData findByC_C_E(long campaignId, long consumerId,
		String eventType) throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = fetchByC_C_E(campaignId, consumerId,
				eventType);

		if (consumerData == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

			msg.append(", consumerId=");
			msg.append(consumerId);

			msg.append(", eventType=");
			msg.append(eventType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchConsumerDataException(msg.toString());
		}

		return consumerData;
	}

	/**
	 * Returns the consumer data where campaignId = &#63; and consumerId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param consumerId the consumer ID
	 * @param eventType the event type
	 * @return the matching consumer data, or <code>null</code> if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData fetchByC_C_E(long campaignId, long consumerId,
		String eventType) throws SystemException {
		return fetchByC_C_E(campaignId, consumerId, eventType, true);
	}

	/**
	 * Returns the consumer data where campaignId = &#63; and consumerId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param consumerId the consumer ID
	 * @param eventType the event type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching consumer data, or <code>null</code> if a matching consumer data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData fetchByC_C_E(long campaignId, long consumerId,
		String eventType, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { campaignId, consumerId, eventType };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_C_E,
					finderArgs, this);
		}

		if (result instanceof ConsumerData) {
			ConsumerData consumerData = (ConsumerData)result;

			if ((campaignId != consumerData.getCampaignId()) ||
					(consumerId != consumerData.getConsumerId()) ||
					!Validator.equals(eventType, consumerData.getEventType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_CONSUMERDATA_WHERE);

			query.append(_FINDER_COLUMN_C_C_E_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_C_C_E_CONSUMERID_2);

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

				qPos.add(campaignId);

				qPos.add(consumerId);

				if (bindEventType) {
					qPos.add(eventType);
				}

				List<ConsumerData> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_E,
						finderArgs, list);
				}
				else {
					ConsumerData consumerData = list.get(0);

					result = consumerData;

					cacheResult(consumerData);

					if ((consumerData.getCampaignId() != campaignId) ||
							(consumerData.getConsumerId() != consumerId) ||
							(consumerData.getEventType() == null) ||
							!consumerData.getEventType().equals(eventType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_E,
							finderArgs, consumerData);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C_E,
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
			return (ConsumerData)result;
		}
	}

	/**
	 * Removes the consumer data where campaignId = &#63; and consumerId = &#63; and eventType = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param consumerId the consumer ID
	 * @param eventType the event type
	 * @return the consumer data that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData removeByC_C_E(long campaignId, long consumerId,
		String eventType) throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = findByC_C_E(campaignId, consumerId,
				eventType);

		return remove(consumerData);
	}

	/**
	 * Returns the number of consumer datas where campaignId = &#63; and consumerId = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param consumerId the consumer ID
	 * @param eventType the event type
	 * @return the number of matching consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_E(long campaignId, long consumerId, String eventType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_E;

		Object[] finderArgs = new Object[] { campaignId, consumerId, eventType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONSUMERDATA_WHERE);

			query.append(_FINDER_COLUMN_C_C_E_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_C_C_E_CONSUMERID_2);

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

				qPos.add(campaignId);

				qPos.add(consumerId);

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

	private static final String _FINDER_COLUMN_C_C_E_CAMPAIGNID_2 = "consumerData.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_E_CONSUMERID_2 = "consumerData.consumerId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_E_EVENTTYPE_1 = "consumerData.eventType IS NULL";
	private static final String _FINDER_COLUMN_C_C_E_EVENTTYPE_2 = "consumerData.eventType = ?";
	private static final String _FINDER_COLUMN_C_C_E_EVENTTYPE_3 = "(consumerData.eventType IS NULL OR consumerData.eventType = '')";

	public ConsumerDataPersistenceImpl() {
		setModelClass(ConsumerData.class);
	}

	/**
	 * Caches the consumer data in the entity cache if it is enabled.
	 *
	 * @param consumerData the consumer data
	 */
	@Override
	public void cacheResult(ConsumerData consumerData) {
		EntityCacheUtil.putResult(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataImpl.class, consumerData.getPrimaryKey(), consumerData);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_E,
			new Object[] {
				consumerData.getCampaignId(), consumerData.getConsumerId(),
				consumerData.getEventType()
			}, consumerData);

		consumerData.resetOriginalValues();
	}

	/**
	 * Caches the consumer datas in the entity cache if it is enabled.
	 *
	 * @param consumerDatas the consumer datas
	 */
	@Override
	public void cacheResult(List<ConsumerData> consumerDatas) {
		for (ConsumerData consumerData : consumerDatas) {
			if (EntityCacheUtil.getResult(
						ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
						ConsumerDataImpl.class, consumerData.getPrimaryKey()) == null) {
				cacheResult(consumerData);
			}
			else {
				consumerData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all consumer datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConsumerDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConsumerDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the consumer data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConsumerData consumerData) {
		EntityCacheUtil.removeResult(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataImpl.class, consumerData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(consumerData);
	}

	@Override
	public void clearCache(List<ConsumerData> consumerDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConsumerData consumerData : consumerDatas) {
			EntityCacheUtil.removeResult(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
				ConsumerDataImpl.class, consumerData.getPrimaryKey());

			clearUniqueFindersCache(consumerData);
		}
	}

	protected void cacheUniqueFindersCache(ConsumerData consumerData) {
		if (consumerData.isNew()) {
			Object[] args = new Object[] {
					consumerData.getCampaignId(), consumerData.getConsumerId(),
					consumerData.getEventType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C_E, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_E, args,
				consumerData);
		}
		else {
			ConsumerDataModelImpl consumerDataModelImpl = (ConsumerDataModelImpl)consumerData;

			if ((consumerDataModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_C_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerData.getCampaignId(),
						consumerData.getConsumerId(),
						consumerData.getEventType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C_E, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C_E, args,
					consumerData);
			}
		}
	}

	protected void clearUniqueFindersCache(ConsumerData consumerData) {
		ConsumerDataModelImpl consumerDataModelImpl = (ConsumerDataModelImpl)consumerData;

		Object[] args = new Object[] {
				consumerData.getCampaignId(), consumerData.getConsumerId(),
				consumerData.getEventType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_E, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C_E, args);

		if ((consumerDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_C_E.getColumnBitmask()) != 0) {
			args = new Object[] {
					consumerDataModelImpl.getOriginalCampaignId(),
					consumerDataModelImpl.getOriginalConsumerId(),
					consumerDataModelImpl.getOriginalEventType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_E, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C_E, args);
		}
	}

	/**
	 * Creates a new consumer data with the primary key. Does not add the consumer data to the database.
	 *
	 * @param consumerDataId the primary key for the new consumer data
	 * @return the new consumer data
	 */
	@Override
	public ConsumerData create(long consumerDataId) {
		ConsumerData consumerData = new ConsumerDataImpl();

		consumerData.setNew(true);
		consumerData.setPrimaryKey(consumerDataId);

		return consumerData;
	}

	/**
	 * Removes the consumer data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param consumerDataId the primary key of the consumer data
	 * @return the consumer data that was removed
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData remove(long consumerDataId)
		throws NoSuchConsumerDataException, SystemException {
		return remove((Serializable)consumerDataId);
	}

	/**
	 * Removes the consumer data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the consumer data
	 * @return the consumer data that was removed
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData remove(Serializable primaryKey)
		throws NoSuchConsumerDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ConsumerData consumerData = (ConsumerData)session.get(ConsumerDataImpl.class,
					primaryKey);

			if (consumerData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConsumerDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(consumerData);
		}
		catch (NoSuchConsumerDataException nsee) {
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
	protected ConsumerData removeImpl(ConsumerData consumerData)
		throws SystemException {
		consumerData = toUnwrappedModel(consumerData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(consumerData)) {
				consumerData = (ConsumerData)session.get(ConsumerDataImpl.class,
						consumerData.getPrimaryKeyObj());
			}

			if (consumerData != null) {
				session.delete(consumerData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (consumerData != null) {
			clearCache(consumerData);
		}

		return consumerData;
	}

	@Override
	public ConsumerData updateImpl(
		com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData consumerData)
		throws SystemException {
		consumerData = toUnwrappedModel(consumerData);

		boolean isNew = consumerData.isNew();

		ConsumerDataModelImpl consumerDataModelImpl = (ConsumerDataModelImpl)consumerData;

		Session session = null;

		try {
			session = openSession();

			if (consumerData.isNew()) {
				session.save(consumerData);

				consumerData.setNew(false);
			}
			else {
				session.merge(consumerData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ConsumerDataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((consumerDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerDataModelImpl.getOriginalCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { consumerDataModelImpl.getCampaignId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((consumerDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						consumerDataModelImpl.getOriginalEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);

				args = new Object[] { consumerDataModelImpl.getEventType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
			ConsumerDataImpl.class, consumerData.getPrimaryKey(), consumerData);

		clearUniqueFindersCache(consumerData);
		cacheUniqueFindersCache(consumerData);

		return consumerData;
	}

	protected ConsumerData toUnwrappedModel(ConsumerData consumerData) {
		if (consumerData instanceof ConsumerDataImpl) {
			return consumerData;
		}

		ConsumerDataImpl consumerDataImpl = new ConsumerDataImpl();

		consumerDataImpl.setNew(consumerData.isNew());
		consumerDataImpl.setPrimaryKey(consumerData.getPrimaryKey());

		consumerDataImpl.setConsumerDataId(consumerData.getConsumerDataId());
		consumerDataImpl.setCampaignId(consumerData.getCampaignId());
		consumerDataImpl.setCount(consumerData.getCount());
		consumerDataImpl.setModifiedDate(consumerData.getModifiedDate());
		consumerDataImpl.setEventType(consumerData.getEventType());
		consumerDataImpl.setElementId(consumerData.getElementId());
		consumerDataImpl.setConsumerId(consumerData.getConsumerId());

		return consumerDataImpl;
	}

	/**
	 * Returns the consumer data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the consumer data
	 * @return the consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConsumerDataException, SystemException {
		ConsumerData consumerData = fetchByPrimaryKey(primaryKey);

		if (consumerData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConsumerDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return consumerData;
	}

	/**
	 * Returns the consumer data with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException} if it could not be found.
	 *
	 * @param consumerDataId the primary key of the consumer data
	 * @return the consumer data
	 * @throws com.liferay.content.targeting.report.campaign.mobile.NoSuchConsumerDataException if a consumer data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData findByPrimaryKey(long consumerDataId)
		throws NoSuchConsumerDataException, SystemException {
		return findByPrimaryKey((Serializable)consumerDataId);
	}

	/**
	 * Returns the consumer data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the consumer data
	 * @return the consumer data, or <code>null</code> if a consumer data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ConsumerData consumerData = (ConsumerData)EntityCacheUtil.getResult(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
				ConsumerDataImpl.class, primaryKey);

		if (consumerData == _nullConsumerData) {
			return null;
		}

		if (consumerData == null) {
			Session session = null;

			try {
				session = openSession();

				consumerData = (ConsumerData)session.get(ConsumerDataImpl.class,
						primaryKey);

				if (consumerData != null) {
					cacheResult(consumerData);
				}
				else {
					EntityCacheUtil.putResult(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
						ConsumerDataImpl.class, primaryKey, _nullConsumerData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConsumerDataModelImpl.ENTITY_CACHE_ENABLED,
					ConsumerDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return consumerData;
	}

	/**
	 * Returns the consumer data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param consumerDataId the primary key of the consumer data
	 * @return the consumer data, or <code>null</code> if a consumer data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerData fetchByPrimaryKey(long consumerDataId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)consumerDataId);
	}

	/**
	 * Returns all the consumer datas.
	 *
	 * @return the consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer datas
	 * @param end the upper bound of the range of consumer datas (not inclusive)
	 * @return the range of consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.mobile.model.impl.ConsumerDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer datas
	 * @param end the upper bound of the range of consumer datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of consumer datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerData> findAll(int start, int end,
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

		List<ConsumerData> list = (List<ConsumerData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONSUMERDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONSUMERDATA;

				if (pagination) {
					sql = sql.concat(ConsumerDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ConsumerData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConsumerData>(list);
				}
				else {
					list = (List<ConsumerData>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the consumer datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ConsumerData consumerData : findAll()) {
			remove(consumerData);
		}
	}

	/**
	 * Returns the number of consumer datas.
	 *
	 * @return the number of consumer datas
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

				Query q = session.createQuery(_SQL_COUNT_CONSUMERDATA);

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
	 * Initializes the consumer data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.report.campaign.mobile.model.ConsumerData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ConsumerData>> listenersList = new ArrayList<ModelListener<ConsumerData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ConsumerData>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConsumerDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONSUMERDATA = "SELECT consumerData FROM ConsumerData consumerData";
	private static final String _SQL_SELECT_CONSUMERDATA_WHERE = "SELECT consumerData FROM ConsumerData consumerData WHERE ";
	private static final String _SQL_COUNT_CONSUMERDATA = "SELECT COUNT(consumerData) FROM ConsumerData consumerData";
	private static final String _SQL_COUNT_CONSUMERDATA_WHERE = "SELECT COUNT(consumerData) FROM ConsumerData consumerData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "consumerData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConsumerData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ConsumerData exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConsumerDataPersistenceImpl.class);
	private static ConsumerData _nullConsumerData = new ConsumerDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ConsumerData> toCacheModel() {
				return _nullConsumerDataCacheModel;
			}
		};

	private static CacheModel<ConsumerData> _nullConsumerDataCacheModel = new CacheModel<ConsumerData>() {
			@Override
			public ConsumerData toEntityModel() {
				return _nullConsumerData;
			}
		};
}