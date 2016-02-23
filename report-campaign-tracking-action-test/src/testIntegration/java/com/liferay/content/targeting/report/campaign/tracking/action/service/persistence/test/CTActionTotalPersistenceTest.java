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

package com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionTotalException;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalServiceUtil;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionTotalPersistence;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionTotalUtil;

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
public class CTActionTotalPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = CTActionTotalUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CTActionTotal> iterator = _ctActionTotals.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTActionTotal ctActionTotal = _persistence.create(pk);

		Assert.assertNotNull(ctActionTotal);

		Assert.assertEquals(ctActionTotal.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CTActionTotal newCTActionTotal = addCTActionTotal();

		_persistence.remove(newCTActionTotal);

		CTActionTotal existingCTActionTotal = _persistence.fetchByPrimaryKey(newCTActionTotal.getPrimaryKey());

		Assert.assertNull(existingCTActionTotal);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCTActionTotal();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTActionTotal newCTActionTotal = _persistence.create(pk);

		newCTActionTotal.setCompanyId(RandomTestUtil.nextLong());

		newCTActionTotal.setCampaignId(RandomTestUtil.nextLong());

		newCTActionTotal.setReportInstanceId(RandomTestUtil.nextLong());

		newCTActionTotal.setAlias(RandomTestUtil.randomString());

		newCTActionTotal.setReferrerClassName(RandomTestUtil.randomString());

		newCTActionTotal.setReferrerClassPK(RandomTestUtil.nextLong());

		newCTActionTotal.setElementId(RandomTestUtil.randomString());

		newCTActionTotal.setEventType(RandomTestUtil.randomString());

		newCTActionTotal.setCount(RandomTestUtil.nextInt());

		newCTActionTotal.setModifiedDate(RandomTestUtil.nextDate());

		_ctActionTotals.add(_persistence.update(newCTActionTotal));

		CTActionTotal existingCTActionTotal = _persistence.findByPrimaryKey(newCTActionTotal.getPrimaryKey());

		Assert.assertEquals(existingCTActionTotal.getCTActionTotalId(),
			newCTActionTotal.getCTActionTotalId());
		Assert.assertEquals(existingCTActionTotal.getCompanyId(),
			newCTActionTotal.getCompanyId());
		Assert.assertEquals(existingCTActionTotal.getCampaignId(),
			newCTActionTotal.getCampaignId());
		Assert.assertEquals(existingCTActionTotal.getReportInstanceId(),
			newCTActionTotal.getReportInstanceId());
		Assert.assertEquals(existingCTActionTotal.getAlias(),
			newCTActionTotal.getAlias());
		Assert.assertEquals(existingCTActionTotal.getReferrerClassName(),
			newCTActionTotal.getReferrerClassName());
		Assert.assertEquals(existingCTActionTotal.getReferrerClassPK(),
			newCTActionTotal.getReferrerClassPK());
		Assert.assertEquals(existingCTActionTotal.getElementId(),
			newCTActionTotal.getElementId());
		Assert.assertEquals(existingCTActionTotal.getEventType(),
			newCTActionTotal.getEventType());
		Assert.assertEquals(existingCTActionTotal.getCount(),
			newCTActionTotal.getCount());
		Assert.assertEquals(Time.getShortTimestamp(
				existingCTActionTotal.getModifiedDate()),
			Time.getShortTimestamp(newCTActionTotal.getModifiedDate()));
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
	public void testCountByR_GtD() throws Exception {
		_persistence.countByR_GtD(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countByR_GtD(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByR_R_R_E_E() throws Exception {
		_persistence.countByR_R_R_E_E(RandomTestUtil.nextLong(),
			StringPool.BLANK, RandomTestUtil.nextLong(), StringPool.BLANK,
			StringPool.BLANK);

		_persistence.countByR_R_R_E_E(0L, StringPool.NULL, 0L, StringPool.NULL,
			StringPool.NULL);

		_persistence.countByR_R_R_E_E(0L, (String)null, 0L, (String)null,
			(String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CTActionTotal newCTActionTotal = addCTActionTotal();

		CTActionTotal existingCTActionTotal = _persistence.findByPrimaryKey(newCTActionTotal.getPrimaryKey());

		Assert.assertEquals(existingCTActionTotal, newCTActionTotal);
	}

	@Test(expected = NoSuchCTActionTotalException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<CTActionTotal> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_CTA_CTActionTotal",
			"CTActionTotalId", true, "companyId", true, "campaignId", true,
			"reportInstanceId", true, "alias", true, "referrerClassName", true,
			"referrerClassPK", true, "elementId", true, "eventType", true,
			"count", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CTActionTotal newCTActionTotal = addCTActionTotal();

		CTActionTotal existingCTActionTotal = _persistence.fetchByPrimaryKey(newCTActionTotal.getPrimaryKey());

		Assert.assertEquals(existingCTActionTotal, newCTActionTotal);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTActionTotal missingCTActionTotal = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCTActionTotal);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		CTActionTotal newCTActionTotal1 = addCTActionTotal();
		CTActionTotal newCTActionTotal2 = addCTActionTotal();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTActionTotal1.getPrimaryKey());
		primaryKeys.add(newCTActionTotal2.getPrimaryKey());

		Map<Serializable, CTActionTotal> ctActionTotals = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, ctActionTotals.size());
		Assert.assertEquals(newCTActionTotal1,
			ctActionTotals.get(newCTActionTotal1.getPrimaryKey()));
		Assert.assertEquals(newCTActionTotal2,
			ctActionTotals.get(newCTActionTotal2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CTActionTotal> ctActionTotals = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ctActionTotals.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		CTActionTotal newCTActionTotal = addCTActionTotal();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTActionTotal.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CTActionTotal> ctActionTotals = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ctActionTotals.size());
		Assert.assertEquals(newCTActionTotal,
			ctActionTotals.get(newCTActionTotal.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CTActionTotal> ctActionTotals = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ctActionTotals.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		CTActionTotal newCTActionTotal = addCTActionTotal();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTActionTotal.getPrimaryKey());

		Map<Serializable, CTActionTotal> ctActionTotals = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ctActionTotals.size());
		Assert.assertEquals(newCTActionTotal,
			ctActionTotals.get(newCTActionTotal.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = CTActionTotalLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<CTActionTotal>() {
				@Override
				public void performAction(CTActionTotal ctActionTotal) {
					Assert.assertNotNull(ctActionTotal);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		CTActionTotal newCTActionTotal = addCTActionTotal();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTActionTotal.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("CTActionTotalId",
				newCTActionTotal.getCTActionTotalId()));

		List<CTActionTotal> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CTActionTotal existingCTActionTotal = result.get(0);

		Assert.assertEquals(existingCTActionTotal, newCTActionTotal);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTActionTotal.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("CTActionTotalId",
				RandomTestUtil.nextLong()));

		List<CTActionTotal> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		CTActionTotal newCTActionTotal = addCTActionTotal();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTActionTotal.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"CTActionTotalId"));

		Object newCTActionTotalId = newCTActionTotal.getCTActionTotalId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("CTActionTotalId",
				new Object[] { newCTActionTotalId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCTActionTotalId = result.get(0);

		Assert.assertEquals(existingCTActionTotalId, newCTActionTotalId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTActionTotal.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"CTActionTotalId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("CTActionTotalId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CTActionTotal newCTActionTotal = addCTActionTotal();

		_persistence.clearCache();

		CTActionTotal existingCTActionTotal = _persistence.findByPrimaryKey(newCTActionTotal.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(
				existingCTActionTotal.getReportInstanceId()),
			ReflectionTestUtil.<Long>invoke(existingCTActionTotal,
				"getOriginalReportInstanceId", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(
				existingCTActionTotal.getReferrerClassName(),
				ReflectionTestUtil.invoke(existingCTActionTotal,
					"getOriginalReferrerClassName", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(
				existingCTActionTotal.getReferrerClassPK()),
			ReflectionTestUtil.<Long>invoke(existingCTActionTotal,
				"getOriginalReferrerClassPK", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(
				existingCTActionTotal.getElementId(),
				ReflectionTestUtil.invoke(existingCTActionTotal,
					"getOriginalElementId", new Class<?>[0])));
		Assert.assertTrue(Validator.equals(
				existingCTActionTotal.getEventType(),
				ReflectionTestUtil.invoke(existingCTActionTotal,
					"getOriginalEventType", new Class<?>[0])));
	}

	protected CTActionTotal addCTActionTotal() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTActionTotal ctActionTotal = _persistence.create(pk);

		ctActionTotal.setCompanyId(RandomTestUtil.nextLong());

		ctActionTotal.setCampaignId(RandomTestUtil.nextLong());

		ctActionTotal.setReportInstanceId(RandomTestUtil.nextLong());

		ctActionTotal.setAlias(RandomTestUtil.randomString());

		ctActionTotal.setReferrerClassName(RandomTestUtil.randomString());

		ctActionTotal.setReferrerClassPK(RandomTestUtil.nextLong());

		ctActionTotal.setElementId(RandomTestUtil.randomString());

		ctActionTotal.setEventType(RandomTestUtil.randomString());

		ctActionTotal.setCount(RandomTestUtil.nextInt());

		ctActionTotal.setModifiedDate(RandomTestUtil.nextDate());

		_ctActionTotals.add(_persistence.update(ctActionTotal));

		return ctActionTotal;
	}

	private List<CTActionTotal> _ctActionTotals = new ArrayList<CTActionTotal>();
	private CTActionTotalPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}