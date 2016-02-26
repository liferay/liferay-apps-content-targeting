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

import com.liferay.content.targeting.exception.NoSuchChannelInstanceException;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.service.ChannelInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.persistence.ChannelInstancePersistence;
import com.liferay.content.targeting.service.persistence.ChannelInstanceUtil;

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
public class ChannelInstancePersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = ChannelInstanceUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ChannelInstance> iterator = _channelInstances.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChannelInstance channelInstance = _persistence.create(pk);

		Assert.assertNotNull(channelInstance);

		Assert.assertEquals(channelInstance.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ChannelInstance newChannelInstance = addChannelInstance();

		_persistence.remove(newChannelInstance);

		ChannelInstance existingChannelInstance = _persistence.fetchByPrimaryKey(newChannelInstance.getPrimaryKey());

		Assert.assertNull(existingChannelInstance);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addChannelInstance();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChannelInstance newChannelInstance = _persistence.create(pk);

		newChannelInstance.setUuid(RandomTestUtil.randomString());

		newChannelInstance.setGroupId(RandomTestUtil.nextLong());

		newChannelInstance.setCompanyId(RandomTestUtil.nextLong());

		newChannelInstance.setUserId(RandomTestUtil.nextLong());

		newChannelInstance.setUserName(RandomTestUtil.randomString());

		newChannelInstance.setCreateDate(RandomTestUtil.nextDate());

		newChannelInstance.setModifiedDate(RandomTestUtil.nextDate());

		newChannelInstance.setChannelKey(RandomTestUtil.randomString());

		newChannelInstance.setCampaignId(RandomTestUtil.nextLong());

		newChannelInstance.setTacticId(RandomTestUtil.nextLong());

		newChannelInstance.setAlias(RandomTestUtil.randomString());

		newChannelInstance.setTypeSettings(RandomTestUtil.randomString());

		_channelInstances.add(_persistence.update(newChannelInstance));

		ChannelInstance existingChannelInstance = _persistence.findByPrimaryKey(newChannelInstance.getPrimaryKey());

		Assert.assertEquals(existingChannelInstance.getUuid(),
			newChannelInstance.getUuid());
		Assert.assertEquals(existingChannelInstance.getChannelInstanceId(),
			newChannelInstance.getChannelInstanceId());
		Assert.assertEquals(existingChannelInstance.getGroupId(),
			newChannelInstance.getGroupId());
		Assert.assertEquals(existingChannelInstance.getCompanyId(),
			newChannelInstance.getCompanyId());
		Assert.assertEquals(existingChannelInstance.getUserId(),
			newChannelInstance.getUserId());
		Assert.assertEquals(existingChannelInstance.getUserName(),
			newChannelInstance.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingChannelInstance.getCreateDate()),
			Time.getShortTimestamp(newChannelInstance.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingChannelInstance.getModifiedDate()),
			Time.getShortTimestamp(newChannelInstance.getModifiedDate()));
		Assert.assertEquals(existingChannelInstance.getChannelKey(),
			newChannelInstance.getChannelKey());
		Assert.assertEquals(existingChannelInstance.getCampaignId(),
			newChannelInstance.getCampaignId());
		Assert.assertEquals(existingChannelInstance.getTacticId(),
			newChannelInstance.getTacticId());
		Assert.assertEquals(existingChannelInstance.getAlias(),
			newChannelInstance.getAlias());
		Assert.assertEquals(existingChannelInstance.getTypeSettings(),
			newChannelInstance.getTypeSettings());
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
	public void testCountByChannelKey() throws Exception {
		_persistence.countByChannelKey(StringPool.BLANK);

		_persistence.countByChannelKey(StringPool.NULL);

		_persistence.countByChannelKey((String)null);
	}

	@Test
	public void testCountByCampaignId() throws Exception {
		_persistence.countByCampaignId(RandomTestUtil.nextLong());

		_persistence.countByCampaignId(0L);
	}

	@Test
	public void testCountByTacticId() throws Exception {
		_persistence.countByTacticId(RandomTestUtil.nextLong());

		_persistence.countByTacticId(0L);
	}

	@Test
	public void testCountByC_K() throws Exception {
		_persistence.countByC_K(RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByC_K(0L, StringPool.NULL);

		_persistence.countByC_K(0L, (String)null);
	}

	@Test
	public void testCountByT_K() throws Exception {
		_persistence.countByT_K(RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByT_K(0L, StringPool.NULL);

		_persistence.countByT_K(0L, (String)null);
	}

	@Test
	public void testCountByT_A() throws Exception {
		_persistence.countByT_A(RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByT_A(0L, StringPool.NULL);

		_persistence.countByT_A(0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ChannelInstance newChannelInstance = addChannelInstance();

		ChannelInstance existingChannelInstance = _persistence.findByPrimaryKey(newChannelInstance.getPrimaryKey());

		Assert.assertEquals(existingChannelInstance, newChannelInstance);
	}

	@Test(expected = NoSuchChannelInstanceException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<ChannelInstance> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_ChannelInstance",
			"uuid", true, "channelInstanceId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "channelKey", true, "campaignId", true,
			"tacticId", true, "alias", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ChannelInstance newChannelInstance = addChannelInstance();

		ChannelInstance existingChannelInstance = _persistence.fetchByPrimaryKey(newChannelInstance.getPrimaryKey());

		Assert.assertEquals(existingChannelInstance, newChannelInstance);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChannelInstance missingChannelInstance = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingChannelInstance);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		ChannelInstance newChannelInstance1 = addChannelInstance();
		ChannelInstance newChannelInstance2 = addChannelInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChannelInstance1.getPrimaryKey());
		primaryKeys.add(newChannelInstance2.getPrimaryKey());

		Map<Serializable, ChannelInstance> channelInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, channelInstances.size());
		Assert.assertEquals(newChannelInstance1,
			channelInstances.get(newChannelInstance1.getPrimaryKey()));
		Assert.assertEquals(newChannelInstance2,
			channelInstances.get(newChannelInstance2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ChannelInstance> channelInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(channelInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		ChannelInstance newChannelInstance = addChannelInstance();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChannelInstance.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ChannelInstance> channelInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, channelInstances.size());
		Assert.assertEquals(newChannelInstance,
			channelInstances.get(newChannelInstance.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ChannelInstance> channelInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(channelInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		ChannelInstance newChannelInstance = addChannelInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChannelInstance.getPrimaryKey());

		Map<Serializable, ChannelInstance> channelInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, channelInstances.size());
		Assert.assertEquals(newChannelInstance,
			channelInstances.get(newChannelInstance.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = ChannelInstanceLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<ChannelInstance>() {
				@Override
				public void performAction(ChannelInstance channelInstance) {
					Assert.assertNotNull(channelInstance);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ChannelInstance newChannelInstance = addChannelInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ChannelInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("channelInstanceId",
				newChannelInstance.getChannelInstanceId()));

		List<ChannelInstance> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		ChannelInstance existingChannelInstance = result.get(0);

		Assert.assertEquals(existingChannelInstance, newChannelInstance);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ChannelInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("channelInstanceId",
				RandomTestUtil.nextLong()));

		List<ChannelInstance> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		ChannelInstance newChannelInstance = addChannelInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ChannelInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"channelInstanceId"));

		Object newChannelInstanceId = newChannelInstance.getChannelInstanceId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("channelInstanceId",
				new Object[] { newChannelInstanceId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingChannelInstanceId = result.get(0);

		Assert.assertEquals(existingChannelInstanceId, newChannelInstanceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ChannelInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"channelInstanceId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("channelInstanceId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		ChannelInstance newChannelInstance = addChannelInstance();

		_persistence.clearCache();

		ChannelInstance existingChannelInstance = _persistence.findByPrimaryKey(newChannelInstance.getPrimaryKey());

		Assert.assertTrue(Validator.equals(existingChannelInstance.getUuid(),
				ReflectionTestUtil.invoke(existingChannelInstance,
					"getOriginalUuid", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingChannelInstance.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingChannelInstance,
				"getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(Long.valueOf(existingChannelInstance.getTacticId()),
			ReflectionTestUtil.<Long>invoke(existingChannelInstance,
				"getOriginalTacticId", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(existingChannelInstance.getAlias(),
				ReflectionTestUtil.invoke(existingChannelInstance,
					"getOriginalAlias", new Class<?>[0])));
	}

	protected ChannelInstance addChannelInstance() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChannelInstance channelInstance = _persistence.create(pk);

		channelInstance.setUuid(RandomTestUtil.randomString());

		channelInstance.setGroupId(RandomTestUtil.nextLong());

		channelInstance.setCompanyId(RandomTestUtil.nextLong());

		channelInstance.setUserId(RandomTestUtil.nextLong());

		channelInstance.setUserName(RandomTestUtil.randomString());

		channelInstance.setCreateDate(RandomTestUtil.nextDate());

		channelInstance.setModifiedDate(RandomTestUtil.nextDate());

		channelInstance.setChannelKey(RandomTestUtil.randomString());

		channelInstance.setCampaignId(RandomTestUtil.nextLong());

		channelInstance.setTacticId(RandomTestUtil.nextLong());

		channelInstance.setAlias(RandomTestUtil.randomString());

		channelInstance.setTypeSettings(RandomTestUtil.randomString());

		_channelInstances.add(_persistence.update(channelInstance));

		return channelInstance;
	}

	private List<ChannelInstance> _channelInstances = new ArrayList<ChannelInstance>();
	private ChannelInstancePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}