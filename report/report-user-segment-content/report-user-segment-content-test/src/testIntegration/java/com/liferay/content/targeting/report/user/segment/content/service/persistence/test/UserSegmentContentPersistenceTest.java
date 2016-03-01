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

package com.liferay.content.targeting.report.user.segment.content.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.content.targeting.report.user.segment.content.exception.NoSuchUserSegmentContentException;
import com.liferay.content.targeting.report.user.segment.content.model.UserSegmentContent;
import com.liferay.content.targeting.report.user.segment.content.service.UserSegmentContentLocalServiceUtil;
import com.liferay.content.targeting.report.user.segment.content.service.persistence.UserSegmentContentPersistence;
import com.liferay.content.targeting.report.user.segment.content.service.persistence.UserSegmentContentUtil;

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
public class UserSegmentContentPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = UserSegmentContentUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<UserSegmentContent> iterator = _userSegmentContents.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserSegmentContent userSegmentContent = _persistence.create(pk);

		Assert.assertNotNull(userSegmentContent);

		Assert.assertEquals(userSegmentContent.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		UserSegmentContent newUserSegmentContent = addUserSegmentContent();

		_persistence.remove(newUserSegmentContent);

		UserSegmentContent existingUserSegmentContent = _persistence.fetchByPrimaryKey(newUserSegmentContent.getPrimaryKey());

		Assert.assertNull(existingUserSegmentContent);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addUserSegmentContent();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserSegmentContent newUserSegmentContent = _persistence.create(pk);

		newUserSegmentContent.setCompanyId(RandomTestUtil.nextLong());

		newUserSegmentContent.setUserSegmentId(RandomTestUtil.nextLong());

		newUserSegmentContent.setClassName(RandomTestUtil.randomString());

		newUserSegmentContent.setClassPK(RandomTestUtil.nextLong());

		newUserSegmentContent.setEventType(RandomTestUtil.randomString());

		newUserSegmentContent.setCount(RandomTestUtil.nextInt());

		newUserSegmentContent.setModifiedDate(RandomTestUtil.nextDate());

		_userSegmentContents.add(_persistence.update(newUserSegmentContent));

		UserSegmentContent existingUserSegmentContent = _persistence.findByPrimaryKey(newUserSegmentContent.getPrimaryKey());

		Assert.assertEquals(existingUserSegmentContent.getUserSegmentContentId(),
			newUserSegmentContent.getUserSegmentContentId());
		Assert.assertEquals(existingUserSegmentContent.getCompanyId(),
			newUserSegmentContent.getCompanyId());
		Assert.assertEquals(existingUserSegmentContent.getUserSegmentId(),
			newUserSegmentContent.getUserSegmentId());
		Assert.assertEquals(existingUserSegmentContent.getClassName(),
			newUserSegmentContent.getClassName());
		Assert.assertEquals(existingUserSegmentContent.getClassPK(),
			newUserSegmentContent.getClassPK());
		Assert.assertEquals(existingUserSegmentContent.getEventType(),
			newUserSegmentContent.getEventType());
		Assert.assertEquals(existingUserSegmentContent.getCount(),
			newUserSegmentContent.getCount());
		Assert.assertEquals(Time.getShortTimestamp(
				existingUserSegmentContent.getModifiedDate()),
			Time.getShortTimestamp(newUserSegmentContent.getModifiedDate()));
	}

	@Test
	public void testCountByUserSegmentId() throws Exception {
		_persistence.countByUserSegmentId(RandomTestUtil.nextLong());

		_persistence.countByUserSegmentId(0L);
	}

	@Test
	public void testCountByC_GtD() throws Exception {
		_persistence.countByC_GtD(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countByC_GtD(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByC_C_C_E() throws Exception {
		_persistence.countByC_C_C_E(RandomTestUtil.nextLong(),
			StringPool.BLANK, RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByC_C_C_E(0L, StringPool.NULL, 0L, StringPool.NULL);

		_persistence.countByC_C_C_E(0L, (String)null, 0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		UserSegmentContent newUserSegmentContent = addUserSegmentContent();

		UserSegmentContent existingUserSegmentContent = _persistence.findByPrimaryKey(newUserSegmentContent.getPrimaryKey());

		Assert.assertEquals(existingUserSegmentContent, newUserSegmentContent);
	}

	@Test(expected = NoSuchUserSegmentContentException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<UserSegmentContent> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_USCR_UserSegmentContent",
			"userSegmentContentId", true, "companyId", true, "userSegmentId",
			true, "className", true, "classPK", true, "eventType", true,
			"count", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserSegmentContent newUserSegmentContent = addUserSegmentContent();

		UserSegmentContent existingUserSegmentContent = _persistence.fetchByPrimaryKey(newUserSegmentContent.getPrimaryKey());

		Assert.assertEquals(existingUserSegmentContent, newUserSegmentContent);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserSegmentContent missingUserSegmentContent = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingUserSegmentContent);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		UserSegmentContent newUserSegmentContent1 = addUserSegmentContent();
		UserSegmentContent newUserSegmentContent2 = addUserSegmentContent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserSegmentContent1.getPrimaryKey());
		primaryKeys.add(newUserSegmentContent2.getPrimaryKey());

		Map<Serializable, UserSegmentContent> userSegmentContents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, userSegmentContents.size());
		Assert.assertEquals(newUserSegmentContent1,
			userSegmentContents.get(newUserSegmentContent1.getPrimaryKey()));
		Assert.assertEquals(newUserSegmentContent2,
			userSegmentContents.get(newUserSegmentContent2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, UserSegmentContent> userSegmentContents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userSegmentContents.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		UserSegmentContent newUserSegmentContent = addUserSegmentContent();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserSegmentContent.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, UserSegmentContent> userSegmentContents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userSegmentContents.size());
		Assert.assertEquals(newUserSegmentContent,
			userSegmentContents.get(newUserSegmentContent.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, UserSegmentContent> userSegmentContents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userSegmentContents.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		UserSegmentContent newUserSegmentContent = addUserSegmentContent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserSegmentContent.getPrimaryKey());

		Map<Serializable, UserSegmentContent> userSegmentContents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userSegmentContents.size());
		Assert.assertEquals(newUserSegmentContent,
			userSegmentContents.get(newUserSegmentContent.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = UserSegmentContentLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<UserSegmentContent>() {
				@Override
				public void performAction(UserSegmentContent userSegmentContent) {
					Assert.assertNotNull(userSegmentContent);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		UserSegmentContent newUserSegmentContent = addUserSegmentContent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserSegmentContent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userSegmentContentId",
				newUserSegmentContent.getUserSegmentContentId()));

		List<UserSegmentContent> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		UserSegmentContent existingUserSegmentContent = result.get(0);

		Assert.assertEquals(existingUserSegmentContent, newUserSegmentContent);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserSegmentContent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("userSegmentContentId",
				RandomTestUtil.nextLong()));

		List<UserSegmentContent> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		UserSegmentContent newUserSegmentContent = addUserSegmentContent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserSegmentContent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"userSegmentContentId"));

		Object newUserSegmentContentId = newUserSegmentContent.getUserSegmentContentId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("userSegmentContentId",
				new Object[] { newUserSegmentContentId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingUserSegmentContentId = result.get(0);

		Assert.assertEquals(existingUserSegmentContentId,
			newUserSegmentContentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserSegmentContent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"userSegmentContentId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("userSegmentContentId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		UserSegmentContent newUserSegmentContent = addUserSegmentContent();

		_persistence.clearCache();

		UserSegmentContent existingUserSegmentContent = _persistence.findByPrimaryKey(newUserSegmentContent.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(
				existingUserSegmentContent.getUserSegmentId()),
			ReflectionTestUtil.<Long>invoke(existingUserSegmentContent,
				"getOriginalUserSegmentId", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(
				existingUserSegmentContent.getClassName(),
				ReflectionTestUtil.invoke(existingUserSegmentContent,
					"getOriginalClassName", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(
				existingUserSegmentContent.getClassPK()),
			ReflectionTestUtil.<Long>invoke(existingUserSegmentContent,
				"getOriginalClassPK", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(
				existingUserSegmentContent.getEventType(),
				ReflectionTestUtil.invoke(existingUserSegmentContent,
					"getOriginalEventType", new Class<?>[0])));
	}

	protected UserSegmentContent addUserSegmentContent()
		throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserSegmentContent userSegmentContent = _persistence.create(pk);

		userSegmentContent.setCompanyId(RandomTestUtil.nextLong());

		userSegmentContent.setUserSegmentId(RandomTestUtil.nextLong());

		userSegmentContent.setClassName(RandomTestUtil.randomString());

		userSegmentContent.setClassPK(RandomTestUtil.nextLong());

		userSegmentContent.setEventType(RandomTestUtil.randomString());

		userSegmentContent.setCount(RandomTestUtil.nextInt());

		userSegmentContent.setModifiedDate(RandomTestUtil.nextDate());

		_userSegmentContents.add(_persistence.update(userSegmentContent));

		return userSegmentContent;
	}

	private List<UserSegmentContent> _userSegmentContents = new ArrayList<UserSegmentContent>();
	private UserSegmentContentPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}