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

import com.liferay.content.targeting.report.campaign.tracking.action.exception.NoSuchCTActionException;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalServiceUtil;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionPersistence;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionUtil;

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
public class CTActionPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = CTActionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CTAction> iterator = _ctActions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTAction ctAction = _persistence.create(pk);

		Assert.assertNotNull(ctAction);

		Assert.assertEquals(ctAction.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CTAction newCTAction = addCTAction();

		_persistence.remove(newCTAction);

		CTAction existingCTAction = _persistence.fetchByPrimaryKey(newCTAction.getPrimaryKey());

		Assert.assertNull(existingCTAction);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCTAction();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTAction newCTAction = _persistence.create(pk);

		newCTAction.setCompanyId(RandomTestUtil.nextLong());

		newCTAction.setCampaignId(RandomTestUtil.nextLong());

		newCTAction.setReportInstanceId(RandomTestUtil.nextLong());

		newCTAction.setUserSegmentId(RandomTestUtil.nextLong());

		newCTAction.setAlias(RandomTestUtil.randomString());

		newCTAction.setReferrerClassName(RandomTestUtil.randomString());

		newCTAction.setReferrerClassPK(RandomTestUtil.nextLong());

		newCTAction.setElementId(RandomTestUtil.randomString());

		newCTAction.setEventType(RandomTestUtil.randomString());

		newCTAction.setCount(RandomTestUtil.nextInt());

		newCTAction.setModifiedDate(RandomTestUtil.nextDate());

		_ctActions.add(_persistence.update(newCTAction));

		CTAction existingCTAction = _persistence.findByPrimaryKey(newCTAction.getPrimaryKey());

		Assert.assertEquals(existingCTAction.getCTActionId(),
			newCTAction.getCTActionId());
		Assert.assertEquals(existingCTAction.getCompanyId(),
			newCTAction.getCompanyId());
		Assert.assertEquals(existingCTAction.getCampaignId(),
			newCTAction.getCampaignId());
		Assert.assertEquals(existingCTAction.getReportInstanceId(),
			newCTAction.getReportInstanceId());
		Assert.assertEquals(existingCTAction.getUserSegmentId(),
			newCTAction.getUserSegmentId());
		Assert.assertEquals(existingCTAction.getAlias(), newCTAction.getAlias());
		Assert.assertEquals(existingCTAction.getReferrerClassName(),
			newCTAction.getReferrerClassName());
		Assert.assertEquals(existingCTAction.getReferrerClassPK(),
			newCTAction.getReferrerClassPK());
		Assert.assertEquals(existingCTAction.getElementId(),
			newCTAction.getElementId());
		Assert.assertEquals(existingCTAction.getEventType(),
			newCTAction.getEventType());
		Assert.assertEquals(existingCTAction.getCount(), newCTAction.getCount());
		Assert.assertEquals(Time.getShortTimestamp(
				existingCTAction.getModifiedDate()),
			Time.getShortTimestamp(newCTAction.getModifiedDate()));
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
	public void testCountByR_E() throws Exception {
		_persistence.countByR_E(RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByR_E(0L, StringPool.NULL);

		_persistence.countByR_E(0L, (String)null);
	}

	@Test
	public void testCountByR_GtD() throws Exception {
		_persistence.countByR_GtD(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countByR_GtD(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByR_R_R() throws Exception {
		_persistence.countByR_R_R(RandomTestUtil.nextLong(), StringPool.BLANK,
			RandomTestUtil.nextLong());

		_persistence.countByR_R_R(0L, StringPool.NULL, 0L);

		_persistence.countByR_R_R(0L, (String)null, 0L);
	}

	@Test
	public void testCountByR_U_R_R_E_E() throws Exception {
		_persistence.countByR_U_R_R_E_E(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), StringPool.BLANK,
			RandomTestUtil.nextLong(), StringPool.BLANK, StringPool.BLANK);

		_persistence.countByR_U_R_R_E_E(0L, 0L, StringPool.NULL, 0L,
			StringPool.NULL, StringPool.NULL);

		_persistence.countByR_U_R_R_E_E(0L, 0L, (String)null, 0L, (String)null,
			(String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CTAction newCTAction = addCTAction();

		CTAction existingCTAction = _persistence.findByPrimaryKey(newCTAction.getPrimaryKey());

		Assert.assertEquals(existingCTAction, newCTAction);
	}

	@Test(expected = NoSuchCTActionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<CTAction> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_CTA_CTAction",
			"CTActionId", true, "companyId", true, "campaignId", true,
			"reportInstanceId", true, "userSegmentId", true, "alias", true,
			"referrerClassName", true, "referrerClassPK", true, "elementId",
			true, "eventType", true, "count", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CTAction newCTAction = addCTAction();

		CTAction existingCTAction = _persistence.fetchByPrimaryKey(newCTAction.getPrimaryKey());

		Assert.assertEquals(existingCTAction, newCTAction);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTAction missingCTAction = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCTAction);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		CTAction newCTAction1 = addCTAction();
		CTAction newCTAction2 = addCTAction();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTAction1.getPrimaryKey());
		primaryKeys.add(newCTAction2.getPrimaryKey());

		Map<Serializable, CTAction> ctActions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, ctActions.size());
		Assert.assertEquals(newCTAction1,
			ctActions.get(newCTAction1.getPrimaryKey()));
		Assert.assertEquals(newCTAction2,
			ctActions.get(newCTAction2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CTAction> ctActions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ctActions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		CTAction newCTAction = addCTAction();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTAction.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CTAction> ctActions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ctActions.size());
		Assert.assertEquals(newCTAction,
			ctActions.get(newCTAction.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CTAction> ctActions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ctActions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		CTAction newCTAction = addCTAction();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTAction.getPrimaryKey());

		Map<Serializable, CTAction> ctActions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ctActions.size());
		Assert.assertEquals(newCTAction,
			ctActions.get(newCTAction.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = CTActionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<CTAction>() {
				@Override
				public void performAction(CTAction ctAction) {
					Assert.assertNotNull(ctAction);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		CTAction newCTAction = addCTAction();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTAction.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("CTActionId",
				newCTAction.getCTActionId()));

		List<CTAction> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CTAction existingCTAction = result.get(0);

		Assert.assertEquals(existingCTAction, newCTAction);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTAction.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("CTActionId",
				RandomTestUtil.nextLong()));

		List<CTAction> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		CTAction newCTAction = addCTAction();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTAction.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("CTActionId"));

		Object newCTActionId = newCTAction.getCTActionId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("CTActionId",
				new Object[] { newCTActionId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCTActionId = result.get(0);

		Assert.assertEquals(existingCTActionId, newCTActionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTAction.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("CTActionId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("CTActionId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CTAction newCTAction = addCTAction();

		_persistence.clearCache();

		CTAction existingCTAction = _persistence.findByPrimaryKey(newCTAction.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(existingCTAction.getReportInstanceId()),
			ReflectionTestUtil.<Long>invoke(existingCTAction,
				"getOriginalReportInstanceId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(existingCTAction.getUserSegmentId()),
			ReflectionTestUtil.<Long>invoke(existingCTAction,
				"getOriginalUserSegmentId", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(
				existingCTAction.getReferrerClassName(),
				ReflectionTestUtil.invoke(existingCTAction,
					"getOriginalReferrerClassName", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingCTAction.getReferrerClassPK()),
			ReflectionTestUtil.<Long>invoke(existingCTAction,
				"getOriginalReferrerClassPK", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(existingCTAction.getElementId(),
				ReflectionTestUtil.invoke(existingCTAction,
					"getOriginalElementId", new Class<?>[0])));
		Assert.assertTrue(Validator.equals(existingCTAction.getEventType(),
				ReflectionTestUtil.invoke(existingCTAction,
					"getOriginalEventType", new Class<?>[0])));
	}

	protected CTAction addCTAction() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTAction ctAction = _persistence.create(pk);

		ctAction.setCompanyId(RandomTestUtil.nextLong());

		ctAction.setCampaignId(RandomTestUtil.nextLong());

		ctAction.setReportInstanceId(RandomTestUtil.nextLong());

		ctAction.setUserSegmentId(RandomTestUtil.nextLong());

		ctAction.setAlias(RandomTestUtil.randomString());

		ctAction.setReferrerClassName(RandomTestUtil.randomString());

		ctAction.setReferrerClassPK(RandomTestUtil.nextLong());

		ctAction.setElementId(RandomTestUtil.randomString());

		ctAction.setEventType(RandomTestUtil.randomString());

		ctAction.setCount(RandomTestUtil.nextInt());

		ctAction.setModifiedDate(RandomTestUtil.nextDate());

		_ctActions.add(_persistence.update(ctAction));

		return ctAction;
	}

	private List<CTAction> _ctActions = new ArrayList<CTAction>();
	private CTActionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}