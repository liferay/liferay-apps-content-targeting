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

package com.liferay.content.targeting.rule.ip.geocode;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.ip.geocoder.IPGeocoder;
import com.liferay.ip.geocoder.IPInfo;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.RegionServiceUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.model.impl.CountryImpl;
import com.liferay.portal.model.impl.RegionImpl;

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
 * @author Eudaldo Alonso
 */
@PrepareForTest(
	{
		CalendarFactoryUtil.class, CountryServiceUtil.class, HttpUtil.class,
		JSONFactoryUtil.class, RegionServiceUtil.class
	}
)
@RunWith(PowerMockRunner.class)
public class IpGeocodeRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_ipGeocodeRule = new IpGeocodeRule();

		_ipGeocodeRule.setIPGeocoder(_ipGeocoder);

		mockStatic(CountryServiceUtil.class);
		mockStatic(JSONFactoryUtil.class);
		mockStatic(RegionServiceUtil.class);

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
		Country country = new CountryImpl();

		country.setA2("ES");

		when(
			CountryServiceUtil.fetchCountry(Mockito.anyLong())
		).thenReturn(
			country
		);

		Region region = new RegionImpl();

		region.setName("Madrid");

		when(
			RegionServiceUtil.getRegion(Mockito.anyLong())
		).thenReturn(
			region
		);

		when(
			_ipInfo.getCountryCode()
		).thenReturn(
			"ES"
		);

		when(
			_ipInfo.getRegionName()
		).thenReturn(
			"Madrid"
		);

		when(
			_ipGeocoder.getIPInfo(Mockito.anyString())
		).thenReturn(
			_ipInfo
		);

		Assert.assertTrue(
			_ipGeocodeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testSpain() throws Exception {
		Country country = new CountryImpl();

		country.setA2("ES");

		when(
			CountryServiceUtil.fetchCountry(Mockito.anyLong())
		).thenReturn(
			country
		);

		when(
			RegionServiceUtil.getRegion(Mockito.anyLong())
		).thenReturn(
			null
		);

		when(
			_ipInfo.getCountryCode()
		).thenReturn(
			"ES"
		);

		when(
			_ipGeocoder.getIPInfo(Mockito.anyString())
		).thenReturn(
			_ipInfo
		);

		Assert.assertTrue(
			_ipGeocodeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Test
	public void testUSA() throws Exception {
		Country country = new CountryImpl();

		country.setA2("US");

		when(
			CountryServiceUtil.fetchCountry(Mockito.anyLong())
		).thenReturn(
			country
		);

		when(
			RegionServiceUtil.getRegion(Mockito.anyLong())
		).thenReturn(
			null
		);

		when(
			_ipInfo.getCountryCode()
		).thenReturn(
			"US"
		);

		when(
			_ipGeocoder.getIPInfo(Mockito.anyString())
		).thenReturn(
			_ipInfo
		);

		Assert.assertTrue(
			_ipGeocodeRule.evaluate(null, _ruleInstance, _anonymousUser));
	}

	@Mock
	private AnonymousUser _anonymousUser;

	@Mock
	private IPGeocoder _ipGeocoder;

	private IpGeocodeRule _ipGeocodeRule;

	@Mock
	private IPInfo _ipInfo;

	@Mock
	private RuleInstance _ruleInstance;

	@Mock
	private User _user;

}