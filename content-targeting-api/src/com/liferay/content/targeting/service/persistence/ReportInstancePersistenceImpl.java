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

package com.liferay.content.targeting.service.persistence;

import com.liferay.content.targeting.NoSuchReportInstanceException;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.model.impl.ReportInstanceImpl;
import com.liferay.content.targeting.model.impl.ReportInstanceModelImpl;

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
 * The persistence implementation for the report instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstancePersistence
 * @see ReportInstanceUtil
 * @generated
 */
public class ReportInstancePersistenceImpl extends BasePersistenceImpl<ReportInstance>
	implements ReportInstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReportInstanceUtil} to access the report instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReportInstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ReportInstanceModelImpl.UUID_COLUMN_BITMASK |
			ReportInstanceModelImpl.REPORTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the report instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the report instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @return the range of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the report instances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByUuid(String uuid, int start, int end,
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

		List<ReportInstance> list = (List<ReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ReportInstance reportInstance : list) {
				if (!Validator.equals(uuid, reportInstance.getUuid())) {
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

			query.append(_SQL_SELECT_REPORTINSTANCE_WHERE);

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
				query.append(ReportInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReportInstance>(list);
				}
				else {
					list = (List<ReportInstance>)QueryUtil.list(q,
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
	 * Returns the first report instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByUuid_First(uuid,
				orderByComparator);

		if (reportInstance != null) {
			return reportInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportInstanceException(msg.toString());
	}

	/**
	 * Returns the first report instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ReportInstance> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last report instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByUuid_Last(uuid, orderByComparator);

		if (reportInstance != null) {
			return reportInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportInstanceException(msg.toString());
	}

	/**
	 * Returns the last report instance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ReportInstance> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the report instances before and after the current report instance in the ordered set where uuid = &#63;.
	 *
	 * @param reportInstanceId the primary key of the current report instance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance[] findByUuid_PrevAndNext(long reportInstanceId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = findByPrimaryKey(reportInstanceId);

		Session session = null;

		try {
			session = openSession();

			ReportInstance[] array = new ReportInstanceImpl[3];

			array[0] = getByUuid_PrevAndNext(session, reportInstance, uuid,
					orderByComparator, true);

			array[1] = reportInstance;

			array[2] = getByUuid_PrevAndNext(session, reportInstance, uuid,
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

	protected ReportInstance getByUuid_PrevAndNext(Session session,
		ReportInstance reportInstance, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REPORTINSTANCE_WHERE);

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
			query.append(ReportInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(reportInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ReportInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the report instances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ReportInstance reportInstance : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(reportInstance);
		}
	}

	/**
	 * Returns the number of report instances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching report instances
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

			query.append(_SQL_COUNT_REPORTINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "reportInstance.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "reportInstance.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(reportInstance.uuid IS NULL OR reportInstance.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ReportInstanceModelImpl.UUID_COLUMN_BITMASK |
			ReportInstanceModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the report instance where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.content.targeting.NoSuchReportInstanceException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByUUID_G(String uuid, long groupId)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByUUID_G(uuid, groupId);

		if (reportInstance == null) {
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

			throw new NoSuchReportInstanceException(msg.toString());
		}

		return reportInstance;
	}

	/**
	 * Returns the report instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the report instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ReportInstance) {
			ReportInstance reportInstance = (ReportInstance)result;

			if (!Validator.equals(uuid, reportInstance.getUuid()) ||
					(groupId != reportInstance.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_REPORTINSTANCE_WHERE);

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

				List<ReportInstance> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ReportInstance reportInstance = list.get(0);

					result = reportInstance;

					cacheResult(reportInstance);

					if ((reportInstance.getUuid() == null) ||
							!reportInstance.getUuid().equals(uuid) ||
							(reportInstance.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, reportInstance);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			return (ReportInstance)result;
		}
	}

	/**
	 * Removes the report instance where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the report instance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance removeByUUID_G(String uuid, long groupId)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = findByUUID_G(uuid, groupId);

		return remove(reportInstance);
	}

	/**
	 * Returns the number of report instances where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_REPORTINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "reportInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "reportInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(reportInstance.uuid IS NULL OR reportInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "reportInstance.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ReportInstanceModelImpl.UUID_COLUMN_BITMASK |
			ReportInstanceModelImpl.COMPANYID_COLUMN_BITMASK |
			ReportInstanceModelImpl.REPORTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the report instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the report instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @return the range of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the report instances where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByUuid_C(String uuid, long companyId,
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

		List<ReportInstance> list = (List<ReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ReportInstance reportInstance : list) {
				if (!Validator.equals(uuid, reportInstance.getUuid()) ||
						(companyId != reportInstance.getCompanyId())) {
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

			query.append(_SQL_SELECT_REPORTINSTANCE_WHERE);

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
				query.append(ReportInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<ReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReportInstance>(list);
				}
				else {
					list = (List<ReportInstance>)QueryUtil.list(q,
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
	 * Returns the first report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (reportInstance != null) {
			return reportInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportInstanceException(msg.toString());
	}

	/**
	 * Returns the first report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ReportInstance> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (reportInstance != null) {
			return reportInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportInstanceException(msg.toString());
	}

	/**
	 * Returns the last report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ReportInstance> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the report instances before and after the current report instance in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param reportInstanceId the primary key of the current report instance
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance[] findByUuid_C_PrevAndNext(long reportInstanceId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = findByPrimaryKey(reportInstanceId);

		Session session = null;

		try {
			session = openSession();

			ReportInstance[] array = new ReportInstanceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, reportInstance, uuid,
					companyId, orderByComparator, true);

			array[1] = reportInstance;

			array[2] = getByUuid_C_PrevAndNext(session, reportInstance, uuid,
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

	protected ReportInstance getByUuid_C_PrevAndNext(Session session,
		ReportInstance reportInstance, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REPORTINSTANCE_WHERE);

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
			query.append(ReportInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(reportInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ReportInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the report instances where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ReportInstance reportInstance : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(reportInstance);
		}
	}

	/**
	 * Returns the number of report instances where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching report instances
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

			query.append(_SQL_COUNT_REPORTINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "reportInstance.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "reportInstance.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(reportInstance.uuid IS NULL OR reportInstance.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "reportInstance.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ReportInstanceModelImpl.CLASSNAME_COLUMN_BITMASK |
			ReportInstanceModelImpl.CLASSPK_COLUMN_BITMASK |
			ReportInstanceModelImpl.REPORTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the report instances where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByC_C(String className, long classPK)
		throws SystemException {
		return findByC_C(className, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the report instances where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @return the range of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByC_C(String className, long classPK,
		int start, int end) throws SystemException {
		return findByC_C(className, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the report instances where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByC_C(String className, long classPK,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C;
			finderArgs = new Object[] { className, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C;
			finderArgs = new Object[] {
					className, classPK,
					
					start, end, orderByComparator
				};
		}

		List<ReportInstance> list = (List<ReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ReportInstance reportInstance : list) {
				if (!Validator.equals(className, reportInstance.getClassName()) ||
						(classPK != reportInstance.getClassPK())) {
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

			query.append(_SQL_SELECT_REPORTINSTANCE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReportInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (!pagination) {
					list = (List<ReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReportInstance>(list);
				}
				else {
					list = (List<ReportInstance>)QueryUtil.list(q,
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
	 * Returns the first report instance in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByC_C_First(String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByC_C_First(className, classPK,
				orderByComparator);

		if (reportInstance != null) {
			return reportInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportInstanceException(msg.toString());
	}

	/**
	 * Returns the first report instance in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByC_C_First(String className, long classPK,
		OrderByComparator orderByComparator) throws SystemException {
		List<ReportInstance> list = findByC_C(className, classPK, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last report instance in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByC_C_Last(String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByC_C_Last(className, classPK,
				orderByComparator);

		if (reportInstance != null) {
			return reportInstance;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportInstanceException(msg.toString());
	}

	/**
	 * Returns the last report instance in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByC_C_Last(String className, long classPK,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_C(className, classPK);

		if (count == 0) {
			return null;
		}

		List<ReportInstance> list = findByC_C(className, classPK, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the report instances before and after the current report instance in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param reportInstanceId the primary key of the current report instance
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance[] findByC_C_PrevAndNext(long reportInstanceId,
		String className, long classPK, OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = findByPrimaryKey(reportInstanceId);

		Session session = null;

		try {
			session = openSession();

			ReportInstance[] array = new ReportInstanceImpl[3];

			array[0] = getByC_C_PrevAndNext(session, reportInstance, className,
					classPK, orderByComparator, true);

			array[1] = reportInstance;

			array[2] = getByC_C_PrevAndNext(session, reportInstance, className,
					classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ReportInstance getByC_C_PrevAndNext(Session session,
		ReportInstance reportInstance, String className, long classPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REPORTINSTANCE_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_C_C_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_C_C_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

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
			query.append(ReportInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(reportInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ReportInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the report instances where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C(String className, long classPK)
		throws SystemException {
		for (ReportInstance reportInstance : findByC_C(className, classPK,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(reportInstance);
		}
	}

	/**
	 * Returns the number of report instances where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C(String className, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C;

		Object[] finderArgs = new Object[] { className, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_REPORTINSTANCE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_C_C_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_C_C_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

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

	private static final String _FINDER_COLUMN_C_C_CLASSNAME_1 = "reportInstance.className IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSNAME_2 = "reportInstance.className = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSNAME_3 = "(reportInstance.className IS NULL OR reportInstance.className = '') AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSPK_2 = "reportInstance.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_C_C = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByR_C_C",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_C_C = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_C_C",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			ReportInstanceModelImpl.REPORTKEY_COLUMN_BITMASK |
			ReportInstanceModelImpl.CLASSNAME_COLUMN_BITMASK |
			ReportInstanceModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_C_C = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_C_C",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByR_C_C(String reportKey, String className,
		long classPK) throws SystemException {
		return findByR_C_C(reportKey, className, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @return the range of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByR_C_C(String reportKey, String className,
		long classPK, int start, int end) throws SystemException {
		return findByR_C_C(reportKey, className, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findByR_C_C(String reportKey, String className,
		long classPK, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_C_C;
			finderArgs = new Object[] { reportKey, className, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_C_C;
			finderArgs = new Object[] {
					reportKey, className, classPK,
					
					start, end, orderByComparator
				};
		}

		List<ReportInstance> list = (List<ReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ReportInstance reportInstance : list) {
				if (!Validator.equals(reportKey, reportInstance.getReportKey()) ||
						!Validator.equals(className,
							reportInstance.getClassName()) ||
						(classPK != reportInstance.getClassPK())) {
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

			query.append(_SQL_SELECT_REPORTINSTANCE_WHERE);

			boolean bindReportKey = false;

			if (reportKey == null) {
				query.append(_FINDER_COLUMN_R_C_C_REPORTKEY_1);
			}
			else if (reportKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_C_C_REPORTKEY_3);
			}
			else {
				bindReportKey = true;

				query.append(_FINDER_COLUMN_R_C_C_REPORTKEY_2);
			}

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_R_C_C_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_C_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_R_C_C_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_C_C_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReportInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReportKey) {
					qPos.add(reportKey);
				}

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (!pagination) {
					list = (List<ReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReportInstance>(list);
				}
				else {
					list = (List<ReportInstance>)QueryUtil.list(q,
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
	 * Returns the first report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByR_C_C_First(String reportKey, String className,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByR_C_C_First(reportKey,
				className, classPK, orderByComparator);

		if (reportInstance != null) {
			return reportInstance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportKey=");
		msg.append(reportKey);

		msg.append(", className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportInstanceException(msg.toString());
	}

	/**
	 * Returns the first report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByR_C_C_First(String reportKey,
		String className, long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		List<ReportInstance> list = findByR_C_C(reportKey, className, classPK,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByR_C_C_Last(String reportKey, String className,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByR_C_C_Last(reportKey, className,
				classPK, orderByComparator);

		if (reportInstance != null) {
			return reportInstance;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportKey=");
		msg.append(reportKey);

		msg.append(", className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReportInstanceException(msg.toString());
	}

	/**
	 * Returns the last report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByR_C_C_Last(String reportKey, String className,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByR_C_C(reportKey, className, classPK);

		if (count == 0) {
			return null;
		}

		List<ReportInstance> list = findByR_C_C(reportKey, className, classPK,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the report instances before and after the current report instance in the ordered set where reportKey = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param reportInstanceId the primary key of the current report instance
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance[] findByR_C_C_PrevAndNext(long reportInstanceId,
		String reportKey, String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = findByPrimaryKey(reportInstanceId);

		Session session = null;

		try {
			session = openSession();

			ReportInstance[] array = new ReportInstanceImpl[3];

			array[0] = getByR_C_C_PrevAndNext(session, reportInstance,
					reportKey, className, classPK, orderByComparator, true);

			array[1] = reportInstance;

			array[2] = getByR_C_C_PrevAndNext(session, reportInstance,
					reportKey, className, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ReportInstance getByR_C_C_PrevAndNext(Session session,
		ReportInstance reportInstance, String reportKey, String className,
		long classPK, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REPORTINSTANCE_WHERE);

		boolean bindReportKey = false;

		if (reportKey == null) {
			query.append(_FINDER_COLUMN_R_C_C_REPORTKEY_1);
		}
		else if (reportKey.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_R_C_C_REPORTKEY_3);
		}
		else {
			bindReportKey = true;

			query.append(_FINDER_COLUMN_R_C_C_REPORTKEY_2);
		}

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_R_C_C_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_R_C_C_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_R_C_C_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_R_C_C_CLASSPK_2);

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
			query.append(ReportInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindReportKey) {
			qPos.add(reportKey);
		}

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(reportInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ReportInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the report instances where reportKey = &#63; and className = &#63; and classPK = &#63; from the database.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByR_C_C(String reportKey, String className, long classPK)
		throws SystemException {
		for (ReportInstance reportInstance : findByR_C_C(reportKey, className,
				classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(reportInstance);
		}
	}

	/**
	 * Returns the number of report instances where reportKey = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByR_C_C(String reportKey, String className, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_C_C;

		Object[] finderArgs = new Object[] { reportKey, className, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_REPORTINSTANCE_WHERE);

			boolean bindReportKey = false;

			if (reportKey == null) {
				query.append(_FINDER_COLUMN_R_C_C_REPORTKEY_1);
			}
			else if (reportKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_C_C_REPORTKEY_3);
			}
			else {
				bindReportKey = true;

				query.append(_FINDER_COLUMN_R_C_C_REPORTKEY_2);
			}

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_R_C_C_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_R_C_C_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_R_C_C_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_R_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReportKey) {
					qPos.add(reportKey);
				}

				if (bindClassName) {
					qPos.add(className);
				}

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

	private static final String _FINDER_COLUMN_R_C_C_REPORTKEY_1 = "reportInstance.reportKey IS NULL AND ";
	private static final String _FINDER_COLUMN_R_C_C_REPORTKEY_2 = "reportInstance.reportKey = ? AND ";
	private static final String _FINDER_COLUMN_R_C_C_REPORTKEY_3 = "(reportInstance.reportKey IS NULL OR reportInstance.reportKey = '') AND ";
	private static final String _FINDER_COLUMN_R_C_C_CLASSNAME_1 = "reportInstance.className IS NULL AND ";
	private static final String _FINDER_COLUMN_R_C_C_CLASSNAME_2 = "reportInstance.className = ? AND ";
	private static final String _FINDER_COLUMN_R_C_C_CLASSNAME_3 = "(reportInstance.className IS NULL OR reportInstance.className = '') AND ";
	private static final String _FINDER_COLUMN_R_C_C_CLASSPK_2 = "reportInstance.classPK = ?";

	public ReportInstancePersistenceImpl() {
		setModelClass(ReportInstance.class);
	}

	/**
	 * Caches the report instance in the entity cache if it is enabled.
	 *
	 * @param reportInstance the report instance
	 */
	@Override
	public void cacheResult(ReportInstance reportInstance) {
		EntityCacheUtil.putResult(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceImpl.class, reportInstance.getPrimaryKey(),
			reportInstance);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { reportInstance.getUuid(), reportInstance.getGroupId() },
			reportInstance);

		reportInstance.resetOriginalValues();
	}

	/**
	 * Caches the report instances in the entity cache if it is enabled.
	 *
	 * @param reportInstances the report instances
	 */
	@Override
	public void cacheResult(List<ReportInstance> reportInstances) {
		for (ReportInstance reportInstance : reportInstances) {
			if (EntityCacheUtil.getResult(
						ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ReportInstanceImpl.class, reportInstance.getPrimaryKey()) == null) {
				cacheResult(reportInstance);
			}
			else {
				reportInstance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all report instances.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ReportInstanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ReportInstanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the report instance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ReportInstance reportInstance) {
		EntityCacheUtil.removeResult(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceImpl.class, reportInstance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(reportInstance);
	}

	@Override
	public void clearCache(List<ReportInstance> reportInstances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ReportInstance reportInstance : reportInstances) {
			EntityCacheUtil.removeResult(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ReportInstanceImpl.class, reportInstance.getPrimaryKey());

			clearUniqueFindersCache(reportInstance);
		}
	}

	protected void cacheUniqueFindersCache(ReportInstance reportInstance) {
		if (reportInstance.isNew()) {
			Object[] args = new Object[] {
					reportInstance.getUuid(), reportInstance.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				reportInstance);
		}
		else {
			ReportInstanceModelImpl reportInstanceModelImpl = (ReportInstanceModelImpl)reportInstance;

			if ((reportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reportInstance.getUuid(), reportInstance.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					reportInstance);
			}
		}
	}

	protected void clearUniqueFindersCache(ReportInstance reportInstance) {
		ReportInstanceModelImpl reportInstanceModelImpl = (ReportInstanceModelImpl)reportInstance;

		Object[] args = new Object[] {
				reportInstance.getUuid(), reportInstance.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((reportInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					reportInstanceModelImpl.getOriginalUuid(),
					reportInstanceModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new report instance with the primary key. Does not add the report instance to the database.
	 *
	 * @param reportInstanceId the primary key for the new report instance
	 * @return the new report instance
	 */
	@Override
	public ReportInstance create(long reportInstanceId) {
		ReportInstance reportInstance = new ReportInstanceImpl();

		reportInstance.setNew(true);
		reportInstance.setPrimaryKey(reportInstanceId);

		String uuid = PortalUUIDUtil.generate();

		reportInstance.setUuid(uuid);

		return reportInstance;
	}

	/**
	 * Removes the report instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportInstanceId the primary key of the report instance
	 * @return the report instance that was removed
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance remove(long reportInstanceId)
		throws NoSuchReportInstanceException, SystemException {
		return remove((Serializable)reportInstanceId);
	}

	/**
	 * Removes the report instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the report instance
	 * @return the report instance that was removed
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance remove(Serializable primaryKey)
		throws NoSuchReportInstanceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ReportInstance reportInstance = (ReportInstance)session.get(ReportInstanceImpl.class,
					primaryKey);

			if (reportInstance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReportInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(reportInstance);
		}
		catch (NoSuchReportInstanceException nsee) {
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
	protected ReportInstance removeImpl(ReportInstance reportInstance)
		throws SystemException {
		reportInstance = toUnwrappedModel(reportInstance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(reportInstance)) {
				reportInstance = (ReportInstance)session.get(ReportInstanceImpl.class,
						reportInstance.getPrimaryKeyObj());
			}

			if (reportInstance != null) {
				session.delete(reportInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (reportInstance != null) {
			clearCache(reportInstance);
		}

		return reportInstance;
	}

	@Override
	public ReportInstance updateImpl(
		com.liferay.content.targeting.model.ReportInstance reportInstance)
		throws SystemException {
		reportInstance = toUnwrappedModel(reportInstance);

		boolean isNew = reportInstance.isNew();

		ReportInstanceModelImpl reportInstanceModelImpl = (ReportInstanceModelImpl)reportInstance;

		if (Validator.isNull(reportInstance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			reportInstance.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (reportInstance.isNew()) {
				session.save(reportInstance);

				reportInstance.setNew(false);
			}
			else {
				session.merge(reportInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ReportInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((reportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reportInstanceModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { reportInstanceModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((reportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reportInstanceModelImpl.getOriginalUuid(),
						reportInstanceModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						reportInstanceModelImpl.getUuid(),
						reportInstanceModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((reportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reportInstanceModelImpl.getOriginalClassName(),
						reportInstanceModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);

				args = new Object[] {
						reportInstanceModelImpl.getClassName(),
						reportInstanceModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C,
					args);
			}

			if ((reportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reportInstanceModelImpl.getOriginalReportKey(),
						reportInstanceModelImpl.getOriginalClassName(),
						reportInstanceModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_C_C,
					args);

				args = new Object[] {
						reportInstanceModelImpl.getReportKey(),
						reportInstanceModelImpl.getClassName(),
						reportInstanceModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_C_C,
					args);
			}
		}

		EntityCacheUtil.putResult(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceImpl.class, reportInstance.getPrimaryKey(),
			reportInstance);

		clearUniqueFindersCache(reportInstance);
		cacheUniqueFindersCache(reportInstance);

		return reportInstance;
	}

	protected ReportInstance toUnwrappedModel(ReportInstance reportInstance) {
		if (reportInstance instanceof ReportInstanceImpl) {
			return reportInstance;
		}

		ReportInstanceImpl reportInstanceImpl = new ReportInstanceImpl();

		reportInstanceImpl.setNew(reportInstance.isNew());
		reportInstanceImpl.setPrimaryKey(reportInstance.getPrimaryKey());

		reportInstanceImpl.setUuid(reportInstance.getUuid());
		reportInstanceImpl.setReportInstanceId(reportInstance.getReportInstanceId());
		reportInstanceImpl.setGroupId(reportInstance.getGroupId());
		reportInstanceImpl.setCompanyId(reportInstance.getCompanyId());
		reportInstanceImpl.setUserId(reportInstance.getUserId());
		reportInstanceImpl.setUserName(reportInstance.getUserName());
		reportInstanceImpl.setCreateDate(reportInstance.getCreateDate());
		reportInstanceImpl.setModifiedDate(reportInstance.getModifiedDate());
		reportInstanceImpl.setReportKey(reportInstance.getReportKey());
		reportInstanceImpl.setName(reportInstance.getName());
		reportInstanceImpl.setDescription(reportInstance.getDescription());
		reportInstanceImpl.setClassName(reportInstance.getClassName());
		reportInstanceImpl.setClassPK(reportInstance.getClassPK());
		reportInstanceImpl.setTypeSettings(reportInstance.getTypeSettings());

		return reportInstanceImpl;
	}

	/**
	 * Returns the report instance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the report instance
	 * @return the report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByPrimaryKey(primaryKey);

		if (reportInstance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReportInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return reportInstance;
	}

	/**
	 * Returns the report instance with the primary key or throws a {@link com.liferay.content.targeting.NoSuchReportInstanceException} if it could not be found.
	 *
	 * @param reportInstanceId the primary key of the report instance
	 * @return the report instance
	 * @throws com.liferay.content.targeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByPrimaryKey(long reportInstanceId)
		throws NoSuchReportInstanceException, SystemException {
		return findByPrimaryKey((Serializable)reportInstanceId);
	}

	/**
	 * Returns the report instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the report instance
	 * @return the report instance, or <code>null</code> if a report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ReportInstance reportInstance = (ReportInstance)EntityCacheUtil.getResult(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ReportInstanceImpl.class, primaryKey);

		if (reportInstance == _nullReportInstance) {
			return null;
		}

		if (reportInstance == null) {
			Session session = null;

			try {
				session = openSession();

				reportInstance = (ReportInstance)session.get(ReportInstanceImpl.class,
						primaryKey);

				if (reportInstance != null) {
					cacheResult(reportInstance);
				}
				else {
					EntityCacheUtil.putResult(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ReportInstanceImpl.class, primaryKey,
						_nullReportInstance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
					ReportInstanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return reportInstance;
	}

	/**
	 * Returns the report instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportInstanceId the primary key of the report instance
	 * @return the report instance, or <code>null</code> if a report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByPrimaryKey(long reportInstanceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)reportInstanceId);
	}

	/**
	 * Returns all the report instances.
	 *
	 * @return the report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the report instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @return the range of report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the report instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReportInstance> findAll(int start, int end,
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

		List<ReportInstance> list = (List<ReportInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REPORTINSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REPORTINSTANCE;

				if (pagination) {
					sql = sql.concat(ReportInstanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ReportInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReportInstance>(list);
				}
				else {
					list = (List<ReportInstance>)QueryUtil.list(q,
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
	 * Removes all the report instances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ReportInstance reportInstance : findAll()) {
			remove(reportInstance);
		}
	}

	/**
	 * Returns the number of report instances.
	 *
	 * @return the number of report instances
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

				Query q = session.createQuery(_SQL_COUNT_REPORTINSTANCE);

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
	 * Initializes the report instance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.content.targeting.model.ReportInstance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ReportInstance>> listenersList = new ArrayList<ModelListener<ReportInstance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ReportInstance>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ReportInstanceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REPORTINSTANCE = "SELECT reportInstance FROM ReportInstance reportInstance";
	private static final String _SQL_SELECT_REPORTINSTANCE_WHERE = "SELECT reportInstance FROM ReportInstance reportInstance WHERE ";
	private static final String _SQL_COUNT_REPORTINSTANCE = "SELECT COUNT(reportInstance) FROM ReportInstance reportInstance";
	private static final String _SQL_COUNT_REPORTINSTANCE_WHERE = "SELECT COUNT(reportInstance) FROM ReportInstance reportInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "reportInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ReportInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ReportInstance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ReportInstancePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ReportInstance _nullReportInstance = new ReportInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ReportInstance> toCacheModel() {
				return _nullReportInstanceCacheModel;
			}
		};

	private static CacheModel<ReportInstance> _nullReportInstanceCacheModel = new CacheModel<ReportInstance>() {
			@Override
			public ReportInstance toEntityModel() {
				return _nullReportInstance;
			}
		};
}