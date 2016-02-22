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

package com.liferay.content.targeting.rule.os;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.util.PortalUtil;

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
@PrepareForTest({BrowserSnifferUtil.class, PortalUtil.class})
@RunWith(PowerMockRunner.class)
public class OSRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_osRule = new OSRule();

		mockStatic(BrowserSnifferUtil.class);
	}

	@Test
	public void testAndroid() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			OSRule.ANDROID
		);

		when(
			BrowserSnifferUtil.isAndroid(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_osRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testIOS() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			OSRule.IOS
		);

		when(
			BrowserSnifferUtil.isMac(_request)
		).thenReturn(
			true
		);

		when(
			BrowserSnifferUtil.isMobile(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_osRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testLinux() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			OSRule.LINUX
		);

		when(
			BrowserSnifferUtil.isLinux(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_osRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testMac() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			OSRule.MAC
		);

		when(
			BrowserSnifferUtil.isMac(_request)
		).thenReturn(
			true
		);

		when(
			BrowserSnifferUtil.isMobile(_request)
		).thenReturn(
			false
		);

		Assert.assertTrue(
			_osRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testWindows() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			OSRule.WINDOWS
		);

		when(
			BrowserSnifferUtil.isWindows(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_osRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Mock
	private AnonymousUser _anonymousUser;

	private OSRule _osRule;

	@Mock
	private HttpServletRequest _request;

	@Mock
	private RuleInstance _ruleInstance;

}