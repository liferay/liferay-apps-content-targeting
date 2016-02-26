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

package com.liferay.content.targeting.analytics.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsReferrerException;
import com.liferay.content.targeting.analytics.model.AnalyticsReferrer;
import com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalServiceUtil;
import com.liferay.content.targeting.analytics.service.persistence.AnalyticsReferrerPersistence;
import com.liferay.content.targeting.analytics.service.persistence.AnalyticsReferrerUtil;

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
public class AnalyticsReferrerPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = AnalyticsReferrerUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnalyticsReferrer> iterator = _analyticsReferrers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalyticsReferrer analyticsReferrer = _persistence.create(pk);

		Assert.assertNotNull(analyticsReferrer);

		Assert.assertEquals(analyticsReferrer.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnalyticsReferrer newAnalyticsReferrer = addAnalyticsReferrer();

		_persistence.remove(newAnalyticsReferrer);

		AnalyticsReferrer existingAnalyticsReferrer = _persistence.fetchByPrimaryKey(newAnalyticsReferrer.getPrimaryKey());

		Assert.assertNull(existingAnalyticsReferrer);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnalyticsReferrer();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalyticsReferrer newAnalyticsReferrer = _persistence.create(pk);

		newAnalyticsReferrer.setAnalyticsEventId(RandomTestUtil.nextLong());

		newAnalyticsReferrer.setReferrerClassName(RandomTestUtil.randomString());

		newAnalyticsReferrer.setReferrerClassPK(RandomTestUtil.nextLong());

		_analyticsReferrers.add(_persistence.update(newAnalyticsReferrer));

		AnalyticsReferrer existingAnalyticsReferrer = _persistence.findByPrimaryKey(newAnalyticsReferrer.getPrimaryKey());

		Assert.assertEquals(existingAnalyticsReferrer.getAnalyticsReferrerId(),
			newAnalyticsReferrer.getAnalyticsReferrerId());
		Assert.assertEquals(existingAnalyticsReferrer.getAnalyticsEventId(),
			newAnalyticsReferrer.getAnalyticsEventId());
		Assert.assertEquals(existingAnalyticsReferrer.getReferrerClassName(),
			newAnalyticsReferrer.getReferrerClassName());
		Assert.assertEquals(existingAnalyticsReferrer.getReferrerClassPK(),
			newAnalyticsReferrer.getReferrerClassPK());
	}

	@Test
	public void testCountByAnalyticsEventId() throws Exception {
		_persistence.countByAnalyticsEventId(RandomTestUtil.nextLong());

		_persistence.countByAnalyticsEventId(0L);
	}

	@Test
	public void testCountByR_R() throws Exception {
		_persistence.countByR_R(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByR_R(StringPool.NULL, 0L);

		_persistence.countByR_R((String)null, 0L);
	}

	@Test
	public void testCountByA_R_R() throws Exception {
		_persistence.countByA_R_R(RandomTestUtil.nextLong(), StringPool.BLANK,
			RandomTestUtil.nextLong());

		_persistence.countByA_R_R(0L, StringPool.NULL, 0L);

		_persistence.countByA_R_R(0L, (String)null, 0L);
	}

	@Test
	public void testCountByA_R_RArrayable() throws Exception {
		_persistence.countByA_R_R(new long[] { RandomTestUtil.nextLong(), 0L },
			RandomTestUtil.randomString(), RandomTestUtil.nextLong());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnalyticsReferrer newAnalyticsReferrer = addAnalyticsReferrer();

		AnalyticsReferrer existingAnalyticsReferrer = _persistence.findByPrimaryKey(newAnalyticsReferrer.getPrimaryKey());

		Assert.assertEquals(existingAnalyticsReferrer, newAnalyticsReferrer);
	}

	@Test(expected = NoSuchAnalyticsReferrerException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<AnalyticsReferrer> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_Analytics_AnalyticsReferrer",
			"analyticsReferrerId", true, "analyticsEventId", true,
			"referrerClassName", true, "referrerClassPK", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnalyticsReferrer newAnalyticsReferrer = addAnalyticsReferrer();

		AnalyticsReferrer existingAnalyticsReferrer = _persistence.fetchByPrimaryKey(newAnalyticsReferrer.getPrimaryKey());

		Assert.assertEquals(existingAnalyticsReferrer, newAnalyticsReferrer);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalyticsReferrer missingAnalyticsReferrer = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnalyticsReferrer);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		AnalyticsReferrer newAnalyticsReferrer1 = addAnalyticsReferrer();
		AnalyticsReferrer newAnalyticsReferrer2 = addAnalyticsReferrer();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalyticsReferrer1.getPrimaryKey());
		primaryKeys.add(newAnalyticsReferrer2.getPrimaryKey());

		Map<Serializable, AnalyticsReferrer> analyticsReferrers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, analyticsReferrers.size());
		Assert.assertEquals(newAnalyticsReferrer1,
			analyticsReferrers.get(newAnalyticsReferrer1.getPrimaryKey()));
		Assert.assertEquals(newAnalyticsReferrer2,
			analyticsReferrers.get(newAnalyticsReferrer2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnalyticsReferrer> analyticsReferrers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(analyticsReferrers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		AnalyticsReferrer newAnalyticsReferrer = addAnalyticsReferrer();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalyticsReferrer.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnalyticsReferrer> analyticsReferrers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, analyticsReferrers.size());
		Assert.assertEquals(newAnalyticsReferrer,
			analyticsReferrers.get(newAnalyticsReferrer.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnalyticsReferrer> analyticsReferrers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(analyticsReferrers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		AnalyticsReferrer newAnalyticsReferrer = addAnalyticsReferrer();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalyticsReferrer.getPrimaryKey());

		Map<Serializable, AnalyticsReferrer> analyticsReferrers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, analyticsReferrers.size());
		Assert.assertEquals(newAnalyticsReferrer,
			analyticsReferrers.get(newAnalyticsReferrer.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = AnalyticsReferrerLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<AnalyticsReferrer>() {
				@Override
				public void performAction(AnalyticsReferrer analyticsReferrer) {
					Assert.assertNotNull(analyticsReferrer);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AnalyticsReferrer newAnalyticsReferrer = addAnalyticsReferrer();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalyticsReferrer.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("analyticsReferrerId",
				newAnalyticsReferrer.getAnalyticsReferrerId()));

		List<AnalyticsReferrer> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnalyticsReferrer existingAnalyticsReferrer = result.get(0);

		Assert.assertEquals(existingAnalyticsReferrer, newAnalyticsReferrer);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalyticsReferrer.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("analyticsReferrerId",
				RandomTestUtil.nextLong()));

		List<AnalyticsReferrer> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		AnalyticsReferrer newAnalyticsReferrer = addAnalyticsReferrer();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalyticsReferrer.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"analyticsReferrerId"));

		Object newAnalyticsReferrerId = newAnalyticsReferrer.getAnalyticsReferrerId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("analyticsReferrerId",
				new Object[] { newAnalyticsReferrerId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAnalyticsReferrerId = result.get(0);

		Assert.assertEquals(existingAnalyticsReferrerId, newAnalyticsReferrerId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalyticsReferrer.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"analyticsReferrerId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("analyticsReferrerId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnalyticsReferrer addAnalyticsReferrer()
		throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalyticsReferrer analyticsReferrer = _persistence.create(pk);

		analyticsReferrer.setAnalyticsEventId(RandomTestUtil.nextLong());

		analyticsReferrer.setReferrerClassName(RandomTestUtil.randomString());

		analyticsReferrer.setReferrerClassPK(RandomTestUtil.nextLong());

		_analyticsReferrers.add(_persistence.update(analyticsReferrer));

		return analyticsReferrer;
	}

	private List<AnalyticsReferrer> _analyticsReferrers = new ArrayList<AnalyticsReferrer>();
	private AnalyticsReferrerPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}