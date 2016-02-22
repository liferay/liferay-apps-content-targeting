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

package com.liferay.content.targeting.analytics.web.servlet.taglib;

import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.PrintWriter;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Pavel Savinov
 */
public abstract class TrackingDynamicInclude extends BaseDynamicInclude {

	protected void doInclude(
			HttpServletResponse response, String eventName, String className,
			long classPK, String referrerClassName, long[] referrerClassPKs)
		throws Exception {

		StringBundler stringBundler = new StringBundler(13);

		stringBundler.append("<script>");
		stringBundler.append("Liferay.Analytics.track('");
		stringBundler.append(eventName);
		stringBundler.append("', { className: '");
		stringBundler.append(className);
		stringBundler.append("', classPK: '");
		stringBundler.append(classPK);
		stringBundler.append("', referrers: [{");
		stringBundler.append("referrerClassName: '");
		stringBundler.append(referrerClassName);
		stringBundler.append("', referrerClassPKs: '");
		stringBundler.append(
			Arrays.deepToString(ArrayUtil.toArray(referrerClassPKs)));
		stringBundler.append("'}]});</script>");

		PrintWriter printWriter = response.getWriter();

		printWriter.println(stringBundler.toString());
	}

}