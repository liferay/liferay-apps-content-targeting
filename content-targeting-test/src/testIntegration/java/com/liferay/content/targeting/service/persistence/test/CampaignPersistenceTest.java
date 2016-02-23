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

import com.liferay.content.targeting.exception.NoSuchCampaignException;
import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.content.targeting.service.persistence.CampaignPersistence;
import com.liferay.content.targeting.service.persistence.CampaignUtil;

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
public class CampaignPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = CampaignUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Campaign> iterator = _campaigns.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Campaign campaign = _persistence.create(pk);

		Assert.assertNotNull(campaign);

		Assert.assertEquals(campaign.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Campaign newCampaign = addCampaign();

		_persistence.remove(newCampaign);

		Campaign existingCampaign = _persistence.fetchByPrimaryKey(newCampaign.getPrimaryKey());

		Assert.assertNull(existingCampaign);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCampaign();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Campaign newCampaign = _persistence.create(pk);

		newCampaign.setUuid(RandomTestUtil.randomString());

		newCampaign.setGroupId(RandomTestUtil.nextLong());

		newCampaign.setCompanyId(RandomTestUtil.nextLong());

		newCampaign.setUserId(RandomTestUtil.nextLong());

		newCampaign.setUserName(RandomTestUtil.randomString());

		newCampaign.setCreateDate(RandomTestUtil.nextDate());

		newCampaign.setModifiedDate(RandomTestUtil.nextDate());

		newCampaign.setName(RandomTestUtil.randomString());

		newCampaign.setDescription(RandomTestUtil.randomString());

		newCampaign.setStartDate(RandomTestUtil.nextDate());

		newCampaign.setEndDate(RandomTestUtil.nextDate());

		newCampaign.setTimeZoneId(RandomTestUtil.randomString());

		newCampaign.setPriority(RandomTestUtil.nextInt());

		newCampaign.setActive(RandomTestUtil.randomBoolean());

		_campaigns.add(_persistence.update(newCampaign));

		Campaign existingCampaign = _persistence.findByPrimaryKey(newCampaign.getPrimaryKey());

		Assert.assertEquals(existingCampaign.getUuid(), newCampaign.getUuid());
		Assert.assertEquals(existingCampaign.getCampaignId(),
			newCampaign.getCampaignId());
		Assert.assertEquals(existingCampaign.getGroupId(),
			newCampaign.getGroupId());
		Assert.assertEquals(existingCampaign.getCompanyId(),
			newCampaign.getCompanyId());
		Assert.assertEquals(existingCampaign.getUserId(),
			newCampaign.getUserId());
		Assert.assertEquals(existingCampaign.getUserName(),
			newCampaign.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingCampaign.getCreateDate()),
			Time.getShortTimestamp(newCampaign.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingCampaign.getModifiedDate()),
			Time.getShortTimestamp(newCampaign.getModifiedDate()));
		Assert.assertEquals(existingCampaign.getName(), newCampaign.getName());
		Assert.assertEquals(existingCampaign.getDescription(),
			newCampaign.getDescription());
		Assert.assertEquals(Time.getShortTimestamp(
				existingCampaign.getStartDate()),
			Time.getShortTimestamp(newCampaign.getStartDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingCampaign.getEndDate()),
			Time.getShortTimestamp(newCampaign.getEndDate()));
		Assert.assertEquals(existingCampaign.getTimeZoneId(),
			newCampaign.getTimeZoneId());
		Assert.assertEquals(existingCampaign.getPriority(),
			newCampaign.getPriority());
		Assert.assertEquals(existingCampaign.getActive(),
			newCampaign.getActive());
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
	public void testCountByGroupIdArrayable() throws Exception {
		_persistence.countByGroupId(new long[] { RandomTestUtil.nextLong(), 0L });
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Campaign newCampaign = addCampaign();

		Campaign existingCampaign = _persistence.findByPrimaryKey(newCampaign.getPrimaryKey());

		Assert.assertEquals(existingCampaign, newCampaign);
	}

	@Test(expected = NoSuchCampaignException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	@Test
	public void testFilterFindByGroupId() throws Exception {
		_persistence.filterFindByGroupId(0, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Campaign> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CT_Campaign", "uuid", true,
			"campaignId", true, "groupId", true, "companyId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true,
			"name", true, "description", true, "startDate", true, "endDate",
			true, "timeZoneId", true, "priority", true, "active", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Campaign newCampaign = addCampaign();

		Campaign existingCampaign = _persistence.fetchByPrimaryKey(newCampaign.getPrimaryKey());

		Assert.assertEquals(existingCampaign, newCampaign);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Campaign missingCampaign = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCampaign);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Campaign newCampaign1 = addCampaign();
		Campaign newCampaign2 = addCampaign();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCampaign1.getPrimaryKey());
		primaryKeys.add(newCampaign2.getPrimaryKey());

		Map<Serializable, Campaign> campaigns = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, campaigns.size());
		Assert.assertEquals(newCampaign1,
			campaigns.get(newCampaign1.getPrimaryKey()));
		Assert.assertEquals(newCampaign2,
			campaigns.get(newCampaign2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Campaign> campaigns = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(campaigns.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Campaign newCampaign = addCampaign();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCampaign.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Campaign> campaigns = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, campaigns.size());
		Assert.assertEquals(newCampaign,
			campaigns.get(newCampaign.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Campaign> campaigns = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(campaigns.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Campaign newCampaign = addCampaign();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCampaign.getPrimaryKey());

		Map<Serializable, Campaign> campaigns = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, campaigns.size());
		Assert.assertEquals(newCampaign,
			campaigns.get(newCampaign.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = CampaignLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Campaign>() {
				@Override
				public void performAction(Campaign campaign) {
					Assert.assertNotNull(campaign);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Campaign newCampaign = addCampaign();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Campaign.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("campaignId",
				newCampaign.getCampaignId()));

		List<Campaign> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Campaign existingCampaign = result.get(0);

		Assert.assertEquals(existingCampaign, newCampaign);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Campaign.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("campaignId",
				RandomTestUtil.nextLong()));

		List<Campaign> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Campaign newCampaign = addCampaign();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Campaign.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("campaignId"));

		Object newCampaignId = newCampaign.getCampaignId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("campaignId",
				new Object[] { newCampaignId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCampaignId = result.get(0);

		Assert.assertEquals(existingCampaignId, newCampaignId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Campaign.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("campaignId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("campaignId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Campaign newCampaign = addCampaign();

		_persistence.clearCache();

		Campaign existingCampaign = _persistence.findByPrimaryKey(newCampaign.getPrimaryKey());

		Assert.assertTrue(Validator.equals(existingCampaign.getUuid(),
				ReflectionTestUtil.invoke(existingCampaign, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingCampaign.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingCampaign,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Campaign addCampaign() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Campaign campaign = _persistence.create(pk);

		campaign.setUuid(RandomTestUtil.randomString());

		campaign.setGroupId(RandomTestUtil.nextLong());

		campaign.setCompanyId(RandomTestUtil.nextLong());

		campaign.setUserId(RandomTestUtil.nextLong());

		campaign.setUserName(RandomTestUtil.randomString());

		campaign.setCreateDate(RandomTestUtil.nextDate());

		campaign.setModifiedDate(RandomTestUtil.nextDate());

		campaign.setName(RandomTestUtil.randomString());

		campaign.setDescription(RandomTestUtil.randomString());

		campaign.setStartDate(RandomTestUtil.nextDate());

		campaign.setEndDate(RandomTestUtil.nextDate());

		campaign.setTimeZoneId(RandomTestUtil.randomString());

		campaign.setPriority(RandomTestUtil.nextInt());

		campaign.setActive(RandomTestUtil.randomBoolean());

		_campaigns.add(_persistence.update(campaign));

		return campaign;
	}

	private List<Campaign> _campaigns = new ArrayList<Campaign>();
	private CampaignPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}