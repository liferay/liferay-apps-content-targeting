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

package com.liferay.anonymoususers.util;

import aQute.bnd.annotation.component.Component;

import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eudaldo Alonso
 */
@Component
public class DefaultAnonymousUsersCookieManagerImpl
	implements AnonymousUsersCookieManager {

	public static final String ANONYMOUS_USER_ID = "ANONYMOUS_USER_ID";

	@Override
	public void addCookie(
		HttpServletRequest request, HttpServletResponse response,
		long anonymousUserId) {

		Cookie userIdCookie = new Cookie(
			ANONYMOUS_USER_ID, String.valueOf(anonymousUserId));

		userIdCookie.setPath(StringPool.SLASH);
		userIdCookie.setMaxAge(CookieKeys.MAX_AGE);

		CookieKeys.addCookie(request, response, userIdCookie);
	}

	@Override
	public long getAnonymousUserId(HttpServletRequest request) {
		return GetterUtil.getLong(
			CookieKeys.getCookie(request, ANONYMOUS_USER_ID));
	}

}