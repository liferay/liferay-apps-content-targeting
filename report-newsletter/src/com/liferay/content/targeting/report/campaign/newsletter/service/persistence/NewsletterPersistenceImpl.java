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

package com.liferay.content.targeting.report.campaign.newsletter.service.persistence;

import com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException;
import com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter;
import com.liferay.content.targeting.report.campaign.newsletter.model.impl.NewsletterImpl;
import com.liferay.content.targeting.report.campaign.newsletter.model.impl.NewsletterModelImpl;

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
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the newsletter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterPersistence
 * @see NewsletterUtil
 * @generated
 */
public class NewsletterPersistenceImpl extends BasePersistenceImpl<Newsletter>
	implements NewsletterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NewsletterUtil} to access the newsletter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NewsletterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			NewsletterModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			NewsletterModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the newsletters where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching newsletters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Newsletter> findByCampaignId(long campaignId)
		throws SystemException {
		return findByCampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletters where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of matching newsletters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Newsletter> findByCampaignId(long campaignId, int start, int end)
		throws SystemException {
		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the newsletters where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Newsletter> findByCampaignId(long campaignId, int start,
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

		List<Newsletter> list = (List<Newsletter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Newsletter newsletter : list) {
				if ((campaignId != newsletter.getCampaignId())) {
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

			query.append(_SQL_SELECT_NEWSLETTER_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NewsletterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Newsletter>(list);
				}
				else {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first newsletter in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter findByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchNewsletterException, SystemException {
		Newsletter newsletter = fetchByCampaignId_First(campaignId,
				orderByComparator);

		if (newsletter != null) {
			return newsletter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNewsletterException(msg.toString());
	}

	/**
	 * Returns the first newsletter in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter fetchByCampaignId_First(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Newsletter> list = findByCampaignId(campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last newsletter in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter findByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchNewsletterException, SystemException {
		Newsletter newsletter = fetchByCampaignId_Last(campaignId,
				orderByComparator);

		if (newsletter != null) {
			return newsletter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNewsletterException(msg.toString());
	}

	/**
	 * Returns the last newsletter in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter fetchByCampaignId_Last(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<Newsletter> list = findByCampaignId(campaignId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the newsletters before and after the current newsletter in the ordered set where campaignId = &#63;.
	 *
	 * @param newsletterId the primary key of the current newsletter
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter[] findByCampaignId_PrevAndNext(long newsletterId,
		long campaignId, OrderByComparator orderByComparator)
		throws NoSuchNewsletterException, SystemException {
		Newsletter newsletter = findByPrimaryKey(newsletterId);

		Session session = null;

		try {
			session = openSession();

			Newsletter[] array = new NewsletterImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, newsletter,
					campaignId, orderByComparator, true);

			array[1] = newsletter;

			array[2] = getByCampaignId_PrevAndNext(session, newsletter,
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

	protected Newsletter getByCampaignId_PrevAndNext(Session session,
		Newsletter newsletter, long campaignId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NEWSLETTER_WHERE);

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
			query.append(NewsletterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(newsletter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Newsletter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the newsletters where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long campaignId) throws SystemException {
		for (Newsletter newsletter : findByCampaignId(campaignId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(newsletter);
		}
	}

	/**
	 * Returns the number of newsletters where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching newsletters
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

			query.append(_SQL_COUNT_NEWSLETTER_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "newsletter.campaignId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_A_E_E = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_A_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			NewsletterModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			NewsletterModelImpl.ALIAS_COLUMN_BITMASK |
			NewsletterModelImpl.ELEMENTID_COLUMN_BITMASK |
			NewsletterModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_A_E_E = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_A_E_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns the newsletter where campaignId = &#63; and alias = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException} if it could not be found.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching newsletter
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter findByC_A_E_E(long campaignId, String alias,
		String elementId, String eventType)
		throws NoSuchNewsletterException, SystemException {
		Newsletter newsletter = fetchByC_A_E_E(campaignId, alias, elementId,
				eventType);

		if (newsletter == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

			msg.append(", alias=");
			msg.append(alias);

			msg.append(", elementId=");
			msg.append(elementId);

			msg.append(", eventType=");
			msg.append(eventType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNewsletterException(msg.toString());
		}

		return newsletter;
	}

	/**
	 * Returns the newsletter where campaignId = &#63; and alias = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter fetchByC_A_E_E(long campaignId, String alias,
		String elementId, String eventType) throws SystemException {
		return fetchByC_A_E_E(campaignId, alias, elementId, eventType, true);
	}

	/**
	 * Returns the newsletter where campaignId = &#63; and alias = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter fetchByC_A_E_E(long campaignId, String alias,
		String elementId, String eventType, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				campaignId, alias, elementId, eventType
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_A_E_E,
					finderArgs, this);
		}

		if (result instanceof Newsletter) {
			Newsletter newsletter = (Newsletter)result;

			if ((campaignId != newsletter.getCampaignId()) ||
					!Validator.equals(alias, newsletter.getAlias()) ||
					!Validator.equals(elementId, newsletter.getElementId()) ||
					!Validator.equals(eventType, newsletter.getEventType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_NEWSLETTER_WHERE);

			query.append(_FINDER_COLUMN_C_A_E_E_CAMPAIGNID_2);

			boolean bindAlias = false;

			if (alias == null) {
				query.append(_FINDER_COLUMN_C_A_E_E_ALIAS_1);
			}
			else if (alias.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_A_E_E_ALIAS_3);
			}
			else {
				bindAlias = true;

				query.append(_FINDER_COLUMN_C_A_E_E_ALIAS_2);
			}

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_C_A_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_A_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_C_A_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_A_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_A_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_A_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindAlias) {
					qPos.add(alias);
				}

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (bindEventType) {
					qPos.add(eventType);
				}

				List<Newsletter> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_A_E_E,
						finderArgs, list);
				}
				else {
					Newsletter newsletter = list.get(0);

					result = newsletter;

					cacheResult(newsletter);

					if ((newsletter.getCampaignId() != campaignId) ||
							(newsletter.getAlias() == null) ||
							!newsletter.getAlias().equals(alias) ||
							(newsletter.getElementId() == null) ||
							!newsletter.getElementId().equals(elementId) ||
							(newsletter.getEventType() == null) ||
							!newsletter.getEventType().equals(eventType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_A_E_E,
							finderArgs, newsletter);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_A_E_E,
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
			return (Newsletter)result;
		}
	}

	/**
	 * Removes the newsletter where campaignId = &#63; and alias = &#63; and elementId = &#63; and eventType = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the newsletter that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter removeByC_A_E_E(long campaignId, String alias,
		String elementId, String eventType)
		throws NoSuchNewsletterException, SystemException {
		Newsletter newsletter = findByC_A_E_E(campaignId, alias, elementId,
				eventType);

		return remove(newsletter);
	}

	/**
	 * Returns the number of newsletters where campaignId = &#63; and alias = &#63; and elementId = &#63; and eventType = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param alias the alias
	 * @param elementId the element ID
	 * @param eventType the event type
	 * @return the number of matching newsletters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_A_E_E(long campaignId, String alias, String elementId,
		String eventType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_A_E_E;

		Object[] finderArgs = new Object[] {
				campaignId, alias, elementId, eventType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_NEWSLETTER_WHERE);

			query.append(_FINDER_COLUMN_C_A_E_E_CAMPAIGNID_2);

			boolean bindAlias = false;

			if (alias == null) {
				query.append(_FINDER_COLUMN_C_A_E_E_ALIAS_1);
			}
			else if (alias.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_A_E_E_ALIAS_3);
			}
			else {
				bindAlias = true;

				query.append(_FINDER_COLUMN_C_A_E_E_ALIAS_2);
			}

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_C_A_E_E_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_A_E_E_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_C_A_E_E_ELEMENTID_2);
			}

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_A_E_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_A_E_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_A_E_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (bindAlias) {
					qPos.add(alias);
				}

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

	private static final String _FINDER_COLUMN_C_A_E_E_CAMPAIGNID_2 = "newsletter.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_C_A_E_E_ALIAS_1 = "newsletter.alias IS NULL AND ";
	private static final String _FINDER_COLUMN_C_A_E_E_ALIAS_2 = "newsletter.alias = ? AND ";
	private static final String _FINDER_COLUMN_C_A_E_E_ALIAS_3 = "(newsletter.alias IS NULL OR newsletter.alias = '') AND ";
	private static final String _FINDER_COLUMN_C_A_E_E_ELEMENTID_1 = "newsletter.elementId IS NULL AND ";
	private static final String _FINDER_COLUMN_C_A_E_E_ELEMENTID_2 = "newsletter.elementId = ? AND ";
	private static final String _FINDER_COLUMN_C_A_E_E_ELEMENTID_3 = "(newsletter.elementId IS NULL OR newsletter.elementId = '') AND ";
	private static final String _FINDER_COLUMN_C_A_E_E_EVENTTYPE_1 = "newsletter.eventType IS NULL";
	private static final String _FINDER_COLUMN_C_A_E_E_EVENTTYPE_2 = "newsletter.eventType = ?";
	private static final String _FINDER_COLUMN_C_A_E_E_EVENTTYPE_3 = "(newsletter.eventType IS NULL OR newsletter.eventType = '')";

	public NewsletterPersistenceImpl() {
		setModelClass(Newsletter.class);
	}

	/**
	 * Caches the newsletter in the entity cache if it is enabled.
	 *
	 * @param newsletter the newsletter
	 */
	@Override
	public void cacheResult(Newsletter newsletter) {
		EntityCacheUtil.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterImpl.class, newsletter.getPrimaryKey(), newsletter);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_A_E_E,
			new Object[] {
				newsletter.getCampaignId(), newsletter.getAlias(),
				newsletter.getElementId(), newsletter.getEventType()
			}, newsletter);

		newsletter.resetOriginalValues();
	}

	/**
	 * Caches the newsletters in the entity cache if it is enabled.
	 *
	 * @param newsletters the newsletters
	 */
	@Override
	public void cacheResult(List<Newsletter> newsletters) {
		for (Newsletter newsletter : newsletters) {
			if (EntityCacheUtil.getResult(
						NewsletterModelImpl.ENTITY_CACHE_ENABLED,
						NewsletterImpl.class, newsletter.getPrimaryKey()) == null) {
				cacheResult(newsletter);
			}
			else {
				newsletter.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all newsletters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NewsletterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NewsletterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the newsletter.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Newsletter newsletter) {
		EntityCacheUtil.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterImpl.class, newsletter.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(newsletter);
	}

	@Override
	public void clearCache(List<Newsletter> newsletters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Newsletter newsletter : newsletters) {
			EntityCacheUtil.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
				NewsletterImpl.class, newsletter.getPrimaryKey());

			clearUniqueFindersCache(newsletter);
		}
	}

	protected void cacheUniqueFindersCache(Newsletter newsletter) {
		if (newsletter.isNew()) {
			Object[] args = new Object[] {
					newsletter.getCampaignId(), newsletter.getAlias(),
					newsletter.getElementId(), newsletter.getEventType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_A_E_E, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_A_E_E, args,
				newsletter);
		}
		else {
			NewsletterModelImpl newsletterModelImpl = (NewsletterModelImpl)newsletter;

			if ((newsletterModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_A_E_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						newsletter.getCampaignId(), newsletter.getAlias(),
						newsletter.getElementId(), newsletter.getEventType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_A_E_E, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_A_E_E, args,
					newsletter);
			}
		}
	}

	protected void clearUniqueFindersCache(Newsletter newsletter) {
		NewsletterModelImpl newsletterModelImpl = (NewsletterModelImpl)newsletter;

		Object[] args = new Object[] {
				newsletter.getCampaignId(), newsletter.getAlias(),
				newsletter.getElementId(), newsletter.getEventType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_A_E_E, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_A_E_E, args);

		if ((newsletterModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_A_E_E.getColumnBitmask()) != 0) {
			args = new Object[] {
					newsletterModelImpl.getOriginalCampaignId(),
					newsletterModelImpl.getOriginalAlias(),
					newsletterModelImpl.getOriginalElementId(),
					newsletterModelImpl.getOriginalEventType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_A_E_E, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_A_E_E, args);
		}
	}

	/**
	 * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	 *
	 * @param newsletterId the primary key for the new newsletter
	 * @return the new newsletter
	 */
	@Override
	public Newsletter create(long newsletterId) {
		Newsletter newsletter = new NewsletterImpl();

		newsletter.setNew(true);
		newsletter.setPrimaryKey(newsletterId);

		return newsletter;
	}

	/**
	 * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletterId the primary key of the newsletter
	 * @return the newsletter that was removed
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter remove(long newsletterId)
		throws NoSuchNewsletterException, SystemException {
		return remove((Serializable)newsletterId);
	}

	/**
	 * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the newsletter
	 * @return the newsletter that was removed
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter remove(Serializable primaryKey)
		throws NoSuchNewsletterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Newsletter newsletter = (Newsletter)session.get(NewsletterImpl.class,
					primaryKey);

			if (newsletter == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNewsletterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(newsletter);
		}
		catch (NoSuchNewsletterException nsee) {
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
	protected Newsletter removeImpl(Newsletter newsletter)
		throws SystemException {
		newsletter = toUnwrappedModel(newsletter);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(newsletter)) {
				newsletter = (Newsletter)session.get(NewsletterImpl.class,
						newsletter.getPrimaryKeyObj());
			}

			if (newsletter != null) {
				session.delete(newsletter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (newsletter != null) {
			clearCache(newsletter);
		}

		return newsletter;
	}

	@Override
	public Newsletter updateImpl(
		com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter newsletter)
		throws SystemException {
		newsletter = toUnwrappedModel(newsletter);

		boolean isNew = newsletter.isNew();

		NewsletterModelImpl newsletterModelImpl = (NewsletterModelImpl)newsletter;

		Session session = null;

		try {
			session = openSession();

			if (newsletter.isNew()) {
				session.save(newsletter);

				newsletter.setNew(false);
			}
			else {
				session.merge(newsletter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NewsletterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((newsletterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						newsletterModelImpl.getOriginalCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { newsletterModelImpl.getCampaignId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}
		}

		EntityCacheUtil.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterImpl.class, newsletter.getPrimaryKey(), newsletter);

		clearUniqueFindersCache(newsletter);
		cacheUniqueFindersCache(newsletter);

		return newsletter;
	}

	protected Newsletter toUnwrappedModel(Newsletter newsletter) {
		if (newsletter instanceof NewsletterImpl) {
			return newsletter;
		}

		NewsletterImpl newsletterImpl = new NewsletterImpl();

		newsletterImpl.setNew(newsletter.isNew());
		newsletterImpl.setPrimaryKey(newsletter.getPrimaryKey());

		newsletterImpl.setNewsletterId(newsletter.getNewsletterId());
		newsletterImpl.setCampaignId(newsletter.getCampaignId());
		newsletterImpl.setAlias(newsletter.getAlias());
		newsletterImpl.setElementId(newsletter.getElementId());
		newsletterImpl.setEventType(newsletter.getEventType());
		newsletterImpl.setCount(newsletter.getCount());
		newsletterImpl.setModifiedDate(newsletter.getModifiedDate());

		return newsletterImpl;
	}

	/**
	 * Returns the newsletter with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the newsletter
	 * @return the newsletter
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNewsletterException, SystemException {
		Newsletter newsletter = fetchByPrimaryKey(primaryKey);

		if (newsletter == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNewsletterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return newsletter;
	}

	/**
	 * Returns the newsletter with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException} if it could not be found.
	 *
	 * @param newsletterId the primary key of the newsletter
	 * @return the newsletter
	 * @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter findByPrimaryKey(long newsletterId)
		throws NoSuchNewsletterException, SystemException {
		return findByPrimaryKey((Serializable)newsletterId);
	}

	/**
	 * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the newsletter
	 * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Newsletter newsletter = (Newsletter)EntityCacheUtil.getResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
				NewsletterImpl.class, primaryKey);

		if (newsletter == _nullNewsletter) {
			return null;
		}

		if (newsletter == null) {
			Session session = null;

			try {
				session = openSession();

				newsletter = (Newsletter)session.get(NewsletterImpl.class,
						primaryKey);

				if (newsletter != null) {
					cacheResult(newsletter);
				}
				else {
					EntityCacheUtil.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
						NewsletterImpl.class, primaryKey, _nullNewsletter);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
					NewsletterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return newsletter;
	}

	/**
	 * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsletterId the primary key of the newsletter
	 * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter fetchByPrimaryKey(long newsletterId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)newsletterId);
	}

	/**
	 * Returns all the newsletters.
	 *
	 * @return the newsletters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Newsletter> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of newsletters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Newsletter> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of newsletters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Newsletter> findAll(int start, int end,
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

		List<Newsletter> list = (List<Newsletter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NEWSLETTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NEWSLETTER;

				if (pagination) {
					sql = sql.concat(NewsletterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Newsletter>(list);
				}
				else {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the newsletters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Newsletter newsletter : findAll()) {
			remove(newsletter);
		}
	}

	/**
	 * Returns the number of newsletters.
	 *
	 * @return the number of newsletters
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

				Query q = session.createQuery(_SQL_COUNT_NEWSLETTER);

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
	 * Initializes the newsletter persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.report.campaign.newsletter.model.Newsletter")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Newsletter>> listenersList = new ArrayList<ModelListener<Newsletter>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Newsletter>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NewsletterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NEWSLETTER = "SELECT newsletter FROM Newsletter newsletter";
	private static final String _SQL_SELECT_NEWSLETTER_WHERE = "SELECT newsletter FROM Newsletter newsletter WHERE ";
	private static final String _SQL_COUNT_NEWSLETTER = "SELECT COUNT(newsletter) FROM Newsletter newsletter";
	private static final String _SQL_COUNT_NEWSLETTER_WHERE = "SELECT COUNT(newsletter) FROM Newsletter newsletter WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "newsletter.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Newsletter exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Newsletter exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NewsletterPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"alias"
			});
	private static Newsletter _nullNewsletter = new NewsletterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Newsletter> toCacheModel() {
				return _nullNewsletterCacheModel;
			}
		};

	private static CacheModel<Newsletter> _nullNewsletterCacheModel = new CacheModel<Newsletter>() {
			@Override
			public Newsletter toEntityModel() {
				return _nullNewsletter;
			}
		};
}