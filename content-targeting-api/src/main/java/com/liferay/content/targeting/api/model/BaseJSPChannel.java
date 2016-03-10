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

package com.liferay.content.targeting.api.model;

import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.servlet.BufferCacheServletResponse;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.util.ThemeUtil;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author PavelSavinov
 */
public abstract class BaseJSPChannel extends BaseChannel {

	@Override
	public String getFormHTML(
		ChannelInstance channelInstance, Map<String, Object> context,
		Map<String, String> values) {

		String content = StringPool.BLANK;

		try {
			populateContext(channelInstance, context, values);

			HttpServletRequest request = (HttpServletRequest)context.get(
				"request");

			HttpServletResponse response = (HttpServletResponse)context.get(
				"response");

			Theme theme = (Theme)context.get(WebKeys.THEME);

			BufferCacheServletResponse bufferResponse =
				new BufferCacheServletResponse(response);

			request.setAttribute("displayContext", context);

			ThemeUtil.includeJSP(
				_servletContext, request, bufferResponse, getFormTemplatePath(),
				theme);

			content = bufferResponse.getString();
		}
		catch (Exception e) {
			_log.error(
				"Error while processing channel form template " +
					getFormTemplatePath(),
				e);
		}

		return content;
	}

	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	@Override
	protected String getFormTemplatePath() {
		return _FORM_TEMPLATE_PATH;
	}

	private static final String _FORM_TEMPLATE_PATH =
		"/templates/ct_channel.jsp";

	private static final Log _log = LogFactoryUtil.getLog(BaseJSPChannel.class);

	private ServletContext _servletContext;

}