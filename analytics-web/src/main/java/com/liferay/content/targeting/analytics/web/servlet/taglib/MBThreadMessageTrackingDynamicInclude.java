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

import com.liferay.message.boards.kernel.model.MBMessage;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = DynamicInclude.class)
public class MBThreadMessageTrackingDynamicInclude
	extends TrackingDynamicInclude {

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response,
			String key)
		throws IOException {

		MBMessage message = (MBMessage)request.getAttribute(
			"edit_message.jsp-message");

		if (message != null) {
			try {
				doInclude(
					response, "view", MBMessage.class.getName(),
					message.getPrimaryKey(), MBMessage.class.getName(),
					new long[] {message.getPrimaryKey()});
			}
			catch (Exception e) {
				_log.error("Unable to include analytics tracking JS", e);
			}
		}
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(
			"com.liferay.message.boards.web#/message_boards/" +
				"view_thread_message.jsp#post");
	}

	private static final Log _log = LogFactoryUtil.getLog(
		MBThreadMessageTrackingDynamicInclude.class);

}