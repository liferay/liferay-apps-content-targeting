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

import com.liferay.content.targeting.model.UserSegment;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Pavel Savinov
 */
public abstract class TrackingDynamicInclude extends BaseDynamicInclude {

	protected void doInclude(
			HttpServletRequest request, HttpServletResponse response,
			String eventName, String className, long classPK)
		throws Exception {

		String referrerClassName = UserSegment.class.getName();
		long[] referrerClassPKs = GetterUtil.getLongValues(
			request.getAttribute("userSegmentIds"));

		doInclude(
			request, response, eventName, className, classPK, referrerClassName,
			referrerClassPKs);
	}

	protected void doInclude(
			HttpServletRequest request, HttpServletResponse response,
			String eventName, String className, long classPK,
			String referrerClassName, long[] referrerClassPKs)
		throws Exception {

		boolean trackingEnabled = false;

		Layout layout = (Layout)request.getAttribute(WebKeys.LAYOUT);

		Group analyticsGroup = layout.getGroup();

		if (!analyticsGroup.isStagingGroup() &&
			!analyticsGroup.isLayoutSetPrototype() &&
			!analyticsGroup.isLayoutPrototype() &&
			!layout.isTypeControlPanel() &&
			!GetterUtil.getBoolean(
				request.getAttribute("isSimulatedUserSegments"))) {

			trackingEnabled = true;
		}

		if (!trackingEnabled) {
			return;
		}

		referrerClassName = ParamUtil.getString(
			request, "analyticsReferrerClassName", referrerClassName);
		referrerClassPKs = ParamUtil.getLongValues(
			request, "analyticsReferrerClassPKs", referrerClassPKs);

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
			ArrayUtil.toString(ArrayUtil.toArray(referrerClassPKs), "", ","));
		stringBundler.append("'}]});</script>");

		PrintWriter printWriter = response.getWriter();

		printWriter.println(stringBundler.toString());
	}

}