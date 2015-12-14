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

package com.liferay.content.targeting.anonymous.users.util;

import com.liferay.portal.util.WebKeys;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Pavel Savinov
 */
@RunWith(PowerMockRunner.class)
public class DefaultAnonymousUsersManagerImplTest extends PowerMockito {

	@Before
	public void setUp() {
		_anonymousUsersManager = new DefaultAnonymousUsersManagerImpl();
	}

	@Test
	public void testGetAddressFromRequestWithoutProxy() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();

		request.setAttribute(WebKeys.COMPANY_ID, "1");
		request.setAttribute(WebKeys.USER_ID, "1");
		request.setRemoteAddr("127.0.0.1");

		String userIp = _anonymousUsersManager.getAddressFromRequest(request);

		Assert.assertEquals("127.0.0.1", userIp);
	}

	@Test
	public void testGetAddressFromRequestWithProxyRFC7239() throws Exception {

		// single proxy

		MockHttpServletRequest requestSingle = new MockHttpServletRequest();

		requestSingle.setAttribute(WebKeys.COMPANY_ID, "1");
		requestSingle.setAttribute(WebKeys.USER_ID, "1");
		requestSingle.setRemoteAddr("127.0.0.1");
		requestSingle.addHeader("Forwarded", "for=127.0.0.2");

		String singleIp = _anonymousUsersManager.getAddressFromRequest(
			requestSingle);

		Assert.assertEquals("127.0.0.2", singleIp);

		// proxy chain

		MockHttpServletRequest requestChain = new MockHttpServletRequest();

		requestChain.setAttribute(WebKeys.COMPANY_ID, "1");
		requestChain.setAttribute(WebKeys.USER_ID, "1");
		requestChain.setRemoteAddr("127.0.0.1");
		requestChain.addHeader(
			"Forwarded", "for=127.0.0.3, for=proxy1, for=proxy2");

		String userChainIp = _anonymousUsersManager.getAddressFromRequest(
			requestChain);

		Assert.assertEquals("127.0.0.3", userChainIp);

		// IPv6 test

		MockHttpServletRequest requestV6 = new MockHttpServletRequest();

		requestV6.setAttribute(WebKeys.COMPANY_ID, "1");
		requestV6.setAttribute(WebKeys.USER_ID, "1");
		requestV6.setRemoteAddr("127.0.0.1");
		requestV6.addHeader("Forwarded", "for=\"[2001:db8:cafe::17]\"");

		String userV6ip = _anonymousUsersManager.getAddressFromRequest(
			requestV6);

		Assert.assertEquals("2001:db8:cafe::17", userV6ip);
	}

	@Test
	public void testGetAddressFromRequestWithProxyXForwarded()
		throws Exception {

		// single proxy

		MockHttpServletRequest requestSingle = new MockHttpServletRequest();

		requestSingle.setAttribute(WebKeys.COMPANY_ID, "1");
		requestSingle.setAttribute(WebKeys.USER_ID, "1");
		requestSingle.setRemoteAddr("127.0.0.1");
		requestSingle.addHeader("X-Forwarded-For", "127.0.0.2");

		String userSingleIp = _anonymousUsersManager.getAddressFromRequest(
			requestSingle);

		Assert.assertEquals("127.0.0.2", userSingleIp);

		// proxy chain

		MockHttpServletRequest requestChain = new MockHttpServletRequest();

		requestChain.setAttribute(WebKeys.COMPANY_ID, "1");
		requestChain.setAttribute(WebKeys.USER_ID, "1");
		requestChain.setRemoteAddr("127.0.0.1");
		requestChain.addHeader("X-Forwarded-For", "127.0.0.3, proxy1, proxy2");

		String userChainIp = _anonymousUsersManager.getAddressFromRequest(
			requestChain);

		Assert.assertEquals("127.0.0.3", userChainIp);
	}

	private DefaultAnonymousUsersManagerImpl _anonymousUsersManager;

}