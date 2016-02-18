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

package com.liferay.content.targeting.rule.facebook;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.facebook.util.FacebookUtil;
import com.liferay.content.targeting.rule.facebook.util.FacebookUtilTest;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Eudaldo Alonso
 */
@PrepareForTest({FacebookUtil.class, JSONFactoryUtil.class})
@RunWith(PowerMockRunner.class)
public class FacebookCityRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_facebookCityRule = new FacebookCityRule();

		mockStatic(FacebookUtil.class);
		mockStatic(JSONFactoryUtil.class);

		when(
			JSONFactoryUtil.createJSONObject(Mockito.anyString())
		).thenAnswer(
			new Answer<JSONObject>() {

				@Override
				public JSONObject answer(InvocationOnMock invocation)
					throws Throwable {

					Object[] args = invocation.getArguments();

					return new JSONObjectImpl((String)args[0]);
				}

			}
		);

		when(
			JSONFactoryUtil.createJSONObject()
		).thenReturn(
			new JSONObjectImpl()
		);

		when(
			FacebookUtil.getFacebookUser(Mockito.anyString())
		).thenReturn(
			FacebookUtilTest.getFacebookUser(getClass())
		);
	}

	@Test
	public void testUserLocationInCity() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			"Madrid"
		);

		Assert.assertTrue(
			_facebookCityRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUserLocationInCountry() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			"Spain"
		);

		Assert.assertTrue(
			_facebookCityRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUserLocationNotInCity() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			"London"
		);

		Assert.assertFalse(
			_facebookCityRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Mock
	private AnonymousUser _anonymousUser;

	private FacebookCityRule _facebookCityRule;

	@Mock
	private RuleInstance _ruleInstance;

}