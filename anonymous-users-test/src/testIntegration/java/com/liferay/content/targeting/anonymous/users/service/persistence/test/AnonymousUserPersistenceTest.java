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

package com.liferay.content.targeting.anonymous.users.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.content.targeting.anonymous.users.exception.NoSuchAnonymousUserException;
import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalServiceUtil;
import com.liferay.content.targeting.anonymous.users.service.persistence.AnonymousUserPersistence;
import com.liferay.content.targeting.anonymous.users.service.persistence.AnonymousUserUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
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
public class AnonymousUserPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = AnonymousUserUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnonymousUser> iterator = _anonymousUsers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnonymousUser anonymousUser = _persistence.create(pk);

		Assert.assertNotNull(anonymousUser);

		Assert.assertEquals(anonymousUser.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnonymousUser newAnonymousUser = addAnonymousUser();

		_persistence.remove(newAnonymousUser);

		AnonymousUser existingAnonymousUser = _persistence.fetchByPrimaryKey(newAnonymousUser.getPrimaryKey());

		Assert.assertNull(existingAnonymousUser);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnonymousUser();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnonymousUser newAnonymousUser = _persistence.create(pk);

		newAnonymousUser.setUuid(RandomTestUtil.randomString());

		newAnonymousUser.setCompanyId(RandomTestUtil.nextLong());

		newAnonymousUser.setUserId(RandomTestUtil.nextLong());

		newAnonymousUser.setUserName(RandomTestUtil.randomString());

		newAnonymousUser.setCreateDate(RandomTestUtil.nextDate());

		newAnonymousUser.setModifiedDate(RandomTestUtil.nextDate());

		newAnonymousUser.setLastIp(RandomTestUtil.randomString());

		newAnonymousUser.setTypeSettings(RandomTestUtil.randomString());

		_anonymousUsers.add(_persistence.update(newAnonymousUser));

		AnonymousUser existingAnonymousUser = _persistence.findByPrimaryKey(newAnonymousUser.getPrimaryKey());

		Assert.assertEquals(existingAnonymousUser.getUuid(),
			newAnonymousUser.getUuid());
		Assert.assertEquals(existingAnonymousUser.getAnonymousUserId(),
			newAnonymousUser.getAnonymousUserId());
		Assert.assertEquals(existingAnonymousUser.getCompanyId(),
			newAnonymousUser.getCompanyId());
		Assert.assertEquals(existingAnonymousUser.getUserId(),
			newAnonymousUser.getUserId());
		Assert.assertEquals(existingAnonymousUser.getUserName(),
			newAnonymousUser.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingAnonymousUser.getCreateDate()),
			Time.getShortTimestamp(newAnonymousUser.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingAnonymousUser.getModifiedDate()),
			Time.getShortTimestamp(newAnonymousUser.getModifiedDate()));
		Assert.assertEquals(existingAnonymousUser.getLastIp(),
			newAnonymousUser.getLastIp());
		Assert.assertEquals(existingAnonymousUser.getTypeSettings(),
			newAnonymousUser.getTypeSettings());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByUserId() throws Exception {
		_persistence.countByUserId(RandomTestUtil.nextLong());

		_persistence.countByUserId(0L);
	}

	@Test
	public void testCountByC_LtD() throws Exception {
		_persistence.countByC_LtD(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countByC_LtD(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnonymousUser newAnonymousUser = addAnonymousUser();

		AnonymousUser existingAnonymousUser = _persistence.findByPrimaryKey(newAnonymousUser.getPrimaryKey());

		Assert.assertEquals(existingAnonymousUser, newAnonymousUser);
	}

	@Test(expected = NoSuchAnonymousUserException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<AnonymousUser> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_AU_AnonymousUser",
			"uuid", true, "anonymousUserId", true, "companyId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true,
			"lastIp", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnonymousUser newAnonymousUser = addAnonymousUser();

		AnonymousUser existingAnonymousUser = _persistence.fetchByPrimaryKey(newAnonymousUser.getPrimaryKey());

		Assert.assertEquals(existingAnonymousUser, newAnonymousUser);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnonymousUser missingAnonymousUser = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnonymousUser);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		AnonymousUser newAnonymousUser1 = addAnonymousUser();
		AnonymousUser newAnonymousUser2 = addAnonymousUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnonymousUser1.getPrimaryKey());
		primaryKeys.add(newAnonymousUser2.getPrimaryKey());

		Map<Serializable, AnonymousUser> anonymousUsers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anonymousUsers.size());
		Assert.assertEquals(newAnonymousUser1,
			anonymousUsers.get(newAnonymousUser1.getPrimaryKey()));
		Assert.assertEquals(newAnonymousUser2,
			anonymousUsers.get(newAnonymousUser2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnonymousUser> anonymousUsers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anonymousUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		AnonymousUser newAnonymousUser = addAnonymousUser();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnonymousUser.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnonymousUser> anonymousUsers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anonymousUsers.size());
		Assert.assertEquals(newAnonymousUser,
			anonymousUsers.get(newAnonymousUser.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnonymousUser> anonymousUsers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anonymousUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		AnonymousUser newAnonymousUser = addAnonymousUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnonymousUser.getPrimaryKey());

		Map<Serializable, AnonymousUser> anonymousUsers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anonymousUsers.size());
		Assert.assertEquals(newAnonymousUser,
			anonymousUsers.get(newAnonymousUser.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = AnonymousUserLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<AnonymousUser>() {
				@Override
				public void performAction(AnonymousUser anonymousUser) {
					Assert.assertNotNull(anonymousUser);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AnonymousUser newAnonymousUser = addAnonymousUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnonymousUser.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("anonymousUserId",
				newAnonymousUser.getAnonymousUserId()));

		List<AnonymousUser> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnonymousUser existingAnonymousUser = result.get(0);

		Assert.assertEquals(existingAnonymousUser, newAnonymousUser);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnonymousUser.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("anonymousUserId",
				RandomTestUtil.nextLong()));

		List<AnonymousUser> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		AnonymousUser newAnonymousUser = addAnonymousUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnonymousUser.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"anonymousUserId"));

		Object newAnonymousUserId = newAnonymousUser.getAnonymousUserId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("anonymousUserId",
				new Object[] { newAnonymousUserId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAnonymousUserId = result.get(0);

		Assert.assertEquals(existingAnonymousUserId, newAnonymousUserId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnonymousUser.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"anonymousUserId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("anonymousUserId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnonymousUser addAnonymousUser() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnonymousUser anonymousUser = _persistence.create(pk);

		anonymousUser.setUuid(RandomTestUtil.randomString());

		anonymousUser.setCompanyId(RandomTestUtil.nextLong());

		anonymousUser.setUserId(RandomTestUtil.nextLong());

		anonymousUser.setUserName(RandomTestUtil.randomString());

		anonymousUser.setCreateDate(RandomTestUtil.nextDate());

		anonymousUser.setModifiedDate(RandomTestUtil.nextDate());

		anonymousUser.setLastIp(RandomTestUtil.randomString());

		anonymousUser.setTypeSettings(RandomTestUtil.randomString());

		_anonymousUsers.add(_persistence.update(anonymousUser));

		return anonymousUser;
	}

	private List<AnonymousUser> _anonymousUsers = new ArrayList<AnonymousUser>();
	private AnonymousUserPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}