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

package com.liferay.content.targeting.rule.gender;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Julio Camarero
 */
@PrepareForTest({PortalUtil.class})
@RunWith(PowerMockRunner.class)
public class GenderRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_genderRule = new GenderRule();
	}

	@Test
	public void testFemale() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			_user
		);

		when(
			_user.isMale()
		).thenReturn(
			false
		);

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			"female"
		);

		Assert.assertTrue(
			_genderRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testMale() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			_user
		);

		when(
			_user.isMale()
		).thenReturn(
			true
		);

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			"male"
		);

		Assert.assertTrue(
			_genderRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUnknown() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			null
		);

		Assert.assertFalse(
			_genderRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Mock
	private AnonymousUser _anonymousUser;

	private GenderRule _genderRule;

	@Mock
	private RuleInstance _ruleInstance;

	@Mock
	private User _user;

}