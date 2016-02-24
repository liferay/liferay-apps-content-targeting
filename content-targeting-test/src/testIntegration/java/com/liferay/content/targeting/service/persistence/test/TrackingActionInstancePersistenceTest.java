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

import com.liferay.content.targeting.exception.NoSuchTrackingActionInstanceException;
import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.persistence.TrackingActionInstancePersistence;
import com.liferay.content.targeting.service.persistence.TrackingActionInstanceUtil;

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
public class TrackingActionInstancePersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = TrackingActionInstanceUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<TrackingActionInstance> iterator = _trackingActionInstances.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TrackingActionInstance trackingActionInstance = _persistence.create(pk);

		Assert.assertNotNull(trackingActionInstance);

		Assert.assertEquals(trackingActionInstance.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		TrackingActionInstance newTrackingActionInstance = addTrackingActionInstance();

		_persistence.remove(newTrackingActionInstance);

		TrackingActionInstance existingTrackingActionInstance = _persistence.fetchByPrimaryKey(newTrackingActionInstance.getPrimaryKey());

		Assert.assertNull(existingTrackingActionInstance);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTrackingActionInstance();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TrackingActionInstance newTrackingActionInstance = _persistence.create(pk);

		newTrackingActionInstance.setUuid(RandomTestUtil.randomString());

		newTrackingActionInstance.setGroupId(RandomTestUtil.nextLong());

		newTrackingActionInstance.setCompanyId(RandomTestUtil.nextLong());

		newTrackingActionInstance.setUserId(RandomTestUtil.nextLong());

		newTrackingActionInstance.setUserName(RandomTestUtil.randomString());

		newTrackingActionInstance.setCreateDate(RandomTestUtil.nextDate());

		newTrackingActionInstance.setModifiedDate(RandomTestUtil.nextDate());

		newTrackingActionInstance.setTrackingActionKey(RandomTestUtil.randomString());

		newTrackingActionInstance.setCampaignId(RandomTestUtil.nextLong());

		newTrackingActionInstance.setReportInstanceId(RandomTestUtil.nextLong());

		newTrackingActionInstance.setAlias(RandomTestUtil.randomString());

		newTrackingActionInstance.setReferrerClassName(RandomTestUtil.randomString());

		newTrackingActionInstance.setReferrerClassPK(RandomTestUtil.nextLong());

		newTrackingActionInstance.setElementId(RandomTestUtil.randomString());

		newTrackingActionInstance.setEventType(RandomTestUtil.randomString());

		newTrackingActionInstance.setTypeSettings(RandomTestUtil.randomString());

		_trackingActionInstances.add(_persistence.update(
				newTrackingActionInstance));

		TrackingActionInstance existingTrackingActionInstance = _persistence.findByPrimaryKey(newTrackingActionInstance.getPrimaryKey());

		Assert.assertEquals(existingTrackingActionInstance.getUuid(),
			newTrackingActionInstance.getUuid());
		Assert.assertEquals(existingTrackingActionInstance.getTrackingActionInstanceId(),
			newTrackingActionInstance.getTrackingActionInstanceId());
		Assert.assertEquals(existingTrackingActionInstance.getGroupId(),
			newTrackingActionInstance.getGroupId());
		Assert.assertEquals(existingTrackingActionInstance.getCompanyId(),
			newTrackingActionInstance.getCompanyId());
		Assert.assertEquals(existingTrackingActionInstance.getUserId(),
			newTrackingActionInstance.getUserId());
		Assert.assertEquals(existingTrackingActionInstance.getUserName(),
			newTrackingActionInstance.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingTrackingActionInstance.getCreateDate()),
			Time.getShortTimestamp(newTrackingActionInstance.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingTrackingActionInstance.getModifiedDate()),
			Time.getShortTimestamp(newTrackingActionInstance.getModifiedDate()));
		Assert.assertEquals(existingTrackingActionInstance.getTrackingActionKey(),
			newTrackingActionInstance.getTrackingActionKey());
		Assert.assertEquals(existingTrackingActionInstance.getCampaignId(),
			newTrackingActionInstance.getCampaignId());
		Assert.assertEquals(existingTrackingActionInstance.getReportInstanceId(),
			newTrackingActionInstance.getReportInstanceId());
		Assert.assertEquals(existingTrackingActionInstance.getAlias(),
			newTrackingActionInstance.getAlias());
		Assert.assertEquals(existingTrackingActionInstance.getReferrerClassName(),
			newTrackingActionInstance.getReferrerClassName());
		Assert.assertEquals(existingTrackingActionInstance.getReferrerClassPK(),
			newTrackingActionInstance.getReferrerClassPK());
		Assert.assertEquals(existingTrackingActionInstance.getElementId(),
			newTrackingActionInstance.getElementId());
		Assert.assertEquals(existingTrackingActionInstance.getEventType(),
			newTrackingActionInstance.getEventType());
		Assert.assertEquals(existingTrackingActionInstance.getTypeSettings(),
			newTrackingActionInstance.getTypeSettings());
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
	public void testCountByReportInstanceId() throws Exception {
		_persistence.countByReportInstanceId(RandomTestUtil.nextLong());

		_persistence.countByReportInstanceId(0L);
	}

	@Test
	public void testCountByC_A() throws Exception {
		_persistence.countByC_A(RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByC_A(0L, StringPool.NULL);

		_persistence.countByC_A(0L, (String)null);
	}

	@Test
	public void testCountByR_A() throws Exception {
		_persistence.countByR_A(RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByR_A(0L, StringPool.NULL);

		_persistence.countByR_A(0L, (String)null);
	}

	@Test
	public void testCountByC_E_E() throws Exception {
		_persistence.countByC_E_E(RandomTestUtil.nextLong(), StringPool.BLANK,
			StringPool.BLANK);

		_persistence.countByC_E_E(0L, StringPool.NULL, StringPool.NULL);

		_persistence.countByC_E_E(0L, (String)null, (String)null);
	}

	@Test
	public void testCountByR_E_E() throws Exception {
		_persistence.countByR_E_E(RandomTestUtil.nextLong(), StringPool.BLANK,
			StringPool.BLANK);

		_persistence.countByR_E_E(0L, StringPool.NULL, StringPool.NULL);

		_persistence.countByR_E_E(0L, (String)null, (String)null);
	}

	@Test
	public void testCountByC_R_R_E() throws Exception {
		_persistence.countByC_R_R_E(RandomTestUtil.nextLong(),
			StringPool.BLANK, RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByC_R_R_E(0L, StringPool.NULL, 0L, StringPool.NULL);

		_persistence.countByC_R_R_E(0L, (String)null, 0L, (String)null);
	}

	@Test
	public void testCountByR_R_R_E() throws Exception {
		_persistence.countByR_R_R_E(RandomTestUtil.nextLong(),
			StringPool.BLANK, RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByR_R_R_E(0L, StringPool.NULL, 0L, StringPool.NULL);

		_persistence.countByR_R_R_E(0L, (String)null, 0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		TrackingActionInstance newTrackingActionInstance = addTrackingActionInstance();

		TrackingActionInstance existingTrackingActionInstance = _persistence.findByPrimaryKey(newTrackingActionInstance.getPrimaryKey());

		Assert.assertEquals(existingTrackingActionInstance,
			newTrackingActionInstance);
	}

	@Test(expected = NoSuchTrackingActionInstanceException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<TrackingActionInstance> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_TrackingActionInstance",
			"uuid", true, "trackingActionInstanceId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "trackingActionKey", true,
			"campaignId", true, "reportInstanceId", true, "alias", true,
			"referrerClassName", true, "referrerClassPK", true, "elementId",
			true, "eventType", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		TrackingActionInstance newTrackingActionInstance = addTrackingActionInstance();

		TrackingActionInstance existingTrackingActionInstance = _persistence.fetchByPrimaryKey(newTrackingActionInstance.getPrimaryKey());

		Assert.assertEquals(existingTrackingActionInstance,
			newTrackingActionInstance);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TrackingActionInstance missingTrackingActionInstance = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTrackingActionInstance);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		TrackingActionInstance newTrackingActionInstance1 = addTrackingActionInstance();
		TrackingActionInstance newTrackingActionInstance2 = addTrackingActionInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTrackingActionInstance1.getPrimaryKey());
		primaryKeys.add(newTrackingActionInstance2.getPrimaryKey());

		Map<Serializable, TrackingActionInstance> trackingActionInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, trackingActionInstances.size());
		Assert.assertEquals(newTrackingActionInstance1,
			trackingActionInstances.get(
				newTrackingActionInstance1.getPrimaryKey()));
		Assert.assertEquals(newTrackingActionInstance2,
			trackingActionInstances.get(
				newTrackingActionInstance2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, TrackingActionInstance> trackingActionInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(trackingActionInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		TrackingActionInstance newTrackingActionInstance = addTrackingActionInstance();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTrackingActionInstance.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, TrackingActionInstance> trackingActionInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, trackingActionInstances.size());
		Assert.assertEquals(newTrackingActionInstance,
			trackingActionInstances.get(
				newTrackingActionInstance.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, TrackingActionInstance> trackingActionInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(trackingActionInstances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		TrackingActionInstance newTrackingActionInstance = addTrackingActionInstance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTrackingActionInstance.getPrimaryKey());

		Map<Serializable, TrackingActionInstance> trackingActionInstances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, trackingActionInstances.size());
		Assert.assertEquals(newTrackingActionInstance,
			trackingActionInstances.get(
				newTrackingActionInstance.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = TrackingActionInstanceLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<TrackingActionInstance>() {
				@Override
				public void performAction(
					TrackingActionInstance trackingActionInstance) {
					Assert.assertNotNull(trackingActionInstance);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		TrackingActionInstance newTrackingActionInstance = addTrackingActionInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TrackingActionInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq(
				"trackingActionInstanceId",
				newTrackingActionInstance.getTrackingActionInstanceId()));

		List<TrackingActionInstance> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		TrackingActionInstance existingTrackingActionInstance = result.get(0);

		Assert.assertEquals(existingTrackingActionInstance,
			newTrackingActionInstance);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TrackingActionInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq(
				"trackingActionInstanceId", RandomTestUtil.nextLong()));

		List<TrackingActionInstance> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		TrackingActionInstance newTrackingActionInstance = addTrackingActionInstance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TrackingActionInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"trackingActionInstanceId"));

		Object newTrackingActionInstanceId = newTrackingActionInstance.getTrackingActionInstanceId();

		dynamicQuery.add(RestrictionsFactoryUtil.in(
				"trackingActionInstanceId",
				new Object[] { newTrackingActionInstanceId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTrackingActionInstanceId = result.get(0);

		Assert.assertEquals(existingTrackingActionInstanceId,
			newTrackingActionInstanceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TrackingActionInstance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"trackingActionInstanceId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in(
				"trackingActionInstanceId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		TrackingActionInstance newTrackingActionInstance = addTrackingActionInstance();

		_persistence.clearCache();

		TrackingActionInstance existingTrackingActionInstance = _persistence.findByPrimaryKey(newTrackingActionInstance.getPrimaryKey());

		Assert.assertTrue(Validator.equals(
				existingTrackingActionInstance.getUuid(),
				ReflectionTestUtil.invoke(existingTrackingActionInstance,
					"getOriginalUuid", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(
				existingTrackingActionInstance.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingTrackingActionInstance,
				"getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(Long.valueOf(
				existingTrackingActionInstance.getCampaignId()),
			ReflectionTestUtil.<Long>invoke(existingTrackingActionInstance,
				"getOriginalCampaignId", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(
				existingTrackingActionInstance.getAlias(),
				ReflectionTestUtil.invoke(existingTrackingActionInstance,
					"getOriginalAlias", new Class<?>[0])));

		Assert.assertEquals(Long.valueOf(
				existingTrackingActionInstance.getReportInstanceId()),
			ReflectionTestUtil.<Long>invoke(existingTrackingActionInstance,
				"getOriginalReportInstanceId", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(
				existingTrackingActionInstance.getAlias(),
				ReflectionTestUtil.invoke(existingTrackingActionInstance,
					"getOriginalAlias", new Class<?>[0])));
	}

	protected TrackingActionInstance addTrackingActionInstance()
		throws Exception {
		long pk = RandomTestUtil.nextLong();

		TrackingActionInstance trackingActionInstance = _persistence.create(pk);

		trackingActionInstance.setUuid(RandomTestUtil.randomString());

		trackingActionInstance.setGroupId(RandomTestUtil.nextLong());

		trackingActionInstance.setCompanyId(RandomTestUtil.nextLong());

		trackingActionInstance.setUserId(RandomTestUtil.nextLong());

		trackingActionInstance.setUserName(RandomTestUtil.randomString());

		trackingActionInstance.setCreateDate(RandomTestUtil.nextDate());

		trackingActionInstance.setModifiedDate(RandomTestUtil.nextDate());

		trackingActionInstance.setTrackingActionKey(RandomTestUtil.randomString());

		trackingActionInstance.setCampaignId(RandomTestUtil.nextLong());

		trackingActionInstance.setReportInstanceId(RandomTestUtil.nextLong());

		trackingActionInstance.setAlias(RandomTestUtil.randomString());

		trackingActionInstance.setReferrerClassName(RandomTestUtil.randomString());

		trackingActionInstance.setReferrerClassPK(RandomTestUtil.nextLong());

		trackingActionInstance.setElementId(RandomTestUtil.randomString());

		trackingActionInstance.setEventType(RandomTestUtil.randomString());

		trackingActionInstance.setTypeSettings(RandomTestUtil.randomString());

		_trackingActionInstances.add(_persistence.update(trackingActionInstance));

		return trackingActionInstance;
	}

	private List<TrackingActionInstance> _trackingActionInstances = new ArrayList<TrackingActionInstance>();
	private TrackingActionInstancePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}