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

package com.liferay.content.targeting.rule.score.points.service.impl;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.score.points.service.ScorePointLocalService;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.GroupTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@RunWith(Arquillian.class)
public class ScorePointLocalServiceImplTest {

	@Before
	public void setUp() throws Exception {
		Group group = GroupTestUtil.addGroup();

		_serviceContext = ServiceTestUtil.getServiceContext(
			group.getGroupId(), TestPropsValues.getUserId());

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), "test-category");

		_userSegment = _userSegmentLocalService.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, _serviceContext);
	}

	@Test
	public void testIncrementPoints() throws Exception {
		ServiceContext serviceContext = ServiceTestUtil.getServiceContext();

		int scorePoints = 10;

		AnonymousUser anonymousUser =
			_anonymousUserLocalService.addAnonymousUser(
				1, "127.0.0.1", StringPool.BLANK, serviceContext);

		int initialScorePointsCount =
			_scorePointLocalService.getScorePointsCount();

		long initialScorePoints = _scorePointLocalService.getPoints(
			anonymousUser.getAnonymousUserId(),
			_userSegment.getUserSegmentId());

		_scorePointLocalService.incrementPoints(
			anonymousUser.getAnonymousUserId(), _userSegment.getUserSegmentId(),
			scorePoints);

		Assert.assertEquals(
			initialScorePoints + scorePoints,
			_scorePointLocalService.getPoints(
				anonymousUser.getAnonymousUserId(),
				_userSegment.getUserSegmentId()));

		Assert.assertEquals(
			initialScorePointsCount + 1,
			_scorePointLocalService.getScorePointsCount());
	}

	@Reference(unbind = "-")
	protected void setAnonymousUserLocalService(
		AnonymousUserLocalService anonymousUserLocalService) {

		_anonymousUserLocalService = anonymousUserLocalService;
	}

	@Reference(unbind = "-")
	protected void setRuleInstanceLocalService(
		RuleInstanceLocalService ruleInstanceLocalService) {

		_ruleInstanceLocalService = ruleInstanceLocalService;
	}

	@Reference(unbind = "-")
	protected void setRulesRegistry(RulesRegistry rulesRegistry) {
		_rulesRegistry = rulesRegistry;
	}

	@Reference(unbind = "-")
	protected void setScorePointLocalService(
		ScorePointLocalService scorePointLocalService) {

		_scorePointLocalService = scorePointLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	private AnonymousUserLocalService _anonymousUserLocalService;
	private RuleInstanceLocalService _ruleInstanceLocalService;
	private RulesRegistry _rulesRegistry;
	private ScorePointLocalService _scorePointLocalService;
	private ServiceContext _serviceContext;
	private UserSegment _userSegment;
	private UserSegmentLocalService _userSegmentLocalService;

}