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

package com.liferay.content.targeting.rule.engine.service.persistence;

import com.liferay.content.targeting.rule.engine.model.RuleEngine;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the rule engine service. This utility wraps {@link RuleEnginePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleEnginePersistence
 * @see RuleEnginePersistenceImpl
 * @generated
 */
public class RuleEngineUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(RuleEngine ruleEngine) {
		getPersistence().clearCache(ruleEngine);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RuleEngine> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RuleEngine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RuleEngine> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RuleEngine update(RuleEngine ruleEngine)
		throws SystemException {
		return getPersistence().update(ruleEngine);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RuleEngine update(RuleEngine ruleEngine,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ruleEngine, serviceContext);
	}

	/**
	* Returns all the rule engines where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rule engines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the rule engines where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.engine.model.impl.RuleEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rule engines
	* @param end the upper bound of the range of rule engines (not inclusive)
	* @return the range of matching rule engines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the rule engines where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.engine.model.impl.RuleEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of rule engines
	* @param end the upper bound of the range of rule engines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rule engines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first rule engine in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule engine
	* @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a matching rule engine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.engine.model.RuleEngine findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first rule engine in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule engine, or <code>null</code> if a matching rule engine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.engine.model.RuleEngine fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last rule engine in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule engine
	* @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a matching rule engine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.engine.model.RuleEngine findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last rule engine in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule engine, or <code>null</code> if a matching rule engine could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.engine.model.RuleEngine fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the rule engines before and after the current rule engine in the ordered set where uuid = &#63;.
	*
	* @param dummyId the primary key of the current rule engine
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rule engine
	* @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a rule engine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.engine.model.RuleEngine[] findByUuid_PrevAndNext(
		long dummyId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(dummyId, uuid, orderByComparator);
	}

	/**
	* Removes all the rule engines where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of rule engines where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rule engines
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the rule engine in the entity cache if it is enabled.
	*
	* @param ruleEngine the rule engine
	*/
	public static void cacheResult(
		com.liferay.content.targeting.rule.engine.model.RuleEngine ruleEngine) {
		getPersistence().cacheResult(ruleEngine);
	}

	/**
	* Caches the rule engines in the entity cache if it is enabled.
	*
	* @param ruleEngines the rule engines
	*/
	public static void cacheResult(
		java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> ruleEngines) {
		getPersistence().cacheResult(ruleEngines);
	}

	/**
	* Creates a new rule engine with the primary key. Does not add the rule engine to the database.
	*
	* @param dummyId the primary key for the new rule engine
	* @return the new rule engine
	*/
	public static com.liferay.content.targeting.rule.engine.model.RuleEngine create(
		long dummyId) {
		return getPersistence().create(dummyId);
	}

	/**
	* Removes the rule engine with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dummyId the primary key of the rule engine
	* @return the rule engine that was removed
	* @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a rule engine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.engine.model.RuleEngine remove(
		long dummyId)
		throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(dummyId);
	}

	public static com.liferay.content.targeting.rule.engine.model.RuleEngine updateImpl(
		com.liferay.content.targeting.rule.engine.model.RuleEngine ruleEngine)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ruleEngine);
	}

	/**
	* Returns the rule engine with the primary key or throws a {@link com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException} if it could not be found.
	*
	* @param dummyId the primary key of the rule engine
	* @return the rule engine
	* @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a rule engine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.engine.model.RuleEngine findByPrimaryKey(
		long dummyId)
		throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(dummyId);
	}

	/**
	* Returns the rule engine with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dummyId the primary key of the rule engine
	* @return the rule engine, or <code>null</code> if a rule engine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.content.targeting.rule.engine.model.RuleEngine fetchByPrimaryKey(
		long dummyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dummyId);
	}

	/**
	* Returns all the rule engines.
	*
	* @return the rule engines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the rule engines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.engine.model.impl.RuleEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rule engines
	* @param end the upper bound of the range of rule engines (not inclusive)
	* @return the range of rule engines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the rule engines.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.engine.model.impl.RuleEngineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rule engines
	* @param end the upper bound of the range of rule engines (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rule engines
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rule engines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rule engines.
	*
	* @return the number of rule engines
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RuleEnginePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RuleEnginePersistence)PortletBeanLocatorUtil.locate(com.liferay.content.targeting.rule.engine.service.ClpSerializer.getServletContextName(),
					RuleEnginePersistence.class.getName());

			ReferenceRegistry.registerReference(RuleEngineUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RuleEnginePersistence persistence) {
	}

	private static RuleEnginePersistence _persistence;
}