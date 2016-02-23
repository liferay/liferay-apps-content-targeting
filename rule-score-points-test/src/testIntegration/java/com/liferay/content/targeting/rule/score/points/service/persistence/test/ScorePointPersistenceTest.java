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

package com.liferay.content.targeting.rule.score.points.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.content.targeting.rule.score.points.exception.NoSuchScorePointException;
import com.liferay.content.targeting.rule.score.points.model.ScorePoint;
import com.liferay.content.targeting.rule.score.points.service.ScorePointLocalServiceUtil;
import com.liferay.content.targeting.rule.score.points.service.persistence.ScorePointPersistence;
import com.liferay.content.targeting.rule.score.points.service.persistence.ScorePointUtil;

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
public class ScorePointPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = ScorePointUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ScorePoint> iterator = _scorePoints.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ScorePoint scorePoint = _persistence.create(pk);

		Assert.assertNotNull(scorePoint);

		Assert.assertEquals(scorePoint.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ScorePoint newScorePoint = addScorePoint();

		_persistence.remove(newScorePoint);

		ScorePoint existingScorePoint = _persistence.fetchByPrimaryKey(newScorePoint.getPrimaryKey());

		Assert.assertNull(existingScorePoint);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addScorePoint();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ScorePoint newScorePoint = _persistence.create(pk);

		newScorePoint.setUuid(RandomTestUtil.randomString());

		newScorePoint.setCompanyId(RandomTestUtil.nextLong());

		newScorePoint.setAnonymousUserId(RandomTestUtil.nextLong());

		newScorePoint.setUserSegmentId(RandomTestUtil.nextLong());

		newScorePoint.setPoints(RandomTestUtil.nextLong());

		_scorePoints.add(_persistence.update(newScorePoint));

		ScorePoint existingScorePoint = _persistence.findByPrimaryKey(newScorePoint.getPrimaryKey());

		Assert.assertEquals(existingScorePoint.getUuid(),
			newScorePoint.getUuid());
		Assert.assertEquals(existingScorePoint.getScorePointId(),
			newScorePoint.getScorePointId());
		Assert.assertEquals(existingScorePoint.getCompanyId(),
			newScorePoint.getCompanyId());
		Assert.assertEquals(existingScorePoint.getAnonymousUserId(),
			newScorePoint.getAnonymousUserId());
		Assert.assertEquals(existingScorePoint.getUserSegmentId(),
			newScorePoint.getUserSegmentId());
		Assert.assertEquals(existingScorePoint.getPoints(),
			newScorePoint.getPoints());
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
	public void testCountByUserSegmentId() throws Exception {
		_persistence.countByUserSegmentId(RandomTestUtil.nextLong());

		_persistence.countByUserSegmentId(0L);
	}

	@Test
	public void testCountByC_U() throws Exception {
		_persistence.countByC_U(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByC_U(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ScorePoint newScorePoint = addScorePoint();

		ScorePoint existingScorePoint = _persistence.findByPrimaryKey(newScorePoint.getPrimaryKey());

		Assert.assertEquals(existingScorePoint, newScorePoint);
	}

	@Test(expected = NoSuchScorePointException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<ScorePoint> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_ScorePoints_ScorePoint",
			"uuid", true, "scorePointId", true, "companyId", true,
			"anonymousUserId", true, "userSegmentId", true, "points", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ScorePoint newScorePoint = addScorePoint();

		ScorePoint existingScorePoint = _persistence.fetchByPrimaryKey(newScorePoint.getPrimaryKey());

		Assert.assertEquals(existingScorePoint, newScorePoint);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ScorePoint missingScorePoint = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingScorePoint);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		ScorePoint newScorePoint1 = addScorePoint();
		ScorePoint newScorePoint2 = addScorePoint();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newScorePoint1.getPrimaryKey());
		primaryKeys.add(newScorePoint2.getPrimaryKey());

		Map<Serializable, ScorePoint> scorePoints = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, scorePoints.size());
		Assert.assertEquals(newScorePoint1,
			scorePoints.get(newScorePoint1.getPrimaryKey()));
		Assert.assertEquals(newScorePoint2,
			scorePoints.get(newScorePoint2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ScorePoint> scorePoints = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(scorePoints.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		ScorePoint newScorePoint = addScorePoint();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newScorePoint.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ScorePoint> scorePoints = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, scorePoints.size());
		Assert.assertEquals(newScorePoint,
			scorePoints.get(newScorePoint.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ScorePoint> scorePoints = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(scorePoints.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		ScorePoint newScorePoint = addScorePoint();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newScorePoint.getPrimaryKey());

		Map<Serializable, ScorePoint> scorePoints = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, scorePoints.size());
		Assert.assertEquals(newScorePoint,
			scorePoints.get(newScorePoint.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = ScorePointLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<ScorePoint>() {
				@Override
				public void performAction(ScorePoint scorePoint) {
					Assert.assertNotNull(scorePoint);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ScorePoint newScorePoint = addScorePoint();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ScorePoint.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("scorePointId",
				newScorePoint.getScorePointId()));

		List<ScorePoint> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		ScorePoint existingScorePoint = result.get(0);

		Assert.assertEquals(existingScorePoint, newScorePoint);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ScorePoint.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("scorePointId",
				RandomTestUtil.nextLong()));

		List<ScorePoint> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		ScorePoint newScorePoint = addScorePoint();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ScorePoint.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"scorePointId"));

		Object newScorePointId = newScorePoint.getScorePointId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("scorePointId",
				new Object[] { newScorePointId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingScorePointId = result.get(0);

		Assert.assertEquals(existingScorePointId, newScorePointId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ScorePoint.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"scorePointId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("scorePointId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		ScorePoint newScorePoint = addScorePoint();

		_persistence.clearCache();

		ScorePoint existingScorePoint = _persistence.findByPrimaryKey(newScorePoint.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(
				existingScorePoint.getAnonymousUserId()),
			ReflectionTestUtil.<Long>invoke(existingScorePoint,
				"getOriginalAnonymousUserId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(existingScorePoint.getUserSegmentId()),
			ReflectionTestUtil.<Long>invoke(existingScorePoint,
				"getOriginalUserSegmentId", new Class<?>[0]));
	}

	protected ScorePoint addScorePoint() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ScorePoint scorePoint = _persistence.create(pk);

		scorePoint.setUuid(RandomTestUtil.randomString());

		scorePoint.setCompanyId(RandomTestUtil.nextLong());

		scorePoint.setAnonymousUserId(RandomTestUtil.nextLong());

		scorePoint.setUserSegmentId(RandomTestUtil.nextLong());

		scorePoint.setPoints(RandomTestUtil.nextLong());

		_scorePoints.add(_persistence.update(scorePoint));

		return scorePoint;
	}

	private List<ScorePoint> _scorePoints = new ArrayList<ScorePoint>();
	private ScorePointPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}