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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the rule engine service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleEnginePersistenceImpl
 * @see RuleEngineUtil
 * @generated
 */
public interface RuleEnginePersistence extends BasePersistence<RuleEngine> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RuleEngineUtil} to access the rule engine persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rule engines where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching rule engines
	* @throws SystemException if a system exception occurred
	*/
	java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findByUuid(
			java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findByUuid(
			java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findByUuid(
			java.lang.String uuid, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule engine in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule engine
	* @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a matching rule engine could not be found
	* @throws SystemException if a system exception occurred
	*/
	com.liferay.content.targeting.rule.engine.model.RuleEngine findByUuid_First(
			java.lang.String uuid,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rule engine in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule engine, or <code>null</code> if a matching rule engine could not be found
	* @throws SystemException if a system exception occurred
	*/
	com.liferay.content.targeting.rule.engine.model.RuleEngine fetchByUuid_First(
			java.lang.String uuid,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule engine in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule engine
	* @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a matching rule engine could not be found
	* @throws SystemException if a system exception occurred
	*/
	com.liferay.content.targeting.rule.engine.model.RuleEngine findByUuid_Last(
			java.lang.String uuid,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rule engine in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule engine, or <code>null</code> if a matching rule engine could not be found
	* @throws SystemException if a system exception occurred
	*/
	com.liferay.content.targeting.rule.engine.model.RuleEngine fetchByUuid_Last(
			java.lang.String uuid,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	com.liferay.content.targeting.rule.engine.model.RuleEngine[] findByUuid_PrevAndNext(
			long dummyId, java.lang.String uuid,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rule engines where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rule engines where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching rule engines
	* @throws SystemException if a system exception occurred
	*/
	int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rule engine in the entity cache if it is enabled.
	*
	* @param ruleEngine the rule engine
	*/
	void cacheResult(
			com.liferay.content.targeting.rule.engine.model.RuleEngine ruleEngine);

	/**
	* Caches the rule engines in the entity cache if it is enabled.
	*
	* @param ruleEngines the rule engines
	*/
	void cacheResult(
			java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> ruleEngines);

	/**
	* Creates a new rule engine with the primary key. Does not add the rule engine to the database.
	*
	* @param dummyId the primary key for the new rule engine
	* @return the new rule engine
	*/
	com.liferay.content.targeting.rule.engine.model.RuleEngine create(
			long dummyId);

	/**
	* Removes the rule engine with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dummyId the primary key of the rule engine
	* @return the rule engine that was removed
	* @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a rule engine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	com.liferay.content.targeting.rule.engine.model.RuleEngine remove(
			long dummyId)
		throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException,
			com.liferay.portal.kernel.exception.SystemException;

	com.liferay.content.targeting.rule.engine.model.RuleEngine updateImpl(
			com.liferay.content.targeting.rule.engine.model.RuleEngine ruleEngine)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule engine with the primary key or throws a {@link com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException} if it could not be found.
	*
	* @param dummyId the primary key of the rule engine
	* @return the rule engine
	* @throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException if a rule engine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	com.liferay.content.targeting.rule.engine.model.RuleEngine findByPrimaryKey(
			long dummyId)
		throws com.liferay.content.targeting.rule.engine.NoSuchRuleEngineException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rule engine with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dummyId the primary key of the rule engine
	* @return the rule engine, or <code>null</code> if a rule engine with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	com.liferay.content.targeting.rule.engine.model.RuleEngine fetchByPrimaryKey(
			long dummyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rule engines.
	*
	* @return the rule engines
	* @throws SystemException if a system exception occurred
	*/
	java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findAll(
			int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	java.util.List<com.liferay.content.targeting.rule.engine.model.RuleEngine> findAll(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rule engines from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rule engines.
	*
	* @return the number of rule engines
	* @throws SystemException if a system exception occurred
	*/
	int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}