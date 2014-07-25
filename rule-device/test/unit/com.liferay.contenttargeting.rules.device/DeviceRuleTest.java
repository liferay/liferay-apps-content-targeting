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

package com.liferay.contenttargeting.rules.device;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.util.PortalUtil;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Eudaldo Alonso
 */
@PrepareForTest({BrowserSnifferUtil.class, DeviceRule.class, PortalUtil.class})
@RunWith(PowerMockRunner.class)
public class DeviceRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_deviceRule = new DeviceRule();

		mockStatic(BrowserSnifferUtil.class);
		mockStatic(DeviceRule.class);
	}

	@Test
	public void testIE() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			DeviceRule.DESKTOP
		);

		when(
			BrowserSnifferUtil.isMobile(_request)
		).thenReturn(
			false
		);

		when(
			DeviceRule.isTablet(_request)
		).thenReturn(
			false
		);

		Assert.assertTrue(
			_deviceRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testMobile() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			DeviceRule.MOBILE
		);

		when(
			BrowserSnifferUtil.isMobile(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_deviceRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testTablet() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			DeviceRule.TABLET
		);

		when(
			DeviceRule.isTablet(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_deviceRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Mock
	private AnonymousUser _anonymousUser;

	private DeviceRule _deviceRule;

	@Mock
	private HttpServletRequest _request;

	@Mock
	private RuleInstance _ruleInstance;

}