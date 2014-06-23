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

package com.liferay.geolocation.service.persistence;

import com.liferay.geolocation.NoSuchGeolocationException;
import com.liferay.geolocation.model.Geolocation;
import com.liferay.geolocation.model.impl.GeolocationImpl;
import com.liferay.geolocation.model.impl.GeolocationModelImpl;

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
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
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
 * The persistence implementation for the geolocation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GeolocationPersistence
 * @see GeolocationUtil
 * @generated
 */
public class GeolocationPersistenceImpl extends BasePersistenceImpl<Geolocation>
	implements GeolocationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeolocationUtil} to access the geolocation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeolocationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, GeolocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, GeolocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, GeolocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, GeolocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			GeolocationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the geolocations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the geolocations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of geolocations
	 * @param end the upper bound of the range of geolocations (not inclusive)
	 * @return the range of matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the geolocations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of geolocations
	 * @param end the upper bound of the range of geolocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByUuid(String uuid, int start, int end,
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

		List<Geolocation> list = (List<Geolocation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Geolocation geolocation : list) {
				if (!Validator.equals(uuid, geolocation.getUuid())) {
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

			query.append(_SQL_SELECT_GEOLOCATION_WHERE);

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
				query.append(GeolocationModelImpl.ORDER_BY_JPQL);
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
					list = (List<Geolocation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Geolocation>(list);
				}
				else {
					list = (List<Geolocation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first geolocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = fetchByUuid_First(uuid, orderByComparator);

		if (geolocation != null) {
			return geolocation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeolocationException(msg.toString());
	}

	/**
	 * Returns the first geolocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geolocation, or <code>null</code> if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Geolocation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geolocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = fetchByUuid_Last(uuid, orderByComparator);

		if (geolocation != null) {
			return geolocation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeolocationException(msg.toString());
	}

	/**
	 * Returns the last geolocation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geolocation, or <code>null</code> if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Geolocation> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the geolocations before and after the current geolocation in the ordered set where uuid = &#63;.
	 *
	 * @param geolocationId the primary key of the current geolocation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation[] findByUuid_PrevAndNext(long geolocationId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = findByPrimaryKey(geolocationId);

		Session session = null;

		try {
			session = openSession();

			Geolocation[] array = new GeolocationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, geolocation, uuid,
					orderByComparator, true);

			array[1] = geolocation;

			array[2] = getByUuid_PrevAndNext(session, geolocation, uuid,
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

	protected Geolocation getByUuid_PrevAndNext(Session session,
		Geolocation geolocation, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEOLOCATION_WHERE);

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
			query.append(GeolocationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(geolocation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Geolocation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geolocations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Geolocation geolocation : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(geolocation);
		}
	}

	/**
	 * Returns the number of geolocations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching geolocations
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

			query.append(_SQL_COUNT_GEOLOCATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "geolocation.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "geolocation.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(geolocation.uuid IS NULL OR geolocation.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, GeolocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, GeolocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			GeolocationModelImpl.UUID_COLUMN_BITMASK |
			GeolocationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the geolocations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the geolocations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of geolocations
	 * @param end the upper bound of the range of geolocations (not inclusive)
	 * @return the range of matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the geolocations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of geolocations
	 * @param end the upper bound of the range of geolocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByUuid_C(String uuid, long companyId,
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

		List<Geolocation> list = (List<Geolocation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Geolocation geolocation : list) {
				if (!Validator.equals(uuid, geolocation.getUuid()) ||
						(companyId != geolocation.getCompanyId())) {
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

			query.append(_SQL_SELECT_GEOLOCATION_WHERE);

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
				query.append(GeolocationModelImpl.ORDER_BY_JPQL);
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
					list = (List<Geolocation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Geolocation>(list);
				}
				else {
					list = (List<Geolocation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (geolocation != null) {
			return geolocation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeolocationException(msg.toString());
	}

	/**
	 * Returns the first geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geolocation, or <code>null</code> if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Geolocation> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (geolocation != null) {
			return geolocation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeolocationException(msg.toString());
	}

	/**
	 * Returns the last geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geolocation, or <code>null</code> if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Geolocation> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the geolocations before and after the current geolocation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param geolocationId the primary key of the current geolocation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation[] findByUuid_C_PrevAndNext(long geolocationId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = findByPrimaryKey(geolocationId);

		Session session = null;

		try {
			session = openSession();

			Geolocation[] array = new GeolocationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, geolocation, uuid,
					companyId, orderByComparator, true);

			array[1] = geolocation;

			array[2] = getByUuid_C_PrevAndNext(session, geolocation, uuid,
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

	protected Geolocation getByUuid_C_PrevAndNext(Session session,
		Geolocation geolocation, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEOLOCATION_WHERE);

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
			query.append(GeolocationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(geolocation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Geolocation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geolocations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Geolocation geolocation : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(geolocation);
		}
	}

	/**
	 * Returns the number of geolocations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching geolocations
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

			query.append(_SQL_COUNT_GEOLOCATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "geolocation.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "geolocation.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(geolocation.uuid IS NULL OR geolocation.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "geolocation.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, GeolocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, GeolocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			GeolocationModelImpl.COMPANYID_COLUMN_BITMASK |
			GeolocationModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			GeolocationModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByC_C_C(long companyId, long classNameId,
		long classPK) throws SystemException {
		return findByC_C_C(companyId, classNameId, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of geolocations
	 * @param end the upper bound of the range of geolocations (not inclusive)
	 * @return the range of matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByC_C_C(long companyId, long classNameId,
		long classPK, int start, int end) throws SystemException {
		return findByC_C_C(companyId, classNameId, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of geolocations
	 * @param end the upper bound of the range of geolocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByC_C_C(long companyId, long classNameId,
		long classPK, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C;
			finderArgs = new Object[] { companyId, classNameId, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C;
			finderArgs = new Object[] {
					companyId, classNameId, classPK,
					
					start, end, orderByComparator
				};
		}

		List<Geolocation> list = (List<Geolocation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Geolocation geolocation : list) {
				if ((companyId != geolocation.getCompanyId()) ||
						(classNameId != geolocation.getClassNameId()) ||
						(classPK != geolocation.getClassPK())) {
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

			query.append(_SQL_SELECT_GEOLOCATION_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeolocationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

				if (!pagination) {
					list = (List<Geolocation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Geolocation>(list);
				}
				else {
					list = (List<Geolocation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first geolocation in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation findByC_C_C_First(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = fetchByC_C_C_First(companyId, classNameId,
				classPK, orderByComparator);

		if (geolocation != null) {
			return geolocation;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeolocationException(msg.toString());
	}

	/**
	 * Returns the first geolocation in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geolocation, or <code>null</code> if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation fetchByC_C_C_First(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		List<Geolocation> list = findByC_C_C(companyId, classNameId, classPK,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geolocation in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation findByC_C_C_Last(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = fetchByC_C_C_Last(companyId, classNameId,
				classPK, orderByComparator);

		if (geolocation != null) {
			return geolocation;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeolocationException(msg.toString());
	}

	/**
	 * Returns the last geolocation in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geolocation, or <code>null</code> if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation fetchByC_C_C_Last(long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_C_C(companyId, classNameId, classPK);

		if (count == 0) {
			return null;
		}

		List<Geolocation> list = findByC_C_C(companyId, classNameId, classPK,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the geolocations before and after the current geolocation in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param geolocationId the primary key of the current geolocation
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation[] findByC_C_C_PrevAndNext(long geolocationId,
		long companyId, long classNameId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = findByPrimaryKey(geolocationId);

		Session session = null;

		try {
			session = openSession();

			Geolocation[] array = new GeolocationImpl[3];

			array[0] = getByC_C_C_PrevAndNext(session, geolocation, companyId,
					classNameId, classPK, orderByComparator, true);

			array[1] = geolocation;

			array[2] = getByC_C_C_PrevAndNext(session, geolocation, companyId,
					classNameId, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Geolocation getByC_C_C_PrevAndNext(Session session,
		Geolocation geolocation, long companyId, long classNameId,
		long classPK, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEOLOCATION_WHERE);

		query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

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
			query.append(GeolocationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(classNameId);

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(geolocation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Geolocation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws SystemException {
		for (Geolocation geolocation : findByC_C_C(companyId, classNameId,
				classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(geolocation);
		}
	}

	/**
	 * Returns the number of geolocations where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_C(long companyId, long classNameId, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_C;

		Object[] finderArgs = new Object[] { companyId, classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GEOLOCATION_WHERE);

			query.append(_FINDER_COLUMN_C_C_C_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(classNameId);

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_C_C_C_COMPANYID_2 = "geolocation.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_CLASSNAMEID_2 = "geolocation.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_CLASSPK_2 = "geolocation.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_M_C_C = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, GeolocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_M_C_C",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_M_C_C = new FinderPath(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_M_C_C",
			new String[] {
				Long.class.getName(), Date.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByC_M_C_C(long companyId, Date modifiedDate,
		long classNameId, long classPK) throws SystemException {
		return findByC_M_C_C(companyId, modifiedDate, classNameId, classPK,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of geolocations
	 * @param end the upper bound of the range of geolocations (not inclusive)
	 * @return the range of matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByC_M_C_C(long companyId, Date modifiedDate,
		long classNameId, long classPK, int start, int end)
		throws SystemException {
		return findByC_M_C_C(companyId, modifiedDate, classNameId, classPK,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param start the lower bound of the range of geolocations
	 * @param end the upper bound of the range of geolocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findByC_M_C_C(long companyId, Date modifiedDate,
		long classNameId, long classPK, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_M_C_C;
		finderArgs = new Object[] {
				companyId, modifiedDate, classNameId, classPK,
				
				start, end, orderByComparator
			};

		List<Geolocation> list = (List<Geolocation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Geolocation geolocation : list) {
				if ((companyId != geolocation.getCompanyId()) ||
						(modifiedDate.getTime() >= geolocation.getModifiedDate()
																  .getTime()) ||
						(classNameId != geolocation.getClassNameId()) ||
						(classPK != geolocation.getClassPK())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_GEOLOCATION_WHERE);

			query.append(_FINDER_COLUMN_C_M_C_C_COMPANYID_2);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_C_M_C_C_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_C_M_C_C_MODIFIEDDATE_2);
			}

			query.append(_FINDER_COLUMN_C_M_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_M_C_C_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeolocationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				qPos.add(classNameId);

				qPos.add(classPK);

				if (!pagination) {
					list = (List<Geolocation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Geolocation>(list);
				}
				else {
					list = (List<Geolocation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first geolocation in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation findByC_M_C_C_First(long companyId, Date modifiedDate,
		long classNameId, long classPK, OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = fetchByC_M_C_C_First(companyId, modifiedDate,
				classNameId, classPK, orderByComparator);

		if (geolocation != null) {
			return geolocation;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeolocationException(msg.toString());
	}

	/**
	 * Returns the first geolocation in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geolocation, or <code>null</code> if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation fetchByC_M_C_C_First(long companyId, Date modifiedDate,
		long classNameId, long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		List<Geolocation> list = findByC_M_C_C(companyId, modifiedDate,
				classNameId, classPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geolocation in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation findByC_M_C_C_Last(long companyId, Date modifiedDate,
		long classNameId, long classPK, OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = fetchByC_M_C_C_Last(companyId, modifiedDate,
				classNameId, classPK, orderByComparator);

		if (geolocation != null) {
			return geolocation;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", modifiedDate=");
		msg.append(modifiedDate);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeolocationException(msg.toString());
	}

	/**
	 * Returns the last geolocation in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geolocation, or <code>null</code> if a matching geolocation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation fetchByC_M_C_C_Last(long companyId, Date modifiedDate,
		long classNameId, long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_M_C_C(companyId, modifiedDate, classNameId, classPK);

		if (count == 0) {
			return null;
		}

		List<Geolocation> list = findByC_M_C_C(companyId, modifiedDate,
				classNameId, classPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the geolocations before and after the current geolocation in the ordered set where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param geolocationId the primary key of the current geolocation
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation[] findByC_M_C_C_PrevAndNext(long geolocationId,
		long companyId, Date modifiedDate, long classNameId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = findByPrimaryKey(geolocationId);

		Session session = null;

		try {
			session = openSession();

			Geolocation[] array = new GeolocationImpl[3];

			array[0] = getByC_M_C_C_PrevAndNext(session, geolocation,
					companyId, modifiedDate, classNameId, classPK,
					orderByComparator, true);

			array[1] = geolocation;

			array[2] = getByC_M_C_C_PrevAndNext(session, geolocation,
					companyId, modifiedDate, classNameId, classPK,
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

	protected Geolocation getByC_M_C_C_PrevAndNext(Session session,
		Geolocation geolocation, long companyId, Date modifiedDate,
		long classNameId, long classPK, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEOLOCATION_WHERE);

		query.append(_FINDER_COLUMN_C_M_C_C_COMPANYID_2);

		boolean bindModifiedDate = false;

		if (modifiedDate == null) {
			query.append(_FINDER_COLUMN_C_M_C_C_MODIFIEDDATE_1);
		}
		else {
			bindModifiedDate = true;

			query.append(_FINDER_COLUMN_C_M_C_C_MODIFIEDDATE_2);
		}

		query.append(_FINDER_COLUMN_C_M_C_C_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_C_M_C_C_CLASSPK_2);

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
			query.append(GeolocationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindModifiedDate) {
			qPos.add(CalendarUtil.getTimestamp(modifiedDate));
		}

		qPos.add(classNameId);

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(geolocation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Geolocation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_M_C_C(long companyId, Date modifiedDate,
		long classNameId, long classPK) throws SystemException {
		for (Geolocation geolocation : findByC_M_C_C(companyId, modifiedDate,
				classNameId, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(geolocation);
		}
	}

	/**
	 * Returns the number of geolocations where companyId = &#63; and modifiedDate &gt; &#63; and classNameId = &#63; and classPK = &#63;.
	 *
	 * @param companyId the company ID
	 * @param modifiedDate the modified date
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_M_C_C(long companyId, Date modifiedDate,
		long classNameId, long classPK) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_M_C_C;

		Object[] finderArgs = new Object[] {
				companyId, modifiedDate, classNameId, classPK
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_GEOLOCATION_WHERE);

			query.append(_FINDER_COLUMN_C_M_C_C_COMPANYID_2);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_C_M_C_C_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_C_M_C_C_MODIFIEDDATE_2);
			}

			query.append(_FINDER_COLUMN_C_M_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_M_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(modifiedDate));
				}

				qPos.add(classNameId);

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_C_M_C_C_COMPANYID_2 = "geolocation.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_M_C_C_MODIFIEDDATE_1 = "geolocation.modifiedDate > NULL AND ";
	private static final String _FINDER_COLUMN_C_M_C_C_MODIFIEDDATE_2 = "geolocation.modifiedDate > ? AND ";
	private static final String _FINDER_COLUMN_C_M_C_C_CLASSNAMEID_2 = "geolocation.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_M_C_C_CLASSPK_2 = "geolocation.classPK = ?";

	public GeolocationPersistenceImpl() {
		setModelClass(Geolocation.class);
	}

	/**
	 * Caches the geolocation in the entity cache if it is enabled.
	 *
	 * @param geolocation the geolocation
	 */
	@Override
	public void cacheResult(Geolocation geolocation) {
		EntityCacheUtil.putResult(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationImpl.class, geolocation.getPrimaryKey(), geolocation);

		geolocation.resetOriginalValues();
	}

	/**
	 * Caches the geolocations in the entity cache if it is enabled.
	 *
	 * @param geolocations the geolocations
	 */
	@Override
	public void cacheResult(List<Geolocation> geolocations) {
		for (Geolocation geolocation : geolocations) {
			if (EntityCacheUtil.getResult(
						GeolocationModelImpl.ENTITY_CACHE_ENABLED,
						GeolocationImpl.class, geolocation.getPrimaryKey()) == null) {
				cacheResult(geolocation);
			}
			else {
				geolocation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all geolocations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeolocationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeolocationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the geolocation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Geolocation geolocation) {
		EntityCacheUtil.removeResult(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationImpl.class, geolocation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Geolocation> geolocations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Geolocation geolocation : geolocations) {
			EntityCacheUtil.removeResult(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
				GeolocationImpl.class, geolocation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new geolocation with the primary key. Does not add the geolocation to the database.
	 *
	 * @param geolocationId the primary key for the new geolocation
	 * @return the new geolocation
	 */
	@Override
	public Geolocation create(long geolocationId) {
		Geolocation geolocation = new GeolocationImpl();

		geolocation.setNew(true);
		geolocation.setPrimaryKey(geolocationId);

		String uuid = PortalUUIDUtil.generate();

		geolocation.setUuid(uuid);

		return geolocation;
	}

	/**
	 * Removes the geolocation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geolocationId the primary key of the geolocation
	 * @return the geolocation that was removed
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation remove(long geolocationId)
		throws NoSuchGeolocationException, SystemException {
		return remove((Serializable)geolocationId);
	}

	/**
	 * Removes the geolocation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the geolocation
	 * @return the geolocation that was removed
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation remove(Serializable primaryKey)
		throws NoSuchGeolocationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Geolocation geolocation = (Geolocation)session.get(GeolocationImpl.class,
					primaryKey);

			if (geolocation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeolocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(geolocation);
		}
		catch (NoSuchGeolocationException nsee) {
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
	protected Geolocation removeImpl(Geolocation geolocation)
		throws SystemException {
		geolocation = toUnwrappedModel(geolocation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geolocation)) {
				geolocation = (Geolocation)session.get(GeolocationImpl.class,
						geolocation.getPrimaryKeyObj());
			}

			if (geolocation != null) {
				session.delete(geolocation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geolocation != null) {
			clearCache(geolocation);
		}

		return geolocation;
	}

	@Override
	public Geolocation updateImpl(
		com.liferay.geolocation.model.Geolocation geolocation)
		throws SystemException {
		geolocation = toUnwrappedModel(geolocation);

		boolean isNew = geolocation.isNew();

		GeolocationModelImpl geolocationModelImpl = (GeolocationModelImpl)geolocation;

		if (Validator.isNull(geolocation.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			geolocation.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (geolocation.isNew()) {
				session.save(geolocation);

				geolocation.setNew(false);
			}
			else {
				session.merge(geolocation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GeolocationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((geolocationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						geolocationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { geolocationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((geolocationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						geolocationModelImpl.getOriginalUuid(),
						geolocationModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						geolocationModelImpl.getUuid(),
						geolocationModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((geolocationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						geolocationModelImpl.getOriginalCompanyId(),
						geolocationModelImpl.getOriginalClassNameId(),
						geolocationModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C,
					args);

				args = new Object[] {
						geolocationModelImpl.getCompanyId(),
						geolocationModelImpl.getClassNameId(),
						geolocationModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C,
					args);
			}
		}

		EntityCacheUtil.putResult(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
			GeolocationImpl.class, geolocation.getPrimaryKey(), geolocation);

		return geolocation;
	}

	protected Geolocation toUnwrappedModel(Geolocation geolocation) {
		if (geolocation instanceof GeolocationImpl) {
			return geolocation;
		}

		GeolocationImpl geolocationImpl = new GeolocationImpl();

		geolocationImpl.setNew(geolocation.isNew());
		geolocationImpl.setPrimaryKey(geolocation.getPrimaryKey());

		geolocationImpl.setUuid(geolocation.getUuid());
		geolocationImpl.setGeolocationId(geolocation.getGeolocationId());
		geolocationImpl.setCompanyId(geolocation.getCompanyId());
		geolocationImpl.setModifiedDate(geolocation.getModifiedDate());
		geolocationImpl.setClassNameId(geolocation.getClassNameId());
		geolocationImpl.setClassPK(geolocation.getClassPK());
		geolocationImpl.setLatitude(geolocation.getLatitude());
		geolocationImpl.setLongitude(geolocation.getLongitude());
		geolocationImpl.setAreaCode(geolocation.getAreaCode());
		geolocationImpl.setCity(geolocation.getCity());
		geolocationImpl.setCountryCode(geolocation.getCountryCode());
		geolocationImpl.setCountryName(geolocation.getCountryName());
		geolocationImpl.setMetroCode(geolocation.getMetroCode());
		geolocationImpl.setRegionCode(geolocation.getRegionCode());
		geolocationImpl.setRegionName(geolocation.getRegionName());
		geolocationImpl.setZipCode(geolocation.getZipCode());

		return geolocationImpl;
	}

	/**
	 * Returns the geolocation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the geolocation
	 * @return the geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeolocationException, SystemException {
		Geolocation geolocation = fetchByPrimaryKey(primaryKey);

		if (geolocation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeolocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return geolocation;
	}

	/**
	 * Returns the geolocation with the primary key or throws a {@link com.liferay.geolocation.NoSuchGeolocationException} if it could not be found.
	 *
	 * @param geolocationId the primary key of the geolocation
	 * @return the geolocation
	 * @throws com.liferay.geolocation.NoSuchGeolocationException if a geolocation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation findByPrimaryKey(long geolocationId)
		throws NoSuchGeolocationException, SystemException {
		return findByPrimaryKey((Serializable)geolocationId);
	}

	/**
	 * Returns the geolocation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the geolocation
	 * @return the geolocation, or <code>null</code> if a geolocation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Geolocation geolocation = (Geolocation)EntityCacheUtil.getResult(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
				GeolocationImpl.class, primaryKey);

		if (geolocation == _nullGeolocation) {
			return null;
		}

		if (geolocation == null) {
			Session session = null;

			try {
				session = openSession();

				geolocation = (Geolocation)session.get(GeolocationImpl.class,
						primaryKey);

				if (geolocation != null) {
					cacheResult(geolocation);
				}
				else {
					EntityCacheUtil.putResult(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
						GeolocationImpl.class, primaryKey, _nullGeolocation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeolocationModelImpl.ENTITY_CACHE_ENABLED,
					GeolocationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geolocation;
	}

	/**
	 * Returns the geolocation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param geolocationId the primary key of the geolocation
	 * @return the geolocation, or <code>null</code> if a geolocation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Geolocation fetchByPrimaryKey(long geolocationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)geolocationId);
	}

	/**
	 * Returns all the geolocations.
	 *
	 * @return the geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the geolocations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geolocations
	 * @param end the upper bound of the range of geolocations (not inclusive)
	 * @return the range of geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the geolocations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.geolocation.model.impl.GeolocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of geolocations
	 * @param end the upper bound of the range of geolocations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of geolocations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Geolocation> findAll(int start, int end,
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

		List<Geolocation> list = (List<Geolocation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEOLOCATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEOLOCATION;

				if (pagination) {
					sql = sql.concat(GeolocationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Geolocation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Geolocation>(list);
				}
				else {
					list = (List<Geolocation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the geolocations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Geolocation geolocation : findAll()) {
			remove(geolocation);
		}
	}

	/**
	 * Returns the number of geolocations.
	 *
	 * @return the number of geolocations
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

				Query q = session.createQuery(_SQL_COUNT_GEOLOCATION);

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
	 * Initializes the geolocation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.geolocation.model.Geolocation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Geolocation>> listenersList = new ArrayList<ModelListener<Geolocation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Geolocation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GeolocationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEOLOCATION = "SELECT geolocation FROM Geolocation geolocation";
	private static final String _SQL_SELECT_GEOLOCATION_WHERE = "SELECT geolocation FROM Geolocation geolocation WHERE ";
	private static final String _SQL_COUNT_GEOLOCATION = "SELECT COUNT(geolocation) FROM Geolocation geolocation";
	private static final String _SQL_COUNT_GEOLOCATION_WHERE = "SELECT COUNT(geolocation) FROM Geolocation geolocation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "geolocation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Geolocation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Geolocation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeolocationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Geolocation _nullGeolocation = new GeolocationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Geolocation> toCacheModel() {
				return _nullGeolocationCacheModel;
			}
		};

	private static CacheModel<Geolocation> _nullGeolocationCacheModel = new CacheModel<Geolocation>() {
			@Override
			public Geolocation toEntityModel() {
				return _nullGeolocation;
			}
		};
}