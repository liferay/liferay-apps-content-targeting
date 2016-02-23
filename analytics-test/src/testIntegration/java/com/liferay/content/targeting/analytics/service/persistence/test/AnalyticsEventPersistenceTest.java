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

import com.liferay.content.targeting.analytics.exception.NoSuchAnalyticsEventException;
import com.liferay.content.targeting.analytics.model.AnalyticsEvent;
import com.liferay.content.targeting.analytics.service.AnalyticsEventLocalServiceUtil;
import com.liferay.content.targeting.analytics.service.persistence.AnalyticsEventPersistence;
import com.liferay.content.targeting.analytics.service.persistence.AnalyticsEventUtil;

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
public class AnalyticsEventPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = AnalyticsEventUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnalyticsEvent> iterator = _analyticsEvents.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalyticsEvent analyticsEvent = _persistence.create(pk);

		Assert.assertNotNull(analyticsEvent);

		Assert.assertEquals(analyticsEvent.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnalyticsEvent newAnalyticsEvent = addAnalyticsEvent();

		_persistence.remove(newAnalyticsEvent);

		AnalyticsEvent existingAnalyticsEvent = _persistence.fetchByPrimaryKey(newAnalyticsEvent.getPrimaryKey());

		Assert.assertNull(existingAnalyticsEvent);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnalyticsEvent();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalyticsEvent newAnalyticsEvent = _persistence.create(pk);

		newAnalyticsEvent.setCompanyId(RandomTestUtil.nextLong());

		newAnalyticsEvent.setUserId(RandomTestUtil.nextLong());

		newAnalyticsEvent.setAnonymousUserId(RandomTestUtil.nextLong());

		newAnalyticsEvent.setClassName(RandomTestUtil.randomString());

		newAnalyticsEvent.setClassPK(RandomTestUtil.nextLong());

		newAnalyticsEvent.setElementId(RandomTestUtil.randomString());

		newAnalyticsEvent.setEventType(RandomTestUtil.randomString());

		newAnalyticsEvent.setClientIP(RandomTestUtil.randomString());

		newAnalyticsEvent.setUserAgent(RandomTestUtil.randomString());

		newAnalyticsEvent.setLanguageId(RandomTestUtil.randomString());

		newAnalyticsEvent.setURL(RandomTestUtil.randomString());

		newAnalyticsEvent.setAdditionalInfo(RandomTestUtil.randomString());

		newAnalyticsEvent.setCreateDate(RandomTestUtil.nextDate());

		_analyticsEvents.add(_persistence.update(newAnalyticsEvent));

		AnalyticsEvent existingAnalyticsEvent = _persistence.findByPrimaryKey(newAnalyticsEvent.getPrimaryKey());

		Assert.assertEquals(existingAnalyticsEvent.getAnalyticsEventId(),
			newAnalyticsEvent.getAnalyticsEventId());
		Assert.assertEquals(existingAnalyticsEvent.getCompanyId(),
			newAnalyticsEvent.getCompanyId());
		Assert.assertEquals(existingAnalyticsEvent.getUserId(),
			newAnalyticsEvent.getUserId());
		Assert.assertEquals(existingAnalyticsEvent.getAnonymousUserId(),
			newAnalyticsEvent.getAnonymousUserId());
		Assert.assertEquals(existingAnalyticsEvent.getClassName(),
			newAnalyticsEvent.getClassName());
		Assert.assertEquals(existingAnalyticsEvent.getClassPK(),
			newAnalyticsEvent.getClassPK());
		Assert.assertEquals(existingAnalyticsEvent.getElementId(),
			newAnalyticsEvent.getElementId());
		Assert.assertEquals(existingAnalyticsEvent.getEventType(),
			newAnalyticsEvent.getEventType());
		Assert.assertEquals(existingAnalyticsEvent.getClientIP(),
			newAnalyticsEvent.getClientIP());
		Assert.assertEquals(existingAnalyticsEvent.getUserAgent(),
			newAnalyticsEvent.getUserAgent());
		Assert.assertEquals(existingAnalyticsEvent.getLanguageId(),
			newAnalyticsEvent.getLanguageId());
		Assert.assertEquals(existingAnalyticsEvent.getURL(),
			newAnalyticsEvent.getURL());
		Assert.assertEquals(existingAnalyticsEvent.getAdditionalInfo(),
			newAnalyticsEvent.getAdditionalInfo());
		Assert.assertEquals(Time.getShortTimestamp(
				existingAnalyticsEvent.getCreateDate()),
			Time.getShortTimestamp(newAnalyticsEvent.getCreateDate()));
	}

	@Test
	public void testCountByCompanyId() throws Exception {
		_persistence.countByCompanyId(RandomTestUtil.nextLong());

		_persistence.countByCompanyId(0L);
	}

	@Test
	public void testCountByC_GtD() throws Exception {
		_persistence.countByC_GtD(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countByC_GtD(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByC_LtD() throws Exception {
		_persistence.countByC_LtD(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countByC_LtD(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByNotC_GtD() throws Exception {
		_persistence.countByNotC_GtD(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countByNotC_GtD(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByC_C_E() throws Exception {
		_persistence.countByC_C_E(StringPool.BLANK, RandomTestUtil.nextLong(),
			StringPool.BLANK);

		_persistence.countByC_C_E(StringPool.NULL, 0L, StringPool.NULL);

		_persistence.countByC_C_E((String)null, 0L, (String)null);
	}

	@Test
	public void testCountByE_E_GtD() throws Exception {
		_persistence.countByE_E_GtD(StringPool.BLANK, StringPool.BLANK,
			RandomTestUtil.nextDate());

		_persistence.countByE_E_GtD(StringPool.NULL, StringPool.NULL,
			RandomTestUtil.nextDate());

		_persistence.countByE_E_GtD((String)null, (String)null,
			RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByA_C_C_E() throws Exception {
		_persistence.countByA_C_C_E(RandomTestUtil.nextLong(),
			StringPool.BLANK, RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByA_C_C_E(0L, StringPool.NULL, 0L, StringPool.NULL);

		_persistence.countByA_C_C_E(0L, (String)null, 0L, (String)null);
	}

	@Test
	public void testCountByC_C_E_GtD() throws Exception {
		_persistence.countByC_C_E_GtD(StringPool.BLANK,
			RandomTestUtil.nextLong(), StringPool.BLANK,
			RandomTestUtil.nextDate());

		_persistence.countByC_C_E_GtD(StringPool.NULL, 0L, StringPool.NULL,
			RandomTestUtil.nextDate());

		_persistence.countByC_C_E_GtD((String)null, 0L, (String)null,
			RandomTestUtil.nextDate());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnalyticsEvent newAnalyticsEvent = addAnalyticsEvent();

		AnalyticsEvent existingAnalyticsEvent = _persistence.findByPrimaryKey(newAnalyticsEvent.getPrimaryKey());

		Assert.assertEquals(existingAnalyticsEvent, newAnalyticsEvent);
	}

	@Test(expected = NoSuchAnalyticsEventException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<AnalyticsEvent> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_Analytics_AnalyticsEvent",
			"analyticsEventId", true, "companyId", true, "userId", true,
			"anonymousUserId", true, "className", true, "classPK", true,
			"elementId", true, "eventType", true, "clientIP", true,
			"userAgent", true, "languageId", true, "URL", true, "createDate",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnalyticsEvent newAnalyticsEvent = addAnalyticsEvent();

		AnalyticsEvent existingAnalyticsEvent = _persistence.fetchByPrimaryKey(newAnalyticsEvent.getPrimaryKey());

		Assert.assertEquals(existingAnalyticsEvent, newAnalyticsEvent);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalyticsEvent missingAnalyticsEvent = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnalyticsEvent);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		AnalyticsEvent newAnalyticsEvent1 = addAnalyticsEvent();
		AnalyticsEvent newAnalyticsEvent2 = addAnalyticsEvent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalyticsEvent1.getPrimaryKey());
		primaryKeys.add(newAnalyticsEvent2.getPrimaryKey());

		Map<Serializable, AnalyticsEvent> analyticsEvents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, analyticsEvents.size());
		Assert.assertEquals(newAnalyticsEvent1,
			analyticsEvents.get(newAnalyticsEvent1.getPrimaryKey()));
		Assert.assertEquals(newAnalyticsEvent2,
			analyticsEvents.get(newAnalyticsEvent2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnalyticsEvent> analyticsEvents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(analyticsEvents.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		AnalyticsEvent newAnalyticsEvent = addAnalyticsEvent();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalyticsEvent.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnalyticsEvent> analyticsEvents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, analyticsEvents.size());
		Assert.assertEquals(newAnalyticsEvent,
			analyticsEvents.get(newAnalyticsEvent.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnalyticsEvent> analyticsEvents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(analyticsEvents.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		AnalyticsEvent newAnalyticsEvent = addAnalyticsEvent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalyticsEvent.getPrimaryKey());

		Map<Serializable, AnalyticsEvent> analyticsEvents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, analyticsEvents.size());
		Assert.assertEquals(newAnalyticsEvent,
			analyticsEvents.get(newAnalyticsEvent.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = AnalyticsEventLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<AnalyticsEvent>() {
				@Override
				public void performAction(AnalyticsEvent analyticsEvent) {
					Assert.assertNotNull(analyticsEvent);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AnalyticsEvent newAnalyticsEvent = addAnalyticsEvent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalyticsEvent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("analyticsEventId",
				newAnalyticsEvent.getAnalyticsEventId()));

		List<AnalyticsEvent> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnalyticsEvent existingAnalyticsEvent = result.get(0);

		Assert.assertEquals(existingAnalyticsEvent, newAnalyticsEvent);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalyticsEvent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("analyticsEventId",
				RandomTestUtil.nextLong()));

		List<AnalyticsEvent> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		AnalyticsEvent newAnalyticsEvent = addAnalyticsEvent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalyticsEvent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"analyticsEventId"));

		Object newAnalyticsEventId = newAnalyticsEvent.getAnalyticsEventId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("analyticsEventId",
				new Object[] { newAnalyticsEventId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAnalyticsEventId = result.get(0);

		Assert.assertEquals(existingAnalyticsEventId, newAnalyticsEventId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalyticsEvent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"analyticsEventId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("analyticsEventId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AnalyticsEvent addAnalyticsEvent() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalyticsEvent analyticsEvent = _persistence.create(pk);

		analyticsEvent.setCompanyId(RandomTestUtil.nextLong());

		analyticsEvent.setUserId(RandomTestUtil.nextLong());

		analyticsEvent.setAnonymousUserId(RandomTestUtil.nextLong());

		analyticsEvent.setClassName(RandomTestUtil.randomString());

		analyticsEvent.setClassPK(RandomTestUtil.nextLong());

		analyticsEvent.setElementId(RandomTestUtil.randomString());

		analyticsEvent.setEventType(RandomTestUtil.randomString());

		analyticsEvent.setClientIP(RandomTestUtil.randomString());

		analyticsEvent.setUserAgent(RandomTestUtil.randomString());

		analyticsEvent.setLanguageId(RandomTestUtil.randomString());

		analyticsEvent.setURL(RandomTestUtil.randomString());

		analyticsEvent.setAdditionalInfo(RandomTestUtil.randomString());

		analyticsEvent.setCreateDate(RandomTestUtil.nextDate());

		_analyticsEvents.add(_persistence.update(analyticsEvent));

		return analyticsEvent;
	}

	private List<AnalyticsEvent> _analyticsEvents = new ArrayList<AnalyticsEvent>();
	private AnalyticsEventPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}