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

import com.liferay.content.targeting.exception.NoSuchAnonymousUserUserSegmentException;
import com.liferay.content.targeting.model.AnonymousUserUserSegment;
import com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalServiceUtil;
import com.liferay.content.targeting.service.persistence.AnonymousUserUserSegmentPersistence;
import com.liferay.content.targeting.service.persistence.AnonymousUserUserSegmentUtil;

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
public class AnonymousUserUserSegmentPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = AnonymousUserUserSegmentUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnonymousUserUserSegment> iterator = _anonymousUserUserSegments.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnonymousUserUserSegment anonymousUserUserSegment = _persistence.create(pk);

		Assert.assertNotNull(anonymousUserUserSegment);

		Assert.assertEquals(anonymousUserUserSegment.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnonymousUserUserSegment newAnonymousUserUserSegment = addAnonymousUserUserSegment();

		_persistence.remove(newAnonymousUserUserSegment);

		AnonymousUserUserSegment existingAnonymousUserUserSegment = _persistence.fetchByPrimaryKey(newAnonymousUserUserSegment.getPrimaryKey());

		Assert.assertNull(existingAnonymousUserUserSegment);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnonymousUserUserSegment();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnonymousUserUserSegment newAnonymousUserUserSegment = _persistence.create(pk);

		newAnonymousUserUserSegment.setCompanyId(RandomTestUtil.nextLong());

		newAnonymousUserUserSegment.setModifiedDate(RandomTestUtil.nextDate());

		newAnonymousUserUserSegment.setAnonymousUserId(RandomTestUtil.nextLong());

		newAnonymousUserUserSegment.setUserSegmentId(RandomTestUtil.nextLong());

		newAnonymousUserUserSegment.setManual(RandomTestUtil.randomBoolean());

		newAnonymousUserUserSegment.setActive(RandomTestUtil.randomBoolean());

		_anonymousUserUserSegments.add(_persistence.update(
				newAnonymousUserUserSegment));

		AnonymousUserUserSegment existingAnonymousUserUserSegment = _persistence.findByPrimaryKey(newAnonymousUserUserSegment.getPrimaryKey());

		Assert.assertEquals(existingAnonymousUserUserSegment.getAnonymousUserUserSegmentId(),
			newAnonymousUserUserSegment.getAnonymousUserUserSegmentId());
		Assert.assertEquals(existingAnonymousUserUserSegment.getCompanyId(),
			newAnonymousUserUserSegment.getCompanyId());
		Assert.assertEquals(Time.getShortTimestamp(
				existingAnonymousUserUserSegment.getModifiedDate()),
			Time.getShortTimestamp(
				newAnonymousUserUserSegment.getModifiedDate()));
		Assert.assertEquals(existingAnonymousUserUserSegment.getAnonymousUserId(),
			newAnonymousUserUserSegment.getAnonymousUserId());
		Assert.assertEquals(existingAnonymousUserUserSegment.getUserSegmentId(),
			newAnonymousUserUserSegment.getUserSegmentId());
		Assert.assertEquals(existingAnonymousUserUserSegment.getManual(),
			newAnonymousUserUserSegment.getManual());
		Assert.assertEquals(existingAnonymousUserUserSegment.getActive(),
			newAnonymousUserUserSegment.getActive());
	}

	@Test
	public void testCountByA_U() throws Exception {
		_persistence.countByA_U(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByA_U(0L, 0L);
	}

	@Test
	public void testCountByAnonymousUserId() throws Exception {
		_persistence.countByAnonymousUserId(RandomTestUtil.nextLong(),
			RandomTestUtil.randomBoolean());

		_persistence.countByAnonymousUserId(0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByUserSegmentIds() throws Exception {
		_persistence.countByUserSegmentIds(RandomTestUtil.nextLong(),
			RandomTestUtil.randomBoolean());

		_persistence.countByUserSegmentIds(0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByUserSegmentIdsArrayable() throws Exception {
		_persistence.countByUserSegmentIds(new long[] {
				RandomTestUtil.nextLong(), 0L
			}, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByC_LtD_M() throws Exception {
		_persistence.countByC_LtD_M(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate(), RandomTestUtil.randomBoolean());

		_persistence.countByC_LtD_M(0L, RandomTestUtil.nextDate(),
			RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnonymousUserUserSegment newAnonymousUserUserSegment = addAnonymousUserUserSegment();

		AnonymousUserUserSegment existingAnonymousUserUserSegment = _persistence.findByPrimaryKey(newAnonymousUserUserSegment.getPrimaryKey());

		Assert.assertEquals(existingAnonymousUserUserSegment,
			newAnonymousUserUserSegment);
	}

	@Test(expected = NoSuchAnonymousUserUserSegmentException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<AnonymousUserUserSegment> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_AnonymousUserUserSegment",
			"anonymousUserUserSegmentId", true, "companyId", true,
			"modifiedDate", true, "anonymousUserId", true, "userSegmentId",
			true, "manual", true, "active", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnonymousUserUserSegment newAnonymousUserUserSegment = addAnonymousUserUserSegment();

		AnonymousUserUserSegment existingAnonymousUserUserSegment = _persistence.fetchByPrimaryKey(newAnonymousUserUserSegment.getPrimaryKey());

		Assert.assertEquals(existingAnonymousUserUserSegment,
			newAnonymousUserUserSegment);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnonymousUserUserSegment missingAnonymousUserUserSegment = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnonymousUserUserSegment);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		AnonymousUserUserSegment newAnonymousUserUserSegment1 = addAnonymousUserUserSegment();
		AnonymousUserUserSegment newAnonymousUserUserSegment2 = addAnonymousUserUserSegment();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnonymousUserUserSegment1.getPrimaryKey());
		primaryKeys.add(newAnonymousUserUserSegment2.getPrimaryKey());

		Map<Serializable, AnonymousUserUserSegment> anonymousUserUserSegments = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, anonymousUserUserSegments.size());
		Assert.assertEquals(newAnonymousUserUserSegment1,
			anonymousUserUserSegments.get(
				newAnonymousUserUserSegment1.getPrimaryKey()));
		Assert.assertEquals(newAnonymousUserUserSegment2,
			anonymousUserUserSegments.get(
				newAnonymousUserUserSegment2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnonymousUserUserSegment> anonymousUserUserSegments = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anonymousUserUserSegments.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		AnonymousUserUserSegment newAnonymousUserUserSegment = addAnonymousUserUserSegment();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnonymousUserUserSegment.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnonymousUserUserSegment> anonymousUserUserSegments = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anonymousUserUserSegments.size());
		Assert.assertEquals(newAnonymousUserUserSegment,
			anonymousUserUserSegments.get(
				newAnonymousUserUserSegment.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnonymousUserUserSegment> anonymousUserUserSegments = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(anonymousUserUserSegments.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		AnonymousUserUserSegment newAnonymousUserUserSegment = addAnonymousUserUserSegment();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnonymousUserUserSegment.getPrimaryKey());

		Map<Serializable, AnonymousUserUserSegment> anonymousUserUserSegments = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, anonymousUserUserSegments.size());
		Assert.assertEquals(newAnonymousUserUserSegment,
			anonymousUserUserSegments.get(
				newAnonymousUserUserSegment.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = AnonymousUserUserSegmentLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<AnonymousUserUserSegment>() {
				@Override
				public void performAction(
					AnonymousUserUserSegment anonymousUserUserSegment) {
					Assert.assertNotNull(anonymousUserUserSegment);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AnonymousUserUserSegment newAnonymousUserUserSegment = addAnonymousUserUserSegment();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnonymousUserUserSegment.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq(
				"anonymousUserUserSegmentId",
				newAnonymousUserUserSegment.getAnonymousUserUserSegmentId()));

		List<AnonymousUserUserSegment> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnonymousUserUserSegment existingAnonymousUserUserSegment = result.get(0);

		Assert.assertEquals(existingAnonymousUserUserSegment,
			newAnonymousUserUserSegment);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnonymousUserUserSegment.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq(
				"anonymousUserUserSegmentId", RandomTestUtil.nextLong()));

		List<AnonymousUserUserSegment> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		AnonymousUserUserSegment newAnonymousUserUserSegment = addAnonymousUserUserSegment();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnonymousUserUserSegment.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"anonymousUserUserSegmentId"));

		Object newAnonymousUserUserSegmentId = newAnonymousUserUserSegment.getAnonymousUserUserSegmentId();

		dynamicQuery.add(RestrictionsFactoryUtil.in(
				"anonymousUserUserSegmentId",
				new Object[] { newAnonymousUserUserSegmentId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAnonymousUserUserSegmentId = result.get(0);

		Assert.assertEquals(existingAnonymousUserUserSegmentId,
			newAnonymousUserUserSegmentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnonymousUserUserSegment.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"anonymousUserUserSegmentId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in(
				"anonymousUserUserSegmentId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnonymousUserUserSegment addAnonymousUserUserSegment()
		throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnonymousUserUserSegment anonymousUserUserSegment = _persistence.create(pk);

		anonymousUserUserSegment.setCompanyId(RandomTestUtil.nextLong());

		anonymousUserUserSegment.setModifiedDate(RandomTestUtil.nextDate());

		anonymousUserUserSegment.setAnonymousUserId(RandomTestUtil.nextLong());

		anonymousUserUserSegment.setUserSegmentId(RandomTestUtil.nextLong());

		anonymousUserUserSegment.setManual(RandomTestUtil.randomBoolean());

		anonymousUserUserSegment.setActive(RandomTestUtil.randomBoolean());

		_anonymousUserUserSegments.add(_persistence.update(
				anonymousUserUserSegment));

		return anonymousUserUserSegment;
	}

	private List<AnonymousUserUserSegment> _anonymousUserUserSegments = new ArrayList<AnonymousUserUserSegment>();
	private AnonymousUserUserSegmentPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}