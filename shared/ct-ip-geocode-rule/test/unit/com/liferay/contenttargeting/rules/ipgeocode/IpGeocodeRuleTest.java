/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.contenttargeting.rules.ipgeocode;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.User;

import com.liferay.portal.model.impl.CountryImpl;
import com.liferay.portal.service.CountryServiceUtil;
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
@PrepareForTest({CalendarFactoryUtil.class, JSONFactoryUtil.class})
@RunWith(PowerMockRunner.class)
public class IpGeocodeRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_IpGeocodeRule = new IpGeocodeRule();

		mockStatic(CountryServiceUtil.class);
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
	}

	@Test
	public void testMadrid() throws Exception {
	}

	@Test
	public void testSpain() throws Exception {
		String SPAIN_IP = "8.8.8.8";

		Country spain = new CountryImpl();
		spain.setName("Spain");

		when(
			CountryServiceUtil.getCountry(Mockito.anyLong())
		).thenReturn(
			spain
		);

		when(
			_ruleInstance.getTypeSettings()
		).thenReturn(
			_generateJSON("Spain", null)
		);

		when(
			_anonymousUser.getLastIp()
		).thenReturn(
			SPAIN_IP
		);

		Assert.assertTrue(_IpGeocodeRule.evaluate(_ruleInstance, _anonymousUser));
	}

	@Test
	public void testUSA() throws Exception {
	}


	private String _generateJSON(String country, String region) {
		JSONObject jsonObj = new JSONObjectImpl();

		jsonObj.put("country", country);
		jsonObj.put("region", region);

		return jsonObj.toString();
	}

	@Mock
	private AnonymousUser _anonymousUser;

	@Mock
	private RuleInstance _ruleInstance;

	private IpGeocodeRule _IpGeocodeRule;

	@Mock
	private User _user;

}