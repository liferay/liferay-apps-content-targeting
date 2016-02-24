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

package com.liferay.content.targeting.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.content.targeting.exception.NoSuchRuleInstanceException;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.persistence.RuleInstancePersistence;
import com.liferay.content.targeting.service.persistence.RuleInstanceUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class RuleInstancePersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = RuleInstanceUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RuleInstance> iterator = _ruleInstances.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RuleInstance ruleInstance = _persistence.create(pk);

		Assert.assertNotNull(ruleInstance);

		Assert.assertEquals(ruleInstance.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RuleInstance newRuleInstance = addRuleInstance();

		_persistence.remove(newRuleInstance);

		RuleInstance existingRuleInstance = _persistence.fetchByPrimaryKey(newRuleInstance.getPrimaryKey());

		Assert.assertNull(existingRuleInstance);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRuleInstance();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RuleInstance newRuleInstance = _persistence.create(pk);

		newRuleInstance.setUuid(RandomTestUtil.randomString());

		newRuleInstance.setGroupId(RandomTestUtil.nextLong());

		newRuleInstance.setCompanyId(RandomTestUtil.nextLong());

		newRuleInstance.setUserId(RandomTestUtil.nextLong());

		newRuleInstance.setUserName(RandomTestUtil.randomString());

		newRuleInstance.setCreateDate(RandomTestUtil.nextDate());

		newRuleInstance.setModifiedDate(RandomTestUtil.nextDate());

		newRuleInstance.setRuleKey(RandomTestUtil.randomString());

		newRuleInstance.setUserSegmentId(RandomTestUtil.nextLong());

		newRuleInstance.setTypeSettings(RandomTestUtil.randomString());

		_ruleInstances.add(_persistence.update(newRuleInstance));

		RuleInstance existingRuleInstance = _persistence.findByPrimaryKey(newRuleInstance.getPrimaryKey());

		Assert.assertEquals(existingRuleInstance.getUuid(),
			newRuleInstance.getUuid());
		Assert.assertEquals(existingRuleInstance.getRuleInstanceId(),
			newRuleInstance.getRuleInstanceId());
		Assert.assertEquals(existingRuleInstance.getGroupId(),
			newRuleInstance.getGroupId());
		Assert.assertEquals(existingRuleInstance.getCompanyId(),
			newRuleInstance.getCompanyId());
		Assert.assertEquals(existingRuleInstance.getUserId(),
			newRuleInstance.getUserId());
		Assert.assertEquals(existingRuleInstance.getUserName(),
			newRuleInstance.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingRuleInstance.getCreateDate()),
			Time.getShortTimestamp(newRuleInstance.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingRuleInstance.getModifiedDate()),
			Time.getShortTimestamp(newRuleInstance.getModifiedDate()));
		Assert.assertEquals(existingRuleInstance.getRuleKey(),
			newRuleInstance.getRuleKey());
		Assert.assertEquals(existingRuleInstance.getUserSegmentId(),
			newRuleInstance.getUserSegmentId());
		Assert.assertEquals(existingRuleInstance.getTypeSettings(),
			newRuleInstance.getTypeSettings());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUUID_G(StringPool.NULL, 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByUserSegmentId() throws Exception {
		_persistence.countByUserSegmentId(RandomTestUtil.nextLong());

		_persistence.countByUserSegmentId(0L);
	}

	@Test
	public void testCountByR_U() throws Exception {
		_persistence.countByR_U(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByR_U(StringPool.NULL, 0L);

		_persistence.countByR_U((String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RuleInstance newRuleInstance = addRuleInstance();

		RuleInstance existingRuleInstance = _persistence.findByPrimaryKey(newRuleInstance.getPrimaryKey());

		Assert.assertEquals(existingRuleInstance, newRuleInstance);
	}

	@Test(expected = NoSuchRuleInstanceException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<RuleInstance> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_RuleInstance", "uuid",
			true, "ruleInstanceId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "ruleKey", true, "userSegmentId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RuleInstance newRuleInstance = addRuleInstance();

		RuleInstance existingRuleInstance = _persistence.fetchByPrimaryKey(newRuleInstance.getPrimaryKey());

		Assert.assertEquals(existingRuleInstance, newRuleInstance);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RuleInstance missingRuleInstance = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRuleInstance);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		RuleInstance newRuleInstance1 = addRuleInstance();
		RuleInstance newRuleInstance2 = addRuleInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRuleInstance1.getPrimaryKey());
		primaryKeys.add(newRuleInstance2.getPrimaryKey());

		Map<Serializable, RuleInstance> ruleInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, ruleInstances.size());
		Assert.assertEquals(newRuleInstance1,
			ruleInstances.get(newRuleInstance1.getPrimaryKey()));
		Assert.assertEquals(newRuleInstance2,
			ruleInstances.get(newRuleInstance2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RuleInstance> ruleInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ruleInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		RuleInstance newRuleInstance = addRuleInstance();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRuleInstance.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RuleInstance> ruleInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ruleInstances.size());
		Assert.assertEquals(newRuleInstance,
			ruleInstances.get(newRuleInstance.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RuleInstance> ruleInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ruleInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		RuleInstance newRuleInstance = addRuleInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRuleInstance.getPrimaryKey());

		Map<Serializable, RuleInstance> ruleInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ruleInstances.size());
		Assert.assertEquals(newRuleInstance,
			ruleInstances.get(newRuleInstance.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = RuleInstanceLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<RuleInstance>() {
				@Override
				public void performAction(RuleInstance ruleInstance) {
					Assert.assertNotNull(ruleInstance);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		RuleInstance newRuleInstance = addRuleInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RuleInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("ruleInstanceId",
				newRuleInstance.getRuleInstanceId()));

		List<RuleInstance> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		RuleInstance existingRuleInstance = result.get(0);

		Assert.assertEquals(existingRuleInstance, newRuleInstance);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RuleInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("ruleInstanceId",
				RandomTestUtil.nextLong()));

		List<RuleInstance> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		RuleInstance newRuleInstance = addRuleInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RuleInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"ruleInstanceId"));

		Object newRuleInstanceId = newRuleInstance.getRuleInstanceId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("ruleInstanceId",
				new Object[] { newRuleInstanceId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingRuleInstanceId = result.get(0);

		Assert.assertEquals(existingRuleInstanceId, newRuleInstanceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RuleInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"ruleInstanceId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("ruleInstanceId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		RuleInstance newRuleInstance = addRuleInstance();

		_persistence.clearCache();

		RuleInstance existingRuleInstance = _persistence.findByPrimaryKey(newRuleInstance.getPrimaryKey());

		Assert.assertTrue(Validator.equals(existingRuleInstance.getUuid(),
				ReflectionTestUtil.invoke(existingRuleInstance,
					"getOriginalUuid", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingRuleInstance.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingRuleInstance,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected RuleInstance addRuleInstance() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RuleInstance ruleInstance = _persistence.create(pk);

		ruleInstance.setUuid(RandomTestUtil.randomString());

		ruleInstance.setGroupId(RandomTestUtil.nextLong());

		ruleInstance.setCompanyId(RandomTestUtil.nextLong());

		ruleInstance.setUserId(RandomTestUtil.nextLong());

		ruleInstance.setUserName(RandomTestUtil.randomString());

		ruleInstance.setCreateDate(RandomTestUtil.nextDate());

		ruleInstance.setModifiedDate(RandomTestUtil.nextDate());

		ruleInstance.setRuleKey(RandomTestUtil.randomString());

		ruleInstance.setUserSegmentId(RandomTestUtil.nextLong());

		ruleInstance.setTypeSettings(RandomTestUtil.randomString());

		_ruleInstances.add(_persistence.update(ruleInstance));

		return ruleInstance;
	}

	private List<RuleInstance> _ruleInstances = new ArrayList<RuleInstance>();
	private RuleInstancePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}