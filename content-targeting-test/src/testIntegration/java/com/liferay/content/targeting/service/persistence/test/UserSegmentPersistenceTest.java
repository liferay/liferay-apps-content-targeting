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

import com.liferay.content.targeting.exception.NoSuchUserSegmentException;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.content.targeting.service.persistence.UserSegmentPersistence;
import com.liferay.content.targeting.service.persistence.UserSegmentUtil;

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
public class UserSegmentPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = UserSegmentUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<UserSegment> iterator = _userSegments.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserSegment userSegment = _persistence.create(pk);

		Assert.assertNotNull(userSegment);

		Assert.assertEquals(userSegment.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		UserSegment newUserSegment = addUserSegment();

		_persistence.remove(newUserSegment);

		UserSegment existingUserSegment = _persistence.fetchByPrimaryKey(newUserSegment.getPrimaryKey());

		Assert.assertNull(existingUserSegment);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addUserSegment();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserSegment newUserSegment = _persistence.create(pk);

		newUserSegment.setUuid(RandomTestUtil.randomString());

		newUserSegment.setGroupId(RandomTestUtil.nextLong());

		newUserSegment.setAssetCategoryId(RandomTestUtil.nextLong());

		newUserSegment.setCompanyId(RandomTestUtil.nextLong());

		newUserSegment.setUserId(RandomTestUtil.nextLong());

		newUserSegment.setUserName(RandomTestUtil.randomString());

		newUserSegment.setCreateDate(RandomTestUtil.nextDate());

		newUserSegment.setModifiedDate(RandomTestUtil.nextDate());

		newUserSegment.setName(RandomTestUtil.randomString());

		newUserSegment.setDescription(RandomTestUtil.randomString());

		_userSegments.add(_persistence.update(newUserSegment));

		UserSegment existingUserSegment = _persistence.findByPrimaryKey(newUserSegment.getPrimaryKey());

		Assert.assertEquals(existingUserSegment.getUuid(),
			newUserSegment.getUuid());
		Assert.assertEquals(existingUserSegment.getUserSegmentId(),
			newUserSegment.getUserSegmentId());
		Assert.assertEquals(existingUserSegment.getGroupId(),
			newUserSegment.getGroupId());
		Assert.assertEquals(existingUserSegment.getAssetCategoryId(),
			newUserSegment.getAssetCategoryId());
		Assert.assertEquals(existingUserSegment.getCompanyId(),
			newUserSegment.getCompanyId());
		Assert.assertEquals(existingUserSegment.getUserId(),
			newUserSegment.getUserId());
		Assert.assertEquals(existingUserSegment.getUserName(),
			newUserSegment.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingUserSegment.getCreateDate()),
			Time.getShortTimestamp(newUserSegment.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingUserSegment.getModifiedDate()),
			Time.getShortTimestamp(newUserSegment.getModifiedDate()));
		Assert.assertEquals(existingUserSegment.getName(),
			newUserSegment.getName());
		Assert.assertEquals(existingUserSegment.getDescription(),
			newUserSegment.getDescription());
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
	public void testCountByGroupIdArrayable() throws Exception {
		_persistence.countByGroupId(new long[] { RandomTestUtil.nextLong(), 0L });
	}

	@Test
	public void testCountByAssetCategoryId() throws Exception {
		_persistence.countByAssetCategoryId(RandomTestUtil.nextLong());

		_persistence.countByAssetCategoryId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		UserSegment newUserSegment = addUserSegment();

		UserSegment existingUserSegment = _persistence.findByPrimaryKey(newUserSegment.getPrimaryKey());

		Assert.assertEquals(existingUserSegment, newUserSegment);
	}

	@Test(expected = NoSuchUserSegmentException.class)
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

	protected OrderByComparator<UserSegment> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_UserSegment", "uuid",
			true, "userSegmentId", true, "groupId", true, "assetCategoryId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "name", true,
			"description", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserSegment newUserSegment = addUserSegment();

		UserSegment existingUserSegment = _persistence.fetchByPrimaryKey(newUserSegment.getPrimaryKey());

		Assert.assertEquals(existingUserSegment, newUserSegment);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserSegment missingUserSegment = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingUserSegment);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		UserSegment newUserSegment1 = addUserSegment();
		UserSegment newUserSegment2 = addUserSegment();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserSegment1.getPrimaryKey());
		primaryKeys.add(newUserSegment2.getPrimaryKey());

		Map<Serializable, UserSegment> userSegments = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, userSegments.size());
		Assert.assertEquals(newUserSegment1,
			userSegments.get(newUserSegment1.getPrimaryKey()));
		Assert.assertEquals(newUserSegment2,
			userSegments.get(newUserSegment2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, UserSegment> userSegments = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userSegments.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		UserSegment newUserSegment = addUserSegment();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserSegment.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, UserSegment> userSegments = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userSegments.size());
		Assert.assertEquals(newUserSegment,
			userSegments.get(newUserSegment.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, UserSegment> userSegments = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userSegments.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		UserSegment newUserSegment = addUserSegment();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserSegment.getPrimaryKey());

		Map<Serializable, UserSegment> userSegments = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userSegments.size());
		Assert.assertEquals(newUserSegment,
			userSegments.get(newUserSegment.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = UserSegmentLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<UserSegment>() {
				@Override
				public void performAction(UserSegment userSegment) {
					Assert.assertNotNull(userSegment);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		UserSegment newUserSegment = addUserSegment();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserSegment.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userSegmentId",
				newUserSegment.getUserSegmentId()));

		List<UserSegment> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		UserSegment existingUserSegment = result.get(0);

		Assert.assertEquals(existingUserSegment, newUserSegment);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserSegment.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userSegmentId",
				RandomTestUtil.nextLong()));

		List<UserSegment> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		UserSegment newUserSegment = addUserSegment();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserSegment.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"userSegmentId"));

		Object newUserSegmentId = newUserSegment.getUserSegmentId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("userSegmentId",
				new Object[] { newUserSegmentId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingUserSegmentId = result.get(0);

		Assert.assertEquals(existingUserSegmentId, newUserSegmentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserSegment.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"userSegmentId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("userSegmentId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		UserSegment newUserSegment = addUserSegment();

		_persistence.clearCache();

		UserSegment existingUserSegment = _persistence.findByPrimaryKey(newUserSegment.getPrimaryKey());

		Assert.assertTrue(Validator.equals(existingUserSegment.getUuid(),
				ReflectionTestUtil.invoke(existingUserSegment,
					"getOriginalUuid", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingUserSegment.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingUserSegment,
				"getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(Long.valueOf(
				existingUserSegment.getAssetCategoryId()),
			ReflectionTestUtil.<Long>invoke(existingUserSegment,
				"getOriginalAssetCategoryId", new Class<?>[0]));
	}

	protected UserSegment addUserSegment() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserSegment userSegment = _persistence.create(pk);

		userSegment.setUuid(RandomTestUtil.randomString());

		userSegment.setGroupId(RandomTestUtil.nextLong());

		userSegment.setAssetCategoryId(RandomTestUtil.nextLong());

		userSegment.setCompanyId(RandomTestUtil.nextLong());

		userSegment.setUserId(RandomTestUtil.nextLong());

		userSegment.setUserName(RandomTestUtil.randomString());

		userSegment.setCreateDate(RandomTestUtil.nextDate());

		userSegment.setModifiedDate(RandomTestUtil.nextDate());

		userSegment.setName(RandomTestUtil.randomString());

		userSegment.setDescription(RandomTestUtil.randomString());

		_userSegments.add(_persistence.update(userSegment));

		return userSegment;
	}

	private List<UserSegment> _userSegments = new ArrayList<UserSegment>();
	private UserSegmentPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}