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
import com.liferay.contenttargeting.rules.ipgeocode.model.IPInfo;
import com.liferay.contenttargeting.rules.ipgeocode.util.IPGeocodeUtil;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.CountryImpl;
import com.liferay.portal.model.impl.RegionImpl;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;

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
@PrepareForTest( {
	CalendarFactoryUtil.class, CountryServiceUtil.class, HttpUtil.class,
	IPGeocodeUtil.class, JSONFactoryUtil.class, RegionServiceUtil.class
})
@RunWith(PowerMockRunner.class)
public class IpGeocodeRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_ipGeocodeRule = new IpGeocodeRule();

		mockStatic(CountryServiceUtil.class);
		mockStatic(IPGeocodeUtil.class);
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
			_anonymousUser.getLastIp()
		).thenReturn(
			_SPAIN_IP
		);

		when(
			IPGeocodeUtil.getIPInfo(Mockito.anyString())
		).thenReturn(
			new IPInfo(_generateJSONSpain())
		);

		Assert.assertTrue(
			_ipGeocodeRule.evaluate(_ruleInstance, _anonymousUser));
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
			_anonymousUser.getLastIp()
		).thenReturn(
			_SPAIN_IP
		);

		when(
			IPGeocodeUtil.getIPInfo(Mockito.anyString())
		).thenReturn(
			new IPInfo(_generateJSONSpain())
		);

		Assert.assertTrue(
			_ipGeocodeRule.evaluate(_ruleInstance, _anonymousUser));
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
			_anonymousUser.getLastIp()
		).thenReturn(
			_US_IP
		);

		when(
			IPGeocodeUtil.getIPInfo(Mockito.anyString())
		).thenReturn(
			new IPInfo(_generateJSONUSA())
		);

		Assert.assertTrue(
			_ipGeocodeRule.evaluate(_ruleInstance, _anonymousUser));
	}

	private JSONObject _generateJSONUSA() {
		JSONObject jsonObj = new JSONObjectImpl();

		jsonObj.put("ip", "173.194.41.248");
		jsonObj.put("country_code", "US");
		jsonObj.put("country_name", "United States");
		jsonObj.put("region_code", "CA");
		jsonObj.put("region_name", "California");
		jsonObj.put("city", "Mountain View");
		jsonObj.put("zipcode", "94043");
		jsonObj.put("latitude", 37.4192);
		jsonObj.put("longitude", -122.0574);
		jsonObj.put("metro_code", "807");
		jsonObj.put("area_code", "650");

		return jsonObj;
	}

	private JSONObject _generateJSONSpain() {
		JSONObject jsonObj = new JSONObjectImpl();

		jsonObj.put("ip", "81.47.192.13");
		jsonObj.put("country_code", "ES");
		jsonObj.put("country_name", "Spain");
		jsonObj.put("region_code", "29");
		jsonObj.put("region_name", "Madrid");
		jsonObj.put("city", "Madrid");
		jsonObj.put("zipcode", "");
		jsonObj.put("latitude", 40.4086);
		jsonObj.put("longitude", -3.6922);
		jsonObj.put("metro_code", "");
		jsonObj.put("area_code", "");

		return jsonObj;
	}

	private static final String _SPAIN_IP = "81.47.192.13";

	private static final String _US_IP = "173.194.41.248";

	@Mock
	private AnonymousUser _anonymousUser;

	private IpGeocodeRule _ipGeocodeRule;

	@Mock
	private RuleInstance _ruleInstance;

	@Mock
	private User _user;

}