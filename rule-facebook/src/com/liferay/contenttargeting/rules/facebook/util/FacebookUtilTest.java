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

package com.liferay.contenttargeting.rules.facebook.util;

import com.liferay.portal.kernel.util.StringUtil;

import com.restfb.DefaultJsonMapper;
import com.restfb.types.User;

import java.io.InputStream;

/**
 * @author Eudaldo Alonso
 */
public class FacebookUtilTest {

	public static User getFacebookUser(Class<?> clazz) throws Exception {
		DefaultJsonMapper defaultJsonMapper = new DefaultJsonMapper();

		String user = readText("facebook-user.json", clazz);

		return defaultJsonMapper.toJavaObject(user, User.class);
	}

	public static String readText(String fileName, Class<?> clazz)
		throws Exception {

		ClassLoader classLoader = clazz.getClassLoader();

		InputStream inputStream = classLoader.getResourceAsStream(
			"com/liferay/contenttargeting/rules/facebook/dependencies/" +
				fileName);

		return StringUtil.read(inputStream);
	}

}