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

package com.liferay.contenttargeting.rules.ipgeocode.util;

import com.liferay.contenttargeting.rules.ipgeocode.model.IPInfo;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;

/**
 * @author Eudaldo Alonso
 */
public class IPGeocodeUtil {

	public static IPInfo getIPInfo(String ipAddress) {
		Http.Options options = new Http.Options();

		options.setLocation("http://freegeoip.net/json/" + ipAddress);

		try {
			String text = HttpUtil.URLtoString(options);

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(text);

			return new IPInfo(jsonObject);
		}
		catch (Exception e) {
		}

		return null;
	}

}