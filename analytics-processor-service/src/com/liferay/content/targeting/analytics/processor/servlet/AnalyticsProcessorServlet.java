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
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

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
			long imageId = ParamUtil.getLong(request, "imageId");

			String redirect = ParamUtil.getString(request, "redirect");

			if (imageId > 0) {
				trackEvent(request, response, "view", "");

				serveImage(request, response);
			}
			else if (!Validator.isBlank(redirect)) {
				trackEvent(request, response, "click", redirect);

				response.sendRedirect(redirect);
			}
			else {
				processEvents(request, response);
			}
		}
		catch (Exception e) {
			_log.error(e, e);

			PortalUtil.sendError(
				HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e, request,
				response);
		}
	}

	@Reference
	public void setAnonymousUserLocalService(
		AnonymousUserLocalService anonymousUserLocalService) {

		_anonymousUserLocalService = anonymousUserLocalService;
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

		while (keys.hasNext()) {
			String key = keys.next();

			if (key.equals("referrers")) {
				JSONArray referrersJSONArray = jsonObject.getJSONArray(key);

				message.put("referrers", getReferrersMap(referrersJSONArray));
			}
			else {
				message.put(key, jsonObject.getString(key));
			}
		}
	}

	protected Map<String, long[]> getReferrersMap(
		JSONArray referrersJSONArray) {

		Map<String, long[]> referrersMap = new HashMap<String, long[]>();

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

		long anonymousUserId = contextJSONObject.getLong("anonymousUserId", 0);
		long userId = contextJSONObject.getLong("userId", 0);

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

		for (int i = 0; i < eventsJSONArray.length(); ++i) {
			Message message = new Message();

			JSONObject eventJSONObject = eventsJSONArray.getJSONObject(i);

			message.put("event", eventJSONObject.getString("event", "view"));
			message.put("timestamp", eventJSONObject.getString("timestamp"));

			copyJSONObjectData(
				message, eventJSONObject.getJSONObject("properties"));

			copyJSONObjectData(message, contextJSONObject);

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
		catch (IOException e) {
			_log.error(e);
		}
	}

	protected void trackEvent(
			HttpServletRequest request, HttpServletResponse response,
			String event, String url) {

		long companyId = PortalUtil.getCompanyId(request);

		long anonymousUserId = ParamUtil.getLong(request, "anonymousUserId");
		String className = ParamUtil.getString(request, "className");
		long classPK = ParamUtil.getLong(request, "classPK");
		long userId = ParamUtil.getLong(request, "userId");
		String email = ParamUtil.getString(request, "email");

		String elementId = ParamUtil.getString(request, "elementId");

		if (Validator.isNotNull(email)) {
			try {
				User user = UserLocalServiceUtil.getUserByEmailAddress(
					companyId, email);

				userId = user.getUserId();

				if (userId > 0) {
					anonymousUserId =
						_anonymousUserLocalService.fetchAnonymousUserByUserId(
							userId).getAnonymousUserId();
				}
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(e, e);
				}
			}
		}

		Message message = new Message();

		message.put("clientIP", request.getRemoteAddr());
		message.put("userAgent", request.getHeader(HttpHeaders.USER_AGENT));

		message.put("additionalInfo", url);
		message.put("anonymousUserId", anonymousUserId);
		message.put("className", className);
		message.put("classPK", classPK);
		message.put("userId", userId);
		message.put("event", event);
		message.put("elementId", elementId);
		message.put("layoutURL", url);

		MessageBusUtil.sendMessage("liferay/analytics", message);
	}

	private static Log _log = LogFactoryUtil.getLog(
		AnalyticsProcessorServlet.class);

	private AnonymousUserLocalService _anonymousUserLocalService;
	private AnonymousUsersManager _anonymousUsersManager;

}