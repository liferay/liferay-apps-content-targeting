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

package com.liferay.content.targeting.analytics.processor.servlet;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.util.AnonymousUsersManager;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;

import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(
	property = {
		"servletName=Analytics Processor", "urlPattern=/track"
	},
	service = Servlet.class)
public class AnalyticsProcessorServlet extends HttpServlet {

	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		try {
			processEvents(request, response);
		}
		catch (Exception e) {
			_log.error(e, e);

			PortalUtil.sendError(
				HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e, request,
				response);
		}
	}

	@Reference
	public void setAnonymousUserManager(
		AnonymousUsersManager anonymousUsersManager) {

		_anonymousUsersManager = anonymousUsersManager;
	}

	// Needed only for http service in 6.2

	@Reference (target ="(Web-ContextPath=/o/analytics-processor)")
	public void setServletContext(ServletContext servletContext) {
	}

	protected void copyJSONObjectData(Message message, JSONObject jsonObject) {
		Iterator<String> keys = jsonObject.keys();

		while (keys.hasNext() ) {
			String key = keys.next();

			message.put(key, jsonObject.getString(key));
		}
	}

	protected void processEvents(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String themeDisplayDataJSON = ParamUtil.getString(
			request, "themeDisplayData");

		if (Validator.isNull(themeDisplayDataJSON)) {
			return;
		}

		JSONObject themeDisplayDataJSONObject =
			JSONFactoryUtil.createJSONObject(themeDisplayDataJSON);

		String eventsJSON = ParamUtil.getString(request, "events", "[]");

		JSONArray eventsJSONArray = JSONFactoryUtil.createJSONArray(eventsJSON);

		if (eventsJSONArray.length() == 0) {
			return;
		}

		AnonymousUser anonymousUser = _anonymousUsersManager.getAnonymousUser(
			request, response);

		for (int i = 0; i < eventsJSONArray.length(); ++i) {
			Message message = new Message();

			message.put("clientIP", request.getRemoteAddr());
			message.put("userAgent", request.getHeader(HttpHeaders.USER_AGENT));

			copyJSONObjectData(message, themeDisplayDataJSONObject);

			message.put("anonymousUserId", anonymousUser.getAnonymousUserId());

			JSONObject eventJSONObject = eventsJSONArray.getJSONObject(i);

			message.put("event", eventJSONObject.getString("event", "view"));
			message.put("timestamp", eventJSONObject.getString("timestamp"));

			copyJSONObjectData(
				message, eventJSONObject.getJSONObject("properties"));

			MessageBusUtil.sendMessage("liferay/analytics", message);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		AnalyticsProcessorServlet.class);

	private AnonymousUsersManager _anonymousUsersManager;

}