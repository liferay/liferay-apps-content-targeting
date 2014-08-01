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

package com.liferay.contenttargeting.rules.facebook;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.contenttargeting.rules.facebook.util.FacebookUtil;
import com.liferay.contenttargeting.rules.facebook.util.FacebookUtilTest;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.restfb.types.User;

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
public class FacebookEducationRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_facebookEducationRule = new FacebookEducationRule();

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
	public void testUserAttendedToCollege() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON(false, true, StringPool.BLANK)
		);

		Assert.assertTrue(
			_facebookEducationRule.evaluate(
				null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUserAttendedToCollegeOrHighSchoolWithName()
		throws Exception {

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON(false, false, "University")
		);

		Assert.assertTrue(
			_facebookEducationRule.evaluate(
				null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUserAttendedToHighSchool() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON(true, false, StringPool.BLANK)
		);

		Assert.assertTrue(
			_facebookEducationRule.evaluate(
				null, _ruleInstance, _anonymousUser));
	}

	private String _generateJSON(
		boolean highSchool, boolean college, String schoolName) {

		JSONObject jsonObj = new JSONObjectImpl();

		jsonObj.put("highSchool", highSchool);
		jsonObj.put("college", college);
		jsonObj.put("schoolName", schoolName);

		return jsonObj.toString();
	}

	@Mock
	private AnonymousUser _anonymousUser;

	private FacebookEducationRule _facebookEducationRule;

	@Mock
	private User _facebookUser;

	@Mock
	private RuleInstance _ruleInstance;

}