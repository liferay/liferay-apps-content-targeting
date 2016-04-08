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

import com.liferay.content.targeting.exception.NoSuchReportInstanceException;
import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.persistence.ReportInstancePersistence;
import com.liferay.content.targeting.service.persistence.ReportInstanceUtil;

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
public class ReportInstancePersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = ReportInstanceUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ReportInstance> iterator = _reportInstances.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ReportInstance reportInstance = _persistence.create(pk);

		Assert.assertNotNull(reportInstance);

		Assert.assertEquals(reportInstance.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ReportInstance newReportInstance = addReportInstance();

		_persistence.remove(newReportInstance);

		ReportInstance existingReportInstance = _persistence.fetchByPrimaryKey(newReportInstance.getPrimaryKey());

		Assert.assertNull(existingReportInstance);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addReportInstance();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ReportInstance newReportInstance = _persistence.create(pk);

		newReportInstance.setUuid(RandomTestUtil.randomString());

		newReportInstance.setGroupId(RandomTestUtil.nextLong());

		newReportInstance.setCompanyId(RandomTestUtil.nextLong());

		newReportInstance.setUserId(RandomTestUtil.nextLong());

		newReportInstance.setUserName(RandomTestUtil.randomString());

		newReportInstance.setCreateDate(RandomTestUtil.nextDate());

		newReportInstance.setModifiedDate(RandomTestUtil.nextDate());

		newReportInstance.setReportKey(RandomTestUtil.randomString());

		newReportInstance.setName(RandomTestUtil.randomString());

		newReportInstance.setDescription(RandomTestUtil.randomString());

		newReportInstance.setClassNameId(RandomTestUtil.nextLong());

		newReportInstance.setClassPK(RandomTestUtil.nextLong());

		newReportInstance.setTypeSettings(RandomTestUtil.randomString());

		_reportInstances.add(_persistence.update(newReportInstance));

		ReportInstance existingReportInstance = _persistence.findByPrimaryKey(newReportInstance.getPrimaryKey());

		Assert.assertEquals(existingReportInstance.getUuid(),
			newReportInstance.getUuid());
		Assert.assertEquals(existingReportInstance.getReportInstanceId(),
			newReportInstance.getReportInstanceId());
		Assert.assertEquals(existingReportInstance.getGroupId(),
			newReportInstance.getGroupId());
		Assert.assertEquals(existingReportInstance.getCompanyId(),
			newReportInstance.getCompanyId());
		Assert.assertEquals(existingReportInstance.getUserId(),
			newReportInstance.getUserId());
		Assert.assertEquals(existingReportInstance.getUserName(),
			newReportInstance.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingReportInstance.getCreateDate()),
			Time.getShortTimestamp(newReportInstance.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingReportInstance.getModifiedDate()),
			Time.getShortTimestamp(newReportInstance.getModifiedDate()));
		Assert.assertEquals(existingReportInstance.getReportKey(),
			newReportInstance.getReportKey());
		Assert.assertEquals(existingReportInstance.getName(),
			newReportInstance.getName());
		Assert.assertEquals(existingReportInstance.getDescription(),
			newReportInstance.getDescription());
		Assert.assertEquals(existingReportInstance.getClassNameId(),
			newReportInstance.getClassNameId());
		Assert.assertEquals(existingReportInstance.getClassPK(),
			newReportInstance.getClassPK());
		Assert.assertEquals(existingReportInstance.getTypeSettings(),
			newReportInstance.getTypeSettings());
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
	public void testCountByC_C() throws Exception {
		_persistence.countByC_C(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByC_C(0L, 0L);
	}

	@Test
	public void testCountByR_C_C() throws Exception {
		_persistence.countByR_C_C(StringPool.BLANK, RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByR_C_C(StringPool.NULL, 0L, 0L);

		_persistence.countByR_C_C((String)null, 0L, 0L);
	}

	@Test
	public void testCountByU_C_C() throws Exception {
		_persistence.countByU_C_C(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByU_C_C(0L, 0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ReportInstance newReportInstance = addReportInstance();

		ReportInstance existingReportInstance = _persistence.findByPrimaryKey(newReportInstance.getPrimaryKey());

		Assert.assertEquals(existingReportInstance, newReportInstance);
	}

	@Test(expected = NoSuchReportInstanceException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<ReportInstance> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_ReportInstance", "uuid",
			true, "reportInstanceId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "reportKey", true, "name", true,
			"description", true, "classNameId", true, "classPK", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ReportInstance newReportInstance = addReportInstance();

		ReportInstance existingReportInstance = _persistence.fetchByPrimaryKey(newReportInstance.getPrimaryKey());

		Assert.assertEquals(existingReportInstance, newReportInstance);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ReportInstance missingReportInstance = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingReportInstance);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		ReportInstance newReportInstance1 = addReportInstance();
		ReportInstance newReportInstance2 = addReportInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newReportInstance1.getPrimaryKey());
		primaryKeys.add(newReportInstance2.getPrimaryKey());

		Map<Serializable, ReportInstance> reportInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, reportInstances.size());
		Assert.assertEquals(newReportInstance1,
			reportInstances.get(newReportInstance1.getPrimaryKey()));
		Assert.assertEquals(newReportInstance2,
			reportInstances.get(newReportInstance2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ReportInstance> reportInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(reportInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		ReportInstance newReportInstance = addReportInstance();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newReportInstance.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ReportInstance> reportInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, reportInstances.size());
		Assert.assertEquals(newReportInstance,
			reportInstances.get(newReportInstance.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ReportInstance> reportInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(reportInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		ReportInstance newReportInstance = addReportInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newReportInstance.getPrimaryKey());

		Map<Serializable, ReportInstance> reportInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, reportInstances.size());
		Assert.assertEquals(newReportInstance,
			reportInstances.get(newReportInstance.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = ReportInstanceLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<ReportInstance>() {
				@Override
				public void performAction(ReportInstance reportInstance) {
					Assert.assertNotNull(reportInstance);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		ReportInstance newReportInstance = addReportInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ReportInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("reportInstanceId",
				newReportInstance.getReportInstanceId()));

		List<ReportInstance> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		ReportInstance existingReportInstance = result.get(0);

		Assert.assertEquals(existingReportInstance, newReportInstance);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ReportInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("reportInstanceId",
				RandomTestUtil.nextLong()));

		List<ReportInstance> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		ReportInstance newReportInstance = addReportInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ReportInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"reportInstanceId"));

		Object newReportInstanceId = newReportInstance.getReportInstanceId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("reportInstanceId",
				new Object[] { newReportInstanceId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingReportInstanceId = result.get(0);

		Assert.assertEquals(existingReportInstanceId, newReportInstanceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ReportInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"reportInstanceId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("reportInstanceId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		ReportInstance newReportInstance = addReportInstance();

		_persistence.clearCache();

		ReportInstance existingReportInstance = _persistence.findByPrimaryKey(newReportInstance.getPrimaryKey());

		Assert.assertTrue(Validator.equals(existingReportInstance.getUuid(),
				ReflectionTestUtil.invoke(existingReportInstance,
					"getOriginalUuid", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingReportInstance.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingReportInstance,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected ReportInstance addReportInstance() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ReportInstance reportInstance = _persistence.create(pk);

		reportInstance.setUuid(RandomTestUtil.randomString());

		reportInstance.setGroupId(RandomTestUtil.nextLong());

		reportInstance.setCompanyId(RandomTestUtil.nextLong());

		reportInstance.setUserId(RandomTestUtil.nextLong());

		reportInstance.setUserName(RandomTestUtil.randomString());

		reportInstance.setCreateDate(RandomTestUtil.nextDate());

		reportInstance.setModifiedDate(RandomTestUtil.nextDate());

		reportInstance.setReportKey(RandomTestUtil.randomString());

		reportInstance.setName(RandomTestUtil.randomString());

		reportInstance.setDescription(RandomTestUtil.randomString());

		reportInstance.setClassNameId(RandomTestUtil.nextLong());

		reportInstance.setClassPK(RandomTestUtil.nextLong());

		reportInstance.setTypeSettings(RandomTestUtil.randomString());

		_reportInstances.add(_persistence.update(reportInstance));

		return reportInstance;
	}

	private List<ReportInstance> _reportInstances = new ArrayList<ReportInstance>();
	private ReportInstancePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}