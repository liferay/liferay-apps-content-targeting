/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.anonymoususers.service.persistence;

import com.liferay.anonymoususers.NoSuchAnonymousUserException;
import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.anonymoususers.model.impl.AnonymousUserImpl;
import com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl;

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
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the anonymous user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserPersistence
 * @see AnonymousUserUtil
 * @generated
 */
public class AnonymousUserPersistenceImpl extends BasePersistenceImpl<AnonymousUser>
	implements AnonymousUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnonymousUserUtil} to access the anonymous user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnonymousUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED,
			AnonymousUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED,
			AnonymousUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED,
			AnonymousUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED,
			AnonymousUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			AnonymousUserModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the anonymous users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anonymous users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of anonymous users
	 * @param end the upper bound of the range of anonymous users (not inclusive)
	 * @return the range of matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the anonymous users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of anonymous users
	 * @param end the upper bound of the range of anonymous users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<AnonymousUser> list = (List<AnonymousUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AnonymousUser anonymousUser : list) {
				if (!Validator.equals(uuid, anonymousUser.getUuid())) {
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

			query.append(_SQL_SELECT_ANONYMOUSUSER_WHERE);

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
				query.append(AnonymousUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<AnonymousUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AnonymousUser>(list);
				}
				else {
					list = (List<AnonymousUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first anonymous user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAnonymousUserException, SystemException {
		AnonymousUser anonymousUser = fetchByUuid_First(uuid, orderByComparator);

		if (anonymousUser != null) {
			return anonymousUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnonymousUserException(msg.toString());
	}

	/**
	 * Returns the first anonymous user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<AnonymousUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last anonymous user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAnonymousUserException, SystemException {
		AnonymousUser anonymousUser = fetchByUuid_Last(uuid, orderByComparator);

		if (anonymousUser != null) {
			return anonymousUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnonymousUserException(msg.toString());
	}

	/**
	 * Returns the last anonymous user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AnonymousUser> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the anonymous users before and after the current anonymous user in the ordered set where uuid = &#63;.
	 *
	 * @param AnonymousUserId the primary key of the current anonymous user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser[] findByUuid_PrevAndNext(long AnonymousUserId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchAnonymousUserException, SystemException {
		AnonymousUser anonymousUser = findByPrimaryKey(AnonymousUserId);

		Session session = null;

		try {
			session = openSession();

			AnonymousUser[] array = new AnonymousUserImpl[3];

			array[0] = getByUuid_PrevAndNext(session, anonymousUser, uuid,
					orderByComparator, true);

			array[1] = anonymousUser;

			array[2] = getByUuid_PrevAndNext(session, anonymousUser, uuid,
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

	protected AnonymousUser getByUuid_PrevAndNext(Session session,
		AnonymousUser anonymousUser, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANONYMOUSUSER_WHERE);

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
			query.append(AnonymousUserModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(anonymousUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnonymousUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the anonymous users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (AnonymousUser anonymousUser : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(anonymousUser);
		}
	}

	/**
	 * Returns the number of anonymous users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANONYMOUSUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "anonymousUser.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "anonymousUser.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(anonymousUser.uuid IS NULL OR anonymousUser.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED,
			AnonymousUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED,
			AnonymousUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			AnonymousUserModelImpl.UUID_COLUMN_BITMASK |
			AnonymousUserModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the anonymous users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anonymous users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of anonymous users
	 * @param end the upper bound of the range of anonymous users (not inclusive)
	 * @return the range of matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the anonymous users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of anonymous users
	 * @param end the upper bound of the range of anonymous users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<AnonymousUser> list = (List<AnonymousUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AnonymousUser anonymousUser : list) {
				if (!Validator.equals(uuid, anonymousUser.getUuid()) ||
						(companyId != anonymousUser.getCompanyId())) {
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

			query.append(_SQL_SELECT_ANONYMOUSUSER_WHERE);

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
				query.append(AnonymousUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<AnonymousUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AnonymousUser>(list);
				}
				else {
					list = (List<AnonymousUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAnonymousUserException, SystemException {
		AnonymousUser anonymousUser = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (anonymousUser != null) {
			return anonymousUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnonymousUserException(msg.toString());
	}

	/**
	 * Returns the first anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AnonymousUser> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAnonymousUserException, SystemException {
		AnonymousUser anonymousUser = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (anonymousUser != null) {
			return anonymousUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnonymousUserException(msg.toString());
	}

	/**
	 * Returns the last anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AnonymousUser> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the anonymous users before and after the current anonymous user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param AnonymousUserId the primary key of the current anonymous user
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser[] findByUuid_C_PrevAndNext(long AnonymousUserId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchAnonymousUserException, SystemException {
		AnonymousUser anonymousUser = findByPrimaryKey(AnonymousUserId);

		Session session = null;

		try {
			session = openSession();

			AnonymousUser[] array = new AnonymousUserImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, anonymousUser, uuid,
					companyId, orderByComparator, true);

			array[1] = anonymousUser;

			array[2] = getByUuid_C_PrevAndNext(session, anonymousUser, uuid,
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

	protected AnonymousUser getByUuid_C_PrevAndNext(Session session,
		AnonymousUser anonymousUser, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANONYMOUSUSER_WHERE);

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
			query.append(AnonymousUserModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(anonymousUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnonymousUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the anonymous users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (AnonymousUser anonymousUser : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(anonymousUser);
		}
	}

	/**
	 * Returns the number of anonymous users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANONYMOUSUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "anonymousUser.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "anonymousUser.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(anonymousUser.uuid IS NULL OR anonymousUser.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "anonymousUser.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED,
			AnonymousUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED,
			AnonymousUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId", new String[] { Long.class.getName() },
			AnonymousUserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the anonymous users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anonymous users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of anonymous users
	 * @param end the upper bound of the range of anonymous users (not inclusive)
	 * @return the range of matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the anonymous users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of anonymous users
	 * @param end the upper bound of the range of anonymous users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<AnonymousUser> list = (List<AnonymousUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AnonymousUser anonymousUser : list) {
				if ((userId != anonymousUser.getUserId())) {
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

			query.append(_SQL_SELECT_ANONYMOUSUSER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnonymousUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<AnonymousUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AnonymousUser>(list);
				}
				else {
					list = (List<AnonymousUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first anonymous user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAnonymousUserException, SystemException {
		AnonymousUser anonymousUser = fetchByUserId_First(userId,
				orderByComparator);

		if (anonymousUser != null) {
			return anonymousUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnonymousUserException(msg.toString());
	}

	/**
	 * Returns the first anonymous user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AnonymousUser> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last anonymous user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAnonymousUserException, SystemException {
		AnonymousUser anonymousUser = fetchByUserId_Last(userId,
				orderByComparator);

		if (anonymousUser != null) {
			return anonymousUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnonymousUserException(msg.toString());
	}

	/**
	 * Returns the last anonymous user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching anonymous user, or <code>null</code> if a matching anonymous user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<AnonymousUser> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the anonymous users before and after the current anonymous user in the ordered set where userId = &#63;.
	 *
	 * @param AnonymousUserId the primary key of the current anonymous user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser[] findByUserId_PrevAndNext(long AnonymousUserId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchAnonymousUserException, SystemException {
		AnonymousUser anonymousUser = findByPrimaryKey(AnonymousUserId);

		Session session = null;

		try {
			session = openSession();

			AnonymousUser[] array = new AnonymousUserImpl[3];

			array[0] = getByUserId_PrevAndNext(session, anonymousUser, userId,
					orderByComparator, true);

			array[1] = anonymousUser;

			array[2] = getByUserId_PrevAndNext(session, anonymousUser, userId,
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

	protected AnonymousUser getByUserId_PrevAndNext(Session session,
		AnonymousUser anonymousUser, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANONYMOUSUSER_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(AnonymousUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(anonymousUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnonymousUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the anonymous users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (AnonymousUser anonymousUser : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(anonymousUser);
		}
	}

	/**
	 * Returns the number of anonymous users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANONYMOUSUSER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "anonymousUser.userId = ?";

	public AnonymousUserPersistenceImpl() {
		setModelClass(AnonymousUser.class);
	}

	/**
	 * Caches the anonymous user in the entity cache if it is enabled.
	 *
	 * @param anonymousUser the anonymous user
	 */
	@Override
	public void cacheResult(AnonymousUser anonymousUser) {
		EntityCacheUtil.putResult(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserImpl.class, anonymousUser.getPrimaryKey(),
			anonymousUser);

		anonymousUser.resetOriginalValues();
	}

	/**
	 * Caches the anonymous users in the entity cache if it is enabled.
	 *
	 * @param anonymousUsers the anonymous users
	 */
	@Override
	public void cacheResult(List<AnonymousUser> anonymousUsers) {
		for (AnonymousUser anonymousUser : anonymousUsers) {
			if (EntityCacheUtil.getResult(
						AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
						AnonymousUserImpl.class, anonymousUser.getPrimaryKey()) == null) {
				cacheResult(anonymousUser);
			}
			else {
				anonymousUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all anonymous users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnonymousUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnonymousUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the anonymous user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnonymousUser anonymousUser) {
		EntityCacheUtil.removeResult(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserImpl.class, anonymousUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnonymousUser> anonymousUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnonymousUser anonymousUser : anonymousUsers) {
			EntityCacheUtil.removeResult(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
				AnonymousUserImpl.class, anonymousUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new anonymous user with the primary key. Does not add the anonymous user to the database.
	 *
	 * @param AnonymousUserId the primary key for the new anonymous user
	 * @return the new anonymous user
	 */
	@Override
	public AnonymousUser create(long AnonymousUserId) {
		AnonymousUser anonymousUser = new AnonymousUserImpl();

		anonymousUser.setNew(true);
		anonymousUser.setPrimaryKey(AnonymousUserId);

		String uuid = PortalUUIDUtil.generate();

		anonymousUser.setUuid(uuid);

		return anonymousUser;
	}

	/**
	 * Removes the anonymous user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param AnonymousUserId the primary key of the anonymous user
	 * @return the anonymous user that was removed
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser remove(long AnonymousUserId)
		throws NoSuchAnonymousUserException, SystemException {
		return remove((Serializable)AnonymousUserId);
	}

	/**
	 * Removes the anonymous user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the anonymous user
	 * @return the anonymous user that was removed
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser remove(Serializable primaryKey)
		throws NoSuchAnonymousUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AnonymousUser anonymousUser = (AnonymousUser)session.get(AnonymousUserImpl.class,
					primaryKey);

			if (anonymousUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnonymousUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(anonymousUser);
		}
		catch (NoSuchAnonymousUserException nsee) {
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
	protected AnonymousUser removeImpl(AnonymousUser anonymousUser)
		throws SystemException {
		anonymousUser = toUnwrappedModel(anonymousUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(anonymousUser)) {
				anonymousUser = (AnonymousUser)session.get(AnonymousUserImpl.class,
						anonymousUser.getPrimaryKeyObj());
			}

			if (anonymousUser != null) {
				session.delete(anonymousUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (anonymousUser != null) {
			clearCache(anonymousUser);
		}

		return anonymousUser;
	}

	@Override
	public AnonymousUser updateImpl(
		com.liferay.anonymoususers.model.AnonymousUser anonymousUser)
		throws SystemException {
		anonymousUser = toUnwrappedModel(anonymousUser);

		boolean isNew = anonymousUser.isNew();

		AnonymousUserModelImpl anonymousUserModelImpl = (AnonymousUserModelImpl)anonymousUser;

		if (Validator.isNull(anonymousUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			anonymousUser.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (anonymousUser.isNew()) {
				session.save(anonymousUser);

				anonymousUser.setNew(false);
			}
			else {
				session.merge(anonymousUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnonymousUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((anonymousUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						anonymousUserModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { anonymousUserModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((anonymousUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						anonymousUserModelImpl.getOriginalUuid(),
						anonymousUserModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						anonymousUserModelImpl.getUuid(),
						anonymousUserModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((anonymousUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						anonymousUserModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { anonymousUserModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
			AnonymousUserImpl.class, anonymousUser.getPrimaryKey(),
			anonymousUser);

		return anonymousUser;
	}

	protected AnonymousUser toUnwrappedModel(AnonymousUser anonymousUser) {
		if (anonymousUser instanceof AnonymousUserImpl) {
			return anonymousUser;
		}

		AnonymousUserImpl anonymousUserImpl = new AnonymousUserImpl();

		anonymousUserImpl.setNew(anonymousUser.isNew());
		anonymousUserImpl.setPrimaryKey(anonymousUser.getPrimaryKey());

		anonymousUserImpl.setUuid(anonymousUser.getUuid());
		anonymousUserImpl.setAnonymousUserId(anonymousUser.getAnonymousUserId());
		anonymousUserImpl.setCompanyId(anonymousUser.getCompanyId());
		anonymousUserImpl.setUserId(anonymousUser.getUserId());
		anonymousUserImpl.setUserName(anonymousUser.getUserName());
		anonymousUserImpl.setCreateDate(anonymousUser.getCreateDate());
		anonymousUserImpl.setModifiedDate(anonymousUser.getModifiedDate());
		anonymousUserImpl.setLastIp(anonymousUser.getLastIp());
		anonymousUserImpl.setTypeSettings(anonymousUser.getTypeSettings());

		return anonymousUserImpl;
	}

	/**
	 * Returns the anonymous user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the anonymous user
	 * @return the anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnonymousUserException, SystemException {
		AnonymousUser anonymousUser = fetchByPrimaryKey(primaryKey);

		if (anonymousUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnonymousUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return anonymousUser;
	}

	/**
	 * Returns the anonymous user with the primary key or throws a {@link com.liferay.anonymoususers.NoSuchAnonymousUserException} if it could not be found.
	 *
	 * @param AnonymousUserId the primary key of the anonymous user
	 * @return the anonymous user
	 * @throws com.liferay.anonymoususers.NoSuchAnonymousUserException if a anonymous user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser findByPrimaryKey(long AnonymousUserId)
		throws NoSuchAnonymousUserException, SystemException {
		return findByPrimaryKey((Serializable)AnonymousUserId);
	}

	/**
	 * Returns the anonymous user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the anonymous user
	 * @return the anonymous user, or <code>null</code> if a anonymous user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AnonymousUser anonymousUser = (AnonymousUser)EntityCacheUtil.getResult(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
				AnonymousUserImpl.class, primaryKey);

		if (anonymousUser == _nullAnonymousUser) {
			return null;
		}

		if (anonymousUser == null) {
			Session session = null;

			try {
				session = openSession();

				anonymousUser = (AnonymousUser)session.get(AnonymousUserImpl.class,
						primaryKey);

				if (anonymousUser != null) {
					cacheResult(anonymousUser);
				}
				else {
					EntityCacheUtil.putResult(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
						AnonymousUserImpl.class, primaryKey, _nullAnonymousUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AnonymousUserModelImpl.ENTITY_CACHE_ENABLED,
					AnonymousUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return anonymousUser;
	}

	/**
	 * Returns the anonymous user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param AnonymousUserId the primary key of the anonymous user
	 * @return the anonymous user, or <code>null</code> if a anonymous user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnonymousUser fetchByPrimaryKey(long AnonymousUserId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)AnonymousUserId);
	}

	/**
	 * Returns all the anonymous users.
	 *
	 * @return the anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the anonymous users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of anonymous users
	 * @param end the upper bound of the range of anonymous users (not inclusive)
	 * @return the range of anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the anonymous users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.anonymoususers.model.impl.AnonymousUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of anonymous users
	 * @param end the upper bound of the range of anonymous users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of anonymous users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AnonymousUser> findAll(int start, int end,
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

		List<AnonymousUser> list = (List<AnonymousUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANONYMOUSUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANONYMOUSUSER;

				if (pagination) {
					sql = sql.concat(AnonymousUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AnonymousUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AnonymousUser>(list);
				}
				else {
					list = (List<AnonymousUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the anonymous users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AnonymousUser anonymousUser : findAll()) {
			remove(anonymousUser);
		}
	}

	/**
	 * Returns the number of anonymous users.
	 *
	 * @return the number of anonymous users
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

				Query q = session.createQuery(_SQL_COUNT_ANONYMOUSUSER);

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
	 * Initializes the anonymous user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.anonymoususers.model.AnonymousUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AnonymousUser>> listenersList = new ArrayList<ModelListener<AnonymousUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AnonymousUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AnonymousUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ANONYMOUSUSER = "SELECT anonymousUser FROM AnonymousUser anonymousUser";
	private static final String _SQL_SELECT_ANONYMOUSUSER_WHERE = "SELECT anonymousUser FROM AnonymousUser anonymousUser WHERE ";
	private static final String _SQL_COUNT_ANONYMOUSUSER = "SELECT COUNT(anonymousUser) FROM AnonymousUser anonymousUser";
	private static final String _SQL_COUNT_ANONYMOUSUSER_WHERE = "SELECT COUNT(anonymousUser) FROM AnonymousUser anonymousUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "anonymousUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnonymousUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AnonymousUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnonymousUserPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static AnonymousUser _nullAnonymousUser = new AnonymousUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AnonymousUser> toCacheModel() {
				return _nullAnonymousUserCacheModel;
			}
		};

	private static CacheModel<AnonymousUser> _nullAnonymousUserCacheModel = new CacheModel<AnonymousUser>() {
			@Override
			public AnonymousUser toEntityModel() {
				return _nullAnonymousUser;
			}
		};
}