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

package com.liferay.content.targeting.report.campaign.content.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.content.targeting.report.campaign.content.exception.NoSuchCampaignContentException;
import com.liferay.content.targeting.report.campaign.content.model.CampaignContent;
import com.liferay.content.targeting.report.campaign.content.service.CampaignContentLocalServiceUtil;
import com.liferay.content.targeting.report.campaign.content.service.persistence.CampaignContentPersistence;
import com.liferay.content.targeting.report.campaign.content.service.persistence.CampaignContentUtil;

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
public class CampaignContentPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = CampaignContentUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CampaignContent> iterator = _campaignContents.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CampaignContent campaignContent = _persistence.create(pk);

		Assert.assertNotNull(campaignContent);

		Assert.assertEquals(campaignContent.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CampaignContent newCampaignContent = addCampaignContent();

		_persistence.remove(newCampaignContent);

		CampaignContent existingCampaignContent = _persistence.fetchByPrimaryKey(newCampaignContent.getPrimaryKey());

		Assert.assertNull(existingCampaignContent);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCampaignContent();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CampaignContent newCampaignContent = _persistence.create(pk);

		newCampaignContent.setCompanyId(RandomTestUtil.nextLong());

		newCampaignContent.setCampaignId(RandomTestUtil.nextLong());

		newCampaignContent.setClassName(RandomTestUtil.randomString());

		newCampaignContent.setClassPK(RandomTestUtil.nextLong());

		newCampaignContent.setEventType(RandomTestUtil.randomString());

		newCampaignContent.setCount(RandomTestUtil.nextInt());

		newCampaignContent.setModifiedDate(RandomTestUtil.nextDate());

		_campaignContents.add(_persistence.update(newCampaignContent));

		CampaignContent existingCampaignContent = _persistence.findByPrimaryKey(newCampaignContent.getPrimaryKey());

		Assert.assertEquals(existingCampaignContent.getCampaignContentId(),
			newCampaignContent.getCampaignContentId());
		Assert.assertEquals(existingCampaignContent.getCompanyId(),
			newCampaignContent.getCompanyId());
		Assert.assertEquals(existingCampaignContent.getCampaignId(),
			newCampaignContent.getCampaignId());
		Assert.assertEquals(existingCampaignContent.getClassName(),
			newCampaignContent.getClassName());
		Assert.assertEquals(existingCampaignContent.getClassPK(),
			newCampaignContent.getClassPK());
		Assert.assertEquals(existingCampaignContent.getEventType(),
			newCampaignContent.getEventType());
		Assert.assertEquals(existingCampaignContent.getCount(),
			newCampaignContent.getCount());
		Assert.assertEquals(Time.getShortTimestamp(
				existingCampaignContent.getModifiedDate()),
			Time.getShortTimestamp(newCampaignContent.getModifiedDate()));
	}

	@Test
	public void testCountByCampaignId() throws Exception {
		_persistence.countByCampaignId(RandomTestUtil.nextLong());

		_persistence.countByCampaignId(0L);
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
		CampaignContent newCampaignContent = addCampaignContent();

		CampaignContent existingCampaignContent = _persistence.findByPrimaryKey(newCampaignContent.getPrimaryKey());

		Assert.assertEquals(existingCampaignContent, newCampaignContent);
	}

	@Test(expected = NoSuchCampaignContentException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<CampaignContent> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_CCR_CampaignContent",
			"campaignContentId", true, "companyId", true, "campaignId", true,
			"className", true, "classPK", true, "eventType", true, "count",
			true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CampaignContent newCampaignContent = addCampaignContent();

		CampaignContent existingCampaignContent = _persistence.fetchByPrimaryKey(newCampaignContent.getPrimaryKey());

		Assert.assertEquals(existingCampaignContent, newCampaignContent);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CampaignContent missingCampaignContent = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCampaignContent);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		CampaignContent newCampaignContent1 = addCampaignContent();
		CampaignContent newCampaignContent2 = addCampaignContent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCampaignContent1.getPrimaryKey());
		primaryKeys.add(newCampaignContent2.getPrimaryKey());

		Map<Serializable, CampaignContent> campaignContents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, campaignContents.size());
		Assert.assertEquals(newCampaignContent1,
			campaignContents.get(newCampaignContent1.getPrimaryKey()));
		Assert.assertEquals(newCampaignContent2,
			campaignContents.get(newCampaignContent2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CampaignContent> campaignContents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(campaignContents.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		CampaignContent newCampaignContent = addCampaignContent();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCampaignContent.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CampaignContent> campaignContents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, campaignContents.size());
		Assert.assertEquals(newCampaignContent,
			campaignContents.get(newCampaignContent.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CampaignContent> campaignContents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(campaignContents.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		CampaignContent newCampaignContent = addCampaignContent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCampaignContent.getPrimaryKey());

		Map<Serializable, CampaignContent> campaignContents = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, campaignContents.size());
		Assert.assertEquals(newCampaignContent,
			campaignContents.get(newCampaignContent.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = CampaignContentLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<CampaignContent>() {
				@Override
				public void performAction(CampaignContent campaignContent) {
					Assert.assertNotNull(campaignContent);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		CampaignContent newCampaignContent = addCampaignContent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CampaignContent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("campaignContentId",
				newCampaignContent.getCampaignContentId()));

		List<CampaignContent> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CampaignContent existingCampaignContent = result.get(0);

		Assert.assertEquals(existingCampaignContent, newCampaignContent);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CampaignContent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("campaignContentId",
				RandomTestUtil.nextLong()));

		List<CampaignContent> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		CampaignContent newCampaignContent = addCampaignContent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CampaignContent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"campaignContentId"));

		Object newCampaignContentId = newCampaignContent.getCampaignContentId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("campaignContentId",
				new Object[] { newCampaignContentId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCampaignContentId = result.get(0);

		Assert.assertEquals(existingCampaignContentId, newCampaignContentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CampaignContent.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"campaignContentId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("campaignContentId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CampaignContent newCampaignContent = addCampaignContent();

		_persistence.clearCache();

		CampaignContent existingCampaignContent = _persistence.findByPrimaryKey(newCampaignContent.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(
				existingCampaignContent.getCampaignId()),
			ReflectionTestUtil.<Long>invoke(existingCampaignContent,
				"getOriginalCampaignId", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(
				existingCampaignContent.getClassName(),
				ReflectionTestUtil.invoke(existingCampaignContent,
					"getOriginalClassName", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingCampaignContent.getClassPK()),
			ReflectionTestUtil.<Long>invoke(existingCampaignContent,
				"getOriginalClassPK", new Class<?>[0]));
		Assert.assertTrue(Validator.equals(
				existingCampaignContent.getEventType(),
				ReflectionTestUtil.invoke(existingCampaignContent,
					"getOriginalEventType", new Class<?>[0])));
	}

	protected CampaignContent addCampaignContent() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CampaignContent campaignContent = _persistence.create(pk);

		campaignContent.setCompanyId(RandomTestUtil.nextLong());

		campaignContent.setCampaignId(RandomTestUtil.nextLong());

		campaignContent.setClassName(RandomTestUtil.randomString());

		campaignContent.setClassPK(RandomTestUtil.nextLong());

		campaignContent.setEventType(RandomTestUtil.randomString());

		campaignContent.setCount(RandomTestUtil.nextInt());

		campaignContent.setModifiedDate(RandomTestUtil.nextDate());

		_campaignContents.add(_persistence.update(campaignContent));

		return campaignContent;
	}

	private List<CampaignContent> _campaignContents = new ArrayList<CampaignContent>();
	private CampaignContentPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}