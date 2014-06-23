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

package com.liferay.contenttargeting.rules.ipgeocode;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.geolocation.model.Geolocation;
import com.liferay.geolocation.service.GeolocationLocalServiceUtil;
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
import com.liferay.portal.service.ServiceContext;

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
	GeolocationLocalServiceUtil.class, JSONFactoryUtil.class,
	RegionServiceUtil.class
})
@RunWith(PowerMockRunner.class)
public class IpGeocodeRuleTest extends PowerMockito {

	@Before
	public void setUp() throws Exception {
		_ipGeocodeRule = new IpGeocodeRule();

		mockStatic(CountryServiceUtil.class);
		mockStatic(GeolocationLocalServiceUtil.class);
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
			_geolocation.getCountryCode()
		).thenReturn(
			"ES"
		);

		when(
			_geolocation.getRegionName()
		).thenReturn(
			"Madrid"
		);

		when(
			GeolocationLocalServiceUtil.geoLocate(
				Mockito.anyLong(), Mockito.anyString(), Mockito.anyLong(),
				Mockito.anyString(), (ServiceContext)Mockito.anyObject())
		).thenReturn(
			_geolocation
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
			_geolocation.getCountryCode()
		).thenReturn(
			"ES"
		);

		when(
			GeolocationLocalServiceUtil.geoLocate(
				Mockito.anyLong(), Mockito.anyString(), Mockito.anyLong(),
				Mockito.anyString(), (ServiceContext)Mockito.anyObject())
		).thenReturn(
			_geolocation
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
			_geolocation.getCountryCode()
		).thenReturn(
			"US"
		);

		when(
			GeolocationLocalServiceUtil.geoLocate(
				Mockito.anyLong(), Mockito.anyString(), Mockito.anyLong(),
				Mockito.anyString(), (ServiceContext)Mockito.anyObject())
		).thenReturn(
			_geolocation
		);

		Assert.assertTrue(
			_ipGeocodeRule.evaluate(_ruleInstance, _anonymousUser));
	}

	@Mock
	private AnonymousUser _anonymousUser;

	@Mock
	private Geolocation _geolocation;

	private IpGeocodeRule _ipGeocodeRule;

	@Mock
	private RuleInstance _ruleInstance;

	@Mock
	private User _user;

}