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

package com.liferay.content.targeting.rule.browser;

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
public class BrowserRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_browserRule = new BrowserRule();

		mockStatic(BrowserSnifferUtil.class);
	}

	@Test
	public void testChrome() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			BrowserRule.CHROME
		);

		when(
			BrowserSnifferUtil.isChrome(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_browserRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testFireFox() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			BrowserRule.FIREFOX
		);

		when(
			BrowserSnifferUtil.isFirefox(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_browserRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testIE() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			BrowserRule.IE
		);

		when(
			BrowserSnifferUtil.isIe(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_browserRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testOpera() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			BrowserRule.OPERA
		);

		when(
			BrowserSnifferUtil.isOpera(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_browserRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testSafari() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			BrowserRule.SAFARI
		);

		when(
			BrowserSnifferUtil.isSafari(_request)
		).thenReturn(
			true
		);

		Assert.assertTrue(
			_browserRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Mock
	private AnonymousUser _anonymousUser;

	private BrowserRule _browserRule;

	@Mock
	private HttpServletRequest _request;

	@Mock
	private RuleInstance _ruleInstance;

}