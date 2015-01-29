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

package com.liferay.content.targeting.rule.language;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Eduardo Garcia
 */
@RunWith(PowerMockRunner.class)
public class LanguageRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_languageRule = new LanguageRule();

		ThemeDisplay themeDisplay = new ThemeDisplay();

		themeDisplay.setLanguageId(LocaleUtil.toLanguageId(LocaleUtil.SPAIN));

		_request.setAttribute(WebKeys.THEME_DISPLAY, themeDisplay);
	}

	@Test
	public void testMatchLanguage() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			LocaleUtil.toLanguageId(LocaleUtil.SPAIN)
		);

		Assert.assertTrue(
			_languageRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testNotMatchLanguage() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			LocaleUtil.toLanguageId(LocaleUtil.ENGLISH)
		);

		Assert.assertFalse(
			_languageRule.evaluate(_request, _ruleInstance, _anonymousUser));
	}

	@Mock
	private AnonymousUser _anonymousUser;

	private LanguageRule _languageRule;

	@Mock
	private HttpServletRequest _request = new MockHttpServletRequest();

	@Mock
	private RuleInstance _ruleInstance;

}