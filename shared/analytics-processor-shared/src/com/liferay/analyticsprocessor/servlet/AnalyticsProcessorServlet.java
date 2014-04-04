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

package com.liferay.analyticsprocessor.servlet;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.anonymoususers.util.AnonymousUsersManager;
import com.liferay.osgi.util.ServiceTrackerUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;

import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Eduardo Garcia
 */
public class AnalyticsProcessorServlet extends HttpServlet {

	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		try {
			Bundle bundle = FrameworkUtil.getBundle(getClass());

			if (_anonymousUsersManager == null) {
				_initAnonymousUserManager(bundle.getBundleContext());
			}

			if (_messageBus == null) {
				_initMessageBus(bundle.getBundleContext());
			}

			processEvents(request, response);
		}
		catch (Exception e) {
			_log.error(e, e);

			PortalUtil.sendError(
				HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e, request,
				response);
		}
	}

	protected void processEvents(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String json = ParamUtil.getString(request, "events", "[]");

		JSONArray eventsJSONArray = JSONFactoryUtil.createJSONArray(json);

		if (eventsJSONArray.length() == 0) {
			return;
		}

		AnonymousUser anonymousUser = _anonymousUsersManager.getAnonymousUser(
			request, response);

		for (int i = 0; i < eventsJSONArray.length(); ++i) {
			Message message = new Message();

			message.put("anonymousUserId", anonymousUser.getAnonymousUserId());

			JSONObject eventJSONObject = eventsJSONArray.getJSONObject(i);

			message.put("event", eventJSONObject.getString("event", "view"));
			message.put("timestamp", eventJSONObject.getString("timestamp"));

			JSONObject propertiesJSONObject = eventJSONObject.getJSONObject(
				"properties");

			Iterator<String> keys = propertiesJSONObject.keys();

			while (keys.hasNext() ) {
				String key = keys.next();

				message.put(key, propertiesJSONObject.getString(key));
			}

			MessageBusUtil.sendMessage("liferay/analytics", message);
		}
	}

	private void _initAnonymousUserManager(BundleContext bundleContext) {
		_anonymousUsersManager = ServiceTrackerUtil.getService(
			AnonymousUsersManager.class, bundleContext);
	}

	private void _initMessageBus(BundleContext bundleContext) {
		_messageBus = ServiceTrackerUtil.getService(
			MessageBus.class, bundleContext);
	}

	private static Log _log = LogFactoryUtil.getLog(
		AnalyticsProcessorServlet.class);

	private AnonymousUsersManager _anonymousUsersManager;
	private MessageBus _messageBus;

}