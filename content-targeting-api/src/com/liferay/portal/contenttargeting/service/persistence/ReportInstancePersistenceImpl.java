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

package com.liferay.portal.contenttargeting.service.persistence;

import com.liferay.portal.contenttargeting.NoSuchReportInstanceException;
import com.liferay.portal.contenttargeting.model.ReportInstance;
import com.liferay.portal.contenttargeting.model.impl.ReportInstanceImpl;
import com.liferay.portal.contenttargeting.model.impl.ReportInstanceModelImpl;
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
	public static final FinderPath FINDER_PATH_FETCH_BY_R_C_C = new FinderPath(ReportInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ReportInstanceModelImpl.FINDER_CACHE_ENABLED,
			ReportInstanceImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByR_C_C",
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
	 * Returns the report instance where reportKey = &#63; and className = &#63; and classPK = &#63; or throws a {@link com.liferay.portal.contenttargeting.NoSuchReportInstanceException} if it could not be found.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching report instance
	 * @throws com.liferay.portal.contenttargeting.NoSuchReportInstanceException if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance findByR_C_C(String reportKey, String className,
		long classPK) throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = fetchByR_C_C(reportKey, className,
				classPK);

		if (reportInstance == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("reportKey=");
			msg.append(reportKey);

			msg.append(", className=");
			msg.append(className);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchReportInstanceException(msg.toString());
		}

		return reportInstance;
	}

	/**
	 * Returns the report instance where reportKey = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByR_C_C(String reportKey, String className,
		long classPK) throws SystemException {
		return fetchByR_C_C(reportKey, className, classPK, true);
	}

	/**
	 * Returns the report instance where reportKey = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance fetchByR_C_C(String reportKey, String className,
		long classPK, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { reportKey, className, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_R_C_C,
					finderArgs, this);
		}

		if (result instanceof ReportInstance) {
			ReportInstance reportInstance = (ReportInstance)result;

			if (!Validator.equals(reportKey, reportInstance.getReportKey()) ||
					!Validator.equals(className, reportInstance.getClassName()) ||
					(classPK != reportInstance.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

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

				List<ReportInstance> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_R_C_C,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ReportInstancePersistenceImpl.fetchByR_C_C(String, String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ReportInstance reportInstance = list.get(0);

					result = reportInstance;

					cacheResult(reportInstance);

					if ((reportInstance.getReportKey() == null) ||
							!reportInstance.getReportKey().equals(reportKey) ||
							(reportInstance.getClassName() == null) ||
							!reportInstance.getClassName().equals(className) ||
							(reportInstance.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_R_C_C,
							finderArgs, reportInstance);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_R_C_C,
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
	 * Removes the report instance where reportKey = &#63; and className = &#63; and classPK = &#63; from the database.
	 *
	 * @param reportKey the report key
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the report instance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReportInstance removeByR_C_C(String reportKey, String className,
		long classPK) throws NoSuchReportInstanceException, SystemException {
		ReportInstance reportInstance = findByR_C_C(reportKey, className,
				classPK);

		return remove(reportInstance);
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

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_R_C_C,
			new Object[] {
				reportInstance.getReportKey(), reportInstance.getClassName(),
				reportInstance.getClassPK()
			}, reportInstance);

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
					reportInstance.getReportKey(), reportInstance.getClassName(),
					reportInstance.getClassPK()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_R_C_C, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_R_C_C, args,
				reportInstance);
		}
		else {
			ReportInstanceModelImpl reportInstanceModelImpl = (ReportInstanceModelImpl)reportInstance;

			if ((reportInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_R_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reportInstance.getReportKey(),
						reportInstance.getClassName(),
						reportInstance.getClassPK()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_R_C_C, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_R_C_C, args,
					reportInstance);
			}
		}
	}

	protected void clearUniqueFindersCache(ReportInstance reportInstance) {
		ReportInstanceModelImpl reportInstanceModelImpl = (ReportInstanceModelImpl)reportInstance;

		Object[] args = new Object[] {
				reportInstance.getReportKey(), reportInstance.getClassName(),
				reportInstance.getClassPK()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_C_C, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_R_C_C, args);

		if ((reportInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_R_C_C.getColumnBitmask()) != 0) {
			args = new Object[] {
					reportInstanceModelImpl.getOriginalReportKey(),
					reportInstanceModelImpl.getOriginalClassName(),
					reportInstanceModelImpl.getOriginalClassPK()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_C_C, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_R_C_C, args);
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

		return reportInstance;
	}

	/**
	 * Removes the report instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportInstanceId the primary key of the report instance
	 * @return the report instance that was removed
	 * @throws com.liferay.portal.contenttargeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
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
	 * @throws com.liferay.portal.contenttargeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
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
		com.liferay.portal.contenttargeting.model.ReportInstance reportInstance)
		throws SystemException {
		reportInstance = toUnwrappedModel(reportInstance);

		boolean isNew = reportInstance.isNew();

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

		reportInstanceImpl.setReportInstanceId(reportInstance.getReportInstanceId());
		reportInstanceImpl.setGroupId(reportInstance.getGroupId());
		reportInstanceImpl.setCompanyId(reportInstance.getCompanyId());
		reportInstanceImpl.setUserId(reportInstance.getUserId());
		reportInstanceImpl.setUserName(reportInstance.getUserName());
		reportInstanceImpl.setModifiedDate(reportInstance.getModifiedDate());
		reportInstanceImpl.setReportKey(reportInstance.getReportKey());
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
	 * @throws com.liferay.portal.contenttargeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
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
	 * Returns the report instance with the primary key or throws a {@link com.liferay.portal.contenttargeting.NoSuchReportInstanceException} if it could not be found.
	 *
	 * @param reportInstanceId the primary key of the report instance
	 * @return the report instance
	 * @throws com.liferay.portal.contenttargeting.NoSuchReportInstanceException if a report instance with the primary key could not be found
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.contenttargeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portal.contenttargeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	 * Initializes the report instance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.portal.contenttargeting.model.ReportInstance")));

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