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
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.service.test.lar.BasePortletExportImportTestCase;
import com.liferay.content.targeting.service.test.service.ServiceTestUtil;
import com.liferay.content.targeting.service.test.util.TestPropsValues;
import com.liferay.osgi.util.service.ServiceTrackerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.service.ServiceContext;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * @author Eduardo Garcia
 */
@RunWith(Arquillian.class)
public class ContentTargetingExportImportTest
	extends BasePortletExportImportTestCase {

	@Override
	public String getNamespace() {
		return ContentTargetingPortletDataHandler.NAMESPACE;
	}

	@Override
	public String getPortletId() {
		return "ctadmin_WAR_contenttargetingweb";
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();

		try {
			_bundle.start();
		}
		catch (BundleException e) {
			e.printStackTrace();
		}

		_userSegmentLocalService = ServiceTrackerUtil.getService(
			UserSegmentLocalService.class, _bundle.getBundleContext());
	}

	@Ignore()
	@Override
	@Test
	public void testExportImportAssetLinks() throws Exception {
	}

	@Override
	protected StagedModel addStagedModel(long groupId) throws Exception {
		Map<Locale, String> nameMap = new HashMap<Locale, String>();

		nameMap.put(LocaleUtil.getDefault(), StringUtil.randomString());

		ServiceContext serviceContext = ServiceTestUtil.getServiceContext(
			groupId, TestPropsValues.getUserId());

		return _userSegmentLocalService.addUserSegment(
			TestPropsValues.getUserId(), nameMap, null, serviceContext);
	}

	@Override
	protected void deleteStagedModel(StagedModel stagedModel) throws Exception {
		_userSegmentLocalService.deleteUserSegment((UserSegment)stagedModel);
	}

	@Override
	protected Map<String, String[]> getExportParameterMap() throws Exception {
		Map<String, String[]> parameterMap = super.getExportParameterMap();

		addParameter(parameterMap, "user-segments", true);

		return parameterMap;
	}

	@Override
	protected Map<String, String[]> getImportParameterMap() throws Exception {
		Map<String, String[]> parameterMap = super.getImportParameterMap();

		addParameter(parameterMap, "user-segments", true);

		return parameterMap;
	}

	@Override
	protected StagedModel getStagedModel(String uuid, long groupId)
		throws PortalException, SystemException {

		return _userSegmentLocalService.getUserSegmentByUuidAndGroupId(
			uuid, groupId);
	}

	@ArquillianResource
	private Bundle _bundle;

	private UserSegmentLocalService _userSegmentLocalService;

}