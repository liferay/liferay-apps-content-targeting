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

package com.liferay.content.targeting.rule.age;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
 * @author Julio Camarero
 */
@PrepareForTest({JSONFactoryUtil.class})
@RunWith(PowerMockRunner.class)
public class AgeRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_ageRule = new AgeRule();

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

		Calendar today = new GregorianCalendar();

		Calendar calendar25YearsOld = new GregorianCalendar(
			(today.get(Calendar.YEAR) - 25), 1, 1);

		when(
			_user.getBirthday()
		).thenReturn(
			calendar25YearsOld.getTime()
		);
	}

	@Test
	public void testInAge() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			_user
		);

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON(20, 30)
		);

		Assert.assertTrue(
			_ageRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testOverAge() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			_user
		);

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON(10, 20)
		);

		Assert.assertFalse(
			_ageRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUnderAge() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			_user
		);

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON(30, 40)
		);

		Assert.assertFalse(
			_ageRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUnknown() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			null
		);

		Assert.assertFalse(
			_ageRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	private String _generateJSON(int olderThan, int youngerThan) {
		JSONObject jsonObj = new JSONObjectImpl();

		jsonObj.put("olderThan", olderThan);
		jsonObj.put("youngerThan", youngerThan);

		return jsonObj.toString();
	}

	private AgeRule _ageRule;

	@Mock
	private AnonymousUser _anonymousUser;

	@Mock
	private RuleInstance _ruleInstance;

	@Mock
	private User _user;

}