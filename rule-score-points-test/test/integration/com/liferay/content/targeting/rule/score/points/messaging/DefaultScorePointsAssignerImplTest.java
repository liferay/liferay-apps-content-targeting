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

package com.liferay.content.targeting.rule.score.points.messaging;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.score.points.api.model.ScorePointsAssigner;
import com.liferay.content.targeting.rule.score.points.service.ScorePointLocalService;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.GroupTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Pavel Savinov
 */
@RunWith(Arquillian.class)
public class DefaultScorePointsAssignerImplTest {

	@Before
	public void setUp() throws Exception {
		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_anonymousUserLocalService = ServiceTrackerUtil.getService(
			AnonymousUserLocalService.class, _bundle.getBundleContext());
        _scorePointsAssigner = ServiceTrackerUtil.getService(
            ScorePointsAssigner.class, _bundle.getBundleContext());
        _scorePointLocalService = ServiceTrackerUtil.getService(
            ScorePointLocalService.class, _bundle.getBundleContext());
        _userSegmentLocalService = ServiceTrackerUtil.getService(
            UserSegmentLocalService.class, _bundle.getBundleContext());

        Group group = GroupTestUtil.addGroup();

        _serviceContext = ServiceTestUtil.getServiceContext(
            group.getGroupId(), TestPropsValues.getUserId());

        Map<Locale, String> nameMap = new HashMap<Locale, String>();

        nameMap.put(LocaleUtil.getDefault(), "test-category");

        _userSegment = _userSegmentLocalService.addUserSegment(
            TestPropsValues.getUserId(), nameMap, null, _serviceContext);
	}


    @Test
    public void testAssignPoints() throws Exception {

        long groupId = TestPropsValues.getGroupId();

        int initialScorePointsCount =
            _scorePointLocalService.getScorePointsCount();

        BlogsEntry entry = BlogsEntryLocalServiceUtil.addEntry(
            TestPropsValues.getUserId(), "title", StringPool.BLANK,
            "This is a blog entry for testing purposes", 1, 1, 1965, 0,
            0, true,
            true, null, false, null, null, null, _serviceContext);

        AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
            BlogsEntry.class.getName(), entry.getEntryId());

        AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(
            assetEntry.getEntryId(), _userSegment.getAssetCategoryId());

        String className = assetEntry.getClassName();
        long classPK = assetEntry.getClassPK();

        AnonymousUser anonymousUser =
            _anonymousUserLocalService.addAnonymousUser(
                1, "127.0.0.1", StringPool.BLANK, _serviceContext);

        _scorePointsAssigner.assignPoints(
            _serviceContext.getScopeGroupId(),
            anonymousUser.getAnonymousUserId(), className, classPK);

        Assert.assertEquals(
            initialScorePointsCount + 1,
            _scorePointLocalService.getScorePointsCount());

        BlogsEntryLocalServiceUtil.deleteBlogsEntry(entry);
    }

	private AnonymousUserLocalService _anonymousUserLocalService;

	@ArquillianResource
	private Bundle _bundle;

	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RulesRegistry _rulesRegistry;
    private ScorePointsAssigner _scorePointsAssigner;
    private ScorePointLocalService _scorePointLocalService;
    private ServiceContext _serviceContext;
    private UserSegment _userSegment;
    private UserSegmentLocalService _userSegmentLocalService;
}