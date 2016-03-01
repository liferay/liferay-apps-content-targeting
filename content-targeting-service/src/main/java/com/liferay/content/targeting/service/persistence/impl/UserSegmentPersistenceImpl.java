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

package com.liferay.content.targeting.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.exception.NoSuchUserSegmentException;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.model.impl.UserSegmentImpl;
import com.liferay.content.targeting.model.impl.UserSegmentModelImpl;
import com.liferay.content.targeting.service.persistence.CampaignPersistence;
import com.liferay.content.targeting.service.persistence.TacticPersistence;
import com.liferay.content.targeting.service.persistence.UserSegmentPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the user segment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserSegmentPersistence
 * @see com.liferay.content.targeting.service.persistence.UserSegmentUtil
 * @generated
 */
@ProviderType
public class UserSegmentPersistenceImpl extends BasePersistenceImpl<UserSegment>
	implements UserSegmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserSegmentUtil} to access the user segment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserSegmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, UserSegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, UserSegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, UserSegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, UserSegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UserSegmentModelImpl.UUID_COLUMN_BITMASK |
			UserSegmentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user segments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user segments
	 */
	@Override
	public List<UserSegment> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user segments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @return the range of matching user segments
	 */
	@Override
	public List<UserSegment> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user segments
	 */
	@Override
	public List<UserSegment> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserSegment> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user segments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user segments
	 */
	@Override
	public List<UserSegment> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<UserSegment> list = null;

		if (retrieveFromCache) {
			list = (List<UserSegment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserSegment userSegment : list) {
					if (!Validator.equals(uuid, userSegment.getUuid())) {
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

			query.append(_SQL_SELECT_USERSEGMENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserSegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<UserSegment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserSegment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user segment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user segment
	 * @throws NoSuchUserSegmentException if a matching user segment could not be found
	 */
	@Override
	public UserSegment findByUuid_First(String uuid,
		OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = fetchByUuid_First(uuid, orderByComparator);

		if (userSegment != null) {
			return userSegment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSegmentException(msg.toString());
	}

	/**
	 * Returns the first user segment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user segment, or <code>null</code> if a matching user segment could not be found
	 */
	@Override
	public UserSegment fetchByUuid_First(String uuid,
		OrderByComparator<UserSegment> orderByComparator) {
		List<UserSegment> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user segment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user segment
	 * @throws NoSuchUserSegmentException if a matching user segment could not be found
	 */
	@Override
	public UserSegment findByUuid_Last(String uuid,
		OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = fetchByUuid_Last(uuid, orderByComparator);

		if (userSegment != null) {
			return userSegment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSegmentException(msg.toString());
	}

	/**
	 * Returns the last user segment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user segment, or <code>null</code> if a matching user segment could not be found
	 */
	@Override
	public UserSegment fetchByUuid_Last(String uuid,
		OrderByComparator<UserSegment> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserSegment> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user segments before and after the current user segment in the ordered set where uuid = &#63;.
	 *
	 * @param userSegmentId the primary key of the current user segment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user segment
	 * @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	 */
	@Override
	public UserSegment[] findByUuid_PrevAndNext(long userSegmentId,
		String uuid, OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = findByPrimaryKey(userSegmentId);

		Session session = null;

		try {
			session = openSession();

			UserSegment[] array = new UserSegmentImpl[3];

			array[0] = getByUuid_PrevAndNext(session, userSegment, uuid,
					orderByComparator, true);

			array[1] = userSegment;

			array[2] = getByUuid_PrevAndNext(session, userSegment, uuid,
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

	protected UserSegment getByUuid_PrevAndNext(Session session,
		UserSegment userSegment, String uuid,
		OrderByComparator<UserSegment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERSEGMENT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(UserSegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userSegment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserSegment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user segments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserSegment userSegment : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userSegment);
		}
	}

	/**
	 * Returns the number of user segments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user segments
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERSEGMENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "userSegment.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userSegment.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userSegment.uuid IS NULL OR userSegment.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, UserSegmentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			UserSegmentModelImpl.UUID_COLUMN_BITMASK |
			UserSegmentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the user segment where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchUserSegmentException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user segment
	 * @throws NoSuchUserSegmentException if a matching user segment could not be found
	 */
	@Override
	public UserSegment findByUUID_G(String uuid, long groupId)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = fetchByUUID_G(uuid, groupId);

		if (userSegment == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserSegmentException(msg.toString());
		}

		return userSegment;
	}

	/**
	 * Returns the user segment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	 */
	@Override
	public UserSegment fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the user segment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	 */
	@Override
	public UserSegment fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof UserSegment) {
			UserSegment userSegment = (UserSegment)result;

			if (!Validator.equals(uuid, userSegment.getUuid()) ||
					(groupId != userSegment.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERSEGMENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<UserSegment> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					UserSegment userSegment = list.get(0);

					result = userSegment;

					cacheResult(userSegment);

					if ((userSegment.getUuid() == null) ||
							!userSegment.getUuid().equals(uuid) ||
							(userSegment.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, userSegment);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

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
			return (UserSegment)result;
		}
	}

	/**
	 * Removes the user segment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user segment that was removed
	 */
	@Override
	public UserSegment removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = findByUUID_G(uuid, groupId);

		return remove(userSegment);
	}

	/**
	 * Returns the number of user segments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user segments
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERSEGMENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "userSegment.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "userSegment.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(userSegment.uuid IS NULL OR userSegment.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "userSegment.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, UserSegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, UserSegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			UserSegmentModelImpl.UUID_COLUMN_BITMASK |
			UserSegmentModelImpl.COMPANYID_COLUMN_BITMASK |
			UserSegmentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user segments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user segments
	 */
	@Override
	public List<UserSegment> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user segments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @return the range of matching user segments
	 */
	@Override
	public List<UserSegment> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user segments
	 */
	@Override
	public List<UserSegment> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<UserSegment> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user segments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user segments
	 */
	@Override
	public List<UserSegment> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<UserSegment> list = null;

		if (retrieveFromCache) {
			list = (List<UserSegment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserSegment userSegment : list) {
					if (!Validator.equals(uuid, userSegment.getUuid()) ||
							(companyId != userSegment.getCompanyId())) {
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

			query.append(_SQL_SELECT_USERSEGMENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserSegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<UserSegment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserSegment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user segment
	 * @throws NoSuchUserSegmentException if a matching user segment could not be found
	 */
	@Override
	public UserSegment findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (userSegment != null) {
			return userSegment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSegmentException(msg.toString());
	}

	/**
	 * Returns the first user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user segment, or <code>null</code> if a matching user segment could not be found
	 */
	@Override
	public UserSegment fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserSegment> orderByComparator) {
		List<UserSegment> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user segment
	 * @throws NoSuchUserSegmentException if a matching user segment could not be found
	 */
	@Override
	public UserSegment findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (userSegment != null) {
			return userSegment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSegmentException(msg.toString());
	}

	/**
	 * Returns the last user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user segment, or <code>null</code> if a matching user segment could not be found
	 */
	@Override
	public UserSegment fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserSegment> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserSegment> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user segments before and after the current user segment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userSegmentId the primary key of the current user segment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user segment
	 * @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	 */
	@Override
	public UserSegment[] findByUuid_C_PrevAndNext(long userSegmentId,
		String uuid, long companyId,
		OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = findByPrimaryKey(userSegmentId);

		Session session = null;

		try {
			session = openSession();

			UserSegment[] array = new UserSegmentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, userSegment, uuid,
					companyId, orderByComparator, true);

			array[1] = userSegment;

			array[2] = getByUuid_C_PrevAndNext(session, userSegment, uuid,
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

	protected UserSegment getByUuid_C_PrevAndNext(Session session,
		UserSegment userSegment, String uuid, long companyId,
		OrderByComparator<UserSegment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_USERSEGMENT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(UserSegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userSegment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserSegment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user segments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UserSegment userSegment : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userSegment);
		}
	}

	/**
	 * Returns the number of user segments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user segments
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERSEGMENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "userSegment.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "userSegment.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(userSegment.uuid IS NULL OR userSegment.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "userSegment.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, UserSegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, UserSegmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			UserSegmentModelImpl.GROUPID_COLUMN_BITMASK |
			UserSegmentModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_GROUPID = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user segments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching user segments
	 */
	@Override
	public List<UserSegment> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user segments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @return the range of matching user segments
	 */
	@Override
	public List<UserSegment> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user segments
	 */
	@Override
	public List<UserSegment> findByGroupId(long groupId, int start, int end,
		OrderByComparator<UserSegment> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user segments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user segments
	 */
	@Override
	public List<UserSegment> findByGroupId(long groupId, int start, int end,
		OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<UserSegment> list = null;

		if (retrieveFromCache) {
			list = (List<UserSegment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserSegment userSegment : list) {
					if ((groupId != userSegment.getGroupId())) {
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

			query.append(_SQL_SELECT_USERSEGMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserSegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<UserSegment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserSegment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user segment
	 * @throws NoSuchUserSegmentException if a matching user segment could not be found
	 */
	@Override
	public UserSegment findByGroupId_First(long groupId,
		OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = fetchByGroupId_First(groupId,
				orderByComparator);

		if (userSegment != null) {
			return userSegment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSegmentException(msg.toString());
	}

	/**
	 * Returns the first user segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user segment, or <code>null</code> if a matching user segment could not be found
	 */
	@Override
	public UserSegment fetchByGroupId_First(long groupId,
		OrderByComparator<UserSegment> orderByComparator) {
		List<UserSegment> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user segment
	 * @throws NoSuchUserSegmentException if a matching user segment could not be found
	 */
	@Override
	public UserSegment findByGroupId_Last(long groupId,
		OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = fetchByGroupId_Last(groupId, orderByComparator);

		if (userSegment != null) {
			return userSegment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserSegmentException(msg.toString());
	}

	/**
	 * Returns the last user segment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user segment, or <code>null</code> if a matching user segment could not be found
	 */
	@Override
	public UserSegment fetchByGroupId_Last(long groupId,
		OrderByComparator<UserSegment> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<UserSegment> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user segments before and after the current user segment in the ordered set where groupId = &#63;.
	 *
	 * @param userSegmentId the primary key of the current user segment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user segment
	 * @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	 */
	@Override
	public UserSegment[] findByGroupId_PrevAndNext(long userSegmentId,
		long groupId, OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = findByPrimaryKey(userSegmentId);

		Session session = null;

		try {
			session = openSession();

			UserSegment[] array = new UserSegmentImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, userSegment, groupId,
					orderByComparator, true);

			array[1] = userSegment;

			array[2] = getByGroupId_PrevAndNext(session, userSegment, groupId,
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

	protected UserSegment getByGroupId_PrevAndNext(Session session,
		UserSegment userSegment, long groupId,
		OrderByComparator<UserSegment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERSEGMENT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(UserSegmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userSegment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserSegment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the user segments that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching user segments that the user has permission to view
	 */
	@Override
	public List<UserSegment> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user segments that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @return the range of matching user segments that the user has permission to view
	 */
	@Override
	public List<UserSegment> filterFindByGroupId(long groupId, int start,
		int end) {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segments that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user segments that the user has permission to view
	 */
	@Override
	public List<UserSegment> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator<UserSegment> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_USERSEGMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_USERSEGMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_USERSEGMENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(UserSegmentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(UserSegmentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				UserSegment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, UserSegmentImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, UserSegmentImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<UserSegment>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the user segments before and after the current user segment in the ordered set of user segments that the user has permission to view where groupId = &#63;.
	 *
	 * @param userSegmentId the primary key of the current user segment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user segment
	 * @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	 */
	@Override
	public UserSegment[] filterFindByGroupId_PrevAndNext(long userSegmentId,
		long groupId, OrderByComparator<UserSegment> orderByComparator)
		throws NoSuchUserSegmentException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(userSegmentId, groupId,
				orderByComparator);
		}

		UserSegment userSegment = findByPrimaryKey(userSegmentId);

		Session session = null;

		try {
			session = openSession();

			UserSegment[] array = new UserSegmentImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, userSegment,
					groupId, orderByComparator, true);

			array[1] = userSegment;

			array[2] = filterGetByGroupId_PrevAndNext(session, userSegment,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserSegment filterGetByGroupId_PrevAndNext(Session session,
		UserSegment userSegment, long groupId,
		OrderByComparator<UserSegment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_USERSEGMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_USERSEGMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_USERSEGMENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(UserSegmentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(UserSegmentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				UserSegment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, UserSegmentImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, UserSegmentImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userSegment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserSegment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the user segments that the user has permission to view where groupId = any &#63;.
	 *
	 * @param groupIds the group IDs
	 * @return the matching user segments that the user has permission to view
	 */
	@Override
	public List<UserSegment> filterFindByGroupId(long[] groupIds) {
		return filterFindByGroupId(groupIds, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user segments that the user has permission to view where groupId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @return the range of matching user segments that the user has permission to view
	 */
	@Override
	public List<UserSegment> filterFindByGroupId(long[] groupIds, int start,
		int end) {
		return filterFindByGroupId(groupIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segments that the user has permission to view where groupId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user segments that the user has permission to view
	 */
	@Override
	public List<UserSegment> filterFindByGroupId(long[] groupIds, int start,
		int end, OrderByComparator<UserSegment> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled(groupIds)) {
			return findByGroupId(groupIds, start, end, orderByComparator);
		}

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		StringBundler query = new StringBundler();

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_USERSEGMENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_USERSEGMENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (groupIds.length > 0) {
			query.append(StringPool.OPEN_PARENTHESIS);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_7);

			query.append(StringUtil.merge(groupIds));

			query.append(StringPool.CLOSE_PARENTHESIS);

			query.append(StringPool.CLOSE_PARENTHESIS);
		}

		query.setStringAt(removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_USERSEGMENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(UserSegmentModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(UserSegmentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				UserSegment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupIds);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, UserSegmentImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, UserSegmentImpl.class);
			}

			return (List<UserSegment>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns all the user segments where groupId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @return the matching user segments
	 */
	@Override
	public List<UserSegment> findByGroupId(long[] groupIds) {
		return findByGroupId(groupIds, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the user segments where groupId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @return the range of matching user segments
	 */
	@Override
	public List<UserSegment> findByGroupId(long[] groupIds, int start, int end) {
		return findByGroupId(groupIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segments where groupId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupIds the group IDs
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user segments
	 */
	@Override
	public List<UserSegment> findByGroupId(long[] groupIds, int start, int end,
		OrderByComparator<UserSegment> orderByComparator) {
		return findByGroupId(groupIds, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user segments where groupId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user segments
	 */
	@Override
	public List<UserSegment> findByGroupId(long[] groupIds, int start, int end,
		OrderByComparator<UserSegment> orderByComparator,
		boolean retrieveFromCache) {
		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		if (groupIds.length == 1) {
			return findByGroupId(groupIds[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(groupIds) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(groupIds),
					
					start, end, orderByComparator
				};
		}

		List<UserSegment> list = null;

		if (retrieveFromCache) {
			list = (List<UserSegment>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserSegment userSegment : list) {
					if (!ArrayUtil.contains(groupIds, userSegment.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_USERSEGMENT_WHERE);

			if (groupIds.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_7);

				query.append(StringUtil.merge(groupIds));

				query.append(StringPool.CLOSE_PARENTHESIS);

				query.append(StringPool.CLOSE_PARENTHESIS);
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserSegmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserSegment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserSegment>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user segments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (UserSegment userSegment : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userSegment);
		}
	}

	/**
	 * Returns the number of user segments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching user segments
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERSEGMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	/**
	 * Returns the number of user segments where groupId = any &#63;.
	 *
	 * @param groupIds the group IDs
	 * @return the number of matching user segments
	 */
	@Override
	public int countByGroupId(long[] groupIds) {
		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		Object[] finderArgs = new Object[] { StringUtil.merge(groupIds) };

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_USERSEGMENT_WHERE);

			if (groupIds.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				query.append(_FINDER_COLUMN_GROUPID_GROUPID_7);

				query.append(StringUtil.merge(groupIds));

				query.append(StringPool.CLOSE_PARENTHESIS);

				query.append(StringPool.CLOSE_PARENTHESIS);
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_GROUPID,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_GROUPID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of user segments that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching user segments that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_USERSEGMENT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				UserSegment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of user segments that the user has permission to view where groupId = any &#63;.
	 *
	 * @param groupIds the group IDs
	 * @return the number of matching user segments that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long[] groupIds) {
		if (!InlineSQLHelperUtil.isEnabled(groupIds)) {
			return countByGroupId(groupIds);
		}

		if (groupIds == null) {
			groupIds = new long[0];
		}
		else if (groupIds.length > 1) {
			groupIds = ArrayUtil.unique(groupIds);

			Arrays.sort(groupIds);
		}

		StringBundler query = new StringBundler();

		query.append(_FILTER_SQL_COUNT_USERSEGMENT_WHERE);

		if (groupIds.length > 0) {
			query.append(StringPool.OPEN_PARENTHESIS);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_7);

			query.append(StringUtil.merge(groupIds));

			query.append(StringPool.CLOSE_PARENTHESIS);

			query.append(StringPool.CLOSE_PARENTHESIS);
		}

		query.setStringAt(removeConjunction(query.stringAt(query.index() - 1)),
			query.index() - 1);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				UserSegment.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupIds);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "userSegment.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_7 = "userSegment.groupId IN (";
	public static final FinderPath FINDER_PATH_FETCH_BY_ASSETCATEGORYID = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, UserSegmentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByAssetCategoryId",
			new String[] { Long.class.getName() },
			UserSegmentModelImpl.ASSETCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ASSETCATEGORYID = new FinderPath(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAssetCategoryId", new String[] { Long.class.getName() });

	/**
	 * Returns the user segment where assetCategoryId = &#63; or throws a {@link NoSuchUserSegmentException} if it could not be found.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching user segment
	 * @throws NoSuchUserSegmentException if a matching user segment could not be found
	 */
	@Override
	public UserSegment findByAssetCategoryId(long assetCategoryId)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = fetchByAssetCategoryId(assetCategoryId);

		if (userSegment == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("assetCategoryId=");
			msg.append(assetCategoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserSegmentException(msg.toString());
		}

		return userSegment;
	}

	/**
	 * Returns the user segment where assetCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	 */
	@Override
	public UserSegment fetchByAssetCategoryId(long assetCategoryId) {
		return fetchByAssetCategoryId(assetCategoryId, true);
	}

	/**
	 * Returns the user segment where assetCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param assetCategoryId the asset category ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user segment, or <code>null</code> if a matching user segment could not be found
	 */
	@Override
	public UserSegment fetchByAssetCategoryId(long assetCategoryId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { assetCategoryId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ASSETCATEGORYID,
					finderArgs, this);
		}

		if (result instanceof UserSegment) {
			UserSegment userSegment = (UserSegment)result;

			if ((assetCategoryId != userSegment.getAssetCategoryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERSEGMENT_WHERE);

			query.append(_FINDER_COLUMN_ASSETCATEGORYID_ASSETCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assetCategoryId);

				List<UserSegment> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ASSETCATEGORYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserSegmentPersistenceImpl.fetchByAssetCategoryId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserSegment userSegment = list.get(0);

					result = userSegment;

					cacheResult(userSegment);

					if ((userSegment.getAssetCategoryId() != assetCategoryId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_ASSETCATEGORYID,
							finderArgs, userSegment);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ASSETCATEGORYID,
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
			return (UserSegment)result;
		}
	}

	/**
	 * Removes the user segment where assetCategoryId = &#63; from the database.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the user segment that was removed
	 */
	@Override
	public UserSegment removeByAssetCategoryId(long assetCategoryId)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = findByAssetCategoryId(assetCategoryId);

		return remove(userSegment);
	}

	/**
	 * Returns the number of user segments where assetCategoryId = &#63;.
	 *
	 * @param assetCategoryId the asset category ID
	 * @return the number of matching user segments
	 */
	@Override
	public int countByAssetCategoryId(long assetCategoryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSETCATEGORYID;

		Object[] finderArgs = new Object[] { assetCategoryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERSEGMENT_WHERE);

			query.append(_FINDER_COLUMN_ASSETCATEGORYID_ASSETCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assetCategoryId);

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

	private static final String _FINDER_COLUMN_ASSETCATEGORYID_ASSETCATEGORYID_2 =
		"userSegment.assetCategoryId = ?";

	public UserSegmentPersistenceImpl() {
		setModelClass(UserSegment.class);
	}

	/**
	 * Caches the user segment in the entity cache if it is enabled.
	 *
	 * @param userSegment the user segment
	 */
	@Override
	public void cacheResult(UserSegment userSegment) {
		entityCache.putResult(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentImpl.class, userSegment.getPrimaryKey(), userSegment);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { userSegment.getUuid(), userSegment.getGroupId() },
			userSegment);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ASSETCATEGORYID,
			new Object[] { userSegment.getAssetCategoryId() }, userSegment);

		userSegment.resetOriginalValues();
	}

	/**
	 * Caches the user segments in the entity cache if it is enabled.
	 *
	 * @param userSegments the user segments
	 */
	@Override
	public void cacheResult(List<UserSegment> userSegments) {
		for (UserSegment userSegment : userSegments) {
			if (entityCache.getResult(
						UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
						UserSegmentImpl.class, userSegment.getPrimaryKey()) == null) {
				cacheResult(userSegment);
			}
			else {
				userSegment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user segments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserSegmentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user segment.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserSegment userSegment) {
		entityCache.removeResult(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentImpl.class, userSegment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserSegmentModelImpl)userSegment);
	}

	@Override
	public void clearCache(List<UserSegment> userSegments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserSegment userSegment : userSegments) {
			entityCache.removeResult(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
				UserSegmentImpl.class, userSegment.getPrimaryKey());

			clearUniqueFindersCache((UserSegmentModelImpl)userSegment);
		}
	}

	protected void cacheUniqueFindersCache(
		UserSegmentModelImpl userSegmentModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					userSegmentModelImpl.getUuid(),
					userSegmentModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				userSegmentModelImpl);

			args = new Object[] { userSegmentModelImpl.getAssetCategoryId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_ASSETCATEGORYID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_ASSETCATEGORYID, args,
				userSegmentModelImpl);
		}
		else {
			if ((userSegmentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userSegmentModelImpl.getUuid(),
						userSegmentModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					userSegmentModelImpl);
			}

			if ((userSegmentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ASSETCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userSegmentModelImpl.getAssetCategoryId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_ASSETCATEGORYID,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_ASSETCATEGORYID,
					args, userSegmentModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		UserSegmentModelImpl userSegmentModelImpl) {
		Object[] args = new Object[] {
				userSegmentModelImpl.getUuid(),
				userSegmentModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((userSegmentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					userSegmentModelImpl.getOriginalUuid(),
					userSegmentModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { userSegmentModelImpl.getAssetCategoryId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_ASSETCATEGORYID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_ASSETCATEGORYID, args);

		if ((userSegmentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ASSETCATEGORYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					userSegmentModelImpl.getOriginalAssetCategoryId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ASSETCATEGORYID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ASSETCATEGORYID, args);
		}
	}

	/**
	 * Creates a new user segment with the primary key. Does not add the user segment to the database.
	 *
	 * @param userSegmentId the primary key for the new user segment
	 * @return the new user segment
	 */
	@Override
	public UserSegment create(long userSegmentId) {
		UserSegment userSegment = new UserSegmentImpl();

		userSegment.setNew(true);
		userSegment.setPrimaryKey(userSegmentId);

		String uuid = PortalUUIDUtil.generate();

		userSegment.setUuid(uuid);

		userSegment.setCompanyId(companyProvider.getCompanyId());

		return userSegment;
	}

	/**
	 * Removes the user segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userSegmentId the primary key of the user segment
	 * @return the user segment that was removed
	 * @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	 */
	@Override
	public UserSegment remove(long userSegmentId)
		throws NoSuchUserSegmentException {
		return remove((Serializable)userSegmentId);
	}

	/**
	 * Removes the user segment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user segment
	 * @return the user segment that was removed
	 * @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	 */
	@Override
	public UserSegment remove(Serializable primaryKey)
		throws NoSuchUserSegmentException {
		Session session = null;

		try {
			session = openSession();

			UserSegment userSegment = (UserSegment)session.get(UserSegmentImpl.class,
					primaryKey);

			if (userSegment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserSegmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userSegment);
		}
		catch (NoSuchUserSegmentException nsee) {
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
	protected UserSegment removeImpl(UserSegment userSegment) {
		userSegment = toUnwrappedModel(userSegment);

		userSegmentToCampaignTableMapper.deleteLeftPrimaryKeyTableMappings(userSegment.getPrimaryKey());

		userSegmentToTacticTableMapper.deleteLeftPrimaryKeyTableMappings(userSegment.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userSegment)) {
				userSegment = (UserSegment)session.get(UserSegmentImpl.class,
						userSegment.getPrimaryKeyObj());
			}

			if (userSegment != null) {
				session.delete(userSegment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userSegment != null) {
			clearCache(userSegment);
		}

		return userSegment;
	}

	@Override
	public UserSegment updateImpl(UserSegment userSegment) {
		userSegment = toUnwrappedModel(userSegment);

		boolean isNew = userSegment.isNew();

		UserSegmentModelImpl userSegmentModelImpl = (UserSegmentModelImpl)userSegment;

		if (Validator.isNull(userSegment.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userSegment.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userSegment.getCreateDate() == null)) {
			if (serviceContext == null) {
				userSegment.setCreateDate(now);
			}
			else {
				userSegment.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!userSegmentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userSegment.setModifiedDate(now);
			}
			else {
				userSegment.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userSegment.isNew()) {
				session.save(userSegment);

				userSegment.setNew(false);
			}
			else {
				userSegment = (UserSegment)session.merge(userSegment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserSegmentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userSegmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userSegmentModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { userSegmentModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((userSegmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userSegmentModelImpl.getOriginalUuid(),
						userSegmentModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						userSegmentModelImpl.getUuid(),
						userSegmentModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((userSegmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userSegmentModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { userSegmentModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		entityCache.putResult(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
			UserSegmentImpl.class, userSegment.getPrimaryKey(), userSegment,
			false);

		clearUniqueFindersCache(userSegmentModelImpl);
		cacheUniqueFindersCache(userSegmentModelImpl, isNew);

		userSegment.resetOriginalValues();

		return userSegment;
	}

	protected UserSegment toUnwrappedModel(UserSegment userSegment) {
		if (userSegment instanceof UserSegmentImpl) {
			return userSegment;
		}

		UserSegmentImpl userSegmentImpl = new UserSegmentImpl();

		userSegmentImpl.setNew(userSegment.isNew());
		userSegmentImpl.setPrimaryKey(userSegment.getPrimaryKey());

		userSegmentImpl.setUuid(userSegment.getUuid());
		userSegmentImpl.setUserSegmentId(userSegment.getUserSegmentId());
		userSegmentImpl.setGroupId(userSegment.getGroupId());
		userSegmentImpl.setAssetCategoryId(userSegment.getAssetCategoryId());
		userSegmentImpl.setCompanyId(userSegment.getCompanyId());
		userSegmentImpl.setUserId(userSegment.getUserId());
		userSegmentImpl.setUserName(userSegment.getUserName());
		userSegmentImpl.setCreateDate(userSegment.getCreateDate());
		userSegmentImpl.setModifiedDate(userSegment.getModifiedDate());
		userSegmentImpl.setName(userSegment.getName());
		userSegmentImpl.setDescription(userSegment.getDescription());

		return userSegmentImpl;
	}

	/**
	 * Returns the user segment with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user segment
	 * @return the user segment
	 * @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	 */
	@Override
	public UserSegment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserSegmentException {
		UserSegment userSegment = fetchByPrimaryKey(primaryKey);

		if (userSegment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserSegmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userSegment;
	}

	/**
	 * Returns the user segment with the primary key or throws a {@link NoSuchUserSegmentException} if it could not be found.
	 *
	 * @param userSegmentId the primary key of the user segment
	 * @return the user segment
	 * @throws NoSuchUserSegmentException if a user segment with the primary key could not be found
	 */
	@Override
	public UserSegment findByPrimaryKey(long userSegmentId)
		throws NoSuchUserSegmentException {
		return findByPrimaryKey((Serializable)userSegmentId);
	}

	/**
	 * Returns the user segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user segment
	 * @return the user segment, or <code>null</code> if a user segment with the primary key could not be found
	 */
	@Override
	public UserSegment fetchByPrimaryKey(Serializable primaryKey) {
		UserSegment userSegment = (UserSegment)entityCache.getResult(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
				UserSegmentImpl.class, primaryKey);

		if (userSegment == _nullUserSegment) {
			return null;
		}

		if (userSegment == null) {
			Session session = null;

			try {
				session = openSession();

				userSegment = (UserSegment)session.get(UserSegmentImpl.class,
						primaryKey);

				if (userSegment != null) {
					cacheResult(userSegment);
				}
				else {
					entityCache.putResult(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
						UserSegmentImpl.class, primaryKey, _nullUserSegment);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
					UserSegmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userSegment;
	}

	/**
	 * Returns the user segment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userSegmentId the primary key of the user segment
	 * @return the user segment, or <code>null</code> if a user segment with the primary key could not be found
	 */
	@Override
	public UserSegment fetchByPrimaryKey(long userSegmentId) {
		return fetchByPrimaryKey((Serializable)userSegmentId);
	}

	@Override
	public Map<Serializable, UserSegment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserSegment> map = new HashMap<Serializable, UserSegment>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserSegment userSegment = fetchByPrimaryKey(primaryKey);

			if (userSegment != null) {
				map.put(primaryKey, userSegment);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			UserSegment userSegment = (UserSegment)entityCache.getResult(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
					UserSegmentImpl.class, primaryKey);

			if (userSegment == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, userSegment);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERSEGMENT_WHERE_PKS_IN);

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

			for (UserSegment userSegment : (List<UserSegment>)q.list()) {
				map.put(userSegment.getPrimaryKeyObj(), userSegment);

				cacheResult(userSegment);

				uncachedPrimaryKeys.remove(userSegment.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserSegmentModelImpl.ENTITY_CACHE_ENABLED,
					UserSegmentImpl.class, primaryKey, _nullUserSegment);
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
	 * Returns all the user segments.
	 *
	 * @return the user segments
	 */
	@Override
	public List<UserSegment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @return the range of user segments
	 */
	@Override
	public List<UserSegment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user segments
	 */
	@Override
	public List<UserSegment> findAll(int start, int end,
		OrderByComparator<UserSegment> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user segments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user segments
	 */
	@Override
	public List<UserSegment> findAll(int start, int end,
		OrderByComparator<UserSegment> orderByComparator,
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

		List<UserSegment> list = null;

		if (retrieveFromCache) {
			list = (List<UserSegment>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERSEGMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERSEGMENT;

				if (pagination) {
					sql = sql.concat(UserSegmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserSegment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserSegment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user segments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserSegment userSegment : findAll()) {
			remove(userSegment);
		}
	}

	/**
	 * Returns the number of user segments.
	 *
	 * @return the number of user segments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERSEGMENT);

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

	/**
	 * Returns the primaryKeys of campaigns associated with the user segment.
	 *
	 * @param pk the primary key of the user segment
	 * @return long[] of the primaryKeys of campaigns associated with the user segment
	 */
	@Override
	public long[] getCampaignPrimaryKeys(long pk) {
		long[] pks = userSegmentToCampaignTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the campaigns associated with the user segment.
	 *
	 * @param pk the primary key of the user segment
	 * @return the campaigns associated with the user segment
	 */
	@Override
	public List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long pk) {
		return getCampaigns(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the campaigns associated with the user segment.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the user segment
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @return the range of campaigns associated with the user segment
	 */
	@Override
	public List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long pk, int start, int end) {
		return getCampaigns(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaigns associated with the user segment.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the user segment
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaigns associated with the user segment
	 */
	@Override
	public List<com.liferay.content.targeting.model.Campaign> getCampaigns(
		long pk, int start, int end,
		OrderByComparator<com.liferay.content.targeting.model.Campaign> orderByComparator) {
		return userSegmentToCampaignTableMapper.getRightBaseModels(pk, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of campaigns associated with the user segment.
	 *
	 * @param pk the primary key of the user segment
	 * @return the number of campaigns associated with the user segment
	 */
	@Override
	public int getCampaignsSize(long pk) {
		long[] pks = userSegmentToCampaignTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the campaign is associated with the user segment.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaignPK the primary key of the campaign
	 * @return <code>true</code> if the campaign is associated with the user segment; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCampaign(long pk, long campaignPK) {
		return userSegmentToCampaignTableMapper.containsTableMapping(pk,
			campaignPK);
	}

	/**
	 * Returns <code>true</code> if the user segment has any campaigns associated with it.
	 *
	 * @param pk the primary key of the user segment to check for associations with campaigns
	 * @return <code>true</code> if the user segment has any campaigns associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCampaigns(long pk) {
		if (getCampaignsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaignPK the primary key of the campaign
	 */
	@Override
	public void addCampaign(long pk, long campaignPK) {
		UserSegment userSegment = fetchByPrimaryKey(pk);

		if (userSegment == null) {
			userSegmentToCampaignTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, campaignPK);
		}
		else {
			userSegmentToCampaignTableMapper.addTableMapping(userSegment.getCompanyId(),
				pk, campaignPK);
		}
	}

	/**
	 * Adds an association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaign the campaign
	 */
	@Override
	public void addCampaign(long pk,
		com.liferay.content.targeting.model.Campaign campaign) {
		UserSegment userSegment = fetchByPrimaryKey(pk);

		if (userSegment == null) {
			userSegmentToCampaignTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, campaign.getPrimaryKey());
		}
		else {
			userSegmentToCampaignTableMapper.addTableMapping(userSegment.getCompanyId(),
				pk, campaign.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaignPKs the primary keys of the campaigns
	 */
	@Override
	public void addCampaigns(long pk, long[] campaignPKs) {
		long companyId = 0;

		UserSegment userSegment = fetchByPrimaryKey(pk);

		if (userSegment == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = userSegment.getCompanyId();
		}

		for (long campaignPK : campaignPKs) {
			userSegmentToCampaignTableMapper.addTableMapping(companyId, pk,
				campaignPK);
		}
	}

	/**
	 * Adds an association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaigns the campaigns
	 */
	@Override
	public void addCampaigns(long pk,
		List<com.liferay.content.targeting.model.Campaign> campaigns) {
		long companyId = 0;

		UserSegment userSegment = fetchByPrimaryKey(pk);

		if (userSegment == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = userSegment.getCompanyId();
		}

		for (com.liferay.content.targeting.model.Campaign campaign : campaigns) {
			userSegmentToCampaignTableMapper.addTableMapping(companyId, pk,
				campaign.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the user segment and its campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment to clear the associated campaigns from
	 */
	@Override
	public void clearCampaigns(long pk) {
		userSegmentToCampaignTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaignPK the primary key of the campaign
	 */
	@Override
	public void removeCampaign(long pk, long campaignPK) {
		userSegmentToCampaignTableMapper.deleteTableMapping(pk, campaignPK);
	}

	/**
	 * Removes the association between the user segment and the campaign. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaign the campaign
	 */
	@Override
	public void removeCampaign(long pk,
		com.liferay.content.targeting.model.Campaign campaign) {
		userSegmentToCampaignTableMapper.deleteTableMapping(pk,
			campaign.getPrimaryKey());
	}

	/**
	 * Removes the association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaignPKs the primary keys of the campaigns
	 */
	@Override
	public void removeCampaigns(long pk, long[] campaignPKs) {
		for (long campaignPK : campaignPKs) {
			userSegmentToCampaignTableMapper.deleteTableMapping(pk, campaignPK);
		}
	}

	/**
	 * Removes the association between the user segment and the campaigns. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaigns the campaigns
	 */
	@Override
	public void removeCampaigns(long pk,
		List<com.liferay.content.targeting.model.Campaign> campaigns) {
		for (com.liferay.content.targeting.model.Campaign campaign : campaigns) {
			userSegmentToCampaignTableMapper.deleteTableMapping(pk,
				campaign.getPrimaryKey());
		}
	}

	/**
	 * Sets the campaigns associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaignPKs the primary keys of the campaigns to be associated with the user segment
	 */
	@Override
	public void setCampaigns(long pk, long[] campaignPKs) {
		Set<Long> newCampaignPKsSet = SetUtil.fromArray(campaignPKs);
		Set<Long> oldCampaignPKsSet = SetUtil.fromArray(userSegmentToCampaignTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeCampaignPKsSet = new HashSet<Long>(oldCampaignPKsSet);

		removeCampaignPKsSet.removeAll(newCampaignPKsSet);

		for (long removeCampaignPK : removeCampaignPKsSet) {
			userSegmentToCampaignTableMapper.deleteTableMapping(pk,
				removeCampaignPK);
		}

		newCampaignPKsSet.removeAll(oldCampaignPKsSet);

		long companyId = 0;

		UserSegment userSegment = fetchByPrimaryKey(pk);

		if (userSegment == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = userSegment.getCompanyId();
		}

		for (long newCampaignPK : newCampaignPKsSet) {
			userSegmentToCampaignTableMapper.addTableMapping(companyId, pk,
				newCampaignPK);
		}
	}

	/**
	 * Sets the campaigns associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param campaigns the campaigns to be associated with the user segment
	 */
	@Override
	public void setCampaigns(long pk,
		List<com.liferay.content.targeting.model.Campaign> campaigns) {
		try {
			long[] campaignPKs = new long[campaigns.size()];

			for (int i = 0; i < campaigns.size(); i++) {
				com.liferay.content.targeting.model.Campaign campaign = campaigns.get(i);

				campaignPKs[i] = campaign.getPrimaryKey();
			}

			setCampaigns(pk, campaignPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	/**
	 * Returns the primaryKeys of tactics associated with the user segment.
	 *
	 * @param pk the primary key of the user segment
	 * @return long[] of the primaryKeys of tactics associated with the user segment
	 */
	@Override
	public long[] getTacticPrimaryKeys(long pk) {
		long[] pks = userSegmentToTacticTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the tactics associated with the user segment.
	 *
	 * @param pk the primary key of the user segment
	 * @return the tactics associated with the user segment
	 */
	@Override
	public List<com.liferay.content.targeting.model.Tactic> getTactics(long pk) {
		return getTactics(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the tactics associated with the user segment.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the user segment
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @return the range of tactics associated with the user segment
	 */
	@Override
	public List<com.liferay.content.targeting.model.Tactic> getTactics(
		long pk, int start, int end) {
		return getTactics(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tactics associated with the user segment.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserSegmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the user segment
	 * @param start the lower bound of the range of user segments
	 * @param end the upper bound of the range of user segments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tactics associated with the user segment
	 */
	@Override
	public List<com.liferay.content.targeting.model.Tactic> getTactics(
		long pk, int start, int end,
		OrderByComparator<com.liferay.content.targeting.model.Tactic> orderByComparator) {
		return userSegmentToTacticTableMapper.getRightBaseModels(pk, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of tactics associated with the user segment.
	 *
	 * @param pk the primary key of the user segment
	 * @return the number of tactics associated with the user segment
	 */
	@Override
	public int getTacticsSize(long pk) {
		long[] pks = userSegmentToTacticTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the tactic is associated with the user segment.
	 *
	 * @param pk the primary key of the user segment
	 * @param tacticPK the primary key of the tactic
	 * @return <code>true</code> if the tactic is associated with the user segment; <code>false</code> otherwise
	 */
	@Override
	public boolean containsTactic(long pk, long tacticPK) {
		return userSegmentToTacticTableMapper.containsTableMapping(pk, tacticPK);
	}

	/**
	 * Returns <code>true</code> if the user segment has any tactics associated with it.
	 *
	 * @param pk the primary key of the user segment to check for associations with tactics
	 * @return <code>true</code> if the user segment has any tactics associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsTactics(long pk) {
		if (getTacticsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param tacticPK the primary key of the tactic
	 */
	@Override
	public void addTactic(long pk, long tacticPK) {
		UserSegment userSegment = fetchByPrimaryKey(pk);

		if (userSegment == null) {
			userSegmentToTacticTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, tacticPK);
		}
		else {
			userSegmentToTacticTableMapper.addTableMapping(userSegment.getCompanyId(),
				pk, tacticPK);
		}
	}

	/**
	 * Adds an association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param tactic the tactic
	 */
	@Override
	public void addTactic(long pk,
		com.liferay.content.targeting.model.Tactic tactic) {
		UserSegment userSegment = fetchByPrimaryKey(pk);

		if (userSegment == null) {
			userSegmentToTacticTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, tactic.getPrimaryKey());
		}
		else {
			userSegmentToTacticTableMapper.addTableMapping(userSegment.getCompanyId(),
				pk, tactic.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param tacticPKs the primary keys of the tactics
	 */
	@Override
	public void addTactics(long pk, long[] tacticPKs) {
		long companyId = 0;

		UserSegment userSegment = fetchByPrimaryKey(pk);

		if (userSegment == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = userSegment.getCompanyId();
		}

		for (long tacticPK : tacticPKs) {
			userSegmentToTacticTableMapper.addTableMapping(companyId, pk,
				tacticPK);
		}
	}

	/**
	 * Adds an association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param tactics the tactics
	 */
	@Override
	public void addTactics(long pk,
		List<com.liferay.content.targeting.model.Tactic> tactics) {
		long companyId = 0;

		UserSegment userSegment = fetchByPrimaryKey(pk);

		if (userSegment == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = userSegment.getCompanyId();
		}

		for (com.liferay.content.targeting.model.Tactic tactic : tactics) {
			userSegmentToTacticTableMapper.addTableMapping(companyId, pk,
				tactic.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the user segment and its tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment to clear the associated tactics from
	 */
	@Override
	public void clearTactics(long pk) {
		userSegmentToTacticTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param tacticPK the primary key of the tactic
	 */
	@Override
	public void removeTactic(long pk, long tacticPK) {
		userSegmentToTacticTableMapper.deleteTableMapping(pk, tacticPK);
	}

	/**
	 * Removes the association between the user segment and the tactic. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param tactic the tactic
	 */
	@Override
	public void removeTactic(long pk,
		com.liferay.content.targeting.model.Tactic tactic) {
		userSegmentToTacticTableMapper.deleteTableMapping(pk,
			tactic.getPrimaryKey());
	}

	/**
	 * Removes the association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param tacticPKs the primary keys of the tactics
	 */
	@Override
	public void removeTactics(long pk, long[] tacticPKs) {
		for (long tacticPK : tacticPKs) {
			userSegmentToTacticTableMapper.deleteTableMapping(pk, tacticPK);
		}
	}

	/**
	 * Removes the association between the user segment and the tactics. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param tactics the tactics
	 */
	@Override
	public void removeTactics(long pk,
		List<com.liferay.content.targeting.model.Tactic> tactics) {
		for (com.liferay.content.targeting.model.Tactic tactic : tactics) {
			userSegmentToTacticTableMapper.deleteTableMapping(pk,
				tactic.getPrimaryKey());
		}
	}

	/**
	 * Sets the tactics associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param tacticPKs the primary keys of the tactics to be associated with the user segment
	 */
	@Override
	public void setTactics(long pk, long[] tacticPKs) {
		Set<Long> newTacticPKsSet = SetUtil.fromArray(tacticPKs);
		Set<Long> oldTacticPKsSet = SetUtil.fromArray(userSegmentToTacticTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeTacticPKsSet = new HashSet<Long>(oldTacticPKsSet);

		removeTacticPKsSet.removeAll(newTacticPKsSet);

		for (long removeTacticPK : removeTacticPKsSet) {
			userSegmentToTacticTableMapper.deleteTableMapping(pk, removeTacticPK);
		}

		newTacticPKsSet.removeAll(oldTacticPKsSet);

		long companyId = 0;

		UserSegment userSegment = fetchByPrimaryKey(pk);

		if (userSegment == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = userSegment.getCompanyId();
		}

		for (long newTacticPK : newTacticPKsSet) {
			userSegmentToTacticTableMapper.addTableMapping(companyId, pk,
				newTacticPK);
		}
	}

	/**
	 * Sets the tactics associated with the user segment, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the user segment
	 * @param tactics the tactics to be associated with the user segment
	 */
	@Override
	public void setTactics(long pk,
		List<com.liferay.content.targeting.model.Tactic> tactics) {
		try {
			long[] tacticPKs = new long[tactics.size()];

			for (int i = 0; i < tactics.size(); i++) {
				com.liferay.content.targeting.model.Tactic tactic = tactics.get(i);

				tacticPKs[i] = tactic.getPrimaryKey();
			}

			setTactics(pk, tacticPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserSegmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user segment persistence.
	 */
	public void afterPropertiesSet() {
		userSegmentToCampaignTableMapper = TableMapperFactory.getTableMapper("CT_Campaigns_UserSegments",
				"companyId", "userSegmentId", "campaignId", this,
				campaignPersistence);

		userSegmentToTacticTableMapper = TableMapperFactory.getTableMapper("CT_Tactics_UserSegments",
				"companyId", "userSegmentId", "tacticId", this,
				tacticPersistence);
	}

	public void destroy() {
		entityCache.removeCache(UserSegmentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("CT_Campaigns_UserSegments");
		TableMapperFactory.removeTableMapper("CT_Tactics_UserSegments");
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = CampaignPersistence.class)
	protected CampaignPersistence campaignPersistence;
	protected TableMapper<UserSegment, com.liferay.content.targeting.model.Campaign> userSegmentToCampaignTableMapper;
	@BeanReference(type = TacticPersistence.class)
	protected TacticPersistence tacticPersistence;
	protected TableMapper<UserSegment, com.liferay.content.targeting.model.Tactic> userSegmentToTacticTableMapper;
	private static final String _SQL_SELECT_USERSEGMENT = "SELECT userSegment FROM UserSegment userSegment";
	private static final String _SQL_SELECT_USERSEGMENT_WHERE_PKS_IN = "SELECT userSegment FROM UserSegment userSegment WHERE userSegmentId IN (";
	private static final String _SQL_SELECT_USERSEGMENT_WHERE = "SELECT userSegment FROM UserSegment userSegment WHERE ";
	private static final String _SQL_COUNT_USERSEGMENT = "SELECT COUNT(userSegment) FROM UserSegment userSegment";
	private static final String _SQL_COUNT_USERSEGMENT_WHERE = "SELECT COUNT(userSegment) FROM UserSegment userSegment WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "userSegment.userSegmentId";
	private static final String _FILTER_SQL_SELECT_USERSEGMENT_WHERE = "SELECT DISTINCT {userSegment.*} FROM CT_UserSegment userSegment WHERE ";
	private static final String _FILTER_SQL_SELECT_USERSEGMENT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {CT_UserSegment.*} FROM (SELECT DISTINCT userSegment.userSegmentId FROM CT_UserSegment userSegment WHERE ";
	private static final String _FILTER_SQL_SELECT_USERSEGMENT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN CT_UserSegment ON TEMP_TABLE.userSegmentId = CT_UserSegment.userSegmentId";
	private static final String _FILTER_SQL_COUNT_USERSEGMENT_WHERE = "SELECT COUNT(DISTINCT userSegment.userSegmentId) AS COUNT_VALUE FROM CT_UserSegment userSegment WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "userSegment";
	private static final String _FILTER_ENTITY_TABLE = "CT_UserSegment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userSegment.";
	private static final String _ORDER_BY_ENTITY_TABLE = "CT_UserSegment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserSegment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserSegment exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserSegmentPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static final UserSegment _nullUserSegment = new UserSegmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserSegment> toCacheModel() {
				return _nullUserSegmentCacheModel;
			}
		};

	private static final CacheModel<UserSegment> _nullUserSegmentCacheModel = new CacheModel<UserSegment>() {
			@Override
			public UserSegment toEntityModel() {
				return _nullUserSegment;
			}
		};
}