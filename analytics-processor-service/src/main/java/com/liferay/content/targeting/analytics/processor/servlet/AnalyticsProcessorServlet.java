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
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.anonymous.users.util.AnonymousUsersManager;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.HttpMethods;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.awt.Color;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

import javax.servlet.Servlet;
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
	immediate = true,
	property = {
		"osgi.http.whiteboard.context.select=analytics-processor",
		"osgi.http.whiteboard.servlet.name=Analytics Processor Servlet",
		"osgi.http.whiteboard.servlet.pattern=/track"
	},
	service = Servlet.class
)
public class AnalyticsProcessorServlet extends HttpServlet {

	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		String method = GetterUtil.getString(request.getMethod());

		if (StringUtil.equalsIgnoreCase(method, HttpMethods.GET)) {
			String imageId = ParamUtil.getString(request, "imageId");

			if (Validator.isNotNull(imageId)) {
				try {
					processEvent(request, response);
				}
				catch (Exception e) {
					_log.error("Tracking image failed", e);
				}
				finally {
					serveImage(request, response);
				}
			}
			else {
				try {
					processEvent(request, response);
				}
				catch (Exception e) {
					_log.error("Tracking url failed", e);
				}
				finally {
					String redirect = ParamUtil.getString(request, "redirect");

					if (Validator.isNotNull(redirect)) {
						response.sendRedirect(redirect);
					}
				}
			}
		}
		else {
			try {
				processEvents(request, response);
			}
			catch (Exception e) {
				_log.error("Tracking events failed", e);

				PortalUtil.sendError(
					HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e, request,
					response);
			}
		}
	}

	@Reference(unbind = "-")
	public void setAnonymousUserLocalService(
		AnonymousUserLocalService anonymousUserLocalService) {

		_anonymousUserLocalService = anonymousUserLocalService;
	}

	@Reference(unbind = "-")
	public void setAnonymousUserManager(
		AnonymousUsersManager anonymousUsersManager) {

		_anonymousUsersManager = anonymousUsersManager;
	}

	protected void processEvent(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String event = ParamUtil.getString(request, "event");

		if (Validator.isNull(event)) {
			throw new IllegalArgumentException();
		}

		long companyId = PortalUtil.getCompanyId(request);

		if (companyId == 0) {
			throw new IllegalArgumentException();
		}

		String additionalInfo = ParamUtil.getString(request, "additionalInfo");
		String className = ParamUtil.getString(request, "className");
		long classPK = ParamUtil.getLong(request, "classPK");
		String elementId = ParamUtil.getString(request, "elementId");
		String referrerClassName = ParamUtil.getString(
			request, "referrerClassName");
		long[] referrerClassPKs = ParamUtil.getLongValues(
			request, "referrerClassPKs");
		long requestAnonymousUserId = ParamUtil.getLong(
			request, "anonymousUserId");
		long userId = ParamUtil.getLong(request, "userId");

		long anonymousUserId = _getAnonymousUserId(
			request, response, requestAnonymousUserId, userId);

		Message message = new Message();

		message.put("additionalInfo", additionalInfo);
		message.put("anonymousUserId", anonymousUserId);
		message.put("className", className);
		message.put("classPK", classPK);
		message.put("clientIP", request.getRemoteAddr());
		message.put("companyId", companyId);
		message.put("elementId", elementId);
		message.put("event", event);

		Map<String, long[]> referrers = new HashMap<>();

		referrers.put(referrerClassName, referrerClassPKs);

		message.put("referrers", referrers);
		message.put("userAgent", request.getHeader(HttpHeaders.USER_AGENT));
		message.put("userId", userId);

		MessageBusUtil.sendMessage("liferay/analytics", message);
	}

	protected void processEvents(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String eventsJSON = ParamUtil.getString(request, "events", "[]");

		JSONArray eventsJSONArray = JSONFactoryUtil.createJSONArray(eventsJSON);

		if (eventsJSONArray.length() == 0) {
			throw new IllegalArgumentException();
		}

		String contextJSON = ParamUtil.getString(request, "context");

		if (Validator.isNull(contextJSON) || contextJSON.isEmpty()) {
			throw new IllegalArgumentException();
		}

		JSONObject contextJSONObject = JSONFactoryUtil.createJSONObject(
			contextJSON);

		long companyId = contextJSONObject.getLong("companyId", 0);

		if (companyId == 0) {
			throw new IllegalArgumentException();
		}

		long requestAnonymousUserId = contextJSONObject.getLong(
			"anonymousUserId", 0);
		long userId = contextJSONObject.getLong("userId", 0);

		long anonymousUserId = _getAnonymousUserId(
			request, response, requestAnonymousUserId, userId);

		for (int i = 0; i < eventsJSONArray.length(); ++i) {
			Message message = new Message();

			JSONObject eventJSONObject = eventsJSONArray.getJSONObject(i);

			message.put("event", eventJSONObject.getString("event", "view"));
			message.put("timestamp", eventJSONObject.getString("timestamp"));

			_copyJSONObjectData(
				message, eventJSONObject.getJSONObject("properties"));

			_copyJSONObjectData(message, contextJSONObject);

			message.put("anonymousUserId", anonymousUserId);
			message.put("companyId", companyId);
			message.put("clientIP", request.getRemoteAddr());
			message.put("userAgent", request.getHeader(HttpHeaders.USER_AGENT));
			message.put("userId", userId);

			MessageBusUtil.sendMessage("liferay/analytics", message);
		}

		response.setContentType(ContentTypes.APPLICATION_JSON);
		response.setStatus(HttpServletResponse.SC_OK);

		JSONObject responseJSONObject = JSONFactoryUtil.createJSONObject();

		responseJSONObject.put("anonymousUserId", anonymousUserId);

		ServletResponseUtil.write(response, responseJSONObject.toString());
	}

	protected void serveImage(
		HttpServletRequest request, HttpServletResponse response) {

		BufferedImage singlePixelImage = new BufferedImage(
			1, 1, BufferedImage.TYPE_4BYTE_ABGR);

		Color transparent = new Color(0, 0, 0, 0);

		singlePixelImage.setRGB(0, 0, transparent.getRGB());

		File file = new File("pixel.png");

		try {
			ImageIO.write(singlePixelImage, "png", file);

			ServletResponseUtil.sendFile(
				request, response, file.getName(), new FileInputStream(file),
				file.length(), "image/png");
		}
		catch (IOException ioe) {
			_log.error(ioe);
		}
	}

	private void _copyJSONObjectData(Message message, JSONObject jsonObject) {
		Iterator<String> keys = jsonObject.keys();

		while (keys.hasNext()) {
			String key = keys.next();

			if (key.equals("referrers")) {
				JSONArray referrersJSONArray = jsonObject.getJSONArray(key);

				message.put("referrers", _getReferrersMap(referrersJSONArray));
			}
			else {
				message.put(key, jsonObject.getString(key));
			}
		}
	}

	private long _getAnonymousUserId(
			HttpServletRequest request, HttpServletResponse response,
			long anonymousUserId, long userId)
		throws Exception {

		if ((anonymousUserId == 0) && (userId > 0)) {
			AnonymousUser anonymousUser =
				_anonymousUserLocalService.fetchAnonymousUserByUserId(userId);

			if (anonymousUser != null) {
				anonymousUserId = anonymousUser.getAnonymousUserId();
			}
		}

		if (anonymousUserId == 0) {
			AnonymousUser anonymousUser =
				_anonymousUsersManager.getAnonymousUser(request, response);

			anonymousUserId = anonymousUser.getAnonymousUserId();
		}

		return anonymousUserId;
	}

	private Map<String, long[]> _getReferrersMap(JSONArray referrersJSONArray) {
		Map<String, long[]> referrersMap = new HashMap<>();

		if (referrersJSONArray == null) {
			return referrersMap;
		}

		for (int i = 0; i < referrersJSONArray.length(); ++i) {
			JSONObject referrerJSONObject = referrersJSONArray.getJSONObject(i);

			String referrerClassName = referrerJSONObject.getString(
				"referrerClassName");

			String[] values = StringUtil.split(
				referrerJSONObject.getString(("referrerClassPKs")));

			long[] referrerClassPKs = GetterUtil.getLongValues(values);

			referrersMap.put(referrerClassName, referrerClassPKs);
		}

		return referrersMap;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AnalyticsProcessorServlet.class);

	private AnonymousUserLocalService _anonymousUserLocalService;
	private AnonymousUsersManager _anonymousUsersManager;

}