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

package com.liferay.content.targeting.test.lar;

import com.liferay.content.targeting.lar.ContentTargetingPortletDataHandler;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.content.targeting.service.TrackingActionInstanceLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.test.lar.BasePortletDataHandlerTestCase;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.lar.PortletDataHandler;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.Before;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class ContentTargetingPortletDataHandlerTest
	extends BasePortletDataHandlerTestCase {

	@Before
	public void setUp() throws Exception {
		super.setUp();

		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_campaignLocalService = ServiceTrackerUtil.getService(
			CampaignLocalService.class, _bundle.getBundleContext());
		_ruleInstanceLocalService = ServiceTrackerUtil.getService(
			RuleInstanceLocalService.class, _bundle.getBundleContext());
		_trackingActionInstanceLocalService = ServiceTrackerUtil.getService(
			TrackingActionInstanceLocalService.class,
			_bundle.getBundleContext());
		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, _bundle.getBundleContext());
	}

	@Override
	protected void addStagedModels() throws Exception {
		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			stagingGroup.getGroupId(), TestPropsValues.getUserId());

		UserSegment userSegment = _userSegmentLocalService.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, serviceContext);

		_campaignLocalService.addCampaign(
			TestPropsValues.getUserId(), nameMap, null, new Date(), new Date(),
			1, true, new long[] {userSegment.getUserSegmentId()},
			serviceContext);
	}

	@Override
	protected PortletDataHandler createPortletDataHandler() {
		return new ContentTargetingPortletDataHandler();
	}

	@Override
	protected String getPortletId() {
		return "ctadmin_WAR_contenttargetingweb";
	}

	@ArquillianResource
	private Bundle _bundle;

	private CampaignLocalService _campaignLocalService;
	private RuleInstanceLocalService _ruleInstanceLocalService;
	private TrackingActionInstanceLocalService
		_trackingActionInstanceLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}