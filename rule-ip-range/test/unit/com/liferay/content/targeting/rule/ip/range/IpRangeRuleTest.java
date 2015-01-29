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

package com.liferay.content.targeting.rule.ip.range;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;

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
 * @author Eduardo Garcia
 */
@PrepareForTest({JSONFactoryUtil.class})
@RunWith(PowerMockRunner.class)
public class IpRangeRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_ipRangeRule = new IpRangeRule();

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
			_anonymousUser.getLastIp()
		).thenReturn(
			"127.0.0.5"
		);
	}

	@Test
	public void testInRange() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON("127.0.0.1", "127.0.0.10")
		);

		Assert.assertTrue(
			_ipRangeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testInRangeLowerLimit() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON("127.0.0.5", "127.0.0.10")
		);

		Assert.assertTrue(
			_ipRangeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testInRangeUpperLimit() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON("127.0.0.1", "127.0.0.5")
		);

		Assert.assertTrue(
			_ipRangeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testIPV6InRange() throws Exception {
		when(
			_anonymousUser.getLastIp()
		).thenReturn(
			"1762:0:0:0:0:B03:1:AF18"
		);

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON("1762:0:0:0:0:B03:1:AF17", "1762:0:0:0:0:B03:1:AF19")
		);

		Assert.assertTrue(
			_ipRangeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testOverRange() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON("127.0.0.1", "127.0.0.4")
		);

		Assert.assertFalse(
			_ipRangeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUnderRange() throws Exception {
		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON("127.0.0.6", "127.0.0.10")
		);

		Assert.assertFalse(
			_ipRangeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUnknown() throws Exception {
		when(
			_anonymousUser.getUser()
		).thenReturn(
			null
		);

		Assert.assertFalse(
			_ipRangeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	private String _generateJSON(String ipFrom, String ipTo) {
		JSONObject jsonObj = new JSONObjectImpl();

		jsonObj.put("ipFrom", ipFrom);
		jsonObj.put("ipTo", ipTo);

		return jsonObj.toString();
	}

	@Mock
	private AnonymousUser _anonymousUser;

	@Mock
	private IpRangeRule _ipRangeRule;

	@Mock
	private RuleInstance _ruleInstance;

	@Mock
	private User _user;

}