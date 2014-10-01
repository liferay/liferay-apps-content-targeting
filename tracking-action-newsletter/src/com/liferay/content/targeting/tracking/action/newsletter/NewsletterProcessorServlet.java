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
package com.liferay.content.targeting.tracking.action.newsletter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Julio Camarero
 */
@Component(
	property = {
		"servletName=Newsletter Processor", "urlPattern=/track"
	},
	service = Servlet.class)
public class NewsletterProcessorServlet extends HttpServlet {

	@Override
	public void service(
		HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		trackInformation(request, response, "view", "");

		serveImage(request, response);
	}

	@Reference(target ="(Web-ContextPath=/o/tracking-action-newsletter)")
	public void setServletContext(ServletContext servletContext) {
	}

	protected void serveImage(HttpServletRequest request, HttpServletResponse response) {
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

	protected void trackInformation(
		HttpServletRequest request, HttpServletResponse response, String event,
		String url) {

		long companyId = PortalUtil.getCompanyId(request);

		long anonymousUserId = ParamUtil.getLong(request, "anonymousUserId");
		long userId = ParamUtil.getLong(request, "userId");
		String email = ParamUtil.getString(request, "email");

		String elementId = ParamUtil.getString(request, "elementId");

		if (Validator.isNotNull(email)) {
			try {
				User user = UserLocalServiceUtil.getUserByEmailAddress(
					companyId, email);

				userId = user.getUserId();
			}
			catch (Exception e) {
				_log.debug(e);
			}
		}

		Message message = new Message();

		message.put("clientIP", request.getRemoteAddr());
		message.put("userAgent", request.getHeader(HttpHeaders.USER_AGENT));

		message.put("anonymousUserId", anonymousUserId);
		message.put("userId", userId);
		message.put("event", event);
		message.put("elementId", elementId);
		message.put("layoutURL", url);

		MessageBusUtil.sendMessage("liferay/analytics", message);
	}

	private static Log _log = LogFactoryUtil.getLog(
		NewsletterProcessorServlet.class);
}
