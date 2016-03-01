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

package com.liferay.content.targeting.report.user.segment.content.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.report.user.segment.content.exception.NoSuchUserSegmentContentException;
import com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent;
import com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentImpl;
import com.liferay.content.targeting.report.user.segment.content.model.impl.UserSegmentContentModelImpl;
import com.liferay.content.targeting.report.user.segment.content.service.persistence.UserSegmentContentPersistence;

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
 * The persistence implementation for the user segment content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentContentPersistence
 * @see com.liferay.content.targeting.report.user.segment.content.service.persistence.UserSegmentContentUtil
 * @generated
 */
@ProviderType
public class UserSegmentContentPersistenceImpl extends BasePersistenceImpl<UserSegmentContent>
	implements UserSegmentContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserSegmentContentUtil} to access the user segment content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserSegmentContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentModelImpl.FINDER_CACHE_ENABLED,
			UserSegmentContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentModelImpl.FINDER_CACHE_ENABLED,
			UserSegmentContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSEGMENTID =
		new FinderPath(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentModelImpl.FINDER_CACHE_ENABLED,
			UserSegmentContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserSegmentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID =
		new FinderPath(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentModelImpl.FINDER_CACHE_ENABLED,
			UserSegmentContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserSegmentId",
			new String[] { Long.class.getName() },
			UserSegmentContentModelImpl.USERSEGMENTID_COLUMN_BITMASK |
			UserSegmentContentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERSEGMENTID = new FinderPath(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserSegmentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user segment contents where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @return the matching user segment contents
	 */
	@Override
	public List<UserSegmentContent> findByUserSegmentId(long userSegmentId) {
		return findByUserSegmentId(userSegmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user segment contents where userSegmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param start the lower bound of the range of user segment contents
	 * @param end the upper bound of the range of user segment contents (not inclusive)
	 * @return the range of matching user segment contents
	 */
	@Override
	public List<UserSegmentContent> findByUserSegmentId(long userSegmentId,
		int start, int end) {
		return findByUserSegmentId(userSegmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segment contents where userSegmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param start the lower bound of the range of user segment contents
	 * @param end the upper bound of the range of user segment contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user segment contents
	 */
	@Override
	public List<UserSegmentContent> findByUserSegmentId(long userSegmentId,
		int start, int end,
		OrderByComparator<UserSegmentContent> orderByComparator) {
		return findByUserSegmentId(userSegmentId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user segment contents where userSegmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param start the lower bound of the range of user segment contents
	 * @param end the upper bound of the range of user segment contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user segment contents
	 */
	@Override
	public List<UserSegmentContent> findByUserSegmentId(long userSegmentId,
		int start, int end,
		OrderByComparator<UserSegmentContent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID;
			finderArgs = new Object[] { userSegmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSEGMENTID;
			finderArgs = new Object[] {
					userSegmentId,
					
					start, end, orderByComparator
				};
		}

		List<UserSegmentContent> list = null;

		if (retrieveFromCache) {
			list = (List<UserSegmentContent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserSegmentContent userSegmentContent : list) {
					if ((userSegmentId != userSegmentContent.getUserSegmentId())) {
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

			query.append(_SQL_SELECT_USERSEGMENTCONTENT_WHERE);

			query.append(_FINDER_COLUMN_USERSEGMENTID_USERSEGMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserSegmentContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userSegmentId);

				if (!pagination) {
					list = (List<UserSegmentContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserSegmentContent>)QueryUtil.list(q,
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
	 * Returns the first user segment content in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user segment content
	 * @throws NoSuchUserSegmentContentException if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent findByUserSegmentId_First(long userSegmentId,
		OrderByComparator<UserSegmentContent> orderByComparator)
		throws NoSuchUserSegmentContentException {
		UserSegmentContent userSegmentContent = fetchByUserSegmentId_First(userSegmentId,
				orderByComparator);

		if (userSegmentContent != null) {
			return userSegmentContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userSegmentId=");
		msg.append(userSegmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSegmentContentException(msg.toString());
	}

	/**
	 * Returns the first user segment content in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user segment content, or <code>null</code> if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent fetchByUserSegmentId_First(long userSegmentId,
		OrderByComparator<UserSegmentContent> orderByComparator) {
		List<UserSegmentContent> list = findByUserSegmentId(userSegmentId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user segment content in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user segment content
	 * @throws NoSuchUserSegmentContentException if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent findByUserSegmentId_Last(long userSegmentId,
		OrderByComparator<UserSegmentContent> orderByComparator)
		throws NoSuchUserSegmentContentException {
		UserSegmentContent userSegmentContent = fetchByUserSegmentId_Last(userSegmentId,
				orderByComparator);

		if (userSegmentContent != null) {
			return userSegmentContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userSegmentId=");
		msg.append(userSegmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSegmentContentException(msg.toString());
	}

	/**
	 * Returns the last user segment content in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user segment content, or <code>null</code> if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent fetchByUserSegmentId_Last(long userSegmentId,
		OrderByComparator<UserSegmentContent> orderByComparator) {
		int count = countByUserSegmentId(userSegmentId);

		if (count == 0) {
			return null;
		}

		List<UserSegmentContent> list = findByUserSegmentId(userSegmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user segment contents before and after the current user segment content in the ordered set where userSegmentId = &#63;.
	 *
	 * @param userSegmentContentId the primary key of the current user segment content
	 * @param userSegmentId the user segment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user segment content
	 * @throws NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	 */
	@Override
	public UserSegmentContent[] findByUserSegmentId_PrevAndNext(
		long userSegmentContentId, long userSegmentId,
		OrderByComparator<UserSegmentContent> orderByComparator)
		throws NoSuchUserSegmentContentException {
		UserSegmentContent userSegmentContent = findByPrimaryKey(userSegmentContentId);

		Session session = null;

		try {
			session = openSession();

			UserSegmentContent[] array = new UserSegmentContentImpl[3];

			array[0] = getByUserSegmentId_PrevAndNext(session,
					userSegmentContent, userSegmentId, orderByComparator, true);

			array[1] = userSegmentContent;

			array[2] = getByUserSegmentId_PrevAndNext(session,
					userSegmentContent, userSegmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserSegmentContent getByUserSegmentId_PrevAndNext(
		Session session, UserSegmentContent userSegmentContent,
		long userSegmentId,
		OrderByComparator<UserSegmentContent> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERSEGMENTCONTENT_WHERE);

		query.append(_FINDER_COLUMN_USERSEGMENTID_USERSEGMENTID_2);

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
			query.append(UserSegmentContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userSegmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userSegmentContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserSegmentContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user segment contents where userSegmentId = &#63; from the database.
	 *
	 * @param userSegmentId the user segment ID
	 */
	@Override
	public void removeByUserSegmentId(long userSegmentId) {
		for (UserSegmentContent userSegmentContent : findByUserSegmentId(
				userSegmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userSegmentContent);
		}
	}

	/**
	 * Returns the number of user segment contents where userSegmentId = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @return the number of matching user segment contents
	 */
	@Override
	public int countByUserSegmentId(long userSegmentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERSEGMENTID;

		Object[] finderArgs = new Object[] { userSegmentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERSEGMENTCONTENT_WHERE);

			query.append(_FINDER_COLUMN_USERSEGMENTID_USERSEGMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userSegmentId);

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

	private static final String _FINDER_COLUMN_USERSEGMENTID_USERSEGMENTID_2 = "userSegmentContent.userSegmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD = new FinderPath(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentModelImpl.FINDER_CACHE_ENABLED,
			UserSegmentContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_GtD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_GTD = new FinderPath(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_GtD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 * @return the matching user segment contents
	 */
	@Override
	public List<UserSegmentContent> findByC_GtD(long userSegmentId,
		Date modifiedDate) {
		return findByC_GtD(userSegmentId, modifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of user segment contents
	 * @param end the upper bound of the range of user segment contents (not inclusive)
	 * @return the range of matching user segment contents
	 */
	@Override
	public List<UserSegmentContent> findByC_GtD(long userSegmentId,
		Date modifiedDate, int start, int end) {
		return findByC_GtD(userSegmentId, modifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of user segment contents
	 * @param end the upper bound of the range of user segment contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user segment contents
	 */
	@Override
	public List<UserSegmentContent> findByC_GtD(long userSegmentId,
		Date modifiedDate, int start, int end,
		OrderByComparator<UserSegmentContent> orderByComparator) {
		return findByC_GtD(userSegmentId, modifiedDate, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of user segment contents
	 * @param end the upper bound of the range of user segment contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user segment contents
	 */
	@Override
	public List<UserSegmentContent> findByC_GtD(long userSegmentId,
		Date modifiedDate, int start, int end,
		OrderByComparator<UserSegmentContent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_GTD;
		finderArgs = new Object[] {
				userSegmentId, modifiedDate,
				
				start, end, orderByComparator
			};

		List<UserSegmentContent> list = null;

		if (retrieveFromCache) {
			list = (List<UserSegmentContent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserSegmentContent userSegmentContent : list) {
					if ((userSegmentId != userSegmentContent.getUserSegmentId()) ||
							(modifiedDate.getTime() >= userSegmentContent.getModifiedDate()
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

			query.append(_SQL_SELECT_USERSEGMENTCONTENT_WHERE);

			query.append(_FINDER_COLUMN_C_GTD_USERSEGMENTID_2);

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
				query.append(UserSegmentContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userSegmentId);

				if (bindModifiedDate) {
					qPos.add(new Timestamp(modifiedDate.getTime()));
				}

				if (!pagination) {
					list = (List<UserSegmentContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserSegmentContent>)QueryUtil.list(q,
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
	 * Returns the first user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user segment content
	 * @throws NoSuchUserSegmentContentException if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent findByC_GtD_First(long userSegmentId,
		Date modifiedDate,
		OrderByComparator<UserSegmentContent> orderByComparator)
		throws NoSuchUserSegmentContentException {
		UserSegmentContent userSegmentContent = fetchByC_GtD_First(userSegmentId,
				modifiedDate, orderByComparator);

		if (userSegmentContent != null) {
			return userSegmentContent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userSegmentId=");
		msg.append(userSegmentId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSegmentContentException(msg.toString());
	}

	/**
	 * Returns the first user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user segment content, or <code>null</code> if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent fetchByC_GtD_First(long userSegmentId,
		Date modifiedDate,
		OrderByComparator<UserSegmentContent> orderByComparator) {
		List<UserSegmentContent> list = findByC_GtD(userSegmentId,
				modifiedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user segment content
	 * @throws NoSuchUserSegmentContentException if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent findByC_GtD_Last(long userSegmentId,
		Date modifiedDate,
		OrderByComparator<UserSegmentContent> orderByComparator)
		throws NoSuchUserSegmentContentException {
		UserSegmentContent userSegmentContent = fetchByC_GtD_Last(userSegmentId,
				modifiedDate, orderByComparator);

		if (userSegmentContent != null) {
			return userSegmentContent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userSegmentId=");
		msg.append(userSegmentId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSegmentContentException(msg.toString());
	}

	/**
	 * Returns the last user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user segment content, or <code>null</code> if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent fetchByC_GtD_Last(long userSegmentId,
		Date modifiedDate,
		OrderByComparator<UserSegmentContent> orderByComparator) {
		int count = countByC_GtD(userSegmentId, modifiedDate);

		if (count == 0) {
			return null;
		}

		List<UserSegmentContent> list = findByC_GtD(userSegmentId,
				modifiedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user segment contents before and after the current user segment content in the ordered set where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param userSegmentContentId the primary key of the current user segment content
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user segment content
	 * @throws NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	 */
	@Override
	public UserSegmentContent[] findByC_GtD_PrevAndNext(
		long userSegmentContentId, long userSegmentId, Date modifiedDate,
		OrderByComparator<UserSegmentContent> orderByComparator)
		throws NoSuchUserSegmentContentException {
		UserSegmentContent userSegmentContent = findByPrimaryKey(userSegmentContentId);

		Session session = null;

		try {
			session = openSession();

			UserSegmentContent[] array = new UserSegmentContentImpl[3];

			array[0] = getByC_GtD_PrevAndNext(session, userSegmentContent,
					userSegmentId, modifiedDate, orderByComparator, true);

			array[1] = userSegmentContent;

			array[2] = getByC_GtD_PrevAndNext(session, userSegmentContent,
					userSegmentId, modifiedDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserSegmentContent getByC_GtD_PrevAndNext(Session session,
		UserSegmentContent userSegmentContent, long userSegmentId,
		Date modifiedDate,
		OrderByComparator<UserSegmentContent> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_USERSEGMENTCONTENT_WHERE);

		query.append(_FINDER_COLUMN_C_GTD_USERSEGMENTID_2);

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
			query.append(UserSegmentContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userSegmentId);

		if (bindModifiedDate) {
			qPos.add(new Timestamp(modifiedDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userSegmentContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserSegmentContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63; from the database.
	 *
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 */
	@Override
	public void removeByC_GtD(long userSegmentId, Date modifiedDate) {
		for (UserSegmentContent userSegmentContent : findByC_GtD(
				userSegmentId, modifiedDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userSegmentContent);
		}
	}

	/**
	 * Returns the number of user segment contents where userSegmentId = &#63; and modifiedDate &gt; &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param modifiedDate the modified date
	 * @return the number of matching user segment contents
	 */
	@Override
	public int countByC_GtD(long userSegmentId, Date modifiedDate) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_GTD;

		Object[] finderArgs = new Object[] { userSegmentId, modifiedDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERSEGMENTCONTENT_WHERE);

			query.append(_FINDER_COLUMN_C_GTD_USERSEGMENTID_2);

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

				qPos.add(userSegmentId);

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

	private static final String _FINDER_COLUMN_C_GTD_USERSEGMENTID_2 = "userSegmentContent.userSegmentId = ? AND ";
	private static final String _FINDER_COLUMN_C_GTD_MODIFIEDDATE_1 = "userSegmentContent.modifiedDate IS NULL";
	private static final String _FINDER_COLUMN_C_GTD_MODIFIEDDATE_2 = "userSegmentContent.modifiedDate > ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_C_C_E = new FinderPath(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentModelImpl.FINDER_CACHE_ENABLED,
			UserSegmentContentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_C_C_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			UserSegmentContentModelImpl.USERSEGMENTID_COLUMN_BITMASK |
			UserSegmentContentModelImpl.CLASSNAME_COLUMN_BITMASK |
			UserSegmentContentModelImpl.CLASSPK_COLUMN_BITMASK |
			UserSegmentContentModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C_E = new FinderPath(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			});

	/**
	 * Returns the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or throws a {@link NoSuchUserSegmentContentException} if it could not be found.
	 *
	 * @param userSegmentId the user segment ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the matching user segment content
	 * @throws NoSuchUserSegmentContentException if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent findByC_C_C_E(long userSegmentId,
		String className, long classPK, String eventType)
		throws NoSuchUserSegmentContentException {
		UserSegmentContent userSegmentContent = fetchByC_C_C_E(userSegmentId,
				className, classPK, eventType);

		if (userSegmentContent == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userSegmentId=");
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

			throw new NoSuchUserSegmentContentException(msg.toString());
		}

		return userSegmentContent;
	}

	/**
	 * Returns the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userSegmentId the user segment ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the matching user segment content, or <code>null</code> if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent fetchByC_C_C_E(long userSegmentId,
		String className, long classPK, String eventType) {
		return fetchByC_C_C_E(userSegmentId, className, classPK, eventType, true);
	}

	/**
	 * Returns the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userSegmentId the user segment ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user segment content, or <code>null</code> if a matching user segment content could not be found
	 */
	@Override
	public UserSegmentContent fetchByC_C_C_E(long userSegmentId,
		String className, long classPK, String eventType,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				userSegmentId, className, classPK, eventType
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_C_C_E,
					finderArgs, this);
		}

		if (result instanceof UserSegmentContent) {
			UserSegmentContent userSegmentContent = (UserSegmentContent)result;

			if ((userSegmentId != userSegmentContent.getUserSegmentId()) ||
					!Validator.equals(className,
						userSegmentContent.getClassName()) ||
					(classPK != userSegmentContent.getClassPK()) ||
					!Validator.equals(eventType,
						userSegmentContent.getEventType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_USERSEGMENTCONTENT_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_E_USERSEGMENTID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_C_E_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_E_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_C_E_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_C_E_CLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_C_C_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_C_C_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userSegmentId);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (bindEventType) {
					qPos.add(eventType);
				}

				List<UserSegmentContent> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_C_C_E,
						finderArgs, list);
				}
				else {
					UserSegmentContent userSegmentContent = list.get(0);

					result = userSegmentContent;

					cacheResult(userSegmentContent);

					if ((userSegmentContent.getUserSegmentId() != userSegmentId) ||
							(userSegmentContent.getClassName() == null) ||
							!userSegmentContent.getClassName().equals(className) ||
							(userSegmentContent.getClassPK() != classPK) ||
							(userSegmentContent.getEventType() == null) ||
							!userSegmentContent.getEventType().equals(eventType)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_C_C_E,
							finderArgs, userSegmentContent);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_C_C_E,
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
			return (UserSegmentContent)result;
		}
	}

	/**
	 * Removes the user segment content where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63; from the database.
	 *
	 * @param userSegmentId the user segment ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the user segment content that was removed
	 */
	@Override
	public UserSegmentContent removeByC_C_C_E(long userSegmentId,
		String className, long classPK, String eventType)
		throws NoSuchUserSegmentContentException {
		UserSegmentContent userSegmentContent = findByC_C_C_E(userSegmentId,
				className, classPK, eventType);

		return remove(userSegmentContent);
	}

	/**
	 * Returns the number of user segment contents where userSegmentId = &#63; and className = &#63; and classPK = &#63; and eventType = &#63;.
	 *
	 * @param userSegmentId the user segment ID
	 * @param className the class name
	 * @param classPK the class p k
	 * @param eventType the event type
	 * @return the number of matching user segment contents
	 */
	@Override
	public int countByC_C_C_E(long userSegmentId, String className,
		long classPK, String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_C_E;

		Object[] finderArgs = new Object[] {
				userSegmentId, className, classPK, eventType
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_USERSEGMENTCONTENT_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_E_USERSEGMENTID_2);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_C_E_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_E_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_C_E_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_C_E_CLASSPK_2);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_C_C_C_E_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_E_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_C_C_C_E_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userSegmentId);

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

	private static final String _FINDER_COLUMN_C_C_C_E_USERSEGMENTID_2 = "userSegmentContent.userSegmentId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_E_CLASSNAME_1 = "userSegmentContent.className IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_C_E_CLASSNAME_2 = "userSegmentContent.className = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_E_CLASSNAME_3 = "(userSegmentContent.className IS NULL OR userSegmentContent.className = '') AND ";
	private static final String _FINDER_COLUMN_C_C_C_E_CLASSPK_2 = "userSegmentContent.classPK = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_E_EVENTTYPE_1 = "userSegmentContent.eventType IS NULL";
	private static final String _FINDER_COLUMN_C_C_C_E_EVENTTYPE_2 = "userSegmentContent.eventType = ?";
	private static final String _FINDER_COLUMN_C_C_C_E_EVENTTYPE_3 = "(userSegmentContent.eventType IS NULL OR userSegmentContent.eventType = '')";

	public UserSegmentContentPersistenceImpl() {
		setModelClass(UserSegmentContent.class);
	}

	/**
	 * Caches the user segment content in the entity cache if it is enabled.
	 *
	 * @param userSegmentContent the user segment content
	 */
	@Override
	public void cacheResult(UserSegmentContent userSegmentContent) {
		entityCache.putResult(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentImpl.class, userSegmentContent.getPrimaryKey(),
			userSegmentContent);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_C_C_E,
			new Object[] {
				userSegmentContent.getUserSegmentId(),
				userSegmentContent.getClassName(),
				userSegmentContent.getClassPK(),
				userSegmentContent.getEventType()
			}, userSegmentContent);

		userSegmentContent.resetOriginalValues();
	}

	/**
	 * Caches the user segment contents in the entity cache if it is enabled.
	 *
	 * @param userSegmentContents the user segment contents
	 */
	@Override
	public void cacheResult(List<UserSegmentContent> userSegmentContents) {
		for (UserSegmentContent userSegmentContent : userSegmentContents) {
			if (entityCache.getResult(
						UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
						UserSegmentContentImpl.class,
						userSegmentContent.getPrimaryKey()) == null) {
				cacheResult(userSegmentContent);
			}
			else {
				userSegmentContent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user segment contents.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserSegmentContentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user segment content.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserSegmentContent userSegmentContent) {
		entityCache.removeResult(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentImpl.class, userSegmentContent.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserSegmentContentModelImpl)userSegmentContent);
	}

	@Override
	public void clearCache(List<UserSegmentContent> userSegmentContents) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserSegmentContent userSegmentContent : userSegmentContents) {
			entityCache.removeResult(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
				UserSegmentContentImpl.class, userSegmentContent.getPrimaryKey());

			clearUniqueFindersCache((UserSegmentContentModelImpl)userSegmentContent);
		}
	}

	protected void cacheUniqueFindersCache(
		UserSegmentContentModelImpl userSegmentContentModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					userSegmentContentModelImpl.getUserSegmentId(),
					userSegmentContentModelImpl.getClassName(),
					userSegmentContentModelImpl.getClassPK(),
					userSegmentContentModelImpl.getEventType()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_C_C_C_E, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_C_C_C_E, args,
				userSegmentContentModelImpl);
		}
		else {
			if ((userSegmentContentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_C_C_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userSegmentContentModelImpl.getUserSegmentId(),
						userSegmentContentModelImpl.getClassName(),
						userSegmentContentModelImpl.getClassPK(),
						userSegmentContentModelImpl.getEventType()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_C_C_C_E, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_C_C_C_E, args,
					userSegmentContentModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		UserSegmentContentModelImpl userSegmentContentModelImpl) {
		Object[] args = new Object[] {
				userSegmentContentModelImpl.getUserSegmentId(),
				userSegmentContentModelImpl.getClassName(),
				userSegmentContentModelImpl.getClassPK(),
				userSegmentContentModelImpl.getEventType()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_C_C_C_E, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_C_C_C_E, args);

		if ((userSegmentContentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_C_C_E.getColumnBitmask()) != 0) {
			args = new Object[] {
					userSegmentContentModelImpl.getOriginalUserSegmentId(),
					userSegmentContentModelImpl.getOriginalClassName(),
					userSegmentContentModelImpl.getOriginalClassPK(),
					userSegmentContentModelImpl.getOriginalEventType()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_C_C_E, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_C_C_E, args);
		}
	}

	/**
	 * Creates a new user segment content with the primary key. Does not add the user segment content to the database.
	 *
	 * @param userSegmentContentId the primary key for the new user segment content
	 * @return the new user segment content
	 */
	@Override
	public UserSegmentContent create(long userSegmentContentId) {
		UserSegmentContent userSegmentContent = new UserSegmentContentImpl();

		userSegmentContent.setNew(true);
		userSegmentContent.setPrimaryKey(userSegmentContentId);

		userSegmentContent.setCompanyId(companyProvider.getCompanyId());

		return userSegmentContent;
	}

	/**
	 * Removes the user segment content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userSegmentContentId the primary key of the user segment content
	 * @return the user segment content that was removed
	 * @throws NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	 */
	@Override
	public UserSegmentContent remove(long userSegmentContentId)
		throws NoSuchUserSegmentContentException {
		return remove((Serializable)userSegmentContentId);
	}

	/**
	 * Removes the user segment content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user segment content
	 * @return the user segment content that was removed
	 * @throws NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	 */
	@Override
	public UserSegmentContent remove(Serializable primaryKey)
		throws NoSuchUserSegmentContentException {
		Session session = null;

		try {
			session = openSession();

			UserSegmentContent userSegmentContent = (UserSegmentContent)session.get(UserSegmentContentImpl.class,
					primaryKey);

			if (userSegmentContent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserSegmentContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userSegmentContent);
		}
		catch (NoSuchUserSegmentContentException nsee) {
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
	protected UserSegmentContent removeImpl(
		UserSegmentContent userSegmentContent) {
		userSegmentContent = toUnwrappedModel(userSegmentContent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userSegmentContent)) {
				userSegmentContent = (UserSegmentContent)session.get(UserSegmentContentImpl.class,
						userSegmentContent.getPrimaryKeyObj());
			}

			if (userSegmentContent != null) {
				session.delete(userSegmentContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userSegmentContent != null) {
			clearCache(userSegmentContent);
		}

		return userSegmentContent;
	}

	@Override
	public UserSegmentContent updateImpl(UserSegmentContent userSegmentContent) {
		userSegmentContent = toUnwrappedModel(userSegmentContent);

		boolean isNew = userSegmentContent.isNew();

		UserSegmentContentModelImpl userSegmentContentModelImpl = (UserSegmentContentModelImpl)userSegmentContent;

		Session session = null;

		try {
			session = openSession();

			if (userSegmentContent.isNew()) {
				session.save(userSegmentContent);

				userSegmentContent.setNew(false);
			}
			else {
				userSegmentContent = (UserSegmentContent)session.merge(userSegmentContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserSegmentContentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userSegmentContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userSegmentContentModelImpl.getOriginalUserSegmentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERSEGMENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID,
					args);

				args = new Object[] {
						userSegmentContentModelImpl.getUserSegmentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERSEGMENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSEGMENTID,
					args);
			}
		}

		entityCache.putResult(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentContentImpl.class, userSegmentContent.getPrimaryKey(),
			userSegmentContent, false);

		clearUniqueFindersCache(userSegmentContentModelImpl);
		cacheUniqueFindersCache(userSegmentContentModelImpl, isNew);

		userSegmentContent.resetOriginalValues();

		return userSegmentContent;
	}

	protected UserSegmentContent toUnwrappedModel(
		UserSegmentContent userSegmentContent) {
		if (userSegmentContent instanceof UserSegmentContentImpl) {
			return userSegmentContent;
		}

		UserSegmentContentImpl userSegmentContentImpl = new UserSegmentContentImpl();

		userSegmentContentImpl.setNew(userSegmentContent.isNew());
		userSegmentContentImpl.setPrimaryKey(userSegmentContent.getPrimaryKey());

		userSegmentContentImpl.setUserSegmentContentId(userSegmentContent.getUserSegmentContentId());
		userSegmentContentImpl.setCompanyId(userSegmentContent.getCompanyId());
		userSegmentContentImpl.setUserSegmentId(userSegmentContent.getUserSegmentId());
		userSegmentContentImpl.setClassName(userSegmentContent.getClassName());
		userSegmentContentImpl.setClassPK(userSegmentContent.getClassPK());
		userSegmentContentImpl.setEventType(userSegmentContent.getEventType());
		userSegmentContentImpl.setCount(userSegmentContent.getCount());
		userSegmentContentImpl.setModifiedDate(userSegmentContent.getModifiedDate());

		return userSegmentContentImpl;
	}

	/**
	 * Returns the user segment content with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user segment content
	 * @return the user segment content
	 * @throws NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	 */
	@Override
	public UserSegmentContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserSegmentContentException {
		UserSegmentContent userSegmentContent = fetchByPrimaryKey(primaryKey);

		if (userSegmentContent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserSegmentContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userSegmentContent;
	}

	/**
	 * Returns the user segment content with the primary key or throws a {@link NoSuchUserSegmentContentException} if it could not be found.
	 *
	 * @param userSegmentContentId the primary key of the user segment content
	 * @return the user segment content
	 * @throws NoSuchUserSegmentContentException if a user segment content with the primary key could not be found
	 */
	@Override
	public UserSegmentContent findByPrimaryKey(long userSegmentContentId)
		throws NoSuchUserSegmentContentException {
		return findByPrimaryKey((Serializable)userSegmentContentId);
	}

	/**
	 * Returns the user segment content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user segment content
	 * @return the user segment content, or <code>null</code> if a user segment content with the primary key could not be found
	 */
	@Override
	public UserSegmentContent fetchByPrimaryKey(Serializable primaryKey) {
		UserSegmentContent userSegmentContent = (UserSegmentContent)entityCache.getResult(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
				UserSegmentContentImpl.class, primaryKey);

		if (userSegmentContent == _nullUserSegmentContent) {
			return null;
		}

		if (userSegmentContent == null) {
			Session session = null;

			try {
				session = openSession();

				userSegmentContent = (UserSegmentContent)session.get(UserSegmentContentImpl.class,
						primaryKey);

				if (userSegmentContent != null) {
					cacheResult(userSegmentContent);
				}
				else {
					entityCache.putResult(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
						UserSegmentContentImpl.class, primaryKey,
						_nullUserSegmentContent);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
					UserSegmentContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userSegmentContent;
	}

	/**
	 * Returns the user segment content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userSegmentContentId the primary key of the user segment content
	 * @return the user segment content, or <code>null</code> if a user segment content with the primary key could not be found
	 */
	@Override
	public UserSegmentContent fetchByPrimaryKey(long userSegmentContentId) {
		return fetchByPrimaryKey((Serializable)userSegmentContentId);
	}

	@Override
	public Map<Serializable, UserSegmentContent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserSegmentContent> map = new HashMap<Serializable, UserSegmentContent>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserSegmentContent userSegmentContent = fetchByPrimaryKey(primaryKey);

			if (userSegmentContent != null) {
				map.put(primaryKey, userSegmentContent);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			UserSegmentContent userSegmentContent = (UserSegmentContent)entityCache.getResult(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
					UserSegmentContentImpl.class, primaryKey);

			if (userSegmentContent == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, userSegmentContent);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERSEGMENTCONTENT_WHERE_PKS_IN);

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

			for (UserSegmentContent userSegmentContent : (List<UserSegmentContent>)q.list()) {
				map.put(userSegmentContent.getPrimaryKeyObj(),
					userSegmentContent);

				cacheResult(userSegmentContent);

				uncachedPrimaryKeys.remove(userSegmentContent.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserSegmentContentModelImpl.ENTITY_CACHE_ENABLED,
					UserSegmentContentImpl.class, primaryKey,
					_nullUserSegmentContent);
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
	 * Returns all the user segment contents.
	 *
	 * @return the user segment contents
	 */
	@Override
	public List<UserSegmentContent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user segment contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user segment contents
	 * @param end the upper bound of the range of user segment contents (not inclusive)
	 * @return the range of user segment contents
	 */
	@Override
	public List<UserSegmentContent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segment contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user segment contents
	 * @param end the upper bound of the range of user segment contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user segment contents
	 */
	@Override
	public List<UserSegmentContent> findAll(int start, int end,
		OrderByComparator<UserSegmentContent> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user segment contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user segment contents
	 * @param end the upper bound of the range of user segment contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user segment contents
	 */
	@Override
	public List<UserSegmentContent> findAll(int start, int end,
		OrderByComparator<UserSegmentContent> orderByComparator,
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

		List<UserSegmentContent> list = null;

		if (retrieveFromCache) {
			list = (List<UserSegmentContent>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERSEGMENTCONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERSEGMENTCONTENT;

				if (pagination) {
					sql = sql.concat(UserSegmentContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserSegmentContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserSegmentContent>)QueryUtil.list(q,
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
	 * Removes all the user segment contents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserSegmentContent userSegmentContent : findAll()) {
			remove(userSegmentContent);
		}
	}

	/**
	 * Returns the number of user segment contents.
	 *
	 * @return the number of user segment contents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERSEGMENTCONTENT);

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
		return UserSegmentContentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user segment content persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserSegmentContentImpl.class.getName());
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
	private static final String _SQL_SELECT_USERSEGMENTCONTENT = "SELECT userSegmentContent FROM UserSegmentContent userSegmentContent";
	private static final String _SQL_SELECT_USERSEGMENTCONTENT_WHERE_PKS_IN = "SELECT userSegmentContent FROM UserSegmentContent userSegmentContent WHERE userSegmentContentId IN (";
	private static final String _SQL_SELECT_USERSEGMENTCONTENT_WHERE = "SELECT userSegmentContent FROM UserSegmentContent userSegmentContent WHERE ";
	private static final String _SQL_COUNT_USERSEGMENTCONTENT = "SELECT COUNT(userSegmentContent) FROM UserSegmentContent userSegmentContent";
	private static final String _SQL_COUNT_USERSEGMENTCONTENT_WHERE = "SELECT COUNT(userSegmentContent) FROM UserSegmentContent userSegmentContent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userSegmentContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserSegmentContent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserSegmentContent exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserSegmentContentPersistenceImpl.class);
	private static final UserSegmentContent _nullUserSegmentContent = new UserSegmentContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserSegmentContent> toCacheModel() {
				return _nullUserSegmentContentCacheModel;
			}
		};

	private static final CacheModel<UserSegmentContent> _nullUserSegmentContentCacheModel =
		new CacheModel<UserSegmentContent>() {
			@Override
			public UserSegmentContent toEntityModel() {
				return _nullUserSegmentContent;
			}
		};
}