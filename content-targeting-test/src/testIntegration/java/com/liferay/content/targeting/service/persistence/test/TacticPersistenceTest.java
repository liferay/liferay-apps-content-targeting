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

import com.liferay.content.targeting.exception.NoSuchTacticException;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.content.targeting.service.persistence.TacticPersistence;
import com.liferay.content.targeting.service.persistence.TacticUtil;

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
public class TacticPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = TacticUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Tactic> iterator = _tactics.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Tactic tactic = _persistence.create(pk);

		Assert.assertNotNull(tactic);

		Assert.assertEquals(tactic.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Tactic newTactic = addTactic();

		_persistence.remove(newTactic);

		Tactic existingTactic = _persistence.fetchByPrimaryKey(newTactic.getPrimaryKey());

		Assert.assertNull(existingTactic);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTactic();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Tactic newTactic = _persistence.create(pk);

		newTactic.setUuid(RandomTestUtil.randomString());

		newTactic.setGroupId(RandomTestUtil.nextLong());

		newTactic.setCompanyId(RandomTestUtil.nextLong());

		newTactic.setUserId(RandomTestUtil.nextLong());

		newTactic.setUserName(RandomTestUtil.randomString());

		newTactic.setCreateDate(RandomTestUtil.nextDate());

		newTactic.setModifiedDate(RandomTestUtil.nextDate());

		newTactic.setCampaignId(RandomTestUtil.nextLong());

		newTactic.setName(RandomTestUtil.randomString());

		newTactic.setDescription(RandomTestUtil.randomString());

		_tactics.add(_persistence.update(newTactic));

		Tactic existingTactic = _persistence.findByPrimaryKey(newTactic.getPrimaryKey());

		Assert.assertEquals(existingTactic.getUuid(), newTactic.getUuid());
		Assert.assertEquals(existingTactic.getTacticId(),
			newTactic.getTacticId());
		Assert.assertEquals(existingTactic.getGroupId(), newTactic.getGroupId());
		Assert.assertEquals(existingTactic.getCompanyId(),
			newTactic.getCompanyId());
		Assert.assertEquals(existingTactic.getUserId(), newTactic.getUserId());
		Assert.assertEquals(existingTactic.getUserName(),
			newTactic.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingTactic.getCreateDate()),
			Time.getShortTimestamp(newTactic.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingTactic.getModifiedDate()),
			Time.getShortTimestamp(newTactic.getModifiedDate()));
		Assert.assertEquals(existingTactic.getCampaignId(),
			newTactic.getCampaignId());
		Assert.assertEquals(existingTactic.getName(), newTactic.getName());
		Assert.assertEquals(existingTactic.getDescription(),
			newTactic.getDescription());
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
	public void testCountByCampaignId() throws Exception {
		_persistence.countByCampaignId(RandomTestUtil.nextLong());

		_persistence.countByCampaignId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Tactic newTactic = addTactic();

		Tactic existingTactic = _persistence.findByPrimaryKey(newTactic.getPrimaryKey());

		Assert.assertEquals(existingTactic, newTactic);
	}

	@Test(expected = NoSuchTacticException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	@Test
	public void testFilterFindByGroupId() throws Exception {
		_persistence.filterFindByGroupId(0, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Tactic> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_Tactic", "uuid", true,
			"tacticId", true, "groupId", true, "companyId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true,
			"campaignId", true, "name", true, "description", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Tactic newTactic = addTactic();

		Tactic existingTactic = _persistence.fetchByPrimaryKey(newTactic.getPrimaryKey());

		Assert.assertEquals(existingTactic, newTactic);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Tactic missingTactic = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTactic);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Tactic newTactic1 = addTactic();
		Tactic newTactic2 = addTactic();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTactic1.getPrimaryKey());
		primaryKeys.add(newTactic2.getPrimaryKey());

		Map<Serializable, Tactic> tactics = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, tactics.size());
		Assert.assertEquals(newTactic1, tactics.get(newTactic1.getPrimaryKey()));
		Assert.assertEquals(newTactic2, tactics.get(newTactic2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Tactic> tactics = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(tactics.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Tactic newTactic = addTactic();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTactic.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Tactic> tactics = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, tactics.size());
		Assert.assertEquals(newTactic, tactics.get(newTactic.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Tactic> tactics = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(tactics.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Tactic newTactic = addTactic();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTactic.getPrimaryKey());

		Map<Serializable, Tactic> tactics = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, tactics.size());
		Assert.assertEquals(newTactic, tactics.get(newTactic.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = TacticLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Tactic>() {
				@Override
				public void performAction(Tactic tactic) {
					Assert.assertNotNull(tactic);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Tactic newTactic = addTactic();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Tactic.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("tacticId",
				newTactic.getTacticId()));

		List<Tactic> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Tactic existingTactic = result.get(0);

		Assert.assertEquals(existingTactic, newTactic);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Tactic.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("tacticId",
				RandomTestUtil.nextLong()));

		List<Tactic> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Tactic newTactic = addTactic();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Tactic.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("tacticId"));

		Object newTacticId = newTactic.getTacticId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("tacticId",
				new Object[] { newTacticId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTacticId = result.get(0);

		Assert.assertEquals(existingTacticId, newTacticId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Tactic.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("tacticId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("tacticId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Tactic newTactic = addTactic();

		_persistence.clearCache();

		Tactic existingTactic = _persistence.findByPrimaryKey(newTactic.getPrimaryKey());

		Assert.assertTrue(Validator.equals(existingTactic.getUuid(),
				ReflectionTestUtil.invoke(existingTactic, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingTactic.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingTactic,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Tactic addTactic() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Tactic tactic = _persistence.create(pk);

		tactic.setUuid(RandomTestUtil.randomString());

		tactic.setGroupId(RandomTestUtil.nextLong());

		tactic.setCompanyId(RandomTestUtil.nextLong());

		tactic.setUserId(RandomTestUtil.nextLong());

		tactic.setUserName(RandomTestUtil.randomString());

		tactic.setCreateDate(RandomTestUtil.nextDate());

		tactic.setModifiedDate(RandomTestUtil.nextDate());

		tactic.setCampaignId(RandomTestUtil.nextLong());

		tactic.setName(RandomTestUtil.randomString());

		tactic.setDescription(RandomTestUtil.randomString());

		_tactics.add(_persistence.update(tactic));

		return tactic;
	}

	private List<Tactic> _tactics = new ArrayList<Tactic>();
	private TacticPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}